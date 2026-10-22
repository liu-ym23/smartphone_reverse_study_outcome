package com.bytedance.ee.bear.bitable.panel;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitablePanelFragment f214838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BitablePanelModel f214839b;

    public a(BitablePanelFragment r100, BitablePanelModel r101) {
        this.f214838a = r100;
        this.f214839b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        m r101 = this.f214838a.N;
        if (r101 == null) goto L11;
        BitablePanelItem r102 = this.f214839b.getBottomFixedData();
        if (r102 == null) goto L8;
        String r103 = r102.getId();
        if (r103 == null) goto L8;
    L9:
        r101.a(r103);
        return;
    L8:
        r103 = "";
        goto L9
    }
}
