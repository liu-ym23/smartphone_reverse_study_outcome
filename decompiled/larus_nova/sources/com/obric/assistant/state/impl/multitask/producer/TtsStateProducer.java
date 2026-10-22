package com.obric.assistant.state.impl.multitask.producer;

import aha.e0;
import aha.f0;
import aha.u;
import com.larus.audio.controller.GlobalAudioStateEnum;
import com.larus.audio.observer.GlobalAudioObserver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016JH\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0018H\u0082@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\bH\u0002J2\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u001f2\u0006\u0010\u001b\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006%"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/TtsStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeTtsTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/obric/assistant/state/impl/multitask/producer/TtsStateProducer$ActiveTtsTask;", "playingRefreshJobs", "Lkotlinx/coroutines/Job;", "initProducer", "", "globalAudioCallback", "com/obric/assistant/state/impl/multitask/producer/TtsStateProducer$globalAudioCallback$1", "Lcom/obric/assistant/state/impl/multitask/producer/TtsStateProducer$globalAudioCallback$1;", "emitTtsTaskState", "audioScene", "state", "Lcom/larus/audio/controller/GlobalAudioStateEnum;", "conversationId", "messageId", "bizExtra", "", "(Ljava/lang/String;Lcom/larus/audio/controller/GlobalAudioStateEnum;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startPlayingRefresh", "taskKey", "activeTask", "stopPlayingRefresh", "findActiveTask", "Lkotlin/Pair;", "endTtsTasksByScene", "scene", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ActiveTtsTask", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsStateProducer implements TaskFlowAutoInitProducer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f393140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f393141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, Job> f393142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TtsStateProducer$globalAudioCallback$1 f393143d;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jha.l<e0> f393144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e0 f393145b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f393144a, r101.f393144a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393145b, r101.f393145b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393144a.hashCode() * 31) + this.f393145b.hashCode();
        }

        public final String toString() {
            return "ActiveTtsTask(handle=" + this.f393144a + ", state=" + this.f393145b + ')';
        }

        public a(jha.l<e0> r100, e0 r101) {
            Intrinsics.checkNotNullParameter(r100, "handle");
            Intrinsics.checkNotNullParameter(r101, "state");
            this.f393144a = r100;
            this.f393145b = r101;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class b {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f393146a = null;

        static {
            int[] r100 = new int[GlobalAudioStateEnum.values().length];
            r100[GlobalAudioStateEnum.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[GlobalAudioStateEnum.PAUSED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[GlobalAudioStateEnum.STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f393146a = r100;
        }
    }

    static {
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        FLogger.f375446a.i("TtsStateProducer", "initProducer");
        GlobalAudioObserver.f289772a.b(this.f393143d);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        FLogger.f375446a.e("TtsStateProducer", "failed to register GlobalAudioObserver", th);
    }

    public TtsStateProducer() {
        ExecutorCoroutineDispatcher r100 = jha.f.f499127a;
        this.f393140a = jha.f.f499128b;
        this.f393141b = new ConcurrentHashMap();
        this.f393142c = new ConcurrentHashMap();
        this.f393143d = new TtsStateProducer$globalAudioCallback$1(this);
    }

    public final Pair<String, a> b(String r100, String r101, String r102) {
        a r103 = this.f393141b.get(r100);
        if (r103 != null) goto L5;
        Set<Map.Entry<String, a>> r104 = this.f393141b.entrySet();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L12;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((a) ((Map.Entry) r107).getValue()).f393145b.d(), r101) == false) goto L8;
        r105.add(r107);
        goto L8
    L12:
        Iterator r108 = r105.iterator();
    L14:
        if (r108.hasNext() == false) goto L18;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((a) ((Map.Entry) r109).getValue()).f393145b.f(), r102) == false) goto L14;
    L19:
        Map.Entry r110 = (Map.Entry) r109;
        if (r110 != null) goto L22;
        Iterator r111 = r105.iterator();
        boolean r112 = false;
        Object r113 = null;
    L25:
        if (r111.hasNext() == false) goto L31;
        Object r114 = r111.next();
        if ((((a) ((Map.Entry) r114).getValue()).f393145b instanceof e0.c) == false) goto L25;
        if (r112 == true) goto L32;
        r112 = true;
        r113 = r114;
    L32:
        r113 = null;
    L33:
        Map.Entry r115 = (Map.Entry) r113;
        if (r115 != null) goto L36;
        return null;
    L36:
        return TuplesKt.to(r115.getKey(), r115.getValue());
    L31:
        if (r112 == true) goto L33;
    L22:
        return TuplesKt.to(r110.getKey(), r110.getValue());
    L18:
        r109 = null;
        goto L19
    L5:
        return TuplesKt.to(r100, r103);
    }

    public static final Object a(TtsStateProducer r110, String r111, GlobalAudioStateEnum r210, String r211, String r212, Map r213, Continuation r214) {
        r110.getClass();
        if ((r214 instanceof TtsStateProducer$emitTtsTaskState$1) == false) goto L7;
        TtsStateProducer$emitTtsTaskState$1 r100 = (TtsStateProducer$emitTtsTaskState$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        TtsStateProducer$emitTtsTaskState$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        a r106 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        e0.b r107 = (e0.b) r102.L$1;
        String r108 = (String) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L46:
        jha.m r109 = (jha.m) r103;
        if (r109 == null) goto L62;
        r110.f393141b.put(r108, new a(r109.f499141a, r107));
        if (r109.f499142b == true) goto L52;
        TaskFlowDslKt.f(r109.f499141a, r107);
    L52:
        String r112 = r108;
    L53:
        a r113 = r110.f393141b.get(r112);
        if (r113 == null) goto L63;
        Job r114 = r110.f393142c.remove(r112);
        if (r114 == null) goto L59;
        Job.DefaultImpls.cancel$default(r114, null, 1, null);
    L59:
        r110.f393142c.put(r112, BuildersKt.launch$default(r110.f393140a, null, null, new TtsStateProducer$startPlayingRefresh$1(r110, r112, r113, null), 3, null));
    L61:
        return Unit.INSTANCE;
    L63:
        return Unit.INSTANCE;
    L62:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        jha.g<e0> r115 = f0.a(r211, r212, r111);
        int r116 = m.f393175a;
        u r117 = m.d(r211, (String) r213.get("bot_id"), null, 12);
        int r118 = c.f393146a[r210.ordinal()];
        if (r118 != 1) goto L17;
        Pair<String, a> r119 = r110.b(r115.f499134a, r111, r212);
        if (r119 == null) goto L35;
        String r120 = r119.getFirst();
        if (r120 == null) goto L35;
    L36:
        r112 = r120;
        e0.b r121 = new e0.b(r111, r211, r212, r213, r117);
        if (r119 == null) goto L39;
        a r122 = r119.getSecond();
    L40:
        if (r122 == null) goto L42;
        FLogger.f375446a.i("TtsStateProducer", "TTS already playing, update instead of start, taskKey=" + r112);
        ConcurrentHashMap<String, a> r123 = r110.f393141b;
        jha.l<e0> r124 = r122.f393144a;
        Intrinsics.checkNotNullParameter(r124, "handle");
        Intrinsics.checkNotNullParameter(r121, "state");
        r123.put(r112, new a(r124, r121));
        TaskFlowDslKt.f(r122.f393144a, r121);
        goto L53
    L42:
        jha.c r125 = jha.j.a.a(r110);
        r102.L$0 = r112;
        r102.L$1 = r121;
        r102.label = 1;
        r103 = TaskFlowDslKt.e(r115, r121, r125, r102);
        if (r103 == r104) goto L64;
        r108 = r112;
        r107 = r121;
        goto L46
    L64:
        return r104;
    L39:
        r122 = null;
    L35:
        r120 = r115.f499134a;
        goto L36
    L17:
        if (r118 != 2) goto L19;
    L21:
        Pair<String, a> r126 = r110.b(r115.f499134a, r111, r212);
        if (r126 == null) goto L27;
        String r127 = r126.component1();
        Job r128 = r110.f393142c.remove(r127);
        if (r128 == null) goto L26;
        Job.DefaultImpls.cancel$default(r128, null, 1, null);
    L26:
        r106 = r110.f393141b.remove(r127);
    L27:
        if (r106 == null) goto L61;
        jha.l<e0> r129 = r106.f393144a;
        if (r129 == null) goto L61;
        TaskFlowDslKt.c(r129, new e0.a(r106.f393145b.d(), r106.f393145b.e(), r106.f393145b.f(), r213, r106.f393145b.b()));
        goto L61
    L19:
        if (r118 == 3) goto L21;
    L7:
        r100 = new TtsStateProducer$emitTtsTaskState$1(r110, r214);
        goto L8
    }
}
