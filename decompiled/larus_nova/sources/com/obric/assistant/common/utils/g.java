package com.obric.assistant.common.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f387877a = null;

    static {
        f387877a = new g();
    }

    public g() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static boolean b(int r100, int r110, int r111, boolean r112) {
        FLogger r101 = FLogger.f375446a;
        r101.i("OSPerformanceschedHelper", "internalStartPerformanceSchedMode pid: " + r100 + ", tid: " + r110 + ", timeout: " + r111 + ", isForeground: " + r112);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Class r103 = a("android.app.CollaborationManager");     // Catch: Throwable -> L12
        Class<?> r104 = a("android.app.PerformanceSchedModeConfig");     // Catch: Throwable -> L12
        Object r105 = r104.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L12
        r104.getField("enable").setBoolean(r105, true);     // Catch: Throwable -> L12
        r104.getField("pid").setInt(r105, r100);     // Catch: Throwable -> L12
        r104.getField("tid").setInt(r105, r110);     // Catch: Throwable -> L12
        r104.getField("timeout").setInt(r105, r111);     // Catch: Throwable -> L12
        r104.getField("cpu").setInt(r105, 1);     // Catch: Throwable -> L12
        r104.getField(EffectConfiguration.KEY_GPU_INFO).setInt(r105, 1);     // Catch: Throwable -> L12
        if (r112 == false) goto L6;
        String r106 = "TYPE_TOP_APP";
    L7:
        Integer r113 = null;
        r104.getField("type").setInt(r105, r104.getField(r106).getInt(null));     // Catch: Throwable -> L12
        Object r107 = r103.getMethod("startPerformanceSchedMode", new Class[]{r104}).invoke(null, new Object[]{r105});     // Catch: Throwable -> L12
        if ((r107 instanceof Integer) == false) goto L10;
        r113 = (Integer) r107;     // Catch: Throwable -> L12
    L10:
        r101.i("OSPerformanceschedHelper", "internalStartPerformanceSchedMode invokeResult: " + r113);     // Catch: Throwable -> L12
        Object r108 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L12
    L14:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r108);
        if (r114 == null) goto L19;
        FLogger.f375446a.w("OSPerformanceschedHelper", "internalStartPerformanceSchedMode reflect failed", r114);
        r108 = Boolean.FALSE;
    L19:
        return ((Boolean) r108).booleanValue();
    L6:
        r106 = "TYPE_NON_FOREGROUND";
    L12:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
