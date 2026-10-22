package com.bytedance.locallife.cube.impl;

import android.widget.Toast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.locallife.cube.impl.CubeDelegateManager$mobPreloadFail$1", f = "CubeDelegateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CubeDelegateManager$mobPreloadFail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bundle;
    final /* synthetic */ String $channel;
    final /* synthetic */ String $msg;
    int label;

    public CubeDelegateManager$mobPreloadFail$1(String r100, String r101, String r102, Continuation<? super CubeDelegateManager$mobPreloadFail$1> r103) {
        this.$channel = r100;
        this.$bundle = r101;
        this.$msg = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CubeDelegateManager$mobPreloadFail$1(this.$channel, this.$bundle, this.$msg, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CubeDelegateManager$mobPreloadFail$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        com.bytedance.locallife.cube.c.c();
        Toast.makeText(com.bytedance.locallife.biz.base.cube.d.f256534a.a(), "卡片[" + this.$channel + '/' + this.$bundle + "]预加载失效，原因是：" + this.$msg, 0).show();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
