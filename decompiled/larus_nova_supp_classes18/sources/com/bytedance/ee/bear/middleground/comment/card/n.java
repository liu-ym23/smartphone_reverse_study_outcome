package com.bytedance.ee.bear.middleground.comment.card;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ FloatCardComment a;

    public n(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.a.k();
        return true;
    }
}
