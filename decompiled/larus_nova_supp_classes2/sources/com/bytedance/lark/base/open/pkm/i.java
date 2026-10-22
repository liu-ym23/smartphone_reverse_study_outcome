package com.bytedance.lark.base.open.pkm;

import kotlin.jvm.internal.Intrinsics;
import open_pkm.proto.FuncErrorX38c51c3b789fecb4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f7234a = null;

    static {
        f7234a = new i();
    }

    public i() {
    }

    public final Object a(RustBuffer.ByValue r2) {
        Intrinsics.checkNotNullParameter(r2, "error_buf");
        RustBuffer.Companion.getClass();
        byte[] r3 = RustBuffer.a.b(r2);
        open_pkm.proto.PkmError r4 = ((FuncErrorX38c51c3b789fecb4) FuncErrorX38c51c3b789fecb4.ADAPTER.decode(r3)).err;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.network == null) goto L6;
        return new PkmErrorNetwork(r4.network);
    L6:
        if (r4.disk == null) goto L9;
        return new PkmErrorDisk(r4.disk);
    L9:
        if (r4.data == null) goto L13;
        return new PkmErrorData(r4.data);
    L13:
        throw new UnhandledException("Unable to determine the [PkmError] variant");
    }
}
