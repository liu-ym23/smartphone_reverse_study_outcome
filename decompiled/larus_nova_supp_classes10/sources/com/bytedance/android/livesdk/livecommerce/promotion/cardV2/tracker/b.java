package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static final String a(List r3, String r4) {
        Iterator r5 = r3.iterator();
    L3:
        String r1 = null;
        if (r5.hasNext() == false) goto L21;
        Map<String, Object> r0 = ((LiveSingleAction) r5.next()).getInfo();
        if (r0 == null) goto L8;
        Object r2 = r0.get(r4);
    L10:
        if ((r2 instanceof String) == true) goto L12;
        r2 = null;
    L12:
        String r6 = (String) r2;
        if (r6 == null) goto L3;
        if (r6.length() <= 0) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
        r1 = r6;
    L20:
        if (r1 == null) goto L3;
    L17:
        r7 = false;
        goto L18
    L8:
        r2 = null;
    L21:
        return r1;
    }
}
