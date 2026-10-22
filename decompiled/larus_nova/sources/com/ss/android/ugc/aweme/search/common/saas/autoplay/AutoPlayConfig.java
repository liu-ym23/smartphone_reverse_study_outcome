package com.ss.android.ugc.aweme.search.common.saas.autoplay;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/autoplay/AutoPlayConfig;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class AutoPlayConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerViewScrollStateManager f452008a;

    public AutoPlayConfig() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AutoPlayConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f452008a, ((AutoPlayConfig) r100).f452008a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        RecyclerViewScrollStateManager r100 = this.f452008a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "AutoPlayConfig(scrollStateManager=" + this.f452008a + ')';
    }

    public AutoPlayConfig(RecyclerViewScrollStateManager r100) {
        this.f452008a = r100;
    }
}
