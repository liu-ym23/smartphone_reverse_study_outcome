package com.obric.oui.orecyclerview.widget;

import androidx.core.os.TraceCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes34.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<s> f401941e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f401942f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<RecyclerView> f401943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f401944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f401945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<c> f401946d;

    public class a implements Comparator<c> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(c r100, c r101) {
            c r102 = r100;
            c r103 = r101;
            RecyclerView r104 = r102.f401954d;
            int r105 = 1;
            if (r104 != null) goto L5;
            boolean r106 = true;
        L7:
            if (r103.f401954d != null) goto L9;
            boolean r107 = true;
        L11:
            if (r106 == r107) goto L14;
            if (r104 == null) goto L26;
        L17:
            r105 = -1;
        L26:
            return r105;
        L14:
            boolean r108 = r102.f401951a;
            if (r108 == r103.f401951a) goto L19;
            if (r108 == false) goto L26;
        L19:
            int r109 = r103.f401952b - r102.f401952b;
            if (r109 != 0) goto L27;
            int r110 = r102.f401953c - r103.f401953c;
            if (r110 != 0) goto L25;
            return 0;
        L25:
            return r110;
        L27:
            return r109;
        L9:
            r107 = false;
            goto L11
        L5:
            r106 = false;
            goto L7
        }
    }

    public static class b implements RecyclerView.k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f401947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f401949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f401950d;

        public b() {
        }

        public final void a(int r100, int r101) {
            if (r100 < 0) goto L15;
            if (r101 < 0) goto L13;
            int r102 = this.f401950d * 2;
            int[] r103 = this.f401949c;
            if (r103 != null) goto L8;
            int[] r104 = new int[4];
            this.f401949c = r104;
            Arrays.fill(r104, -1);
        L10:
            int[] r105 = this.f401949c;
            r105[r102] = r100;
            r105[r102 + 1] = r101;
            this.f401950d++;
            return;
        L8:
            if (r102 < r103.length) goto L10;
            int[] r106 = new int[r102 * 2];
            this.f401949c = r106;
            System.arraycopy(r103, 0, r106, 0, r103.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public final void b(RecyclerView r100, boolean r101) {
            boolean r102 = false;
            this.f401950d = 0;
            int[] r103 = this.f401949c;
            if (r103 == null) goto L5;
            Arrays.fill(r103, -1);
        L5:
            RecyclerView.k r104 = r100.f401621m;
            if (r100.f401620l == null) goto L27;
            if (r104 != null) goto L9;
            return;
        L9:
            if (r104.f401667g == false) goto L29;
            if (r101 == false) goto L15;
            if (r100.f401607d.g() == true) goto L23;
            r104.h(r100.f401620l.a(), this);
        L23:
            int r105 = this.f401950d;
            if (r105 <= r104.f401668h) goto L30;
            r104.f401668h = r105;
            r104.f401669i = r101;
            r100.f401603b.m();
            return;
        L30:
            return;
        L15:
            if (r100.f401631u == true) goto L17;
        L20:
            r102 = true;
        L21:
            if (r102 == true) goto L23;
            r104.g(this.f401947a, this.f401948b, r100.L0, this);
            goto L23
        L17:
            if (r100.C == true) goto L20;
            if (r100.f401607d.g() == false) goto L21;
        L29:
            return;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f401951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f401952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f401953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f401954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f401955e;

        public c() {
        }
    }

    static {
        f401941e = new ThreadLocal();
        f401942f = new a();
    }

    public final void a() {
        TraceCompat.beginSection("RV Prefetch");     // Catch: Throwable -> L19
        if (this.f401943a.isEmpty() == false) goto L7;
    L5:
        this.f401944b = 0;
        TraceCompat.endSection();
        return;
    L7:
        int r100 = this.f401943a.size();     // Catch: Throwable -> L19
        int r101 = 0;
        long r102 = 0;
    L8:
        if (r101 >= r100) goto L14;
        RecyclerView r103 = this.f401943a.get(r101);     // Catch: Throwable -> L19
        if (r103.getWindowVisibility() != 0) goto L12;
        r102 = Math.max(r103.getDrawingTime(), r102);     // Catch: Throwable -> L19
    L12:
        r101 = r101 + 1;     // Catch: Throwable -> L19
        goto L8
    L14:
        if (r102 == 0) goto L5;
        c(TimeUnit.MILLISECONDS.toNanos(r102) + this.f401945c);     // Catch: Throwable -> L19
        this.f401944b = 0;
        TraceCompat.endSection();
        return;
    L19:
        th = move-exception;
        this.f401944b = 0;
        TraceCompat.endSection();
        throw th;
    }

    public s() {
        this.f401943a = new ArrayList();
        this.f401946d = new ArrayList();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final void c(long r110) {
        int r100 = this.f401943a.size();
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L8;
        RecyclerView r103 = (RecyclerView) ListProtector.get(this.f401943a, r101);
        if (r103.getWindowVisibility() != 0) goto L7;
        r103.H0.b(r103, false);
        r102 = r102 + r103.H0.f401950d;
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        this.f401946d.ensureCapacity(r102);
        int r104 = 0;
        int r105 = 0;
    L10:
        if (r104 >= r100) goto L27;
        RecyclerView r106 = (RecyclerView) ListProtector.get(this.f401943a, r104);
        if (r106.getWindowVisibility() != 0) goto L26;
        b r107 = r106.H0;
        int r108 = Math.abs(r107.f401947a) + Math.abs(r107.f401948b);
        int r109 = 0;
    L16:
        if (r109 >= (r107.f401950d * 2)) goto L26;
        if (r105 < this.f401946d.size()) goto L20;
        c r111 = new c();
        this.f401946d.add(r111);
    L21:
        int[] r112 = r107.f401949c;
        int r113 = r112[r109 + 1];
        if (r113 > r108) goto L24;
        boolean r114 = true;
    L25:
        r111.f401951a = r114;
        r111.f401952b = r108;
        r111.f401953c = r113;
        r111.f401954d = r106;
        r111.f401955e = r112[r109];
        r105 = r105 + 1;
        r109 = r109 + 2;
        goto L16
    L24:
        r114 = false;
        goto L25
    L20:
        r111 = (c) ListProtector.get(this.f401946d, r105);
    L26:
        r104 = r104 + 1;
        goto L10
    L27:
        Collections.sort(this.f401946d, f401942f);
        int r115 = 0;
    L29:
        if (r115 >= this.f401946d.size()) goto L65;
        c r116 = (c) ListProtector.get(this.f401946d, r115);
        RecyclerView r117 = r116.f401954d;
        if (r117 == null) goto L86;
        if (r116.f401951a == false) goto L36;
        long r118 = Long.MAX_VALUE;
    L37:
        RecyclerView.y r119 = d(r117, r116.f401955e, r118);
        if (r119 == null) goto L64;
        if (r119.f401729b == null) goto L64;
        if (r119.f() == false) goto L64;
        if (r119.g() == true) goto L64;
        RecyclerView r120 = r119.f401729b.get();
        if (r120 == null) goto L64;
        if (r120.C == true) goto L51;
    L53:
        b r121 = r120.H0;
        r121.b(r120, true);
        if (r121.f401950d == 0) goto L64;
        TraceCompat.beginSection("RV Nested Prefetch");     // Catch: Throwable -> L61
        RecyclerView.v r122 = r120.L0;     // Catch: Throwable -> L61
        RecyclerView.Adapter r123 = r120.f401620l;     // Catch: Throwable -> L61
        r122.f401709d = 1;     // Catch: Throwable -> L61
        r122.f401710e = r123.a();     // Catch: Throwable -> L61
        r122.f401712g = false;     // Catch: Throwable -> L61
        r122.f401713h = false;     // Catch: Throwable -> L61
        r122.f401714i = false;     // Catch: Throwable -> L61
        int r124 = 0;
    L57:
        if (r124 >= (r121.f401950d * 2)) goto L60;
        d(r120, r121.f401949c[r124], r110);     // Catch: Throwable -> L61
        r124 = r124 + 2;
        goto L57
    L60:
        TraceCompat.endSection();
    L61:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    L51:
        if (r120.f401608e.h() == 0) goto L53;
        r120.R();
    L64:
        r116.f401951a = false;
        r116.f401952b = 0;
        r116.f401953c = 0;
        r116.f401954d = null;
        r116.f401955e = 0;
        r115 = r115 + 1;
        goto L29
    L36:
        r118 = r110;
        goto L37
    L86:
        return;
    }

    public static RecyclerView.y d(RecyclerView r100, int r101, long r102) {
        int r103 = r100.f401608e.h();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        RecyclerView.y r105 = RecyclerView.E(r100.f401608e.g(r104));
        if (r105.f401730c != r101) goto L9;
        if (r105.g() == true) goto L9;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L14;
        return null;
    L14:
        RecyclerView.q r107 = r100.f401603b;
        r100.K();     // Catch: Throwable -> L25
        RecyclerView.y r108 = r107.k(r101, r102);     // Catch: Throwable -> L25
        if (r108 != null) goto L18;
    L23:
        r100.L(false);
        return r108;
    L18:
        if (r108.f() == true) goto L20;
    L22:
        r107.a(r108, false);     // Catch: Throwable -> L25
        goto L23
    L20:
        if (r108.g() == true) goto L22;
        r107.h(r108.f401728a);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r100.L(false);
        throw th;
    L9:
        r104 = r104 + 1;
        goto L3
    L10:
        r106 = false;
        goto L11
    }

    public final void b(RecyclerView r100, int r101, int r102) {
        if (r100.isAttachedToWindow() == true) goto L5;
    L14:
        b r103 = r100.H0;
        r103.f401947a = r101;
        r103.f401948b = r102;
        return;
    L5:
        if (RecyclerView.f401596h2 == false) goto L12;
        if (this.f401943a.contains(r100) == true) goto L12;
        throw new IllegalStateException("attempting to post unregistered view!");
    L12:
        if (this.f401944b != 0) goto L14;
        this.f401944b = r100.getNanoTime();
        r100.post(this);
        goto L14
    }
}
