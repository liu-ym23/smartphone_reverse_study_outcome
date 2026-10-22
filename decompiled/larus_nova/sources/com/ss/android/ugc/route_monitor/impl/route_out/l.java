package com.ss.android.ugc.route_monitor.impl.route_out;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.route_monitor.ComponentType;
import com.ss.android.ugc.route_monitor.RouteMonitorManager;
import com.ss.android.ugc.route_monitor.impl.ViewEventTracker;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import com.ss.android.ugc.route_monitor.utils.Logger;
import com.ss.android.ugc.route_monitor.utils.u;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f454704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f454705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f454706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f454707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f454708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f454709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f454710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f454711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f454712i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f454713j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.ugc.route_monitor.impl.n f454714k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<com.ss.android.ugc.route_monitor.impl.n> f454715l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Object> f454716m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Intent f454717n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Deque<s> f454718o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ComponentType f454719p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f454720q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ControlRule f454721r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f454722s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Intent[] f454723t;

    public static final class a {
    }

    static {
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        o.f454736h.getClass();
        Activity r101 = o.b();
        RouteMonitorManager.f454384g.b().e().getClass();
        Object r102 = "";
        ((ConcurrentHashMap) this.f454716m).put("out_feed_group_id", "");
        ((ConcurrentHashMap) this.f454716m).put("out_feed_aweme_type", -1);
        ((ConcurrentHashMap) this.f454716m).put("out_page_group_id", "");
        ((ConcurrentHashMap) this.f454716m).put("out_page_aweme_type", -1);
        Iterator r103 = ((ConcurrentHashMap) this.f454716m).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L225;
        Map.Entry r104 = (Map.Entry) r103.next();
        r100.put((String) r104.getKey(), r104.getValue());
        goto L4
    L225:
        Map<String, Object> r105 = this.f454716m;     // Catch: Throwable -> L11
        if (r105 == null) goto L10;
        r100.put("scene_info", new JSONObject(r105));     // Catch: Throwable -> L11
    L13:
        r100.put(AppbrandHostConstants.SCHEMA_INSPECT.SESSION, this.f454704a);
        r100.put("target_app", this.f454705b);
        r100.put("target_page", this.f454706c);
        r100.put("component_type", this.f454719p);
        Object r106 = this.f454717n.getDataString();
        if (r106 != null) goto L17;
        r106 = "";
    L17:
        r100.put("target_page_data", r106);
        r100.put("invoke_timestamp", this.f454707d);
        r100.put("invoke_result", this.f454711h);
        r100.put("invoke_result_msg", this.f454712i);
        if (r101 == null) goto L20;
        Object r107 = r101.getClass().getName();
    L21:
        r100.put("from_scene", r107);
        Uri r108 = this.f454717n.getData();
        if (r108 == null) goto L26;
        Object r109 = r108.getScheme();
        if (r109 == null) goto L26;
    L27:
        r100.put("scheme", r109);
        Uri r110 = this.f454717n.getData();
        if (r110 == null) goto L32;
        Object r111 = r110.getHost();
        if (r111 == null) goto L32;
    L33:
        r100.put("host", r111);
        Intent r112 = this.f454717n;
        Uri r113 = r112.getData();
        int r114 = 0;
        ControlRule r115 = null;
        if (r113 != null) goto L223;
    L39:
        String r116 = null;
    L40:
        if (r116 != null) goto L42;
    L45:
        boolean r117 = true;
    L46:
        if (r117 == false) goto L50;
        r116 = r112.getStringExtra(AppConstants.BUNDLE_GD_LABEL);     // Catch: Throwable -> L38
    L49:
        r116 = null;
    L50:
        if (r116 != null) goto L53;
        r116 = "";
    L53:
        r100.put(AppConstants.BUNDLE_GD_LABEL, r116);
        r100.put("is_foreground", this.f454710g);
        r100.put("route_out_type", this.f454720q);
        JSONObject r118 = new JSONObject();
        Iterator r119 = CollectionsKt.withIndex(this.f454718o).iterator();
    L55:
        if (r119.hasNext() == false) goto L57;
        IndexedValue r120 = (IndexedValue) r119.next();
        String r121 = "page" + r120.getIndex();
        s r122 = (s) r120.getValue();
        r122.getClass();
        JSONObject r123 = new JSONObject();
        r123.put("page_name", r122.f454739b);
        r123.put("sub_page_name", "");
        r123.put("position_name", "");
        r123.put("enter_timestamp", r122.f454740c);
        r123.put("left_timestamp", r122.f454741d);
        List<lhc.b> r124 = lhc.d.f509310a;
        r123.put("page_url", lhc.d.b(r122.f454739b, r122.f454743f, r122.f454744g));
        r123.put("intentAction", r122.f454742e);
        RouteMonitorManager.f454384g.b().getClass();
        r123.put("intentExtra", "");
        r118.put(r121, r123);
        goto L55
    L57:
        r100.put("travel_page_list", r118);
        com.ss.android.ugc.route_monitor.impl.n r125 = this.f454714k;
        if (r125 == null) goto L60;
        Object r126 = r125.a();
    L61:
        r100.put("click_anchor_info", r126);
        JSONArray r127 = new JSONArray();
        Iterator<com.ss.android.ugc.route_monitor.impl.n> r128 = this.f454715l.iterator();
    L63:
        if (r128.hasNext() == false) goto L65;
        r127.put(r128.next().a());
        goto L63
    L65:
        r100.put("click_anchor_list", r127);
        JSONObject r129 = u.g(this.f454717n);
        String r130 = this.f454717n.getStringExtra("out_extra_obj");
        if (r130 != null) goto L68;
    L71:
        boolean r131 = true;
    L72:
        if (r131 == true) goto L77;
        JSONObject r132 = new JSONObject(r130);
        Iterator<String> r133 = r132.keys();
    L75:
        if (r133.hasNext() == false) goto L77;
        String r134 = r133.next();
        r129.put(r134, r132.get(r134));
    L77:
        r100.put("extra_data", r129);
        if (this.f454723t == null) goto L83;
        JSONArray r135 = new JSONArray();
        Intent[] r136 = this.f454723t;
        int r137 = r136.length;
        int r138 = 0;
    L80:
        if (r138 >= r137) goto L82;
        r135.put(u.g(r136[r138]));
        r138 = r138 + 1;
        goto L80
    L82:
        r100.put("intents", r135);
    L83:
        mhc.b r139 = com.ss.android.ugc.route_monitor.impl.route_out.control.j.f454635a;
        r100.put("open_route_out_control", com.ss.android.ugc.route_monitor.impl.route_out.control.j.a());
        RouteMonitorManager.f454384g.b().getClass();
        r100.put("enable_noncert_block", false);
        com.ss.android.ugc.route_monitor.impl.route_out.control.j.f454635a.getClass();
        r100.put("route_out_control_rule_version", 0);
        String r140 = this.f454717n.getStringExtra("route_out_biz_report_params");
        if (r140 != null) goto L86;
    L89:
        boolean r141 = true;
    L90:
        if (r141 == false) goto L106;
        Uri r142 = this.f454717n.getData();
        if (r142 != null) goto L94;
    L97:
        String r143 = null;
    L98:
        if (r143 != null) goto L100;
    L103:
        boolean r144 = true;
    L104:
        if (r144 == true) goto L106;
        r140 = Uri.decode(r143);
        goto L106
    L100:
        if (r143.length() == 0) goto L103;
        r144 = false;
        goto L104
    L94:
        if (r142.isOpaque() == true) goto L97;
        r143 = UriProtector.getQueryParameter(r142, "route_out_biz_report_params");
    L106:
        if (r140 != null) goto L222;
    L111:
        boolean r145 = true;
    L112:
        if (r145 == true) goto L114;
        Object r146 = new JSONObject(r140);     // Catch: Throwable -> L136
    L141:
        r100.put("biz_attribution_info", r146);
        ControlRule r147 = this.f454721r;
        RouteMonitorManager r148 = RouteMonitorManager.f454384g;
        r148.b().getClass();
        if (r147 == null) goto L146;
        String r149 = r147.getCertId();
        if (r149 == null) goto L146;
    L147:
        if (r147 == null) goto L151;
        String r150 = r147.getRuleId();
        if (r150 == null) goto L151;
    L152:
        if (r147 != null) goto L154;
        mhc.b r151 = com.ss.android.ugc.route_monitor.impl.route_out.control.j.f454635a;
        r149 = com.ss.android.ugc.route_monitor.impl.route_out.control.j.c(this.f454717n, "").f454619b;
    L154:
        mhc.b r152 = com.ss.android.ugc.route_monitor.impl.route_out.control.j.f454635a;
        com.ss.android.ugc.route_monitor.impl.route_out.control.r r153 = com.ss.android.ugc.route_monitor.impl.route_out.control.j.f(r149, r150);
        if (r153 == null) goto L157;
        com.ss.android.ugc.route_monitor.impl.route_out.control.s r154 = r153.f454669a;
    L158:
        r148.b().getClass();
        if (r154 == null) goto L161;
        r115 = r154.f454674d;
    L161:
        StringBuilder r155 = new StringBuilder();
        if (r154 == null) goto L172;
        List<mhc.c> r156 = r154.f454676f;
        if (r156 == null) goto L172;
        Iterator<mhc.c> r157 = r156.iterator();
    L167:
        if (r157.hasNext() == false) goto L172;
        mhc.c r158 = r157.next();
        RuleConditionBean r159 = r158.f514032c;
        if (r159 == null) goto L167;
        r155.append("certId:" + r158.f514031b.getCertId() + ",ruleId:" + r158.f514031b.getRuleId() + ",key:" + r159.getKey() + ",operator:" + r159.getOperation() + ",value:" + r159.getValue());
        r155.append("\n");
    L172:
        Object r160 = "unknown";
        if (r154 == null) goto L177;
        Object r161 = r154.f454672b;
        if (r161 == null) goto L177;
    L178:
        r100.put("rule_match_result", r161);
        if (r154 == null) goto L183;
        Object r162 = r154.f454673c;
        if (r162 == null) goto L183;
        r160 = r162;
    L183:
        r100.put("rule_match_result_msg", r160);
        r100.put("miss_match_conditions", r155.toString());
        if (r153 == null) goto L186;
        boolean r163 = r153.f454670b;
    L187:
        r100.put("show_dialog_by_illegal_route_out", r163);
        if (r154 == null) goto L190;
        boolean r164 = r154.f454675e;
    L191:
        r100.put("has_rule_for_cert_id", r164);
        if (r154 == null) goto L200;
        com.ss.android.ugc.route_monitor.impl.route_out.control.o r165 = r154.f454671a;
        if (r165 == null) goto L200;
        com.ss.android.ugc.route_monitor.impl.route_out.control.d r166 = r165.f454659c;
        if (r166 == null) goto L200;
        Object r167 = r166.f454620c;
        if (r167 == null) goto L200;
    L201:
        r100.put("cert_id_list", r167);
        if (r115 == null) goto L211;
        Object r168 = r115.getCertId();
        String r169 = r115.getLastPositionCertId();
        if (r169.length() != 0) goto L206;
        boolean r170 = true;
    L207:
        if (r170 == false) goto L209;
        r102 = r168;
    L210:
        Object r171 = r115.getRuleId();
        r114 = r115.getAction();
    L212:
        r100.put("cert_id", r168);
        r100.put("position_cert_id", r102);
        r100.put("rule_id", r171);
        r100.put("action", r114);
        if (r101 == null) goto L217;
        Intent r172 = r101.getIntent();
        if (r172 == null) goto L217;
        List<lhc.b> r173 = lhc.d.f509310a;
        r100.put("page_url", lhc.d.b(r101.getClass().getName(), r172.getDataString(), r172.getExtras()));
    L217:
        Object r174 = this.f454722s;
        if (r174 == null) goto L220;
        r100.put("source", r174);
    L220:
        com.ss.android.ugc.route_monitor.c.a().getClass();
        return r100;
    L209:
        r102 = r169;
        goto L210
    L206:
        r170 = false;
        goto L207
    L211:
        mhc.b r175 = com.ss.android.ugc.route_monitor.impl.route_out.control.j.f454635a;
        r168 = com.ss.android.ugc.route_monitor.impl.route_out.control.j.c(this.f454717n, "").f454619b;
        r171 = "";
    L200:
        r167 = new JSONArray();
        goto L201
    L190:
        r164 = false;
        goto L191
    L186:
        r163 = false;
    L177:
        r161 = "unknown";
        goto L178
    L157:
        r154 = null;
    L151:
        r150 = "";
    L146:
        r149 = "";
        goto L147
    L114:
        ControlRule r176 = this.f454721r;     // Catch: Throwable -> L136
        if (r176 == null) goto L117;
        String r177 = r176.getCertId();     // Catch: Throwable -> L136
    L118:
        if (r140 != null) goto L120;
    L123:
        boolean r178 = true;
    L124:
        if (r178 == false) goto L138;
        if (r177 != null) goto L127;
    L130:
        boolean r179 = true;
    L131:
        if (r179 == true) goto L138;
        Map r180 = com.ss.android.ugc.route_monitor.impl.route_out.control.j.d(r177);     // Catch: Throwable -> L136
        if (r180 == null) goto L135;
        r146 = com.ss.android.ugc.route_monitor.utils.p.d(r180);     // Catch: Throwable -> L136
        goto L141
    L135:
        r146 = new JSONObject();     // Catch: Throwable -> L136
        goto L141
    L127:
        if (r177.length() == 0) goto L130;
        r179 = false;
    L138:
        r146 = new JSONObject();     // Catch: Throwable -> L136
        goto L141
    L120:
        if (r140.length() == 0) goto L123;
        r178 = false;
        goto L124
    L117:
        r177 = null;
        goto L118
    L222:
    L136:
        th = move-exception;
        Logger.f454747c.d(th);
        r146 = new JSONObject();
        goto L141
    L108:
        if (r140.length() == 0) goto L111;
        r145 = false;
        goto L112
    L86:
        if (r140.length() == 0) goto L89;
        r141 = false;
        goto L90
    L68:
        if (r130.length() == 0) goto L71;
        r131 = false;
        goto L72
    L60:
        r126 = SliceInitService.DEFAULT_SWITCH;
        goto L61
    L42:
        if (r116.length() == 0) goto L45;
        r117 = false;
        goto L46
    L223:
        if (r113.isHierarchical() != true) goto L39;
        r116 = UriProtector.getQueryParameter(r113, AppConstants.BUNDLE_GD_LABEL);     // Catch: Throwable -> L38
    L32:
        r111 = "";
    L26:
        r109 = "";
        goto L27
    L20:
        r107 = "";
        goto L21
    L10:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<*, *>");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Logger.f454747c.d(th);
        goto L13
    }

    public final String toString() {
        return a().toString();
    }

    public l(ComponentInfo r100, Intent r101, Deque<s> r102, ComponentType r103, String r104, ControlRule r105, String r106, Intent[] r107) {
        this.f454717n = r101;
        this.f454718o = r102;
        this.f454719p = r103;
        this.f454720q = r104;
        this.f454721r = r105;
        this.f454722s = r106;
        this.f454723t = r107;
        this.f454704a = "RouteOutMonitor-" + u.h(true);
        String r108 = "";
        if (r100 == null) goto L9;
        ApplicationInfo r109 = r100.applicationInfo;
        if (r109 == null) goto L9;
        String r110 = r109.packageName;
        if (r110 == null) goto L9;
    L10:
        this.f454705b = r110;
        if (r100 == null) goto L15;
        String r111 = r100.name;
        if (r111 == null) goto L15;
        r108 = r111;
    L15:
        this.f454706c = r108;
        this.f454707d = System.currentTimeMillis();
        this.f454708e = SystemClock.elapsedRealtime();
        this.f454710g = com.ss.android.ugc.route_monitor.utils.c.t();
        this.f454712i = "succeed";
        ViewEventTracker.f454400c.getClass();
        LinkedList<com.ss.android.ugc.route_monitor.impl.n> r112 = ViewEventTracker.f454398a;
        this.f454714k = (com.ss.android.ugc.route_monitor.impl.n) CollectionsKt.firstOrNull(r112);
        if (r112.isEmpty() == false) goto L18;
        List<com.ss.android.ugc.route_monitor.impl.n> r113 = CollectionsKt.emptyList();
    L19:
        this.f454715l = r113;
        this.f454716m = new ConcurrentHashMap();
        return;
    L18:
        r113 = r112.subList(0, Math.min(Math.max(20, 0), r112.size()));
    L9:
        r110 = "";
        goto L10
    }
}
