package com.bytedance.ies.web.jsbridge2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f249296m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f249297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<u> f249298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f249299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f249300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f249301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f249302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ies.web.jsbridge2.a f249303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f249304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public k f249305i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public v f249306j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, k> f249307k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<TimeLineEvent> f249308l;

    public class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ies.web.jsbridge2.b$b, reason: collision with other inner class name */
    public class RunnableC3555b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c0 f249309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TimeLineEvent f249310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f249311c;

        public final void a() {
            if (this.f249311c.f249302f == false) goto L5;
            return;
        L5:
            c0 r100 = this.f249309a;
            if (r100 == null) goto L9;
            List<TimeLineEvent> r101 = r100.f249326k;
            CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) r101;
            r102.add(this.f249310b);
        L9:
            if (c0.b(this.f249309a) == false) goto L14;
            Objects.toString(this.f249309a);
            if (this.f249309a == null) goto L16;
            TimeLineEvent.b r103 = new TimeLineEvent.b();
            r103.b("reason", "call_invalid_2");
            r103.a("label_abstract_bridge_reject", this.f249309a.f249326k);
            b r104 = this.f249311c;
            String r105 = r104.h();
            c0 r106 = this.f249309a;
            r104.c(r105, r106.f249319d, 3, "call_invalid_2", r106.f249326k);
            this.f249311c.e(n0.a(new JsBridgeException(this.f249309a.f249316a, "Failed to parse invocation.")), this.f249309a);
            return;
        L16:
            return;
        L14:
            b.b(this.f249311c, this.f249309a);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC3555b(b r100, c0 r101, TimeLineEvent r102) {
            this.f249311c = r100;
            this.f249309a = r101;
            this.f249310b = r102;
        }
    }

    public abstract Context getContext(o r100);

    public abstract String h();

    public abstract void j(o r100);

    public abstract void k(String r100);

    static {
        f249296m = PatternProtector.compile("^[0-9a-zA-Z.]+$");
    }

    public View g() {
        return this.f249303g.a();
    }

    public void p() {
        this.f249305i.h();
        Iterator r100 = ((HashMap) this.f249307k).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((k) r100.next()).h();
        goto L4
    L6:
        this.f249300d.removeCallbacksAndMessages(null);
        this.f249302f = true;
    }

    public b() {
        this.f249300d = new Handler(Looper.getMainLooper());
        this.f249302f = false;
        this.f249307k = new HashMap();
        new a();
    }

    public final void d(c0 r100) {
        Iterator<u> r101 = this.f249298b.iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        r101.next().b(r100, 2);     // Catch: Throwable -> L8 AbstractMethodError -> L10
    L10:
        e = move-exception;
        e.getMessage();
    L8:
        th = move-exception;
        th.getMessage();
        goto L4
    }

    public final void i(c0 r110) {
        if (this.f249302f == true) goto L63;
        String r100 = r110.f249324i;
        if (r100 != null) goto L8;
    L11:
        String r101 = h();
    L12:
        TimeLineEvent.b r102 = new TimeLineEvent.b();
        if (r101 != null) goto L15;
        String r103 = "null";
    L16:
        r102.b("url", r103);
        r102.a("label_call_origin_url", r110.f249326k);
        if (r101 == null) goto L64;
        String r104 = r110.f249322g;
        if (TextUtils.equals(r104, this.f249301e) == false) goto L22;
    L25:
        k r105 = this.f249305i;
    L27:
        if (r105 != null) goto L29;
        r110.toString();
        TimeLineEvent.b r106 = new TimeLineEvent.b();
        r106.b("reason", "unknown_namespace");
        r106.a("label_abstract_bridge_reject", r110.f249326k);
        c(h(), r110.f249319d, 2, "unknown_namespace", r110.f249326k);
        d(r110);
        e(n0.a(new JsBridgeException(-4, "Namespace " + r110.f249322g + " unknown.")), r110);
        return;
    L29:
        CallContext r107 = new CallContext();
        r107.f249267b = r101;
        r107.f249266a = this.f249297a;
        r107.f249268c = r105;
        r107.f249269d = this.f249303g.a();
        r107.f249270e = true;
        r107.f249272g = this.f249304h;
        k.a r108 = r105.e(r110, r107);     // Catch: Exception -> L53
        if (r108 != null) goto L43;
        r110.toString();     // Catch: Exception -> L53
        TimeLineEvent.b r109 = new TimeLineEvent.b();     // Catch: Exception -> L53
        if (this.f249302f == false) goto L36;
        Object r111 = "not_registered_1_release";
    L37:
        r109.b("reason", r111);     // Catch: Exception -> L53
        r109.a("label_abstract_bridge_reject", r110.f249326k);     // Catch: Exception -> L53
        String r112 = h();     // Catch: Exception -> L53
        String r113 = r110.f249319d;     // Catch: Exception -> L53
        if (this.f249302f == false) goto L40;
        String r114 = "not_registered_1_release";
    L41:
        c(r112, r113, 2, r114, r110.f249326k);     // Catch: Exception -> L53
        d(r110);     // Catch: Exception -> L53
        e(n0.a(new JsBridgeException(-2, "Function " + r110.f249319d + " is not registered.")), r110);     // Catch: Exception -> L53
        return;
    L40:
        r114 = "not_registered_1";
        goto L41
    L36:
        r111 = "not_registered_1";
        goto L37
    L43:
        if (r108.f249383a == false) goto L48;
        JSONObject r115 = r108.f249385c;     // Catch: Exception -> L53
        if (r115 == null) goto L47;
        f(r115, r110);     // Catch: Exception -> L53
        goto L48
    L47:
        e(r108.f249384b, r110);     // Catch: Exception -> L53
    L48:
        String r116 = h();     // Catch: Exception -> L53
        String r117 = r110.f249319d;     // Catch: Exception -> L53
        List<TimeLineEvent> r118 = r110.f249326k;     // Catch: Exception -> L53
        Iterator<u> r119 = this.f249298b.iterator();     // Catch: Exception -> L53
    L50:
        if (r119.hasNext() == false) goto L65;
        r119.next().a(r116, r117, new o0(d0.f249339j, this.f249308l, r118));     // Catch: Exception -> L53
        goto L50
    L65:
        return;
    L53:
        e = move-exception;
        r110.toString();
        if (m.f249390a == false) goto L57;
        Log.getStackTraceString(e);
    L57:
        e(n0.a(e), r110);
        return;
    L22:
        if (TextUtils.isEmpty(r104) == true) goto L25;
        r105 = (k) ((HashMap) this.f249307k).get(r104);
        goto L27
    L64:
        return;
    L15:
        r103 = r101;
        goto L16
    L8:
        if (r100.isEmpty() == true) goto L11;
        r101 = r110.f249324i;
        goto L12
    }

    public void l(JSONObject r100) {
        k(r100.toString());
    }

    public void o(c0 r100) {
        if (this.f249302f == false) goto L5;
        return;
    L5:
        TimeLineEvent.b r101 = new TimeLineEvent.b();
        r101.c();
        r101.f249287a = "label_pre_call_origin_url";
        TimeLineEvent r102 = new TimeLineEvent(r101, null);
        this.f249300d.post(new RunnableC3555b(this, r100, r102));
    }

    public static c0 a(b r110, JSONObject r111) {
        if (r110.f249302f == true) goto L8;
        String r100 = r111.optString("__callback_id");
        String r101 = r111.optString("func");
        String r102 = r110.h();
        if (r102 != null) goto L17;
        r110.c(null, null, 3, "url_empty", null);
        goto L8
    L17:
        String r103 = JSONObjectProtectorUtils.getString(r111, "__msg_type");     // Catch: JSONException -> L11
        String r104 = JSONObjectProtectorUtils.getString(r111, "params");     // Catch: JSONException -> L11
        String r105 = JSONObjectProtectorUtils.getString(r111, "JSSDK");     // Catch: JSONException -> L11
        String r106 = r111.optString("namespace");     // Catch: JSONException -> L11
        String r107 = r111.optString("__iframe_url");     // Catch: JSONException -> L11
        Boolean r112 = Boolean.valueOf(r111.optBoolean("shouldHook", false));     // Catch: JSONException -> L11
        c0.a r108 = new c0.a();     // Catch: JSONException -> L11
        r108.f249327a = r105;     // Catch: JSONException -> L11
        r108.f249328b = r103;     // Catch: JSONException -> L11
        r108.f249329c = r101;     // Catch: JSONException -> L11
        r108.f249330d = r104;     // Catch: JSONException -> L11
        r108.f249331e = r100;     // Catch: JSONException -> L11
        r108.f249332f = r106;     // Catch: JSONException -> L11
        r108.f249333g = r107;     // Catch: JSONException -> L11
        r108.f249335i = r112;     // Catch: JSONException -> L11
        return new c0(r108);
    L11:
        e = move-exception;
        if (m.f249390a == false) goto L15;
        Log.getStackTraceString(e);
    L15:
        r110.c(r102, r101, 3, "params_invalid", null);
        return new c0(r100);
    L8:
        return null;
    }

    public static void b(b r100, c0 r101) {
        r100.getClass();
        s r102 = d0.f249338i.a();
        if (r102 == null) goto L7;
        r100.f249303g.a();
        r100.h();
        if (r102.shouldIntercept() == false) goto L7;
        r100.f249303g.a();
        r100.h();
        r102.intercept();
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r101.f249322g) == true) goto L16;
        v r103 = r100.f249306j;
        if (r103 == null) goto L17;
        r103.a(r101.f249322g, r101.f249319d);
        return;
    L17:
        return;
    L16:
        return;
    L7:
        r100.i(r101);
        goto L8
    }

    public final void e(String r100, c0 r101) {
        if (this.f249302f == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101.f249321f) == true) goto L8;
        Boolean r102 = r101.f249325j;
        if (r102 != null) goto L12;
    L15:
        new TimeLineEvent.b().a("label_pre_callback_origin_url", r101.f249326k);
        if (r100.startsWith("{") == true) goto L18;
    L19:
        IllegalArgumentException r103 = new IllegalArgumentException("Illegal callback data: ".concat(r100));
        if (m.f249390a == false) goto L22;
        throw r103;
    L22:
        if (f249296m.matcher(r101.f249321f).matches() == false) goto L36;
        d0.d r104 = d0.f249340k;
        if (r104.a() == null) goto L28;
        d0.e r105 = r104.a();
        SwitchConfigEnum r106 = SwitchConfigEnum.XSS_CALLBACK_ID_SWITCH;
        if (r105.f() == true) goto L36;
    L28:
        String r107 = "{\"__msg_type\":\"callback\",\"__callback_id\":\"" + r101.f249321f + "\",\"__params\":" + r100 + com.alipay.sdk.m.u.i.f25855d;
    L33:
        m(r107, r101);
        new TimeLineEvent.b().a("label_post_callback_origin_url", r101.f249326k);
        return;
    L36:
        JSONObject r108 = new JSONObject(r100);     // Catch: Exception -> L31
    L32:
        b0 r109 = new b0();
        r109.a("__msg_type", "callback");
        r109.a("__callback_id", r101.f249321f);
        r109.a("__params", r108);
        r107 = r109.b();
    L31:
        r108 = new JSONObject();
        goto L32
    L18:
        if (r100.endsWith(com.alipay.sdk.m.u.i.f25855d) == true) goto L22;
    L12:
        if (r102.booleanValue() == false) goto L15;
        r101.toString();
        return;
    }

    public final void f(JSONObject r100, c0 r101) {
        if (this.f249302f == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r101.f249321f) == false) goto L9;
        Objects.toString(r100);
        return;
    L9:
        Boolean r102 = r101.f249325j;
        if (r102 != null) goto L12;
    L15:
        new TimeLineEvent.b().a("label_pre_callback_origin_url", r101.f249326k);
        JSONObject r103 = new JSONObject();
        r103.put("__msg_type", "callback");     // Catch: JSONException -> L18
        r103.put("__callback_id", r101.f249321f);     // Catch: JSONException -> L18
        r103.put("__params", r100);     // Catch: JSONException -> L18
        n(r103, r101);     // Catch: JSONException -> L18
        new TimeLineEvent.b().a("label_post_callback_origin_url", r101.f249326k);     // Catch: JSONException -> L18
        return;
    L18:
        e(r100.toString(), r101);
        return;
    L12:
        if (r102.booleanValue() == false) goto L15;
        r101.toString();
    }

    public void m(String r100, c0 r101) {
        k(r100);
    }

    public void n(JSONObject r100, c0 r101) {
        m(r100.toString(), r101);
    }

    public final <T> void q(String r100, T r101) {
        if (this.f249302f == false) goto L6;
        return;
    L6:
        if ((r101 instanceof JSONObject) == false) goto L8;
    L9:
        JSONObject r102 = new JSONObject();
        r102.put("__msg_type", "event");     // Catch: JSONException -> L12
        r102.put("__event_id", r100);     // Catch: JSONException -> L12
        r102.put("__params", r101);     // Catch: JSONException -> L12
        l(r102);     // Catch: JSONException -> L12
        return;
    L13:
        String r103 = this.f249299c.b(r101);
        d0.d r104 = d0.f249340k;
        if (r104.a() == null) goto L21;
        d0.e r105 = r104.a();
        SwitchConfigEnum r106 = SwitchConfigEnum.XSS_CALLBACK_ID_SWITCH;
        if (r105.f() == false) goto L21;
        JSONObject r107 = new JSONObject(r103);     // Catch: Exception -> L19
    L20:
        b0 r108 = new b0();
        r108.a("__msg_type", "event");
        r108.a("__event_id", r100);
        r108.a("__params", r107);
        String r109 = r108.b();
    L22:
        k(r109);
        return;
    L19:
        r107 = new JSONObject();
    L21:
        r109 = "{\"__msg_type\":\"event\",\"__event_id\":\"" + r100 + "\",\"__params\":" + r103 + com.alipay.sdk.m.u.i.f25855d;
        goto L22
    L8:
        if ((r101 instanceof JSONArray) == false) goto L13;
        goto L9
    }

    public final void c(String r100, String r110, int r111, String r112, List<TimeLineEvent> r113) {
        Iterator<u> r101 = this.f249298b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().c(r100, r110, r111, r112, new o0(d0.f249339j, this.f249308l, r113));
        goto L4
    }
}
