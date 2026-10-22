package com.larus.platform.service;

import com.larus.platform.api.n2;
import kotlin.Lazy;
import kotlin.LazyKt;
import q97.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class n0 implements com.larus.platform.api.m2 {
    public static final n0 a = null;
    public static final Lazy b = null;

    public n0() {
    }

    static {
        a = new n0();
        b = LazyKt.lazy(new m0());
    }

    @Override // com.larus.platform.api.m2
    public final a a() {
        com.larus.platform.api.m2 r0 = (com.larus.platform.api.m2) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    @Override // com.larus.platform.api.m2
    public final boolean b() {
        com.larus.platform.api.m2 r0 = (com.larus.platform.api.m2) b.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.m2
    public final n2 c() {
        com.larus.platform.api.m2 r0 = (com.larus.platform.api.m2) b.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }
}
