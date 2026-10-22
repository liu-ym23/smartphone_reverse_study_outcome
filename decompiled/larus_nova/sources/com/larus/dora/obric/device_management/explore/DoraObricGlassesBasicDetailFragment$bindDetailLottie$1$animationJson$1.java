package com.larus.dora.obric.device_management.explore;

import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.explore.DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1", f = "DoraObricGlassesBasicDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ File $lottieFile;
    private /* synthetic */ Object L$0;
    int label;

    public DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1(File r100, Continuation<? super DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1> r101) {
        this.$lottieFile = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1 r102 = new DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1(this.$lottieFile, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((DoraObricGlassesBasicDetailFragment$bindDetailLottie$1$animationJson$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        File r102 = this.$lottieFile;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(FilesKt.readText$default(r102, null, 1, null));     // Catch: Throwable -> L7
    L9:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L13;
        g49.d.b("DoraObricGlassesBasicDetailFragment", "read media detail lottie failed: " + r105.getMessage());
    L13:
        if (Result.m9455isFailureimpl(r104) == false) goto L16;
        return null;
    L16:
        return r104;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
