package com.bytedance.ies.argus.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConfigFrom f246108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f246109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f246110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArgusGeckoFetchType f246111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f246112e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f246108a == r101.f246108a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246109b, r101.f246109b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f246110c, r101.f246110c) == true) goto L18;
        return false;
    L18:
        if (this.f246111d == r101.f246111d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f246112e, r101.f246112e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f246108a.hashCode() * 31) + this.f246109b.hashCode()) * 31;
        Long r101 = this.f246110c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ArgusGeckoFetchType r105 = this.f246111d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f246112e;
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
        return "ConfigInfo(from=" + this.f246108a + ", version=" + this.f246109b + ", createTimeStamp=" + this.f246110c + ", fetchType=" + this.f246111d + ", geckoVersion=" + this.f246112e + ')';
    }

    public c(ConfigFrom r100, String r101, Long r102, ArgusGeckoFetchType r103, String r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = "-1";
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 16) == 0) goto L11;
        r104 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, "version");
        this.f246108a = r100;
        this.f246109b = r101;
        this.f246110c = r102;
        this.f246111d = r103;
        this.f246112e = r104;
    }
}
