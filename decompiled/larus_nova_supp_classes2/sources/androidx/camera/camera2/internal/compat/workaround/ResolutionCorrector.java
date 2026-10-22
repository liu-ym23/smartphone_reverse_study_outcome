package androidx.camera.camera2.internal.compat.workaround;

import android.util.Size;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ResolutionCorrector {
    private final ExtraCroppingQuirk mExtraCroppingQuirk;

    public ResolutionCorrector() {
        this((ExtraCroppingQuirk) DeviceQuirks.get(ExtraCroppingQuirk.class));
    }

    public ResolutionCorrector(ExtraCroppingQuirk r1) {
        this.mExtraCroppingQuirk = r1;
    }

    public List<Size> insertOrPrioritize(SurfaceConfig.ConfigType r4, List<Size> r5) {
        ExtraCroppingQuirk r0 = this.mExtraCroppingQuirk;
        if (r0 != null) goto L5;
        return r5;
    L5:
        Size r6 = r0.getVerifiedResolution(r4);
        if (r6 != null) goto L8;
        return r5;
    L8:
        ArrayList r1 = new ArrayList();
        r1.add(r6);
        Iterator<Size> r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        Size r2 = r7.next();
        if (r2.equals(r6) == true) goto L10;
        r1.add(r2);
        goto L10
    L14:
        return r1;
    }
}
