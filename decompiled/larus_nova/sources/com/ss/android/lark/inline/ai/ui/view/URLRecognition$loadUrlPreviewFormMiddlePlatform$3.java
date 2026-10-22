package com.ss.android.lark.inline.ai.ui.view;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.view.URLRecognition$loadUrlPreviewFormMiddlePlatform$3", f = "URLRecognition.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class URLRecognition$loadUrlPreviewFormMiddlePlatform$3 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<UrlInlinePreviewEntity> $callback;
    /* synthetic */ Object L$0;
    int label;

    public URLRecognition$loadUrlPreviewFormMiddlePlatform$3(IGetDataCallback<UrlInlinePreviewEntity> r100, Continuation<? super URLRecognition$loadUrlPreviewFormMiddlePlatform$3> r101) {
        this.$callback = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        URLRecognition$loadUrlPreviewFormMiddlePlatform$3 r102 = new URLRecognition$loadUrlPreviewFormMiddlePlatform$3(this.$callback, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ErrorResult r100, Continuation<? super Unit> r101) {
        return ((URLRecognition$loadUrlPreviewFormMiddlePlatform$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ErrorResult r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        ErrorResult r101 = (ErrorResult) this.L$0;
        this.$callback.onError(r101);
        Log.e("URLRecognition", "loadUrlPreviewFormMiddlePlatform: fetch failed , " + r101.getMessage());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
