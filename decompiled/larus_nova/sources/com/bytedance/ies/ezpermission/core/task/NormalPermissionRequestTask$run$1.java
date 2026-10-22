package com.bytedance.ies.ezpermission.core.task;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0096@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "run"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.bytedance.ies.ezpermission.core.task.NormalPermissionRequestTask", f = "NormalPermissionRequestTask.kt", i = {0, 0, 0, 0, 0, 0}, l = {28, 38}, m = "run", n = {"this", "resultWrapper", "onRequestListener", "grantedPermissions", "normalPermissions", "group"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class NormalPermissionRequestTask$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NormalPermissionRequestTask this$0;

    public NormalPermissionRequestTask$run$1(NormalPermissionRequestTask r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
