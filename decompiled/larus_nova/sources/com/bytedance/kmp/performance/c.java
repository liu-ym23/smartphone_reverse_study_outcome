package com.bytedance.kmp.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f252710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f252711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f252712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f252713d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f252714e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f252710a, r101.f252710a) == true) goto L12;
        return false;
    L12:
        if (this.f252711b == r101.f252711b) goto L15;
        return false;
    L15:
        if (this.f252712c == r101.f252712c) goto L18;
        return false;
    L18:
        if (this.f252713d == r101.f252713d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f252714e, r101.f252714e) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f252710a.hashCode() * 31;
        long r101 = this.f252711b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        int r103 = 1231;
        if (this.f252712c == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f252713d == true) goto L11;
        r103 = 1237;
    L11:
        return ((((r105 + r103) * 31) + 0) * 31) + this.f252714e.hashCode();
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "KPerfViewWrapperKey(scene=" + this.f252710a + ", openTimeStamp=" + this.f252711b + ", showImmediately=" + this.f252712c + ", frameCallbackOpt=" + this.f252713d + ", state=null, containerId=" + this.f252714e + ')';
    }

    public c(String r100, long r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter("", "containerId");
        this.f252710a = r100;
        this.f252711b = r101;
        this.f252712c = r102;
        this.f252713d = r103;
        this.f252714e = "";
    }
}
