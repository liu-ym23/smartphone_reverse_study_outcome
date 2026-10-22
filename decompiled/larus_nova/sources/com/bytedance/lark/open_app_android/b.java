package com.bytedance.lark.open_app_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f253419a = null;

    static {
        f253419a = new b();
    }

    public b() {
    }

    public final Object a(RustBuffer.ByValue r100) {
        Intrinsics.checkNotNullParameter(r100, "error_buf");
        RustBuffer.Companion.getClass();
        RustBuffer.a.c(r100);
        UnhandledException r101 = new UnhandledException("Unexpected CALL_ERROR");
        Intrinsics.checkNotNullParameter(r101, "e");
        return r101;
    }
}
