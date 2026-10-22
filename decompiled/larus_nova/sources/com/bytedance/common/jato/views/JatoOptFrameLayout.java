package com.bytedance.common.jato.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes15.dex */
public class JatoOptFrameLayout extends FrameLayout implements LayoutHookHelper.ViewInterface {
    private LayoutHookHelper mViewOptHelper;

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        LayoutHookHelper r100 = this.mViewOptHelper;
        if (r100 == null) goto L5;
        r100.proxyRequestLayout(true);
        return;
    L5:
        super.requestLayout();
    }

    @Override // com.bytedance.common.jato.views.LayoutHookHelper.ViewInterface
    public void requestLayoutDelegate() {
        super.requestLayout();
    }

    public JatoOptFrameLayout(Context r100) {
        super(r100);
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (ViewOpt.isIsStrictMode() == false) goto L11;
        LayoutHookHelper r101 = this.mViewOptHelper;
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.checkViewPropAvailable(getMeasuredWidth(), getMeasuredHeight(), getLeft(), getTop(), getRight(), getBottom()) == false) goto L10;
        return;
    L10:
        throw new RuntimeException();
    }

    public void setHasFixSize(boolean r100) {
        if (this.mViewOptHelper != null) goto L5;
        this.mViewOptHelper = new LayoutHookHelper("JatoOptFrameLayout", this);
    L5:
        this.mViewOptHelper.setSkipMeasure(r100);
    }

    public JatoOptFrameLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public JatoOptFrameLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
