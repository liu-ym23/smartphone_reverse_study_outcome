package com.bytedance.ee.bear.widgets.tagview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceTagView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UDTagsDrawable.d.a f240344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDTagsDrawable f240345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public UDTagsDrawable f240346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f240347d;

    public SpaceTagView(Context r100) {
        this(r100, null);
    }

    public final UDTagsDrawable b(float r100) {
        if (this.f240344a != null) goto L6;
        return null;
    L6:
        UDTagsDrawable.a r101 = new UDTagsDrawable.a(getContext());
        r101.a(this.f240344a.b());
        r101.f285332f = r100;
        return r101.b();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.f240346c == null) goto L6;
        r100.save();
        r100.translate(getPaddingStart(), getPaddingTop());
        this.f240346c.draw(r100);
        r100.restore();
        return;
    }

    public void setLabel(UDTagsDrawable.d.a r100) {
        Context r101 = getContext();
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        this.f240344a = r100;
        this.f240345b = b(Float.MAX_VALUE);
        requestLayout();
        return;
    L8:
        return;
    }

    public SpaceTagView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = getPaddingStart() + getPaddingEnd();
        int r103 = getPaddingTop() + getPaddingEnd();
        int r104 = a(r100, r102, this.f240345b);
        UDTagsDrawable r105 = this.f240345b;
        int r106 = View.MeasureSpec.getMode(r101);
        int r107 = View.MeasureSpec.getSize(r101);
        if (r106 == 1073741824) goto L13;
        if (r105 == null) goto L7;
        int r108 = r105.getIntrinsicHeight();
    L8:
        int r109 = Math.max(r108 + r103, getSuggestedMinimumHeight());
        if (r106 != Integer.MIN_VALUE) goto L11;
        r107 = Math.min(r107, r109);
        goto L13
    L11:
        r107 = r109;
        goto L13
    L7:
        r108 = 0;
    L13:
        if (r104 == this.f240347d) goto L15;
        this.f240346c = b(r104 - r102);
    L15:
        this.f240347d = r104;
        UDTagsDrawable r110 = this.f240346c;
        if (r110 == null) goto L18;
        r104 = a(r100, r102, r110);
    L18:
        setMeasuredDimension(r104, r107);
    }

    public SpaceTagView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public final int a(int r100, int r101, UDTagsDrawable r102) {
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        if (r103 == 1073741824) goto L14;
        if (r102 == null) goto L7;
        int r105 = r102.getIntrinsicWidth();
    L8:
        int r106 = Math.max(r105 + r101, getSuggestedMinimumWidth());
        if (r103 != Integer.MIN_VALUE) goto L12;
        return Math.min(r104, r106);
    L12:
        return r106;
    L7:
        r105 = 0;
        goto L8
    L14:
        return r104;
    }
}
