package com.bytedance.ee.bear.integrator.wiki;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f227144a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).C().c("wiki");
        this.f227144a.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    }

    public a(View r100) {
        this.f227144a = r100;
    }
}
