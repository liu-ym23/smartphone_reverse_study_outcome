package sz2;

import android.app.Application;
import android.content.SharedPreferences;
import android.view.View;
import com.bytedance.android.monitorV2.constant.MonitorGlobalSp;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f543906a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, ConcurrentHashMap<String, Object>> f543907b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, ConcurrentHashMap<String, Object>> f543908c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, JSONObject> f543909d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, f> f543910e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final WeakHashMap<View, InterfaceC7672a> f543911f = null;

    /* JADX INFO: renamed from: sz2.a$a, reason: collision with other inner class name */
    public interface InterfaceC7672a {
        void a(String r100);
    }

    public a() {
    }

    static {
        f543906a = new a();
        f543907b = Collections.synchronizedMap(new ConcurrentHashMap());
        f543908c = Collections.synchronizedMap(new ConcurrentHashMap());
        f543909d = Collections.synchronizedMap(new ConcurrentHashMap());
        f543910e = Collections.synchronizedMap(new LinkedHashMap());
        f543911f = new WeakHashMap();
    }

    public static ConcurrentHashMap a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Map<String, ConcurrentHashMap<String, Object>> r101 = f543907b;
        if (r101.get(r100) != null) goto L5;
        ConcurrentHashMap<String, Object> r102 = new ConcurrentHashMap();
        r102.put(PerfLog.PARAM_KEY_CONTEXT_ID, b(r100));
        r102.put("version", "10.4.0");
        r101.put(r100, r102);
    L5:
        ConcurrentHashMap<String, Object> r103 = r101.get(r100);
        if (r103 == null) goto L8;
        return r103;
    L8:
        return new ConcurrentHashMap();
    }

    public static JSONObject b(String r110) {
        Map<String, JSONObject> r100 = f543909d;
        if (r100.get(r110) != null) goto L64;
        JSONObject r101 = new JSONObject();
        int r102 = com.bytedance.android.monitorV2.util.c.f163234a;
        Lazy r103 = MonitorGlobalSp.f162991a;
        Intrinsics.checkNotNullParameter("monitor_is_reinstall", "key");
        Application r104 = MonitorGlobalSp.f162993c;
        boolean r105 = false;
        if (r104 == null) goto L10;
        SharedPreferences r106 = MonitorGlobalSp.c();
        if (r106 == null) goto L10;
        boolean r107 = r106.getBoolean("monitor_is_reinstall", false);
    L12:
        if (r107 == true) goto L23;
        Intrinsics.checkNotNullParameter("monitor_is_reinstall", "key");
        if (r104 == null) goto L23;
        SharedPreferences r108 = MonitorGlobalSp.c();
        if (r108 == null) goto L23;
        SharedPreferences.Editor r109 = r108.edit();
        if (r109 == null) goto L23;
        SharedPreferences.Editor r111 = r109.putBoolean("monitor_is_reinstall", true);
        if (r111 == null) goto L23;
        r111.apply();
    L23:
        r101.put("is_reinstall", !r107);
        long r112 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - com.bytedance.apm.d.e());
        if (0 <= r112) goto L26;
    L28:
        boolean r113 = false;
    L29:
        if (r113 == false) goto L32;
        String r114 = "0";
    L63:
        r101.put("app_runtime", r114);
        r100.put(r110, r101);
        goto L64
    L32:
        if (3 <= r112) goto L34;
    L36:
        boolean r115 = false;
    L37:
        if (r115 == false) goto L40;
        r114 = "1";
        goto L63
    L40:
        if (5 <= r112) goto L42;
    L44:
        boolean r116 = false;
    L45:
        if (r116 == false) goto L48;
        r114 = "2";
        goto L63
    L48:
        if (10 <= r112) goto L50;
    L52:
        boolean r117 = false;
    L53:
        if (r117 == false) goto L56;
        r114 = "3";
        goto L63
    L56:
        if (30 <= r112) goto L58;
    L60:
        if (r105 == false) goto L62;
        r114 = "4";
        goto L63
    L62:
        r114 = "5";
        goto L63
    L58:
        if (r112 >= 60) goto L60;
        r105 = true;
        goto L60
    L50:
        if (r112 >= 30) goto L52;
        r117 = true;
        goto L53
    L42:
        if (r112 >= 10) goto L44;
        r116 = true;
        goto L45
    L34:
        if (r112 >= 5) goto L36;
        r115 = true;
        goto L37
    L26:
        if (r112 >= 3) goto L28;
        r113 = true;
    L10:
        r107 = false;
    L64:
        JSONObject r118 = r100.get(r110);
        if (r118 == null) goto L67;
        return r118;
    L67:
        return new JSONObject();
    }

    public static ConcurrentHashMap c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Map<String, ConcurrentHashMap<String, Object>> r101 = f543908c;
        if (r101.get(r100) != null) goto L5;
        r101.put(r100, new ConcurrentHashMap());
    L5:
        ConcurrentHashMap<String, Object> r102 = r101.get(r100);
        if (r102 == null) goto L8;
        return r102;
    L8:
        return new ConcurrentHashMap();
    }

    public static List d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ArrayList r101 = new ArrayList();
        Map<String, f> r102 = f543910e;
        monitor-enter(r102);
        Iterator<Map.Entry<String, f>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L18
    L6:
        if (r103.hasNext() == false) goto L15;
        Map.Entry<String, f> r104 = r103.next();     // Catch: Throwable -> L18
        View r105 = r104.getValue().a();     // Catch: Throwable -> L18
        if (r105 == null) goto L12;
        boolean r106 = true;
        if (r105.equals(r100) != true) goto L12;
    L13:
        if (r106 == false) goto L6;
        r101.add(r104.getKey());     // Catch: Throwable -> L18
    L12:
        r106 = false;
        goto L13
    L15:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r102);
        return r101;
    L18:
        th = move-exception;
        throw th;
    }

    public static f f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        return f543910e.get(r100);
    }

    public static jz2.a g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        CopyOnWriteArrayList r101 = new CopyOnWriteArrayList();
        Iterator r102 = ((ArrayList) d(r100)).iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        String r103 = (String) r102.next();
        Intrinsics.checkNotNullParameter(r103, "monitorId");
        r101.add(a(r103));
        goto L4
    L7:
        return new jz2.a(r101);
    }

    public static jz2.b h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        CopyOnWriteArrayList r101 = new CopyOnWriteArrayList();
        Iterator r102 = ((ArrayList) d(r100)).iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        String r103 = (String) r102.next();
        Intrinsics.checkNotNullParameter(r103, "monitorId");
        r101.add(c(r103));
        goto L4
    L7:
        return new jz2.b(r101);
    }

    public static void e(View r100, InterfaceC7672a r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Map<String, f> r102 = f543910e;
        monitor-enter(r102);
        Iterator<Map.Entry<String, f>> r103 = r102.entrySet().iterator();     // Catch: Throwable -> L20
        boolean r104 = false;
    L6:
        if (r103.hasNext() == false) goto L15;
        Map.Entry<String, f> r105 = r103.next();     // Catch: Throwable -> L20
        String r106 = r105.getKey();     // Catch: Throwable -> L20
        View r107 = r105.getValue().a();     // Catch: Throwable -> L20
        if (r107 != null) goto L10;
    L12:
        boolean r108 = false;
    L13:
        if (r108 == false) goto L6;
        r101.a(r106);     // Catch: Throwable -> L20
        r104 = true;
        goto L6
    L10:
        if (r107.equals(r100) != true) goto L12;
        r108 = true;
        goto L13
    L15:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r102);
        if (r104 == true) goto L30;
        f543911f.put(r100, r101);
        return;
    L30:
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static String i(String r100, View r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "field");
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Object r104 = c(r100).get(r102);
        if ((r104 instanceof String) == true) goto L19;
    L17:
        return null;
    L19:
        return (String) r104;
    L13:
        if (r101 == null) goto L17;
        Object r105 = ((ConcurrentHashMap) h(r101).a()).get(r102);
        if ((r105 instanceof String) == false) goto L17;
        return (String) r105;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public static void j(String r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "monitorId");
        Intrinsics.checkNotNullParameter(r101, "field");
        Intrinsics.checkNotNullParameter(r102, "value");
        a(r100).put(r101, r102);
    }
}
