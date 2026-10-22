package com.bytedance.gkfs.storage.io;

import com.bytedance.gkfs.UtilsKt;
import com.bytedance.gkfs.cdc.GkFSByteBuffer;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f245342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.gkfs.c f245343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f245344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f245345d;

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        this.f245345d.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        super.close();
        if (UtilsKt.d() == false) goto L5;
        com.bytedance.gkfs.c.b(this.f245343b, "CombinedChunkOutputStream", "Stream closed, totalWriteSize=" + this.f245342a, 0, false, 12);
    L5:
        flush();
    }

    public final void a(GkFSByteBuffer r110) {
        this.f245345d.h(r110.f245144d);
        int r100 = r110.f245144d;
        if (r100 < 0) goto L47;
        if (r100 < 0) goto L47;
        int r101 = r100 + 0;
        if (r101 > r100) goto L47;
        if (r101 < 0) goto L47;
        if (r100 != 0) goto L11;
        return;
    L11:
        if (this.f245342a >= this.f245344c) goto L45;
        b r102 = this.f245345d;
        if (r102.f245355c.get() == true) goto L43;
        int r103 = r110.f245144d;
        if (r103 < 0) goto L41;
        if (r100 < 0) goto L41;
        if (r101 > r103) goto L41;
        if (r101 < 0) goto L41;
        if (r100 == 0) goto L33;
        ReentrantReadWriteLock r104 = r102.f245354b;
        ReentrantReadWriteLock.ReadLock r105 = r104.readLock();
        int r106 = 0;
        if (r104.getWriteHoldCount() != 0) goto L24;
        int r107 = r104.getReadHoldCount();
    L25:
        int r108 = 0;
    L26:
        if (r108 >= r107) goto L28;
        r105.unlock();
        r108 = r108 + 1;
        goto L26
    L28:
        ReentrantReadWriteLock.WriteLock r109 = r104.writeLock();
        r109.lock();
        r102.h(r100);     // Catch: Throwable -> L35
        r102.g(r102.f245353a, r110, r100);     // Catch: Throwable -> L35
        r102.f245353a += (long) r100;     // Catch: Throwable -> L35
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L35
    L30:
        if (r106 >= r107) goto L32;
        r105.lock();
        r106 = r106 + 1;
        goto L30
    L32:
        r109.unlock();
        b.a.a(b.f245352n, r102);
    L35:
        th = move-exception;
    L36:
        if (r106 >= r107) goto L38;
        r105.lock();
        r106 = r106 + 1;
        goto L36
    L38:
        r109.unlock();
        throw th;
    L24:
        r107 = 0;
    L33:
        this.f245342a += r100;
        return;
    L41:
        throw new IndexOutOfBoundsException();
    L43:
        throw new IOException("buffer " + r102.f245357e.f245185a + " closed");
    L45:
        throw new IOException("Already write " + this.f245342a);
    L47:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.OutputStream
    public final void write(int r100) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100) {
        throw new UnsupportedOperationException();
    }

    public a(int r100, b r101) {
        this.f245344c = r100;
        this.f245345d = r101;
        this.f245343b = new com.bytedance.gkfs.c();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] r100, int r101, int r102) {
        throw new UnsupportedOperationException();
    }
}
