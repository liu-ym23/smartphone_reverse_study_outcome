package com.bytedance.awemeopen.apps.framework.feed.ui.information.username;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        boolean r1 = this.c;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.d;
        if (r5 == true) goto L10;
        r2 = r5;
    L10:
        return r4 + r2;
    }

    public final String toString() {
        return "UserNameInfo(userName=" + this.a + ", awemeCreateTime=" + this.b + ", hasPhotoTag=" + this.c + ", hasDouyinTag=" + this.d + ')';
    }

    public h(String r2, String r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "userName");
        Intrinsics.checkNotNullParameter(r3, "awemeCreateTime");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
