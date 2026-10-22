package er5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f473591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f473592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f473593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f473594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f473595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f473596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f473597g;

    public a() {
        this(null, false, null, null, null, null, 127);
    }

    public a(String r100, boolean r110, String r111, String r112) {
        this(r100, r110, r111, r112, null, null, 96);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f473591a, r101.f473591a) == true) goto L12;
        return false;
    L12:
        if (this.f473592b == r101.f473592b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f473593c, r101.f473593c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f473594d, r101.f473594d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f473595e, r101.f473595e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f473596f, r101.f473596f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f473597g, r101.f473597g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f473591a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.f473592b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.f473593c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f473594d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f473595e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f473596f;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        Integer r118 = this.f473597g;
        if (r118 == null) goto L31;
        r101 = r118.hashCode();
    L31:
        return r117 + r101;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BitableCreationParams(workspaceToken=" + this.f473591a + ", needNewWorkspace=" + this.f473592b + ", templateToken=" + this.f473593c + ", templateId=" + this.f473594d + ", title=" + this.f473595e + ", workspaceTitle=" + this.f473596f + ", source=" + this.f473597g + ')';
    }

    public a(String r100, boolean r101, String r102, String r103, String r104, Integer r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 64) == 0) goto L20;
        r105 = null;
    L20:
        this.f473591a = r100;
        this.f473592b = r101;
        this.f473593c = r102;
        this.f473594d = r103;
        this.f473595e = null;
        this.f473596f = r104;
        this.f473597g = r105;
    }
}
