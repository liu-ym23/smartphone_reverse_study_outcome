package com.larus.im.internal.core.message;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.RequestSubMessageProcessor$Companion$onFirstPackageError$1", f = "RequestSubMessageProcessor.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
public final class RequestSubMessageProcessor$Companion$onFirstPackageError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ int $index;
    final /* synthetic */ String $key;
    final /* synthetic */ String $parentId;
    int label;

    public RequestSubMessageProcessor$Companion$onFirstPackageError$1(String r100, String r101, String r102, int r103, Continuation<? super RequestSubMessageProcessor$Companion$onFirstPackageError$1> r104) {
        this.$key = r100;
        this.$conversationId = r101;
        this.$parentId = r102;
        this.$index = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RequestSubMessageProcessor$Companion$onFirstPackageError$1(this.$key, this.$conversationId, this.$parentId, this.$index, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RequestSubMessageProcessor$Companion$onFirstPackageError$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        vt7.b<String> r111 = RequestSubMessageProcessor.f347765d;
        String r102 = this.$key;
        String r103 = this.$conversationId;
        String r104 = this.$parentId;
        int r105 = this.$index;
        this.label = 1;
        if (RequestSubMessageProcessor.Companion.a(r102, r103, r104, r105, 22, this) != r100) goto L12;
        return r100;
    }
}
