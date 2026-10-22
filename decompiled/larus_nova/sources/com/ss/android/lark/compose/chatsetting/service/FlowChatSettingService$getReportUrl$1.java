package com.ss.android.lark.compose.chatsetting.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.service.FlowChatSettingService", f = "FlowChatSettingService.kt", i = {}, l = {23}, m = "getReportUrl", n = {}, s = {})
public final class FlowChatSettingService$getReportUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowChatSettingService this$0;

    public FlowChatSettingService$getReportUrl$1(FlowChatSettingService r100, Continuation<? super FlowChatSettingService$getReportUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
