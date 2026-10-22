package com.larus.bmhome.upload.audio;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.audio.AudioResourceUploader$upLoadImage$task$1$2$1", f = "AudioResourceUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioResourceUploader$upLoadImage$task$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<b> $content;
    final /* synthetic */ Throwable $it;
    final /* synthetic */ Function1<Throwable, Unit> $onFail;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioResourceUploader$upLoadImage$task$1$2$1(Function1<? super Throwable, Unit> r100, Throwable r101, List<b> r102, Continuation<? super AudioResourceUploader$upLoadImage$task$1$2$1> r103) {
        this.$onFail = r100;
        this.$it = r101;
        this.$content = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AudioResourceUploader$upLoadImage$task$1$2$1(this.$onFail, this.$it, this.$content, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AudioResourceUploader$upLoadImage$task$1$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        this.$onFail.invoke(this.$it);
        List<b> r101 = this.$content;
        Throwable r102 = this.$it;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        b r104 = (b) r103.next();
        Map<String, l> r105 = g.f314752b;
        LinkedHashMap r106 = (LinkedHashMap) r105;
        l r107 = (l) r106.get(r104.a());
        if (r107 == null) goto L6;
        r107.H0(r104, r102);
        goto L6
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
