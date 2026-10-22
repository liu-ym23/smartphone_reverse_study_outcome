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

/* JADX INFO: loaded from: classes.dex */
public class ProcessHelper {
    private static List<String> pluginProcessNameRegExpList;
    private static String sCurrentProcessName;

    public ProcessHelper() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        pluginProcessNameRegExpList = new CopyOnWriteArrayList();
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r100 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L15
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r102 = r100.read();     // Catch: Throwable -> L14
        if (r102 <= 0) goto L9;
        r101.append((char) r102);     // Catch: Throwable -> L14
        goto L5
    L9:
        if (MiraLogger.isDebug() == false) goto L11;
        MiraLogger.d("Process", "get processName = " + r101.toString());     // Catch: Throwable -> L14
    L11:
        String r103 = r101.toString();     // Catch: Throwable -> L14
        r100.close();     // Catch: Exception -> L19
    L13:
        return r103;
    L16:
        if (r100 != null) goto L27;
    L18:
        return null;
    L27:
        r100.close();     // Catch: Exception -> L20
    L15:
        r100 = null;
        goto L16
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_helper_ProcessHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void addPluginProcNames(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L8;
        pluginProcessNameRegExpList.addAll(r100);
        return;
    }

    public static void addPluginProcessRegExp(String r100) {
        pluginProcessNameRegExpList.add(r100);
    }

    public static String getCurrentProcessName(Context r100) {
        MiraParamPre r101 = MiraManager.getInstance().getParamPre();
        if (r101 == null) goto L9;
        if (r101.isEnableInitProcessOpt() == false) goto L9;
        return ProcessHelperOpt.getCurrentProcessName();
    L9:
        return getsCurrentProcessNameOld(r100);
    }

    private static String getsCurrentProcessNameOld(Context r100) {
        if (TextUtils.isEmpty(sCurrentProcessName) == false) goto L5;
        int r101 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r102 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L8:
        if (r102.hasNext() == false) goto L15;
        ActivityManager.RunningAppProcessInfo r103 = r102.next();     // Catch: Exception -> L13
        if (r103.pid != r101) goto L8;
        String r104 = r103.processName;     // Catch: Exception -> L13
        sCurrentProcessName = r104;     // Catch: Exception -> L13
        return r104;
    L15:
        String r105 = getCurProcessNameFromProc();
        sCurrentProcessName = r105;
        return r105;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L5:
        return sCurrentProcessName;
    }

    public static boolean isMainProcess(Context r100) {
        MiraParamPre r101 = MiraManager.getInstance().getParamPre();
        if (r101 == null) goto L9;
        if (r101.isEnableInitProcessOpt() == false) goto L9;
        return ProcessHelperOpt.isMainProcess(r100);
    L9:
        return isMainProcessOld(r100);
    }

    public static boolean isMainProcessOld(Context r100) {
        String r101 = getCurrentProcessName(r100);
        if (r101 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.equals(r100.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r101.contains(":") == false) goto L7;
        return false;
    }

    public static boolean isPluginProcess(Context r100) {
        String r101 = getCurrentProcessName(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.contains(":plugin") == false) goto L8;
        return true;
    L8:
        Iterator<String> r102 = pluginProcessNameRegExpList.iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        if (r101.matches(r102.next()) == false) goto L10;
        return true;
    L14:
        return false;
    }

    public static final void setProcessName(String r100) {
        MethodUtils.getAccessibleMethod(INVOKESTATIC_com_bytedance_mira_helper_ProcessHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.Process"), "setArgV0", new Class[]{String.class}).invoke(null, new Object[]{r100});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
