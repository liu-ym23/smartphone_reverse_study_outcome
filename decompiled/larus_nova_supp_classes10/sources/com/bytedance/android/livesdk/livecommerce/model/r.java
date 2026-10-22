package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r implements am3.c<ECV2InteractionData.InteractionContent> {
    public r() {
    }

    public static ECV2InteractionData.InteractionContent a(am3.g r10) throws Exception {
        ECV2InteractionData.InteractionContent r0 = new ECV2InteractionData.InteractionContent();
        r0.bgColors = new ArrayList();
        r0.eventParam = new HashMap();
        r0.rows = new ArrayList();
        r0.content = new ArrayList();
        long r1 = r10.c();
    L3:
        int r3 = r10.f();
        if (r3 == (-1)) goto L33;
        switch(r3) {
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        r0.action = u.a(r10);
        goto L3
    L8:
        r0.product = w.a(r10);
        goto L3
    L9:
        r0.bgColors.add(am3.h.c(r10));
        goto L3
    L10:
        r0.rows.add(v.a(r10));
        goto L3
    L11:
        long r5 = r10.c();
        String r4 = null;
        String r7 = null;
    L12:
        int r8 = r10.f();
        if (r8 == (-1)) goto L21;
        if (r8 != 1) goto L17;
        r4 = am3.h.c(r10);
        goto L12
    L17:
        if (r8 != 2) goto L12;
        r7 = am3.h.c(r10);
        goto L12
    L21:
        r10.d(r5);
        if (r4 == null) goto L28;
        if (r7 == null) goto L26;
        r0.eventParam.put(r4, r7);
        goto L3
    L26:
        throw new IllegalStateException("Map value must not be null!");
    L28:
        throw new IllegalStateException("Map key must not be null!");
    L29:
        r0.content.add(s.a(r10));
        goto L3
    L30:
        r0.loopCount = r10.i();
        goto L3
    L31:
        r0.priority = r10.i();
        goto L3
    L32:
        r0.check = q.a(r10);
        goto L3
    L6:
        am3.h.e(r10);
        goto L3
    L33:
        r10.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
