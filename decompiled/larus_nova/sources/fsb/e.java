package fsb;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f478728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f.a f478729b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        f.a.a(this.f478729b);
        String r100 = this.f478728a;
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.equals(f.b().f478734a) == false) goto L10;
        f.b().e();
        return true;
    L10:
        return true;
    }

    public e(f.a r100, String r101) {
        this.f478729b = r100;
        this.f478728a = r101;
    }
}
