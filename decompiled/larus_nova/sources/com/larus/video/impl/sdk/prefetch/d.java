package com.larus.video.impl.sdk.prefetch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f375851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f375852b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f375851a, r101.f375851a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f375852b, r101.f375852b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f375851a.hashCode() * 31) + this.f375852b.hashCode();
    }

    public final String toString() {
        return "CachedFirstScreenData(messageId=" + this.f375851a + ", contentListJsonStr=" + this.f375852b + ')';
    }

    public d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "contentListJsonStr");
        this.f375851a = r100;
        this.f375852b = r101;
    }
}
