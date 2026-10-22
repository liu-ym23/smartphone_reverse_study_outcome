package ok9;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f523708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f523709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f523710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f523711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f523712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f523713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f523714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f523715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f523716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f523717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f523718k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f523719l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Long f523720m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f523721n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f523722o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f523723p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f523724q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f523725r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f523726s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f523727t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f523728u;

    /* JADX INFO: renamed from: ok9.a$a, reason: collision with other inner class name */
    public static final class C7063a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f523729a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f523730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f523731c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f523732d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f523733e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f523734f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f523729a, r101.f523729a) == true) goto L12;
            return false;
        L12:
            if (this.f523730b == r101.f523730b) goto L15;
            return false;
        L15:
            if (this.f523731c == r101.f523731c) goto L18;
            return false;
        L18:
            if (this.f523732d == r101.f523732d) goto L21;
            return false;
        L21:
            if (Float.compare(this.f523733e, r101.f523733e) == 0) goto L24;
            return false;
        L24:
            if (this.f523734f == r101.f523734f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f523729a.hashCode() * 31;
            long r101 = this.f523730b;
            int r102 = (((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f523731c) * 31) + this.f523732d) * 31) + Float.floatToIntBits(this.f523733e)) * 31;
            long r103 = this.f523734f;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "MetricEvent(action=" + this.f523729a + ", silentMs=" + this.f523730b + ", retryCount=" + this.f523731c + ", maxRetryCount=" + this.f523732d + ", amplitude=" + this.f523733e + ", recoveryCostMs=" + this.f523734f + ')';
        }

        public b(String r100, long r101, int r102, int r103, float r104, long r105) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f523729a = r100;
            this.f523730b = r101;
            this.f523731c = r102;
            this.f523732d = r103;
            this.f523733e = r104;
            this.f523734f = r105;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f523735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f523736b;

        public c() {
            this(null, null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f523735a, r101.f523735a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f523736b, r101.f523736b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            d r100 = this.f523735a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            b r104 = this.f523736b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "RecordDecision(restartDecision=" + this.f523735a + ", metricEvent=" + this.f523736b + ')';
        }

        public c(d r100, b r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this.f523735a = r100;
            this.f523736b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f523737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f523738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f523739c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f523740d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f523737a == r101.f523737a) goto L12;
            return false;
        L12:
            if (this.f523738b == r101.f523738b) goto L15;
            return false;
        L15:
            if (this.f523739c == r101.f523739c) goto L18;
            return false;
        L18:
            if (Float.compare(this.f523740d, r101.f523740d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f523737a;
            return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f523738b) * 31) + this.f523739c) * 31) + Float.floatToIntBits(this.f523740d);
        }

        public final String toString() {
            return "RestartDecision(silentMs=" + this.f523737a + ", retryCount=" + this.f523738b + ", maxRetryCount=" + this.f523739c + ", amplitude=" + this.f523740d + ')';
        }

        public d(long r100, int r101, int r102, float r103) {
            this.f523737a = r100;
            this.f523738b = r101;
            this.f523739c = r102;
            this.f523740d = r103;
        }
    }

    static {
    }

    public static String a(float r100) {
        if (r100 != Float.MAX_VALUE) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100 = 0.0f;
    L9:
        return String.format("%.6f", Arrays.copyOf(new Object[]{Float.valueOf(r100)}, 1));
    L5:
        r101 = false;
        goto L6
    }

    public final void b(boolean r100) {
        this.f523717j = 0;
        if (r100 == false) goto L6;
        this.f523719l = 0;
        this.f523718k = null;
        this.f523720m = null;
        this.f523721n = false;
        return;
    }

    public a(int r100, int r101, boolean r102, long r103, float r104, long r105, int r106, boolean r110, long r111) {
        this.f523708a = r100;
        this.f523709b = r101;
        this.f523710c = r102;
        this.f523711d = r103;
        this.f523712e = r104;
        this.f523713f = r105;
        this.f523714g = r106;
        this.f523715h = r110;
        this.f523716i = r111;
        this.f523726s = Float.MAX_VALUE;
    }
}
