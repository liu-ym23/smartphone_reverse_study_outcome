package com.bytedance.applog.priority.original;

import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.PriorityHttpResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class Group implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f192677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f192678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.applog.log.a f192679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PriorityCallback f192680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppSession f192681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f192682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f192683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f192684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f192685i;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192686a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f192687b = null;

        static {
            int[] r100 = new int[Model$EventType.values().length];
            r100[Model$EventType.V3.ordinal()] = 1;
            r100[Model$EventType.V1.ordinal()] = 2;
            r100[Model$EventType.LogData.ordinal()] = 3;
            r100[Model$EventType.Launch.ordinal()] = 4;
            r100[Model$EventType.Terminate.ordinal()] = 5;
            r100[Model$EventType.Impression.ordinal()] = 6;
            r100[Model$EventType.Unknown.ordinal()] = 7;
            r100[Model$EventType.ForwardV3.ordinal()] = 8;
            f192686a = r100;
            int[] r101 = new int[Model$GroupFrequencyAllow.values().length];
            r101[Model$GroupFrequencyAllow.Allow.ordinal()] = 1;
            r101[Model$GroupFrequencyAllow.BlockByBackoff.ordinal()] = 2;
            r101[Model$GroupFrequencyAllow.BlockByFrequency.ordinal()] = 3;
            f192687b = r101;
        }
    }

    @Override // com.bytedance.applog.priority.original.g
    public final int b() {
        return this.f192678b.f192757c;
    }

    @Override // com.bytedance.applog.priority.original.g
    public final int c() {
        return this.f192678b.f192755a;
    }

    @Override // com.bytedance.applog.priority.original.g
    public final void destroy() {
        this.f192683g.set(false);
    }

    @Override // com.bytedance.applog.priority.original.g
    public final void flush() {
        this.f192684h = 0;
    }

    public final String toString() {
        return "Group-" + this.f192678b.f192759e.f192775c + '-' + this.f192678b.f192755a + '-' + this.f192678b.f192757c + 's';
    }

    @Override // com.bytedance.applog.priority.original.g
    public final boolean a(long r100) {
        if (this.f192683g.get() == true) goto L6;
        return false;
    L6:
        if (this.f192678b.f192757c > 0) goto L9;
        return true;
    L9:
        if (this.f192684h > r100) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean f(JSONObject r100, HashMap r101) {
        Iterator r102 = r101.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        String r105 = (String) r103.getValue();
        if (Intrinsics.areEqual(r100.optString(r104), r105) == true) goto L4;
        Object r106 = r100.opt(r104);
        if (r106 == null) goto L10;
        String r107 = r106.toString();
    L12:
        if (Intrinsics.areEqual(r107, r105) == true) goto L4;
        return false;
    L10:
        r107 = null;
        goto L12
    L15:
        return true;
    }

    public final boolean e(final PriorityHttpResponse r110, final Map<j, ? extends JSONObject> r111) {
        int r100 = r110.getCode();
        if (200 <= r100) goto L5;
    L7:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L31;
        m r102 = this.f192678b.f192758d;
        int r103 = r102.f192768f.incrementAndGet();
        if (r102.f192767e.get() > 0) goto L13;
    L17:
        this.f192679c.a("Group:doWork", new Group$handleLogResponse$1(this, r110));
        JSONObject r104 = new JSONObject(r110.getData());
        if (Intrinsics.areEqual(r104.optString("message"), "success") == true) goto L20;
    L22:
        boolean r105 = false;
    L23:
        if (r105 == false) goto L27;
        Set<j> r112 = r111.keySet();
        Intrinsics.checkNotNullParameter(r112, "keys");
        this.f192682f.b(r112);
        PriorityCallback r113 = this.f192680d;
        l r106 = this.f192678b;
        CommonKt.m(r113, "3F", r111, r106.f192759e.f192775c, r106.f192755a);
        CommonKt.j(this.f192680d, this.f192678b.f192755a, r111);
        this.f192680d.monitorIncreaseStats("priority_request_success_cnt", 1);
        this.f192679c.a("Group:doWork", new Group$handleLogResponse$2(this, r111));
        this.f192678b.f192759e.f192773a.i(r104);
        return true;
    L27:
        if (this.f192680d.isMonitorEnabled() == false) goto L29;
        this.f192680d.monitorError("post priority[" + this + "] log biz error", "response: " + r110);
    L29:
        this.f192679c.b("Group:doWork", null, new Group$handleLogResponse$3(this, r110));
    L55:
        PriorityCallback r114 = this.f192680d;
        l r107 = this.f192678b;
        CommonKt.m(r114, "3B", r111, r107.f192759e.f192775c, r107.f192755a);
        this.f192680d.monitorIncreaseStats("priority_request_failed_cnt", 1);
        return false;
    L20:
        if (Intrinsics.areEqual(r104.optString("magic_tag"), "ss_app_log") == false) goto L22;
        r105 = true;
        goto L23
    L13:
        if (r103 < r102.f192772j) goto L15;
    L16:
        r102.f192767e.set(0);
        goto L17
    L15:
        if (r102.f192763a == false) goto L17;
    L31:
        if (500 <= r100) goto L33;
    L35:
        boolean r108 = false;
    L36:
        if (r108 == false) goto L44;
        m r109 = this.f192678b.f192758d;
        r109.f192768f.set(r109.f192766d);
        r109.f192769g = r109.f192770h;
        if (r109.f192767e.incrementAndGet() <= 4) goto L41;
        r109.f192767e.set(4);
    L41:
        if (this.f192680d.isMonitorEnabled() == false) goto L55;
        this.f192680d.monitorError("post priority[" + this + "] log 5xx error", "response: " + r110);
        goto L55
    L44:
        if (400 > r100) goto L47;
        if (r100 >= 500) goto L47;
        boolean r115 = true;
    L48:
        if (r115 == false) goto L52;
        this.f192678b.f192758d.getClass();
        this.f192679c.b("Group:doWork", null, new Group$handleLogResponse$4(this, r110));
        if (this.f192680d.isMonitorEnabled() == false) goto L55;
        this.f192680d.monitorError("post priority[" + this + "] log 4xx error", "response: " + r110);
        goto L55
    L52:
        this.f192679c.b("Group:doWork", null, new Group$handleLogResponse$5(this, r110));
        if (this.f192680d.isMonitorEnabled() == false) goto L55;
        this.f192680d.monitorError("post priority[" + this + "] log unknown error", "response: " + r110);
    L47:
        r115 = false;
        goto L48
    L33:
        if (r100 >= 600) goto L35;
        r108 = true;
        goto L36
    L5:
        if (r100 >= 300) goto L7;
        r101 = true;
        goto L9
    }

    @Override // com.bytedance.applog.priority.original.g
    public final Object d(i r110, long r210, Continuation r211) {
        if ((r211 instanceof Group$doWork$1) == false) goto L7;
        Group$doWork$1 r100 = (Group$doWork$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Lazy r105 = (Lazy) r100.L$1;
        final Group r106 = (Group) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L69:
        int r107 = r106.f192678b.f192758d.f192766d;     // Catch: Throwable -> L66
        final int r108 = 0;
    L32:
        if (r108 >= r107) goto L64;
        if (r106.f192683g.get() == false) goto L64;
        if (r106.f192682f.e(r106.f192678b.f192755a) == true) goto L64;
        Model$GroupFrequencyAllow r109 = r106.f192678b.f192758d.a();     // Catch: Throwable -> L66
        int r111 = a.f192687b[r109.ordinal()];     // Catch: Throwable -> L66
        if (r111 != 1) goto L41;
        r106.f192679c.a("Group:doWork", new Group$doWork$4(r106, r108));     // Catch: Throwable -> L66
    L48:
        n r112 = r106.f192678b.f192759e;     // Catch: Throwable -> L66
        long r113 = r112.f192777e;     // Catch: Throwable -> L66
        int r114 = r112.f192778f;     // Catch: Throwable -> L66
        long r115 = r112.f192779g * ((long) 1000);     // Catch: Throwable -> L66
        Function1<JSONObject, Boolean> r116 = new Group$doWork$7(r106);     // Catch: Throwable -> L66
        Intrinsics.checkNotNullParameter(r116, "filter");     // Catch: Throwable -> L66
        Pair<HashMap<j, JSONObject>, Boolean> r117 = r106.f192682f.c(r106.f192678b.f192755a, r113, r114, r115, r116);     // Catch: Throwable -> L66
        final HashMap<j, JSONObject> r118 = r117.component1();     // Catch: Throwable -> L66
        boolean r119 = r117.component2().booleanValue();     // Catch: Throwable -> L66
        if (r118.isEmpty() == true) goto L50;
        if (r105.getValue() == null) goto L53;
        r106.f192679c.a("Group:doWork", new Group$doWork$10(r106, r118));     // Catch: Throwable -> L66
        JSONObject r120 = new JSONObject();     // Catch: Throwable -> L66
        r120.put("header", r105.getValue());     // Catch: Throwable -> L66
        CommonKt.c(r120, r118, r106.f192677a.getContext().f192622c);     // Catch: Throwable -> L66
        JSONObject r121 = new JSONObject();     // Catch: Throwable -> L66
        l r122 = r106.f192678b;     // Catch: Throwable -> L66
        r121.put("backoff_priority", r122.f192758d.f192764b.b(Boxing.boxInt(r122.f192755a)));     // Catch: Throwable -> L66
        l r123 = r106.f192678b;     // Catch: Throwable -> L66
        r121.put("group_priority", r123.f192756b.b(Boxing.boxInt(r123.f192755a)));     // Catch: Throwable -> L66
        n r124 = r106.f192678b.f192759e;     // Catch: Throwable -> L66
        r121.put("event_priority_config", r124.f192774b.b(r124.f192775c.name()));     // Catch: Throwable -> L66
        CommonKt.e(r121, r106.f192680d);     // Catch: Throwable -> L66
        r120.put("options", r121);     // Catch: Throwable -> L66
        CommonKt.d(r120);     // Catch: Throwable -> L66
        if (r106.f192677a.getContext().f192621b.f192614d == false) goto L57;
        Pair<String, String> r125 = CommonKt.f(r120, r106.f192677a.getContext().f192621b.f192615e);     // Catch: Throwable -> L66
    L58:
        r106.f192680d.monitorIncreaseStats("REPORT_REQUEST_COUNT", 1);     // Catch: Throwable -> L66
        if (r106.e(r106.f192680d.doHttpPost(r106.f192678b.f192762h, r120.toString().getBytes(Charsets.UTF_8), r125), r118) == false) goto L63;
        if (r119 == true) goto L63;
        r106.f192679c.a("Group:doWork", new Group$doWork$11(r106));     // Catch: Throwable -> L66
    L63:
        r108 = r108 + 1;
        goto L32
    L57:
        r125 = null;
        goto L58
    L53:
        r106.f192679c.a("Group:doWork", new Group$doWork$9(r106));     // Catch: Throwable -> L66
        goto L64
    L50:
        r106.f192679c.a("Group:doWork", new Group$doWork$8(r106));     // Catch: Throwable -> L66
        goto L64
    L41:
        if (r111 == 2) goto L46;
        if (r111 != 3) goto L48;
        r106.f192679c.a("Group:doWork", new Group$doWork$6(r106));     // Catch: Throwable -> L66
        goto L64
    L46:
        r106.f192679c.a("Group:doWork", new Group$doWork$5(r106));     // Catch: Throwable -> L66
    L64:
        r106.f192685i.set(false);
        return Unit.INSTANCE;
    L66:
        th = move-exception;
        r106.f192685i.set(false);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        this.f192684h = r210 + ((long) this.f192678b.f192757c);
        if (this.f192685i.compareAndSet(false, true) == true) goto L18;
        this.f192679c.b("Group:doWork", null, new Group$doWork$2(this));
        return Unit.INSTANCE;
    L18:
        this.f192679c.a("Group:doWork", new Group$doWork$3(this));
        if (this.f192678b.f192761g.contains(Model$EventType.Launch.getAlias()) == false) goto L21;
    L24:
        final AppSession r126 = this.f192681e;
        r100.L$0 = this;
        i r127 = r110;
        r100.L$1 = r127;
        r100.label = 1;
        r126.f192638a.f192622c.a("AppSession:packHistorySessionEvents", new AppSession$syncPackHistorySessionEvents$2(r126));
        Object r128 = r126.c(r126.f192641d, r100);
        if (r128 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        r128 = Unit.INSTANCE;
    L28:
        if (r128 != r103) goto L30;
        return r103;
    L30:
        r106 = this;
        r105 = r127;
        goto L69
    L21:
        if (this.f192678b.f192761g.contains(Model$EventType.Terminate.getAlias()) == true) goto L24;
        r127 = r110;
    L7:
        r100 = new Group$doWork$1(this, r211);
        goto L8
    }

    public final boolean g(Model$EventType r100, String r101, Lazy r110) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (this.f192678b.f192761g.contains(r100.getAlias()) == true) goto L6;
        return false;
    L6:
        if (this.f192678b.f192760f != null) goto L9;
        return true;
    L9:
        switch(a.f192686a[r100.ordinal()]) {
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L11;
            default: goto L14;
        };
    L11:
        return false;
    L12:
        return true;
    L14:
        if ((!this.f192678b.f192760f.f192792a.isEmpty()) == true) goto L16;
    L18:
        if (r110 != null) goto L21;
        return false;
    L21:
        if ((!this.f192678b.f192760f.f192793b.isEmpty()) == false) goto L73;
        List<List<String>> r102 = this.f192678b.f192760f.f192793b.get(r101);
        if (r102 == null) goto L46;
        JSONObject r103 = ((JSONObject) r110.getValue()).optJSONObject("params");
        if (r103 == null) goto L46;
        List<List<String>> r104 = r102;
        if ((r104 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r105 = r104.iterator();
    L33:
        if (r105.hasNext() == false) goto L43;
        Iterator r106 = ((List) r105.next()).iterator();
    L36:
        if (r106.hasNext() == false) goto L40;
        if (r103.has((String) r106.next()) == true) goto L36;
        boolean r107 = false;
    L41:
        if (r107 == false) goto L33;
        boolean r108 = true;
    L44:
        if (r108 == false) goto L46;
        return true;
    L40:
        r107 = true;
    L43:
        r108 = false;
        goto L44
    L29:
        if (r104.isEmpty() == false) goto L31;
    L46:
        List<List<String>> r109 = this.f192678b.f192760f.f192793b.get("*");
        if (r109 == null) goto L73;
        if ((!r109.isEmpty()) == false) goto L73;
        JSONObject r111 = ((JSONObject) r110.getValue()).optJSONObject("params");
        if (r111 == null) goto L73;
        List<List<String>> r112 = r109;
        if ((r112 instanceof Collection) == true) goto L55;
    L57:
        Iterator<T> r113 = r112.iterator();
    L59:
        if (r113.hasNext() == false) goto L69;
        Iterator r114 = ((List) r113.next()).iterator();
    L62:
        if (r114.hasNext() == false) goto L66;
        if (r111.has((String) r114.next()) == true) goto L62;
        boolean r115 = false;
    L67:
        if (r115 == false) goto L59;
        boolean r116 = true;
    L70:
        if (r116 == false) goto L73;
        return true;
    L66:
        r115 = true;
    L69:
        r116 = false;
        goto L70
    L55:
        if (r112.isEmpty() == false) goto L57;
    L73:
        if ((!this.f192678b.f192760f.f192794c.isEmpty()) == false) goto L112;
        List<HashMap<String, String>> r117 = this.f192678b.f192760f.f192794c.get(r101);
        if (r117 == null) goto L92;
        JSONObject r118 = ((JSONObject) r110.getValue()).optJSONObject("params");
        if (r118 == null) goto L92;
        List<HashMap<String, String>> r119 = r117;
        if ((r119 instanceof Collection) == true) goto L81;
    L83:
        Iterator<T> r120 = r119.iterator();
    L85:
        if (r120.hasNext() == false) goto L89;
        if (f(r118, (HashMap) r120.next()) == false) goto L85;
        boolean r121 = true;
    L90:
        if (r121 == false) goto L92;
        return true;
    L89:
        r121 = false;
        goto L90
    L81:
        if (r119.isEmpty() == false) goto L83;
    L92:
        List<HashMap<String, String>> r122 = this.f192678b.f192760f.f192794c.get("*");
        if (r122 == null) goto L112;
        if ((!r122.isEmpty()) == false) goto L112;
        JSONObject r123 = ((JSONObject) r110.getValue()).optJSONObject("params");
        if (r123 == null) goto L112;
        List<HashMap<String, String>> r124 = r122;
        if ((r124 instanceof Collection) == true) goto L101;
    L103:
        Iterator<T> r125 = r124.iterator();
    L105:
        if (r125.hasNext() == false) goto L109;
        if (f(r123, (HashMap) r125.next()) == false) goto L105;
        boolean r126 = true;
    L110:
        if (r126 == false) goto L112;
        return true;
    L109:
        r126 = false;
        goto L110
    L101:
        if (r124.isEmpty() == false) goto L103;
    L112:
        return false;
    L16:
        if (this.f192678b.f192760f.f192792a.contains(r101) == false) goto L18;
        return true;
    }

    public Group(o r100, l r101, com.bytedance.applog.log.a r102, PriorityCallback r103, AppSession r104) {
        Intrinsics.checkNotNullParameter(r100, "priorityContext");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "logger");
        Intrinsics.checkNotNullParameter(r103, "callback");
        Intrinsics.checkNotNullParameter(r104, "appSession");
        this.f192677a = r100;
        this.f192678b = r101;
        this.f192679c = r102;
        this.f192680d = r103;
        this.f192681e = r104;
        this.f192682f = r100.f192781a.a(r101.f192759e.f192775c);
        this.f192683g = new AtomicBoolean(true);
        this.f192685i = new AtomicBoolean(false);
    }
}
