package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class x1 implements com.larus.platform.api.a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x1 f365857a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365858b = null;

    public x1() {
    }

    static {
        f365857a = new x1();
        f365858b = LazyKt.lazy(new w1());
    }

    @Override // com.larus.platform.api.a3
    public final boolean a() {
        com.larus.platform.api.a3 r100 = (com.larus.platform.api.a3) f365858b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }
}
