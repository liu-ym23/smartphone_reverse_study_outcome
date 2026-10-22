package tf3;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f545720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f545721b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f545720a, r101.f545720a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f545721b, r101.f545721b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f545720a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f545721b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AdParamsFromSchema(productId=" + this.f545720a + ", ad=" + this.f545721b + ")";
    }

    public b(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "ad");
        this.f545720a = r100;
        this.f545721b = r101;
    }
}
