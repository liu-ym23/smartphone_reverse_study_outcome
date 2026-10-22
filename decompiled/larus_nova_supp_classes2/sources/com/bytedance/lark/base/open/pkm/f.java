package com.bytedance.lark.base.open.pkm;

import com.sun.jna.Pointer;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class f extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pointer f7232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7233b;

    public f(Pointer r2) {
        Intrinsics.checkNotNullParameter(r2, "pointer");
        this.f7232a = r2;
    }

    @Override // java.io.OutputStream
    public final void write(int r7) {
        this.f7232a.write(this.f7233b, new int[]{r7}, 0, 1);
        this.f7233b++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        this.f7232a.write(this.f7233b, r7, 0, r7.length);
        this.f7233b += (long) r7.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r7, int r8, int r9) {
        if (r7 != null) goto L4;
        return;
    L4:
        this.f7232a.write(this.f7233b, r7, r8, r9);
        this.f7233b += (long) r9;
    }
}
