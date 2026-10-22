package g53;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f480030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f480031b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f480030a, r101.f480030a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f480031b, r101.f480031b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f480030a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.f480031b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BrandVO(cnCountryName=" + this.f480030a + ", cnCountryIcon=" + this.f480031b + ")";
    }

    public a(String r100, ECUrlModel r101) {
        this.f480030a = r100;
        this.f480031b = r101;
    }
}
