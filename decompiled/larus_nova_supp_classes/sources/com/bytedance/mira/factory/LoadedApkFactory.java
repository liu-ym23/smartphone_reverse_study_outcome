package com.bytedance.mira.factory;

import android.app.ActivityThread;
import android.app.LoadedApk;
import android.app.ResourcesManager;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.util.ArrayMap;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.helper.ActivityThreadHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.OSUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class LoadedApkFactory {
    private static final String TAG = "LoadedApkFactory";
    private static Constructor<?> sLoadedApkConstructor;

    public LoadedApkFactory() {
    }

    public static boolean expansionMaps() {
        MiraParam r1 = MiraManager.getInstance().getParam();     // Catch: Throwable -> L31
        if (r1 != null) goto L6;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L13;
    L30:
        return false;
    L13:
        if (ResourcesManager.getInstance() == null) goto L30;
        ResourcesManager r3 = ResourcesManager.getInstance();     // Catch: Throwable -> L31
        monitor-enter(r3);     // Catch: Throwable -> L31
        Object r4 = ActivityThreadHelper.currentActivityThread();     // Catch: Throwable -> L27
        Object r5 = FieldUtils.readField(r4, "mPackages");     // Catch: Throwable -> L27
        ArrayMap r6 = new ArrayMap(64);     // Catch: Throwable -> L27
        Iterator r7 = PluginManager.getInstance().listPluginConfigs().iterator();     // Catch: Throwable -> L27
    L19:
        if (r7.hasNext() == false) goto L22;
        r6.put(((Plugin) r7.next()).mPackageName, null);     // Catch: Throwable -> L27
        goto L19
    L22:
        if ((r5 instanceof Map) == false) goto L24;
        r6.putAll((Map) r5);     // Catch: Throwable -> L27
    L24:
        FieldUtils.writeField(r4, "mPackages", r6);     // Catch: Throwable -> L27
        monitor-exit(r3);     // Catch: Throwable -> L27
        return true;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L6:
        if (r1.isEnableOptCreateLoadedApk() == false) goto L10;
        if (OSUtil.isAndroidLHigher() == false) goto L10;
        r2 = true;
    L31:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "LoadedApkFactory expansionMaps Fail.", th);
        return false;
    }

    static {
        Class r2 = Boolean.TYPE;     // Catch: Throwable -> L4
        Constructor<?> r0 = LoadedApk.class.getDeclaredConstructor(new Class[]{ActivityThread.class, ApplicationInfo.class, CompatibilityInfo.class, ClassLoader.class, r2, r2, r2});     // Catch: Throwable -> L4
        sLoadedApkConstructor = r0;     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        sLoadedApkConstructor = null;
        MiraLogger.e(MiraLogger.TAG_LOAD, "LoadedApkFactory LoadedApkConstructor Fail.", th);
    }

    public static Map getLoadedApkMap() {
        return (Map) FieldUtils.readField(ActivityThreadHelper.currentActivityThread(), "mPackages");
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "LoadedApkFactory getLoadedApkMap Fail.", th);
        return null;
    }

    public static LoadedApk getLoadedApk(String r3) {
        Map r0 = getLoadedApkMap();
        if (r0 != null) goto L5;
        return null;
    L5:
        Object r4 = r0.get(r3);
        if (r4 != null) goto L13;
        return null;
    L13:
        return (LoadedApk) ((WeakReference) r4).get();
    L10:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "LoadedApkFactory getLoadedApk Fail.", th);
        return null;
    }

    public static LoadedApk createLoadedApk(ApplicationInfo r6, Object r7) {
        Constructor<?> r2 = sLoadedApkConstructor;     // Catch: Throwable -> L11
        if (r2 != null) goto L7;
        MiraLogger.e(MiraLogger.TAG_LOAD, "LoadedApkFactory createLoadedApk Fail. sLoadedApkConstructor==null !");     // Catch: Throwable -> L11
        return null;
    L7:
        Boolean r8 = Boolean.FALSE;     // Catch: Throwable -> L11
        LoadedApk r9 = (LoadedApk) r2.newInstance(new Object[]{(ActivityThread) ActivityThreadHelper.currentActivityThread(), r6, (CompatibilityInfo) r7, null, r8, Boolean.TRUE, r8});     // Catch: Throwable -> L11
        Map r3 = getLoadedApkMap();     // Catch: Throwable -> L11
        if (r3 == null) goto L10;
        r3.put(r6.packageName, new WeakReference(r9));     // Catch: Throwable -> L11
    L10:
        return r9;
    L11:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "LoadedApkFactory createLoadedApk Fail.", th);
        return null;
    }
}
