package com.bytedance.lark.base.open.pkm;

import com.squareup.wire.ProtoAdapter;
import com.sun.jna.Pointer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import open_pkm.proto.FuncParamsX0e798fd943da4743;
import open_pkm.proto.FuncParamsX3897bf48216accb9;
import open_pkm.proto.FuncParamsX4877ab89ad2b2b88;
import open_pkm.proto.FuncParamsXb212c76ad323a577;
import open_pkm.proto.FuncReturnX0bf8b5c665c57f35;
import open_pkm.proto.FuncReturnX3dc8b8542df1cbb1;
import open_pkm.proto.FuncReturnXb05c0e03c1bfe022;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class j extends k {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.lark.base.open.pkm.k
    public final void a() {
        b r0 = b.f7226a;
        NativeLib.Companion.getClass();
        BufferCallStatus.ByValue r1 = NativeLib.Companion.a().molten_ffi_open_pkm_free(NativeLib.Companion.b(), this.f7235a, 8376425728991821824L);
        int r2 = r1.code;
        if (r2 != 0) goto L6;
        return;
    L6:
        if (r2 == 1) goto L28;
        if (r2 != 2) goto L25;
        RustBuffer.ByValue r3 = r1.data;
        int r4 = r3.len;
        if (r4 > 0) goto L29;
        UnhandledException r5 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r5, "e");
        throw r5;
    L29:
        Pointer r6 = r3.data;     // Catch: Throwable -> L20
        String r7 = null;
        if (r6 == null) goto L14;
        byte[] r8 = r6.getByteArray(0, r4);     // Catch: Throwable -> L20
    L15:
        if (r8 == null) goto L17;
        r7 = new String(r8, Charsets.UTF_8);     // Catch: Throwable -> L20
    L17:
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L20
        RustBuffer.a r9 = RustBuffer.Companion;
        RustBuffer.ByValue r10 = r1.data;
        r9.getClass();
        RustBuffer.a.c(r10);
        UnhandledException r11 = new UnhandledException(r7);
        Intrinsics.checkNotNullParameter(r11, "e");
        throw r11;
    L14:
        r8 = null;
    L20:
        th = move-exception;
        RustBuffer.a r12 = RustBuffer.Companion;
        RustBuffer.ByValue r13 = r1.data;
        r12.getClass();
        RustBuffer.a.c(r13);
        throw th;
    L25:
        UnhandledException r14 = new UnhandledException("Unknown rust call status: " + r1 + ".code");
        Intrinsics.checkNotNullParameter(r14, "e");
        throw r14;
    L28:
        throw ((Throwable) r0.a(r1.data));
    }

    public j(Pointer r2) {
        Intrinsics.checkNotNullParameter(r2, "pointer");
        super(r2);
    }

    public final boolean e(PkmBizType r12) throws PkmError {
        Intrinsics.checkNotNullParameter(r12, "bizType");
    L3:
        long r0 = this.f7237c.get();
        if (r0 == 0) goto L54;
        if (r0 == Long.MAX_VALUE) goto L52;
        if (this.f7237c.compareAndSet(r0, 1 + r0) == false) goto L3;
        Pointer r6 = this.f7235a;     // Catch: Throwable -> L12
        i r1 = i.f7234a;     // Catch: Throwable -> L12
        NativeLib.Companion r2 = NativeLib.Companion;     // Catch: Throwable -> L12
        e r4 = new e(Long.valueOf(Pointer.nativeValue(r6)), "jssdkCheckUpdateWithBizType");     // Catch: Throwable -> L12
        r2.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r4, "info");     // Catch: Throwable -> L12
        String r10 = null;
        FuncParamsX0e798fd943da4743 r3 = new FuncParamsX0e798fd943da4743(r12.into(), null);     // Catch: Throwable -> L12
        int r13 = FuncParamsX0e798fd943da4743.ADAPTER.encodedSize(r3);     // Catch: Throwable -> L12
        if (r13 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r14 = RustBuffer.a.a(r13);     // Catch: Throwable -> L12
        Pointer r5 = r14.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L12
        f r7 = new f(r5);     // Catch: Throwable -> L12
        r3.encode(r7);     // Catch: Throwable -> L12
        r7.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r15 = NativeLib.Companion.a().molten_ffi_open_pkm_call(NativeLib.Companion.b(), r6, -1802007860225596071L, r14);     // Catch: Throwable -> L12
        int r8 = r15.code;     // Catch: Throwable -> L12
        if (r8 != 0) goto L24;
        RustBuffer.ByValue r16 = r15.data;     // Catch: Throwable -> L12
        ProtoAdapter r9 = FuncReturnX3dc8b8542df1cbb1.ADAPTER;     // Catch: Throwable -> L12
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        Boolean r17 = ((FuncReturnX3dc8b8542df1cbb1) r9.decode(RustBuffer.a.b(r16))).ret;     // Catch: Throwable -> L12
        if (this.f7237c.decrementAndGet() != 0) goto L22;
        a();
    L22:
        return r17.booleanValue();
    L24:
        if (r8 == 1) goto L46;
        if (r8 != 2) goto L43;
        RustBuffer.ByValue r11 = r15.data;     // Catch: Throwable -> L12
        int r18 = r11.len;     // Catch: Throwable -> L12
        if (r18 > 0) goto L55;
        b r19 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r110 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r110, "e");     // Catch: Throwable -> L12
        throw r110;     // Catch: Throwable -> L12
    L55:
        Pointer r20 = r11.data;     // Catch: Throwable -> L38
        if (r20 == null) goto L32;
        byte[] r21 = r20.getByteArray(0, r18);     // Catch: Throwable -> L38
    L33:
        if (r21 == null) goto L35;
        r10 = new String(r21, Charsets.UTF_8);     // Catch: Throwable -> L38
    L35:
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L38
        RustBuffer.a r22 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r111 = r15.data;     // Catch: Throwable -> L12
        r22.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r111);     // Catch: Throwable -> L12
        b r112 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r113 = new UnhandledException(r10);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r113, "e");     // Catch: Throwable -> L12
        throw r113;     // Catch: Throwable -> L12
    L32:
        r21 = null;
    L38:
        th = move-exception;
        RustBuffer.a r23 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r114 = r15.data;     // Catch: Throwable -> L12
        r23.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r114);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L43:
        b r24 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r25 = new UnhandledException("Unknown rust call status: " + r15 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r25, "e");     // Catch: Throwable -> L12
        throw r25;     // Catch: Throwable -> L12
    L46:
        throw ((Throwable) r1.a(r15.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r14 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.f7237c.decrementAndGet() != 0) goto L50;
        a();
    L50:
        throw th;
    L52:
        throw new IllegalStateException(j.class.getSimpleName().concat(" call counter would overflow"));
    L54:
        throw new IllegalStateException(j.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final byte[] g(PkmBizType r13) throws PkmError {
        Intrinsics.checkNotNullParameter("template.js", "resourcePath");
        Intrinsics.checkNotNullParameter(r13, "bizType");
    L3:
        long r2 = this.f7237c.get();
        if (r2 == 0) goto L53;
        if (r2 == Long.MAX_VALUE) goto L51;
        if (this.f7237c.compareAndSet(r2, 1 + r2) == false) goto L3;
        Pointer r8 = this.f7235a;     // Catch: Throwable -> L12
        i r0 = i.f7234a;     // Catch: Throwable -> L12
        NativeLib.Companion r3 = NativeLib.Companion;     // Catch: Throwable -> L12
        e r4 = new e(Long.valueOf(Pointer.nativeValue(r8)), "readDataFromJssdkWithBizType");     // Catch: Throwable -> L12
        r3.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r4, "info");     // Catch: Throwable -> L12
        String r5 = null;
        FuncParamsX3897bf48216accb9 r6 = new FuncParamsX3897bf48216accb9("template.js", r13.into(), null);     // Catch: Throwable -> L12
        int r14 = FuncParamsX3897bf48216accb9.ADAPTER.encodedSize(r6);     // Catch: Throwable -> L12
        if (r14 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r15 = RustBuffer.a.a(r14);     // Catch: Throwable -> L12
        Pointer r7 = r15.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L12
        f r1 = new f(r7);     // Catch: Throwable -> L12
        r6.encode(r1);     // Catch: Throwable -> L12
        r1.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r16 = NativeLib.Companion.a().molten_ffi_open_pkm_call(NativeLib.Companion.b(), r8, -4973017999909700663L, r15);     // Catch: Throwable -> L12
        int r9 = r16.code;     // Catch: Throwable -> L12
        if (r9 != 0) goto L23;
        RustBuffer.ByValue r17 = r16.data;     // Catch: Throwable -> L12
        ProtoAdapter r10 = FuncReturnXb05c0e03c1bfe022.ADAPTER;     // Catch: Throwable -> L12
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        byte[] r18 = ((FuncReturnXb05c0e03c1bfe022) r10.decode(RustBuffer.a.b(r17))).ret.toByteArray();     // Catch: Throwable -> L12
        if (this.f7237c.decrementAndGet() != 0) goto L21;
        a();
    L21:
        return r18;
    L23:
        if (r9 == 1) goto L45;
        if (r9 != 2) goto L42;
        RustBuffer.ByValue r11 = r16.data;     // Catch: Throwable -> L12
        int r12 = r11.len;     // Catch: Throwable -> L12
        if (r12 > 0) goto L55;
        b r19 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r110 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r110, "e");     // Catch: Throwable -> L12
        throw r110;     // Catch: Throwable -> L12
    L55:
        Pointer r20 = r11.data;     // Catch: Throwable -> L37
        if (r20 == null) goto L31;
        byte[] r21 = r20.getByteArray(0, r12);     // Catch: Throwable -> L37
    L32:
        if (r21 == null) goto L34;
        r5 = new String(r21, Charsets.UTF_8);     // Catch: Throwable -> L37
    L34:
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L37
        RustBuffer.a r22 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r111 = r16.data;     // Catch: Throwable -> L12
        r22.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r111);     // Catch: Throwable -> L12
        b r112 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r113 = new UnhandledException(r5);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r113, "e");     // Catch: Throwable -> L12
        throw r113;     // Catch: Throwable -> L12
    L31:
        r21 = null;
    L37:
        th = move-exception;
        RustBuffer.a r23 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r114 = r16.data;     // Catch: Throwable -> L12
        r23.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r114);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L42:
        b r24 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r25 = new UnhandledException("Unknown rust call status: " + r16 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r25, "e");     // Catch: Throwable -> L12
        throw r25;     // Catch: Throwable -> L12
    L45:
        throw ((Throwable) r0.a(r16.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r15 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.f7237c.decrementAndGet() != 0) goto L49;
        a();
    L49:
        throw th;
    L51:
        throw new IllegalStateException(j.class.getSimpleName().concat(" call counter would overflow"));
    L53:
        throw new IllegalStateException(j.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final void b(PkmBizType r12, omb.a.a r13) throws PkmError {
        Intrinsics.checkNotNullParameter(r12, "bizType");
        Intrinsics.checkNotNullParameter(r13, "callback");
    L3:
        long r0 = this.f7237c.get();
        if (r0 == 0) goto L54;
        if (r0 == Long.MAX_VALUE) goto L52;
        if (this.f7237c.compareAndSet(r0, 1 + r0) == false) goto L3;
        Pointer r6 = this.f7235a;     // Catch: Throwable -> L12
        i r1 = i.f7234a;     // Catch: Throwable -> L12
        NativeLib.Companion r2 = NativeLib.Companion;     // Catch: Throwable -> L12
        e r4 = new e(Long.valueOf(Pointer.nativeValue(r6)), "applyJssdkUpdate");     // Catch: Throwable -> L12
        r2.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r4, "info");     // Catch: Throwable -> L12
        String r10 = null;
        FuncParamsXb212c76ad323a577 r3 = new FuncParamsXb212c76ad323a577(r12.into(), h.b(r13), null);     // Catch: Throwable -> L12
        int r14 = FuncParamsXb212c76ad323a577.ADAPTER.encodedSize(r3);     // Catch: Throwable -> L12
        if (r14 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r15 = RustBuffer.a.a(r14);     // Catch: Throwable -> L12
        Pointer r5 = r15.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L12
        f r16 = new f(r5);     // Catch: Throwable -> L12
        r3.encode(r16);     // Catch: Throwable -> L12
        r16.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r17 = NativeLib.Companion.a().molten_ffi_open_pkm_call(NativeLib.Companion.b(), r6, -5647288605377120802L, r15);     // Catch: Throwable -> L12
        int r18 = r17.code;     // Catch: Throwable -> L12
        if (r18 != 0) goto L24;
        RustBuffer.ByValue r19 = r17.data;     // Catch: Throwable -> L12
        ProtoAdapter r110 = FuncReturnX3dc8b8542df1cbb1.ADAPTER;     // Catch: Throwable -> L12
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        Boolean r111 = ((FuncReturnX3dc8b8542df1cbb1) r110.decode(RustBuffer.a.b(r19))).ret;     // Catch: Throwable -> L12
        if (this.f7237c.decrementAndGet() != 0) goto L21;
        a();
    L21:
        r111.booleanValue();
        return;
    L24:
        if (r18 == 1) goto L46;
        if (r18 != 2) goto L43;
        RustBuffer.ByValue r112 = r17.data;     // Catch: Throwable -> L12
        int r7 = r112.len;     // Catch: Throwable -> L12
        if (r7 > 0) goto L56;
        b r113 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r114 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r114, "e");     // Catch: Throwable -> L12
        throw r114;     // Catch: Throwable -> L12
    L56:
        Pointer r115 = r112.data;     // Catch: Throwable -> L38
        if (r115 == null) goto L32;
        byte[] r116 = r115.getByteArray(0, r7);     // Catch: Throwable -> L38
    L33:
        if (r116 == null) goto L35;
        r10 = new String(r116, Charsets.UTF_8);     // Catch: Throwable -> L38
    L35:
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L38
        RustBuffer.a r117 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r118 = r17.data;     // Catch: Throwable -> L12
        r117.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r118);     // Catch: Throwable -> L12
        b r119 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r120 = new UnhandledException(r10);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r120, "e");     // Catch: Throwable -> L12
        throw r120;     // Catch: Throwable -> L12
    L32:
        r116 = null;
    L38:
        th = move-exception;
        RustBuffer.a r8 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r121 = r17.data;     // Catch: Throwable -> L12
        r8.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r121);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L43:
        b r122 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r123 = new UnhandledException("Unknown rust call status: " + r17 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r123, "e");     // Catch: Throwable -> L12
        throw r123;     // Catch: Throwable -> L12
    L46:
        throw ((Throwable) r1.a(r17.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r15 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.f7237c.decrementAndGet() != 0) goto L50;
        a();
    L50:
        throw th;
    L52:
        throw new IllegalStateException(j.class.getSimpleName().concat(" call counter would overflow"));
    L54:
        throw new IllegalStateException(j.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final boolean c(PkmBizType r12, String r13) throws PkmError {
        Intrinsics.checkNotNullParameter(r12, "bizType");
        Intrinsics.checkNotNullParameter(r13, "zipPath");
    L3:
        long r0 = this.f7237c.get();
        if (r0 == 0) goto L54;
        if (r0 == Long.MAX_VALUE) goto L52;
        if (this.f7237c.compareAndSet(r0, 1 + r0) == false) goto L3;
        Pointer r6 = this.f7235a;     // Catch: Throwable -> L12
        i r1 = i.f7234a;     // Catch: Throwable -> L12
        NativeLib.Companion r2 = NativeLib.Companion;     // Catch: Throwable -> L12
        e r4 = new e(Long.valueOf(Pointer.nativeValue(r6)), "extractBuiltinJssdkZipWithPathAndBizType");     // Catch: Throwable -> L12
        r2.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r4, "info");     // Catch: Throwable -> L12
        String r10 = null;
        FuncParamsX4877ab89ad2b2b88 r3 = new FuncParamsX4877ab89ad2b2b88(r12.into(), r13, null);     // Catch: Throwable -> L12
        int r14 = FuncParamsX4877ab89ad2b2b88.ADAPTER.encodedSize(r3);     // Catch: Throwable -> L12
        if (r14 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r15 = RustBuffer.a.a(r14);     // Catch: Throwable -> L12
        Pointer r5 = r15.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L12
        f r16 = new f(r5);     // Catch: Throwable -> L12
        r3.encode(r16);     // Catch: Throwable -> L12
        r16.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r17 = NativeLib.Companion.a().molten_ffi_open_pkm_call(NativeLib.Companion.b(), r6, 4479242481348972077L, r15);     // Catch: Throwable -> L12
        int r18 = r17.code;     // Catch: Throwable -> L12
        if (r18 != 0) goto L24;
        RustBuffer.ByValue r19 = r17.data;     // Catch: Throwable -> L12
        ProtoAdapter r110 = FuncReturnX3dc8b8542df1cbb1.ADAPTER;     // Catch: Throwable -> L12
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        Boolean r111 = ((FuncReturnX3dc8b8542df1cbb1) r110.decode(RustBuffer.a.b(r19))).ret;     // Catch: Throwable -> L12
        if (this.f7237c.decrementAndGet() != 0) goto L22;
        a();
    L22:
        return r111.booleanValue();
    L24:
        if (r18 == 1) goto L46;
        if (r18 != 2) goto L43;
        RustBuffer.ByValue r112 = r17.data;     // Catch: Throwable -> L12
        int r7 = r112.len;     // Catch: Throwable -> L12
        if (r7 > 0) goto L56;
        b r113 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r114 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r114, "e");     // Catch: Throwable -> L12
        throw r114;     // Catch: Throwable -> L12
    L56:
        Pointer r115 = r112.data;     // Catch: Throwable -> L38
        if (r115 == null) goto L32;
        byte[] r116 = r115.getByteArray(0, r7);     // Catch: Throwable -> L38
    L33:
        if (r116 == null) goto L35;
        r10 = new String(r116, Charsets.UTF_8);     // Catch: Throwable -> L38
    L35:
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L38
        RustBuffer.a r117 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r118 = r17.data;     // Catch: Throwable -> L12
        r117.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r118);     // Catch: Throwable -> L12
        b r119 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r120 = new UnhandledException(r10);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r120, "e");     // Catch: Throwable -> L12
        throw r120;     // Catch: Throwable -> L12
    L32:
        r116 = null;
    L38:
        th = move-exception;
        RustBuffer.a r8 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r121 = r17.data;     // Catch: Throwable -> L12
        r8.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r121);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L43:
        b r122 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r123 = new UnhandledException("Unknown rust call status: " + r17 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r123, "e");     // Catch: Throwable -> L12
        throw r123;     // Catch: Throwable -> L12
    L46:
        throw ((Throwable) r1.a(r17.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r15 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.f7237c.decrementAndGet() != 0) goto L50;
        a();
    L50:
        throw th;
    L52:
        throw new IllegalStateException(j.class.getSimpleName().concat(" call counter would overflow"));
    L54:
        throw new IllegalStateException(j.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final void d(PkmBizType r12, omb.b r13) {
        Intrinsics.checkNotNullParameter(r12, "bizType");
        Intrinsics.checkNotNullParameter(r13, "callback");
    L3:
        long r0 = this.f7237c.get();
        if (r0 == 0) goto L52;
        if (r0 == Long.MAX_VALUE) goto L50;
        if (this.f7237c.compareAndSet(r0, 1 + r0) == false) goto L3;
        Pointer r6 = this.f7235a;     // Catch: Throwable -> L12
        b r1 = b.f7226a;     // Catch: Throwable -> L12
        NativeLib.Companion r2 = NativeLib.Companion;     // Catch: Throwable -> L12
        e r4 = new e(Long.valueOf(Pointer.nativeValue(r6)), "getJssdkInstallationVersion");     // Catch: Throwable -> L12
        r2.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r4, "info");     // Catch: Throwable -> L12
        String r10 = null;
        FuncParamsXb212c76ad323a577 r3 = new FuncParamsXb212c76ad323a577(r12.into(), h.b(r13), null);     // Catch: Throwable -> L12
        int r14 = FuncParamsXb212c76ad323a577.ADAPTER.encodedSize(r3);     // Catch: Throwable -> L12
        if (r14 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r15 = RustBuffer.a.a(r14);     // Catch: Throwable -> L12
        Pointer r5 = r15.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L12
        f r16 = new f(r5);     // Catch: Throwable -> L12
        r3.encode(r16);     // Catch: Throwable -> L12
        r16.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r17 = NativeLib.Companion.a().molten_ffi_open_pkm_call(NativeLib.Companion.b(), r6, -1844905458293680994L, r15);     // Catch: Throwable -> L12
        int r18 = r17.code;     // Catch: Throwable -> L12
        if (r18 != 0) goto L22;
        if (this.f7237c.decrementAndGet() != 0) goto L59;
        a();
        return;
    L59:
        return;
    L22:
        if (r18 == 1) goto L44;
        if (r18 != 2) goto L41;
        RustBuffer.ByValue r19 = r17.data;     // Catch: Throwable -> L12
        int r7 = r19.len;     // Catch: Throwable -> L12
        if (r7 > 0) goto L54;
        UnhandledException r110 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r110, "e");     // Catch: Throwable -> L12
        throw r110;     // Catch: Throwable -> L12
    L54:
        Pointer r111 = r19.data;     // Catch: Throwable -> L36
        if (r111 == null) goto L30;
        byte[] r112 = r111.getByteArray(0, r7);     // Catch: Throwable -> L36
    L31:
        if (r112 == null) goto L33;
        r10 = new String(r112, Charsets.UTF_8);     // Catch: Throwable -> L36
    L33:
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L36
        RustBuffer.a r113 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r114 = r17.data;     // Catch: Throwable -> L12
        r113.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r114);     // Catch: Throwable -> L12
        UnhandledException r115 = new UnhandledException(r10);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r115, "e");     // Catch: Throwable -> L12
        throw r115;     // Catch: Throwable -> L12
    L30:
        r112 = null;
    L36:
        th = move-exception;
        RustBuffer.a r8 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r116 = r17.data;     // Catch: Throwable -> L12
        r8.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r116);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L41:
        UnhandledException r117 = new UnhandledException("Unknown rust call status: " + r17 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r117, "e");     // Catch: Throwable -> L12
        throw r117;     // Catch: Throwable -> L12
    L44:
        throw ((Throwable) r1.a(r17.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r15 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.f7237c.decrementAndGet() != 0) goto L48;
        a();
    L48:
        throw th;
    L50:
        throw new IllegalStateException(j.class.getSimpleName().concat(" call counter would overflow"));
    L52:
        throw new IllegalStateException(j.class.getSimpleName().concat(" object has already been destroyed"));
    }

    public final String f(String r12, PkmBizType r13) throws PkmError {
        Intrinsics.checkNotNullParameter(r12, "resourcePath");
        Intrinsics.checkNotNullParameter(r13, "bizType");
    L3:
        long r0 = this.f7237c.get();
        if (r0 == 0) goto L53;
        if (r0 == Long.MAX_VALUE) goto L51;
        if (this.f7237c.compareAndSet(r0, 1 + r0) == false) goto L3;
        Pointer r6 = this.f7235a;     // Catch: Throwable -> L12
        i r1 = i.f7234a;     // Catch: Throwable -> L12
        NativeLib.Companion r2 = NativeLib.Companion;     // Catch: Throwable -> L12
        e r4 = new e(Long.valueOf(Pointer.nativeValue(r6)), "jssdkInstallationPathWithBizType");     // Catch: Throwable -> L12
        r2.getClass();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r4, "info");     // Catch: Throwable -> L12
        String r10 = null;
        FuncParamsX3897bf48216accb9 r3 = new FuncParamsX3897bf48216accb9(r12, r13.into(), null);     // Catch: Throwable -> L12
        int r14 = FuncParamsX3897bf48216accb9.ADAPTER.encodedSize(r3);     // Catch: Throwable -> L12
        if (r14 <= 0) goto L14;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        RustBuffer.ByValue r15 = RustBuffer.a.a(r14);     // Catch: Throwable -> L12
        Pointer r5 = r15.data;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L12
        f r16 = new f(r5);     // Catch: Throwable -> L12
        r3.encode(r16);     // Catch: Throwable -> L12
        r16.close();     // Catch: Throwable -> L12
    L15:
        BufferCallStatus.ByValue r17 = NativeLib.Companion.a().molten_ffi_open_pkm_call(NativeLib.Companion.b(), r6, 2974361757270137568L, r15);     // Catch: Throwable -> L12
        int r18 = r17.code;     // Catch: Throwable -> L12
        if (r18 != 0) goto L23;
        RustBuffer.ByValue r19 = r17.data;     // Catch: Throwable -> L12
        ProtoAdapter r110 = FuncReturnX0bf8b5c665c57f35.ADAPTER;     // Catch: Throwable -> L12
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        String r111 = ((FuncReturnX0bf8b5c665c57f35) r110.decode(RustBuffer.a.b(r19))).ret;     // Catch: Throwable -> L12
        if (this.f7237c.decrementAndGet() != 0) goto L21;
        a();
    L21:
        return r111;
    L23:
        if (r18 == 1) goto L45;
        if (r18 != 2) goto L42;
        RustBuffer.ByValue r112 = r17.data;     // Catch: Throwable -> L12
        int r7 = r112.len;     // Catch: Throwable -> L12
        if (r7 > 0) goto L54;
        b r113 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r114 = new UnhandledException("Rust panic");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r114, "e");     // Catch: Throwable -> L12
        throw r114;     // Catch: Throwable -> L12
    L54:
        Pointer r115 = r112.data;     // Catch: Throwable -> L37
        if (r115 == null) goto L31;
        byte[] r116 = r115.getByteArray(0, r7);     // Catch: Throwable -> L37
    L32:
        if (r116 == null) goto L34;
        r10 = new String(r116, Charsets.UTF_8);     // Catch: Throwable -> L37
    L34:
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L37
        RustBuffer.a r117 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r118 = r17.data;     // Catch: Throwable -> L12
        r117.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r118);     // Catch: Throwable -> L12
        b r119 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r120 = new UnhandledException(r10);     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r120, "e");     // Catch: Throwable -> L12
        throw r120;     // Catch: Throwable -> L12
    L31:
        r116 = null;
    L37:
        th = move-exception;
        RustBuffer.a r8 = RustBuffer.Companion;     // Catch: Throwable -> L12
        RustBuffer.ByValue r121 = r17.data;     // Catch: Throwable -> L12
        r8.getClass();     // Catch: Throwable -> L12
        RustBuffer.a.c(r121);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L42:
        b r122 = b.f7226a;     // Catch: Throwable -> L12
        UnhandledException r123 = new UnhandledException("Unknown rust call status: " + r17 + ".code");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r123, "e");     // Catch: Throwable -> L12
        throw r123;     // Catch: Throwable -> L12
    L45:
        throw ((Throwable) r1.a(r17.data));     // Catch: Throwable -> L12
    L14:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L12
        r15 = RustBuffer.a.a(0);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (this.f7237c.decrementAndGet() != 0) goto L49;
        a();
    L49:
        throw th;
    L51:
        throw new IllegalStateException(j.class.getSimpleName().concat(" call counter would overflow"));
    L53:
        throw new IllegalStateException(j.class.getSimpleName().concat(" object has already been destroyed"));
    }
}
