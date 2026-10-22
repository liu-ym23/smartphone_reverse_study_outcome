package com.bytedance.ee.bear.document.associateddocs.view;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.NetService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ AssociatedActionSheetPanel a;
    public final /* synthetic */ NetService b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ String d;

    public e(AssociatedActionSheetPanel r1, NetService r2, Context r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        AssociatedActionSheetPanel.a(this.a, this.b, this.c, this.d, "Create_Associated");
        AssociatedActionSheetPanel r8 = this.a;
        Context r0 = this.c;
        l r1 = new l("", "click_create_docs_entrance", "ccm_docs_page_view", "add_docs");
        r8.getClass();
        AssociatedActionSheetPanel.d(r0, r1);
    }
}
