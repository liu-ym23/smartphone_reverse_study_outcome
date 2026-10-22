package com.bytedance.creativex.mediaimport.view.internal.validator;

import com.bytedance.services.apm.api.EnsureManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import ki4.r;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.creativex.mediaimport.view.internal.validator.MediaDimensionUpdatePreSelectValidator$preCheck$2", f = "BuiltinValidators.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaDimensionUpdatePreSelectValidator$preCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ r $incoming;
    int label;

    public MediaDimensionUpdatePreSelectValidator$preCheck$2(r r100, Continuation<? super MediaDimensionUpdatePreSelectValidator$preCheck$2> r101) {
        this.$incoming = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MediaDimensionUpdatePreSelectValidator$preCheck$2(this.$incoming, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((MediaDimensionUpdatePreSelectValidator$preCheck$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r100);
        b.a(this.$incoming);     // Catch: Throwable -> L7
    L11:
        return Boxing.boxBoolean(true);
    L7:
        th = move-exception;
        FLogger.f375446a.e("BuiltinValidators", "MediaDimensionUpdatePreSelectValidator tryUpdateWidthHeight error", th);
        EnsureManager.ensureNotReachHere(th, "BuiltinValidators");
        if (AppHost.f326268a.isDebug() == false) goto L11;
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
