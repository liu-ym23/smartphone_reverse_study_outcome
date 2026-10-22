package androidx.camera.core.imagecapture;

import android.util.Size;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CaptureBundles;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.core.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ImagePipeline {
    static final ExifRotationAvailability EXIF_ROTATION_AVAILABILITY = null;
    static final byte JPEG_QUALITY_MAX_QUALITY = 100;
    static final byte JPEG_QUALITY_MIN_LATENCY = 95;
    private static int sNextRequestId;
    private final CaptureConfig mCaptureConfig;
    private final CaptureNode mCaptureNode;
    private final CaptureNode.In mPipelineIn;
    private final ProcessingNode mProcessingNode;
    private final ImageCaptureConfig mUseCaseConfig;

    static {
        EXIF_ROTATION_AVAILABILITY = new ExifRotationAvailability();
    }

    private CaptureBundle createCaptureBundle() {
        CaptureBundle r0 = this.mUseCaseConfig.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
        Objects.requireNonNull(r0);
        return r0;
    }

    private int getOutputFormat() {
        ImageCaptureConfig r0 = this.mUseCaseConfig;
        Config.Option<Integer> r1 = ImageCaptureConfig.OPTION_BUFFER_FORMAT;
        r0.getClass();
        Integer r2 = (Integer) ReadableConfig.CC.$default$retrieveOption(r0, r1, null);
        if (r2 != null) goto L5;
        ImageCaptureConfig r3 = this.mUseCaseConfig;
        Config.Option<Integer> r4 = ImageInputConfig.OPTION_INPUT_FORMAT;
        r3.getClass();
        Integer r5 = (Integer) ReadableConfig.CC.$default$retrieveOption(r3, r4, null);
        if (r5 != null) goto L9;
        return 256;
    L9:
        if (r5.intValue() != 4101) goto L13;
        return 4101;
    L13:
        return 256;
    L5:
        return r2.intValue();
    }

    private boolean shouldEnablePostview() {
        if (this.mPipelineIn.getPostviewSurface() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean expectsMetadata() {
        return this.mCaptureNode.getSafeCloseImageReaderProxy().getImageReaderProxy() instanceof MetadataImageReader;
    }

    public Size getPostviewSize() {
        return this.mPipelineIn.getPostviewSize();
    }

    public void close() {
        Threads.checkMainThread();
        this.mCaptureNode.release();
        this.mProcessingNode.release();
    }

    public int getCapacity() {
        Threads.checkMainThread();
        return this.mCaptureNode.getCapacity();
    }

    public CaptureNode getCaptureNode() {
        return this.mCaptureNode;
    }

    public ProcessingNode getProcessingNode() {
        return this.mProcessingNode;
    }

    public SessionConfig.Builder createSessionConfigBuilder(Size r2) {
        SessionConfig.Builder r3 = SessionConfig.Builder.createFrom(this.mUseCaseConfig, r2);
        r3.addNonRepeatingSurface(this.mPipelineIn.getSurface());
        if (this.mPipelineIn.getPostviewSurface() == null) goto L5;
        r3.setPostviewSurface(this.mPipelineIn.getPostviewSurface());
    L5:
        return r3;
    }

    public int getCameraRequestJpegQuality(TakePictureRequest r4) {
        if (r4.getOnDiskCallback() == null) goto L5;
        boolean r0 = true;
    L6:
        boolean r1 = TransformUtils.hasCropping(r4.getCropRect(), this.mPipelineIn.getSize());
        if (r0 == false) goto L16;
        if (r1 == false) goto L16;
        if (r4.getCaptureMode() != 0) goto L13;
        return 100;
    L13:
        return 95;
    L16:
        return r4.getJpegQuality();
    L5:
        r0 = false;
        goto L6
    }

    public void notifyCaptureError(TakePictureManager.CaptureError r2) {
        Threads.checkMainThread();
        this.mPipelineIn.getErrorEdge().accept(r2);
    }

    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener r2) {
        Threads.checkMainThread();
        this.mCaptureNode.setOnImageCloseListener(r2);
    }

    public void submitProcessingRequest(ProcessingRequest r2) {
        Threads.checkMainThread();
        this.mPipelineIn.getRequestEdge().accept(r2);
    }

    public ImagePipeline(ImageCaptureConfig r8, Size r9) {
        this(r8, r9, null, false, null, 35);
    }

    public Pair<CameraRequest, ProcessingRequest> createRequests(TakePictureRequest r9, TakePictureCallback r10, ListenableFuture<Void> r11) {
        Threads.checkMainThread();
        CaptureBundle r2 = createCaptureBundle();
        int r1 = sNextRequestId;
        sNextRequestId = r1 + 1;
        return new Pair(createCameraRequest(r1, r2, r9, r10), createProcessingRequest(r1, r2, r9, r10, r11));
    }

    public ImagePipeline(ImageCaptureConfig r8, Size r9, CameraEffect r10, boolean r11) {
        this(r8, r9, r10, r11, null, 35);
    }

    private CameraRequest createCameraRequest(int r7, CaptureBundle r8, TakePictureRequest r9, TakePictureCallback r10) {
        ArrayList r0 = new ArrayList();
        String r1 = String.valueOf(r8.hashCode());
        List<CaptureStage> r11 = r8.getCaptureStages();
        Objects.requireNonNull(r11);
        Iterator<CaptureStage> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L13;
        CaptureStage r2 = r12.next();
        CaptureConfig.Builder r3 = new CaptureConfig.Builder();
        r3.setTemplateType(this.mCaptureConfig.getTemplateType());
        r3.addImplementationOptions(this.mCaptureConfig.getImplementationOptions());
        r3.addAllCameraCaptureCallbacks(r9.getSessionConfigCameraCaptureCallbacks());
        r3.addSurface(this.mPipelineIn.getSurface());
        r3.setPostviewEnabled(shouldEnablePostview());
        if (ImageUtil.isJpegFormats(this.mPipelineIn.getInputFormat()) == false) goto L11;
        if (EXIF_ROTATION_AVAILABILITY.isRotationOptionSupported() == false) goto L10;
        r3.addImplementationOption(CaptureConfig.OPTION_ROTATION, Integer.valueOf(r9.getRotationDegrees()));
    L10:
        r3.addImplementationOption(CaptureConfig.OPTION_JPEG_QUALITY, Integer.valueOf(getCameraRequestJpegQuality(r9)));
    L11:
        r3.addImplementationOptions(r2.getCaptureConfig().getImplementationOptions());
        r3.addTag(r1, Integer.valueOf(r2.getId()));
        r3.setId(r7);
        r3.addCameraCaptureCallback(this.mPipelineIn.getCameraCaptureCallback());
        r0.add(r3.build());
        goto L4
    L13:
        return new CameraRequest(r0, r10);
    }

    private ProcessingRequest createProcessingRequest(int r12, CaptureBundle r13, TakePictureRequest r14, TakePictureCallback r15, ListenableFuture<Void> r16) {
        return new ProcessingRequest(r13, r14.getOutputFileOptions(), r14.getCropRect(), r14.getRotationDegrees(), r14.getJpegQuality(), r14.getSensorToBufferTransform(), r15, r16, r12);
    }

    public ImagePipeline(ImageCaptureConfig r14, Size r15, CameraEffect r16, boolean r17, Size r18, int r19) {
        Threads.checkMainThread();
        this.mUseCaseConfig = r14;
        this.mCaptureConfig = CaptureConfig.Builder.createFrom(r14).build();
        this.mCaptureNode = new CaptureNode();
        Executor r4 = r14.getIoExecutor(CameraXExecutors.ioExecutor());
        Objects.requireNonNull(r4);
        Executor r5 = r4;
        if (r16 == null) goto L5;
        InternalImageProcessor r6 = new InternalImageProcessor(r16);
    L6:
        ProcessingNode r3 = new ProcessingNode(r5, r6);
        this.mProcessingNode = r3;
        this.mPipelineIn = CaptureNode.In.of(r15, r14.getInputFormat(), getOutputFormat(), r17, r14.getImageReaderProxyProvider(), r18, r19);
        r3.transform2(this.mCaptureNode.transform2(this.mPipelineIn));
        return;
    L5:
        r6 = null;
        goto L6
    }
}
