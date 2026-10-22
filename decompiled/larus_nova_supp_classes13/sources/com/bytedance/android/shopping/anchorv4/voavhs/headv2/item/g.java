package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ j a;

    public g(j r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        PlayerBlock r4 = this.a.e;
        if (r4 == null) goto L6;
        PlayerBlock.o(r4, false, 3);
        return;
    }
}
