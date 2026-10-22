package com.larus.utils;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.keva.Keva;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f375463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f375464b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f375465c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f375466d = null;

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f375467a = null;

        static {
            f375467a = new a();
        }

        public a() {
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

        public static int b() {
            Intrinsics.checkNotNullParameter("persist.sys.muiltdisplay_type", "key");
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
            Integer r101 = null;
            Object r102 = a().getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{"persist.sys.muiltdisplay_type", 0});     // Catch: Throwable -> L11
            if ((r102 instanceof Integer) == false) goto L6;
            r101 = (Integer) r102;     // Catch: Throwable -> L11
        L6:
            if (r101 == null) goto L8;
            int r103 = r101.intValue();     // Catch: Throwable -> L11
        L9:
            Object r104 = Result.m9449constructorimpl(Integer.valueOf(r103));     // Catch: Throwable -> L11
        L14:
            if (Result.m9455isFailureimpl(r104) == false) goto L17;
            r104 = 0;
        L17:
            return ((Number) r104).intValue();
        L8:
            r103 = 0;
        L11:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }
    }

    public t() {
    }

    static {
        f375463a = new t();
        f375464b = new ConcurrentHashMap();
        f375465c = new Object();
        f375466d = LazyKt.lazy(new s());
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

    public static boolean c(Context r100) {
        String r101 = Build.BRAND;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        boolean r102 = true;
        if (StringsKt.equals(r101, RomUtils.BRAND_HUAWEI, true) == false) goto L16;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r100.getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture")));     // Catch: Throwable -> L9
    L11:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L98;
        r104 = r105;
    L98:
        return ((Boolean) r104).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L16:
        if (StringsKt.equals(r101, RomUtils.BRAND_HONOR, true) == true) goto L94;
        Boolean r107 = null;
        String r108 = null;
        String r109 = null;
        if (StringsKt.equals(r101, AppConstants.CHANNEL_OPPO, true) == false) goto L28;
    L86:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L79
        Class r111 = a("com.oplus.content.OplusFeatureConfigManager");     // Catch: Throwable -> L79
        Object r112 = r111.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L79
        Object r113 = r111.getDeclaredMethod("hasFeature", new Class[]{String.class}).invoke(r112, new Object[]{"oplus.hardware.type.fold"});     // Catch: Throwable -> L79
        if ((r113 instanceof Boolean) == false) goto L77;
        r107 = (Boolean) r113;     // Catch: Throwable -> L79
    L77:
        Object r114 = Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(r107, Boolean.TRUE)));     // Catch: Throwable -> L79
    L81:
        Boolean r115 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r114) == false) goto L85;
        r114 = r115;
    L85:
        return ((Boolean) r114).booleanValue();
    L79:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L81
    L28:
        if (StringsKt.equals(r101, "oneplus", true) == true) goto L86;
        if (StringsKt.equals(r101, DimLocationCheckUtil.VIVO, true) == false) goto L44;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L37
        Object r118 = a("android.util.FtDeviceInfo").getMethod("getDeviceType", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L37
        if ((r118 instanceof String) == false) goto L35;
        r109 = (String) r118;     // Catch: Throwable -> L37
    L35:
        Object r119 = Result.m9449constructorimpl(Boolean.valueOf(StringsKt.equals(r109, "foldable", true)));     // Catch: Throwable -> L37
    L39:
        Boolean r120 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r119) == false) goto L100;
        r119 = r120;
    L100:
        return ((Boolean) r119).booleanValue();
    L37:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L39
    L44:
        if (StringsKt.equals(r101, DimLocationCheckUtil.XIAOMI, true) == false) goto L46;
    L90:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L68
        a.f375467a.getClass();     // Catch: Throwable -> L68
        if (a.b() == 2) goto L66;
        r102 = false;
    L66:
        Object r123 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L68
    L70:
        Boolean r124 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r123) == false) goto L103;
        r123 = r124;
    L103:
        return ((Boolean) r123).booleanValue();
    L68:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L70
    L46:
        if (StringsKt.equals(r101, "redmi", true) == true) goto L90;
        if (StringsKt.equals(r101, SmEditTextLeakOpt.SAMSUNG, true) == true) goto L96;
        return false;
    L96:
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L55
        Class r127 = a("com.samsung.android.feature.SemFloatingFeature");     // Catch: Throwable -> L55
        Object r128 = r127.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L55
        Object r129 = r127.getDeclaredMethod("getString", new Class[]{String.class}).invoke(r128, new Object[]{"SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD"});     // Catch: Throwable -> L55
        if ((r129 instanceof String) == false) goto L53;
        r108 = (String) r129;     // Catch: Throwable -> L55
    L53:
        Object r130 = Result.m9449constructorimpl(Boolean.valueOf(StringsKt.equals(r108, "TRUE", true)));     // Catch: Throwable -> L55
    L57:
        Boolean r131 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r130) == false) goto L101;
        r130 = r131;
    L101:
        return ((Boolean) r130).booleanValue();
    L55:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L57
    L94:
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L19
        Object r134 = Result.m9449constructorimpl(Boolean.valueOf(r100.getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture")));     // Catch: Throwable -> L19
    L21:
        Boolean r135 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r134) == false) goto L99;
        r134 = r135;
    L99:
        return ((Boolean) r134).booleanValue();
    L19:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public static void b(boolean r100, String r101, boolean r102) {
        Boolean r103 = Boolean.valueOf(r102);
        f375464b.put(r101, r103);
        if (r100 == false) goto L6;
        ((Keva) f375466d.getValue()).storeBoolean("is_android_fold_".concat(r101), r102);
        return;
    }
}
