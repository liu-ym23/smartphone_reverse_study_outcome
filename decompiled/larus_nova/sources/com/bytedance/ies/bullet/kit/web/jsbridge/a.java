package com.bytedance.ies.bullet.kit.web.jsbridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f247041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f247042b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f247041a == r101.f247041a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f247042b, r101.f247042b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f247041a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f247042b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "BlockJsbCallResult(shouldBlock=" + this.f247041a + ", msg=" + this.f247042b + ')';
    }

    public a() {
        Intrinsics.checkNotNullParameter("", "msg");
        this.f247041a = false;
        this.f247042b = "";
    }
}
