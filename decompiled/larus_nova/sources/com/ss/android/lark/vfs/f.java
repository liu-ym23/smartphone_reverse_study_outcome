package com.ss.android.lark.vfs;

import java.io.InputStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f444825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f444826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f444827c;

    @Override // java.io.InputStream
    public final int available() {
        return this.f444825a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f444827c == false) goto L5;
        return;
    L5:
        this.f444827c = true;
        this.f444825a.close();
        this.f444826b.invoke();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f444825a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() {
        return this.f444825a.read();
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f444825a.reset();
    }

    @Override // java.io.InputStream
    public final void mark(int r100) {
        this.f444825a.mark(r100);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100) {
        return this.f444825a.read(r100);
    }

    @Override // java.io.InputStream
    public final long skip(long r100) {
        return this.f444825a.skip(r100);
    }

    public f(InputStream r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "onClosedCallback");
        this.f444825a = r100;
        this.f444826b = r101;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) {
        return this.f444825a.read(r100, r101, r102);
    }
}
