package com.larksuite.framework.http.v2.internal.rust.stream;

import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Sink;
import okio.j0;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements Sink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f285631a;

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f285631a.f285625e.compareAndSet(false, true) == true) goto L26;
        return;
    L26:
        c r100 = this.f285631a;     // Catch: Throwable -> L12 IOException -> L14
        PolarisFileOutputStreamWrapper r101 = r100.f285622b;     // Catch: Throwable -> L12 IOException -> L14
        monitor-enter(r101);     // Catch: Throwable -> L12 IOException -> L14
        r100.f285622b.flush();     // Catch: Throwable -> L9
        r100.f285622b.close();     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L12 IOException -> L14
    L21:
        this.f285631a.f285623c.countDown();
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e = move-exception;
        AtomicReference<Throwable> r103 = this.f285631a.f285624d;     // Catch: Throwable -> L12
    L17:
        if (r103.compareAndSet(null, e) == true) goto L21;
        if (r103.get() == null) goto L17;
    L12:
        th = move-exception;
        this.f285631a.f285623c.countDown();
        throw th;
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        if (this.f285631a.f285625e.get() == true) goto L12;
        c r100 = this.f285631a;
        PolarisFileOutputStreamWrapper r101 = r100.f285622b;
        monitor-enter(r101);
        r100.f285622b.flush();     // Catch: Throwable -> L9
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r101);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // okio.Sink
    public final j0 timeout() {
        return j0.f524073d;
    }

    public d(c r100) {
        this.f285631a = r100;
    }

    @Override // okio.Sink
    public final void write(Buffer r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        byte[] r102 = r100.readByteArray(r101);
        c r103 = this.f285631a;
        PolarisFileOutputStreamWrapper r104 = r103.f285622b;
        monitor-enter(r104);
        r103.f285622b.write(r102);     // Catch: Throwable -> L7
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r104);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
