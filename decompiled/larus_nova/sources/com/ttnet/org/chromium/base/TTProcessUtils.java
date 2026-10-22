package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public class TTProcessUtils {
    public static final String MESSAGE_PROCESS_SERVICE_SUFFIX = ":pushservice";
    public static final String MESSAGE_PROCESS_SUFFIX = ":push";
    private static volatile String sCurProcessName;

    public TTProcessUtils() {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    private static String getCurrentProcessNameFromActivityThread() {
        Method r100 = INVOKESTATIC_com_ttnet_org_chromium_base_TTProcessUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r100.setAccessible(true);     // Catch: Throwable -> L7
        Object r101 = r100.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r101 instanceof String) == false) goto L12;
        return (String) r101;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
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
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r101.toString());     // Catch: Throwable -> L14
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

    private static String getCurrentProcessNameFromApplication() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static String getCurProcessName(Context r100) {
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L5;
        sCurProcessName = getCurrentProcessNameFromApplication();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L9;
        sCurProcessName = getCurrentProcessNameFromActivityThread();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L13;
        sCurProcessName = getCurProcessNameFromProc();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L17;
        sCurProcessName = getCurProcessNameFromActivityManager(r100);
        return sCurProcessName;
    L17:
        return sCurProcessName;
    L13:
        return sCurProcessName;
    L9:
        return sCurProcessName;
    L5:
        return sCurProcessName;
    }

    private static String getCurProcessNameFromActivityManager(Context r100) {
        String r101 = null;
        if (r100 != null) goto L18;
        return null;
    L18:
        int r102 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L6:
        if (r103.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r104 = r103.next();     // Catch: Exception -> L15
        if (r104.pid != r102) goto L6;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r104.processName);     // Catch: Exception -> L15
    L13:
        r101 = r104.processName;     // Catch: Exception -> L15
    L17:
        return r101;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static boolean isMainProcess(Context r100) {
        String r101 = getCurProcessName(r100);
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

    public static boolean isMessageProcess(Context r100) {
        String r101 = getCurProcessName(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.endsWith(MESSAGE_PROCESS_SUFFIX) == false) goto L7;
        return true;
    L7:
        if (r101.endsWith(MESSAGE_PROCESS_SERVICE_SUFFIX) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_base_TTProcessUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
}
