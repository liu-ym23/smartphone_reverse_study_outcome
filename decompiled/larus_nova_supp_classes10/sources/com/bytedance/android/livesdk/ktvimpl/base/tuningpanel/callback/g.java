package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ j a;

    public g(j r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        ec0.a r2 = this.a.c;
        if (r2 == null) goto L6;
        r2.i();
        return;
    }
}
