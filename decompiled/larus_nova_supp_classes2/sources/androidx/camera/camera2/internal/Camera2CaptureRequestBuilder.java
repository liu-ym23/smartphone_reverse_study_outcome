package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.workaround.TemplateParamsOverride;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class Camera2CaptureRequestBuilder {
    private static final String TAG = "Camera2CaptureRequestBuilder";

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static CaptureRequest.Builder createReprocessCaptureRequest(CameraDevice r0, TotalCaptureResult r1) throws CameraAccessException {
            return r0.createReprocessCaptureRequest(r1);
        }
    }

    private Camera2CaptureRequestBuilder() {
    }

    private static void applyAeFpsRange(CaptureConfig r2, CaptureRequest.Builder r3) {
        if (r2.getExpectedFrameRateRange().equals(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED) == true) goto L6;
        r3.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, r2.getExpectedFrameRateRange());
        return;
    }

    private static void applyImplementationOptionToCaptureBuilder(CaptureRequest.Builder r4, Config r5) {
        CaptureRequestOptions r6 = CaptureRequestOptions.Builder.from(r5).build();
        Iterator r0 = r6.listOptions().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Config.Option r1 = (Config.Option) r0.next();
        CaptureRequest.Key r2 = (CaptureRequest.Key) r1.getToken();
        r4.set(r2, r6.retrieveOption(r1));     // Catch: IllegalArgumentException -> L8
    L8:
        Logger.e(TAG, "CaptureRequest.Key is not supported: " + r2);
        goto L4
    }

    public static void applyVideoStabilization(CaptureConfig r3, CaptureRequest.Builder r4) {
        if (r3.getPreviewStabilizationMode() != 1) goto L5;
    L13:
        r4.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        return;
    L5:
        if (r3.getVideoStabilizationMode() == 1) goto L13;
        if (r3.getPreviewStabilizationMode() != 2) goto L11;
        r4.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 2);
        return;
    L11:
        if (r3.getVideoStabilizationMode() != 2) goto L16;
        r4.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
        return;
    }

    private static List<Surface> getConfiguredSurfaces(List<DeferrableSurface> r2, Map<DeferrableSurface, Surface> r3) {
        ArrayList r0 = new ArrayList();
        Iterator<DeferrableSurface> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Surface r1 = r3.get(r4.next());
        if (r1 == null) goto L9;
        r0.add(r1);
        goto L4
    L9:
        throw new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
    L10:
        return r0;
    }

    private static void applyTemplateParamsOverrideWorkaround(CaptureRequest.Builder r1, int r2, TemplateParamsOverride r3) {
        Iterator<Map.Entry<CaptureRequest.Key<?>, Object>> r4 = r3.getOverrideParams(r2).entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<CaptureRequest.Key<?>, Object> r5 = r4.next();
        r1.set(r5.getKey(), r5.getValue());
        goto L4
    }

    public static CaptureRequest buildWithoutTarget(CaptureConfig r2, CameraDevice r3, TemplateParamsOverride r4) throws CameraAccessException {
        if (r3 != null) goto L5;
        return null;
    L5:
        Logger.d(TAG, "template type = " + r2.getTemplateType());
        CaptureRequest.Builder r5 = r3.createCaptureRequest(r2.getTemplateType());
        applyTemplateParamsOverrideWorkaround(r5, r2.getTemplateType(), r4);
        applyImplementationOptionToCaptureBuilder(r5, r2.getImplementationOptions());
        return r5.build();
    }

    public static CaptureRequest build(CaptureConfig r5, CameraDevice r6, Map<DeferrableSurface, Surface> r7, boolean r8, TemplateParamsOverride r9) throws CameraAccessException {
        if (r6 != null) goto L5;
        return null;
    L5:
        List<Surface> r10 = getConfiguredSurfaces(r5.getSurfaces(), r7);
        if (r10.isEmpty() == false) goto L8;
        return null;
    L8:
        CameraCaptureResult r0 = r5.getCameraCaptureResult();
        if (Build.VERSION.SDK_INT >= 23) goto L11;
    L16:
        Logger.d(TAG, "createCaptureRequest");
        if (r5.getTemplateType() != 5) goto L22;
        if (r8 == false) goto L20;
        int r11 = 1;
    L21:
        CaptureRequest.Builder r12 = r6.createCaptureRequest(r11);
    L23:
        applyTemplateParamsOverrideWorkaround(r12, r5.getTemplateType(), r9);
        applyAeFpsRange(r5, r12);
        applyVideoStabilization(r5, r12);
        Config r13 = r5.getImplementationOptions();
        Config.Option<Integer> r14 = CaptureConfig.OPTION_ROTATION;
        if (r13.containsOption(r14) == false) goto L26;
        r12.set(CaptureRequest.JPEG_ORIENTATION, (Integer) r5.getImplementationOptions().retrieveOption(r14));
    L26:
        Config r15 = r5.getImplementationOptions();
        Config.Option<Integer> r16 = CaptureConfig.OPTION_JPEG_QUALITY;
        if (r15.containsOption(r16) == false) goto L29;
        r12.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) r5.getImplementationOptions().retrieveOption(r16)).byteValue()));
    L29:
        applyImplementationOptionToCaptureBuilder(r12, r5.getImplementationOptions());
        Iterator<Surface> r17 = r10.iterator();
    L31:
        if (r17.hasNext() == false) goto L33;
        r12.addTarget(r17.next());
        goto L31
    L33:
        r12.setTag(r5.getTagBundle());
        return r12.build();
    L20:
        r11 = 2;
        goto L21
    L22:
        r12 = r6.createCaptureRequest(r5.getTemplateType());
        goto L23
    L11:
        if (r5.getTemplateType() != 5) goto L16;
        if (r0 == null) goto L16;
        if ((r0.getCaptureResult() instanceof TotalCaptureResult) == false) goto L16;
        Logger.d(TAG, "createReprocessCaptureRequest");
        r12 = Api23Impl.createReprocessCaptureRequest(r6, (TotalCaptureResult) r0.getCaptureResult());
        goto L23
    }
}
