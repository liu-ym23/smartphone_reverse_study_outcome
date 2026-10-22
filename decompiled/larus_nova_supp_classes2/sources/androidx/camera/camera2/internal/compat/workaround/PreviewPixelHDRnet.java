package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.core.impl.SessionConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class PreviewPixelHDRnet {
    public static final Rational ASPECT_RATIO_16_9 = null;

    static {
        ASPECT_RATIO_16_9 = new Rational(16, 9);
    }

    private PreviewPixelHDRnet() {
    }

    private static boolean isAspectRatioMatch(Size r2, Rational r3) {
        return r3.equals(new Rational(r2.getWidth(), r2.getHeight()));
    }

    public static void setHDRnet(Size r2, SessionConfig.Builder r3) {
        if (((PreviewPixelHDRnetQuirk) DeviceQuirks.get(PreviewPixelHDRnetQuirk.class)) != null) goto L6;
        return;
    L6:
        if (isAspectRatioMatch(r2, ASPECT_RATIO_16_9) == false) goto L8;
        return;
    L8:
        Camera2ImplConfig.Builder r4 = new Camera2ImplConfig.Builder();
        r4.setCaptureRequestOption(CaptureRequest.TONEMAP_MODE, 2);
        r3.addImplementationOptions(r4.build());
    }
}
