package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssociatedActionSheetPanel f219061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetService f219062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f219063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f219064d;

    public e(AssociatedActionSheetPanel r100, NetService r101, Context r102, String r103) {
        this.f219061a = r100;
        this.f219062b = r101;
        this.f219063c = r102;
        this.f219064d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AssociatedActionSheetPanel.a(this.f219061a, this.f219062b, this.f219063c, this.f219064d, "Create_Associated");
        AssociatedActionSheetPanel r101 = this.f219061a;
        Context r102 = this.f219063c;
        l r103 = new l("", "click_create_docs_entrance", "ccm_docs_page_view", "add_docs");
        r101.getClass();
        AssociatedActionSheetPanel.d(r102, r103);
    }
}
