package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f253114a = null;

    static {
        f253114a = new s();
    }

    public s() {
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
