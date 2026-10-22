package com.larus.bmhome;

import com.larus.bmhome.chat.input.ChatInputService;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.AIChatUploadMediaServiceImpl$processTakePhotoImg$2", f = "AIChatUploadMediaServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIChatUploadMediaServiceImpl$processTakePhotoImg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ic8.n0>, Object> {
    final /* synthetic */ ns8.a $compressConfig;
    final /* synthetic */ boolean $isMultiFile;
    final /* synthetic */ ns8.b $processConfig;
    final /* synthetic */ String $tmpSrcPath;
    int label;

    public AIChatUploadMediaServiceImpl$processTakePhotoImg$2(String r100, boolean r101, ns8.a r102, ns8.b r103, Continuation<? super AIChatUploadMediaServiceImpl$processTakePhotoImg$2> r104) {
        this.$tmpSrcPath = r100;
        this.$isMultiFile = r101;
        this.$compressConfig = r102;
        this.$processConfig = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AIChatUploadMediaServiceImpl$processTakePhotoImg$2(this.$tmpSrcPath, this.$isMultiFile, this.$compressConfig, this.$processConfig, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ic8.n0> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ic8.n0> r101) {
        return ((AIChatUploadMediaServiceImpl$processTakePhotoImg$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return ye8.b.a.c(ChatInputService.f303327b.f(), this.$tmpSrcPath, this.$isMultiFile, this.$compressConfig, this.$processConfig, 16);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
