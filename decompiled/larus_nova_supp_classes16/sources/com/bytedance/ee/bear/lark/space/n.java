package com.bytedance.ee.bear.lark.space;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ View a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).C().c("space");
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }

    public n(View r1) {
        this.a = r1;
    }
}
