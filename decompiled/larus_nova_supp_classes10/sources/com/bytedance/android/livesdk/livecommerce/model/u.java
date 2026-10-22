package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u implements am3.c<ECV2InteractionData.ListAction> {
    public u() {
    }

    public static ECV2InteractionData.ListAction a(am3.g r5) throws Exception {
        ECV2InteractionData.ListAction r0 = new ECV2InteractionData.ListAction();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.actionType = Long.valueOf(r5.j());
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.bizAction = i.a(r5);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.jumpAction = t.a(r5);
        goto L3
    L11:
        am3.h.e(r5);
        goto L3
    L15:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
