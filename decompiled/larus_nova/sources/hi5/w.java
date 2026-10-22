package hi5;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes18.dex */
public final class w implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f485338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f485339b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.f485338a.getWidth() > 0) goto L5;
        return true;
    L5:
        if (this.f485338a.getHeight() > 0) goto L8;
        return true;
    L8:
        if (this.f485338a.getViewTreeObserver().isAlive() == false) goto L10;
        this.f485338a.getViewTreeObserver().removeOnPreDrawListener(this);
    L10:
        tt5.a.h("LinkShareUtils", "[mask issue fix] fixSafeTipsDialogFrame apply, framePadding=" + x.d(this.f485339b) + ", rootSize=" + this.f485338a.getWidth() + "x" + this.f485338a.getHeight());
        this.f485339b.setPadding(0, 0, 0, 0);
        this.f485339b.requestLayout();
        return false;
    }

    public w(View r100, View r101) {
        this.f485338a = r100;
        this.f485339b = r101;
    }
}
