package androidx.camera.core.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.QuirkSettings;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    public static List<Quirk> loadQuirks(QuirkSettings r3) {
        ArrayList r0 = new ArrayList();
        if (r3.shouldEnableQuirk(ImageCaptureRotationOptionQuirk.class, ImageCaptureRotationOptionQuirk.load()) == false) goto L6;
        r0.add(new ImageCaptureRotationOptionQuirk());
    L6:
        if (r3.shouldEnableQuirk(SurfaceOrderQuirk.class, SurfaceOrderQuirk.load()) == false) goto L9;
        r0.add(new SurfaceOrderQuirk());
    L9:
        if (r3.shouldEnableQuirk(CaptureFailedRetryQuirk.class, CaptureFailedRetryQuirk.load()) == false) goto L12;
        r0.add(new CaptureFailedRetryQuirk());
    L12:
        if (r3.shouldEnableQuirk(LowMemoryQuirk.class, LowMemoryQuirk.load()) == false) goto L15;
        r0.add(new LowMemoryQuirk());
    L15:
        if (r3.shouldEnableQuirk(LargeJpegImageQuirk.class, LargeJpegImageQuirk.load()) == false) goto L18;
        r0.add(new LargeJpegImageQuirk());
    L18:
        if (r3.shouldEnableQuirk(IncorrectJpegMetadataQuirk.class, IncorrectJpegMetadataQuirk.load()) == false) goto L20;
        r0.add(new IncorrectJpegMetadataQuirk());
    L20:
        return r0;
    }
}
