package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssociatedActionSheetPanel f219065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetService f219066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f219067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f219068d;

    public f(AssociatedActionSheetPanel r100, NetService r101, Context r102, String r103) {
        this.f219065a = r100;
        this.f219066b = r101;
        this.f219067c = r102;
        this.f219068d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AssociatedActionSheetPanel.a(this.f219065a, this.f219066b, this.f219067c, this.f219068d, "Associated_Exiting");
        AssociatedActionSheetPanel r101 = this.f219065a;
        Context r102 = this.f219067c;
        l r103 = new l("", "click_relation_docs_entrance", "none", "add_docs");
        r101.getClass();
        AssociatedActionSheetPanel.d(r102, r103);
    }
}
