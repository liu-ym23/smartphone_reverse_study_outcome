package com.bytedance.android.shopping.feed.resourcecard.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ WindowNodeView a;
    public final /* synthetic */ rd3.a b;

    public p(WindowNodeView r1, rd3.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        WindowNodeView r5 = this.a;
        rd3.a r0 = this.b;
        int r1 = WindowNodeView.l;
        r5.a(r0, "name", null, null);
    }
}
