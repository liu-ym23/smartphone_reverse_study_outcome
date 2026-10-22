package com.volcengine.zeus.plugin;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.plugin.linker.NSLinker;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.volcengine.zeus.ComponentManager;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.IPluginProcessManager;
import com.volcengine.zeus.NativePluginClassLoader;
import com.volcengine.zeus.PluginClassLoader;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.ZeusApplication;
import com.volcengine.zeus.i;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.provider.ContentProviderManager;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.res.PluginResources;
import com.volcengine.zeus.servermanager.ServerManagerHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.util.MethodUtils;
import com.volcengine.zeus.wrapper.PluginApplicationWrapper;
import dalvik.system.BaseDexClassLoader;
import dqc.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.NotImplementedError;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import mqc.m;
import mqc.s;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f {
    public static final i a = null;
    public static final Map<String, Object> b = null;
    public static final Map<String, Runnable> c = null;

    public class a implements ypc.a.b {
        public final /* synthetic */ Plugin a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ File d;
        public final /* synthetic */ StringBuilder e;
        public final /* synthetic */ JSONObject f;
        public final /* synthetic */ f g;

        @Override // ypc.a.b
        public final void run() throws Throwable {
            f r0 = this.g;
            Plugin r1 = this.a;
            String r2 = this.b;
            File r3 = this.c;
            File r4 = this.d;
            StringBuilder r5 = this.e;
            JSONObject r6 = this.f;
            r0.getClass();
            f.e(r1, r2, r3, r4, r5, r6);
        }

        public a(f r1, Plugin r2, String r3, PolarisFileWrapper r4, PolarisFileWrapper r5, StringBuilder r6, JSONObject r7) {
            this.g = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public class b implements ypc.a.b {
        public final /* synthetic */ PackageInfo[] a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Plugin c;
        public final /* synthetic */ StringBuilder d;
        public final /* synthetic */ String e;
        public final /* synthetic */ File f;
        public final /* synthetic */ JSONObject g;
        public final /* synthetic */ f h;

        @Override // ypc.a.b
        public final void run() throws Throwable {
            PackageInfo[] r0 = this.a;
            f r1 = this.h;
            String r2 = this.b;
            Plugin r3 = this.c;
            StringBuilder r4 = this.d;
            String r5 = this.e;
            File r6 = this.f;
            JSONObject r7 = this.g;
            r1.getClass();
            r0[0] = f.f(r2, r3, r4, r5, r6, r7);
        }

        public b(f r1, PackageInfo[] r2, String r3, Plugin r4, StringBuilder r5, String r6, PolarisFileWrapper r7, JSONObject r8) {
            this.h = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Plugin a;
        public final /* synthetic */ StringBuilder b;
        public final /* synthetic */ PackageInfo[] c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ f e;

        @Override // java.lang.Runnable
        public final void run() {
            f.b(this.e, this.a, this.b, this.c[0], this.d);     // Catch: Throwable -> L4 ClassNotFoundException -> L6 InstantiationException -> L8 Throwable -> L10
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L16;
            return;
        L16:
            throw th;
        L10:
            e = move-exception;
            throw new RuntimeException(e);     // Catch: Throwable -> L4
        }

        public c(f r1, Plugin r2, StringBuilder r3, PackageInfo[] r4, JSONObject r5) {
            this.e = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public class d implements ComponentCallbacks {
        public final /* synthetic */ Plugin a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public d(Plugin r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r4) {
            Resources r0 = this.a.mResources;
            Resources r1 = Zeus.getAppApplication().getResources();
            r0.updateConfiguration(r4, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
        }
    }

    static {
        a = i.a();
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
    }

    public f() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(PluginClassLoader r2, String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r4 = r2.loadClass(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r4;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r5 = r2.loadClass(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r5;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r3);
    }

    public static void h(Plugin r9, String r10) throws JSONException {
        ZeusLogger.d(ZeusLogger.TAG_LOAD, String.format("parseActStubMapping %s, thread=%s", new Object[]{r10, ThreadMethodProxy.currentThread().getName()}));
        if (TextUtils.isEmpty(r10) == true) goto L35;
        JSONObject r0 = new JSONObject(r10);
        JSONObject r2 = r0.optJSONObject("mapping");
        HashMap r4 = new HashMap();
        if (r2 == null) goto L10;
        Iterator<String> r5 = r2.keys();
    L8:
        if (r5.hasNext() == false) goto L10;
        String r6 = r5.next();
        r4.put(r6, JSONObjectProtectorUtils.getString(r2, r6));
    L10:
        JSONArray r1 = r0.optJSONArray("forceMappings");
        if (r1 == null) goto L25;
        int r3 = 0;
    L14:
        if (r3 >= r1.length()) goto L25;
        JSONObject r7 = JSONArrayProtectorUtils.getJSONObject(r1, r3);
        int r8 = r7.optInt("minApi", 0);
        int r11 = r7.optInt("maxApi", Integer.MAX_VALUE);
        int r12 = r9.getApiVersionCode();
        if (r12 > r11) goto L24;
        if (r12 < r8) goto L24;
        JSONObject r13 = r7.optJSONObject("mapping");
        if (r13 == null) goto L24;
        Iterator<String> r14 = r13.keys();
    L22:
        if (r14.hasNext() == false) goto L24;
        String r15 = r14.next();
        r4.put(r15, JSONObjectProtectorUtils.getString(r13, r15));
    L24:
        r3 = r3 + 1;
    L25:
        Iterator r16 = r4.keySet().iterator();
    L27:
        if (r16.hasNext() == false) goto L45;
        String r17 = (String) r16.next();
        String r18 = (String) r4.get(r17);
        String r19 = r9.mPkgName;
        StringBuilder r20 = new StringBuilder();
        if (r18 != null) goto L31;
    L33:
        String r21 = r9.mPkgName + ".";
    L34:
        r20.append(r21);
        r20.append((String) r4.get(r17));
        ComponentManager.registerActivity(r19, r20.toString(), new String[]{r17});
        goto L27
    L31:
        if (r18.contains(".") == false) goto L33;
        r21 = XmlPullParser.NO_NAMESPACE;
        goto L34
    L45:
        return;
    }

    public static void i(Plugin r7, String r8) throws JSONException {
        ZeusLogger.d(ZeusLogger.TAG_LOAD, String.format("parseReceiverStubMapping %s, thread=%s", new Object[]{r8, ThreadMethodProxy.currentThread().getName()}));
        if (TextUtils.isEmpty(r8) == true) goto L34;
        JSONObject r9 = new JSONObject(r8).optJSONObject("mapping");
        HashMap r0 = new HashMap();
        if (r9 == null) goto L10;
        Iterator<String> r1 = r9.keys();
    L8:
        if (r1.hasNext() == false) goto L10;
        String r2 = r1.next();
        r0.put(r2, JSONObjectProtectorUtils.getString(r9, r2));
    L10:
        Iterator r10 = r0.keySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L41;
        String r3 = (String) r10.next();
        String r4 = (String) r0.get(r3);
        iqc.b r5 = iqc.b.c();
        r5.getClass();
        String r6 = r7.mPkgName;
        String r11 = (String) ((HashMap) r5.d).get(r3);
        if (r11 != null) goto L16;
    L20:
        ((HashMap) r5.d).put(r3, r6);
        ((HashMap) r5.e).put(r4, (PluginBroadcastReceiver) iqc.b.b(r7.mClassLoader, r3).newInstance());     // Catch: Throwable -> L23 IllegalAccessException -> L25 ClassCastException -> L27 NullPointerException -> L29 ClassNotFoundException -> L31
    L23:
        e = move-exception;
        throw new RuntimeException("registerStaticReceiver-加载插件静态广播失败:" + r6 + " " + r4 + " " + r3, e);
    L16:
        if (r11.equals(r6) == true) goto L20;
        throw new IllegalArgumentException("registerStaticReceiver-重复注册静态广播:" + r6 + " " + r4 + " " + r3);
    L41:
        return;
    }

    public static PolarisFileWrapper c(String r3, int r4, String r5) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(dqc.c.c(r3, r4));
        if (Build.VERSION.SDK_INT > 25) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == true) goto L8;
    L11:
        if (r0 != null) goto L13;
    L15:
        return r0;
    L13:
        if (r0.exists() == true) goto L15;
        r0.mkdirs();
        goto L15
    L8:
        if (com.volcengine.zeus.oat.d.e(new String[]{r0 + File.separator + com.volcengine.zeus.oat.d.d(r5)}) == true) goto L11;
        r0 = null;
        goto L11
    L5:
        r6 = false;
        goto L6
    }

    public static void b(f r9, Plugin r10, StringBuilder r11, PackageInfo r12, JSONObject r13) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        r9.getClass();
        ActivityInfo[] r14 = r12.activities;
        int r0 = 0;
        if (r14 == null) goto L14;
        int r4 = r14.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L14;
        ActivityInfo r6 = r14[r5];
        if (TextUtils.isEmpty(r6.processName) == false) goto L9;
    L12:
        r6.processName = "main";
    L13:
        r10.pluginActivities.put(r6.name, r6);
        r5 = r5 + 1;
        goto L5
    L9:
        if (r6.processName.contains(":") == false) goto L12;
        r6.processName = r6.processName.split(":")[1];
    L14:
        ServiceInfo[] r15 = r12.services;
        if (r15 == null) goto L26;
        int r7 = r15.length;
        int r8 = 0;
    L17:
        if (r8 >= r7) goto L26;
        ServiceInfo r16 = r15[r8];
        if (TextUtils.isEmpty(r16.processName) == false) goto L21;
    L24:
        r16.processName = "main";
    L25:
        r10.pluginServices.put(r16.name, r16);
        r8 = r8 + 1;
        goto L17
    L21:
        if (r16.processName.contains(":") == false) goto L24;
        r16.processName = r16.processName.split(":")[1];
    L26:
        ActivityInfo[] r17 = r12.receivers;
        if (r17 == null) goto L38;
        int r18 = r17.length;
        int r19 = 0;
    L29:
        if (r19 >= r18) goto L38;
        ActivityInfo r20 = r17[r19];
        if (TextUtils.isEmpty(r20.processName) == false) goto L33;
    L36:
        r20.processName = "main";
    L37:
        r10.pluginReceiver.put(r20.name, r20);
        r19 = r19 + 1;
        goto L29
    L33:
        if (r20.processName.contains(":") == false) goto L36;
        r20.processName = r20.processName.split(":")[1];
    L38:
        ProviderInfo[] r21 = r12.providers;
        if (r21 == null) goto L50;
        int r22 = r21.length;
    L41:
        if (r0 >= r22) goto L50;
        ProviderInfo r23 = r21[r0];
        if (TextUtils.isEmpty(r23.processName) == false) goto L45;
    L48:
        r23.processName = "main";
    L49:
        r10.pluginProvider.put(r23.name, r23);
        r0 = r0 + 1;
        goto L41
    L45:
        if (r23.processName.contains(":") == false) goto L48;
        r23.processName = r23.processName.split(":")[1];
    L50:
        long r1 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r12.applicationInfo.className) == true) goto L53;
        ZeusApplication r24 = (ZeusApplication) a(r10.mClassLoader, r12.applicationInfo.className).newInstance();
        r10.mApplication = r24;
        r24.attach(r10, Zeus.getAppApplication());
    L53:
        r11.append("makeApplication cost:");
        r11.append(System.currentTimeMillis() - r1);
        r11.append(";");
        s.a(r13, "make_application_cost", Long.valueOf(System.currentTimeMillis() - r1));
        long r2 = System.currentTimeMillis();
        HashMap<String, ProviderInfo> r3 = r10.pluginProvider;
        if (r3 != null) goto L56;
    L58:
        r11.append("installProvider cost:");
        r11.append(System.currentTimeMillis() - r2);
        r11.append(";");
        s.a(r13, "install_provider_cost", Long.valueOf(System.currentTimeMillis() - r2));
        long r25 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r12.applicationInfo.className) == true) goto L61;
        r10.mApplication.onCreate();
    L61:
        r11.append("Application.onCreate cost:");
        r11.append(System.currentTimeMillis() - r25);
        r11.append(";");
        s.a(r13, "application_onCreate_cost", Long.valueOf(System.currentTimeMillis() - r25));
        return;
    L56:
        if (r3.size() <= 0) goto L58;
        ContentProviderManager.getInstance().installContentProviders(r10.pluginProvider.values(), r10);
        goto L58
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.volcengine.zeus.plugin.Plugin] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    public final boolean d(String r23, Plugin r24, StringBuilder r25, JSONObject r26, StringBuilder r28) {
        ?? r11 = r24;
        r11 = "PluginLoader loadPluginInternal, plugin[";
        ZeusLogger.v(ZeusLogger.TAG_LOAD, "loadPluginInternal invoked, packageName = " + r23);     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        if (Looper.myLooper() == Looper.getMainLooper()) goto L11;
        r25.append("loadPluginInternal, not load in non-main thread");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        r28.append("not in main thread");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "loadPlugin in non-main thread.");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        if (GlobalParam.getInstance().isDebug() == false) goto L11;
        throw new PluginImportantExceptionWrapper(new IllegalArgumentException("loadPlugin in non-main thread"));     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
    L11:
        if (r24.isInstalled() == true) goto L15;
        r25.append("loadPluginInternal, !plugin.isInstalled();");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        r28.append("plugin not installed");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + r23 + "] not installed !!!");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        return false;
    L15:
        if (r24.isInstalled() == true) goto L17;
    L20:
        Lazy r5 = PluginProtocolVersionChecker.a;     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        if (PluginProtocolVersionChecker.a(r23, Integer.toString(r24.getVersion())) == true) goto L25;
        r25.append("loadPluginInternal, protocol version not match; pluginVersionCode = ");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        r25.append(r24.getVersion());     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + r23 + "] protocol version not match !!! pluginVersionCode = " + r24.getVersion());     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        return false;
    L25:
        if (r11.mReInstallInternalPluginByMd5 == false) goto L34;
        String r6 = r24.getInternalPluginIdentity();     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        if (TextUtils.isEmpty(r6) == true) goto L34;
        if (TextUtils.equals(r6, mqc.d.a(r23)) == true) goto L34;
        if (r24.getVersion() != r24.getInternalVersionCode()) goto L34;
        r25.append("loadPluginInternal, identity not match; waiting for reinstall;");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        r28.append("identity not match");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + r23 + "] identity not match !!!");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        return false;
    L34:
        String r7 = dqc.c.h(r11.mPkgName, r24.getVersion(), false);     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        if (new PolarisFileWrapper(r7).exists() == true) goto L38;
        r25.append("loadPluginInternal, sourceApk not exist; sourceApkPath:" + r7);     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        r28.append("source apk not exist");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + r23 + "] file not exist !!! pluginApkPath:" + r7);     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        return false;
    L38:
        String r4 = r24.getPluginProcess();     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        Set<String> r8 = r24.getAllPluginProcesses();     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        Zeus.getAppApplication();     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        String r9 = dqc.d.c();     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        String r10 = dqc.d.b(r9);     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        if (TextUtils.isEmpty(r4) == false) goto L41;
    L58:
        PolarisFileWrapper r0 = new PolarisFileWrapper(dqc.c.e(r11.mPkgName, r24.getVersion(), false));     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        PolarisFileWrapper r12 = c(r11.mPkgName, r24.getVersion(), r7);     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        PackageInfo[] r13 = new PackageInfo[1];     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        if (m.b() == false) goto L73;
        ypc.a.b[] r3 = new ypc.a.b[2];     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        PackageInfo[] r18 = r13;
        boolean r19 = true;
        boolean r21 = false;
        r3[0] = new a(this, r24, r7, r0, r12, r25, r26);     // Catch: Throwable -> L69 PluginImportantExceptionWrapper -> L71
    L64:
        r3[1] = new b(this, r18, r23, r24, r25, r7, r0, r26);     // Catch: Throwable -> L65 PluginImportantExceptionWrapper -> L67
        ypc.a.a(r3);     // Catch: Throwable -> L65 PluginImportantExceptionWrapper -> L67
    L74:
        ((ConcurrentHashMap) c).put(r23, new c(this, r24, r25, r18, r26));     // Catch: Throwable -> L65 PluginImportantExceptionWrapper -> L67
        return r19;
    L71:
        e = e;
        String r14 = "PluginLoader loadPluginInternal, plugin[";
    L82:
        Throwable r1 = e.getCause();
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, r14 + r23 + "] ", r1);
        r28.append(r1.getMessage());
        if (GlobalParam.getInstance().isDebug() == true) goto L86;
        return r21;
    L86:
        throw ((RuntimeException) r1);
    L69:
        th = th;
        String r15 = "PluginLoader loadPluginInternal, plugin[";
    L78:
        r25.append("loadPluginInternal ");
        r25.append(th.getMessage());
        r25.append(";");
        r28.append(th.getMessage());
        ZeusLogger.w(ZeusLogger.TAG_LOAD, r15 + r23 + "] ", th);
        return r21;
    L73:
        r18 = r13;
        r19 = true;
        r21 = false;
        e(r24, r7, r0, r12, r25, r26);     // Catch: Throwable -> L65 PluginImportantExceptionWrapper -> L67
        r18[0] = f(r23, r24, r25, r7, r0, r26);     // Catch: Throwable -> L65 PluginImportantExceptionWrapper -> L67
    L67:
        e = e;
        r14 = r11;
    L65:
        th = th;
        r15 = r11;
        goto L78
    L41:
        if (dqc.d.d(Zeus.getAppApplication()) == false) goto L43;
        r25.append("loadPluginInternal, main process skip load;");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, main process skip load plugin[" + r23 + "]");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        throw new PluginImportantExceptionWrapper(new IllegalProcessException("cannot load in main process, plugin = ".concat(r23)));     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
    L43:
        if (r8.contains(r10) == true) goto L45;
        r25.append("loadPluginInternal, plugin process not match;");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + r23 + "] process not match !!!");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        throw new PluginImportantExceptionWrapper(new IllegalProcessException("cannot load plugin in this process, plugin = " + r23 + " process = " + r4));     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
    L45:
        if (GlobalParam.getInstance().enableHostQueryPluginProcessPid() == true) goto L58;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader report plugin process name to main process, plugin=" + r23 + ", process=" + r9);     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        IPluginProcessManager r2 = ServerManagerHelper.getPluginProcessManager("main");     // Catch: Throwable -> L52
        if (r2 == null) goto L51;
        r2.gatherPluginProcessName(r23, r9);     // Catch: Throwable -> L52
        goto L58
    L51:
        throw new IllegalStateException("PluginProcessManager for main nullptr");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader report plugin process name to main process failed", th);     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        goto L58
    L17:
        if (r24.getMigrationHandler().isMigrationNeeded(r23) == false) goto L20;
        r25.append("loadPluginInternal, migration needed;");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + r23 + "] is waiting for migration !!!");     // Catch: Throwable -> L76 PluginImportantExceptionWrapper -> L80
        return false;
    L80:
        e = e;
        r14 = "PluginLoader loadPluginInternal, plugin[";
        r21 = false;
    L76:
        th = th;
        r15 = "PluginLoader loadPluginInternal, plugin[";
        r21 = false;
        goto L78
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static void e(Plugin r23, String r24, File r25, File r26, StringBuilder r28, JSONObject r29) throws Throwable {
        String r9 = ";";
        String r10 = "actStubV1 cost:";
        long r11 = System.currentTimeMillis();
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 34) goto L9;
        if (r0 == 33) goto L6;
    L8:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L124;
    L20:
        String r2 = r25.getAbsolutePath();
        GlobalParam r7 = GlobalParam.getInstance();
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 24) goto L23;
    L29:
        boolean r8 = r7.enableClassLoaderOpt();
        String r14 = ZeusLogger.TAG_LOAD;
        if (r8 == false) goto L32;
        String r19 = "map_stub_cost";
        PluginClassLoader r12 = new NativePluginClassLoader(r24, r26, r2, null);
    L47:
        r23.mClassLoader = r12;
        int r3 = eqc.a.a;
        if (r23.mEnableSoNamespaceLink == true) goto L50;
    L96:
        String r20 = ";";
        String r18 = "actStubV1 cost:";
        String r21 = ZeusLogger.TAG_LOAD;
    L97:
        r28.append("classLoader cost:");
        r28.append(System.currentTimeMillis() - r11);
        r28.append(" ;");
        s.a(r29, "make_class_loader_cost", Long.valueOf(System.currentTimeMillis() - r11));
        if (r23.mOpenLoadClassOpt == false) goto L100;
        e.b(new e(r23));
    L100:
        long r4 = System.currentTimeMillis();
        ZeusLogger.d(r21, String.format("loadClass %s, thread=%s", new Object[]{"com.volcengine.StubConfig", ThreadMethodProxy.currentThread().getName()}));     // Catch: ClassNotFoundException -> L110 Throwable -> L111
        Class r5 = a(r23.mClassLoader, "com.volcengine.StubConfig");     // Catch: ClassNotFoundException -> L110 Throwable -> L111
        String r6 = (String) FieldUtils.readStaticField(r5, "actStubV1");     // Catch: ClassNotFoundException -> L110 Throwable -> L111
        if (r6 != null) goto L121;
    L106:
        String r15 = (String) FieldUtils.readStaticField(r5, "receiverStubV1");     // Catch: ClassNotFoundException -> L110 Throwable -> L111
        if (r15 == null) goto L109;
        i(r23, r15);     // Catch: Throwable -> L111 ClassNotFoundException -> L114
    L109:
        r28.append(r18);
        r28.append(System.currentTimeMillis() - r4);
        r28.append(r20);
        Long r16 = Long.valueOf(System.currentTimeMillis() - r4);
        r19 = r19;
    L116:
        s.a(r29, r19, r16);
        return;
    L121:
        h(r23, r6);     // Catch: Throwable -> L111 ClassNotFoundException -> L114
    L111:
        th = move-exception;
        r28.append(r18);
        r28.append(System.currentTimeMillis() - r4);
        r28.append(r20);
        s.a(r29, r19, Long.valueOf(System.currentTimeMillis() - r4));
        throw th;
    L115:
        r28.append(r18);
        r28.append(System.currentTimeMillis() - r4);
        r28.append(r20);
        r16 = Long.valueOf(System.currentTimeMillis() - r4);
        goto L116
    L50:
        if (r23.mSoNamespaceLinkAllowSet.isEmpty() == true) goto L96;
        if (Build.VERSION.SDK_INT < 24) goto L95;
        PluginClassLoader r17 = r23.mClassLoader;
        if (r17 == null) goto L96;
        ClassLoader r22 = r17.getInnerClassLoader();
        if (r22 == null) goto L96;
        Application r30 = Zeus.getAppApplication();
        if (r30 == null) goto L96;
        ClassLoader r31 = r30.getClassLoader();
        if (r31 == null) goto L96;
        Set<String> r110 = r23.mSoNamespaceLinkAllowSet;
        ArrayList r111 = new ArrayList();
        Iterator r112 = r110.iterator();
    L64:
        if (r112.hasNext() == false) goto L84;
        String r210 = (String) r112.next();
        if (TextUtils.isEmpty(r210) == true) goto L64;
        if (r210 == null) goto L83;
        String r32 = StringsKt.trim(r210).toString();
        if (r32.length() != 0) goto L72;
        boolean r211 = true;
    L73:
        if (r211 == true) goto L64;
        Iterator r212 = r112;
        String r213 = r9;
        String r113 = r10;
        String r214 = r14;
        if (StringsKt.endsWith$default(r32, ".so", false, 2, null) == true) goto L79;
        r32 = r32.concat(".so");
    L79:
        if (StringsKt.startsWith$default(r32, "lib", false, 2, null) == true) goto L81;
        r32 = "lib" + r32;
    L81:
        r111.add(r32);
        r112 = r212;
        r10 = r113;
        r9 = r213;
        r14 = r214;
        goto L64
    L72:
        r211 = false;
        goto L73
    L83:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L84:
        r20 = r9;
        r18 = r10;
        r21 = r14;
        if (r111.isEmpty() == true) goto L97;
    L92:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_SO, "SoNamespaceLinker link namespace failed, pkg=" + r23.mPkgName, th);
        goto L97
    L88:
        if (Build.VERSION.SDK_INT > 25) goto L90;
        ClassLoader r33 = r22.getParent();     // Catch: Throwable -> L92
        NSLinker.updateClassLoaderParent(r22, r31);     // Catch: Throwable -> L92
        NSLinker.createClassLoaderNameSpace(r30, r22);     // Catch: Throwable -> L92
        NSLinker.updateClassLoaderParent(r22, r33);     // Catch: Throwable -> L92
        ZeusLogger.i(ZeusLogger.TAG_SO, "SoNamespaceLinker create namespace (N) done, pkg=" + r23.mPkgName);     // Catch: Throwable -> L92
    L118:
        goto L97
    L90:
        NSLinker.createClassLoaderNameSpace(r30, r31);     // Catch: Throwable -> L92
        NSLinker.createClassLoaderNameSpace(r30, r22);     // Catch: Throwable -> L92
        NSLinker.linkNameSpace(r22, r31, r111);     // Catch: Throwable -> L92
        ZeusLogger.i(ZeusLogger.TAG_SO, "SoNamespaceLinker link namespace (O+) done, pkg=" + r23.mPkgName + ", so=" + TextUtils.join(":", r111));     // Catch: Throwable -> L92
        goto L118
    L95:
        throw new NotImplementedError("An operation is not implemented: 当前安卓版本没有完成NSLinker适配！");
    L32:
        if (m.b() == false) goto L45;
        if (r13 < 33) goto L35;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "ClassLoaderFactoryreportSecondaryDex33P:" + r24);
        gqc.b.a().getClass();
        gqc.b.d(r24);
        r12 = new com.volcengine.zeus.f(r24, r26, r2);
        r19 = "map_stub_cost";
        goto L47
    L35:
        r12 = new PluginClassLoader(XmlPullParser.NO_NAMESPACE, r26, r2, null);
        r19 = "map_stub_cost";
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", new Class[]{String.class}).invoke(r12, new Object[]{r24});     // Catch: Throwable -> L40
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "ClassLoaderFactory createPluginClassLoader#addDexPath success >>>" + r24);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "ClassLoaderFactory createPluginClassLoader#addDexPath fail >>>" + r24, th);
        goto L47
    L45:
        r19 = "map_stub_cost";
        r12 = new PluginClassLoader(r24, r26, r2, null);
        goto L47
    L23:
        if (r23.mEnableSoNamespaceLink == false) goto L29;
        if (r23.mSoNamespaceLinkAllowSet.isEmpty() == true) goto L29;
        throw new AssertionError("ns linker没有完成适配！");
    L124:
        PolarisFileWrapper r34 = new PolarisFileWrapper(r24);     // Catch: Throwable -> L18
        if (r34.exists() == true) goto L14;
    L16:
        ZeusLogger.d("PluginLoader", r23.mPkgName + " >> ensure file not write success~");     // Catch: Throwable -> L18
        goto L20
    L14:
        if (r34.canWrite() == false) goto L16;
        r34.setWritable(false, false);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        ZeusLogger.w("PluginLoader", r23.mPkgName + " >> ensure file not write fail~", th);
        goto L20
    L6:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L8;
    L9:
        r1 = true;
        goto L10
    }

    public static PackageInfo f(String r5, Plugin r6, StringBuilder r7, String r8, File r9, JSONObject r10) throws PackageManager.NameNotFoundException {
        long r0 = System.currentTimeMillis();
        PackageInfo r2 = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(r8, 143);
        r6.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), r6.mPkgName);
        ApplicationInfo r3 = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
        r6.mHostApplicationInfoHookSomeField = r3;
        r3.nativeLibraryDir = r9.getAbsolutePath();
        ApplicationInfo r11 = r6.mHostApplicationInfoHookSomeField;
        r11.dataDir = r6.mHostApplication.getDataDir().getAbsolutePath();
        r6.mHostApplicationInfoHookSomeField.sourceDir = r8;
        if (TextUtils.isEmpty(r2.applicationInfo.sourceDir) == false) goto L6;
        r2.applicationInfo.sourceDir = r8;
    L6:
        if (TextUtils.isEmpty(r2.applicationInfo.publicSourceDir) == false) goto L8;
        r2.applicationInfo.publicSourceDir = r8;
    L8:
        r6.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(r2.applicationInfo), r5);
        Zeus.getAppApplication().registerComponentCallbacks(new d(r6));
        r7.append("makeResources cost:");
        r7.append(System.currentTimeMillis() - r0);
        r7.append(";");
        s.a(r10, "make_res_cost", Long.valueOf(System.currentTimeMillis() - r0));
        return r2;
    }

    public static void g(String r4, int r5, String r6, int r7, long r8, String r10) {
        JSONObject r0 = new JSONObject();
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r0.putOpt("status_code", fqc.b.a(Integer.valueOf(r5)));     // Catch: JSONException -> L10
        r0.putOpt("plugin_package_name", fqc.b.a(r6));     // Catch: JSONException -> L10
        r0.putOpt("version_code", fqc.b.a(Integer.valueOf(r7)));     // Catch: JSONException -> L10
        Long r9 = Long.valueOf(r8);     // Catch: JSONException -> L10
        int r11 = -1;
        if (r9 != null) goto L15;
    L8:
        r2.putOpt("duration", Integer.valueOf(r11));     // Catch: JSONException -> L10
        r1.putOpt("message", fqc.b.a(r10));     // Catch: JSONException -> L10
    L12:
        bqc.b.c().b(r4, r0, r2, r1);
        return;
    L15:
        r11 = CastIntegerProtector.parseInt(r9.toString());     // Catch: Throwable -> L14
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }
}
