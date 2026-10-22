package xw6;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f565254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f565255b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f565254a, r101.f565254a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565255b, r101.f565255b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f565254a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.f565255b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DitoApiRequestInfo(apiUrlPath=" + this.f565254a + ", params=" + this.f565255b + ')';
    }

    public b(Map r100) {
        this.f565254a = "/aweme/v2/poi/user/trade/product/info/";
        this.f565255b = r100;
    }
}
