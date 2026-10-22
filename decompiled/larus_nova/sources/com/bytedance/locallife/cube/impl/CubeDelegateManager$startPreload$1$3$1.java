package com.bytedance.locallife.cube.impl;

import com.bytedance.locallife.cube.api.config.CubeConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.locallife.cube.impl.CubeDelegateManager$startPreload$1$3$1", f = "CubeDelegateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CubeDelegateManager$startPreload$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CubeConfig $config;
    final /* synthetic */ Ref.ObjectRef<Throwable> $error;
    final /* synthetic */ Function2<CubeConfig, Throwable, Unit> $it;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CubeDelegateManager$startPreload$1$3$1(Function2<? super CubeConfig, ? super Throwable, Unit> r100, CubeConfig r101, Ref.ObjectRef<Throwable> r102, Continuation<? super CubeDelegateManager$startPreload$1$3$1> r103) {
        this.$it = r100;
        this.$config = r101;
        this.$error = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CubeDelegateManager$startPreload$1$3$1(this.$it, this.$config, this.$error, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CubeDelegateManager$startPreload$1$3$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.$it.invoke(this.$config, this.$error.element);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
