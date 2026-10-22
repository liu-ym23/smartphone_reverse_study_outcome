package com.google.common.collect;

import java.util.Arrays;
import javax.annotation.CheckForNull;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public class c2<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Object[] f275438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient int[] f275439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f275440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient int f275441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient int[] f275442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient long[] f275443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient float f275444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int f275445h;

    public class a extends Multisets.a<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ParametricNullness
        public final K f275446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f275447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c2 f275448c;

        @Override // com.google.common.collect.y1.a
        public final int getCount() {
            int r100 = this.f275447b;
            if (r100 == (-1)) goto L8;
            c2 r101 = this.f275448c;
            if (r100 >= r101.f275440c) goto L8;
            if (com.google.common.base.k.a(this.f275446a, r101.f275438a[r100]) == false) goto L8;
        L9:
            int r102 = this.f275447b;
            if (r102 != (-1)) goto L13;
            return 0;
        L13:
            return this.f275448c.f275439b[r102];
        L8:
            this.f275447b = this.f275448c.f(this.f275446a);
            goto L9
        }

        @Override // com.google.common.collect.y1.a
        @ParametricNullness
        public final K getElement() {
            return this.f275446a;
        }

        public a(c2 r100, int r101) {
            this.f275448c = r100;
            this.f275446a = (K) r100.f275438a[r101];
            this.f275447b = r101;
        }
    }

    public int k(int r100, int r101) {
        return r100 - 1;
    }

    public void a() {
        this.f275441d++;
        Arrays.fill(this.f275438a, 0, this.f275440c, null);
        Arrays.fill(this.f275439b, 0, this.f275440c, 0);
        Arrays.fill(this.f275442e, -1);
        Arrays.fill(this.f275443f, -1);
        this.f275440c = 0;
    }

    public int c() {
        if (this.f275440c != 0) goto L5;
        return -1;
    L5:
        return 0;
    }

    public c2() {
        g(3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c2(c2<? extends K> r100) {
        g(r100.f275440c);
        int r101 = r100.c();
    L4:
        if (r101 == (-1)) goto L6;
        com.google.common.base.m.j(r101, r100.f275440c);
        l(r100.f275438a[r101], r100.e(r101));
        r101 = r100.j(r101);
        goto L4
    }

    public final void b(int r100) {
        if (r100 <= this.f275443f.length) goto L6;
        o(r100);
    L6:
        if (r100 < this.f275445h) goto L9;
        p(Math.max(2, Integer.highestOneBit(r100 - 1) << 1));
        return;
    }

    public final int d(@CheckForNull Object r100) {
        int r101 = f(r100);
        if (r101 != (-1)) goto L6;
        return 0;
    L6:
        return this.f275439b[r101];
    }

    public final int e(int r100) {
        com.google.common.base.m.j(r100, this.f275440c);
        return this.f275439b[r100];
    }

    public final int f(@CheckForNull Object r100) {
        int r101 = u0.c(r100);
        int[] r102 = this.f275442e;
        int r103 = r102[(r102.length - 1) & r101];
    L3:
        if (r103 == (-1)) goto L10;
        long r104 = this.f275443f[r103];
        if (((int) (r104 >>> 32)) != r101) goto L9;
        if (com.google.common.base.k.a(r100, this.f275438a[r103]) == false) goto L9;
        return r103;
    L9:
        r103 = (int) r104;
        goto L3
    L10:
        return -1;
    }

    public void g(int r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        com.google.common.base.m.c(r101, "Initial capacity must be non-negative");
        int r102 = u0.a(r100, 1.0f);
        int[] r103 = new int[r102];
        Arrays.fill(r103, -1);
        this.f275442e = r103;
        this.f275444g = 1.0f;
        this.f275438a = new Object[r100];
        this.f275439b = new int[r100];
        long[] r104 = new long[r100];
        Arrays.fill(r104, -1);
        this.f275443f = r104;
        this.f275445h = Math.max(1, (int) (r102 * 1.0f));
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void i(int r110) {
        int r100 = this.f275440c - 1;
        if (r110 >= r100) goto L11;
        Object[] r101 = this.f275438a;
        r101[r110] = r101[r100];
        int[] r102 = this.f275439b;
        r102[r110] = r102[r100];
        r101[r100] = null;
        r102[r100] = 0;
        long[] r103 = this.f275443f;
        long r104 = r103[r100];
        r103[r110] = r104;
        r103[r100] = -1;
        int[] r105 = this.f275442e;
        int r106 = ((int) (r104 >>> 32)) & (r105.length - 1);
        int r107 = r105[r106];
        if (r107 != r100) goto L7;
        r105[r106] = r110;
        return;
    L7:
        long[] r108 = this.f275443f;
        long r109 = r108[r107];
        int r111 = (int) r109;
        if (r111 == r100) goto L9;
        r107 = r111;
        goto L7
    L9:
        r108[r107] = (r109 & (-4294967296L)) | (BodyPartID.bodyIdMax & ((long) r110));
        return;
    L11:
        this.f275438a[r110] = null;
        this.f275439b[r110] = 0;
        this.f275443f[r110] = -1;
    }

    public int j(int r100) {
        int r101 = r100 + 1;
        if (r101 < this.f275440c) goto L7;
        return -1;
    L7:
        return r101;
    }

    public final int n(int r100) {
        return m(this.f275438a[r100], (int) (this.f275443f[r100] >>> 32));
    }

    public void o(int r100) {
        this.f275438a = Arrays.copyOf(this.f275438a, r100);
        this.f275439b = Arrays.copyOf(this.f275439b, r100);
        long[] r101 = this.f275443f;
        int r102 = r101.length;
        long[] r103 = Arrays.copyOf(r101, r100);
        if (r100 <= r102) goto L5;
        Arrays.fill(r103, r102, r100, -1);
    L5:
        this.f275443f = r103;
    }

    public final void p(int r110) {
        if (this.f275442e.length < 1073741824) goto L6;
        this.f275445h = Integer.MAX_VALUE;
        return;
    L6:
        int r100 = ((int) (r110 * this.f275444g)) + 1;
        int[] r101 = new int[r110];
        Arrays.fill(r101, -1);
        long[] r102 = this.f275443f;
        int r111 = r110 - 1;
        int r103 = 0;
    L8:
        if (r103 >= this.f275440c) goto L10;
        int r104 = (int) (r102[r103] >>> 32);
        int r105 = r104 & r111;
        int r106 = r101[r105];
        r101[r105] = r103;
        r102[r103] = (((long) r104) << 32) | (((long) r106) & BodyPartID.bodyIdMax);
        r103 = r103 + 1;
        goto L8
    L10:
        this.f275445h = r100;
        this.f275442e = r101;
    }

    public c2(int r100) {
        this(r100, 0);
    }

    public c2(int r100, int r101) {
        g(r100);
    }

    public final int l(@ParametricNullness K r110, int r111) {
        o.d(r111, "count");
        long[] r100 = this.f275443f;
        Object[] r101 = this.f275438a;
        int[] r102 = this.f275439b;
        int r103 = u0.c(r110);
        int[] r104 = this.f275442e;
        int r105 = (r104.length - 1) & r103;
        int r106 = this.f275440c;
        int r107 = r104[r105];
        if (r107 != (-1)) goto L5;
        r104[r105] = r106;
    L14:
        int r108 = Integer.MAX_VALUE;
        if (r106 == Integer.MAX_VALUE) goto L30;
        int r109 = r106 + 1;
        int r112 = this.f275443f.length;
        if (r109 <= r112) goto L24;
        int r113 = Math.max(1, r112 >>> 1) + r112;
        if (r113 < 0) goto L22;
        r108 = r113;
    L22:
        if (r108 == r112) goto L24;
        o(r108);
    L24:
        h(r106, r110, r111, r103);
        this.f275440c = r109;
        if (r106 < this.f275445h) goto L27;
        p(this.f275442e.length * 2);
    L27:
        this.f275441d++;
        return 0;
    L30:
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    L5:
        long r114 = r100[r107];
        if (((int) (r114 >>> 32)) == r103) goto L8;
    L11:
        int r115 = (int) r114;
        if (r115 == (-1)) goto L13;
        r107 = r115;
        goto L5
    L13:
        r100[r107] = ((-4294967296L) & r114) | (BodyPartID.bodyIdMax & ((long) r106));
        goto L14
    L8:
        if (com.google.common.base.k.a(r110, r101[r107]) == false) goto L11;
        int r116 = r102[r107];
        r102[r107] = r111;
        return r116;
    }

    public final int m(@CheckForNull Object r110, int r111) {
        int[] r100 = this.f275442e;
        int r101 = (r100.length - 1) & r111;
        int r102 = r100[r101];
        if (r102 != (-1)) goto L5;
        return 0;
    L5:
        int r103 = -1;
    L7:
        if (((int) (this.f275443f[r102] >>> 32)) == r111) goto L9;
    L16:
        int r104 = (int) this.f275443f[r102];
        if (r104 == (-1)) goto L18;
        r103 = r102;
        r102 = r104;
        goto L7
    L18:
        return 0;
    L9:
        if (com.google.common.base.k.a(r110, this.f275438a[r102]) == false) goto L16;
        int r112 = this.f275439b[r102];
        if (r103 != (-1)) goto L13;
        this.f275442e[r101] = (int) this.f275443f[r102];
    L14:
        i(r102);
        this.f275440c--;
        this.f275441d++;
        return r112;
    L13:
        long[] r113 = this.f275443f;
        r113[r103] = (r113[r103] & (-4294967296L)) | (BodyPartID.bodyIdMax & ((long) ((int) r113[r102])));
        goto L14
    }

    public void h(int r100, @ParametricNullness K r101, int r102, int r103) {
        this.f275443f[r100] = (((long) r103) << 32) | BodyPartID.bodyIdMax;
        this.f275438a[r100] = r101;
        this.f275439b[r100] = r102;
    }
}
