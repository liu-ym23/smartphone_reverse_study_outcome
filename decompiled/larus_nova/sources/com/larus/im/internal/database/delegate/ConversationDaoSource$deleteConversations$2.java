package com.larus.im.internal.database.delegate;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.ConversationDaoSource$deleteConversations$2", f = "ConversationDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ConversationDaoSource$deleteConversations$2 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {
    final /* synthetic */ List<String> $cvsIds;
    int label;

    public ConversationDaoSource$deleteConversations$2(List<String> r100, Continuation<? super ConversationDaoSource$deleteConversations$2> r101) {
        this.$cvsIds = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new ConversationDaoSource$deleteConversations$2(this.$cvsIds, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Integer> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Integer> r100) {
        return ((ConversationDaoSource$deleteConversations$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        Integer r101 = Boxing.boxInt(0);
        final List<String> r102 = this.$cvsIds;
        return com.larus.im.internal.database.utils.n.a("ConversationDaoSource", r101, new d(r102));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
