package com.larus.im.internal.network.link.impl.rtc.strategy;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.link.impl.rtc.strategy.RoomInfoGetter", f = "RoomConnectionGenerator.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {333, 335}, m = "requestWithRetry", n = {DBDefinition.TASK_ID, "start", "isAutoReq", DBDefinition.RETRY_COUNT, "retryCountLimit", DBDefinition.TASK_ID, "start", "isAutoReq", DBDefinition.RETRY_COUNT, "retryCountLimit"}, s = {"L$0", "J$0", "Z$0", "I$0", "I$1", "L$0", "J$0", "Z$0", "I$0", "I$1"})
public final class RoomInfoGetter$requestWithRetry$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomInfoGetter this$0;

    public RoomInfoGetter$requestWithRetry$1(RoomInfoGetter r100, Continuation<? super RoomInfoGetter$requestWithRetry$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        RoomInfoGetter r101 = this.this$0;
        RoomInfoGetter r102 = RoomInfoGetter.f349411a;
        return r101.d(null, 0, false, this);
    }
}
