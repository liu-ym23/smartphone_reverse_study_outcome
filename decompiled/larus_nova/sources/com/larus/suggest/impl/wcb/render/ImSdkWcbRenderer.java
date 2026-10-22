package com.larus.suggest.impl.wcb.render;

import android.os.SystemClock;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.chat.bean.NexPulseCandidate;
import com.larus.bmhome.chat.bean.NexPulseConf;
import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.bean.SuggestItemType;
import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class ImSdkWcbRenderer implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f370012c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kx9.a f370013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f370014b;

    public final class Transaction implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k f370015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f370016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ImSdkWcbRenderer f370017c;

        @Override // com.larus.suggest.impl.wcb.render.q
        public final void c() {
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final void cancel() {
            FLogger.f375446a.i("WcbLog", "[render] transaction.cancel chat=" + this.f370015a.f370053a.f370116d + " exec=" + this.f370015a.f370053a.f370117e);
            this.f370016b = false;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final boolean isActive() {
            return this.f370016b;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final Object b(Continuation<? super Unit> r100) {
            FLogger.f375446a.i("WcbLog", "[render] im.transaction.finish chat=" + this.f370015a.f370053a.f370116d + " exec=" + this.f370015a.f370053a.f370117e);
            this.f370016b = false;
            return Unit.INSTANCE;
        }

        public Transaction(ImSdkWcbRenderer r100, k r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f370017c = r100;
            this.f370015a = r101;
            this.f370016b = true;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final Object a(l r110, Continuation<? super n> r111) {
            if ((r111 instanceof ImSdkWcbRenderer$Transaction$render$1) == false) goto L7;
            ImSdkWcbRenderer$Transaction$render$1 r100 = (ImSdkWcbRenderer$Transaction$render$1) r111;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            ImSdkWcbRenderer$Transaction$render$1 r102 = r100;
            Object r103 = r102.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r102.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            l r106 = (l) r102.L$0;
            ResultKt.throwOnFailure(r103);
            String r112 = " active=";
        L32:
            FLogger.f375446a.i("WcbLog", "[render] im.result chat=" + this.f370015a.f370053a.f370116d + " exec=" + this.f370015a.f370053a.f370117e + " plan=" + r106.getClass().getSimpleName() + " result=" + ((n) r103).getClass().getSimpleName() + r112 + this.f370016b);
            return r103;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            FLogger r107 = FLogger.f375446a;
            r107.i("WcbLog", "[render] im.render chat=" + this.f370015a.f370053a.f370116d + " exec=" + this.f370015a.f370053a.f370117e + " plan=" + r110.getClass().getSimpleName() + " active=" + this.f370016b);
            if (this.f370016b == false) goto L17;
            ImSdkWcbRenderer r113 = this.f370017c;
            k r108 = this.f370015a;
            com.larus.suggest.impl.wcb.request.f r109 = r108.f370053a;
            jx9.a r114 = r108.f370054b;
            r102.L$0 = r110;
            r102.label = 1;
            r113.getClass();
            if ((r110 instanceof l.a) == false) goto L21;
            r112 = " active=";
            r103 = r113.d(((l.a) r110).f370056a, new ImSdkWcbRenderer$renderPlan$2(r113, r109, r110, r114, null), r102);
        L29:
            if (r103 != r104) goto L31;
            return r104;
        L31:
            r106 = r110;
            goto L32
        L21:
            r112 = " active=";
            if ((r110 instanceof l.c) == false) goto L25;
            r103 = r113.d(((l.c) r110).f370060b, new ImSdkWcbRenderer$renderPlan$3(r113, r110, r114, null), r102);
            goto L29
        L25:
            if ((r110 instanceof l.b) == false) goto L35;
            p r115 = ((l.b) r110).f370058a;
            kotlinx.coroutines.j r116 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
            r116.C();
            r107.i("WcbLog", "[render] im.deprecate target=" + r115.f370069a);
            AtomicBoolean r117 = new AtomicBoolean(false);
            r116.i(new d(r117));
            com.larus.im.d.e().x(StringsKt.removeSuffix(r115.f370069a, ":fake_message:1"), new e(r113), new f(r116, r117, r113, r115));
            r103 = r116.B();
            if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
            DebugProbesKt.probeCoroutineSuspended(r102);
            goto L29
        L35:
            throw new NoWhenBranchMatchedException();
        L17:
            return new n.a("wcb render transaction inactive");
        L7:
            r100 = new ImSdkWcbRenderer$Transaction$render$1(this, r111);
            goto L8
        }
    }

    public static final class a {
    }

    public static final class b implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f370018a;

        public b(AtomicBoolean r100) {
            this.f370018a = r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            this.f370018a.set(true);
            return Unit.INSTANCE;
        }
    }

    public static final class c implements IIMCallback<Message> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f370019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<n> f370020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f370021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ImSdkWcbRenderer f370022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ jx9.a f370023e;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !y0.a();
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            FLogger.f375446a.e("WcbLog", "[render] im.callback onFailure operation=" + this.f370019a + " success=false cancelled=" + this.f370020b.isCancelled());
            if (this.f370021c.compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            kx9.a r101 = this.f370022d.f370013a;
            jx9.a r102 = this.f370023e;
            r101.getClass();
            Intrinsics.checkNotNullParameter(r102, "traceData");
            r102.f500935g = SystemClock.elapsedRealtime();
            kx9.a.d(this.f370022d.f370013a, this.f370023e, r100.toString(), false, 12);
            kotlinx.coroutines.i<n> r103 = this.f370020b;
            Result.Companion r104 = Result.Companion;
            r103.resumeWith(Result.m9449constructorimpl(new n.a(this.f370019a + " failed: " + r100)));
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Message r100) {
            Message r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            FLogger.f375446a.i("WcbLog", "[render] im.callback onSuccess operation=" + this.f370019a + " success=true promptKeyInfo=" + gx9.p.b(r101) + " cancelled=" + this.f370020b.isCancelled());
            if (this.f370021c.compareAndSet(false, true) == false) goto L7;
            kx9.a r102 = this.f370022d.f370013a;
            jx9.a r103 = this.f370023e;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "traceData");
            r103.f500935g = SystemClock.elapsedRealtime();
            kx9.a r104 = this.f370022d.f370013a;
            jx9.a r105 = this.f370023e;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r105, "traceData");
            JSONObject r106 = new JSONObject();
            r106.put("success", "1");
            kx9.a.b(r106, r105);
            kx9.a.a(r106, r105);
            com.larus.platform.service.o.f365780a.reportEvent("dev_wcb_monitor_event", r106);
            kotlinx.coroutines.i<n> r107 = this.f370020b;
            Result.Companion r108 = Result.Companion;
            r107.resumeWith(Result.m9449constructorimpl(ImSdkWcbRenderer.b(this.f370022d, r101)));
            return;
        }

        public c(String r100, kotlinx.coroutines.j r101, AtomicBoolean r102, ImSdkWcbRenderer r103, jx9.a r104) {
            this.f370019a = r100;
            this.f370020b = r101;
            this.f370021c = r102;
            this.f370022d = r103;
            this.f370023e = r104;
        }
    }

    static {
    }

    public ImSdkWcbRenderer(kx9.a r100) {
        j r101 = new j();
        Intrinsics.checkNotNullParameter(r100, "monitor");
        Intrinsics.checkNotNullParameter(r101, "extMapper");
        this.f370013a = r100;
        this.f370014b = r101;
    }

    @Override // com.larus.suggest.impl.wcb.render.r
    public final q a(k r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new Transaction(this, r100);
    }

    public static final n b(ImSdkWcbRenderer r100, Message r101) {
        r100.getClass();
        String r102 = r101.getLocalMessageId();
        if (r102 == null) goto L18;
        if (r102.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L18;
        Map<String, String> r104 = r101.getExt();
        if (r104 != null) goto L19;
        r104 = MapsKt.emptyMap();
    L19:
        return new n.b(r102, MapsKt.toMap(r104));
    L7:
        r103 = false;
    L18:
        return new n.a("submitted wcb has no localMessageId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    public final Object d(i r210, Function2<? super Map<String, String>, ? super Continuation<? super n>, ? extends Object> r211, Continuation<? super n> r212) {
        this.f370014b.getClass();
        Intrinsics.checkNotNullParameter(r210, "presentation");
        NexPulseResponseData r100 = r210.f370050b;
        Integer r101 = r100.getNexPulseType();
        String r110 = null;
        if (r101 != null) goto L6;
    L74:
        if (r101 != null) goto L77;
    L113:
        if (r101 != null) goto L116;
    L146:
        Map r102 = MapsKt.emptyMap();
    L148:
        if (r102.isEmpty() == false) goto L152;
        return new n.a("create wcb extra failed");
    L152:
        return r211.invoke(r102, r212);
    L116:
        if (r101.intValue() != 4) goto L146;
        Type r103 = gx9.p.f483266a;
        Intrinsics.checkNotNullParameter(r100, "resp");
        List<NexPulseCandidate> r104 = r100.getCandidateList();
        if (r104 == null) goto L122;
        NexPulseCandidate r105 = (NexPulseCandidate) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L122;
        r110 = r105.getLogId();
    L122:
        if (r110 != null) goto L124;
        String r106 = "";
    L125:
        List<NexPulseCandidate> r107 = r100.getCandidateList();
        if (r107 == null) goto L131;
        List<NexPulseCandidate> r108 = r107;
        Object r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r111 = r108.iterator();
    L129:
        if (r111.hasNext() == false) goto L132;
        r109.add(((NexPulseCandidate) r111.next()).toOnboardingSugItem());
    L132:
        String r112 = GsonProtectorUtils.toJson(HttpExtKt.f360123f, r109);
        Pair[] r113 = new Pair[8];
        r113[0] = TuplesKt.to("onboarding_sug", r112);
        r113[1] = TuplesKt.to("onboarding_display_style", "vertical");
        r113[2] = TuplesKt.to("onboarding_sug_type", String.valueOf(SuggestItemType.VideoRichMediaWelcomeBack.getValue()));
        r113[3] = TuplesKt.to("wcb_message_hidden", "true");
        NexPulseConf r114 = r100.getConf();
        if (r114 == null) goto L138;
        Long r115 = r114.getExpireTime();
        if (r115 == null) goto L138;
        String r116 = r115.toString();
        if (r116 == null) goto L138;
    L139:
        r113[4] = TuplesKt.to("onboarding_sug_expiration_time", r116);
        r113[5] = TuplesKt.to("inner_log_id", r106);
        r113[6] = TuplesKt.to("log_id", r106);
        r113[7] = TuplesKt.to("next_pulse_type", String.valueOf(r100.getNexPulseType()));
        r102 = MapsKt.mutableMapOf(r113);
        List<NexPulseCandidate> r117 = r100.getCandidateList();
        if (r117 == null) goto L148;
        NexPulseCandidate r118 = (NexPulseCandidate) CollectionsKt.firstOrNull(r117);
        if (r118 == null) goto L148;
        String r119 = r118.getClickClearContext();
        if (r119 == null) goto L148;
        r102.put("click_clear_context", r119);
    L138:
        r116 = "0";
        goto L139
    L131:
        r109 = CollectionsKt.emptyList();
        goto L132
    L124:
        r106 = r110;
        goto L125
    L77:
        if (r101.intValue() != 2) goto L113;
        Type r120 = gx9.p.f483266a;
        Intrinsics.checkNotNullParameter(r100, "resp");
        String r121 = GsonProtectorUtils.toJson(HttpExtKt.f360123f, r100);
        List<NexPulseCandidate> r122 = r100.getCandidateList();
        if (r122 == null) goto L83;
        NexPulseCandidate r123 = (NexPulseCandidate) CollectionsKt.firstOrNull(r122);
        if (r123 == null) goto L83;
        String r124 = r123.getLogId();
    L84:
        if (r124 != null) goto L86;
        r124 = "";
    L86:
        Pair[] r125 = new Pair[7];
        r125[0] = TuplesKt.to("wcb_message_hidden", "true");
        NexPulseConf r126 = r100.getConf();
        if (r126 == null) goto L92;
        Long r127 = r126.getExpireTime();
        if (r127 == null) goto L92;
        String r128 = r127.toString();
        if (r128 == null) goto L92;
    L93:
        r125[1] = TuplesKt.to("onboarding_sug_expiration_time", r128);
        r125[2] = TuplesKt.to("inner_log_id", r124);
        r125[3] = TuplesKt.to("log_id", r124);
        NexPulseConf r129 = r100.getConf();
        if (r129 == null) goto L96;
        r110 = r129.getWcbTitle();
    L96:
        if (r110 != null) goto L98;
        String r130 = "";
    L99:
        r125[4] = TuplesKt.to("wcb_title", r130);
        r125[5] = TuplesKt.to("next_pulse_resp_data", r121);
        r125[6] = TuplesKt.to("next_pulse_type", String.valueOf(r100.getNexPulseType()));
        r102 = MapsKt.mutableMapOf(r125);
        List<NexPulseCandidate> r131 = r100.getCandidateList();
        if (r131 == null) goto L106;
        NexPulseCandidate r132 = (NexPulseCandidate) CollectionsKt.firstOrNull(r131);
        if (r132 == null) goto L106;
        String r133 = r132.getClickClearContext();
        if (r133 == null) goto L106;
        String r134 = (String) r102.put("click_clear_context", r133);
    L106:
        List<NexPulseCandidate> r135 = r100.getCandidateList();
        if (r135 == null) goto L148;
        NexPulseCandidate r136 = (NexPulseCandidate) CollectionsKt.firstOrNull(r135);
        if (r136 == null) goto L148;
        String r137 = r136.getCardName();
        if (r137 == null) goto L148;
        r102.put("next_pulse_card_name", r137);
        goto L148
    L98:
        r130 = r110;
    L92:
        r128 = "0";
    L83:
        r124 = null;
        goto L84
    L6:
        if (r101.intValue() != 1) goto L74;
        int r138 = r210.f370049a;
        String r139 = r210.f370051c;
        if (r139 == null) goto L10;
        Map r140 = MapsKt.mapOf(TuplesKt.to("wcb_render_status", r139));
    L11:
        boolean r141 = r210.f370052d;
        Type r213 = gx9.p.f483266a;
        Intrinsics.checkNotNullParameter(r100, "resp");
        List<PromptContent.SuggestItem> r142 = r100.toSuggestItems(Boolean.valueOf(r141));
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L18
        Object r214 = "click_clear_context";
        Object r144 = Result.m9449constructorimpl(HttpExtKt.f360123f.toJson(r142, gx9.p.f483266a));     // Catch: Throwable -> L16
    L22:
        if (Result.m9455isFailureimpl(r144) == false) goto L24;
        r144 = null;
    L24:
        String r145 = (String) r144;
        if (r145 != null) goto L28;
        r102 = MapsKt.emptyMap();
        goto L148
    L28:
        if (r142.isEmpty() == false) goto L35;
        if (r140 == null) goto L31;
        String r146 = (String) r140.get("wcb_render_status");
    L33:
        if (Intrinsics.areEqual(r146, WcbRenderStatus.DEPRECATED) == true) goto L35;
        r102 = MapsKt.emptyMap();
        goto L148
    L31:
        r146 = null;
    L35:
        List<NexPulseCandidate> r147 = r100.getCategoryCandidateList();
        if (r147 == null) goto L39;
        NexPulseCandidate r148 = (NexPulseCandidate) CollectionsKt.firstOrNull(r147);
        if (r148 == null) goto L39;
    L43:
        if (r148 == null) goto L45;
        String r149 = r148.getLogId();
    L46:
        if (r149 != null) goto L48;
        r149 = "";
    L48:
        Pair[] r150 = new Pair[10];
        Map r151 = r140;
        r150[0] = TuplesKt.to("suggest_items", r145);
        r150[1] = TuplesKt.to("onboarding_display_style", "vertical");
        r150[2] = TuplesKt.to("wcb_message_hidden", "true");
        NexPulseConf r152 = r100.getConf();
        if (r152 == null) goto L54;
        Long r153 = r152.getExpireTime();
        if (r153 == null) goto L54;
        String r154 = r153.toString();
        if (r154 == null) goto L54;
    L55:
        r150[3] = TuplesKt.to("onboarding_sug_expiration_time", r154);
        r150[4] = TuplesKt.to("inner_log_id", r149);
        r150[5] = TuplesKt.to("log_id", r149);
        NexPulseConf r155 = r100.getConf();
        if (r155 == null) goto L58;
        r110 = r155.getWcbTitle();
    L58:
        if (r110 != null) goto L60;
        String r156 = "";
    L61:
        r150[6] = TuplesKt.to("wcb_title", r156);
        NexPulseConf r157 = r100.getConf();
        if (r157 == null) goto L66;
        Integer r158 = r157.getWcbTitleStyle();
        if (r158 == null) goto L66;
        int r159 = r158.intValue();
    L67:
        r150[7] = TuplesKt.to("wcb_title_style", String.valueOf(r159));
        r150[8] = TuplesKt.to("next_pulse_type", String.valueOf(r100.getNexPulseType()));
        r150[9] = TuplesKt.to("next_pulse_scene", String.valueOf(r138));
        r102 = MapsKt.mutableMapOf(r150);
        if (r148 == null) goto L72;
        String r160 = r148.getClickClearContext();
        if (r160 == null) goto L72;
        String r161 = (String) r102.put(r214, r160);
    L72:
        if (r151 == null) goto L148;
        r102.putAll(r151);
    L66:
        r159 = 0;
        goto L67
    L60:
        r156 = r110;
    L54:
        r154 = "0";
        goto L55
    L45:
        r149 = null;
    L39:
        List<NexPulseCandidate> r162 = r100.getCandidateList();
        if (r162 == null) goto L42;
        r148 = (NexPulseCandidate) CollectionsKt.firstOrNull(r162);
        goto L43
    L42:
        r148 = null;
    L16:
        th = th;
    L20:
        Result.Companion r163 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L18:
        th = th;
        r214 = "click_clear_context";
        goto L20
    L10:
        r140 = null;
        goto L11
    }

    private final Object update(p r100, final Map<String, String> r101, jx9.a r102, Continuation<? super n> r103) {
        final String r104 = StringsKt.removeSuffix(r100.f370069a, ":fake_message:1");
        return e("updateLocalMessage", r102, new com.larus.suggest.impl.wcb.render.a(r104, this, r101), r103);
    }

    public final Object e(String r100, jx9.a r110, Function1<? super IIMCallback<Message>, Unit> r111, Continuation<? super n> r112) {
        kotlinx.coroutines.j r101 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r112), 1);
        r101.C();
        AtomicBoolean r102 = new AtomicBoolean(false);
        r101.i(new b(r102));
        r111.invoke(new c(r100, r101, r102, this, r110));
        Object r103 = r101.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r112);
    L5:
        return r103;
    }

    public static final /* synthetic */ Object c(ImSdkWcbRenderer r100, p r101, Map r102, jx9.a r103, Continuation r104) {
        return r100.update(r101, r102, r103, r104);
    }
}
