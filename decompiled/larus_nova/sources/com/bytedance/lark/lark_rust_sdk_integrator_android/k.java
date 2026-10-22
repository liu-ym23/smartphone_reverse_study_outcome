package com.bytedance.lark.lark_rust_sdk_integrator_android;

import com.sun.jna.Pointer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes16.dex */
public final class k extends j {
    @Override // com.bytedance.lark.lark_rust_sdk_integrator_android.j
    public final void a() {
        d r100 = d.f253246a;
        NativeLib.Companion.getClass();
        BufferCallStatus.ByValue r101 = NativeLib.Companion.a().molten_ffi_lark_rust_sdk_integrator_free(NativeLib.Companion.b(), this.f253254a, -8606561449784901632L);
        int r102 = r101.code;
        if (r102 != 0) goto L6;
        return;
    L6:
        if (r102 == 1) goto L28;
        if (r102 != 2) goto L25;
        RustBuffer.ByValue r103 = r101.data;
        int r104 = r103.len;
        if (r104 > 0) goto L29;
        UnhandledException r105 = new UnhandledException("Rust panic");
        Intrinsics.checkNotNullParameter(r105, "e");
        throw r105;
    L29:
        Pointer r106 = r103.data;     // Catch: Throwable -> L20
        String r107 = null;
        if (r106 == null) goto L14;
        byte[] r108 = r106.getByteArray(0, r104);     // Catch: Throwable -> L20
    L15:
        if (r108 == null) goto L17;
        r107 = new String(r108, Charsets.UTF_8);     // Catch: Throwable -> L20
    L17:
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L20
        RustBuffer.a r109 = RustBuffer.Companion;
        RustBuffer.ByValue r110 = r101.data;
        r109.getClass();
        RustBuffer.a.c(r110);
        UnhandledException r111 = new UnhandledException(r107);
        Intrinsics.checkNotNullParameter(r111, "e");
        throw r111;
    L14:
        r108 = null;
    L20:
        th = move-exception;
        RustBuffer.a r112 = RustBuffer.Companion;
        RustBuffer.ByValue r113 = r101.data;
        r112.getClass();
        RustBuffer.a.c(r113);
        throw th;
    L25:
        UnhandledException r114 = new UnhandledException("Unknown rust call status: " + r101 + ".code");
        Intrinsics.checkNotNullParameter(r114, "e");
        throw r114;
    L28:
        throw r100.a(r101.data);
    }

    public k(Pointer r100) {
        Intrinsics.checkNotNullParameter(r100, "pointer");
        super(r100);
    }
}
