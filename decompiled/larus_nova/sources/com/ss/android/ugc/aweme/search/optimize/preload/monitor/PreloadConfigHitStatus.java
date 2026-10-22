package com.ss.android.ugc.aweme.search.optimize.preload.monitor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/preload/monitor/PreloadConfigHitStatus;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PreloadConfigHitStatus {
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreloadConfigHitStatus) == true) goto L8;
        return false;
    L8:
        ((PreloadConfigHitStatus) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "PreloadConfigHitStatus(cardTypeName=null, preloadCount=0, realCount=0)";
    }
}
