package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f263200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiCoiSingleFeedCard f263201b;

    public r(PoiCoiImageView r100, PoiCoiSingleFeedCard r101) {
        this.f263200a = r100;
        this.f263201b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (com.bytedance.locallife.common.utils.g.a(this.f263200a) == false) goto L5;
        return;
    L5:
        PoiCoiSingleFeedCard r101 = this.f263201b;
        r101.d0(r101.getEnterDetail(), "coi_pic");
    }
}
