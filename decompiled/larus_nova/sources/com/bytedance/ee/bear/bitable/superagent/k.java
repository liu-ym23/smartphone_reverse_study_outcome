package com.bytedance.ee.bear.bitable.superagent;

import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableSuperAgentPanel f215908a;

    public k(BitableSuperAgentPanel r100) {
        this.f215908a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        tt5.a.h(this.f215908a.f215757t, "onInputClick");
        r100.requestFocus();
        rcb.c.h(r100, null);
    }
}
