package lc5;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.net.CloudReqFun;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class x {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile x f508596g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Long> f508597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Boolean> f508598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f508599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile FolderSortStrategy f508600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f508601e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f508602f;

    public static x c() {
        if (f508596g != null) goto L15;
        monitor-enter(x.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f508596g != null) goto L9;
        f508596g = new x();     // Catch: Throwable -> L11
    L9:
        monitor-exit(x.class);     // Catch: Throwable -> L11
    L15:
        return f508596g;
    }

    public final void b() {
        tt5.a.b("SpaceReport", "clearRecord()...");
        ((ConcurrentHashMap) this.f508597a).clear();
        ((ConcurrentHashMap) this.f508599c).clear();
        ((ConcurrentHashMap) this.f508598b).clear();
    }

    public x() {
        this.f508597a = new ConcurrentHashMap();
        this.f508598b = new ConcurrentHashMap();
        this.f508599c = new ConcurrentHashMap();
    }

    public static void d(Throwable r100) {
        if ((r100 instanceof SocketTimeoutException) == false) goto L5;
    L13:
        c().e(1, "SEC3", "recent", "key_open_finish_recent");
        return;
    L5:
        if ((r100 instanceof CloudReqFun.OkHttpReqException) == false) goto L10;
        if ((((CloudReqFun.OkHttpReqException) r100).exceptionObj instanceof SocketTimeoutException) == true) goto L13;
    L10:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L12;
        c().e(1, "SEC4", "recent", "key_open_finish_recent");
        return;
    L12:
        c().e(1, "SEC5", "recent", "key_open_finish_recent");
    }

    public final void a(String r100) {
        Map<String, Long> r101 = this.f508597a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100.concat("_recent"), Long.valueOf(SystemClock.uptimeMillis()));
    }

    public final void h(String r110) {
        Boolean r100 = (Boolean) ((ConcurrentHashMap) this.f508598b).get(r110);
        if (r100 != null) goto L5;
    L7:
        Long r101 = (Long) ((ConcurrentHashMap) this.f508597a).get("init");
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.longValue() <= 0) goto L17;
        long r102 = SystemClock.uptimeMillis() - r101.longValue();
        if (r102 > 0) goto L14;
        return;
    L14:
        f(r110, r102, 0, 0);
        Map<String, Boolean> r103 = this.f508598b;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r104.put(r110, Boolean.TRUE);
        Map<String, Long> r105 = this.f508599c;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        r106.put(r110, Long.valueOf(r102));
        return;
    L17:
        return;
    L5:
        if (r100.booleanValue() == false) goto L7;
    }

    public final void i(String r100) {
        j(r100);
        j(r100.concat("_recent"));
    }

    public final void j(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        ((ConcurrentHashMap) this.f508597a).remove(r100);
        ((ConcurrentHashMap) this.f508599c).remove(r100);
        ((ConcurrentHashMap) this.f508598b).remove(r100);
    }

    public final void k(long r100, String... r101) {
        if (r100 <= 0) goto L11;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L15;
        String r104 = r101[r103];
        if (TextUtils.isEmpty(r104) == true) goto L10;
        Map<String, Long> r105 = this.f508597a;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        r106.put(r104, Long.valueOf(r100));
    L10:
        r103 = r103 + 1;
        goto L6
    L15:
        return;
    }

    public final void g(String r110, int r111, int r112) {
        String r100 = r110.concat("_recent");
        Long r101 = (Long) ((ConcurrentHashMap) this.f508597a).get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.longValue() <= 0) goto L12;
        long r102 = SystemClock.uptimeMillis() - r101.longValue();
        if (r102 > 0) goto L9;
        return;
    L9:
        f(r110, r102, r111, r112);
        ((ConcurrentHashMap) this.f508597a).put(r100, 0L);
        return;
    }

    public final void e(int r110, String r111, String r112, String r113) {
        Boolean r100 = (Boolean) ((ConcurrentHashMap) this.f508598b).get(r113);
        if (r100 != null) goto L5;
    L7:
        Long r101 = (Long) ((ConcurrentHashMap) this.f508597a).get(r113);
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.longValue() <= 0) goto L66;
        long r102 = SystemClock.uptimeMillis() - r101.longValue();
        if (r102 > 0) goto L15;
        return;
    L15:
        if (this.f508600d == null) goto L24;
        sbb.e r103 = sbb.e.d(this.f508600d.getType());
        if (r103.f541317b != 12) goto L22;
        if ("photo".equalsIgnoreCase(this.f508600d.f227682c) == false) goto L22;
        String r104 = "image";
    L26:
        if (this.f508600d == null) goto L36;
        RecentSort r105 = RecentSort.getSort(this.f508600d.f227684e);
        if (r105 != RecentSort.MODIFIED) goto L31;
        String r106 = "Latest_modified_time";
    L37:
        boolean r107 = this.f508601e;
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L54
        r108.put("result_code", String.valueOf(r110));     // Catch: Exception -> L54
        r108.put("fail_code", r111);     // Catch: Exception -> L54
        r108.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r102);     // Catch: Exception -> L54
        r108.put("list_type", "recent");     // Catch: Exception -> L54
        r108.put("filter_type1", r104);     // Catch: Exception -> L54
        r108.put(com.bytedance.android.ec.core.event.a.KEY_SORD_TYPE, r106);     // Catch: Exception -> L54
        r108.put("view_mode", r107 ? 1 : 0);     // Catch: Exception -> L54
        r108.put("user_operation_source", 0);     // Catch: Exception -> L54
        if (this.f508602f == false) goto L41;
        int r114 = 1;
    L42:
        r108.put("has_cache", r114);     // Catch: Exception -> L54
        r108.put("select_tab", r112);     // Catch: Exception -> L54
        if (qc5.a.h() == false) goto L45;
        String r115 = "new_format";
    L46:
        r108.put("space_version", r115);     // Catch: Exception -> L54
        Iterator r116 = ((ConcurrentHashMap) this.f508599c).entrySet().iterator();     // Catch: Exception -> L54
    L48:
        if (r116.hasNext() == false) goto L52;
        Map.Entry r117 = (Map.Entry) r116.next();     // Catch: Exception -> L54
        String r118 = (String) r117.getKey();     // Catch: Exception -> L54
        Long r119 = (Long) r117.getValue();     // Catch: Exception -> L54
        if (TextUtils.isEmpty(r118) == true) goto L48;
        r108.put(r118, r119);     // Catch: Exception -> L54
        goto L48
    L52:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).a("dev_performance_space_open_finish", r108);     // Catch: Exception -> L54
        tt5.a.b("SpaceReport", "reportOpenFinish()...param = " + r108.toString());     // Catch: Exception -> L54
    L56:
        ((ConcurrentHashMap) this.f508598b).put(r113, Boolean.TRUE);
        return;
    L45:
        r115 = "original";
        goto L46
    L41:
        r114 = 0;
    L54:
        e = move-exception;
        tt5.a.f("SpaceReport", e, false);
        goto L56
    L31:
        if (r105 != RecentSort.CREATED) goto L34;
        r106 = "Latest_created";
        goto L37
    L34:
        if (r105 != RecentSort.OPENED) goto L36;
        r106 = "Latest_open_time";
    L36:
        r106 = "All_time";
    L22:
        if (r103.f541317b == sbb.e.f541294e.f541317b) goto L24;
        r104 = r103.getType();
    L24:
        r104 = "all";
        goto L26
    L66:
        return;
    L5:
        if (r100.booleanValue() == false) goto L7;
    }

    public final void f(String r100, long r101, int r110, int r111) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L9
        r102.put("stage", r100);     // Catch: Exception -> L9
        r102.put("list_type", "recent");     // Catch: Exception -> L9
        r102.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r101);     // Catch: Exception -> L9
        r102.put("result_code", r110);     // Catch: Exception -> L9
        if (this.f508601e == false) goto L6;
        int r103 = 1;
    L7:
        r102.put("view_mode", r103);     // Catch: Exception -> L9
        r102.put("data_size", r111);     // Catch: Exception -> L9
        r102.put("user_operation_source", 0);     // Catch: Exception -> L9
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).a("dev_performance_space_open_stages", r102);     // Catch: Exception -> L9
        tt5.a.b("SpaceReport", "reportStage()...param = " + r102.toString());     // Catch: Exception -> L9
        return;
    L6:
        r103 = 0;
    L9:
        e = move-exception;
        tt5.a.f("SpaceReport", e, false);
    }
}
