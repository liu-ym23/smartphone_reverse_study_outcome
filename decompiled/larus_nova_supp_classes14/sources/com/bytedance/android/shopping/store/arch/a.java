package com.bytedance.android.shopping.store.arch;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static volatile Boolean a;
    public static final Set<String> b = null;
    public static final Set<String> c = null;
    public static final Set<String> d = null;
    public static final Set<String> e = null;
    public static final Set<String> f = null;
    public static final a g = null;

    public a() {
    }

    static {
        g = new a();
        b = SetsKt.setOf(new String[]{"HWTAH", "HWTAH-C", "unknownRLI", "unknownRHA", "unknownTXL"});
        c = SetsKt.setOf(new String[]{"TAH-AN00", "TAH-N29", "TAH-AN00m", "TAH-N29m", "RLI-AN00", "RLI-N29", "RHA-AN00m", "RHA-N29m"});
        d = SetsKt.setOf(new String[]{"DIA-AN00", "MGI-AN00"});
        e = SetsKt.setOf(new String[]{"OP4E75L1", "OP55F1L1"});
        f = SetsKt.setOf("M2011J18C");
    }

    public static boolean b() {
        if (e.contains(Build.DEVICE) == false) goto L5;
        return true;
    L5:
        Class r0 = a("com.oplus.content.OplusFeatureConfigManager");
        Object r5 = null;
        Object r3 = r0.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        Object r1 = r0.getDeclaredMethod("hasFeature", new Class[]{String.class}).invoke(r3, new Object[]{"oplus.hardware.type.fold"});
        if ((r1 instanceof Boolean) == false) goto L10;
        r5 = r1;
    L10:
        return Intrinsics.areEqual((Boolean) r5, Boolean.TRUE);
    }

    public static boolean c() {
        String r0 = Build.MODEL;
        String r4 = null;
        if (StringsKt.startsWith$default(r0, "SM-F9", false, 2, null) == false) goto L5;
    L12:
        return true;
    L5:
        if (StringsKt.startsWith$default(r0, "SM-W202", false, 2, null) == true) goto L12;
        Class r1 = a("com.samsung.android.feature.SemFloatingFeature");
        Object r2 = r1.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        Object r3 = r1.getDeclaredMethod("getString", new Class[]{String.class}).invoke(r2, new Object[]{"SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD"});
        if (r3 == null) goto L11;
        r4 = r3.toString();
    L11:
        return StringsKt.equals(r4, "true", true);
    }

    public static boolean d() {
        if (f.contains(Build.MODEL) == false) goto L5;
        return true;
    L5:
        Class r0 = a("android.os.SystemProperties");
        return Intrinsics.areEqual(r0.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r0, new Object[]{"persist.sys.muiltdisplay_type", 0}), 2);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }
}
