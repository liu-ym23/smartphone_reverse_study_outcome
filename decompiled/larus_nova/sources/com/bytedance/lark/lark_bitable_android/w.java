package com.bytedance.lark.lark_bitable_android;

import kotlin.ULong;

/* JADX INFO: loaded from: classes43.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f253122a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L9;
        return false;
    L9:
        if (this.f253122a == ((w) r100).f253122a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return ULong.m9635hashCodeimpl(this.f253122a);
    }

    public final String toString() {
        return "ForegroundUserContainerScope(uid=" + ULong.m9669toStringimpl(this.f253122a) + ')';
    }

    public w(long r100) {
        this.f253122a = r100;
    }
}
