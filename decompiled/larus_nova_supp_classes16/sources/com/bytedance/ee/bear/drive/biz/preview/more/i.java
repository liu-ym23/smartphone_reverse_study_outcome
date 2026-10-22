package com.bytedance.ee.bear.drive.biz.preview.more;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ b a;

    public i(b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        b.b(this.a, new com.bytedance.ee.bear.contract.drive.sdk.entity.menu.d(null));
    }
}
