package com.larus.im.internal.core.conversation.bot;

import com.larus.im.callback.IMError;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.bot.UpdateConversationTtsProcessor$process$1", f = "UpdateConversationTtsProcessor.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
final class UpdateConversationTtsProcessor$process$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ j this$0;

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.bot.UpdateConversationTtsProcessor$process$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.bot.UpdateConversationTtsProcessor$process$1$1", f = "UpdateConversationTtsProcessor.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ j this$0;

        public AnonymousClass1(j r100, Continuation<? super AnonymousClass1> r101) {
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass1(null, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((AnonymousClass1) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r100 = this.label;
            if (r100 != 0) goto L5;
            ResultKt.throwOnFailure(r110);
            ae9.b.a();
            throw null;
        L5:
            if (r100 != 1) goto L12;
            ResultKt.throwOnFailure(r110);
            if (((Number) r110).intValue() <= 0) goto L9;
            throw null;
        L9:
            new IMError(-1, null, null, null, 14, null);
            throw null;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public UpdateConversationTtsProcessor$process$1(j r100, Continuation<? super UpdateConversationTtsProcessor$process$1> r101) {
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new UpdateConversationTtsProcessor$process$1(null, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((UpdateConversationTtsProcessor$process$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        AnonymousClass1 r103 = new AnonymousClass1(null, null);
        this.label = 1;
        if (OmniDatabaseExtKt.e(r103, this) != r101) goto L12;
        return r101;
    }
}
