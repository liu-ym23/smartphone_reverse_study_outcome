package com.google.android.material.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.ThemeEnforcement;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class MaterialCardView extends CardView {
    private final MaterialCardViewHelper cardViewHelper;

    public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    public MaterialCardView(Context r100) {
        this(r100, null);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float r100) {
        super.setRadius(r100);
        this.cardViewHelper.updateForeground();
    }

    public void setStrokeColor(int r100) {
        this.cardViewHelper.setStrokeColor(r100);
    }

    public void setStrokeWidth(int r100) {
        this.cardViewHelper.setStrokeWidth(r100);
    }

    public MaterialCardView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.materialCardViewStyle);
    }

    public MaterialCardView(Context r100, AttributeSet r101, int r110) {
        super(r100, r101, r110);
        TypedArray r102 = ThemeEnforcement.obtainStyledAttributes(r100, r101, new int[]{R.attr.strokeColor, R.attr.strokeWidth}, r110, R.style.Widget_MaterialComponents_CardView, new int[0]);
        MaterialCardViewHelper r103 = new MaterialCardViewHelper(this);
        this.cardViewHelper = r103;
        r103.loadFromAttributes(r102);
        r102.recycle();
    }
}
