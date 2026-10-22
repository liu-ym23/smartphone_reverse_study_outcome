package com.bytedance.ee.bear.list.homepage.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class CompatDrawableTextView extends AppCompatTextView {
    public CompatDrawableTextView(Context r100) {
        this(r100, null);
    }

    public CompatDrawableTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public CompatDrawableTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        if (r101 == null) goto L6;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.drawableBottomCompat, R.attr.drawableEndCompat, R.attr.drawableStartCompat, R.attr.drawableTopCompat});
        Drawable r104 = r103.getDrawable(2);
        Drawable r105 = r103.getDrawable(1);
        Drawable r106 = r103.getDrawable(0);
        setCompoundDrawablesRelativeWithIntrinsicBounds(r104, r103.getDrawable(3), r105, r106);
        r103.recycle();
        return;
    }
}
