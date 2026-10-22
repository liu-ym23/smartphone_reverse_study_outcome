package com.larus.drive.sdk.impl.utils;

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

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.ObjTokenGetUrlHelper$getUrlByToken$1$type$1", f = "ObjTokenGetUrlHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObjTokenGetUrlHelper$getUrlByToken$1$type$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $audioUrl;
    final /* synthetic */ Function1<String, Unit> $onFailure;
    final /* synthetic */ Function1<String, Unit> $onSuccess;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ObjTokenGetUrlHelper$getUrlByToken$1$type$1(String r100, Function1<? super String, Unit> r101, Function1<? super String, Unit> r102, Continuation<? super ObjTokenGetUrlHelper$getUrlByToken$1$type$1> r103) {
        this.$audioUrl = r100;
        this.$onSuccess = r101;
        this.$onFailure = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObjTokenGetUrlHelper$getUrlByToken$1$type$1 r102 = new ObjTokenGetUrlHelper$getUrlByToken$1$type$1(this.$audioUrl, this.$onSuccess, this.$onFailure, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ObjTokenGetUrlHelper$getUrlByToken$1$type$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        String r102 = this.$audioUrl;
        if (r102 == null) goto L7;
        this.$onSuccess.invoke(r102);
    L11:
        return Unit.INSTANCE;
    L7:
        Function1<String, Unit> r103 = this.$onFailure;
        if (r103 == null) goto L11;
        r103.invoke("");
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
