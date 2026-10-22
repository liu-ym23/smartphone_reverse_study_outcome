package yo2;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends d<e> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a f568662x;

    public interface a {
        void a(View r100, e r101);
    }

    @Override // yo2.d
    public final void f() {
    }

    public e() {
    }

    public e(Context r100) {
        this.f568641c = r100;
    }

    @Override // yo2.d
    public final void g(View r100, d r101) {
        e r102 = (e) r101;
        a r103 = this.f568662x;
        if (r103 == null) goto L6;
        r103.a(r100, r102);
        return;
    }
}
