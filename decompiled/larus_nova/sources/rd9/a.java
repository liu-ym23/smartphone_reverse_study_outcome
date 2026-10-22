package rd9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f537338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f537339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f537340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f537341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f537342e;

    public a() {
        this(null, null, 0, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f537338a, r101.f537338a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f537339b, r101.f537339b) == true) goto L15;
        return false;
    L15:
        if (this.f537340c == r101.f537340c) goto L18;
        return false;
    L18:
        if (this.f537341d == r101.f537341d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f537342e, r101.f537342e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f537338a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f537339b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f537340c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f537341d;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        Integer r111 = this.f537342e;
        if (r111 == null) goto L15;
        r101 = r111.hashCode();
    L15:
        return r110 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowAVVideoFpsTraceData(initialThermalStatus=" + this.f537338a + ", maxThermalStatus=" + this.f537339b + ", enterTime=" + this.f537340c + ", maxThermalStatusTime=" + this.f537341d + ", exitThermalStatus=" + this.f537342e + ')';
    }

    public a(Integer r100, Integer r101, long r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = null;
    L8:
        long r104 = -1;
        if ((r103 & 4) == 0) goto L12;
        r102 = -1;
    L12:
        if ((r103 & 8) != 0) goto L15;
        r104 = 0;
    L15:
        this.f537338a = r100;
        this.f537339b = r101;
        this.f537340c = r102;
        this.f537341d = r104;
        this.f537342e = null;
    }
}
