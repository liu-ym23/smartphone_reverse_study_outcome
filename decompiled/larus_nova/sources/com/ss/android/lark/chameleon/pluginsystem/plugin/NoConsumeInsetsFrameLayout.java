package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.ss.android.lark.chameleon.idependency.Log;

/* JADX INFO: loaded from: classes35.dex */
public class NoConsumeInsetsFrameLayout extends FrameLayout {
    private static final String TAG = "NoConsumeInsetsFrameLayout";

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
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i(TAG, getTagString() + "onAttachedToWindow ");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.i(TAG, getTagString() + "onDetachedFromWindow ");
    }

    public NoConsumeInsetsFrameLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets r100) {
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
    public void onViewAdded(View r100) {
        super.onViewAdded(r100);
        requestApplyInsets();
        Log.i(TAG, getTagString() + "onViewAdded " + r100);
    }

    public NoConsumeInsetsFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        Log.i(TAG, getTagString() + "onVisibilityChanged " + r101);
    }

    public NoConsumeInsetsFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    public NoConsumeInsetsFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Log.i(TAG, getTagString() + "onSizeChanged  " + r100 + " " + r101 + " " + r102 + " " + r103);
    }
}
