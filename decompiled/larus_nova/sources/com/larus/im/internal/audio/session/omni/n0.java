package com.larus.im.internal.audio.session.omni;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f347330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f347331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f347332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f347333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f347334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f347335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f347336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f347337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f347338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f347339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f347340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicLong f347341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f347342m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f347343n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f347344o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f347345p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f347346q;

    public static final class a {
    }

    static {
    }

    public final void c() {
        Object r100 = this.f347333d;
        monitor-enter(r100);
        fe9.c r101 = fe9.c.f476624a;     // Catch: Throwable -> L7
        r101.a("OmniRefSignalProcessor", "clear: resetting buffer");     // Catch: Throwable -> L7
        f();     // Catch: Throwable -> L7
        this.f347341l.set(0);     // Catch: Throwable -> L7
        r101.a("OmniRefSignalProcessor", "clear: buffer stats " + d());     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final Map<String, Object> d() {
        Object r100 = this.f347333d;
        monitor-enter(r100);
        Map<String, Object> r101 = MapsKt.mapOf(new Pair[]{TuplesKt.to("bufferSize", Integer.valueOf(this.f347337h)), TuplesKt.to("bufferCapacity", Integer.valueOf(this.f347334e.length)), TuplesKt.to("lastUpdateTime", Long.valueOf(System.currentTimeMillis() - this.f347341l.get())), TuplesKt.to("bufferMs", Integer.valueOf(this.f347338i)), TuplesKt.to("trimKeepMs", Integer.valueOf(this.f347339j)), TuplesKt.to("maxSignalAgeMs", Long.valueOf(this.f347340k)), TuplesKt.to("enabled", Boolean.valueOf(this.f347342m)), TuplesKt.to("totalDequeueEmptySizeTrace", Long.valueOf(this.f347345p)), TuplesKt.to("totalDequeueSizeTrace", Long.valueOf(this.f347344o)), TuplesKt.to("totalOutdateSizeTrace", Long.valueOf(this.f347346q)), TuplesKt.to("totalEnqueueSizeTrace", Long.valueOf(this.f347343n)), TuplesKt.to("totalOutdateSizeTrace", Long.valueOf(this.f347346q))});     // Catch: Throwable -> L8
        monitor-exit(r100);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    public final void f() {
        int r100 = b(this.f347338i);
        fe9.c.f476624a.e("OmniRefSignalProcessor", "resetBuffer: using calculated buffer size " + r100 + " bytes for sampleRate=" + this.f347330a + ", channels=" + this.f347331b + ", bitsPerSample=" + this.f347332c + ", bufferTime=" + this.f347338i + "ms, trimKeepMs=" + this.f347339j + "ms, maxAgeMs=" + this.f347340k + "ms");
        this.f347334e = new byte[r100];
        this.f347335f = 0;
        this.f347336g = 0;
        this.f347337h = 0;
    }

    public final void i() {
        int r100 = this.f347335f;
        int r101 = this.f347336g;
        if (r100 > r101) goto L5;
        int r102 = r101 - r100;
    L7:
        if (r102 == this.f347337h) goto L10;
        fe9.c r103 = fe9.c.f476624a;
        r103.f("OmniRefSignalProcessor", "verifyBufferState: buffer state inconsistency detected! Calculated size=" + r102 + ", actual size=" + this.f347337h);
        this.f347336g = (this.f347335f + this.f347337h) % this.f347334e.length;
        StringBuilder r104 = new StringBuilder("verifyBufferState: buffer state restored - new end index=");
        r104.append(this.f347336g);
        r103.f("OmniRefSignalProcessor", r104.toString());
        return;
    L10:
        return;
    L5:
        r102 = r101 + (this.f347334e.length - r100);
        goto L7
    }

    public n0(m0 r100) {
        Intrinsics.checkNotNullParameter(r100, "refSignalConfig");
        this.f347330a = 24000;
        this.f347331b = 1;
        this.f347332c = 16;
        this.f347333d = new Object();
        int r101 = r100.f347326a;
        this.f347338i = r101;
        int r102 = r100.f347327b;
        this.f347339j = r102;
        this.f347340k = r100.f347328c;
        int r103 = b(r101);
        this.f347334e = new byte[r103];
        fe9.c.f476624a.e("OmniRefSignalProcessor", "OmniRefSignalProcessor initialized with " + r103 + " bytes buffer (buffer=" + r101 + "ms, trimKeep=" + r102 + "ms, maxAge=" + r100.f347328c + "ms)");
        this.f347341l = new AtomicLong(System.currentTimeMillis());
        this.f347342m = true;
    }

    public final void a(byte[] r100) {
        int r101 = r100.length;
        this.f347343n += (long) r101;
        int r102 = this.f347337h + r101;
        byte[] r103 = this.f347334e;
        if (r102 <= r103.length) goto L5;
        int r104 = r102 - r103.length;
        fe9.c.f476624a.f("OmniRefSignalProcessor", "addToCircularBuffer: buffer full, need to remove " + r104 + " bytes of oldest data");
        e(r104);
    L5:
        int r105 = Math.min(r101, this.f347334e.length - this.f347336g);
        if (r105 <= 0) goto L8;
        System.arraycopy(r100, 0, this.f347334e, this.f347336g, r105);
        int r106 = r105 + 0;
        int r107 = r101 - r105;
        this.f347336g += r105;
    L9:
        if (r107 <= 0) goto L11;
        System.arraycopy(r100, r106, this.f347334e, 0, r107);
        this.f347336g = r107;
    L11:
        this.f347337h += r101;
        if (this.f347336g != this.f347334e.length) goto L14;
        this.f347336g = 0;
    L14:
        i();
        return;
    L8:
        r107 = r101;
        r106 = 0;
        goto L9
    }

    public final int b(int r100) {
        int r101 = this.f347330a;
        int r102 = this.f347331b;
        int r103 = this.f347332c;
        if (r101 <= 0) goto L11;
        if (r102 <= 0) goto L11;
        if (r102 > 3) goto L11;
        if (r103 < 8) goto L11;
        int r104 = (((r101 / 1000) * r102) * r103) / 8;
    L13:
        return r100 * r104;
    L11:
        r104 = 0;
        goto L13
    }

    public final int e(int r100) {
        if (r100 <= 0) goto L13;
        int r101 = this.f347337h;
        if (r101 <= 0) goto L13;
        int r102 = Math.min(r100, r101);
        int r103 = this.f347335f + r102;
        byte[] r104 = this.f347334e;
        int r105 = r103 % r104.length;
        this.f347335f = r105;
        int r106 = this.f347337h - r102;
        this.f347337h = r106;
        if (r106 != 0) goto L10;
        this.f347335f = 0;
        this.f347336g = 0;
        fe9.c.f476624a.a("OmniRefSignalProcessor", "removeOldestData: buffer is now empty, reset all indices");
    L11:
        i();
        return r102;
    L10:
        this.f347336g = (r105 + r106) % r104.length;
    L13:
        fe9.c.f476624a.a("OmniRefSignalProcessor", "removeOldestData: no data to remove");
        return 0;
    }

    public final void g(int r100) {
        byte[] r101 = new byte[r100];
        int r102 = this.f347337h;
        if (r102 <= 0) goto L9;
        int r103 = this.f347335f;
        if (r103 >= this.f347336g) goto L7;
        System.arraycopy(this.f347334e, r103, r101, 0, r102);
    L8:
        this.f347335f = 0;
        this.f347336g = this.f347337h;
        goto L9
    L7:
        byte[] r104 = this.f347334e;
        int r105 = r104.length - r103;
        System.arraycopy(r104, r103, r101, 0, r105);
        System.arraycopy(this.f347334e, 0, r101, r105, this.f347336g);
    L9:
        this.f347334e = r101;
        fe9.c.f476624a.e("OmniRefSignalProcessor", "resizeBuffer: new capacity=" + r100);
    }

    public static void h(n0 r100, int r101, int r102) {
        Object r103 = r100.f347333d;
        monitor-enter(r103);
        fe9.c.f476624a.e("OmniRefSignalProcessor", "setAudioFormat: sampleRate=" + r101 + ", channels=" + r102 + ", bitsPerSample=16");     // Catch: Throwable -> L7
        r100.f347330a = r101;     // Catch: Throwable -> L7
        r100.f347331b = r102;     // Catch: Throwable -> L7
        r100.f347332c = 16;     // Catch: Throwable -> L7
        r100.f();     // Catch: Throwable -> L7
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r103);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
