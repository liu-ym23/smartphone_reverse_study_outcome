package com.bytedance.awemeopen.apps.framework.base.view.tablayout;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class DmtTabItem extends View {
    public final CharSequence a;
    public final Drawable b;
    public final int c;

    public DmtTabItem(Context r2) {
        this(r2, null);
    }

    public DmtTabItem(Context r2, AttributeSet r3) {
        super(r2, r3);
        TintTypedArray r4 = TintTypedArray.obtainStyledAttributes(r2, r3, new int[]{R.attr.icon, R.attr.layout, R.attr.text});
        this.a = r4.getText(2);
        this.b = r4.getDrawable(0);
        this.c = r4.getResourceId(1, 0);
        r4.recycle();
    }
}
