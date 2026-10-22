package com.larus.asr.session;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.asr.session.SendMessageAsrSession$asrGlobalSuccess$1$2", f = "SendMessageAsrSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SendMessageAsrSession$asrGlobalSuccess$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $alterSnapshot;
    final /* synthetic */ boolean $resultIntercepted;
    final /* synthetic */ boolean $successIntercepted;
    int label;

    public SendMessageAsrSession$asrGlobalSuccess$1$2(boolean r100, boolean r101, boolean r102, Continuation<? super SendMessageAsrSession$asrGlobalSuccess$1$2> r103) {
        this.$alterSnapshot = r100;
        this.$resultIntercepted = r101;
        this.$successIntercepted = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SendMessageAsrSession$asrGlobalSuccess$1$2(this.$alterSnapshot, this.$resultIntercepted, this.$successIntercepted, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SendMessageAsrSession$asrGlobalSuccess$1$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        if (this.$alterSnapshot == true) goto L7;
        t19.s r101 = t19.s.f544207a;
        Application r102 = AppHost.f326268a.getApplication();
        r101.getClass();
        t19.s.s(r102, R.string.larus_asr_no_speech_detected);
    L13:
        return Unit.INSTANCE;
    L7:
        if (this.$resultIntercepted == true) goto L13;
        if (this.$successIntercepted == true) goto L13;
        t19.s r103 = t19.s.f544207a;
        Application r104 = AppHost.f326268a.getApplication();
        r103.getClass();
        t19.s.s(r104, R.string.larus_asr_no_speech_detected);
        goto L13
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
