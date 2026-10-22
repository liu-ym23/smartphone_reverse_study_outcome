package com.bytedance.ee.bear.list.homepage.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CompatDrawableTextView extends AppCompatTextView {
    public CompatDrawableTextView(Context r2) {
        this(r2, null);
    }

    public CompatDrawableTextView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CompatDrawableTextView(Context r3, AttributeSet r4, int r5) {
        super(r3, r4, r5);
        if (r4 == null) goto L6;
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130969821, 2130969822, 2130969831, 2130969834});
        Drawable r7 = r6.getDrawable(2);
        Drawable r8 = r6.getDrawable(1);
        Drawable r0 = r6.getDrawable(0);
        setCompoundDrawablesRelativeWithIntrinsicBounds(r7, r6.getDrawable(3), r8, r0);
        r6.recycle();
        return;
    }
}
