package com.larus.dora.impl.assistant;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f332039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f332040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f332041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f332042d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f332039a == r101.f332039a) goto L12;
        return false;
    L12:
        if (this.f332040b == r101.f332040b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f332041c, r101.f332041c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f332042d, r101.f332042d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f332039a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f332040b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String r104 = this.f332041c;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f332042d;
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
        return "AssistantWifiStateResult(success=" + this.f332039a + ", enabled=" + this.f332040b + ", errorCode=" + this.f332041c + ", errorMsg=" + this.f332042d + ')';
    }

    public c(boolean r100, boolean r101, String r102, String r103) {
        this.f332039a = r100;
        this.f332040b = r101;
        this.f332041c = r102;
        this.f332042d = r103;
    }
}
