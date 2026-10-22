package com.bytedance.ee.bear.office.list.selectpanel;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSelectPanelAdapter.ActionViewHolder f236011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f236012b;

    public a(OfficeSelectPanelAdapter.ActionViewHolder r100, d r101) {
        this.f236011a = r100;
        this.f236012b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f236011a.f235958a.invoke(this.f236012b);
    }
}
