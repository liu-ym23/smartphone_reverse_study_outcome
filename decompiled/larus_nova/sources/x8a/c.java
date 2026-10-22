package x8a;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import b9a.e;
import b9a.f;
import b9a.h;
import b9a.i;
import b9a.k;
import b9a.l;
import b9a.m;
import b9a.n;
import b9a.o;
import b9a.p;
import b9a.q;
import b9a.r;
import com.bytedance.apm.util.j;
import com.bytedance.apm.util.x;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;
import xu3.g;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile Context f562935f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile c f562936g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static y8a.b f562937h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static y8a.c f562938i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static y8a.d f562939j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile boolean f562940k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile String f562941l = "";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f562942m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Vector f562943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a9a.b> f562944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f562945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile HashMap<String, String> f562946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f562947e;

    public static c b() {
        if (f562936g != null) goto L19;
        monitor-enter(c.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (f562936g == null) goto L9;
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L15
        goto L19
    L9:
        if (f562940k == false) goto L12;
        f562936g = new c();     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("call CloudMessageManager.init() first");     // Catch: Throwable -> L15
    L19:
        return f562936g;
    }

    public final void a() {
        f562942m = xs3.a.f564948c;
        long r100 = System.currentTimeMillis();
        if ((r100 - this.f562947e) >= 120000) goto L6;
        ps3.b.a(new String[]{"fetchCommandImmediately too fast. just ignore for this time."});
        return;
    L6:
        this.f562947e = r100;
        String r101 = x.a("https://" + f562942m + "/monitor/collect/c/cloudcontrol/get", com.bytedance.apm.d.g());     // Catch: Exception -> L60
        HashMap r102 = new HashMap();     // Catch: Exception -> L60
        r102.put("Content-Type", "application/json");     // Catch: Exception -> L60
        r102.put("Version-Code", "1");     // Catch: Exception -> L60
        r102.put("Accept", "application/json");     // Catch: Exception -> L60
        ff7.b r103 = com.bytedance.apm.d.a(r101, g.a(new JSONObject().toString()), r102);     // Catch: Exception -> L60
        int r104 = 0;
        if (com.bytedance.apm.d.j() == false) goto L10;
        ps3.b.a(new String[]{"fetchCommandImmediately: url=" + r101});     // Catch: Exception -> L60
    L10:
        if (r103 != null) goto L14;
        ps3.b.a(new String[]{"fetchCommandImmediately: res null"});     // Catch: Exception -> L60
        return;
    L14:
        if (r103.f476667a != 200) goto L74;
        JSONObject r105 = new JSONObject(new String(r103.f476669c));     // Catch: Exception -> L60
        if (com.bytedance.apm.d.j() == false) goto L18;
        ps3.b.a(new String[]{"fetchCommandImmediately: resultMsg=" + r105.toString()});     // Catch: Exception -> L60
    L18:
        Map<String, String> r106 = r103.f476668b;     // Catch: Exception -> L60
        if (r106 != null) goto L21;
    L32:
        String r107 = null;
    L33:
        String r108 = r105.optString("data");     // Catch: Exception -> L60
        if (r108.isEmpty() == true) goto L46;
        if (TextUtils.isEmpty(r107) == true) goto L44;
        String r109 = "";
        byte[] r110 = Base64.decode(r108.getBytes(), 0);     // Catch: Exception -> L64
        if (TextUtils.isEmpty(r107) == true) goto L43;
        com.bytedance.apm.util.c.f190643a = r107;     // Catch: Exception -> L60
        r109 = com.bytedance.apm.util.c.b(r107, r110);     // Catch: Exception -> L60
    L43:
        r105 = new JSONObject(r109);     // Catch: Exception -> L60
        goto L46
    L44:
        r105 = new JSONObject(new String(r108.getBytes()));     // Catch: Exception -> L60
    L46:
        if (com.bytedance.apm.d.j() == false) goto L49;
        ps3.b.a(new String[]{"fetchCommandImmediately resultMsg=" + r105});     // Catch: Exception -> L60
    L49:
        if (j.c(r105) == false) goto L51;
        return;
    L51:
        JSONObject r111 = r105.optJSONObject(FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);     // Catch: Exception -> L60
        if (j.c(r111) == false) goto L54;
        return;
    L54:
        JSONArray r112 = r111.optJSONArray("cloud_commands");     // Catch: Exception -> L60
        if (r112 != null) goto L57;
        return;
    L57:
        if (r104 >= r112.length()) goto L76;
        this.f562945c.execute(new a(this, r112.optString(r104)));     // Catch: Exception -> L60
        r104 = r104 + 1;
        goto L57
    L76:
        return;
    L21:
        if (r106.isEmpty() == true) goto L32;
        r107 = r106.get("ran");     // Catch: Exception -> L60
        if (TextUtils.isEmpty(r107) == false) goto L33;
        Iterator<Map.Entry<String, String>> r113 = r106.entrySet().iterator();     // Catch: Throwable -> L63
    L27:
        if (r113.hasNext() == false) goto L33;
        Map.Entry<String, String> r114 = r113.next();     // Catch: Throwable -> L63
        if ("ran".equalsIgnoreCase(r114.getKey()) == false) goto L27;
        r107 = r114.getValue();     // Catch: Throwable -> L63
        goto L33
    L74:
        return;
    L60:
        e = move-exception;
        ps3.b.a(new String[]{"fetchCommandImmediately error."});
        Log.getStackTraceString(e);
    }

    public c() {
        this.f562946d = new HashMap();
        this.f562943a = new Vector(10);
        ExecutorService r100 = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;
        this.f562945c = r100;
        ArrayList r101 = new ArrayList(20);
        r101.add(new f());
        r101.add(new b9a.c());
        r101.add(new q());
        r101.add(new b9a.j());
        r101.add(new o());
        r101.add(new r());
        r101.add(new b9a.d());
        r101.add(new p());
        r101.add(new m());
        r101.add(new h());
        r101.add(new b9a.b());
        r101.add(new b9a.a());
        r101.add(new l());
        r101.add(new n());
        r101.add(new b9a.g());
        r101.add(new i());
        r101.add(new e());
        r101.add(new k());
        this.f562944b = Collections.unmodifiableList(r101);
        y8a.b r102 = f562937h;
        if (r102 == null) goto L5;
        c(r102);
        f562937h = null;
    L5:
        y8a.c r103 = f562938i;
        if (r103 == null) goto L8;
        d(r103);
        f562938i = null;
    L8:
        y8a.d r104 = f562939j;
        if (r104 == null) goto L11;
        e(r104);
        f562939j = null;
    L11:
        r100.execute(new b());
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L17
        PolarisFileWrapper r106 = new PolarisFileWrapper(f562935f.getExternalFilesDir(null) + "/monitor");     // Catch: Exception -> L17
        if (r106.exists() == true) goto L15;
        r106.mkdir();     // Catch: Exception -> L17
    L15:
        r105.append(r106.getAbsolutePath());     // Catch: Exception -> L17
        r105.append("/dump.hprof");     // Catch: Exception -> L17
        f562941l = r105.toString();     // Catch: Exception -> L17
        return;
    }

    public Context getContext() {
        return f562935f;
    }

    public final void c(y8a.b r100) {
        if (r100 == null) goto L13;
        Iterator<a9a.b> r101 = this.f562944b.iterator();
    L5:
        if (r101.hasNext() == false) goto L14;
        a9a.b r102 = r101.next();
        if ((r102 instanceof b9a.b) == false) goto L5;
        ((b9a.b) r102).f18349b = r100;
        return;
    L14:
        return;
    }

    public final void d(y8a.c r100) {
        if (r100 == null) goto L13;
        Iterator<a9a.b> r101 = this.f562944b.iterator();
    L5:
        if (r101.hasNext() == false) goto L14;
        a9a.b r102 = r101.next();
        if ((r102 instanceof h) == false) goto L5;
        ((h) r102).f18359b = r100;
        return;
    L14:
        return;
    }

    public final void e(y8a.d r100) {
        if (r100 == null) goto L13;
        Iterator<a9a.b> r101 = this.f562944b.iterator();
    L5:
        if (r101.hasNext() == false) goto L14;
        a9a.b r102 = r101.next();
        if ((r102 instanceof r) == false) goto L5;
        ((r) r102).f18369b = r100;
        return;
    L14:
        return;
    }
}
