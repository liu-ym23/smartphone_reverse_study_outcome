package com.larus.dora.impl.frameassembler;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class l extends com.larus.dora.impl.frameassembler.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j f335857q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public OutputStream f335858r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f335859s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f335860t;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final long e() {
        return this.f335860t + this.f335797n;
    }

    public final void j() throws IOException {
        if (this.f335859s == true) goto L6;
        this.f335858r = this.f335857q.a(c());
        this.f335859s = true;
        return;
    }

    public final void l() {
        this.f335788e.lock();
        g49.d.e("DoraStreamingFrameSession", "onTimeout: key=" + this.f335784a + ", receivedBytes=" + (this.f335860t + this.f335797n) + ", finished=" + this.f335798o);     // Catch: Throwable -> L32
        if (this.f335798o == false) goto L8;
    L5:
        this.f335788e.unlock();
        return;
    L8:
        this.f335798o = true;     // Catch: Throwable -> L32
        j();     // Catch: Throwable -> L14 Exception -> L16
        if (this.f335785b.f335817j == DoraIncompleteSessionPolicy.DISCARD) goto L29;
        j r100 = this.f335857q;     // Catch: Throwable -> L14 Exception -> L16
        h r101 = c();     // Catch: Throwable -> L14 Exception -> L16
        OutputStream r102 = this.f335858r;     // Catch: Throwable -> L14 Exception -> L16
        if (r102 == null) goto L19;
        r100.e(r101, r102, DoraIncompleteReason.TIMEOUT);     // Catch: Throwable -> L14 Exception -> L16
        this.f335787d.f335834c.incrementAndGet();     // Catch: Throwable -> L14 Exception -> L16
        goto L29
    L19:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L14 Exception -> L16
    L29:
        m();     // Catch: Throwable -> L32
    L14:
        th = move-exception;
        m();     // Catch: Throwable -> L32
        throw th;     // Catch: Throwable -> L32
    L16:
        e = move-exception;
        k("onTimeout failed", e);     // Catch: Throwable -> L14
        j r103 = this.f335857q;     // Catch: Throwable -> L14 Exception -> L26
        h r104 = c();     // Catch: Throwable -> L14 Exception -> L26
        OutputStream r105 = this.f335858r;     // Catch: Throwable -> L14 Exception -> L26
        if (r105 == null) goto L25;
        r103.c(r104, r105, e);     // Catch: Throwable -> L14 Exception -> L26
    L28:
        this.f335787d.b();     // Catch: Throwable -> L14
        goto L29
    L25:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L14 Exception -> L26
    L26:
        e = move-exception;
        k("onTimeout failed onError", e);     // Catch: Throwable -> L14
    L32:
        th = move-exception;
        this.f335788e.unlock();
        throw th;
    }

    public final void m() {
        OutputStream r100 = this.f335858r;     // Catch: IOException -> L7
        if (r100 == null) goto L5;
        r100.close();     // Catch: IOException -> L7
    L5:
        this.f335786c.a(this.f335797n);
        this.f335797n = 0;
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final void h(byte[] r100) {
        OutputStream r101 = this.f335858r;     // Catch: Throwable -> L8 Exception -> L10
        if (r101 == null) goto L7;
        j();     // Catch: Throwable -> L8 Exception -> L10
        this.f335857q.b(c(), r101);     // Catch: Throwable -> L8 Exception -> L10
        this.f335787d.a();     // Catch: Throwable -> L8 Exception -> L10
    L20:
        m();
        return;
    L7:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L8 Exception -> L10
    L8:
        th = move-exception;
        m();
        throw th;
    L10:
        e = move-exception;
        k("onCompleted failed", e);     // Catch: Throwable -> L8
        j r102 = this.f335857q;     // Catch: Throwable -> L8 Exception -> L17
        h r103 = c();     // Catch: Throwable -> L8 Exception -> L17
        OutputStream r104 = this.f335858r;     // Catch: Throwable -> L8 Exception -> L17
        if (r104 == null) goto L16;
        r102.c(r103, r104, e);     // Catch: Throwable -> L8 Exception -> L17
    L19:
        this.f335787d.b();     // Catch: Throwable -> L8
        goto L20
    L16:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L8 Exception -> L17
    L17:
        e = move-exception;
        k("onCompleted failed onError", e);     // Catch: Throwable -> L8
        goto L19
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final boolean a(byte[] r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        j();     // Catch: Exception -> L8
        j r102 = this.f335857q;     // Catch: Exception -> L8
        h r103 = c();     // Catch: Exception -> L8
        OutputStream r104 = this.f335858r;     // Catch: Exception -> L8
        if (r104 == null) goto L7;
        r102.d(r103, r104, r100, r101);     // Catch: Exception -> L8
        this.f335860t += (long) r100.length;     // Catch: Exception -> L8
        return true;
    L7:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Exception -> L8
    L8:
        e = move-exception;
        k("onChunk failed", e);
        return false;
    }

    public final void k(String r100, Throwable r101) {
        g49.d.c("DoraStreamingFrameSession", r100 + ", key=" + this.f335784a, r101);
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final void i(DoraIncompleteReason r100, byte[] r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f335788e.lock();
        g49.d.c("DoraStreamingFrameSession", "onForceClose: key=" + this.f335784a + ", reason=" + r100 + ", receivedBytes=" + (this.f335860t + this.f335797n) + ", finished=" + this.f335798o, r102);     // Catch: Throwable -> L39
        if (this.f335798o == false) goto L8;
    L5:
        this.f335788e.unlock();
        return;
    L8:
        this.f335798o = true;     // Catch: Throwable -> L39
        j();     // Catch: Throwable -> L29 Exception -> L31
        if (r100 == DoraIncompleteReason.RESOURCE_LIMIT) goto L25;
        if (r100 == DoraIncompleteReason.TOTAL_SEQ_MISMATCH) goto L25;
        if (r100 == DoraIncompleteReason.SEQ_MISMATCH) goto L25;
        j r103 = this.f335857q;     // Catch: Throwable -> L29 Exception -> L31
        h r104 = c();     // Catch: Throwable -> L29 Exception -> L31
        OutputStream r105 = this.f335858r;     // Catch: Throwable -> L29 Exception -> L31
        if (r105 == null) goto L23;
        if (r102 != null) goto L21;
        r102 = new IllegalStateException("session closed");     // Catch: Throwable -> L29 Exception -> L31
    L21:
        r103.c(r104, r105, r102);     // Catch: Throwable -> L29 Exception -> L31
        this.f335787d.b();     // Catch: Throwable -> L29 Exception -> L31
    L36:
        m();     // Catch: Throwable -> L39
        goto L5
    L23:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L29 Exception -> L31
    L25:
        if (this.f335785b.f335817j == DoraIncompleteSessionPolicy.DISCARD) goto L36;
        j r106 = this.f335857q;     // Catch: Throwable -> L29 Exception -> L31
        h r107 = c();     // Catch: Throwable -> L29 Exception -> L31
        OutputStream r108 = this.f335858r;     // Catch: Throwable -> L29 Exception -> L31
        if (r108 == null) goto L34;
        r106.e(r107, r108, r100);     // Catch: Throwable -> L29 Exception -> L31
        this.f335787d.f335834c.incrementAndGet();     // Catch: Throwable -> L29 Exception -> L31
        goto L36
    L34:
        throw new IllegalStateException("Required value was null.".toString());     // Catch: Throwable -> L29 Exception -> L31
    L29:
        th = move-exception;
        m();     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L31:
        e = move-exception;
        k("onForceClose failed", e);     // Catch: Throwable -> L29
    L39:
        th = move-exception;
        this.f335788e.unlock();
        throw th;
    }

    public l(i r100, e r101, g r110, f r111, j r112, long r113) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r110, "resourceTracker");
        Intrinsics.checkNotNullParameter(r111, "metrics");
        Intrinsics.checkNotNullParameter(r112, "consumer");
        super(r100, r101, r110, r111, r113);
        this.f335857q = r112;
    }
}
