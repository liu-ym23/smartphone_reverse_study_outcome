package com.larus.camera.impl.utils;

import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.m0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes26.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f322714a = null;

    static {
        f322714a = LazyKt.lazy(new z());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static boolean b(FragmentActivity r100) {
        Class r101 = a();     // Catch: Exception -> L13
        Object r102 = r101.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{"qemu.hw.mainkeys"});     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L13
        String r103 = (String) r102;     // Catch: Exception -> L13
        if (Intrinsics.areEqual("1", r103) == false) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual("0", r103) == false) goto L9;
        return true;
    L9:
        Resources r104 = r100.getResources();     // Catch: Exception -> L13
        int r105 = r104.getIdentifier("config_showNavigationBar", "bool", "android");     // Catch: Exception -> L13
        if (r105 <= 0) goto L16;
        return r104.getBoolean(r105);
    L16:
        return false;
    L17:
        return false;
    }

    public static boolean c(FragmentActivity r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        if (Build.VERSION.SDK_INT < 23) goto L16;
        WindowInsets r102 = r101.getRootWindowInsets();
        if (r102 != null) goto L9;
        return b(r100);
    L9:
        if (b(r100) == true) goto L11;
    L13:
        return false;
    L11:
        if (m0.d(r102) == false) goto L13;
        return true;
    L16:
        return b(r100);
    }
}
