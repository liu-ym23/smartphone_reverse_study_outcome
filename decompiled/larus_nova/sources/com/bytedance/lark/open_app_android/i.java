package com.bytedance.lark.open_app_android;

import kotlin.jvm.internal.Intrinsics;
import open_app.proto.FuncErrorX9757bb2a5952da86;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f253433a = null;

    static {
        f253433a = new i();
    }

    public i() {
    }

    public final Object a(RustBuffer.ByValue r100) {
        Intrinsics.checkNotNullParameter(r100, "error_buf");
        RustBuffer.Companion.getClass();
        byte[] r101 = RustBuffer.a.b(r100);
        open_app.proto.OpenAppFfiError r102 = FuncErrorX9757bb2a5952da86.ADAPTER.decode(r101).err;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        return new OpenAppFfiError(r102.error_msg, r102.error_code.intValue());
    }
}
