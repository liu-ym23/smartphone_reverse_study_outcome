package com.larus.im.internal.legacy;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.legacy.AndroidIMABExperimentReadCostTracker$triggerOnce$2", f = "IMABExperimentReadCostTracker.kt", i = {0}, l = {48}, m = "invokeSuspend", n = {"index"}, s = {"I$2"})
final class AndroidIMABExperimentReadCostTracker$triggerOnce$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    int label;

    public AndroidIMABExperimentReadCostTracker$triggerOnce$2(Continuation<? super AndroidIMABExperimentReadCostTracker$triggerOnce$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AndroidIMABExperimentReadCostTracker$triggerOnce$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AndroidIMABExperimentReadCostTracker$triggerOnce$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0039 -> B:14:0x003a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        int r102 = this.I$2;
        int r103 = this.I$1;
        int r104 = this.I$0;
        ResultKt.throwOnFailure(r110);
        AndroidIMABExperimentReadCostTracker$triggerOnce$2 r111 = this;
    L14:
        boolean r105 = g.f348766a;
        int r106 = r102 + 1;
        com.larus.im.internal.delegate.a r107 = com.larus.im.internal.delegate.a.f348188b;
        r107.i("IMABExperimentReadCostTracker", "read config round=" + r106 + " start");
        g.b(r106, "exp_im_test_bool_key", new a());
        g.b(r106, "exp_im_test_int_key", new b());
        g.b(r106, "exp_im_test_double_key", new c());
        g.b(r106, "exp_im_test_string_key", new d());
        g.b(r106, "exp_im_test_dic_key", new e());
        g.b(r106, "old_link_exp_bool_key", new f());
        r107.i("IMABExperimentReadCostTracker", "read config round=" + r106 + " end");
        r102 = r103 + 1;
    L9:
        if (r102 >= r104) goto L16;
        r111.I$0 = r104;
        r111.I$1 = r102;
        r111.I$2 = r102;
        r111.label = 1;
        if (DelayKt.delay(5000, r111) != r100) goto L13;
        return r100;
    L13:
        r103 = r102;
        goto L14
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        r111 = this;
        r102 = 0;
        r104 = 3;
        goto L9
    }
}
