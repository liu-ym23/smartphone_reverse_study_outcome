package com.bytedance.lark.lark_rust_sdk_integrator_android;

import kotlin.ULong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l {
    public final boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof l) == true) goto L9;
        return false;
    L9:
        ((l) r3).getClass();
        return true;
    }

    public final int hashCode() {
        return ULong.hashCode-impl(0);
    }

    public final String toString() {
        return "UserForegroundScope(containerId=" + ULong.toString-impl(0) + ')';
    }
}
