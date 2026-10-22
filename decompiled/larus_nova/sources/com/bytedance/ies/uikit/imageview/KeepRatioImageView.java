package com.bytedance.ies.uikit.imageview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes19.dex */
public class KeepRatioImageView extends ImageView {
    public KeepRatioImageView(Context r100) {
        super(r100);
    }

    public KeepRatioImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int r100, int r101) {
        Drawable r102 = getDrawable();     // Catch: Exception -> L15
        if (r102 != null) goto L5;
        setMeasuredDimension(0, 0);     // Catch: Exception -> L15
    L17:
        return;
    L5:
        int r103 = View.MeasureSpec.getSize(r100);     // Catch: Exception -> L15
        int r104 = View.MeasureSpec.getSize(r101);     // Catch: Exception -> L15
        if (r104 != 0) goto L9;
        if (r103 != 0) goto L9;
        setMeasuredDimension(r103, r104);     // Catch: Exception -> L15
    L9:
        if (r104 != 0) goto L11;
        setMeasuredDimension(r103, (r102.getIntrinsicHeight() * r103) / r102.getIntrinsicWidth());     // Catch: Exception -> L15
        goto L17
    L11:
        if (r103 != 0) goto L13;
        setMeasuredDimension((r102.getIntrinsicWidth() * r104) / r102.getIntrinsicHeight(), r104);     // Catch: Exception -> L15
        goto L17
    L13:
        setMeasuredDimension(r103, r104);     // Catch: Exception -> L15
    L15:
        super.onMeasure(r100, r101);
    }

    public KeepRatioImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
