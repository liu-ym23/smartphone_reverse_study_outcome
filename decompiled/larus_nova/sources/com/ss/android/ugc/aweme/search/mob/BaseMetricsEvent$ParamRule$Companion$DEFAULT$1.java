package com.ss.android.ugc.aweme.search.mob;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ss/android/ugc/aweme/search/mob/BaseMetricsEvent$ParamRule$Companion$DEFAULT$1", "Lcom/ss/android/ugc/aweme/search/mob/BaseMetricsEvent$ParamRule;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BaseMetricsEvent$ParamRule$Companion$DEFAULT$1 implements BaseMetricsEvent.ParamRule {
    public BaseMetricsEvent$ParamRule$Companion$DEFAULT$1() {
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L6:
        return "";
    L5:
        if (Intrinsics.areEqual("null", r100) == true) goto L6;
        return r100;
    }
}
