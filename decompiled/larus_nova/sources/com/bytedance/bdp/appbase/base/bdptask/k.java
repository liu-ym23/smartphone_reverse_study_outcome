package com.bytedance.bdp.appbase.base.bdptask;

import android.app.Application;
import android.text.TextUtils;
import androidx.core.os.TraceCompat;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpContextService;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f200514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<LinkedList<TracePoint>> f200515b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f200516c = 0;

    static {
        f200515b = new ThreadLocal();
        if (f() == false) goto L5;
        int r100 = 150;
    L6:
        f200516c = r100;
        return;
    L5:
        r100 = 15;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.Trace");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.Trace");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.Trace");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.Trace");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.Trace");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.Trace");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.Trace");
    }

    public static boolean f() {
        if (f200514a != null) goto L22;
        BdpInfoService r100 = (BdpInfoService) BdpManager.getInst().getService(BdpInfoService.class);
        if (r100 == null) goto L7;
        f200514a = Boolean.valueOf(r100.isDebugMode());
    L9:
        if (f200514a.booleanValue() == true) goto L22;
        Application r101 = ((BdpContextService) BdpManager.getInst().getService(BdpContextService.class)).getHostApplication();     // Catch: Throwable -> L23
        if ("com.bytedance.miniapp.app".equals(r101.getPackageName()) == false) goto L13;
        f200514a = Boolean.TRUE;     // Catch: Throwable -> L23
    L19:
        if (f200514a.booleanValue() == false) goto L22;
        a().getDeclaredMethod("setAppTracingAllowed", new Class[]{Boolean.TYPE}).invoke(null, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L23
        goto L22
    L13:
        f94.a.c().getClass();     // Catch: Throwable -> L23
        if (TextUtils.equals(f94.a.a(), "local_test") == false) goto L19;
        if (new PolarisFileWrapper((r101.getExternalCacheDir() + HTTP.URL_DEFAULT) + "debug.flag").exists() == false) goto L19;
        f200514a = Boolean.TRUE;     // Catch: Throwable -> L23
        goto L19
    L7:
        f200514a = Boolean.FALSE;
    L22:
        return f200514a.booleanValue();
    }

    public static void e() {
        if (f() == false) goto L6;
        TraceCompat.endSection();
        return;
    }

    public static void d(TracePoint r100) {
        if (f() == false) goto L16;
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getEventKeyName());
        r101.append(":");
        if (TextUtils.isEmpty(r100.f200479sub) == true) goto L8;
        r101.append("(");
        r101.append(r100.f200479sub);
        r101.append(")");
    L8:
        if (TextUtils.isEmpty(r100.trace) == false) goto L10;
        r101.append("Empty Trace");
    L11:
        String r102 = r101.toString();
        if (r102.length() <= 120) goto L14;
        r102 = r102.substring(0, 120);
    L14:
        TraceCompat.beginSection(r102);
        return;
    L10:
        r101.append(r100.trace);
        goto L11
    }

    public static void b(LinkedList<TracePoint> r100, TracePoint r101) {
        if (TextUtils.isEmpty(r101.trace) == false) goto L5;
        return;
    L5:
        monitor-enter(r100);
        r100.addFirst(r101);     // Catch: Throwable -> L12
    L8:
        if (r100.size() <= f200516c) goto L10;
        r100.removeLast();     // Catch: Throwable -> L12
        goto L8
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void c(LinkedList<TracePoint> r100, TracePoint r101) {
        if (TracePoint.isEnable(r101.event) == true) goto L5;
        return;
    L5:
        b(r100, r101);
        if (f() == false) goto L9;
        d(r101);
        e();
        return;
    }
}
