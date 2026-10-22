package com.larus.platform.service;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes31.dex */
public final class v0 implements com.larus.platform.api.q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f365814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365815b = null;

    public v0() {
    }

    static {
        f365814a = new v0();
        f365815b = LazyKt.lazy(new u0());
    }

    @Override // com.larus.platform.api.q2
    public final String a() {
        com.larus.platform.api.q2 r100 = (com.larus.platform.api.q2) f365815b.getValue();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.a();
    }

    @Override // com.larus.platform.api.q2
    public final boolean b() {
        com.larus.platform.api.q2 r100 = (com.larus.platform.api.q2) f365815b.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.b() != true) goto L7;
        return true;
    }
}
