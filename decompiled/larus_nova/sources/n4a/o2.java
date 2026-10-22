package n4a;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public final class o2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile o2 f517565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object f517566h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LongSparseArray<a> f517567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LongSparseArray<a> f517568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LongSparseArray<a> f517569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LongSparseArray<a> f517570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f517571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f517572f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f517573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f517574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f517575c;

        public a() {
        }
    }

    static {
        f517566h = new Object();
    }

    public o2() {
        this.f517571e = new Object();
        this.f517572f = new Object();
        this.f517567a = new LongSparseArray();
        this.f517568b = new LongSparseArray();
        this.f517569c = new LongSparseArray();
        this.f517570d = new LongSparseArray();
    }

    public static o2 a() {
        if (f517565g != null) goto L15;
        Object r100 = f517566h;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f517565g != null) goto L9;
        f517565g = new o2();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return f517565g;
    }

    public final void c(List<n2> r100) {
        if (((ArrayList) r100).isEmpty() == false) goto L5;
        return;
    L5:
        Object r101 = this.f517571e;
        monitor-enter(r101);
        d(r100, this.f517567a, this.f517568b);     // Catch: Throwable -> L10
        LongSparseArray<a> r102 = this.f517567a;     // Catch: Throwable -> L10
        this.f517567a = this.f517568b;     // Catch: Throwable -> L10
        this.f517568b = r102;     // Catch: Throwable -> L10
        r102.clear();     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void e(List<n2> r100) {
        if (((ArrayList) r100).isEmpty() == false) goto L5;
        return;
    L5:
        Object r101 = this.f517572f;
        monitor-enter(r101);
        d(r100, this.f517569c, this.f517570d);     // Catch: Throwable -> L10
        LongSparseArray<a> r102 = this.f517569c;     // Catch: Throwable -> L10
        this.f517569c = this.f517570d;     // Catch: Throwable -> L10
        this.f517570d = r102;     // Catch: Throwable -> L10
        r102.clear();     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static short b(LongSparseArray<a> r100, long r101) {
        monitor-enter(r100);
        a r102 = r100.get(r101);     // Catch: Throwable -> L14
        if (r102 != null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L14
        return 0;
    L8:
        short r103 = (short) Math.max(1, Math.min(32767, (SystemClock.elapsedRealtime() - r102.f517574b) / 1000));     // Catch: Throwable -> L14
        if (r102.f517575c == true) goto L12;
        r103 = (short) (-r103);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return r103;
    L14:
        th = move-exception;
        throw th;
    }

    public static void d(List<n2> r100, LongSparseArray<a> r101, LongSparseArray<a> r110) {
        long r102 = SystemClock.elapsedRealtime();
        int r103 = r101.size();
        Iterator r104 = ((ArrayList) r100).iterator();
        if (r103 != 0) goto L9;
    L5:
        if (r104.hasNext() == false) goto L7;
        n2 r105 = (n2) r104.next();
        a r106 = new a();
        r106.f517573a = r105.b();
        r106.f517574b = r102;
        r106.f517575c = false;
        r110.put(r105.a(), r106);
        goto L5
    L7:
        return;
    L9:
        if (r104.hasNext() == false) goto L17;
        n2 r107 = (n2) r104.next();
        long r108 = r107.a();
        a r109 = r101.get(r108);
        if (r109 != null) goto L14;
        r109 = new a();
    L15:
        r109.f517573a = r107.b();
        r109.f517574b = r102;
        r109.f517575c = true;
    L16:
        r110.put(r108, r109);
        goto L9
    L14:
        if (r109.f517573a == r107.b()) goto L16;
    }
}
