package zv6;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f573737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f573738b;

    public c() {
        this(0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f573737a, r101.f573737a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f573738b, r101.f573738b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f573737a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f573738b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "JSBroadcastPageData(eventType=" + this.f573737a + ", params=" + this.f573738b + ')';
    }

    public c(Integer r100, JSONObject r101) {
        this.f573737a = r100;
        this.f573738b = r101;
    }
}
