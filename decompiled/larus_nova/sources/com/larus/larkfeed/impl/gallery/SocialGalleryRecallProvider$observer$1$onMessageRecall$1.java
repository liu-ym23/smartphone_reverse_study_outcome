package com.larus.larkfeed.impl.gallery;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.gallery.SocialGalleryRecallProvider$observer$1$onMessageRecall$1", f = "LarkOfficeMaterialGalleryHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SocialGalleryRecallProvider$observer$1$onMessageRecall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SocialGalleryRecallProvider this$0;

    public SocialGalleryRecallProvider$observer$1$onMessageRecall$1(SocialGalleryRecallProvider r100, Continuation<? super SocialGalleryRecallProvider$observer$1$onMessageRecall$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SocialGalleryRecallProvider$observer$1$onMessageRecall$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SocialGalleryRecallProvider$observer$1$onMessageRecall$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.larkfeed.impl.gallery.d0] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        final SocialGalleryRecallProvider r101 = this.this$0;
        com.larus.gallery.api.w r102 = r101.f343899e;
        if (r102 == null) goto L8;
        r102.Rf(new com.larus.gallery.api.p.i(new d0(r101)));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
