package com.bytedance.ee.bear.more.protocol3.panel;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MoreGroup f234992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<o> f234993b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f234992a == r101.f234992a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f234993b, r101.f234993b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f234992a.hashCode() * 31) + this.f234993b.hashCode();
    }

    public final String toString() {
        return "MoreGroupConfig(group=" + this.f234992a + ", items=" + this.f234993b + ')';
    }

    public m(MoreGroup r100, List<o> r101) {
        Intrinsics.checkNotNullParameter(r100, "group");
        Intrinsics.checkNotNullParameter(r101, "items");
        this.f234992a = r100;
        this.f234993b = r101;
    }
}
