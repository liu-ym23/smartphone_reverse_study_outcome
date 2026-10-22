package com.bytedance.ee.bear.debug;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ AppendParamsActivity.ParamsAdapter a;
    public final /* synthetic */ AppendParamsActivity.b b;

    public a(AppendParamsActivity.ParamsAdapter r1, AppendParamsActivity.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.getData().remove(this.b);
        this.a.notifyDataSetChanged();
    }
}
