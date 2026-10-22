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
import org.xmlpull.v1.XmlPullParser;
import xs3.a;
import xu3.g;
import y8a.b;
import y8a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static volatile Context f = null;
    public static volatile c g = null;
    public static b h = null;
    public static y8a.c i = null;
    public static d j = null;
    public static volatile boolean k = false;
    public static volatile String l = "";
    public static String m;
    public final Vector a;
    public final List<a9a.b> b;
    public final ExecutorService c;
    public volatile HashMap<String, String> d;
    public long e;

    public static c b() {
        if (g != null) goto L19;
        monitor-enter(c.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (g == null) goto L9;
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L15
        goto L19
    L9:
        if (k == false) goto L12;
        g = new c();     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("call CloudMessageManager.init() first");     // Catch: Throwable -> L15
    L19:
        return g;
    }

    public final void a() {
        m = a.c;
        long r5 = System.currentTimeMillis();
        if ((r5 - this.e) >= 120000) goto L6;
        ps3.b.a(new String[]{"fetchCommandImmediately too fast. just ignore for this time."});
        return;
    L6:
        this.e = r5;
        String r4 = x.a("https://" + m + "/monitor/collect/c/cloudcontrol/get", com.bytedance.apm.d.g());     // Catch: Exception -> L60
        HashMap r6 = new HashMap();     // Catch: Exception -> L60
        r6.put("Content-Type", "application/json");     // Catch: Exception -> L60
        r6.put("Version-Code", "1");     // Catch: Exception -> L60
        r6.put("Accept", "application/json");     // Catch: Exception -> L60
        ff7.b r1 = com.bytedance.apm.d.a(r4, g.a(new JSONObject().toString()), r6);     // Catch: Exception -> L60
        int r7 = 0;
        if (com.bytedance.apm.d.j() == false) goto L10;
        ps3.b.a(new String[]{"fetchCommandImmediately: url=" + r4});     // Catch: Exception -> L60
    L10:
        if (r1 != null) goto L14;
        ps3.b.a(new String[]{"fetchCommandImmediately: res null"});     // Catch: Exception -> L60
        return;
    L14:
        if (r1.a != 200) goto L74;
        JSONObject r3 = new JSONObject(new String(r1.c));     // Catch: Exception -> L60
        if (com.bytedance.apm.d.j() == false) goto L18;
        ps3.b.a(new String[]{"fetchCommandImmediately: resultMsg=" + r3.toString()});     // Catch: Exception -> L60
    L18:
        Map r2 = r1.b;     // Catch: Exception -> L60
        if (r2 != null) goto L21;
    L32:
        String r8 = null;
    L33:
        String r0 = r3.optString("data");     // Catch: Exception -> L60
        if (r0.isEmpty() == true) goto L46;
        if (TextUtils.isEmpty(r8) == true) goto L44;
        byte[] r9 = r0.getBytes();     // Catch: Exception -> L60
        String r10 = XmlPullParser.NO_NAMESPACE;
        byte[] r11 = Base64.decode(r9, 0);     // Catch: Exception -> L64
        if (TextUtils.isEmpty(r8) == true) goto L43;
        com.bytedance.apm.util.c.a = r8;     // Catch: Exception -> L60
        r10 = com.bytedance.apm.util.c.b(r8, r11);     // Catch: Exception -> L60
    L43:
        r3 = new JSONObject(r10);     // Catch: Exception -> L60
        goto L46
    L44:
        r3 = new JSONObject(new String(r0.getBytes()));     // Catch: Exception -> L60
    L46:
        if (com.bytedance.apm.d.j() == false) goto L49;
        ps3.b.a(new String[]{"fetchCommandImmediately resultMsg=" + r3});     // Catch: Exception -> L60
    L49:
        if (j.c(r3) == false) goto L51;
        return;
    L51:
        JSONObject r12 = r3.optJSONObject("configs");     // Catch: Exception -> L60
        if (j.c(r12) == false) goto L54;
        return;
    L54:
        JSONArray r13 = r12.optJSONArray("cloud_commands");     // Catch: Exception -> L60
        if (r13 != null) goto L57;
        return;
    L57:
        if (r7 >= r13.length()) goto L76;
        this.c.execute(new a(this, r13.optString(r7)));     // Catch: Exception -> L60
        r7 = r7 + 1;
        goto L57
    L76:
        return;
    L21:
        if (r2.isEmpty() == true) goto L32;
        r8 = (String) r2.get("ran");     // Catch: Exception -> L60
        if (TextUtils.isEmpty(r8) == false) goto L33;
        Iterator r14 = r2.entrySet().iterator();     // Catch: Throwable -> L63
    L27:
        if (r14.hasNext() == false) goto L33;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L63
        if ("ran".equalsIgnoreCase((String) r15.getKey()) == false) goto L27;
        r8 = (String) r15.getValue();     // Catch: Throwable -> L63
        goto L33
    L74:
        return;
    L60:
        e = move-exception;
        ps3.b.a(new String[]{"fetchCommandImmediately error."});
        Log.getStackTraceString(e);
    }

    public c() {
        this.d = new HashMap();
        this.a = new Vector(10);
        ExecutorService r0 = (ExecutorService) AsyncTask.THREAD_POOL_EXECUTOR;
        this.c = r0;
        ArrayList r1 = new ArrayList(20);
        r1.add(new f());
        r1.add(new b9a.c());
        r1.add(new q());
        r1.add(new b9a.j());
        r1.add(new o());
        r1.add(new r());
        r1.add(new b9a.d());
        r1.add(new p());
        r1.add(new m());
        r1.add(new h());
        r1.add(new b9a.b());
        r1.add(new b9a.a());
        r1.add(new l());
        r1.add(new n());
        r1.add(new b9a.g());
        r1.add(new i());
        r1.add(new e());
        r1.add(new k());
        this.b = Collections.unmodifiableList(r1);
        b r2 = h;
        if (r2 == null) goto L5;
        c(r2);
        h = null;
    L5:
        y8a.c r3 = i;
        if (r3 == null) goto L8;
        d(r3);
        i = null;
    L8:
        d r4 = j;
        if (r4 == null) goto L11;
        e(r4);
        j = null;
    L11:
        r0.execute(new b());
        StringBuilder r5 = new StringBuilder();     // Catch: Exception -> L17
        PolarisFileWrapper r6 = new PolarisFileWrapper(f.getExternalFilesDir(null) + "/monitor");     // Catch: Exception -> L17
        if (r6.exists() == true) goto L15;
        r6.mkdir();     // Catch: Exception -> L17
    L15:
        r5.append(r6.getAbsolutePath());     // Catch: Exception -> L17
        r5.append("/dump.hprof");     // Catch: Exception -> L17
        l = r5.toString();     // Catch: Exception -> L17
        return;
    }

    public Context getContext() {
        return f;
    }

    public final void c(b r4) {
        if (r4 == null) goto L13;
        Iterator<a9a.b> r0 = this.b.iterator();
    L5:
        if (r0.hasNext() == false) goto L14;
        b9a.b r1 = (a9a.b) r0.next();
        if ((r1 instanceof b9a.b) == false) goto L5;
        r1.b = r4;
        return;
    L14:
        return;
    }

    public final void d(y8a.c r4) {
        if (r4 == null) goto L13;
        Iterator<a9a.b> r0 = this.b.iterator();
    L5:
        if (r0.hasNext() == false) goto L14;
        h r1 = (a9a.b) r0.next();
        if ((r1 instanceof h) == false) goto L5;
        r1.b = r4;
        return;
    L14:
        return;
    }

    public final void e(d r4) {
        if (r4 == null) goto L13;
        Iterator<a9a.b> r0 = this.b.iterator();
    L5:
        if (r0.hasNext() == false) goto L14;
        r r1 = (a9a.b) r0.next();
        if ((r1 instanceof r) == false) goto L5;
        r1.b = r4;
        return;
    L14:
        return;
    }
}
