package nm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f519590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f519592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f519593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f519594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f519595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f519596g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (this.f519590a == r101.f519590a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f519591b, r101.f519591b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f519592c, r101.f519592c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f519593d, r101.f519593d) == true) goto L14;
        return false;
    L14:
        if (this.f519594e == r101.f519594e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f519595f, r101.f519595f) == true) goto L18;
        return false;
    L18:
        if (this.f519596g == r101.f519596g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f519590a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f519591b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f519592c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f519593d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (((r108 + r110) * 31) + this.f519594e) * 31;
        String r112 = this.f519595f;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        return ((r111 + r103) * 31) + this.f519596g;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "StoreFloatLayoutEntity(id=" + this.f519590a + ", componentName=" + this.f519591b + ", userId=" + this.f519592c + ", scopeKey=" + this.f519593d + ", action=" + this.f519594e + ", time=" + this.f519595f + ", count=" + this.f519596g + ")";
    }

    public b(long r100, String r101, String r102, String r103, int r104, String r105, int r106) {
        Intrinsics.checkNotNullParameter(r101, "componentName");
        this.f519590a = r100;
        this.f519591b = r101;
        this.f519592c = r102;
        this.f519593d = r103;
        this.f519594e = r104;
        this.f519595f = r105;
        this.f519596g = r106;
    }
}
