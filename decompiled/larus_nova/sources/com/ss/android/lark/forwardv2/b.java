package com.ss.android.lark.forwardv2;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.forwardv2.dto.template.BusinessRecentVisitIncludeConfig;
import com.ss.android.lark.forwardv2.dto.template.ForwardTargetFilter;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements hib.e {
    public b() {
    }

    @Override // hib.e
    public final void a(BusinessRecentVisitIncludeConfig r100, IGetDataCallback r101, ForwardTargetFilter r102) {
        Intrinsics.checkNotNullParameter(r100, "includeConfigs");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "filter");
        r101.onSuccess(CollectionsKt.emptyList());
    }
}
