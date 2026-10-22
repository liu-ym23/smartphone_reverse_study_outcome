package com.larus.login.impl.douyinconversationauth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DouyinConversationAuthDialogFragment$bindActions$2$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Boolean>, Object>, SuspendFunction {
    public DouyinConversationAuthDialogFragment$bindActions$2$1(Object r100) {
        super(1, r100, DouyinConversationAuthActionHandler.class, "reject", "reject(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Boolean> r100) {
        ((DouyinConversationAuthActionHandler) this.receiver).getClass();
        return DouyinConversationAuthRepository.f357644a.b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r100) {
        return invoke2(r100);
    }
}
