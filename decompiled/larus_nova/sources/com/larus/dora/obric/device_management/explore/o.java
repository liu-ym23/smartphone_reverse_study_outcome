package com.larus.dora.obric.device_management.explore;

import com.bytedance.dora.annotation.ProductNameType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProductNameType f339544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c59.t f339545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f339546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z49.b f339547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<n> f339548e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f339544a == r101.f339544a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f339545b, r101.f339545b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f339546c, r101.f339546c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f339547d, r101.f339547d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f339548e, r101.f339548e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        ProductNameType r100 = this.f339544a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c59.t r104 = this.f339545b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f339546c.hashCode()) * 31;
        z49.b r107 = this.f339547d;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return ((r106 + r101) * 31) + this.f339548e.hashCode();
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoraObricExploreSection(productType=" + this.f339544a + ", title=" + this.f339545b + ", fallbackTitle=" + this.f339546c + ", device=" + this.f339547d + ", items=" + this.f339548e + ')';
    }

    public o(ProductNameType r100, c59.t r101, String r102, z49.b r103, List<n> r104) {
        Intrinsics.checkNotNullParameter(r102, "fallbackTitle");
        Intrinsics.checkNotNullParameter(r104, "items");
        this.f339544a = r100;
        this.f339545b = r101;
        this.f339546c = r102;
        this.f339547d = r103;
        this.f339548e = r104;
    }
}
