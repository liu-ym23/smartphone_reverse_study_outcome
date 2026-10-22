package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatterFilterValueEditViewHolder<Object, ChatterFilterValueEditViewHolder.ChatterListResult<Object>> f211986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f211987b;

    public c(ChatterFilterValueEditViewHolder<Object, ChatterFilterValueEditViewHolder.ChatterListResult<Object>> r100, String r101) {
        this.f211986a = r100;
        this.f211987b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ChatterFilterValueEditViewHolder<Object, ChatterFilterValueEditViewHolder.ChatterListResult<Object>> r101 = this.f211986a;
        String r102 = this.f211987b;
        int r103 = ChatterFilterValueEditViewHolder.f211911z;
        r101.t(r102);
    }
}
