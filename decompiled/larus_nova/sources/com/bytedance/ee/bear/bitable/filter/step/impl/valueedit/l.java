package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkFilterValueEditViewHolder f212001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f212002b;

    public l(LinkFilterValueEditViewHolder r100, String r101) {
        this.f212001a = r100;
        this.f212002b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LinkFilterValueEditViewHolder r101 = this.f212001a;
        String r102 = this.f212002b;
        int r103 = LinkFilterValueEditViewHolder.f211945v;
        r101.s(r102);
    }
}
