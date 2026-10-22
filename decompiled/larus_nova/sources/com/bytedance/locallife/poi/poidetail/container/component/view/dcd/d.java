package com.bytedance.locallife.poi.poidetail.container.component.view.dcd;

import android.view.View;
import com.bytedance.locallife.common.utils.g;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f263825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PoiExpDcdProductWidget f263826b;

    public d(View r100, PoiExpDcdProductWidget r101) {
        this.f263825a = r100;
        this.f263826b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (g.a(this.f263825a) == false) goto L5;
        return;
    L5:
        PoiExpDcdProductWidget r101 = this.f263826b;
        int r102 = PoiExpDcdProductWidget.f263800j;
        r101.d("click_more");
    }
}
