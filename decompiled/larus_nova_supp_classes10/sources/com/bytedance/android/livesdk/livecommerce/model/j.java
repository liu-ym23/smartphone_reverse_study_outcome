package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements am3.c<ECV2InteractionData.ElementAvatar> {
    public j() {
    }

    public static ECV2InteractionData.ElementAvatar a(am3.g r5) throws Exception {
        ECV2InteractionData.ElementAvatar r0 = new ECV2InteractionData.ElementAvatar();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.image = z.a(r5);
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
