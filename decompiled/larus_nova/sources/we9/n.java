package we9;

import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n implements xe9.c, xe9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f559438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f559439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f559440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f559441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f559442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f559443f;

    public final String toString() {
        return "UploadImageModel(uploadId=" + this.f559438a + ", imageData=" + Arrays.toString(this.f559439b) + ", width=" + this.f559440c + ", height=" + this.f559441d + ", format=" + this.f559442e + ", ext=" + this.f559443f + ')';
    }

    public final int hashCode() {
        String r100 = this.f559438a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((r102 * 31) + Arrays.hashCode(this.f559439b)) * 31) + this.f559440c) * 31) + this.f559441d) * 31;
        Map<String, Object> r104 = this.f559443f;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f559438a, r101.f559438a) == true) goto L12;
        return false;
    L12:
        if (Arrays.equals(this.f559439b, r101.f559439b) == true) goto L15;
        return false;
    L15:
        if (this.f559440c == r101.f559440c) goto L18;
        return false;
    L18:
        if (this.f559441d == r101.f559441d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f559443f, r101.f559443f) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public n(String r100, byte[] r101, int r102, int r103, int r104, Map<String, ? extends Object> r105) {
        Intrinsics.checkNotNullParameter(r101, "imageData");
        this.f559438a = r100;
        this.f559439b = r101;
        this.f559440c = r102;
        this.f559441d = r103;
        this.f559442e = r104;
        this.f559443f = r105;
    }
}
