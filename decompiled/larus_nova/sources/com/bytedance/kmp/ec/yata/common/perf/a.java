package com.bytedance.kmp.ec.yata.common.perf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f251470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f251471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f251472d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f251469a, r101.f251469a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251470b, r101.f251470b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f251471c, r101.f251471c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f251472d, r101.f251472d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f251469a.hashCode() * 31) + this.f251470b.hashCode()) * 31;
        Long r101 = this.f251471c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f251472d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TimingNode(key=" + this.f251469a + ", name=" + this.f251470b + ", start=" + this.f251471c + ", end=" + this.f251472d + ')';
    }

    public a(String r100, String r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f251469a = r100;
        this.f251470b = r101;
        this.f251471c = r102;
        this.f251472d = null;
    }
}
