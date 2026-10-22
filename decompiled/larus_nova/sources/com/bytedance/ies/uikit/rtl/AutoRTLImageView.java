package com.bytedance.ies.uikit.rtl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes19.dex */
public class AutoRTLImageView extends ImageView {
    public AutoRTLImageView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
        super.setBackground(r100);
        if (r100 == null) goto L6;
        r100.setAutoMirrored(true);
        return;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        super.setImageDrawable(r100);
        if (r100 == null) goto L6;
        r100.setAutoMirrored(true);
        return;
    }

    public AutoRTLImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public AutoRTLImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Drawable r103 = getDrawable();
        Drawable r104 = getBackground();
        if (r103 == null) goto L5;
        r103.setAutoMirrored(true);
    L5:
        if (r104 == null) goto L8;
        r104.setAutoMirrored(true);
        return;
    }
}
