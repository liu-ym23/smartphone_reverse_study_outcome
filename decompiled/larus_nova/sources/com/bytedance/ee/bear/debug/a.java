package com.bytedance.ee.bear.debug;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppendParamsActivity.ParamsAdapter f217362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppendParamsActivity.b f217363b;

    public a(AppendParamsActivity.ParamsAdapter r100, AppendParamsActivity.b r101) {
        this.f217362a = r100;
        this.f217363b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f217362a.getData().remove(this.f217363b);
        this.f217362a.notifyDataSetChanged();
    }
}
