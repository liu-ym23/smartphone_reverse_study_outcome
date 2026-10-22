package androidx.camera.core.internal.compat.workaround;

import android.media.MediaCodec;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class SurfaceSorter {
    private static final int PRIORITY_MEDIA_CODEC_SURFACE = 2;
    private static final int PRIORITY_OTHERS = 1;
    private static final int PRIORITY_PREVIEW_SURFACE = 0;
    private final boolean mHasQuirk;

    public static /* synthetic */ int a(SurfaceSorter r0, SessionConfig.OutputConfig r1, SessionConfig.OutputConfig r2) {
        return r0.lambda$sort$0(r1, r2);
    }

    public SurfaceSorter() {
        if (DeviceQuirks.get(SurfaceOrderQuirk.class) == null) goto L5;
        boolean r0 = true;
    L6:
        this.mHasQuirk = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private int getSurfacePriority(DeferrableSurface r3) {
        if (r3.getContainerClass() != MediaCodec.class) goto L7;
        return 2;
    L7:
        if (r3.getContainerClass() != Preview.class) goto L10;
        return 0;
    L10:
        return 1;
    }

    public void sort(List<SessionConfig.OutputConfig> r2) {
        if (this.mHasQuirk == true) goto L5;
        return;
    L5:
        Collections.sort(r2, new a(this));
    }

    private /* synthetic */ int lambda$sort$0(SessionConfig.OutputConfig r1, SessionConfig.OutputConfig r2) {
        return getSurfacePriority(r1.getSurface()) - getSurfacePriority(r2.getSurface());
    }
}
