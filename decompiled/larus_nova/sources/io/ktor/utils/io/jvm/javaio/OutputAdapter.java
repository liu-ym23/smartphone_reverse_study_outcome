package io.ktor.utils.io.jvm.javaio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes41.dex */
public final class OutputAdapter extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.ktor.utils.io.d f492120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OutputAdapter$loop$1 f492121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f492122c;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
        this.f492121b.d(BlockingKt.f492113b);     // Catch: Throwable -> L6
        this.f492121b.c();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        throw th;
    L8:
        throw new IOException(th);     // Catch: Throwable -> L9
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final synchronized void flush() {
        monitor-enter(this);
        this.f492121b.d(BlockingKt.f492114c);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int r100) {
        monitor-enter(this);
        byte[] r101 = this.f492122c;     // Catch: Throwable -> L9
        if (r101 != null) goto L6;
        r101 = new byte[1];     // Catch: Throwable -> L9
        this.f492122c = r101;     // Catch: Throwable -> L9
    L6:
        r101[0] = (byte) r100;     // Catch: Throwable -> L9
        this.f492121b.e(r101, 0, 1);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public OutputAdapter(Job r100, io.ktor.utils.io.d r101) {
        Intrinsics.checkNotNullParameter(r101, "channel");
        this.f492120a = r101;
        this.f492121b = new OutputAdapter$loop$1(r100, this);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] r100, int r101, int r102) {
        monitor-enter(this);
        OutputAdapter$loop$1 r103 = this.f492121b;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L6
        r103.e(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
