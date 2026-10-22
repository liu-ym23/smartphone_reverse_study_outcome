package com.ss.android.ugc.aweme.shortvideo.sticker.widget.tablayout;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: loaded from: classes40.dex */
public final class TabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f454194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f454195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f454196c;

    public TabItem(Context r100) {
        this(r100, null);
    }

    public TabItem(Context r100, AttributeSet r101) {
        super(r100, r101);
        TintTypedArray r102 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.icon, R.attr.layout, R.attr.text});
        this.f454194a = r102.getText(2);
        this.f454195b = r102.getDrawable(0);
        this.f454196c = r102.getResourceId(1, 0);
        r102.recycle();
    }
}
