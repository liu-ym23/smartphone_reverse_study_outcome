package com.bytedance.mira.helper;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.MiraManager;
import com.bytedance.mira.MiraParamPre;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ProcessHelper {
    private static List<String> pluginProcessNameRegExpList;
    private static String sCurrentProcessName;

    public ProcessHelper() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    static {
        pluginProcessNameRegExpList = new CopyOnWriteArrayList();
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L15
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r3 = r2.read();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L9;
        r0.append((char) r3);     // Catch: Throwable -> L14
        goto L5
    L9:
        if (MiraLogger.isDebug() == false) goto L11;
        MiraLogger.d("Process", "get processName = " + r0.toString());     // Catch: Throwable -> L14
    L11:
        String r1 = r0.toString();     // Catch: Throwable -> L14
        r2.close();     // Catch: Exception -> L19
    L13:
        return r1;
    L16:
        if (r2 != null) goto L27;
    L18:
        return null;
    L27:
        r2.close();     // Catch: Exception -> L20
    L15:
        r2 = null;
        goto L16
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_helper_ProcessHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
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
        return MiraPluginFix.forName(r3);
    }

    public static void addPluginProcNames(List<String> r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.size() <= 0) goto L8;
        pluginProcessNameRegExpList.addAll(r1);
        return;
    }

    public static void addPluginProcessRegExp(String r1) {
        pluginProcessNameRegExpList.add(r1);
    }

    public static String getCurrentProcessName(Context r1) {
        MiraParamPre r0 = MiraManager.getInstance().getParamPre();
        if (r0 == null) goto L9;
        if (r0.isEnableInitProcessOpt() == false) goto L9;
        return ProcessHelperOpt.getCurrentProcessName();
    L9:
        return getsCurrentProcessNameOld(r1);
    }

    private static String getsCurrentProcessNameOld(Context r3) {
        if (TextUtils.isEmpty(sCurrentProcessName) == false) goto L5;
        int r0 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r4 = ((ActivityManager) r3.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L8:
        if (r4.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r1 = r4.next();     // Catch: Exception -> L13
        if (r1.pid != r0) goto L8;
        String r5 = r1.processName;     // Catch: Exception -> L13
        sCurrentProcessName = r5;     // Catch: Exception -> L13
        return r5;
    L15:
        String r6 = getCurProcessNameFromProc();
        sCurrentProcessName = r6;
        return r6;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return sCurrentProcessName;
    }

    public static boolean isMainProcess(Context r1) {
        MiraParamPre r0 = MiraManager.getInstance().getParamPre();
        if (r0 == null) goto L9;
        if (r0.isEnableInitProcessOpt() == false) goto L9;
        return ProcessHelperOpt.isMainProcess(r1);
    L9:
        return isMainProcessOld(r1);
    }

    public static boolean isMainProcessOld(Context r3) {
        String r0 = getCurrentProcessName(r3);
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r3.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }

    public static boolean isPluginProcess(Context r4) {
        String r5 = getCurrentProcessName(r4);
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.contains(":plugin") == false) goto L8;
        return true;
    L8:
        Iterator<String> r1 = pluginProcessNameRegExpList.iterator();
    L10:
        if (r1.hasNext() == false) goto L14;
        if (r5.matches(r1.next()) == false) goto L10;
        return true;
    L14:
        return false;
    }

    public static final void setProcessName(String r6) {
        MethodUtils.getAccessibleMethod(INVOKESTATIC_com_bytedance_mira_helper_ProcessHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.Process"), "setArgV0", new Class[]{String.class}).invoke(null, new Object[]{r6});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
