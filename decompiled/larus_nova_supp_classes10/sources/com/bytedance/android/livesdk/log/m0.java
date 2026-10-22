package com.bytedance.android.livesdk.log;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m0 {
    public final Map<String, String> a;

    public m0() {
        this.a = new HashMap();
    }

    public final void c(Map r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L9;
        ((HashMap) this.a).putAll(r2);
        return;
    }

    public final void a(com.bytedance.android.livesdk.log.filter.o r6, String... r7) {
        if (r7.length < 1) goto L8;
        int r0 = r7.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L10;
        String r2 = r7[r1];
        Map<String, String> r3 = this.a;
        HashMap r4 = (HashMap) r3;
        r4.put(r2, l0.a(r2, r6));
        r1 = r1 + 1;
        goto L6
    L10:
        return;
    }

    public final void b(String r2, String r3) {
        ((HashMap) this.a).put(r2, r3);
    }
}
