package g21;

import android.view.SurfaceView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c extends a {
    public final String toString() {
        return "SurfaceRenderView(render=" + this.f479676b + ')';
    }

    public c(SurfaceView r100) {
        Intrinsics.checkNotNullParameter(r100, "surfaceView");
        super(r100, true);
    }

    public c(SurfaceView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "surfaceView");
        super(r100, r101);
    }
}
