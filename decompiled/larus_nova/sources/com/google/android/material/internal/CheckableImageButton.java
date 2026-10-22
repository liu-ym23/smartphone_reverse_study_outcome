package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes23.dex */
public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = null;
    private boolean checked;

    static {
        DRAWABLE_STATE_CHECKED = new int[]{R.attr.state_checked};
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public CheckableImageButton(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int r100) {
        if (this.checked == false) goto L7;
        int[] r101 = DRAWABLE_STATE_CHECKED;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(r100 + r101.length), r101);
    L7:
        return super.onCreateDrawableState(r100);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r100) {
        if (this.checked == r100) goto L6;
        this.checked = r100;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
        return;
    }

    public CheckableImageButton(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1(this));
    }
}
