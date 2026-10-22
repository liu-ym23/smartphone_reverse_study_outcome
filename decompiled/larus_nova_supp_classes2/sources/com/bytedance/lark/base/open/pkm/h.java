package com.bytedance.lark.base.open.pkm;

import com.squareup.wire.ProtoAdapter;
import com.sun.jna.Pointer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import open_pkm.proto.FuncParamsX9f2014e8c57b1e23;
import open_pkm.proto.FuncReturnX8f13730e4623857f;
import open_pkm.proto.MoltenFfiInstanceMsg;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class h {
    public static final j a(String r11) throws PkmError {
        Intrinsics.checkNotNullParameter(r11, "userId");
        i r0 = i.f7234a;
        NativeLib.Companion r1 = NativeLib.Companion;
        String r4 = null;
        e r2 = new e(null, "buildPkmManager");
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "info");
        FuncParamsX9f2014e8c57b1e23 r3 = new FuncParamsX9f2014e8c57b1e23(r11, null);
        int r12 = FuncParamsX9f2014e8c57b1e23.ADAPTER.encodedSize(r3);
        if (r12 <= 0) goto L5;
        RustBuffer.Companion.getClass();
        RustBuffer.ByValue r13 = RustBuffer.a.a(r12);
        Pointer r5 = r13.data;
        Intrinsics.checkNotNull(r5);
        f r6 = new f(r5);
        r3.encode(r6);
        r6.close();
    L6:
        BufferCallStatus.ByValue r14 = NativeLib.Companion.a().molten_ffi_open_pkm_call(NativeLib.Companion.b(), new Pointer(0), -802857189623356933L, r13);
        int r7 = r14.code;
        if (r7 != 0) goto L11;
        RustBuffer.ByValue r15 = r14.data;
        ProtoAdapter r8 = FuncReturnX8f13730e4623857f.ADAPTER;
        RustBuffer.Companion.getClass();
        Long r16 = ((FuncReturnX8f13730e4623857f) r8.decode(RustBuffer.a.b(r15))).ret;
        Intrinsics.checkNotNull(r16);
        return new j(new Pointer(r16.longValue()));
    L11:
        if (r7 == 1) goto L33;
        if (r7 != 2) goto L30;
        RustBuffer.ByValue r9 = r14.data;
        int r10 = r9.len;
        if (r10 > 0) goto L34;
        b r17 = b.f7226a;
        UnhandledException r18 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r18, "e");
        throw r18;
    L34:
        Pointer r19 = r9.data;     // Catch: Throwable -> L25
        if (r19 == null) goto L19;
        byte[] r20 = r19.getByteArray(0, r10);     // Catch: Throwable -> L25
    L20:
        if (r20 == null) goto L22;
        r4 = new String(r20, Charsets.UTF_8);     // Catch: Throwable -> L25
    L22:
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L25
        RustBuffer.a r21 = RustBuffer.Companion;
        RustBuffer.ByValue r110 = r14.data;
        r21.getClass();
        RustBuffer.a.c(r110);
        b r111 = b.f7226a;
        UnhandledException r112 = new UnhandledException(r4);
        Intrinsics.checkNotNullParameter(r112, "e");
        throw r112;
    L19:
        r20 = null;
    L25:
        th = move-exception;
        RustBuffer.a r22 = RustBuffer.Companion;
        RustBuffer.ByValue r113 = r14.data;
        r22.getClass();
        RustBuffer.a.c(r113);
        throw th;
    L30:
        b r23 = b.f7226a;
        UnhandledException r24 = new UnhandledException("Unknown rust call status: " + r14 + ".code");
        Intrinsics.checkNotNullParameter(r24, "e");
        throw r24;
    L33:
        throw ((Throwable) r0.a(r14.data));
    L5:
        RustBuffer.Companion.getClass();
        r13 = RustBuffer.a.a(0);
        goto L6
    }

    public static final MoltenFfiInstanceMsg b(c r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = d.f7227b;
        Intrinsics.checkNotNullParameter(r5, "callback");
        d r1 = new d(r5);
        a r6 = a.f7223a;
        Intrinsics.checkNotNullParameter(r1, "cb");
        monitor-enter(r6);
        long r2 = a.f7224b.incrementAndGet();     // Catch: Throwable -> L8
        Long r3 = Long.valueOf(r2);     // Catch: Throwable -> L8
        a.f7225c.put(r3, r1);     // Catch: Throwable -> L8
        monitor-exit(r6);
        return new MoltenFfiInstanceMsg(8880753289804720508L, Long.valueOf(r2));
    L8:
        th = move-exception;
        throw th;
    }
}
