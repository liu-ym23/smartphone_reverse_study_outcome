package com.bytedance.iesgurd;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f250701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f250702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f250703c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (this.f250701a == r101.f250701a) goto L8;
        return false;
    L8:
        if (this.f250702b == r101.f250702b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f250703c, r101.f250703c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.f250701a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.f250702b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f250703c;
        if (r104 == null) goto L8;
        int r105 = r104.hashCode();
    L10:
        return r103 + r105;
    L8:
        r105 = 0;
        goto L10
    }

    public final String toString() {
        return "IESGurdUpdateChannelInfo(success=" + this.f250701a + ", version=" + this.f250702b + ", errorMessage=" + this.f250703c + ")";
    }

    public h(boolean r100, long r101, String r102) {
        this.f250701a = r100;
        this.f250702b = r101;
        this.f250703c = r102;
    }
}
