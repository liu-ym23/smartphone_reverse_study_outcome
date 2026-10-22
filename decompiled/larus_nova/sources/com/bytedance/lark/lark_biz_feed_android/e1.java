package com.bytedance.lark.lark_biz_feed_android;

import kotlin.ULong;

/* JADX INFO: loaded from: classes8.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f253159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f253160b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e1) == true) goto L8;
        return false;
    L8:
        e1 r101 = (e1) r100;
        if (this.f253159a == r101.f253159a) goto L12;
        return false;
    L12:
        if (this.f253160b == r101.f253160b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = ULong.m9635hashCodeimpl(this.f253159a) * 31;
        if (this.f253160b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ToastStatusSuccess(version=" + ULong.m9669toStringimpl(this.f253159a) + ", isRemind=" + this.f253160b + ')';
    }

    public e1(long r100, boolean r101) {
        this.f253159a = r100;
        this.f253160b = r101;
    }
}
