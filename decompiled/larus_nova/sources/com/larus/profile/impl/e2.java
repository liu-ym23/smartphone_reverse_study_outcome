package com.larus.profile.impl;

import com.larus.profile.api.bean.LandingTab;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f366568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LandingTab f366569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f366570c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e2) == true) goto L8;
        return false;
    L8:
        e2 r101 = (e2) r100;
        if (Intrinsics.areEqual(this.f366568a, r101.f366568a) == true) goto L12;
        return false;
    L12:
        if (this.f366569b == r101.f366569b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f366570c, r101.f366570c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f366568a.hashCode() * 31) + this.f366569b.hashCode()) * 31;
        Boolean r101 = this.f366570c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ProfileSelectorData(fragmentTag=" + this.f366568a + ", landingTab=" + this.f366569b + ", isEmpty=" + this.f366570c + ')';
    }

    public e2(String r100, LandingTab r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "fragmentTag");
        Intrinsics.checkNotNullParameter(r101, "landingTab");
        this.f366568a = r100;
        this.f366569b = r101;
        this.f366570c = r102;
    }
}
