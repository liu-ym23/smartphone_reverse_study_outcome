package com.larus.contextwindow.impl.membership;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MembershipQuotaRepository$Companion$INSTANCE$2$2 extends FunctionReferenceImpl implements Function1<Continuation<? super e>, Object>, SuspendFunction {
    public MembershipQuotaRepository$Companion$INSTANCE$2$2(Object r100) {
        super(1, r100, MembershipQuotaApi.class, "fetch", "fetch(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super e> r100) {
        return ((MembershipQuotaApi) this.receiver).a(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super e> r100) {
        return invoke2(r100);
    }
}
