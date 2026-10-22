package com.bytedance.ee.bear.contract;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f217053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f217054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f217055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f217056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0.e f217057e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f217053a, r101.f217053a) == true) goto L12;
        return false;
    L12:
        if (this.f217054b == r101.f217054b) goto L15;
        return false;
    L15:
        if (this.f217055c == r101.f217055c) goto L18;
        return false;
    L18:
        if (this.f217056d == r101.f217056d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f217057e, r101.f217057e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f217053a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f217054b) * 31;
        if (this.f217055c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f217056d) * 31;
        c0.e r106 = this.f217057e;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ListSubscribeBean(token=" + this.f217053a + ", type=" + this.f217054b + ", isSubscribe=" + this.f217055c + ", subscribeType=" + this.f217056d + ", callback=" + this.f217057e + ')';
    }

    public final int getType() {
        return this.f217054b;
    }

    public f0(String r100, int r101, boolean r102, int r103, c0.e r104) {
        this.f217053a = r100;
        this.f217054b = r101;
        this.f217055c = r102;
        this.f217056d = r103;
        this.f217057e = r104;
    }
}
