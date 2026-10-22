package dqc;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
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

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f469734a;

    static {
        new CopyOnWriteArrayList();
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

    public static String c() {
        if (TextUtils.isEmpty(f469734a) == false) goto L5;
        if (Build.VERSION.SDK_INT < 28) goto L44;
        String r100 = Application.getProcessName();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r100) == true) goto L11;
        f469734a = r100;     // Catch: Throwable -> L36
    L11:
        return f469734a;
    L44:
        Object r101 = MethodUtils.invokeStaticMethod(a(), "currentProcessName", new Object[0]);     // Catch: Exception -> L18
        if (TextUtils.isEmpty((String) r101) == true) goto L16;
        f469734a = (String) r101;     // Catch: Exception -> L18
    L16:
        return f469734a;
    L18:
        e = move-exception;
        e.printStackTrace();
        String r102 = null;
        BufferedReader r103 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L31
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L30
    L22:
        int r105 = r103.read();     // Catch: Throwable -> L30
        if (r105 <= 0) goto L26;
        r104.append((char) r105);     // Catch: Throwable -> L30
        goto L22
    L26:
        if (ZeusLogger.isDebug() == false) goto L28;
        ZeusLogger.d("Process", "get processName = " + r104.toString());     // Catch: Throwable -> L30
    L28:
        r102 = r104.toString();     // Catch: Throwable -> L30
    L46:
        r103.close();     // Catch: Exception -> L37
    L34:
        f469734a = r102;
        return r102;
    L32:
        if (r103 == null) goto L34;
    L31:
        r103 = null;
        goto L32
    L5:
        return f469734a;
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L8:
        return PullConfiguration.PROCESS_NAME_MAIN;
    L5:
        if (r100.contains(":") == false) goto L8;
        return r100.split(":")[1];
    }

    public static boolean d(Context r100) {
        String r101 = c();
        if (r101 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.equals(r100.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r101.contains(":") == false) goto L7;
        return false;
    }
}
