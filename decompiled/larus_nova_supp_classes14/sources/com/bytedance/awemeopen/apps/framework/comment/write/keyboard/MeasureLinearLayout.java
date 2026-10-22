package com.bytedance.awemeopen.apps.framework.comment.write.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class MeasureLinearLayout extends LinearLayout {
    public MeasureLinearLayout(Context r2) {
        this(r2, null);
    }

    public MeasureLinearLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    public MeasureLinearLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
