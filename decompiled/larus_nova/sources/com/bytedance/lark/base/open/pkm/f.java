package com.bytedance.lark.base.open.pkm;

import com.sun.jna.Pointer;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pointer f252901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f252902b;

    public f(Pointer r100) {
        Intrinsics.checkNotNullParameter(r100, "pointer");
        this.f252901a = r100;
    }

    @Override // java.io.OutputStream
    public final void write(int r100) {
        this.f252901a.write(this.f252902b, new int[]{r100}, 0, 1);
        this.f252902b++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f252901a.write(this.f252902b, r100, 0, r100.length);
        this.f252902b += (long) r100.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f252901a.write(this.f252902b, r100, r101, r102);
        this.f252902b += (long) r102;
    }
}
