package com.bytedance.lark.lark_biz_feed_android;

import kotlin.ULong;

/* JADX INFO: loaded from: classes8.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f253173a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L9;
        return false;
    L9:
        if (this.f253173a == ((l) r100).f253173a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return ULong.m9635hashCodeimpl(this.f253173a);
    }

    public final String toString() {
        return "ForegroundUserContainerScope(uid=" + ULong.m9669toStringimpl(this.f253173a) + ')';
    }

    public l(long r100) {
        this.f253173a = r100;
    }
}
