package com.obric.assistant.agent;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.agent.ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshotUri$1", f = "ObricAgentServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshotUri$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Function1<Uri, Unit>> $tmpUriCallback;
    final /* synthetic */ Uri $uri;
    int label;

    public ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshotUri$1(Ref.ObjectRef<Function1<Uri, Unit>> r100, Uri r101, Continuation<? super ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshotUri$1> r102) {
        this.$tmpUriCallback = r100;
        this.$uri = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshotUri$1(this.$tmpUriCallback, this.$uri, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricAgentServiceImpl$createScreenshotCallback$1$onReceivedScreenshotUri$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        Function1<Uri, Unit> r101 = this.$tmpUriCallback.element;
        if (r101 == null) goto L7;
        r101.invoke(this.$uri);
    L7:
        this.$tmpUriCallback.element = null;
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
