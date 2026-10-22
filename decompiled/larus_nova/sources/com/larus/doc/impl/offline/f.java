package com.larus.doc.impl.offline;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f331255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f331256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f331257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f331258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f331259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f331260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f331261g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f331255a, r101.f331255a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f331256b, r101.f331256b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f331257c, r101.f331257c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f331258d, r101.f331258d) == true) goto L21;
        return false;
    L21:
        if (this.f331259e == r101.f331259e) goto L24;
        return false;
    L24:
        if (this.f331260f == r101.f331260f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f331261g, r101.f331261g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f331255a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.f331256b.hashCode()) * 31) + this.f331257c.hashCode()) * 31;
        Long r104 = this.f331258d;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f331259e) * 31) + this.f331260f) * 31;
        String r107 = this.f331261g;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfflineDocCreateConfig(attemptId=" + this.f331255a + ", initialDocId=" + this.f331256b + ", conversationId=" + this.f331257c + ", messageId=" + this.f331258d + ", resourceType=" + this.f331259e + ", sourceType=" + this.f331260f + ", artifactVersionId=" + this.f331261g + ')';
    }

    public f(String r100, String r101, String r102, Long r103, int r104, int r105, String r106) {
        Intrinsics.checkNotNullParameter(r101, "initialDocId");
        Intrinsics.checkNotNullParameter(r102, "conversationId");
        this.f331255a = r100;
        this.f331256b = r101;
        this.f331257c = r102;
        this.f331258d = r103;
        this.f331259e = r104;
        this.f331260f = r105;
        this.f331261g = r106;
    }
}
