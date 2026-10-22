package com.ss.android.lark.appsetting.api;

import android.text.TextUtils;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Reference<Map<String, AppConfig>> f408947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Map<String, Map<String, String>> f408948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Reference<Map<String, Object>>> f408949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Map<String, String> f408950d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f408951a = null;

        static {
            f408951a = new e();
        }
    }

    public e() {
        this.f408950d = new ConcurrentHashMap();
        this.f408948b = new HashMap();
        this.f408949c = new HashMap();
        this.f408947a = new SoftReference(new HashMap());
    }

    public final AppConfig b(Class r100) {
        Map<String, AppConfig> r101 = this.f408947a.get();
        if (r101 != null) goto L5;
    L8:
        AppConfig r102 = (AppConfig) r100.getAnnotation(AppConfig.class);
        if (r101 != null) goto L11;
        r101 = new HashMap();
        this.f408947a = new SoftReference(r101);
    L11:
        if (r102 == null) goto L13;
        r101.put(r100.getName(), r102);
    L13:
        return r102;
    L5:
        if (r101.containsKey(r100.getName()) == false) goto L8;
        return r101.get(r100.getName());
    }

    public final <T> T a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        Log.w("SettingCacheService", "get settings from absent_user, className: ".concat(r101));
        r100 = "absent_user";
    L5:
        Reference r102 = (Reference) ((HashMap) this.f408949c).get(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        Map r103 = (Map) r102.get();
        if (CollectionUtils.isNotEmpty(r103) == true) goto L11;
        return null;
    L11:
        return (T) r103.get(r101);
    }

    public static void d(String r100, Map r101, Map r102) {
        if (CollectionUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        if (r103.keySet().isEmpty() == false) goto L8;
        return;
    L8:
        Iterator r104 = r103.keySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        String r105 = (String) r104.next();
        r101.put(r105, (String) r103.get(r105));
        goto L10
    L12:
        KVRepo r106 = AppSettingApiModule.a().getUserRepo(r100);
        Iterator r107 = r103.keySet().iterator();
    L14:
        if (r107.hasNext() == false) goto L19;
        String r108 = (String) r107.next();
        String r109 = (String) r103.get(r108);
        if (TextUtils.isEmpty(r109) == true) goto L14;
        r106.putString(r108, r109);
        goto L14
    }

    public final String c(String r100, String r101, boolean r102) {
        if (CollectionUtils.isNotEmpty(this.f408950d) == false) goto L9;
        if (((ConcurrentHashMap) this.f408950d).containsKey(r101) == false) goto L9;
        return (String) ((ConcurrentHashMap) this.f408950d).get(r101);
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        Log.w("SettingCacheService", "get settings form absent_user, key: " + r101);
        r100 = "absent_user";
    L11:
        Map<String, String> r103 = this.f408948b.get(r100);
        String r104 = null;
        if (r103 != null) goto L14;
    L25:
        Log.d("SettingCacheService", "key:" + r101 + " mem cache doesn't exist in memory.");
        if (r102 == true) goto L28;
        AppSettingApiModule.a().getUserRepo(r100).remove(r101);
    L30:
        if (TextUtils.isEmpty(r104) == false) goto L33;
        String r105 = InternalLocalDefaultConfigStorage.f408932g.getValue().b(r101);
        Log.i("SettingCacheService", "getSettingConfig from local setting, key is ".concat(r101));
        return r105;
    L33:
        return r104;
    L28:
        r104 = AppSettingApiModule.a().getUserRepo(r100).getString(r101, "");
        goto L30
    L14:
        if (r103.containsKey(r101) == false) goto L25;
        if (CollectionUtils.isNotEmpty(r103) == false) goto L24;
        String r106 = r103.get(r101);
        if (r102 == true) goto L21;
    L23:
        return r106;
    L21:
        if (AppSettingApiModule.a().getUserRepo(r100).contains(r101) == true) goto L23;
        AppSettingApiModule.a().getUserRepo(r100).putString(r101, r106);
        goto L23
    L24:
        return null;
    }

    public final synchronized void e(final Map<String, String> r100, boolean r101, final String r102) {
        monitor-enter(this);
        if (r101 == true) goto L23;
        r102 = "absent_user";
    L10:
        if (r100 != null) goto L15;
        Log.w("SettingCacheService", "putConfigData, configDataMap is null");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L15:
        if (this.f408948b.get(r102) == null) goto L17;
        this.f408948b.put(r102, new HashMap());     // Catch: Throwable -> L20
    L17:
        this.f408948b = this.f408948b;     // Catch: Throwable -> L20
        this.f408948b.put(r102, new HashMap(r100));     // Catch: Throwable -> L20
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new d(r102, r100));     // Catch: Throwable -> L20
        d(r102, this.f408948b.get(r102), this.f408950d);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L23:
    L20:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.equals(r102, "absent_user") == false) goto L7;
    L8:
        r102 = AppSettingApiModule.a().getUid();     // Catch: Throwable -> L20
        goto L10
    L7:
        if (TextUtils.isEmpty(r102) == false) goto L10;
        goto L8
    }
}
