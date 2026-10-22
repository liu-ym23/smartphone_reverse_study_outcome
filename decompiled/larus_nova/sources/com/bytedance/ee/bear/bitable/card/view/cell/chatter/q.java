package com.bytedance.ee.bear.bitable.card.view.cell.chatter;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f207616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f207617b;

    public q(View.OnClickListener r100, s r101) {
        this.f207616a = r100;
        this.f207617b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        View.OnClickListener r101 = this.f207616a;
        if (r101 == null) goto L5;
        r101.onClick(r100);
    L5:
        this.f207617b.v("add");
    }
}
