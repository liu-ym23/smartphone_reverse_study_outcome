package com.bytedance.lark.view_flow_wrapper;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\f\b\u0001\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "R", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.view_flow_wrapper.MoltenService$withService$2$1", f = "MoltenService.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
public final class MoltenService$withService$2$1<R, S> extends SuspendLambda implements Function2<S, Continuation<? super R>, Object> {
    final /* synthetic */ Function2<S, Continuation<? super R>, Object> $onValue;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MoltenService$withService$2$1(Function2<? super S, ? super Continuation<? super R>, ? extends Object> r100, Continuation<? super MoltenService$withService$2$1> r101) {
        this.$onValue = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MoltenService$withService$2$1 r102 = new MoltenService$withService$2$1(this.$onValue, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX WARN: Incorrect types in method signature: (TS;Lkotlin/coroutines/Continuation<-TR;>;)Ljava/lang/Object; */
    public final Object invoke(AutoCloseable r100, Continuation r101) {
        return ((MoltenService$withService$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke((AutoCloseable) r100, (Continuation) r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        AutoCloseable r103 = (AutoCloseable) this.L$0;
        Function2<S, Continuation<? super R>, Object> r104 = this.$onValue;
        this.label = 1;
        r100 = r104.invoke(r103, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
