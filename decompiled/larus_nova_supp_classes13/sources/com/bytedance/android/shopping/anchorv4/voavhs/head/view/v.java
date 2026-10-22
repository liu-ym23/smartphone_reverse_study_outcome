package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class v implements View.OnClickListener {
    public final /* synthetic */ AnchorV4VideoView a;

    public v(AnchorV4VideoView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        PlayerBlock r4 = this.a.d;
        if (r4 == null) goto L6;
        PlayerBlock.o(r4, false, 3);
        return;
    }
}
