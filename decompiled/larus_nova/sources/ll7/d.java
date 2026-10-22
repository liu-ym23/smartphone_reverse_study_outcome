package ll7;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.LuckyDogLocalSettings;
import com.bytedance.ug.sdk.luckydog.api.window.LuckyDialogConstants$PopupStatus;
import com.google.gson.Gson;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rk7.m;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b f509678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f509679b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f509680c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f509681d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f509682e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CopyOnWriteArrayList<JSONObject> f509683f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CopyOnWriteArrayList<JSONObject> f509684g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CopyOnWriteArrayList<JSONObject> f509685h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CopyOnWriteArrayList<JSONObject> f509686i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static ConcurrentSkipListSet<f> f509687j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicBoolean f509688k = null;

    public static final class a implements com.bytedance.ug.sdk.luckydog.api.sidechaintracker.a {

        /* JADX INFO: renamed from: ll7.d$a$a, reason: collision with other inner class name */
        public static final class RunnableC6708a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f509689a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ JSONObject f509690b;

            public RunnableC6708a(String r100, JSONObject r101) {
                this.f509689a = r100;
                this.f509690b = r101;
            }

            public final void a() {
                com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b r100 = d.f509678a;
                String r101 = this.f509689a;
                JSONObject r102 = this.f509690b;
                com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "createEventData call");
                JSONObject r110 = new JSONObject();
                JSONObject r111 = r102.optJSONObject("tracker_data");     // Catch: Throwable -> L23
                if (r111 != null) goto L7;
                r111 = new JSONObject();     // Catch: Throwable -> L23
            L7:
                JSONObject r112 = r102.optJSONObject("reason_map");     // Catch: Throwable -> L23
                if (r112 != null) goto L11;
                r112 = new JSONObject();     // Catch: Throwable -> L23
            L11:
                JSONObject r103 = r102.optJSONObject("extra_data");     // Catch: Throwable -> L23
                if (r103 != null) goto L15;
                r103 = new JSONObject();     // Catch: Throwable -> L23
            L15:
                int r104 = 0;
                if (r111.optBoolean(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, false) == false) goto L35;
                r104 = 1;
            L35:
                r110.put("pop_id", r101);     // Catch: Throwable -> L21
                r110.put("pop_key", r111.optString("pop_key"));     // Catch: Throwable -> L21
                r110.put("pop_name", r111.optString("pop_name"));     // Catch: Throwable -> L21
                r110.put("enter_from", r111.optString("enter_from"));     // Catch: Throwable -> L21
                r110.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, r104);     // Catch: Throwable -> L21
                r110.put("reason_map", r112.toString());     // Catch: Throwable -> L21
                r110.put("success", r112.optInt("success", 0));     // Catch: Throwable -> L21
                r110.put("abnormal", r112.optInt("abnormal_untracked", 0));     // Catch: Throwable -> L21
                r110.put("receive_count", r103.optInt("receive_count", 0));     // Catch: Throwable -> L21
                r110.put("event_receive_time_ms", r103.optLong("event_receive_time_ms", 0));     // Catch: Throwable -> L21
                r110.put("event_end_time_ms", r103.optLong("event_end_time_ms", 0));     // Catch: Throwable -> L21
                r110.put("pop_status", r103.optString("status", ""));     // Catch: Throwable -> L21
                String r105 = "LuckyDogDialogTracker";
            L26:
                com.bytedance.ug.sdk.luckydog.api.log.d.d(r105, "createEventData finish");
                com.bytedance.ug.sdk.luckydog.api.log.b.a("luckydog_pop_track", r110);     // Catch: Exception -> L29
            L31:
                com.bytedance.ug.sdk.luckydog.api.log.d.d(r105, "send track event");
                return;
            L29:
                e = move-exception;
                com.bytedance.ug.sdk.luckydog.api.log.d.c("popupTrackEvent", e.getLocalizedMessage(), e);
            L21:
                th = th;
            L25:
                r105 = r17;
                com.bytedance.ug.sdk.luckydog.api.log.d.b(r105, "createEventData e = " + th);
            L23:
                th = th;
                String r113 = "LuckyDogDialogTracker";
                goto L25
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
        }

        public a() {
        }

        @Override // com.bytedance.ug.sdk.luckydog.api.sidechaintracker.a
        public final void a(String r100, JSONObject r101) {
            Application r102 = m.f538347a;
            m.d(new RunnableC6708a(r100, r101));
        }
    }

    @JvmStatic
    public static final ConcurrentSkipListSet<f> d() {
        LuckyDogLocalSettings r100 = com.bytedance.ug.sdk.luckydog.api.settings.h.a();     // Catch: Throwable -> L19
        if (r100 == null) goto L6;
        LinkedHashSet<String> r101 = r100.getPopupSet();     // Catch: Throwable -> L19
    L7:
        if (r101 != null) goto L9;
    L18:
        return null;
    L9:
        if ((!r101.isEmpty()) == false) goto L18;
        ConcurrentSkipListSet<f> r102 = new ConcurrentSkipListSet();     // Catch: Throwable -> L19
        Iterator<T> r103 = r101.iterator();     // Catch: Throwable -> L19
    L11:
        if (r103.hasNext() == false) goto L17;
        f r104 = (f) new Gson().fromJson((String) r103.next(), f.class);     // Catch: Throwable -> L19
        if (r104 == null) goto L11;
        r102.add(r104);     // Catch: Throwable -> L19
        goto L11
    L17:
        return r102;
    L6:
        r101 = null;
    L19:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "getPopupSet meet throwable, " + th);
        return null;
    }

    static {
        f509679b = new AtomicBoolean(false);
        f509680c = new AtomicBoolean(false);
        f509681d = new AtomicBoolean(false);
        f509682e = new AtomicBoolean(false);
        f509683f = new CopyOnWriteArrayList();
        f509684g = new CopyOnWriteArrayList();
        f509685h = new CopyOnWriteArrayList();
        f509686i = new CopyOnWriteArrayList();
        f509688k = new AtomicBoolean(false);
    }

    public static void a() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "afterUpdate call");
        CopyOnWriteArrayList<JSONObject> r100 = f509683f;
        if (r100.isEmpty() == true) goto L8;
        Iterator<JSONObject> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        JSONObject r102 = r101.next();
        h(r102.optLong("popup_id", 0), r102.optString("pop_name"), r102.optString("pop_key"), r102.optString("enter_from"), r102.optBoolean(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE));
    L8:
        f509683f.clear();
        CopyOnWriteArrayList<JSONObject> r103 = f509686i;
        if (r103.isEmpty() == true) goto L14;
        Iterator<JSONObject> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        JSONObject r105 = r104.next();
        j(r105.optLong("popup_id", 0), r105.optString("status"));
    L14:
        f509686i.clear();
        CopyOnWriteArrayList<JSONObject> r106 = f509684g;
        if (r106.isEmpty() == true) goto L20;
        Iterator<JSONObject> r107 = r106.iterator();
    L18:
        if (r107.hasNext() == false) goto L20;
        JSONObject r108 = r107.next();
        i(r108.optLong("popup_id", 0), r108.optString("pop_name"), r108.optString("pop_key"), r108.optString("enter_from"), r108.optBoolean(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE), r108.optString("popup_reason"));
    L20:
        f509684g.clear();
        CopyOnWriteArrayList<JSONObject> r109 = f509685h;
        if (r109.isEmpty() == true) goto L26;
        Iterator<JSONObject> r110 = r109.iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        JSONObject r111 = r110.next();
        g(r111.optLong("popup_id", 0), r111.optString("pop_name"), r111.optString("pop_key"), r111.optString("enter_from"), r111.optBoolean(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE), r111.optString("popup_reason"));
    L26:
        f509685h.clear();
    }

    @JvmStatic
    public static final synchronized void f() {
        monitor-enter(d.class);
        AtomicBoolean r100 = f509688k;     // Catch: Throwable -> L28
        if (r100.get() == true) goto L8;
        r100.set(true);     // Catch: Throwable -> L28
        f509687j = d();     // Catch: Throwable -> L28
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "update popup model");     // Catch: Throwable -> L28
    L8:
        if (f509681d.get() == true) goto L12;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "未获取开关数据，等待数据更新");     // Catch: Throwable -> L28
        f509682e.set(true);     // Catch: Throwable -> L28
        monitor-exit(d.class);
        return;
    L12:
        f509682e.set(false);     // Catch: Throwable -> L28
        if (f509680c.get() == true) goto L20;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "开关关闭，无法进行全链路埋点上报");     // Catch: Throwable -> L28
        f509679b.set(true);     // Catch: Throwable -> L28
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "release 释放资源");     // Catch: Throwable -> L28
        f509678a = null;     // Catch: Throwable -> L28
        ConcurrentSkipListSet<f> r101 = f509687j;     // Catch: Throwable -> L28
        if (r101 == null) goto L17;
        r101.clear();     // Catch: Throwable -> L28
    L17:
        f509683f.clear();     // Catch: Throwable -> L28
        f509684g.clear();     // Catch: Throwable -> L28
        f509685h.clear();     // Catch: Throwable -> L28
        f509686i.clear();     // Catch: Throwable -> L28
        monitor-exit(d.class);
        return;
    L20:
        AtomicBoolean r102 = f509679b;     // Catch: Throwable -> L28
        if (r102.get() == false) goto L25;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "already init");     // Catch: Throwable -> L28
        monitor-exit(d.class);
        return;
    L25:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "init call");     // Catch: Throwable -> L28
        f509678a = new com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b(new a());     // Catch: Throwable -> L28
        update();     // Catch: Throwable -> L28
        a();     // Catch: Throwable -> L28
        r102.set(true);     // Catch: Throwable -> L28
        monitor-exit(d.class);
        return;
    L28:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    private static final void update() {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "update");
        ConcurrentSkipListSet<f> r100 = f509687j;
        boolean r101 = false;
        if (r100 == null) goto L14;
        Iterator<f> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        f r103 = r102.next();
        com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b r104 = f509678a;
        if (r104 == null) goto L6;
        String r105 = String.valueOf(r103.d());
        String r106 = r103.g();
        String r107 = r103.e();
        String r108 = r103.f509704a;
        if (r103.c() != 1) goto L12;
        boolean r109 = true;
    L13:
        r104.a(r105, e(r106, r107, r108, r109));
        goto L6
    L12:
        r109 = false;
    L14:
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h r110 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;
        ILuckyDogCommonSettingsService.Channel r111 = ILuckyDogCommonSettingsService.Channel.DYNAMIC;
        xk7.e r112 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(r111);
        if (r112 == null) goto L17;
        g r113 = (g) r112.k("data.common_info", g.class);
    L18:
        xk7.e r114 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(r111);
        if (r114 == null) goto L21;
        Integer r115 = Integer.valueOf(r114.i(r114.f564223c));
    L22:
        StringBuilder r116 = new StringBuilder("rainPopupModel = null ? ");
        if (r113 != null) goto L25;
        r101 = true;
    L25:
        r116.append(r101);
        r116.append(" version = ");
        r116.append(r115);
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", r116.toString());
        if (r113 == null) goto L35;
        List<f> r117 = r113.a();
        if (r117 == null) goto L35;
        Iterator<T> r118 = r117.iterator();
    L31:
        if (r118.hasNext() == false) goto L35;
        f r119 = (f) r118.next();
        com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b r120 = f509678a;
        if (r120 == null) goto L31;
        r120.a(String.valueOf(r119.d()), null);
    L35:
        LuckyDogLocalSettings r121 = com.bytedance.ug.sdk.luckydog.api.settings.h.a();
        String r122 = il7.m.b("activity_local.sp").e("key_cold_pop_data", "");
        if (r121 == null) goto L63;
        r122 = r121.getColdPopData();
    L63:
    L43:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogDialogTracker", "getColdPopModel err = " + th);
    L45:
        f r123 = null;
    L46:
        if (r123 == null) goto L50;
        com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b r124 = f509678a;
        if (r124 == null) goto L50;
        r124.a(String.valueOf(r123.d()), null);
    L50:
        com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b r125 = f509678a;
        if (r125 == null) goto L62;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r125.f271663e, "onActivateCachedTrackedObjectEnd call");
        Iterator<Map.Entry<String, JSONObject>> r126 = r125.f271659a.entrySet().iterator();
    L54:
        if (r126.hasNext() == false) goto L80;
        Map.Entry<String, JSONObject> r127 = r126.next();
        if (r125.f271660b.contains(r127.getKey()) == true) goto L54;
        JSONObject r128 = r127.getValue().optJSONObject("extra_data");
        if (r128 != null) goto L61;
        r128 = new JSONObject();
    L61:
        r128.put("event_end_time_ms", hl7.b.b().a());
        r127.getValue().put("extra_data", r128);
        com.bytedance.ug.sdk.luckydog.api.sidechaintracker.a r129 = r125.f271664f;
        String r130 = r127.getKey();
        JSONObject r131 = r127.getValue();
        r125.c(r131, "untracked");
        r129.a(r130, r131);
        r126.remove();
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r125.f271663e, "stopTrackingObject remove " + r127.getKey());
        goto L54
    L80:
        return;
    L62:
        return;
    L39:
        if (TextUtils.isEmpty(r122) == true) goto L45;
        r123 = (f) new Gson().fromJson(r122, f.class);     // Catch: Throwable -> L43
        goto L46
    L21:
        r115 = null;
        goto L22
    L17:
        r113 = null;
        goto L18
    }

    @JvmStatic
    public static final synchronized void k() {
        monitor-enter(d.class);
        AtomicBoolean r100 = f509680c;     // Catch: Throwable -> L15
        com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.h r101 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.f271628a;     // Catch: Throwable -> L15
        xk7.e r102 = com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.impl.b.b(ILuckyDogCommonSettingsService.Channel.STATIC);     // Catch: Throwable -> L15
        if (r102 == null) goto L9;
        Boolean r103 = (Boolean) r102.k("data.common_info.extra.lucky_sidechain_tracker.enable_dialog_tracker", Boolean.TYPE);     // Catch: Throwable -> L15
        if (r103 == null) goto L9;
        boolean r104 = r103.booleanValue();     // Catch: Throwable -> L15
    L10:
        r100.set(r104);     // Catch: Throwable -> L15
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "updateSettings switch = " + r100.get());     // Catch: Throwable -> L15
        f509681d.set(true);     // Catch: Throwable -> L15
        if (f509682e.get() == false) goto L13;
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "pending init");     // Catch: Throwable -> L15
        f();     // Catch: Throwable -> L15
    L13:
        monitor-exit(d.class);
        return;
    L9:
        r104 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public static boolean b(String r100, String r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b r103 = f509678a;
        if (r103 == null) goto L30;
        monitor-enter(r103);
        ConcurrentHashMap<String, JSONObject> r104 = r103.f271659a;     // Catch: Throwable -> L27
        if (r104 == null) goto L25;
        JSONObject r105 = r104.get(r100);     // Catch: Throwable -> L27
        if (r105 == null) goto L25;
        JSONObject r106 = r105.optJSONObject("extra_data");     // Catch: Throwable -> L27
        if (r106 != null) goto L22;
        r106 = new JSONObject();     // Catch: Throwable -> L27
    L22:
        String r107 = r106.optString("status");     // Catch: Throwable -> L27
        monitor-exit(r103);
    L31:
        if (r107 != null) goto L33;
    L36:
        boolean r108 = true;
    L37:
        if (r108 == false) goto L40;
        return true;
    L40:
        if (Intrinsics.areEqual(r101, r107) == false) goto L42;
        return false;
    L42:
        LuckyDialogConstants$PopupStatus r109 = LuckyDialogConstants$PopupStatus.ENQUEUE;
        if (Intrinsics.areEqual(r107, r109.getStatus()) == false) goto L48;
        if (Intrinsics.areEqual(r101, LuckyDialogConstants$PopupStatus.RECEIVE.getStatus()) == false) goto L57;
        return false;
    L57:
        return true;
    L48:
        if (Intrinsics.areEqual(r107, LuckyDialogConstants$PopupStatus.DEQUEUE.getStatus()) == false) goto L55;
        if (Intrinsics.areEqual(r101, LuckyDialogConstants$PopupStatus.RECEIVE.getStatus()) == false) goto L52;
    L53:
        return false;
    L52:
        if (Intrinsics.areEqual(r101, r109.getStatus()) == false) goto L57;
    L55:
        if (Intrinsics.areEqual(r107, LuckyDialogConstants$PopupStatus.SHOW.getStatus()) == false) goto L57;
        return false;
    L33:
        if (r107.length() == 0) goto L36;
        r108 = false;
    L25:
        monitor-exit(r103);
    L27:
        th = move-exception;
        throw th;
    L30:
        r107 = null;
        goto L31
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @JvmStatic
    public static final synchronized void j(long r110, String r111) {
        monitor-enter(d.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f509679b.get() == true) goto L7;
        f509686i.add(c(r110, null, null, null, false, null, r111));     // Catch: Throwable -> L14
    L7:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "updateObjectStatus status = " + r111);     // Catch: Throwable -> L14
        if (b(String.valueOf(r110), r111) == false) goto L12;
        com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b r100 = f509678a;     // Catch: Throwable -> L14
        if (r100 == null) goto L12;
        r100.d(String.valueOf(r110), r111);     // Catch: Throwable -> L14
    L12:
        monitor-exit(d.class);
    }

    public static JSONObject e(String r100, String r101, String r102, boolean r103) {
        JSONObject r104 = new JSONObject();
        r104.put("pop_name", r100);     // Catch: Throwable -> L5
        r104.put("pop_key", r101);     // Catch: Throwable -> L5
        r104.put("enter_from", r102);     // Catch: Throwable -> L5
        r104.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, r103);     // Catch: Throwable -> L5
    L7:
        return r104;
    L5:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogDialogTracker", "getTrackData e = " + th);
        goto L7
    }

    @JvmStatic
    public static final void h(long r100, String r110, String r111, String r112, boolean r113) {
        if (f509679b.get() == true) goto L5;
        f509683f.add(c(r100, r110, r111, r112, r113, null, null));
    L5:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "trackNewObject");
        com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b r101 = f509678a;
        if (r101 == null) goto L22;
        String r102 = String.valueOf(r100);
        JSONObject r114 = e(r110, r111, r112, r113);
        JSONObject r115 = r101.f271659a.get(r102);
        if (r115 != null) goto L10;
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L17
        r116.put("receive_count", 1);     // Catch: Throwable -> L17
        r116.put("event_receive_time_ms", hl7.b.b().a());     // Catch: Throwable -> L17
        r115 = r101.b(r102, r114, new JSONObject(), r116);     // Catch: Throwable -> L17
    L15:
        r101.f271659a.put(r102, r115);     // Catch: Throwable -> L17
        return;
    L10:
        JSONObject r117 = r115.optJSONObject("extra_data");     // Catch: Throwable -> L17
        if (r117 != null) goto L14;
        r117 = new JSONObject();     // Catch: Throwable -> L17
    L14:
        r117.put("receive_count", r117.optInt("receive_count", 0) + 1);     // Catch: Throwable -> L17
        r115.put("extra_data", r117);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(r101.f271663e, "trackNewObject e = " + th);
        return;
    }

    @JvmStatic
    public static final void g(long r100, String r110, String r111, String r112, boolean r113, String r114) {
        if (f509679b.get() == true) goto L5;
        f509685h.add(c(r100, r110, r111, r112, r113, r114, null));
    L5:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "stopTrackingObject");
        com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b r101 = f509678a;
        if (r101 == null) goto L22;
        String r102 = String.valueOf(r100);
        JSONObject r115 = e(r110, r111, r112, r113);
        JSONObject r116 = r101.f271659a.get(r102);
        JSONObject r103 = new JSONObject();
        if (r116 != null) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r101.f271663e, "stopTrackingObject abnormal_untracked reason = " + r114);     // Catch: Throwable -> L17
        r103.put("abnormal_untracked", 1);     // Catch: Throwable -> L17
        r103.put(r114, 1);     // Catch: Throwable -> L17
        JSONObject r117 = new JSONObject();     // Catch: Throwable -> L17
        r117.put("receive_count", 0);     // Catch: Throwable -> L17
        r117.put("event_receive_time_ms", hl7.b.b().a());     // Catch: Throwable -> L17
        r117.put("event_end_time_ms", hl7.b.b().a());     // Catch: Throwable -> L17
        r116 = r101.b(r102, r115, r103, r117);     // Catch: Throwable -> L17
    L15:
        r101.f271659a.remove(r102);     // Catch: Throwable -> L17
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r101.f271663e, "stopTrackingObject remove " + r102);     // Catch: Throwable -> L17
        r101.f271664f.a(r102, r116);     // Catch: Throwable -> L17
        return;
    L10:
        JSONObject r118 = r116.optJSONObject("extra_data");     // Catch: Throwable -> L17
        if (r118 != null) goto L14;
        r118 = new JSONObject();     // Catch: Throwable -> L17
    L14:
        r118.put("event_end_time_ms", hl7.b.b().a());     // Catch: Throwable -> L17
        r116.put("extra_data", r118);     // Catch: Throwable -> L17
        r101.c(r116, r114);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(r101.f271663e, "stopTrackingObject e = " + th);
        return;
    }

    @JvmStatic
    public static final void i(long r100, String r110, String r111, String r112, boolean r113, String r114) {
        if (f509679b.get() == true) goto L5;
        f509684g.add(c(r100, r110, r111, r112, r113, r114, null));
    L5:
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogDialogTracker", "updateObjectReason");
        com.bytedance.ug.sdk.luckydog.api.sidechaintracker.b r101 = f509678a;
        if (r101 == null) goto L18;
        String r102 = String.valueOf(r100);
        JSONObject r115 = e(r110, r111, r112, r113);
        JSONObject r116 = r101.f271659a.get(r102);
        JSONObject r117 = new JSONObject();
        if (r116 != null) goto L10;
        com.bytedance.ug.sdk.luckydog.api.log.d.d(r101.f271663e, "updateObjectReason abnormal_untracked reason = " + r114);     // Catch: Throwable -> L13
        r117.put("abnormal_untracked", 1);     // Catch: Throwable -> L13
        r117.put(r114, 1);     // Catch: Throwable -> L13
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L13
        r118.put("receive_count", 0);     // Catch: Throwable -> L13
        r118.put("event_receive_time_ms", hl7.b.b().a());     // Catch: Throwable -> L13
        r116 = r101.b(r102, r115, r117, r118);     // Catch: Throwable -> L13
    L11:
        r101.f271659a.put(r102, r116);     // Catch: Throwable -> L13
        return;
    L10:
        r101.c(r116, r114);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b(r101.f271663e, "activateCachedTrackedObject e = " + th);
        return;
    }

    public static JSONObject c(long r100, String r101, String r102, String r103, boolean r104, String r105, String r106) {
        JSONObject r107 = new JSONObject();
        r107.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, r104);     // Catch: Throwable -> L15
        r107.put("popup_id", r100);     // Catch: Throwable -> L15
        if (r101 == null) goto L6;
        r107.put("pop_name", r101);     // Catch: Throwable -> L15
    L6:
        if (r102 == null) goto L8;
        r107.put("pop_key", r102);     // Catch: Throwable -> L15
    L8:
        if (r103 == null) goto L10;
        r107.put("enter_from", r103);     // Catch: Throwable -> L15
    L10:
        if (r105 == null) goto L12;
        r107.put("popup_reason", r105);     // Catch: Throwable -> L15
    L12:
        if (r106 == null) goto L17;
        r107.put("status", r106);     // Catch: Throwable -> L15
    L17:
        return r107;
    L15:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.d.b("LuckyDogDialogTracker", "createPendingData e = " + th);
        goto L17
    }
}
