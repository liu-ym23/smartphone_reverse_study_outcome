package com.bytedance.lark.ccm_nexus_android;

import ccm_nexus.proto.MoltenFfiInstanceMsg;
import com.sun.jna.Pointer;
import java.io.OutputStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
public final class g {
    public static final MoltenFfiInstanceMsg b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = f.f252913b;
        Intrinsics.checkNotNullParameter(r100, "callback");
        f r102 = new f(r100);
        a r103 = a.f252910a;
        Intrinsics.checkNotNullParameter(r102, "cb");
        monitor-enter(r103);
        long r104 = a.f252911b.incrementAndGet();     // Catch: Throwable -> L8
        Long r105 = Long.valueOf(r104);     // Catch: Throwable -> L8
        a.f252912c.put(r105, r102);     // Catch: Throwable -> L8
        monitor-exit(r103);
        return new MoltenFfiInstanceMsg(1706181995547820430L, Long.valueOf(r104));
    L8:
        th = move-exception;
        throw th;
    }

    public static final RustBuffer.ByValue a(int r100, Function1<? super OutputStream, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "write_block");
        if (r100 <= 0) goto L5;
        RustBuffer.Companion.getClass();
        RustBuffer.ByValue r102 = RustBuffer.a.a(r100);
        Pointer r103 = r102.data;
        Intrinsics.checkNotNull(r103);
        j r104 = new j(r103);
        r101.invoke(r104);
        r104.close();
        return r102;
    L5:
        RustBuffer.Companion.getClass();
        return RustBuffer.a.a(0);
    }
}
