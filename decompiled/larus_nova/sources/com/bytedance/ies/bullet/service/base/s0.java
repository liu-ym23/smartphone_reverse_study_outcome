package com.bytedance.ies.bullet.service.base;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f247912b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (Intrinsics.areEqual(this.f247911a, r101.f247911a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f247912b, r101.f247912b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f247911a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JSONObject r104 = this.f247912b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PrefetchV2Data(globalPropsName=" + this.f247911a + ", body=" + this.f247912b + ')';
    }

    public s0(String r100, JSONObject r101) {
        this.f247911a = r100;
        this.f247912b = r101;
    }
}
