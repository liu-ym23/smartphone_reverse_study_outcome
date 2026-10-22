package com.volcengine.zeus.oat;

import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.oat.Dex2OatHelper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.util.MethodUtils;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import mqc.i;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("dalvik.system.VMRuntime");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("dalvik.system.VMRuntime");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("dalvik.system.VMRuntime");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static String d(String r100) {
        String r101 = r100.substring(r100.lastIndexOf(HTTP.URL_DEFAULT) + 1);
        String r102 = r101.substring(r101.lastIndexOf("."));
        if (Build.VERSION.SDK_INT < 26) goto L5;
        String r103 = Dex2OatHelper.ODEX_SUFFIX;
    L7:
        if (Dex2OatHelper.DEX_SUFFIX.equals(r102) == false) goto L10;
        return r101;
    L10:
        if (".zip".equals(r102) == true) goto L16;
        if (".apk".equals(r102) == true) goto L16;
        return r101.concat(r103);
    L16:
        return r101.replace(r102, r103);
    L5:
        r103 = Dex2OatHelper.DEX_SUFFIX;
        goto L7
    }

    public static boolean e(String... r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        boolean r103 = true;
        if (r102 >= r101) goto L16;
        PolarisFileWrapper r104 = new PolarisFileWrapper(r100[r102]);
        if (r104.exists() == false) goto L15;
        i.a(new h(r104));
    L12:
        if (r103 == false) goto L15;
        r102 = r102 + 1;
        goto L3
    L11:
        r103 = false;
    L9:
        th = move-exception;
        throw th;
    L15:
        return false;
    L16:
        return true;
    }

    public static String[] c(String r100, String r101, int r102) {
        ArrayList r103 = new ArrayList();
        r103.add("dex2oat");
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 24) goto L5;
        r103.add("--runtime-arg");
        r103.add("-classpath");
        r103.add("--runtime-arg");
        r103.add("&");
    L5:
        r103.add("--instruction-set=" + b());
        boolean r105 = true;
        if (r102 != 1) goto L15;
        if (r104 >= 26) goto L11;
        r105 = false;
    L11:
        if (r105 == false) goto L13;
        r103.add("--compiler-filter=quicken");
    L17:
        r103.add("--dex-file=".concat(r100));
        r103.add("--oat-file=" + r101);
        return (String[]) r103.toArray(new String[r103.size()]);
    L13:
        r103.add("--compiler-filter=interpret-only");
        goto L17
    L15:
        if (r102 != 2) goto L17;
        r103.add("--compiler-filter=speed");
        goto L17
    }
}
