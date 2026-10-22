package com.larus.dora.obric.device_management.device_home;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DoraObricDeviceHomeTabPage f339351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f339352c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r1) == true) goto L8;
        return false;
    L8:
        r1 r101 = (r1) r100;
        if (Intrinsics.areEqual(this.f339350a, r101.f339350a) == true) goto L12;
        return false;
    L12:
        if (this.f339351b == r101.f339351b) goto L15;
        return false;
    L15:
        if (this.f339352c == r101.f339352c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f339350a.hashCode() * 31) + this.f339351b.hashCode()) * 31;
        if (this.f339352c == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraObricDeviceHomeTab(title=" + this.f339350a + ", page=" + this.f339351b + ", selected=" + this.f339352c + ')';
    }

    public r1(String r100, DoraObricDeviceHomeTabPage r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "page");
        this.f339350a = r100;
        this.f339351b = r101;
        this.f339352c = r102;
    }
}
