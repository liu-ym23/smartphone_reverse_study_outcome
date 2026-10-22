package com.larus.bmhome;

import android.net.Uri;
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
@DebugMetadata(c = "com.larus.bmhome.AIChatUploadMediaServiceImpl$preprocessAlbumImg$2", f = "AIChatUploadMediaServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AIChatUploadMediaServiceImpl$preprocessAlbumImg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ic8.n0>, Object> {
    final /* synthetic */ ns8.a $compressConfig;
    final /* synthetic */ boolean $isMultiFile;
    final /* synthetic */ boolean $keepCompressConfig;
    final /* synthetic */ ns8.b $processConfig;
    final /* synthetic */ String $scene;
    final /* synthetic */ Uri $uri;
    int label;

    public AIChatUploadMediaServiceImpl$preprocessAlbumImg$2(Uri r100, boolean r101, ns8.a r102, String r103, ns8.b r104, boolean r105, Continuation<? super AIChatUploadMediaServiceImpl$preprocessAlbumImg$2> r106) {
        this.$uri = r100;
        this.$isMultiFile = r101;
        this.$compressConfig = r102;
        this.$scene = r103;
        this.$processConfig = r104;
        this.$keepCompressConfig = r105;
        super(2, r106);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        return new AIChatUploadMediaServiceImpl$preprocessAlbumImg$2(this.$uri, this.$isMultiFile, this.$compressConfig, this.$scene, this.$processConfig, this.$keepCompressConfig, r110);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super ic8.n0> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super ic8.n0> r101) {
        return ((AIChatUploadMediaServiceImpl$preprocessAlbumImg$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return ChatInputService.f303327b.f().e(this.$uri, this.$isMultiFile, this.$compressConfig, this.$scene, this.$processConfig, this.$keepCompressConfig);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
