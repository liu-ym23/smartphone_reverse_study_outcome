package kd4;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f502724b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f502723a, r101.f502723a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502724b, r101.f502724b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f502723a.hashCode() * 31;
        JSONObject r101 = this.f502724b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CJJs2NativeEvent(eventName=" + this.f502723a + ", params=" + this.f502724b + ')';
    }

    public b(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f502723a = r100;
        this.f502724b = r101;
    }
}
