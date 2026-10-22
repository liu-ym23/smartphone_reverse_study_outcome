package com.bytedance.lark.lark_biz_feed_android;

import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f253209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f253210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f253211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f253212d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x0) == true) goto L8;
        return false;
    L8:
        x0 r101 = (x0) r100;
        if (this.f253209a == r101.f253209a) goto L12;
        return false;
    L12:
        if (this.f253210b == r101.f253210b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f253211c, r101.f253211c) == true) goto L18;
        return false;
    L18:
        if (this.f253212d == r101.f253212d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ULong.m9635hashCodeimpl(this.f253209a) * 31;
        if (this.f253210b == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.f253211c.hashCode()) * 31) + this.f253212d;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ToastStatusFailure(version=" + ULong.m9669toStringimpl(this.f253209a) + ", isRemind=" + this.f253210b + ", errorMessage=" + this.f253211c + ", errorCode=" + this.f253212d + ')';
    }

    public x0(long r100, boolean r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        this.f253209a = r100;
        this.f253210b = r101;
        this.f253211c = r102;
        this.f253212d = r103;
    }
}
