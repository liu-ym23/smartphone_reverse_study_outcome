package zg1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f571916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f571917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f571918e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q1) == false) goto L16;
        q1 r101 = (q1) r100;
        if (this.f571914a == r101.f571914a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f571915b, r101.f571915b) == true) goto L10;
        return false;
    L10:
        if (this.f571916c == r101.f571916c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571917d, r101.f571917d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f571918e, r101.f571918e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f571914a * 31;
        String r101 = this.f571915b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.f571916c) * 31;
        String r105 = this.f571917d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f571918e;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "MagicGestureActivityEvent(status=" + this.f571914a + ", effectId=" + this.f571915b + ", actionType=" + this.f571916c + ", actionSchema=" + this.f571917d + ", bizId=" + this.f571918e + ")";
    }

    public q1(int r100, String r101, int r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "effectId");
        Intrinsics.checkNotNullParameter(r104, "bizId");
        this.f571914a = r100;
        this.f571915b = r101;
        this.f571916c = r102;
        this.f571917d = r103;
        this.f571918e = r104;
    }
}
