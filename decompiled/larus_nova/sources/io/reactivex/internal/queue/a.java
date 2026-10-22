package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import vtc.i;

/* JADX INFO: loaded from: classes41.dex */
public final class a<T> implements i<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f494904i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f494905j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f494906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f494907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f494908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f494909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicReferenceArray<Object> f494910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f494911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicReferenceArray<Object> f494912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f494913h;

    static {
        f494904i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        f494905j = new Object();
    }

    @Override // vtc.j
    public final boolean isEmpty() {
        if (this.f494906a.get() != this.f494913h.get()) goto L5;
        return true;
    L5:
        return false;
    }

    public final T peek() {
        AtomicReferenceArray<Object> r100 = this.f494912g;
        long r101 = this.f494913h.get();
        int r102 = this.f494911f;
        int r103 = ((int) r101) & r102;
        T r104 = (T) r100.get(r103);
        if (r104 != f494905j) goto L6;
        int r105 = r102 + 1;
        AtomicReferenceArray<Object> r106 = (AtomicReferenceArray) r100.get(r105);
        r100.lazySet(r105, null);
        this.f494912g = r106;
        return (T) r106.get(r103);
    L6:
        return r104;
    }

    @Override // vtc.i, vtc.j
    public final T poll() {
        AtomicReferenceArray<Object> r100 = this.f494912g;
        long r101 = this.f494913h.get();
        int r102 = this.f494911f;
        int r103 = ((int) r101) & r102;
        T r104 = (T) r100.get(r103);
        if (r104 != f494905j) goto L5;
        boolean r105 = true;
    L7:
        if (r104 == null) goto L11;
        if (r105 == true) goto L11;
        r100.lazySet(r103, null);
        AtomicLong r106 = this.f494913h;
        r106.lazySet(r101 + 1);
        return r104;
    L11:
        if (r105 == false) goto L16;
        int r107 = r102 + 1;
        AtomicReferenceArray<Object> r108 = (AtomicReferenceArray) r100.get(r107);
        r100.lazySet(r107, null);
        this.f494912g = r108;
        T r109 = (T) r108.get(r103);
        if (r109 == null) goto L15;
        r108.lazySet(r103, null);
        AtomicLong r110 = this.f494913h;
        r110.lazySet(r101 + 1);
    L15:
        return r109;
    L16:
        return null;
    L5:
        r105 = false;
        goto L7
    }

    @Override // vtc.j
    public final void clear() {
    L3:
        if (poll() != null) goto L3;
        if (isEmpty() == false) goto L3;
    }

    public a(int r100) {
        AtomicLong r101 = new AtomicLong();
        this.f494906a = r101;
        this.f494913h = new AtomicLong();
        int r102 = 1 << (32 - Integer.numberOfLeadingZeros(Math.max(8, r100) - 1));
        int r103 = r102 - 1;
        AtomicReferenceArray<Object> r104 = new AtomicReferenceArray(r102 + 1);
        this.f494910e = r104;
        this.f494909d = r103;
        this.f494907b = Math.min(r102 / 4, f494904i);
        this.f494912g = r104;
        this.f494911f = r103;
        this.f494908c = r103 - 1;
        r101.lazySet(0);
    }

    @Override // vtc.j
    public final boolean offer(T r110) {
        if (r110 == null) goto L18;
        AtomicReferenceArray<Object> r100 = this.f494910e;
        long r101 = this.f494906a.get();
        int r102 = this.f494909d;
        int r103 = ((int) r101) & r102;
        if (r101 >= this.f494908c) goto L7;
        r100.lazySet(r103, r110);
        this.f494906a.lazySet(r101 + 1);
        return true;
    L7:
        long r104 = ((long) this.f494907b) + r101;
        if (r100.get(((int) r104) & r102) != null) goto L11;
        this.f494908c = r104 - 1;
        r100.lazySet(r103, r110);
        this.f494906a.lazySet(r101 + 1);
        return true;
    L11:
        long r105 = r101 + 1;
        if (r100.get(((int) r105) & r102) != null) goto L15;
        r100.lazySet(r103, r110);
        this.f494906a.lazySet(r105);
        return true;
    L15:
        AtomicReferenceArray<Object> r111 = new AtomicReferenceArray(r100.length());
        this.f494910e = r111;
        this.f494908c = (r102 + r101) - 1;
        r111.lazySet(r103, r110);
        r100.lazySet(r100.length() - 1, r111);
        r100.lazySet(r103, f494905j);
        this.f494906a.lazySet(r105);
        return true;
    L18:
        throw new NullPointerException("Null is not a valid element");
    }

    public final boolean a(T r100, T r110) {
        AtomicReferenceArray<Object> r101 = this.f494910e;
        long r102 = this.f494906a.get();
        int r103 = this.f494909d;
        long r104 = 2 + r102;
        if (r101.get(((int) r104) & r103) != null) goto L5;
        int r105 = ((int) r102) & r103;
        r101.lazySet(r105 + 1, r110);
        r101.lazySet(r105, r100);
        this.f494906a.lazySet(r104);
        return true;
    L5:
        AtomicReferenceArray<Object> r106 = new AtomicReferenceArray(r101.length());
        this.f494910e = r106;
        int r107 = ((int) r102) & r103;
        r106.lazySet(r107 + 1, r110);
        r106.lazySet(r107, r100);
        r101.lazySet(r101.length() - 1, r106);
        r101.lazySet(r107, f494905j);
        this.f494906a.lazySet(r104);
        return true;
    }
}
