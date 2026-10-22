package com.bytedance.android.shopping.mall.homepage.card.live;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ NativeLiveCard a;
    public final /* synthetic */ g93.a b;

    public k(NativeLiveCard r1, g93.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        String r4 = this.a.v;
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.b == null) goto L9;
        boolean r0 = !g93.a.a(r4);
        g93.a.b(r4, r0);
        NativeLiveCard r5 = this.a;
        int r1 = NativeLiveCard.Z2;
        r5.l5(r0);
        return;
    }
}
