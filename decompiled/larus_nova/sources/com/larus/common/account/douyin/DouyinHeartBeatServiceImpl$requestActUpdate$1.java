package com.larus.common.account.douyin;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.douyin.DouyinHeartBeatServiceImpl", f = "DouyinHeartBeatServiceImpl.kt", i = {}, l = {234}, m = "requestActUpdate", n = {}, s = {})
public final class DouyinHeartBeatServiceImpl$requestActUpdate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouyinHeartBeatServiceImpl this$0;

    public DouyinHeartBeatServiceImpl$requestActUpdate$1(DouyinHeartBeatServiceImpl r100, Continuation<? super DouyinHeartBeatServiceImpl$requestActUpdate$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DouyinHeartBeatServiceImpl r101 = this.this$0;
        int r102 = DouyinHeartBeatServiceImpl.f326010d;
        return r101.h(null, false, null, this);
    }
}
