package com.bytedance.lark.base.open.pkm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7226a = null;

    static {
        f7226a = new b();
    }

    public b() {
    }

    public final Object a(RustBuffer.ByValue r2) {
        Intrinsics.checkNotNullParameter(r2, "error_buf");
        RustBuffer.Companion.getClass();
        RustBuffer.a.c(r2);
        UnhandledException r3 = new UnhandledException("Unexpected CALL_ERROR");
        Intrinsics.checkNotNullParameter(r3, "e");
        return r3;
    }
}
