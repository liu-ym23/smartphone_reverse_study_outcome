package com.volcengine.zeus;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.stub.PluginLoaderActivity;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.volcengine.zeus.apm.ApmUtils;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.provider.ContentProviderManager;
import com.volcengine.zeus.servermanager.MainServerManager;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.util.MethodUtils;
import com.volcengine.zeus.util.kv.KVStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;
import mqc.m;
import mqc.o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile i f462708e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f462709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ZeusPluginStateListener> f462710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<ZeusPluginEventCallback> f462711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f462712d;

    /* JADX INFO: loaded from: classes41.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            o.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a() {
        }
    }

    public class b implements bqc.a {
        public b() {
        }

        @Override // bqc.a
        public final void a(String r100, JSONObject r101, JSONObject r102, JSONObject r110) {
            if (r102 != null) goto L6;
            r102 = new JSONObject();
        L6:
            if (Zeus.getAppApplication() == null) goto L8;
            Zeus.getAppApplication();
            String r103 = dqc.d.b(dqc.d.c());
        L10:
            if (Zeus.getAppApplication() == null) goto L12;
            String r104 = Zeus.getAppApplication().getPackageName();
        L13:
            if (r103 != null) goto L24;
            r103 = "unknown";
        L24:
            r101.putOpt("process_name", fqc.b.a(r103));     // Catch: JSONException -> L21
            r101.putOpt("host_package_name", r104);     // Catch: JSONException -> L21
            Plugin r105 = Zeus.getPlugin(r101.optString(PluginLoaderActivity.EXTRA_PLUGIN_PACKAGE_NAME, ""), false);     // Catch: JSONException -> L21
            if (r105 == null) goto L18;
            int r106 = r105.getApiVersionCode();     // Catch: JSONException -> L21
        L19:
            r101.putOpt("plugin_api_version", fqc.b.a(Integer.valueOf(r106)));     // Catch: JSONException -> L21
            r101.putOpt("zeus_sdk_version", fqc.b.a("0.0.1-alpha.174"));     // Catch: JSONException -> L21
            ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + r100 + "\ncategoryData:" + r101.toString(1) + "\nmetricData:" + r102.toString(1) + "\nlogExtrData:" + r110.toString(1));     // Catch: JSONException -> L21
            ApmUtils.getApmInstance().monitorEvent(r100, r101, r102, r110);     // Catch: JSONException -> L21
            return;
        L18:
            r106 = -1;
        L21:
            e = move-exception;
            ZeusLogger.w(ZeusLogger.TAG_REPORTER, e.getMessage(), e);
            return;
        L12:
            r104 = "";
            goto L13
        L8:
            r103 = null;
            goto L10
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class c implements Runnable {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.android.server.SystemConfig");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.android.server.SystemConfig");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.android.server.SystemConfig");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.android.server.SystemConfig");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.android.server.SystemConfig");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.android.server.SystemConfig");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.android.server.SystemConfig");
        }

        @Override // java.lang.Runnable
        public final void run() {
            MethodUtils.invokeStaticMethod(a(), "getInstance", new Object[0]);     // Catch: Throwable -> L4
            return;
        }

        public c() {
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f462713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f462714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f462715c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f462716d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f462717e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Throwable f462718f;

        @Override // java.lang.Runnable
        public final void run() {
            ((ZeusPluginEventCallback) this.f462713a).onPluginEvent(this.f462714b, this.f462715c, this.f462716d, this.f462717e, this.f462718f);     // Catch: Throwable -> L4
            return;
        }

        public d(Object r100, int r101, int r102, String r103, int r104, Throwable r105) {
            this.f462713a = r100;
            this.f462714b = r101;
            this.f462715c = r102;
            this.f462716d = r103;
            this.f462717e = r104;
            this.f462718f = r105;
        }
    }

    public static i a() {
        if (f462708e != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f462708e != null) goto L9;
        f462708e = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f462708e;
    }

    public static void c() {
        PackageInfo r100 = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);     // Catch: Exception -> L34
        if (r100 == null) goto L32;
        ProviderInfo[] r101 = r100.providers;     // Catch: Exception -> L34
        if (r101 == null) goto L32;
        int r102 = r101.length;     // Catch: Exception -> L34
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L31;
        ProviderInfo r104 = r101[r103];     // Catch: Exception -> L34
        if (TextUtils.isEmpty(r104.authority) == true) goto L30;
        if (r104.authority.contains(Zeus.getAppApplication().getPackageName() + ".zeus.servermanager.") == false) goto L30;
        if (TextUtils.isEmpty(r104.processName) == false) goto L18;
    L21:
        String r105 = PullConfiguration.PROCESS_NAME_MAIN;
    L23:
        if (Zeus.getServerManagerHashMap().get(r105) != null) goto L25;
    L29:
        Zeus.getServerManagerHashMap().put(r105, r104);     // Catch: Exception -> L34
        goto L30
    L25:
        if (TextUtils.equals(r105, PullConfiguration.PROCESS_NAME_MAIN) == false) goto L29;
        if (TextUtils.equals(r104.name, MainServerManager.class.getName()) == false) goto L29;
    L18:
        if (r104.processName.contains(":") == false) goto L21;
        r105 = r104.processName.split(":")[1];     // Catch: Exception -> L34
    L30:
        r103 = r103 + 1;     // Catch: Exception -> L34
        goto L9
    L31:
        return;
    L32:
        ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:" + r100);     // Catch: Exception -> L34
        return;
    L34:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public i() {
        this.f462710b = new CopyOnWriteArrayList();
        this.f462711c = new ArrayList();
        this.f462712d = new Handler(Looper.getMainLooper());
    }

    public final synchronized void b(Application r100, boolean r110) {
        monitor-enter(this);
    L45:
        th = move-exception;
        throw th;
    L5:
        if (this.f462709a == false) goto L10;
        ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");     // Catch: Throwable -> L45
        monitor-exit(this);
        return;
    L10:
        d(3000, 0, null, -1, null);     // Catch: Throwable -> L45
        Zeus.setAppContext(r100);     // Catch: Throwable -> L45
        GlobalParam r101 = GlobalParam.getInstance();     // Catch: Throwable -> L45
        r101.init();     // Catch: Throwable -> L45
        if (r100 == null) goto L44;
        KevaBuilder.getInstance().setContext(r100);     // Catch: Throwable -> L45
        ZeusLogger.setDebug(r101.isDebug());     // Catch: Throwable -> L45
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + r100 + ", hParam = " + r101);     // Catch: Throwable -> L45
        KVStorage.INSTANCE.init();     // Catch: Throwable -> L45
        com.volcengine.zeus.oat.c.c();     // Catch: Throwable -> L45
        if (GlobalParam.getInstance().isIgnoreWebViewRes() == true) goto L16;
        dqc.e.b(new a());     // Catch: Throwable -> L45
    L16:
        if (GlobalParam.getInstance().isPostBgDexOptByInit() == false) goto L18;
        com.volcengine.zeus.oat.f.a();     // Catch: Throwable -> L45
    L18:
        if (r110 == false) goto L20;
        Zeus.onPrivacyAgreed();     // Catch: Throwable -> L45
    L20:
        bqc.b.c().a(new b());     // Catch: Throwable -> L45
        if (r101.isCloseFlipped() == true) goto L24;
        com.volcengine.zeus.a.a();     // Catch: Throwable -> L45
    L24:
        if (Build.VERSION.SDK_INT != 29) goto L26;
        boolean r111 = true;
    L27:
        if (r111 == false) goto L30;
        dqc.e.b(new c());     // Catch: Throwable -> L45
    L30:
        if (m.a() == true) goto L51;
    L36:
        c();     // Catch: Throwable -> L45
        ContentProviderManager.getInstance().initSystemContentProviderInfo();     // Catch: Throwable -> L45
        iqc.a.C6351a r112 = iqc.a.f495426a;     // Catch: Throwable -> L45
        if (TextUtils.equals(Build.BRAND.toLowerCase(), RomUtils.BRAND_HUAWEI) == false) goto L40;
        iqc.a.f495426a.a(r100.getBaseContext());     // Catch: Throwable -> L48
    L40:
        this.f462709a = true;     // Catch: Throwable -> L45
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
        r111 = false;
        goto L27
    L44:
        throw new IllegalArgumentException("context must be not null !!!");     // Catch: Throwable -> L45
    }

    public final void d(int r110, int r111, String r112, int r113, Throwable r114) {
        List<ZeusPluginEventCallback> r100 = this.f462711c;
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f462711c).isEmpty() == true) goto L7;
        Object[] r101 = ((ArrayList) this.f462711c).toArray();     // Catch: Throwable -> L16
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L16
        int r102 = 0;
        if (r101 != null) goto L12;
        r101 = new Object[0];
    L12:
        int r103 = r101.length;
    L13:
        if (r102 >= r103) goto L15;
        Object r104 = r101[r102];
        this.f462712d.post(new d(r104, r110, r111, r112, r113, r114));
        r102 = r102 + 1;
        goto L13
    L15:
        return;
    L7:
        r101 = null;
        goto L8
    }
}
