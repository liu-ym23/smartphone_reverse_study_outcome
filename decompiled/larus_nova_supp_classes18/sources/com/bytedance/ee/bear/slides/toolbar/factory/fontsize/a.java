package com.bytedance.ee.bear.slides.toolbar.factory.fontsize;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ FontSizeAdapter a;

    public a(FontSizeAdapter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        h r2 = this.a.b;
        if (r2 == null) goto L6;
        r2.onBackClick();
        return;
    }
}
