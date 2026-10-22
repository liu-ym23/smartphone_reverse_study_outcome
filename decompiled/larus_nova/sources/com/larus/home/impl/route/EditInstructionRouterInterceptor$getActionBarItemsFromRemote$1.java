package com.larus.home.impl.route;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.route.EditInstructionRouterInterceptor", f = "EditInstructionRouterInterceptor.kt", i = {0, 0, 0}, l = {404}, m = "getActionBarItemsFromRemote", n = {"curActivity", "loadingDialog", "delayShowLoadingJob"}, s = {"L$0", "L$1", "L$2"})
public final class EditInstructionRouterInterceptor$getActionBarItemsFromRemote$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditInstructionRouterInterceptor this$0;

    public EditInstructionRouterInterceptor$getActionBarItemsFromRemote$1(EditInstructionRouterInterceptor r100, Continuation<? super EditInstructionRouterInterceptor$getActionBarItemsFromRemote$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        EditInstructionRouterInterceptor r101 = this.this$0;
        int r102 = EditInstructionRouterInterceptor.f346050a;
        return r101.e(null, this);
    }
}
