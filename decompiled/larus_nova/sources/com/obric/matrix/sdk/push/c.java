package com.obric.matrix.sdk.push;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397025b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f397024a, r101.f397024a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397025b, r101.f397025b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f397024a.hashCode() * 31) + this.f397025b.hashCode();
    }

    public final String toString() {
        return "PushConfiguration(appId=" + this.f397024a + ", appKey=" + this.f397025b + ')';
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276376z);
        this.f397024a = r100;
        this.f397025b = r101;
    }
}
