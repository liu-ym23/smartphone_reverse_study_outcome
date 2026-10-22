package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: loaded from: classes23.dex */
public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }

    public VisibilityAwareImageButton(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int r100) {
        internalSetVisibility(r100, true);
    }

    public VisibilityAwareImageButton(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public final void internalSetVisibility(int r100, boolean r101) {
        super.setVisibility(r100);
        if (r101 == false) goto L6;
        this.userSetVisibility = r100;
        return;
    }

    public VisibilityAwareImageButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.userSetVisibility = getVisibility();
    }
}
