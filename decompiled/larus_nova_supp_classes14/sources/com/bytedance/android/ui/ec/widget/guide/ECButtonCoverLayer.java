package com.bytedance.android.ui.ec.widget.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ECButtonCoverLayer extends View implements ECFunctionGuideView.FunctionLayer {
    private FrameLayout.LayoutParams mLayerParams;

    @Override // com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView.FunctionLayer
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.ui.ec.widget.guide.ECFunctionGuideView.FunctionLayer
    public FrameLayout.LayoutParams getLayerParams() {
        return this.mLayerParams;
    }

    public ECButtonCoverLayer(Context r1) {
        super(r1);
    }

    @Override // android.view.View
    public void onDraw(Canvas r1) {
        super.onDraw(r1);
    }

    public void setData(Rect r4) {
        if (r4 == null) goto L5;
        FrameLayout.LayoutParams r2 = new FrameLayout.LayoutParams(r4.right - r4.left, r4.bottom - r4.top);
        this.mLayerParams = r2;
        r2.leftMargin = r4.left;
        r2.topMargin = r4.top;
        return;
    }

    public ECButtonCoverLayer(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public ECButtonCoverLayer(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
