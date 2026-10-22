package mo5;

import com.bytedance.ee.bear.widgets.lottie.CCMLottieRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f514586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f514587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f514588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f514589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f514590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CCMLottieRes f514591f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f514586a, r101.f514586a) == true) goto L12;
        return false;
    L12:
        if (this.f514587b == r101.f514587b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f514588c, r101.f514588c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f514589d, r101.f514589d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f514590e, r101.f514590e) == true) goto L24;
        return false;
    L24:
        if (this.f514591f == r101.f514591f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f514586a.hashCode() * 31) + this.f514587b) * 31) + this.f514588c.hashCode()) * 31) + this.f514589d.hashCode()) * 31) + this.f514590e.hashCode()) * 31;
        CCMLottieRes r101 = this.f514591f;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TtsItemInfo(" + hashCode() + "){docToken: " + du5.b.i(this.f514586a) + ", docType: " + this.f514587b + ", docTitle: " + this.f514588c + ", docOwner: " + this.f514589d + ", docIconInfo(length): " + this.f514590e.length() + '}';
    }

    public j(String r100, int r101, String r102, String r103, String r104, CCMLottieRes r105) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "docTitle");
        Intrinsics.checkNotNullParameter(r103, "docOwner");
        Intrinsics.checkNotNullParameter(r104, "docIconInfo");
        this.f514586a = r100;
        this.f514587b = r101;
        this.f514588c = r102;
        this.f514589d = r103;
        this.f514590e = r104;
        this.f514591f = r105;
    }
}
