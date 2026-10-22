package com.ss.android.ugc.route_monitor.impl.route_in;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.route_monitor.ComponentType;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import com.ss.android.ugc.route_monitor.api.RouteLazyConfigProxy;
import com.ss.android.ugc.route_monitor.api.RouteResult;
import com.ss.android.ugc.route_monitor.impl.PresetStageEnum;
import com.ss.android.ugc.route_monitor.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class u extends com.ss.android.ugc.route_monitor.impl.route_in.c {
    public volatile ihc.c A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f454561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f454562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f454563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f454564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f454565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f454566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RouteResult f454567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedList<ihc.o> f454568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f454569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f454570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f454571k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<String> f454572l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<b> f454573m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f454574n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f454575o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f454576p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, Boolean> f454577q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, Boolean> f454578r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final HashMap<String, Object> f454579s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f454580t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.ss.android.ugc.route_monitor.impl.route_in.b f454581u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Map<String, Object> f454582v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.ss.android.ugc.route_monitor.utils.j<ihc.n> f454583w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicBoolean f454584x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f454585y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.ss.android.ugc.route_monitor.impl.launch_info.f f454586z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<Activity> f454587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f454588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f454589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f454590d;

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Integer.valueOf(this.f454588b), this.f454589c, this.f454590d});
        }

        public final String toString() {
            return "{activityHash=" + this.f454588b + ", activityClassName=" + this.f454589c + ", stage=" + this.f454590d + '}';
        }

        public final WeakReference<Activity> getActivity() {
            return this.f454587a;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof b) == false) goto L11;
            b r101 = (b) r100;
            if (r101.f454588b != this.f454588b) goto L11;
            ihc.f r102 = com.ss.android.ugc.route_monitor.c.a();
            String r103 = r101.f454589c;
            String r104 = this.f454589c;
            r102.getClass();
            if (Intrinsics.areEqual(r103, r104) == false) goto L11;
            if (Intrinsics.areEqual(r101.f454590d, this.f454590d) == false) goto L11;
            return true;
        L11:
            return false;
        }

        public b(Activity r100, String r101) {
            this.f454590d = r101;
            this.f454587a = new WeakReference(r100);
            this.f454588b = r100.hashCode();
            this.f454589c = r100.getClass().getName();
        }
    }

    public static final class c implements com.ss.android.ugc.route_monitor.utils.j.a<ihc.n> {
        @Override // com.ss.android.ugc.route_monitor.utils.j.a
        public /* bridge */ /* synthetic */ void call(com.ss.android.ugc.route_monitor.utils.j.b r100) {
            call((ihc.n) r100);
        }

        public void call(ihc.n r100) {
            r100.n();
        }

        public c(u r100, RouteResult r101) {
        }
    }

    static {
    }

    public final List<b> d() {
        LinkedHashSet r100 = new LinkedHashSet();
        ArrayList r101 = new ArrayList();
        Iterator<b> r102 = this.f454573m.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        b r103 = r102.next();
        if (r100.contains(Integer.valueOf(r103.f454588b)) == true) goto L4;
        r100.add(Integer.valueOf(r103.f454588b));
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    public final JSONObject e() {
        if (this.f454565e <= this.f454562b) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        n();
    L9:
        if (this.f454566f.length() != 0) goto L11;
        boolean r101 = true;
    L12:
        if (r101 == false) goto L21;
        if ((!this.f454573m.isEmpty()) == false) goto L21;
        String r102 = ((b) CollectionsKt.last(this.f454573m)).f454589c;
        if (r102 != null) goto L19;
        r102 = "";
    L19:
        this.f454566f = r102;
    L21:
        if (this.f454564d.length() != 0) goto L23;
        boolean r103 = true;
    L24:
        Long r104 = null;
        if (r103 == false) goto L31;
        String r105 = com.ss.android.ugc.route_monitor.impl.launch_info.h.b(null);
        if (r105 != null) goto L30;
        r105 = com.ss.android.ugc.route_monitor.impl.launch_info.h.b(null);
    L30:
        this.f454564d = r105;
    L31:
        List<b> r106 = d();
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator r108 = ((ArrayList) r106).iterator();
    L33:
        if (r108.hasNext() == false) goto L35;
        r107.add(((b) r108.next()).f454589c);
        goto L33
    L35:
        JSONObject r109 = new JSONObject();
        RouteMonitorManager r110 = RouteMonitorManager.f454384g;
        String r111 = this.f454585y;
        r110.getClass();
        StringBuilder r112 = new StringBuilder("_");
        com.ss.android.ugc.route_monitor.c.a().d();
        r112.append(r111);
        r109.put(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, r112.toString());
        r110.b().getClass();
        r109.put("time_stamp", this.f454563c);
        r110.b().getClass();
        r109.put("is_foreground", this.f454581u.f454506e);
        r109.put(HiAnalyticsConstant.BI_KEY_COST_TIME, this.f454565e);
        r109.put("report_reason", 1);
        r109.put("route_monitor_mode", this.A.toString());
        r109.put("route_result_code", this.f454567g.getErrorCode());
        r109.put("route_result_msg", this.f454567g.getErrorMsg());
        r109.put("biz_error_code", 0);
        r109.put("biz_error_msg", this.f454569i);
        if (this.f454567g.isSucceed() == false) goto L38;
        com.ss.android.ugc.route_monitor.c.a().getClass();
    L38:
        com.ss.android.ugc.route_monitor.impl.launch_info.f r113 = this.f454586z;
        String r114 = r113.f454469e;
        Uri r115 = UriProtector.parse(r114);     // Catch: Throwable -> L41
    L42:
        r109.put("open_url", r114);
        r109.put("real_url", r113.f454469e);
        r109.put("intent_action", r113.f454470f);
        Object r116 = "";
        if (r115 == null) goto L47;
        Object r117 = r115.getScheme();
        if (r117 == null) goto L47;
    L48:
        r109.put("scheme", r117);
        if (r115 == null) goto L53;
        Object r118 = r115.getHost();
        if (r118 == null) goto L53;
    L54:
        r109.put("host", r118);
        if (r115 == null) goto L59;
        Object r119 = r115.getPath();
        if (r119 == null) goto L59;
    L60:
        r109.put("path", r119);
        r109.put("cold_boot", r113.f454467c);
        if (Intrinsics.areEqual(this.f454586z.f454465a, ihc.p.f489954g) == true) goto L63;
    L67:
        String r120 = this.f454586z.f454465a.f489955a;
        Locale r121 = Locale.ROOT;
        if (r120 == null) goto L185;
        Object r122 = r120.toLowerCase(r121);
    L70:
        r109.put(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD, r122);
        r109.put("referrer", r113.f454466b);
        r109.put("from_route_out_session", r113.f454468d);
        r109.put("first_component_name", r113.f454472h);
        r109.put("first_component_type", r113.f454473i);
        r109.put("to_page", this.f454566f);
        if (r115 != null) goto L73;
    L81:
        r109.put(AppConstants.BUNDLE_GD_LABEL, r116);
        r109.put("undertake_page_process", this.f454564d);
        LinkedList<ihc.o> r123 = this.f454568h;
        monitor-enter(r123);
        LinkedList<ihc.o> r124 = this.f454568h;     // Catch: Throwable -> L181
        JSONObject r125 = new JSONObject();     // Catch: Throwable -> L181
        JSONObject r126 = new JSONObject();     // Catch: Throwable -> L181
        Iterator r127 = CollectionsKt.withIndex(r124).iterator();     // Catch: Throwable -> L181
    L85:
        if (r127.hasNext() == false) goto L87;
        IndexedValue r128 = (IndexedValue) r127.next();     // Catch: Throwable -> L181
        r125.put("stage_" + r128.getIndex(), ((ihc.o) r128.getValue()).c());     // Catch: Throwable -> L181
        r126.put(((ihc.o) r128.getValue()).getDescribe(), "stage_" + r128.getIndex());     // Catch: Throwable -> L181
        goto L85
    L87:
        StringBuilder r129 = new StringBuilder();     // Catch: Throwable -> L181
        r129.append("stage_");     // Catch: Throwable -> L181
        r129.append(r124.size() - 1);     // Catch: Throwable -> L181
        r126.put("last_describe_stage", r129.toString());     // Catch: Throwable -> L181
        r125.put("stage_describe_map", r126);     // Catch: Throwable -> L181
        monitor-exit(r123);
        r109.put("combine_stages", r125);
        r109.put("pending_start_activity_list", CollectionsKt.toList(this.f454572l));
        r109.put("launched_activity_list", r107);
        List<jhc.f> r130 = com.ss.android.ugc.route_monitor.impl.launch_info.a.f454452a;
        r109.put("launched_service_list", com.ss.android.ugc.route_monitor.impl.launch_info.a.y(ComponentType.SERVICE));
        r109.put("launched_receiver_list", com.ss.android.ugc.route_monitor.impl.launch_info.a.y(ComponentType.RECEIVER));
        r109.put("app_status", this.f454581u.l());
        JSONObject r131 = new JSONObject();
        Iterator<T> r132 = this.f454568h.iterator();
    L91:
        if (r132.hasNext() == false) goto L100;
        Object r133 = r132.next();
        ihc.o r134 = (ihc.o) r133;
        if ((r134 instanceof com.ss.android.ugc.route_monitor.impl.f) == true) goto L95;
    L97:
        boolean r135 = false;
    L98:
        if (r135 == false) goto L91;
    L101:
        ihc.o r136 = (ihc.o) r133;
        if (r136 == null) goto L104;
        Long r137 = Long.valueOf(r136.getTimestamp());
    L105:
        Iterator<T> r138 = this.f454568h.iterator();
    L107:
        if (r138.hasNext() == false) goto L116;
        Object r139 = r138.next();
        ihc.o r140 = (ihc.o) r139;
        if ((r140 instanceof com.ss.android.ugc.route_monitor.impl.f) == true) goto L111;
    L113:
        boolean r141 = false;
    L114:
        if (r141 == false) goto L107;
    L117:
        ihc.o r142 = (ihc.o) r139;
        if (r142 == null) goto L120;
        Long r143 = Long.valueOf(r142.getTimestamp());
    L121:
        Iterator<T> r144 = this.f454568h.iterator();
    L123:
        if (r144.hasNext() == false) goto L132;
        Object r145 = r144.next();
        ihc.o r146 = (ihc.o) r145;
        if ((r146 instanceof com.ss.android.ugc.route_monitor.impl.f) == true) goto L127;
    L129:
        boolean r147 = false;
    L130:
        if (r147 == false) goto L123;
    L133:
        ihc.o r148 = (ihc.o) r145;
        if (r148 == null) goto L136;
        Long r149 = Long.valueOf(r148.getTimestamp());
    L137:
        LinkedList<ihc.o> r150 = this.f454568h;
        ListIterator<ihc.o> r151 = r150.listIterator(r150.size());
    L139:
        if (r151.hasPrevious() == false) goto L148;
        ihc.o r152 = r151.previous();
        ihc.o r153 = r152;
        if ((r153 instanceof com.ss.android.ugc.route_monitor.impl.f) == true) goto L143;
    L145:
        boolean r154 = false;
    L146:
        if (r154 == false) goto L139;
    L149:
        ihc.o r155 = r152;
        if (r155 == null) goto L152;
        Long r156 = Long.valueOf(r155.getTimestamp());
    L154:
        if (this.f454567g != RouteResult.SUCCEED) goto L158;
        ihc.o r157 = (ihc.o) CollectionsKt.lastOrNull(this.f454568h);
        if (r157 == null) goto L158;
        r104 = Long.valueOf(r157.getTimestamp());
    L158:
        if (r137 != null) goto L160;
    L164:
        if (r143 == null) goto L167;
        if (r149 == null) goto L167;
        r131.put("deeplink_stage_time", r149.longValue() - r143.longValue());
    L167:
        if (r149 == null) goto L170;
        if (r156 == null) goto L170;
        r131.put("transition_page_stage_time", r156.longValue() - r149.longValue());
    L170:
        if (r156 == null) goto L173;
        if (r104 == null) goto L173;
        r131.put("biz_success_stage_time", r104.longValue() - r156.longValue());
    L173:
        r109.put("stage_cost_time", r131);
        j(r109, r107);
        Iterator<Map.Entry<String, Object>> r158 = this.f454579s.entrySet().iterator();
    L175:
        if (r158.hasNext() == false) goto L180;
        Map.Entry<String, Object> r159 = r158.next();
        String r160 = r159.getKey();
        Object r161 = r159.getValue();
        if (r109.has(r160) == false) goto L178;
        Logger.f454747c.e();
        goto L175
    L178:
        r109.put(r160, r161);
        goto L175
    L180:
        return r109;
    L160:
        if (r143 == null) goto L162;
        r131.put("application_stage_time", r143.longValue() - r137.longValue());
        goto L164
    L162:
        if (r149 == null) goto L164;
        r131.put("application_stage_time", r149.longValue() - r137.longValue());
        goto L164
    L152:
        r156 = null;
        goto L154
    L143:
        if (StringsKt.startsWith$default(((com.ss.android.ugc.route_monitor.impl.f) r153).f454423i.getStageName(), "TransitionPage", false, 2, null) == false) goto L145;
        r154 = true;
        goto L146
    L148:
        r152 = null;
        goto L149
    L136:
        r149 = null;
        goto L137
    L127:
        if (StringsKt.startsWith$default(((com.ss.android.ugc.route_monitor.impl.f) r146).f454423i.getStageName(), "TransitionPage", false, 2, null) == false) goto L129;
        r147 = true;
        goto L130
    L132:
        r145 = null;
        goto L133
    L120:
        r143 = null;
        goto L121
    L111:
        if (((com.ss.android.ugc.route_monitor.impl.f) r140).f454423i != PresetStageEnum.DEEPLINK_ACTIVITY_ON_CREATE_START) goto L113;
        r141 = true;
        goto L114
    L116:
        r139 = null;
        goto L117
    L104:
        r137 = null;
        goto L105
    L95:
        if (((com.ss.android.ugc.route_monitor.impl.f) r134).f454423i != PresetStageEnum.APPLICATION_ATTACH_BASE_CONTEXT_START) goto L97;
        r135 = true;
        goto L98
    L100:
        r133 = null;
    L181:
        th = move-exception;
        throw th;
    L73:
        if (r115.isHierarchical() == true) goto L76;
        r115 = null;
    L76:
        if (r115 == null) goto L78;
        Object r162 = UriProtector.getQueryParameter(r115, AppConstants.BUNDLE_GD_LABEL);
    L79:
        if (r162 == null) goto L81;
        r116 = r162;
        goto L81
    L78:
        r162 = null;
        goto L79
    L185:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L63:
        if (this.f454572l.isEmpty() == false) goto L67;
        if (r107.isEmpty() == false) goto L67;
        r122 = "background".toLowerCase(Locale.ROOT);
    L59:
        r119 = "";
    L53:
        r118 = "";
    L47:
        r117 = "";
    L41:
        r115 = null;
        goto L42
    L23:
        r103 = false;
        goto L24
    L11:
        r101 = false;
        goto L12
    L5:
        r100 = false;
        goto L6
    }

    public final String g() {
        ihc.c r100 = this.A;
        if ((r100 instanceof ihc.e) == false) goto L9;
        if ((!this.f454572l.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (String) CollectionsKt.last(this.f454572l);
    L9:
        if ((r100 instanceof ihc.s) == false) goto L13;
        return ((ihc.s) r100).f489958b;
    L13:
        if ((r100 instanceof ihc.t) == false) goto L21;
        List<b> r101 = d();
        int r102 = ((ihc.t) r100).f489959b;
        if (r102 > 0) goto L17;
        return null;
    L17:
        if (((ArrayList) r101).size() >= r102) goto L19;
        return null;
    L19:
        return ((b) ListProtector.get(r101, r102 - 1)).f454589c;
    L21:
        if ((r100 instanceof ihc.b) == false) goto L31;
        List<b> r103 = d();
        if ((!r103.isEmpty()) == true) goto L25;
        return null;
    L25:
        if (((ArrayList) r103).size() >= ((ihc.b) r100).f489931b) goto L27;
        return null;
    L27:
        return ((b) CollectionsKt.last(r103)).f454589c;
    L31:
        return null;
    }

    public final boolean i() {
        ihc.c r100 = this.A;
        if ((r100 instanceof ihc.e) == false) goto L23;
        if (this.f454570j == false) goto L20;
        List<String> r101 = this.f454572l;
        if (r101.isEmpty() == false) goto L10;
    L8:
        boolean r102 = false;
    L18:
        if (r102 == false) goto L20;
        return true;
    L10:
        if (r101.size() > this.f454573m.size()) goto L8;
        String r103 = (String) CollectionsKt.lastOrNull(r101);
        Iterator<b> r104 = this.f454573m.iterator();
    L14:
        if (r104.hasNext() == false) goto L8;
        b r105 = r104.next();
        ihc.f r106 = com.ss.android.ugc.route_monitor.c.a();
        String r107 = r105.f454589c;
        r106.getClass();
        if (Intrinsics.areEqual(r107, r103) == false) goto L14;
        r102 = true;
    L20:
        return false;
    L23:
        if ((r100 instanceof ihc.s) == false) goto L33;
        List<b> r108 = this.f454573m;
        String r109 = ((ihc.s) r100).f489958b;
        int r110 = r108.size();
        int r111 = 0;
    L25:
        if (r111 >= r110) goto L30;
        ihc.f r112 = com.ss.android.ugc.route_monitor.c.a();
        String r113 = ((b) ListProtector.get(r108, (r110 - 1) - r111)).f454589c;
        r112.getClass();
        if (Intrinsics.areEqual(r113, r109) == true) goto L63;
        r111 = r111 + 1;
        goto L25
    L63:
        return true;
    L30:
        return false;
    L33:
        if ((r100 instanceof ihc.t) == false) goto L44;
        LinkedHashSet r114 = new LinkedHashSet();
        Iterator<b> r115 = this.f454573m.iterator();
    L36:
        if (r115.hasNext() == false) goto L39;
        r114.add(Integer.valueOf(r115.next().f454588b));
        goto L36
    L39:
        if (r114.size() >= ((ihc.t) r100).f489959b) goto L64;
        return false;
    L64:
        return true;
    L44:
        if ((r100 instanceof ihc.b) == false) goto L54;
        List<b> r116 = this.f454573m;
        LinkedHashSet r117 = new LinkedHashSet();
        Iterator<b> r118 = r116.iterator();
    L47:
        if (r118.hasNext() == false) goto L50;
        r117.add(Integer.valueOf(r118.next().f454588b));
        goto L47
    L50:
        if (r117.size() >= ((ihc.b) r100).f489931b) goto L65;
        return false;
    L65:
        return true;
    L54:
        return false;
    }

    public final void n() {
        RouteMonitorManager.f454384g.b().getClass();
        String r100 = g();
        boolean r101 = i();
        boolean r102 = k(r100);
        boolean r103 = h(r100);
        com.ss.android.ugc.route_monitor.impl.route_in.b r104 = this.f454581u;
        monitor-enter(r104);
    L48:
        th = move-exception;
        throw th;
    L5:
        if (r104.f454505d == true) goto L10;
        if (r104.f454507f != 0) goto L10;
        boolean r105 = true;
    L11:
        monitor-exit(r104);
        if (r105 == false) goto L15;
        RouteResult r106 = RouteResult.FAIL_TIMEOUT_BY_USER_ALWAYS_BACKGROUND;
    L46:
        Logger r107 = Logger.f454747c;
        Objects.toString(r106);
        r107.b();
        m(r106);
        return;
    L15:
        if (this.f454580t == false) goto L18;
        r106 = RouteResult.FAIL_TIMEOUT_BY_SESSION_INTERRUPTION;
        goto L46
    L18:
        if (TextUtils.isEmpty(r100) == false) goto L23;
        if (this.f454581u.f() <= 1) goto L23;
        r106 = RouteResult.FAIL_TIMEOUT_BY_UNKNOWN_UNDERTAKE_PAGE;
    L23:
        if ((this.A instanceof ihc.e) == true) goto L25;
    L29:
        if (r101 == false) goto L33;
        if (r102 == false) goto L33;
        if (r103 == false) goto L33;
        r106 = RouteResult.FAIL_TIMEOUT_BY_UNMET_BUSINESS_CONDITION;
    L33:
        if (r101 == false) goto L38;
        if (r102 == true) goto L38;
        if (this.f454581u.f() <= 1) goto L38;
        r106 = RouteResult.FAIL_TIMEOUT_BY_MISS_UNDERTAKE_PAGE_VIEW_SHOW;
    L38:
        if (r101 == true) goto L43;
        if (this.f454581u.f() <= 1) goto L43;
        r106 = RouteResult.FAIL_TIMEOUT_BY_NOT_REACHED_UNDERTAKE_PAGE;
    L43:
        if (this.f454581u.h() == false) goto L45;
        r106 = RouteResult.FAIL_TIMEOUT_BY_USER_ENTER_BACKGROUND;
        goto L46
    L45:
        r106 = RouteResult.FAIL_TIMEOUT;
        goto L46
    L25:
        if (this.f454570j == true) goto L29;
        if (this.f454581u.f() <= 1) goto L29;
        r106 = RouteResult.FAIL_TIMEOUT_BY_NOT_CALL_DEEPLINK_END;
    L10:
        r105 = false;
        goto L11
    }

    public final void o() {
        RouteMonitorManager.f454384g.b().getClass();
        a(new com.ss.android.ugc.route_monitor.impl.f(f(), "", PresetStageEnum.DEFAULT_TIMEOUT_END));
        n();
        l(true);
    }

    public final void p() {
        if (this.f454561a == true) goto L5;
        return;
    L5:
        q r100 = q.f454556c;
        String r101 = this.f454585y;
        JSONObject r102 = e();
        r100.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L10;
        Throwable r103 = new Throwable();
        r100.f454775b.execute(new com.ss.android.ugc.route_monitor.utils.e(r100, r101, r102, r103));
        return;
    }

    public final String f() {
        LinkedList<ihc.o> r100 = this.f454568h;
        monitor-enter(r100);
        String r101 = "stage_" + this.f454568h.size();     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void q() {
        boolean r100 = i();
        Logger r101 = Logger.f454747c;
        Objects.toString(this.f454572l);
        Objects.toString(this.f454573m);
        Objects.toString(this.A);
        r101.b();
        if (r100 == true) goto L6;
    L13:
        boolean r102 = false;
    L15:
        r101.b();
        if (r102 == true) goto L18;
        return;
    L18:
        if (this.f454565e <= this.f454562b) goto L20;
        boolean r103 = true;
    L21:
        if (r103 == false) goto L23;
        o();
        return;
    L23:
        com.ss.android.ugc.route_monitor.c.a().getClass();
        this.f454575o = SystemClock.uptimeMillis();
        m(RouteResult.SUCCEED);
        com.ss.android.ugc.route_monitor.c.a().getClass();
        l(false);
        return;
    L20:
        r103 = false;
        goto L21
    L6:
        if (this.f454571k != 0) goto L8;
        this.f454571k = SystemClock.uptimeMillis();
    L8:
        String r104 = g();
        r101.b();
        if (r104 == null) goto L13;
        if (h(r104) == true) goto L13;
        r102 = k(r104);
        goto L15
    }

    public final boolean a(com.ss.android.ugc.route_monitor.impl.b r100) {
        if (this.f454574n == false) goto L6;
        return false;
    L6:
        LinkedList<ihc.o> r101 = this.f454568h;
        monitor-enter(r101);
    L17:
        th = move-exception;
        throw th;
    L9:
        if ((!this.f454568h.isEmpty()) == false) goto L11;
        ihc.o r102 = this.f454568h.getLast();     // Catch: Throwable -> L17
        r102.b(r100.f454406c - r102.getTimestamp());     // Catch: Throwable -> L17
    L11:
        long r103 = SystemClock.uptimeMillis();     // Catch: Throwable -> L17
        r100.f454410g = r103 - this.f454563c;     // Catch: Throwable -> L17
        this.f454568h.add(r100);     // Catch: Throwable -> L17
        this.f454583w.b(new v(this, r100));     // Catch: Throwable -> L17
        this.f454565e = r103 - this.f454563c;     // Catch: Throwable -> L17
        if ((r100 instanceof com.ss.android.ugc.route_monitor.impl.f) == false) goto L14;
        com.ss.android.ugc.route_monitor.impl.f r104 = (com.ss.android.ugc.route_monitor.impl.f) r100;     // Catch: Throwable -> L17
    L14:
        p();     // Catch: Throwable -> L17
        monitor-exit(r101);
        return true;
    }

    public final boolean b(Activity r100) {
        if ((this.A instanceof ihc.e) == false) goto L46;
        RouteMonitorManager r101 = RouteMonitorManager.f454384g;
        r101.getClass();
        String r102 = r100.getClass().getName();
        if (r101.b().b().contains(r102) == false) goto L7;
    L36:
        return false;
    L7:
        if (r101.c(r100.getClass().getName()) == true) goto L36;
        LinkedList<ihc.o> r103 = this.f454568h;
        monitor-enter(r103);
        Iterator<ihc.o> r104 = this.f454568h.descendingIterator();     // Catch: Throwable -> L33
    L11:
        if (r104.hasNext() == false) goto L29;
        ihc.o r105 = r104.next();     // Catch: Throwable -> L33
        if ((r105 instanceof com.ss.android.ugc.route_monitor.impl.f) == false) goto L26;
        if (((com.ss.android.ugc.route_monitor.impl.f) r105).f454423i == PresetStageEnum.DEEPLINK_ACTIVITY_ON_CREATE_END) goto L23;
        if (Intrinsics.areEqual(this.f454586z.f454465a, ihc.p.f489950c) == false) goto L22;
        if (((com.ss.android.ugc.route_monitor.impl.f) r105).f454423i == PresetStageEnum.PUSH_ACTIVITY_ON_CREATE_END) goto L23;
    L22:
        if (((com.ss.android.ugc.route_monitor.impl.f) r105).f454423i != PresetStageEnum.DEEPLINK_END) goto L26;
    L23:
        monitor-exit(r103);
    L28:
        boolean r106 = true;
    L31:
        if (r106 == false) goto L36;
        return true;
    L26:
        if (Intrinsics.areEqual(this.f454586z.f454474j.get("inner_session"), Boolean.TRUE) == false) goto L11;
        monitor-exit(r103);
        goto L28
    L29:
        monitor-exit(r103);
        r106 = false;
    L33:
        th = move-exception;
        throw th;
    L46:
        return true;
    }

    public final boolean c(Activity r100) {
        if (i() == false) goto L11;
        ihc.f r101 = com.ss.android.ugc.route_monitor.c.a();
        String r102 = g();
        String r103 = r100.getClass().getName();
        r101.getClass();
        if (Intrinsics.areEqual(r102, r103) == false) goto L11;
        if (this.f454574n == false) goto L11;
        if (this.f454567g.isSucceed() == false) goto L11;
        return true;
    L11:
        return false;
    }

    public final boolean h(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Boolean r101 = (Boolean) ((ConcurrentHashMap) this.f454577q).get(r100);
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == true) goto L9;
        Map<String, Boolean> r103 = this.f454578r;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (Intrinsics.areEqual((Boolean) r104.get(this.f454585y), r102) == true) goto L9;
        return false;
    L9:
        return true;
    }

    public final boolean k(String r100) {
        LinkedList<ihc.o> r101 = this.f454568h;
        monitor-enter(r101);
        Iterator<ihc.o> r102 = this.f454568h.descendingIterator();     // Catch: Throwable -> L24
    L6:
        if (r102.hasNext() == false) goto L20;
        ihc.o r103 = r102.next();     // Catch: Throwable -> L24
        ihc.f r104 = com.ss.android.ugc.route_monitor.c.a();     // Catch: Throwable -> L24
        String r105 = r103.a();     // Catch: Throwable -> L24
        r104.getClass();     // Catch: Throwable -> L24
        if (Intrinsics.areEqual(r105, r100) == false) goto L6;
        PresetStageEnum r106 = null;
        if ((r103 instanceof com.ss.android.ugc.route_monitor.impl.f) == true) goto L12;
        r103 = null;
    L12:
        com.ss.android.ugc.route_monitor.impl.f r107 = (com.ss.android.ugc.route_monitor.impl.f) r103;     // Catch: Throwable -> L24
        if (r107 == null) goto L16;
        r106 = r107.f454423i;     // Catch: Throwable -> L24
    L16:
        if (r106 != PresetStageEnum.TRANSITION_PAGE_ON_VIEW_SHOW) goto L6;
        monitor-exit(r101);
        return true;
    L20:
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L24
        monitor-exit(r101);
        return false;
    L24:
        th = move-exception;
        throw th;
    }

    public final void l(boolean r100) {
        if ((this.A instanceof ihc.e) == true) goto L7;
        if (this.f454573m.isEmpty() == false) goto L7;
    L10:
        Logger r101 = Logger.f454747c;
        Objects.toString(this.A);
        Objects.toString(this.f454573m);
        r101.b();
        t.a(this);
        return;
    L7:
        if ((this.A instanceof ihc.r) == false) goto L12;
        com.ss.android.ugc.route_monitor.impl.launch_info.f r102 = this.f454586z;
        r102.getClass();
        if (RouteMonitorManager.f454384g.c(r102.f454472h) == false) goto L10;
    L12:
        com.ss.android.ugc.route_monitor.impl.route_in.b r103 = this.f454581u;
        monitor-enter(r103);
        d r104 = (d) CollectionsKt.lastOrNull(r103.f454502a);     // Catch: Throwable -> L30
        if (r104 == null) goto L20;
        if (r104.f454514a != 0) goto L20;
        boolean r105 = true;
    L21:
        monitor-exit(r103);
        if (r105 == false) goto L25;
        r103.f454503b = true;
        r103.c(true);
    L25:
        if (this.f454584x.compareAndSet(false, true) == false) goto L35;
        ConcurrentHashMap<String, u> r106 = t.f454558a;
        Logger.f454747c.b();
        String r107 = this.f454585y;
        q.f454556c.d(r107, "route_monitor_result", e());
        if (r100 == false) goto L36;
        t.f454558a.remove(r107);
        return;
    L36:
        return;
    L35:
        return;
    L20:
        r105 = false;
    L30:
        th = move-exception;
        throw th;
    }

    public final void m(RouteResult r100) {
        RouteResult r101 = this.f454567g;
        this.f454567g = r100;
        this.f454574n = true;
        if (r101 == r100) goto L5;
        p();
    L5:
        this.f454583w.b(new c(this, r100));
        if (t.f454560c != null) goto L16;
        t.f454560c = new com.ss.android.ugc.route_monitor.utils.j();
        RouteLazyConfigProxy r102 = RouteLazyConfigProxy.f454387b;
        if (r102.isLazy() == false) goto L16;
        com.ss.android.ugc.route_monitor.utils.j<jhc.j> r103 = t.f454560c;
        if (r103 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        List<jhc.j> r104 = r102.routeMonitorEventListenerList();
        r103.getClass();
        Iterator<jhc.j> r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        r103.a(r105.next());
    L16:
        com.ss.android.ugc.route_monitor.utils.j<jhc.j> r106 = t.f454560c;
        if (r106 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        r106.b(new r(r100, this));
    }

    public final void r(ActivityInfo r100) {
        String r101 = r100.name;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        this.f454566f = r101;
        String r102 = r100.processName;
        if (r102 != null) goto L10;
        r102 = com.ss.android.ugc.route_monitor.impl.launch_info.h.b(null);
    L10:
        this.f454564d = r102;
    }

    public u(String r100, com.ss.android.ugc.route_monitor.impl.launch_info.f r101) {
        ihc.r r102 = ihc.r.f489957b;
        this.f454585y = r100;
        this.f454586z = r101;
        this.A = r102;
        this.f454561a = true;
        this.f454562b = 15000;
        this.f454563c = SystemClock.uptimeMillis();
        this.f454564d = "";
        this.f454566f = "";
        this.f454567g = RouteResult.UNDEFINED;
        this.f454568h = new LinkedList();
        this.f454569i = "";
        this.f454572l = Collections.synchronizedList(new ArrayList());
        this.f454573m = Collections.synchronizedList(new ArrayList());
        this.f454577q = new ConcurrentHashMap();
        this.f454578r = new ConcurrentHashMap();
        this.f454579s = new HashMap();
        this.f454581u = new com.ss.android.ugc.route_monitor.impl.route_in.b();
        this.f454582v = new ConcurrentHashMap();
        this.f454583w = new com.ss.android.ugc.route_monitor.utils.j();
        this.f454584x = new AtomicBoolean(false);
    }

    public final void j(JSONObject r100, List<String> r110) {
        JSONObject r101 = new JSONObject();
        Iterator r102 = ((ConcurrentHashMap) this.f454582v).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Map.Entry r103 = (Map.Entry) r102.next();
        r101.put((String) r103.getKey(), r103.getValue());
        goto L4
    L6:
        long r104 = this.f454571k;
        long r105 = -1;
        if (r104 != 0) goto L9;
        long r106 = -1;
    L10:
        if (r104 == 0) goto L13;
        r105 = SystemClock.uptimeMillis() - this.f454571k;
    L13:
        String r107 = g();
        boolean r108 = h(r107);
        r101.put("undertake_page_name", r107);
        r101.put("open_to_undertake_page_duration", r106);
        r101.put("reach_undertake_page_to_end_duration", r105);
        r101.put("is_business_custom_success", r108);
        r101.put("bg_dur", this.f454581u.b());
        com.ss.android.ugc.route_monitor.impl.route_in.b r109 = this.f454581u;
        monitor-enter(r109);
        int r111 = r109.f454502a.size();     // Catch: Throwable -> L28
        monitor-exit(r109);
        r101.put("enter_bg_cnt", r111);
        r101.put("mock_enter_fg", this.f454581u.j());
        r101.put("initial_in_fg", this.f454581u.i());
        r101.put("first_switch_dur", this.f454581u.d());
        r101.put("last_switch_dur", this.f454581u.e());
        r101.put("launch_act_size", this.f454581u.f());
        int r112 = ((ArrayList) r110).size();
        boolean r113 = false;
        if (r112 <= 1) goto L26;
        int r114 = r112 - 1;
        int r115 = 0;
    L21:
        if (r115 >= r114) goto L26;
        ihc.f r116 = com.ss.android.ugc.route_monitor.c.a();
        String r117 = (String) ListProtector.get(r110, r115);
        r116.getClass();
        if (ihc.f.h(r117) == true) goto L24;
        r115 = r115 + 1;
        goto L21
    L24:
        r113 = true;
    L26:
        r101.put("travel_extra_main_page", r113);
        r100.put("extras", r101);
        return;
    L28:
        th = move-exception;
        throw th;
    L9:
        r106 = r104 - this.f454563c;
        goto L10
    }
}
