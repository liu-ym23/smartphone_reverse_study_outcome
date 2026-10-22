package com.larus.common.account.platform.larkauth.model;

import com.alipay.sdk.m.p.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f326144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f326145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f326146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f326147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f326148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f326149f;

    public b() {
        this(null, null, null, false, false, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f326144a, r101.f326144a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f326145b, r101.f326145b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f326146c, r101.f326146c) == true) goto L18;
        return false;
    L18:
        if (this.f326147d == r101.f326147d) goto L21;
        return false;
    L21:
        if (this.f326148e == r101.f326148e) goto L24;
        return false;
    L24:
        if (this.f326149f == r101.f326149f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f326144a.hashCode() * 31) + this.f326145b.hashCode()) * 31;
        String r101 = this.f326146c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f326147d == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f326148e == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f326149f == true) goto L19;
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
        return "LarkAuthRequestContext(method=" + this.f326144a + ", url=" + this.f326145b + ", host=" + this.f326146c + ", whiteCheck=" + this.f326147d + ", checkMainThread=" + this.f326148e + ", forceNetworkDPop=" + this.f326149f + ')';
    }

    public b(String r100, String r101, String r102, boolean r103, boolean r104, boolean r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = false;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = true;
    L18:
        if ((r106 & 32) == 0) goto L20;
        r105 = false;
    L20:
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "url");
        this.f326144a = r100;
        this.f326145b = r101;
        this.f326146c = r102;
        this.f326147d = r103;
        this.f326148e = r104;
        this.f326149f = r105;
    }
}
