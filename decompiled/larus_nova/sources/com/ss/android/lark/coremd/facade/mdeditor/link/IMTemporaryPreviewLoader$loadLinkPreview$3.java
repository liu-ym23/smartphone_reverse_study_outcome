package com.ss.android.lark.coremd.facade.mdeditor.link;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremd.facade.mdeditor.link.IMTemporaryPreviewLoader$loadLinkPreview$3", f = "IMTemporaryPreviewLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IMTemporaryPreviewLoader$loadLinkPreview$3 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<n> $callback;
    final /* synthetic */ n $link;
    final /* synthetic */ LinkType $linkType;
    /* synthetic */ Object L$0;
    int label;

    public IMTemporaryPreviewLoader$loadLinkPreview$3(LinkType r100, IGetDataCallback<n> r101, n r102, Continuation<? super IMTemporaryPreviewLoader$loadLinkPreview$3> r103) {
        this.$linkType = r100;
        this.$callback = r101;
        this.$link = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        IMTemporaryPreviewLoader$loadLinkPreview$3 r102 = new IMTemporaryPreviewLoader$loadLinkPreview$3(this.$linkType, this.$callback, this.$link, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ErrorResult r100, Continuation<? super Unit> r101) {
        return ((IMTemporaryPreviewLoader$loadLinkPreview$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ErrorResult r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        ErrorResult r101 = (ErrorResult) this.L$0;
        if (this.$linkType != LinkType.PossibleLink) goto L7;
        this.$callback.onSuccess(this.$link);
    L9:
        return Unit.INSTANCE;
    L7:
        this.$callback.onError(r101);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
