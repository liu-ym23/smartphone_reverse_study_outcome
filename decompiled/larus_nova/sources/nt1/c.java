package nt1;

import com.bytedance.android.live.base.model.ImageModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f520467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f520468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f520469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f520470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f520471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f520472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageModel f520473g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (this.f520467a == r101.f520467a) goto L8;
        return false;
    L8:
        if (this.f520468b == r101.f520468b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f520469c, r101.f520469c) == true) goto L12;
        return false;
    L12:
        if (this.f520470d == r101.f520470d) goto L14;
        return false;
    L14:
        if (this.f520471e == r101.f520471e) goto L16;
        return false;
    L16:
        if (this.f520472f == r101.f520472f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f520473g, r101.f520473g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int r100 = ((this.f520467a * 31) + this.f520468b) * 31;
        String r101 = this.f520469c;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f520470d;
        ?? r106 = 1;
        ?? r107 = r105;
        if (r105 == false) goto L9;
        r107 = 1;
    L9:
        int r108 = (r104 + r107) * 31;
        boolean r109 = this.f520471e;
        ?? r110 = r109;
        if (r109 == false) goto L12;
        r110 = 1;
    L12:
        int r111 = (r108 + r110) * 31;
        boolean r112 = this.f520472f;
        if (r112 == true) goto L16;
        r106 = r112;
    L16:
        int r113 = (r111 + r106) * 31;
        ImageModel r114 = this.f520473g;
        if (r114 == null) goto L20;
        r102 = r114.hashCode();
    L20:
        return r113 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "OptionDescVO(imageResId=" + this.f520467a + ", textResId=" + this.f520468b + ", textStr=" + this.f520469c + ", showDot=" + this.f520470d + ", isEmpty=" + this.f520471e + ", forceShowDot=" + this.f520472f + ", imageModel=" + this.f520473g + ")";
    }

    public final boolean a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        if (r100.f520467a == this.f520467a) goto L5;
    L16:
        boolean r101 = true;
    L17:
        if (r101 == true) goto L20;
        r100 = null;
    L20:
        if (r100 == null) goto L22;
        return false;
    L22:
        return true;
    L5:
        if (r100.f520468b != this.f520468b) goto L16;
        if ((!Intrinsics.areEqual(r100.f520469c, this.f520469c)) == true) goto L16;
        if (r100.f520470d != this.f520470d) goto L16;
        if (r100.f520471e != this.f520471e) goto L16;
        if (r100.f520472f != this.f520472f) goto L16;
        r101 = false;
        goto L17
    }

    public c(int r100, int r101, String r102, boolean r103, boolean r104, boolean r105, ImageModel r106, int r110) {
        if ((r110 & 4) == 0) goto L6;
        r102 = "";
    L6:
        if ((r110 & 8) == 0) goto L9;
        r103 = false;
    L9:
        if ((r110 & 16) == 0) goto L12;
        r104 = false;
    L12:
        if ((r110 & 32) == 0) goto L15;
        r105 = false;
    L15:
        if ((r110 & 64) == 0) goto L17;
        r106 = null;
    L17:
        this.f520467a = r100;
        this.f520468b = r101;
        this.f520469c = r102;
        this.f520470d = r103;
        this.f520471e = r104;
        this.f520472f = r105;
        this.f520473g = r106;
    }
}
