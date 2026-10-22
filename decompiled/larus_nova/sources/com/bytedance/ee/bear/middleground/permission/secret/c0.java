package com.bytedance.ee.bear.middleground.permission.secret;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f234031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f234033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f234034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f234035f;

    public c0() {
        this(null, 0, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r101 = (c0) r100;
        if (Intrinsics.areEqual(this.f234030a, r101.f234030a) == true) goto L12;
        return false;
    L12:
        if (this.f234031b == r101.f234031b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234032c, r101.f234032c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f234033d, r101.f234033d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234034e, r101.f234034e) == true) goto L24;
        return false;
    L24:
        if (this.f234035f == r101.f234035f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f234030a.hashCode() * 31) + this.f234031b) * 31) + this.f234032c.hashCode()) * 31) + this.f234033d.hashCode()) * 31) + this.f234034e.hashCode()) * 31) + this.f234035f;
    }

    public final String toString() {
        return "UpdateSecretParam(token=" + this.f234030a + ", type=" + this.f234031b + ", secLableId=" + this.f234032c + ", reason=" + this.f234033d + ", name=" + this.f234034e + ", level=" + this.f234035f + ')';
    }

    public final int getType() {
        return this.f234031b;
    }

    public c0(String r110, int r111, String r112, String r113, int r114) {
        String r100 = "";
        if ((r114 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r114 & 2) == 0) goto L9;
        r111 = sbb.e.f541296g.f541317b;
    L9:
        int r102 = r111;
        if ((r114 & 4) == 0) goto L12;
        String r103 = "";
    L14:
        if ((r114 & 8) == 0) goto L16;
        String r104 = "";
    L18:
        if ((r114 & 16) != 0) goto L21;
        r100 = null;
    L21:
        String r105 = r100;
        if ((r114 & 32) == 0) goto L24;
        int r106 = -1;
    L25:
        this(r101, r102, r103, r104, r105, r106);
        return;
    L24:
        r106 = 0;
        goto L25
    L16:
        r104 = r113;
        goto L18
    L12:
        r103 = r112;
        goto L14
    L5:
        r101 = r110;
        goto L7
    }

    public c0(String r100, int r101, String r102, String r103, String r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "secLableId");
        Intrinsics.checkNotNullParameter(r103, "reason");
        Intrinsics.checkNotNullParameter(r104, "name");
        this.f234030a = r100;
        this.f234031b = r101;
        this.f234032c = r102;
        this.f234033d = r103;
        this.f234034e = r104;
        this.f234035f = r105;
    }
}
