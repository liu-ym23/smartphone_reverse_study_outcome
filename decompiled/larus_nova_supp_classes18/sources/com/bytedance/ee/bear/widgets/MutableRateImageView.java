package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MutableRateImageView extends AppCompatImageView {
    public final float a;

    public MutableRateImageView(Context r2) {
        this(r2, null);
    }

    public MutableRateImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r2, int r3) {
        super/*android.widget.ImageView*/.onMeasure(r2, r3);
        if (this.a == 0.0f) goto L6;
        int r4 = getMeasuredWidth();
        setMeasuredDimension(r4, (int) ((r4 * 1.0f) / this.a));
        return;
    }

    public MutableRateImageView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        this.a = r3.obtainStyledAttributes(r4, new int[]{2130975142}).getFloat(0, 0.0f);
    }
}
