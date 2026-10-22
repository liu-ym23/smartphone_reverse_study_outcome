package com.ss.android.lark.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class RatioImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f445641a;

    public RatioImageView(Context r100) {
        this(r100, null);
    }

    public RatioImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        float r103 = this.f445641a;
        if (r103 <= 0.0f) goto L5;
        r101 = View.MeasureSpec.makeMeasureSpec((int) (r102 / r103), 1073741824);
    L5:
        super.onMeasure(r100, r101);
    }

    public RatioImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f445641a = 0.0f;
        TypedArray r103 = getContext().obtainStyledAttributes(r101, new int[]{R.attr.ratio});
        this.f445641a = r103.getFloat(0, 0.0f);
        r103.recycle();
    }
}
