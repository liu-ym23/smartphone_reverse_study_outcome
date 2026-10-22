package com.larus.office.base;

import com.larus.abtest.api.IAbTest;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class d0 implements etb.b {
    public d0() {
    }

    @Override // etb.b
    public final <T> T r(String r100, Class<T> r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "tClass");
        return (T) IAbTest.f286085a.r(r100, r101, r102);
    }
}
