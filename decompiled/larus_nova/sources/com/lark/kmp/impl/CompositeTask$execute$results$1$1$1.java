package com.lark.kmp.impl;

import com.lark.kmp.basic.Scene;
import com.lark.kmp.logger.LarkLogger;
import gy7.n;
import gy7.o;
import gy7.p;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/lark/kmp/basic/TaskResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.lark.kmp.impl.CompositeTask$execute$results$1$1$1", f = "CompositeTask.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
public final class CompositeTask$execute$results$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends o>>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ Scene $scene;
    final /* synthetic */ n $task;
    final /* synthetic */ p $userPayload;
    int label;

    public CompositeTask$execute$results$1$1$1(n r100, p r101, Scene r102, int r103, Continuation<? super CompositeTask$execute$results$1$1$1> r104) {
        this.$task = r100;
        this.$userPayload = r101;
        this.$scene = r102;
        this.$index = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CompositeTask$execute$results$1$1$1(this.$task, this.$userPayload, this.$scene, this.$index, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Pair<? extends Integer, ? extends o>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Pair<Integer, o>> r101) {
        return ((CompositeTask$execute$results$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        o r103 = (o) r100;     // Catch: Throwable -> L15
    L17:
        LarkLogger r104 = LarkLogger.f278603a;
        StringBuilder r105 = new StringBuilder("CompositeTask finish, result = ");
        this.$task.name();
        r105.append(r103.f483345a);
        r105.append(", errorMsg = ");
        r105.append(r103.f483347c);
        LarkLogger.c("OnlineTask", r105.toString());
        return TuplesKt.to(Boxing.boxInt(this.$index), r103);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        LarkLogger r106 = LarkLogger.f278603a;
        this.$task.name();
        LarkLogger.c("OnlineTask", "execute task CompositeTask start");
        n r107 = this.$task;     // Catch: Throwable -> L15
        p r108 = this.$userPayload;     // Catch: Throwable -> L15
        Scene r109 = this.$scene;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r100 = r107.a(r108, r109, this);     // Catch: Throwable -> L15
        if (r100 != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        LarkLogger r110 = LarkLogger.f278603a;
        StringBuilder r111 = new StringBuilder("CompositeTask execute with exception: ");
        this.$task.name();
        r111.append(th.getMessage());
        LarkLogger.b("OnlineTask", r111.toString());
        r103 = new o(false, -1, "exception: " + th.getMessage());
        goto L17
    }
}
