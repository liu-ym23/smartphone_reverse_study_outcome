package com.bytedance.sdk.account.monitor;

import ac7.g;
import com.bytedance.sdk.account.monitor.settings.MonitorControlSettings;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class MonitorProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f269176a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f269177b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f269178c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MonitorProcessor f269179d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f269180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f269181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f269182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f269183d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f269184e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final JSONObject f269185f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Set<String> f269186g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f269187h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L36:
            return true;
        L5:
            if ((r100 instanceof a) == false) goto L35;
            a r101 = (a) r100;
            if (this.f269180a != r101.f269180a) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L35;
            if (this.f269181b != r101.f269181b) goto L14;
            boolean r103 = true;
        L15:
            if (r103 == false) goto L35;
            if (Intrinsics.areEqual(this.f269182c, r101.f269182c) == false) goto L35;
            if (Intrinsics.areEqual(this.f269183d, r101.f269183d) == false) goto L35;
            if (this.f269184e != r101.f269184e) goto L23;
            boolean r104 = true;
        L24:
            if (r104 == false) goto L35;
            if (Intrinsics.areEqual(this.f269185f, r101.f269185f) == false) goto L35;
            if (Intrinsics.areEqual(this.f269186g, r101.f269186g) == false) goto L35;
            if (this.f269187h != r101.f269187h) goto L32;
            boolean r105 = true;
        L33:
            if (r105 == false) goto L35;
        L32:
            r105 = false;
            goto L33
        L23:
            r104 = false;
            goto L24
        L14:
            r103 = false;
            goto L15
        L9:
            r102 = false;
        L35:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        public final int hashCode() {
            boolean r100 = this.f269180a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.f269181b;
            ?? r105 = r104;
            if (r104 == false) goto L8;
            r105 = 1;
        L8:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f269182c;
            int r108 = 0;
            if (r107 == null) goto L11;
            int r109 = r107.hashCode();
        L12:
            int r110 = (r106 + r109) * 31;
            String r111 = this.f269183d;
            if (r111 == null) goto L15;
            int r112 = r111.hashCode();
        L16:
            int r113 = (((r110 + r112) * 31) + this.f269184e) * 31;
            JSONObject r114 = this.f269185f;
            if (r114 == null) goto L19;
            int r115 = r114.hashCode();
        L20:
            int r116 = (r113 + r115) * 31;
            Set<String> r117 = this.f269186g;
            if (r117 == null) goto L23;
            r108 = r117.hashCode();
        L23:
            int r118 = (r116 + r108) * 31;
            boolean r119 = this.f269187h;
            if (r119 == true) goto L28;
            r101 = r119;
        L28:
            return r118 + r101;
        L19:
            r115 = 0;
            goto L20
        L15:
            r112 = 0;
            goto L16
        L11:
            r109 = 0;
            goto L12
        }

        public final String toString() {
            return "MonitorProcessorResult(shouldReport=" + this.f269180a + ", hasEventConfig=" + this.f269181b + ", info=" + this.f269182c + ", configVersion=" + this.f269183d + ", sampleRate=" + this.f269184e + ", createdParams=" + this.f269185f + ", logParams=" + this.f269186g + ", logAllParams=" + this.f269187h + ")";
        }

        public a(boolean r100, boolean r101, String r102, String r103, int r104, JSONObject r105, Set<String> r106, boolean r107) {
            this.f269180a = r100;
            this.f269181b = r101;
            this.f269182c = r102;
            this.f269183d = r103;
            this.f269184e = r104;
            this.f269185f = r105;
            this.f269186g = r106;
            this.f269187h = r107;
        }
    }

    static {
        f269176a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MonitorProcessor.class), "commonParamsService", "getCommonParamsService()Lcom/bytedance/sdk/account/monitor/IAccountSdkMonitorService;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MonitorProcessor.class), "debugMode", "getDebugMode()Z"))};
        f269179d = new MonitorProcessor();
        f269177b = LazyKt.lazy(MonitorProcessor$commonParamsService$2.INSTANCE);
        f269178c = LazyKt.lazy(MonitorProcessor$debugMode$2.INSTANCE);
    }

    public MonitorProcessor() {
    }

    public static IAccountSdkMonitorService a() {
        Lazy r100 = f269177b;
        KProperty r101 = f269176a[0];
        return (IAccountSdkMonitorService) r100.getValue();
    }

    public static boolean b(String r310, IAccountSdkMonitorService r311, final Function0 r312) {
        MonitorControlSettings r100 = MonitorControlSettings.f269195k;
        r100.getClass();
        com.bytedance.sdk.account.settings.b.C3766b r101 = MonitorControlSettings.f269194j;
        int r102 = 2;
        KProperty r103 = MonitorControlSettings.f269191g[2];
        com.bytedance.sdk.account.monitor.settings.b r104 = (com.bytedance.sdk.account.monitor.settings.b) r101.c(r100);
        boolean r105 = false;
        if (r104 == null) goto L60;
        if (r104.f269205b == false) goto L60;
        final com.bytedance.sdk.account.monitor.settings.a r106 = (com.bytedance.sdk.account.monitor.settings.a) ((LinkedHashMap) r104.f269204a).get(r310);
        if (r106 == null) goto L58;
        final String r107 = r104.f269207d;
        final int r108 = r106.f269197b;
        Function1<String, a> r109 = new MonitorProcessor$checkSampler$1(r107, r108, r106);
        final MonitorProcessor$checkSampler$2 r110 = new MonitorProcessor$checkSampler$2(r107, r108, r106);
        Function1<String, a> r111 = new MonitorProcessor$checkSampler$3(r110, r312);
        if (r108 >= 0) goto L12;
        a r112 = r111.invoke2("Illegal sample rate: " + r108);
    L57:
        a r113 = r112;
    L71:
        if (r113.f269180a == false) goto L100;
        JSONObject r114 = r113.f269185f;
        if (r114 != null) goto L76;
        r114 = b.a(r312);
    L76:
        JSONObject r115 = r114;
        r115.put(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, r113.f269184e);
        r115.put("monitor_config_version", r113.f269183d);
    L97:
        e = move-exception;
        tb7.a.c("MonitorProcessor", "addCommonParams error", e);
    L99:
        boolean r116 = r311.onEvent(r310, r115);
    L101:
        final StringBuilder r117 = new StringBuilder();
        Function1<String, StringBuilder> r118 = new MonitorProcessor$logEventInfo$logBuilder$1$1(r117);
        r118.invoke2("onEvent: << ");
        r118.invoke2(r310);
        r118.invoke2(" >>\n");
        r118.invoke2("hasEventConfig: " + r113.f269181b + '\n');
        if (r113.f269181b == false) goto L104;
        r118.invoke2("configVersion: " + r113.f269183d + '\n');
    L104:
        r118.invoke2("doReport: " + r113.f269180a + '\n');
        if (r113.f269180a == false) goto L107;
        r118.invoke2("reportSuccess: " + r116 + '\n');
    L109:
        if (r113.f269187h == true) goto L112;
        f269179d.getClass();
        Lazy r119 = f269178c;
        KProperty r120 = f269176a[1];
        if (((Boolean) r119.getValue()).booleanValue() == true) goto L112;
    L114:
        if ((!r113.f269186g.isEmpty()) == true) goto L116;
        if (r105 == true) goto L116;
    L136:
        String r121 = r117.toString();
        if (r113.f269180a == false) goto L139;
        tb7.a.d("AccountMonitor", r121);
    L140:
        return r116;
    L139:
        tb7.a.a("AccountMonitor", r121);
    L116:
        JSONObject r122 = r113.f269185f;
        if (r122 != null) goto L120;
        r122 = (JSONObject) r312.invoke();
    L120:
        if (r122 == null) goto L136;
        if (r122.length() <= 0) goto L136;
        if (r105 == false) goto L125;
        String r123 = r122.toString(2);
    L133:
        if (r105 == false) goto L135;
        r118.invoke2("params: " + r123);
        goto L136
    L135:
        r118.invoke2("params (filtered): " + r123);
        goto L136
    L125:
        Iterator<String> r124 = r113.f269186g.iterator();
        f269179d.getClass();
        JSONObject r125 = new JSONObject();     // Catch: Exception -> L132
    L128:
        if (r124.hasNext() == false) goto L130;
        String r126 = r124.next();     // Catch: Exception -> L132
        r125.put(r126, r122.get(r126));     // Catch: Exception -> L132
        goto L128
    L130:
        r123 = r125.toString(2);     // Catch: Exception -> L132
    L132:
        r123 = "<paramsToString error>";
    L112:
        r105 = true;
        goto L114
    L107:
        r118.invoke2("noReportReason: " + r113.f269182c + '\n');
        goto L109
    L78:
        if (a() == null) goto L99;
        IAccountSdkMonitorService r127 = a();     // Catch: Exception -> L97
        if (r127 != null) goto L82;
        Intrinsics.throwNpe();     // Catch: Exception -> L97
    L82:
        Iterator<Map.Entry<String, Object>> r128 = r127.getMonitorCommonParams(r310).entrySet().iterator();     // Catch: Exception -> L97
    L84:
        if (r128.hasNext() == false) goto L88;
        Map.Entry<String, Object> r129 = r128.next();     // Catch: Exception -> L97
        String r130 = r129.getKey();     // Catch: Exception -> L97
        Object r131 = r129.getValue();     // Catch: Exception -> L97
        if (r115.has(r130) == true) goto L84;
        r115.put(r130, r131);     // Catch: Exception -> L97
        goto L84
    L88:
        IAccountSdkMonitorService r132 = a();     // Catch: Exception -> L97
        if (r132 != null) goto L91;
        Intrinsics.throwNpe();     // Catch: Exception -> L97
    L91:
        Iterator<Map.Entry<String, Object>> r133 = r132.getOverrideCommonParams(r310).entrySet().iterator();     // Catch: Exception -> L97
    L92:
        if (r133.hasNext() == false) goto L99;
        Map.Entry<String, Object> r134 = r133.next();     // Catch: Exception -> L97
        r115.put(r134.getKey(), r134.getValue());     // Catch: Exception -> L97
        goto L92
    L100:
        r116 = false;
        goto L101
    L12:
        int r135 = r106.f269199d;
        if (r135 <= 1) goto L15;
        r112 = r111.invoke2("Illegal sample mode: " + r135);
        goto L57
    L15:
        g r136 = r106.f269200e;
        if (r136 == null) goto L20;
        JSONObject r137 = b.a(r312);
        if (r136.a(r137) == true) goto L20;
        r112 = r110.invoke2("Sample if condition not met", r137);
    L20:
        if (r108 != 0) goto L23;
        r112 = r109.invoke2("Sample rate is 0");
        goto L57
    L23:
        if (r108 == 1) goto L56;
        if (r135 == 0) goto L51;
        if (r135 == 1) goto L27;
        r112 = r111.invoke2("Illegal sample mode: " + r135);
        goto L57
    L27:
        String r138 = r106.f269201f;
        if (r138 != null) goto L30;
    L33:
        boolean r139 = true;
    L34:
        if (r139 == false) goto L36;
        int r140 = r106.f269196a.f269206c;
    L46:
        if (UnsignedKt.m9801uintRemainderJ1ME1BU(r140, UInt.m9544constructorimpl(r108)) == 0) goto L52;
    L53:
        boolean r141 = false;
    L54:
        if (r141 == true) goto L56;
        r112 = r109.invoke2("Intercept by sampler, Sample rate: " + r108 + ", sample mode: " + r135);
    L52:
        r141 = true;
        goto L54
    L36:
        int r142 = bc7.a.f18591a;
        byte[][] r143 = new byte[2][];
        int r144 = r106.f269196a.f269206c;
        r143[0] = new byte[]{(byte) (r144 & 255), (byte) ((r144 >> 8) & 255), (byte) ((r144 >> 16) & 255), (byte) ((r144 >> 24) & 255)};
        String r145 = r106.f269201f;
        Charset r146 = Charsets.UTF_8;
        if (r145 == null) goto L49;
        r143[1] = r145.getBytes(r146);
        int r147 = 0;
        int r148 = 0;
    L39:
        if (r147 >= 2) goto L41;
        r148 = r148 + r143[r147].length;
        r147 = r147 + 1;
        goto L39
    L41:
        byte[] r149 = new byte[r148];
        int r150 = 0;
        int r210 = 0;
    L42:
        if (r150 >= r102) goto L44;
        byte[] r151 = r143[r150];
        ArraysKt.copyInto$default(r151, r149, r210, 0, 0, 12, null);
        r210 = r210 + r151.length;
        r150 = r150 + 1;
        r102 = 2;
        goto L42
    L44:
        r140 = UInt.m9544constructorimpl(bc7.a.a(r149, 0));
        goto L46
    L49:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L30:
        if (r138.length() == 0) goto L33;
        r139 = false;
        goto L34
    L51:
        if (ThreadLocalRandom.current().nextInt(r108) != 0) goto L53;
    L56:
        r112 = r111.invoke2("Not intercepted by sampler, sample rate: " + r108 + ", sample mode: " + r135);
        goto L57
    L58:
        r113 = new a(true, false, "Event does not exist in config", r104.f269207d, 1, b.a(r312), SetsKt.emptySet(), false);
    L60:
        if (r104 != null) goto L62;
        String r152 = "Monitor config is null";
    L63:
        String r211 = r152;
        if (r104 == null) goto L68;
        String r153 = r104.f269207d;
        if (r153 == null) goto L68;
    L69:
        r113 = new a(true, false, r211, r153, 1, b.a(r312), SetsKt.emptySet(), false);
    L68:
        r153 = "<null>";
        goto L69
    L62:
        r152 = "Monitor config is disabled";
        goto L63
    }
}
