package com.larus.dispatcher.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.api.GetAllDevicesRepo", f = "GetAllDevicesRepo.kt", i = {0, 0}, l = {581}, m = "loadCurrentDevicesInfoFromDisk", n = {"$this$withLock_u24default$iv", "versionBeforeLoad"}, s = {"L$0", "J$0"})
final class GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetAllDevicesRepo this$0;

    public GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1(GetAllDevicesRepo r100, Continuation<? super GetAllDevicesRepo$loadCurrentDevicesInfoFromDisk$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return GetAllDevicesRepo.a(this.this$0, 0, this);
    }
}
