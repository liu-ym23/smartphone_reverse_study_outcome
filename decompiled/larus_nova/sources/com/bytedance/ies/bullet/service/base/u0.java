package com.bytedance.ies.bullet.service.base;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<w0> f247914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<x0> f247915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<v0> f247916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b1> f247917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<y0> f247918e;

    public u0() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.f247914a, r101.f247914a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f247915b, r101.f247915b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f247916c, r101.f247916c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f247917d, r101.f247917d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f247918e, r101.f247918e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<w0> r100 = this.f247914a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<x0> r104 = this.f247915b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<v0> r107 = this.f247916c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<b1> r110 = this.f247917d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<y0> r113 = this.f247918e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "PreloadConfig(geckoChannel=" + this.f247914a + ", image=" + this.f247915b + ", font=" + this.f247916c + ", video=" + this.f247917d + ", js=" + this.f247918e + ')';
    }

    public u0(List<w0> r100, List<x0> r101, List<v0> r102, List<b1> r103, List<y0> r104) {
        this.f247914a = r100;
        this.f247915b = r101;
        this.f247916c = r102;
        this.f247917d = r103;
        this.f247918e = r104;
    }
}
