package com.bytedance.android.shopping.mall.homepage.tools;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.homepage.tools.ECRequestManager$executeRequest$job$1", f = "ECRequestManager.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
final class ECRequestManager$executeRequest$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred $newDeferred;
    final /* synthetic */ Function1 $request;
    int label;

    public ECRequestManager$executeRequest$job$1(Function1 r1, CompletableDeferred r2, Continuation r3) {
        this.$request = r1;
        this.$newDeferred = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new ECRequestManager$executeRequest$job$1(this.$request, this.$newDeferred, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r4);     // Catch: Exception -> L7
    L15:
        this.$newDeferred.complete(r4);     // Catch: Exception -> L7
    L19:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r4);
        Function1 r5 = this.$request;     // Catch: Exception -> L7
        this.label = 1;     // Catch: Exception -> L7
        r4 = r5.invoke(this);     // Catch: Exception -> L7
        if (r4 != r0) goto L15;
        return r0;
    L7:
        e = move-exception;
        this.$newDeferred.completeExceptionally(e);
        goto L19
    }
}
