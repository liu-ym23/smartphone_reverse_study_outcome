package com.obric.assistant.network.impl;

import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.api.bean.IntentShortLinkType;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/obric/assistant/network/impl/ObricProtocolApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$pendingRetry$1$response$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ROTATION, 558}, m = "invokeSuspend", n = {}, s = {})
public final class ObricNetworkServiceImpl$pendingRetry$1$response$1 extends SuspendLambda implements Function2<ObricProtocolApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ String $seqId;
    final /* synthetic */ IntentShortLinkType $type;
    final /* synthetic */ vea.i $uplinkIntentRequest;
    private /* synthetic */ Object L$0;
    int label;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f390331a = null;

        static {
            int[] r100 = new int[IntentShortLinkType.values().length];
            r100[IntentShortLinkType.COMPENSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[IntentShortLinkType.ASYNC_NOTIFY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[IntentShortLinkType.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f390331a = r100;
        }
    }

    public ObricNetworkServiceImpl$pendingRetry$1$response$1(IntentShortLinkType r100, String r101, vea.i r102, Continuation<? super ObricNetworkServiceImpl$pendingRetry$1$response$1> r103) {
        this.$type = r100;
        this.$seqId = r101;
        this.$uplinkIntentRequest = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricNetworkServiceImpl$pendingRetry$1$response$1 r102 = new ObricNetworkServiceImpl$pendingRetry$1$response$1(this.$type, this.$seqId, this.$uplinkIntentRequest, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ObricProtocolApi r100, Continuation<? super BizResponse<Object>> r101) {
        return ((ObricNetworkServiceImpl$pendingRetry$1$response$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ObricProtocolApi r100, Continuation<? super BizResponse<Object>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L28:
        return (BizResponse) r100;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L26:
        return (BizResponse) r100;
    L10:
        ResultKt.throwOnFailure(r100);
        ObricProtocolApi r103 = (ObricProtocolApi) this.L$0;
        FLogger.f375446a.i("[ObricNetworkServiceImpl]", "pendingRetry: type: " + this.$type + ", seqId: " + this.$seqId + ", request = " + this.$uplinkIntentRequest);
        int r104 = a.f390331a[this.$type.ordinal()];
        if (r104 == 1) goto L22;
        if (r104 != 2) goto L14;
        vea.i r105 = this.$uplinkIntentRequest;
        this.label = 2;
        r100 = r103.uploadIntentResultForAsyncNotify(r105, this);
        if (r100 != r101) goto L28;
        return r101;
    L14:
        if (r104 != 3) goto L17;
        return null;
    L17:
        throw new NoWhenBranchMatchedException();
    L22:
        vea.i r106 = this.$uplinkIntentRequest;
        this.label = 1;
        r100 = r103.uploadIntentResultForCompensation(r106, this);
        if (r100 != r101) goto L26;
        return r101;
    }
}
