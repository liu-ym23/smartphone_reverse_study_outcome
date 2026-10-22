package cy6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f465789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f465790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f465791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f465792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f465793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f465794f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f465789a, r101.f465789a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465790b, r101.f465790b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465791c, r101.f465791c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465792d, r101.f465792d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465793e, r101.f465793e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465794f, r101.f465794f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f465789a.hashCode() * 31;
        Integer r101 = this.f465790b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f465791c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f465792d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f465793e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Object r114 = this.f465794f;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "LifeAweme(itemId=" + this.f465789a + ", sourceFrom=" + this.f465790b + ", coverUrl=" + this.f465791c + ", width=" + this.f465792d + ", height=" + this.f465793e + ", raw=" + this.f465794f + ')';
    }

    public /* synthetic */ b(String r110, Object r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        Integer r100 = 3;
    L7:
        if ((r112 & 32) == 0) goto L9;
        Object r101 = null;
    L10:
        this(r110, r100, null, null, null, r101);
        return;
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = null;
        goto L7
    }

    public b(String r100, Integer r101, String r102, Integer r103, Integer r104, Object r105) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        this.f465789a = r100;
        this.f465790b = r101;
        this.f465791c = r102;
        this.f465792d = r103;
        this.f465793e = r104;
        this.f465794f = r105;
    }
}
