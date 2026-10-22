package com.bytedance.ee.bear.document.plugin.selection;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes16.dex */
public final class p implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f220945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f220946b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        tt5.a.b("SelectionHackHelper", "HandleView onGlobalLayout");
        this.f220945a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f220946b.c();
    }

    public p(q r100, View r101) {
        this.f220946b = r100;
        this.f220945a = r101;
    }
}
