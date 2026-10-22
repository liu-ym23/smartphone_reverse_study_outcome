package com.bytedance.kmp.ec.yata.common.biz.callback;

import kotlin.jvm.internal.Intrinsics;
import v96.l;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f251375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.protocol.data.e f251376b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f251375a, r101.f251375a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251376b, r101.f251376b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        l r100 = this.f251375a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        com.bytedance.kmp.ec.yata.common.protocol.data.e r104 = this.f251376b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UplinkResponseInfo(rawNetResponse=" + this.f251375a + ", downLinkDataResponse=" + this.f251376b + ')';
    }

    public h(l r100, com.bytedance.kmp.ec.yata.common.protocol.data.e r101) {
        this.f251375a = r100;
        this.f251376b = r101;
    }
}
