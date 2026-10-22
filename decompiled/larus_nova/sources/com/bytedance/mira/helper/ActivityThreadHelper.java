package com.bytedance.mira.helper;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.ArrayMap;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParam;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.factory.LoadedApkFactory;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityThreadHelper {
    private static final String TAG = "ActivityThreadHelper";
    private static Object sActivityThread;
    private static Class sClassForActivityThread;

    public ActivityThreadHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static final Object currentActivityThread() {
        if (sActivityThread != null) goto L38;
        monitor-enter(ActivityThreadHelper.class);     // Catch: Exception -> L35
    L32:
        th = move-exception;
        throw th;     // Catch: Exception -> L35
    L7:
        if (sActivityThread != null) goto L13;
        if (sClassForActivityThread != null) goto L11;
        sClassForActivityThread = INVOKESTATIC_com_bytedance_mira_helper_ActivityThreadHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread");     // Catch: Throwable -> L32
    L11:
        sActivityThread = MethodUtils.invokeStaticMethod(sClassForActivityThread, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L32
    L13:
        if (sActivityThread == null) goto L15;
    L30:
        monitor-exit(ActivityThreadHelper.class);     // Catch: Throwable -> L32
        goto L38
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        final Object r100 = new Object();     // Catch: Throwable -> L32
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(r100));     // Catch: Throwable -> L32
        if (sActivityThread != null) goto L30;
        monitor-enter(r100);     // Catch: Throwable -> L32
        r100.wait(5000);     // Catch: Throwable -> L22 InterruptedException -> L24
    L26:
        monitor-exit(r100);     // Catch: Throwable -> L22
    L24:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L35:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e);
    L38:
        return sActivityThread;
    }

    public static List<Activity> getActivities() {
        ArrayList r100 = new ArrayList();
        Iterator<Object> r101 = getActivityRecords().iterator();
    L4:
        if (r101.hasNext() == false) goto L12;
        Object r102 = r101.next();
        Activity r103 = (Activity) FieldUtils.readField(r102, "activity");     // Catch: Exception -> L8
    L10:
        if (r103 == null) goto L4;
        r100.add(r103);
    L8:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ActivityThreadHelper reflect activityRecord.activity failed, record = " + r102, e);
        r103 = null;
        goto L10
    L12:
        return r100;
    }

    public static List<Object> getActivityRecords() {
        ArrayList r100 = new ArrayList();
        Object r101 = FieldUtils.readField(currentActivityThread(), "mActivities");     // Catch: Exception -> L12
        if ((r101 instanceof HashMap) == false) goto L7;
        r100.addAll(((HashMap) r101).values());     // Catch: Exception -> L12
    L15:
    L14:
        return r100;
    L7:
        if (OSUtil.isAndroidKHigher() == false) goto L15;
        if ((r101 instanceof ArrayMap) == false) goto L15;
        r100.addAll(((ArrayMap) r101).values());     // Catch: Exception -> L12
    L12:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ActivityThreadHelper getActivityRecords failed.", e);
        goto L14
    }

    public static List<Application> getApplications() {
        return new ArrayList((List) FieldUtils.readField(currentActivityThread(), "mAllApplications"));
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ActivityThreadHelper getApplications failed.", th);
        return null;
    }

    public static Object getAppBindData() {
        return FieldUtils.readField(currentActivityThread(), "mBoundApplication");
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ActivityThreadHelper getAppBindData failed.", e);
        return null;
    }

    public static Map getCachedLoadedApkMap() {
        Object r100 = currentActivityThread();
        if (r100 != null) goto L14;
    L8:
        Object r101 = null;
    L10:
        if ((r101 instanceof Map) == true) goto L12;
        return null;
    L12:
        return (Map) r101;
    L14:
        r101 = FieldUtils.readField(r100, "mPackages");     // Catch: IllegalAccessException -> L6
    L6:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ActivityThreadHelper getCachedLoadedApkMap failed.", e);
        goto L8
    }

    public static Instrumentation getInstrumentation() {
        return (Instrumentation) MethodUtils.invokeMethod(currentActivityThread(), "getInstrumentation", new Object[0]);
    L4:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ActivityThreadHelper getInstrumentation failed.", e);
        return null;
    }

    public static List<ProviderInfo> getProviders() {
        Object r100 = getAppBindData();     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return (List) FieldUtils.readField(r100, "providers");
    L12:
        return null;
    L6:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "ActivityThreadHelper getProviders failed", e);
        return null;
    }

    public static /* synthetic */ Class access$100() {
        return sClassForActivityThread;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_helper_ActivityThreadHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ Object access$002(Object r100) {
        sActivityThread = r100;
        return r100;
    }

    public static Object createLoadedApk(ApplicationInfo r110) {
        Object r100 = null;
        if (r110 != null) goto L25;
    L24:
        return r100;
    L25:
        Object r101 = currentActivityThread();     // Catch: Exception -> L22
        if (OSUtil.isAndroidHHigher() == false) goto L19;
        MiraParam r102 = MiraManager.getInstance().getParam();     // Catch: Exception -> L22
        if (r102 != null) goto L10;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == false) goto L17;
        r100 = LoadedApkFactory.createLoadedApk(r110, CompatibilityInfoHelper.getHostCompatibilityInfoNew());     // Catch: Exception -> L22
        MiraLogger.i(MiraLogger.TAG_LOAD, "ActivityThreadHelper createLoadedApk with new method, " + r110 + " >> " + r100);     // Catch: Exception -> L22
    L17:
        if (r100 != null) goto L20;
        r100 = MethodUtils.invokeMethod(r101, "getPackageInfoNoCheck", new Object[]{r110, CompatibilityInfoHelper.getHostCompatibilityInfo()});     // Catch: Exception -> L22
        MiraLogger.i(MiraLogger.TAG_LOAD, "ActivityThreadHelper createLoadedApk with old method, " + r110 + " >> " + r100);     // Catch: Exception -> L22
    L20:
        MiraLogger.i(MiraLogger.TAG_LOAD, "ActivityThreadHelper createLoadedApk, " + r110 + " >> " + r100);     // Catch: Exception -> L22
        goto L24
    L10:
        if (r102.isEnableOptCreateLoadedApk() == false) goto L14;
        if (OSUtil.isAndroidLHigher() == false) goto L14;
        r103 = true;
        goto L15
    L19:
        r100 = MethodUtils.invokeMethod(r101, "getPackageInfoNoCheck", new Object[]{r110});     // Catch: Exception -> L22
    L22:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ActivityThreadHelper createLoadedApk failed.", e);
        goto L24
    }

    public static Object getCachedLoadedApk(String r100) {
        Map r101 = (Map) FieldUtils.readField(currentActivityThread(), "mPackages");     // Catch: Exception -> L8
        WeakReference r102 = (WeakReference) r101.get(r100);     // Catch: Exception -> L8
        if (r102 == null) goto L7;
        return r102.get();
    L7:
        return r101.get(r100);
    L8:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ActivityThreadHelper getCachedLoadedApk failed.", e);
        return null;
    }

    public static void removePluginLoadedApk(String r100) {
        Map r101 = getCachedLoadedApkMap();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.containsKey(r100) == false) goto L9;
        r101.remove(r100);
        return;
    }

    public static void setApplications(List<Application> r100) {
        FieldUtils.writeField(currentActivityThread(), "mAllApplications", r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ActivityThreadHelper setApplications failed.", th);
    }

    public static void installContentProviders(Context r100, List<ProviderInfo> r101) {
        MethodUtils.invokeMethod(currentActivityThread(), "installContentProviders", new Object[]{r100, r101});     // Catch: Exception -> L5
        MiraLogger.w(MiraLogger.TAG_LOAD, "ActivityThreadHelper installContentProviders, size = " + r101.size());     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_LOAD, "ActivityThreadHelper installContentProviders failed.", e);
    }
}
