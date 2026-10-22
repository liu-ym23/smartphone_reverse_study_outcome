package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes.dex */
public final class m2 implements com.larus.platform.api.h3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m2 f365764a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365765b = null;

    public m2() {
    }

    static {
        f365764a = new m2();
        f365765b = LazyKt.lazy(new l2());
    }

    @Override // com.larus.platform.api.h3
    public final boolean a() {
        com.larus.platform.api.h3 r100 = (com.larus.platform.api.h3) f365765b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }
}
