package com.bytedance.ies.web.jsbridge2;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.lang.ref.SoftReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f249372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f249373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, d> f249374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, f.b> f249375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<c0> f249376e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<f> f249377f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<u> f249378g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f249379h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f249380i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o f249381j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p f249382k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f249383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f249384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JSONObject f249385c;

        public a(JSONObject r100) {
            this.f249383a = true;
            this.f249385c = r100;
        }

        public a(boolean r100, String r101) {
            this.f249383a = r100;
            this.f249384b = r101;
        }
    }

    public final String f() {
        if (((ConcurrentHashMap) this.f249374c).isEmpty() == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L18;
        b r101 = this.f249380i;
        if (r101 == null) goto L17;
        if (r101.f249302f == false) goto L17;
        return "not_registered_2_release_empty";
    L17:
        return "not_registered_2empty";
    L18:
        b r102 = this.f249380i;
        if (r102 == null) goto L25;
        if (r102.f249302f == false) goto L25;
        return "not_registered_2_release";
    L25:
        return "not_registered_2_re";
    L5:
        if (((ConcurrentHashMap) this.f249375d).isEmpty() == true) goto L8;
        r100 = false;
        goto L9
    }

    public final void h() {
        Iterator<f> r100 = this.f249377f.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().terminateActual();
        goto L4
    L6:
        this.f249377f.clear();
        ((ConcurrentHashMap) this.f249374c).clear();
        ((ConcurrentHashMap) this.f249375d).clear();
        if (this.f249373b.f249369c != null) goto L10;
        return;
    L10:
        throw null;
    }

    public final void b(c0 r100) {
        Iterator<u> r101 = this.f249378g.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        r101.next().b(r100, 1);     // Catch: Throwable -> L8 AbstractMethodError -> L10
    L10:
        e = move-exception;
        e.getMessage();
    L8:
        th = move-exception;
        th.getMessage();
        goto L4
    }

    public final Object d(String r100, d r101) throws JSONException {
        l r102 = this.f249372a;
        Type r103 = r101.getClass().getGenericSuperclass();
        if (r103 == null) goto L15;
        Type r104 = ((ParameterizedType) r103).getActualTypeArguments()[0];
        r102.getClass();
        l.a(r100);
        if (r104.equals(JSONObject.class) == true) goto L13;
        if ((r104 instanceof Class) == false) goto L16;
        if (JSONObject.class.isAssignableFrom((Class) r104) == true) goto L13;
    L16:
        return r102.f249386a.b(r100, r104);
    L13:
        return new JSONObject(r100);
    L15:
        throw new IllegalStateException("Method is not parameterized?!");
    }

    public final a e(c0 r110, CallContext r111) throws Exception {
        p r100 = this.f249382k;
        JSONObject r112 = null;
        if (r100 == null) goto L5;
        r100.a();
        this.f249382k = null;
    L5:
        Map<String, d> r101 = this.f249374c;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        d r103 = (d) r102.get(r110.f249319d);
        String r104 = r111.f249267b;     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        if (TextUtils.isEmpty(r104) == false) goto L10;
    L11:
        String r105 = this.f249380i.h();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        if (TextUtils.isEmpty(r105) == true) goto L15;
        r111.f249267b = r105;     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        TimeLineEvent.b r106 = new TimeLineEvent.b();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r106.b("url", r105);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r106.a("label_call_new_url", r110.f249326k);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
    L15:
        if (r103 == null) goto L50;
        PermissionGroup r107 = c(r111, r103, r110.f249326k);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        if (r107 == null) goto L20;
        new TimeLineEvent.b().a("label_pre_handle_origin_url", r110.f249326k);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        if ((r103 instanceof g) == false) goto L44;
        r110.toString();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        d0.a r108 = d0.f249336g;     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        if (r108.a() == null) goto L33;
        g r109 = (g) r103;     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r108.a().c();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
    L33:
        g r113 = (g) r103;     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        Objects.toString(r113);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        Object r114 = r113.invoke(d(r110.f249320e, r113), r111);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        if ((r114 instanceof JSONObject) == true) goto L79;
    L39:
        if (r112 == null) goto L42;
        return new a(r112);
    L42:
        return new a(true, n0.b(this.f249372a, r114));
    L79:
        ((JSONObject) r114).put("code", 1);     // Catch: JSONException -> L77 PermissionConfig.IllegalRemoteConfigException -> L71
        r112 = (JSONObject) r114;     // Catch: JSONException -> L77 PermissionConfig.IllegalRemoteConfigException -> L71
        goto L39
    L44:
        if ((r103 instanceof e) == false) goto L50;
        r110.toString();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        d0.a r115 = d0.f249336g;     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        if (r115.a() == null) goto L48;
        e r116 = (e) r103;     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r115.a().b();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
    L48:
        ((e) r103).j(r110, new i0(r110.f249319d, r107, new j(this, r110)));     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        return new a(false, "");
    L20:
        if (TextUtils.isEmpty(r111.f249267b) == false) goto L22;
    L25:
        String r117 = "about_blank_1";
    L26:
        TimeLineEvent.b r118 = new TimeLineEvent.b();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r118.b("reason", "permission_empty_1");     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r118.a("label_call_handler_reject", r110.f249326k);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        String r119 = r117;
        a(r111.f249267b, r110.f249319d, 1, r119, r110.f249326k);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        b(r110);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r110.toString();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        throw new JsBridgeException(-1, "Permission denied");     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
    L22:
        if ("about:blank".equals(r111.f249267b) == true) goto L25;
        r117 = "permission_empty_1";
    L50:
        Map<String, f.b> r120 = this.f249375d;     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        ConcurrentHashMap r121 = (ConcurrentHashMap) r120;     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        f.b r122 = (f.b) r121.get(r110.f249319d);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        if (r122 == null) goto L69;
        f r123 = r122.a();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r123.setName(r110.f249319d);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        if (c(r111, r123, r110.f249326k) == null) goto L56;
        r110.toString();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        new TimeLineEvent.b().a("label_pre_handle_origin_url", r110.f249326k);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        d0.a r124 = d0.f249336g;     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        if (r124.a() == null) goto L67;
        r124.a().a();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
    L67:
        Objects.toString(r123);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        this.f249377f.add(r123);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r123.invokeActual(d(r110.f249320e, r123), r111, new i(this, r110, r123));     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        return new a(false, "");
    L56:
        if (TextUtils.isEmpty(r111.f249267b) == false) goto L58;
    L61:
        String r125 = "about_blank_2";
    L62:
        TimeLineEvent.b r126 = new TimeLineEvent.b();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r126.b("reason", "permission_empty_2");     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r126.a("label_call_handler_reject", r110.f249326k);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        String r127 = r125;
        a(r111.f249267b, r110.f249319d, 1, r127, r110.f249326k);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        b(r110);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r110.toString();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        r123.onDestroy();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
        throw new JsBridgeException(-1, "Permission denied");     // Catch: PermissionConfig.IllegalRemoteConfigException -> L71
    L58:
        if ("about:blank".equals(r111.f249267b) == true) goto L61;
        r125 = "permission_empty_2";
        goto L62
    L69:
        TimeLineEvent.b r128 = new TimeLineEvent.b();
        r128.b("reason", f());
        r128.a("label_call_handler_reject", r110.f249326k);
        a(r111.f249267b, r110.f249319d, 2, f(), r110.f249326k);
        r110.toString();
        return null;
    L10:
        if ("about:blank".equals(r104) == false) goto L15;
    L71:
        e = move-exception;
        r110.toString();
        if (m.f249390a == false) goto L75;
        Log.getStackTraceString(e);
    L75:
        TimeLineEvent.b r129 = new TimeLineEvent.b();
        r129.b(CrashHianalyticsData.EXCEPTION_NAME, e.getClass().getSimpleName());
        r129.b("exception_message", e.getMessage());
        r129.a("label_call_pending", r110.f249326k);
        ((ArrayList) this.f249376e).add(r110);
        return new a(false, "");
    }

    public final void g(String r100, r r101) {
        r101.setName(r100);
        ((ConcurrentHashMap) this.f249374c).put(r100, r101);
    }

    public k(o r100, b r101, PermissionConfig r102) {
        this.f249374c = new ConcurrentHashMap();
        this.f249375d = new ConcurrentHashMap();
        this.f249376e = new ArrayList();
        this.f249377f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f249380i = r101;
        this.f249381j = r100;
        this.f249372a = r100.f249400e;
        j0 r103 = new j0(r102, r100.f249407l, r100.f249408m, r100.f249415t);
        this.f249373b = r103;
        if (r103.f249369c != null) goto L10;
        this.f249378g = r100.f249405j;
        this.f249379h = r100.f249404i;
        this.f249382k = r100.f249413r;
        TimeLineEvent.b r104 = new TimeLineEvent.b();
        if (r102 == null) goto L7;
        boolean r105 = true;
    L8:
        r104.b("config", Boolean.valueOf(r105));
        r104.a("label_create_call_handler", r100.f249411p);
        return;
    L7:
        r105 = false;
        goto L8
    L10:
        new SoftReference(this);
        throw null;
    }

    public final PermissionGroup c(CallContext r110, d r111, List<TimeLineEvent> r112) {
        o r100 = this.f249381j;
        if (r100 != null) goto L5;
        boolean r101 = false;
    L6:
        if (r101 == false) goto L8;
    L69:
        TimeLineEvent.b r102 = new TimeLineEvent.b();
        r102.b("url", r110.f249267b);
        r102.b("method_name", r111.getName());
        r102.b("method_class", r111.getClass().getSimpleName());
        r102.b("method_permission_group", r111.getPermissionGroup());
        r102.b("disable_all_permission_check", Boolean.TRUE);
        PermissionGroup r113 = PermissionGroup.PRIVATE;
        r102.b("call_permission_group", r113.toString());
        r102.a("label_permission_checker", r112);
        return r113;
    L8:
        if (r110.f249270e == false) goto L69;
        j0 r103 = this.f249373b;
        boolean r104 = this.f249379h;
        String r114 = r110.f249267b;
        monitor-enter(r103);
        TimeLineEvent.b r105 = new TimeLineEvent.b();     // Catch: Throwable -> L66
        r105.b("url", r114);     // Catch: Throwable -> L66
        r105.b("enable_permission_check", Boolean.valueOf(r104));     // Catch: Throwable -> L66
        r105.b("method_name", r111.getName());     // Catch: Throwable -> L66
        r105.b("method_class", r111.getClass().getSimpleName());     // Catch: Throwable -> L66
        r105.b("method_permission_group", r111.getPermissionGroup());     // Catch: Throwable -> L66
        r105.a("label_permission_checker", r112);     // Catch: Throwable -> L66
        Uri r106 = UriProtector.parse(r114);     // Catch: Throwable -> L66
        PermissionGroup r107 = null;
        if (r103.f249371e == true) goto L15;
    L20:
        String r108 = r106.getHost();     // Catch: Throwable -> L66
        boolean r109 = r103.f249368b.contains(r111.getName());     // Catch: Throwable -> L66
        TimeLineEvent.b r115 = new TimeLineEvent.b();     // Catch: Throwable -> L66
        if (r109 == false) goto L23;
        String r116 = PermissionGroup.PUBLIC.toString();     // Catch: Throwable -> L66
    L24:
        r115.b("call_permission_group", r116);     // Catch: Throwable -> L66
        r115.b("public_method_set", r103.f249368b);     // Catch: Throwable -> L66
        r115.a("label_permission_public_method", r112);     // Catch: Throwable -> L66
        if (r108 != null) goto L32;
        TimeLineEvent.b r117 = new TimeLineEvent.b();     // Catch: Throwable -> L66
        r117.b("host", "null");     // Catch: Throwable -> L66
        r117.a("label_permission_checker_null_host", r112);     // Catch: Throwable -> L66
        if (r109 == false) goto L29;
        r107 = PermissionGroup.PUBLIC;     // Catch: Throwable -> L66
    L29:
        monitor-exit(r103);
    L65:
        return r107;
    L32:
        if (r111.getPermissionGroup() == PermissionGroup.SECURE) goto L44;
        Iterator<String> r118 = r103.f249367a.iterator();     // Catch: Throwable -> L66
    L35:
        if (r118.hasNext() == false) goto L43;
        String r119 = r118.next();     // Catch: Throwable -> L66
        if (r106.getHost().equals(r119) == true) goto L40;
        if (r108.endsWith("." + r119) == false) goto L35;
    L40:
        TimeLineEvent.b r120 = new TimeLineEvent.b();     // Catch: Throwable -> L66
        r107 = PermissionGroup.PRIVATE;     // Catch: Throwable -> L66
        r120.b("call_permission_group", r107.toString());     // Catch: Throwable -> L66
        r120.b("host", r108);     // Catch: Throwable -> L66
        r120.b("safe_host_set", r103.f249367a);     // Catch: Throwable -> L66
        r120.a("label_permission_checker_safe_host", r112);     // Catch: Throwable -> L66
        monitor-exit(r103);
        goto L65
    L43:
        TimeLineEvent.b r121 = new TimeLineEvent.b();     // Catch: Throwable -> L66
        r121.b("call_permission_group", "null");     // Catch: Throwable -> L66
        r121.b("host", r108);     // Catch: Throwable -> L66
        r121.b("safe_host_set", r103.f249367a);     // Catch: Throwable -> L66
        r121.a("label_permission_checker_safe_host", r112);     // Catch: Throwable -> L66
    L44:
        r103.getClass();     // Catch: Throwable -> L66
        if (r104 == true) goto L72;
    L56:
        if (r107 != null) goto L59;
        if (r109 == false) goto L59;
        r107 = PermissionGroup.PUBLIC;     // Catch: Throwable -> L66
    L59:
        TimeLineEvent.b r122 = new TimeLineEvent.b();     // Catch: Throwable -> L66
        if (r107 != null) goto L62;
        String r123 = "null";
    L63:
        r122.b("call_permission_group", r123);     // Catch: Throwable -> L66
        r122.a("label_permission_checker_result", r112);     // Catch: Throwable -> L66
        monitor-exit(r103);
        goto L65
    L62:
        r123 = r107.toString();     // Catch: Throwable -> L66
        goto L63
    L72:
        r107 = r103.a(r114, r111, r112);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L54 Throwable -> L66
        if (r107 != null) goto L56;
        if (r109 == true) goto L56;
        if (r103.f249370d == null) goto L56;
        PermissionConfig.b(r108);     // Catch: PermissionConfig.IllegalRemoteConfigException -> L54 Throwable -> L66
        r103.f249370d.getClass();     // Catch: PermissionConfig.IllegalRemoteConfigException -> L54 Throwable -> L66
        throw new PermissionConfig.IllegalRemoteConfigException("Permission config is outdated!");     // Catch: PermissionConfig.IllegalRemoteConfigException -> L54 Throwable -> L66
    L54:
        e = move-exception;
        throw e;     // Catch: Throwable -> L66
    L23:
        r116 = "null";
        goto L24
    L15:
        if ("http".equalsIgnoreCase(r106.getScheme()) == true) goto L20;
        if ("https".equalsIgnoreCase(r106.getScheme()) == true) goto L20;
        monitor-exit(r103);
    L66:
        th = move-exception;
        throw th;
    L5:
        r101 = r100.f249410o;
        goto L6
    }

    public final void a(String r100, String r110, int r111, String r112, List<TimeLineEvent> r113) {
        Iterator<u> r101 = this.f249378g.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().c(r100, r110, r111, r112, new o0(d0.f249339j, this.f249380i.f249308l, r113));
        goto L4
    }
}
