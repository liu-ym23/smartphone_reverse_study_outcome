package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public final class i implements com.larus.platform.api.o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f365746a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365747b = null;

    public i() {
    }

    static {
        f365746a = new i();
        f365747b = LazyKt.lazy(new h());
    }

    @Override // com.larus.platform.api.o1
    public final boolean a() {
        com.larus.platform.api.o1 r100 = (com.larus.platform.api.o1) f365747b.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.o1
    public final int b() {
        com.larus.platform.api.o1 r100 = (com.larus.platform.api.o1) f365747b.getValue();
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.b();
    }
}
