package gk8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f481554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f481555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f481556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f481557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f481558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f481559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f481560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f481561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f481562i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f481554a == r101.f481554a) goto L12;
        return false;
    L12:
        if (this.f481555b == r101.f481555b) goto L15;
        return false;
    L15:
        if (this.f481556c == r101.f481556c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f481557d, r101.f481557d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f481558e, r101.f481558e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f481559f, r101.f481559f) == true) goto L27;
        return false;
    L27:
        if (this.f481560g == r101.f481560g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f481561h, r101.f481561h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f481562i, r101.f481562i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f481554a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f481555b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f481556c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (((((((r104 + r105) * 31) + this.f481557d.hashCode()) * 31) + this.f481558e.hashCode()) * 31) + this.f481559f.hashCode()) * 31;
        if (this.f481560g == true) goto L19;
        r100 = 1237;
    L19:
        return ((((r106 + r100) * 31) + this.f481561h.hashCode()) * 31) + this.f481562i.hashCode();
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ComputerUseToolResultBlockInput(isFold=" + this.f481554a + ", forceHideArrow=" + this.f481555b + ", disableHeaderInteraction=" + this.f481556c + ", title=" + this.f481557d + ", imageUri=" + this.f481558e + ", imageUrl=" + this.f481559f + ", isLoading=" + this.f481560g + ", leftDarkIcon=" + this.f481561h + ", leftLightIcon=" + this.f481562i + ')';
    }

    public a(boolean r100, boolean r101, boolean r102, String r103, String r104, String r105, boolean r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r103, "title");
        Intrinsics.checkNotNullParameter(r104, "imageUri");
        Intrinsics.checkNotNullParameter(r105, "imageUrl");
        Intrinsics.checkNotNullParameter(r107, "leftDarkIcon");
        Intrinsics.checkNotNullParameter(r110, "leftLightIcon");
        this.f481554a = r100;
        this.f481555b = r101;
        this.f481556c = r102;
        this.f481557d = r103;
        this.f481558e = r104;
        this.f481559f = r105;
        this.f481560g = r106;
        this.f481561h = r107;
        this.f481562i = r110;
    }
}
