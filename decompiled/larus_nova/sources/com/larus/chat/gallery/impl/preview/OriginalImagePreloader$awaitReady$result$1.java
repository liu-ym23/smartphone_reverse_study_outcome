package com.larus.chat.gallery.impl.preview;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.OriginalImagePreloader$awaitReady$result$1", f = "OriginalImagePreloader.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class OriginalImagePreloader$awaitReady$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $bizTag;
    final /* synthetic */ String $rawImagePath;
    private /* synthetic */ Object L$0;
    int label;

    public OriginalImagePreloader$awaitReady$result$1(String r100, String r101, Continuation<? super OriginalImagePreloader$awaitReady$result$1> r102) {
        this.$rawImagePath = r100;
        this.$bizTag = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        OriginalImagePreloader$awaitReady$result$1 r102 = new OriginalImagePreloader$awaitReady$result$1(this.$rawImagePath, this.$bizTag, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((OriginalImagePreloader$awaitReady$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r100).booleanValue()));     // Catch: Throwable -> L15
    L17:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L20;
        FLogger.f375446a.e("OriginalImagePreloader", "awaitReady: prefetch raw image failed", r104);
    L20:
        Boolean r105 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r103) == true) goto L23;
        return r103;
    L23:
        return r105;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r106 = (CoroutineScope) this.L$0;
        String r107 = this.$rawImagePath;
        String r108 = this.$bizTag;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L15
        OriginalImagePreloader r110 = OriginalImagePreloader.f324211a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r100 = OriginalImagePreloader.a(r110, r107, r108, this);     // Catch: Throwable -> L15
        if (r100 != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
