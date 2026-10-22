package com.ss.android.lark.imageocr.select;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f426550a;

    public k(e r100) {
        this.f426550a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        e r100 = this.f426550a;
        if (r100.f426512p == false) goto L7;
        r100.f426512p = false;
        r100.f426502f.removeCallbacks(r100.f426516t);
        r100.f426502f.postDelayed(r100.f426516t, 100);
        return true;
    L7:
        return true;
    }
}
