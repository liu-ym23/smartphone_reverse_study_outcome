package com.larus.business.floatchat.impl;

import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import va8.t0;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.floatchat.impl.AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1", f = "AIFloatChatViewControlBizCmdProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ t0 $bizPayload;
    final /* synthetic */ String $queryMsgId;
    int label;

    public AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1(String r100, t0 r101, Continuation<? super AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1> r102) {
        this.$queryMsgId = r100;
        this.$bizPayload = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1(this.$queryMsgId, this.$bizPayload, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AIFloatChatViewControlBizCmdProcessor$receiveDownLinkBody$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        CopyOnWriteArrayList<WeakReference<ew8.b>> r101 = y.f320458a;
        String r102 = this.$queryMsgId;
        t0 r103 = this.$bizPayload;
        Iterator<WeakReference<ew8.b>> r104 = y.f320458a.iterator();
        boolean r105 = false;
    L6:
        if (r104.hasNext() == false) goto L11;
        WeakReference<ew8.b> r106 = r104.next();
        ew8.b r107 = r106.get();
        if (r107 == null) goto L9;
        r107.ba(r102, r103);
        r105 = true;
        goto L6
    L9:
        y.f320458a.remove(r106);
        goto L6
    L11:
        FLogger.f375446a.i("AIFloatChatWindowEventDispatcher", "onReceiveRefreshCmd queryMsgId=" + r102 + ", viewBusinessPayload=" + r103 + ", dispatched=" + r105);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
