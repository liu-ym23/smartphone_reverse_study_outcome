package com.bytedance.lark.lark_bitable_android;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f253069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f253070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<f0> f253071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<g0> f253072e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f253068a, r101.f253068a) == true) goto L12;
        return false;
    L12:
        if (this.f253069b == r101.f253069b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f253070c, r101.f253070c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f253071d, r101.f253071d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f253072e, r101.f253072e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f253068a.hashCode() * 31;
        if (this.f253069b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((((r100 + r101) * 31) + this.f253070c.hashCode()) * 31) + this.f253071d.hashCode()) * 31) + this.f253072e.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "HomepageListData(lastLabel=" + this.f253068a + ", hasMore=" + this.f253069b + ", spaceToken=" + this.f253070c + ", docDataList=" + this.f253071d + ", rawDataList=" + this.f253072e + ')';
    }

    public i0(String r100, boolean r101, String r102, List<f0> r103, List<g0> r104) {
        Intrinsics.checkNotNullParameter(r100, "lastLabel");
        Intrinsics.checkNotNullParameter(r102, "spaceToken");
        Intrinsics.checkNotNullParameter(r103, "docDataList");
        Intrinsics.checkNotNullParameter(r104, "rawDataList");
        this.f253068a = r100;
        this.f253069b = r101;
        this.f253070c = r102;
        this.f253071d = r103;
        this.f253072e = r104;
    }
}
