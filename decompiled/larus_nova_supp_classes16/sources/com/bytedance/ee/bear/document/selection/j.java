package com.bytedance.ee.bear.document.selection;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ k b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        tt5.a.b("SelectionHackHelper", "HandleView onGlobalLayout");
        this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.b.c();
    }

    public j(k r1, View r2) {
        this.b = r1;
        this.a = r2;
    }
}
