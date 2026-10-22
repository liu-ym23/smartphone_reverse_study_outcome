package com.larus.bmhome.auth;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f295807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TouristModeABParam f295808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f295809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f295810d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i1) == true) goto L8;
        return false;
    L8:
        i1 r101 = (i1) r100;
        if (Intrinsics.areEqual(this.f295807a, r101.f295807a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295808b, r101.f295808b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295809c, r101.f295809c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295810d, r101.f295810d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f295807a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        TouristModeABParam r104 = this.f295808b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f295809c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f295810d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TouristModeInfo(secUserId=" + this.f295807a + ", touristModeABParam=" + this.f295808b + ", mainBotId=" + this.f295809c + ", mainConversationId=" + this.f295810d + ')';
    }

    public i1(String r100, TouristModeABParam r101, String r102, String r103) {
        this.f295807a = r100;
        this.f295808b = r101;
        this.f295809c = r102;
        this.f295810d = r103;
    }
}
