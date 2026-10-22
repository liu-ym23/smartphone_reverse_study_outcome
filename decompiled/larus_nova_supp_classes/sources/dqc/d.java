package dqc;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.MethodUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class d {
    public static String a;

    static {
        new CopyOnWriteArrayList();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static String c() {
        if (TextUtils.isEmpty(a) == false) goto L5;
        if (Build.VERSION.SDK_INT < 28) goto L44;
        String r0 = Application.getProcessName();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r0) == true) goto L11;
        a = r0;     // Catch: Throwable -> L36
    L11:
        return a;
    L44:
        Object r1 = MethodUtils.invokeStaticMethod(a(), "currentProcessName", new Object[0]);     // Catch: Exception -> L18
        if (TextUtils.isEmpty((String) r1) == true) goto L16;
        a = (String) r1;     // Catch: Exception -> L18
    L16:
        return a;
    L18:
        e = move-exception;
        e.printStackTrace();
        String r2 = null;
        BufferedReader r3 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L31
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L30
    L22:
        int r5 = r3.read();     // Catch: Throwable -> L30
        if (r5 <= 0) goto L26;
        r4.append((char) r5);     // Catch: Throwable -> L30
        goto L22
    L26:
        if (ZeusLogger.isDebug() == false) goto L28;
        ZeusLogger.d("Process", "get processName = " + r4.toString());     // Catch: Throwable -> L30
    L28:
        r2 = r4.toString();     // Catch: Throwable -> L30
    L46:
        r3.close();     // Catch: Exception -> L37
    L34:
        a = r2;
        return r2;
    L32:
        if (r3 == null) goto L34;
    L31:
        r3 = null;
        goto L32
    L5:
        return a;
    }

    public static String b(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L8:
        return "main";
    L5:
        if (r2.contains(":") == false) goto L8;
        return r2.split(":")[1];
    }

    public static boolean d(Context r3) {
        String r0 = c();
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r3.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }
}
