package v50;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {
    public static /* synthetic */ void b(GLSurfaceView r100, Context r101, j50.a r102) {
        a(r100, r101, r102, new com.bytedance.android.live.core.gl.primitive.a());
    }

    public static final void a(GLSurfaceView r110, Context r111, j50.a r112, com.bytedance.android.live.core.gl.primitive.a r113) {
        Intrinsics.checkNotNullParameter(r110, "$this$initSurfaceTransparent");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "scene");
        Intrinsics.checkNotNullParameter(r113, "backgroundColor");
        Intrinsics.checkNotNullParameter(r110, "$this$isInitialized");
        Object r100 = r110.getTag(R.id.is_initialized_tag);
        if ((r100 instanceof Boolean) == true) goto L5;
        r100 = null;
    L5:
        Boolean r101 = (Boolean) r100;
        if (r101 == null) goto L8;
        boolean r102 = r101.booleanValue();
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        r110.setEGLContextClientVersion(3);
        r110.setZOrderOnTop(true);
        r110.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        r110.getHolder().setFormat(1);
        k50.a r103 = new k50.a(r111, r113);
        Intrinsics.checkNotNullParameter(r112, "scene");
        r103.f501799a = r112;
        r112.f(r103.f501800b);
        r110.setRenderer(r103);
        Intrinsics.checkNotNullParameter(r110, "$this$isInitialized");
        r110.setTag(R.id.is_initialized_tag, Boolean.TRUE);
        return;
    L8:
        r102 = false;
        goto L9
    }
}
