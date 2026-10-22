package com.larksuite.rucket.job;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.base.b;
import com.larksuite.rucket.job.extension.EmptyResultException;
import com.larksuite.rucket.job.extension.JobItrImpl;
import com.larksuite.rucket.job.impl.DataHolderRucketJob;
import com.larksuite.rucket.job.impl.FutureRucketJob;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.bduploader.BDVideoUploaderBase;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes24.dex */
public class RucketJobImpl<T> extends RucketJob<T> implements CoroutineScope {
    public static final a Companion = null;
    private static final String TAG = "RucketJob";
    private final Channel<b<T>> channel;
    private final ConcurrentLinkedQueue<Function2<b<? extends T>, Continuation<? super Unit>, Object>> consumerQueue;
    private final CoroutineContext coroutineContext;
    private Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> errorHandler;
    private final AtomicInteger idleConsumers;
    private int lastProduceIndex;
    private final ReentrantLock lock;
    private RucketJob<?> next;
    private ConcurrentLinkedQueue<b> pendingErrorBuffer;
    private ConcurrentLinkedQueue<b<T>> pendingResultBuffer;
    private RucketJob<?> prev;
    private Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> resolver;
    private final AtomicBoolean terminalFlag;

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$1", f = "RucketJobImpl.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public AnonymousClass1(RucketJobImpl<T> r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
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
            RucketJobImpl<T> r103 = this.this$0;
            this.label = 1;
            if (RucketJobImpl.access$consumeChannelData(r103, this) != r101) goto L12;
            return r101;
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$consumeChannelData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl", f = "RucketJobImpl.kt", i = {}, l = {BDVideoUploaderBase.KeyIsSkipCode2ndFileSize, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME}, m = "consumeChannelData", n = {}, s = {})
    public static final class C107661 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C107661(RucketJobImpl<T> r100, Continuation<? super C107661> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return RucketJobImpl.access$consumeChannelData(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$flatMap$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "data"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$flatMap$1", f = "RucketJobImpl.kt", i = {}, l = {VideoRef.VALUE_VIDEO_REF_AI_BARRAGE_URL}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107671 extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super RucketJob<V>>, Object> $h;
        final /* synthetic */ FutureRucketJob<V> $nextJobDelegate;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C107671(Function2<? super T, ? super Continuation<? super RucketJob<V>>, ? extends Object> r100, FutureRucketJob<V> r101, Continuation<? super C107671> r102) {
            this.$h = r100;
            this.$nextJobDelegate = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C107671 r102 = new C107671(this.$h, this.$nextJobDelegate, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(T r100, Continuation<? super Unit> r101) {
            return ((C107671) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to com.larksuite.rucket.job.RucketJobImpl$flatMap$1 for r3v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = r3.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L9;
            kotlin.ResultKt.throwOnFailure(r4);     // Catch: java.lang.Exception -> L7
        L15:
            com.larksuite.rucket.job.RucketJob r4 = (com.larksuite.rucket.job.RucketJob) r4;     // Catch: java.lang.Exception -> L7
        L18:
            com.larksuite.rucket.job.impl.FutureRucketJob<V> r0 = r3.$nextJobDelegate;
            com.larksuite.rucket.job.RucketJob<V> r4 = (com.larksuite.rucket.job.RucketJob<V>) r4;
            r0.b(r4);
            kotlin.Unit r4 = kotlin.Unit.INSTANCE;
            return r4;
        L9:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw r4;
        L11:
            kotlin.ResultKt.throwOnFailure(r4);
            java.lang.Object r4 = r3.L$0;
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super com.larksuite.rucket.job.RucketJob<V>>, java.lang.Object> r1 = r3.$h;     // Catch: java.lang.Exception -> L7
            r3.label = 1;     // Catch: java.lang.Exception -> L7
            T r4 = (T) r4;
            java.lang.Object r3 = (kotlin.coroutines.Continuation<? super com.larksuite.rucket.job.RucketJob<V>>) r3;
            r4 = r1.invoke(r4, r3);     // Catch: java.lang.Exception -> L7
            if (r4 != r0) goto L15;
            return r0;
        L7:
            r4 = move-exception;
            com.ss.android.lark.log.Log.i(com.larksuite.rucket.job.RucketJobImpl.TAG, "flatMap: there is an error occurred in IFlatMapHandler#invoke");
            com.larksuite.rucket.job.impl.ErrorHolderRucketJob r0 = new com.larksuite.rucket.job.impl.ErrorHolderRucketJob(r4);
            r4 = r0;
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$get$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larksuite/rucket/job/base/RucketResult;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$get$1", f = "RucketJobImpl.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b<? extends T>>, Object> {
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C107681(RucketJobImpl<T> r100, Continuation<? super C107681> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C107681(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Object r101) {
            return invoke(r100, (Continuation) r101);
        }

        public final Object invoke(CoroutineScope r100, Continuation<? super b<? extends T>> r101) {
            return ((C107681) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            RucketJobImpl<T> r103 = this.this$0;
            this.label = 1;
            r100 = r103.awaitGet(this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$map$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larksuite/rucket/job/RucketJob;", "D", ExifInterface.GPS_DIRECTION_TRUE, "data"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$map$1", f = "RucketJobImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107691<D> extends SuspendLambda implements Function2<T, Continuation<? super RucketJob<D>>, Object> {
        final /* synthetic */ Function1<T, D> $h;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C107691(Function1<? super T, ? extends D> r100, Continuation<? super C107691> r101) {
            this.$h = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C107691 r102 = new C107691(this.$h, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
            return invoke(r100, (Continuation) r101);
        }

        public final Object invoke(T r100, Continuation<? super RucketJob<D>> r101) {
            return ((C107691) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            Object r101 = this.L$0;
            return new DataHolderRucketJob(this.$h.invoke((T) r101));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$1", f = "RucketJobImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107701 extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $action;
        final /* synthetic */ CoroutineContext $context;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$1$1", f = "RucketJobImpl.kt", i = {}, l = {426}, m = "invokeSuspend", n = {}, s = {})
        public static final class C39371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $action;
            final /* synthetic */ T $it;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public C39371(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r100, T r101, Continuation<? super C39371> r102) {
                this.$action = r100;
                this.$it = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C39371(this.$action, this.$it, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C39371) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
                Function2<T, Continuation<? super Unit>, Object> r103 = this.$action;
                T r104 = this.$it;
                this.label = 1;
                if (r103.invoke(r104, this) != r101) goto L12;
                return r101;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C107701(RucketJobImpl<T> r100, CoroutineContext r101, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super C107701> r103) {
            this.this$0 = r100;
            this.$context = r101;
            this.$action = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C107701 r102 = new C107701(this.this$0, this.$context, this.$action, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(T r100, Continuation<? super Unit> r101) {
            return ((C107701) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            Object r101 = this.L$0;
            BuildersKt.launch$default(this.this$0, this.$context, null, new C39371(this.$action, r101, null), 2, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$2", f = "RucketJobImpl.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public AnonymousClass2(RucketJobImpl<T> r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            RucketJobImpl<T> r103 = this.this$0;
            this.label = 1;
            if (RucketJobImpl.access$produceAllResults(r103, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$1", f = "RucketJobImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107711 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<ErrorResult, Continuation<? super Unit>, Object> $action;
        final /* synthetic */ CoroutineContext $context;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$1$1", f = "RucketJobImpl.kt", i = {}, l = {438}, m = "invokeSuspend", n = {}, s = {})
        public static final class C39381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<ErrorResult, Continuation<? super Unit>, Object> $action;
            final /* synthetic */ ErrorResult $it;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public C39381(Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r100, ErrorResult r101, Continuation<? super C39381> r102) {
                this.$action = r100;
                this.$it = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C39381(this.$action, this.$it, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C39381) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
                Function2<ErrorResult, Continuation<? super Unit>, Object> r103 = this.$action;
                ErrorResult r104 = this.$it;
                this.label = 1;
                if (r103.invoke(r104, this) != r101) goto L12;
                return r101;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C107711(RucketJobImpl<T> r100, CoroutineContext r101, Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super C107711> r103) {
            this.this$0 = r100;
            this.$context = r101;
            this.$action = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C107711 r102 = new C107711(this.this$0, this.$context, this.$action, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ErrorResult r100, Continuation<? super Unit> r101) {
            return ((C107711) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ErrorResult r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            ErrorResult r101 = (ErrorResult) this.L$0;
            BuildersKt.launch$default(this.this$0, this.$context, null, new C39381(this.$action, r101, null), 2, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$2", f = "RucketJobImpl.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
    public static final class C107722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C107722(RucketJobImpl<T> r100, Continuation<? super C107722> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C107722(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C107722) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            RucketJobImpl<T> r103 = this.this$0;
            this.label = 1;
            if (RucketJobImpl.access$produceAllErrors(r103, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$produceAllErrors$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl", f = "RucketJobImpl.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS}, m = "produceAllErrors", n = {}, s = {})
    public static final class C107731 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C107731(RucketJobImpl<T> r100, Continuation<? super C107731> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return RucketJobImpl.access$produceAllErrors(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$produceAllResults$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl", f = "RucketJobImpl.kt", i = {}, l = {359}, m = "produceAllResults", n = {}, s = {})
    public static final class C107741 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C107741(RucketJobImpl<T> r100, Continuation<? super C107741> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return RucketJobImpl.access$produceAllResults(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$setError$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl", f = "RucketJobImpl.kt", i = {0}, l = {337, TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG}, m = "setError$suspendImpl", n = {"$this"}, s = {"L$0"})
    public static final class C107751<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C107751(RucketJobImpl<T> r100, Continuation<? super C107751> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return RucketJobImpl.setError$suspendImpl(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$setResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl", f = "RucketJobImpl.kt", i = {1}, l = {304, 315, 327}, m = "setResult$suspendImpl", n = {"$this"}, s = {"L$0"})
    public static final class C107761<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C107761(RucketJobImpl<T> r100, Continuation<? super C107761> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return RucketJobImpl.setResult$suspendImpl(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$toFlow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$toFlow$1", f = "RucketJobImpl.kt", i = {0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME, 270}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    public static final class C107771 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C107771(RucketJobImpl<T> r100, Continuation<? super C107771> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C107771 r102 = new C107771(this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
            return invoke((FlowCollector) r100, r101);
        }

        public final Object invoke(FlowCollector<? super T> r100, Continuation<? super Unit> r101) {
            return ((C107771) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0075 -> B:12:0x0041). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            com.larksuite.rucket.job.extension.a<b<T>> r103 = (com.larksuite.rucket.job.extension.a) this.L$1;
            FlowCollector r104 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r100);
        L11:
            C107771 r105 = this;
        L12:
            r105.L$0 = r104;
            r105.L$1 = r103;
            r105.label = 1;
            Object r106 = r103.hasNext(r105);
            if (r106 != r101) goto L15;
            return r101;
        L15:
            Object r107 = r101;
            C107771 r108 = r105;
            r100 = r106;
            FlowCollector r109 = r104;
            com.larksuite.rucket.job.extension.a<b<T>> r110 = r103;
            Object r111 = r107;
        L17:
            if (((Boolean) r100).booleanValue() == false) goto L31;
            b r112 = r110.a();
            if ((r112 instanceof b.c) == false) goto L25;
            T r113 = ((b.c) r112).f286079b;
            r108.L$0 = r109;
            r108.L$1 = r110;
            r108.label = 2;
            if (r109.emit(r113, r108) != r111) goto L23;
            return r111;
        L23:
            r105 = r108;
            r101 = r111;
            r103 = r110;
            r104 = r109;
            goto L12
        L25:
            if ((r112 instanceof b.C3939b) == false) goto L29;
            throw ((b.C3939b) r112).f286078b;
        L29:
            throw new NoWhenBranchMatchedException();
        L31:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            com.larksuite.rucket.job.extension.a<b<T>> r114 = (com.larksuite.rucket.job.extension.a) this.L$1;
            FlowCollector r115 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r100);
            r109 = r115;
            r110 = r114;
            r111 = r101;
            r108 = this;
            goto L17
        L10:
            ResultKt.throwOnFailure(r100);
            r104 = (FlowCollector) this.L$0;
            r103 = this.this$0.iterator();
            goto L11
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public Object awaitGet(Continuation<? super b<? extends T>> r100) {
        return awaitGet$suspendImpl(this, r100);
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public Object setError(ErrorResult r100, Continuation<? super Unit> r101) {
        return setError$suspendImpl(this, r100, r101);
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public Object setResult(T r100, Continuation<? super Unit> r101) {
        return setResult$suspendImpl(this, r100, r101);
    }

    private final boolean distributeAnIleConsumer() {
        int r100 = this.idleConsumers.get();
        if (r100 > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.idleConsumers.compareAndSet(r100, r100 - 1) == false) goto L7;
        return true;
    }

    private final b<T> produceNext() {
        int r100 = (this.lastProduceIndex + 1) % 2;
        this.lastProduceIndex = r100;
        if ((r100 % 2) != 0) goto L6;
        return this.pendingResultBuffer.poll();
    L6:
        return this.pendingErrorBuffer.poll();
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public void cancel() {
        if (this.terminalFlag.compareAndSet(false, true) == false) goto L11;
        Log.d(TAG, "rucketJob invoke cancel");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineScope");
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        this.resolver = null;
        this.errorHandler = null;
        this.pendingResultBuffer.clear();
        this.pendingErrorBuffer.clear();
        this.consumerQueue.clear();
        this.idleConsumers.set(0);
        RucketJob<?> r100 = nextJob();
        if (r100 == null) goto L7;
        r100.cancel();
    L7:
        RucketJob<?> r101 = prevJob();
        if (r101 == null) goto L12;
        r101.cancel();
        return;
    L12:
        return;
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public boolean isCanceled() {
        return this.terminalFlag.get();
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public com.larksuite.rucket.job.extension.a<b<T>> iterator() {
        return new JobItrImpl(this);
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public Flow<T> toFlow() {
        return new c1(new C107771(this, null));
    }

    public RucketJobImpl() {
        this.consumerQueue = new ConcurrentLinkedQueue();
        this.idleConsumers = new AtomicInteger(0);
        this.pendingResultBuffer = new ConcurrentLinkedQueue();
        this.pendingErrorBuffer = new ConcurrentLinkedQueue();
        this.terminalFlag = new AtomicBoolean(false);
        this.lock = new ReentrantLock();
        this.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.coroutineContext = Dispatchers.getUnconfined().plus(SupervisorKt.SupervisorJob$default(null, 1, null));
        BuildersKt.launch$default(this, null, null, new AnonymousClass1(this, null), 3, null);
        this.lastProduceIndex = 1;
    }

    private final b<T> tryProduceImmediately() {
        b<T> r100 = produceNext();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return produceNext();
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public b<T> get() {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == true) goto L7;
        return (b) BuildersKt.runBlocking$default(null, new C107681(this, null), 1, null);
    L7:
        throw new Error("You should not call method 'get' on main thread , this action may block thw main thread and will cause ANR !!!");
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public RucketJob<?> nextJob() {
        return this.next;
    }

    public RucketJob<?> prevJob() {
        return this.prev;
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getConsumerQueue$p(RucketJobImpl r100) {
        return r100.consumerQueue;
    }

    public static final /* synthetic */ AtomicInteger access$getIdleConsumers$p(RucketJobImpl r100) {
        return r100.idleConsumers;
    }

    public static final /* synthetic */ ReentrantLock access$getLock$p(RucketJobImpl r100) {
        return r100.lock;
    }

    public static final /* synthetic */ b access$tryProduceImmediately(RucketJobImpl r100) {
        return r100.tryProduceImmediately();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008c -> B:21:0x0053). Please report as a decompilation issue!!! */
    private final Object consumeChannelData(Continuation<? super Unit> r110) {
        if ((r110 instanceof C107661) == false) goto L7;
        C107661 r100 = (C107661) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L19;
        if (r103 == 1) goto L18;
        if (r103 == 2) goto L17;
        if (r103 == 3) goto L17;
        if (r103 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ChannelIterator<b<T>> r104 = (ChannelIterator) r100.L$0;
        ResultKt.throwOnFailure(r111);
        ChannelIterator<b<T>> r112 = r104;
    L20:
        RucketJobImpl r105 = this;
    L21:
        r100.L$0 = r112;
        r100.label = 1;
        Object r106 = r112.hasNext(r100);
        if (r106 != r102) goto L24;
        return r102;
    L24:
        RucketJobImpl r113 = r105;
        ChannelIterator<b<T>> r107 = r112;
        r111 = r106;
        RucketJobImpl r108 = r113;
    L26:
        if (((Boolean) r111).booleanValue() == false) goto L46;
        b<T> r114 = r107.next();
        Function2<b<? extends T>, Continuation<? super Unit>, Object> r109 = r108.consumerQueue.poll();
        if (r109 == null) goto L34;
        Log.d(TAG, "consumeChannelData: There is a suspended coroutine is waiting for the result, now resume this coroutine");
        r100.L$0 = r107;
        r100.label = 2;
        if (r109.invoke(r114, r100) != r102) goto L32;
        return r102;
    L32:
        r112 = r107;
        r105 = r108;
        goto L21
    L34:
        if ((r114 instanceof b.c) == false) goto L39;
        T r115 = ((b.c) r114).f286079b;
        r100.L$0 = r107;
        r100.label = 3;
        if (r108.handleConsumeResult(r115, r100) != r102) goto L32;
        return r102;
    L39:
        if ((r114 instanceof b.C3939b) == false) goto L44;
        ErrorResult r116 = ((b.C3939b) r114).f286078b;
        r100.L$0 = r107;
        r100.label = 4;
        if (r108.handleConsumeError(r116, r100) != r102) goto L32;
        return r102;
    L44:
        throw new NoWhenBranchMatchedException();
    L46:
        return Unit.INSTANCE;
    L18:
        r107 = (ChannelIterator) r100.L$0;
        ResultKt.throwOnFailure(r111);
        r108 = this;
        goto L26
    L19:
        ResultKt.throwOnFailure(r111);
        r112 = this.channel.iterator();
    L7:
        r100 = new C107661(this, r110);
        goto L8
    }

    private final Object produceAllErrors(Continuation<? super Unit> r100) {
        if ((r100 instanceof C107731) == false) goto L7;
        C107731 r101 = (C107731) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 == 1) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
    L16:
        if (this.pendingErrorBuffer.isEmpty() == true) goto L21;
        r101.label = 1;
        if (produceErrorOnce(r101) != r104) goto L16;
        return r104;
    L21:
        return Unit.INSTANCE;
    L7:
        r101 = new C107731(this, r100);
        goto L8
    }

    private final Object produceAllResults(Continuation<? super Unit> r100) {
        if ((r100 instanceof C107741) == false) goto L7;
        C107741 r101 = (C107741) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 == 1) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
    L16:
        if (this.pendingResultBuffer.isEmpty() == true) goto L21;
        distributeAnIleConsumer();
        r101.label = 1;
        if (produceResultOnce(r101) != r104) goto L16;
        return r104;
    L21:
        return Unit.INSTANCE;
    L7:
        r101 = new C107741(this, r100);
        goto L8
    }

    private final Object produceErrorOnce(Continuation<? super Unit> r100) {
        b<T> r101 = this.pendingErrorBuffer.poll();
        if (r101 == null) goto L8;
        Object r102 = this.channel.send(r101, r100);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r102;
    L8:
        return Unit.INSTANCE;
    }

    private final Object produceResultOnce(Continuation<? super Unit> r100) {
        b<T> r101 = this.pendingResultBuffer.poll();
        if (r101 == null) goto L8;
        Object r102 = this.channel.send(r101, r100);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r102;
    L8:
        return Unit.INSTANCE;
    }

    @Override // com.larksuite.rucket.job.base.a
    public void setNextJob(RucketJob<?> r100) {
        this.next = r100;
    }

    @Override // com.larksuite.rucket.job.base.a
    public void setPrevJob(RucketJob<?> r100) {
        this.prev = r100;
    }

    public static final /* synthetic */ Object access$consumeChannelData(RucketJobImpl r100, Continuation r101) {
        return r100.consumeChannelData(r101);
    }

    public static final /* synthetic */ Object access$produceAllErrors(RucketJobImpl r100, Continuation r101) {
        return r100.produceAllErrors(r101);
    }

    public static final /* synthetic */ Object access$produceAllResults(RucketJobImpl r100, Continuation r101) {
        return r100.produceAllResults(r101);
    }

    public static final /* synthetic */ Object access$produceErrorOnce(RucketJobImpl r100, Continuation r101) {
        return r100.produceErrorOnce(r101);
    }

    public static final /* synthetic */ Object access$produceResultOnce(RucketJobImpl r100, Continuation r101) {
        return r100.produceResultOnce(r101);
    }

    public static <T> Object awaitGet$suspendImpl(final RucketJobImpl<T> r100, Continuation<? super b<? extends T>> r101) {
        if (r100.isCanceled() == false) goto L6;
        int r102 = b.f286077a;
        return new b.C3939b(new ErrorResult("RucketJob has been canceled!"));
    L6:
        final j r103 = new j(IntrinsicsKt.intercepted(r101), 1);
        r103.C();
        access$getLock$p(r100).lock();     // Catch: Throwable -> L20
        final b r104 = access$tryProduceImmediately(r100);     // Catch: Throwable -> L20
        if (r104 == null) goto L11;
        Log.d(TAG, "awaitGet: pending result is not null, now return it directly.");     // Catch: Throwable -> L20
        Function0<Unit> r105 = new RucketJobImpl$awaitGet$2$1(r103, r104);     // Catch: Throwable -> L20
    L13:
        access$getLock$p(r100).unlock();
        if (r105 == null) goto L16;
        r105.invoke();
    L16:
        Object r106 = r103.B();
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L19:
        return r106;
    L11:
        access$getIdleConsumers$p(r100).incrementAndGet();     // Catch: Throwable -> L20
        access$getConsumerQueue$p(r100).add(new RucketJobImpl$awaitGet$2$2(r103, null));     // Catch: Throwable -> L20
        r103.i(new RucketJobImpl$awaitGet$2$3(r100));     // Catch: Throwable -> L20
        Log.d(TAG, "awaitGet: pending result is null, now suspend current coroutine.");     // Catch: Throwable -> L20
        r105 = null;
    L20:
        th = move-exception;
        access$getLock$p(r100).unlock();
        throw th;
    }

    private final Object handleConsumeError(ErrorResult r100, Continuation<? super Unit> r101) {
        Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r102 = this.errorHandler;
        if (r102 == null) goto L10;
        if (r102 == null) goto L18;
        Object r103 = r102.invoke(r100, r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r103;
    L9:
        return Unit.INSTANCE;
    L18:
        return Unit.INSTANCE;
    L10:
        RucketJob<?> r104 = nextJob();
        if (r104 == null) goto L18;
        Object r105 = r104.setError(r100, r101);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        return r105;
    L16:
        return Unit.INSTANCE;
    }

    private final Object handleConsumeResult(T r100, Continuation<? super Unit> r101) {
        Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r102 = this.resolver;
        if (r102 == null) goto L10;
        Object r103 = r102.invoke(r100, r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r103;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    private final void onDataPrepared(CoroutineContext r100, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r110) {
        if (isCanceled() == false) goto L5;
        return;
    L5:
        this.resolver = new C107701(this, r100, r110, null);
        BuildersKt.launch$default(this, null, null, new AnonymousClass2(this, null), 3, null);
    }

    private final void onErrorOccurred(CoroutineContext r100, Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r110) {
        if (isCanceled() == false) goto L5;
        return;
    L5:
        this.errorHandler = new C107711(this, r100, r110, null);
        BuildersKt.launch$default(this, null, null, new C107722(this, null), 3, null);
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public RucketJob<T> error(CoroutineContext r100, Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "h");
        onErrorOccurred(r100, new RucketJobImpl$error$1$1(r101, null));
        return this;
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public <V> RucketJob<V> flatMap(CoroutineContext r100, Function2<? super T, ? super Continuation<? super RucketJob<V>>, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "h");
        FutureRucketJob r102 = new FutureRucketJob();
        setNextJob(r102);
        r102.setPrevJob(this);
        onDataPrepared(r100, new C107671(r101, r102, null));
        return r102;
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public <D> RucketJob<D> map(CoroutineContext r100, Function1<? super T, ? extends D> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "h");
        return (RucketJob<D>) flatMap(r100, new C107691(r101, null));
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public RucketJob<T> then(CoroutineContext r100, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "h");
        onDataPrepared(r100, new RucketJobImpl$then$1$1(r101, null));
        return this;
    }

    public static final /* synthetic */ Object access$handleConsumeError(RucketJobImpl r100, ErrorResult r101, Continuation r102) {
        return r100.handleConsumeError(r101, r102);
    }

    public static final /* synthetic */ Object access$handleConsumeResult(RucketJobImpl r100, Object r101, Continuation r102) {
        return r100.handleConsumeResult(r101, r102);
    }

    public static /* synthetic */ <T> Object setError$suspendImpl(RucketJobImpl<T> r100, ErrorResult r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof C107751) == false) goto L7;
        C107751 r103 = (C107751) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L18;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L41:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (RucketJobImpl) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L42
    L28:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L42
        ((RucketJobImpl) r100).lock.unlock();
        return r108;
    L18:
        ResultKt.throwOnFailure(r105);
        if (r100.isCanceled() == true) goto L21;
        ((RucketJobImpl) r100).lock.lock();     // Catch: Throwable -> L42
        ((RucketJobImpl) r100).pendingErrorBuffer.add(new b.C3939b(r101));     // Catch: Throwable -> L42
        if (r100.distributeAnIleConsumer() == false) goto L31;
        Log.d(TAG, "setResult: There is a suspended coroutine is waiting for the error, produce once.");     // Catch: Throwable -> L42
        r103.L$0 = r100;     // Catch: Throwable -> L42
        r103.label = 1;     // Catch: Throwable -> L42
        if (r100.produceErrorOnce(r103) != r106) goto L28;
        return r106;
    L31:
        ((RucketJobImpl) r100).lock.unlock();
        if (((RucketJobImpl) r100).errorHandler == null) goto L34;
    L37:
        r103.label = 2;
        if (r100.produceAllErrors(r103) != r106) goto L41;
        return r106;
    L34:
        if (r100.nextJob() != null) goto L37;
        Log.d(TAG, "setError: There is no resolver and also next job is null, just return.");
        return Unit.INSTANCE;
    L21:
        return Unit.INSTANCE;
    L42:
        th = move-exception;
        ((RucketJobImpl) r100).lock.unlock();
        throw th;
    L7:
        r103 = new C107751(r100, r102);
        goto L8
    }

    public static /* synthetic */ <T> Object setResult$suspendImpl(RucketJobImpl<T> r100, T r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof C107761) == false) goto L7;
        C107761 r103 = (C107761) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L22;
        if (r107 == 1) goto L21;
        if (r107 == 2) goto L16;
        if (r107 != 3) goto L15;
        ResultKt.throwOnFailure(r105);
    L46:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r100 = (RucketJobImpl) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L19
    L38:
        ((RucketJobImpl) r100).lock.unlock();
        if (((RucketJobImpl) r100).resolver != null) goto L42;
        Log.d(TAG, "setResult: There is no resolver, just return.");
        return Unit.INSTANCE;
    L42:
        r103.L$0 = null;
        r103.label = 3;
        if (r100.produceAllResults(r103) != r106) goto L46;
        return r106;
    L21:
        ResultKt.throwOnFailure(r105);
    L28:
        return Unit.INSTANCE;
    L22:
        ResultKt.throwOnFailure(r105);
        if (r101 != null) goto L30;
        EmptyResultException r108 = new EmptyResultException();
        r103.label = 1;
        if (r100.setError(r108, r103) != r106) goto L28;
        return r106;
    L30:
        if (r100.isCanceled() == true) goto L32;
        ((RucketJobImpl) r100).lock.lock();     // Catch: Throwable -> L19
        ((RucketJobImpl) r100).pendingResultBuffer.add(new b.c(r101));     // Catch: Throwable -> L19
        if (r100.distributeAnIleConsumer() == false) goto L38;
        Log.d(TAG, "setResult: There is a suspended coroutine is waiting for the result, produce once.");     // Catch: Throwable -> L19
        r103.L$0 = r100;     // Catch: Throwable -> L19
        r103.label = 2;     // Catch: Throwable -> L19
        if (r100.produceResultOnce(r103) != r106) goto L38;
        return r106;
    L32:
        return Unit.INSTANCE;
    L19:
        th = move-exception;
        ((RucketJobImpl) r100).lock.unlock();
        throw th;
    L7:
        r103 = new C107761(r100, r102);
        goto L8
    }
}
