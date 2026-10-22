package lc5;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.recent.RecentSort;
import com.bytedance.ee.bear.net.CloudReqFun;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import java.net.SocketTimeoutException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x {
    public static volatile x g;
    public final Map<String, Long> a;
    public final Map<String, Boolean> b;
    public final Map<String, Long> c;
    public volatile FolderSortStrategy d;
    public volatile boolean e;
    public boolean f;

    public static x c() {
        if (g != null) goto L15;
        monitor-enter(x.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new x();     // Catch: Throwable -> L11
    L9:
        monitor-exit(x.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public final void b() {
        tt5.a.b("SpaceReport", "clearRecord()...");
        ((ConcurrentHashMap) this.a).clear();
        ((ConcurrentHashMap) this.c).clear();
        ((ConcurrentHashMap) this.b).clear();
    }

    public x() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
    }

    public static void d(Throwable r4) {
        if ((r4 instanceof SocketTimeoutException) == false) goto L5;
    L13:
        c().e(1, "SEC3", "recent", "key_open_finish_recent");
        return;
    L5:
        if ((r4 instanceof CloudReqFun.OkHttpReqException) == false) goto L10;
        if ((((CloudReqFun.OkHttpReqException) r4).exceptionObj instanceof SocketTimeoutException) == true) goto L13;
    L10:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L12;
        c().e(1, "SEC4", "recent", "key_open_finish_recent");
        return;
    L12:
        c().e(1, "SEC5", "recent", "key_open_finish_recent");
    }

    public final void a(String r4) {
        Map<String, Long> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.put(r4.concat("_recent"), Long.valueOf(SystemClock.uptimeMillis()));
    }

    public final void h(String r14) {
        Boolean r0 = (Boolean) ((ConcurrentHashMap) this.b).get(r14);
        if (r0 != null) goto L5;
    L7:
        Long r1 = (Long) ((ConcurrentHashMap) this.a).get("init");
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.longValue() <= 0) goto L17;
        long r2 = SystemClock.uptimeMillis() - r1.longValue();
        if (r2 > 0) goto L14;
        return;
    L14:
        f(r14, r2, 0, 0);
        Map<String, Boolean> r3 = this.b;
        ConcurrentHashMap r4 = (ConcurrentHashMap) r3;
        r4.put(r14, Boolean.TRUE);
        Map<String, Long> r5 = this.c;
        ConcurrentHashMap r6 = (ConcurrentHashMap) r5;
        r6.put(r14, Long.valueOf(r2));
        return;
    L17:
        return;
    L5:
        if (r0.booleanValue() == false) goto L7;
    }

    public final void i(String r2) {
        j(r2);
        j(r2.concat("_recent"));
    }

    public final void j(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        ((ConcurrentHashMap) this.a).remove(r2);
        ((ConcurrentHashMap) this.c).remove(r2);
        ((ConcurrentHashMap) this.b).remove(r2);
    }

    public final void k(long r6, String... r8) {
        if (r6 <= 0) goto L11;
        int r0 = r8.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L15;
        String r2 = r8[r1];
        if (TextUtils.isEmpty(r2) == true) goto L10;
        Map<String, Long> r3 = this.a;
        ConcurrentHashMap r4 = (ConcurrentHashMap) r3;
        r4.put(r2, Long.valueOf(r6));
    L10:
        r1 = r1 + 1;
        goto L6
    L15:
        return;
    }

    public final void g(String r10, int r11, int r12) {
        String r6 = r10.concat("_recent");
        Long r0 = (Long) ((ConcurrentHashMap) this.a).get(r6);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.longValue() <= 0) goto L12;
        long r2 = SystemClock.uptimeMillis() - r0.longValue();
        if (r2 > 0) goto L9;
        return;
    L9:
        f(r10, r2, r11, r12);
        ((ConcurrentHashMap) this.a).put(r6, 0L);
        return;
    }

    public final void e(int r10, String r11, String r12, String r13) {
        Boolean r0 = (Boolean) ((ConcurrentHashMap) this.b).get(r13);
        if (r0 != null) goto L5;
    L7:
        Long r1 = (Long) ((ConcurrentHashMap) this.a).get(r13);
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.longValue() <= 0) goto L66;
        long r2 = SystemClock.uptimeMillis() - r1.longValue();
        if (r2 > 0) goto L15;
        return;
    L15:
        if (this.d == null) goto L24;
        sbb.e r3 = sbb.e.d(this.d.getType());
        if (r3.b != 12) goto L22;
        if ("photo".equalsIgnoreCase(this.d.c) == false) goto L22;
        String r4 = ExportShareModel.EXPORT_SHARE_TYPE_IMAGE;
    L26:
        if (this.d == null) goto L36;
        RecentSort r5 = RecentSort.getSort(this.d.e);
        if (r5 != RecentSort.MODIFIED) goto L31;
        String r6 = "Latest_modified_time";
    L37:
        boolean r7 = this.e;
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L54
        r8.put("result_code", String.valueOf(r10));     // Catch: Exception -> L54
        r8.put("fail_code", r11);     // Catch: Exception -> L54
        r8.put("cost_time", r2);     // Catch: Exception -> L54
        r8.put("list_type", "recent");     // Catch: Exception -> L54
        r8.put("filter_type1", r4);     // Catch: Exception -> L54
        r8.put("sort_type", r6);     // Catch: Exception -> L54
        r8.put("view_mode", r7 ? 1 : 0);     // Catch: Exception -> L54
        r8.put("user_operation_source", 0);     // Catch: Exception -> L54
        if (this.f == false) goto L41;
        int r14 = 1;
    L42:
        r8.put("has_cache", r14);     // Catch: Exception -> L54
        r8.put("select_tab", r12);     // Catch: Exception -> L54
        if (qc5.a.h() == false) goto L45;
        String r15 = "new_format";
    L46:
        r8.put("space_version", r15);     // Catch: Exception -> L54
        Iterator r16 = ((ConcurrentHashMap) this.c).entrySet().iterator();     // Catch: Exception -> L54
    L48:
        if (r16.hasNext() == false) goto L52;
        Map.Entry r17 = (Map.Entry) r16.next();     // Catch: Exception -> L54
        String r18 = (String) r17.getKey();     // Catch: Exception -> L54
        Long r19 = (Long) r17.getValue();     // Catch: Exception -> L54
        if (TextUtils.isEmpty(r18) == true) goto L48;
        r8.put(r18, r19);     // Catch: Exception -> L54
        goto L48
    L52:
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).a("dev_performance_space_open_finish", r8);     // Catch: Exception -> L54
        tt5.a.b("SpaceReport", "reportOpenFinish()...param = " + r8.toString());     // Catch: Exception -> L54
    L56:
        ((ConcurrentHashMap) this.b).put(r13, Boolean.TRUE);
        return;
    L45:
        r15 = "original";
        goto L46
    L41:
        r14 = 0;
    L54:
        e = move-exception;
        tt5.a.f("SpaceReport", e, false);
        goto L56
    L31:
        if (r5 != RecentSort.CREATED) goto L34;
        r6 = "Latest_created";
        goto L37
    L34:
        if (r5 != RecentSort.OPENED) goto L36;
        r6 = "Latest_open_time";
    L36:
        r6 = "All_time";
    L22:
        if (r3.b == sbb.e.e.b) goto L24;
        r4 = r3.getType();
    L24:
        r4 = "all";
        goto L26
    L66:
        return;
    L5:
        if (r0.booleanValue() == false) goto L7;
    }

    public final void f(String r7, long r8, int r10, int r11) {
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L9
        r4.put("stage", r7);     // Catch: Exception -> L9
        r4.put("list_type", "recent");     // Catch: Exception -> L9
        r4.put("cost_time", r8);     // Catch: Exception -> L9
        r4.put("result_code", r10);     // Catch: Exception -> L9
        if (this.e == false) goto L6;
        int r9 = 1;
    L7:
        r4.put("view_mode", r9);     // Catch: Exception -> L9
        r4.put("data_size", r11);     // Catch: Exception -> L9
        r4.put("user_operation_source", 0);     // Catch: Exception -> L9
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).a("dev_performance_space_open_stages", r4);     // Catch: Exception -> L9
        tt5.a.b("SpaceReport", "reportStage()...param = " + r4.toString());     // Catch: Exception -> L9
        return;
    L6:
        r9 = 0;
    L9:
        e = move-exception;
        tt5.a.f("SpaceReport", e, false);
    }
}
