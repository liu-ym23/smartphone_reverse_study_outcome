package e0b;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import c0b.k;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f470657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f470658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g0b.a f470659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f470660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f470661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f470662f;

    @Override // e0b.f
    public final void a() {
        this.f470658b.a();
    }

    @Override // e0b.f
    public final void confirm() {
        this.f470658b.confirm();
    }

    public Context getContext() {
        return this.f470657a;
    }

    @Override // e0b.f
    public final void b(String r100) {
        this.f470658b.b(r100);
    }

    @Override // e0b.f
    public final void d(float r100) {
        this.f470658b.d(r100);
    }

    @Override // e0b.f
    public final void e(k.b r100) {
        this.f470658b.e(r100);
    }

    public c(Context r100, g0b.a r101) {
        this.f470657a = r100;
        d r102 = new d(this);
        this.f470660d = r102;
        this.f470661e = new a(this);
        this.f470662f = new b(this);
        this.f470658b = r102;
        this.f470659c = r101;
    }

    @Override // e0b.f
    public final void g(SurfaceHolder r100, float r101) {
        this.f470658b.g(r100, r101);
    }

    @Override // e0b.f
    public final void h(SurfaceHolder r100, float r101) {
        this.f470658b.h(r100, r101);
    }

    @Override // e0b.f
    public final void i(SurfaceHolder r100, float r101) {
        this.f470658b.i(r100, r101);
    }

    @Override // e0b.f
    public final void f(Context r100, Surface r101, float r102) {
        this.f470658b.f(r100, r101, r102);
    }

    @Override // e0b.f
    public final void j(Context r100, boolean r101, long r102) {
        this.f470658b.j(r100, r101, r102);
    }

    @Override // e0b.f
    public final void c(float r100, float r101, int r102, int r110, com.ss.android.lark.cameraview.e.d r111) {
        this.f470658b.c(r100, r101, r102, r110, r111);
    }
}
