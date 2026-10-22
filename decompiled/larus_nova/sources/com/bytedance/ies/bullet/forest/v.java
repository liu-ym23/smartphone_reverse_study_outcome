package com.bytedance.ies.bullet.forest;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f246773b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f246772a, r101.f246772a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246773b, r101.f246773b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f246772a.hashCode() * 31;
        String r101 = this.f246773b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "RequestInfoCacheKey(srcUrl=" + this.f246772a + ", cdnUrl=" + this.f246773b + ')';
    }

    public v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "srcUrl");
        this.f246772a = r100;
        this.f246773b = r101;
    }
}
