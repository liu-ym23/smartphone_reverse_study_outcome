package com.larus.im.internal.core.cmd.util;

import com.flow.kmp.common.util.ReentrantMutex;
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
@DebugMetadata(c = "com.larus.im.internal.core.cmd.util.CmdCoroutineScopeKt$cmdContext$1", f = "CmdCoroutineScope.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
final class CmdCoroutineScopeKt$cmdContext$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.im.internal.core.cmd.util.CmdCoroutineScopeKt$cmdContext$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.cmd.util.CmdCoroutineScopeKt$cmdContext$1$1", f = "CmdCoroutineScope.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r100, CoroutineScope r101, Continuation<? super AnonymousClass1> r102) {
            this.$block = r100;
            this.$$this$launch = r101;
            super(1, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass1(this.$block, this.$$this$launch, r100);
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
            Function2<CoroutineScope, Continuation<? super Unit>, Object> r103 = this.$block;
            CoroutineScope r104 = this.$$this$launch;
            this.label = 1;
            if (r103.invoke(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CmdCoroutineScopeKt$cmdContext$1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super CmdCoroutineScopeKt$cmdContext$1> r101) {
        this.$block = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CmdCoroutineScopeKt$cmdContext$1 r102 = new CmdCoroutineScopeKt$cmdContext$1(this.$block, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CmdCoroutineScopeKt$cmdContext$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        CoroutineScope r103 = (CoroutineScope) this.L$0;
        ReentrantMutex r104 = c.f347540d;
        AnonymousClass1 r105 = new AnonymousClass1(this.$block, r103, null);
        this.label = 1;
        if (r104.a(r105, this) != r101) goto L12;
        return r101;
    }
}
