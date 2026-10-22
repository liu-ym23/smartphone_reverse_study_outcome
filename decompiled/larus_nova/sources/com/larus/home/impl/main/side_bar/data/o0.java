package com.larus.home.impl.main.side_bar.data;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k0 f344525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f344526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<s> f344527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f344528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f344529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k0 f344530f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o0) == true) goto L8;
        return false;
    L8:
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.f344525a, r101.f344525a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f344526b, r101.f344526b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f344527c, r101.f344527c) == true) goto L18;
        return false;
    L18:
        if (this.f344528d == r101.f344528d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f344529e, r101.f344529e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f344530f, r101.f344530f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f344525a.hashCode() * 31) + this.f344526b.hashCode()) * 31) + this.f344527c.hashCode()) * 31;
        long r101 = this.f344528d;
        int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f344529e.hashCode()) * 31;
        k0 r103 = this.f344530f;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        return "SideBarOrderUpdate(layout=" + this.f344525a + ", componentId=" + this.f344526b + ", components=" + this.f344527c + ", lastUpdateTime=" + this.f344528d + ", userId=" + this.f344529e + ", previousLayout=" + this.f344530f + ')';
    }

    public static o0 a(o0 r100, String r101, k0 r110) {
        k0 r102 = r100.f344525a;
        String r103 = r100.f344526b;
        List<s> r104 = r100.f344527c;
        long r105 = r100.f344528d;
        Intrinsics.checkNotNullParameter(r102, "layout");
        Intrinsics.checkNotNullParameter(r103, "componentId");
        Intrinsics.checkNotNullParameter(r104, "components");
        Intrinsics.checkNotNullParameter(r101, "userId");
        return new o0(r102, r103, r104, r105, r101, r110);
    }

    public o0(k0 r100, String r101, List<s> r102, long r103, String r104, k0 r105) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        Intrinsics.checkNotNullParameter(r101, "componentId");
        Intrinsics.checkNotNullParameter(r102, "components");
        Intrinsics.checkNotNullParameter(r104, "userId");
        this.f344525a = r100;
        this.f344526b = r101;
        this.f344527c = r102;
        this.f344528d = r103;
        this.f344529e = r104;
        this.f344530f = r105;
    }
}
