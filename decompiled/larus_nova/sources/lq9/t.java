package lq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f510356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f510357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f510358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f510359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f510360f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f510355a, r101.f510355a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f510356b, r101.f510356b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f510357c, r101.f510357c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f510358d, r101.f510358d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f510359e, r101.f510359e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f510360f, r101.f510360f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f510355a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f510356b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f510357c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f510358d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f510359e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f510360f;
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
        return "PopupConfig(title=" + this.f510355a + ", subTitle=" + this.f510356b + ", confirmBtnText=" + this.f510357c + ", cancelBtnText=" + this.f510358d + ", latestVersion=" + this.f510359e + ", downloadUrl=" + this.f510360f + ')';
    }

    public t() {
        this("", "", "", "", 0L, "");
    }

    public t(String r100, String r101, String r102, String r103, Long r104, String r105) {
        this.f510355a = r100;
        this.f510356b = r101;
        this.f510357c = r102;
        this.f510358d = r103;
        this.f510359e = r104;
        this.f510360f = r105;
    }
}
