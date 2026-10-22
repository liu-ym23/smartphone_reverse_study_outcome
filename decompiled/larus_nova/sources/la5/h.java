package la5;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f508181a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (hu5.a.d(this.f508181a.f508187f) == true) goto L7;
        this.f508181a.o();
        this.f508181a.m();
        return true;
    L7:
        return true;
    }

    public h(i r100) {
        this.f508181a = r100;
    }
}
