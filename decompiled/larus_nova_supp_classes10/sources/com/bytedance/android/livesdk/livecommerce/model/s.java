package com.bytedance.android.livesdk.livecommerce.model;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements am3.c<ECV2InteractionData.InteractionElement> {
    public s() {
    }

    public static ECV2InteractionData.InteractionElement a(am3.g r5) throws Exception {
        ECV2InteractionData.InteractionElement r0 = new ECV2InteractionData.InteractionElement();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L28;
        if (r3 != 20) goto L8;
        r0.elementTextV2 = o.a(r5);
        goto L3
    L8:
        if (r3 != 21) goto L10;
        r0.elementBlank = k.a(r5);
        goto L3
    L10:
        if (r3 != 23) goto L12;
        r0.elementAvatar = j.a(r5);
        goto L3
    L12:
        if (r3 != 24) goto L14;
        r0.elementImage = m.a(r5);
        goto L3
    L14:
        if (r3 != 29) goto L15;
        r0.elementLoopText = n.a(r5);
        goto L3
    L15:
        switch(r3) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            default: goto L16;
        };
    L17:
        r0.textSize = Integer.valueOf(r5.i());
        goto L3
    L18:
        r0.blankWidth = r5.i();
        goto L3
    L19:
        r0.avatars = p.a(r5);
        goto L3
    L20:
        r0.textColor = am3.h.c(r5);
        goto L3
    L21:
        r0.text = am3.h.c(r5);
        goto L3
    L22:
        r0.elementType = r5.i();
        goto L3
    L16:
        am3.h.e(r5);
        goto L3
    L28:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
