package com.bytedance.lark.open_app_android;

import com.squareup.wire.ProtoAdapter;
import com.sun.jna.Pointer;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import open_app.proto.FileStat;
import open_app.proto.FuncParamsXf1672a73e1398765;
import open_app.proto.FuncReturnX24f00c44e39a7f53;
import open_app.proto.MoltenFfiInstanceMsg;

/* JADX INFO: loaded from: classes19.dex */
public final class j {
    public static final c a(String r110) throws OpenAppFfiError {
        Intrinsics.checkNotNullParameter(r110, "filePath");
        i r100 = i.f253433a;
        NativeLib.Companion r101 = NativeLib.Companion;
        String r102 = null;
        f r103 = new f(null, "getFileStat");
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, "info");
        FuncParamsXf1672a73e1398765 r104 = new FuncParamsXf1672a73e1398765(r110, null);
        int r111 = FuncParamsXf1672a73e1398765.ADAPTER.encodedSize(r104);
        if (r111 <= 0) goto L5;
        RustBuffer.Companion.getClass();
        RustBuffer.ByValue r112 = RustBuffer.a.a(r111);
        Pointer r105 = r112.data;
        Intrinsics.checkNotNull(r105);
        g r106 = new g(r105);
        r104.encode(r106);
        r106.close();
    L6:
        BufferCallStatus.ByValue r113 = NativeLib.Companion.a().molten_ffi_open_app_call(NativeLib.Companion.f253409c.getValue(), new Pointer(0), 5896607694723190884L, r112);
        int r107 = r113.code;
        if (r107 != 0) goto L11;
        RustBuffer.ByValue r114 = r113.data;
        ProtoAdapter<FuncReturnX24f00c44e39a7f53> r108 = FuncReturnX24f00c44e39a7f53.ADAPTER;
        RustBuffer.Companion.getClass();
        FileStat r115 = r108.decode(RustBuffer.a.b(r114)).ret;
        Intrinsics.checkNotNull(r115);
        Intrinsics.checkNotNullParameter(r115, "<this>");
        return new c(UInt.m9544constructorimpl(r115.mode.intValue()), ULong.m9623constructorimpl(r115.size.longValue()), ULong.m9623constructorimpl(r115.last_accessed_time.longValue()), ULong.m9623constructorimpl(r115.last_modified_time.longValue()));
    L11:
        if (r107 == 1) goto L33;
        if (r107 != 2) goto L30;
        RustBuffer.ByValue r109 = r113.data;
        int r116 = r109.len;
        if (r116 > 0) goto L34;
        b r117 = b.f253419a;
        UnhandledException r118 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r118, "e");
        throw r118;
    L34:
        Pointer r119 = r109.data;     // Catch: Throwable -> L25
        if (r119 == null) goto L19;
        byte[] r120 = r119.getByteArray(0, r116);     // Catch: Throwable -> L25
    L20:
        if (r120 == null) goto L22;
        r102 = new String(r120, Charsets.UTF_8);     // Catch: Throwable -> L25
    L22:
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L25
        RustBuffer.a r121 = RustBuffer.Companion;
        RustBuffer.ByValue r122 = r113.data;
        r121.getClass();
        RustBuffer.a.c(r122);
        b r123 = b.f253419a;
        UnhandledException r124 = new UnhandledException(r102);
        Intrinsics.checkNotNullParameter(r124, "e");
        throw r124;
    L19:
        r120 = null;
    L25:
        th = move-exception;
        RustBuffer.a r125 = RustBuffer.Companion;
        RustBuffer.ByValue r126 = r113.data;
        r125.getClass();
        RustBuffer.a.c(r126);
        throw th;
    L30:
        b r127 = b.f253419a;
        UnhandledException r128 = new UnhandledException("Unknown rust call status: " + r113 + ".code");
        Intrinsics.checkNotNullParameter(r128, "e");
        throw r128;
    L33:
        throw ((Throwable) r100.a(r113.data));
    L5:
        RustBuffer.Companion.getClass();
        r112 = RustBuffer.a.a(0);
        goto L6
    }

    public static final MoltenFfiInstanceMsg b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = e.f253424b;
        Intrinsics.checkNotNullParameter(r100, "callback");
        e r102 = new e(r100);
        a r103 = a.f253416a;
        Intrinsics.checkNotNullParameter(r102, "cb");
        monitor-enter(r103);
        long r104 = a.f253417b.incrementAndGet();     // Catch: Throwable -> L8
        Long r105 = Long.valueOf(r104);     // Catch: Throwable -> L8
        a.f253418c.put(r105, r102);     // Catch: Throwable -> L8
        monitor-exit(r103);
        return new MoltenFfiInstanceMsg(-8356417133374527695L, Long.valueOf(r104));
    L8:
        th = move-exception;
        throw th;
    }
}
