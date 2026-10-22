package com.bytedance.awemeopen.apps.framework.feed.ui.pendant;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class PendantDragLayout extends RelativeLayout {
    public static final /* synthetic */ int m = 0;
    public float a;
    public float b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public final boolean h;
    public boolean i;
    public int j;
    public int k;
    public int l;

    public interface a {
    }

    public void setPendantClickListener(a r1) {
    }

    public PendantDragLayout(Context r2) {
        super(r2);
        this.c = false;
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = true;
        this.i = true;
        this.k = 0;
        this.l = 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        super.dispatchTouchEvent(r2);
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r14) {
        ViewGroup r0 = (ViewGroup) getParent();
        if (this.i == false) goto L38;
        float r1 = r14.getRawX();
        float r5 = r14.getRawY();
        int r6 = r14.getAction();
        if (r6 == 0) goto L36;
        if (r6 == 1) goto L26;
        if (r6 == 2) goto L11;
        if (r6 == 3) goto L26;
    L11:
        if (r1 < 0.0f) goto L38;
        if (r1 > this.e) goto L38;
        int r7 = this.g;
        if (r5 < r7) goto L38;
        if (r5 > (this.f + r7)) goto L38;
        float r8 = r1 - this.a;
        float r9 = r5 - this.b;
        if (this.c == false) goto L21;
    L24:
        a(getTranslationX() + r8, getTranslationY() + r9);
        this.a = r1;
        this.b = r5;
        goto L38
    L21:
        if (Math.sqrt((r8 * r8) + (r9 * r9)) >= 2.0d) goto L23;
        this.c = false;
        goto L24
    L23:
        this.c = true;
        this.d = r0.isMotionEventSplittingEnabled();
        r0.setMotionEventSplittingEnabled(false);
    L26:
        if (this.h == false) goto L34;
        if (this.c == false) goto L34;
        if (this.a > (this.e / 2)) goto L32;
        animate().setDuration(200).x(this.j).start();
        this.a = this.j;
        goto L34
    L32:
        animate().setDuration(200).x((this.e - getWidth()) - this.j).start();
        this.a = (this.e - getWidth()) - this.j;
    L34:
        if (this.c == false) goto L38;
        r0.setMotionEventSplittingEnabled(this.d);
        goto L38
    L36:
        this.c = false;
        this.a = r1;
        this.b = r5;
        int[] r2 = new int[2];
        r0.getLocationInWindow(r2);
        this.f = (r0.getMeasuredHeight() - r0.getPaddingTop()) - r0.getPaddingBottom();
        this.e = (r0.getMeasuredWidth() - r0.getPaddingLeft()) - r0.getPaddingRight();
        this.g = r2[1];
    L38:
        if (this.c == false) goto L40;
    L43:
        boolean r3 = true;
    L45:
        if (this.i == true) goto L47;
    L50:
        this.c = false;
    L51:
        return r3;
    L47:
        if (r14.getAction() == 1) goto L50;
        if (r14.getAction() != 3) goto L51;
    L40:
        if (super.onTouchEvent(r14) == true) goto L43;
        r3 = false;
        goto L45
    }

    public void setBottomBound(int r1) {
        this.k = r1;
    }

    public void setDragEnable(boolean r1) {
        this.i = r1;
    }

    public void setHorizontalMargin(int r1) {
        this.j = r1;
    }

    @Override // android.view.View
    public void setOnClickListener(final View.OnClickListener r2) {
        if (r2 != null) goto L4;
        super.setOnClickListener(null);
        return;
    L4:
        super.setOnClickListener(new com.bytedance.awemeopen.apps.framework.feed.ui.pendant.a(this, r2));
    }

    public void setTopBound(int r1) {
        this.l = r1;
    }

    public PendantDragLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = false;
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = true;
        this.i = true;
        this.k = 0;
        this.l = 0;
    }

    public final void a(float r6, float r7) {
        if (this.e != 0) goto L5;
    L6:
        ViewGroup r0 = (ViewGroup) getParent();
        if (r0 == null) goto L9;
        r0.getLocationInWindow(new int[2]);
        this.f = (r0.getMeasuredHeight() - r0.getPaddingTop()) - r0.getPaddingBottom();
        this.e = (r0.getMeasuredWidth() - r0.getPaddingLeft()) - r0.getPaddingRight();
    L9:
        float r1 = this.e - getWidth();
        float r2 = (this.f - getHeight()) - this.k;
        float r3 = this.l;
        float r4 = 0.0f;
        if (r6 < 0.0f) goto L14;
        r4 = Math.min(r6, r1);
    L14:
        if (r7 < r3) goto L17;
        r3 = Math.min(r7, r2);
    L17:
        setTranslationX(r4);
        setTranslationY(r3);
        return;
    L5:
        if (this.f != 0) goto L9;
        goto L6
    }

    public PendantDragLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = false;
        this.d = false;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = true;
        this.i = true;
        this.k = 0;
        this.l = 0;
    }
}
