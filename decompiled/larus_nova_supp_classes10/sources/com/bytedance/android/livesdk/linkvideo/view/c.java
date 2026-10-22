package com.bytedance.android.livesdk.linkvideo.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ AnchorLinkVideoListViewHolder a;
    public final /* synthetic */ gf2.a b;
    public final /* synthetic */ gf2.a c;

    public c(AnchorLinkVideoListViewHolder r1, gf2.a r2, gf2.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        AnchorLinkVideoListViewHolder.T3(this.a, this.b, this.c);
    }
}
