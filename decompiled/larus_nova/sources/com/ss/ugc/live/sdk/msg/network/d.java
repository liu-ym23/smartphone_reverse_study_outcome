package com.ss.ugc.live.sdk.msg.network;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f458296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f458297b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f458296a, r101.f458296a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f458297b, r101.f458297b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f458296a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f458297b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Header(key=" + this.f458296a + ", value=" + this.f458297b + ")";
    }

    public d(String r100, String r101) {
        this.f458296a = r100;
        this.f458297b = r101;
    }
}
