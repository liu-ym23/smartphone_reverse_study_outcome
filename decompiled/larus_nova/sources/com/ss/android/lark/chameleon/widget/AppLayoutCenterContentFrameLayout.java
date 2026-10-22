package com.ss.android.lark.chameleon.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public class AppLayoutCenterContentFrameLayout extends FrameLayout {
    private int appBarLayoutId;
    private int scrollContentId;

    private boolean isUsingAppBarLayoutScrollBehavior(View r100) {
        return false;
    }

    private int calHeightToAdjust() {
        View r100 = getRootView();
        if (r100 != null) goto L5;
        return 0;
    L5:
        View r101 = r100.findViewById(this.appBarLayoutId);
        View r102 = r100.findViewById(this.scrollContentId);
        if (r101 == null) goto L13;
        if (r102 != null) goto L10;
        return 0;
    L10:
        if (isUsingAppBarLayoutScrollBehavior(r102) == true) goto L12;
        return 0;
    L12:
        return r101.getMeasuredHeight();
    L13:
        return 0;
    }

    public AppLayoutCenterContentFrameLayout(Context r100) {
        super(r100);
        init(null);
    }

    private void init(AttributeSet r100) {
        if (r100 == null) goto L5;
        TypedArray r101 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.appBarLayoutId, R.attr.scrollContentId}, 0, 0);
        this.appBarLayoutId = r101.getResourceId(0, 0);
        this.scrollContentId = r101.getResourceId(1, 0);
        r101.recycle();
        return;
    }

    public AppLayoutCenterContentFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        init(r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r101);
        int r103 = View.MeasureSpec.getSize(r101);
        if (r103 <= 0) goto L5;
        r101 = View.MeasureSpec.makeMeasureSpec(r103 - calHeightToAdjust(), r102);
    L5:
        super.onMeasure(r100, r101);
    }

    public AppLayoutCenterContentFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init(r101);
    }

    public AppLayoutCenterContentFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        init(r101);
    }
}
