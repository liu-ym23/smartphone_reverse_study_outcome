package com.obric.oui.tab;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: loaded from: classes34.dex */
public final class OTabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f403129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f403130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f403131c;

    public OTabItem(Context r100) {
        this(r100, null);
    }

    public OTabItem(Context r100, AttributeSet r101) {
        super(r100, r101);
        TintTypedArray r102 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.icon, R.attr.layout, R.attr.text});
        this.f403129a = r102.getText(2);
        this.f403130b = r102.getDrawable(0);
        this.f403131c = r102.getResourceId(1, 0);
        r102.recycle();
    }
}
