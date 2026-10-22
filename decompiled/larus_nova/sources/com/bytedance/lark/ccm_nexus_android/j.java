package com.bytedance.lark.ccm_nexus_android;

import com.sun.jna.Pointer;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
public final class j extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pointer f252921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f252922b;

    public j(Pointer r100) {
        Intrinsics.checkNotNullParameter(r100, "pointer");
        this.f252921a = r100;
    }

    @Override // java.io.OutputStream
    public final void write(int r100) {
        this.f252921a.write(this.f252922b, new int[]{r100}, 0, 1);
        this.f252922b++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f252921a.write(this.f252922b, r100, 0, r100.length);
        this.f252922b += (long) r100.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f252921a.write(this.f252922b, r100, r101, r102);
        this.f252922b += (long) r102;
    }
}
