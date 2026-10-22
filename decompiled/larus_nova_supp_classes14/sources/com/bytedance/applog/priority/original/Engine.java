package com.bytedance.applog.priority.original;

import android.content.ContentValues;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.applog.priority.PriorityCallback;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class Engine implements b, f {
    public static final /* synthetic */ int j = 0;
    public final com.bytedance.applog.priority.h a;
    public final Lazy b;
    public k c;
    public final Config d;
    public final EventDatabasePool e;
    public final AppSession f;
    public t g;
    public t h;
    public t i;

    public static final class Companion {
        public static Engine a(final com.bytedance.applog.priority.h r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            r3.c.a("createEngine", new Engine$Companion$create$1(r3));
            return new Engine(r3);
        }
    }

    static {
    }

    public final JSONObject e() {
        if (this.g == null) goto L5;
    L10:
        JSONObject r0 = new JSONObject();
        t r1 = this.g;
        if (r1 == null) goto L13;
        r0.put("backoff_priority", r1.a());
    L13:
        t r2 = this.h;
        if (r2 == null) goto L16;
        r0.put("event_priority_config", r2.a());
    L16:
        t r3 = this.i;
        if (r3 == null) goto L19;
        r0.put("group_priority", r3.a());
    L19:
        return r0;
    L5:
        if (this.h != null) goto L10;
        if (this.i != null) goto L10;
        return null;
    }

    public final ConcurrentHashMap<Model$PriorityName, Worker> f() {
        return (ConcurrentHashMap) this.b.getValue();
    }

    public final String toString() {
        return "Engine-" + this.a.b.a;
    }

    public final void d() {
        Iterator<Worker> r0 = f().values().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        final Worker r1 = r0.next();
        r1.b.getContext().c.a("Worker:flush", new Worker$flush$1(r1));
        Iterator<T> r2 = r1.f.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((g) r2.next()).flush();
        goto L7
    L9:
        final y r3 = r1.e;
        ScheduledExecutorService r4 = r3.a;
        if (r4 == null) goto L4;
        r4.submit(new x(r3));
        goto L4
    }

    public Engine(com.bytedance.applog.priority.h r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.a = r5;
        this.b = LazyKt.lazy(Engine$workerMap$2.INSTANCE);
        this.c = new k(new CopyOnWriteArrayList());
        this.d = new Config(r5.c, r5.getContext(), r5.b.a);
        this.e = new EventDatabasePool(r5.c, r5.getContext(), r5.b.a);
        this.f = new AppSession(r5, this, this);
    }

    public final synchronized void g(final JSONObject r38) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r38, "configJson");     // Catch: Throwable -> L98
        this.a.c.a("Engine:initConfig", new Engine$initConfig$1(this, r38));     // Catch: Throwable -> L98
        JSONObject r1 = r38.optJSONObject("group_priority_list");     // Catch: Throwable -> L98
        if (r1 != null) goto L7;
        r1 = new JSONObject();     // Catch: Throwable -> L98
    L7:
        com.bytedance.applog.priority.h r2 = this.a;     // Catch: Throwable -> L98
        String r3 = r2.e;     // Catch: Throwable -> L98
        String r4 = r2.f;     // Catch: Throwable -> L98
        Intrinsics.checkNotNullParameter(r1, "json");     // Catch: Throwable -> L98
        Intrinsics.checkNotNullParameter(r3, "defaultReportHost");     // Catch: Throwable -> L98
        Intrinsics.checkNotNullParameter(r4, "defaultReportPath");     // Catch: Throwable -> L98
        t r15 = new t(r1.optInt("version", 0), r1.optJSONArray("config_ids"));     // Catch: Throwable -> L98
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L98
        JSONArray r5 = r1.optJSONArray("priorities");     // Catch: Throwable -> L98
        if (r5 == null) goto L15;
        int r6 = r5.length();     // Catch: Throwable -> L98
        int r7 = 0;
    L10:
        if (r7 >= r6) goto L15;
        JSONObject r8 = r5.optJSONObject(r7);     // Catch: Throwable -> L98
        if (r8 == null) goto L14;
        r12.add(new q(r8, r3, r4));     // Catch: Throwable -> L98
    L14:
        r7 = r7 + 1;     // Catch: Throwable -> L98
    L15:
        this.i = r15;     // Catch: Throwable -> L98
        JSONObject r9 = r38.optJSONObject("backoff_priority_list");     // Catch: Throwable -> L98
        if (r9 != null) goto L18;
        r9 = new JSONObject();     // Catch: Throwable -> L98
    L18:
        Intrinsics.checkNotNullParameter(r9, "json");     // Catch: Throwable -> L98
        t r10 = new t(r9.optInt("version", 0), r9.optJSONArray("config_ids"));     // Catch: Throwable -> L98
        int r23 = r9.optInt("backoff_ratio", 0);     // Catch: Throwable -> L98
        int r24 = r9.optInt("max_request_frequency", 10);     // Catch: Throwable -> L98
        ConcurrentHashMap r11 = new ConcurrentHashMap();     // Catch: Throwable -> L98
        JSONArray r13 = r9.optJSONArray("priorities");     // Catch: Throwable -> L98
        if (r13 == null) goto L28;
        int r14 = r13.length();     // Catch: Throwable -> L98
        int r16 = 0;
    L21:
        if (r16 >= r14) goto L28;
        JSONObject r17 = r13.optJSONObject(r16);     // Catch: Throwable -> L98
        if (r17 == null) goto L27;
        int r18 = r17.optInt("global_priority");     // Catch: Throwable -> L98
        if (r18 <= 0) goto L27;
        r11.put(Integer.valueOf(r18), new p(r17));     // Catch: Throwable -> L98
    L27:
        r16 = r16 + 1;     // Catch: Throwable -> L98
    L28:
        this.g = r10;     // Catch: Throwable -> L98
        JSONObject r0 = r38.optJSONObject("event_priority_config");     // Catch: Throwable -> L98
        if (r0 != null) goto L31;
        r0 = new JSONObject();     // Catch: Throwable -> L98
    L31:
        Intrinsics.checkNotNullParameter(r0, "json");     // Catch: Throwable -> L98
        t r19 = new t(r0.optInt("version", 0), r0.optJSONArray("config_ids"));     // Catch: Throwable -> L98
        JSONObject r20 = r0.optJSONObject("config");     // Catch: Throwable -> L98
        if (r20 != null) goto L34;
        r20 = new JSONObject();     // Catch: Throwable -> L98
    L34:
        Intrinsics.checkNotNullParameter(r20, "json");     // Catch: Throwable -> L98
        JSONObject r21 = r20.optJSONObject("P0");     // Catch: Throwable -> L98
        if (r21 != null) goto L37;
        r21 = new JSONObject();     // Catch: Throwable -> L98
    L37:
        s r22 = new s(r21);     // Catch: Throwable -> L98
        JSONObject r25 = r20.optJSONObject("P1");     // Catch: Throwable -> L98
        if (r25 != null) goto L40;
        r25 = new JSONObject();     // Catch: Throwable -> L98
    L40:
        s r26 = new s(r25);     // Catch: Throwable -> L98
        JSONObject r27 = r20.optJSONObject("P2");     // Catch: Throwable -> L98
        if (r27 != null) goto L43;
        r27 = new JSONObject();     // Catch: Throwable -> L98
    L43:
        s r28 = new s(r27);     // Catch: Throwable -> L98
        this.h = r19;     // Catch: Throwable -> L98
        if (r12.isEmpty() == true) goto L46;
    L49:
        t r29 = r15;
        ConcurrentHashMap r110 = r11;
        n r30 = new n(this, r19, Model$PriorityName.P0, r22.a, r22.b, r22.c, r22.d, this.a.b.f);     // Catch: Throwable -> L98
        n r210 = new n(this, r19, Model$PriorityName.P1, r26.a, r26.b, r26.c, r26.d, this.a.b.f);     // Catch: Throwable -> L98
        n r211 = new n(this, r19, Model$PriorityName.P2, r28.a, r28.b, r28.c, r28.d, this.a.b.f);     // Catch: Throwable -> L98
        o r31 = new o(this.e, this.a);     // Catch: Throwable -> L98
        CopyOnWriteArrayList r32 = new CopyOnWriteArrayList();     // Catch: Throwable -> L98
        ArrayList r33 = new ArrayList();     // Catch: Throwable -> L98
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L98
        ArrayList r112 = new ArrayList();     // Catch: Throwable -> L98
        Iterator r113 = r12.iterator();     // Catch: Throwable -> L98
    L50:
        boolean r34 = true;
        if (r113.hasNext() == false) goto L72;
        q r114 = (q) r113.next();     // Catch: Throwable -> L98
        p r35 = (p) r110.get(Integer.valueOf(r114.a));     // Catch: Throwable -> L98
        if (r35 == null) goto L60;
        if (r114.b <= 0) goto L58;
        r34 = false;
    L58:
        m r36 = new m(r34, r10, r35.a, r35.b, new AtomicInteger(0), new AtomicInteger(0));     // Catch: Throwable -> L98
    L64:
        String r37 = CommonKt.a(r114.a, r114.c, r114.d);     // Catch: Throwable -> L98
        String r39 = r114.f;     // Catch: Throwable -> L98
        if (Intrinsics.areEqual(r39, Model$PriorityName.P0.name()) == false) goto L67;
        ConcurrentHashMap r310 = r110;
        t r311 = r29;
        l r312 = new l(r114.a, r311, r114.b, r36, r30, r114.g, r114.e, r37);     // Catch: Throwable -> L98
        com.bytedance.applog.priority.h r40 = this.a;     // Catch: Throwable -> L98
        Group r41 = new Group(r31, r312, r40.c, r40.b.f, this.f);     // Catch: Throwable -> L98
        r33.add(r41);     // Catch: Throwable -> L98
        r32.add(r41);     // Catch: Throwable -> L98
    L71:
        r110 = r310;
        r29 = r311;
        goto L50
    L67:
        r310 = r110;
        r311 = r29;
        if (Intrinsics.areEqual(r39, Model$PriorityName.P1.name()) == false) goto L70;
        l r313 = new l(r114.a, r311, r114.b, r36, r210, r114.g, r114.e, r37);     // Catch: Throwable -> L98
        com.bytedance.applog.priority.h r42 = this.a;     // Catch: Throwable -> L98
        Group r43 = new Group(r31, r313, r42.c, r42.b.f, this.f);     // Catch: Throwable -> L98
        r111.add(r43);     // Catch: Throwable -> L98
        r32.add(r43);     // Catch: Throwable -> L98
        goto L71
    L70:
        l r314 = new l(r114.a, r311, r114.b, r36, r211, r114.g, r114.e, r37);     // Catch: Throwable -> L98
        com.bytedance.applog.priority.h r44 = this.a;     // Catch: Throwable -> L98
        Group r45 = new Group(r31, r314, r44.c, r44.b.f, this.f);     // Catch: Throwable -> L98
        r112.add(r45);     // Catch: Throwable -> L98
        r32.add(r45);     // Catch: Throwable -> L98
        goto L71
    L60:
        if (r114.b <= 0) goto L63;
        r34 = false;
    L63:
        r36 = new m(r34, r10, r23, r24, new AtomicInteger(0), new AtomicInteger(0));     // Catch: Throwable -> L98
        goto L64
    L72:
        ConcurrentHashMap<Model$PriorityName, Worker> r46 = f();     // Catch: Throwable -> L98
        Model$PriorityName r47 = Model$PriorityName.P0;     // Catch: Throwable -> L98
        Worker r48 = r46.get(r47);     // Catch: Throwable -> L98
        Unit r49 = null;
        if (r48 == null) goto L75;
        r48.b(r33);     // Catch: Throwable -> L98
        Unit r50 = Unit.INSTANCE;     // Catch: Throwable -> L98
    L76:
        if (r50 == null) goto L78;
    L80:
        ConcurrentHashMap<Model$PriorityName, Worker> r51 = f();     // Catch: Throwable -> L98
        Model$PriorityName r52 = Model$PriorityName.P1;     // Catch: Throwable -> L98
        Worker r53 = r51.get(r52);     // Catch: Throwable -> L98
        if (r53 == null) goto L83;
        r53.b(r111);     // Catch: Throwable -> L98
        Unit r54 = Unit.INSTANCE;     // Catch: Throwable -> L98
    L84:
        if (r54 == null) goto L86;
    L88:
        ConcurrentHashMap<Model$PriorityName, Worker> r55 = f();     // Catch: Throwable -> L98
        Model$PriorityName r56 = Model$PriorityName.P2;     // Catch: Throwable -> L98
        Worker r57 = r55.get(r56);     // Catch: Throwable -> L98
        if (r57 == null) goto L91;
        r57.b(r112);     // Catch: Throwable -> L98
        r49 = Unit.INSTANCE;     // Catch: Throwable -> L98
    L91:
        if (r49 == null) goto L93;
    L95:
        this.a.c.a("Engine:initConfig", new Engine$initConfig$5(this));     // Catch: Throwable -> L98
        k r58 = new k(r32);     // Catch: Throwable -> L98
        this.c = r58;     // Catch: Throwable -> L98
        this.d.b(r58);     // Catch: Throwable -> L98
        monitor-exit(this);
        return;
    L93:
        if ((!r112.isEmpty()) == false) goto L95;
        f().put(r56, new Worker(r56, r31, r112));     // Catch: Throwable -> L98
        goto L95
    L86:
        if ((!r111.isEmpty()) == false) goto L88;
        f().put(r52, new Worker(r52, r31, r111));     // Catch: Throwable -> L98
        goto L88
    L83:
        r54 = null;
        goto L84
    L78:
        if ((!r33.isEmpty()) == false) goto L80;
        f().put(r47, new Worker(r47, r31, r33));     // Catch: Throwable -> L98
        goto L80
    L75:
        r50 = null;
        goto L76
    L46:
        if (f().isEmpty() == false) goto L49;
        monitor-exit(this);
        return;
    L98:
        th = move-exception;
        throw th;
    }

    public final void i(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "json");
        boolean r3 = true;
        if (r8.has("backoff_priority_list") == false) goto L5;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        JSONObject r4 = this.d.a();
        if (r4 != null) goto L16;
        r4 = new JSONObject();
    L16:
        boolean r1 = j(r8, r4, "backoff_priority_list");
        if (j(r8, r4, "event_priority_config") == true) goto L21;
        if (r1 == true) goto L21;
        boolean r5 = false;
    L23:
        if (j(r8, r4, "group_priority_list") == true) goto L27;
        if (r5 == true) goto L27;
        r3 = false;
    L27:
        if (r3 == true) goto L30;
        this.a.c.a("Engine:setConfig", new Engine$setConfig$1(this));
        return;
    L30:
        Config r9 = this.d;
        String r6 = r4.toString();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "json");
        r9.d.storeStringJustDisk(r9.b, r6);
        g(r4);
        return;
    L21:
        r5 = true;
        goto L23
    L5:
        if (r8.has("event_priority_config") == true) goto L10;
        if (r8.has("group_priority_list") == true) goto L10;
        r2 = false;
        goto L11
    }

    public static final boolean j(JSONObject r9, JSONObject r10, String r11) {
        JSONObject r12 = r9.optJSONObject(r11);
        if (r12 == null) goto L27;
        JSONObject r1 = r10.optJSONObject(r11);
        String r3 = null;
        if (r1 == null) goto L24;
        int r4 = t.c;
        Intrinsics.checkNotNullParameter(r12, "json");
        int r6 = r12.optInt("version", 0);
        JSONArray r8 = r12.optJSONArray("config_ids");
        Intrinsics.checkNotNullParameter(r1, "json");
        int r5 = r1.optInt("version", 0);
        JSONArray r2 = r1.optJSONArray("config_ids");
        Intrinsics.checkNotNullParameter(new t(r5, r2), "other");
        if (r6 > r5) goto L18;
        if (r6 < r5) goto L19;
        if (r8 == null) goto L13;
        String r7 = r8.toString();
    L14:
        if (r2 == null) goto L17;
        r3 = r2.toString();
    L17:
        if (Intrinsics.areEqual(r7, r3) == true) goto L19;
    L13:
        r7 = null;
    L19:
        boolean r13 = false;
    L20:
        if (r13 == false) goto L23;
        r10.put(r11, r12);
        return true;
    L23:
        r3 = Unit.INSTANCE;
    L18:
        r13 = true;
    L24:
        if (r3 != null) goto L27;
        r10.put(r11, r12);
        return true;
    L27:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.applog.priority.original.f
    public final boolean a(final String r21, final int r22, Lazy r23) {
        Intrinsics.checkNotNullParameter(r21, "eventName");
        Intrinsics.checkNotNullParameter(r23, "json");
        this.a.c.a("Engine:onEvent", new Engine$onEvent$1(this, r21, r22));
        Model$EventType.Companion.getClass();
        Model$EventType r9 = Model$EventType.a.a(r22);
        k r1 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r21, "eventName");
        Intrinsics.checkNotNullParameter(r9, "eventType");
        Intrinsics.checkNotNullParameter(r23, "json");
        String r15 = "";
        Object r3 = null;
        if (r1.a.isEmpty() == false) goto L6;
    L31:
        Group r5 = r3;
        boolean r16 = false;
        if (r5 != 0) goto L34;
        return false;
    L34:
        PriorityCallback r2 = this.a.b.f;
        l r4 = r5.b;
        CommonKt.k(r2, "2A", r22, r23, r4.e.c, r4.a);
        JSONObject r6 = (JSONObject) r23.getValue();
        Intrinsics.checkNotNullParameter(r9, "eventType");
        Intrinsics.checkNotNullParameter(r21, "eventName");
        Intrinsics.checkNotNullParameter(r6, "json");
        String r7 = r6.toString();
        int r8 = CommonKt.g(r7);
        if (r5.b.e.d >= r8) goto L59;
        int r10 = Group.a.a[r9.ordinal()];
        if (r10 != 1) goto L39;
        JSONObject r11 = new JSONObject();
        r11.put("params_cleared_by_event_size_limit", r8);
        r11.put("max_event_size", r5.b.e.d);
        r6.put("params", r11);
    L58:
        r7 = r6.toString();
        goto L59
    L39:
        if (r10 != 2) goto L41;
        final Set r12 = SetsKt.setOf(new String[]{"tag", "label", "monitor_id", "event_stained"});
        Iterator r13 = SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(r6.keys()), new Group$insertEvent$1(r12))).iterator();
    L54:
        if (r13.hasNext() == false) goto L56;
        r6.remove((String) r13.next());
        goto L54
    L56:
        r6.put("params_cleared_by_event_size_limit", r8);
        r6.put("max_event_size", r5.b.e.d);
        goto L58
    L41:
        if (r10 == 3) goto L47;
        final Set r14 = SetsKt.setOf(new String[]{"monitor_id", "event_stained"});
        Iterator r17 = SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(r6.keys()), new Group$insertEvent$5(r14))).iterator();
    L44:
        if (r17.hasNext() == false) goto L46;
        r6.remove((String) r17.next());
        goto L44
    L46:
        r6.put("params_cleared_by_event_size_limit", r8);
        r6.put("max_event_size", r5.b.e.d);
        goto L58
    L47:
        final Set r18 = SetsKt.setOf(new String[]{"log_type", "monitor_id", "event_stained"});
        Iterator r19 = SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(r6.keys()), new Group$insertEvent$3(r18))).iterator();
    L49:
        if (r19.hasNext() == false) goto L51;
        r6.remove((String) r19.next());
        goto L49
    L51:
        r6.put("params_cleared_by_event_size_limit", r8);
        r6.put("max_event_size", r5.b.e.d);
    L59:
        String r20 = r7;
        int r24 = r5.b.a;
        long r110 = System.currentTimeMillis() / ((long) ECDraweeView.SQUARE);
        if (r6.optInt("event_stained") <= 0) goto L62;
        r16 = true;
    L62:
        String r25 = r6.optString("monitor_id");
        if (r25 == null) goto L66;
        r15 = r25;
    L66:
        final j r26 = r5.f.insert(new j(-1, r24, r110, r9, r16, r15, r21), r20);
        this.a.c.a("Engine:onEvent", new Engine$onEvent$2(this, r21, r26));
        PriorityCallback r27 = this.a.b.f;
        l r28 = r5.b;
        CommonKt.k(r27, "2F", r22, r23, r28.e.c, r28.a);
        return true;
    L6:
        if (k.a.a[r9.ordinal()] == 1) goto L8;
        Set<Model$EventType> r29 = r1.d;
        if (r29 == null) goto L31;
        Intrinsics.checkNotNull(r29);
        if (r29.contains(r9) == false) goto L31;
        Iterator<T> r30 = r1.a.iterator();
    L26:
        if (r30.hasNext() == false) goto L30;
        Object r31 = r30.next();
        if (((Group) r31).g(r9, "", null) == false) goto L26;
        r3 = r31;
    L30:
        r3 = (Group) r3;
        goto L31
    L8:
        if (r1.b == true) goto L13;
        Set<String> r32 = r1.c;
        if (r32 == null) goto L31;
        Intrinsics.checkNotNull(r32);
        if (r32.contains(r21) == false) goto L31;
    L13:
        Iterator<T> r33 = r1.a.iterator();
    L15:
        if (r33.hasNext() == false) goto L19;
        Object r34 = r33.next();
        if (((Group) r34).g(r9, r21, r23) == false) goto L15;
        r3 = r34;
    L19:
        r3 = (Group) r3;
        goto L31
    }

    @Override // com.bytedance.applog.priority.original.b
    public final void b(final boolean r3, final String r4, final String r5) {
        Intrinsics.checkNotNullParameter(r4, "newSessionId");
        this.a.c.a("Engine:onSessionChanged", new Engine$onSessionChanged$1(this, r4, r3, r5));
    }

    public final void c(final String r17, final String r18, final long r19, final String r21) {
        Intrinsics.checkNotNullParameter(r17, "sessionId");
        Intrinsics.checkNotNullParameter(r18, "pageName");
        this.a.c.a("Engine:addTerminateDuration", new Engine$addSessionDuration$1(this, r17, r18, r19, r21));
        final long r13 = Math.max(0, r19);
        if (r13 <= 0) goto L22;
        AppSession r3 = this.f;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r17, "sessionId");
        Intrinsics.checkNotNullParameter(r18, "pageName");
        r3.a.c.a("AppSession:addDuration", new AppSession$addPageDuration$1(r17, r18, r13));
        SessionDatabase r15 = r3.a();
        r15.getClass();
        Intrinsics.checkNotNullParameter(r17, "sessionId");
        Intrinsics.checkNotNullParameter(r18, "pageName");
        ContentValues r4 = new ContentValues();     // Catch: Throwable -> L16
        r4.put(r15.f, r17);     // Catch: Throwable -> L16
        r4.put(r15.h, r18);     // Catch: Throwable -> L16
        r4.put(r15.g, Long.valueOf(r13));     // Catch: Throwable -> L16
        if (r21 == null) goto L8;
        r4.put(r15.i, r21);     // Catch: Throwable -> L16
    L8:
        final long r5 = r15.b().getWritableDatabase().insert(r15.e, null, r4);     // Catch: Throwable -> L16
        if (r5 >= 0) goto L29;
        com.bytedance.applog.log.a r0 = r15.a;     // Catch: Throwable -> L16
        String r8 = "SessionDatabase:insertPage";
        r0.b(r8, null, new SessionDatabase$insertPage$2(r5, r17, r18, r13));     // Catch: Throwable -> L14
        return;
    L14:
        th = th;
    L23:
        r15.a.b(r8, th, new SessionDatabase$insertPage$3(r17, r18, r13));     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L29:
        return;
    L16:
        th = th;
        r8 = "SessionDatabase:insertPage";
        goto L23
    }

    public final void h(final String r18, final boolean r19, long r20, String r22) {
        Intrinsics.checkNotNullParameter(r18, "sessionId");
        AppSession r10 = this.f;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r18, "sessionId");
        r10.a.c.a("AppSession:newSession", new AppSession$newSession$1(r18, r19));
        final String r12 = r10.d;
        r10.d = r18;
        if (r22 != null) goto L21;
    L4:
        JSONObject r4 = null;
    L8:
        if (((Boolean) BuildersKt.runBlocking$default(null, new AppSession$newSession$success$1(r10, new a(r18, r19, r4, r20), r18, r19, r22, null), 1, null)).booleanValue() == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r12, r10.d) == true) goto L23;
        r10.a.c.a("AppSession:newSession", new AppSession$newSession$2(r12, r18, r19));
        r10.b();
        r10.b.b(r19, r18, r12);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        r10.a.c.b("AppSession:newSession", th, AppSession$newSession$3.INSTANCE);
        return;
    L23:
        return;
    L21:
        r4 = new JSONObject(r22);     // Catch: Throwable -> L18
        goto L8
    }
}
