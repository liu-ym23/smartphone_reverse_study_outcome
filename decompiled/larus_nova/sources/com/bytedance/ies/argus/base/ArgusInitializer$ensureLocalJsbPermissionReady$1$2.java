package com.bytedance.ies.argus.base;

import com.bytedance.sdk.xbridge.cn.auth.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.ies.argus.base.ArgusInitializer$ensureLocalJsbPermissionReady$1$2", f = "ArgusInitializer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ArgusInitializer$ensureLocalJsbPermissionReady$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $permissionConfigProvider;
    int label;

    public ArgusInitializer$ensureLocalJsbPermissionReady$1$2(g r100, Continuation<? super ArgusInitializer$ensureLocalJsbPermissionReady$1$2> r101) {
        this.$permissionConfigProvider = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ArgusInitializer$ensureLocalJsbPermissionReady$1$2(this.$permissionConfigProvider, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ArgusInitializer$ensureLocalJsbPermissionReady$1$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        boolean r101 = com.bytedance.sdk.xbridge.cn.auth.c.f269833a;
        com.bytedance.sdk.xbridge.cn.auth.c.a(this.$permissionConfigProvider, true);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
