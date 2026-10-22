package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m implements am3.c<ECV2InteractionData.ElementImage> {
    public m() {
    }

    public static ECV2InteractionData.ElementImage a(am3.g r5) throws Exception {
        ECV2InteractionData.ElementImage r0 = new ECV2InteractionData.ElementImage();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L12;
        if (r3 != 1) goto L8;
        r0.image = z.a(r5);
        goto L3
    L8:
        if (r3 != 2) goto L9;
        r0.bubble = l.a(r5);
        goto L3
    L9:
        am3.h.e(r5);
        goto L3
    L12:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
