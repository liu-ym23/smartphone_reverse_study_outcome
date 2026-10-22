package com.obric.aivoice.core.utils;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.v;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a.\u0010\u0006\u001a\u00020\u00052\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0000ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a<\u0010\r\u001a\u00020\f*\u00020\b2#\b\u0004\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00020\u0000H\u0086Hø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a?\u0010\u0012\u001a\u00020\u0002\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u000f*\u00020\f2!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\fø\u0001\u0001\u001a3\u0010\u0013\u001a\u00020\u0002*\u00020\f2!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\fø\u0001\u0001\u001a?\u0010\u0014\u001a\u00020\f\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u000f*\u00020\f2!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00020\u0000H\u0086\fø\u0001\u0001\u001a\u001e\u0010\u0016\u001a\u00020\u0002*\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0086\fø\u0001\u0001\"\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "block", "Lkotlinx/coroutines/Job;", "listenConnectionChanged", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ParameterName;", "name", "it", "Lcom/obric/aivoice/core/utils/TryRunResult;", "tryBinder", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", ExifInterface.GPS_DIRECTION_TRUE, "t", "catch", "catchAll", "catching", "Lkotlin/Function0;", "finally", "Lkotlinx/coroutines/flow/z0;", "", "connStatusEvent", "Lkotlinx/coroutines/flow/z0;", "getConnStatusEvent", "()Lkotlinx/coroutines/flow/z0;", "voicesdk_release"}, k = 2, mv = {1, 7, 1})
public final class TryExtKt {
    private static final z0<Boolean> connStatusEvent = null;

    /* JADX INFO: renamed from: com.obric.aivoice.core.utils.TryExtKt$listenConnectionChanged$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.aivoice.core.utils.TryExtKt$listenConnectionChanged$1", f = "TryExt.kt", i = {}, l = {15}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX INFO: renamed from: com.obric.aivoice.core.utils.TryExtKt$listenConnectionChanged$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "emit", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class C45881<T> implements FlowCollector {
            final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;

            /* JADX WARN: Multi-variable type inference failed */
            public C45881(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
                this.$block = r100;
            }

            public final Object emit(boolean r100, Continuation<? super Unit> r101) {
                if ((r101 instanceof TryExtKt$listenConnectionChanged$1$1$emit$1) == false) goto L7;
                TryExtKt$listenConnectionChanged$1$1$emit$1 r102 = (TryExtKt$listenConnectionChanged$1$1$emit$1) r101;
                int r103 = r102.label;
                if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
                r102.label = r103 - Integer.MIN_VALUE;
            L8:
                Object r104 = r102.result;
                Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r106 = r102.label;
                if (r106 == 0) goto L14;
                if (r106 != 1) goto L12;
                ResultKt.throwOnFailure(r104);
            L20:
                throw new CancellationException("disconnection posted.");
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r104);
                if (r100 == true) goto L22;
                Function1<Continuation<? super Unit>, Object> r107 = this.$block;
                r102.label = 1;
                if (r107.invoke(r102) != r105) goto L20;
                return r105;
            L22:
                return Unit.INSTANCE;
            L7:
                r102 = new TryExtKt$listenConnectionChanged$1$1$emit$1(this, r101);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
                return emit(((Boolean) r100).booleanValue(), r101);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super AnonymousClass1> r101) {
            this.$block = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$block, r101);
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
            v r103 = e.p(TryExtKt.getConnStatusEvent(), 1);
            C45881 r104 = new C45881(this.$block);
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.aivoice.core.utils.TryExtKt$tryBinder$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 176)
    @DebugMetadata(c = "com.obric.aivoice.core.utils.TryExtKt", f = "TryExt.kt", i = {}, l = {31}, m = "tryBinder", n = {}, s = {})
    public static final class C116181 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C116181(Continuation<? super C116181> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return TryExtKt.tryBinder(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.obric.aivoice.core.utils.TryExtKt$tryBinder$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "emit", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 176)
    public static final class AnonymousClass2<T> implements FlowCollector {
        public static final AnonymousClass2<T> INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return emit(((Boolean) r100).booleanValue(), r101);
        }

        public final Object emit(boolean r100, Continuation<? super Unit> r101) {
            throw new BinderCloseException();
        }
    }

    static {
        connStatusEvent = j1.a(Boolean.FALSE);
    }

    public static final z0<Boolean> getConnStatusEvent() {
        return connStatusEvent;
    }

    public static final Job listenConnectionChanged(Function1<? super Continuation<? super Unit>, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        return BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(r100, null), 3, null);
    }

    /* JADX INFO: renamed from: catch, reason: not valid java name */
    public static final /* synthetic */ <T extends Throwable> void m8577catch(TryRunResult r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        if ((r100.getThrowable() instanceof CancellationException) == true) goto L13;
        Throwable r102 = r100.getThrowable();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((r102 instanceof Throwable) == false) goto L8;
        r101.invoke(r100.getThrowable());
        return;
    L8:
        if (r100.getThrowable() != null) goto L11;
        return;
    L11:
        throw r100.getThrowable();
    L13:
        throw r100.getThrowable();
    }

    public static final void catchAll(TryRunResult r100, Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        if ((r100.getThrowable() instanceof CancellationException) == true) goto L9;
        if (r100.getThrowable() == null) goto L10;
        r101.invoke(r100.getThrowable());
        return;
    L10:
        return;
    L9:
        throw r100.getThrowable();
    }

    public static final /* synthetic */ <T extends Throwable> TryRunResult catching(TryRunResult r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        Throwable r102 = r100.getThrowable();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((r102 instanceof Throwable) == false) goto L6;
        r101.invoke(r100.getThrowable());
        return new TryRunResult(null);
    L6:
        return r100;
    }

    /* JADX INFO: renamed from: finally, reason: not valid java name */
    public static final void m8578finally(TryRunResult r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        r101.invoke();
        if (r100.getThrowable() != null) goto L6;
        return;
    L6:
        throw r100.getThrowable();
    }

    public static final Object tryBinder(CoroutineScope r100, Function1<? super CoroutineScope, Unit> r101, Continuation<? super TryRunResult> r102) {
        if ((r102 instanceof C116181) == false) goto L7;
        C116181 r103 = (C116181) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L12;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L21
    L20:
        throw new KotlinNothingValueException();     // Catch: Throwable -> L21
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        r101.invoke(r100);     // Catch: Throwable -> L21
        z0<Boolean> r108 = getConnStatusEvent();     // Catch: Throwable -> L21
        FlowCollector<? super Boolean> r109 = AnonymousClass2.INSTANCE;     // Catch: Throwable -> L21
        r103.label = 1;     // Catch: Throwable -> L21
        if (r108.collect(r109, r103) != r106) goto L20;
        return r106;
    L21:
        th = move-exception;
        return new TryRunResult(th);
    L7:
        r103 = new C116181(r102);
        goto L8
    }

    private static final Object tryBinder$$forInline(CoroutineScope r100, Function1<? super CoroutineScope, Unit> r101, Continuation<? super TryRunResult> r102) {
        r101.invoke(r100);     // Catch: Throwable -> L4
        z0<Boolean> r103 = getConnStatusEvent();     // Catch: Throwable -> L4
        FlowCollector<? super Boolean> r104 = AnonymousClass2.INSTANCE;     // Catch: Throwable -> L4
        InlineMarker.mark(0);     // Catch: Throwable -> L4
        r103.collect(r104, r102);     // Catch: Throwable -> L4
        InlineMarker.mark(1);     // Catch: Throwable -> L4
        throw new KotlinNothingValueException();     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        return new TryRunResult(th);
    }
}
