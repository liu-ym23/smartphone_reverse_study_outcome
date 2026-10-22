package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m0 implements View.OnClickListener {
    public final /* synthetic */ n a;

    public m0(g r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        this.a.onBackClick();
    }
}
