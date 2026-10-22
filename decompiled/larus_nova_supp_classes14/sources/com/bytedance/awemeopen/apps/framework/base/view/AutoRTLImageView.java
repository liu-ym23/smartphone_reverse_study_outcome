package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class AutoRTLImageView extends AppCompatImageView {
    public AutoRTLImageView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackground(Drawable r2) {
        super/*android.widget.ImageView*/.setBackground(r2);
        if (r2 == null) goto L6;
        r2.setAutoMirrored(true);
        return;
    }

    public void setImageDrawable(Drawable r2) {
        super.setImageDrawable(r2);
        if (r2 == null) goto L6;
        r2.setAutoMirrored(true);
        return;
    }

    public AutoRTLImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutoRTLImageView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        int r5 = Build.VERSION.SDK_INT;
        Drawable r6 = getDrawable();
        Drawable r7 = getBackground();
        if (r5 < 23) goto L5;
        Drawable r8 = getForeground();
    L7:
        if (r6 == null) goto L9;
        r6.setAutoMirrored(true);
    L9:
        if (r7 == null) goto L11;
        r7.setAutoMirrored(true);
    L11:
        if (r8 == null) goto L14;
        r8.setAutoMirrored(true);
        return;
    L14:
        return;
    L5:
        r8 = null;
        goto L7
    }
}
