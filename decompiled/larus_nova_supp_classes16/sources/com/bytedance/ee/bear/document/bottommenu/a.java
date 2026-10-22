package com.bytedance.ee.bear.document.bottommenu;

import android.view.View;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ BottomMenuPlugin a;
    public final /* synthetic */ m b;
    public final /* synthetic */ BottomMenuData.Item c;

    public a(BottomMenuPlugin r1, m r2, BottomMenuData.Item r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        BottomMenuPlugin.access$handleResult(this.a, this.b, this.c.getId());
    }
}
