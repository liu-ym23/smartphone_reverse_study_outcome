package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.anchor;

import fd2.x;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ KtvComponentAnchorLogicWidget a;

    public n(KtvComponentAnchorLogicWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        x r4 = (x) sh6.c.b((sh6.b) r3);
        if (r4 == null) goto L6;
        KtvComponentAnchorLogicWidget r0 = this.a;
        int r1 = KtvComponentAnchorLogicWidget.q;
        r0.zq(r4);
        return;
    }
}
