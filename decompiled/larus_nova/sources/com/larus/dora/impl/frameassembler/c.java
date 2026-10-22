package com.larus.dora.impl.frameassembler;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c extends com.larus.dora.impl.frameassembler.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f335801q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<byte[]> f335802r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f335803s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public File f335804t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public BufferedOutputStream f335805u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f335806v;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final long e() {
        return this.f335803s + this.f335806v;
    }

    public final byte[] j() throws IOException {
        File r100 = this.f335804t;
        if (r100 != null) goto L8;
        byte[] r101 = new byte[(int) this.f335803s];
        Iterator r102 = ((ArrayList) this.f335802r).iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L48;
        byte[] r104 = (byte[]) r102.next();
        System.arraycopy(r104, 0, r101, r103, r104.length);
        r103 = r103 + r104.length;
        goto L6
    L48:
        return r101;
    L8:
        k();
        long r105 = this.f335806v + this.f335803s;
        if (this.f335786c.c(r105) == false) goto L37;
        this.f335797n += r105;
        int r106 = (int) r105;
        byte[] r107 = new byte[r106];
        PolarisFileInputStreamWrapper r108 = new PolarisFileInputStreamWrapper(r100);
        BufferedInputStream r109 = new BufferedInputStream(r108);     // Catch: Throwable -> L31
        int r110 = 0;
    L41:
        int r111 = r109.read(r107, r110, r106 - r110);     // Catch: Throwable -> L26
        if (r111 <= 0) goto L17;
        r110 = r110 + r111;     // Catch: Throwable -> L26
        goto L41
    L17:
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L19:
        CloseableKt.closeFinally(r109, null);     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r108, null);
        Iterator r113 = ((ArrayList) this.f335802r).iterator();
    L22:
        if (r113.hasNext() == false) goto L25;
        byte[] r114 = (byte[]) r113.next();
        System.arraycopy(r114, 0, r107, r110, r114.length);
        r110 = r110 + r114.length;
        goto L22
    L25:
        return r107;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r109, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);
        throw th;
    L37:
        throw new IOException("No memory to materialize payload of size=" + r105);
    }

    public final void k() {
        BufferedOutputStream r100 = this.f335805u;     // Catch: IOException -> L7
        if (r100 == null) goto L5;
        r100.close();     // Catch: IOException -> L7
    L5:
        this.f335805u = null;
    }

    public final void l() {
        File r100 = this.f335804t;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.delete();
        this.f335804t = null;
    }

    public final void n() {
        this.f335788e.lock();
        g49.d.e("DoraAggregateFrameSession", "onTimeout: key=" + this.f335784a + ", receivedBytes=" + (this.f335803s + this.f335806v) + ", finished=" + this.f335798o);     // Catch: Throwable -> L29
        if (this.f335798o == false) goto L8;
    L5:
        this.f335788e.unlock();
        return;
    L8:
        this.f335798o = true;     // Catch: Throwable -> L29
        if (this.f335785b.f335817j != DoraIncompleteSessionPolicy.NOTIFY_PARTIAL) goto L34;
        j();     // Catch: IOException -> L12 Throwable -> L29
    L12:
        e = move-exception;
        m("buildPayload on timeout failed", e);     // Catch: Throwable -> L29
    L34:
    L22:
        th = move-exception;
        m("onIncomplete failed", th);     // Catch: Throwable -> L26
        this.f335801q.c(c(), th);     // Catch: Throwable -> L26
        this.f335787d.b();     // Catch: Throwable -> L26
        k();     // Catch: Throwable -> L29
        l();     // Catch: Throwable -> L29
        g r100 = this.f335786c;     // Catch: Throwable -> L29
        long r101 = this.f335797n;     // Catch: Throwable -> L29
    L20:
        r100.a(r101);     // Catch: Throwable -> L29
        this.f335797n = 0;     // Catch: Throwable -> L29
        goto L5
    L26:
        th = move-exception;
        k();     // Catch: Throwable -> L29
        l();     // Catch: Throwable -> L29
        this.f335786c.a(this.f335797n);     // Catch: Throwable -> L29
        this.f335797n = 0;     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L16:
        if (this.f335785b.f335817j == DoraIncompleteSessionPolicy.DISCARD) goto L18;
        this.f335801q.b(c(), DoraIncompleteReason.TIMEOUT);     // Catch: Throwable -> L22
    L18:
        this.f335787d.f335834c.incrementAndGet();     // Catch: Throwable -> L22
        k();     // Catch: Throwable -> L29
        l();     // Catch: Throwable -> L29
        r100 = this.f335786c;     // Catch: Throwable -> L29
        r101 = this.f335797n;     // Catch: Throwable -> L29
        goto L20
    L29:
        th = move-exception;
        this.f335788e.unlock();
        throw th;
    }

    public final void o() throws IOException {
        if (this.f335804t == null) goto L5;
        return;
    L5:
        PolarisFileWrapper r100 = this.f335785b.f335815h;
        if (r100.exists() == false) goto L8;
    L12:
        File r101 = File.createTempFile("frame-session-", DefaultDiskStorage.FileType.TEMP, r100);
        g49.d.d("DoraAggregateFrameSession", "startSpooling: switching to disk, file=" + r101.getAbsolutePath() + ", bytesInMemory=" + this.f335797n);
        this.f335804t = r101;
        this.f335805u = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r101));
        this.f335799p = true;
        this.f335787d.f335836e.incrementAndGet();
        Iterator r102 = ((ArrayList) this.f335802r).iterator();
    L14:
        if (r102.hasNext() == false) goto L19;
        byte[] r103 = (byte[]) r102.next();
        BufferedOutputStream r104 = this.f335805u;
        if (r104 == null) goto L18;
        r104.write(r103);
    L18:
        this.f335806v += (long) r103.length;
        this.f335797n -= (long) r103.length;
        this.f335786c.a(r103.length);
        goto L14
    L19:
        ((ArrayList) this.f335802r).clear();
        this.f335803s = 0;
        return;
    L8:
        if (r100.mkdirs() == true) goto L12;
        throw new IOException("Failed to create spool directory: " + r100);
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final void h(byte[] r100) {
        byte[] r101 = j();     // Catch: Throwable -> L5
        this.f335801q.a(c(), r101);     // Catch: Throwable -> L5
    L4:
        k();
        l();
        this.f335786c.a(this.f335797n);
        this.f335797n = 0;
        this.f335787d.a();
        return;
    L5:
        th = move-exception;
        m("onCompleted failed", th);     // Catch: Throwable -> L10
        this.f335801q.c(c(), th);     // Catch: Throwable -> L10
        this.f335787d.b();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        k();
        l();
        this.f335786c.a(this.f335797n);
        this.f335797n = 0;
        this.f335787d.a();
        throw th;
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final boolean a(byte[] r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        long r100 = r110.length;
        if (this.f335804t != null) goto L35;
        long r101 = this.f335803s + r100;
        g49.d.d("DoraAggregateFrameSession", "appendInOrder, dataId=" + this.f335784a.f335846a + ", predicted=" + r101 + ", spoolThresholdBytes=" + this.f335785b.f335814g);
        e r102 = this.f335785b;
        if (r101 <= r102.f335814g) goto L15;
        o();     // Catch: IOException -> L11
        BufferedOutputStream r112 = this.f335805u;     // Catch: IOException -> L11
        if (r112 == null) goto L9;
        r112.write(r110);     // Catch: IOException -> L11
    L9:
        this.f335806v += (long) r110.length;     // Catch: IOException -> L11
        return true;
    L11:
        e = move-exception;
        m("startSpooling failed", e);
        return false;
    L15:
        if ((this.f335797n + r100) <= r102.f335812e) goto L19;
        g49.d.b("DoraAggregateFrameSession", "appendInOrder, dataId=" + this.f335784a.f335846a + ", bytesInMemory + len > config.maxSessionBufferedBytes, len=" + r100);
        return false;
    L19:
        if (this.f335786c.c(r100) == true) goto L22;
        g49.d.b("DoraAggregateFrameSession", "appendInOrder, dataId=" + this.f335784a.f335846a + ", tryAcquireBytes failed, len=" + r100);
        return false;
    L22:
        g49.d.d("DoraAggregateFrameSession", "appendInOrder, dataId=" + this.f335784a.f335846a + ", seq=" + r111 + ", len=" + r100);
        this.f335797n = this.f335797n + r100;
        ((ArrayList) this.f335802r).add(r110);
        this.f335803s = this.f335803s + r100;
        return true;
    L35:
        BufferedOutputStream r113 = this.f335805u;     // Catch: IOException -> L27
        if (r113 == null) goto L29;
        r113.write(r110);     // Catch: IOException -> L27
    L29:
        this.f335806v += (long) r110.length;     // Catch: IOException -> L27
        return true;
    L27:
        e = move-exception;
        m("writeToSpool failed", e);
        return false;
    }

    public final void m(String r100, Throwable r101) {
        g49.d.c("DoraAggregateFrameSession", r100 + ", key=" + this.f335784a, r101);
    }

    @Override // com.larus.dora.impl.frameassembler.a
    public final void i(DoraIncompleteReason r100, byte[] r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f335788e.lock();
        g49.d.c("DoraAggregateFrameSession", "onForceClose: key=" + this.f335784a + ", reason=" + r100 + ", receivedBytes=" + (this.f335803s + this.f335806v) + ", finished=" + this.f335798o, r102);     // Catch: Throwable -> L42
        if (this.f335798o == false) goto L8;
    L5:
        this.f335788e.unlock();
        return;
    L8:
        this.f335798o = true;     // Catch: Throwable -> L42
    L31:
        th = move-exception;
        m("onForceClose callback failed", th);     // Catch: Throwable -> L39
        k();     // Catch: Throwable -> L42
        l();     // Catch: Throwable -> L42
        g r103 = this.f335786c;     // Catch: Throwable -> L42
        long r104 = this.f335797n;     // Catch: Throwable -> L42
    L34:
        r103.a(r104);     // Catch: Throwable -> L42
        this.f335797n = 0;     // Catch: Throwable -> L42
        goto L5
    L39:
        th = move-exception;
        k();     // Catch: Throwable -> L42
        l();     // Catch: Throwable -> L42
        this.f335786c.a(this.f335797n);     // Catch: Throwable -> L42
        this.f335797n = 0;     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L11:
        if (r100 != DoraIncompleteReason.RESOURCE_LIMIT) goto L19;
        if (this.f335785b.f335817j != DoraIncompleteSessionPolicy.NOTIFY_PARTIAL) goto L19;
        j();     // Catch: IOException -> L16 Throwable -> L31
    L16:
        e = move-exception;
        m("buildPayload on forceClose failed", e);     // Catch: Throwable -> L31
    L19:
        if (r100 == DoraIncompleteReason.RESOURCE_LIMIT) goto L28;
        if (r100 == DoraIncompleteReason.TOTAL_SEQ_MISMATCH) goto L28;
        b r105 = this.f335801q;     // Catch: Throwable -> L31
        h r106 = c();     // Catch: Throwable -> L31
        if (r102 != null) goto L26;
        r102 = new IllegalStateException("session closed");     // Catch: Throwable -> L31
    L26:
        r105.c(r106, r102);     // Catch: Throwable -> L31
        this.f335787d.b();     // Catch: Throwable -> L31
    L33:
        k();     // Catch: Throwable -> L42
        l();     // Catch: Throwable -> L42
        r103 = this.f335786c;     // Catch: Throwable -> L42
        r104 = this.f335797n;     // Catch: Throwable -> L42
    L28:
        if (this.f335785b.f335817j == DoraIncompleteSessionPolicy.DISCARD) goto L33;
        this.f335801q.b(c(), r100);     // Catch: Throwable -> L31
        this.f335787d.f335834c.incrementAndGet();     // Catch: Throwable -> L31
    L42:
        th = move-exception;
        this.f335788e.unlock();
        throw th;
    }

    public c(i r100, e r101, g r110, f r111, b r112, long r113) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r110, "resourceTracker");
        Intrinsics.checkNotNullParameter(r111, "metrics");
        Intrinsics.checkNotNullParameter(r112, "consumer");
        super(r100, r101, r110, r111, r113);
        this.f335801q = r112;
        this.f335802r = new ArrayList();
    }
}
