package com.bytedance.ee.bear.lark.space;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes16.dex */
public final class n implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f227578a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).C().c("space");
        this.f227578a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }

    public n(View r100) {
        this.f227578a = r100;
    }
}
