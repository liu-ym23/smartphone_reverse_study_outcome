package com.ss.android.lark.conditional.access.nopermission.manager;

import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.manager.NoPermissionModuleManager$addSecurityActionInterceptor$1", f = "NoPermissionModuleManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NoPermissionModuleManager$addSecurityActionInterceptor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n4c.a $interceptor;
    int label;
    final /* synthetic */ NoPermissionModuleManager this$0;

    public NoPermissionModuleManager$addSecurityActionInterceptor$1(n4c.a r100, NoPermissionModuleManager r101, Continuation<? super NoPermissionModuleManager$addSecurityActionInterceptor$1> r102) {
        this.$interceptor = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new NoPermissionModuleManager$addSecurityActionInterceptor$1(this.$interceptor, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((NoPermissionModuleManager$addSecurityActionInterceptor$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        int r101 = ScsLogger.f440428a;
        StringBuilder r102 = new StringBuilder("addSecurityActionInterceptor, biz: ");
        n4c.a r103 = this.$interceptor;
        if (r103 == null) goto L7;
        String r104 = r103.getBizName();
    L8:
        r102.append(r104);
        ScsLogger.d("SecurityPolicy_NoPermissionModuleManager", r102.toString());
        n4c.a r105 = this.$interceptor;
        if (r105 == null) goto L12;
        this.this$0.f418113m.put(r105.getBizName(), r105);
    L12:
        return Unit.INSTANCE;
    L7:
        r104 = null;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
