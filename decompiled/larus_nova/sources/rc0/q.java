package rc0;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f537068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f537069b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L10;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f537068a, r101.f537068a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f537069b, r101.f537069b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f537068a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f537069b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SeiOptExtra(appDataString=" + this.f537068a + ", appDataJson=" + this.f537069b + ")";
    }

    public q(String r100, JSONObject r101) {
        this.f537068a = r100;
        this.f537069b = r101;
    }
}
