package com.larus.office.base.service;

import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.service.OfficePreloadHelper$startDeferredPrefetchCollector$1", f = "OfficePreloadHelper.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
final class OfficePreloadHelper$startDeferredPrefetchCollector$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.larus.office.base.service.OfficePreloadHelper$startDeferredPrefetchCollector$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1<T> f361071a = null;

        static {
            f361071a = new AnonymousClass1();
        }

        public AnonymousClass1() {
        }

        public final Object a(d.a r100, Continuation<? super Unit> r110) {
            if ((r110 instanceof OfficePreloadHelper$startDeferredPrefetchCollector$1$1$emit$1) == false) goto L7;
            OfficePreloadHelper$startDeferredPrefetchCollector$1$1$emit$1 r101 = (OfficePreloadHelper$startDeferredPrefetchCollector$1$1$emit$1) r110;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r111 = r101.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r101.label;
            boolean r105 = true;
            if (r104 == 0) goto L14;
            if (r104 != 1) goto L13;
            r100 = (d.a) r101.L$0;
            ResultKt.throwOnFailure(r111);
        L17:
            JobKt.ensureActive(r101.getContext());
        L34:
            e = move-exception;
            throw e;
        L32:
            e = move-exception;
            FLogger.f375446a.i("OfficePreloadHelper", "[" + r100.f361100b + "] deferred prefetch failed, resId=" + r100.f361101c + ", error=" + e);
        L38:
            return Unit.INSTANCE;
        L19:
            if (r100.f361099a.f0() == true) goto L23;
            return Unit.INSTANCE;
        L23:
            if (z2.f365865a.enableOfficeDataPrefetch() == true) goto L26;
            FLogger.f375446a.i("OfficePreloadHelper", "[" + r100.f361100b + "] deferred prefetch disabled by settings, resId=" + r100.f361101c);     // Catch: Exception -> L32 CancellationException -> L34
            return Unit.INSTANCE;
        L26:
            boolean r112 = r100.f361102d.invoke().booleanValue();     // Catch: Exception -> L32 CancellationException -> L34
            FLogger r106 = FLogger.f375446a;     // Catch: Exception -> L32 CancellationException -> L34
            StringBuilder r107 = new StringBuilder("[");     // Catch: Exception -> L32 CancellationException -> L34
            r107.append(r100.f361100b);     // Catch: Exception -> L32 CancellationException -> L34
            r107.append("] deferred prefetch result=");     // Catch: Exception -> L32 CancellationException -> L34
            if (r112 == true) goto L30;
            r105 = false;
        L30:
            r107.append(r105);     // Catch: Exception -> L32 CancellationException -> L34
            r107.append(", resId=");     // Catch: Exception -> L32 CancellationException -> L34
            r107.append(r100.f361101c);     // Catch: Exception -> L32 CancellationException -> L34
            r106.d("OfficePreloadHelper", r107.toString());     // Catch: Exception -> L32 CancellationException -> L34
            goto L38
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r111);
            IOfficeSdkServiceV2 r113 = r100.f361099a;
            r101.L$0 = r100;
            r101.label = 1;
            if (r113.o0(Long.MAX_VALUE, r101) != r103) goto L17;
            return r103;
        L7:
            r101 = new OfficePreloadHelper$startDeferredPrefetchCollector$1$1$emit$1(this, r110);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((d.a) r100, r101);
        }
    }

    public OfficePreloadHelper$startDeferredPrefetchCollector$1(Continuation<? super OfficePreloadHelper$startDeferredPrefetchCollector$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfficePreloadHelper$startDeferredPrefetchCollector$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OfficePreloadHelper$startDeferredPrefetchCollector$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        MutableSharedFlow<d.a> r103 = d.f361098b;
        FlowCollector<? super d.a> r104 = AnonymousClass1.f361071a;
        this.label = 1;
        if (r103.collect(r104, this) != r101) goto L12;
        return r101;
    }
}
