package com.lark.kmp.rustclient.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lark.kmp.rustclient.api.model.c<?> f282557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f282558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f282559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f282560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f282561e;

    public u() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f282557a, r101.f282557a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f282558b, r101.f282558b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f282559c, r101.f282559c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f282560d, r101.f282560d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f282561e, r101.f282561e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f282557a.hashCode() * 31;
        String r101 = this.f282558b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f282559c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.f282560d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Long r111 = this.f282561e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PacketData(request=" + this.f282557a + ", userId=" + this.f282558b + ", taskId=" + this.f282559c + ", currentThreadId=" + this.f282560d + ", containerId=" + this.f282561e + ')';
    }

    public u(com.lark.kmp.rustclient.api.model.c r100, String r101, Long r102, Long r103, Long r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f282557a = r100;
        this.f282558b = r101;
        this.f282559c = r102;
        this.f282560d = r103;
        this.f282561e = r104;
    }
}
