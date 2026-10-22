package com.ss.android.lark.vfs;

import java.io.OutputStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f444828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f444829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f444830c;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f444830c == false) goto L5;
        return;
    L5:
        this.f444830c = true;
        this.f444828a.close();
        this.f444829b.invoke();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        this.f444828a.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int r100) {
        this.f444828a.write(r100);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100) {
        this.f444828a.write(r100);
    }

    public g(OutputStream r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "onClosedCallback");
        this.f444828a = r100;
        this.f444829b = r101;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100, int r101, int r102) {
        this.f444828a.write(r100, r101, r102);
    }
}
