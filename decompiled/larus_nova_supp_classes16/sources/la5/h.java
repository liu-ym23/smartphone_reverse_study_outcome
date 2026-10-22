package la5;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ i a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (hu5.a.d(this.a.f) == true) goto L7;
        this.a.o();
        this.a.m();
        return true;
    L7:
        return true;
    }

    public h(i r1) {
        this.a = r1;
    }
}
