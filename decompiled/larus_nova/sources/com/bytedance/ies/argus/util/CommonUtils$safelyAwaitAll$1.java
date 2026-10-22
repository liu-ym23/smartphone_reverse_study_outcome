package com.bytedance.ies.argus.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.ies.argus.util.CommonUtils$safelyAwaitAll$1", f = "CommonUtils.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
final class CommonUtils$safelyAwaitAll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<Deferred<?>> $this_safelyAwaitAll;
    int label;

    /* JADX INFO: renamed from: com.bytedance.ies.argus.util.CommonUtils$safelyAwaitAll$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.ies.argus.util.CommonUtils$safelyAwaitAll$1$1", f = "CommonUtils.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Object>>, Object> {
        final /* synthetic */ List<Deferred<?>> $this_safelyAwaitAll;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(List<? extends Deferred<?>> r100, Continuation<? super AnonymousClass1> r101) {
            this.$this_safelyAwaitAll = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$this_safelyAwaitAll, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super List<? extends Object>> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super List<? extends Object>> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            List<Deferred<?>> r103 = this.$this_safelyAwaitAll;
            this.label = 1;
            r100 = AwaitKt.a(r103, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonUtils$safelyAwaitAll$1(List<? extends Deferred<?>> r100, Continuation<? super CommonUtils$safelyAwaitAll$1> r101) {
        this.$this_safelyAwaitAll = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommonUtils$safelyAwaitAll$1(this.$this_safelyAwaitAll, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((CommonUtils$safelyAwaitAll$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L18
    L13:
        if (r100 == null) goto L17;
        r103 = false;
        goto L17
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        AnonymousClass1 r104 = new AnonymousClass1(this.$this_safelyAwaitAll, null);     // Catch: Exception -> L18
        this.label = 1;     // Catch: Exception -> L18
        r100 = TimeoutKt.c(3000, r104, this);     // Catch: Exception -> L18
        if (r100 != r101) goto L13;
        return r101;
    L17:
        return Boxing.boxBoolean(r103);
    }
}
