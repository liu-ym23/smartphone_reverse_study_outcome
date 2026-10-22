package com.bytedance.locallife.poi.newdetail.component;

import android.view.View;

/* JADX INFO: loaded from: classes21.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f263232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiQuickPageBackgroundView f263233b;

    public p(View r100, PoiQuickPageBackgroundView r101) {
        this.f263232a = r100;
        this.f263233b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        if (com.bytedance.locallife.common.utils.g.a(this.f263232a) == false) goto L5;
        return;
    L5:
        PoiQuickPageBackgroundView r100 = this.f263233b;
        PoiQuickPageBackgroundView.f0(r100, r100.S, "click_photo", null, 0, false, false, null, null, null, null, 32760);
    }
}
