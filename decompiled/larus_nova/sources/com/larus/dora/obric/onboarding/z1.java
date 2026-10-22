package com.larus.dora.obric.onboarding;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f340966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f340967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f340968c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z1) == true) goto L8;
        return false;
    L8:
        z1 r101 = (z1) r100;
        if (Intrinsics.areEqual(this.f340966a, r101.f340966a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f340967b, r101.f340967b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f340968c, r101.f340968c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f340966a.hashCode() * 31;
        String r101 = this.f340967b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f340968c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ObricDoraOnboardingQueryItem(query=" + this.f340966a + ", answer=" + this.f340967b + ", pictureUrl=" + this.f340968c + ')';
    }

    public z1(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "query");
        this.f340966a = r100;
        this.f340967b = r101;
        this.f340968c = r102;
    }
}
