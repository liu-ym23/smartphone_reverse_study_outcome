package com.bytedance.locallife.cube;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f257185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f257186b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f257185a, r101.f257185a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f257186b, r101.f257186b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f257185a.hashCode() * 31;
        JSONObject r101 = this.f257186b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "CubeBroadCastEvent(event=" + this.f257185a + ", params=" + this.f257186b + ')';
    }

    public b(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f257185a = r100;
        this.f257186b = r101;
    }
}
