package kn4;

import android.view.View;
import com.bytedance.ee.bear.widget.AtFinderView;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.b f504213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ee.bear.atfinder.c f504214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtFinderView f504215c;

    @Override // kn4.g
    public void d(View r100) {
    }

    @Override // kn4.g
    public void e(int r100) {
    }

    @Override // kn4.g
    public void h(View r100) {
    }

    @Override // kn4.g
    public void i(int r100) {
    }

    @Override // kn4.g
    public abstract /* synthetic */ void update();

    public a() {
        this.f504213a = null;
    }

    @Override // kn4.g
    public final void a(Map<String, Object> r100) {
        this.f504214b.f206358k.a(r100);
    }

    @Override // kn4.g
    public final void b(g.b r100) {
        this.f504213a = r100;
    }

    @Override // kn4.g
    public final void c(boolean r100) {
        this.f504214b.f206359l = r100;
    }

    @Override // kn4.g
    public final void g(bo4.d r100) {
        this.f504214b.d(r100);
    }

    public final void k(h r100) {
        com.bytedance.ee.bear.atfinder.f r101 = r100.f504245p;
        if (r101 == null) goto L5;
        this.f504215c.setSearchDelegate(r101);
        return;
    L5:
        tt5.a.k("AbsAtWindow", "setSearchDelegate: null");
    }
}
