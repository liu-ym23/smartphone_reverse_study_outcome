package com.larksuite.rucket.job;

import androidx.exifinterface.media.ExifInterface;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.base.a;
import com.larksuite.rucket.job.compat.b;
import com.larksuite.rucket.job.compat.c;
import com.larksuite.rucket.job.compat.d;
import com.larksuite.rucket.job.compat.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes24.dex */
public abstract class RucketJob<T> implements a<RucketJob<?>> {

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJob$error$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJob$error$1", f = "RucketJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
        final /* synthetic */ b<T> $h;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RucketJob<T> this$0;

        public AnonymousClass1(b<T> r100, RucketJob<T> r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(null, this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ErrorResult r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ErrorResult r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L5;
            ResultKt.throwOnFailure(r100);
            ErrorResult r101 = (ErrorResult) this.L$0;
            throw null;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJob$flatMap$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larksuite/rucket/job/RucketJob;", "V", ExifInterface.GPS_DIRECTION_TRUE, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJob$flatMap$1", f = "RucketJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107631<V> extends SuspendLambda implements Function2<T, Continuation<? super RucketJob<V>>, Object> {
        final /* synthetic */ d<T, V> $h;
        /* synthetic */ Object L$0;
        int label;

        public C107631(d<T, V> r100, Continuation<? super C107631> r101) {
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C107631 r102 = new C107631(null, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
            return invoke(r100, (Continuation) r101);
        }

        public final Object invoke(T r100, Continuation<? super RucketJob<V>> r101) {
            return ((C107631) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L5;
            ResultKt.throwOnFailure(r100);
            throw null;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJob$then$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJob$then$1", f = "RucketJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107651 extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        final /* synthetic */ e<T> $h;
        /* synthetic */ Object L$0;
        int label;

        public C107651(e<T> r100, Continuation<? super C107651> r101) {
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C107651 r102 = new C107651(null, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(T r100, Continuation<? super Unit> r101) {
            return ((C107651) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L5;
            ResultKt.throwOnFailure(r100);
            throw null;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RucketJob() {
    }

    public abstract Object awaitGet(Continuation<? super com.larksuite.rucket.job.base.b<? extends T>> r100);

    public abstract void cancel();

    public final RucketJob<T> error(b<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "h");
        return error$default(this, null, r100, 1, null);
    }

    public abstract RucketJob<T> error(CoroutineContext r100, Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r101);

    public final <V> RucketJob<V> flatMap(d<T, V> r100) {
        Intrinsics.checkNotNullParameter(r100, "h");
        return flatMap$default(this, null, r100, 1, null);
    }

    public abstract <U> RucketJob<U> flatMap(CoroutineContext r100, Function2<? super T, ? super Continuation<? super RucketJob<U>>, ? extends Object> r101);

    public abstract com.larksuite.rucket.job.base.b<T> get();

    public abstract boolean isCanceled();

    public abstract com.larksuite.rucket.job.extension.a<com.larksuite.rucket.job.base.b<T>> iterator();

    public final <D> RucketJob<D> map(c<T, D> r100) {
        Intrinsics.checkNotNullParameter(r100, "h");
        return map$default(this, null, r100, 1, null);
    }

    public abstract <D> RucketJob<D> map(CoroutineContext r100, Function1<? super T, ? extends D> r101);

    public abstract Object setError(ErrorResult r100, Continuation<? super Unit> r101);

    public abstract Object setResult(T r100, Continuation<? super Unit> r101);

    public final RucketJob<T> then(e<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "h");
        return then$default(this, null, r100, 1, null);
    }

    public abstract RucketJob<T> then(CoroutineContext r100, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r101);

    public abstract Flow<T> toFlow();

    public final RucketJob<T> error(CoroutineContext r100, b<T> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "h");
        return error(r100, new AnonymousClass1(r101, this, null));
    }

    public final <V> RucketJob<V> flatMap(CoroutineContext r100, d<T, V> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "h");
        return (RucketJob<V>) flatMap(r100, new C107631(r101, null));
    }

    public final <D> RucketJob<D> map(CoroutineContext r100, final c<T, D> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "h");
        return map(r100, new C107641(r101));
    }

    public final RucketJob<T> then(CoroutineContext r100, e<T> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "h");
        return then(r100, new C107651(r101, null));
    }

    public static /* synthetic */ RucketJob error$default(RucketJob r100, CoroutineContext r101, b r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = Dispatchers.getUnconfined();
    L7:
        return r100.error(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
    }

    public static /* synthetic */ RucketJob flatMap$default(RucketJob r100, CoroutineContext r101, d r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = Dispatchers.getUnconfined();
    L7:
        return r100.flatMap(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatMap");
    }

    public static /* synthetic */ RucketJob map$default(RucketJob r100, CoroutineContext r101, c r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = Dispatchers.getUnconfined();
    L7:
        return r100.map(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: map");
    }

    public static /* synthetic */ RucketJob then$default(RucketJob r100, CoroutineContext r101, e r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = Dispatchers.getUnconfined();
    L7:
        return r100.then(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: then");
    }

    public static /* synthetic */ RucketJob error$default(RucketJob r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = Dispatchers.getUnconfined();
    L7:
        return r100.error(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
    }

    public static /* synthetic */ RucketJob flatMap$default(RucketJob r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = Dispatchers.getUnconfined();
    L7:
        return r100.flatMap(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatMap");
    }

    public static /* synthetic */ RucketJob map$default(RucketJob r100, CoroutineContext r101, Function1 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = Dispatchers.getUnconfined();
    L7:
        return r100.map(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: map");
    }

    public static /* synthetic */ RucketJob then$default(RucketJob r100, CoroutineContext r101, Function2 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r101 = Dispatchers.getUnconfined();
    L7:
        return r100.then(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: then");
    }
}
