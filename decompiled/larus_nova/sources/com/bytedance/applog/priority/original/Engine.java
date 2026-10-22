package com.bytedance.applog.priority.original;

import android.content.ContentValues;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import com.bytedance.applog.priority.PriorityCallback;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class Engine implements b, f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f192650j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.applog.priority.h f192651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f192652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f192653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Config f192654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EventDatabasePool f192655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppSession f192656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public t f192657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t f192658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t f192659i;

    public static final class Companion {
        public static Engine a(final com.bytedance.applog.priority.h r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            r100.f192622c.a("createEngine", new Engine$Companion$create$1(r100));
            return new Engine(r100);
        }
    }

    static {
    }

    public final JSONObject e() {
        if (this.f192657g == null) goto L5;
    L10:
        JSONObject r100 = new JSONObject();
        t r101 = this.f192657g;
        if (r101 == null) goto L13;
        r100.put("backoff_priority", r101.a());
    L13:
        t r102 = this.f192658h;
        if (r102 == null) goto L16;
        r100.put("event_priority_config", r102.a());
    L16:
        t r103 = this.f192659i;
        if (r103 == null) goto L19;
        r100.put("group_priority", r103.a());
    L19:
        return r100;
    L5:
        if (this.f192658h != null) goto L10;
        if (this.f192659i != null) goto L10;
        return null;
    }

    public final ConcurrentHashMap<Model$PriorityName, Worker> f() {
        return (ConcurrentHashMap) this.f192652b.getValue();
    }

    public final String toString() {
        return "Engine-" + this.f192651a.f192621b.f192611a;
    }

    public final void d() {
        Iterator<Worker> r100 = f().values().iterator();
    L4:
        if (r100.hasNext() == false) goto L12;
        final Worker r101 = r100.next();
        r101.f192711b.getContext().f192622c.a("Worker:flush", new Worker$flush$1(r101));
        Iterator<T> r102 = r101.f192715f.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((g) r102.next()).flush();
        goto L7
    L9:
        final y r103 = r101.f192714e;
        ScheduledExecutorService r104 = r103.f192803a;
        if (r104 == null) goto L4;
        r104.submit(new x(r103));
        goto L4
    }

    public Engine(com.bytedance.applog.priority.h r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f192651a = r100;
        this.f192652b = LazyKt.lazy(Engine$workerMap$2.INSTANCE);
        this.f192653c = new k(new CopyOnWriteArrayList());
        this.f192654d = new Config(r100.f192622c, r100.getContext(), r100.f192621b.f192611a);
        this.f192655e = new EventDatabasePool(r100.f192622c, r100.getContext(), r100.f192621b.f192611a);
        this.f192656f = new AppSession(r100, this, this);
    }

    public final synchronized void g(final JSONObject r310) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r310, "configJson");     // Catch: Throwable -> L98
        this.f192651a.f192622c.a("Engine:initConfig", new Engine$initConfig$1(this, r310));     // Catch: Throwable -> L98
        JSONObject r100 = r310.optJSONObject("group_priority_list");     // Catch: Throwable -> L98
        if (r100 != null) goto L7;
        r100 = new JSONObject();     // Catch: Throwable -> L98
    L7:
        com.bytedance.applog.priority.h r101 = this.f192651a;     // Catch: Throwable -> L98
        String r102 = r101.f192624e;     // Catch: Throwable -> L98
        String r103 = r101.f192625f;     // Catch: Throwable -> L98
        Intrinsics.checkNotNullParameter(r100, "json");     // Catch: Throwable -> L98
        Intrinsics.checkNotNullParameter(r102, "defaultReportHost");     // Catch: Throwable -> L98
        Intrinsics.checkNotNullParameter(r103, "defaultReportPath");     // Catch: Throwable -> L98
        t r110 = new t(r100.optInt("version", 0), r100.optJSONArray("config_ids"));     // Catch: Throwable -> L98
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L98
        JSONArray r104 = r100.optJSONArray("priorities");     // Catch: Throwable -> L98
        if (r104 == null) goto L15;
        int r105 = r104.length();     // Catch: Throwable -> L98
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L15;
        JSONObject r107 = r104.optJSONObject(r106);     // Catch: Throwable -> L98
        if (r107 == null) goto L14;
        r111.add(new q(r107, r102, r103));     // Catch: Throwable -> L98
    L14:
        r106 = r106 + 1;     // Catch: Throwable -> L98
    L15:
        this.f192659i = r110;     // Catch: Throwable -> L98
        JSONObject r108 = r310.optJSONObject("backoff_priority_list");     // Catch: Throwable -> L98
        if (r108 != null) goto L18;
        r108 = new JSONObject();     // Catch: Throwable -> L98
    L18:
        Intrinsics.checkNotNullParameter(r108, "json");     // Catch: Throwable -> L98
        t r112 = new t(r108.optInt("version", 0), r108.optJSONArray("config_ids"));     // Catch: Throwable -> L98
        int r210 = r108.optInt("backoff_ratio", 0);     // Catch: Throwable -> L98
        int r211 = r108.optInt("max_request_frequency", 10);     // Catch: Throwable -> L98
        ConcurrentHashMap r113 = new ConcurrentHashMap();     // Catch: Throwable -> L98
        JSONArray r109 = r108.optJSONArray("priorities");     // Catch: Throwable -> L98
        if (r109 == null) goto L28;
        int r114 = r109.length();     // Catch: Throwable -> L98
        int r115 = 0;
    L21:
        if (r115 >= r114) goto L28;
        JSONObject r116 = r109.optJSONObject(r115);     // Catch: Throwable -> L98
        if (r116 == null) goto L27;
        int r117 = r116.optInt("global_priority");     // Catch: Throwable -> L98
        if (r117 <= 0) goto L27;
        r113.put(Integer.valueOf(r117), new p(r116));     // Catch: Throwable -> L98
    L27:
        r115 = r115 + 1;     // Catch: Throwable -> L98
    L28:
        this.f192657g = r112;     // Catch: Throwable -> L98
        JSONObject r118 = r310.optJSONObject("event_priority_config");     // Catch: Throwable -> L98
        if (r118 != null) goto L31;
        r118 = new JSONObject();     // Catch: Throwable -> L98
    L31:
        Intrinsics.checkNotNullParameter(r118, "json");     // Catch: Throwable -> L98
        t r119 = new t(r118.optInt("version", 0), r118.optJSONArray("config_ids"));     // Catch: Throwable -> L98
        JSONObject r120 = r118.optJSONObject("config");     // Catch: Throwable -> L98
        if (r120 != null) goto L34;
        r120 = new JSONObject();     // Catch: Throwable -> L98
    L34:
        Intrinsics.checkNotNullParameter(r120, "json");     // Catch: Throwable -> L98
        JSONObject r121 = r120.optJSONObject(DiagnoseResult.DIAGNOSE_LEVEL_P0);     // Catch: Throwable -> L98
        if (r121 != null) goto L37;
        r121 = new JSONObject();     // Catch: Throwable -> L98
    L37:
        s r122 = new s(r121);     // Catch: Throwable -> L98
        JSONObject r123 = r120.optJSONObject(DiagnoseResult.DIAGNOSE_LEVEL_P1);     // Catch: Throwable -> L98
        if (r123 != null) goto L40;
        r123 = new JSONObject();     // Catch: Throwable -> L98
    L40:
        s r124 = new s(r123);     // Catch: Throwable -> L98
        JSONObject r125 = r120.optJSONObject(DiagnoseResult.DIAGNOSE_LEVEL_P2);     // Catch: Throwable -> L98
        if (r125 != null) goto L43;
        r125 = new JSONObject();     // Catch: Throwable -> L98
    L43:
        s r126 = new s(r125);     // Catch: Throwable -> L98
        this.f192658h = r119;     // Catch: Throwable -> L98
        if (r111.isEmpty() == true) goto L46;
    L49:
        t r212 = r110;
        ConcurrentHashMap r127 = r113;
        n r128 = new n(this, r119, Model$PriorityName.P0, r122.f192795a, r122.f192796b, r122.f192797c, r122.f192798d, this.f192651a.f192621b.f192616f);     // Catch: Throwable -> L98
        n r213 = new n(this, r119, Model$PriorityName.P1, r124.f192795a, r124.f192796b, r124.f192797c, r124.f192798d, this.f192651a.f192621b.f192616f);     // Catch: Throwable -> L98
        n r214 = new n(this, r119, Model$PriorityName.P2, r126.f192795a, r126.f192796b, r126.f192797c, r126.f192798d, this.f192651a.f192621b.f192616f);     // Catch: Throwable -> L98
        o r129 = new o(this.f192655e, this.f192651a);     // Catch: Throwable -> L98
        CopyOnWriteArrayList r130 = new CopyOnWriteArrayList();     // Catch: Throwable -> L98
        ArrayList r131 = new ArrayList();     // Catch: Throwable -> L98
        ArrayList r132 = new ArrayList();     // Catch: Throwable -> L98
        ArrayList r133 = new ArrayList();     // Catch: Throwable -> L98
        Iterator r134 = r111.iterator();     // Catch: Throwable -> L98
    L50:
        boolean r135 = true;
        if (r134.hasNext() == false) goto L72;
        q r136 = (q) r134.next();     // Catch: Throwable -> L98
        p r137 = (p) r127.get(Integer.valueOf(r136.f192785a));     // Catch: Throwable -> L98
        if (r137 == null) goto L60;
        if (r136.f192786b <= 0) goto L58;
        r135 = false;
    L58:
        m r138 = new m(r135, r112, r137.f192783a, r137.f192784b, new AtomicInteger(0), new AtomicInteger(0));     // Catch: Throwable -> L98
    L64:
        String r139 = CommonKt.a(r136.f192785a, r136.f192787c, r136.f192788d);     // Catch: Throwable -> L98
        String r140 = r136.f192790f;     // Catch: Throwable -> L98
        if (Intrinsics.areEqual(r140, Model$PriorityName.P0.name()) == false) goto L67;
        ConcurrentHashMap r311 = r127;
        t r312 = r212;
        l r313 = new l(r136.f192785a, r312, r136.f192786b, r138, r128, r136.f192791g, r136.f192789e, r139);     // Catch: Throwable -> L98
        com.bytedance.applog.priority.h r141 = this.f192651a;     // Catch: Throwable -> L98
        Group r142 = new Group(r129, r313, r141.f192622c, r141.f192621b.f192616f, this.f192656f);     // Catch: Throwable -> L98
        r131.add(r142);     // Catch: Throwable -> L98
        r130.add(r142);     // Catch: Throwable -> L98
    L71:
        r127 = r311;
        r212 = r312;
        goto L50
    L67:
        r311 = r127;
        r312 = r212;
        if (Intrinsics.areEqual(r140, Model$PriorityName.P1.name()) == false) goto L70;
        l r314 = new l(r136.f192785a, r312, r136.f192786b, r138, r213, r136.f192791g, r136.f192789e, r139);     // Catch: Throwable -> L98
        com.bytedance.applog.priority.h r143 = this.f192651a;     // Catch: Throwable -> L98
        Group r144 = new Group(r129, r314, r143.f192622c, r143.f192621b.f192616f, this.f192656f);     // Catch: Throwable -> L98
        r132.add(r144);     // Catch: Throwable -> L98
        r130.add(r144);     // Catch: Throwable -> L98
        goto L71
    L70:
        l r315 = new l(r136.f192785a, r312, r136.f192786b, r138, r214, r136.f192791g, r136.f192789e, r139);     // Catch: Throwable -> L98
        com.bytedance.applog.priority.h r145 = this.f192651a;     // Catch: Throwable -> L98
        Group r146 = new Group(r129, r315, r145.f192622c, r145.f192621b.f192616f, this.f192656f);     // Catch: Throwable -> L98
        r133.add(r146);     // Catch: Throwable -> L98
        r130.add(r146);     // Catch: Throwable -> L98
        goto L71
    L60:
        if (r136.f192786b <= 0) goto L63;
        r135 = false;
    L63:
        r138 = new m(r135, r112, r210, r211, new AtomicInteger(0), new AtomicInteger(0));     // Catch: Throwable -> L98
        goto L64
    L72:
        ConcurrentHashMap<Model$PriorityName, Worker> r147 = f();     // Catch: Throwable -> L98
        Model$PriorityName r148 = Model$PriorityName.P0;     // Catch: Throwable -> L98
        Worker r149 = r147.get(r148);     // Catch: Throwable -> L98
        Unit r150 = null;
        if (r149 == null) goto L75;
        r149.b(r131);     // Catch: Throwable -> L98
        Unit r151 = Unit.INSTANCE;     // Catch: Throwable -> L98
    L76:
        if (r151 == null) goto L78;
    L80:
        ConcurrentHashMap<Model$PriorityName, Worker> r152 = f();     // Catch: Throwable -> L98
        Model$PriorityName r153 = Model$PriorityName.P1;     // Catch: Throwable -> L98
        Worker r154 = r152.get(r153);     // Catch: Throwable -> L98
        if (r154 == null) goto L83;
        r154.b(r132);     // Catch: Throwable -> L98
        Unit r155 = Unit.INSTANCE;     // Catch: Throwable -> L98
    L84:
        if (r155 == null) goto L86;
    L88:
        ConcurrentHashMap<Model$PriorityName, Worker> r156 = f();     // Catch: Throwable -> L98
        Model$PriorityName r157 = Model$PriorityName.P2;     // Catch: Throwable -> L98
        Worker r158 = r156.get(r157);     // Catch: Throwable -> L98
        if (r158 == null) goto L91;
        r158.b(r133);     // Catch: Throwable -> L98
        r150 = Unit.INSTANCE;     // Catch: Throwable -> L98
    L91:
        if (r150 == null) goto L93;
    L95:
        this.f192651a.f192622c.a("Engine:initConfig", new Engine$initConfig$5(this));     // Catch: Throwable -> L98
        k r159 = new k(r130);     // Catch: Throwable -> L98
        this.f192653c = r159;     // Catch: Throwable -> L98
        this.f192654d.b(r159);     // Catch: Throwable -> L98
        monitor-exit(this);
        return;
    L93:
        if ((!r133.isEmpty()) == false) goto L95;
        f().put(r157, new Worker(r157, r129, r133));     // Catch: Throwable -> L98
        goto L95
    L86:
        if ((!r132.isEmpty()) == false) goto L88;
        f().put(r153, new Worker(r153, r129, r132));     // Catch: Throwable -> L98
        goto L88
    L83:
        r155 = null;
        goto L84
    L78:
        if ((!r131.isEmpty()) == false) goto L80;
        f().put(r148, new Worker(r148, r129, r131));     // Catch: Throwable -> L98
        goto L80
    L75:
        r151 = null;
        goto L76
    L46:
        if (f().isEmpty() == false) goto L49;
        monitor-exit(this);
        return;
    L98:
        th = move-exception;
        throw th;
    }

    public final void i(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        boolean r101 = true;
        if (r100.has("backoff_priority_list") == false) goto L5;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        return;
    L13:
        JSONObject r103 = this.f192654d.a();
        if (r103 != null) goto L16;
        r103 = new JSONObject();
    L16:
        boolean r104 = j(r100, r103, "backoff_priority_list");
        if (j(r100, r103, "event_priority_config") == true) goto L21;
        if (r104 == true) goto L21;
        boolean r105 = false;
    L23:
        if (j(r100, r103, "group_priority_list") == true) goto L27;
        if (r105 == true) goto L27;
        r101 = false;
    L27:
        if (r101 == true) goto L30;
        this.f192651a.f192622c.a("Engine:setConfig", new Engine$setConfig$1(this));
        return;
    L30:
        Config r106 = this.f192654d;
        String r107 = r103.toString();
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "json");
        r106.f192648d.storeStringJustDisk(r106.f192646b, r107);
        g(r103);
        return;
    L21:
        r105 = true;
        goto L23
    L5:
        if (r100.has("event_priority_config") == true) goto L10;
        if (r100.has("group_priority_list") == true) goto L10;
        r102 = false;
        goto L11
    }

    public static final boolean j(JSONObject r100, JSONObject r110, String r111) {
        JSONObject r101 = r100.optJSONObject(r111);
        if (r101 == null) goto L27;
        JSONObject r102 = r110.optJSONObject(r111);
        Object r103 = null;
        if (r102 == null) goto L24;
        int r104 = t.f192799c;
        Intrinsics.checkNotNullParameter(r101, "json");
        int r105 = r101.optInt("version", 0);
        JSONArray r106 = r101.optJSONArray("config_ids");
        Intrinsics.checkNotNullParameter(r102, "json");
        int r107 = r102.optInt("version", 0);
        JSONArray r108 = r102.optJSONArray("config_ids");
        Intrinsics.checkNotNullParameter(new t(r107, r108), "other");
        if (r105 > r107) goto L18;
        if (r105 < r107) goto L19;
        if (r106 == null) goto L13;
        String r109 = r106.toString();
    L14:
        if (r108 == null) goto L17;
        r103 = r108.toString();
    L17:
        if (Intrinsics.areEqual(r109, r103) == true) goto L19;
    L13:
        r109 = null;
    L19:
        boolean r112 = false;
    L20:
        if (r112 == false) goto L23;
        r110.put(r111, r101);
        return true;
    L23:
        r103 = Unit.INSTANCE;
    L18:
        r112 = true;
    L24:
        if (r103 != null) goto L27;
        r110.put(r111, r101);
        return true;
    L27:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.applog.priority.original.f
    public final boolean a(final String r210, final int r211, Lazy r212) {
        Intrinsics.checkNotNullParameter(r210, "eventName");
        Intrinsics.checkNotNullParameter(r212, "json");
        this.f192651a.f192622c.a("Engine:onEvent", new Engine$onEvent$1(this, r210, r211));
        Model$EventType.Companion.getClass();
        Model$EventType r100 = Model$EventType.a.a(r211);
        k r101 = this.f192653c;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r210, "eventName");
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r212, "json");
        String r110 = "";
        Object r102 = null;
        if (r101.f192749a.isEmpty() == false) goto L6;
    L31:
        Group r103 = r102;
        boolean r111 = false;
        if (r103 != 0) goto L34;
        return false;
    L34:
        PriorityCallback r104 = this.f192651a.f192621b.f192616f;
        l r105 = r103.f192678b;
        CommonKt.k(r104, "2A", r211, r212, r105.f192759e.f192775c, r105.f192755a);
        JSONObject r106 = (JSONObject) r212.getValue();
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r210, "eventName");
        Intrinsics.checkNotNullParameter(r106, "json");
        String r107 = r106.toString();
        int r108 = CommonKt.g(r107);
        if (r103.f192678b.f192759e.f192776d >= r108) goto L59;
        int r109 = Group.a.f192686a[r100.ordinal()];
        if (r109 != 1) goto L39;
        JSONObject r112 = new JSONObject();
        r112.put("params_cleared_by_event_size_limit", r108);
        r112.put("max_event_size", r103.f192678b.f192759e.f192776d);
        r106.put("params", r112);
    L58:
        r107 = r106.toString();
        goto L59
    L39:
        if (r109 != 2) goto L41;
        final Set r113 = SetsKt.setOf(new String[]{"tag", "label", "monitor_id", "event_stained"});
        Iterator r114 = SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(r106.keys()), new Group$insertEvent$1(r113))).iterator();
    L54:
        if (r114.hasNext() == false) goto L56;
        r106.remove((String) r114.next());
        goto L54
    L56:
        r106.put("params_cleared_by_event_size_limit", r108);
        r106.put("max_event_size", r103.f192678b.f192759e.f192776d);
        goto L58
    L41:
        if (r109 == 3) goto L47;
        final Set r115 = SetsKt.setOf(new String[]{"monitor_id", "event_stained"});
        Iterator r116 = SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(r106.keys()), new Group$insertEvent$5(r115))).iterator();
    L44:
        if (r116.hasNext() == false) goto L46;
        r106.remove((String) r116.next());
        goto L44
    L46:
        r106.put("params_cleared_by_event_size_limit", r108);
        r106.put("max_event_size", r103.f192678b.f192759e.f192776d);
        goto L58
    L47:
        final Set r117 = SetsKt.setOf(new String[]{FrescoMonitorConst.LOG_TYPE, "monitor_id", "event_stained"});
        Iterator r118 = SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(r106.keys()), new Group$insertEvent$3(r117))).iterator();
    L49:
        if (r118.hasNext() == false) goto L51;
        r106.remove((String) r118.next());
        goto L49
    L51:
        r106.put("params_cleared_by_event_size_limit", r108);
        r106.put("max_event_size", r103.f192678b.f192759e.f192776d);
    L59:
        String r119 = r107;
        int r120 = r103.f192678b.f192755a;
        long r121 = System.currentTimeMillis() / ((long) 1000);
        if (r106.optInt("event_stained") <= 0) goto L62;
        r111 = true;
    L62:
        String r122 = r106.optString("monitor_id");
        if (r122 == null) goto L66;
        r110 = r122;
    L66:
        final j r123 = r103.f192682f.insert(new j(-1, r120, r121, r100, r111, r110, r210), r119);
        this.f192651a.f192622c.a("Engine:onEvent", new Engine$onEvent$2(this, r210, r123));
        PriorityCallback r124 = this.f192651a.f192621b.f192616f;
        l r125 = r103.f192678b;
        CommonKt.k(r124, "2F", r211, r212, r125.f192759e.f192775c, r125.f192755a);
        return true;
    L6:
        if (k.a.f192754a[r100.ordinal()] == 1) goto L8;
        Set<Model$EventType> r126 = r101.f192752d;
        if (r126 == null) goto L31;
        Intrinsics.checkNotNull(r126);
        if (r126.contains(r100) == false) goto L31;
        Iterator<T> r127 = r101.f192749a.iterator();
    L26:
        if (r127.hasNext() == false) goto L30;
        Object r128 = r127.next();
        if (((Group) r128).g(r100, "", null) == false) goto L26;
        r102 = r128;
    L30:
        r102 = (Group) r102;
        goto L31
    L8:
        if (r101.f192750b == true) goto L13;
        Set<String> r129 = r101.f192751c;
        if (r129 == null) goto L31;
        Intrinsics.checkNotNull(r129);
        if (r129.contains(r210) == false) goto L31;
    L13:
        Iterator<T> r130 = r101.f192749a.iterator();
    L15:
        if (r130.hasNext() == false) goto L19;
        Object r131 = r130.next();
        if (((Group) r131).g(r100, r210, r212) == false) goto L15;
        r102 = r131;
    L19:
        r102 = (Group) r102;
        goto L31
    }

    @Override // com.bytedance.applog.priority.original.b
    public final void b(final boolean r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r101, "newSessionId");
        this.f192651a.f192622c.a("Engine:onSessionChanged", new Engine$onSessionChanged$1(this, r101, r100, r102));
    }

    public final void c(final String r110, final String r111, final long r112, final String r210) {
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        Intrinsics.checkNotNullParameter(r111, "pageName");
        this.f192651a.f192622c.a("Engine:addTerminateDuration", new Engine$addSessionDuration$1(this, r110, r111, r112, r210));
        final long r113 = Math.max(0, r112);
        if (r113 <= 0) goto L22;
        AppSession r100 = this.f192656f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        Intrinsics.checkNotNullParameter(r111, "pageName");
        r100.f192638a.f192622c.a("AppSession:addDuration", new AppSession$addPageDuration$1(r110, r111, r113));
        SessionDatabase r114 = r100.a();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        Intrinsics.checkNotNullParameter(r111, "pageName");
        ContentValues r101 = new ContentValues();     // Catch: Throwable -> L16
        r101.put(r114.f192696f, r110);     // Catch: Throwable -> L16
        r101.put(r114.f192698h, r111);     // Catch: Throwable -> L16
        r101.put(r114.f192697g, Long.valueOf(r113));     // Catch: Throwable -> L16
        if (r210 == null) goto L8;
        r101.put(r114.f192699i, r210);     // Catch: Throwable -> L16
    L8:
        final long r102 = r114.b().getWritableDatabase().insert(r114.f192695e, null, r101);     // Catch: Throwable -> L16
        if (r102 >= 0) goto L29;
        com.bytedance.applog.log.a r103 = r114.f192691a;     // Catch: Throwable -> L16
        String r104 = "SessionDatabase:insertPage";
        r103.b(r104, null, new SessionDatabase$insertPage$2(r102, r110, r111, r113));     // Catch: Throwable -> L14
        return;
    L14:
        th = th;
    L23:
        r114.f192691a.b(r104, th, new SessionDatabase$insertPage$3(r110, r111, r113));     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L29:
        return;
    L16:
        th = th;
        r104 = "SessionDatabase:insertPage";
        goto L23
    }

    public final void h(final String r110, final boolean r111, long r210, String r211) {
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        AppSession r112 = this.f192656f;
        r112.getClass();
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        r112.f192638a.f192622c.a("AppSession:newSession", new AppSession$newSession$1(r110, r111));
        final String r113 = r112.f192641d;
        r112.f192641d = r110;
        if (r211 != null) goto L21;
    L4:
        JSONObject r100 = null;
    L8:
        if (((Boolean) BuildersKt.runBlocking$default(null, new AppSession$newSession$success$1(r112, new a(r110, r111, r100, r210), r110, r111, r211, null), 1, null)).booleanValue() == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r113, r112.f192641d) == true) goto L23;
        r112.f192638a.f192622c.a("AppSession:newSession", new AppSession$newSession$2(r113, r110, r111));
        r112.b();
        r112.f192639b.b(r111, r110, r113);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        r112.f192638a.f192622c.b("AppSession:newSession", th, AppSession$newSession$3.INSTANCE);
        return;
    L23:
        return;
    L21:
        r100 = new JSONObject(r211);     // Catch: Throwable -> L18
        goto L8
    }
}
