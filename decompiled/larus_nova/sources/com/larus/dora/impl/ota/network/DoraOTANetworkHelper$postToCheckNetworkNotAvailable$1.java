package com.larus.dora.impl.ota.network;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.common.apphost.AppHost;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import g49.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.network.DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1", f = "DoraOTANetworkHelper.kt", i = {0}, l = {127}, m = "invokeSuspend", n = {RXScreenCaptureService.KEY_INDEX}, s = {"I$0"})
final class DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    int I$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1(Function1<? super Boolean, Unit> r100, Continuation<? super DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1> r101) {
        this.$callback = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1(this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002f -> B:14:0x0032). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        int r103 = this.I$0;
        ResultKt.throwOnFailure(r100);
        DoraOTANetworkHelper$postToCheckNetworkNotAvailable$1 r104 = this;
    L14:
        AppHost.Companion r105 = AppHost.f326268a;
        if (NetworkUtils.isNetworkAvailable(r105.getApplication()) == true) goto L17;
        d.d("DoraOTANetworkHelper", "postToCheckNetworkNotAvailable: network not connected");
    L22:
        r103 = r103 + 1;
    L10:
        if (r103 >= 5) goto L23;
        r104.I$0 = r103;
        r104.label = 1;
        if (DelayKt.delay(200, r104) != r101) goto L14;
        return r101;
    L23:
        d.d("DoraOTANetworkHelper", "postToCheckNetworkNotAvailable: network not connected final");
        r104.$callback.invoke(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    L17:
        if (NetworkUtils.isWifi(r105.getApplication()) == false) goto L19;
        d.d("DoraOTANetworkHelper", "postToCheckNetworkNotAvailable: wifi connected");
        goto L22
    L19:
        d.d("DoraOTANetworkHelper", "postToCheckNetworkNotAvailable: wifi not connected, other network");
        r104.$callback.invoke(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r104 = this;
        r103 = 0;
        goto L10
    }
}
