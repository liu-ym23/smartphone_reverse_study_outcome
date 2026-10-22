package com.ss.android.videoshop.widget.compat;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes40.dex */
public class RelativeLayoutCompat extends RelativeLayout {
    public RelativeLayoutCompat(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchWindowFocusChanged(boolean r100) {
        super.dispatchWindowFocusChanged(r100);
    }

    public RelativeLayoutCompat(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public RelativeLayoutCompat(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
