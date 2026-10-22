package com.larus.contextwindow.impl.routing;

import com.larus.contextwindow.api.ContextWindowEntryRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import x29.g;

/* JADX INFO: loaded from: classes27.dex */
public final class ContextWindowColdStartResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<ContextWindowEntryRequest, Continuation<? super v29.a>, Object> f330408a;

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.routing.ContextWindowColdStartResolver$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<ContextWindowEntryRequest, Continuation<? super v29.a>, Object>, SuspendFunction {
        public AnonymousClass1(Object r100) {
            super(2, r100, ContextWindowColdStartDataSource.class, "load", "load(Lcom/larus/contextwindow/api/ContextWindowEntryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ContextWindowEntryRequest r100, Continuation<? super v29.a> r101) {
            return ((ContextWindowColdStartDataSource) this.receiver).a(r100, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ContextWindowEntryRequest r100, Continuation<? super v29.a> r101) {
            return invoke2(r100, r101);
        }
    }

    public ContextWindowColdStartResolver(int r100) {
        AnonymousClass1 r101 = new AnonymousClass1(new ContextWindowColdStartDataSource(null));
        Intrinsics.checkNotNullParameter(r101, "inputLoader");
        this.f330408a = r101;
    }

    public final Object a(ContextWindowEntryRequest r100, Continuation<? super com.larus.contextwindow.api.a> r101) {
        if ((r101 instanceof ContextWindowColdStartResolver$resolve$1) == false) goto L7;
        ContextWindowColdStartResolver$resolve$1 r102 = (ContextWindowColdStartResolver$resolve$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        g r107 = (g) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L18:
        r107.getClass();
        return g.a((v29.a) r104);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        g r108 = g.f562264a;
        Function2<ContextWindowEntryRequest, Continuation<? super v29.a>, Object> r109 = this.f330408a;
        r102.L$0 = r108;
        r102.label = 1;
        Object r110 = r109.invoke(r100, r102);
        if (r110 != r105) goto L17;
        return r105;
    L17:
        r104 = r110;
        r107 = r108;
    L7:
        r102 = new ContextWindowColdStartResolver$resolve$1(this, r101);
        goto L8
    }
}
