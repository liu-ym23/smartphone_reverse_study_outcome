package com.larus.common.account.bdauth.repository;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f325938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f325939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f325940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f325941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f325942e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f325938a, r101.f325938a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f325939b, r101.f325939b) == true) goto L15;
        return false;
    L15:
        if (this.f325940c == r101.f325940c) goto L18;
        return false;
    L18:
        if (this.f325941d == r101.f325941d) goto L21;
        return false;
    L21:
        if (this.f325942e == r101.f325942e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f325938a.hashCode() * 31;
        String r101 = this.f325939b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f325940c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f325941d == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f325942e == true) goto L19;
        r104 = 1237;
    L19:
        return r108 + r104;
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BDAuthorizeAccountSnapshot(accounts=" + this.f325938a + ", defaultSelectedSecUserId=" + this.f325939b + ", showAddAccount=" + this.f325940c + ", multiAccountEnabled=" + this.f325941d + ", hasLoginAccount=" + this.f325942e + ')';
    }

    public c(List<a> r100, String r101, boolean r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "accounts");
        this.f325938a = r100;
        this.f325939b = r101;
        this.f325940c = r102;
        this.f325941d = r103;
        this.f325942e = r104;
    }
}
