package com.bytedance.ee.bear.profile;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnLayoutChangeListener {
    public final /* synthetic */ HalfProfileActivity a;

    public a(HalfProfileActivity r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        int r10 = r5 - r3;
        HalfProfileActivity r11 = this.a;
        r11.f = r10;
        j r12 = r11.j;
        if (r12 == null) goto L6;
        r12.m(0.0f, r10 * 0.87f, r10);
        return;
    }
}
