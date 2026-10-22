package com.huawei.hms.push;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class o {
    private String A;
    private int B;
    private String C;
    private String D;
    private String E;
    private String F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f277626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f277629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f277630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f277631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f277632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f277633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f277634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f277635k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f277636l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f277637m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f277638n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f277639o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f277640p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f277641q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f277642r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f277643s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f277644t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f277645u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f277646v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f277647w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f277648x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f277649y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f277650z;

    private JSONObject q() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("style", this.f277644t);
        r100.put("bigTitle", this.f277645u);
        r100.put("bigContent", this.f277646v);
        r100.put("bigPic", this.f277647w);
        return r100;
    }

    private JSONObject u() throws JSONException {
        JSONObject r100 = new JSONObject();
        r100.put("autoClear", this.f277626b);
        r100.put("url", this.f277638n);
        r100.put("rpl", this.f277639o);
        r100.put("rpt", this.f277640p);
        r100.put("rpct", this.f277641q);
        r100.put("appPackageName", this.f277636l);
        r100.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f277637m);
        r100.put(RemoteMessageConst.Notification.INTENT_URI, this.f277627c);
        return r100;
    }

    public String o() {
        HMSLog.d("PushSelfShowLog", "msgId =" + this.f277629e);
        return this.f277629e;
    }

    public byte[] x() {
        return this.f277643s.getBytes(m.f277621a);
    }

    public boolean y() {
    L15:
        HMSLog.d("PushSelfShowLog", "parse message exception.");
        return false;
    L12:
        e = move-exception;
        HMSLog.d("PushSelfShowLog", e.toString());
        return false;
    L4:
        if (TextUtils.isEmpty(this.f277642r) == false) goto L7;
        HMSLog.d("PushSelfShowLog", "msg is null");     // Catch: Exception -> L12 JSONException -> L15
        return false;
    L7:
        JSONObject r100 = new JSONObject(this.f277642r);     // Catch: Exception -> L12 JSONException -> L15
        g(r100);     // Catch: Exception -> L12 JSONException -> L15
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r100, RemoteMessageConst.MessageBody.MSG_CONTENT);     // Catch: Exception -> L12 JSONException -> L15
        if (e(r101) == true) goto L10;
        return false;
    L10:
        this.f277630f = r101.optString("dispPkgName");     // Catch: Exception -> L12 JSONException -> L15
        c(r101);     // Catch: Exception -> L12 JSONException -> L15
        this.B = r101.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);     // Catch: Exception -> L12 JSONException -> L15
        this.C = r101.optString("data");     // Catch: Exception -> L12 JSONException -> L15
        this.F = r101.optString(RemoteMessageConst.ANALYTIC_INFO);     // Catch: Exception -> L12 JSONException -> L15
        return i(r101);
    }

    public byte[] n() {
        return a(a(b(u()), q())).toString().getBytes(m.f277621a);
    L4:
        e = move-exception;
        HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", e);
        return new byte[0];
    }

    public String a() {
        return this.f277637m;
    }

    public String b() {
        return this.F;
    }

    public String c() {
        return this.f277636l;
    }

    public int d() {
        return this.f277648x;
    }

    public int e() {
        return this.f277626b;
    }

    public String f() {
        return this.f277646v;
    }

    public String g() {
        return this.f277645u;
    }

    public String h() {
        return this.f277631g;
    }

    public String i() {
        return this.f277632h;
    }

    public String j() {
        return this.f277630f;
    }

    public String k() {
        return this.f277625a;
    }

    public String l() {
        return this.E;
    }

    public String m() {
        return this.f277627c;
    }

    public String p() {
        return this.A;
    }

    public int r() {
        return this.B;
    }

    public String s() {
        return this.f277635k;
    }

    public String t() {
        return this.f277634j;
    }

    public int v() {
        return this.f277644t;
    }

    public String w() {
        return this.D;
    }

    private JSONObject a(JSONObject r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        r101.put(RemoteMessageConst.MessageBody.MSG_CONTENT, r100);
        r101.put("group", this.f277625a);
        r101.put("tag", this.A);
        r101.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.f277648x);
        r101.put(RemoteMessageConst.Notification.VISIBILITY, this.f277649y);
        r101.put(RemoteMessageConst.Notification.WHEN, this.f277650z);
        return r101;
    }

    private JSONObject b(JSONObject r100) throws JSONException {
        JSONObject r101 = new JSONObject();
        r101.put("cmd", this.f277631g);
        r101.put("content", this.f277632h);
        r101.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f277633i);
        r101.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.f277634j);
        r101.put("notifySummary", this.f277635k);
        r101.put("param", r100);
        return r101;
    }

    private void c(JSONObject r100) throws JSONException {
        if (r100.has("ap") == false) goto L15;
        String r101 = JSONObjectProtectorUtils.getString(r100, "ap");
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
        if (TextUtils.isEmpty(r101) == false) goto L7;
    L12:
        this.f277628d = r101.substring(0, 48);
        return;
    L7:
        if (r101.length() >= 48) goto L12;
        int r104 = 48 - r101.length();
    L9:
        if (r103 >= r104) goto L11;
        r102.append("0");
        r103 = r103 + 1;
        goto L9
    L11:
        r102.append(r101);
        this.f277628d = r102.toString();
        return;
    }

    private boolean d(JSONObject r100) throws JSONException {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.has(RemoteMessageConst.Notification.CLICK_ACTION) == false) goto L9;
        this.f277637m = JSONObjectProtectorUtils.getString(r100, RemoteMessageConst.Notification.CLICK_ACTION);
    L9:
        if (r100.has(RemoteMessageConst.Notification.INTENT_URI) == false) goto L12;
        this.f277627c = JSONObjectProtectorUtils.getString(r100, RemoteMessageConst.Notification.INTENT_URI);
    L12:
        if (r100.has("appPackageName") == false) goto L15;
        this.f277636l = JSONObjectProtectorUtils.getString(r100, "appPackageName");
        return true;
    L15:
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    private boolean e(JSONObject r100) throws JSONException {
        if (r100.has(RemoteMessageConst.MSGID) == false) goto L12;
        Object r101 = r100.get(RemoteMessageConst.MSGID);
        if ((r101 instanceof String) == false) goto L8;
        this.f277629e = (String) r101;
        return true;
    L8:
        if ((r101 instanceof Integer) == false) goto L15;
        this.f277629e = String.valueOf(((Integer) r101).intValue());
        return true;
    L15:
        return true;
    L12:
        HMSLog.i("PushSelfShowLog", "msgId == null");
        return false;
    }

    private boolean f(JSONObject r100) {
        HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r100, RemoteMessageConst.MessageBody.NOTIFY_DETAIL);     // Catch: JSONException -> L9
        if (r101.has("style") == false) goto L6;
        this.f277644t = JSONObjectProtectorUtils.getInt(r101, "style");     // Catch: JSONException -> L9
    L6:
        this.f277645u = r101.optString("bigTitle");     // Catch: JSONException -> L9
        this.f277646v = r101.optString("bigContent");     // Catch: JSONException -> L9
        this.E = r101.optString("icon");     // Catch: JSONException -> L9
        return true;
    L9:
        e = move-exception;
        HMSLog.i("PushSelfShowLog", e.toString());
        return false;
    }

    private void g(JSONObject r100) {
        this.f277625a = r100.optString("group");
        HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f277625a);
        this.f277648x = r100.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.d("PushSelfShowLog", "autoCancel: " + this.f277648x);
        this.f277649y = r100.optInt(RemoteMessageConst.Notification.VISIBILITY, 0);
        this.f277650z = r100.optString(RemoteMessageConst.Notification.WHEN);
        this.A = r100.optString("tag");
    }

    private boolean h(JSONObject r100) {
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r100, "param");     // Catch: Exception -> L21
        if (r101.has("autoClear") == false) goto L6;
        this.f277626b = JSONObjectProtectorUtils.getInt(r101, "autoClear");     // Catch: Exception -> L21
    L8:
        if ("app".equals(this.f277631g) == false) goto L10;
    L18:
        d(r101);     // Catch: Exception -> L21
        return true;
    L10:
        if ("cosa".equals(this.f277631g) == true) goto L18;
        if ("url".equals(this.f277631g) == false) goto L16;
        k(r101);     // Catch: Exception -> L21
        return true;
    L16:
        if ("rp".equals(this.f277631g) == false) goto L26;
        j(r101);     // Catch: Exception -> L21
        return true;
    L26:
        return true;
    L6:
        this.f277626b = 0;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        HMSLog.e("PushSelfShowLog", "ParseParam error ", e);
        return false;
    }

    private boolean i(JSONObject r100) throws JSONException {
        if (r100.has(RemoteMessageConst.MessageBody.PS_CONTENT) == false) goto L13;
        JSONObject r101 = JSONObjectProtectorUtils.getJSONObject(r100, RemoteMessageConst.MessageBody.PS_CONTENT);
        this.f277631g = JSONObjectProtectorUtils.getString(r101, "cmd");
        this.f277632h = r101.optString("content");
        this.f277633i = r101.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
        this.f277634j = r101.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
        this.f277635k = r101.optString("notifySummary");
        this.D = r101.optString(RemoteMessageConst.Notification.TICKER);
        if (r101.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) == false) goto L10;
        if (f(r101) == true) goto L10;
        return false;
    L10:
        if (r101.has("param") == false) goto L13;
        return h(r101);
    L13:
        return false;
    }

    private boolean j(JSONObject r100) throws JSONException {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.has("appPackageName") == false) goto L9;
        this.f277636l = JSONObjectProtectorUtils.getString(r100, "appPackageName");
    L9:
        if (r100.has("rpt") == true) goto L11;
    L17:
        HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
        return false;
    L11:
        if (r100.has("rpl") == false) goto L17;
        this.f277639o = JSONObjectProtectorUtils.getString(r100, "rpl");
        this.f277640p = JSONObjectProtectorUtils.getString(r100, "rpt");
        if (r100.has("rpct") == false) goto L19;
        this.f277641q = JSONObjectProtectorUtils.getString(r100, "rpct");
        return true;
    L19:
        return true;
    }

    private boolean k(JSONObject r100) throws JSONException {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.has("url") == false) goto L19;
        this.f277638n = JSONObjectProtectorUtils.getString(r100, "url");
        if (r100.has("appPackageName") == false) goto L11;
        this.f277636l = JSONObjectProtectorUtils.getString(r100, "appPackageName");
    L11:
        if (r100.has("rpt") == true) goto L13;
        return true;
    L13:
        if (r100.has("rpl") == false) goto L22;
        this.f277639o = JSONObjectProtectorUtils.getString(r100, "rpl");
        this.f277640p = JSONObjectProtectorUtils.getString(r100, "rpt");
        if (r100.has("rpct") == false) goto L23;
        this.f277641q = JSONObjectProtectorUtils.getString(r100, "rpct");
        return true;
    L23:
        return true;
    L22:
        return true;
    L19:
        HMSLog.d("PushSelfShowLog", "url is null");
        return false;
    }

    public void a(int r100) {
        this.B = r100;
    }

    public o(byte[] r100, byte[] r101) {
        this.f277625a = "";
        this.f277629e = "";
        this.f277630f = "";
        this.f277631g = "";
        this.f277632h = "";
        this.f277633i = "";
        this.f277634j = "";
        this.f277635k = "";
        this.f277641q = "";
        this.f277644t = k.f277615a.ordinal();
        this.f277645u = "";
        this.f277646v = "";
        this.f277647w = "";
        this.f277648x = 0;
        this.f277649y = 0;
        this.A = "";
        this.C = "";
        this.E = "";
        this.F = "";
        Charset r102 = m.f277621a;
        this.f277642r = new String(r100, r102);
        this.f277643s = new String(r101, r102);
    }

    private JSONObject a(JSONObject r100, JSONObject r101) throws JSONException {
        JSONObject r102 = new JSONObject();
        r102.put("dispPkgName", this.f277630f);
        r102.put(RemoteMessageConst.MSGID, this.f277629e);
        r102.put("ap", this.f277628d);
        r102.put(RemoteMessageConst.Notification.NOTIFY_ID, this.B);
        r102.put(RemoteMessageConst.MessageBody.PS_CONTENT, r100);
        r102.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, r101);
        r102.put(RemoteMessageConst.Notification.TICKER, this.D);
        r102.put("data", this.C);
        return r102;
    }
}
