package com.ss.android.lark.search.ui.result.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public class IconFrontTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f440336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f440337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f440338c;

    public IconFrontTextView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
    }

    public IconFrontTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public IconFrontTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f440338c = true;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.drawableLeftHeight, R.attr.drawableLeftWidth, R.attr.isAlignCenter});
        this.f440336a = r103.getDimensionPixelSize(1, 0);
        this.f440337b = r103.getDimensionPixelSize(0, 0);
        this.f440338c = r103.getBoolean(2, true);
        r103.recycle();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setCompoundDrawables(Drawable r100, Drawable r101, Drawable r102, Drawable r103) {
        if (r100 == null) goto L12;
        int r104 = this.f440336a;
        int r105 = this.f440337b;
        if (r104 != 0) goto L6;
        r104 = r100.getIntrinsicWidth();
    L6:
        if (r105 != 0) goto L8;
        r105 = r100.getIntrinsicHeight();
    L8:
        int r106 = (int) ((((((getBottom() - getTop()) - getCompoundPaddingBottom()) - getCompoundPaddingTop()) * (1.0f - (1.0f / Math.min(getLineCount(), getMaxLines())))) * (-1.0f)) / 2.0f);
        if (this.f440338c == false) goto L11;
        r106 = 0;
    L11:
        r100.setBounds(0, r106, r104, r105 + r106);
    L12:
        super.setCompoundDrawables(r100, r101, r102, r103);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        Drawable[] r105 = getCompoundDrawables();
        setCompoundDrawables(r105[0], r105[1], r105[2], r105[3]);
    }
}
