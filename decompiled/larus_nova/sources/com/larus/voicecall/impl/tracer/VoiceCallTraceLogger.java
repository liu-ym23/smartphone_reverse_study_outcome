package com.larus.voicecall.impl.tracer;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ai.event.MessageIndication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: classes32.dex */
public final class VoiceCallTraceLogger {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final f2a.d f379094l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set<String> f379095m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Set<String> f379096n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f379097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f379098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Channel<Function0<Unit>> f379099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f379100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f379101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f379102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f379103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f379104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<v> f379105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f379106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Boolean f379107k;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.tracer.VoiceCallTraceLogger$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.tracer.VoiceCallTraceLogger$1", f = "VoiceCallTraceLogger.kt", i = {0}, l = {203}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ VoiceCallTraceLogger this$0;

        public AnonymousClass1(VoiceCallTraceLogger r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0041 -> B:13:0x0047). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ChannelIterator<Function0<Unit>> r103 = (ChannelIterator) this.L$1;
            CoroutineScope r104 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r100);
            CoroutineScope r105 = r104;
            ChannelIterator<Function0<Unit>> r106 = r103;
            Object r107 = r101;
            AnonymousClass1 r108 = this;
        L14:
            if (((Boolean) r100).booleanValue() == false) goto L22;
            Function0<Unit> r109 = r106.next();
            Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L18
            r109.invoke();     // Catch: Throwable -> L18
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L18
        L20:
            AnonymousClass1 r111 = r108;
            r101 = r107;
            ChannelIterator<Function0<Unit>> r112 = r106;
            CoroutineScope r113 = r105;
        L9:
            r111.L$0 = r113;
            r111.L$1 = r112;
            r111.label = 1;
            Object r114 = r112.hasNext(r111);
            if (r114 != r101) goto L12;
            return r101;
        L12:
            Object r115 = r101;
            r108 = r111;
            r100 = r114;
            r105 = r113;
            r106 = r112;
            r107 = r115;
        L18:
            th = move-exception;
            Result.Companion r116 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L20
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CoroutineScope r117 = (CoroutineScope) this.L$0;
            r112 = this.this$0.f379099c.iterator();
            r113 = r117;
            r111 = this;
            goto L9
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.larus.voicecall.impl.tracer.VoiceCallTraceLogger$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4533a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f379108a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f379109b = null;

            static {
                int[] r100 = new int[ReplyAudioPhase.values().length];
                r100[ReplyAudioPhase.BEGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[ReplyAudioPhase.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L6:
                f379108a = r100;
                int[] r101 = new int[VoiceCallTraceReplyType.values().length];
                r101[VoiceCallTraceReplyType.REPLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
            L21:
                r101[VoiceCallTraceReplyType.CHIME_IN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
            L9:
                f379109b = r101;
            }
        }

        public a() {
        }

        public static final ReplyAudioEventType a(VoiceCallTraceReplyType r100) {
            f2a.d r101 = VoiceCallTraceLogger.f379094l;
            int r102 = C4533a.f379109b[r100.ordinal()];
            if (r102 == 1) goto L10;
            if (r102 != 2) goto L8;
            return ReplyAudioEventType.CHIME_IN_END;
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return ReplyAudioEventType.REPLY_END;
        }

        public static final Map b(String r100, String r101, long r102, long r103, String r110, Boolean r111, String r112, String r113) {
            f2a.d r104 = VoiceCallTraceLogger.f379094l;
            boolean r105 = false;
            LinkedHashMap r106 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(HTTP.SID, r100), TuplesKt.to("call_round", Long.valueOf(r102)), TuplesKt.to("trace_round", Long.valueOf(r103)), TuplesKt.to("timestamp_ms", Long.valueOf(System.currentTimeMillis()))});
            if (r111 == null) goto L6;
            r106.put("is_model_proactive_speak", Integer.valueOf(r111.booleanValue() ? 1 : 0));
        L6:
            if (r110.length() <= 0) goto L8;
            boolean r107 = true;
        L9:
            if (r107 == false) goto L22;
            r106.put("trace_message_id", r110);
            if (r103 > 0) goto L14;
        L20:
            r106.put("trace_key", r110);
            goto L22
        L14:
            if (r110.length() != 0) goto L16;
            boolean r108 = true;
        L17:
            if (r108 == false) goto L19;
            r110 = String.valueOf(r103);
            goto L20
        L19:
            r110 = r103 + '_' + r110;
            goto L20
        L16:
            r108 = false;
        L22:
            if (r101.length() <= 0) goto L24;
            boolean r109 = true;
        L25:
            if (r109 == false) goto L27;
            r106.put("room_id", r101);
        L27:
            if (r112 != null) goto L29;
        L32:
            boolean r114 = true;
        L33:
            if (r114 == true) goto L35;
            r106.put("last_asr_task_id", r112);
        L35:
            if (r113 != null) goto L37;
        L38:
            r105 = true;
        L39:
            if (r105 == true) goto L41;
            r106.put("last_tts_task_id", r113);
        L41:
            return r106;
        L37:
            if (r113.length() != 0) goto L39;
        L29:
            if (r112.length() == 0) goto L32;
            r114 = false;
            goto L33
        L24:
            r109 = false;
            goto L25
        L8:
            r107 = false;
            goto L9
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f379110a = null;

        static {
            int[] r100 = new int[ReplyAudioPhase.values().length];
            r100[ReplyAudioPhase.BEGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ReplyAudioPhase.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f379110a = r100;
        }
    }

    static {
        new a();
        f379094l = new f2a.d("flow-call", "VoiceCallTraceLogger");
        f379095m = SetsKt.setOf(new String[]{"player_status_end", "reply_end_pushed", "check_reply_status", "auto_end_on_new_begin", "auto_end_on_drain", "auto_end_on_release"});
        f379096n = SetsKt.setOf(new String[]{"player_status_end", "inner_play_tail", "outer_play_tail", "check_reply_status", "auto_end_on_new_begin", "auto_end_on_drain", "auto_end_on_release"});
    }

    public VoiceCallTraceLogger() {
        CoroutineScope r100 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().limitedParallelism(1).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f379097a = r100;
        this.f379098b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f379099c = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        BuildersKt.launch$default(r100, null, null, new AnonymousClass1(this, null), 3, null);
        this.f379103g = "";
        this.f379105i = new ArrayList();
        this.f379106j = new ArrayList();
    }

    public final void d(z r100) {
        p r101 = this.f379104h;
        if (r101 == null) goto L6;
        b(r101, System.currentTimeMillis(), r100, "auto_end_on_drain");
    L6:
        if (((ArrayList) this.f379105i).isEmpty() == false) goto L8;
        return;
    L8:
        e("reply.round", f(r100));
        ((ArrayList) this.f379105i).clear();
    }

    public final Map<String, Object> f(z r110) {
        String r100 = r110.f379256c;
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        r100 = this.f379103g;
    L8:
        String r102 = r110.f379254a;
        String r103 = r110.f379255b;
        long r104 = this.f379100d;
        long r105 = this.f379101e;
        return a.b(r102, r103, r104, r105, r100, Boolean.valueOf(this.f379102f), r110.f379257d, r110.f379258e);
    L5:
        r101 = false;
        goto L6
    }

    public final void h(Function0<Unit> r100) {
        this.f379099c.mo10962trySendJP2dKIU(r100);
    }

    public static void e(String r100, Map r101) {
        f2a.c r102 = f379094l.b(r100);
        Set r103 = r101.entrySet();
        LinkedHashMap r104 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r103, 10)), 16));
        Iterator r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        Map.Entry r106 = (Map.Entry) r105.next();
        Pair r107 = TuplesKt.to(new f2a.f((String) r106.getKey()), r106.getValue());
        r104.put(r107.getFirst(), r107.getSecond());
        goto L4
    L6:
        r102.d(r104);
        f2a.c.c(r102, null, 15);
    }

    public final void a(final ReplyAudioEventType r100, final String r101, final z r110, final String r111) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "endType");
        Intrinsics.checkNotNullParameter(r110, "baseContext");
        Intrinsics.checkNotNullParameter(r111, "source");
        h(new a0(this, r100, r101, r110, r111));
    }

    public final void b(p r100, long r101, z r110, String r111) {
        ReplyAudioEventType r102 = a.a(r100.f379222a);
        this.f379104h = null;
        g(r102, r101, MessageIndication.STATUS_INTERRUPT, r110, r111);
    }

    public final void c(ReplyAudioEventType r110, String r111, z r112, String r113) {
        long r100 = System.currentTimeMillis();
        ReplyAudioPhase r101 = r110.getPhase();
        int r102 = b.f379110a[r101.ordinal()];
        boolean r103 = true;
        if (r102 != 1) goto L5;
        p r104 = this.f379104h;
        if (r104 == null) goto L19;
        b(r104, r100, r112, "auto_end_on_new_begin");
    L19:
        this.f379104h = new p(r110.getKind(), r100);
    L20:
        if (r103 == true) goto L22;
        return;
    L22:
        g(r110, r100, r111, r112, r113);
        return;
    L5:
        if (r102 != 2) goto L15;
        VoiceCallTraceReplyType r105 = r110.getKind();
        p r106 = this.f379104h;
        if (r106 != null) goto L10;
    L12:
        r103 = false;
        goto L20
    L10:
        if (r106.f379222a == r105) goto L13;
        b(r106, r100, r112, "auto_end_on_new_begin");
        goto L12
    L13:
        this.f379104h = null;
        goto L20
    L15:
        throw new NoWhenBranchMatchedException();
    }

    public final void g(ReplyAudioEventType r100, long r101, String r102, z r103, String r104) {
        List<v> r105 = this.f379105i;
        ArrayList r106 = (ArrayList) r105;
        r106.add(new v(r100, r101, r102));
        Map<String, Object> r107 = f(r103);
        r107.put("event_type", r100.getEventType());
        r107.put("end_type", r102);
        r107.put("source", r104);
        ReplyAudioPhase r108 = r100.getPhase();
        int r109 = a.C4533a.f379108a[r108.ordinal()];
        if (r109 == 1) goto L20;
        if (r109 != 2) goto L18;
        VoiceCallTraceReplyType r110 = r100.getKind();
        VoiceCallTraceReplyType r111 = VoiceCallTraceReplyType.REPLY;
        if (r110 != r111) goto L9;
        Set<String> r112 = f379095m;
    L11:
        if (r112.contains(r104) == false) goto L14;
        String r113 = "playback_end";
    L26:
        r107.put("semantic_stage", r113);
        e(r100.getWhat(), r107);
        return;
    L14:
        if (r100.getKind() != r111) goto L16;
        r113 = "reply_end";
        goto L26
    L16:
        r113 = "chime_in_end";
        goto L26
    L9:
        r112 = f379096n;
        goto L11
    L18:
        throw new NoWhenBranchMatchedException();
    L20:
        if (Intrinsics.areEqual(r104, "audio_first_frame") == false) goto L23;
        r113 = "playback_start";
        goto L26
    L23:
        if (r100.getKind() != VoiceCallTraceReplyType.REPLY) goto L25;
        r113 = "reply_begin";
        goto L26
    L25:
        r113 = "chime_in_begin";
        goto L26
    }
}
