package com.larus.chat.gallery.impl.providers;

import com.larus.chat.gallery.api.IFindSimilarAvailabilityChecker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/chat/gallery/api/FindSimilarAvailability;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.providers.FindSimilarProvider$applyVisibility$2$availability$1", f = "FindSimilarProvider.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
public final class FindSimilarProvider$applyVisibility$2$availability$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.chat.gallery.api.h>, Object> {
    final /* synthetic */ String $imageUri;
    int label;

    public FindSimilarProvider$applyVisibility$2$availability$1(String r100, Continuation<? super FindSimilarProvider$applyVisibility$2$availability$1> r101) {
        this.$imageUri = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FindSimilarProvider$applyVisibility$2$availability$1(this.$imageUri, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super com.larus.chat.gallery.api.h> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super com.larus.chat.gallery.api.h> r101) {
        return ((FindSimilarProvider$applyVisibility$2$availability$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IFindSimilarAvailabilityChecker.Delegate r103 = IFindSimilarAvailabilityChecker.f324102a;
        String r104 = this.$imageUri;
        this.label = 1;
        r100 = r103.a(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
