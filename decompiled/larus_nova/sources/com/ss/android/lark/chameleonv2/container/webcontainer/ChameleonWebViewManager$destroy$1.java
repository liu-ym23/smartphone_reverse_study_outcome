package com.ss.android.lark.chameleonv2.container.webcontainer;

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
@DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager$destroy$1", f = "ChameleonWebViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChameleonWebViewManager$destroy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bizName;
    final /* synthetic */ q0b.a $webviewPool;
    int label;
    final /* synthetic */ ChameleonWebViewManager this$0;

    public ChameleonWebViewManager$destroy$1(q0b.a r100, ChameleonWebViewManager r101, String r102, Continuation<? super ChameleonWebViewManager$destroy$1> r103) {
        this.$webviewPool = r100;
        this.this$0 = r101;
        this.$bizName = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChameleonWebViewManager$destroy$1(this.$webviewPool, this.this$0, this.$bizName, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChameleonWebViewManager$destroy$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        q0b.a r101 = this.$webviewPool;
        if (r101 == null) goto L7;
        r101.destroyAll();
    L7:
        this.this$0.f411138b.remove(this.$bizName);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
