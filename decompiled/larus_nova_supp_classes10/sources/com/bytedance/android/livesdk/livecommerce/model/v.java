package com.bytedance.android.livesdk.livecommerce.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class v implements am3.c<ECV2InteractionData.ListTopInteractionRow> {
    public v() {
    }

    public static ECV2InteractionData.ListTopInteractionRow a(am3.g r5) throws Exception {
        ECV2InteractionData.ListTopInteractionRow r0 = new ECV2InteractionData.ListTopInteractionRow();
        r0.content = new ArrayList();
        long r1 = r5.c();
    L3:
        int r3 = r5.f();
        if (r3 == (-1)) goto L9;
        if (r3 != 1) goto L7;
        r0.content.add(s.a(r5));
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
