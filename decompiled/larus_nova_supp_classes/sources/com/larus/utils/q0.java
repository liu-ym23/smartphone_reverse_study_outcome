package com.larus.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import el9.a;
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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class q0 {
    public static volatile String a;
    public static volatile Boolean b;

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
    public static final String b(Context r9) {
        String r0 = XmlPullParser.NO_NAMESPACE;
        Intrinsics.checkNotNullParameter(r9, "context");
        String r2 = a;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L83;
        return a;
    L83:
        Class r5 = a();     // Catch: Exception -> L18
        Object r6 = r5.getMethod("getProcessName", new Class[0]).invoke(r5.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);     // Catch: Exception -> L18
        if ((r6 instanceof String) == false) goto L17;
        String r7 = (String) r6;     // Catch: Exception -> L18
    L20:
        a = r7;
        String r8 = a;
        if (r8 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        if (r10 == false) goto L29;
        Object r11 = r9.getSystemService("activity");     // Catch: Exception -> L53
        if ((r11 instanceof ActivityManager) == false) goto L33;
        ActivityManager r12 = (ActivityManager) r11;     // Catch: Exception -> L53
    L34:
        if (r12 == null) goto L37;
        List<ActivityManager.RunningAppProcessInfo> r13 = r12.getRunningAppProcesses();     // Catch: Exception -> L53
        if (r13 == null) goto L37;
    L38:
        int r14 = Process.myPid();     // Catch: Exception -> L53
        Iterator<T> r15 = r13.iterator();     // Catch: Exception -> L53
    L40:
        if (r15.hasNext() == false) goto L47;
        Object r16 = r15.next();     // Catch: Exception -> L53
        if (((ActivityManager.RunningAppProcessInfo) r16).pid != r14) goto L44;
        boolean r17 = true;
    L45:
        if (r17 == false) goto L40;
    L48:
        ActivityManager.RunningAppProcessInfo r18 = (ActivityManager.RunningAppProcessInfo) r16;     // Catch: Exception -> L53
        if (r18 == null) goto L52;
        String r19 = r18.processName;     // Catch: Exception -> L53
    L55:
        a = r19;
        String r20 = a;
        if (r20 != null) goto L58;
    L61:
        if (r3 == false) goto L63;
        BufferedReader r21 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/self/cmdline")));     // Catch: IOException -> L77 FileNotFoundException -> L79
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L72
    L66:
        int r23 = r21.read();     // Catch: Throwable -> L72
        if (r23 <= 0) goto L69;
        r22.append((char) r23);     // Catch: Throwable -> L72
        goto L66
    L69:
        String r24 = r22.toString();     // Catch: Throwable -> L72
        CloseableKt.closeFinally(r21, null);     // Catch: IOException -> L77 FileNotFoundException -> L79
        r0 = r24;
    L81:
        a = r0;
        return a;
    L72:
        th = move-exception;
        throw th;     // Catch: Throwable -> L74
    L74:
        th = move-exception;
        CloseableKt.closeFinally(r21, th);     // Catch: IOException -> L77 FileNotFoundException -> L79
        throw th;     // Catch: IOException -> L77 FileNotFoundException -> L79
    L79:
        e = move-exception;
        FLogger.a.e("SystemUtil", "getProcessName  FileNotFoundException, error " + e);
    L77:
        e = move-exception;
        FLogger.a.e("SystemUtil", "getProcessName  IOException, error " + e);
        goto L81
    L63:
        return a;
    L58:
        if (r20.length() == 0) goto L61;
        r3 = false;
        goto L61
    L52:
        r19 = null;
        goto L55
    L44:
        r17 = false;
        goto L45
    L47:
        r16 = null;
    L37:
        r13 = CollectionsKt.emptyList();     // Catch: Exception -> L53
        goto L38
    L33:
        r12 = null;
    L53:
        e = move-exception;
        FLogger.a.e("SystemUtil", "getProcessName  with ActivityThread method, error " + e);
        r19 = XmlPullParser.NO_NAMESPACE;
        goto L55
    L29:
        return a;
    L23:
        if (r8.length() == 0) goto L26;
        r10 = false;
        goto L27
    L17:
        r7 = null;
    L18:
        e = move-exception;
        FLogger.a.e("SystemUtil", "getProcessName with ActivityThread method, error " + e);
        r7 = XmlPullParser.NO_NAMESPACE;
        goto L20
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean c(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (b != null) goto L17;
        String r0 = b(r4);
        boolean r2 = true;
        if (r0 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
    L15:
        r2 = false;
    L16:
        b = Boolean.valueOf(r2);
        goto L17
    L13:
        if (Intrinsics.areEqual(r0, r4.getPackageName()) == false) goto L15;
    L7:
        if (r0.length() == 0) goto L10;
        r3 = false;
    L17:
        Boolean r5 = b;
        if (r5 != null) goto L20;
        return false;
    L20:
        return r5.booleanValue();
    }
}
