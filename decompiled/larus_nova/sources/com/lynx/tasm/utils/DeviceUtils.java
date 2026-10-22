package com.lynx.tasm.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.text.TextPaint;
import android.view.Display;
import android.widget.TextView;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public class DeviceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f384073a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f384074b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f384075c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f384076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Typeface f384077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f384078f;

    public DeviceUtils() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("miui.os.Build");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("miui.os.Build");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("miui.os.Build");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("miui.os.Build");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("miui.os.Build");
    }

    public static synchronized Typeface b() {
        monitor-enter(DeviceUtils.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (d() == true) goto L10;
        monitor-exit(DeviceUtils.class);
        return null;
    L10:
        if (f384078f == false) goto L25;
        Typeface r100 = f384077e;     // Catch: Throwable -> L22
        monitor-exit(DeviceUtils.class);
        return r100;
    L25:
        TextPaint r101 = new TextView(LynxEnv.inst().getAppContext()).getPaint();     // Catch: Exception -> L18 Throwable -> L22
        if (r101 == null) goto L19;
        f384077e = r101.getTypeface();     // Catch: Exception -> L18 Throwable -> L22
    L19:
        f384078f = true;     // Catch: Throwable -> L22
        Typeface r102 = f384077e;     // Catch: Throwable -> L22
        monitor-exit(DeviceUtils.class);
        return r102;
    L18:
        LLog.e("Lynx", "get default typeface failed");     // Catch: Throwable -> L22
        goto L19
    }

    public static synchronized boolean d() {
        monitor-enter(DeviceUtils.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f384073a == false) goto L18;
    L11:
        boolean r100 = f384074b;     // Catch: Throwable -> L14
        monitor-exit(DeviceUtils.class);
        return r100;
    L18:
        if (a() == null) goto L10;
        f384074b = true;     // Catch: Exception -> L17 Throwable -> L14
    L10:
        f384073a = true;     // Catch: Throwable -> L14
        goto L11
    }

    public static boolean is64BitDevice() {
        if (f384075c != (-1)) goto L24;
        if (f384076d == null) goto L27;
    L22:
        f384075c = f384076d.contains(BDLocationException.ERROR_RESTRICTED_MODE_ON) ? 1 : 0;
        goto L24
    L27:
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L21
        if (Build.SUPPORTED_ABIS.length <= 0) goto L15;
        int r101 = 0;
    L9:
        String[] r102 = Build.SUPPORTED_ABIS;     // Catch: Exception -> L21
        if (r101 >= r102.length) goto L17;
        r100.append(r102[r101]);     // Catch: Exception -> L21
        if (r101 == (r102.length - 1)) goto L14;
        r100.append(", ");     // Catch: Exception -> L21
    L14:
        r101 = r101 + 1;     // Catch: Exception -> L21
    L17:
        if (android.text.TextUtils.isEmpty(r100.toString()) == false) goto L19;
        f384076d = "unknown";     // Catch: Exception -> L21
    L19:
        f384076d = r100.toString();     // Catch: Exception -> L21
        goto L22
    L15:
        r100 = new StringBuilder(Build.CPU_ABI);     // Catch: Exception -> L21
    L21:
        LLog.e("DeviceUtils", "Lynx get unknown CPU ABIs");
        f384076d = "unknown";
    L24:
        if (f384075c != 1) goto L32;
        return true;
    L32:
        return false;
    }

    public static float c(Context r100) {
        Display r101 = null;
        if (Build.VERSION.SDK_INT < 23) goto L7;
        DisplayManager r102 = (DisplayManager) r100.getSystemService(DisplayManager.class);
        if (r102 == null) goto L10;
        r101 = r102.getDisplay(0);
    L10:
        if (r101 != null) goto L12;
        return 60.0f;
    L12:
        return r101.getRefreshRate();
    L7:
        Activity r103 = a.getActivity(r100);
        if (r103 == null) goto L10;
        r101 = r103.getWindowManager().getDefaultDisplay();
        goto L10
    }
}
