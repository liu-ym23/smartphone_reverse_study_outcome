package com.obric.assistant.interaction.impl;

import com.bytedance.apm.ApmAgent;
import com.larus.platform.IFlowSdkCommonDepend;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.IObricApmService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J.\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricApmServiceImpl;", "Lcom/obric/assistant/interaction/api/IObricApmService;", "<init>", "()V", "workScope", "Lkotlinx/coroutines/CoroutineScope;", "isReady", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingSlardarEvents", "", "Lcom/obric/assistant/interaction/impl/ObricApmServiceImpl$SlardarEventParams;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "markReady", "", "monitorEventForSlardar", "event", "", "category", "Lorg/json/JSONObject;", "metric", "extraLog", "reportEventForSlardar", "Companion", "SlardarEventParams", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricApmServiceImpl implements IObricApmService {
    public static final Companion Companion = null;
    private static final String TAG = "ObricApmServiceImpl";
    private final AtomicBoolean isReady;
    private final kotlinx.coroutines.sync.a lock;
    private final List<SlardarEventParams> pendingSlardarEvents;
    private final CoroutineScope workScope;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricApmServiceImpl$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricApmServiceImpl$SlardarEventParams;", "", "event", "", "category", "Lorg/json/JSONObject;", "metric", "extraLog", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V", "getEvent", "()Ljava/lang/String;", "getCategory", "()Lorg/json/JSONObject;", "getMetric", "getExtraLog", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SlardarEventParams {
        private final JSONObject category;
        private final String event;
        private final JSONObject extraLog;
        private final JSONObject metric;

        public static /* synthetic */ SlardarEventParams copy$default(SlardarEventParams r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.event;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.category;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.metric;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.extraLog;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.event;
        }

        public final JSONObject component2() {
            return this.category;
        }

        public final JSONObject component3() {
            return this.metric;
        }

        public final JSONObject component4() {
            return this.extraLog;
        }

        public final SlardarEventParams copy(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            Intrinsics.checkNotNullParameter(r100, "event");
            return new SlardarEventParams(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SlardarEventParams) == true) goto L8;
            return false;
        L8:
            SlardarEventParams r101 = (SlardarEventParams) r100;
            if (Intrinsics.areEqual(this.event, r101.event) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.category, r101.category) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.metric, r101.metric) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.extraLog, r101.extraLog) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r100 = this.event.hashCode() * 31;
            JSONObject r101 = this.category;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            JSONObject r105 = this.metric;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            JSONObject r108 = this.extraLog;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "SlardarEventParams(event=" + this.event + ", category=" + this.category + ", metric=" + this.metric + ", extraLog=" + this.extraLog + ')';
        }

        public final JSONObject getCategory() {
            return this.category;
        }

        public final String getEvent() {
            return this.event;
        }

        public final JSONObject getExtraLog() {
            return this.extraLog;
        }

        public final JSONObject getMetric() {
            return this.metric;
        }

        public SlardarEventParams(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.event = r100;
            this.category = r101;
            this.metric = r102;
            this.extraLog = r103;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.ObricApmServiceImpl$monitorEventForSlardar$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricApmServiceImpl$monitorEventForSlardar$1", f = "ObricApmServiceImpl.kt", i = {0}, l = {90}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JSONObject $category;
        final /* synthetic */ String $event;
        final /* synthetic */ JSONObject $extraLog;
        final /* synthetic */ JSONObject $metric;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ ObricApmServiceImpl this$0;

        public AnonymousClass1(ObricApmServiceImpl r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104, Continuation<? super AnonymousClass1> r105) {
            this.this$0 = r100;
            this.$event = r101;
            this.$category = r102;
            this.$metric = r103;
            this.$extraLog = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$event, this.$category, this.$metric, this.$extraLog, r101);
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
            JSONObject r103 = (JSONObject) this.L$5;
            JSONObject r104 = (JSONObject) this.L$4;
            JSONObject r105 = (JSONObject) this.L$3;
            String r106 = (String) this.L$2;
            ObricApmServiceImpl r107 = (ObricApmServiceImpl) this.L$1;
            kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r100);
        L22:
        L19:
            th = move-exception;
            r108.unlock(null);
            throw th;
        L13:
            if (ObricApmServiceImpl.access$isReady$p(r107).get() == false) goto L15;
            ObricApmServiceImpl.access$reportEventForSlardar(r107, r106, r105, r104, r103);     // Catch: Throwable -> L19
        L16:
            Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L19
            r108.unlock(null);
            return Unit.INSTANCE;
        L15:
            Boxing.boxBoolean(ObricApmServiceImpl.access$getPendingSlardarEvents$p(r107).add(new SlardarEventParams(r106, r105, r104, r103)));     // Catch: Throwable -> L19
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            r108 = ObricApmServiceImpl.access$getLock$p(this.this$0);
            r107 = this.this$0;
            r106 = this.$event;
            JSONObject r110 = this.$category;
            r104 = this.$metric;
            JSONObject r111 = this.$extraLog;
            this.L$0 = r108;
            this.L$1 = r107;
            this.L$2 = r106;
            this.L$3 = r110;
            this.L$4 = r104;
            this.L$5 = r111;
            this.label = 1;
            if (r108.a(null, this) != r101) goto L11;
            return r101;
        L11:
            r105 = r110;
            r103 = r111;
            goto L22
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(ObricApmServiceImpl r100) {
        markReady$lambda$0(r100);
    }

    @Override // com.obric.assistant.interaction.api.IObricApmService
    public void markReady() {
        t0.f375468a.post(new g(this));
    }

    public ObricApmServiceImpl() {
        this.workScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.isReady = new AtomicBoolean(false);
        this.pendingSlardarEvents = new ArrayList();
        this.lock = kotlinx.coroutines.sync.b.a();
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getLock$p(ObricApmServiceImpl r100) {
        return r100.lock;
    }

    public static final /* synthetic */ List access$getPendingSlardarEvents$p(ObricApmServiceImpl r100) {
        return r100.pendingSlardarEvents;
    }

    public static final /* synthetic */ AtomicBoolean access$isReady$p(ObricApmServiceImpl r100) {
        return r100.isReady;
    }

    private static final void markReady$lambda$0(ObricApmServiceImpl r100) {
        BuildersKt.launch$default(r100.workScope, null, null, new ObricApmServiceImpl$markReady$1$1(r100, null), 3, null);
    }

    private final void reportEventForSlardar(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        FLogger.f375446a.i(TAG, "reportEventForSlardar: " + r100);     // Catch: Throwable -> L11
        IFlowSdkCommonDepend r105 = (IFlowSdkCommonDepend) ServiceManager.get().getService(IFlowSdkCommonDepend.class);     // Catch: Throwable -> L11
        if (r105 == null) goto L8;
        r105.getApmService();     // Catch: Throwable -> L11
        ic9.a r106 = ic9.a.f489256a;
        Intrinsics.checkNotNullParameter(r100, "event");     // Catch: Throwable -> L11
        ApmAgent.monitorEvent(r100, r101, r102, r103);     // Catch: Throwable -> L11
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L11
    L9:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L11
    L13:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L19;
        FLogger.f375446a.w(TAG, "report failed: " + r109.getMessage(), r109);
        return;
    L19:
        return;
    L8:
        r107 = null;
    L11:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // com.obric.assistant.interaction.api.IObricApmService
    public void monitorEventForSlardar(String r110, JSONObject r111, JSONObject r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r110, "event");
        BuildersKt.launch$default(this.workScope, null, null, new AnonymousClass1(this, r110, r111, r112, r113, null), 3, null);
    }

    public static final /* synthetic */ void access$reportEventForSlardar(ObricApmServiceImpl r100, String r101, JSONObject r102, JSONObject r103, JSONObject r104) {
        r100.reportEventForSlardar(r101, r102, r103, r104);
    }
}
