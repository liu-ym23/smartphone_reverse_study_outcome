package com.bytedance.lark.lark_rust_sdk_integrator_android;

import com.sun.jna.Pointer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k extends j {
    @Override // com.bytedance.lark.lark_rust_sdk_integrator_android.j
    public final void a() {
        d r0 = d.a;
        NativeLib.Companion.getClass();
        BufferCallStatus.ByValue r1 = NativeLib.Companion.a().molten_ffi_lark_rust_sdk_integrator_free(NativeLib.Companion.b(), this.a, -8606561449784901632L);
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
        throw r0.a(r1.data);
    }

    public k(Pointer r2) {
        Intrinsics.checkNotNullParameter(r2, "pointer");
        super(r2);
    }
}
