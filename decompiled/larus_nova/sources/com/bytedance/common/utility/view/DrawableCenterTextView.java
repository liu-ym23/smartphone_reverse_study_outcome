package com.bytedance.common.utility.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes15.dex */
public class DrawableCenterTextView extends TextView {
    public DrawableCenterTextView(Context r100) {
        super(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r100) {
        Drawable[] r101 = getCompoundDrawables();
        if (r101 != null) goto L5;
    L17:
        super.onDraw(r100);
        return;
    L5:
        if (r101.length != 4) goto L17;
        Drawable r102 = r101[0];
        Drawable r103 = r101[2];
        if (r102 != null) goto L9;
        if (r103 == null) goto L17;
    L9:
        float r104 = getPaint().measureText(getText().toString());
        int r105 = getCompoundDrawablePadding();
        if (r102 == null) goto L12;
        int r106 = r102.getIntrinsicWidth();
    L13:
        float r107 = (r104 + r106) + r105;
        if (r102 == null) goto L16;
        setGravity(19);
        r100.translate((getWidth() - r107) / 2.0f, 0.0f);
        goto L17
    L16:
        setGravity(21);
        r100.translate((r107 - getWidth()) / 2.0f, 0.0f);
        goto L17
    L12:
        r106 = r103.getIntrinsicWidth();
        goto L13
    }

    public DrawableCenterTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public DrawableCenterTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
