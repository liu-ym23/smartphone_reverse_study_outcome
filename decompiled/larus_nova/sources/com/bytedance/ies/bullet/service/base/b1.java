package com.bytedance.ies.bullet.service.base;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f247781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f247782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f247783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f247784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f247785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f247786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f247787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f247788h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r101 = (b1) r100;
        if (Intrinsics.areEqual(this.f247781a, r101.f247781a) == true) goto L12;
        return false;
    L12:
        if (this.f247782b == r101.f247782b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f247783c, r101.f247783c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f247784d, r101.f247784d) == true) goto L21;
        return false;
    L21:
        if (this.f247785e == r101.f247785e) goto L24;
        return false;
    L24:
        if (this.f247786f == r101.f247786f) goto L27;
        return false;
    L27:
        if (this.f247787g == r101.f247787g) goto L30;
        return false;
    L30:
        if (this.f247788h == r101.f247788h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f247781a.hashCode() * 31;
        int r101 = 1231;
        if (this.f247782b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((r100 + r102) * 31) + this.f247783c.hashCode()) * 31) + this.f247784d.hashCode()) * 31) + this.f247785e) * 31;
        if (this.f247786f == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f247787g == true) goto L14;
        r101 = 1237;
    L14:
        long r106 = this.f247788h;
        return ((r105 + r101) * 31) + ((int) (r106 ^ (r106 >>> 32)));
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreloadVideoConfig(id=" + this.f247781a + ", h265=" + this.f247782b + ", uri=" + this.f247783c + ", url=" + this.f247784d + ", priority=" + this.f247785e + ", serial=" + this.f247786f + ", enableMemory=" + this.f247787g + ", expire=" + this.f247788h + ')';
    }

    public b1(String r100, boolean r101, String r102, List<String> r103, int r104, boolean r105, boolean r106, long r107) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r102, "uri");
        Intrinsics.checkNotNullParameter(r103, "url");
        this.f247781a = r100;
        this.f247782b = r101;
        this.f247783c = r102;
        this.f247784d = r103;
        this.f247785e = r104;
        this.f247786f = r105;
        this.f247787g = r106;
        this.f247788h = r107;
    }
}
