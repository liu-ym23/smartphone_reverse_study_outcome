package com.bytedance.iesgurd;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f250678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f250679b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f250678a, r101.f250678a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f250679b, r101.f250679b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f250678a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f250679b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IESGurdObserverCleanInfo(accessKey=" + this.f250678a + ", channel=" + this.f250679b + ")";
    }

    public d(String r100, String r101) {
        this.f250678a = r100;
        this.f250679b = r101;
    }
}
