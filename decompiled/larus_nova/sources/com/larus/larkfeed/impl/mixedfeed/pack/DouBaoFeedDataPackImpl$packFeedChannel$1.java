package com.larus.larkfeed.impl.mixedfeed.pack;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.mixedfeed.pack.DouBaoFeedDataPackImpl", f = "DouBaoFeedDataPackImpl.kt", i = {0, 0, 0}, l = {117}, m = "packFeedChannel", n = {HiAnalyticsConstant.Direction.REQUEST, "destination$iv$iv", "metaFeed"}, s = {"L$0", "L$1", "L$3"})
public final class DouBaoFeedDataPackImpl$packFeedChannel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouBaoFeedDataPackImpl this$0;

    public DouBaoFeedDataPackImpl$packFeedChannel$1(DouBaoFeedDataPackImpl r100, Continuation<? super DouBaoFeedDataPackImpl$packFeedChannel$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.N1(null, this);
    }
}
