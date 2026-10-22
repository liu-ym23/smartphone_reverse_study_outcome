package com.bytedance.ee.bear.lark;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class w implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ViewTreeObserver a;
    public final /* synthetic */ DocTabFragment b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        tt5.a.h("DocTabFragment", "onPreDraw rootView.getViewTreeObserver():" + this.a);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).C().c("space");
        if (this.a.isAlive() == false) goto L7;
        this.a.removeOnPreDrawListener(this);
        this.b.B = null;
        return true;
    L7:
        return true;
    }

    public w(DocTabFragment r1, ViewTreeObserver r2) {
        this.b = r1;
        this.a = r2;
    }
}
