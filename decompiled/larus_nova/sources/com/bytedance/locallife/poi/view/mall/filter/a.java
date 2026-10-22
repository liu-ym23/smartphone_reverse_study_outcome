package com.bytedance.locallife.poi.view.mall.filter;

import android.view.View;
import com.bytedance.locallife.poi.view.mall.model.MallFilterStruct;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PoiMallFilterItemViewHolder f264262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MallFilterStruct f264263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f264264c;

    public a(PoiMallFilterItemViewHolder r100, MallFilterStruct r101, int r102) {
        this.f264262a = r100;
        this.f264263b = r101;
        this.f264264c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PoiMallFilterItemViewHolder.a r101 = this.f264262a.f264240b;
        if (r101 == null) goto L6;
        r101.j2(r100, this.f264263b, this.f264264c);
        return;
    }
}
