package com.larus.bmhome.upload.audio;

import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.audio.AudioResourceUploader$upLoadImage$task$1", f = "AudioResourceUploader.kt", i = {2}, l = {54, 69, 79}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
final class AudioResourceUploader$upLoadImage$task$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ List<b> $content;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Function1<Throwable, Unit> $onFail;
    final /* synthetic */ Function1<i, Unit> $onSuccess;
    final /* synthetic */ Function1<Float, Unit> $onUploadProgressChange;
    Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioResourceUploader$upLoadImage$task$1(String r100, String r101, List<b> r102, Function1<? super Throwable, Unit> r103, Function1<? super Float, Unit> r104, Function1<? super i, Unit> r105, Continuation<? super AudioResourceUploader$upLoadImage$task$1> r106) {
        this.$botId = r100;
        this.$conversationId = r101;
        this.$content = r102;
        this.$onFail = r103;
        this.$onUploadProgressChange = r104;
        this.$onSuccess = r105;
        super(1, r106);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r110) {
        return new AudioResourceUploader$upLoadImage$task$1(this.$botId, this.$conversationId, this.$content, this.$onFail, this.$onUploadProgressChange, this.$onSuccess, r110);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((AudioResourceUploader$upLoadImage$task$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [com.larus.bmhome.upload.audio.e] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L12;
        if (r101 == 2) goto L10;
        if (r101 != 3) goto L9;
        Throwable r102 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r110);
    L38:
        FLogger.f375446a.e("AudioImageUploader", "catch err when upload img, msg=" + r102);
    L40:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L29
    L25:
        Unit r111 = (Unit) r110;     // Catch: Throwable -> L29
    L27:
        Object r112 = Result.m9449constructorimpl(r111);     // Catch: Throwable -> L29
    L31:
        Function1<Throwable, Unit> r103 = this.$onFail;
        List<b> r104 = this.$content;
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L40;
        MainCoroutineDispatcher r105 = Dispatchers.getMain();
        AudioResourceUploader$upLoadImage$task$1$2$1 r106 = new AudioResourceUploader$upLoadImage$task$1$2$1(r103, r113, r104, null);
        this.L$0 = r113;
        this.label = 3;
        if (BuildersKt.withContext(r105, r106, this) != r100) goto L37;
        return r100;
    L37:
        r102 = r113;
        goto L38
    L12:
        Function1<i, Unit> r107 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L29
    L20:
        i r114 = (i) r110;     // Catch: Throwable -> L29
        if (r114 == null) goto L26;
        MainCoroutineDispatcher r108 = Dispatchers.getMain();     // Catch: Throwable -> L29
        AudioResourceUploader$upLoadImage$task$1$1$1 r109 = new AudioResourceUploader$upLoadImage$task$1$1$1(r107, r114, null);     // Catch: Throwable -> L29
        this.L$0 = null;     // Catch: Throwable -> L29
        this.label = 2;     // Catch: Throwable -> L29
        r110 = BuildersKt.withContext(r108, r109, this);     // Catch: Throwable -> L29
        if (r110 != r100) goto L25;
        return r100;
    L26:
        FLogger.f375446a.e("AudioImageUploader", "on request err");     // Catch: Throwable -> L29
        r111 = Unit.INSTANCE;     // Catch: Throwable -> L29
        goto L27
    L15:
        ResultKt.throwOnFailure(r110);
        c r115 = new c(this.$botId, this.$conversationId, this.$content);
        g r116 = g.f314751a;
        Function1<Throwable, Unit> r117 = this.$onFail;
        final List<b> r118 = this.$content;
        final Function1<Float, Unit> r119 = this.$onUploadProgressChange;
        Function1<i, Unit> r120 = this.$onSuccess;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L29
        AudioResourceUploader$upLoadImage$task$1$1$result$1 r122 = new AudioResourceUploader$upLoadImage$task$1$1$result$1(r117, r118, null);     // Catch: Throwable -> L29
        ?? r123 = new e(r118, r119);     // Catch: Throwable -> L29
        this.L$0 = r120;     // Catch: Throwable -> L29
        this.label = 1;     // Catch: Throwable -> L29
        r110 = g.a(r116, r115, r122, r123, this);     // Catch: Throwable -> L29
        if (r110 != r100) goto L19;
        return r100;
    L19:
        r107 = r120;
    L29:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    }
}
