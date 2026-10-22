package com.larus.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f375455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f375456b;

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    @JvmStatic
    public static final String b(Context r100) {
        String r101 = "";
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = f375455a;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L83;
        return f375455a;
    L83:
        Class r105 = a();     // Catch: Exception -> L18
        Object r106 = r105.getMethod("getProcessName", new Class[0]).invoke(r105.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);     // Catch: Exception -> L18
        if ((r106 instanceof String) == false) goto L17;
        String r107 = (String) r106;     // Catch: Exception -> L18
    L20:
        f375455a = r107;
        String r108 = f375455a;
        if (r108 != null) goto L23;
    L26:
        boolean r109 = true;
    L27:
        if (r109 == false) goto L29;
        Object r110 = r100.getSystemService("activity");     // Catch: Exception -> L53
        if ((r110 instanceof ActivityManager) == false) goto L33;
        ActivityManager r111 = (ActivityManager) r110;     // Catch: Exception -> L53
    L34:
        if (r111 == null) goto L37;
        List<ActivityManager.RunningAppProcessInfo> r112 = r111.getRunningAppProcesses();     // Catch: Exception -> L53
        if (r112 == null) goto L37;
    L38:
        int r113 = Process.myPid();     // Catch: Exception -> L53
        Iterator<T> r114 = r112.iterator();     // Catch: Exception -> L53
    L40:
        if (r114.hasNext() == false) goto L47;
        Object r115 = r114.next();     // Catch: Exception -> L53
        if (((ActivityManager.RunningAppProcessInfo) r115).pid != r113) goto L44;
        boolean r116 = true;
    L45:
        if (r116 == false) goto L40;
    L48:
        ActivityManager.RunningAppProcessInfo r117 = (ActivityManager.RunningAppProcessInfo) r115;     // Catch: Exception -> L53
        if (r117 == null) goto L52;
        String r118 = r117.processName;     // Catch: Exception -> L53
    L55:
        f375455a = r118;
        String r119 = f375455a;
        if (r119 != null) goto L58;
    L61:
        if (r103 == false) goto L63;
        BufferedReader r120 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/self/cmdline")));     // Catch: IOException -> L77 FileNotFoundException -> L79
        StringBuilder r121 = new StringBuilder();     // Catch: Throwable -> L72
    L66:
        int r122 = r120.read();     // Catch: Throwable -> L72
        if (r122 <= 0) goto L69;
        r121.append((char) r122);     // Catch: Throwable -> L72
        goto L66
    L69:
        String r123 = r121.toString();     // Catch: Throwable -> L72
        CloseableKt.closeFinally(r120, null);     // Catch: IOException -> L77 FileNotFoundException -> L79
        r101 = r123;
    L81:
        f375455a = r101;
        return f375455a;
    L72:
        th = move-exception;
        throw th;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        CloseableKt.closeFinally(r120, th);     // Catch: IOException -> L77 FileNotFoundException -> L79
        throw th;     // Catch: IOException -> L77 FileNotFoundException -> L79
    L79:
        e = move-exception;
        FLogger.f375446a.e("SystemUtil", "getProcessName  FileNotFoundException, error " + e);
    L77:
        e = move-exception;
        FLogger.f375446a.e("SystemUtil", "getProcessName  IOException, error " + e);
        goto L81
    L63:
        return f375455a;
    L58:
        if (r119.length() == 0) goto L61;
        r103 = false;
        goto L61
    L52:
        r118 = null;
        goto L55
    L44:
        r116 = false;
        goto L45
    L47:
        r115 = null;
    L37:
        r112 = CollectionsKt.emptyList();     // Catch: Exception -> L53
        goto L38
    L33:
        r111 = null;
    L53:
        e = move-exception;
        FLogger.f375446a.e("SystemUtil", "getProcessName  with ActivityThread method, error " + e);
        r118 = "";
        goto L55
    L29:
        return f375455a;
    L23:
        if (r108.length() == 0) goto L26;
        r109 = false;
        goto L27
    L17:
        r107 = null;
    L18:
        e = move-exception;
        FLogger.f375446a.e("SystemUtil", "getProcessName with ActivityThread method, error " + e);
        r107 = "";
        goto L20
    L5:
        if (r102.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (f375456b != null) goto L17;
        String r101 = b(r100);
        boolean r102 = true;
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
    L15:
        r102 = false;
    L16:
        f375456b = Boolean.valueOf(r102);
        goto L17
    L13:
        if (Intrinsics.areEqual(r101, r100.getPackageName()) == false) goto L15;
    L7:
        if (r101.length() == 0) goto L10;
        r103 = false;
    L17:
        Boolean r104 = f375456b;
        if (r104 != null) goto L20;
        return false;
    L20:
        return r104.booleanValue();
    }
}
