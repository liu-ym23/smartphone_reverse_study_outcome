package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ForceCloseDeferrableSurface {
    private final boolean mHasConfigureSurfaceToSecondarySessionFailQuirk;
    private final boolean mHasPreviewOrientationIncorrectQuirk;
    private final boolean mHasTextureViewIsClosedQuirk;

    public boolean shouldForceClose() {
        if (this.mHasTextureViewIsClosedQuirk == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mHasPreviewOrientationIncorrectQuirk == true) goto L10;
        if (this.mHasConfigureSurfaceToSecondarySessionFailQuirk == true) goto L10;
        return false;
    }

    public void onSessionEnd(List<DeferrableSurface> r2) {
        if (shouldForceClose() == false) goto L12;
        if (r2 == null) goto L13;
        Iterator<DeferrableSurface> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r3.next().close();
        goto L7
    L9:
        Logger.d("ForceCloseDeferrableSurface", "deferrableSurface closed");
        return;
    L13:
        return;
    }

    public ForceCloseDeferrableSurface(Quirks r2, Quirks r3) {
        this.mHasTextureViewIsClosedQuirk = r3.contains(TextureViewIsClosedQuirk.class);
        this.mHasPreviewOrientationIncorrectQuirk = r2.contains(PreviewOrientationIncorrectQuirk.class);
        this.mHasConfigureSurfaceToSecondarySessionFailQuirk = r2.contains(ConfigureSurfaceToSecondarySessionFailQuirk.class);
    }
}
