package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import v7b.n;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext2.mdeditor.link.TemporaryPreviewLoader$loadLinkPreview$2", f = "TemporaryPreviewLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TemporaryPreviewLoader$loadLinkPreview$2 extends SuspendLambda implements Function2<UrlInlinePreviewEntity, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<n> $callback;
    final /* synthetic */ Context $context;
    /* synthetic */ Object L$0;
    int label;

    public TemporaryPreviewLoader$loadLinkPreview$2(IGetDataCallback<n> r100, Context r101, Continuation<? super TemporaryPreviewLoader$loadLinkPreview$2> r102) {
        this.$callback = r100;
        this.$context = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        TemporaryPreviewLoader$loadLinkPreview$2 r102 = new TemporaryPreviewLoader$loadLinkPreview$2(this.$callback, this.$context, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(UrlInlinePreviewEntity r100, Continuation<? super Unit> r101) {
        return ((TemporaryPreviewLoader$loadLinkPreview$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(UrlInlinePreviewEntity r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        UrlInlinePreviewEntity r101 = (UrlInlinePreviewEntity) this.L$0;
        IGetDataCallback<n> r102 = this.$callback;
        int r103 = PreviewEntityLinkParser.f429190a;
        r102.onSuccess(PreviewEntityLinkParser.a(this.$context, r101));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
