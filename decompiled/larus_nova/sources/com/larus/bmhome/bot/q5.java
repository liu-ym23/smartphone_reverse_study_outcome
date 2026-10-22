package com.larus.bmhome.bot;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f296688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d6> f296689b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q5) == true) goto L8;
        return false;
    L8:
        q5 r101 = (q5) r100;
        if (Intrinsics.areEqual(this.f296688a, r101.f296688a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f296689b, r101.f296689b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f296688a.hashCode() * 31) + this.f296689b.hashCode();
    }

    public final String toString() {
        return "ServiceBotSettingBlock(categoryName=" + this.f296688a + ", items=" + this.f296689b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q5(String r100, List<? extends d6> r101) {
        Intrinsics.checkNotNullParameter(r100, "categoryName");
        Intrinsics.checkNotNullParameter(r101, "items");
        this.f296688a = r100;
        this.f296689b = r101;
    }
}
