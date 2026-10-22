package com.volcengine.zeus.plugin;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.hihonor.honorid.core.data.UserInfo;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.kv.KVStorage;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: loaded from: classes41.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f462778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f462779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f462780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f462781d;

        public a(int r100, String r101, String r102, long r103) {
            this.f462778a = r100;
            this.f462779b = r101;
            this.f462780c = r102;
            this.f462781d = r103;
        }
    }

    public static void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return;
    L10:
        KVStorage.INSTANCE.staticKV().erase(b(r100));     // Catch: Throwable -> L7
        ZeusLogger.d(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot clear snapshot. " + r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot clear snapshot failed. " + r100, th);
    }

    public static String b(String r100) {
        return String.format(Locale.getDefault(), "zeus_plugin_install_state_snapshot_%s", new Object[]{r100});
    }

    public static String c(String r100) {
        return String.format(Locale.getDefault(), "zeus_plugin_install_state_uninstall_pending_%s", new Object[]{r100});
    }

    public static void d(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return;
    L11:
        KVStorage.INSTANCE.staticKV().storeBoolean(c(r100), true);     // Catch: Throwable -> L7
    L9:
        g(r100, r101, "pending_uninstall", "uninstall_requested");
        return;
    L7:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot save pending uninstall tombstone failed. " + r100, th);
        goto L9
    }

    public static a e(String r100, String r101, String r102) {
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginInstallStateSnapshot miss installed snapshot. pkg=" + r100 + " reason=" + r101 + " detail=" + r102);
        return new a(0, "miss", r101, 0);
    }

    public static void f(String r110, int r111, int r112) {
        if (TextUtils.isEmpty(r110) == true) goto L21;
        if (r111 <= 0) goto L21;
        String r100 = dqc.c.f(r110, r111, false);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r100) == false) goto L10;
        PolarisFileWrapper r101 = null;
    L11:
        if (r101 != null) goto L13;
    L16:
        a(r110);     // Catch: Throwable -> L18
        ZeusLogger.d(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot skip save. source apk not exists. " + r110 + ":" + r111);     // Catch: Throwable -> L18
        return;
    L13:
        if (r101.exists() == false) goto L16;
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L18
        r102.put("schema", 1);     // Catch: Throwable -> L18
        r102.put("packageName", r110);     // Catch: Throwable -> L18
        r102.put("state", "installed");     // Catch: Throwable -> L18
        r102.put("installed", true);     // Catch: Throwable -> L18
        r102.put("version", r111);     // Catch: Throwable -> L18
        r102.put(com.alipay.sdk.m.l.c.f25508m, r112);     // Catch: Throwable -> L18
        r102.put("hostAbi", Zeus.getHostAbi());     // Catch: Throwable -> L18
        r102.put("hostIdentity", mqc.b.a(Zeus.getAppApplication()));     // Catch: Throwable -> L18
        r102.put("apkPath", r101.getAbsolutePath());     // Catch: Throwable -> L18
        r102.put("apkLength", r101.length());     // Catch: Throwable -> L18
        r102.put("apkLastModified", r101.lastModified());     // Catch: Throwable -> L18
        r102.put(UserInfo.UPDATE_TIME, System.currentTimeMillis());     // Catch: Throwable -> L18
        KVStorage.INSTANCE.staticKV().storeString(b(r110), r102.toString());     // Catch: Throwable -> L18
        ZeusLogger.d(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot save installed snapshot. pkg=" + r110 + " version=" + r111 + " apiVersion=" + r112 + " hostAbi=" + Zeus.getHostAbi() + " apkLength=" + r101.length() + " apkLastModified=" + r101.lastModified());     // Catch: Throwable -> L18
        return;
    L10:
        r101 = new PolarisFileWrapper(new PolarisFileWrapper(r100, "apk"), "base-1.apk");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot save installed snapshot failed. " + r110 + ":" + r111, th);
        return;
    L21:
        ZeusLogger.d(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot save skipped, invalid args. pkg=" + r110 + " version=" + r111 + " apiVersion=" + r112);
        a(r110);
    }

    public static void g(String r100, int r101, String r102, String r110) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return;
    L10:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L7
        r103.put("schema", 1);     // Catch: Throwable -> L7
        r103.put("packageName", r100);     // Catch: Throwable -> L7
        r103.put("state", r102);     // Catch: Throwable -> L7
        r103.put("installed", false);     // Catch: Throwable -> L7
        r103.put(com.alipay.sdk.m.l.c.f25508m, r101);     // Catch: Throwable -> L7
        r103.put("hostAbi", Zeus.getHostAbi());     // Catch: Throwable -> L7
        r103.put("hostIdentity", mqc.b.a(Zeus.getAppApplication()));     // Catch: Throwable -> L7
        r103.put(UserInfo.UPDATE_TIME, System.currentTimeMillis());     // Catch: Throwable -> L7
        r103.put("reason", r110);     // Catch: Throwable -> L7
        KVStorage.INSTANCE.staticKV().storeString(b(r100), r103.toString());     // Catch: Throwable -> L7
        ZeusLogger.d(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot save unavailable snapshot. pkg=" + r100 + " state=" + r102 + " apiVersion=" + r101 + " reason=" + r110);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "PluginInstallStateSnapshot save unavailable snapshot failed. pkg=" + r100 + " state=" + r102, th);
    }
}
