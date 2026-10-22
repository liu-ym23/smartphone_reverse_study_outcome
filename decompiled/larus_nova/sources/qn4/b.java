package qn4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f534027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f534028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f534029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f534030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f534031e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f534027a == r101.f534027a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f534028b, r101.f534028b) == true) goto L15;
        return false;
    L15:
        if (this.f534029c == r101.f534029c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f534030d, r101.f534030d) == true) goto L21;
        return false;
    L21:
        if (this.f534031e == r101.f534031e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f534027a * 31;
        String r101 = this.f534028b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f534029c) * 31;
        String r105 = this.f534030d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return ((r104 + r102) * 31) + this.f534031e;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RemoveUserPermissionParams(type=" + this.f534027a + ", token=" + this.f534028b + ", ownerType=" + this.f534029c + ", ownerId=" + this.f534030d + ", permType=" + this.f534031e + ')';
    }

    public final int getType() {
        return this.f534027a;
    }

    public b(int r100, String r101, int r102, String r103, int r104) {
        this.f534027a = r100;
        this.f534028b = r101;
        this.f534029c = r102;
        this.f534030d = r103;
        this.f534031e = r104;
    }
}
