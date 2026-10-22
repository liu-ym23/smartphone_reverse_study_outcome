package gd9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f480978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f480979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f480980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f480981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f480982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f480983f;

    public f() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f480978a, r101.f480978a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f480979b, r101.f480979b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f480980c, r101.f480980c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f480981d, r101.f480981d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f480982e, r101.f480982e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f480983f, r101.f480983f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f480978a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f480979b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f480980c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f480981d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f480982e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f480983f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowNetworkMetrics(totalMs=" + this.f480978a + ", connectMs=" + this.f480979b + ", dnsMs=" + this.f480980c + ", sendMs=" + this.f480981d + ", waitMs=" + this.f480982e + ", receiveMs=" + this.f480983f + ')';
    }

    public f(Long r100, Long r101, Long r102, Long r103, Long r104, Long r105) {
        this.f480978a = r100;
        this.f480979b = r101;
        this.f480980c = r102;
        this.f480981d = r103;
        this.f480982e = r104;
        this.f480983f = r105;
    }
}
