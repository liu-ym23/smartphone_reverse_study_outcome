package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.core.impl.SurfaceCombination;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ExtraSupportedSurfaceCombinationsContainer {
    private final ExtraSupportedSurfaceCombinationsQuirk mQuirk;

    public ExtraSupportedSurfaceCombinationsContainer() {
        this.mQuirk = (ExtraSupportedSurfaceCombinationsQuirk) DeviceQuirks.get(ExtraSupportedSurfaceCombinationsQuirk.class);
    }

    public List<SurfaceCombination> get(String r2) {
        ExtraSupportedSurfaceCombinationsQuirk r0 = this.mQuirk;
        if (r0 != null) goto L7;
        return new ArrayList();
    L7:
        return r0.getExtraSupportedSurfaceCombinations(r2);
    }
}
