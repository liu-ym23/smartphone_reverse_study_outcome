package k50;

import android.opengl.GLSurfaceView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {
    public static final n50.a a(GLSurfaceView r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getScene");
        Object r101 = r100.getTag(R.id.tag_common_scene);
        if ((r101 instanceof n50.a) == true) goto L6;
        r101 = null;
    L6:
        return (n50.a) r101;
    }

    public static final void b(GLSurfaceView r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setFpsStabilizer");
        Intrinsics.checkNotNullParameter(r101, "fpsStabilizer");
        r100.setTag(R.id.tag_fps_stabilizer, r101);
    }

    public static final void c(GLSurfaceView r100, j50.a r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setScene");
        Intrinsics.checkNotNullParameter(r101, "scene");
        r100.setTag(R.id.tag_common_scene, r101);
    }
}
