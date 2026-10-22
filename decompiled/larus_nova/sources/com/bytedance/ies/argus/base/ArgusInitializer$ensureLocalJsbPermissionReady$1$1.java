package com.bytedance.ies.argus.base;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.ies.argus.base.ArgusInitializer$ensureLocalJsbPermissionReady$1$1", f = "ArgusInitializer.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
final class ArgusInitializer$ensureLocalJsbPermissionReady$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Job $asyncScope;
    final /* synthetic */ r06.b $it;
    int label;

    /* JADX INFO: renamed from: com.bytedance.ies.argus.base.ArgusInitializer$ensureLocalJsbPermissionReady$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.ies.argus.base.ArgusInitializer$ensureLocalJsbPermissionReady$1$1$1", f = "ArgusInitializer.kt", i = {}, l = {241}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $asyncScope;
        int label;

        public AnonymousClass1(Job r100, Continuation<? super AnonymousClass1> r101) {
            this.$asyncScope = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$asyncScope, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            Job r103 = this.$asyncScope;
            this.label = 1;
            if (r103.join(this) != r101) goto L12;
            return r101;
        }
    }

    public ArgusInitializer$ensureLocalJsbPermissionReady$1$1(r06.b r100, Job r101, Continuation<? super ArgusInitializer$ensureLocalJsbPermissionReady$1$1> r102) {
        this.$it = r100;
        this.$asyncScope = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ArgusInitializer$ensureLocalJsbPermissionReady$1$1(this.$it, this.$asyncScope, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ArgusInitializer$ensureLocalJsbPermissionReady$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L13
    L16:
    L15:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        long r103 = this.$it.c();     // Catch: Exception -> L13
        AnonymousClass1 r104 = new AnonymousClass1(this.$asyncScope, null);     // Catch: Exception -> L13
        this.label = 1;     // Catch: Exception -> L13
        if (TimeoutKt.b(r103, r104, this) != r101) goto L16;
        return r101;
    L13:
        d.b("ArgusInitializer", "ensureLocalJsbPermissionReady: mode async_await timeout.", null, 12);
        goto L15
    }
}
