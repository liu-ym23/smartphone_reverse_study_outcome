package com.lark.kmp.rustclient.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a<Resp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lark.kmp.rustclient.api.model.c<Resp> f282454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.lark.kmp.rustclient.api.model.j f282455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f282456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f282457d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f282454a, r101.f282454a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f282455b, r101.f282455b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f282456c, r101.f282456c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f282457d, r101.f282457d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f282454a.hashCode() * 31) + this.f282455b.hashCode()) * 31;
        String r101 = this.f282456c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f282457d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ChainInput(request=" + this.f282454a + ", scopePayload=" + this.f282455b + ", requestUidInstant=" + this.f282456c + ", requestUserContainerIdInstant=" + this.f282457d + ')';
    }

    public a(com.lark.kmp.rustclient.api.model.c<Resp> r100, com.lark.kmp.rustclient.api.model.j r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "scopePayload");
        this.f282454a = r100;
        this.f282455b = r101;
        this.f282456c = r102;
        this.f282457d = r103;
    }
}
