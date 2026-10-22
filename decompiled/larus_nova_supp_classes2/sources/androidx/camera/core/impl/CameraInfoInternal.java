package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface CameraInfoInternal extends CameraInfo {

    /* JADX INFO: renamed from: androidx.camera.core.impl.CameraInfoInternal$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static CameraInfoInternal $default$getImplementation(CameraInfoInternal r0) {
            return r0;
        }

        public static boolean $default$isCaptureProcessProgressSupported(CameraInfoInternal r0) {
            return false;
        }

        public static boolean $default$isPostviewSupported(CameraInfoInternal r0) {
            return false;
        }

        public static CameraSelector $default$getCameraSelector(final CameraInfoInternal r2) {
            return new CameraSelector.Builder().addCameraFilter(new d(r2)).addCameraFilter(new LensFacingCameraFilter(r2.getLensFacing())).build();
        }

        public static /* synthetic */ List $private$lambda$getCameraSelector$0(CameraInfoInternal r2, List r3) {
            String r4 = r2.getCameraId();
            Iterator r5 = r3.iterator();
        L4:
            if (r5.hasNext() == false) goto L10;
            CameraInfo r0 = (CameraInfo) r5.next();
            Preconditions.checkArgument(r0 instanceof CameraInfoInternal);
            if (((CameraInfoInternal) r0).getCameraId().equals(r4) == false) goto L4;
            return Collections.singletonList(r0);
        L10:
            throw new IllegalStateException("Unable to find camera with id " + r4 + " from list of available cameras.");
        }
    }

    void addSessionCaptureCallback(Executor r1, CameraCaptureCallback r2);

    Object getCameraCharacteristics();

    String getCameraId();

    Quirks getCameraQuirks();

    @Override // androidx.camera.core.CameraInfo
    CameraSelector getCameraSelector();

    EncoderProfilesProvider getEncoderProfilesProvider();

    CameraInfoInternal getImplementation();

    Object getPhysicalCameraCharacteristics(String r1);

    Set<DynamicRange> getSupportedDynamicRanges();

    List<Size> getSupportedHighResolutions(int r1);

    Set<Integer> getSupportedOutputFormats();

    List<Size> getSupportedResolutions(int r1);

    Timebase getTimebase();

    boolean isCaptureProcessProgressSupported();

    boolean isPostviewSupported();

    boolean isPreviewStabilizationSupported();

    boolean isVideoStabilizationSupported();

    void removeSessionCaptureCallback(CameraCaptureCallback r1);
}
