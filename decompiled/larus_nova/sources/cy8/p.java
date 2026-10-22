package cy8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f465886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f465887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f465888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f465889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f465890e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f465891f;

    public p() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f465886a, r101.f465886a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f465887b, r101.f465887b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f465888c, r101.f465888c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f465889d, r101.f465889d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f465890e, r101.f465890e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f465891f, r101.f465891f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f465886a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        s r104 = this.f465887b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f465888c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f465889d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f465890e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f465891f;
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
        return "CanvasOptionExtra(isPresetRefImage=" + this.f465886a + ", presetRefImage=" + this.f465887b + ", isTrending=" + this.f465888c + ", detectMode=" + this.f465889d + ", subDisplay=" + this.f465890e + ", optionMsg=" + this.f465891f + ')';
    }

    public p(Boolean r100, s r101, Boolean r102, Integer r103, String r104, String r105) {
        this.f465886a = r100;
        this.f465887b = r101;
        this.f465888c = r102;
        this.f465889d = r103;
        this.f465890e = r104;
        this.f465891f = r105;
    }
}
