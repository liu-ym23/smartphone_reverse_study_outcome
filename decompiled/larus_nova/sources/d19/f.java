package d19;

import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes27.dex */
public final class f implements GLSurfaceView.Renderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f466452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f466453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f466454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f466455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f466456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f466457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f466458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f466459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f466460i;

    public f() {
        this.f466452a = 2;
        this.f466454c = 1.0f;
        this.f466457f = 1.0f;
        this.f466458g = 1.0f;
        this.f466460i = System.nanoTime();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 r110) {
        float r100 = ((System.nanoTime() - this.f466460i) / 1.0E9f) % 10000.0f;
        c r101 = this.f466459h;
        if (r101 == null) goto L6;
        r101.b(r100, this.f466453b, this.f466454c, this.f466455d, this.f466456e, this.f466457f, this.f466458g);
        return;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 r100, EGLConfig r101) {
        if (this.f466452a < 3) goto L5;
        c r102 = new e();
    L6:
        r102.a();
        this.f466459h = r102;
        return;
    L5:
        r102 = new d();
        goto L6
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 r100, int r101, int r102) {
        c r103 = this.f466459h;
        if (r103 == null) goto L5;
        r103.onSurfaceChanged(r101, r102);
    L5:
        this.f466457f = r101;
        this.f466458g = r102;
    }
}
