package com.bytedance.lark.base.open.pkm;

import kotlin.jvm.internal.Intrinsics;
import open_pkm.proto.FuncErrorX38c51c3b789fecb4;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f252903a = null;

    static {
        f252903a = new i();
    }

    public i() {
    }

    public final Object a(RustBuffer.ByValue r100) {
        Intrinsics.checkNotNullParameter(r100, "error_buf");
        RustBuffer.Companion.getClass();
        byte[] r101 = RustBuffer.a.b(r100);
        open_pkm.proto.PkmError r102 = FuncErrorX38c51c3b789fecb4.ADAPTER.decode(r101).err;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r102.network == null) goto L6;
        return new PkmErrorNetwork(r102.network);
    L6:
        if (r102.disk == null) goto L9;
        return new PkmErrorDisk(r102.disk);
    L9:
        if (r102.data == null) goto L13;
        return new PkmErrorData(r102.data);
    L13:
        throw new UnhandledException("Unable to determine the [PkmError] variant");
    }
}
