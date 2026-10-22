package d25;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.offline.base.OfflineResultModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Flowable;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final Map<String, Set<String>> a = null;
    public static final Map<String, JSONObject> b = null;
    public static final List<String> c = null;
    public static String d;
    public static String e;
    public static int f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static BearUrl k;
    public static volatile boolean l;
    public static volatile boolean m;
    public static String n;
    public static String o;

    static {
        a = new HashMap();
        b = new HashMap();
        c = new CopyOnWriteArrayList();
        sbb.e r0 = sbb.e.e;
        f = r0.b;
        g = r0.getType();
        h = r0.getType();
        k = null;
        r0.getClass();
        r0.getType();
        l = false;
        m = false;
    }

    public static String d() {
        BearUrl r0 = k;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.r;
    }

    public static void i() {
        tt5.a.b("OfflineUtils", "resetPreloadAnalyticData");
        l = false;
        m = false;
        n = null;
        o = null;
    }

    public static void a(Closeable r2) {
        if (r2 == null) goto L10;
        r2.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("OfflineUtils", e, false);
        return;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0061: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:16777313), block:B:27:0x0061 */
    public static String b(InputStream r6) {
        StringBuffer r0 = new StringBuffer();
        Closeable r2 = null;
        if (r6 != null) goto L33;
    L20:
        tt5.a.d("OfflineUtils", "convertString()... steam is invalid");     // Catch: Throwable -> L16 IOException -> L18
        String r1 = r0.toString();     // Catch: Throwable -> L16 IOException -> L18
        a(r6);
        return r1;
    L33:
    L18:
        e = move-exception;
        BufferedReader r3 = null;
        IOException e2 = e;
    L24:
        tt5.a.f("OfflineUtils", e2, false);     // Catch: Throwable -> L12
    L25:
        a(r6);
        a(r3);
        return r0.toString();
    L16:
        th = th;
    L28:
        a(r6);
        a(r2);
        throw th;
    L5:
        if (r6.available() <= 0) goto L20;
        r3 = new BufferedReader(new InputStreamReader(r6));     // Catch: Throwable -> L16 IOException -> L18
    L31:
        String r4 = r3.readLine();     // Catch: Throwable -> L12 IOException -> L14
        if (r4 == null) goto L25;
        r0.append(r4 + System.getProperty("line.separator"));     // Catch: Throwable -> L12 IOException -> L14
    L14:
        e2 = e;
    L12:
        th = th;
        r2 = r3;
        goto L28
    }

    public static String c(String r1) {
        String r2 = UriProtector.parse(r1).getPath();
        if (r2 != null) goto L5;
    L23:
        return "text/html";
    L5:
        if (r2.endsWith(".css") == false) goto L8;
        return "text/css";
    L8:
        if (r2.endsWith(".js") == false) goto L11;
        return "application/x-javascript";
    L11:
        if (r2.endsWith(".jpg") == false) goto L13;
    L22:
        return "image/*";
    L13:
        if (r2.endsWith(".gif") == true) goto L22;
        if (r2.endsWith(".png") == true) goto L22;
        if (r2.endsWith(".jpeg") == true) goto L22;
        if (r2.endsWith(".webp") == true) goto L22;
        if (r2.endsWith(".bmp") == false) goto L23;
        goto L22
    }

    public static org.json.JSONObject e(String r2) {
        return new org.json.JSONObject(r2).optJSONObject("data").optJSONObject("collab_client_vars").optJSONObject("resources");
    L4:
        e = move-exception;
        tt5.a.d("OfflineUtils", "getResourcesByClientVar()... e = " + e);
        return null;
    }

    public static void k(String r2) {
        e = r2;
        tt5.a.h("OfflineUtils", "setOpeningObjToken " + du5.b.g(r2));
    }

    public static void l(BearUrl r1) {
        k = r1;
        if (r1 != null) goto L5;
    L7:
        sbb.e r2 = sbb.e.e;
        r2.getClass();
        r2.getType();
        i = null;
        j = null;
        return;
    L5:
        if (TextUtils.isEmpty(r1.a) == true) goto L7;
        sbb.e.g(r1.a);
        i = r1.b;
        j = r1.n;
    }

    public static void n(String r2) {
        tt5.a.b("OfflineUtils", "updateClientVarUnusedReason");
        if (o == null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L10;
        o = r2;
        return;
    L10:
        if (m == false) goto L12;
        o = "memory_cache_unread";
        return;
    L12:
        o = "no_cache";
    }

    public static void o(String r2) {
        tt5.a.b("OfflineUtils", "updateSsrUnusedReason");
        if (n == null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L10;
        n = r2;
        return;
    L10:
        if (l == false) goto L12;
        n = "memory_cache_unread";
        return;
    L12:
        n = "no_cache";
    }

    public static void f(final OfflineResultModel r4, final m r5) {
        final long r0 = System.currentTimeMillis();
        Flowable.just("").observeOn(fo5.d.d()).subscribe(new b(r4, r0, r5), new c(r5));
    }

    public static void g(String r3, m r4) {
        tt5.a.b("OfflineUtils", "onJsFailCallback()... errorMsg = " + r3);
        f(new OfflineResultModel(false, r3, ""), r4);
    }

    public static void h(String r3, m r4) {
        tt5.a.b("OfflineUtils", "onJsSuccessCallback()...");
        f(new OfflineResultModel(true, "", r3), r4);
    }

    public static void j(BearUrl r4, String r5) {
        if (r4 != null) goto L5;
    L10:
        sbb.e r6 = sbb.e.e;
        f = r6.b;
        g = r6.getType();
        d = null;
        h = r6.getType();
        e = null;
        tt5.a.h("OfflineUtils", "setOpeningDocUrl null");
        return;
    L5:
        if (TextUtils.isEmpty(r4.a) == true) goto L10;
        f = sbb.e.g(r4.a);
        g = r4.a;
        String r1 = r4.b;
        d = r1;
        tt5.a.h("OfflineUtils", "setOpeningDocUrl " + du5.b.g(r1));
        if (TextUtils.isEmpty(r5) == false) goto L9;
        r5 = r4.b;
    L9:
        k(r5);
    }

    public static void m(String r4, String r5) {
        if (r4 != null) goto L18;
        return;
    L18:
        JSONArray r6 = new org.json.JSONObject(r4).optJSONArray("prefetchKeys");     // Catch: JSONException -> L15
        HashSet r1 = new HashSet();     // Catch: JSONException -> L15
        int r2 = 0;
    L6:
        if (r2 >= r6.length()) goto L12;
        if (JSONArrayProtectorUtils.getString(r6, r2) == null) goto L10;
        r1.add(JSONArrayProtectorUtils.getString(r6, r2));     // Catch: JSONException -> L15
    L10:
        r2 = r2 + 1;     // Catch: JSONException -> L15
        goto L6
    L12:
        if (r1.size() <= 0) goto L24;
        ((HashMap) a).put(r5, r1);     // Catch: JSONException -> L15
        return;
    L24:
        return;
    L15:
        e = move-exception;
        tt5.a.f("OfflineUtils", e, false);
    }
}
