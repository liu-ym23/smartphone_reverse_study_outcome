package com.larus.im.internal.core;

import android.os.SystemClock;
import com.flow.kmp.common.util.CoroutineExtKt;
import com.flow.kmp.common.util.i;
import com.larus.im.FlowRuntime;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.callback.IMError;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.utils.w;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.a0;
import ouc.e0;
import ouc.j;

/* JADX INFO: loaded from: classes4.dex */
public abstract class IMActionProcessor<T, R> {
    private final String RootTag;
    private final CoroutineScope _scope;
    private long beginTime;
    private final IIMCallback<R> callback;
    private long endTime;
    private long networkDuration;
    private final T request;
    private boolean started;
    private final String traceId;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IMActionProcessor f347512a;

        public a(CoroutineExceptionHandler.Key r100, IMActionProcessor r101) {
            this.f347512a = r101;
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r110) {
            if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L6;
            com.larus.im.internal.delegate.a r101 = com.larus.im.internal.delegate.a.f348188b;
            StringBuilder r102 = new StringBuilder("processor invoke error , msg = ");
            Intrinsics.checkNotNullParameter(r110, "<this>");
            r102.append(ExceptionsKt.stackTraceToString(r110));
            r101.e("IMActionProcessor", r102.toString());
            this.f347512a.onFailure(new IMError(-3, r110.getMessage(), r110, null, 8, null));
            return;
        L6:
            throw r110;
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.IMActionProcessor$requestServer$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.IMActionProcessor", f = "IMActionProcessor.kt", i = {0}, l = {116}, m = "requestServer", n = {GearStrategyConsts.EV_SELECT_BEGIN}, s = {"J$0"})
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ IMActionProcessor<T, R> this$0;

        public AnonymousClass1(IMActionProcessor<T, R> r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.requestServer(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.IMActionProcessor$run$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.IMActionProcessor$run$1", f = "IMActionProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IMActionProcessor<T, R> this$0;

        public C114571(IMActionProcessor<T, R> r100, Continuation<? super C114571> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114571(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114571) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r100);
            if (FlowRuntime.d() == true) goto L7;
            final IMActionProcessor<T, R> r101 = this.this$0;
            FlowRuntime.e(new c(r101));
        L9:
            return Unit.INSTANCE;
        L7:
            this.this$0.run();
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.im.internal.core.IMActionProcessor$runInMainThread$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.IMActionProcessor$runInMainThread$1", f = "IMActionProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C114581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $block;
        int label;

        public C114581(Function0<Unit> r100, Continuation<? super C114581> r101) {
            this.$block = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C114581(this.$block, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C114581) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            this.$block.invoke();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Unit a(IMActionProcessor r100, IIMError r101) {
        return onFailure$lambda$2(r100, r101);
    }

    public static /* synthetic */ Unit b(IMActionProcessor r100, Object r101) {
        return onSuccess$lambda$1(r100, r101);
    }

    public abstract String getTAG();

    public abstract void process();

    public CoroutineScope getScope() {
        return CoroutineScopeKt.plus(this._scope, new a0(getTAG() + '_' + this.traceId));
    }

    public final void run() {
        if (FlowRuntime.d() == true) goto L5;
        CoroutineExtKt.a(new C114571(this, null));
        return;
    L5:
        this.beginTime = SystemClock.elapsedRealtime();
        com.larus.im.internal.delegate.a.f348188b.i(this.RootTag, "trigger " + getTAG() + ", traceId: " + this.traceId);
        process();
    }

    public IIMCallback<R> getOuterCallback() {
        return this.callback;
    }

    public T getRequest() {
        return this.request;
    }

    private final void reportProcessorFinish(IIMError r110) {
        if (this.beginTime != 0) goto L5;
        return;
    L5:
        if (this.endTime != 0) goto L28;
        this.endTime = SystemClock.elapsedRealtime();
        int r100 = com.larus.im.internal.tracking.c.f350315a;
        String r101 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        long r102 = this.endTime - this.beginTime;
        long r103 = this.networkDuration;
        boolean r104 = false;
        if (r110 != null) goto L13;
        int r105 = 0;
    L14:
        String r106 = null;
        if (r110 == null) goto L17;
        Integer r107 = Integer.valueOf(r110.getCode());
    L18:
        if (r110 == null) goto L20;
        r106 = r110.getTips();
    L20:
        Intrinsics.checkNotNullParameter(r101, "name");
        if (w.f350562a.nextInt(100) != 0) goto L23;
        r104 = true;
    L23:
        if (r104 == false) goto L29;
        e0 r108 = new e0();
        j.c(r108, "name", r101);
        j.b(r108, "duration", Long.valueOf(r102));
        j.b(r108, "network_duration", Long.valueOf(r103));
        j.b(r108, "status", Integer.valueOf(r105));
        j.b(r108, "error_code", r107);
        j.c(r108, GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r106);
        d1.f348206b.a("flow_imsdk_service_result", r108.a());
        return;
    L29:
        return;
    L17:
        r107 = null;
        goto L18
    L13:
        r105 = 1;
        goto L14
    }

    public void onFailure(final IIMError r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        reportProcessorFinish(r100);
        IIMCallback<R> r101 = this.callback;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L9;
        runInMainThread(new com.larus.im.internal.core.a(this, r100));
        return;
    L9:
        IIMCallback<R> r103 = this.callback;
        if (r103 == null) goto L14;
        r103.onFailure(r100);
        return;
    L14:
        return;
    L5:
        if (r101.mustInMain() != true) goto L7;
        r102 = true;
        goto L7
    }

    public void onSuccess(final R r100) {
        reportProcessorFinish(null);
        IIMCallback<R> r101 = this.callback;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L9;
        runInMainThread(new b(this, r100));
        return;
    L9:
        IIMCallback<R> r103 = this.callback;
        if (r103 == null) goto L14;
        r103.onSuccess(r100);
        return;
    L14:
        return;
    L5:
        if (r101.mustInMain() != true) goto L7;
        r102 = true;
        goto L7
    }

    public void runInMainThread(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        CoroutineExtKt.b(new C114581(r100, null));
    }

    public IMActionProcessor(T r100, IIMCallback<R> r101) {
        this.request = r100;
        this.callback = r101;
        this.RootTag = "FlowProcessor";
        this.traceId = i.a();
        this._scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new a(CoroutineExceptionHandler.Key, this)));
    }

    private static final Unit onFailure$lambda$2(IMActionProcessor r100, IIMError r101) {
        r100.callback.onFailure(r101);
        return Unit.INSTANCE;
    }

    private static final Unit onSuccess$lambda$1(IMActionProcessor r100, Object r101) {
        r100.callback.onSuccess(r101);
        return Unit.INSTANCE;
    }

    public final <T> Object requestServer(Function1<? super Continuation<? super T>, ? extends Object> r100, Continuation<? super T> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        long r107 = r102.J$0;
        ResultKt.throwOnFailure(r104);
    L18:
        this.networkDuration += SystemClock.elapsedRealtime() - r107;
        return r104;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        long r108 = SystemClock.elapsedRealtime();
        r102.J$0 = r108;
        r102.label = 1;
        r104 = r100.invoke(r102);
        if (r104 != r105) goto L17;
        return r105;
    L17:
        r107 = r108;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }

    public /* synthetic */ IMActionProcessor(Object r100, IIMCallback r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
