package rp8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements m1a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f538880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f538881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f538882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f538883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f538884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CharSequence f538885f;

    public d() {
        this(null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f538880a, r101.f538880a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538881b, r101.f538881b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f538882c, r101.f538882c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f538883d, r101.f538883d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f538884e, r101.f538884e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f538885f, r101.f538885f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f538880a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f538881b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f538882c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f538883d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f538884e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        CharSequence r116 = this.f538885f;
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
        return "InputBoxConfig(fullScreenEditEnabled=" + this.f538880a + ", inputPopupMenuEnabled=" + this.f538881b + ", actionBarEnabled=" + this.f538882c + ", plusButtonEnabled=" + this.f538883d + ", initialMode=" + this.f538884e + ", defaultHint=" + this.f538885f + ')';
    }

    public d(Boolean r100, Boolean r101, Boolean r102, CharSequence r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 32) == 0) goto L14;
        r103 = null;
    L14:
        this.f538880a = r100;
        this.f538881b = r101;
        this.f538882c = null;
        this.f538883d = r102;
        this.f538884e = null;
        this.f538885f = r103;
    }
}
