package com.larus.dora.impl.frameassembler;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f335784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f335785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f335786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f335787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantLock f335788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Integer, byte[]> f335789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f335790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f335791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f335792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f335793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f335794k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f335795l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f335796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f335797n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f335798o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f335799p;

    /* JADX INFO: renamed from: com.larus.dora.impl.frameassembler.a$a, reason: collision with other inner class name */
    public static final class C4265a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f335800a = null;

        static {
            int[] r100 = new int[DoraDuplicateFramePolicy.values().length];
            r100[DoraDuplicateFramePolicy.FAIL_SESSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DoraDuplicateFramePolicy.OVERWRITE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DoraDuplicateFramePolicy.IGNORE_NEW.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f335800a = r100;
        }
    }

    static {
    }

    public abstract boolean a(byte[] r100, int r101);

    public abstract long e();

    public abstract void h(byte[] r100);

    public abstract void i(DoraIncompleteReason r100, byte[] r101, Throwable r102);

    public final h c() {
        return new h(this.f335784a, this.f335790g, this.f335791h, this.f335794k, this.f335799p, e());
    }

    public final void d(byte[] r100) {
    L2:
        byte[] r101 = (byte[]) ((TreeMap) this.f335789f).remove(Integer.valueOf(this.f335795l));
        if (r101 == null) goto L4;
        this.f335797n -= (long) r101.length;
        this.f335786c.a(r101.length);
        if (a(r101, this.f335795l + 0) == false) goto L7;
        this.f335796m++;
        this.f335795l++;
        goto L2
    L7:
        i(DoraIncompleteReason.RESOURCE_LIMIT, r100, new IllegalStateException("appendInOrder failed while flushing buffered frames"));
        return;
    }

    public final boolean b(int r100, byte[] r110) {
        int r101 = ((TreeMap) this.f335789f).size();
        e r102 = this.f335785b;
        if (r101 < r102.f335813f) goto L5;
        return false;
    L5:
        long r103 = r110.length;
        if ((this.f335797n + r103) <= r102.f335812e) goto L9;
        return false;
    L9:
        if (this.f335786c.c(r103) == true) goto L11;
        return false;
    L11:
        this.f335797n += r103;
        byte[] r111 = (byte[]) ((TreeMap) this.f335789f).put(Integer.valueOf(r100), r110);
        if (r111 != null) goto L14;
        return true;
    L14:
        if (this.f335785b.f335816i != DoraDuplicateFramePolicy.OVERWRITE) goto L16;
        this.f335797n -= (long) r111.length;
        this.f335786c.a(r111.length);
        return true;
    L16:
        ((TreeMap) this.f335789f).put(Integer.valueOf(r100), r111);
        this.f335797n -= r103;
        this.f335786c.a(r103);
        return true;
    }

    public final void f(int r100, byte[] r101) {
        int r102 = b.f335800a[this.f335785b.f335816i.ordinal()];
        if (r102 != 1) goto L5;
        i(DoraIncompleteReason.UNKNOWN, r101, new IllegalStateException("duplicate frame seq=" + r100));
        return;
    L5:
        if (r102 != 2) goto L7;
        return;
    L7:
        if (r102 != 3) goto L10;
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public a(i r100, e r101, g r102, f r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "resourceTracker");
        Intrinsics.checkNotNullParameter(r103, "metrics");
        this.f335784a = r100;
        this.f335785b = r101;
        this.f335786c = r102;
        this.f335787d = r103;
        this.f335788e = new ReentrantLock();
        this.f335789f = new TreeMap();
        this.f335790g = r104;
        this.f335791h = r104;
    }

    public final void g(int r110, int r111, int r112, int r113, byte[] r210, byte[] r211) {
        Intrinsics.checkNotNullParameter(r210, "data");
        this.f335788e.lock();
    L45:
        th = move-exception;
        this.f335788e.unlock();
        throw th;
    L4:
        if (this.f335798o == true) goto L39;
        g49.d.d("DoraAbstractFrameSession", "handleFrame, dataId=" + this.f335784a.f335846a + ", scene=" + r110 + ", type=" + r111 + ", seq=" + r112 + ", totalSeq=" + r113 + ", baseSeqInitialized=" + this.f335792i + ", nextExpectedIndex=" + this.f335795l);     // Catch: Throwable -> L45
        long r114 = System.currentTimeMillis();     // Catch: Throwable -> L45
        if (r112 != 0) goto L10;
        this.f335795l = 0;     // Catch: Throwable -> L45
        this.f335796m = 0;     // Catch: Throwable -> L45
        this.f335792i = true;     // Catch: Throwable -> L45
    L10:
        if (this.f335793j == true) goto L13;
        this.f335793j = true;     // Catch: Throwable -> L45
        this.f335794k = r113;     // Catch: Throwable -> L45
    L17:
        this.f335791h = r114;     // Catch: Throwable -> L45
        int r100 = r112 + 0;     // Catch: Throwable -> L45
        if (r100 >= 0) goto L21;
        g49.d.b("DoraAbstractFrameSession", "index < 0, handleDuplicateFrame");     // Catch: Throwable -> L45
        f(r112, r211);     // Catch: Throwable -> L45
        goto L39
    L21:
        if (r100 < this.f335794k) goto L23;
        i(DoraIncompleteReason.TOTAL_SEQ_MISMATCH, r211, new IllegalStateException("seq out of range, index=" + r100 + ", totalSeq=" + this.f335794k));     // Catch: Throwable -> L45
        goto L39
    L23:
        int r101 = this.f335795l;     // Catch: Throwable -> L45
        if (r100 >= r101) goto L27;
        g49.d.b("DoraAbstractFrameSession", "index < nextExpectedIndex, handleDuplicateFrame");     // Catch: Throwable -> L45
        f(r112, r211);     // Catch: Throwable -> L45
        goto L39
    L27:
        if (this.f335792i == false) goto L34;
        if (r100 != r101) goto L34;
        if (a(r210, r112) == true) goto L32;
        i(DoraIncompleteReason.RESOURCE_LIMIT, r211, new IllegalStateException("appendInOrder failed due to resource limit"));     // Catch: Throwable -> L45
        goto L39
    L32:
        this.f335796m++;     // Catch: Throwable -> L45
        this.f335795l++;     // Catch: Throwable -> L45
        d(r211);     // Catch: Throwable -> L45
    L42:
        if (this.f335796m != this.f335794k) goto L39;
        this.f335798o = true;     // Catch: Throwable -> L45
        h(r211);     // Catch: Throwable -> L45
    L34:
        if (this.f335785b.f335819l == false) goto L37;
        i(DoraIncompleteReason.SEQ_MISMATCH, r211, new IllegalStateException("seq mismatch, strict check enabled, index=" + r100 + ", nextExpectedIndex=" + this.f335795l));     // Catch: Throwable -> L45
        goto L39
    L37:
        if (b(r100, r210) == true) goto L42;
        i(DoraIncompleteReason.RESOURCE_LIMIT, r211, new IllegalStateException("bufferOutOfOrderFrame failed due to resource limit"));     // Catch: Throwable -> L45
        goto L39
    L13:
        if (this.f335785b.f335818k == false) goto L17;
        if (r113 == this.f335794k) goto L17;
        i(DoraIncompleteReason.TOTAL_SEQ_MISMATCH, r211, new IllegalStateException("totalSeq mismatch, expected=" + this.f335794k + ", actual=" + r113));     // Catch: Throwable -> L45
    L39:
        this.f335788e.unlock();
    }
}
