package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements am3.c<ECV2InteractionData.MessageProduct> {
    public w() {
    }

    public static ECV2InteractionData.MessageProduct a(am3.g r5) throws Exception {
        ECV2InteractionData.MessageProduct r0 = new ECV2InteractionData.MessageProduct();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L15;
        if (r3 != 1) goto L8;
        r0.cover = x.a(r5);
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.showIndex = am3.h.a(r5);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.index = r5.i();
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
