package com.bytedance.lark.rustclient.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.d<?> f254004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f254005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f254006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f254007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f254008e;

    public o() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f254004a, r101.f254004a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f254005b, r101.f254005b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f254006c, r101.f254006c) == true) goto L18;
        return false;
    L18:
        if (this.f254007d == r101.f254007d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f254008e, r101.f254008e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f254004a.hashCode() * 31;
        String r101 = this.f254005b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f254006c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        long r107 = this.f254007d;
        int r108 = (((r104 + r106) * 31) + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        Long r109 = this.f254008e;
        if (r109 == null) goto L15;
        r102 = r109.hashCode();
    L15:
        return r108 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PacketData(request=" + this.f254004a + ", userId=" + this.f254005b + ", taskId=" + this.f254006c + ", currentThreadId=" + this.f254007d + ", containerId=" + this.f254008e + ')';
    }

    public o(com.bytedance.lark.rustclient.api.d r100, String r101, Long r102, long r103, Long r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = 0;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f254004a = r100;
        this.f254005b = r101;
        this.f254006c = r102;
        this.f254007d = r103;
        this.f254008e = r104;
    }
}
