package hi5;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.a.getWidth() > 0) goto L5;
        return true;
    L5:
        if (this.a.getHeight() > 0) goto L8;
        return true;
    L8:
        if (this.a.getViewTreeObserver().isAlive() == false) goto L10;
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    L10:
        tt5.a.h("LinkShareUtils", "[mask issue fix] fixSafeTipsDialogFrame apply, framePadding=" + x.d(this.b) + ", rootSize=" + this.a.getWidth() + "x" + this.a.getHeight());
        this.b.setPadding(0, 0, 0, 0);
        this.b.requestLayout();
        return false;
    }

    public w(View r1, View r2) {
        this.a = r1;
        this.b = r2;
    }
}
