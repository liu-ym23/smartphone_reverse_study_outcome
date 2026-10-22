package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import android.content.Context;
import com.ss.android.lark.chameleon.ChameleonConfig;
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
@DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.ChameleonDefaultResFetcher$asyncGetResource$1", f = "ChameleonDefaultResFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChameleonDefaultResFetcher$asyncGetResource$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChameleonConfig $chameleonConfig;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $session;
    int label;
    final /* synthetic */ ChameleonDefaultResFetcher this$0;

    public ChameleonDefaultResFetcher$asyncGetResource$1(ChameleonDefaultResFetcher r100, ChameleonConfig r101, Context r102, String r103, Continuation<? super ChameleonDefaultResFetcher$asyncGetResource$1> r104) {
        this.this$0 = r100;
        this.$chameleonConfig = r101;
        this.$context = r102;
        this.$session = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChameleonDefaultResFetcher$asyncGetResource$1(this.this$0, this.$chameleonConfig, this.$context, this.$session, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChameleonDefaultResFetcher$asyncGetResource$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        ChameleonDefaultResFetcher r101 = this.this$0;
        ChameleonConfig r102 = this.$chameleonConfig;
        Context r103 = this.$context;
        String r104 = this.$session;
        int r105 = ChameleonDefaultResFetcher.f411272b;
        r101.b(r102, r103, r104);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
