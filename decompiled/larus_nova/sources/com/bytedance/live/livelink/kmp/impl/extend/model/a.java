package com.bytedance.live.livelink.kmp.impl.extend.model;

import kotlin.jvm.internal.Intrinsics;
import zf2.d0;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f255592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f255593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f255594c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f255592a, r101.f255592a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f255593b, r101.f255593b) == true) goto L10;
        return false;
    L10:
        if (this.f255594c == r101.f255594c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f255592a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d0 r104 = this.f255593b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f255594c;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ChorusPosition(uid=" + this.f255592a + ", positon=" + this.f255593b + ", hasUser=" + this.f255594c + ")";
    }

    public a(d0 r100) {
        Intrinsics.checkNotNullParameter("#", "uid");
        Intrinsics.checkNotNullParameter(r100, "positon");
        this.f255592a = "#";
        this.f255593b = r100;
        this.f255594c = false;
    }
}
