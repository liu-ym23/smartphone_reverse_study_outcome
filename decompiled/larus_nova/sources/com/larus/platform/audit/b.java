package com.larus.platform.audit;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f365329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365331e;

    public b() {
        this(null, null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f365327a, r101.f365327a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365328b, r101.f365328b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365329c, r101.f365329c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365330d, r101.f365330d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365331e, r101.f365331e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f365327a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f365328b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f365329c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f365330d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f365331e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BehaviorAuditFileInfo(fileId=" + this.f365327a + ", fileName=" + this.f365328b + ", fileSize=" + this.f365329c + ", md5=" + this.f365330d + ", fileType=" + this.f365331e + ')';
    }

    public b(String r100, String r101, Long r102, String r103, String r104) {
        this.f365327a = r100;
        this.f365328b = r101;
        this.f365329c = r102;
        this.f365330d = r103;
        this.f365331e = r104;
    }

    public /* synthetic */ b(String r100, String r101, Long r102, String r103, String r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        String r104 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r111 & 4) == 0) goto L13;
        Long r106 = null;
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r111 & 16) == 0) goto L21;
        String r112 = null;
    L22:
        this(r104, r105, r106, r107, r112);
        return;
    L21:
        r112 = r110;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r104 = r100;
        goto L7
    }
}
