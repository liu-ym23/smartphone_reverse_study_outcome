package com.obric.assistant.settings;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f391987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f391988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f391989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f391990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f391991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f391992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f391993g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f391987a, r101.f391987a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f391988b, r101.f391988b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f391989c, r101.f391989c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f391990d, r101.f391990d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f391991e, r101.f391991e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f391992f, r101.f391992f) == true) goto L27;
        return false;
    L27:
        if (this.f391993g == r101.f391993g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f391987a.hashCode() * 31) + this.f391988b.hashCode()) * 31) + this.f391989c.hashCode()) * 31;
        List<String> r101 = this.f391990d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((((((r100 + r102) * 31) + this.f391991e.hashCode()) * 31) + this.f391992f.hashCode()) * 31) + this.f391993g;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AppInfo(packageName=" + this.f391987a + ", appName=" + this.f391988b + ", appEnName=" + this.f391989c + ", appAliasName=" + this.f391990d + ", appPinyinName=" + this.f391991e + ", appPinyinFirstLetter=" + this.f391992f + ", blockSouce=" + this.f391993g + ')';
    }

    public /* synthetic */ b(String r100, String r110, String r111) {
        this(r100, r110, "", null, "", r111, 0);
    }

    public static b a(b r110, List r111, int r112, int r113) {
        String r100 = null;
        if ((r113 & 1) == 0) goto L5;
        String r101 = r110.f391987a;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r102 = r110.f391988b;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r103 = r110.f391989c;
    L15:
        if ((r113 & 8) == 0) goto L17;
        r111 = r110.f391990d;
    L17:
        List r104 = r111;
        if ((r113 & 16) == 0) goto L20;
        String r105 = r110.f391991e;
    L22:
        if ((r113 & 32) == 0) goto L24;
        r100 = r110.f391992f;
    L24:
        String r106 = r100;
        if ((r113 & 64) == 0) goto L27;
        r112 = r110.f391993g;
    L27:
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, "appName");
        Intrinsics.checkNotNullParameter(r103, "appEnName");
        Intrinsics.checkNotNullParameter(r105, "appPinyinName");
        Intrinsics.checkNotNullParameter(r106, "appPinyinFirstLetter");
        return new b(r101, r102, r103, r104, r105, r106, r112);
    L20:
        r105 = null;
        goto L22
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public b(String r100, String r101, String r102, List<String> r103, String r104, String r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "appName");
        Intrinsics.checkNotNullParameter(r102, "appEnName");
        Intrinsics.checkNotNullParameter(r104, "appPinyinName");
        Intrinsics.checkNotNullParameter(r105, "appPinyinFirstLetter");
        this.f391987a = r100;
        this.f391988b = r101;
        this.f391989c = r102;
        this.f391990d = r103;
        this.f391991e = r104;
        this.f391992f = r105;
        this.f391993g = r106;
    }
}
