package com.bytedance.applog.priority;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f192611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f192612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f192613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f192614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f192615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PriorityCallback f192616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PriorityEventMetaFactory f192617g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f192611a, r101.f192611a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f192612b, r101.f192612b) == true) goto L15;
        return false;
    L15:
        if (this.f192613c == r101.f192613c) goto L18;
        return false;
    L18:
        if (this.f192614d == r101.f192614d) goto L21;
        return false;
    L21:
        if (this.f192615e == r101.f192615e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f192616f, r101.f192616f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f192617g, r101.f192617g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((this.f192611a.hashCode() * 31) + this.f192612b.hashCode()) * 31;
        boolean r101 = this.f192613c;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        boolean r105 = this.f192614d;
        ?? r106 = r105;
        if (r105 == false) goto L8;
        r106 = 1;
    L8:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f192615e;
        if (r108 == true) goto L13;
        r102 = r108;
    L13:
        return ((((r107 + r102) * 31) + this.f192616f.hashCode()) * 31) + this.f192617g.hashCode();
    }

    public final String toString() {
        return "PriorityConfig(appId='" + this.f192611a + "', defaultReportUrl='" + this.f192612b + "', logEnabled=" + this.f192613c + ", eventUidEnabled=" + this.f192614d + ", encryptable=" + this.f192615e + ')';
    }

    public f(String r100, String r101, boolean r102, boolean r103, boolean r104, PriorityCallbackImpl r105, i r106) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "defaultReportUrl");
        Intrinsics.checkNotNullParameter(r105, "priorityCallback");
        Intrinsics.checkNotNullParameter(r106, "eventMetaFactory");
        this.f192611a = r100;
        this.f192612b = r101;
        this.f192613c = r102;
        this.f192614d = r103;
        this.f192615e = r104;
        this.f192616f = r105;
        this.f192617g = r106;
    }
}
