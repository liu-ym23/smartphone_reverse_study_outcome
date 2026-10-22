package com.larus.bmhome.taskskill;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f314245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f314246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f314247c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f314245a, r101.f314245a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f314246b, r101.f314246b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f314247c, r101.f314247c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f314245a.hashCode() * 31) + this.f314246b.hashCode()) * 31) + this.f314247c.hashCode();
    }

    public final String toString() {
        return "AuthorizationModeCacheKey(accountId=" + this.f314245a + ", conversationId=" + this.f314246b + ", remotePcDeviceId=" + this.f314247c + ')';
    }

    public a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "accountId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "remotePcDeviceId");
        this.f314245a = r100;
        this.f314246b = r101;
        this.f314247c = r102;
    }
}
