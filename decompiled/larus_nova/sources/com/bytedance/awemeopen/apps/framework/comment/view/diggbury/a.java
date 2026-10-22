package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o14.a f194228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f194229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f194230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f194231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f194232e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f194228a, r101.f194228a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f194229b, r101.f194229b) == true) goto L15;
        return false;
    L15:
        if (this.f194230c == r101.f194230c) goto L18;
        return false;
    L18:
        if (this.f194231d == r101.f194231d) goto L21;
        return false;
    L21:
        if (this.f194232e == r101.f194232e) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = this.f194228a.hashCode() * 31;
        String r101 = this.f194229b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.f194230c;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (((r103 + r106) * 31) + this.f194231d) * 31;
        boolean r108 = this.f194232e;
        if (r108 == true) goto L14;
        r105 = r108;
    L14:
        return r107 + r105;
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommentDiggParams(comment=" + this.f194228a + ", enterMethod=" + this.f194229b + ", isCommentFeed=" + this.f194230c + ", diggType=" + this.f194231d + ", isFakeAction=" + this.f194232e + ')';
    }

    public a(o14.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "comment");
        this.f194228a = r100;
        this.f194229b = null;
        this.f194230c = false;
        this.f194231d = r101;
        this.f194232e = false;
    }
}
