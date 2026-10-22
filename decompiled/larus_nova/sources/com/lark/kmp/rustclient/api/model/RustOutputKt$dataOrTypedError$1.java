package com.lark.kmp.rustclient.api.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n"}, d2 = {"<anonymous>", "", "RAW", "DATA", "r", "Lcom/lark/kmp/rustclient/api/model/RustOutput;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.lark.kmp.rustclient.api.model.RustOutputKt$dataOrTypedError$1", f = "RustOutput.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RustOutputKt$dataOrTypedError$1 extends SuspendLambda implements Function2<g<Object, Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Object, Unit> $onNext;
    final /* synthetic */ Function1<f, Unit> $onRustError;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public RustOutputKt$dataOrTypedError$1(Function1<Object, Unit> r100, Function1<? super f, Unit> r101, Continuation<? super RustOutputKt$dataOrTypedError$1> r102) {
        this.$onNext = r100;
        this.$onRustError = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        RustOutputKt$dataOrTypedError$1 r102 = new RustOutputKt$dataOrTypedError$1(this.$onNext, this.$onRustError, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(g<Object, Object> r100, Continuation<? super Unit> r101) {
        return ((RustOutputKt$dataOrTypedError$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(g<Object, Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r100);
        g r101 = (g) this.L$0;
        if ((r101 instanceof k) == false) goto L8;
        this.$onNext.invoke(((k) r101).f282482b);
    L11:
        return Unit.INSTANCE;
    L8:
        if ((r101 instanceof b) == false) goto L13;
        this.$onRustError.invoke(((b) r101).f282469b);
        goto L11
    L13:
        throw new NoWhenBranchMatchedException();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
