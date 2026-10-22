package com.bytedance.mira.core.opt.res.ext;

import android.app.ActivityThread;
import android.app.ResourcesManager;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.trip.natvierutime.artmethod.ArtMethodExt;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class SystemSupportExtApi21Impl extends SystemSupportExtImpl {
    public static final int APPLICATION_INFO_CHANGED = 156;
    public static final int DISPATCH_PACKAGE_BROADCAST = 133;
    private static final String HANDLE_APPLICATION_INFO_CHANGED_PREX = "handleApplicationInfoChanged";
    private static final String SCHEDULE_APPLICATION_INFO_CHANGED_PREX = "scheduleApplicationInfoChanged";
    private static final String TAG = "SystemSupportExtApi21Impl";

    private void clearPendingAppInfoUpdates() {
        if (Build.VERSION.SDK_INT >= 31) goto L29;
        return;
    L29:
        Field r100 = ReflectUtils.findDeclaredField(ResourcesManager.class, "mLock");     // Catch: Throwable -> L24
        if (r100 != null) goto L9;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearPendingAppInfoUpdates err: lockField == null !");     // Catch: Throwable -> L24
        return;
    L9:
        Object r101 = r100.get(ResourcesManager.getInstance());     // Catch: Throwable -> L24
        if (r101 != null) goto L13;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearPendingAppInfoUpdates err: lock == null !");     // Catch: Throwable -> L24
        return;
    L13:
        Field r102 = ReflectUtils.findDeclaredField(ResourcesManager.class, "mPendingAppInfoUpdates");     // Catch: Throwable -> L24
        if (r102 != null) goto L17;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearPendingAppInfoUpdates err: pendingAppInfoUpdatesField == null !");     // Catch: Throwable -> L24
        return;
    L17:
        monitor-enter(r101);     // Catch: Throwable -> L24
        r102.set(ResourcesManager.getInstance(), null);     // Catch: Throwable -> L21
        monitor-exit(r101);     // Catch: Throwable -> L21
    L30:
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearPendingAppInfoUpdates err:" + Log.getStackTraceString(th));
    }

    private void disableHandleDispatchPackageBroadcast() {
        if (Build.VERSION.SDK_INT >= 29) goto L13;
        return;
    L13:
        Method r100 = ReflectUtils.findDeclaredMethod(Class.forName("android.app.ActivityThread"), "handleDispatchPackageBroadcast", new Class[]{Integer.TYPE, String[].class});     // Catch: Throwable -> L10
        if (r100 != null) goto L8;
        return;
    L8:
        ArtMethodExt.disableRun(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableHandleDispatchPackageBroadcast err:" + Log.getStackTraceString(th));
    }

    private void clearApplicationInfoChangedMsg() {
        if (Build.VERSION.SDK_INT >= 26) goto L26;
        return;
    L26:
        Method r100 = ReflectUtils.findDeclaredMethod(ActivityThread.class, "currentActivityThread", new Class[0]);     // Catch: Throwable -> L23
        if (r100 != null) goto L9;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearApplicationInfoChangedMsg err: currentActivityThreadMethod == null ！");     // Catch: Throwable -> L23
        return;
    L9:
        r100.setAccessible(true);     // Catch: Throwable -> L23
        Object r101 = r100.invoke(null, new Object[0]);     // Catch: Throwable -> L23
        if (r101 != null) goto L13;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearApplicationInfoChangedMsg err: activityThread == null ！");     // Catch: Throwable -> L23
        return;
    L13:
        Field r102 = ReflectUtils.findDeclaredField(ActivityThread.class, "mH");     // Catch: Throwable -> L23
        if (r102 != null) goto L17;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearApplicationInfoChangedMsg err: hFiled == null ！");     // Catch: Throwable -> L23
        return;
    L17:
        Handler r103 = (Handler) r102.get(r101);     // Catch: Throwable -> L23
        if (r103 != null) goto L21;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearApplicationInfoChangedMsg err: mH == null ！");     // Catch: Throwable -> L23
        return;
    L21:
        r103.removeMessages(156);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearApplicationInfoChangedMsg err:" + Log.getStackTraceString(th));
    }

    private void clearDispatchPackageBroadcastMsg() {
        if (Build.VERSION.SDK_INT >= 29) goto L26;
        return;
    L26:
        Method r100 = ReflectUtils.findDeclaredMethod(ActivityThread.class, "currentActivityThread", new Class[0]);     // Catch: Throwable -> L23
        if (r100 != null) goto L9;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearDispatchPackageBroadcastMsg err: currentActivityThreadMethod == null ！");     // Catch: Throwable -> L23
        return;
    L9:
        r100.setAccessible(true);     // Catch: Throwable -> L23
        Object r101 = r100.invoke(null, new Object[0]);     // Catch: Throwable -> L23
        if (r101 != null) goto L13;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearDispatchPackageBroadcastMsg err: activityThread == null ！");     // Catch: Throwable -> L23
        return;
    L13:
        Field r102 = ReflectUtils.findDeclaredField(ActivityThread.class, "mH");     // Catch: Throwable -> L23
        if (r102 != null) goto L17;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearDispatchPackageBroadcastMsg err: hFiled == null ！");     // Catch: Throwable -> L23
        return;
    L17:
        Handler r103 = (Handler) r102.get(r101);     // Catch: Throwable -> L23
        if (r103 != null) goto L21;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearDispatchPackageBroadcastMsg err: mH == null ！");     // Catch: Throwable -> L23
        return;
    L21:
        r103.removeMessages(133);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl clearDispatchPackageBroadcastMsg err:" + Log.getStackTraceString(th));
    }

    private void disableDispatchPackageBroadcast() {
        if (Build.VERSION.SDK_INT >= 29) goto L14;
        return;
    L14:
        Method r100 = ReflectUtils.findDeclaredMethod(Class.forName("android.app.ActivityThread$ApplicationThread"), "dispatchPackageBroadcast", new Class[]{Integer.TYPE, String[].class});     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableDispatchPackageBroadcast err: dispatchPackageBroadcastMethod == null ！");     // Catch: Throwable -> L11
        return;
    L9:
        ArtMethodExt.disableRun(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableDispatchPackageBroadcast err:" + Log.getStackTraceString(th));
    }

    private void disableHandleApplicationInfoChangedUsed() {
        if (Build.VERSION.SDK_INT >= 26) goto L25;
        return;
    L25:
        Method[] r100 = Class.forName("android.app.ActivityThread").getDeclaredMethods();     // Catch: Throwable -> L22
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L22
        int r102 = r100.length;     // Catch: Throwable -> L22
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L14;
        Method r104 = r100[r103];     // Catch: Throwable -> L22
        if (r104 == null) goto L12;
        if (r104.getName().startsWith(HANDLE_APPLICATION_INFO_CHANGED_PREX) == false) goto L12;
        r101.add(r104);     // Catch: Throwable -> L22
    L12:
        r103 = r103 + 1;     // Catch: Throwable -> L22
        goto L6
    L14:
        if (r101.isEmpty() == false) goto L17;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableHandleApplicationInfoChangedUsed err: disableMethodList is empty !");     // Catch: Throwable -> L22
        return;
    L17:
        Iterator r105 = r101.iterator();     // Catch: Throwable -> L22
    L19:
        if (r105.hasNext() == false) goto L31;
        ArtMethodExt.disableRun((Method) r105.next());     // Catch: Throwable -> L22
        goto L19
    L31:
        return;
    L22:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableHandleApplicationInfoChangedUsed err:" + Log.getStackTraceString(th));
    }

    private void disableScheduleApplicationInfoChangedUsed() {
        if (Build.VERSION.SDK_INT >= 26) goto L25;
        return;
    L25:
        Method[] r100 = Class.forName("android.app.ActivityThread$ApplicationThread").getDeclaredMethods();     // Catch: Throwable -> L22
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L22
        int r102 = r100.length;     // Catch: Throwable -> L22
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L14;
        Method r104 = r100[r103];     // Catch: Throwable -> L22
        if (r104 == null) goto L12;
        if (r104.getName().startsWith(SCHEDULE_APPLICATION_INFO_CHANGED_PREX) == false) goto L12;
        r101.add(r104);     // Catch: Throwable -> L22
    L12:
        r103 = r103 + 1;     // Catch: Throwable -> L22
        goto L6
    L14:
        if (r101.isEmpty() == false) goto L17;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableScheduleApplicationInfoChangedUsed err: disableMethodList is empty !");     // Catch: Throwable -> L22
        return;
    L17:
        Iterator r105 = r101.iterator();     // Catch: Throwable -> L22
    L19:
        if (r105.hasNext() == false) goto L31;
        ArtMethodExt.disableRun((Method) r105.next());     // Catch: Throwable -> L22
        goto L19
    L31:
        return;
    L22:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableScheduleApplicationInfoChangedUsed err:" + Log.getStackTraceString(th));
    }

    private void disableScheduleApplicationInfoChangedUsedForHonor() {
        if (Build.VERSION.SDK_INT >= 26) goto L14;
        return;
    L14:
        Method r100 = ReflectUtils.findDeclaredMethod(Class.forName("android.app.ActivityThread$ApplicationThread"), "scheduleApplicationThemeInfoChanged", new Class[]{ApplicationInfo.class, Boolean.TYPE});     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableScheduleApplicationInfoChangedUsedForHonor err: scheduleApplicationInfoChangedMethod == null !");     // Catch: Throwable -> L11
        return;
    L9:
        ArtMethodExt.disableRun(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableScheduleApplicationInfoChangedUsedForHonor err:" + Log.getStackTraceString(th));
    }

    private void disableUpdateApplicationInfoUsed() {
        if (Build.VERSION.SDK_INT >= 24) goto L14;
        return;
    L14:
        Method r100 = ReflectUtils.findDeclaredMethod(Class.forName("android.app.LoadedApk"), "updateApplicationInfo", new Class[]{ApplicationInfo.class, List.class});     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableUpdateApplicationInfoUsed err: updateApplicationInfoMethod == null ！");     // Catch: Throwable -> L11
        return;
    L9:
        ArtMethodExt.disableRun(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "SystemSupportExtApi21Impl disableUpdateApplicationInfoUsed err:" + Log.getStackTraceString(th));
    }

    @Override // com.bytedance.mira.core.opt.res.ext.ISystemSupportExt
    public void init() {
        initArtMethodExt();
        disableHandleApplicationInfoChangedUsed();
        disableScheduleApplicationInfoChangedUsed();
        disableScheduleApplicationInfoChangedUsedForHonor();
        clearPendingAppInfoUpdates();
        clearApplicationInfoChangedMsg();
        disableUpdateApplicationInfoUsed();
        disableHandleDispatchPackageBroadcast();
        disableDispatchPackageBroadcast();
        clearDispatchPackageBroadcastMsg();
    }

    public SystemSupportExtApi21Impl() {
    }

    private void initArtMethodExt() {
        ArtMethodExt.init();
    }
}
