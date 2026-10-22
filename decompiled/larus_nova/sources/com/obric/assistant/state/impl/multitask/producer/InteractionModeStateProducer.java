package com.obric.assistant.state.impl.multitask.producer;

import aha.a0;
import aha.e0;
import aha.h0;
import aha.t;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.subtitle.SubtitleListUpdateType;
import com.obric.assistant.state.api.multitask.IObricInteractionModeService;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.state.api.multitask.state.ModeEndReason;
import com.obric.assistant.state.api.multitask.state.ModeRefreshSource;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.state.multitask.TaskFlowManager;
import com.obric.assistant.state.multitask.core.TaskFlowDispatchStrategy;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.assistant.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import jha.o;
import jha.q;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 72\u00020\u0001:\u000278B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016¢\u0006\u0002\u0010\u001bJ \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0002\u0010!J=\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016¢\u0006\u0002\u0010&J=\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\r2\u0006\u0010$\u001a\u00020%2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002¢\u0006\u0002\u0010)J.\u0010*\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\bH\u0016J.\u0010.\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002J\u001f\u0010/\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u00100J\u001c\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\b2\n\u00103\u001a\u0006\u0012\u0002\b\u000304H\u0002J\"\u00105\u001a\u00020\n*\u00020\u001f2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/InteractionModeStateProducer;", "Lcom/obric/assistant/state/api/multitask/IObricInteractionModeService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "latestSessionIdByBotId", "Ljava/util/concurrent/ConcurrentHashMap;", "", "modeSnapshotsByBotId", "Lcom/obric/assistant/state/api/multitask/ActiveModeSnapshot;", "activeModesBySessionId", "", "Lcom/obric/assistant/state/impl/multitask/producer/InteractionModeStateProducer$ActiveMode;", "activeSessionIdByBotId", "timeoutJobs", "Lkotlinx/coroutines/Job;", "startMode", "botId", "conversationId", "interactionType", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;", "timeoutMillis", "", "ext", "", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;Ljava/lang/Long;Ljava/util/Map;)Ljava/lang/String;", "startModeInternal", "", "state", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionModeState$Start;", "effectiveTimeout", "(Lcom/obric/assistant/state/api/multitask/state/ObricInteractionModeState$Start;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshMode", "sessionId", "source", "Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;Ljava/lang/Long;Ljava/util/Map;)V", "refreshModeInternal", "activeMode", "(Lcom/obric/assistant/state/impl/multitask/producer/InteractionModeStateProducer$ActiveMode;Lcom/obric/assistant/state/api/multitask/state/ModeRefreshSource;Ljava/lang/Long;Ljava/util/Map;)V", "endMode", "reason", "Lcom/obric/assistant/state/api/multitask/state/ModeEndReason;", "getActiveMode", "endModeInternal", "scheduleTimeout", "(Ljava/lang/String;Ljava/lang/Long;)V", "handleTaskFlowEvent", "taskFlowId", "event", "Lcom/obric/assistant/state/multitask/core/TaskStateEvent;", "toSnapshot", "snapshotExt", "Companion", "ActiveMode", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InteractionModeStateProducer implements IObricInteractionModeService {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f393046g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f393047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f393048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, zga.a> f393049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, a> f393050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f393051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Job> f393052f;

    /* JADX INFO: renamed from: com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer$1", f = "InteractionModeStateProducer.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ InteractionModeStateProducer this$0;

        /* JADX INFO: renamed from: com.obric.assistant.state.impl.multitask.producer.InteractionModeStateProducer$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ InteractionModeStateProducer f393053a;

            public a(InteractionModeStateProducer r100) {
                this.f393053a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r110, Continuation r111) {
                Pair r100 = (Pair) r110;
                jha.g r101 = (jha.g) r100.component1();
                q r102 = (q) r100.component2();
                InteractionModeStateProducer r103 = this.f393053a;
                String r104 = r101.toString();
                int r105 = InteractionModeStateProducer.f393046g;
                r103.getClass();
                S r106 = r102.a().f499148b;
                if ((r106 instanceof aha.l) == true) goto L129;
                Long r107 = null;
                if ((r106 instanceof t) == false) goto L8;
                t r108 = (t) r106;
            L9:
                if (r108 == null) goto L129;
                String r109 = r108.c();
                if (r109 == null) goto L129;
                String r112 = r108.getBotId();
                if (r112 == null) goto L129;
                a r113 = (a) ((LinkedHashMap) r103.f393050d).get(r109);
                if (r113 == null) goto L129;
                if (Intrinsics.areEqual(r113.f393054a.f3633h, r112) == true) goto L23;
                r113 = null;
            L23:
                if (r113 == null) goto L129;
                if ((r106 instanceof aha.q) == false) goto L28;
                ModeRefreshSource r114 = ModeRefreshSource.MESSAGE;
            L42:
                TaskFlowManager r115 = TaskFlowManager.f393247a;
                List r116 = TaskFlowManager.c();
                ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
                Iterator r118 = ((ArrayList) r116).iterator();
            L44:
                if (r118.hasNext() == false) goto L46;
                r117.add(((q) ((Pair) r118.next()).component2()).a().f499148b);
                goto L44
            L46:
                ArrayList r119 = new ArrayList();
                Iterator r120 = r117.iterator();
            L48:
                if (r120.hasNext() == false) goto L60;
                Object r121 = r120.next();
                o r122 = (o) r121;
                if ((r122 instanceof t) == false) goto L52;
                t r123 = (t) r122;
            L53:
                if (r123 == null) goto L55;
                String r124 = r123.c();
            L57:
                if (Intrinsics.areEqual(r124, r109) == false) goto L48;
                r119.add(r121);
                goto L48
            L55:
                r124 = null;
                goto L57
            L52:
                r123 = null;
                goto L53
            L60:
                if (r119.isEmpty() == true) goto L78;
                Iterator r125 = r119.iterator();
            L64:
                if (r125.hasNext() == false) goto L78;
                o r126 = (o) r125.next();
                if ((r126 instanceof aha.j.b) == false) goto L68;
            L75:
                boolean r127 = true;
            L76:
                if (r127 == false) goto L64;
                boolean r128 = true;
            L80:
                if (r119.isEmpty() == true) goto L95;
                Iterator r129 = r119.iterator();
            L84:
                if (r129.hasNext() == false) goto L95;
                o r130 = (o) r129.next();
                if ((r130 instanceof aha.q.a) == false) goto L90;
                if (((aha.q.a) r130).f3655f != 20) goto L90;
            L91:
                boolean r131 = true;
            L93:
                if (r131 == false) goto L84;
                boolean r132 = true;
            L97:
                if (r128 == false) goto L115;
                int r133 = i.f393171a;
                boolean r134 = t1.f393353a.r0();
                if (r119.isEmpty() == true) goto L107;
                Iterator r135 = r119.iterator();
            L103:
                if (r135.hasNext() == false) goto L107;
                if ((((o) r135.next()) instanceof aha.j.b) == false) goto L103;
                boolean r136 = true;
            L108:
                boolean r137 = Intrinsics.areEqual(r113.f393057d.get("has_attachment"), Boolean.TRUE);
                if (r134 == false) goto L111;
                int r138 = 30;
            L116:
                Long r139 = r113.f393056c;
                if (r139 != null) goto L126;
                if (r128 == true) goto L120;
                if (r132 == true) goto L120;
            L127:
                r103.g(r113, r114, r107, MapsKt.mapOf(new Pair[]{TuplesKt.to("task_flow_id", r104), TuplesKt.to("timeout_times", Integer.valueOf(r138)), TuplesKt.to(SubtitleListUpdateType.THINKING, Boolean.valueOf(r128)), TuplesKt.to("generating", Boolean.valueOf(r132))}));
            L120:
                int r140 = i.f393171a;
                ObricInteractionType r141 = r113.f393054a.f3636k;
                Intrinsics.checkNotNullParameter(r141, "interactionType");
                switch(i.a.f393172a[r141.ordinal()]) {
                    case 1: goto L125;
                    case 2: goto L125;
                    case 3: goto L125;
                    case 4: goto L127;
                    case 5: goto L127;
                    case 6: goto L127;
                    default: goto L123;
                };
            L125:
                r107 = Long.valueOf(((long) r138) * 140000);
                goto L127
            L123:
                throw new NoWhenBranchMatchedException();
            L126:
                r107 = r139;
                goto L127
            L111:
                if (r136 == false) goto L113;
                r138 = 13;
                goto L116
            L113:
                if (r137 == false) goto L115;
                r138 = 3;
            L107:
                r136 = false;
            L115:
                r138 = 1;
            L90:
                if ((r130 instanceof e0.b) == true) goto L91;
                r131 = false;
            L95:
                r132 = false;
                goto L97
            L68:
                if ((r126 instanceof aha.d.a) == true) goto L75;
                if ((r126 instanceof aha.q.a) == true) goto L72;
            L74:
                r127 = false;
                goto L76
            L72:
                if (SetsKt.setOf(new Integer[]{11, 24}).contains(Integer.valueOf(((aha.q.a) r126).f3655f)) == false) goto L74;
            L78:
                r128 = false;
                goto L80
            L28:
                if ((r106 instanceof aha.j) == false) goto L31;
                r114 = ModeRefreshSource.DEEP_THINK;
                goto L42
            L31:
                if ((r106 instanceof aha.d) == false) goto L34;
                r114 = ModeRefreshSource.COMPLEX_TASK;
                goto L42
            L34:
                if ((r106 instanceof e0) == false) goto L37;
                r114 = ModeRefreshSource.TTS;
                goto L42
            L37:
                if ((r106 instanceof h0) == false) goto L40;
                r114 = ModeRefreshSource.CLICK_TALK;
                goto L42
            L40:
                if ((r106 instanceof a0) == false) goto L129;
                r114 = ModeRefreshSource.REALTIME_CALL;
                goto L42
            L8:
                r108 = null;
            L129:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(InteractionModeStateProducer r100, Continuation<? super AnonymousClass1> r101) {
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
            a1 r103 = TaskFlowManager.f393254h;
            a r104 = new a(this.this$0);
            this.label = 1;
            if (r103.collect(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final aha.l.c f393054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jha.l<aha.l> f393055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Long f393056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, ? extends Object> f393057d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f393054a, r101.f393054a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393055b, r101.f393055b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f393056c, r101.f393056c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f393057d, r101.f393057d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f393054a.hashCode() * 31) + this.f393055b.hashCode()) * 31;
            Long r101 = this.f393056c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f393057d.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ActiveMode(state=" + this.f393054a + ", handle=" + this.f393055b + ", baseTimeoutMillis=" + this.f393056c + ", ext=" + this.f393057d + ')';
        }

        public a(aha.l.c r100, jha.l<aha.l> r101, Long r102, Map<String, ? extends Object> r103) {
            Intrinsics.checkNotNullParameter(r100, "state");
            Intrinsics.checkNotNullParameter(r101, "handle");
            Intrinsics.checkNotNullParameter(r103, "ext");
            this.f393054a = r100;
            this.f393055b = r101;
            this.f393056c = r102;
            this.f393057d = r103;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class b {
    }

    static {
    }

    public InteractionModeStateProducer() {
        CoroutineScope r100 = jha.f.f499128b;
        this.f393047a = r100;
        this.f393048b = new ConcurrentHashMap();
        this.f393049c = new ConcurrentHashMap();
        this.f393050d = new LinkedHashMap();
        this.f393051e = new LinkedHashMap();
        this.f393052f = new LinkedHashMap();
        BuildersKt.launch$default(r100, null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this, null), 1, null);
        ObricInteractionProjectionDelegate.f392943b.b(null, new c(this));
    }

    @Override // com.obric.assistant.state.api.multitask.IObricInteractionModeService
    public final zga.a c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        return this.f393049c.get(r100);
    }

    public final void h(String r100, Long r110) {
        Job r101 = this.f393052f.remove(r100);
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        if (r110 != null) goto L7;
        return;
    L7:
        if (r110.longValue() <= 0) goto L12;
        this.f393052f.put(r100, BuildersKt.launch$default(this.f393047a, null, null, new InteractionModeStateProducer$scheduleTimeout$1(r110, this, r100, null), 3, null));
        return;
    }

    @Override // com.obric.assistant.state.api.multitask.IObricInteractionModeService
    public final void b(String r110, ModeEndReason r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        Intrinsics.checkNotNullParameter(r111, "reason");
        Intrinsics.checkNotNullParameter(r112, "ext");
        BuildersKt.launch$default(this.f393047a, null, null, new InteractionModeStateProducer$endMode$1(this, r110, r111, r112, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.obric.assistant.state.impl.multitask.producer.d] */
    public final void f(final String r110, ModeEndReason r111, Map<String, ? extends Object> r112) {
        a r100 = this.f393050d.remove(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        Job r101 = this.f393052f.remove(r110);
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.f393051e.remove(r100.f393054a.f3633h, r110);
        this.f393048b.remove(r100.f393054a.f3633h, r110);
        ConcurrentHashMap<String, zga.a> r102 = this.f393049c;
        String r103 = r100.f393054a.f3633h;
        final ?? r104 = new d(r110);
        r102.computeIfPresent(r103, new e(r104));
        jha.l<aha.l> r105 = r100.f393055b;
        aha.l.c r106 = r100.f393054a;
        TaskFlowDslKt.c(r105, new aha.l.b(r106.f3633h, r106.f3634i, r110, r106.f3636k, r111, r112));
        FLogger.f375446a.i("InteractionModeStateProducer", "mode ended botId=" + r100.f393054a.f3633h + ", mode=" + r100.f393054a.f3636k + ", sessionId=" + r110 + ", reason=" + r111);
    }

    public static final Object e(InteractionModeStateProducer r110, aha.l.c r111, Long r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof InteractionModeStateProducer$startModeInternal$1) == false) goto L7;
        InteractionModeStateProducer$startModeInternal$1 r100 = (InteractionModeStateProducer$startModeInternal$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        String r115 = (String) r100.L$2;
        r112 = (Long) r100.L$1;
        aha.l.c r104 = (aha.l.c) r100.L$0;
        ResultKt.throwOnFailure(r114);
        String r116 = r115;
        r111 = r104;
        Object r105 = r114;
    L23:
        jha.m r106 = (jha.m) r105;
        if (r106 != null) goto L26;
    L32:
        FLogger.f375446a.w("InteractionModeStateProducer", "startMode ignored, task already exists, sessionId=" + r116);
        r110.f393048b.remove(r111.f3633h, r116);
        ConcurrentHashMap<String, zga.a> r117 = r110.f393049c;
        String r118 = r111.f3633h;
        r117.remove(r118, new zga.a(r118, r111.f3634i, r111.f3635j, r111.f3636k, r111.f3638m));
        return Unit.INSTANCE;
    L26:
        if (r106.f499142b == false) goto L32;
        r110.f393050d.put(r116, new a(r111, r106.f499141a, r112, r111.f3638m));
        r110.f393051e.put(r111.f3633h, r116);
        FLogger.f375446a.i("InteractionModeStateProducer", "mode started botId=" + r111.f3633h + ", mode=" + r111.f3636k + ", sessionId=" + r116 + ", timeoutMillis=" + r112);
        if (r112 == null) goto L35;
        r110.h(r116, r112);
    L35:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        r116 = r111.f3635j;
        if (Intrinsics.areEqual(r110.f393048b.get(r111.f3633h), r116) == false) goto L34;
        String r107 = (String) ((LinkedHashMap) r110.f393051e).get(r111.f3633h);
        if (r107 == null) goto L20;
        r110.f(r107, ModeEndReason.REPLACED, MapsKt.emptyMap());
    L20:
        String r108 = r111.f3633h;
        String r109 = r111.f3634i;
        Intrinsics.checkNotNullParameter(r108, "botId");
        Intrinsics.checkNotNullParameter(r116, "sessionId");
        aha.m r119 = aha.m.f3639a;
        int r120 = com.obric.assistant.state.multitask.ext.f.f393299a;
        jha.g r121 = TaskFlowDslKt.b(r119, com.obric.assistant.state.multitask.ext.g.a(new com.obric.assistant.state.multitask.ext.g(), new String[]{r108, r109, r116}));
        ExecutorCoroutineDispatcher r122 = jha.f.f499127a;
        Intrinsics.checkNotNullParameter("InteractionModeStateProducer", "orderingDomain");
        jha.c r123 = new jha.c(TaskFlowDispatchStrategy.SHARED_SERIALIZED, "InteractionModeStateProducer");
        r100.L$0 = r111;
        r100.L$1 = r112;
        r100.L$2 = r116;
        r100.label = 1;
        r105 = TaskFlowDslKt.e(r121, r111, r123, r100);
        if (r105 != r102) goto L23;
        return r102;
    L34:
        return Unit.INSTANCE;
    L7:
        r100 = new InteractionModeStateProducer$startModeInternal$1(r110, r113);
        goto L8
    }

    @Override // com.obric.assistant.state.api.multitask.IObricInteractionModeService
    public final void a(String r110, ModeRefreshSource r111, Long r112, Map<String, ? extends Object> r113) {
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        Intrinsics.checkNotNullParameter(r111, "source");
        Intrinsics.checkNotNullParameter(r113, "ext");
        BuildersKt.launch$default(this.f393047a, null, null, new InteractionModeStateProducer$refreshMode$1(this, r110, r112, r111, r113, null), 3, null);
    }

    public final void g(a r110, ModeRefreshSource r111, Long r112, Map<String, ? extends Object> r113) {
        String r100 = r110.f393054a.f3635j;
        if ((!r113.isEmpty()) == false) goto L5;
        Map<String, ? extends Object> r114 = MapsKt.plus(r110.f393057d, r113);
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r110.f393057d = r114;
    L5:
        jha.l<aha.l> r115 = r110.f393055b;
        aha.l.c r101 = r110.f393054a;
        TaskFlowDslKt.f(r115, new aha.l.a(r101.f3633h, r101.f3634i, r100, r101.f3636k, r111, r110.f393057d));
        FLogger.f375446a.i("InteractionModeStateProducer", "mode refreshed botId=" + r110.f393054a.f3633h + ", mode=" + r110.f393054a.f3636k + ", sessionId=" + r100 + ", source=" + r111 + ", timeoutMillis=" + r112);
        if (((LinkedHashMap) this.f393050d).get(r100) == r110) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.f393048b.get(r110.f393054a.f3633h), r100) == false) goto L10;
        ConcurrentHashMap<String, zga.a> r116 = this.f393049c;
        aha.l.c r117 = r110.f393054a;
        String r102 = r117.f3633h;
        r116.put(r102, new zga.a(r102, r117.f3634i, r117.f3635j, r117.f3636k, r110.f393057d));
    L10:
        h(r100, r112);
    }

    @Override // com.obric.assistant.state.api.multitask.IObricInteractionModeService
    public final String d(String r210, String r211, ObricInteractionType r212, Long r213, Map<String, ? extends Object> r214) {
        Intrinsics.checkNotNullParameter(r210, "botId");
        Intrinsics.checkNotNullParameter(r212, "interactionType");
        Intrinsics.checkNotNullParameter(r214, "ext");
        String r110 = UUID.randomUUID().toString();
        Map r111 = MapsKt.toMap(r214);
        aha.l.c r112 = new aha.l.c(r210, r211, r110, r212, r111);
        FLogger.f375446a.i("InteractionModeStateProducer", "startMode requested botId=" + r210 + ", mode=" + r212 + ", sessionId=" + r110 + ", timeoutMillis=" + r213);
        this.f393048b.put(r210, r110);
        this.f393049c.put(r210, new zga.a(r112.f3633h, r112.f3634i, r112.f3635j, r112.f3636k, r111));
        BuildersKt.launch$default(this.f393047a, null, null, new InteractionModeStateProducer$startMode$1(this, r112, r213, null), 3, null);
        return r110;
    }
}
