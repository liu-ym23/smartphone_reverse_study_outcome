package com.bytedance.ee.bear.doc.translate;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f218358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f218359b;

    public a(Context r100) {
        this.f218358a = ViewConfiguration.get(r100).getScaledPagingTouchSlop();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        this.f218359b = r100.getY();
        return super.onDown(r100);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        if (r103 != 0.0f) goto L5;
        this.f218359b = r101.getY();
    L5:
        float r104 = this.f218359b - r101.getY();
        int r105 = this.f218358a;
        if (r104 >= (-r105)) goto L11;
        TranslatePlugin.c r106 = (TranslatePlugin.c) this;
        if (TranslatePlugin.access$800(r106.f218343c).getWebView().isNestedScrollingEnabled() == false) goto L16;
        TranslatePlugin.access$900(r106.f218343c);
    L16:
        return super.onScroll(r100, r101, r102, r103);
    L11:
        if (r104 <= r105) goto L16;
        TranslatePlugin.c r107 = (TranslatePlugin.c) this;
        if (TranslatePlugin.access$1000(r107.f218343c).getWebView().isNestedScrollingEnabled() == false) goto L16;
        TranslatePlugin.access$000(r107.f218343c);
        goto L16
    }
}
