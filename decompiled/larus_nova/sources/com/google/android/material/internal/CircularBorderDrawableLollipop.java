package com.google.android.material.internal;

import android.graphics.Outline;

/* JADX INFO: loaded from: classes23.dex */
public class CircularBorderDrawableLollipop extends CircularBorderDrawable {
    public CircularBorderDrawableLollipop() {
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r100) {
        copyBounds(this.rect);
        r100.setOval(this.rect);
    }
}
