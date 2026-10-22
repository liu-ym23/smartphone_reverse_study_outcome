package rk7;

import android.app.Application;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f538312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f538313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f538314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f538315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f538316e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static List<String> f538317f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f538318g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, z> f538319h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile long f538320i;

    /* JADX INFO: renamed from: rk7.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"rk7/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "luckydog-api_release"}, k = 1, mv = {1, 4, 0})
    public static final class C7497a extends TypeToken<List<? extends String>> {
        public C7497a() {
        }
    }

    static {
        f538319h = new ConcurrentHashMap();
    }

    public static boolean a() {
        if (f538314c == false) goto L5;
        return false;
    L5:
        f538314c = true;
        Application r100 = m.f538347a;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("AppLaunchOptimizeManager", "enableActivityStageDelayInit: false");
        return false;
    }

    public static boolean b() {
        if (f538313b == false) goto L5;
        return false;
    L5:
        f538313b = true;
        Application r100 = m.f538347a;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("AppLaunchOptimizeManager", "enableAutoStaticSettingsCacheSnapshot: false");
        return false;
    }

    public static boolean c() {
        if (f538312a == false) goto L5;
        return false;
    L5:
        f538312a = true;
        Application r100 = m.f538347a;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("AppLaunchOptimizeManager", "enableStaticSettingsCacheSnapshot: false");
        return false;
    }

    public static void d(String r100) {
        if (m.f538357k == false) goto L5;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("AppLaunchOptimizeManager", "onStageEnd stageName: ".concat(r100));
    L5:
        AtomicBoolean r101 = u.f538372v;
        u.c.f538395a.getClass();
        ConcurrentHashMap r102 = (ConcurrentHashMap) f538319h;
        if (r102.containsKey(r100) == true) goto L8;
        return;
    L8:
        z r103 = (z) r102.get(r100);
        if (r103 == null) goto L12;
        r103.f538404b = System.currentTimeMillis();
        return;
    }

    public static void e(String r100) {
        if (m.f538357k == false) goto L6;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("AppLaunchOptimizeManager", "onStageStart stageName: ".concat(r100));
    L6:
        if (f538320i != 0) goto L8;
        f538320i = System.currentTimeMillis();
    L8:
        AtomicBoolean r101 = u.f538372v;
        u.c.f538395a.getClass();
        ConcurrentHashMap r102 = (ConcurrentHashMap) f538319h;
        if (r102.containsKey(r100) == false) goto L11;
        return;
    L11:
        z r103 = new z();
        r103.f538403a = System.currentTimeMillis();
        r102.put(r100, r103);
    }

    public static void f(String r100, boolean r101) {
        com.bytedance.ug.sdk.luckydog.api.log.a.c("AppLaunchOptimizeManager", "key str: " + r100 + ", isSave: " + r101);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("AppLaunchOptimizeManager", "key str is null");
    L5:
        Integer r102 = null;
        List<String> r103 = (List) new Gson().fromJson(r100, new C7497a().getType());     // Catch: Throwable -> L8
    L10:
        if (r103 != null) goto L13;
        com.bytedance.ug.sdk.luckydog.api.log.a.c("AppLaunchOptimizeManager", "parse static settings snapshot failed");
        return;
    L13:
        if (r101 == false) goto L15;
        il7.m.a().k("static_settings_cache_snapshot_keys", r100);
    L15:
        StringBuilder r104 = new StringBuilder("static settings cache snapshot keys size: ");
        List<String> r105 = f538317f;
        if (r105 == null) goto L18;
        r102 = Integer.valueOf(r105.size());
    L18:
        r104.append(r102);
        com.bytedance.ug.sdk.luckydog.api.log.a.c("AppLaunchOptimizeManager", r104.toString());
        f538317f = r103;
        return;
    L8:
        th = move-exception;
        com.bytedance.ug.sdk.luckydog.api.log.a.b("AppLaunchOptimizeManager", th.getMessage(), th);
        r103 = null;
        goto L10
    }
}
