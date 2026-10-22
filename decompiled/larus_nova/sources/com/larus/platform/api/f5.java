package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class f5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f365111c;

    public f5() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f5) == true) goto L8;
        return false;
    L8:
        f5 r101 = (f5) r100;
        if (Intrinsics.areEqual(this.f365109a, r101.f365109a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365110b, r101.f365110b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365111c, r101.f365111c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f365109a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f365110b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f365111c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SdkDouyinHeartbeatResult(token=" + this.f365109a + ", openId=" + this.f365110b + ", scope=" + this.f365111c + ')';
    }

    public f5(String r100, String r101, String r102) {
        this.f365109a = r100;
        this.f365110b = r101;
        this.f365111c = r102;
    }
}
