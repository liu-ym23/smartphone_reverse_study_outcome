package com.larus.bmhome.upload.audio;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.audio.AudioResourceUploader$upLoadImage$task$1$1$1", f = "AudioResourceUploader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AudioResourceUploader$upLoadImage$task$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<i, Unit> $onSuccess;
    final /* synthetic */ i $result;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AudioResourceUploader$upLoadImage$task$1$1$1(Function1<? super i, Unit> r100, i r101, Continuation<? super AudioResourceUploader$upLoadImage$task$1$1$1> r102) {
        this.$onSuccess = r100;
        this.$result = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AudioResourceUploader$upLoadImage$task$1$1$1(this.$onSuccess, this.$result, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AudioResourceUploader$upLoadImage$task$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r100);
        this.$onSuccess.invoke(this.$result);
        List<h> r101 = this.$result.a();
        if (r101 == null) goto L18;
        List r102 = CollectionsKt.filterNotNull(r101);
        if (r102 == null) goto L18;
        i r103 = this.$result;
        Iterator r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L27;
        h r105 = (h) r104.next();
        Map<String, l> r106 = g.f314752b;
        String r107 = r105.a();
        if (r107 != null) goto L14;
        r107 = "";
    L14:
        l r108 = (l) ((LinkedHashMap) r106).get(r107);
        if (r108 == null) goto L10;
        r108.I0(r103, r105);
        goto L10
    L27:
        return Unit.INSTANCE;
    L18:
        return null;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
