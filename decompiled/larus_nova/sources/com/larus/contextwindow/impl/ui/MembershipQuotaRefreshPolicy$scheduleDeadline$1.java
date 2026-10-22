package com.larus.contextwindow.impl.ui;

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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.ui.MembershipQuotaRefreshPolicy$scheduleDeadline$1", f = "MembershipQuotaRefreshPolicy.kt", i = {}, l = {50, 53}, m = "invokeSuspend", n = {}, s = {})
public final class MembershipQuotaRefreshPolicy$scheduleDeadline$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $deadline;
    final /* synthetic */ long $delayMillis;
    int label;
    final /* synthetic */ MembershipQuotaRefreshPolicy this$0;

    public MembershipQuotaRefreshPolicy$scheduleDeadline$1(long r100, MembershipQuotaRefreshPolicy r101, long r102, Continuation<? super MembershipQuotaRefreshPolicy$scheduleDeadline$1> r103) {
        this.$delayMillis = r100;
        this.this$0 = r101;
        this.$deadline = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MembershipQuotaRefreshPolicy$scheduleDeadline$1(this.$delayMillis, this.this$0, this.$deadline, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MembershipQuotaRefreshPolicy$scheduleDeadline$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L30:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L13:
        MembershipQuotaRefreshPolicy r103 = this.this$0;
        if (r103.f330464d == false) goto L32;
        Long r104 = r103.f330465e;
        long r105 = this.$deadline;
        if (r104 == null) goto L32;
        if (r104.longValue() != r105) goto L32;
        Long r106 = this.this$0.f330466f;
        long r107 = this.$deadline;
        if (r106 != null) goto L24;
    L26:
        MembershipQuotaRefreshPolicy r108 = this.this$0;
        r108.f330466f = Boxing.boxLong(this.$deadline);
        Function1<Continuation<? super Unit>, Object> r109 = this.this$0.f330463c;
        this.label = 2;
        if (r109.invoke(this) != r101) goto L30;
        return r101;
    L24:
        if (r106.longValue() != r107) goto L26;
    L32:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r100);
        long r110 = this.$delayMillis;
        this.label = 1;
        if (DelayKt.delay(r110, this) != r101) goto L13;
        return r101;
    }
}
