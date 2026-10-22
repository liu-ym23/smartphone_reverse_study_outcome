package com.ss.android.lark.message.card.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes36.dex */
public class MaxHeightInterruptEventScrollView extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f431931a;

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    public int getMaxHeight() {
        return this.f431931a;
    }

    public MaxHeightInterruptEventScrollView(Context r100) {
        super(r100);
        this.f431931a = UIHelper.dp2px(280.0f);
    }

    public void setMaxHeight(int r100) {
        this.f431931a = r100;
        invalidate();
    }

    public MaxHeightInterruptEventScrollView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f431931a = UIHelper.dp2px(280.0f);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(this.f431931a, Integer.MIN_VALUE));
    }

    public MaxHeightInterruptEventScrollView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f431931a = UIHelper.dp2px(280.0f);
    }
}
