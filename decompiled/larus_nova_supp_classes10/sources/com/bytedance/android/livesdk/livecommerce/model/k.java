package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class k implements am3.c<ECV2InteractionData.ElementBlank> {
    public k() {
    }

    public static ECV2InteractionData.ElementBlank a(am3.g r5) throws Exception {
        ECV2InteractionData.ElementBlank r0 = new ECV2InteractionData.ElementBlank();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.width = (int) r5.j();
        goto L3
    L7:
        am3.h.e(r5);
        goto L3
    L9:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
