package com.larus.common.account.douyin;

import com.larus.network.http.y;
import com.ss.ttm.player.MediaPlayer;
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
@DebugMetadata(c = "com.larus.common.account.douyin.DouyinHeartBeatServiceImpl$actUpdate$1", f = "DouyinHeartBeatServiceImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE}, m = "invokeSuspend", n = {}, s = {})
final class DouyinHeartBeatServiceImpl$actUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n38.f $callback;
    final /* synthetic */ n38.e $douYinTokenResult;
    final /* synthetic */ boolean $isAuto;
    int label;
    final /* synthetic */ DouyinHeartBeatServiceImpl this$0;

    public DouyinHeartBeatServiceImpl$actUpdate$1(DouyinHeartBeatServiceImpl r100, n38.e r101, boolean r102, n38.f r103, Continuation<? super DouyinHeartBeatServiceImpl$actUpdate$1> r104) {
        this.this$0 = r100;
        this.$douYinTokenResult = r101;
        this.$isAuto = r102;
        this.$callback = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DouyinHeartBeatServiceImpl$actUpdate$1(this.this$0, this.$douYinTokenResult, this.$isAuto, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DouyinHeartBeatServiceImpl$actUpdate$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        if ((((com.larus.network.http.a) r100) instanceof y) == false) goto L16;
        n38.f r103 = this.$callback;
        if (r103 == null) goto L20;
        n38.e r104 = this.$douYinTokenResult;
        r103.onResult(r104.f516997a, r104.f516998b, r104.f516999c);
    L20:
        return Unit.INSTANCE;
    L16:
        n38.f r105 = this.$callback;
        if (r105 == null) goto L20;
        r105.onResult(null, null, null);
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        DouyinHeartBeatServiceImpl r106 = this.this$0;
        n38.e r107 = this.$douYinTokenResult;
        boolean r108 = this.$isAuto;
        this.label = 1;
        int r109 = DouyinHeartBeatServiceImpl.f326010d;
        r100 = r106.h(r107, r108, null, this);
        if (r100 != r101) goto L12;
        return r101;
    }
}
