package fk;

import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f477557a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        FrameLayout r100 = this.f477557a.f477559i;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getMeasuredWidth() > 0) goto L8;
        return;
    L8:
        if (r100.getMeasuredHeight() <= 0) goto L14;
        r100.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        if (this.f477557a.i() == false) goto L15;
        r100.setAlpha(1.0f);
        r100.setTranslationY(r100.getMeasuredHeight());
        this.f477557a.l(true);
        return;
    L15:
        return;
    }

    public d(e r100) {
        this.f477557a = r100;
    }
}
