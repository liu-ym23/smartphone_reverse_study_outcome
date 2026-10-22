package com.ss.android.ugc.aweme.poi.event;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/event/PoiDetailPageDismissEvent;", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDetailPageDismissEvent {
    public PoiDetailPageDismissEvent(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "groupId");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
    }
}
