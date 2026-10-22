package com.larus.audio.call;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f289088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f289089b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f289088a, r101.f289088a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f289089b, r101.f289089b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f289088a.hashCode() * 31) + this.f289089b.hashCode();
    }

    public final String toString() {
        return "DebugConfig(larkSSOToken=" + this.f289088a + ", lunaVipMode=" + this.f289089b + ')';
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "larkSSOToken");
        Intrinsics.checkNotNullParameter(r101, "lunaVipMode");
        this.f289088a = r100;
        this.f289089b = r101;
    }
}
