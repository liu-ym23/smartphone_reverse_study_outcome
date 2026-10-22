package com.ss.android.lark.statistics;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.log.Log;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f440624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile com.ss.android.lark.statistics.a f440625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f440626c;

    public class a implements c {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.statistics.b$b, reason: collision with other inner class name */
    public static class C5291b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f440627a;

        public C5291b(String r100, JSONObject r101) {
            this.f440627a = r100;
        }
    }

    public interface c {
    }

    public interface d {
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<C5291b> f440628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f440629b;

        public e() {
            this.f440628a = Collections.synchronizedList(new LinkedList());
            this.f440629b = new AtomicInteger(0);
            new AtomicBoolean(false);
        }

        public final void a(Runnable r100) {
            List<C5291b> r101 = this.f440628a;
            monitor-enter(r101);
            r100.run();     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        f440626c = new a();
    }

    public static com.ss.android.lark.statistics.a a() {
        if (f440625b != null) goto L5;
        f440625b = (com.ss.android.lark.statistics.a) ClaymoreServiceLoader.loadFirstOrNull(com.ss.android.lark.statistics.a.class);     // Catch: Exception -> L8
        return f440625b;
    L8:
        e = move-exception;
        Log.w("StatisticsLazy", "getStatisticsAppLog failed: " + e.getMessage());
        return null;
    L5:
        return f440625b;
    }

    public static void b(String r100, JSONObject r101) {
        final e r102 = f440624a;
        if (r102 == null) goto L43;
        int r103 = 0;
        if (r101 == null) goto L9;
        int r104 = r101.toString().getBytes().length / 1024;
        if (r104 <= 1024) goto L9;
        Log.i("StatisticsLazy", "dropEvent: " + r100 + ", size: " + r104 + " KB");
        new JSONObject().put("event", r100);     // Catch: Exception -> L13
        new JSONObject().put("size_kb", r104);     // Catch: Exception -> L13
        throw null;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.i("StatisticsLazy", "reportSlardar fail, e: " + e.getMessage());
        boolean r105 = true;
    L15:
        if (r105 == true) goto L55;
        Log.i("StatisticsLazy", "sendEvent:" + r100);
        if (r102.f440629b.get() == 2) goto L20;
        List<C5291b> r106 = r102.f440628a;
        monitor-enter(r106);
        r102.f440628a.add(new C5291b(r100, r101));     // Catch: Throwable -> L40
        monitor-exit(r106);     // Catch: Throwable -> L40
        if (r102.f440629b.compareAndSet(0, 1) == false) goto L57;
        throw null;
    L57:
        return;
    L40:
        th = move-exception;
        throw th;
    L20:
        if (r102.f440628a.isEmpty() == true) goto L23;
        r102.a(new com.ss.android.lark.statistics.c(r102));
    L23:
        u5c.a r107 = u5c.d.b.f548913a.f548912i;
        if (r107 == null) goto L27;
        r103 = r107.f548909b;
    L27:
        if (r103 != 0) goto L29;
        f440626c.getClass();
        return;
    L29:
        if (r103 == 2) goto L56;
        f440626c.getClass();
        return;
    L56:
        return;
    L55:
        return;
    L9:
        r105 = false;
        goto L15
    L43:
        com.ss.android.lark.statistics.a r108 = a();
        if (r108 == null) goto L46;
        r108.onEventV3(r100, r101);
        return;
    L46:
        Log.w("StatisticsLazy", "sendEvent failed: sStatisticsImpl is null and IStatisticsAppLog not found, eventName: " + r100);
    }
}
