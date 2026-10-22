package com.bytedance.ee.bear.document;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class x1 implements View.OnClickListener {
    public final /* synthetic */ DocTipsLayout a;

    public x1(DocTipsLayout r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.t.setVisibility(8);
        this.a.j = true;
    }
}
