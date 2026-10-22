package com.bytedance.lark.view_flow_wrapper;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003H\n"}, d2 = {"<anonymous>", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.lark.view_flow_wrapper.MoltenService$serviceLazy$1", f = "MoltenService.kt", i = {}, l = {16}, m = "invokeSuspend", n = {}, s = {})
public final class MoltenService$serviceLazy$1<S> extends SuspendLambda implements Function1<Continuation<? super S>, Object> {
    final /* synthetic */ Function1<Continuation<? super S>, Object> $serviceProvider;
    int label;
    final /* synthetic */ MoltenService<S> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MoltenService$serviceLazy$1(Function1<? super Continuation<? super S>, ? extends Object> r100, MoltenService<S> r101, Continuation<? super MoltenService$serviceLazy$1> r102) {
        this.$serviceProvider = r100;
        this.this$0 = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MoltenService$serviceLazy$1(this.$serviceProvider, this.this$0, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        return invoke((Continuation) r100);
    }

    public final Object invoke(Continuation<? super S> r100) {
        return ((MoltenService$serviceLazy$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        MoltenService<S> r103 = this.this$0;
        AutoCloseable r104 = (AutoCloseable) r100;
        y r105 = ViewFlowPlugin.f254409a;
        y r106 = ViewFlowPlugin.f254409a;
        if (r106 == null) goto L14;
        r106.a(new e0(MoltenService.a(r103)));
    L14:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function1<Continuation<? super S>, Object> r107 = this.$serviceProvider;
        this.label = 1;
        r100 = r107.invoke(this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
