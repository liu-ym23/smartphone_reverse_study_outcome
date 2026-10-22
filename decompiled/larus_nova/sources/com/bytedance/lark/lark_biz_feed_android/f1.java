package com.bytedance.lark.lark_biz_feed_android;

import kotlin.ULong;

/* JADX INFO: loaded from: classes8.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f253165a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f1) == true) goto L9;
        return false;
    L9:
        if (this.f253165a == ((f1) r100).f253165a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return ULong.m9635hashCodeimpl(this.f253165a);
    }

    public final String toString() {
        return "UserForegroundScope(uid=" + ULong.m9669toStringimpl(this.f253165a) + ')';
    }

    public f1(long r100) {
        this.f253165a = r100;
    }
}
