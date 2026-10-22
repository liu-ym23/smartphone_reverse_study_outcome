package com.bytedance.ies.argus.bean;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TASMVerifyType f246065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f246066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f246067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f246068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<w> f246069e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f246065a == r101.f246065a) goto L12;
        return false;
    L12:
        if (this.f246066b == r101.f246066b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f246067c, r101.f246067c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f246068d, r101.f246068d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f246069e, r101.f246069e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        TASMVerifyType r100 = this.f246065a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f246066b) * 31;
        String r104 = this.f246067c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f246068d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<w> r110 = this.f246069e;
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
        return "TASMEncryptInfo(type=" + this.f246065a + ", totalLength=" + this.f246066b + ", appId=" + this.f246067c + ", signSuitesNumber=" + this.f246068d + ", signSuites=" + this.f246069e + ')';
    }

    public final TASMVerifyType getType() {
        return this.f246065a;
    }

    public y(TASMVerifyType r100, int r101, String r102, Integer r103, List<w> r104) {
        this.f246065a = r100;
        this.f246066b = r101;
        this.f246067c = r102;
        this.f246068d = r103;
        this.f246069e = r104;
    }
}
