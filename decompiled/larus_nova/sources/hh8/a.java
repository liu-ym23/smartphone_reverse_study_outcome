package hh8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f485230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f485231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f485232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f485233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Float f485234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f485235f;

    public a() {
        this(false, false, false, null, null, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f485230a == r101.f485230a) goto L12;
        return false;
    L12:
        if (this.f485231b == r101.f485231b) goto L15;
        return false;
    L15:
        if (this.f485232c == r101.f485232c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f485233d, r101.f485233d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f485234e, r101.f485234e) == true) goto L24;
        return false;
    L24:
        if (this.f485235f == r101.f485235f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f485230a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f485231b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f485232c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        Integer r107 = this.f485233d;
        int r108 = 0;
        if (r107 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r106 + r109) * 31;
        Float r111 = this.f485234e;
        if (r111 == null) goto L22;
        r108 = r111.hashCode();
    L22:
        int r112 = (r110 + r108) * 31;
        if (this.f485235f == true) goto L27;
        r100 = 1237;
    L27:
        return r112 + r100;
    L17:
        r109 = r107.hashCode();
        goto L18
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
        return "MarkdownCodeViewUIConfig(enableCodeBlockStroke=" + this.f485230a + ", enableCodeBlockHeaderBackground=" + this.f485231b + ", enableTransparentCodeBlockBackground=" + this.f485232c + ", borderColor=" + this.f485233d + ", cornerRadius=" + this.f485234e + ", onlyShowCopyButton=" + this.f485235f + ')';
    }

    public a(boolean r100, boolean r101, boolean r102, Integer r103, Float r104, boolean r105, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r110 & 32) == 0) goto L20;
        r105 = false;
    L20:
        this.f485230a = r100;
        this.f485231b = r101;
        this.f485232c = r102;
        this.f485233d = r103;
        this.f485234e = r104;
        this.f485235f = r105;
    }
}
