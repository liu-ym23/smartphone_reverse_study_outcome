package com.obric.assistant.upload.internal;

import com.larus.im.bean.message.UplinkFileEntity;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import mr9.n;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.upload.internal.ObricUploadDispatcher$onSuccess$1", f = "ObricUploadDispatcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricUploadDispatcher$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $identifier;
    final /* synthetic */ mr9.d $imageResult;
    final /* synthetic */ String $resId;
    final /* synthetic */ String $tosKey;
    final /* synthetic */ n $videoResult;
    int label;

    public ObricUploadDispatcher$onSuccess$1(String r100, UplinkFileEntity r101, String r102, String r103, mr9.d r104, n r105, Continuation<? super ObricUploadDispatcher$onSuccess$1> r106) {
        this.$identifier = r100;
        this.$entity = r101;
        this.$tosKey = r102;
        this.$resId = r103;
        this.$imageResult = r104;
        this.$videoResult = r105;
        super(2, r106);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        return new ObricUploadDispatcher$onSuccess$1(this.$identifier, this.$entity, this.$tosKey, this.$resId, this.$imageResult, this.$videoResult, r110);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObricUploadDispatcher$onSuccess$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r110);
        int r111 = m.f393570a;
        m.c("ObricUploadDispatcher", "onSuccess called, identifier = " + this.$identifier);
        Set<oha.a> r112 = e.f393564a.get(this.$identifier);
        if (r112 == null) goto L11;
        UplinkFileEntity r100 = this.$entity;
        String r101 = this.$tosKey;
        String r102 = this.$resId;
        Iterator<T> r113 = r112.iterator();
    L8:
        if (r113.hasNext() == false) goto L11;
        oha.a r103 = (oha.a) r113.next();
        r103.c(r100, r101, r102);
        r103.onResult(true, r101, r102, null, null);
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
