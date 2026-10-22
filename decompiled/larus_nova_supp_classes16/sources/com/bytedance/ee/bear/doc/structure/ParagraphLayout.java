package com.bytedance.ee.bear.doc.structure;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import com.bytedance.ee.util.ui.j;
import mz4.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ParagraphLayout extends LinearLayout {
    public int a;
    public boolean b;
    public int c;
    public int d;
    public a e;

    public interface a {
    }

    public ParagraphLayout(Context r2) {
        super(r2);
        this.d = -1;
        this.c = ViewConfiguration.get(r2).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        int r0 = r6.getAction();
        if (r0 != 2) goto L8;
        if (this.b == false) goto L8;
        return true;
    L8:
        if (super.onInterceptTouchEvent(r6) == false) goto L10;
        return true;
    L10:
        int r1 = r0 & 255;
        if (r1 != 0) goto L13;
        int r2 = (int) r6.getY();
        this.b = false;
        this.a = r2;
        this.d = r6.getPointerId(0);
        a r3 = this.e;
        if (r3 == null) goto L32;
        float r7 = r6.getY();
        FloatingStructureFragment r4 = ((m) r3).a;
        r4.h = r7;
        r4.i = r4.k.getY();
        r4.j = 0;
        j.e(r4.y);
        r4.m = r4.g.computeContentHeight();
    L32:
        return this.b;
    L13:
        if (r1 == 1) goto L27;
        if (r1 != 2) goto L16;
        int r5 = this.d;
        if (r5 != (-1)) goto L21;
        tt5.a.h("ParagraphLayout", "invalid pointer");
        goto L32
    L21:
        int r8 = r6.findPointerIndex(r5);
        if (r8 != (-1)) goto L24;
        tt5.a.d("ParagraphLayout", "Invalid pointerId=" + r5 + " in onInterceptTouchEvent");
        goto L32
    L24:
        int r9 = (int) r6.getY(r8);
        if (Math.abs(r9 - this.a) <= this.c) goto L32;
        this.b = true;
        this.a = r9;
        goto L32
    L16:
        if (r1 != 3) goto L32;
    L27:
        this.b = false;
        this.d = -1;
        goto L32
    }

    public void setOnActionDownListener(a r1) {
        this.e = r1;
    }

    public ParagraphLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.d = -1;
        this.c = ViewConfiguration.get(r1).getScaledTouchSlop();
    }

    public ParagraphLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.d = -1;
        this.c = ViewConfiguration.get(r1).getScaledTouchSlop();
    }
}
