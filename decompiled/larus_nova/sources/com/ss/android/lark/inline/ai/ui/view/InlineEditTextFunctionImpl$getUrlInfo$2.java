package com.ss.android.lark.inline.ai.ui.view;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.view.InlineEditTextFunctionImpl$getUrlInfo$2", f = "InlineEditTextFunctionImpl.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
final class InlineEditTextFunctionImpl$getUrlInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Triple<? extends String, ? extends String, ? extends String>>, Object> {
    final /* synthetic */ String $defaultTitle;
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    int label;

    public InlineEditTextFunctionImpl$getUrlInfo$2(String r100, String r101, Continuation<? super InlineEditTextFunctionImpl$getUrlInfo$2> r102) {
        this.$url = r100;
        this.$defaultTitle = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new InlineEditTextFunctionImpl$getUrlInfo$2(this.$url, this.$defaultTitle, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Triple<? extends String, ? extends String, ? extends String>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Triple<String, String, String>> r101) {
        return ((InlineEditTextFunctionImpl$getUrlInfo$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        String r103 = (String) this.L$1;
        String r104 = (String) this.L$0;
        ResultKt.throwOnFailure(r100);
    L16:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        final String r105 = this.$url;
        final String r106 = this.$defaultTitle;
        this.L$0 = r105;
        this.L$1 = r106;
        this.label = 1;
        final SafeContinuation r107 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        if (TextUtils.isEmpty(r105) == false) goto L11;
        Result.Companion r108 = Result.Companion;
        r107.resumeWith(Result.m9449constructorimpl(new Triple("", "", "")));
    L11:
        URLRecognition.a(r105, new InlineEditTextFunctionImpl$getUrlInfo$2$1$1(r107, r105, r106));
        r100 = r107.getOrThrow();
        if (r100 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(this);
    L14:
        if (r100 != r101) goto L16;
        return r101;
    }
}
