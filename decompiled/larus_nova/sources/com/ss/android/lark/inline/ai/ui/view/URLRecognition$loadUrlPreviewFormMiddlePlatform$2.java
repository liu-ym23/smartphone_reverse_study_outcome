package com.ss.android.lark.inline.ai.ui.view;

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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.view.URLRecognition$loadUrlPreviewFormMiddlePlatform$2", f = "URLRecognition.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class URLRecognition$loadUrlPreviewFormMiddlePlatform$2 extends SuspendLambda implements Function2<UrlInlinePreviewEntity, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<UrlInlinePreviewEntity> $callback;
    /* synthetic */ Object L$0;
    int label;

    public URLRecognition$loadUrlPreviewFormMiddlePlatform$2(IGetDataCallback<UrlInlinePreviewEntity> r100, Continuation<? super URLRecognition$loadUrlPreviewFormMiddlePlatform$2> r101) {
        this.$callback = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        URLRecognition$loadUrlPreviewFormMiddlePlatform$2 r102 = new URLRecognition$loadUrlPreviewFormMiddlePlatform$2(this.$callback, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(UrlInlinePreviewEntity r100, Continuation<? super Unit> r101) {
        return ((URLRecognition$loadUrlPreviewFormMiddlePlatform$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(UrlInlinePreviewEntity r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        UrlInlinePreviewEntity r101 = (UrlInlinePreviewEntity) this.L$0;
        if (r101.f428709b.length() != 0) goto L7;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        Log.w("URLRecognition", "loadUrlPreviewFormMiddlePlatform: get empty title from preview entity, method return");
        return Unit.INSTANCE;
    L12:
        Log.i("URLRecognition", "loadUrlPreviewFormMiddlePlatform success: " + r101.f428709b);
        this.$callback.onSuccess(r101);
        return Unit.INSTANCE;
    L7:
        r102 = false;
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
