package mo5;

import com.bytedance.ee.bear.widgets.lottie.CCMLottieRes;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public final String a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final CCMLottieRes f;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        CCMLottieRes r1 = this.f;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "TtsItemInfo(" + hashCode() + "){docToken: " + du5.b.i(this.a) + ", docType: " + this.b + ", docTitle: " + this.c + ", docOwner: " + this.d + ", docIconInfo(length): " + this.e.length() + '}';
    }

    public j(String r2, int r3, String r4, String r5, String r6, CCMLottieRes r7) {
        Intrinsics.checkNotNullParameter(r2, "docToken");
        Intrinsics.checkNotNullParameter(r4, "docTitle");
        Intrinsics.checkNotNullParameter(r5, "docOwner");
        Intrinsics.checkNotNullParameter(r6, "docIconInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
