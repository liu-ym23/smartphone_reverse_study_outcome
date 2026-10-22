package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Size;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ZslRingBuffer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class ZslControlImpl implements ZslControl {
    static final int MAX_IMAGES = 9;
    static final int RING_BUFFER_CAPACITY = 3;
    private static final String TAG = "ZslControlImpl";
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    final ZslRingBuffer mImageRingBuffer;
    private boolean mIsPrivateReprocessingSupported;
    private boolean mIsZslDisabledByFlashMode;
    private boolean mIsZslDisabledByUseCaseConfig;
    private CameraCaptureCallback mMetadataMatchingCaptureCallback;
    private DeferrableSurface mReprocessingImageDeferrableSurface;
    SafeCloseImageReaderProxy mReprocessingImageReader;
    ImageWriter mReprocessingImageWriter;
    private boolean mShouldZslDisabledByQuirks;

    public static /* synthetic */ void a(ZslControlImpl r0, ImageReaderProxy r1) {
        r0.lambda$addZslConfig$1(r1);
    }

    public static /* synthetic */ void b(ImageProxy r0) {
        lambda$new$0(r0);
    }

    private void cleanup() {
        ZslRingBuffer r0 = this.mImageRingBuffer;
    L4:
        if (r0.isEmpty() == true) goto L6;
        r0.dequeue().close();
        goto L4
    L6:
        DeferrableSurface r1 = this.mReprocessingImageDeferrableSurface;
        if (r1 == null) goto L12;
        SafeCloseImageReaderProxy r2 = this.mReprocessingImageReader;
        if (r2 == null) goto L11;
        r1.getTerminationFuture().addListener(new v3(r2), CameraXExecutors.mainThreadExecutor());
        this.mReprocessingImageReader = null;
    L11:
        r1.close();
        this.mReprocessingImageDeferrableSurface = null;
    L12:
        ImageWriter r3 = this.mReprocessingImageWriter;
        if (r3 == null) goto L17;
        r3.close();
        this.mReprocessingImageWriter = null;
        return;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public ImageProxy dequeueImageFromBuffer() {
        return this.mImageRingBuffer.dequeue();
    L4:
        Logger.e(TAG, "dequeueImageFromBuffer no such element");
        return null;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean isZslDisabledByFlashMode() {
        return this.mIsZslDisabledByFlashMode;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean isZslDisabledByUserCaseConfig() {
        return this.mIsZslDisabledByUseCaseConfig;
    }

    public ZslControlImpl(CameraCharacteristicsCompat r3) {
        boolean r0 = false;
        this.mIsZslDisabledByUseCaseConfig = false;
        this.mIsZslDisabledByFlashMode = false;
        this.mIsPrivateReprocessingSupported = false;
        this.mShouldZslDisabledByQuirks = false;
        this.mCameraCharacteristicsCompat = r3;
        this.mIsPrivateReprocessingSupported = ZslUtil.isCapabilitySupported(r3, 4);
        if (DeviceQuirks.get(ZslDisablerQuirk.class) == null) goto L5;
        r0 = true;
    L5:
        this.mShouldZslDisabledByQuirks = r0;
        this.mImageRingBuffer = new ZslRingBuffer(3, new w3());
    }

    private Map<Integer, Size> createReprocessingInputSizeMap(CameraCharacteristicsCompat r10) {
        StreamConfigurationMap r11 = (StreamConfigurationMap) r10.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: AssertionError -> L4
    L6:
        if (r11 == null) goto L18;
        if (r11.getInputFormats() == null) goto L18;
        HashMap r0 = new HashMap();
        int[] r1 = r11.getInputFormats();
        int r2 = r1.length;
        int r4 = 0;
    L11:
        if (r4 >= r2) goto L16;
        int r5 = r1[r4];
        Size[] r6 = r11.getInputSizes(r5);
        if (r6 == null) goto L15;
        Arrays.sort(r6, new CompareSizesByArea(true));
        r0.put(Integer.valueOf(r5), r6[0]);
    L15:
        r4 = r4 + 1;
        goto L11
    L16:
        return r0;
    L18:
        return new HashMap();
    L4:
        e = move-exception;
        Logger.e(TAG, "Failed to retrieve StreamConfigurationMap, error = " + e.getMessage());
        r11 = null;
        goto L6
    }

    private /* synthetic */ void lambda$addZslConfig$1(ImageReaderProxy r3) {
        ImageProxy r4 = r3.acquireLatestImage();     // Catch: IllegalStateException -> L6
        if (r4 == null) goto L11;
        this.mImageRingBuffer.enqueue(r4);     // Catch: IllegalStateException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.e(TAG, "Failed to acquire latest image IllegalStateException = " + e.getMessage());
    }

    private static /* synthetic */ void lambda$new$0(ImageProxy r0) {
        r0.close();
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void addZslConfig(SessionConfig.Builder r7) {
        cleanup();
        if (this.mIsZslDisabledByUseCaseConfig == false) goto L7;
        r7.setTemplateType(1);
        return;
    L7:
        if (this.mShouldZslDisabledByQuirks == false) goto L10;
        r7.setTemplateType(1);
        return;
    L10:
        Map<Integer, Size> r0 = createReprocessingInputSizeMap(this.mCameraCharacteristicsCompat);
        if (this.mIsPrivateReprocessingSupported == true) goto L13;
    L21:
        r7.setTemplateType(1);
        return;
    L13:
        if (r0.isEmpty() == true) goto L21;
        if (r0.containsKey(34) == false) goto L21;
        if (isJpegValidOutputForInputFormat(this.mCameraCharacteristicsCompat, 34) == false) goto L21;
        Size r1 = r0.get(34);
        MetadataImageReader r2 = new MetadataImageReader(r1.getWidth(), r1.getHeight(), 34, 9);
        this.mMetadataMatchingCaptureCallback = r2.getCameraCaptureCallback();
        this.mReprocessingImageReader = new SafeCloseImageReaderProxy(r2);
        r2.setOnImageAvailableListener(new u3(this), CameraXExecutors.ioExecutor());
        ImmediateSurface r3 = new ImmediateSurface(this.mReprocessingImageReader.getSurface(), new Size(this.mReprocessingImageReader.getWidth(), this.mReprocessingImageReader.getHeight()), 34);
        this.mReprocessingImageDeferrableSurface = r3;
        SafeCloseImageReaderProxy r4 = this.mReprocessingImageReader;
        ListenableFuture<Void> r5 = r3.getTerminationFuture();
        Objects.requireNonNull(r4);
        r5.addListener(new v3(r4), CameraXExecutors.mainThreadExecutor());
        r7.addSurface(this.mReprocessingImageDeferrableSurface);
        r7.addCameraCaptureCallback(this.mMetadataMatchingCaptureCallback);
        r7.addSessionStateCallback(new AnonymousClass1(this));
        r7.setInputConfiguration(new InputConfiguration(this.mReprocessingImageReader.getWidth(), this.mReprocessingImageReader.getHeight(), this.mReprocessingImageReader.getImageFormat()));
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean enqueueImageToImageWriter(ImageProxy r4) {
        Image r5 = r4.getImage();
        if (Build.VERSION.SDK_INT < 23) goto L12;
        ImageWriter r0 = this.mReprocessingImageWriter;
        if (r0 == null) goto L12;
        if (r5 == null) goto L12;
        ImageWriterCompat.queueInputImage(r0, r5);     // Catch: IllegalStateException -> L10
        return true;
    L10:
        e = move-exception;
        Logger.e(TAG, "enqueueImageToImageWriter throws IllegalStateException = " + e.getMessage());
    L12:
        return false;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void setZslDisabledByFlashMode(boolean r1) {
        this.mIsZslDisabledByFlashMode = r1;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void setZslDisabledByUserCaseConfig(boolean r1) {
        this.mIsZslDisabledByUseCaseConfig = r1;
    }

    private boolean isJpegValidOutputForInputFormat(CameraCharacteristicsCompat r5, int r6) {
        StreamConfigurationMap r7 = (StreamConfigurationMap) r5.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (r7 != null) goto L5;
        return false;
    L5:
        int[] r8 = r7.getValidOutputFormatsForInput(r6);
        if (r8 != null) goto L8;
        return false;
    L8:
        int r9 = r8.length;
        int r1 = 0;
    L9:
        if (r1 >= r9) goto L15;
        if (r8[r1] == 256) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }
}
