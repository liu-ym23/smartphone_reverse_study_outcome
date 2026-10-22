package com.lynx.component.svg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes32.dex */
public class SvgImageView extends AppCompatImageView {
    public SvgImageView(Context r100) {
        super(r100);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r100) {
        ViewCompat.setLayerType(this, 1, null);
        super.setImageDrawable(r100);
    }
}
