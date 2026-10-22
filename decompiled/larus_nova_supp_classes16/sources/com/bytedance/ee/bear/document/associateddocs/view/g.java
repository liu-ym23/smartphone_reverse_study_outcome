package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ AssociatedActionSheetPanel a;
    public final /* synthetic */ NetService b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ String d;

    public g(AssociatedActionSheetPanel r1, NetService r2, Context r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        AssociatedActionSheetPanel.a(this.a, this.b, this.c, this.d, "Cancel");
    }
}
