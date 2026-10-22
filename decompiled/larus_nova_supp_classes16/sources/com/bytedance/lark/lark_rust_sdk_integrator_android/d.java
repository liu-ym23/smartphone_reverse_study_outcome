package com.bytedance.lark.lark_rust_sdk_integrator_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final UnhandledException a(RustBuffer.ByValue r2) {
        Intrinsics.checkNotNullParameter(r2, "error_buf");
        RustBuffer.Companion.getClass();
        RustBuffer.a.c(r2);
        UnhandledException r3 = new UnhandledException("Unexpected CALL_ERROR");
        Intrinsics.checkNotNullParameter(r3, "e");
        return r3;
    }
}
