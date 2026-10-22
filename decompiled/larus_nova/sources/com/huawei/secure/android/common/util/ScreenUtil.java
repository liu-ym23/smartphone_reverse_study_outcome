package com.huawei.secure.android.common.util;

import android.app.Activity;
import android.view.Window;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class ScreenUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278224a = "ScreenUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f278225b = 524288;

    public static class a implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Method f278226a;

        @Override // java.security.PrivilegedAction
        public Object run() {
            Method r100 = this.f278226a;
            if (r100 != null) goto L5;
            return null;
        L5:
            r100.setAccessible(true);
            return null;
        }

        public a(Method r100) {
            this.f278226a = r100;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public ScreenUtil() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_secure_android_common_util_ScreenUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static void disableScreenshots(Activity r100) {
        a(r100, 8192);
    }

    public static void enableScreenshots(Activity r100) {
        b(r100, 8192);
    }

    public static void hideOverlayWindows(Activity r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L20;
        Window r101 = r100.getWindow();     // Catch: IllegalAccessException -> L12 InvocationTargetException -> L13 NoSuchMethodException -> L14 ClassNotFoundException -> L15
        Class r102 = INVOKESTATIC_com_huawei_secure_android_common_util_ScreenUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.Window");     // Catch: IllegalAccessException -> L12 InvocationTargetException -> L13 NoSuchMethodException -> L14 ClassNotFoundException -> L15
        Method r103 = r102.getDeclaredMethod("addPrivateFlags", new Class[]{Integer.TYPE});     // Catch: IllegalAccessException -> L12 InvocationTargetException -> L13 NoSuchMethodException -> L14 ClassNotFoundException -> L15
        AccessController.doPrivileged(new a(r103));     // Catch: IllegalAccessException -> L12 InvocationTargetException -> L13 NoSuchMethodException -> L14 ClassNotFoundException -> L15
        r103.invoke(r101, new Object[]{524288});     // Catch: IllegalAccessException -> L12 InvocationTargetException -> L13 NoSuchMethodException -> L14 ClassNotFoundException -> L15
    L24:
        return;
    L15:
        LogsUtil.e(f278224a, "hideOverlayWindows ClassNotFoundException");
        return;
    L12:
        LogsUtil.e(f278224a, "hideOverlayWindows IllegalAccessException");
        return;
    L14:
        LogsUtil.e(f278224a, "hideOverlayWindows NoSuchMethodException");
        return;
    L13:
        LogsUtil.e(f278224a, "hideOverlayWindows InvocationTargetException");
        return;
    }

    private static void a(Activity r100, int r101) {
        if (r100 != null) goto L4;
    L8:
        LogsUtil.e("", "activity is null");
        return;
    L4:
        if (r100.isFinishing() == true) goto L8;
        r100.getWindow().addFlags(r101);
    }

    private static void b(Activity r100, int r101) {
        if (r100 != null) goto L4;
    L8:
        LogsUtil.e("", "activity is null");
        return;
    L4:
        if (r100.isFinishing() == true) goto L8;
        r100.getWindow().clearFlags(r101);
    }
}
