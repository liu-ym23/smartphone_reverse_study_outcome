package com.bytedance.ee.bear.drive.biz.preview.more;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ a95.a b;

    public g(b r1, a95.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        b.a(this.a, new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(null), this.b);
    }
}
