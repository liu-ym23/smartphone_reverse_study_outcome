package com.obric.assistant.performance;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricThresholdDumpHprofConfig;
import com.obric.assistant.t1;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/performance/ObricThresholdDumpHprofServiceImpl;", "Lcom/obric/assistant/performance/IObricThresholdDumpHprofService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dumpJob", "Lkotlinx/coroutines/Job;", "hasDumped", "", "init", "", "loopCheckAndDump", "config", "Lcom/obric/assistant/ObricThresholdDumpHprofConfig;", "(Lcom/obric/assistant/ObricThresholdDumpHprofConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dumpHprof", "usedMemory", "", "maxMemory", "usedPercent", "threshold", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricThresholdDumpHprofServiceImpl implements IObricThresholdDumpHprofService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f391025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f391026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f391027d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.performance.ObricThresholdDumpHprofServiceImpl$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.performance.ObricThresholdDumpHprofServiceImpl$init$1", f = "ObricThresholdDumpHprofServiceImpl.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricThresholdDumpHprofServiceImpl this$0;

        public AnonymousClass1(ObricThresholdDumpHprofServiceImpl r100, Continuation<? super AnonymousClass1> r101) {
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
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L11;
            if (r101 != 1) goto L10;
            ResultKt.throwOnFailure(r110);     // Catch: Exception -> L7 CancellationException -> L20
        L22:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r110);
            ObricThresholdDumpHprofConfig r111 = t1.f393353a.getObricThresholdDumpHprofConfig();     // Catch: Exception -> L7 CancellationException -> L20
            FLogger r102 = FLogger.f375446a;     // Catch: Exception -> L7 CancellationException -> L20
            r102.i("ObricThresholdDumpHprofServiceImpl", "init, config=" + r111 + ", localDefault=" + new ObricThresholdDumpHprofConfig(false, 0, 0, 7, null));     // Catch: Exception -> L7 CancellationException -> L20
            if (r111.getEnableHprofDump() == true) goto L16;
            r102.i("ObricThresholdDumpHprofServiceImpl", "init ignored, hprof dump disabled");     // Catch: Exception -> L7 CancellationException -> L20
            return Unit.INSTANCE;
        L16:
            ObricThresholdDumpHprofServiceImpl r103 = this.this$0;     // Catch: Exception -> L7 CancellationException -> L20
            this.label = 1;     // Catch: Exception -> L7 CancellationException -> L20
            if (ObricThresholdDumpHprofServiceImpl.a(r103, r111, this) != r100) goto L22;
            return r100;
        L20:
            FLogger.f375446a.i("ObricThresholdDumpHprofServiceImpl", "init job cancelled");
        L7:
            e = move-exception;
            FLogger.f375446a.e("ObricThresholdDumpHprofServiceImpl", "init error: " + e);
            goto L22
        }
    }

    static {
    }

    @Override // com.obric.assistant.performance.IObricThresholdDumpHprofService
    public final void init() {
        Job r100 = this.f391026c;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        Boolean r102 = null;
        if (r101 == false) goto L10;
    L17:
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("init ignored, jobActive=");
        Job r105 = this.f391026c;
        if (r105 == null) goto L20;
        r102 = Boolean.valueOf(r105.isActive());
    L20:
        r104.append(r102);
        r104.append(", hasDumped=");
        r104.append(this.f391027d);
        r103.i("ObricThresholdDumpHprofServiceImpl", r104.toString());
        return;
    L10:
        if (this.f391027d == true) goto L17;
        Job r106 = this.f391026c;
        if (r106 == null) goto L15;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L15:
        this.f391026c = BuildersKt.launch$default(this.f391025b, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L5:
        if (r100.isActive() != true) goto L7;
        r101 = true;
        goto L7
    }

    public ObricThresholdDumpHprofServiceImpl() {
        this.f391025b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0071 -> B:22:0x0075). Please report as a decompilation issue!!! */
    public static final Object a(ObricThresholdDumpHprofServiceImpl r110, ObricThresholdDumpHprofConfig r111, Continuation r210) {
        r110.getClass();
        if ((r210 instanceof ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1) == false) goto L7;
        ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1 r100 = (ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
        ObricThresholdDumpHprofServiceImpl r102 = r110;
    L8:
        Object r103 = r100.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r100.label;
        int r106 = 100;
        int r107 = 1;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r108 = r100.I$0;
        long r109 = r100.J$0;
        ResultKt.throwOnFailure(r103);
    L22:
        Runtime r112 = Runtime.getRuntime();
        long r113 = r112.maxMemory();
        long r114 = r112.totalMemory() - r112.freeMemory();
        if (r113 > 0) goto L25;
        FLogger.f375446a.w("ObricThresholdDumpHprofServiceImpl", "skip check, invalid maxMemory=" + r113);
    L36:
        r100 = r100;
        r104 = r104;
        r109 = r109;
        r106 = 100;
        r107 = 1;
    L16:
        if (JobKt.isActive(r100.getContext()) == false) goto L38;
        if (r102.f391027d == true) goto L38;
        r100.J$0 = r109;
        r100.I$0 = r108;
        r100.label = r107;
        if (DelayKt.delay(r109, r100) != r104) goto L22;
        return r104;
    L38:
        return Unit.INSTANCE;
    L25:
        long r115 = (((long) r106) * r114) / r113;
        FLogger r116 = FLogger.f375446a;
        r116.d("ObricThresholdDumpHprofServiceImpl", "check java heap, used=" + r114 + ", max=" + r113 + ", percent=" + r115 + ", threshold=" + r108);
        if (r115 < r108) goto L36;
        if (r102.f391027d == true) goto L41;
        r102.f391027d = true;
        r116.i("ObricThresholdDumpHprofServiceImpl", "dump hprof start, used=" + r114 + ", max=" + r113 + ", percent=" + r115 + ", threshold=" + r108);     // Catch: Exception -> L33
        s17.d.f().d(System.currentTimeMillis(), 2);     // Catch: Exception -> L33
        r116.i("ObricThresholdDumpHprofServiceImpl", "dump hprof triggered");     // Catch: Exception -> L33
    L33:
        e = move-exception;
        FLogger.f375446a.e("ObricThresholdDumpHprofServiceImpl", "dump hprof error: " + e);
    L41:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r109 = ((long) RangesKt.coerceAtLeast(r111.getHprofDumpInterval(), 1)) * 1000;
        r108 = RangesKt.coerceIn(r111.getHprofDumpThreshold(), 1, 100);
    L7:
        r102 = r110;
        r100 = new ObricThresholdDumpHprofServiceImpl$loopCheckAndDump$1(r102, r210);
        goto L8
    }
}
