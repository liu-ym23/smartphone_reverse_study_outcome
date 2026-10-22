package com.bytedance.ee.bear.document.bottommenu;

import android.view.View;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ BottomMenuPlugin a;
    public final /* synthetic */ m b;

    public c(BottomMenuPlugin r1, m r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        BottomMenuPlugin.access$handleResult(this.a, this.b, "Cancel");
    }
}
