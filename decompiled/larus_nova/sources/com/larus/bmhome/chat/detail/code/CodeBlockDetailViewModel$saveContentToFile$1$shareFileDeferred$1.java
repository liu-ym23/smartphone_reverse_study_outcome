package com.larus.bmhome.chat.detail.code;

import android.content.Context;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.detail.code.CodeBlockDetailViewModel$saveContentToFile$1$shareFileDeferred$1", f = "CodeBlockDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CodeBlockDetailViewModel$saveContentToFile$1$shareFileDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ String $codeInfo;
    final /* synthetic */ String $content;
    final /* synthetic */ Context $context;
    int label;

    public CodeBlockDetailViewModel$saveContentToFile$1$shareFileDeferred$1(Context r100, String r101, String r102, Continuation<? super CodeBlockDetailViewModel$saveContentToFile$1$shareFileDeferred$1> r103) {
        this.$context = r100;
        this.$content = r101;
        this.$codeInfo = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CodeBlockDetailViewModel$saveContentToFile$1$shareFileDeferred$1(this.$context, this.$content, this.$codeInfo, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super File> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super File> r101) {
        return ((CodeBlockDetailViewModel$saveContentToFile$1$shareFileDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        Lazy r101 = se8.d.f541621a;
        return se8.d.a(this.$context, this.$content, this.$codeInfo);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
