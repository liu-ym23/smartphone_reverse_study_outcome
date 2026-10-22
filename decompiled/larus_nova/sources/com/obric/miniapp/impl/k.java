package com.obric.miniapp.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f397655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f397656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f397658d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f397655a == r101.f397655a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397656b, r101.f397656b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397657c, r101.f397657c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f397658d, r101.f397658d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f397655a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f397656b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f397657c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Long r109 = this.f397658d;
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
        return "LiveIslandAnnouncementDecision(shouldSpeak=" + this.f397655a + ", speakText=" + this.f397656b + ", dedupeKey=" + this.f397657c + ", expireAtMs=" + this.f397658d + ')';
    }

    public k(boolean r100, String r101, String r102, Long r103) {
        this.f397655a = r100;
        this.f397656b = r101;
        this.f397657c = r102;
        this.f397658d = r103;
    }
}
