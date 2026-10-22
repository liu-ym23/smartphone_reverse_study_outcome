package com.ss.android.lark.imageocr.select;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements ViewTreeObserver.OnScrollChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f426551a;

    public l(e r100) {
        this.f426551a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        e r100 = this.f426551a;
        if (r100.f426512p == false) goto L5;
        return;
    L5:
        if (r100.f426513q == true) goto L17;
        r100.f426512p = true;
        e.d r101 = r100.f426499c;
        if (r101 == null) goto L9;
        PopupWindow r102 = r101.f426536a;
        PopupWindowLancet.handleDismissBeforeOrigin(r102);
        r102.dismiss();
    L9:
        e.c r103 = this.f426551a.f426497a;
        if (r103 == null) goto L12;
        PopupWindow r104 = r103.f426524b;
        PopupWindowLancet.handleDismissBeforeOrigin(r104);
        r104.dismiss();
    L12:
        e.c r105 = this.f426551a.f426498b;
        if (r105 == null) goto L18;
        PopupWindow r106 = r105.f426524b;
        PopupWindowLancet.handleDismissBeforeOrigin(r106);
        r106.dismiss();
        return;
    L18:
        return;
    }
}
