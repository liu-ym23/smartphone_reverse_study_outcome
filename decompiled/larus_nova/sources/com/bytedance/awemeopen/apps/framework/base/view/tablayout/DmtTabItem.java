package com.bytedance.awemeopen.apps.framework.base.view.tablayout;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: loaded from: classes14.dex */
public final class DmtTabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f193669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f193670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f193671c;

    public DmtTabItem(Context r100) {
        this(r100, null);
    }

    public DmtTabItem(Context r100, AttributeSet r101) {
        super(r100, r101);
        TintTypedArray r102 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.icon, R.attr.layout, R.attr.text});
        this.f193669a = r102.getText(2);
        this.f193670b = r102.getDrawable(0);
        this.f193671c = r102.getResourceId(1, 0);
        r102.recycle();
    }
}
