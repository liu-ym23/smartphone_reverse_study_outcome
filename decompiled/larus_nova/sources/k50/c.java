package k50;

import android.opengl.GLSurfaceView;
import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f501803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f501804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f501805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GLSurfaceView f501806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f501807e;

    public final void a() {
        this.f501804b = false;
        b();
    }

    public final void b() {
        this.f501803a.removeCallbacks(this.f501805c);
        if (this.f501804b == true) goto L6;
        this.f501803a.postDelayed(this.f501805c, (long) (1000.0f / this.f501807e));
        this.f501806d.requestRender();
        return;
    }

    public c(GLSurfaceView r100) {
        Intrinsics.checkNotNullParameter(r100, "glSurfaceView");
        this.f501806d = r100;
        this.f501807e = 60.0f;
        this.f501803a = new Handler();
        this.f501805c = new b(this);
        r100.setRenderMode(0);
    }
}
