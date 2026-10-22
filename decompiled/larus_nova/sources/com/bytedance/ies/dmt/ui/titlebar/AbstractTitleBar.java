package com.bytedance.ies.dmt.ui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import e46.b;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AbstractTitleBar extends FrameLayout implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DmtTextView f248381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f248382b;

    @Override // e46.b
    public abstract void a(int r100);

    public abstract void setDividerLineBackground(int r100);

    public int getColorMode() {
        return this.f248382b;
    }

    public DmtTextView getTitleView() {
        return this.f248381a;
    }

    public AbstractTitleBar(Context r100) {
        super(r100);
    }

    public void setColorMode(int r100) {
        if (this.f248382b == r100) goto L5;
        this.f248382b = r100;
        a(r100);
    L5:
        this.f248382b = r100;
    }

    public void setTitle(int r100) {
        DmtTextView r101 = this.f248381a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setText(r100);
    }

    public void setTitleColor(int r100) {
        DmtTextView r101 = this.f248381a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTextColor(r100);
    }

    public void setTitleSize(float r100) {
        DmtTextView r101 = this.f248381a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setTextSize(r100);
    }

    public void setTitle(CharSequence r100) {
        DmtTextView r101 = this.f248381a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setText(r100);
    }

    public AbstractTitleBar(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public AbstractTitleBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
