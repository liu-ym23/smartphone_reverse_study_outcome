package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;
import lark_bitable.proto.FuncErrorX529049160a731337;

/* JADX INFO: loaded from: classes43.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p0 f253100a = null;

    static {
        f253100a = new p0();
    }

    public p0() {
    }

    public final Object a(RustBuffer.ByValue r100) {
        Intrinsics.checkNotNullParameter(r100, "error_buf");
        RustBuffer.Companion.getClass();
        byte[] r101 = RustBuffer.a.b(r100);
        lark_bitable.proto.ModelError r102 = FuncErrorX529049160a731337.ADAPTER.decode(r101).err;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        return new ModelError(r102.code.longValue(), r102.msg);
    }
}
