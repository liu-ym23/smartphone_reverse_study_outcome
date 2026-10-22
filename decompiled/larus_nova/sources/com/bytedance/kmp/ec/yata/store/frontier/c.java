package com.bytedance.kmp.ec.yata.store.frontier;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.protocol.data.c f251771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f251772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FrontierMessageHandleType f251773c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f251771a, r101.f251771a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f251772b, r101.f251772b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f251771a.hashCode() * 31) + this.f251772b.hashCode();
    }

    public final String toString() {
        return "YataFrontierMessageData(downLinkData=" + this.f251771a + ", logId=" + this.f251772b + ')';
    }

    public c(com.bytedance.kmp.ec.yata.common.protocol.data.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "downLinkData");
        Intrinsics.checkNotNullParameter(r101, "logId");
        this.f251771a = r100;
        this.f251772b = r101;
    }
}
