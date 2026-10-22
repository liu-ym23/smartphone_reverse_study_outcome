package com.volcengine.zeus.service.server;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public final a<String, String> a;

    public b() {
        this.a = new a();
    }

    public final void a(String r3, String r4) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return;
    L8:
        if (((HashMap) this.a.a).containsKey(r3) == false) goto L13;
        a<String, String> r0 = this.a;
        Object r1 = ((HashMap) r0.a).remove(r3);
        if (r1 == null) goto L13;
        ((HashMap) r0.b).remove(r1);
    L13:
        if (((HashMap) this.a.b).containsKey(r4) == false) goto L17;
        a<String, String> r2 = this.a;
        Object r5 = ((HashMap) r2.b).remove(r4);
        if (r5 == null) goto L17;
        ((HashMap) r2.a).remove(r5);
    L17:
        a<String, String> r6 = this.a;
        if (((HashMap) r6.a).containsKey(r3) == true) goto L26;
        if (((HashMap) r6.b).containsKey(r4) == true) goto L24;
        ((HashMap) r6.a).put(r3, r4);
        ((HashMap) r6.b).put(r4, r3);
        return;
    L24:
        throw new IllegalArgumentException("Value已存在：" + r4);
    L26:
        throw new IllegalArgumentException("Key已存在：" + r3);
    }
}
