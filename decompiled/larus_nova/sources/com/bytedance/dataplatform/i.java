package com.bytedance.dataplatform;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.init.task.AbTestInitiator;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Map<String, String> f204304k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f204305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f204306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f204307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Integer> f204308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f204309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f204310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t f204311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final q f204312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Future f204313i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Runnable> f204314j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f204315a;

        @Override // java.lang.Runnable
        public final void run() {
            i.a(this.f204315a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(i r100) {
            this.f204315a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f204316a;

        @Override // java.lang.Runnable
        public final void run() {
            i.a(this.f204316a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(i r100) {
            this.f204316a = r100;
        }
    }

    static {
        f204304k = new ConcurrentHashMap();
    }

    public static void a(i r100) {
        r100.getClass();
        StringBuilder r101 = new StringBuilder(r100.f204305a);     // Catch: Exception -> L28
        if (f204304k.isEmpty() == false) goto L7;
    L18:
        JSONObject r102 = new JSONObject(r100.f204311g.a(r101.toString()));     // Catch: Exception -> L28
        if (r102.has("code") == true) goto L21;
        return;
    L21:
        if (r102.has("data") == true) goto L24;
        return;
    L24:
        if (r102.optInt("code", -1) != 0) goto L36;
        r100.d(JSONObjectProtectorUtils.getJSONObject(r102, "data"));     // Catch: Exception -> L28
        return;
    L36:
        return;
    L7:
        if (r100.f204305a.indexOf(63) >= 0) goto L9;
        r101.append("?");     // Catch: Exception -> L28
    L10:
        Iterator<Map.Entry<String, String>> r103 = f204304k.entrySet().iterator();     // Catch: Exception -> L28
        boolean r104 = true;
    L12:
        if (r103.hasNext() == false) goto L18;
        Map.Entry<String, String> r105 = r103.next();     // Catch: Exception -> L28
        if (r104 == false) goto L16;
        r104 = false;
    L17:
        r101.append(URLEncoder.encode(r105.getKey(), "UTF-8"));     // Catch: Exception -> L28
        r101.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L28
        r101.append(URLEncoder.encode(r105.getValue(), "UTF-8"));     // Catch: Exception -> L28
        goto L12
    L16:
        r101.append("&");     // Catch: Exception -> L28
        goto L17
    L9:
        r101.append("&");     // Catch: Exception -> L28
    }

    public final synchronized void c(Map<String, String> r100) {
        monitor-enter(this);
        Future r101 = this.f204313i;     // Catch: Throwable -> L11
        if (r101 == null) goto L6;
        r101.cancel(true);     // Catch: Throwable -> L11
    L6:
        if (r100 == null) goto L8;
        f204304k.putAll(r100);     // Catch: Throwable -> L11
    L8:
        b r102 = new b(this);     // Catch: Throwable -> L11
        this.f204313i = w.f204370a.scheduleWithFixedDelay(r102, 0, 3600000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void d(JSONObject r110) {
        JSONObject r100 = new JSONObject();
        HashMap r101 = new HashMap();
        HashMap r102 = new HashMap();
        Iterator<String> r103 = r110.keys();
    L4:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        JSONObject r105 = JSONObjectProtectorUtils.getJSONObject(r110, r104);     // Catch: JSONException -> L13
        r100.put(r104, r105.get("val"));     // Catch: JSONException -> L13
        String r106 = JSONObjectProtectorUtils.getString(r105, "vid");     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r106) == true) goto L4;
        r101.put(r104, r106);     // Catch: JSONException -> L13
        long r107 = JSONObjectProtectorUtils.getLong(r105, "et");     // Catch: JSONException -> L13
        if (r107 <= 0) goto L4;
        r102.put(r106, Long.valueOf(r107));     // Catch: JSONException -> L13
        goto L4
    L14:
        ((ConcurrentHashMap) this.f204309e).clear();
        this.f204307c = r100;
        w.a(new com.bytedance.dataplatform.a(this.f204306b, r100));
        q r108 = this.f204312h;
        r108.f204366i = r101;
        w.a(new e(r108.f204358a, r101));
        r108.f204360c.retainAll(r108.f204366i.values());
        w.a(new c(r108.f204358a, "SP_EXPERIMENT_EXPOSURE_CACHE", r108.f204360c));
        r108.c();
        if (o.f204351j == null) goto L29;
        int r109 = AbTestInitiator.f350994g;
        FLogger.f375446a.i("InitAbTest", "onLibraExperimentChanged: " + r110);
        return;
    }

    public final void e(String r100) {
        q r101 = this.f204312h;
        r101.getClass();
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L6:
        r100 = "";
    L8:
        if (TextUtils.equals(r101.f204364g, r100) == true) goto L12;
        r101.f204364g = r100;
        r101.f204362e = g.d(r101.f204358a, "SP_EXPERIMENT_EXPOSURE_CACHE_" + r101.f204364g);
        w.a(new d(r101.f204364g, r101.f204358a, "SP_EXPERIMENT_CACHE", "ab_test_current_uid"));
        r101.c();
        return;
    L12:
        return;
    L5:
        if ("0".equals(r100) == false) goto L8;
        goto L6
    }

    public final Object b(String r100, Type r101, boolean r102) {
        Object r103 = null;
        if (r101 == Boolean.class) goto L58;
        if (r101 == Boolean.TYPE) goto L58;
        if (r101 == Integer.class) goto L55;
        if (r101 == Short.class) goto L55;
        if (r101 == Integer.TYPE) goto L55;
        if (r101 == Short.TYPE) goto L55;
        if (r101 == Float.class) goto L52;
        if (r101 == Float.TYPE) goto L52;
        if (r101 == Long.class) goto L49;
        if (r101 == Long.TYPE) goto L49;
        if (r101 == Double.class) goto L46;
        if (r101 == Double.TYPE) goto L46;
        if (r101 != String.class) goto L67;
        Object r104 = this.f204307c.optString(r100, null);
    L61:
        j r105 = new j(this, r100);
        if (r102 == false) goto L64;
        r105.run();
    L65:
        return r104;
    L64:
        ((ConcurrentHashMap) this.f204314j).put(r100, r105);
        goto L65
    L67:
    L44:
        ((ConcurrentHashMap) this.f204309e).remove(r100);
    L60:
        r104 = r103;
        goto L61
    L35:
        if (((ConcurrentHashMap) this.f204309e).containsKey(r100) == true) goto L37;
    L39:
        String r106 = this.f204307c.optString(r100, "");     // Catch: Exception -> L44
        Object r107 = this.f204310f.a(r106, r101);     // Catch: Exception -> L44
        if (r107 != null) goto L42;
        ((ConcurrentHashMap) this.f204309e).remove(r100);     // Catch: Exception -> L44
    L66:
        goto L60
    L42:
        ((ConcurrentHashMap) this.f204309e).put(r100, r107);     // Catch: Exception -> L44
        r103 = r107;
        goto L66
    L37:
        if (((ConcurrentHashMap) this.f204309e).get(r100).getClass() != r101) goto L39;
        r103 = ((ConcurrentHashMap) this.f204309e).get(r100);     // Catch: Exception -> L44
    L46:
        if (this.f204307c.has(r100) == false) goto L60;
        r104 = Double.valueOf(this.f204307c.optDouble(r100));
    L49:
        if (this.f204307c.has(r100) == false) goto L60;
        r104 = Long.valueOf(this.f204307c.optLong(r100));
    L52:
        if (this.f204307c.has(r100) == false) goto L60;
        r104 = Float.valueOf((float) this.f204307c.optDouble(r100));
    L55:
        if (this.f204307c.has(r100) == false) goto L60;
        r104 = Integer.valueOf(this.f204307c.optInt(r100));
    L58:
        if (this.f204307c.has(r100) == false) goto L60;
        r104 = Boolean.valueOf(this.f204307c.optBoolean(r100));
        goto L61
    }

    public i(Application r100, String r101, boolean r110, u r111, s r112, t r113, Map<String, String> r114, Set<String> r115) {
        this.f204309e = new ConcurrentHashMap();
        this.f204314j = new ConcurrentHashMap();
        this.f204305a = r101;
        f204304k = r114;
        this.f204306b = r100;
        JSONObject r116 = new JSONObject(g.c(r100, "SP_EXPERIMENT_CACHE").getString("SP_EXPERIMENT_CACHE", ""));     // Catch: JSONException -> L5
    L6:
        this.f204307c = r116;
        this.f204308d = g.a(r100);
        q r102 = new q(r100, r112, r115);
        this.f204312h = r102;
        ClientExperimentManager.f204280f.getClass();
        if (ClientExperimentManager.f204277c != null) goto L9;
        ClientExperimentManager.f204277c = r102;
        w.a(new h(r102));
    L9:
        this.f204310f = r111;
        this.f204311g = r113;
        if (r110 == false) goto L15;
        a r103 = new a(this);
        this.f204313i = w.f204370a.scheduleWithFixedDelay(r103, 2000, 3600000, TimeUnit.MILLISECONDS);
        return;
    L15:
        return;
    L5:
        r116 = new JSONObject();
        goto L6
    }
}
