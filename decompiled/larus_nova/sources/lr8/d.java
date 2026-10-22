package lr8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f510449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f510450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f510451d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f510452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f510453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f510454g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f510448a, r101.f510448a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510449b, r101.f510449b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f510450c, r101.f510450c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f510451d, r101.f510451d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f510452e, r101.f510452e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f510453f, r101.f510453f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f510454g, r101.f510454g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f510448a.hashCode() * 31;
        String r101 = this.f510449b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f510450c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f510451d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f510452e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        b r114 = this.f510453f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        h r117 = this.f510454g;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
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
        return "NestedFileUplinkUpdateInfo(fileIdentifier=" + this.f510448a + ", md5=" + this.f510449b + ", tosKey=" + this.f510450c + ", resourceId=" + this.f510451d + ", instantUploadInfoJson=" + this.f510452e + ", imageInfo=" + this.f510453f + ", videoInfo=" + this.f510454g + ')';
    }

    public d(String r100, String r101, String r102, String r103, String r104, b r105, h r106) {
        Intrinsics.checkNotNullParameter(r100, "fileIdentifier");
        this.f510448a = r100;
        this.f510449b = r101;
        this.f510450c = r102;
        this.f510451d = r103;
        this.f510452e = r104;
        this.f510453f = r105;
        this.f510454g = r106;
    }
}
