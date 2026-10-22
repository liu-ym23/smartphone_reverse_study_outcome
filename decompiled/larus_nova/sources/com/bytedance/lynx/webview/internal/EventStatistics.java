package com.bytedance.lynx.webview.internal;

import android.os.Build;
import android.os.Process;
import android.os.Trace;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class EventStatistics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f265113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JSONObject f265114b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f265115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static LinkedList<Map<String, Object>> f265116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<Integer> f265117e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<Integer> f265118f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static com.bytedance.lynx.webview.internal.c f265119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static com.bytedance.lynx.webview.internal.b f265120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap f265121i = null;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f265122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f265123b;

        public final void a() {
            Trace.beginSection("sendCommonEvent");
            int r100 = this.f265122a;
            JSONObject r101 = this.f265123b;
            if (((HashSet) EventStatistics.f265117e).contains(Integer.valueOf(r100)) == false) goto L5;
            l17.k.a(new String[]{"Event filtered: [" + r100 + "] = " + r101.toString()});
        L27:
            Trace.endSection();
            return;
        L5:
            JSONObject r102 = new JSONObject();
            EventStatistics.f265113a++;     // Catch: Exception -> L21
            int r103 = Process.myPid();     // Catch: Exception -> L21
            HashMap r104 = new HashMap();     // Catch: Exception -> L21
            EventStatistics.b(r104);     // Catch: Exception -> L21
            EventStatistics.c(r100, r104);     // Catch: Exception -> L21
            JSONObject r105 = EventStatistics.f265114b;     // Catch: Exception -> L21
            JSONObject r106 = new JSONObject(r104);     // Catch: Exception -> L18
            if (r105 == null) goto L17;
            Iterator<String> r107 = r105.keys();     // Catch: Exception -> L18
        L10:
            if (r107 == null) goto L17;
            if (r107.hasNext() == false) goto L17;
            String r108 = r107.next();     // Catch: Exception -> L18
            if (r106.has(r108) == true) goto L10;
            r106.put(r108, r105.opt(r108));     // Catch: Exception -> L18
        L17:
            r102 = r106;
        L19:
            r102.put("logindex", r103 + "-" + EventStatistics.f265113a);     // Catch: Exception -> L21
        L24:
            if (((HashSet) EventStatistics.f265118f).contains(Integer.valueOf(r100)) == false) goto L26;
            l17.k.a(new String[]{"sendImportEvent [" + r100 + "] " + r101.toString() + r102.toString()});
            EventStatistics.f265119g.a(r100, r101, r102);
            goto L27
        L26:
            l17.k.a(new String[]{"sendCommonEvent [" + r100 + "] = " + r101.toString() + r102.toString()});
            EventStatistics.f265119g.b(r100, r101, r102);
        L18:
            r102 = null;
        L21:
            e = move-exception;
            e.toString();
            goto L24
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

        public a(int r100, JSONObject r101) {
            this.f265122a = r100;
            this.f265123b = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventType f265124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f265125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f265126c;

        public final void a() {
            JSONObject r100 = new JSONObject();
            EventType r101 = this.f265124a;     // Catch: JSONException -> L32
            EventType r102 = EventType.SO_UPDATE_SUCCESS;     // Catch: JSONException -> L32
            if (r101 != r102) goto L7;
            EventStatistics.e(r102, this.f265125b);     // Catch: JSONException -> L32
            c0 r103 = TTWebContext.h().p();     // Catch: JSONException -> L32
            String r104 = this.f265125b;     // Catch: JSONException -> L32
            r103.f265273b.edit().putBoolean("so_update_status" + r104, false).apply();     // Catch: JSONException -> L32
        L35:
            return;
        L7:
            EventType r105 = EventType.SO_UPDATE_FAILED;     // Catch: JSONException -> L32
            if (r101 != r105) goto L11;
            r100.put(r105.getEventName(), this.f265125b);     // Catch: JSONException -> L32
            r100.put(EventType.DOWNLOAD_RESULT.getEventName(), l17.b.c());     // Catch: JSONException -> L32
            r100.put(EventType.DOWNLOAD_PROCESS.getEventName(), "");     // Catch: JSONException -> L32
            r100.put(EventType.DOWNLOAD_FINISH_STATUS.getEventName(), this.f265126c);     // Catch: JSONException -> L32
            EventStatistics.f(r105.getEventCode(), r100);     // Catch: JSONException -> L32
            goto L35
        L11:
            EventType r106 = EventType.LOAD_RESULT;     // Catch: JSONException -> L32
            if (r101 != r106) goto L14;
            StringBuffer r107 = l17.b.f506991a;     // Catch: JSONException -> L32
            String r108 = r107.toString();     // Catch: JSONException -> L32
            r107.setLength(0);     // Catch: JSONException -> L32
            TTWebContext.h().p().t(r108);     // Catch: JSONException -> L32
            String r109 = l17.b.d(r108);     // Catch: JSONException -> L32
            r100.put(r106.getEventName(), r109);     // Catch: JSONException -> L32
            r100.put(EventType.LOAD_PROCESS.getEventName(), r108);     // Catch: JSONException -> L32
            r100.put(EventType.DOWNLOAD_FINISH_STATUS.getEventName(), this.f265126c);     // Catch: JSONException -> L32
            r100.put("config_url", TTWebContext.h().p().f265273b.getString("config_url", null));     // Catch: JSONException -> L32
            EventStatistics.f(r106.getEventCode(), r100);     // Catch: JSONException -> L32
            r.d("[Load] Load Result:" + r109);     // Catch: JSONException -> L32
            goto L35
        L14:
            EventType r110 = EventType.SO_UPDATE_NEED;     // Catch: JSONException -> L32
            if (r101 != r110) goto L17;
            c0 r111 = TTWebContext.h().p();     // Catch: JSONException -> L32
            String r112 = this.f265125b;     // Catch: JSONException -> L32
            r111.f265273b.edit().putBoolean("so_update_status" + r112, true).apply();     // Catch: JSONException -> L32
            r100.put(r110.getEventName(), this.f265125b);     // Catch: JSONException -> L32
            r100.put(EventType.DOWNLOAD_RESULT.getEventName(), l17.b.c());     // Catch: JSONException -> L32
            r100.put(EventType.DOWNLOAD_PROCESS.getEventName(), "");     // Catch: JSONException -> L32
            EventStatistics.f(r110.getEventCode(), r100);     // Catch: JSONException -> L32
            goto L35
        L17:
            EventType r113 = EventType.DOWNLOAD_RESULT;     // Catch: JSONException -> L32
            if (r101 != r113) goto L21;
            r100.put(r113.getEventName(), l17.b.c());     // Catch: JSONException -> L32
            r100.put(EventType.DOWNLOAD_PROCESS.getEventName(), "");     // Catch: JSONException -> L32
            r100.put(EventType.DOWNLOAD_FINISH_STATUS.getEventName(), this.f265126c);     // Catch: JSONException -> L32
            EventStatistics.f(r113.getEventCode(), r100);     // Catch: JSONException -> L32
            goto L35
        L21:
            if (r101 != EventType.DOWNLOAD_STATUS_FAILED) goto L23;
        L30:
            StringBuffer r114 = l17.b.f506991a;     // Catch: JSONException -> L32
            JSONObject r115 = new JSONObject();     // Catch: JSONException -> L32
            r115.put("download_seg_list", "");     // Catch: JSONException -> L32
            EventStatistics.f(this.f265124a.getEventCode(), r115);     // Catch: JSONException -> L32
            goto L35
        L23:
            if (r101 == EventType.DOWNLOAD_STATUS_END) goto L30;
            if (r101 != EventType.DOWNLOAD_STATUS_START) goto L28;
        L29:
            EventStatistics.e(r101, this.f265125b);     // Catch: JSONException -> L32
            goto L35
        L28:
            if (r101 != EventType.DOWNLOAD_PROHIBITED_BY_MEMORY_LIMIT) goto L35;
        L32:
            e = move-exception;
            e.toString();
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

        public b(EventType r100, String r101, boolean r102) {
            this.f265124a = r100;
            this.f265125b = r101;
            this.f265126c = r102;
        }
    }

    public static class c implements com.bytedance.lynx.webview.internal.b {
        @Override // com.bytedance.lynx.webview.internal.b
        public final void a(String r100, Map<String, Object> r101, Map<String, Object> r102) {
        }

        public c() {
        }
    }

    public static class d implements com.bytedance.lynx.webview.internal.c {
        @Override // com.bytedance.lynx.webview.internal.c
        public final void a(int r100, JSONObject r101, JSONObject r102) {
        }

        @Override // com.bytedance.lynx.webview.internal.c
        public final void b(int r100, JSONObject r101, JSONObject r102) {
        }

        public d() {
        }
    }

    public EventStatistics() {
    }

    static {
        f265114b = new JSONObject();
        f265115c = false;
        f265117e = new AnonymousClass1();
        f265118f = new AnonymousClass2();
        f265119g = new d();
        f265120h = new c();
        f265121i = new ConcurrentHashMap();
    }

    public static void b(Map<String, Object> r100) {
        TTWebContext.h().getClass();
        r100.put("loadso", TTWebContext.l(false));
        r100.put("sdk_aar_version", k17.a.f501380a);
        r100.put("pid", Integer.valueOf(Process.myPid()));
        r100.put("processname", l17.n.b(TTWebContext.h().getContext()));
        i17.b r101 = TTWebContext.h().f265216b.f265149l;
        if (r101 == null) goto L5;
        int r102 = r101.getWebViewCount();
    L6:
        r100.put("webview_count", Integer.valueOf(r102));
        r100.put("app_start_times", Integer.valueOf(TTWebContext.h().p().f265273b.getInt(ILoadStallMonitor.START_TIME, 0)));
        r100.put("app_start_times_by_version", Integer.valueOf(TTWebContext.h().p().f265273b.getInt("start_time_by_version", 0)));
        r100.put("os_api", Integer.valueOf(Build.VERSION.SDK_INT));
        r100.put("os_version", Build.VERSION.RELEASE);
        r100.put("sdk_scc_version", 25);
        r100.put("kernel_scc_version", Integer.valueOf(TTWebContext.h().k()));
        r100.putAll(f265121i);
        r100.put("app_host_abi", TTWebContext.g());     // Catch: Throwable -> L9
        return;
    L9:
        r100.put("app_host_abi", "empty");
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public static void a(String r100, Object r101) {
        f265121i.put(r100, r101);
    }

    public static void c(int r100, Map<String, Object> r101) {
    L7:
        th = move-exception;
        l17.k.b(new String[]{"Error happened: " + th});
        return;
    L4:
        if (r100 != EventType.LOAD_WEBVIEW_CREATEWEBVIEW_TIME.getEventCode()) goto L12;
        TTWebContext.h().f265223i.set(true);     // Catch: Throwable -> L7
        long r102 = System.currentTimeMillis() - TTWebContext.h().f265224j;     // Catch: Throwable -> L7
        ((HashMap) r101).put("timedelta_of_first_webview", Long.valueOf(r102));     // Catch: Throwable -> L7
        l17.k.d(new String[]{"First webview instance created until: " + r102});     // Catch: Throwable -> L7
        return;
    }

    public static void e(EventType r100, Object r101) {
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L4
        r102.put(r100.getEventName(), r101);     // Catch: JSONException -> L4
        f(r100.getEventCode(), r102);     // Catch: JSONException -> L4
        return;
    }

    public static void f(int r100, JSONObject r101) {
        TTWebContext.C(new a(r100, r101));
    }

    public static void d(String r100, Map<String, Object> r101, Map<String, Object> r102) {
        if (f265115c == true) goto L5;
    L12:
        b(r101);
        f265120h.a(r100, r101, r102);
        return;
    L5:
        if ("ttwebview_scc".equals(r100) == false) goto L12;
        if (f265116d != null) goto L9;
        f265116d = new LinkedList();
    L9:
        f265116d.add(r101);
        if (f265116d.size() <= 10) goto L12;
        f265116d.removeFirst();
        goto L12
    }

    public static void g(EventType r100, String r101, boolean r102) {
        TTWebContext.C(new b(r100, r101, r102));
    }
}
