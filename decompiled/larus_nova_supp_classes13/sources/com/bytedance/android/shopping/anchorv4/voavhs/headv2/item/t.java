package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ w a;
    public final /* synthetic */ int b;

    public t(w r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        this.a.getHeadAbility().TB(this.b, false);
    }
}
