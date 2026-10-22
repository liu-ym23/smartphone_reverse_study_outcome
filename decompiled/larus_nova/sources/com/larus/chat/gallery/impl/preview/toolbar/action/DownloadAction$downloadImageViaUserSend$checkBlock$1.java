package com.larus.chat.gallery.impl.preview.toolbar.action;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.DownloadAction$downloadImageViaUserSend$checkBlock$1", f = "DownloadAction.kt", i = {}, l = {315}, m = "invokeSuspend", n = {}, s = {})
final class DownloadAction$downloadImageViaUserSend$checkBlock$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $taskId;
    int label;

    public DownloadAction$downloadImageViaUserSend$checkBlock$1(String r100, String r101, String r102, Continuation<? super DownloadAction$downloadImageViaUserSend$checkBlock$1> r103) {
        this.$creationId = r100;
        this.$taskId = r101;
        this.$messageId = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new DownloadAction$downloadImageViaUserSend$checkBlock$1(this.$creationId, this.$taskId, this.$messageId, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((DownloadAction$downloadImageViaUserSend$checkBlock$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        com.larus.platform.service.e0 r103 = com.larus.platform.service.e0.f365731a;
        String r104 = this.$creationId;
        String r105 = this.$taskId;
        String r106 = this.$messageId;
        this.label = 1;
        if (r103.h1(r104, r105, r106, this) != r101) goto L12;
        return r101;
    }
}
