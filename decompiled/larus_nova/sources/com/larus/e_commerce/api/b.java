package com.larus.e_commerce.api;

import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f342338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f342339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f342340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f342341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f342342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f342343f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f342338a, r101.f342338a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f342339b, r101.f342339b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f342340c, r101.f342340c) == true) goto L18;
        return false;
    L18:
        if (this.f342341d == r101.f342341d) goto L21;
        return false;
    L21:
        if (this.f342342e == r101.f342342e) goto L24;
        return false;
    L24:
        if (this.f342343f == r101.f342343f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f342338a.hashCode() * 31) + this.f342339b.hashCode()) * 31) + this.f342340c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f342341d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f342342e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f342343f == true) goto L15;
        r101 = 1237;
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ECBindDouYinParams(activity=" + this.f342338a + ", sourcePage=" + this.f342339b + ", sourceMethod=" + this.f342340c + ", bindPanelCancelButtonVisible=" + this.f342341d + ", ignoreNotifyPopup=" + this.f342342e + ", isMiniApplication=" + this.f342343f + ')';
    }

    public final FragmentActivity getActivity() {
        return this.f342338a;
    }

    public /* synthetic */ b(FragmentActivity r100, String r101, String r110, boolean r111) {
        this(r100, r101, r110, r111, false, false);
    }

    public b(FragmentActivity r100, String r101, String r102, boolean r103, boolean r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "sourcePage");
        Intrinsics.checkNotNullParameter(r102, "sourceMethod");
        this.f342338a = r100;
        this.f342339b = r101;
        this.f342340c = r102;
        this.f342341d = r103;
        this.f342342e = r104;
        this.f342343f = r105;
    }
}
