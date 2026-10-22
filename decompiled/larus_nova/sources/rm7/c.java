package rm7;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.tokenunion.model.TokenUnionConfig$ACT_COMMON_PARSE_TYPE;
import com.google.gson.Gson;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rk7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mm7.c f538576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public mm7.a f538577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f538578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f538579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f538580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f538581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Set<String> f538582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile String f538583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Set<String> f538584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile String f538585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TokenUnionConfig$ACT_COMMON_PARSE_TYPE f538586k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f538587a = null;

        static {
            f538587a = new c();
        }
    }

    public static void f() {
        j r100 = j.a.f538610a;
        r100.getClass();
        um7.e.b("handleCommonPramsFirstSuccess() on call; mIsFinishParams = " + r100.f538607c);
        if (r100.f538607c == true) goto L11;
        r100.f538607c = true;
        Iterator<mm7.b> r101 = r100.f538609e.iterator();
    L7:
        if (r101.hasNext() == false) goto L17;
        mm7.b r102 = r101.next();
        if (r102 == null) goto L7;
        um7.e.b("handleTokenSuccess() onTokenSuccess回调 listener.name = ".concat(r102.getClass().getName()));
        r102.b();
        goto L7
    L17:
        return;
    }

    public static void i() {
        j r100 = j.a.f538610a;
        r100.getClass();
        um7.e.b("handleUpdateCommonPrams() on call; mIsUpdateParams = " + r100.f538608d);
        r100.f538608d = true;
        Iterator<mm7.b> r101 = r100.f538609e.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        mm7.b r102 = r101.next();
        if (r102 == null) goto L4;
        um7.e.b("handleUpdateCommonPrams() onUpdateCommonPrams回调 listener.name = ".concat(r102.getClass().getName()));
        r102.c();
        goto L4
    }

    public final List<String> d() {
        if (this.f538576a == null) goto L10;
        Application r100 = m.f538347a;
        m.n();
        ik7.c r101 = m.f538353g;
        if (r101 == null) goto L11;
        bn7.c r102 = ((dn7.c) r101).f469366a;
        if (r102 != null) goto L9;
        return null;
    L9:
        return r102.c();
    L11:
        return null;
    L10:
        return null;
    }

    public c() {
        this.f538581f = false;
        this.f538582g = new HashSet();
        this.f538584i = new HashSet();
        this.f538586k = TokenUnionConfig$ACT_COMMON_PARSE_TYPE.DEFAULT;
    }

    public static Set c(String r100) {
        HashSet r101 = new HashSet();
        if (TextUtils.isEmpty(r100) == false) goto L18;
        return r101;
    L18:
        JSONArray r102 = new JSONArray(r100);     // Catch: JSONException -> L15
        if (r102.length() > 0) goto L8;
        return r101;
    L8:
        int r103 = 0;
    L10:
        if (r103 >= r102.length()) goto L17;
        String r104 = r102.get(r103).toString();     // Catch: JSONException -> L15
        if (TextUtils.isEmpty(r104) == true) goto L14;
        r101.add(r104);     // Catch: JSONException -> L15
    L14:
        r103 = r103 + 1;
    L17:
        return r101;
    L15:
        e = move-exception;
        um7.e.b(e.getLocalizedMessage());
        goto L17
    }

    public static void h(boolean r100) {
        j r101 = j.a.f538610a;
        monitor-enter(r101);
        um7.e.b("handleTokenSuccess() on call; mIsFinishToken = " + r101.f538605a + " isFirst = " + r100);     // Catch: Throwable -> L18
        if (r101.f538605a == false) goto L9;
        monitor-exit(r101);
        return;
    L9:
        r101.f538605a = true;     // Catch: Throwable -> L18
        r101.f538606b = r100;     // Catch: Throwable -> L18
        Iterator<mm7.b> r102 = r101.f538609e.iterator();     // Catch: Throwable -> L18
    L11:
        if (r102.hasNext() == false) goto L16;
        mm7.b r103 = r102.next();     // Catch: Throwable -> L18
        if (r103 == null) goto L11;
        um7.e.b("handleTokenSuccess() onTokenSuccess回调 listener.name = " + r103.getClass().getName());     // Catch: Throwable -> L18
        r103.onTokenSuccess(r100);     // Catch: Throwable -> L18
        goto L11
    L16:
        monitor-exit(r101);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public final void a(JSONObject r100) {
        this.f538585j = qm7.e.a().b("block_path_prefix_list");
        String r101 = um7.c.b(r100, true);
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L7:
        this.f538584i = c(this.f538585j);
        this.f538583h = qm7.e.a().b("path_prefix_list");
        String r102 = um7.c.b(r100, false);
        if (TextUtils.isEmpty(r102) == false) goto L10;
    L12:
        this.f538582g = c(this.f538583h);
        return;
    L10:
        if (r102.equals(this.f538583h) == true) goto L12;
        um7.e.b("init() 处理白名单 pendingAppSetting取到数据，覆盖sp，update");
        this.f538583h = r102;
        qm7.e.a().c("path_prefix_list", this.f538583h);
        goto L12
    L5:
        if (r101.equals(this.f538585j) == true) goto L7;
        um7.e.b("init() 处理block pendingAppSetting取到数据，覆盖sp，update");
        this.f538585j = r101;
        qm7.e.a().c("block_path_prefix_list", this.f538585j);
        goto L7
    }

    public final void b(Runnable r100) {
        if (this.f538576a == null) goto L6;
        Application r101 = m.f538347a;
        m.d(r100);
        return;
    }

    public final void g(String r100) {
        if (this.f538576a == null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.c.a r101 = new com.bytedance.ug.sdk.luckydog.api.log.c.a();
        r101.b("token", "initTokenUnion");
        Gson r102 = com.bytedance.ug.sdk.luckydog.api.log.c.f271581a;
        com.bytedance.ug.sdk.luckydog.api.log.c.b("TokenUnion", r100, null, r101);
        return;
    }

    public final synchronized void j(String r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (r100.equals(this.f538585j) == false) goto L13;
        um7.e.b("tryUpdateBlockPathPrefix() 数据没有发生变化，return");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        um7.e.b("tryUpdateBlockPathPrefix() 数据发生变化，进行更新; newStr = ".concat(r100));     // Catch: Throwable -> L16
        this.f538585j = r100;     // Catch: Throwable -> L16
        qm7.e.a().c("block_path_prefix_list", this.f538585j);     // Catch: Throwable -> L16
        this.f538584i = c(this.f538585j);     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final synchronized void k(JSONObject r100) {
        monitor-enter(this);
        if (r100 != null) goto L13;
        monitor-exit(this);
        return;
    L13:
        j(um7.c.b(r100, true));     // Catch: Throwable -> L10
        l(um7.c.b(r100, false));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void l(String r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (r100.equals(this.f538583h) == false) goto L13;
        um7.e.b("tryUpdatePathPrefix() 数据没有发生变化，return");     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L13:
        um7.e.b("tryUpdatePathPrefix() 数据发生变化，进行更新; newStr = ".concat(r100));     // Catch: Throwable -> L16
        this.f538583h = r100;     // Catch: Throwable -> L16
        qm7.e.a().c("path_prefix_list", this.f538583h);     // Catch: Throwable -> L16
        this.f538582g = c(this.f538583h);     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final void e(String r100, JSONObject r101) {
        if (this.f538576a == null) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.b.a(r100, r101);
        return;
    }
}
