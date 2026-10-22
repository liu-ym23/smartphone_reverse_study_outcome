package com.volcengine.zeus.oat;

import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.util.MethodUtils;
import el9.a;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import mqc.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("dalvik.system.VMRuntime");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("dalvik.system.VMRuntime");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("dalvik.system.VMRuntime");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("dalvik.system.VMRuntime");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("dalvik.system.VMRuntime");
    }

    public static String b() {
        return (String) MethodUtils.invokeStaticMethod(a(), "getCurrentInstructionSet", new Object[0]);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String d(String r4) {
        String r5 = r4.substring(r4.lastIndexOf("/") + 1);
        String r0 = r5.substring(r5.lastIndexOf("."));
        if (Build.VERSION.SDK_INT < 26) goto L5;
        String r1 = ".odex";
    L7:
        if (".dex".equals(r0) == false) goto L10;
        return r5;
    L10:
        if (".zip".equals(r0) == true) goto L16;
        if (".apk".equals(r0) == true) goto L16;
        return r5.concat(r1);
    L16:
        return r5.replace(r0, r1);
    L5:
        r1 = ".dex";
        goto L7
    }

    public static boolean e(String... r6) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        boolean r3 = true;
        if (r2 >= r0) goto L16;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r6[r2]);
        if (r5.exists() == false) goto L15;
        i.a(new h(r5));
    L12:
        if (r3 == false) goto L15;
        r2 = r2 + 1;
        goto L3
    L11:
        r3 = false;
    L9:
        th = move-exception;
        throw th;
    L15:
        return false;
    L16:
        return true;
    }

    public static String[] c(String r4, String r5, int r6) {
        ArrayList r0 = new ArrayList();
        r0.add("dex2oat");
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 24) goto L5;
        r0.add("--runtime-arg");
        r0.add("-classpath");
        r0.add("--runtime-arg");
        r0.add("&");
    L5:
        r0.add("--instruction-set=" + b());
        boolean r2 = true;
        if (r6 != 1) goto L15;
        if (r1 >= 26) goto L11;
        r2 = false;
    L11:
        if (r2 == false) goto L13;
        r0.add("--compiler-filter=quicken");
    L17:
        r0.add("--dex-file=".concat(r4));
        r0.add("--oat-file=" + r5);
        return (String[]) r0.toArray(new String[r0.size()]);
    L13:
        r0.add("--compiler-filter=interpret-only");
        goto L17
    L15:
        if (r6 != 2) goto L17;
        r0.add("--compiler-filter=speed");
        goto L17
    }
}
