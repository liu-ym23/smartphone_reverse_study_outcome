package com.bytedance.lark.lark_rust_sdk_integrator_android;

import com.sun.jna.Pointer;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends OutputStream {
    public final Pointer a;
    public long b;

    public h(Pointer r2) {
        Intrinsics.checkNotNullParameter(r2, "pointer");
        this.a = r2;
    }

    @Override // java.io.OutputStream
    public final void write(int r7) {
        this.a.write(this.b, new int[]{r7}, 0, 1);
        this.b++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        this.a.write(this.b, r7, 0, r7.length);
        this.b += (long) r7.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r7, int r8, int r9) {
        if (r7 != null) goto L4;
        return;
    L4:
        this.a.write(this.b, r7, r8, r9);
        this.b += (long) r9;
    }
}
