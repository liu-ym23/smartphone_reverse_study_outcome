package com.bytedance.ee.bear.bitable.superagent;

import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements fc5.d {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    @Override // fc5.d
    public final boolean a(String r3) {
        t45.c r0 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.v6(r3);
    }
}
