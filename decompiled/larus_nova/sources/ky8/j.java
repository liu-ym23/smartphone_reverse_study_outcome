package ky8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f506717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f506718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f506719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f506720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f506721f;

    public j() {
        this(null, null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f506716a, r101.f506716a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506717b, r101.f506717b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506718c, r101.f506718c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506719d, r101.f506719d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506720e, r101.f506720e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506721f, r101.f506721f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f506716a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f506717b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f506718c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f506719d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f506720e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f506721f;
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
        return "OriginImageInfo(uri=" + this.f506716a + ", url=" + this.f506717b + ", height=" + this.f506718c + ", width=" + this.f506719d + ", localFilePath=" + this.f506720e + ", aiCreationImage=" + this.f506721f + ')';
    }

    public static j a(j r100, String r101, Integer r102, Integer r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.f506716a;
    L5:
        String r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        String r104 = r100.f506717b;
    L10:
        if ((r111 & 4) == 0) goto L12;
        r102 = r100.f506718c;
    L12:
        Integer r105 = r102;
        if ((r111 & 8) == 0) goto L15;
        r110 = r100.f506719d;
    L15:
        Integer r106 = r110;
        if ((r111 & 16) == 0) goto L18;
        String r107 = r100.f506720e;
    L20:
        if ((r111 & 32) == 0) goto L22;
        Boolean r108 = r100.f506721f;
    L23:
        r100.getClass();
        return new j(r103, r104, r105, r106, r107, r108);
    L22:
        r108 = null;
        goto L23
    L18:
        r107 = null;
        goto L20
    L8:
        r104 = null;
        goto L10
    }

    public j(String r100, String r101, Integer r102, Integer r103, String r104, Boolean r105) {
        this.f506716a = r100;
        this.f506717b = r101;
        this.f506718c = r102;
        this.f506719d = r103;
        this.f506720e = r104;
        this.f506721f = r105;
    }

    public /* synthetic */ j(String r100, String r101, Integer r102, Integer r110, String r111, Boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Integer r105 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r113 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r113 & 32) == 0) goto L25;
        Boolean r114 = null;
    L26:
        this(r103, r104, r105, r106, r107, r114);
        return;
    L25:
        r114 = r112;
        goto L26
    L21:
        r107 = r111;
        goto L23
    L17:
        r106 = r110;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }
}
