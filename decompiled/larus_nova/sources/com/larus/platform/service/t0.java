package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public final class t0 implements com.larus.platform.api.o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t0 f365805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365806b = null;

    public t0() {
    }

    static {
        f365805a = new t0();
        f365806b = LazyKt.lazy(new s0());
    }

    @Override // com.larus.platform.api.o2
    public final void a() {
        com.larus.platform.api.o2 r100 = (com.larus.platform.api.o2) f365806b.getValue();
        if (r100 == null) goto L6;
        r100.a();
        return;
    }
}
