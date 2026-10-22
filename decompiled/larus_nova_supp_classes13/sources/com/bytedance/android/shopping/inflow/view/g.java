package com.bytedance.android.shopping.inflow.view;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends ViewOutlineProvider {
    public float a;
    public int b;
    public int c;

    public g() {
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r4, Outline r5) {
        r5.setRoundRect(new Rect(0, 0, this.b, this.c), this.a);
    }

    public void update(float r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
