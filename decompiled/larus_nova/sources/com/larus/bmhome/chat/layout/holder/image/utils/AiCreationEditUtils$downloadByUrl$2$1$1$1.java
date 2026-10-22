package com.larus.bmhome.chat.layout.holder.image.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.uaigc.service.ICreationWorkflowService;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.image.utils.AiCreationEditUtils$downloadByUrl$2$1$1$1", f = "AiCreationEditUtils.kt", i = {}, l = {1064}, m = "invokeSuspend", n = {}, s = {})
final class AiCreationEditUtils$downloadByUrl$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Context $context;
    final /* synthetic */ i<File> $continuation;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AiCreationEditUtils$downloadByUrl$2$1$1$1(Context r100, Bitmap r101, i<? super File> r102, Continuation<? super AiCreationEditUtils$downloadByUrl$2$1$1$1> r103) {
        this.$context = r100;
        this.$bitmap = r101;
        this.$continuation = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AiCreationEditUtils$downloadByUrl$2$1$1$1(this.$context, this.$bitmap, this.$continuation, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AiCreationEditUtils$downloadByUrl$2$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        File r103 = (File) r100;
        if (this.$continuation.isActive() == false) goto L15;
        this.$continuation.resumeWith(Result.m9449constructorimpl(r103));
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ICreationWorkflowService.Companion r104 = ICreationWorkflowService.f373940a;
        Context r105 = this.$context;
        Bitmap r106 = this.$bitmap;
        this.label = 1;
        r100 = r104.m(r105, r106, "image_selector_default_image.jpeg", this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
