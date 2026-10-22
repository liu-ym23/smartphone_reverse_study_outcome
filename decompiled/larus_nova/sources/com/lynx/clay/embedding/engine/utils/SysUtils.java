package com.lynx.clay.embedding.engine.utils;

import android.os.Build;
import android.os.StrictMode;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.io.BufferedReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public class SysUtils {
    private static Integer sAmountOfPhysicalMemoryKB;

    public SysUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static int amountOfPhysicalMemoryKB() {
        if (sAmountOfPhysicalMemoryKB != null) goto L6;
        sAmountOfPhysicalMemoryKB = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
    L6:
        return sAmountOfPhysicalMemoryKB.intValue();
    }

    private static int detectAmountOfPhysicalMemoryKB() {
        Pattern r100 = PatternProtector.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy r101 = StrictMode.allowThreadDiskReads();
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper("/proc/meminfo");     // Catch: Throwable -> L27 Exception -> L32
        BufferedReader r103 = new BufferedReader(r102);     // Catch: Throwable -> L24
    L33:
        String r104 = r103.readLine();     // Catch: Throwable -> L21
        if (r104 == null) goto L14;
        Matcher r105 = r100.matcher(r104);     // Catch: Throwable -> L21
        if (r105.find() == false) goto L33;
        int r106 = Integer.parseInt(r105.group(1));     // Catch: Throwable -> L21
        goto L30
    L13:
        if (r106 <= 1024) goto L14;
        r103.close();     // Catch: Throwable -> L24
        r102.close();     // Catch: Throwable -> L27 Exception -> L32
        StrictMode.setThreadPolicy(r101);
        return r106;
    L14:
        r103.close();     // Catch: Throwable -> L24
        r102.close();     // Catch: Throwable -> L27 Exception -> L32
    L21:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L27 Exception -> L32
        throw th;     // Catch: Throwable -> L27 Exception -> L32
    L27:
        th = move-exception;
        StrictMode.setThreadPolicy(r101);
        throw th;
    L30:
        StrictMode.setThreadPolicy(r101);
        return 0;
    }

    public static boolean willUseVulkan() {
        Class r100 = INVOKESTATIC_com_lynx_clay_embedding_engine_utils_SysUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Throwable -> L4
        String r101 = (String) r100.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r100, new Object[]{"ro.hwui.use_vulkan", "false"});     // Catch: Throwable -> L4
    L7:
        return "true".equals(r101);
    L4:
        th = move-exception;
        th.printStackTrace();
        r101 = "";
        goto L7
    }

    public static int sdkLevel() {
        return Build.VERSION.SDK_INT;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_clay_embedding_engine_utils_SysUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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
}
