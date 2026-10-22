package com.obric.assistant.state.impl.multitask.producer;

import aha.b0;
import aha.c0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.update.api.v2.IObricUpdateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0013\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0016\u0010\u001e\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006#"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/SelfUpdateDownloadStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "updateService", "Lcom/obric/update/api/v2/IObricUpdateService;", "activeHandle", "Lcom/obric/assistant/state/multitask/core/TaskHandle;", "Lcom/obric/assistant/state/api/multitask/state/SelfUpdateDownloadTaskState;", "refreshJob", "Lkotlinx/coroutines/Job;", "maxHoldJob", "maxExpiredUntilStateExit", "", "refreshSequence", "", "updateListener", "com/obric/assistant/state/impl/multitask/producer/SelfUpdateDownloadStateProducer$updateListener$1", "Lcom/obric/assistant/state/impl/multitask/producer/SelfUpdateDownloadStateProducer$updateListener$1;", "initProducer", "", "handleUpdateState", "state", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startOrRefreshTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleRefresh", "handle", "scheduleMaxHold", "endTask", "reason", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelfUpdateDownloadStateProducer implements TaskFlowAutoInitProducer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f393130i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f393131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IObricUpdateService f393132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jha.l<c0> f393133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f393134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f393135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f393136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f393137g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SelfUpdateDownloadStateProducer$updateListener$1 f393138h;

    /* JADX INFO: loaded from: classes4.dex */
    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        IObricUpdateService r100 = (IObricUpdateService) ServiceManager.get().getService(IObricUpdateService.class);
        if (r100 != null) goto L6;
        FLogger.f375446a.e("SelfUpdateDownloadStateProducer", "IObricUpdateService is unavailable");
        return;
    L6:
        this.f393132b = r100;
        r100.f(this.f393138h);
        FLogger.f375446a.i("SelfUpdateDownloadStateProducer", "initialized");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.state.impl.multitask.producer.SelfUpdateDownloadStateProducer$updateListener$1] */
    public SelfUpdateDownloadStateProducer() {
        ExecutorCoroutineDispatcher r100 = jha.f.f499127a;
        Intrinsics.checkNotNullParameter("SelfUpdateDownloadStateProducer", "orderingDomain");
        this.f393131a = jha.f.b("SelfUpdateDownloadStateProducer").f499132b;
        this.f393138h = new SelfUpdateDownloadStateProducer$updateListener$1(this);
    }

    public final void a(String r100) {
        jha.l<c0> r101 = this.f393133c;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f393133c = null;
        Job r102 = this.f393134d;
        if (r102 == null) goto L8;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L8:
        this.f393134d = null;
        Job r103 = this.f393135e;
        if (r103 == null) goto L11;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L11:
        this.f393135e = null;
        TaskFlowDslKt.c(r101, new c0.b(r100));
        FLogger.f375446a.i("SelfUpdateDownloadStateProducer", "self-update download task ended, reason=".concat(r100));
    }

    public final Object b(Continuation<? super Unit> r110) {
        if ((r110 instanceof SelfUpdateDownloadStateProducer$startOrRefreshTask$1) == false) goto L7;
        SelfUpdateDownloadStateProducer$startOrRefreshTask$1 r100 = (SelfUpdateDownloadStateProducer$startOrRefreshTask$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        c0.a r104 = (c0.a) r100.L$0;
        ResultKt.throwOnFailure(r111);
    L22:
        jha.m r112 = (jha.m) r111;
        if (r112 != null) goto L26;
        FLogger.f375446a.e("SelfUpdateDownloadStateProducer", "failed to acquire self-update download task handle");
        return Unit.INSTANCE;
    L26:
        jha.l r105 = r112.f499141a;
        this.f393133c = r105;
        if (r112.f499142b == true) goto L29;
        TaskFlowDslKt.f(r105, r104);
    L29:
        jha.l<S> r106 = r112.f499141a;
        Job r107 = this.f393134d;
        if (r107 == null) goto L32;
        Job.DefaultImpls.cancel$default(r107, null, 1, null);
    L32:
        this.f393134d = BuildersKt.launch$default(this.f393131a, null, null, new SelfUpdateDownloadStateProducer$scheduleRefresh$1(this, r106, null), 3, null);
        jha.l<S> r113 = r112.f499141a;
        Job r108 = this.f393135e;
        if (r108 == null) goto L35;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);
    L35:
        this.f393135e = BuildersKt.launch$default(this.f393131a, null, null, new SelfUpdateDownloadStateProducer$scheduleMaxHold$1(this, r113, null), 3, null);
        FLogger.f375446a.i("SelfUpdateDownloadStateProducer", "self-update download task started");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        jha.l<c0> r114 = this.f393133c;
        if (r114 == null) goto L18;
        TaskFlowDslKt.f(r114, new c0.a(this.f393137g));
        return Unit.INSTANCE;
    L18:
        this.f393137g = 0;
        c0.a r109 = new c0.a(0);
        jha.g r115 = TaskFlowDslKt.b(b0.f3490a, "self_update_download");
        jha.c r116 = jha.j.a.a(this);
        r100.L$0 = r109;
        r100.label = 1;
        r111 = TaskFlowDslKt.e(r115, r109, r116, r100);
        if (r111 != r102) goto L21;
        return r102;
    L21:
        r104 = r109;
    L7:
        r100 = new SelfUpdateDownloadStateProducer$startOrRefreshTask$1(this, r110);
        goto L8
    }
}
