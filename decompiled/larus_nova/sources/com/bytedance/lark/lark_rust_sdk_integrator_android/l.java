package com.bytedance.lark.lark_rust_sdk_integrator_android;

import kotlin.ULong;

/* JADX INFO: loaded from: classes16.dex */
public final class l {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L9;
        return false;
    L9:
        ((l) r100).getClass();
        return true;
    }

    public final int hashCode() {
        return ULong.m9635hashCodeimpl(0);
    }

    public final String toString() {
        return "UserForegroundScope(containerId=" + ULong.m9669toStringimpl(0) + ')';
    }
}
