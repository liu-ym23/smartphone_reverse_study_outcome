package zb9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class i<ITEM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITEM f571188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f571189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f571190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f571191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f571192e;

    public i() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f571188a, r101.f571188a) == true) goto L12;
        return false;
    L12:
        if (this.f571189b == r101.f571189b) goto L15;
        return false;
    L15:
        if (this.f571190c == r101.f571190c) goto L18;
        return false;
    L18:
        if (this.f571191d == r101.f571191d) goto L21;
        return false;
    L21:
        if (this.f571192e == r101.f571192e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        ITEM r100 = this.f571188a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        long r102 = this.f571189b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f571190c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f571191d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        if (this.f571192e == false) goto L9;
        int r108 = 1231;
    L11:
        return r107 + r108;
    L9:
        r108 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GroupItem(data=" + this.f571188a + ", updateTime=" + this.f571189b + ", createTime=" + this.f571190c + ", pinTime=" + this.f571191d + ", fixedFirst=" + this.f571192e + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Object r100, long r101, long r102, long r103, boolean r110, int r111) {
        if ((r111 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r111 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r111 & 8) == 0) goto L12;
        r103 = 0;
    L12:
        if ((r111 & 16) == 0) goto L14;
        r110 = false;
    L14:
        this.f571188a = r100;
        this.f571189b = r101;
        this.f571190c = r102;
        this.f571191d = r103;
        this.f571192e = r110;
    }
}
