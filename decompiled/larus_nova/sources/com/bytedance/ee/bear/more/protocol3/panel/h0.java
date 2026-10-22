package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f234975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f234976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f234977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f234978d;

    public h0() {
        Integer r100 = null;
        this(r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f234975a, r101.f234975a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234976b, r101.f234976b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234977c, r101.f234977c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f234978d, r101.f234978d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f234975a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f234976b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f234977c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f234978d;
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
        return "VisualOverride(iconRes=" + this.f234975a + ", iconTint=" + this.f234976b + ", disableIconTint=" + this.f234977c + ", title=" + this.f234978d + ')';
    }

    public /* synthetic */ h0(Integer r100, Integer r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        this(null, r100, r101, null);
    }

    public h0(Integer r100, Integer r101, Integer r102, String r103) {
        this.f234975a = r100;
        this.f234976b = r101;
        this.f234977c = r102;
        this.f234978d = r103;
    }
}
