package com.obric.oui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public abstract class OTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f403462a;

    public abstract void setDividerLineBackground(int r100);

    public TextView getTitleView() {
        return this.f403462a;
    }

    public OTitleBar(Context r100) {
        super(r100);
    }

    public void setTitle(int r100) {
        TextView r101 = this.f403462a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setText(r100);
    }

    public void setTitleColor(int r100) {
        TextView r101 = this.f403462a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTextColor(r100);
    }

    public void setTitleSize(float r100) {
        TextView r101 = this.f403462a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTextSize(r100);
    }

    public void setTitleSizePixel(float r100) {
        TextView r101 = this.f403462a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTextSize(0, r100);
    }

    public void setTitle(CharSequence r100) {
        TextView r101 = this.f403462a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setText(r100);
    }

    public OTitleBar(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public OTitleBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        if (getBackground() != null) goto L6;
        setBackgroundColor(ContextCompat.getColor(r100, R.color.BGPrimary));
        return;
    }
}
