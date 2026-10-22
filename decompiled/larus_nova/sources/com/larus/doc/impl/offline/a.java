package com.larus.doc.impl.offline;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f331234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f331235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f331236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f331237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f331238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f331239f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f331240g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f331234a, r101.f331234a) == true) goto L12;
        return false;
    L12:
        if (this.f331235b == r101.f331235b) goto L15;
        return false;
    L15:
        if (this.f331236c == r101.f331236c) goto L18;
        return false;
    L18:
        if (this.f331237d == r101.f331237d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f331238e, r101.f331238e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f331239f, r101.f331239f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f331240g, r101.f331240g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f331234a.hashCode() * 31;
        long r101 = this.f331235b;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f331236c) * 31) + this.f331237d) * 31;
        String r103 = this.f331238e;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f331239f;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f331240g;
        if (r110 == null) goto L15;
        r104 = r110.hashCode();
    L15:
        return r109 + r104;
    L9:
        r108 = r107.hashCode();
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreateDocByMessageSnapshot(conversationId=" + this.f331234a + ", messageId=" + this.f331235b + ", resourceType=" + this.f331236c + ", sourceType=" + this.f331237d + ", artifactVersionId=" + this.f331238e + ", docRealToken=" + this.f331239f + ", useMessageContent=" + this.f331240g + ')';
    }

    public static a a(a r100, String r110, Boolean r111) {
        String r101 = r100.f331234a;
        long r102 = r100.f331235b;
        int r103 = r100.f331236c;
        int r104 = r100.f331237d;
        String r105 = r100.f331238e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        return new a(r101, r102, r103, r104, r105, r110, r111);
    }

    public a(String r100, long r101, int r102, int r103, String r104, String r105, Boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.f331234a = r100;
        this.f331235b = r101;
        this.f331236c = r102;
        this.f331237d = r103;
        this.f331238e = r104;
        this.f331239f = r105;
        this.f331240g = r106;
    }
}
