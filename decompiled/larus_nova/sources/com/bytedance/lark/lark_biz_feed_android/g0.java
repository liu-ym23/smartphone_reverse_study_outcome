package com.bytedance.lark.lark_biz_feed_android;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f253166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f253167b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g0) == true) goto L8;
        return false;
    L8:
        g0 r101 = (g0) r100;
        if (Intrinsics.areEqual(this.f253166a, r101.f253166a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253167b, r101.f253167b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f253166a.hashCode() * 31) + this.f253167b.hashCode();
    }

    public final String toString() {
        return "LarkFeedListContextWrapped(inner=" + this.f253166a + ", containerScope=" + this.f253167b + ')';
    }

    public g0(f0 r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, RNParamRegisterEventHandler.SRC_INNER);
        Intrinsics.checkNotNullParameter(r101, "containerScope");
        this.f253166a = r100;
        this.f253167b = r101;
    }
}
