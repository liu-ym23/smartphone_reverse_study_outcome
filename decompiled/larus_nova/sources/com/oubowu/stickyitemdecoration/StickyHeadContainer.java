package com.oubowu.stickyitemdecoration;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes34.dex */
public class StickyHeadContainer extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f404337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f404338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f404339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f404340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f404341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f404342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f404343g;

    public interface a {
        void a(int r100);
    }

    public int getChildHeight() {
        return getChildAt(0).getHeight();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    public int getLastStickyHeadPosition() {
        return this.f404339c;
    }

    public StickyHeadContainer(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        return r100 instanceof ViewGroup.MarginLayoutParams;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new ViewGroup.MarginLayoutParams(getContext(), r100);
    }

    public void setDataCallback(a r100) {
        this.f404343g = r100;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return new ViewGroup.MarginLayoutParams(r100);
    }

    public StickyHeadContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getChildCount() != 1) goto L7;
        View r102 = getChildAt(0);
        measureChildWithMargins(r102, r100, 0, r101, 0);
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102.getLayoutParams();
        int r104 = (r102.getMeasuredWidth() + r103.leftMargin) + r103.rightMargin;
        int r105 = (r102.getMeasuredHeight() + r103.topMargin) + r103.bottomMargin;
        int r106 = r104 + (getPaddingLeft() + getPaddingRight());
        int r107 = r105 + (getPaddingTop() + getPaddingBottom());
        int r108 = Math.max(r106, getSuggestedMinimumWidth());
        int r109 = Math.max(r107, getSuggestedMinimumHeight());
        setMeasuredDimension(ViewGroup.resolveSize(r108, r100), ViewGroup.resolveSize(r109, r101));
        return;
    L7:
        throw new IllegalArgumentException("只允许容器添加1个子View！");
    }

    public StickyHeadContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f404338b = 0;
        this.f404339c = Integer.MIN_VALUE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = getChildAt(0);
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105.getLayoutParams();
        int r107 = getPaddingLeft();
        int r108 = getPaddingTop();
        this.f404340d = r107 + r106.leftMargin;
        this.f404341e = r105.getMeasuredWidth() + this.f404340d;
        this.f404342f = (r108 + r106.topMargin) + this.f404337a;
        int r109 = r105.getMeasuredHeight();
        int r110 = this.f404342f;
        int r111 = this.f404340d;
        int r112 = this.f404341e;
        r105.layout(r111, r110, r112, r109 + r110);
    }
}
