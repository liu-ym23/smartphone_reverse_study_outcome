package paa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f528399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f528400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f528401f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f528396a, r101.f528396a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528397b, r101.f528397b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528398c, r101.f528398c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528399d, r101.f528399d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f528400e, r101.f528400e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f528401f, r101.f528401f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f528396a.hashCode() * 31) + this.f528397b.hashCode()) * 31;
        String r101 = this.f528398c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f528399d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.f528400e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.f528401f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricSkillItem(id=" + this.f528396a + ", name=" + this.f528397b + ", coverUrl=" + this.f528398c + ", lastUsedAt=" + this.f528399d + ", createdAt=" + this.f528400e + ", lastUpdatedAt=" + this.f528401f + ')';
    }

    public /* synthetic */ e(String r100, String r101, String r110, int r111) {
        if ((r111 & 4) == 0) goto L5;
        r110 = null;
    L5:
        this(r100, r101, r110, null, null, null);
    }

    public e(String r100, String r101, String r102, Long r103, Long r104, Long r105) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f528396a = r100;
        this.f528397b = r101;
        this.f528398c = r102;
        this.f528399d = r103;
        this.f528400e = r104;
        this.f528401f = r105;
    }
}
