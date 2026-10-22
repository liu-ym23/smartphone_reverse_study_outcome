package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements am3.c<ECV2InteractionData.ElementLoopText> {
    public n() {
    }

    public static ECV2InteractionData.ElementLoopText a(am3.g r5) throws Exception {
        ECV2InteractionData.ElementLoopText r0 = new ECV2InteractionData.ElementLoopText();
        r0.loopText = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L21;
        if (r3 != 1) goto L8;
        r0.loopText.add(am3.h.c(r5));
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.textColor = am3.h.c(r5);
        goto L3
    L10:
        if (r3 != 3) goto L12;
        r0.textSize = (int) r5.j();
        goto L3
    L12:
        if (r3 != 4) goto L14;
        r0.bold = am3.h.a(r5);
        goto L3
    L14:
        if (r3 != 5) goto L15;
        r0.animGap = r5.j();
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
