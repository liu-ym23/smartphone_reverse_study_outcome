package com.ss.android.lark.active.user.impl;

import com.ss.android.lark.active.user.api.IGlobalActiveUserManager;
import java.util.Iterator;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.active.user.impl.GlobalActiveUserServiceImpl$registerConvention$1$1", f = "GlobalActiveUserServiceImpl.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
final class GlobalActiveUserServiceImpl$registerConvention$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.active.user.api.a $convention;
    int label;
    final /* synthetic */ b this$0;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f408612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.active.user.api.a f408613b;

        public a(b r100, com.ss.android.lark.active.user.api.a r101) {
            this.f408612a = r100;
            this.f408613b = r101;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            IGlobalActiveUserManager.a r102 = (IGlobalActiveUserManager.a) r100;
            b r103 = this.f408612a;
            Set<com.ss.android.lark.active.user.api.a> r104 = r103.f408623b;
            com.ss.android.lark.active.user.api.a r105 = this.f408613b;
            monitor-enter(r104);
            Iterator<T> r106 = r103.f408623b.iterator();     // Catch: Throwable -> L12
        L6:
            if (r106.hasNext() == false) goto L9;
            com.ss.android.lark.active.user.api.a r107 = (com.ss.android.lark.active.user.api.a) r106.next();     // Catch: Throwable -> L12
            r105.a();     // Catch: Throwable -> L12
            goto L6
        L9:
            monitor-exit(r104);
            return Unit.INSTANCE;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public GlobalActiveUserServiceImpl$registerConvention$1$1(b r100, com.ss.android.lark.active.user.api.a r101, Continuation<? super GlobalActiveUserServiceImpl$registerConvention$1$1> r102) {
        this.this$0 = r100;
        this.$convention = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new GlobalActiveUserServiceImpl$registerConvention$1$1(this.this$0, this.$convention, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((GlobalActiveUserServiceImpl$registerConvention$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        b1 r103 = this.this$0.f408622a.c();
        a r104 = new a(this.this$0, this.$convention);
        this.label = 1;
        if (r103.collect(r104, this) != r101) goto L12;
        return r101;
    }
}
