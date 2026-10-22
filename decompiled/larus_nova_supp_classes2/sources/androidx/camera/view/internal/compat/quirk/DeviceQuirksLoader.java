package androidx.camera.view.internal.compat.quirk;

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
        if (r3.shouldEnableQuirk(SurfaceViewStretchedQuirk.class, SurfaceViewStretchedQuirk.load()) == false) goto L6;
        r0.add(new SurfaceViewStretchedQuirk());
    L6:
        if (r3.shouldEnableQuirk(SurfaceViewNotCroppedByParentQuirk.class, SurfaceViewNotCroppedByParentQuirk.load()) == false) goto L8;
        r0.add(new SurfaceViewNotCroppedByParentQuirk());
    L8:
        return r0;
    }
}
