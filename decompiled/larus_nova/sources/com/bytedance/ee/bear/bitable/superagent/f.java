package com.bytedance.ee.bear.bitable.superagent;

import com.ss.android.lark.utils.LarkContext;

/* JADX INFO: loaded from: classes16.dex */
public final class f implements fc5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f215890a = null;

    static {
        f215890a = new f();
    }

    public f() {
    }

    @Override // fc5.d
    public final boolean a(String r100) {
        t45.c r101 = (t45.c) e0c.k.a(LarkContext.getApplication(), t45.c.class);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.v6(r100);
    }
}
