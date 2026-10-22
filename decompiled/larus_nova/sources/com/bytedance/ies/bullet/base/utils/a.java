package com.bytedance.ies.bullet.base.utils;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.ies.bullet.core.h;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f246322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f246323b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Field> f246324c = null;

    public a() {
    }

    static {
        HashMap r100 = new HashMap();
        f246323b = r100;
        f246324c = new HashMap();
        r100.put("armeabi", 32);
        r100.put("armeabi-v7a", 32);
        r100.put("arm64-v8a", 64);
        r100.put("x86", 32);
        r100.put("x86_64", 64);
        r100.put("mips", 32);
        r100.put("mips64", 64);
        f246322a = d();
    }

    public static String c() {
        if (f246322a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f246322a != null) goto L9;
        f246322a = d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f246322a;
    }

    public static String d() {
        JSONObject r100 = new JSONObject();
        r100.put(MiraMonitor.KEY_PRIMARY_CPU_ABI, "0");     // Catch: JSONException -> L5
        r100.put(MiraMonitor.KEY_PROCESS_MODE, "0");     // Catch: JSONException -> L5
        r100.put(MiraMonitor.KEY_SUPPORTED_ABI0, "0");     // Catch: JSONException -> L5
        r100.put(MiraMonitor.KEY_MATCH_CPU_ABI, "0");     // Catch: JSONException -> L5
        r100.put(MiraMonitor.KEY_DEFAULT_ABI0, "0");     // Catch: JSONException -> L5
        r100.put(MiraMonitor.KEY_DEFAULT_ABI, "0");     // Catch: JSONException -> L5
        r100.put(MiraMonitor.KEY_AUTO_ERROR, "0");     // Catch: JSONException -> L5
        r100.put(MiraMonitor.KEY_MANUAL_ERROR, "0");     // Catch: JSONException -> L5
    L7:
        Application r101 = h.f246501h.f246503b;
        String r110 = null;
        if (r101 != null) goto L65;
    L35:
        String r102 = null;
    L36:
        if (r102 == null) goto L61;
        return r102;
    L61:
        Application r103 = h.f246501h.f246503b;     // Catch: PackageManager.NameNotFoundException -> L57 Throwable -> L53
        if (r103 == null) goto L41;
        r110 = r103.getPackageManager().getPackageInfo(r103.getPackageName(), 0).applicationInfo.sourceDir;     // Catch: PackageManager.NameNotFoundException -> L57 Throwable -> L53
    L53:
        a(r100, MiraMonitor.KEY_MANUAL_ERROR, "1");
    L54:
        String[] r104 = Build.SUPPORTED_ABIS;
        a(r100, MiraMonitor.KEY_DEFAULT_ABI0, r104[0]);
        return r104[0];
    L41:
        PolarisZipFileWrapper r105 = new PolarisZipFileWrapper(new PolarisFileWrapper(r110));     // Catch: Throwable -> L53
        HashSet r106 = new HashSet(((HashMap) b(r105)).keySet());     // Catch: Throwable -> L53
        r105.close();     // Catch: IOException -> L58 Throwable -> L53
    L43:
        String[] r107 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L53
        if (r106.isEmpty() == false) goto L46;
        a(r100, MiraMonitor.KEY_SUPPORTED_ABI0, r107[0]);     // Catch: Throwable -> L53
        return r107[0];
    L46:
        int r108 = r107.length;     // Catch: Throwable -> L53
        int r109 = 0;
    L47:
        if (r109 >= r108) goto L54;
        String r111 = r107[r109];     // Catch: Throwable -> L53
        if (r106.contains(r111) == true) goto L50;
        r109 = r109 + 1;
        goto L47
    L50:
        a(r100, MiraMonitor.KEY_MATCH_CPU_ABI, r111);     // Catch: Throwable -> L53
        return r111;
    L65:
        r102 = (String) e(r101.getApplicationInfo());     // Catch: Throwable -> L34
        a(r100, MiraMonitor.KEY_PRIMARY_CPU_ABI, r102);     // Catch: Throwable -> L34
        if (r102 == null) goto L35;
        if (Build.VERSION.SDK_INT < 23) goto L15;
        boolean r112 = true;
    L16:
        if (r112 == false) goto L26;
        if (Process.is64Bit() == false) goto L20;
        int r113 = 64;
    L68:
    L27:
        a(r100, MiraMonitor.KEY_PROCESS_MODE, "" + r113);     // Catch: Throwable -> L34
        if (r113 == 0) goto L36;
        if (((Integer) ((HashMap) f246323b).get(r102)).intValue() != r113) goto L35;
    L20:
        r113 = 32;
        goto L68
    L23:
        r113 = 0;
    L26:
        r113 = 0;
        goto L27
    L15:
        r112 = false;
    L34:
        a(r100, MiraMonitor.KEY_AUTO_ERROR, "1");
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static Map b(PolarisZipFileWrapper r100) {
        HashMap r101 = new HashMap();
        Enumeration<? extends ZipEntry> r102 = r100.entries();
        Pattern r103 = PatternProtector.compile("^lib/[^/]+/lib[^/]+.so$");
    L4:
        if (r102.hasMoreElements() == false) goto L23;
        ZipEntry r104 = r102.nextElement();
        if (r104.isDirectory() == true) goto L4;
        boolean r105 = r103.matcher(r104.getName()).matches();     // Catch: Exception -> L10
    L12:
        if (r105 == false) goto L4;
        String[] r106 = r104.getName().split(File.separator);
        if (r106 == null) goto L4;
        if (r106.length < 2) goto L4;
        String r107 = r106[r106.length - 2];
        if (((HashMap) f246323b).containsKey(r107) == false) goto L4;
        if (r101.get(r107) != null) goto L22;
        r101.put(r107, new LinkedList());
    L22:
        ((List) r101.get(r107)).add(r104);
    L10:
        e = move-exception;
        e.toString();
        r105 = false;
        goto L12
    L23:
        r100.getName();
        r101.toString();
        return r101;
    }

    public static Object e(Object r100) throws IllegalAccessException {
        if (r100 == null) goto L41;
        Class<?> r101 = r100.getClass();
        if ((!TextUtils.isEmpty(MiraMonitor.KEY_PRIMARY_CPU_ABI)) == false) goto L39;
        String r102 = r101.toString() + "#primaryCpuAbi";
        Map<String, Field> r103 = f246324c;
        monitor-enter(r103);
        Field r104 = (Field) ((HashMap) r103).get(r102);     // Catch: Throwable -> L35
        monitor-exit(r103);     // Catch: Throwable -> L35
        if (r104 != null) goto L13;
    L15:
        if (r101 == null) goto L28;
        r104 = r101.getDeclaredField(MiraMonitor.KEY_PRIMARY_CPU_ABI);     // Catch: NoSuchFieldException -> L27
        if (r104.isAccessible() == true) goto L19;
        r104.setAccessible(true);     // Catch: NoSuchFieldException -> L27
    L19:
        Map<String, Field> r105 = f246324c;     // Catch: NoSuchFieldException -> L27
        monitor-enter(r105);     // Catch: NoSuchFieldException -> L27
        ((HashMap) r105).put(r102, r104);     // Catch: Throwable -> L24
        monitor-exit(r105);     // Catch: Throwable -> L24
    L29:
        if (r104 != null) goto L31;
        return null;
    L31:
        if (r104.isAccessible() == true) goto L34;
        r104.setAccessible(true);
    L34:
        return r104.get(r100);
    L24:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L27
    L27:
        r101 = r101.getSuperclass();
        goto L15
    L28:
        r104 = null;
        goto L29
    L13:
        if (r104.isAccessible() == true) goto L29;
        r104.setAccessible(true);
    L35:
        th = move-exception;
        throw th;
    L39:
        throw new IllegalArgumentException("The field name must not be blank");
    L41:
        throw new IllegalArgumentException("target object must not be null");
    }

    public static void a(JSONObject r100, String r101, String r102) {
        r100.put(r101, r102);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }
}
