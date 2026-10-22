package d00;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f466168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f466169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f466170c;

    public c() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f466168a, r101.f466168a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f466169b, r101.f466169b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f466170c, r101.f466170c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        JSONObject r100 = this.f466168a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f466169b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.f466170c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommonData(category=" + this.f466168a + ", metric=" + this.f466169b + ", extra=" + this.f466170c + ")";
    }

    public c(JSONObject r100, JSONObject r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new JSONObject();
    L6:
        if ((r102 & 2) == 0) goto L8;
        JSONObject r103 = new JSONObject();
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = new JSONObject();
    L12:
        Intrinsics.checkNotNullParameter(r100, "category");
        Intrinsics.checkNotNullParameter(r103, "metric");
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.f466168a = r100;
        this.f466169b = r103;
        this.f466170c = r101;
        return;
    L8:
        r103 = null;
        goto L10
    }
}
