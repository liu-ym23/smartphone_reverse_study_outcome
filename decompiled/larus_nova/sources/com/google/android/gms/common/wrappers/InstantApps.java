package com.google.android.gms.common.wrappers;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.google.android.gms.common.util.PlatformVersion;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class InstantApps {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static Context f274611zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private static Boolean f274612zzb;

    public InstantApps() {
    }

    public static synchronized boolean isInstantApp(Context r100) {
        monitor-enter(InstantApps.class);
        Context r101 = r100.getApplicationContext();     // Catch: Throwable -> L24
        Context r102 = f274611zza;     // Catch: Throwable -> L24
        if (r102 == null) goto L14;
        Boolean r103 = f274612zzb;     // Catch: Throwable -> L24
        if (r103 == null) goto L14;
        if (r102 != r101) goto L14;
        boolean r104 = r103.booleanValue();     // Catch: Throwable -> L24
        monitor-exit(InstantApps.class);
        return r104;
    L14:
        f274612zzb = null;     // Catch: Throwable -> L24
        if (PlatformVersion.isAtLeastO() == false) goto L27;
        f274612zzb = Boolean.valueOf(r101.getPackageManager().isInstantApp());     // Catch: Throwable -> L24
    L21:
        f274611zza = r101;     // Catch: Throwable -> L24
        boolean r105 = f274612zzb.booleanValue();     // Catch: Throwable -> L24
        monitor-exit(InstantApps.class);
        return r105;
    L27:
        INVOKEVIRTUAL_com_google_android_gms_common_wrappers_InstantApps_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClassLoader(), "com.google.android.instantapps.supervisor.InstantAppsRuntime");     // Catch: ClassNotFoundException -> L20 Throwable -> L24
        f274612zzb = Boolean.TRUE;     // Catch: ClassNotFoundException -> L20 Throwable -> L24
    L20:
        f274612zzb = Boolean.FALSE;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_google_android_gms_common_wrappers_InstantApps_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }
}
