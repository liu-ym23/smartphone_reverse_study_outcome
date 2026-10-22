package com.bytedance.forest.utils.io;

import com.bytedance.forest.utils.ThreadUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f244556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f244557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CountDownLatch f244558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f244559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.forest.utils.c f244560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicInteger f244561f;

    /* JADX INFO: renamed from: com.bytedance.forest.utils.io.a$a, reason: collision with other inner class name */
    public static final class C3498a {
    }

    static {
    }

    public final void a() {
        if (this.f244556a.compareAndSet(false, true) == true) goto L6;
        com.bytedance.forest.utils.c.a(this.f244560e, 4, "Concurrent", "already finished when invoke finish", false, null, null, 56);
        return;
    L6:
        com.bytedance.forest.utils.c.a(this.f244560e, 4, "Concurrent", "invoke finished success, closed=" + this.f244557b.get(), false, null, null, 56);
        int r100 = c();
        byte[] r101 = ((ByteArrayOutputStream) this).buf;
        if (r101 != null) goto L10;
        Intrinsics.throwNpe();
    L10:
        if (r100 >= r101.length) goto L12;
        ((ByteArrayOutputStream) this).buf = Arrays.copyOf(((ByteArrayOutputStream) this).buf, c());
    L12:
        Object r102 = this.f244559d;
        monitor-enter(r102);
        com.bytedance.forest.utils.c.a(this.f244560e, 3, "Concurrent", "release locker for #finish", false, null, null, 56);     // Catch: Throwable -> L18
        this.f244559d.notifyAll();     // Catch: Throwable -> L18
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r102);
        this.f244558c.countDown();
        com.bytedance.forest.utils.c.a(this.f244560e, 3, "Concurrent", "release finishWaiter for #finish", false, null, null, 56);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final int c() {
        Object r100 = this.f244559d;
        monitor-enter(r100);
        int r101 = ((ByteArrayOutputStream) this).count;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f244557b.compareAndSet(false, true) == false) goto L13;
        com.bytedance.forest.utils.c.a(this.f244560e, 4, "Concurrent", "ConcurrentIOMeta@" + hashCode() + " closed", false, null, null, 56);
        super.close();
        Object r100 = this.f244559d;
        monitor-enter(r100);
        ((ByteArrayOutputStream) this).buf = null;     // Catch: Throwable -> L10
        ((ByteArrayOutputStream) this).count = 0;     // Catch: Throwable -> L10
        com.bytedance.forest.utils.c.a(this.f244560e, 3, "Concurrent", "release locker for #close", false, null, null, 56);     // Catch: Throwable -> L10
        this.f244559d.notifyAll();     // Catch: Throwable -> L10
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r100);
        this.f244558c.countDown();
        com.bytedance.forest.utils.c.a(this.f244560e, 3, "Concurrent", "release finishWaiter for #close", false, null, null, 56);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        return "ConcurrentIOMeta@" + hashCode() + "(readAvailable=" + c() + ", isFulFilled=" + this.f244556a.get() + ", isClosed=" + this.f244557b.get() + ')';
    }

    public final byte[] b() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public a(int r100, com.bytedance.forest.utils.c r101, AtomicInteger r102) {
        super(r100);
        this.f244560e = r101;
        this.f244561f = r102;
        this.f244556a = new AtomicBoolean(false);
        this.f244557b = new AtomicBoolean(false);
        this.f244558c = new CountDownLatch(1);
        this.f244559d = new Object();
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final void write(byte[] r110, int r111, int r112) {
        if (r110 == null) goto L20;
        Object r100 = this.f244559d;
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.f244557b.get() == true) goto L15;
        if (this.f244556a.get() == false) goto L11;
        com.bytedance.forest.utils.c.a(this.f244560e, 6, "Concurrent", "buffer has been fulfilled, buffer={b:" + ((ByteArrayOutputStream) this).buf + ", size:" + ((ByteArrayOutputStream) this).count + "}, write={b:" + r110 + ", off:" + r111 + ", len:" + r112 + '}', true, null, null, 48);     // Catch: Throwable -> L16
    L11:
        com.bytedance.forest.utils.c.a(this.f244560e, 3, "Concurrent", "write (bytes:" + r110 + ", size=" + Math.min(r110.length - r111, r112) + ')', false, null, null, 56);     // Catch: Throwable -> L16
        super.write(r110, r111, r112);     // Catch: Throwable -> L16
        this.f244559d.notifyAll();     // Catch: Throwable -> L16
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r100);
        return;
    L15:
        throw new IOException("ConcurrentIOMeta closed!");     // Catch: Throwable -> L16
    L20:
        throw new IOException("ByteArray is NULL!");
    }

    public final int read(int r110, byte[] r210, int r211, int r212) throws IOException {
        if (this.f244557b.get() == true) goto L45;
        if (r210 == null) goto L43;
        Ref.IntRef r100 = new Ref.IntRef();
        int r101 = this.f244561f.getAndIncrement();
        Object r102 = this.f244559d;
        monitor-enter(r102);
        r100.element = ((ByteArrayOutputStream) this).count - r110;     // Catch: Throwable -> L39
    L9:
        if (r100.element > 0) goto L24;
        com.bytedance.forest.utils.c.a(this.f244560e, 3, "Concurrent", '[' + r101 + "]count=" + ((ByteArrayOutputStream) this).count + ", start=" + r110 + ", sizeCanRead=" + r100.element + ", isFulFilled=" + this.f244556a.get() + ", isClosed=" + this.f244557b, false, null, null, 56);     // Catch: Throwable -> L39
        if (this.f244556a.get() == true) goto L21;
        if (this.f244557b.get() == true) goto L21;
        com.bytedance.forest.utils.c.a(this.f244560e, 3, "Concurrent", '[' + r101 + "]start to wait writing", false, null, null, 56);     // Catch: Throwable -> L39
        Object r103 = this.f244559d;     // Catch: Throwable -> L39
        if (ThreadUtils.a() == false) goto L18;
        long r104 = 500;
    L19:
        r103.wait(r104);     // Catch: Throwable -> L39
        com.bytedance.forest.utils.c.a(this.f244560e, 3, "Concurrent", '[' + r101 + "]receive write side release", false, null, null, 56);     // Catch: Throwable -> L39
        r100.element = ((ByteArrayOutputStream) this).count - r110;     // Catch: Throwable -> L39
        goto L9
    L18:
        r104 = 1000;
    L21:
        monitor-exit(r102);
        return -1;
    L24:
        if (this.f244557b.get() == false) goto L28;
        monitor-exit(r102);
        return -1;
    L28:
        Integer r105 = Integer.valueOf(((ByteArrayOutputStream) this).count);     // Catch: Throwable -> L39
        byte[] r106 = ((ByteArrayOutputStream) this).buf;     // Catch: Throwable -> L39
        if (r106 != null) goto L31;
        Intrinsics.throwNpe();     // Catch: Throwable -> L39
    L31:
        Pair r107 = TuplesKt.to(r105, r106);     // Catch: Throwable -> L39
        monitor-exit(r102);
        int r108 = ((Number) r107.component1()).intValue();
        byte[] r109 = (byte[]) r107.component2();
        com.bytedance.forest.utils.c.a(this.f244560e, 4, "Concurrent", "[" + r101 + "]get snapshot: {maxReadableSize:" + r108 + ", buffer:" + r109 + ", sizeCanRead=" + r100.element + '}', false, null, null, 56);
        int r111 = Math.min(r210.length - r211, r212);
        if (r111 > 0) goto L37;
        return 0;
    L37:
        int r112 = Math.min(r100.element, r111);
        com.bytedance.forest.utils.c.a(this.f244560e, 4, "Concurrent", "[" + r101 + "]read from buffer: {sizeCanRead:" + r100.element + ", sizeToRead:" + r111 + ", readSize=" + r112 + '}', false, null, null, 56);
        ArraysKt.copyInto(r109, r210, r211, r110, r110 + r112);
        return r112;
    L39:
        th = move-exception;
        throw th;
    L43:
        throw new IOException("ByteArray is NULL!");
    L45:
        throw new IOException("ConcurrentIOMeta closed!");
    }
}
