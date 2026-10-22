package androidx.camera.core.impl.utils;

import androidx.camera.core.resolutionselector.ResolutionSelector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ResolutionSelectorUtil {
    private ResolutionSelectorUtil() {
    }

    public static ResolutionSelector overrideResolutionSelectors(ResolutionSelector r1, ResolutionSelector r2) {
        if (r2 != null) goto L4;
        return r1;
    L4:
        if (r1 != null) goto L6;
        return r2;
    L6:
        ResolutionSelector.Builder r3 = ResolutionSelector.Builder.fromResolutionSelector(r1);
        if (r2.getAspectRatioStrategy() == null) goto L10;
        r3.setAspectRatioStrategy(r2.getAspectRatioStrategy());
    L10:
        if (r2.getResolutionStrategy() == null) goto L13;
        r3.setResolutionStrategy(r2.getResolutionStrategy());
    L13:
        if (r2.getResolutionFilter() == null) goto L16;
        r3.setResolutionFilter(r2.getResolutionFilter());
    L16:
        if (r2.getAllowedResolutionMode() == 0) goto L19;
        r3.setAllowedResolutionMode(r2.getAllowedResolutionMode());
    L19:
        return r3.build();
    }
}
