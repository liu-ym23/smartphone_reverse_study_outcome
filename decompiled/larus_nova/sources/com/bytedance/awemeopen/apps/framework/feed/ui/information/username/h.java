package com.bytedance.awemeopen.apps.framework.feed.ui.information.username;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f196530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f196531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f196532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f196533d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f196530a, r101.f196530a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f196531b, r101.f196531b) == true) goto L15;
        return false;
    L15:
        if (this.f196532c == r101.f196532c) goto L18;
        return false;
    L18:
        if (this.f196533d == r101.f196533d) goto L20;
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
        int r100 = ((this.f196530a.hashCode() * 31) + this.f196531b.hashCode()) * 31;
        boolean r101 = this.f196532c;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f196533d;
        if (r105 == true) goto L10;
        r102 = r105;
    L10:
        return r104 + r102;
    }

    public final String toString() {
        return "UserNameInfo(userName=" + this.f196530a + ", awemeCreateTime=" + this.f196531b + ", hasPhotoTag=" + this.f196532c + ", hasDouyinTag=" + this.f196533d + ')';
    }

    public h(String r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "userName");
        Intrinsics.checkNotNullParameter(r101, "awemeCreateTime");
        this.f196530a = r100;
        this.f196531b = r101;
        this.f196532c = r102;
        this.f196533d = r103;
    }
}
