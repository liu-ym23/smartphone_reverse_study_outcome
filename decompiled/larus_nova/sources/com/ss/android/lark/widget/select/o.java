package com.ss.android.lark.widget.select;

import android.text.Selection;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public final class o implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f448479a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
    }

    public o(p r100) {
        this.f448479a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        p r101 = this.f448479a;
        r101.f448482c.getViewTreeObserver().removeOnScrollChangedListener(r101.f448493n);
        r101.f448488i = false;
        r101.f448489j.getClass();
        Spannable r102 = r101.f448483d;
        if (r102 == null) goto L8;
        Selection.removeSelection(r102);
        BackgroundColorSpan r103 = r101.f448484e;
        if (r103 == null) goto L7;
        r101.f448483d.removeSpan(r103);
    L7:
        r101.f448482c.invalidate();
    L8:
        r101.f();
    }
}
