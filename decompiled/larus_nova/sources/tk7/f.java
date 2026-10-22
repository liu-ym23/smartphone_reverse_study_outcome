package tk7;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f546560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f546561b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f546560a, r101.f546560a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f546561b, r101.f546561b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f546560a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f546561b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "EventCacheBean(eventName=" + this.f546560a + ", params=" + this.f546561b + ")";
    }

    public f(String r100, JSONObject r101) {
        this.f546560a = r100;
        this.f546561b = r101;
    }
}
