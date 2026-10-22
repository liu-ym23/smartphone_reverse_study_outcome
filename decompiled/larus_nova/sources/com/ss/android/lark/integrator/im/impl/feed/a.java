package com.ss.android.lark.integrator.im.impl.feed;

import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.utils.ApiUtils;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@OfficeSDKUserScope
public final class a implements fza.a {
    @Inject
    public a() {
    }

    @Override // fza.a
    public final void peakFeedCard(String r100, FeedCard.Type r101) {
        Intrinsics.checkNotNullParameter(r100, "entityId");
        Intrinsics.checkNotNullParameter(r101, "entityType");
        IIMApi r102 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r102 == null) goto L6;
        r102.peakFeedCard(r100, r101);
        return;
    }
}
