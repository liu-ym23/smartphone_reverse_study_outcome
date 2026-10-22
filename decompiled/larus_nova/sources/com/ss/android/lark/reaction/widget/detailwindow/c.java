package com.ss.android.lark.reaction.widget.detailwindow;

import android.view.ViewTreeObserver;
import n2c.p;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f439233a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int r100 = this.f439233a.f439205b.getHeight();
        if (r100 != 0) goto L5;
        return;
    L5:
        this.f439233a.f439204a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f439233a.f439204a.setMaxScrollY(r100);
        this.f439233a.f439204a.setCloseUpAlgorithm(new a.f());
        a.b(0, Double.valueOf(((double) r100) * a.f439203v.doubleValue()).intValue(), new p(this));
    }

    public c(a r100) {
        this.f439233a = r100;
    }
}
