package com.bytedance.ee.bear.sheet.filter;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements View.OnClickListener {
    public final /* synthetic */ FilterValueAdapter.ViewHolder a;

    public q(FilterValueAdapter.ViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.c.performClick();
    }
}
