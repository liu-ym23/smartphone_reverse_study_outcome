package com.larus.im.internal.core.message;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.core.IMActionProcessor;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
public class AddLocalMessageProcessor extends IMActionProcessor<f0, Message> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutexImpl f347725d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f347726e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IIMCallback<Message> f347727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f347728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f347729c;

    public static final class a {
    }

    public static final class b implements IIMCallback<Message> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f347730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AddLocalMessageProcessor f347731b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            IIMCallback<Message> r100 = this.f347731b.f347727a;
            if (r100 != null) goto L7;
            return true;
        L7:
            return r100.mustInMain();
        }

        public b(AddLocalMessageProcessor r100) {
            this.f347731b = r100;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            com.larus.im.internal.delegate.a.f348188b.i(this.f347731b.getTAG(), "trigger add message local fail, msgId = " + AddLocalMessageProcessor.c(this.f347731b).f567246i + ", cost: " + (com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - this.f347730a));
            this.f347731b.onFailure(r100);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Message r100) {
            Message r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            com.larus.im.internal.delegate.a.f348188b.i(this.f347731b.getTAG(), "trigger add message local success, msgId = " + AddLocalMessageProcessor.c(this.f347731b).f567246i + ", cost: " + (com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - this.f347730a));
            this.f347731b.onSuccess(r101);
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.message.AddLocalMessageProcessor$process$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.message.AddLocalMessageProcessor$process$1", f = "AddLocalMessageProcessor.kt", i = {}, l = {79, 81}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddLocalMessageProcessor this$0;

        public AnonymousClass1(AddLocalMessageProcessor r100, Continuation<? super AnonymousClass1> r101) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r210);
            Object r102 = r210;
        L19:
            Message r103 = (Message) r102;
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r210);
            Object r104 = r210;
        L15:
            Message r105 = (Message) r104;
            goto L21
        L10:
            ResultKt.throwOnFailure(r210);
            this.this$0.f347729c.f347730a = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
            com.larus.im.internal.delegate.a.f348188b.i(this.this$0.getTAG(), "trigger add message local, in coroutine req = " + com.larus.im.internal.utils.l.g(AddLocalMessageProcessor.c(this.this$0)));
            if (AddLocalMessageProcessor.c(this.this$0).f567248k == (-1)) goto L16;
            MessageHandler r106 = MessageHandler.f347752a;
            f0 r107 = AddLocalMessageProcessor.c(this.this$0);
            b r108 = this.this$0.f347729c;
            this.label = 1;
            r106.getClass();
            r104 = OmniDatabaseExtKt.e(new MessageHandler$addLocalMessage$2(r107, null, r108, null), this);
            if (r104 != r100) goto L15;
            return r100;
        L16:
            MessageHandler r109 = MessageHandler.f347752a;
            f0 r110 = f0.a(AddLocalMessageProcessor.c(this.this$0), null, null, null, 0, null, null, null, 0, null, null, null, null, null, null, null, 536869887);
            b r111 = this.this$0.f347729c;
            this.label = 2;
            r109.getClass();
            r102 = OmniDatabaseExtKt.e(new MessageHandler$addLocalMessage$2(r110, null, r111, null), this);
            if (r102 != r100) goto L19;
            return r100;
        }
    }

    static {
        f347725d = kotlinx.coroutines.sync.b.a();
        f347726e = com.flow.kmp.common.thread.c.a("flow-im#add-msg");
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public void process() {
        com.larus.im.internal.delegate.a.f348188b.i(getTAG(), "trigger add message , msgId = " + getRequest().f567246i);
        AnonymousClass1 r100 = new AnonymousClass1(this, null);
        Intrinsics.checkNotNullParameter(r100, "block");
        BuildersKt.launch$default(getScope(), f347726e, null, new AddLocalMessageProcessor$singleRun$1(r100, null), 2, null);
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public String getTAG() {
        return this.f347728b;
    }

    public static final /* synthetic */ f0 c(AddLocalMessageProcessor r100) {
        return r100.getRequest();
    }

    public AddLocalMessageProcessor(f0 r100, IIMCallback<Message> r101) {
        Intrinsics.checkNotNullParameter(r100, "msgReq");
        super(r100, r101);
        this.f347727a = r101;
        this.f347728b = "AddMessageProcessor_" + com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();
        this.f347729c = new b(this);
    }
}
