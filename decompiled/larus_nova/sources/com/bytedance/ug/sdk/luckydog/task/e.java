package com.bytedance.ug.sdk.luckydog.task;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.ug.sdk.luckydog.api.model.SchemaAckType;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api.ILuckyDogSettingsService;
import com.bytedance.ug.sdk.luckydog.task.pendant.LuckyDogPendantManager;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f271887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f271888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f271889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile int f271890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile int f271891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Set<String> f271892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f271893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Map<String, Integer> f271894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Gson f271895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f271896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public tk7.g f271897k;

    public class a extends TypeToken<HashMap<String, Integer>> {
        public a() {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f271898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f271899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f271900c;

        public final void a() {
            int r100 = this.f271900c.f271887a.get();     // Catch: Throwable -> L39
            int r101 = this.f271900c.f271888b.get();     // Catch: Throwable -> L39
            HashMap r102 = new HashMap(this.f271900c.f271894h);     // Catch: Throwable -> L39
            this.f271898a.put("timestamp", hl7.b.b().a());     // Catch: Throwable -> L39
            this.f271898a.put("usage_time", r100);     // Catch: Throwable -> L39
            this.f271898a.put("read_time", r101);     // Catch: Throwable -> L39
            e.b(this.f271900c, r102, this.f271898a);     // Catch: Throwable -> L39
            this.f271898a.put("cross_tokens", n.a(this.f271900c.f271892f));     // Catch: Throwable -> L39
            this.f271898a.put("luckydog_target_app_version", il7.h.b(rk7.m.f538361o.e()));     // Catch: Throwable -> L39
            String r103 = this.f271898a.toString();     // Catch: Throwable -> L39
            com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateTimerManager", "uploadTime(), request: " + r103);     // Catch: Throwable -> L39
            if (TextUtils.isEmpty(r103) == false) goto L6;
            r103 = "";
        L6:
            String r104 = (String) uk7.n.d("https://polaris.zijieapi.com/luckycat/crossover/v:version/ack_time/", r103.getBytes(XML.CHARSET_UTF8)).body();     // Catch: Throwable -> L39
            if (TextUtils.isEmpty(r104) == true) goto L24;
            JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L39
            if (uk7.i.c(r105) == true) goto L56;
        L25:
            boolean r106 = false;
        L26:
            if (r105 != null) goto L52;
        L31:
            JSONObject r107 = this.f271898a;     // Catch: Throwable -> L37
            if (r106 == false) goto L34;
            int r108 = 1;
        L35:
            r107.put("success", r108);     // Catch: Throwable -> L37
            com.bytedance.ug.sdk.luckydog.api.log.b.a("upload_time_result", this.f271898a);     // Catch: Throwable -> L37
            com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateTimerManager", "uploadTime(), result: " + this.f271898a);     // Catch: Throwable -> L37
        L47:
            if (r106 == true) goto L49;
            this.f271900c.f271893g++;
        L50:
            e r109 = this.f271900c;
            r109.getClass();
            il7.m.b("luckydog_task_union.prefs").i("key_request_fail_count", r109.f271893g);
            this.f271900c.f271889c = false;
            return;
        L49:
            this.f271900c.f271893g = 0;
        L37:
            th = move-exception;
            boolean r110 = r106;
            th = th;
        L41:
            com.bytedance.ug.sdk.luckydog.api.log.d.b("AppActivateTimerManager", th.getMessage());
            this.f271898a.put("success", -1);     // Catch: JSONException -> L44
            this.f271898a.put("catch_error", th.getMessage());     // Catch: JSONException -> L44
            this.f271898a.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, th.toString());     // Catch: JSONException -> L44
        L46:
            com.bytedance.ug.sdk.luckydog.api.log.b.a("upload_time_result", this.f271898a);
            r106 = r110;
        L44:
            e = move-exception;
            com.bytedance.ug.sdk.luckydog.api.log.d.b("AppActivateTimerManager", e.getMessage());
            goto L46
        L34:
            r108 = 0;
            goto L35
        L52:
            Iterator<String> r111 = r105.keys();     // Catch: Throwable -> L37
        L29:
            if (r111.hasNext() == false) goto L31;
            String r112 = r111.next();     // Catch: Throwable -> L37
            this.f271898a.put(r112, r105.opt(r112));     // Catch: Throwable -> L37
            goto L29
        L56:
            e.c(this.f271900c, r100, r101, r102);     // Catch: Throwable -> L22
            this.f271900c.f();     // Catch: Throwable -> L22
            JSONObject r113 = r105.optJSONObject("data");     // Catch: Throwable -> L22
            if (r113 == null) goto L20;
            int r114 = r113.optInt("usage_interval", 60);     // Catch: Throwable -> L22
            int r115 = r113.optInt("read_interval", 30);     // Catch: Throwable -> L22
            if (r114 <= 0) goto L15;
            this.f271900c.f271890d = r114;     // Catch: Throwable -> L22
        L15:
            if (r115 <= 0) goto L17;
            this.f271900c.f271891e = r115;     // Catch: Throwable -> L22
        L17:
            this.f271900c.e(r113.optJSONArray("expired_cross_tokens"));     // Catch: Throwable -> L22
            if (this.f271899b == false) goto L20;
            cl7.c.f24113l.a(r113, this.f271900c.f271897k);     // Catch: Throwable -> L22
        L20:
            e.a(this.f271900c, r113);     // Catch: Throwable -> L22
            r106 = true;
        L22:
            th = th;
            r110 = true;
            goto L41
        L24:
            r105 = null;
        L39:
            th = th;
            r110 = false;
            goto L41
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

        public b(e r100, JSONObject r101, boolean r102) {
            this.f271900c = r100;
            this.f271898a = r101;
            this.f271899b = r102;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f271901a = null;

        static {
            f271901a = new e();
        }
    }

    public final void f() {
        Handler r100 = n.f271932a;
        long r101 = hl7.b.b().a();
        String r102 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(r101));
        il7.m.b("luckydog_task_union.prefs").k("key_save_date", r102);
        il7.m.b("luckydog_task_union.prefs").i("key_usage_time", this.f271887a.get());
        il7.m.b("luckydog_task_union.prefs").i("key_read_time", this.f271888b.get());
        il7.m.b("luckydog_task_union.prefs").k("key_scene_time", GsonProtectorUtils.toJson(this.f271895i, this.f271894h));     // Catch: JsonIOException -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("AppActivateTimerManager", e.getMessage());
    }

    public e() {
        AtomicInteger r100 = new AtomicInteger(0);
        this.f271887a = r100;
        AtomicInteger r101 = new AtomicInteger(0);
        this.f271888b = r101;
        this.f271890d = 60;
        this.f271891e = 30;
        this.f271892f = new HashSet();
        this.f271894h = new ConcurrentHashMap();
        this.f271895i = new Gson();
        com.bytedance.ug.sdk.luckydog.api.log.d.a("AppActivateTimerManager", "AppActivateTimerManager() on call");
        Handler r102 = n.f271932a;
        long r103 = hl7.b.b().a();
        String r104 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(r103));
        if (TextUtils.isEmpty(r104) == false) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L16;
        r100.set(il7.m.b("luckydog_task_union.prefs").c("key_usage_time", 0));
        r101.set(il7.m.b("luckydog_task_union.prefs").c("key_read_time", 0));
        this.f271893g = il7.m.b("luckydog_task_union.prefs").c("key_request_fail_count", 0);
        this.f271894h = (Map) this.f271895i.fromJson(il7.m.b("luckydog_task_union.prefs").e("key_scene_time", SliceInitService.DEFAULT_SWITCH), new a().getType());     // Catch: Exception -> L14
        if (this.f271894h != null) goto L16;
        this.f271894h = new HashMap();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("AppActivateTimerManager", e.getMessage());
    L16:
        this.f271892f = n.b();
        return;
    L5:
        if (r104.equals(il7.m.b("luckydog_task_union.prefs").e("key_save_date", "")) == false) goto L7;
        r105 = true;
        goto L8
    }

    public final synchronized void d(boolean r100) {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.a("AppActivateTimerManager", "checkUpload(), checkInterval = " + r100 + "mHadUsageDurationSec = " + this.f271887a + "mHadReadDurationSec = " + this.f271888b);     // Catch: Throwable -> L18
        if (this.f271889c == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (r100 == true) goto L12;
        h(false);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L12:
        if (this.f271887a.get() < (this.f271890d * (this.f271893g + 1))) goto L14;
    L15:
        h(false);     // Catch: Throwable -> L18
        goto L16
    L14:
        if (this.f271888b.get() < (this.f271891e * (this.f271893g + 1))) goto L16;
    L18:
        th = move-exception;
        throw th;
    }

    public final void e(JSONArray r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length() <= 0) goto L31;
        HashSet r101 = new HashSet();
        int r102 = 0;
    L23:
    L13:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r101.size() <= 0) goto L30;
        Iterator r103 = r101.iterator();
    L19:
        if (r103.hasNext() == false) goto L21;
        String r104 = (String) r103.next();
        this.f271892f.remove(r104);
        goto L19
    L21:
        n.c(this.f271892f);
        return;
    L30:
        return;
    L8:
        if (r102 >= r100.length()) goto L16;
        String r105 = r100.get(r102).toString();     // Catch: JSONException -> L13
        if (TextUtils.isEmpty(r105) == true) goto L12;
        r101.add(r105);     // Catch: JSONException -> L13
    L12:
        r102 = r102 + 1;
        goto L23
    }

    public final void h(boolean r100) {
        if (bl7.d.a() == false) goto L12;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateTimerManager", "uploadTime() 为新的逻辑，这里return");
        JSONObject r101 = new JSONObject();
        r101.put("err_code", 100);     // Catch: JSONException -> L7
        r101.put(LocationMonitorConst.ERR_MSG, "uploadTime");     // Catch: JSONException -> L7
    L9:
        com.bytedance.ug.sdk.luckydog.api.log.b.a("ug_sdk_luckydog_new_timer_error", r101);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L12:
        if (n.f271933b == false) goto L14;
        this.f271892f = n.b();
    L14:
        JSONArray r102 = n.a(this.f271892f);
        int r103 = 0;
        boolean r104 = false;
    L16:
        if (r103 >= r102.length()) goto L24;
        String r105 = JSONArrayProtectorUtils.getString(r102, r103);     // Catch: JSONException -> L21
        if ("ack_count_type".equals(il7.m.a().e(r105, "ack_time_type")) == false) goto L23;
        this.f271892f.remove(r105);     // Catch: JSONException -> L21
        r104 = true;
    L23:
        r103 = r103 + 1;
    L21:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("AppActivateTimerManager", e.getMessage());
        goto L23
    L24:
        tk7.g r106 = this.f271897k;
        if (r106 != null) goto L27;
    L28:
        if (r104 == false) goto L30;
    L29:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("AppActivateTimerManager", "uploadTime() 为计次逻辑");
    L30:
        this.f271889c = true;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("AppActivateTimerManager", "uploadTime() called");
        JSONObject r107 = new JSONObject();
        Application r108 = rk7.m.f538347a;
        rk7.m.d(new b(this, r107, r100));
        return;
    L27:
        if (r106.f546565d == SchemaAckType.ACK_COUNT) goto L29;
        goto L28
    }

    public static void a(e r100, JSONObject r110) {
        if (r110 != null) goto L4;
        r100.getClass();
        return;
    L4:
        Set<String> r101 = r100.f271892f;
        Handler r102 = n.f271932a;
        if (r101 != null) goto L7;
    L11:
        String r103 = "";
    L13:
        if (TextUtils.isEmpty(r103) == false) goto L21;
        LuckyDogPendantManager r104 = LuckyDogPendantManager.f272193p;
        if (r104.o() == false) goto L21;
        r104.d();
        com.bytedance.ug.sdk.luckydog.api.log.d.a("AppActivateTimerManager", "updatePendantState crossTokenStr isEmpty");
        Context r105 = rk7.m.f538361o.e();
        if (r105 == null) goto L21;
        if (to7.c.c() == false) goto L21;
        il7.o.a(r105, r105.getString(R.string.luckydog_pendant_timer_expired));
    L21:
        LuckyDogPendantManager r106 = LuckyDogPendantManager.f272193p;
        r106.getClass();
        Integer r107 = null;
        if (LuckyDogPendantManager.p(r103) == true) goto L63;
        int r108 = dl7.f.f469134d;
        String r109 = r100.f271896j;
        JSONObject r111 = r110.optJSONObject("timer_component");
        Gson r112 = new Gson();
        if (r111 == null) goto L26;
        String r113 = r111.toString();
    L27:
        dl7.f r114 = (dl7.f) GsonProtectorUtils.fromJson(r112, r113, dl7.f.class);
        if (r114 == null) goto L34;
        r114.f469136b = r103;
        r114.f469137c = r109;
        JSONArray r115 = r110.optJSONArray("sceneId");
        if (r115 == null) goto L32;
        String r116 = JSONArrayProtectorUtils.getString(r115, 0);
    L33:
        r114.f469135a = r116;
        goto L34
    L32:
        r116 = null;
    L34:
        if (r114 == null) goto L63;
        if (LuckyDogPendantManager.f272182e == true) goto L41;
        LuckyDogPendantManager.f272182e = true;
        if (LuckyDogPendantManager.f272186i == false) goto L41;
        LuckyDogPendantManager.f272186i = false;
        r106.a(LuckyDogPendantManager.f272187j, LuckyDogPendantManager.f272188k);
    L41:
        if (LuckyDogPendantManager.p(r114.f469136b) == false) goto L43;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantManager", "initPendant isInit");
        goto L63
    L43:
        r106.d();
        if ((!Intrinsics.areEqual(r114.g(), Boolean.TRUE)) == false) goto L46;
    L61:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantManager", "initPendant enable = " + r114.g() + ", leftTs = " + (r114.o() - r114.a()));
        LuckyDogPendantManager.f272182e = false;
        goto L63
    L46:
        if (r114.a() >= r114.o()) goto L61;
        LuckyDogPendantManager.f272178a = r114;
        LuckyDogPendantManager.b r117 = LuckyDogPendantManager.f272181d;
        if (r117 == null) goto L51;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantManager", "initPendant pendingShowPendantRunnable");
        LuckyDogPendantManager.f272180c.post(r117);
    L51:
        LuckyDogPendantManager.f272181d = null;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantManager", "tryInit() LuckyDogPendantManager called; 触发内部init方法执行");
        wm7.g.b(ym7.d.class, LuckyDogPendantManager.f272185h);
        ym7.d r118 = (ym7.d) wm7.g.a(ym7.d.class);
        if (r118 == null) goto L54;
        r118.a(r106);
    L54:
        LuckyDogPendantManager.f272191n.set(true);
        if (LuckyDogPendantManager.f272190m == false) goto L60;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantManager", "registerPendantExclusionListener reShowPendant");
        ym7.k r119 = LuckyDogPendantManager.f272189l;
        if (r119 == null) goto L59;
        r119.a();
    L59:
        LuckyDogPendantManager.f272190m = false;
        LuckyDogPendantManager.f272189l = null;
    L60:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogPendantManager", "initPendant return");
        goto L63
    L26:
        r113 = null;
    L63:
        if (to7.c.c() == true) goto L75;
        int r120 = dl7.f.f469134d;
        JSONObject r121 = r110.optJSONObject("timer_component");
        if (r121 == null) goto L67;
        r107 = Integer.valueOf(r121.optInt("acked_ts"));
    L67:
        if (r107 == null) goto L69;
        r106.v(r107.intValue());
    L69:
        com.bytedance.ug.sdk.luckydog.api.log.d.a("AppActivateTimerManager", "updatePendantState isAppForeground updatePendantAckedTime " + r107);
        return;
    L75:
        return;
    L7:
        if (r101.isEmpty() == true) goto L11;
        r103 = (String) r101.toArray()[0];     // Catch: Exception -> L71
        goto L13
    }

    public static void b(e r100, Map r110, JSONObject r111) {
        r100.getClass();
        HashMap r112 = (HashMap) r110;     // Catch: JSONException -> L31
        if (r112.isEmpty() == true) goto L47;
        JSONArray r101 = new JSONArray();     // Catch: JSONException -> L31
        ILuckyDogSettingsService r102 = (ILuckyDogSettingsService) fk7.c.b(ILuckyDogSettingsService.class);     // Catch: JSONException -> L31
        List r103 = null;
        if (r102 == null) goto L21;
        Object r104 = r102.getSettingsByKey(ILuckyDogCommonSettingsService.Channel.STATIC, "data.common_info.scene_time_infos");     // Catch: JSONException -> L31
        if ((r104 instanceof JSONArray) == false) goto L21;
        JSONArray r105 = (JSONArray) r104;     // Catch: JSONException -> L31
        int r106 = 0;
    L12:
        if (r106 >= r105.length()) goto L21;
        Object r107 = r105.get(r106);     // Catch: JSONException -> L31
        if ((r107 instanceof JSONObject) == false) goto L20;
        JSONObject r108 = (JSONObject) r107;     // Catch: JSONException -> L31
        int r109 = r108.optInt("app_id");     // Catch: JSONException -> L31
        Application r113 = rk7.m.f538347a;     // Catch: JSONException -> L31
        if (r109 != rk7.m.f()) goto L20;
        JSONArray r114 = r108.optJSONArray(InvRouter.SCENES);     // Catch: JSONException -> L31
        if (r114 == null) goto L20;
        r103 = (List) GsonProtectorUtils.fromJson(r100.f271895i, r114.toString(), new f().getType());     // Catch: JSONException -> L31
        com.bytedance.ug.sdk.luckydog.api.log.d.a("AppActivateTimerManager", "fusion settings replace mark: addScenesParams, scenes " + r103);     // Catch: JSONException -> L31
    L20:
        r106 = r106 + 1;     // Catch: JSONException -> L31
    L21:
        Iterator r115 = r112.keySet().iterator();     // Catch: JSONException -> L31
    L23:
        if (r115.hasNext() == false) goto L29;
        String r116 = (String) r115.next();     // Catch: JSONException -> L31
        if (r103 == null) goto L28;
        if (r103.contains(r116) == false) goto L23;
    L28:
        JSONObject r117 = new JSONObject();     // Catch: JSONException -> L31
        r117.put("scene_id", r116);     // Catch: JSONException -> L31
        r117.put("scene_time", r112.get(r116));     // Catch: JSONException -> L31
        r101.put(r117);     // Catch: JSONException -> L31
        goto L23
    L29:
        r111.put(InvRouter.SCENES, r101);     // Catch: JSONException -> L31
        return;
    L47:
        return;
    L31:
        e = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("AppActivateTimerManager", e.getMessage());
    }

    public static void c(e r100, int r101, int r102, Map r103) {
        r100.f271887a.getAndAdd(r101 * (-1));
        r100.f271888b.getAndAdd(r102 * (-1));
        if (r100.f271888b.get() >= 0) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("AppActivateTimerManager", "clearUploadTime mHadReadDurationSec != null, duration = " + r100.f271888b.get());
        r100.f271888b.set(0);
    L6:
        if (r100.f271887a.get() >= 0) goto L8;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("AppActivateTimerManager", "clearUploadTime mHadUsageDurationSec != null, duration = " + r100.f271887a.get());
        r100.f271887a.set(0);
    L8:
        HashMap r104 = (HashMap) r103;
        Iterator r105 = r104.keySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L30;
        String r106 = (String) r105.next();
        if (TextUtils.isEmpty(r106) == true) goto L10;
        Integer r107 = (Integer) r104.get(r106);
        if (r107 == null) goto L10;
        if (r107.intValue() <= 0) goto L10;
        if (r100.f271894h.containsKey(r106) == false) goto L25;
        Integer r108 = r100.f271894h.get(r106);
        if (r108 == null) goto L25;
        int r109 = r108.intValue();
    L26:
        int r110 = r109 - r107.intValue();
        if (r110 >= 0) goto L29;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("AppActivateTimerManager", "clearUploadTime sceneMap newDuration != null, scene =" + r106 + "duration = " + r110);
        r110 = 0;
    L29:
        r100.f271894h.put(r106, Integer.valueOf(r110));
    L25:
        r109 = 0;
        goto L26
    }

    public final void g(int r100, int r101, Map<String, Integer> r102, boolean r103) {
        this.f271887a.getAndAdd(r100);
        this.f271888b.getAndAdd(r101);
        if (r102 == null) goto L23;
        Iterator<String> r104 = r102.keySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L23;
        String r105 = r104.next();
        if (TextUtils.isEmpty(r105) == true) goto L6;
        Integer r106 = r102.get(r105);
        if (r106 == null) goto L6;
        if (r106.intValue() <= 0) goto L6;
        if (this.f271894h.containsKey(r105) == false) goto L21;
        Integer r107 = this.f271894h.get(r105);
        if (r107 == null) goto L21;
        int r108 = r107.intValue();
    L22:
        this.f271894h.put(r105, Integer.valueOf(r108 + r106.intValue()));
    L21:
        r108 = 0;
    L23:
        if (r103 == false) goto L25;
        f();
    L25:
        d(true);
        LuckyDogPendantManager r109 = LuckyDogPendantManager.f272193p;
        if (r109.o() == false) goto L57;
        dl7.f r110 = LuckyDogPendantManager.f272178a;
        if (r110 == null) goto L31;
        String r111 = r110.f469135a;
    L33:
        if (TextUtils.isEmpty(r111) == true) goto L40;
        if (r102 == null) goto L39;
        Integer r112 = r102.get(r111);
        if (r112 == null) goto L39;
        r101 = r112.intValue();
    L39:
        r101 = 0;
    L40:
        if (r101 == 0) goto L58;
        dl7.f r113 = LuckyDogPendantManager.f272178a;
        if (r113 == null) goto L45;
        int r114 = r113.a();
    L46:
        r109.v(r114 + r101);
        return;
    L45:
        r114 = -1;
        goto L46
    L58:
        return;
    L31:
        r111 = null;
        goto L33
    }
}
