package com.larus.platform.api;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<r> f365274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f365275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f365276e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t) == true) goto L8;
        return false;
    L8:
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f365272a, r101.f365272a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365273b, r101.f365273b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365274c, r101.f365274c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365275d, r101.f365275d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f365276e, r101.f365276e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f365272a.hashCode() * 31) + this.f365273b.hashCode()) * 31;
        List<r> r101 = this.f365274c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f365275d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f365276e;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowEffectItem(path=" + this.f365272a + ", resourceId=" + this.f365273b + ", effectParam=" + this.f365274c + ", effectId=" + this.f365275d + ", effectName=" + this.f365276e + ')';
    }

    public t(String r100, String r101, List<r> r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "resourceId");
        this.f365272a = r100;
        this.f365273b = r101;
        this.f365274c = r102;
        this.f365275d = r103;
        this.f365276e = r104;
    }
}
