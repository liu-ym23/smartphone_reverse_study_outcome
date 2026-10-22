package com.bytedance.bdinstall;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f199627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Boolean f199628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final char[] f199629c = null;

    static {
        f199629c = "0123456789ABCDEF".toCharArray();
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

    public static String b(byte[] r100) {
        char[] r101 = new char[r100.length * 2];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        int r103 = r100[r102] & UByte.MAX_VALUE;
        int r104 = r102 * 2;
        char[] r105 = f199629c;
        r101[r104] = r105[r103 >>> 4];
        r101[r104 + 1] = r105[r103 & 15];
        r102 = r102 + 1;
        goto L4
    L7:
        return new String(r101);
    }

    public static boolean c(String r100) {
        boolean r101 = false;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L18:
        return false;
    L5:
        if ("unknown".equalsIgnoreCase(r100) == true) goto L18;
        if ("Null".equalsIgnoreCase(r100) == true) goto L18;
        int r102 = 0;
    L10:
        if (r102 >= r100.length()) goto L15;
        if (r100.charAt(r102) != '0') goto L17;
        r102 = r102 + 1;
    L17:
        return !r101;
    L15:
        r101 = true;
        goto L17
    }

    public static void d(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    public static boolean g(Context r100) {
        if (f199628b != null) goto L49;
        if (r100 == null) goto L47;
        String r101 = f199627a;
        if (TextUtils.isEmpty(r101) == true) goto L9;
    L45:
        f199628b = Boolean.valueOf(TextUtils.equals(r101, r100.getPackageName()));
        goto L49
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L13;
        r101 = Application.getProcessName();
        if (TextUtils.isEmpty(r101) == true) goto L13;
        f199627a = r101;
    L13:
        String r102 = null;
        Method r103 = a().getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L18
        r103.setAccessible(true);     // Catch: Throwable -> L18
        Object r104 = r103.invoke(null, new Object[0]);     // Catch: Throwable -> L18
        if ((r104 instanceof String) == false) goto L19;
        String r105 = (String) r104;     // Catch: Throwable -> L18
    L21:
        if (TextUtils.isEmpty(r105) == true) goto L53;
        f199627a = r105;
        r101 = r105;
        goto L45
    L53:
        int r106 = Process.myPid();     // Catch: Exception -> L30
        Iterator<ActivityManager.RunningAppProcessInfo> r107 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L30
    L25:
        if (r107.hasNext() == false) goto L57;
        ActivityManager.RunningAppProcessInfo r108 = r107.next();     // Catch: Exception -> L30
        if (r108.pid != r106) goto L25;
        f199627a = r108.processName;     // Catch: Exception -> L30
    L57:
        BufferedReader r109 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L41
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L40
    L35:
        int r111 = r109.read();     // Catch: Throwable -> L40
        if (r111 <= 0) goto L38;
        r110.append((char) r111);     // Catch: Throwable -> L40
        goto L35
    L38:
        r102 = r110.toString();     // Catch: Throwable -> L40
    L59:
        r109.close();     // Catch: Exception -> L50
    L44:
        f199627a = r102;
        int r112 = t.f199790a;
        r101 = f199627a;
    L42:
        if (r109 == null) goto L44;
    L41:
        r109 = null;
    L30:
        e = move-exception;
        e.printStackTrace();
    L19:
        r105 = null;
        goto L21
    L47:
        throw new NullPointerException("context is null");
    L49:
        return f199628b.booleanValue();
    }

    public static boolean h(String r100) {
        if (r100 == null) goto L5;
        int r101 = r100.length();
    L7:
        if (r101 >= 13) goto L9;
    L31:
        return false;
    L9:
        if (r101 > 128) goto L31;
        int r102 = 0;
    L12:
        if (r102 >= r101) goto L29;
        char r103 = r100.charAt(r102);
        if (r103 < '0') goto L18;
        if (r103 > '9') goto L18;
    L27:
        r102 = r102 + 1;
    L18:
        if (r103 < 'a') goto L22;
        if (r103 <= 'f') goto L27;
    L22:
        if (r103 < 'A') goto L26;
        if (r103 <= 'F') goto L27;
    L26:
        if (r103 == '-') goto L27;
        return false;
    L29:
        return true;
    L5:
        r101 = 0;
        goto L7
    }

    public static void e(JSONObject r100, JSONObject r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L22;
        return;
    L22:
        monitor-enter(b84.m.class);     // Catch: JSONException -> L17
        Iterator<String> r102 = r101.keys();     // Catch: Throwable -> L14
    L10:
        if (r102.hasNext() == false) goto L12;
        String r103 = r102.next();     // Catch: Throwable -> L14
        r100.put(r103, r101.opt(r103));     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(b84.m.class);     // Catch: Throwable -> L14
    L25:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        t.e(e);
    }

    public static boolean f(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
    L6:
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.equals(r101) == false) goto L10;
    L9:
        return true;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        goto L6
    }

    public static void j(SharedPreferences r100, String[] r101) {
        SharedPreferences.Editor r102 = r100.edit();
        int r103 = r101.length;
        int r104 = 0;
        boolean r105 = false;
    L3:
        if (r104 >= r103) goto L8;
        String r106 = r101[r104];
        if (r100.contains(r106) == false) goto L7;
        r102.remove(r106);
        r105 = true;
    L7:
        r104 = r104 + 1;
        goto L3
    L8:
        if (r105 == false) goto L14;
        r102.apply();
        return;
    }

    public static void i(JSONObject r100, String r101, String r102) throws JSONException {
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r100.put(r101, r102);
        return;
    }
}
