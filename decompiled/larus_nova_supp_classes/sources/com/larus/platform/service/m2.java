package com.larus.platform.service;

import com.larus.platform.api.h3;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class m2 implements h3 {
    public static final m2 a = null;
    public static final Lazy b = null;

    public m2() {
    }

    static {
        a = new m2();
        b = LazyKt.lazy(new l2());
    }

    @Override // com.larus.platform.api.h3
    public final boolean a() {
        h3 r0 = (h3) b.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a();
    }
}
