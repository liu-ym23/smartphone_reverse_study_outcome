package com.bytedance.lark.rustclient.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b<Resp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<Resp> f253903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w f253904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f253905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f253906d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f253903a, r101.f253903a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253904b, r101.f253904b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f253905c, r101.f253905c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253906d, r101.f253906d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f253903a.hashCode() * 31) + this.f253904b.hashCode()) * 31;
        String r101 = this.f253905c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f253906d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChainInput(request=" + this.f253903a + ", scopePayload=" + this.f253904b + ", requestUidInstant=" + this.f253905c + ", requestUserContainerIdInstant=" + this.f253906d + ')';
    }

    public b(d<Resp> r100, w r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "scopePayload");
        this.f253903a = r100;
        this.f253904b = r101;
        this.f253905c = r102;
        this.f253906d = r103;
    }
}
