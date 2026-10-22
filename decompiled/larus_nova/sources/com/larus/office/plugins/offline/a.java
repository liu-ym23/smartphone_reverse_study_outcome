package com.larus.office.plugins.offline;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f363075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f363076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f363077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f363078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f363079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f363080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f363081g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f363075a, r101.f363075a) == true) goto L12;
        return false;
    L12:
        if (this.f363076b == r101.f363076b) goto L15;
        return false;
    L15:
        if (this.f363077c == r101.f363077c) goto L18;
        return false;
    L18:
        if (this.f363078d == r101.f363078d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f363079e, r101.f363079e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f363080f, r101.f363080f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f363081g, r101.f363081g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f363075a.hashCode() * 31;
        long r101 = this.f363076b;
        int r102 = (((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f363077c) * 31) + this.f363078d) * 31;
        String r103 = this.f363079e;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f363080f;
        if (r107 != null) goto L9;
        int r108 = 0;
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f363081g;
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
        return "OfficeCreateDocByMessageSnapshot(conversationId=" + this.f363075a + ", messageId=" + this.f363076b + ", resourceType=" + this.f363077c + ", sourceType=" + this.f363078d + ", artifactVersionId=" + this.f363079e + ", originalMessageId=" + this.f363080f + ", attemptId=" + this.f363081g + ')';
    }

    public a(String r100, long r101, int r102, int r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        this.f363075a = r100;
        this.f363076b = r101;
        this.f363077c = r102;
        this.f363078d = r103;
        this.f363079e = r104;
        this.f363080f = r105;
        this.f363081g = r106;
    }
}
