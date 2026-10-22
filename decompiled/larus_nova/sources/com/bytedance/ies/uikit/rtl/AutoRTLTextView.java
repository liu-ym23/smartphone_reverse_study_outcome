package com.bytedance.ies.uikit.rtl;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: classes19.dex */
public class AutoRTLTextView extends AppCompatTextView {
    public AutoRTLTextView(Context r100) {
        this(r100, null);
    }

    public AutoRTLTextView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.textViewStyle);
    }

    public AutoRTLTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        Drawable r103 = getBackground();
        Drawable[] r104 = getCompoundDrawables();
        Drawable[] r105 = getCompoundDrawablesRelative();
        if (r103 == null) goto L5;
        r103.setAutoMirrored(true);
    L5:
        int r106 = r104.length;
        int r107 = 0;
        int r108 = 0;
    L6:
        if (r108 >= r106) goto L12;
        Drawable r109 = r104[r108];
        if (r109 == null) goto L11;
        r109.setAutoMirrored(true);
    L11:
        r108 = r108 + 1;
        goto L6
    L12:
        int r110 = r105.length;
    L13:
        if (r107 >= r110) goto L19;
        Drawable r111 = r105[r107];
        if (r111 == null) goto L18;
        r111.setAutoMirrored(true);
    L18:
        r107 = r107 + 1;
        goto L13
    }
}
