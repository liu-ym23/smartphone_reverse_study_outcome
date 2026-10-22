package com.bytedance.timonbase.utils;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f270909a;

    static {
        f270909a = "";
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

    public static String b() {
        if (TextUtils.isEmpty(f270909a) == false) goto L5;
        int r100 = Build.VERSION.SDK_INT;
        String r101 = null;
        if (r100 < 33) goto L9;
        String r102 = Process.myProcessName();
    L10:
        f270909a = r102;
        if (TextUtils.isEmpty(r102) == true) goto L15;
        return f270909a;
    L15:
        if (r100 >= 28) goto L38;
    L20:
        String r103 = null;
    L21:
        f270909a = r103;
        if (TextUtils.isEmpty(r103) == false) goto L24;
        Object r104 = a().getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L30
        if (r104 == null) goto L29;
        r101 = (String) r104;     // Catch: Throwable -> L30
    L32:
        f270909a = r101;
        if (TextUtils.isEmpty(r101) == true) goto L37;
        return f270909a;
    L37:
        return f270909a;
    L29:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        th.printStackTrace();
        goto L32
    L24:
        return f270909a;
    L38:
        r103 = Application.getProcessName();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    L9:
        r102 = null;
        goto L10
    L5:
        return f270909a;
    }

    public static boolean c(Application r100) {
        return Intrinsics.areEqual(r100.getPackageName(), b());
    }
}
