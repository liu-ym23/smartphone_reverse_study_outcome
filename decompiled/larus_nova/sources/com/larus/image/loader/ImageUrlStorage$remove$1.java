package com.larus.image.loader;

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

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.image.loader.ImageUrlStorage$remove$1", f = "ImageUrlStorage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ImageUrlStorage$remove$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $originUrl;
    private /* synthetic */ Object L$0;
    int label;

    public ImageUrlStorage$remove$1(String r100, Continuation<? super ImageUrlStorage$remove$1> r101) {
        this.$originUrl = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ImageUrlStorage$remove$1 r102 = new ImageUrlStorage$remove$1(this.$originUrl, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ImageUrlStorage$remove$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$originUrl;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        String r104 = ImageUrlStorage.a(ImageUrlStorage.f350955a, r102);     // Catch: Throwable -> L7
        Object r105 = Result.m9449constructorimpl(Boxing.boxBoolean(ImageUrlStorage.d().m(r104)));     // Catch: Throwable -> L7
    L9:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L14;
        ImageUrlStorage.f350955a.getClass();
        ImageUrlStorage.f("remove", r106);
    L14:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
