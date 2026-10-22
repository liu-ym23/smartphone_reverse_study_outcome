package com.bytedance.lark.lark_bitable_android;

import com.sun.jna.Pointer;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o0 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pointer f253098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f253099b;

    public o0(Pointer r100) {
        Intrinsics.checkNotNullParameter(r100, "pointer");
        this.f253098a = r100;
    }

    @Override // java.io.OutputStream
    public final void write(int r100) {
        this.f253098a.write(this.f253099b, new int[]{r100}, 0, 1);
        this.f253099b++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f253098a.write(this.f253099b, r100, 0, r100.length);
        this.f253099b += (long) r100.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f253098a.write(this.f253099b, r100, r101, r102);
        this.f253099b += (long) r102;
    }
}
