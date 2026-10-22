package x79;

import com.larus.drive.sdk.api.file.select.BaseFileSelectFromType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f562830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f562832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f562833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f562834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f562835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f562836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BaseFileSelectFromType f562837h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f562830a, r101.f562830a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562831b, r101.f562831b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f562832c, r101.f562832c) == true) goto L18;
        return false;
    L18:
        if (this.f562833d == r101.f562833d) goto L21;
        return false;
    L21:
        if (this.f562834e == r101.f562834e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f562835f, r101.f562835f) == true) goto L27;
        return false;
    L27:
        if (this.f562836g == r101.f562836g) goto L30;
        return false;
    L30:
        if (this.f562837h == r101.f562837h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f562830a.hashCode() * 31) + this.f562831b.hashCode()) * 31) + this.f562832c.hashCode()) * 31) + this.f562833d) * 31;
        int r101 = 1231;
        if (this.f562834e == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        String r104 = this.f562835f;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f562836g == true) goto L15;
        r101 = 1237;
    L15:
        return ((r106 + r101) * 31) + this.f562837h.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "BaseFileSelectConfig(fileUri=" + this.f562830a + ", fileName=" + this.f562831b + ", visitTime=" + this.f562832c + ", iconRes=" + this.f562833d + ", isSelected=" + this.f562834e + ", thumbnailUrl=" + this.f562835f + ", isImage=" + this.f562836g + ", fromType=" + this.f562837h + ')';
    }

    public a(String r100, String r101, String r102, int r103, boolean r104, BaseFileSelectFromType r105, int r106) {
        if ((r106 & 64) == 0) goto L6;
        r104 = false;
    L6:
        if ((r106 & 128) == 0) goto L8;
        r105 = BaseFileSelectFromType.LOCAL;
    L8:
        Intrinsics.checkNotNullParameter(r100, "fileUri");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r102, "visitTime");
        Intrinsics.checkNotNullParameter(r105, "fromType");
        this.f562830a = r100;
        this.f562831b = r101;
        this.f562832c = r102;
        this.f562833d = r103;
        this.f562834e = false;
        this.f562835f = null;
        this.f562836g = r104;
        this.f562837h = r105;
    }
}
