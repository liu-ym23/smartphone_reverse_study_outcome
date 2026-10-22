package com.larus.dora.impl.device_v2;

import android.view.View;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device_v2.DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1", f = "DoraDeviceBindFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c59.c0 $pageInfo;
    int label;
    final /* synthetic */ DoraDeviceBindFragment this$0;

    public DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1(DoraDeviceBindFragment r100, c59.c0 r101, Continuation<? super DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1> r102) {
        this.this$0 = r100;
        this.$pageInfo = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1(this.this$0, this.$pageInfo, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraDeviceBindFragment$onViewCreated$3$onSuccess$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        final DoraDeviceBindFragment r101 = this.this$0;
        final c59.c0 r102 = this.$pageInfo;
        DoraDeviceBindFragment.c r103 = r101.f334952g;
        if (r103 == null) goto L10;
        View r104 = r103.getRoot();
        if (r104 == null) goto L10;
        r104.post(new i(r101, r102));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
