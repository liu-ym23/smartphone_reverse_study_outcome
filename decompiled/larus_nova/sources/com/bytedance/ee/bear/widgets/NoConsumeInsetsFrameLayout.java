package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes18.dex */
public class NoConsumeInsetsFrameLayout extends FrameLayout {
    private String getTagString() {
        if (getTag() != null) goto L5;
        return "";
    L5:
        if (getTag().toString().length() > 0) goto L7;
        return "";
    L7:
        return getTag().toString() + " ";
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.ss.android.lark.officesdk.utils.di.j.e("NoConsumeInsetsFrameLayout", getTagString() + "onAttachedToWindow ");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.ss.android.lark.officesdk.utils.di.j.e("NoConsumeInsetsFrameLayout", getTagString() + "onDetachedFromWindow ");
    }

    public NoConsumeInsetsFrameLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets r100) {
        super.dispatchApplyWindowInsets(new WindowInsets(r100));
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L6;
        getChildAt(r101).dispatchApplyWindowInsets(new WindowInsets(r100));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r100) {
        super.onViewAdded(r100);
        requestApplyInsets();
        com.ss.android.lark.officesdk.utils.di.j.e("NoConsumeInsetsFrameLayout", getTagString() + "onViewAdded " + r100);
    }

    public NoConsumeInsetsFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        com.ss.android.lark.officesdk.utils.di.j.e("NoConsumeInsetsFrameLayout", getTagString() + "onVisibilityChanged " + r101);
    }

    public NoConsumeInsetsFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        com.ss.android.lark.officesdk.utils.di.j.e("NoConsumeInsetsFrameLayout", getTagString() + "onSizeChanged  " + r100 + " " + r101 + " " + r102 + " " + r103);
    }
}
