package com.larus.share.impl.sdk;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.share.impl.sdk.SharePanelService", f = "SharePanelService.kt", i = {0, 0, 0, 1, 1}, l = {320, 341}, m = "buildFinalImageShareContent", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "shareContent", "shouldWriteManualMetadata", "materializedShareContent", "finalImageUrl"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1"})
final class SharePanelService$buildFinalImageShareContent$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharePanelService this$0;

    public SharePanelService$buildFinalImageShareContent$1(SharePanelService r100, Continuation<? super SharePanelService$buildFinalImageShareContent$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return SharePanelService.f(this.this$0, null, null, null, this);
    }
}
