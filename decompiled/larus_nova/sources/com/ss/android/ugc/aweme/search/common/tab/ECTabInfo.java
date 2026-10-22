package com.ss.android.ugc.aweme.search.common.tab;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/tab/ECTabInfo;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabInfo {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECTabInfo) == false) goto L8;
        ((ECTabInfo) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "ECTabInfo(position=0, tabType=null)";
    }
}
