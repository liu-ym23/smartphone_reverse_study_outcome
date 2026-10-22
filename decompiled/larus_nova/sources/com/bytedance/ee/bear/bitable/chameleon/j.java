package com.bytedance.ee.bear.bitable.chameleon;

import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableSubType f209653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WikiInfo f209654b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f209653a == r101.f209653a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f209654b, r101.f209654b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f209653a.hashCode() * 31;
        WikiInfo r101 = this.f209654b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BitableWikiCheckResult(subType=" + this.f209653a + ", wikiInfo=" + this.f209654b + ')';
    }

    public j(BitableSubType r100, WikiInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "subType");
        this.f209653a = r100;
        this.f209654b = r101;
    }
}
