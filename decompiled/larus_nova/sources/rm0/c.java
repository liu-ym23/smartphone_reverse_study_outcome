package rm0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f538507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f538508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f538509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f538510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f538511f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f538506a, r101.f538506a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f538507b, r101.f538507b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f538508c, r101.f538508c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538509d, r101.f538509d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f538510e, r101.f538510e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f538511f, r101.f538511f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f538506a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f538507b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f538508c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f538509d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f538510e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f538511f;
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
        return "LiveMiddleAppInfo(versionCode=" + this.f538506a + ", packageName=" + this.f538507b + ", updateVersionCode=" + this.f538508c + ", appName=" + this.f538509d + ", appIcon=" + this.f538510e + ", versionName=" + this.f538511f + ")";
    }

    public c(String r100, String r101, Integer r102, String r103, Integer r104, String r105) {
        this.f538506a = r100;
        this.f538507b = r101;
        this.f538508c = r102;
        this.f538509d = r103;
        this.f538510e = r104;
        this.f538511f = r105;
    }
}
