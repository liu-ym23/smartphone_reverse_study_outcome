package com.bytedance.ies.dmt.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes19.dex */
public class AutoRTLImageView extends AppCompatImageView {
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

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
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
        int r103 = Build.VERSION.SDK_INT;
        Drawable r104 = getDrawable();
        Drawable r105 = getBackground();
        if (r103 < 23) goto L5;
        Drawable r106 = getForeground();
    L7:
        if (r104 == null) goto L9;
        r104.setAutoMirrored(true);
    L9:
        if (r105 == null) goto L11;
        r105.setAutoMirrored(true);
    L11:
        if (r106 == null) goto L14;
        r106.setAutoMirrored(true);
        return;
    L14:
        return;
    L5:
        r106 = null;
        goto L7
    }
}
