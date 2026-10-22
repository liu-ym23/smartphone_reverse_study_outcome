package com.larus.dispatcher.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.api.GetAllDevicesRepo", f = "GetAllDevicesRepo.kt", i = {0, 0, 0, 1, 2, 2}, l = {581, 352, 591}, m = "requestAllDevicesWithTimeControl", n = {"caller", "$this$withLock_u24default$iv", "requestIntervalInSecond", "deferred", "deferred", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "I$0", "L$0", "L$0", "L$2"})
public final class GetAllDevicesRepo$requestAllDevicesWithTimeControl$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetAllDevicesRepo this$0;

    public GetAllDevicesRepo$requestAllDevicesWithTimeControl$1(GetAllDevicesRepo r100, Continuation<? super GetAllDevicesRepo$requestAllDevicesWithTimeControl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        GetAllDevicesRepo r101 = this.this$0;
        GetAllDevicesRepo r102 = GetAllDevicesRepo.f330842a;
        return r101.i(0, null, this);
    }
}
