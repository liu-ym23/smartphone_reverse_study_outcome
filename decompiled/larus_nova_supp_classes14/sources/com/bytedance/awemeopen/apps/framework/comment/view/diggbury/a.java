package com.bytedance.awemeopen.apps.framework.comment.view.diggbury;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public final o14.a a;
    public final String b;
    public final boolean c;
    public final int d;
    public final boolean e;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
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
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = (r0 + r2) * 31;
        boolean r4 = this.c;
        ?? r5 = 1;
        ?? r6 = r4;
        if (r4 == false) goto L9;
        r6 = 1;
    L9:
        int r7 = (((r3 + r6) * 31) + this.d) * 31;
        boolean r8 = this.e;
        if (r8 == true) goto L14;
        r5 = r8;
    L14:
        return r7 + r5;
    L5:
        r2 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "CommentDiggParams(comment=" + this.a + ", enterMethod=" + this.b + ", isCommentFeed=" + this.c + ", diggType=" + this.d + ", isFakeAction=" + this.e + ')';
    }

    public a(o14.a r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "comment");
        this.a = r2;
        this.b = null;
        this.c = false;
        this.d = r3;
        this.e = false;
    }
}
