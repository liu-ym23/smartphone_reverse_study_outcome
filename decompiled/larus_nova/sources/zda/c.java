package zda;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f571489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f571490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f571491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f571492f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f571487a, r101.f571487a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571488b, r101.f571488b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f571489c, r101.f571489c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f571490d, r101.f571490d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f571491e, r101.f571491e) == true) goto L24;
        return false;
    L24:
        if (this.f571492f == r101.f571492f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f571487a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f571488b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f571489c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f571490d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f571491e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        if (this.f571492f == false) goto L25;
        int r115 = 1231;
    L27:
        return r114 + r115;
    L25:
        r115 = 1237;
        goto L27
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
        return "ObricSearchImage(resUri=" + this.f571487a + ", entityType=" + this.f571488b + ", entityId=" + this.f571489c + ", entityPackageName=" + this.f571490d + ", index=" + this.f571491e + ", isVideo=" + this.f571492f + ')';
    }

    public c(String r100, String r101, String r102, String r103, Integer r104, boolean r105) {
        this.f571487a = r100;
        this.f571488b = r101;
        this.f571489c = r102;
        this.f571490d = r103;
        this.f571491e = r104;
        this.f571492f = r105;
    }
}
