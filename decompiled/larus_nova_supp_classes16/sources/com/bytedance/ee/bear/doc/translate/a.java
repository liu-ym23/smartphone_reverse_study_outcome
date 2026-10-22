package com.bytedance.ee.bear.doc.translate;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a extends GestureDetector.SimpleOnGestureListener {
    public final int a;
    public float b;

    public a(Context r1) {
        this.a = ViewConfiguration.get(r1).getScaledPagingTouchSlop();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r2) {
        this.b = r2.getY();
        return super.onDown(r2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r4, MotionEvent r5, float r6, float r7) {
        if (r7 != 0.0f) goto L5;
        this.b = r5.getY();
    L5:
        float r0 = this.b - r5.getY();
        int r1 = this.a;
        if (r0 >= (-r1)) goto L11;
        TranslatePlugin.c r2 = (TranslatePlugin.c) this;
        if (TranslatePlugin.access$800(r2.c).getWebView().isNestedScrollingEnabled() == false) goto L16;
        TranslatePlugin.access$900(r2.c);
    L16:
        return super.onScroll(r4, r5, r6, r7);
    L11:
        if (r0 <= r1) goto L16;
        TranslatePlugin.c r3 = (TranslatePlugin.c) this;
        if (TranslatePlugin.access$1000(r3.c).getWebView().isNestedScrollingEnabled() == false) goto L16;
        TranslatePlugin.access$000(r3.c);
        goto L16
    }
}
