package com.larus.home.impl.reddot;

import com.larus.home.impl.reddot.api.UpdateRedDotApi;
import com.larus.network.http.f;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.reddot.UpdateRedDotManager$tryRequestUpdateRedDot$1", f = "UpdateRedDotManager.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
final class UpdateRedDotManager$tryRequestUpdateRedDot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ fc9.b $request;
    final /* synthetic */ String $source;
    int label;

    public UpdateRedDotManager$tryRequestUpdateRedDot$1(fc9.b r100, String r101, Continuation<? super UpdateRedDotManager$tryRequestUpdateRedDot$1> r102) {
        this.$request = r100;
        this.$source = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new UpdateRedDotManager$tryRequestUpdateRedDot$1(this.$request, this.$source, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((UpdateRedDotManager$tryRequestUpdateRedDot$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        com.larus.network.http.a r103 = (com.larus.network.http.a) r100;
        if ((r103 instanceof f) == false) goto L15;
        FLogger.f375446a.e("UpdateRedDotManager", "tryRequestUpdateRedDot: api error:", ((f) r103).f360157d);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FLogger.f375446a.d("UpdateRedDotManager", "tryRequestUpdateRedDot: request = " + this.$request + ", source = " + this.$source);
        UpdateRedDotApi.a r104 = UpdateRedDotApi.f346029a;
        fc9.b r105 = this.$request;
        String r106 = this.$source;
        this.label = 1;
        r100 = r104.call(r105, r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
