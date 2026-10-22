package com.bytedance.lark.ccm_nexus_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f252915a = null;

    static {
        f252915a = new h();
    }

    public h() {
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
