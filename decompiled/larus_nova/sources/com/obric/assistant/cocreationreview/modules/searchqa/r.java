package com.obric.assistant.cocreationreview.modules.searchqa;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f387576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f387577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f387578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f387579f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f387574a, r101.f387574a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387575b, r101.f387575b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f387576c, r101.f387576c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387577d, r101.f387577d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f387578e, r101.f387578e) == true) goto L24;
        return false;
    L24:
        if (this.f387579f == r101.f387579f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f387574a.hashCode() * 31;
        String r101 = this.f387575b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f387576c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f387577d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Integer r111 = this.f387578e;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        int r112 = (r110 + r102) * 31;
        if (this.f387579f == false) goto L21;
        int r113 = 1231;
    L23:
        return r112 + r113;
    L21:
        r113 = 1237;
        goto L23
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
        return "SearchQaLocalImage(resUri=" + this.f387574a + ", entityType=" + this.f387575b + ", entityId=" + this.f387576c + ", entityPackageName=" + this.f387577d + ", index=" + this.f387578e + ", isVideo=" + this.f387579f + ')';
    }

    public r(String r100, String r101, String r102, String r103, Integer r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "resUri");
        this.f387574a = r100;
        this.f387575b = r101;
        this.f387576c = r102;
        this.f387577d = r103;
        this.f387578e = r104;
        this.f387579f = r105;
    }
}
