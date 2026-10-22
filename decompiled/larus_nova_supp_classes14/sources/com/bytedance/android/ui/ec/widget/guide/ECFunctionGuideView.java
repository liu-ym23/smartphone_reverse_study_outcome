package com.bytedance.android.ui.ec.widget.guide;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class ECFunctionGuideView extends FrameLayout {

    public interface FunctionLayer {
        FrameLayout.LayoutParams getLayerParams();

        View getView();
    }

    public ECFunctionGuideView(Context r1) {
        super(r1);
    }

    public ECFunctionGuideView addFunctionLayer(FunctionLayer r2) {
        if (r2 == null) goto L7;
        View r0 = r2.getView();
        FrameLayout.LayoutParams r3 = r2.getLayerParams();
        if (r0 == null) goto L7;
        if (r3 == null) goto L7;
        addView(r0, r3);
    L7:
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r4) {
        boolean r0 = super.dispatchTouchEvent(r4);
        if (r4 == null) goto L11;
        int r5 = r4.getAction() & 255;
        if (r5 != 0) goto L9;
        if (r0 == true) goto L9;
        setVisibility(8);
    L9:
        if (r5 != 1) goto L11;
        setVisibility(8);
    L11:
        return r0;
    }

    public ECFunctionGuideView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public ECFunctionGuideView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
