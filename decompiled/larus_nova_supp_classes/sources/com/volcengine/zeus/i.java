package com.volcengine.zeus;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.keva.KevaBuilder;
import com.volcengine.zeus.apm.ApmUtils;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.provider.ContentProviderManager;
import com.volcengine.zeus.servermanager.MainServerManager;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.util.kv.KVStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqc.m;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class i {
    public static volatile i e;
    public boolean a;
    public final List<ZeusPluginStateListener> b;
    public final List<ZeusPluginEventCallback> c;
    public final Handler d;

    public class b implements bqc.a {
        public b() {
        }

        @Override // bqc.a
        public final void a(String r7, JSONObject r8, JSONObject r9, JSONObject r10) {
            if (r9 != null) goto L6;
            r9 = new JSONObject();
        L6:
            if (Zeus.getAppApplication() == null) goto L8;
            Zeus.getAppApplication();
            String r2 = dqc.d.b(dqc.d.c());
        L10:
            if (Zeus.getAppApplication() == null) goto L12;
            String r3 = Zeus.getAppApplication().getPackageName();
        L13:
            if (r2 != null) goto L24;
            r2 = "unknown";
        L24:
            r8.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, fqc.b.a(r2));     // Catch: JSONException -> L21
            r8.putOpt("host_package_name", r3);     // Catch: JSONException -> L21
            Plugin r4 = Zeus.getPlugin(r8.optString("plugin_package_name", XmlPullParser.NO_NAMESPACE), false);     // Catch: JSONException -> L21
            if (r4 == null) goto L18;
            int r5 = r4.getApiVersionCode();     // Catch: JSONException -> L21
        L19:
            r8.putOpt("plugin_api_version", fqc.b.a(Integer.valueOf(r5)));     // Catch: JSONException -> L21
            r8.putOpt("zeus_sdk_version", fqc.b.a("0.0.1-alpha.174"));     // Catch: JSONException -> L21
            ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + r7 + "\ncategoryData:" + r8.toString(1) + "\nmetricData:" + r9.toString(1) + "\nlogExtrData:" + r10.toString(1));     // Catch: JSONException -> L21
            ApmUtils.getApmInstance().monitorEvent(r7, r8, r9, r10);     // Catch: JSONException -> L21
            return;
        L18:
            r5 = -1;
        L21:
            e = move-exception;
            ZeusLogger.w(ZeusLogger.TAG_REPORTER, e.getMessage(), e);
            return;
        L12:
            r3 = XmlPullParser.NO_NAMESPACE;
            goto L13
        L8:
            r2 = null;
            goto L10
        }
    }

    public static i a() {
        if (e != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public static void c() {
        PackageInfo r2 = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);     // Catch: Exception -> L34
        if (r2 == null) goto L32;
        ProviderInfo[] r3 = r2.providers;     // Catch: Exception -> L34
        if (r3 == null) goto L32;
        int r1 = r3.length;     // Catch: Exception -> L34
        int r4 = 0;
    L9:
        if (r4 >= r1) goto L31;
        ProviderInfo r5 = r3[r4];     // Catch: Exception -> L34
        if (TextUtils.isEmpty(r5.authority) == true) goto L30;
        if (r5.authority.contains(Zeus.getAppApplication().getPackageName() + ".zeus.servermanager.") == false) goto L30;
        if (TextUtils.isEmpty(r5.processName) == false) goto L18;
    L21:
        String r6 = "main";
    L23:
        if (Zeus.getServerManagerHashMap().get(r6) != null) goto L25;
    L29:
        Zeus.getServerManagerHashMap().put(r6, r5);     // Catch: Exception -> L34
        goto L30
    L25:
        if (TextUtils.equals(r6, "main") == false) goto L29;
        if (TextUtils.equals(r5.name, MainServerManager.class.getName()) == false) goto L29;
    L18:
        if (r5.processName.contains(":") == false) goto L21;
        r6 = r5.processName.split(":")[1];     // Catch: Exception -> L34
    L30:
        r4 = r4 + 1;     // Catch: Exception -> L34
        goto L9
    L31:
        return;
    L32:
        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:" + r2);     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public i() {
        this.b = new CopyOnWriteArrayList();
        this.c = new ArrayList();
        this.d = new Handler(Looper.getMainLooper());
    }

    public final synchronized void b(Application r9, boolean r10) {
        monitor-enter(this);
    L45:
        th = move-exception;
        throw th;
    L5:
        if (this.a == false) goto L10;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");     // Catch: Throwable -> L45
        monitor-exit(this);
        return;
    L10:
        d(3000, 0, null, -1, null);     // Catch: Throwable -> L45
        Zeus.setAppContext(r9);     // Catch: Throwable -> L45
        GlobalParam r1 = GlobalParam.getInstance();     // Catch: Throwable -> L45
        r1.init();     // Catch: Throwable -> L45
        if (r9 == null) goto L44;
        KevaBuilder.getInstance().setContext(r9);     // Catch: Throwable -> L45
        ZeusLogger.setDebug(r1.isDebug());     // Catch: Throwable -> L45
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + r9 + ", hParam = " + r1);     // Catch: Throwable -> L45
        KVStorage.INSTANCE.init();     // Catch: Throwable -> L45
        com.volcengine.zeus.oat.c.c();     // Catch: Throwable -> L45
        if (GlobalParam.getInstance().isIgnoreWebViewRes() == true) goto L16;
        dqc.e.b(new a());     // Catch: Throwable -> L45
    L16:
        if (GlobalParam.getInstance().isPostBgDexOptByInit() == false) goto L18;
        com.volcengine.zeus.oat.f.a();     // Catch: Throwable -> L45
    L18:
        if (r10 == false) goto L20;
        Zeus.onPrivacyAgreed();     // Catch: Throwable -> L45
    L20:
        bqc.b.c().a(new b());     // Catch: Throwable -> L45
        if (r1.isCloseFlipped() == true) goto L24;
        a.a();     // Catch: Throwable -> L45
    L24:
        if (Build.VERSION.SDK_INT != 29) goto L26;
        boolean r11 = true;
    L27:
        if (r11 == false) goto L30;
        dqc.e.b(new c());     // Catch: Throwable -> L45
    L30:
        if (m.a() == true) goto L51;
    L36:
        c();     // Catch: Throwable -> L45
        ContentProviderManager.getInstance().initSystemContentProviderInfo();     // Catch: Throwable -> L45
        iqc.a.C0009a r12 = iqc.a.a;     // Catch: Throwable -> L45
        if (TextUtils.equals(Build.BRAND.toLowerCase(), "huawei") == false) goto L40;
        iqc.a.a.a(r9.getBaseContext());     // Catch: Throwable -> L48
    L40:
        this.a = true;     // Catch: Throwable -> L45
        d(3100, 0, null, -1, null);     // Catch: Throwable -> L45
        monitor-exit(this);
        return;
    L51:
        FieldUtils.writeField(dqc.a.b(), "mHiddenApiWarningShown", Boolean.TRUE);     // Catch: Exception -> L34 Throwable -> L45
        ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");     // Catch: Exception -> L34 Throwable -> L45
    L34:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);     // Catch: Throwable -> L45
        goto L36
    L26:
        r11 = false;
        goto L27
    L44:
        throw new IllegalArgumentException("context must be not null !!!");     // Catch: Throwable -> L45
    }

    public final void d(int r14, int r15, String r16, int r17, Throwable r18) {
        List<ZeusPluginEventCallback> r2 = this.c;
        monitor-enter(r2);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.c).isEmpty() == true) goto L7;
        Object[] r0 = ((ArrayList) this.c).toArray();     // Catch: Throwable -> L16
    L8:
        monitor-exit(r2);     // Catch: Throwable -> L16
        int r3 = 0;
        if (r0 != null) goto L12;
        r0 = new Object[0];
    L12:
        int r4 = r0.length;
    L13:
        if (r3 >= r4) goto L15;
        Object r5 = r0[r3];
        this.d.post(new d(r5, r14, r15, r16, r17, r18));
        r3 = r3 + 1;
        goto L13
    L15:
        return;
    L7:
        r0 = null;
        goto L8
    }
}
