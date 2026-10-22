package com.larus.voicecall.impl.notification;

import android.content.Context;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.android.SystemUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f378399a = 0;

    static {
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

    public static boolean d() {
        String r100 = Build.MANUFACTURER;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r100.toUpperCase(Locale.getDefault()), SystemUtils.PRODUCT_HONOR, false, 2, null) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean e() {
        String r100 = Build.MANUFACTURER;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (StringsKt.equals(r100, "OnePlus", true) == false) goto L7;
        return true;
    }

    public static int b() {
        if (d() == true) goto L5;
        return 0;
    L5:
        String r100 = f("ro.build.version.magic");
        boolean r101 = true;
        if (r100.length() != 0) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r100 = f("ro.build.version.magicui");
    L12:
        if (r100.length() == 0) goto L15;
        r101 = false;
    L15:
        if (r101 == false) goto L17;
        return 0;
    L17:
        MatchResult r103 = Regex.find$default(new Regex("(\\d+)"), r100, 0, 2, null);
        if (r103 != null) goto L20;
        return 0;
    L20:
        Integer r104 = StringsKt.toIntOrNull(r103.getValue());
        if (r104 != null) goto L23;
        return 0;
    L23:
        return r104.intValue();
    L8:
        r102 = false;
        goto L9
    }

    public static boolean c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (d() == false) goto L8;
        if (b() < 8) goto L8;
        return true;
    L8:
        if ((r100.getResources().getConfiguration().uiMode & 48) == 32) goto L12;
        return false;
    L12:
        return true;
    }

    public static String f(String r100) {
        Object[] r101 = {r100, ""};     // Catch: Throwable -> L10
        String r102 = null;
        Object r103 = a().getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(null, r101);     // Catch: Throwable -> L10
        if ((r103 instanceof String) == false) goto L6;
        r102 = (String) r103;     // Catch: Throwable -> L10
    L6:
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    L14:
        return "";
    }
}
