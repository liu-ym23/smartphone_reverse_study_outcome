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

/* JADX INFO: loaded from: classes.dex */
public class LoadedApkFactory {
    private static final String TAG = "LoadedApkFactory";
    private static Constructor<?> sLoadedApkConstructor;

    public LoadedApkFactory() {
    }

    public static boolean expansionMaps() {
        MiraParam r100 = MiraManager.getInstance().getParam();     // Catch: Throwable -> L31
        if (r100 != null) goto L6;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == true) goto L13;
    L30:
        return false;
    L13:
        if (ResourcesManager.getInstance() == null) goto L30;
        ResourcesManager r102 = ResourcesManager.getInstance();     // Catch: Throwable -> L31
        monitor-enter(r102);     // Catch: Throwable -> L31
        Object r103 = ActivityThreadHelper.currentActivityThread();     // Catch: Throwable -> L27
        Object r104 = FieldUtils.readField(r103, "mPackages");     // Catch: Throwable -> L27
        ArrayMap r105 = new ArrayMap(64);     // Catch: Throwable -> L27
        Iterator<Plugin> r106 = PluginManager.getInstance().listPluginConfigs().iterator();     // Catch: Throwable -> L27
    L19:
        if (r106.hasNext() == false) goto L22;
        r105.put(r106.next().mPackageName, null);     // Catch: Throwable -> L27
        goto L19
    L22:
        if ((r104 instanceof Map) == false) goto L24;
        r105.putAll((Map) r104);     // Catch: Throwable -> L27
    L24:
        FieldUtils.writeField(r103, "mPackages", r105);     // Catch: Throwable -> L27
        monitor-exit(r102);     // Catch: Throwable -> L27
        return true;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L6:
        if (r100.isEnableOptCreateLoadedApk() == false) goto L10;
        if (OSUtil.isAndroidLHigher() == false) goto L10;
        r101 = true;
    L31:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "LoadedApkFactory expansionMaps Fail.", th);
        return false;
    }

    static {
        Class r100 = Boolean.TYPE;     // Catch: Throwable -> L4
        Constructor<?> r101 = LoadedApk.class.getDeclaredConstructor(new Class[]{ActivityThread.class, ApplicationInfo.class, CompatibilityInfo.class, ClassLoader.class, r100, r100, r100});     // Catch: Throwable -> L4
        sLoadedApkConstructor = r101;     // Catch: Throwable -> L4
        r101.setAccessible(true);     // Catch: Throwable -> L4
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

    public static LoadedApk getLoadedApk(String r100) {
        Map r101 = getLoadedApkMap();
        if (r101 != null) goto L5;
        return null;
    L5:
        Object r102 = r101.get(r100);
        if (r102 != null) goto L13;
        return null;
    L13:
        return (LoadedApk) ((WeakReference) r102).get();
    L10:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "LoadedApkFactory getLoadedApk Fail.", th);
        return null;
    }

    public static LoadedApk createLoadedApk(ApplicationInfo r100, Object r101) {
        Constructor<?> r102 = sLoadedApkConstructor;     // Catch: Throwable -> L11
        if (r102 != null) goto L7;
        MiraLogger.e(MiraLogger.TAG_LOAD, "LoadedApkFactory createLoadedApk Fail. sLoadedApkConstructor==null !");     // Catch: Throwable -> L11
        return null;
    L7:
        Boolean r103 = Boolean.FALSE;     // Catch: Throwable -> L11
        LoadedApk r104 = (LoadedApk) r102.newInstance(new Object[]{(ActivityThread) ActivityThreadHelper.currentActivityThread(), r100, (CompatibilityInfo) r101, null, r103, Boolean.TRUE, r103});     // Catch: Throwable -> L11
        Map r105 = getLoadedApkMap();     // Catch: Throwable -> L11
        if (r105 == null) goto L10;
        r105.put(r100.packageName, new WeakReference(r104));     // Catch: Throwable -> L11
    L10:
        return r104;
    L11:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "LoadedApkFactory createLoadedApk Fail.", th);
        return null;
    }
}
