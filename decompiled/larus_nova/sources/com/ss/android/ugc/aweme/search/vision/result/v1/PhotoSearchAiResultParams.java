package com.ss.android.ugc.aweme.search.vision.result.v1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/v1/PhotoSearchAiResultParams;", "", "Lcom/ss/android/ugc/aweme/search/vision/result/v1/PhotoSearchAiContainerStatusType;", "type", "Lcom/ss/android/ugc/aweme/search/vision/result/v1/PhotoSearchAiContainerStatusType;", "getType", "()Lcom/ss/android/ugc/aweme/search/vision/result/v1/PhotoSearchAiContainerStatusType;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchAiResultParams {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PhotoSearchAiResultParams) == false) goto L12;
        ((PhotoSearchAiResultParams) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(null, null) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final PhotoSearchAiContainerStatusType getType() {
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "PhotoSearchAiResultParams(type=null, sourceBtmToken=null, aiPageParams=null)";
    }
}
