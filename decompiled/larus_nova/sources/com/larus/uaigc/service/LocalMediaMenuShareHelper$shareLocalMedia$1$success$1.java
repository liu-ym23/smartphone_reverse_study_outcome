package com.larus.uaigc.service;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.service.LocalMediaMenuShareHelper$shareLocalMedia$1$success$1", f = "LocalMediaMenuShareHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LocalMediaMenuShareHelper$shareLocalMedia$1$success$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1<Uri, Boolean> $launchShare;
    final /* synthetic */ Uri $shareUri;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalMediaMenuShareHelper$shareLocalMedia$1$success$1(Uri r100, Function1<? super Uri, Boolean> r101, Continuation<? super LocalMediaMenuShareHelper$shareLocalMedia$1$success$1> r102) {
        this.$shareUri = r100;
        this.$launchShare = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LocalMediaMenuShareHelper$shareLocalMedia$1$success$1(this.$shareUri, this.$launchShare, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((LocalMediaMenuShareHelper$shareLocalMedia$1$success$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        Uri r101 = this.$shareUri;
        if (r101 == null) goto L7;
        boolean r102 = this.$launchShare.invoke(r101).booleanValue();
    L9:
        return Boxing.boxBoolean(r102);
    L7:
        r102 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
