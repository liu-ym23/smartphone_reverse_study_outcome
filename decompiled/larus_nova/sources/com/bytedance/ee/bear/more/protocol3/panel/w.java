package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemUIStyle f235004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<m> f235005b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (this.f235004a == r101.f235004a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f235005b, r101.f235005b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f235004a.hashCode() * 31) + this.f235005b.hashCode();
    }

    public final String toString() {
        return "MorePanelConfig(hostStyle=" + this.f235004a + ", groups=" + this.f235005b + ')';
    }

    public w(ItemUIStyle r100, List<m> r101) {
        Intrinsics.checkNotNullParameter(r100, "hostStyle");
        Intrinsics.checkNotNullParameter(r101, "groups");
        this.f235004a = r100;
        this.f235005b = r101;
    }
}
