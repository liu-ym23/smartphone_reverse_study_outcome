package com.larus.im.internal.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.stream.PendingHandler$handleCvsPendingMsg$1$1$1", f = "PendingHandler.kt", i = {0}, l = {91, 107}, m = "invokeSuspend", n = {"cvsPendingList"}, s = {"L$0"})
public final class PendingHandler$handleCvsPendingMsg$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cvsId;
    Object L$0;
    Object L$1;
    int label;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((PendingHandler.a) r100).f350092a.indexInConv), Long.valueOf(((PendingHandler.a) r101).f350092a.indexInConv));
        }
    }

    public PendingHandler$handleCvsPendingMsg$1$1$1(String r100, Continuation<? super PendingHandler$handleCvsPendingMsg$1$1$1> r101) {
        this.$cvsId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PendingHandler$handleCvsPendingMsg$1$1$1(this.$cvsId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((PendingHandler$handleCvsPendingMsg$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L10;
        if (r101 == 1) goto L9;
        if (r101 != 2) goto L8;
        Iterator r102 = (Iterator) this.L$1;
        String r103 = (String) this.L$0;
        ResultKt.throwOnFailure(r110);
    L28:
        if (r102.hasNext() == false) goto L33;
        PendingHandler.a r104 = (PendingHandler.a) r102.next();
        com.larus.im.internal.delegate.a.f348188b.i("PendingHandler", "invoke cvs msg: message_id = " + r104.f350092a.messageId + ", reply_id = " + r104.f350092a.botReplyMessageId + " index_in_conv = " + r104.f350092a.indexInConv + "cvsId = " + r103);
        this.L$0 = r103;
        this.L$1 = r102;
        this.label = 2;
        if (r104.a(this) != r100) goto L28;
        return r100;
    L33:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Set r105 = (Set) this.L$0;
        ResultKt.throwOnFailure(r110);
    L23:
        boolean r111 = ((Boolean) r110).booleanValue();
        com.larus.im.internal.delegate.a.f348188b.i("PendingHandler", "cvs end stream, cvs id =  " + this.$cvsId + " isCurCvsMsgStreaming = " + r111);
        if (r111 == true) goto L33;
        PendingHandler.f350085b.removeAll(r105);
        List r112 = CollectionsKt.sortedWith(r105, new a());
        r103 = this.$cvsId;
        r102 = r112.iterator();
        goto L28
    L10:
        ResultKt.throwOnFailure(r110);
        CopyOnWriteArrayList<PendingHandler.a> r113 = PendingHandler.f350085b;
        String r106 = this.$cvsId;
        ArrayList r107 = new ArrayList();
        Iterator<T> r114 = r113.iterator();
    L12:
        if (r114.hasNext() == false) goto L16;
        Object r108 = r114.next();
        if (Intrinsics.areEqual(((PendingHandler.a) r108).f350092a.conversationId, r106) == false) goto L12;
        r107.add(r108);
        goto L12
    L16:
        r105 = CollectionsKt.toSet(r107);
        com.larus.im.internal.delegate.a.f348188b.i("PendingHandler", "start to invoke, cvs id = " + this.$cvsId + " pendingList size = " + r105.size());
        if (r105.isEmpty() == true) goto L19;
        PendingHandler r115 = PendingHandler.f350084a;
        String r109 = this.$cvsId;
        this.L$0 = r105;
        this.label = 1;
        r110 = PendingHandler.b(r115, r109, this);
        if (r110 != r100) goto L23;
        return r100;
    L19:
        return Unit.INSTANCE;
    }
}
