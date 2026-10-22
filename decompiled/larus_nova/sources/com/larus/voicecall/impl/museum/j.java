package com.larus.voicecall.impl.museum;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f378390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f378391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f378392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f378393d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f378390a == r101.f378390a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f378391b, r101.f378391b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f378392c, r101.f378392c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f378393d, r101.f378393d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f378390a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f378391b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Long r106 = this.f378392c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f378393d;
        if (r109 == null) goto L19;
        r103 = r109.hashCode();
    L19:
        return r108 + r103;
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "MuseumPickExtensionResult(success=" + this.f378390a + ", msg=" + this.f378391b + ", grantDuration=" + this.f378392c + ", failReason=" + this.f378393d + ')';
    }

    public j(boolean r100, String r101, Long r102, String r103) {
        this.f378390a = r100;
        this.f378391b = r101;
        this.f378392c = r102;
        this.f378393d = r103;
    }
}
