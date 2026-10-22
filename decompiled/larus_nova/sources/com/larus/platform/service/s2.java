package com.larus.platform.service;

import com.larus.platform.api.b4;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class s2 implements com.larus.platform.api.u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s2 f365801a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365802b = null;

    public s2() {
    }

    static {
        f365801a = new s2();
        f365802b = LazyKt.lazy(new r2());
    }

    @Override // com.larus.platform.api.u3
    public final b4 a(mr9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        com.larus.platform.api.u3 r101 = (com.larus.platform.api.u3) f365802b.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.a(r100);
    }

    @Override // com.larus.platform.api.u3
    public final b4 b(mr9.j r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        com.larus.platform.api.u3 r101 = (com.larus.platform.api.u3) f365802b.getValue();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.b(r100);
    }
}
