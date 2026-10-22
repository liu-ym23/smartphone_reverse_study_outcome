package com.bytedance.ee.bear.bitable.superagent;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ BitableSuperAgentPanel a;

    public k(BitableSuperAgentPanel r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        tt5.a.h(this.a.t, "onInputClick");
        r3.requestFocus();
        rcb.c.h(r3, null);
    }
}
