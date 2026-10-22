package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ c a;

    public e(c r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        c r4 = this.a;
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m r1 = r0.X1();
        if (r1 == null) goto L9;
        Boolean r5 = (Boolean) r1.getValue();
        if (r5 == null) goto L9;
        boolean r6 = r5.booleanValue();
    L10:
        r4.l(r6);
        return;
    L9:
        r6 = false;
        goto L10
    }
}
