package com.larus.dora.impl.assistant;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f332047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f332048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f332049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f332050d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f332047a == r101.f332047a) goto L12;
        return false;
    L12:
        if (this.f332048b == r101.f332048b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f332049c, r101.f332049c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f332050d, r101.f332050d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f332047a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f332048b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String r104 = this.f332049c;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f332050d;
        if (r108 == null) goto L19;
        r105 = r108.hashCode();
    L19:
        return r107 + r105;
    L13:
        r106 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "DoraWifiStateResult(success=" + this.f332047a + ", enabled=" + this.f332048b + ", errorCode=" + this.f332049c + ", errorMsg=" + this.f332050d + ')';
    }

    public f(boolean r100, boolean r101, String r102, String r103) {
        this.f332047a = r100;
        this.f332048b = r101;
        this.f332049c = r102;
        this.f332050d = r103;
    }
}
