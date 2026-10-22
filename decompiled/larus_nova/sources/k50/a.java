package k50;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements GLSurfaceView.Renderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n50.a f501799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f501800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.core.gl.primitive.a f501801c;

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r100) {
        Intrinsics.checkNotNullParameter(r100, "unused");
        f r101 = this.f501800b;
        if (r101.f501814e == false) goto L5;
        r101.f501813d = System.currentTimeMillis();
    L5:
        GLES20.glClear(16640);
        n50.a r102 = this.f501799a;
        if (r102 == null) goto L8;
        r102.c(this.f501800b);
    L8:
        this.f501800b.f501810a.f501809b.getClass();
        this.f501800b.f501810a.f501808a.b();
    }

    public a(Context r100, com.bytedance.android.live.core.gl.primitive.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "backgroundColor");
        f r102 = new f(r100);
        Intrinsics.checkNotNullParameter(r102, "rendererParams");
        Intrinsics.checkNotNullParameter(r101, "backgroundColor");
        this.f501800b = r102;
        this.f501801c = r101;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "unused");
        Intrinsics.checkNotNullParameter(r101, "config");
        com.bytedance.android.live.core.gl.primitive.a r102 = this.f501801c;
        GLES20.glClearColor(r102.f64829a, r102.f64830b, r102.f64831c, r102.f64832d);
        GLES20.glDisable(2929);
        GLES20.glFrontFace(2305);
        GLES20.glCullFace(1029);
        f r103 = this.f501800b;
        r103.f501811b++;
        n50.a r104 = this.f501799a;
        if (r104 == null) goto L15;
        Intrinsics.checkNotNullParameter(r103, "rendererParams");
        ArrayList<m50.b> r105 = r104.f517987a;
        monitor-enter(r105);
        int r106 = r104.f517987a.size();     // Catch: Throwable -> L12
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L9;
        r104.f517987a.get(r107).b(r103);     // Catch: Throwable -> L12
        r107 = r107 + 1;     // Catch: Throwable -> L12
        goto L7
    L9:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r105);
    L12:
        th = move-exception;
        throw th;
    L15:
        f r109 = this.f501800b;
        com.bytedance.android.live.core.gl.core.shader.b r110 = r109.f501810a.f501809b;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r109, "rendererParams");
        Iterator<com.bytedance.android.live.core.gl.core.shader.a> r111 = r110.f64825a.values().iterator();
    L17:
        if (r111.hasNext() == false) goto L19;
        r111.next().a(r109);
        goto L17
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "unused");
        this.f501800b.getClass();
        GLES20.glViewport(0, 0, r101, r102);
        n50.a r103 = this.f501799a;
        if (r103 == null) goto L6;
        r103.d(this.f501800b, r101, r102);
        return;
    }
}
