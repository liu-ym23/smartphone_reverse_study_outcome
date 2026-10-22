package com.larus.im.internal.core.message.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class MsgTimeoutTask implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f347847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f347848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<String, Continuation<? super Unit>, Object> f347849c;

    /* JADX INFO: renamed from: com.larus.im.internal.core.message.utils.MsgTimeoutTask$run$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.message.utils.MsgTimeoutTask$run$1", f = "MessageTimeoutStrategy.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MsgTimeoutTask this$0;

        public AnonymousClass1(MsgTimeoutTask r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            MsgTimeoutTask r103 = this.this$0;
            Function2<String, Continuation<? super Unit>, Object> r104 = r103.f347849c;
            String r105 = r103.f347848b;
            this.label = 1;
            if (r104.invoke(r105, this) != r101) goto L12;
            return r101;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        BuildersKt.launch$default(this.f347847a, null, null, new AnonymousClass1(this, null), 3, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MsgTimeoutTask(CoroutineScope r100, String r101, Function2<? super String, ? super Continuation<? super Unit>, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f347847a = r100;
        this.f347848b = r101;
        this.f347849c = r102;
    }
}
