package com.bytedance.vodsetting;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class SettingsManager {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static SettingsManager f272533n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f272534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<g> f272535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f272536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.vodsetting.b f272537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, j> f272538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f272539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f272540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f272541h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f272542i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f272543j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PthreadTimer f272544k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f272545l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ModuleItem[] f272546m;

    public static final enum ModuleItem extends Enum<ModuleItem> {
        public static final ModuleItem BIZ_PORTRAIT = null;
        public static final ModuleItem MDL = null;
        public static final ModuleItem UPLOAD = null;
        public static final ModuleItem VOD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ModuleItem[] f272547a = null;
        int intValue;
        String stringValue;

        static {
            ModuleItem r100 = new ModuleItem("VOD", 0, 1, "vod");
            VOD = r100;
            ModuleItem r101 = new ModuleItem("MDL", 1, 2, "mdl");
            MDL = r101;
            ModuleItem r102 = new ModuleItem("UPLOAD", 2, 4, "upload");
            UPLOAD = r102;
            ModuleItem r103 = new ModuleItem("BIZ_PORTRAIT", 3, 16, "biz_portrait");
            BIZ_PORTRAIT = r103;
            f272547a = new ModuleItem[]{r100, r101, r102, r103};
        }

        public static ModuleItem[] values() {
            return (ModuleItem[]) f272547a.clone();
        }

        public static ModuleItem valueOf(String r100) {
            return (ModuleItem) r27.a.a(ModuleItem.class, r100);
        }

        public ModuleItem(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.intValue = r102;
            this.stringValue = r103;
        }
    }

    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SettingsManager f272548a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            com.bytedance.vodsetting.b r100 = this.f272548a.f272537d;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.f272561e = 0;     // Catch: Throwable -> L6
            r100.c("all", null);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(SettingsManager r100) {
            this.f272548a = r100;
        }
    }

    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SettingsManager> f272549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SettingsManager f272550b;

        public b(SettingsManager r100, SettingsManager r101) {
            this.f272550b = r100;
            this.f272549a = new WeakReference(r101);
        }

        public final void a(int r110, String r111, JSONObject r112, String r113, String r114) {
            SettingsManager r100 = this.f272549a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            e.b("Manager", "refresh settings: code " + r110 + ", message = " + r111);
            if (r110 == 0) goto L9;
            e.a("Manager", "refresh data fail. code = " + r110);
            return;
        L9:
            JSONObject r115 = r112.optJSONObject("general_settings");
            int r116 = 0;
            if (r115 == null) goto L34;
            long r101 = r115.optLong("config_version");
            r100.f272537d.b(r101);
            j r102 = this.f272550b.f272538e.get("common");
            r102.e("config_version", r101);
            int r103 = r115.optInt("max_fetch_times", -1);
            if (r103 <= 0) goto L17;
            r102.d("max_fetch_times", r103);
            com.bytedance.vodsetting.b r104 = r100.f272537d;
            if (r103 >= 1) goto L16;
            r104.getClass();
            e.a("Fetcher", "set max fetch times fail. times = " + r103);
            goto L17
        L16:
            r104.f272560d = r103;
        L17:
            int r105 = r115.optInt("fetch_interval");
            if (r105 > 0) goto L20;
        L25:
            long r106 = r115.optLong("local_cache_expire");
            if (r106 <= 0) goto L28;
            r102.e("local_cache_expire", System.currentTimeMillis() + (r106 * 1000));
        L28:
            boolean r117 = r115.optBoolean("use_local_cache");
            r102.d("use_local_cache", r117 ? 1 : 0);
            if (r117 == true) goto L34;
            int r118 = 0;
        L31:
            SettingsManager r107 = this.f272550b;
            ModuleItem[] r108 = r107.f272546m;
            if (r118 >= r108.length) goto L34;
            r107.f272538e.get(r108[r118].stringValue).f();
            r118 = r118 + 1;
            goto L31
        L20:
            if (r105 == r102.a("fetch_interval", -1)) goto L25;
            r102.d("fetch_interval", r105);
            r100.f272537d.getClass();
            if (r105 >= 1) goto L24;
            e.a("Fetcher", "set fetch interval fail. interval = " + r105);
        L24:
            this.f272550b.c(r105);
        L34:
            JSONObject r119 = r112.optJSONObject("custom_settings");
            if (r119 == null) goto L43;
            if (r113 == null) goto L40;
            if (r113.equals("all") == true) goto L40;
            SettingsManager.e(this.f272550b, r113, r114, r119.optJSONObject(r113));
            return;
        L40:
            SettingsManager r120 = this.f272550b;
            ModuleItem[] r121 = r120.f272546m;
            if (r116 >= r121.length) goto L48;
            String r122 = r121[r116].stringValue;
            SettingsManager.e(r120, r122, r114, r119.optJSONObject(r122));
            r116 = r116 + 1;
            goto L40
        L48:
            return;
        }
    }

    public SettingsManager() {
        this.f272534a = new ReentrantReadWriteLock();
        this.f272535b = new ArrayList();
        this.f272536c = null;
        this.f272537d = null;
        this.f272539f = true;
        this.f272540g = 0;
        this.f272541h = 600;
        this.f272542i = 0;
        this.f272543j = 100;
        this.f272544k = null;
        this.f272545l = null;
        int r100 = 0;
        this.f272546m = new ModuleItem[]{ModuleItem.VOD, ModuleItem.MDL, ModuleItem.UPLOAD, ModuleItem.BIZ_PORTRAIT};
        HashMap<String, j> r101 = new HashMap();
        this.f272538e = r101;
        r101.put("common", new j("common", 2));
    L3:
        ModuleItem[] r102 = this.f272546m;
        if (r100 >= r102.length) goto L6;
        HashMap<String, j> r103 = this.f272538e;
        String r104 = r102[r100].stringValue;
        r103.put(r104, new j(r104, 3));
        r100 = r100 + 1;
        goto L3
    }

    public final void a(String r100) {
        j r101 = this.f272538e.get(r100);
        if (r101.g(this.f272536c.getApplicationContext()) == true) goto L5;
        return;
    L5:
        if (this.f272539f == false) goto L7;
        b(r100);
        return;
    L7:
        r101.f();
    }

    public final void b(String r100) {
        this.f272534a.readLock().lock();
        Iterator<g> r101 = this.f272535b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onNotify(r100, 1000);
        goto L4
    L6:
        this.f272534a.readLock().unlock();
    }

    public final synchronized void c(long r100) {
        monitor-enter(this);
        e.b("Manager", "smart schedule mAppBackGround:false, interval:" + r100);     // Catch: Throwable -> L7
        d(r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(long r110) {
        monitor-enter(this);
        a r100 = this.f272545l;     // Catch: Throwable -> L21
        if (r100 == null) goto L7;
        r100.cancel();     // Catch: Throwable -> L21
    L7:
        this.f272545l = new a(this);     // Catch: Throwable -> L21
        PthreadTimer r101 = this.f272544k;     // Catch: Throwable -> L21
        if (r101 == null) goto L10;
        r101.purge();     // Catch: Throwable -> L21
    L12:
        if ((r110 * 1000) >= 1000) goto L14;
        r110 = 86400;
    L14:
        e.b("Manager", "start schedule");     // Catch: Throwable -> L21
        long r102 = r110 * 1000;     // Catch: Throwable -> L17
        this.f272544k.schedule(this.f272545l, r102, r102);     // Catch: Throwable -> L17
    L19:
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        e.a("Manager", "reset schedule fail. " + th.toString());     // Catch: Throwable -> L21
        th.printStackTrace();     // Catch: Throwable -> L21
        goto L19
    L10:
        this.f272544k = new PthreadTimer("SettingsManager", true);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    public final JSONObject f(String r100, String r101) {
        j r102 = this.f272538e.get(r100);
        r102.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L29;
        r102.g(r102.f272577c);
        if ((r102.f272579e & 1) <= 0) goto L12;
        r102.f272575a.readLock().lock();
        JSONObject r103 = r102.f272576b;
        if (r103 == null) goto L10;
        JSONObject r104 = r103.optJSONObject(r101);
    L11:
        r102.f272575a.readLock().unlock();
    L13:
        if (r104 != null) goto L25;
    L22:
        e = move-exception;
        e.a("Storage", e.toString());
        return null;
    L15:
        if ((r102.f272579e & 2) <= 0) goto L25;
        SharedPreferences r105 = r102.f272580f;     // Catch: JSONException -> L22
        if (r105 == null) goto L25;
        String r106 = r105.getString(r101, "");     // Catch: JSONException -> L22
        if (TextUtils.isEmpty(r106) == true) goto L25;
        r104 = new JSONObject(r106);     // Catch: JSONException -> L22
        e.b("Storage", "get jsonObject from SP, key = " + r101 + ", retValue = " + r104);     // Catch: JSONException -> L22
    L25:
        return r104;
    L10:
        r104 = null;
        goto L11
    L12:
        r104 = null;
        goto L13
    L29:
        return null;
    }

    public final String g(String r100, String r101, String r102) {
        j r103 = this.f272538e.get(r100);
        r103.getClass();
        if (TextUtils.isEmpty(r101) == true) goto L23;
        r103.g(r103.f272577c);
        String r104 = null;
        int r105 = 0;
        if ((r103.f272579e & 1) <= 0) goto L13;
        r103.f272575a.readLock().lock();
        JSONObject r106 = r103.f272576b;
        if (r106 != null) goto L10;
    L12:
        r103.f272575a.readLock().unlock();
        goto L13
    L10:
        if (r106.isNull(r101) == true) goto L12;
        String r107 = r103.f272576b.optString(r101);
        r105 = r103.f272576b.length();
        r104 = r107;
    L13:
        if (r105 != 0) goto L21;
        if (r104 != null) goto L21;
        if ((r103.f272579e & 2) <= 0) goto L21;
        SharedPreferences r108 = r103.f272580f;
        if (r108 == null) goto L21;
        String r109 = r108.getString(r101, r102);
        e.b("Storage", "get string from SP, key = " + r101 + ", retValue = " + r109);
        return r109;
    L21:
        return r104;
    L23:
        return r102;
    }

    public static void e(SettingsManager r100, String r101, String r102, JSONObject r103) {
        if (r103 == null) goto L33;
        j r104 = r100.f272538e.get(r101);
        JSONObject r105 = r104.b();
        if (r105 != null) goto L6;
    L7:
        if (r102 == null) goto L9;
        boolean r106 = true;
    L10:
        r104.g(r104.f272577c);
        r104.f272575a.writeLock().lock();
    L26:
        th = move-exception;
        r104.f272575a.writeLock().unlock();
        throw th;
    L28:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L26
        e.a("Storage", e.toString());     // Catch: Throwable -> L26
    L30:
        r104.f272575a.writeLock().unlock();
        r100.b(r101);
        return;
    L12:
        if (r104.f272576b == null) goto L19;
        if (r106 == false) goto L19;
        Iterator<String> r107 = r103.keys();     // Catch: Throwable -> L26 JSONException -> L28
    L17:
        if (r107.hasNext() == false) goto L21;
        String r108 = r107.next();     // Catch: Throwable -> L26 JSONException -> L28
        r104.f272576b.putOpt(r108, r103.opt(r108));     // Catch: Throwable -> L26 JSONException -> L28
        e.b("Storage", "update json, key = " + r108 + ", value = " + r103.opt(r108));     // Catch: Throwable -> L26 JSONException -> L28
    L21:
        if ((r104.f272579e & 2) <= 0) goto L30;
        SharedPreferences r109 = r104.f272580f;     // Catch: Throwable -> L26 JSONException -> L28
        if (r109 == null) goto L30;
        SharedPreferences.Editor r110 = r109.edit();     // Catch: Throwable -> L26 JSONException -> L28
        r110.putString(r104.f272581g + "_whole", r104.f272576b.toString());     // Catch: Throwable -> L26 JSONException -> L28
        r110.apply();     // Catch: Throwable -> L26 JSONException -> L28
    L19:
        r104.f272576b = r103;     // Catch: Throwable -> L26 JSONException -> L28
        goto L21
    L9:
        r106 = false;
        goto L10
    L6:
        if (r105.toString().equals(r103.toString()) == false) goto L7;
        return;
    L33:
        r100.getClass();
    }
}
