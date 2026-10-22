package com.ss.android.lark.passport.flow.verify.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "f1", "f2", "f3"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$countDownTime$1", f = "VerifyCodeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VerifyCodeViewModel$countDownTime$1 extends SuspendLambda implements Function4<Integer, Integer, Integer, Continuation<? super Triple<? extends Integer, ? extends Integer, ? extends Integer>>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    /* synthetic */ int I$2;
    int label;

    public VerifyCodeViewModel$countDownTime$1(Continuation<? super VerifyCodeViewModel$countDownTime$1> r100) {
        super(4, r100);
    }

    public final Object invoke(int r100, int r101, int r102, Continuation<? super Triple<Integer, Integer, Integer>> r103) {
        VerifyCodeViewModel$countDownTime$1 r104 = new VerifyCodeViewModel$countDownTime$1(r103);
        r104.I$0 = r100;
        r104.I$1 = r101;
        r104.I$2 = r102;
        return r104.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Integer r100, Integer r101, Integer r102, Continuation<? super Triple<? extends Integer, ? extends Integer, ? extends Integer>> r103) {
        return invoke(r100.intValue(), r101.intValue(), r102.intValue(), r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        int r101 = this.I$0;
        int r102 = this.I$1;
        int r103 = this.I$2;
        return new Triple(Boxing.boxInt(r101), Boxing.boxInt(r102), Boxing.boxInt(r103));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
