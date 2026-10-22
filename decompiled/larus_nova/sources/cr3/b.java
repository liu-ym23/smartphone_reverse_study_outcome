package cr3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Float f465043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Float f465044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f465045c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f465046d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f465047e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f465048f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f465043a, r101.f465043a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f465044b, r101.f465044b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f465045c, r101.f465045c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465046d, r101.f465046d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f465047e, r101.f465047e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f465048f, r101.f465048f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Float r100 = this.f465043a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Float r104 = this.f465044b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Float r107 = this.f465045c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f465046d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f465047e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f465048f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TabScrollState(selectedPositionX=" + this.f465043a + ", prevPositionX=" + this.f465044b + ", nextPositionX=" + this.f465045c + ", selectedPositionWidth=" + this.f465046d + ", prevPositionWidth=" + this.f465047e + ", nextPositionWidth=" + this.f465048f + ")";
    }

    public static boolean a(int r100, Float r101, Integer r102) {
        if (r101 == null) goto L10;
        r101.floatValue();
        if (r102 == null) goto L10;
        r102.intValue();
        float r103 = r100;
        if (r103 < r101.floatValue()) goto L10;
        if (r103 >= (r101.floatValue() + r102.intValue())) goto L10;
        return true;
    L10:
        return false;
    }

    public b(Float r100, Float r101, Float r102, Integer r103, Integer r104, Integer r105) {
        this.f465043a = r100;
        this.f465044b = r101;
        this.f465045c = r102;
        this.f465046d = r103;
        this.f465047e = r104;
        this.f465048f = r105;
    }

    public final b update(Float r100, Float r101, Float r102, Integer r103, Integer r104, Integer r105) {
        this.f465043a = r100;
        this.f465044b = r101;
        this.f465045c = r102;
        this.f465046d = r103;
        this.f465047e = r104;
        this.f465048f = r105;
        return this;
    }
}
