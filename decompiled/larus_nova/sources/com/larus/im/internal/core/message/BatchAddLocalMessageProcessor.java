package com.larus.im.internal.core.message;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.core.IMActionProcessor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.sync.MutexImpl;
import yc9.f0;

/* JADX INFO: loaded from: classes29.dex */
public final class BatchAddLocalMessageProcessor extends IMActionProcessor<List<? extends f0>, List<? extends Message>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutexImpl f347732d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f347733e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f0> f347734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IIMCallback<List<Message>> f347735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f347736c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.message.BatchAddLocalMessageProcessor$process$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.message.BatchAddLocalMessageProcessor$process$1", f = "BatchAddLocalMessageProcessor.kt", i = {0, 1}, l = {43, 45}, m = "invokeSuspend", n = {"destination$iv$iv", "destination$iv$iv"}, s = {"L$1", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ BatchAddLocalMessageProcessor this$0;

        public AnonymousClass1(BatchAddLocalMessageProcessor r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass1(this.this$0, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((AnonymousClass1) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00dc -> B:24:0x00df). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            int r102 = 1;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            Collection r103 = (Collection) this.L$3;
            Iterator r104 = (Iterator) this.L$2;
            Collection r105 = (Collection) this.L$1;
            BatchAddLocalMessageProcessor r106 = (BatchAddLocalMessageProcessor) this.L$0;
            ResultKt.throwOnFailure(r210);
            Object r107 = r210;
            BatchAddLocalMessageProcessor r108 = r106;
            AnonymousClass1 r109 = this;
        L24:
            Message r110 = (Message) r107;
        L25:
            com.larus.im.internal.delegate.a r111 = com.larus.im.internal.delegate.a.f348188b;
            String r112 = r108.f347736c;
            StringBuilder r113 = new StringBuilder("add message success, localMsgId = ");
            if (r110 == null) goto L28;
            String r114 = r110.getLocalMessageId();
        L29:
            r113.append(r114);
            r111.i(r112, r113.toString());
            r103.add(r110);
            r103 = r105;
            AnonymousClass1 r115 = r109;
            BatchAddLocalMessageProcessor r116 = r108;
            r102 = 1;
        L12:
            if (r104.hasNext() == false) goto L30;
            f0 r117 = (f0) r104.next();
            com.larus.im.internal.delegate.a.f348188b.i(r116.f347736c, "trigger batch add message, req = " + r117);
            if (r117.f567248k == (-1)) goto L20;
            MessageHandler r118 = MessageHandler.f347752a;
            r115.L$0 = r116;
            r115.L$1 = r103;
            r115.L$2 = r104;
            r115.L$3 = r103;
            r115.label = r102;
            Object r119 = MessageHandler.i(r118, r117, null, r115, 4);
            if (r119 != r100) goto L18;
            return r100;
        L18:
            BatchAddLocalMessageProcessor r120 = r116;
            r109 = r115;
            r105 = r103;
            r110 = (Message) r119;
            r108 = r120;
            goto L25
        L20:
            MessageHandler r121 = MessageHandler.f347752a;
            f0 r122 = f0.a(r117, null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, 536869887);
            r115.L$0 = r116;
            r115.L$1 = r103;
            r115.L$2 = r104;
            r115.L$3 = r103;
            r115.label = 2;
            r107 = MessageHandler.i(r121, r122, null, r115, 4);
            if (r107 != r100) goto L23;
            return r100;
        L23:
            r108 = r116;
            r109 = r115;
            r105 = r103;
            goto L24
        L30:
            List<Message> r123 = (List) r103;
            IIMCallback<List<Message>> r124 = r115.this$0.f347735b;
            if (r124 == null) goto L34;
            r124.onSuccess(r123);
        L34:
            return Unit.INSTANCE;
        L28:
            r114 = null;
            goto L29
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r103 = (Collection) this.L$3;
            r104 = (Iterator) this.L$2;
            r105 = (Collection) this.L$1;
            BatchAddLocalMessageProcessor r125 = (BatchAddLocalMessageProcessor) this.L$0;
            ResultKt.throwOnFailure(r210);
            r109 = this;
            r110 = (Message) r210;
            r108 = r125;
            goto L25
        L10:
            ResultKt.throwOnFailure(r210);
            BatchAddLocalMessageProcessor r126 = this.this$0;
            List<f0> r127 = r126.f347734a;
            ArrayList r128 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
            r104 = r127.iterator();
            r116 = r126;
            r103 = r128;
            r115 = this;
            goto L12
        }
    }

    static {
        f347732d = kotlinx.coroutines.sync.b.a();
        f347733e = com.flow.kmp.common.thread.c.a("flow-im#add-msg");
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final void process() {
        com.larus.im.internal.delegate.a.f348188b.i(this.f347736c, "trigger batch add message");
        AnonymousClass1 r100 = new AnonymousClass1(this, null);
        Intrinsics.checkNotNullParameter(r100, "block");
        BuildersKt.launch$default(getScope(), f347733e, null, new BatchAddLocalMessageProcessor$singleRun$1(r100, null), 2, null);
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final String getTAG() {
        return this.f347736c;
    }

    public BatchAddLocalMessageProcessor(List<f0> r100, IIMCallback<List<Message>> r101) {
        Intrinsics.checkNotNullParameter(r100, "requestList");
        super(r100, r101);
        this.f347734a = r100;
        this.f347735b = r101;
        this.f347736c = "BatchAddLocalMessageProcessor";
    }
}
