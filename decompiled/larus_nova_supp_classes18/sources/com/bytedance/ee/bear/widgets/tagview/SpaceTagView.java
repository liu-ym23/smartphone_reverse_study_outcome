package com.bytedance.ee.bear.widgets.tagview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceTagView extends View {
    public UDTagsDrawable.d.a a;
    public UDTagsDrawable b;
    public UDTagsDrawable c;
    public int d;

    public SpaceTagView(Context r2) {
        this(r2, null);
    }

    public final UDTagsDrawable b(float r3) {
        if (this.a != null) goto L6;
        return null;
    L6:
        UDTagsDrawable.a r0 = new UDTagsDrawable.a(getContext());
        r0.a(this.a.b());
        r0.f = r3;
        return r0.b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r3) {
        super.onDraw(r3);
        if (this.c == null) goto L6;
        r3.save();
        r3.translate(getPaddingStart(), getPaddingTop());
        this.c.draw(r3);
        r3.restore();
        return;
    }

    public void setLabel(UDTagsDrawable.d.a r2) {
        Context r0 = getContext();
        if (r2 == null) goto L7;
        if (r0 == null) goto L8;
        this.a = r2;
        this.b = b(Float.MAX_VALUE);
        requestLayout();
        return;
    L8:
        return;
    }

    public SpaceTagView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r7, int r8) {
        super.onMeasure(r7, r8);
        int r0 = getPaddingStart() + getPaddingEnd();
        int r1 = getPaddingTop() + getPaddingEnd();
        int r2 = a(r7, r0, this.b);
        UDTagsDrawable r3 = this.b;
        int r4 = View.MeasureSpec.getMode(r8);
        int r9 = View.MeasureSpec.getSize(r8);
        if (r4 == 1073741824) goto L13;
        if (r3 == null) goto L7;
        int r5 = r3.getIntrinsicHeight();
    L8:
        int r6 = Math.max(r5 + r1, getSuggestedMinimumHeight());
        if (r4 != Integer.MIN_VALUE) goto L11;
        r9 = Math.min(r9, r6);
        goto L13
    L11:
        r9 = r6;
        goto L13
    L7:
        r5 = 0;
    L13:
        if (r2 == this.d) goto L15;
        this.c = b(r2 - r0);
    L15:
        this.d = r2;
        UDTagsDrawable r10 = this.c;
        if (r10 == null) goto L18;
        r2 = a(r7, r0, r10);
    L18:
        setMeasuredDimension(r2, r9);
    }

    public SpaceTagView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public final int a(int r3, int r4, UDTagsDrawable r5) {
        int r0 = View.MeasureSpec.getMode(r3);
        int r6 = View.MeasureSpec.getSize(r3);
        if (r0 == 1073741824) goto L14;
        if (r5 == null) goto L7;
        int r7 = r5.getIntrinsicWidth();
    L8:
        int r8 = Math.max(r7 + r4, getSuggestedMinimumWidth());
        if (r0 != Integer.MIN_VALUE) goto L12;
        return Math.min(r6, r8);
    L12:
        return r8;
    L7:
        r7 = 0;
        goto L8
    L14:
        return r6;
    }
}
