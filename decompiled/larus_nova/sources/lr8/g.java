package lr8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f510465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f510466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f510467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f510468d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f510469e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f510470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f510471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f510472h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f510473i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f510465a == r101.f510465a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510466b, r101.f510466b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f510467c, r101.f510467c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f510468d, r101.f510468d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f510469e, r101.f510469e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f510470f, r101.f510470f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f510471g, r101.f510471g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f510472h, r101.f510472h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f510473i, r101.f510473i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f510465a * 31;
        Integer r101 = this.f510466b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f510467c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Boolean r108 = this.f510468d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f510469e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f510470f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f510471g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f510472h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f510473i;
        if (r123 == null) goto L35;
        r102 = r123.hashCode();
    L35:
        return r122 + r102;
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
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
        return "StepResult(stepCode=" + this.f510465a + ", statusCode=" + this.f510466b + ", mainUrl=" + this.f510467c + ", isEncrypted=" + this.f510468d + ", decryptionKey=" + this.f510469e + ", downloadErrorCode=" + this.f510470f + ", downloadErrorMessage=" + this.f510471g + ", downloadFilePath=" + this.f510472h + ", decryptFilePath=" + this.f510473i + ')';
    }

    public g(int r100, Integer r101, String r102, Boolean r103, String r104, Integer r105, String r106, String r110, String r111, int r112) {
        if ((r112 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r112 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r112 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r112 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r112 & 32) == 0) goto L18;
        r105 = null;
    L18:
        if ((r112 & 64) == 0) goto L21;
        r106 = null;
    L21:
        if ((r112 & 128) == 0) goto L24;
        r110 = null;
    L24:
        if ((r112 & 256) == 0) goto L26;
        r111 = null;
    L26:
        this.f510465a = r100;
        this.f510466b = r101;
        this.f510467c = r102;
        this.f510468d = r103;
        this.f510469e = r104;
        this.f510470f = r105;
        this.f510471g = r106;
        this.f510472h = r110;
        this.f510473i = r111;
    }
}
