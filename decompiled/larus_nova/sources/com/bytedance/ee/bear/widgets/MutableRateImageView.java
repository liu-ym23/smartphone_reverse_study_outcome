package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class MutableRateImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f240110a;

    public MutableRateImageView(Context r100) {
        this(r100, null);
    }

    public MutableRateImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f240110a == 0.0f) goto L6;
        int r102 = getMeasuredWidth();
        setMeasuredDimension(r102, (int) ((r102 * 1.0f) / this.f240110a));
        return;
    }

    public MutableRateImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f240110a = r100.obtainStyledAttributes(r101, new int[]{R.attr.width_height_rate}).getFloat(0, 0.0f);
    }
}
