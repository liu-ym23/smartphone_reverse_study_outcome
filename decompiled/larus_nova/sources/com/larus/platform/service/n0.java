package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes.dex */
public final class n0 implements com.larus.platform.api.m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0 f365775a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365776b = null;

    public n0() {
    }

    static {
        f365775a = new n0();
        f365776b = LazyKt.lazy(new m0());
    }

    @Override // com.larus.platform.api.m2
    public final q97.a a() {
        com.larus.platform.api.m2 r100 = (com.larus.platform.api.m2) f365776b.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.m2
    public final boolean b() {
        com.larus.platform.api.m2 r100 = (com.larus.platform.api.m2) f365776b.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.b() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.m2
    public final com.larus.platform.api.n2 c() {
        com.larus.platform.api.m2 r100 = (com.larus.platform.api.m2) f365776b.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.c();
    }
}
