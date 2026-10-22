package com.bytedance.ee.bear.document.selection;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes16.dex */
public final class j implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f221653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f221654b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        tt5.a.b("SelectionHackHelper", "HandleView onGlobalLayout");
        this.f221653a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.f221654b.c();
    }

    public j(k r100, View r101) {
        this.f221654b = r100;
        this.f221653a = r101;
    }
}
