package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public NoConsumeInsetsFrameLayout(Context r1) {
        super(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets r4) {
        super.dispatchApplyWindowInsets(new WindowInsets(r4));
        int r0 = 0;
    L4:
        if (r0 >= getChildCount()) goto L6;
        getChildAt(r0).dispatchApplyWindowInsets(new WindowInsets(r4));
        r0 = r0 + 1;
        goto L4
    L6:
        return r4;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r3) {
        super.onViewAdded(r3);
        requestApplyInsets();
        com.ss.android.lark.officesdk.utils.di.j.e("NoConsumeInsetsFrameLayout", getTagString() + "onViewAdded " + r3);
    }

    public NoConsumeInsetsFrameLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        super.onVisibilityChanged(r2, r3);
        com.ss.android.lark.officesdk.utils.di.j.e("NoConsumeInsetsFrameLayout", getTagString() + "onVisibilityChanged " + r3);
    }

    public NoConsumeInsetsFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r3, int r4, int r5, int r6) {
        super.onSizeChanged(r3, r4, r5, r6);
        com.ss.android.lark.officesdk.utils.di.j.e("NoConsumeInsetsFrameLayout", getTagString() + "onSizeChanged  " + r3 + " " + r4 + " " + r5 + " " + r6);
    }
}
