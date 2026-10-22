package com.bytedance.ies.bullet.base.utils.logger;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f246349b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f246348a, r101.f246348a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246349b, r101.f246349b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f246348a.hashCode() * 31) + this.f246349b.hashCode();
    }

    public final String toString() {
        return "Stage(name=" + this.f246348a + ", sessionId=" + this.f246349b + ')';
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        this.f246348a = r100;
        this.f246349b = r101;
    }
}
