package com.bytedance.ee.bear.document.sharewords.view;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnLayoutChangeListener {
    public final /* synthetic */ Drawable a;

    public a(Drawable r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        this.a.setBounds(0, 0, r4 - r2, r5 - r3);
    }
}
