package com.larus.navigation.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f359715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f359716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f359717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f359718d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x) == true) goto L8;
        return false;
    L8:
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f359715a, r101.f359715a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f359716b, r101.f359716b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f359717c, r101.f359717c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f359718d, r101.f359718d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f359715a.hashCode() * 31) + this.f359716b.hashCode()) * 31;
        String r101 = this.f359717c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f359718d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "NavigationTraceContextParam(traceName=" + this.f359715a + ", traceId=" + this.f359716b + ", pageId=" + this.f359717c + ", widgetInstanceId=" + this.f359718d + ')';
    }

    public x(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "traceName");
        Intrinsics.checkNotNullParameter(r101, "traceId");
        this.f359715a = r100;
        this.f359716b = r101;
        this.f359717c = r102;
        this.f359718d = r103;
    }
}
