package com.bytedance.android.livesdk.linkvideo.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ AnchorLinkVideoListViewHolder a;
    public final /* synthetic */ gf2.a b;

    public b(AnchorLinkVideoListViewHolder r1, gf2.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        h r4 = this.a.f;
        if (r4 == null) goto L10;
        Long r0 = this.b.b();
        if (r0 == null) goto L7;
        long r1 = r0.longValue();
    L8:
        r4.XJ(r1);
        return;
    L7:
        r1 = 0;
        goto L8
    }
}
