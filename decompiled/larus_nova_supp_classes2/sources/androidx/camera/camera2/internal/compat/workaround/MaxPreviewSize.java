package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class MaxPreviewSize {
    private final ExtraCroppingQuirk mExtraCroppingQuirk;

    public MaxPreviewSize() {
        this((ExtraCroppingQuirk) DeviceQuirks.get(ExtraCroppingQuirk.class));
    }

    public MaxPreviewSize(ExtraCroppingQuirk r1) {
        this.mExtraCroppingQuirk = r1;
    }

    public Size getMaxPreviewResolution(Size r5) {
        ExtraCroppingQuirk r0 = this.mExtraCroppingQuirk;
        if (r0 != null) goto L5;
        return r5;
    L5:
        Size r1 = r0.getVerifiedResolution(SurfaceConfig.ConfigType.PRIV);
        if (r1 != null) goto L9;
        return r5;
    L9:
        if ((r1.getWidth() * r1.getHeight()) <= (r5.getWidth() * r5.getHeight())) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        return r5;
    L14:
        return r1;
    L11:
        r2 = false;
        goto L12
    }
}
