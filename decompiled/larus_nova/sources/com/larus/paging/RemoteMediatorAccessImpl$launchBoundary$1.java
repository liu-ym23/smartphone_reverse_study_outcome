package com.larus.paging;

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
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.RemoteMediatorAccessImpl$launchBoundary$1", f = "RemoteMediatorAccessor.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
final class RemoteMediatorAccessImpl$launchBoundary$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RemoteMediatorAccessImpl<Object, Object> this$0;

    /* JADX INFO: renamed from: com.larus.paging.RemoteMediatorAccessImpl$launchBoundary$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\u008a@"}, d2 = {"", "Key", "Value", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.larus.paging.RemoteMediatorAccessImpl$launchBoundary$1$1", f = "RemoteMediatorAccessor.kt", i = {0}, l = {345}, m = "invokeSuspend", n = {"loadType"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ RemoteMediatorAccessImpl<Object, Object> this$0;

        public AnonymousClass1(RemoteMediatorAccessImpl<Object, Object> r100, Continuation<? super AnonymousClass1> r101) {
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
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 != 0) goto L5;
            ResultKt.throwOnFailure(r100);
        L17:
            this.this$0.getClass();
            C44571 r102 = C44571.INSTANCE;
            throw null;
        L5:
            if (r101 != 1) goto L15;
            final LoadType r103 = (LoadType) this.L$0;
            ResultKt.throwOnFailure(r100);
            final RemoteMediator.a r104 = (RemoteMediator.a) r100;
            if ((r104 instanceof RemoteMediator.a.b) == false) goto L9;
            this.this$0.getClass();
            new AnonymousClass2(r103, r104);
            throw null;
        L9:
            if ((r104 instanceof RemoteMediator.a.C4456a) == false) goto L17;
            this.this$0.getClass();
            new AnonymousClass3(r103, r104);
            throw null;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RemoteMediatorAccessImpl$launchBoundary$1(RemoteMediatorAccessImpl<Object, Object> r100, Continuation<? super RemoteMediatorAccessImpl$launchBoundary$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RemoteMediatorAccessImpl$launchBoundary$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RemoteMediatorAccessImpl$launchBoundary$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L8;
        ResultKt.throwOnFailure(r100);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        RemoteMediatorAccessImpl<Object, Object> r102 = this.this$0;
        r102.getClass();
        new AnonymousClass1(r102, null);
        this.label = 1;
        throw null;
    }
}
