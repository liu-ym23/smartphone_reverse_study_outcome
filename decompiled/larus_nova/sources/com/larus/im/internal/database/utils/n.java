package com.larus.im.internal.database.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class n {
    public static final <T> T a(String r100, T r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "block");
        return r102.invoke();
    L5:
        e = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e(r100, "tryCatchSQL error: " + e.getMessage());
        return r101;
    }
}
