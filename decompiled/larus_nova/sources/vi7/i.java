package vi7;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f555345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f555346b;

    @Override // vi7.d
    public final void I7(int r100) {
        this.f555345a.I7(r100);
    }

    @Override // vi7.b
    public final boolean a() {
        return this.f555345a.a();
    }

    @Override // vi7.b
    public final void b() {
        this.f555345a.b();
    }

    @Override // vi7.b
    public final boolean c() {
        return this.f555345a.c();
    }

    @Override // vi7.b
    public final void f() {
        this.f555345a.f();
    }

    @Override // vi7.b
    public final void g() {
        this.f555345a.g();
    }

    @Override // vi7.b
    public final ViewGroup getView() {
        return this.f555345a.getView();
    }

    @Override // vi7.b
    public final void j() {
        this.f555345a.j();
    }

    @Override // vi7.b
    public final void setOnCloseClickListener(View.OnClickListener r100) {
        this.f555345a.setOnCloseClickListener(r100);
    }

    @Override // vi7.b
    public final void setOnRetryClickListener(View.OnClickListener r100) {
        this.f555345a.setOnRetryClickListener(r100);
    }

    @Override // vi7.b
    public final void showLoadingView() {
        this.f555345a.showLoadingView();
        this.f555346b.invoke();
    }

    public i(d r100, Function0<Unit> r101) {
        this.f555345a = r100;
        this.f555346b = r101;
    }
}
