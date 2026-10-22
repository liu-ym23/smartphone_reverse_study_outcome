package com.bytedance.applet.aibridge.feedback;

import com.larus.im.callback.IIMError;
import f3.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.aibridge.feedback.GetFeedbackDataMethod$handle$1$onFailure$1", f = "GetFeedbackDataMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GetFeedbackDataMethod$handle$1$onFailure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h<AbsGetFeedbackDataMethodIDL.b> $callback;
    final /* synthetic */ IIMError $error;
    int label;
    final /* synthetic */ GetFeedbackDataMethod this$0;

    public GetFeedbackDataMethod$handle$1$onFailure$1(h<AbsGetFeedbackDataMethodIDL.b> r1, IIMError r2, GetFeedbackDataMethod r3, Continuation<? super GetFeedbackDataMethod$handle$1$onFailure$1> r4) {
        this.$callback = r1;
        this.$error = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GetFeedbackDataMethod$handle$1$onFailure$1(this.$callback, this.$error, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        h<AbsGetFeedbackDataMethodIDL.b> r6 = this.$callback;
        String r0 = "0_[" + this.$error.getCode() + "]:" + this.$error.getTips();
        AbsGetFeedbackDataMethodIDL.b r1 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsGetFeedbackDataMethodIDL.b.class));
        GetFeedbackDataMethod r2 = this.this$0;
        AbsGetFeedbackDataMethodIDL.b r3 = r1;
        List r4 = CollectionsKt.emptyList();
        r2.getClass();
        AbsGetFeedbackDataMethodIDL.b(r3, r4);
        Unit r7 = Unit.INSTANCE;
        h.a.a(r6, r0, null, r3.toJson(), 6);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
