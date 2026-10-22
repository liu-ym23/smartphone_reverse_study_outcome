package com.bytedance.ee.bear.office.space;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements View.OnLayoutChangeListener {
    public final /* synthetic */ OfficeSpaceFragment a;
    public final /* synthetic */ View b;

    public g(OfficeSpaceFragment r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if ((r4 - r2) == (r8 - r6)) goto L6;
        OfficeSpaceFragment r10 = this.a;
        View r11 = this.b;
        int r12 = OfficeSpaceFragment.v;
        r10.U90(r11);
        return;
    }
}
