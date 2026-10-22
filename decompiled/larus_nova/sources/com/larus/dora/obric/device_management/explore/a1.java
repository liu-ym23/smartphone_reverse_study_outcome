package com.larus.dora.obric.device_management.explore;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f339495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0 f339496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f339497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f339498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y0 f339499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f339500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f339501g;

    public a1() {
        this(null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a1) == true) goto L8;
        return false;
    L8:
        a1 r101 = (a1) r100;
        if (Intrinsics.areEqual(this.f339495a, r101.f339495a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f339496b, r101.f339496b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f339497c, r101.f339497c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f339498d, r101.f339498d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f339499e, r101.f339499e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f339500f, r101.f339500f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f339501g, r101.f339501g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f339495a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        z0 r104 = this.f339496b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.f339497c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f339498d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        y0 r113 = this.f339499e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f339500f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f339501g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "DoraObricGlassesIntroductionPageInfo(title=" + this.f339495a + ", image=" + this.f339496b + ", descriptions=" + this.f339497c + ", queries=" + this.f339498d + ", buttonInfo=" + this.f339499e + ", cardContentType=" + this.f339500f + ", buttonType=" + this.f339501g + ')';
    }

    public a1(String r100, z0 r101, List<String> r102, List<String> r103, y0 r104, String r105, String r106) {
        this.f339495a = r100;
        this.f339496b = r101;
        this.f339497c = r102;
        this.f339498d = r103;
        this.f339499e = r104;
        this.f339500f = r105;
        this.f339501g = r106;
    }
}
