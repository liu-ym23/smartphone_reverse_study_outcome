package com.larus.platform.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.platform.service.FlowDriveSdkService", f = "FlowDriveSdkService.kt", i = {}, l = {41}, m = "prepareLocalFilePreview", n = {}, s = {})
public final class FlowDriveSdkService$prepareLocalFilePreview$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowDriveSdkService this$0;

    public FlowDriveSdkService$prepareLocalFilePreview$1(FlowDriveSdkService r100, Continuation<? super FlowDriveSdkService$prepareLocalFilePreview$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.v(this);
    }
}
