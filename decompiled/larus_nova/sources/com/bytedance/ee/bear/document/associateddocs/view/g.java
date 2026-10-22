package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AssociatedActionSheetPanel f219069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetService f219070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f219071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f219072d;

    public g(AssociatedActionSheetPanel r100, NetService r101, Context r102, String r103) {
        this.f219069a = r100;
        this.f219070b = r101;
        this.f219071c = r102;
        this.f219072d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AssociatedActionSheetPanel.a(this.f219069a, this.f219070b, this.f219071c, this.f219072d, "Cancel");
    }
}
