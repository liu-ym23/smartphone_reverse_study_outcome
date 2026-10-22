package com.ss.android.lark.widget.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;

/* JADX INFO: loaded from: classes38.dex */
public class NavigationImageView extends LKUIRoundedImageView2 {
    public NavigationImageView(Context r100) {
        this(r100, null);
    }

    public NavigationImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public NavigationImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
}
