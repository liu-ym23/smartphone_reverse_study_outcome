package com.bytedance.applet.debugger;

import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.debugscene.h0;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final CoroutineScope a = null;
    public static final AppletDebuggerAgentTraceRepository b = null;
    public static final Gson c = null;
    public static final Object d = null;
    public static long e;
    public static Job f;
    public static C0055a g;
    public static final b h = null;
    public static final Set<String> i = null;

    /* JADX INFO: renamed from: com.bytedance.applet.debugger.a$a, reason: collision with other inner class name */
    public static final class C0055a {
        public final long a;
        public final String b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0055a) == true) goto L8;
            return false;
        L8:
            C0055a r9 = (C0055a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PanelStateEvent(requestId=" + this.a + ", paramsJson=" + this.b + ')';
        }

        public C0055a(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "paramsJson");
            this.a = r2;
            this.b = r4;
        }
    }

    public static final class b implements com.bytedance.ai.debug.h {
        public b() {
        }

        public final void a() {
            FLogger r0 = FLogger.a;
            r0.i("AppletDebugAgentTraceHandler", "agent trace panel loaded");
            CoroutineScope r1 = a.a;
            Object r2 = a.d;
            monitor-enter(r2);
            C0055a r3 = a.g;     // Catch: Throwable -> L21
            if (r3 == null) goto L13;
            if (r3.a != a.e) goto L10;
            boolean r4 = true;
        L11:
            if (r4 == false) goto L13;
        L14:
            monitor-exit(r2);
            if (r3 == null) goto L27;
            String r5 = r3.b;
            if (IAISDKDebugService.a.j("panel.launchParamsChanged", r5) == true) goto L26;
            r0.w("AppletDebugAgentTraceHandler", "send latest agent trace panel state rejected");
            return;
        L26:
            return;
        L27:
            return;
        L10:
            r4 = false;
        L13:
            r3 = null;
        L21:
            th = move-exception;
            throw th;
        }

        public final void onClosed() {
            CoroutineScope r0 = a.a;
            Object r1 = a.d;
            monitor-enter(r1);
            a.e++;     // Catch: Throwable -> L11
            Job r2 = a.f;     // Catch: Throwable -> L11
            if (r2 == null) goto L7;
            Job.DefaultImpls.cancel$default(r2, null, 1, null);     // Catch: Throwable -> L11
        L7:
            a.f = null;     // Catch: Throwable -> L11
            a.g = null;     // Catch: Throwable -> L11
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L11
            monitor-exit(r1);
            FLogger.a.i("AppletDebugAgentTraceHandler", "agent trace panel closed");
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public final void b(String r2, String r3, h0 r4) {
            Intrinsics.checkNotNullParameter(r2, "type");
            Intrinsics.checkNotNullParameter(r3, "message");
            Intrinsics.checkNotNullParameter(r4, "reply");
            r4.a(-2, "MESSAGE_TYPE_NOT_REGISTERED", null);
        }
    }

    public a() {
    }

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        b = new AppletDebuggerAgentTraceRepository();
        c = new Gson();
        d = new Object();
        h = new b();
        i = SetsKt.setOf(new String[]{"ModelCall", "ToolCall", "CardRendered"});
    }

    public static final void a(long r4) {
        Object r0 = d;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (e != r4) goto L7;
        f = null;     // Catch: Throwable -> L10
    L7:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }

    public static void e(long r4) {
        Object r0 = d;
        monitor-enter(r0);
        long r1 = e;     // Catch: Throwable -> L16
        if (r1 == r4) goto L10;
        monitor-exit(r0);
        return;
    L10:
        e = r1 + 1;     // Catch: Throwable -> L16
        Job r5 = f;     // Catch: Throwable -> L16
        if (r5 == null) goto L13;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);     // Catch: Throwable -> L16
    L13:
        f = null;     // Catch: Throwable -> L16
        g = null;     // Catch: Throwable -> L16
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public static String f(List r3) {
        if (r3 != null) goto L4;
        r3 = CollectionsKt.emptyList();
    L4:
        ArrayList r0 = new ArrayList();
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L21;
        String r1 = (String) r4.next();
        if (r1 == null) goto L17;
        String r2 = StringsKt.trim(r1).toString();
        if (r2 == null) goto L17;
        if (r2.length() <= 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
    L18:
        if (r2 == null) goto L6;
        r0.add(r2);
        goto L6
    L14:
        r5 = false;
    L17:
        r2 = null;
        goto L18
    L21:
        return (String) CollectionsKt.singleOrNull(CollectionsKt.distinct(r0));
    }

    public static JsonElement g(t r9) {
        if (r9 == null) goto L4;
        JsonObject r0 = new JsonObject();
        String r1 = r9.b();
        if (r1 == null) goto L8;
        r0.addProperty("role", r1);
    L8:
        JsonArray r2 = new JsonArray();
        List<s> r10 = r9.a();
        if (r10 != null) goto L11;
        r10 = CollectionsKt.emptyList();
    L11:
        Iterator r11 = CollectionsKt.filterNotNull(r10).iterator();
    L13:
        if (r11.hasNext() == false) goto L46;
        s r3 = (s) r11.next();
        JsonObject r4 = new JsonObject();
        String r5 = r3.b();
        if (r5 == null) goto L17;
        r4.addProperty("key", r5);
    L17:
        JsonElement r6 = r3.a();
        if (r6 == null) goto L45;
        if (r6.isJsonPrimitive() == true) goto L22;
    L44:
        r4.add("content", r6);
        goto L45
    L22:
        if (r6.getAsJsonPrimitive().isString() == false) goto L44;
        String r7 = StringsKt.trim(r6.getAsString()).toString();
        boolean r8 = false;
        if (StringsKt.startsWith$default(r7, '{', false, 2, null) == false) goto L29;
        if (StringsKt.endsWith$default(r7, '}', false, 2, null) == false) goto L29;
    L32:
        r8 = true;
    L33:
        if (r8 == false) goto L44;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L37
        Object r13 = Result.constructor-impl(new JsonParser().parse(r7));     // Catch: Throwable -> L37
    L39:
        Object r14 = r6;
        if (Result.isFailure-impl(r13) == true) goto L43;
        r14 = r13;
    L43:
        r6 = (JsonElement) r14;
    L37:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L29:
        if (StringsKt.startsWith$default(r7, '[', false, 2, null) == false) goto L33;
        if (StringsKt.endsWith$default(r7, ']', false, 2, null) == false) goto L33;
    L45:
        r2.add(r4);
        goto L13
    L46:
        Unit r16 = Unit.INSTANCE;
        r0.add("contentList", r2);
        return r0;
    L4:
        return JsonNull.INSTANCE;
    }

    public static void c(long r5, Job r7) {
        Object r0 = d;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (e != r5) goto L8;
        f = r7;     // Catch: Throwable -> L14
        boolean r6 = true;
    L9:
        monitor-exit(r0);
        if (r6 == false) goto L12;
        r7.start();
        return;
    L12:
        Job.DefaultImpls.cancel$default(r7, null, 1, null);
        return;
    L8:
        r6 = false;
        goto L9
    }

    public static String d(t r9, String... r10) {
        if (r9 == null) goto L47;
        List<s> r11 = r9.a();
        if (r11 == null) goto L48;
        List r12 = CollectionsKt.filterNotNull(r11);
        if (r12 == null) goto L49;
        Iterator r13 = r12.iterator();
    L9:
        boolean r2 = false;
        if (r13.hasNext() == false) goto L20;
        Object r1 = r13.next();
        s r4 = (s) r1;
        int r5 = r10.length;
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L17;
        if (StringsKt.equals(r4.b(), r10[r6], true) == true) goto L15;
        r6 = r6 + 1;
        goto L12
    L15:
        boolean r7 = true;
    L18:
        if (r7 == false) goto L9;
    L21:
        s r3 = (s) r1;
        if (r3 == null) goto L50;
        JsonElement r14 = r3.a();
        if (r14 != null) goto L26;
        return null;
    L26:
        if (r14.isJsonPrimitive() == true) goto L28;
    L30:
        if (r2 == true) goto L33;
        r14 = null;
    L33:
        if (r14 == null) goto L52;
        String r15 = r14.getAsString();
        if (r15 != null) goto L37;
        return null;
    L37:
        if ((!StringsKt.isBlank(r15)) == true) goto L39;
        return null;
    L39:
        return r15;
    L52:
        return null;
    L28:
        if (r14.getAsJsonPrimitive().isString() == false) goto L30;
        r2 = true;
        goto L30
    L50:
        return null;
    L17:
        r7 = false;
        goto L18
    L20:
        r1 = null;
        goto L21
    L49:
        return null;
    L48:
        return null;
    L47:
        return null;
    }

    public static final AgentTracePanelData b(e r22, String r23, String r24, String r25) {
        v r0 = r22.b();
        String r1 = null;
        boolean r2 = true;
        if (r0 == null) goto L13;
        String r3 = r0.c();
        if (r3 == null) goto L13;
        if ((!StringsKt.isBlank(r3)) == true) goto L10;
        r3 = null;
    L10:
        if (r3 == null) goto L13;
        String r7 = r3;
    L14:
        List<u> r4 = r22.a();
        if (r4 != null) goto L17;
        r4 = CollectionsKt.emptyList();
    L17:
        ArrayList r12 = new ArrayList();
        Iterator<T> r5 = r4.iterator();
        int r6 = 0;
        int r8 = 0;
    L19:
        if (r5.hasNext() == false) goto L93;
        Object r9 = r5.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        u r11 = (u) r9;
        if (r11 == null) goto L89;
        String r15 = r11.d();
        if (r15 != null) goto L29;
    L88:
        r6 = r6 + 1;
        goto L89
    L29:
        if (i.contains(r15) == false) goto L88;
        int r13 = r15.hashCode();
        if (r13 == (-919457738)) goto L52;
        if (r13 == (-7189241)) goto L49;
        if (r13 == 133260293) goto L39;
    L53:
        String r14 = null;
    L61:
        if (r14 != null) goto L63;
    L65:
        String r16 = null;
    L66:
        String r17 = r7 + ':' + r8;
        Long r18 = r11.e();
        if (r18 != null) goto L69;
    L77:
        Long r19 = null;
    L78:
        Long r20 = r11.a();
        if (r20 != null) goto L81;
    L86:
        Long r110 = null;
    L87:
        AgentTracePanelSpan r21 = new AgentTracePanelSpan(r17, r15, r16, "API", r19, r110, g(r11.b()), g(r11.c()));
    L90:
        if (r21 == null) goto L92;
        r12.add(r21);
    L92:
        r8 = r10;
        goto L19
    L81:
        if (r20.longValue() < 0) goto L83;
        boolean r26 = true;
    L84:
        if (r26 == false) goto L86;
        r110 = r20;
        goto L87
    L83:
        r26 = false;
        goto L84
    L69:
        if (r18.longValue() < 0) goto L71;
        boolean r111 = true;
    L72:
        if (r111 == true) goto L75;
        r18 = null;
    L75:
        if (r18 == null) goto L77;
        r19 = Long.valueOf(r18.longValue() / 1000);
        goto L78
    L71:
        r111 = false;
        goto L72
    L63:
        if ((!StringsKt.isBlank(r14)) == false) goto L65;
        r16 = r14;
        goto L66
    L39:
        if (r15.equals("CardRendered") == false) goto L53;
        r14 = d(r11.c(), new String[]{"widgetId", "widget_id"});
        if (r14 != null) goto L61;
        v r112 = r22.b();
        if (r112 == null) goto L46;
        List<String> r113 = r112.f();
    L47:
        r14 = f(r113);
        goto L61
    L46:
        r113 = null;
        goto L47
    L49:
        if (r15.equals("ModelCall") == false) goto L53;
        r14 = d(r11.b(), new String[]{"model_name"});
        goto L61
    L52:
        if (r15.equals("ToolCall") == false) goto L53;
        r14 = d(r11.b(), new String[]{"tool_name", "工具名称"});
        if (r14 != null) goto L61;
        v r114 = r22.b();
        if (r114 == null) goto L59;
        List<String> r115 = r114.e();
    L60:
        r14 = f(r115);
        goto L61
    L59:
        r115 = null;
    L89:
        r21 = null;
        goto L90
    L93:
        if (r6 <= 0) goto L95;
        FLogger.a.w("AppletDebugAgentTraceHandler", "skipped unsupported agent trace scenes, count=" + r6);
    L95:
        v r27 = r22.b();
        if (r27 == null) goto L108;
        Long r28 = r27.a();
        if (r28 == null) goto L108;
        if (r28.longValue() >= 0) goto L103;
        r2 = false;
    L103:
        if (r2 == true) goto L106;
        r28 = null;
    L106:
        if (r28 == null) goto L108;
        long r29 = r28.longValue();
    L109:
        v r30 = r22.b();
        if (r30 == null) goto L112;
        String r31 = r30.b();
    L114:
        if (r31 != null) goto L116;
        String r116 = "";
    L117:
        v r32 = r22.b();
        if (r32 == null) goto L120;
        r1 = r32.d();
    L120:
        if (r1 != null) goto L122;
        String r117 = "";
    L124:
        return new AgentTracePanelData(0, r25, r24, r7, null, r29, r116, r12, r117, 17, null);
    L122:
        r117 = r1;
        goto L124
    L116:
        r116 = r31;
        goto L117
    L112:
        r31 = null;
    L108:
        r29 = 0;
    L13:
        r7 = r23;
        goto L14
    }
}
