package com.larus.office.card.urlpreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f361870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f361871b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c2) == true) goto L8;
        return false;
    L8:
        c2 r101 = (c2) r100;
        if (Intrinsics.areEqual(this.f361870a, r101.f361870a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f361871b, r101.f361871b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f361870a.hashCode() * 31) + this.f361871b.hashCode();
    }

    public final String toString() {
        return "OfficeUrlPreviewRequestKey(messageId=" + this.f361870a + ", url=" + this.f361871b + ')';
    }

    public c2(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f361870a = r100;
        this.f361871b = r101;
    }
}
