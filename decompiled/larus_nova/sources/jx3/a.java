package jx3;

import android.content.ContentValues;
import android.database.Cursor;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Cloneable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final SimpleDateFormat f500755w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final C6490a f500756x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f500757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f500758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f500759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f500760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f500761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f500762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f500763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f500764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f500765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f500766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f500767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f500768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f500769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f500770n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f500771o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f500772p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f500773q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f500774r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f500775s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<String> f500776t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ow3.d.a f500777u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public JSONObject f500778v;

    /* JADX INFO: renamed from: jx3.a$a, reason: collision with other inner class name */
    public static class C6490a extends com.bytedance.applog.log.b<HashMap<String, a>> {
        public C6490a() {
        }

        @Override // com.bytedance.applog.log.b
        public final HashMap<String, a> a(Object[] r100) {
            HashMap<String, a> r101 = new HashMap();
            r101.put("page", new j());
            r101.put(EventVerify.TYPE_LAUNCH, new g());
            r101.put(EventVerify.TYPE_TERMINATE, new k());
            r101.put("pack", new i());
            a[] r102 = a.d();
            int r103 = 0;
        L4:
            if (r103 >= 3) goto L6;
            a r104 = r102[r103];
            r101.put(r104.j(), r104);
            r103 = r103 + 1;
            goto L4
        L6:
            return r101;
        }
    }

    public static a[] d() {
        return new a[]{new c(), new e(null, null, null, 0), new d(null, "", new JSONObject())};
    }

    public String f() {
        return null;
    }

    public abstract String h();

    public abstract String j();

    public abstract JSONObject r() throws JSONException;

    static {
        f500755w = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        f500756x = new C6490a();
    }

    public List<String> e() {
        return Arrays.asList(new String[]{DBDefinition.ID, "integer primary key autoincrement", "local_time_ms", "integer", "tea_event_index", "integer", "nt", "integer", "user_id", "integer", "uid", "integer", "session_id", "varchar", DyPayConstant.KEY_USER_UNIQUE_ID, "varchar", "ab_sdk_version", "varchar", "user_type", "integer", "user_is_login", "integer", "user_is_auth", "integer", "_app_id", "varchar", "priority", "integer", "forward", "integer", "_local_event_id", "varchar", "monitor_id", "integer", "event_stained", "integer"});
    }

    public String g() {
        return "sid:" + this.f500760d;
    }

    public final com.bytedance.applog.log.i i() {
        String r100 = this.f500769m;
        com.bytedance.applog.log.i r101 = (com.bytedance.applog.log.i) ((ConcurrentHashMap) com.bytedance.applog.log.c.f192456c).get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return n.w();
    }

    public final JSONObject o() {
        JSONObject r100 = new JSONObject();
        this.f500770n = f500755w.format(new Date(this.f500758b));     // Catch: Throwable -> L5
        return r();
    L5:
        th = move-exception;
        com.bytedance.applog.b r101 = com.bytedance.applog.a.a(this.f500769m);
        if (r101 == null) goto L12;
        r101.W.b(StatsCountKeys.PACK_ERROR_COUNT, 1);
        if ((th instanceof JSONException) == false) goto L11;
        r101.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
    L11:
        r101.W.h(j() + " to pack json failed", th, true);
    L12:
        i().r(4, this.f500776t, "toPackJson failed", th, new Object[0]);
        return r100;
    }

    public a() {
        this.f500766j = 0;
        this.f500767k = 0;
        this.f500768l = 0;
        this.f500771o = -1;
        this.f500772p = 0;
        this.f500773q = 0;
        this.f500774r = 0;
        this.f500775s = 0;
        m(0);
        long r100 = ex3.g.f474706a.incrementAndGet();
        this.f500773q = r100;
        this.f500774r = r100;
        this.f500776t = Collections.singletonList(j());
    }

    public a a() {
        a r100 = (a) super.clone();     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        long r101 = ex3.g.f474706a.incrementAndGet();     // Catch: Throwable -> L4
        r100.f500773q = r101;     // Catch: Throwable -> L4
        r100.f500774r = r101;     // Catch: Throwable -> L4
        return r100;
    L4:
        th = move-exception;
        i().r(4, this.f500776t, "Clone data failed", th, new Object[0]);
        return null;
    }

    public final String b() {
        List<String> r100 = e();
        if (r100 == null) goto L9;
        StringBuilder r101 = new StringBuilder(128);
        r101.append("create table if not exists ");
        r101.append(j());
        r101.append("(");
        int r102 = 0;
    L6:
        if (r102 >= r100.size()) goto L8;
        r101.append((String) ListProtector.get(r100, r102));
        r101.append(" ");
        r101.append((String) ListProtector.get(r100, r102 + 1));
        r101.append(",");
        r102 = r102 + 2;
        goto L6
    L8:
        r101.delete(r101.length() - 1, r101.length());
        r101.append(")");
        return r101.toString();
    L9:
        return null;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public long n() {
        String r100 = g();
        long r101 = 0;
        if (nx3.k.h(r100) == false) goto L5;
        r101 = 0 + ((long) r100.length());
    L5:
        String r102 = f();
        if (nx3.k.h(r102) == true) goto L8;
        return r101;
    L8:
        return r101 + ((long) r102.length());
    }

    public String toString() {
        String r100 = j();
        if (getClass().getSimpleName().equalsIgnoreCase(r100) == true) goto L5;
        r100 = r100 + ", " + getClass().getSimpleName();
    L5:
        String r101 = this.f500760d;
        String r102 = "-";
        if (r101 == null) goto L12;
        int r103 = r101.indexOf("-");
        if (r103 < 0) goto L10;
        r101 = r101.substring(0, r103);
    L10:
        r102 = r101;
    L12:
        return "{" + r100 + ", " + g() + ", " + r102 + ", " + this.f500758b + ", id=" + this.f500773q + com.alipay.sdk.m.u.i.f25855d;
    }

    public final void c(JSONObject r100) throws JSONException {
        com.bytedance.applog.b r101 = com.bytedance.applog.a.a(this.f500769m);
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L11;
    L12:
        r100.put("user_id", this.f500761e);
    L13:
        if (r102 == false) goto L15;
    L16:
        r100.put("uid", this.f500762f);
    L17:
        if (r102 == false) goto L19;
    L20:
        r100.put("user_type", this.f500766j);
    L21:
        if (r102 == false) goto L23;
    L24:
        r100.put("user_is_login", this.f500767k);
    L25:
        if (r102 == false) goto L27;
    L28:
        r100.put("user_is_auth", this.f500768l);
        return;
    L27:
        if (this.f500768l > 0) goto L28;
        return;
    L23:
        if (this.f500767k <= 0) goto L25;
    L19:
        if (this.f500766j <= 0) goto L21;
    L15:
        if (this.f500762f <= 0) goto L17;
    L11:
        if (this.f500761e <= 0) goto L13;
    L5:
        if (r101.f192441x == false) goto L7;
        r102 = true;
        goto L9
    }

    public void k(Cursor r100) {
        this.f500757a = r100.getLong(0);
        this.f500758b = r100.getLong(1);
        this.f500759c = r100.getLong(2);
        this.f500765i = r100.getInt(3);
        this.f500761e = r100.getLong(4);
        this.f500762f = r100.getLong(5);
        this.f500760d = r100.getString(6);
        this.f500763g = r100.getString(7);
        this.f500764h = r100.getString(8);
        this.f500766j = r100.getInt(9);
        this.f500767k = r100.getInt(10);
        this.f500768l = r100.getInt(11);
        this.f500769m = r100.getString(12);
        this.f500771o = r100.getInt(13);
        this.f500772p = r100.getInt(14);
        String r101 = r100.getString(15);
        if (nx3.k.h(r101) == true) goto L8;
    L5:
        this.f500774r = r100.getLong(16);
        this.f500775s = r100.getInt(17);
        return;
    L8:
        this.f500773q = CastLongProtector.parseLong(r101);     // Catch: Throwable -> L7
        goto L5
    }

    public a l(JSONObject r100) {
        this.f500758b = r100.optLong("local_time_ms", 0);
        this.f500757a = 0;
        this.f500759c = 0;
        this.f500765i = 0;
        this.f500761e = 0;
        this.f500762f = 0;
        this.f500760d = null;
        this.f500763g = null;
        this.f500764h = null;
        this.f500766j = 0;
        this.f500767k = 0;
        this.f500768l = 0;
        this.f500769m = r100.optString("_app_id");
        this.f500771o = r100.optInt("priority", -1);
        this.f500772p = r100.optInt("forward");
        this.f500773q = r100.optLong("_local_event_id", 0);
        this.f500774r = r100.optLong("monitor_id", 0);
        return this;
    }

    public final void m(long r100) {
        if (r100 != 0) goto L5;
        r100 = System.currentTimeMillis();
    L5:
        this.f500758b = r100;
    }

    public void p(ContentValues r100) {
        r100.put("local_time_ms", Long.valueOf(this.f500758b));
        r100.put("tea_event_index", Long.valueOf(this.f500759c));
        r100.put("nt", Integer.valueOf(this.f500765i));
        r100.put("user_id", Long.valueOf(this.f500761e));
        r100.put("uid", Long.valueOf(this.f500762f));
        r100.put("session_id", this.f500760d);
        r100.put(DyPayConstant.KEY_USER_UNIQUE_ID, this.f500763g);
        r100.put("ab_sdk_version", this.f500764h);
        r100.put("user_type", Integer.valueOf(this.f500766j));
        r100.put("user_is_login", Integer.valueOf(this.f500767k));
        r100.put("user_is_auth", Integer.valueOf(this.f500768l));
        r100.put("_app_id", this.f500769m);
        r100.put("priority", Integer.valueOf(this.f500771o));
        r100.put("forward", Integer.valueOf(this.f500772p));
        r100.put("_local_event_id", String.valueOf(this.f500773q));
        r100.put("monitor_id", Long.valueOf(this.f500774r));
        r100.put("event_stained", Integer.valueOf(this.f500775s));
    }

    public void q(JSONObject r100) throws JSONException {
        r100.put("local_time_ms", this.f500758b);
        r100.put("_app_id", this.f500769m);
        r100.put("priority", this.f500771o);
        r100.put("forward", this.f500772p);
        r100.put("_local_event_id", this.f500773q);
        r100.put("monitor_id", this.f500774r);
    }
}
