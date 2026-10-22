package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ KtvOpusOrderSongButton a;

    public y(KtvOpusOrderSongButton r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        List r3 = (List) r2;
        KtvOpusOrderSongButton r4 = this.a;
        KtvContext r0 = r4.d;
        if (r0 == null) goto L5;
        int r1 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.e(r0);
    L6:
        r4.U5(r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }
}
