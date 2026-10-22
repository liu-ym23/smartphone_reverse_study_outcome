package com.bytedance.common.jato.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes15.dex */
public class JatoOptRecyclerView extends RecyclerView implements LayoutHookHelper.ViewInterface {
    private LayoutHookHelper mViewOptHelper;

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        LayoutHookHelper r100 = this.mViewOptHelper;
        if (r100 == null) goto L5;
        r100.proxyRequestLayout(false);
        return;
    L5:
        super.requestLayout();
    }

    @Override // com.bytedance.common.jato.views.LayoutHookHelper.ViewInterface
    public void requestLayoutDelegate() {
        super.requestLayout();
    }

    public JatoOptRecyclerView(Context r100) {
        super(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
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

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setHasFixedSize(boolean r100) {
        super.setHasFixedSize(r100);
        if (this.mViewOptHelper != null) goto L5;
        this.mViewOptHelper = new LayoutHookHelper("JatoOptRecyclerView", this);
    L5:
        this.mViewOptHelper.setSkipMeasure(r100);
    }

    public JatoOptRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public JatoOptRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
