package com.bytedance.ee.bear.office.common.upload;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements View.OnLayoutChangeListener {
    public final /* synthetic */ g a;

    public f(g r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        if (r1.getHeight() <= 0) goto L6;
        this.a.a(r1.getHeight() + this.a.b);
        return;
    }
}
