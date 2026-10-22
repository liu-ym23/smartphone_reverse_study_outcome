package jb0;

import android.opengl.GLSurfaceView;
import android.os.Handler;
import com.bytedance.android.live.ktv.common.canvasgl.glview.GLContinuousSurfaceAdapterView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f497978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f497979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f497980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final GLSurfaceView f497981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f497982e;

    public final void a() {
        this.f497978a.removeCallbacks(this.f497980c);
        if (this.f497979b == true) goto L6;
        this.f497978a.postDelayed(this.f497980c, (long) (1000.0f / this.f497982e));
        this.f497981d.requestRender();
        return;
    }

    public b(GLContinuousSurfaceAdapterView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "glSurfaceView");
        this.f497981d = r100;
        this.f497982e = r101;
        this.f497978a = new Handler();
        this.f497980c = new a(this);
        r100.setRenderMode(0);
    }
}
