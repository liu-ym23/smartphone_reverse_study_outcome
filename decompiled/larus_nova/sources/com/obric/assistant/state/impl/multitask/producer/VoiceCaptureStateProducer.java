package com.obric.assistant.state.impl.multitask.producer;

import aha.h0;
import aha.u;
import com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService;
import com.obric.assistant.state.api.multitask.state.VoiceCaptureScene;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0003+,-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J=\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\u0016J3\u0010\u0017\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0018J;\u0010\u0019\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u001bJ3\u0010\u001c\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0018J3\u0010\u001d\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0018J;\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010#J2\u0010$\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J#\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020)0(2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u0010*R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/VoiceCaptureStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowStateProducer;", "Lcom/obric/assistant/state/api/multitask/IVoiceCaptureStateProducerService;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeSessionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/state/impl/multitask/producer/VoiceCaptureStateProducer$ActiveSession;", "pendingEndMap", "Lcom/obric/assistant/state/impl/multitask/producer/VoiceCaptureStateProducer$PendingEndEvent;", "start", "", "conversationId", "scene", "Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;", "sessionId", "sourceType", "", "botId", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "onAsrStart", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/String;Ljava/lang/Integer;)V", "onCallStateChanged", "callState", "(Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;ILjava/lang/String;Ljava/lang/Integer;)V", "onAsrEnd", "end", "bufferPendingEnd", "key", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/Integer;Ljava/lang/String;)V", "flushPendingEnd", "effectiveSessionId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endSession", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/state/api/multitask/state/VoiceCaptureScene;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sessionKey", "buildExt", "", "", "(Ljava/lang/Integer;)Ljava/util/Map;", "Companion", "PendingEndEvent", "ActiveSession", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceCaptureStateProducer implements jha.j, IVoiceCaptureStateProducerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f393148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f393149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f393150c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f393151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jha.l<h0> f393152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final u f393153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final VoiceCaptureScene f393154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f393155e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f393151a, r101.f393151a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393152b, r101.f393152b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f393153c, r101.f393153c) == true) goto L18;
            return false;
        L18:
            if (this.f393154d == r101.f393154d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f393155e, r101.f393155e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f393151a.hashCode() * 31) + this.f393152b.hashCode()) * 31) + this.f393153c.hashCode()) * 31) + this.f393154d.hashCode()) * 31;
            Integer r101 = this.f393155e;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ActiveSession(sessionId=" + this.f393151a + ", handle=" + this.f393152b + ", taskMetadata=" + this.f393153c + ", scene=" + this.f393154d + ", sourceType=" + this.f393155e + ')';
        }

        public a(String r100, jha.l<h0> r101, u r102, VoiceCaptureScene r103, Integer r104) {
            Intrinsics.checkNotNullParameter(r100, "sessionId");
            Intrinsics.checkNotNullParameter(r101, "handle");
            Intrinsics.checkNotNullParameter(r102, "taskMetadata");
            Intrinsics.checkNotNullParameter(r103, "scene");
            this.f393151a = r100;
            this.f393152b = r101;
            this.f393153c = r102;
            this.f393154d = r103;
            this.f393155e = r104;
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f393156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final VoiceCaptureScene f393157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f393158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f393159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Job f393160e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f393156a, r101.f393156a) == true) goto L12;
            return false;
        L12:
            if (this.f393157b == r101.f393157b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f393158c, r101.f393158c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f393159d, r101.f393159d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f393160e, r101.f393160e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f393156a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = ((r102 * 31) + this.f393157b.hashCode()) * 31;
            Integer r104 = this.f393158c;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f393159d;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return ((r106 + r101) * 31) + this.f393160e.hashCode();
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "PendingEndEvent(conversationId=" + this.f393156a + ", scene=" + this.f393157b + ", sourceType=" + this.f393158c + ", sessionId=" + this.f393159d + ", timeoutJob=" + this.f393160e + ')';
        }

        public c(String r100, VoiceCaptureScene r101, Integer r102, String r103, Job r104) {
            Intrinsics.checkNotNullParameter(r101, "scene");
            Intrinsics.checkNotNullParameter(r104, "timeoutJob");
            this.f393156a = r100;
            this.f393157b = r101;
            this.f393158c = r102;
            this.f393159d = r103;
            this.f393160e = r104;
        }
    }

    static {
    }

    public VoiceCaptureStateProducer() {
        ExecutorCoroutineDispatcher r100 = jha.f.f499127a;
        this.f393148a = jha.f.f499128b;
        this.f393149b = new ConcurrentHashMap();
        this.f393150c = new ConcurrentHashMap();
    }

    public static Map h(Integer r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 != null) goto L6;
    L8:
        return r101;
    L6:
        if (r100.intValue() != 4) goto L8;
        r101.put("is_from_continuous_intents", "1");
        goto L8
    }

    public static final String g(VoiceCaptureStateProducer r100, String r101, VoiceCaptureScene r102) {
        r100.getClass();
        StringBuilder r103 = new StringBuilder();
        r103.append(r102.name());
        r103.append('#');
        if (r101 != null) goto L5;
        r101 = "unknown_session";
    L5:
        r103.append(r101);
        return r103.toString();
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void c(String r110, VoiceCaptureScene r111, String r112, Integer r113) {
        Intrinsics.checkNotNullParameter(r111, "scene");
        BuildersKt.launch$default(this.f393148a, null, null, new VoiceCaptureStateProducer$onAsrStart$1(this, r110, r111, r112, r113, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void d(String r110, VoiceCaptureScene r111, String r112, Integer r113) {
        Intrinsics.checkNotNullParameter(r111, "scene");
        BuildersKt.launch$default(this.f393148a, null, null, new VoiceCaptureStateProducer$end$1(this, r110, r111, r112, r113, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void e(String r110, VoiceCaptureScene r111, String r112, Integer r113) {
        Intrinsics.checkNotNullParameter(r111, "scene");
        BuildersKt.launch$default(this.f393148a, null, null, new VoiceCaptureStateProducer$onAsrEnd$1(this, r110, r111, r112, r113, null), 3, null);
    }

    public final Unit i(String r100, String r110, VoiceCaptureScene r111, Integer r112) {
        a r101 = this.f393149b.remove(r100);
        if (r101 == null) goto L5;
        TaskFlowDslKt.c(r101.f393152b, new h0.c(r110, r111, r112, h(r112), r101.f393153c));
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void a(String r110, VoiceCaptureScene r111, int r112, String r113, Integer r114) {
        Intrinsics.checkNotNullParameter(r111, "scene");
        if (r112 != 3) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f393148a, null, null, new VoiceCaptureStateProducer$onCallStateChanged$1(this, r110, r111, r112, r113, r114, null), 3, null);
    }

    @Override // com.obric.assistant.state.api.multitask.IVoiceCaptureStateProducerService
    public final void b(String r110, VoiceCaptureScene r111, String r112, Integer r113, String r114) {
        Intrinsics.checkNotNullParameter(r111, "scene");
        BuildersKt.launch$default(this.f393148a, null, null, new VoiceCaptureStateProducer$start$1(r112, r110, r114, r111, r113, this, null), 3, null);
    }
}
