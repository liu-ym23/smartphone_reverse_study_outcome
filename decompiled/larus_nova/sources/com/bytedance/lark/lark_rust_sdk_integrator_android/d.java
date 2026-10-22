package com.bytedance.lark.lark_rust_sdk_integrator_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f253246a = null;

    static {
        f253246a = new d();
    }

    public d() {
    }

    public final UnhandledException a(RustBuffer.ByValue r100) {
        Intrinsics.checkNotNullParameter(r100, "error_buf");
        RustBuffer.Companion.getClass();
        RustBuffer.a.c(r100);
        UnhandledException r101 = new UnhandledException("Unexpected CALL_ERROR");
        Intrinsics.checkNotNullParameter(r101, "e");
        return r101;
    }
}
