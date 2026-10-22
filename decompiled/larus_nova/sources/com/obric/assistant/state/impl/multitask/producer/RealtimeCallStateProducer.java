package com.obric.assistant.state.impl.multitask.producer;

import aha.a0;
import aha.u;
import aha.x;
import aha.y;
import aha.z;
import com.huawei.hms.api.FailedBinderCallBack;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\"\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u0003012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J(\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0016J \u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0011H\u0016J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u001e\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010$J\u001a\u0010%\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J \u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010'J \u0010(\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0018\u0010)\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\n2\u0006\u0010*\u001a\u00020\u0011H\u0002J \u0010+\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00110/X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/RealtimeCallStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowStateProducer;", "Lcom/obric/assistant/state/api/multitask/IObricRealtimeCallStateProducerService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeCallsByConversationId", "", "", "Lcom/obric/assistant/state/impl/multitask/producer/RealtimeCallStateProducer$ActiveRealtimeCall;", "conversationIdByCallId", "pendingCallIdByConversationId", "pendingMajorStatesByCallId", "Ljava/util/ArrayDeque;", "Lcom/obric/assistant/state/impl/multitask/producer/RealtimeCallStateProducer$PendingMajorState;", "pendingMuteStateByCallId", "", "closedCallIds", "", "closedCallIdOrder", "onCallEntered", "", "botId", "conversationId", "onCallExited", "onPluginStarted", FailedBinderCallBack.CALLER_ID, "onMajorStateChanged", "prevState", "currentState", "onMuteStateChanged", "state", "onPluginStopped", "bindCall", "activeCall", "(Lcom/obric/assistant/state/impl/multitask/producer/RealtimeCallStateProducer$ActiveRealtimeCall;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findActiveCall", "findOrBindActiveCall", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMajorState", "endTasks", "finalState", "bufferMajorState", "clearCallId", "markCallClosed", "projectedCallStates", "", "Companion", "PendingMajorState", "ActiveRealtimeCall", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallStateProducer implements jha.j, IObricRealtimeCallStateProducerService {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f393110j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f393111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, a> f393112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f393113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f393114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, ArrayDeque<c>> f393115e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Integer> f393116f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f393117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayDeque<String> f393118h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<Integer> f393119i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f393120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f393121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f393122c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final u f393123d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f393124e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public jha.l<a0> f393125f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public jha.l<y> f393126g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c f393127h;

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f393120a, r101.f393120a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393121b, r101.f393121b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f393122c, r101.f393122c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f393123d, r101.f393123d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f393124e, r101.f393124e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f393125f, r101.f393125f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f393126g, r101.f393126g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f393127h, r101.f393127h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f393120a.hashCode() * 31) + this.f393121b.hashCode()) * 31) + this.f393122c.hashCode()) * 31) + this.f393123d.hashCode()) * 31;
            String r101 = this.f393124e;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            jha.l<a0> r105 = this.f393125f;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            jha.l<y> r108 = this.f393126g;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            c r111 = this.f393127h;
            if (r111 == null) goto L19;
            r102 = r111.hashCode();
        L19:
            return r110 + r102;
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActiveRealtimeCall(botId=" + this.f393120a + ", conversationId=" + this.f393121b + ", modeSessionId=" + this.f393122c + ", metadata=" + this.f393123d + ", callId=" + this.f393124e + ", callHandle=" + this.f393125f + ", muteHandle=" + this.f393126g + ", lastTransition=" + this.f393127h + ')';
        }

        public a(String r100, String r101, String r102, u r103) {
            Intrinsics.checkNotNullParameter(r100, "botId");
            Intrinsics.checkNotNullParameter(r101, "conversationId");
            Intrinsics.checkNotNullParameter(r102, "modeSessionId");
            Intrinsics.checkNotNullParameter(r103, "metadata");
            this.f393120a = r100;
            this.f393121b = r101;
            this.f393122c = r102;
            this.f393123d = r103;
            this.f393124e = null;
            this.f393125f = null;
            this.f393126g = null;
            this.f393127h = null;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f393128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f393129b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f393128a == r101.f393128a) goto L12;
            return false;
        L12:
            if (this.f393129b == r101.f393129b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393128a * 31) + this.f393129b;
        }

        public final String toString() {
            return "PendingMajorState(prevState=" + this.f393128a + ", currentState=" + this.f393129b + ')';
        }

        public c(int r100, int r101) {
            this.f393128a = r100;
            this.f393129b = r101;
        }
    }

    static {
    }

    public RealtimeCallStateProducer() {
        ExecutorCoroutineDispatcher r100 = jha.f.f499127a;
        this.f393111a = jha.f.f499128b;
        this.f393112b = new LinkedHashMap();
        this.f393113c = new LinkedHashMap();
        this.f393114d = new LinkedHashMap();
        this.f393115e = new LinkedHashMap();
        this.f393116f = new LinkedHashMap();
        this.f393117g = new LinkedHashSet();
        this.f393118h = new ArrayDeque();
        this.f393119i = SetsKt.setOf(new Integer[]{-1, 0, 1, 2, 9, 3, 4, 5, 6});
    }

    public static void k(a r100) {
        String r101 = r100.f393124e;
        if (r101 != null) goto L5;
        return;
    L5:
        jha.l<a0> r102 = r100.f393125f;
        if (r102 == null) goto L8;
        TaskFlowDslKt.c(r102, new a0.c(r101, r100.f393121b, r100.f393123d));
    L8:
        jha.l<y> r103 = r100.f393126g;
        if (r103 == null) goto L11;
        TaskFlowDslKt.c(r103, new y.c(r101, r100.f393121b, r100.f393123d));
    L11:
        r100.f393125f = null;
        r100.f393126g = null;
        r100.f393127h = null;
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        BuildersKt.launch$default(this.f393111a, null, null, new RealtimeCallStateProducer$onCallExited$1(this, r101, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        if (StringsKt.isBlank(r100) == false) goto L5;
    L9:
        FLogger.f375446a.w("RealtimeCallStateProducer", "ignore call enter with empty identity");
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L9;
        BuildersKt.launch$default(this.f393111a, null, null, new RealtimeCallStateProducer$onCallEntered$1(this, r101, r100, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        BuildersKt.launch$default(this.f393111a, null, null, new RealtimeCallStateProducer$onPluginStopped$1(this, r101, r100, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        if (StringsKt.isBlank(r100) == false) goto L5;
    L9:
        FLogger.f375446a.w("RealtimeCallStateProducer", "ignore plugin start with empty identity");
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L9;
        BuildersKt.launch$default(this.f393111a, null, null, new RealtimeCallStateProducer$onPluginStarted$1(this, r100, r101, null), 3, null);
    }

    public final a l(String r100, String r101) {
        String r102 = (String) ((LinkedHashMap) this.f393113c).get(r100);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r102, r101) == true) goto L8;
        return null;
    L8:
        a r103 = (a) ((LinkedHashMap) this.f393112b).get(r101);
        if (r103 != null) goto L11;
        return null;
    L11:
        if (Intrinsics.areEqual(r103.f393124e, r100) == true) goto L13;
        return null;
    L13:
        return r103;
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void a(String r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        if (StringsKt.isBlank(r110) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r111) == true) goto L10;
        BuildersKt.launch$default(this.f393111a, null, null, new RealtimeCallStateProducer$onMuteStateChanged$1(this, r110, r111, r112, null), 3, null);
        return;
    }

    public final void i(a r100, int r110, int r111) {
        c r101 = new c(r110, r111);
        boolean r102 = Intrinsics.areEqual(r100.f393127h, r101);
        r100.f393127h = r101;
        if (r102 == false) goto L5;
    L9:
        boolean r112 = false;
    L11:
        if (this.f393119i.contains(Integer.valueOf(r111)) == true) goto L13;
        return;
    L13:
        String r103 = r100.f393124e;
        if (r103 != null) goto L16;
        return;
    L16:
        if (r112 == false) goto L21;
        jha.l<a0> r113 = r100.f393125f;
        if (r113 == null) goto L25;
        TaskFlowDslKt.f(r113, new a0.a(r103, r100.f393121b, r111, MapsKt.mapOf(TuplesKt.to("round_completed", Boolean.TRUE)), r100.f393123d, 8));
        return;
    L25:
        return;
    L21:
        jha.l<a0> r114 = r100.f393125f;
        if (r114 == null) goto L26;
        TaskFlowDslKt.f(r114, new a0.a(r103, r100.f393121b, r111, null, r100.f393123d, 24));
        return;
    L26:
        return;
    L5:
        if (r110 != 5) goto L9;
        if (r111 != 3) goto L9;
        r112 = true;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object j(a r110, String r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof RealtimeCallStateProducer$bindCall$1) == false) goto L7;
        RealtimeCallStateProducer$bindCall$1 r100 = (RealtimeCallStateProducer$bindCall$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        jha.l r104 = null;
        r104 = null;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        a r114 = (a) r100.L$2;
        r111 = (String) r100.L$1;
        a r105 = (a) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L40:
        jha.m r115 = (jha.m) r113;
        if (r115 != null) goto L43;
    L48:
        r114.f393126g = r104;
        ArrayDeque<c> r116 = this.f393115e.remove(r111);
        if (r116 == null) goto L54;
        Iterator<T> r117 = r116.iterator();
    L52:
        if (r117.hasNext() == false) goto L54;
        c r118 = (c) r117.next();
        i(r105, r118.f393128a, r118.f393129b);
    L54:
        Integer r119 = this.f393116f.remove(r111);
        if (r119 == null) goto L60;
        int r120 = r119.intValue();
        jha.l<y> r121 = r105.f393126g;
        if (r121 == null) goto L60;
        TaskFlowDslKt.f(r121, new y.a(r111, r105.f393121b, r120, r105.f393123d));
    L60:
        return Unit.INSTANCE;
    L43:
        if (r115.f499142b == true) goto L46;
        r115 = null;
    L46:
        if (r115 == null) goto L48;
        r104 = r115.f499141a;
        goto L48
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (a) r100.L$2;
        r111 = (String) r100.L$1;
        a r106 = (a) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L27:
        jha.m r122 = (jha.m) r113;
        if (r122 != null) goto L30;
    L35:
        jha.l<a0> r123 = 0;
    L36:
        r110.f393125f = r123;
        Intrinsics.checkNotNullParameter(r111, FailedBinderCallBack.CALLER_ID);
        jha.g r124 = TaskFlowDslKt.b(x.f3681a, r111);
        y.b r125 = new y.b(r111, r106.f393121b, r106.f393123d);
        jha.c r107 = jha.j.a.a(this);
        r100.L$0 = r106;
        r100.L$1 = r111;
        r100.L$2 = r106;
        r100.label = 2;
        r113 = TaskFlowDslKt.e(r124, r125, r107, r100);
        if (r113 != r102) goto L39;
        return r102;
    L39:
        r114 = r106;
        r105 = r114;
        goto L40
    L30:
        if (r122.f499142b == true) goto L33;
        r122 = null;
    L33:
        if (r122 == null) goto L35;
        r123 = r122.f499141a;
        goto L36
    L16:
        ResultKt.throwOnFailure(r113);
        if (Intrinsics.areEqual(r110.f393124e, r111) == true) goto L19;
        String r126 = r110.f393124e;
        if (r126 == null) goto L23;
        k(r110);
        this.f393113c.remove(r126);
        this.f393115e.remove(r126);
        this.f393116f.remove(r126);
    L23:
        r110.f393124e = r111;
        this.f393113c.put(r111, r110.f393121b);
        Intrinsics.checkNotNullParameter(r111, FailedBinderCallBack.CALLER_ID);
        jha.g r127 = TaskFlowDslKt.b(z.f3701a, r111);
        a0.b r108 = new a0.b(r111, r110.f393121b, r110.f393123d);
        jha.c r109 = jha.j.a.a(this);
        r100.L$0 = r110;
        r100.L$1 = r111;
        r100.L$2 = r110;
        r100.label = 1;
        r113 = TaskFlowDslKt.e(r127, r108, r109, r100);
        if (r113 != r102) goto L26;
        return r102;
    L26:
        r106 = r110;
        goto L27
    L19:
        return Unit.INSTANCE;
    L7:
        r100 = new RealtimeCallStateProducer$bindCall$1(this, r112);
        goto L8
    }

    public static final Object h(RealtimeCallStateProducer r100, String r101, String r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof RealtimeCallStateProducer$findOrBindActiveCall$1) == false) goto L7;
        RealtimeCallStateProducer$findOrBindActiveCall$1 r104 = (RealtimeCallStateProducer$findOrBindActiveCall$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        a r109 = (a) r104.L$0;
        ResultKt.throwOnFailure(r106);
        return r109;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        a r110 = r100.l(r101, r102);
        if (r110 != null) goto L33;
        a r111 = (a) ((LinkedHashMap) r100.f393112b).get(r102);
        r110 = null;
        if (r111 == null) goto L33;
        if (r111.f393124e != null) goto L22;
        boolean r112 = true;
    L23:
        if (r112 == true) goto L26;
        r111 = null;
    L26:
        if (r111 == null) goto L33;
        r104.L$0 = r111;
        r104.label = 1;
        if (r100.j(r111, r101, r104) != r107) goto L31;
        return r107;
    L31:
        return r111;
    L22:
        r112 = false;
    L33:
        return r110;
    L7:
        r104 = new RealtimeCallStateProducer$findOrBindActiveCall$1(r100, r103);
        goto L8
    }

    @Override // com.obric.assistant.state.api.multitask.IObricRealtimeCallStateProducerService
    public final void b(String r110, String r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r110, FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        if (StringsKt.isBlank(r110) == false) goto L5;
        return;
    L5:
        if (StringsKt.isBlank(r111) == true) goto L10;
        BuildersKt.launch$default(this.f393111a, null, null, new RealtimeCallStateProducer$onMajorStateChanged$1(this, r110, r111, r112, r113, null), 3, null);
        return;
    }
}
