package jqc;

import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.util.MethodUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import mqc.m;
import mqc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static final Map<String, Integer> b = null;
    public final LinkedHashMap<String, Integer> a;

    static {
        b = new HashMap();
        AssetManager r0 = (AssetManager) AssetManager.class.newInstance();     // Catch: Exception -> L5
    L7:
        ArrayList r1 = (ArrayList) o.c(r0);
        if (r1.size() <= 0) goto L13;
        Iterator r2 = r1.iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        String r3 = (String) r2.next();
        b.put(r3, 0);
        goto L11
    L17:
        return;
    L13:
        return;
    L5:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e);
        r0 = null;
        goto L7
    }

    public a() {
        LinkedHashMap<String, Integer> r0 = new LinkedHashMap();
        this.a = r0;
        r0.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    public static void a(AssetManager r9, String r10, boolean r11) {
        String r0 = "addAssetPath";
        if (r11 == false) goto L5;
        String r1 = "addAssetPathAsSharedLibrary";
    L6:
        int r2 = Build.VERSION.SDK_INT;
        if (r2 < 30) goto L9;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L20;
        if (r11 == true) goto L20;
        if (r10.startsWith("/product/overlay/") == false) goto L20;
        r1 = "addOverlayPath";
    L20:
        Method r4 = MethodUtils.getAccessibleMethod(AssetManager.class, r1, new Class[]{String.class});
        if (r4 != null) goto L24;
        if (r11 == false) goto L24;
        r4 = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", new Class[]{String.class});
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
    L25:
        if (r4 == null) goto L37;
        int r5 = 3;
    L27:
        int r6 = r5 - 1;
        if (r5 < 0) goto L45;
        int r7 = ((Integer) r4.invoke(r9, new Object[]{r10})).intValue();     // Catch: Exception -> L34
        if (r7 == 0) goto L32;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + r7 + ", path = " + r10);     // Catch: Exception -> L34
        return;
    L32:
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + r7 + " " + r10);     // Catch: Exception -> L34
    L36:
        r5 = r6;
    L34:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + r11 + ", methodName = " + r0, e);
        goto L36
    L45:
        return;
    L37:
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + r11 + " methodName:" + r0);
        return;
    L24:
        r0 = r1;
        goto L25
    L9:
        if (r2 == 29) goto L11;
    L13:
        r3 = false;
        goto L15
    L11:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L13;
    L5:
        r1 = "addAssetPath";
        goto L6
    }

    public static void b(AssetManager r17, String r18, boolean r19) {
        Throwable th = null;
        int r3 = 3;
        int r4 = 3;
    L3:
        int r5 = r4 - 1;
        if (r4 < 0) goto L50;
        monitor-enter(r17);     // Catch: Throwable -> L48
        int r6 = 0;
        int r7 = 0;
    L8:
        if (r6 >= r3) goto L28;
        int r10 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L26
        if (r10 > 23) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == false) goto L16;
        r7 = ((Integer) MethodUtils.invokeMethod(r17, "addAssetPathNative", new Object[]{r18}, new Class[]{String.class})).intValue();     // Catch: Throwable -> L26
    L23:
        if (r7 != 0) goto L28;
        r6 = r6 + 1;     // Catch: Throwable -> L26
        goto L8
    L16:
        if (r10 >= 24) goto L18;
    L20:
        boolean r12 = false;
    L21:
        if (r12 == false) goto L23;
        r7 = ((Integer) MethodUtils.invokeMethod(r17, "addAssetPathNative", new Object[]{r18, Boolean.valueOf(r19)}, new Class[]{String.class, Boolean.TYPE})).intValue();     // Catch: Throwable -> L26
        goto L23
    L18:
        if (r10 > 25) goto L20;
        r12 = true;
        goto L21
    L12:
        r11 = false;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L28:
        if (r7 != 0) goto L32;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + r7 + " " + r18);     // Catch: Throwable -> L26
        monitor-exit(r17);     // Catch: Throwable -> L26
        goto L50
    L32:
        Object r8 = FieldUtils.readField(r17, "mStringBlocks");     // Catch: Throwable -> L26
        if (r8 == null) goto L35;
        int r9 = Array.getLength(r8);     // Catch: Throwable -> L26
    L36:
        int r13 = ((Integer) MethodUtils.invokeMethod(r17, "getStringBlockCount", new Object[0])).intValue();     // Catch: Throwable -> L26
        Object r14 = Array.newInstance(r8.getClass().getComponentType(), r13);     // Catch: Throwable -> L26
        int r15 = 0;
    L37:
        if (r15 >= r13) goto L42;
        if (r15 >= r9) goto L40;
        Array.set(r14, r15, Array.get(r8, r15));     // Catch: Throwable -> L26
    L41:
        r15 = r15 + 1;     // Catch: Throwable -> L26
        goto L37
    L40:
        Array.set(r14, r15, MethodUtils.invokeConstructor(r8.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(r17, "getNativeStringBlock", new Object[]{Integer.valueOf(r15)}, new Class[]{Integer.TYPE})).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));     // Catch: Throwable -> L26
        goto L41
    L42:
        FieldUtils.writeField(r17, "mStringBlocks", r14);     // Catch: Throwable -> L26
        monitor-exit(r17);     // Catch: Throwable -> L26
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = " + r18);     // Catch: Throwable -> L48
        goto L50
    L35:
        r9 = 0;
    L48:
        th = th;
        r4 = r5;
        r3 = 3;
    L50:
        if (th != null) goto L52;
        return;
    L52:
        if (TextUtils.equals(Build.BRAND.toLowerCase(), "samsung") == true) goto L54;
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = " + r18, th);
    L54:
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = " + r18, th);
    }

    public final void c(AssetManager r9, String r10, boolean r11) {
        if (r10.endsWith(".frro") == false) goto L6;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(r10));
        return;
    L6:
        boolean r2 = true;
        if (Build.VERSION.SDK_INT > 25) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L34;
        b(r9, r10, r11);
    L29:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
    L31:
        r2 = false;
    L32:
        if (r2 == true) goto L35;
        a(r9, r10, r11);
    L35:
        LinkedHashMap<String, Integer> r12 = this.a;
        monitor-enter(r12);
        this.a.put(r10, 0);     // Catch: Throwable -> L40
        monitor-exit(r12);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    L13:
        if (m.a() == false) goto L24;
        Object[] r1 = (Object[]) MethodUtils.invokeMethod(r9, "getApkAssets", new Object[0]);     // Catch: Throwable -> L29
        if (r1 == null) goto L31;
        if (r1.length <= 0) goto L31;
        int r3 = r1.length;     // Catch: Throwable -> L29
        int r4 = 0;
    L19:
        if (r4 >= r3) goto L31;
        if (TextUtils.equals((String) MethodUtils.invokeMethod(r1[r4], "getAssetPath", new Object[0]), r10) == true) goto L32;
        r4 = r4 + 1;     // Catch: Throwable -> L29
        goto L19
    L24:
        int r5 = ((Integer) MethodUtils.invokeMethod(r9, "getStringBlockCount", new Object[0])).intValue();     // Catch: Throwable -> L29
        int r6 = 0;
    L25:
        if (r6 >= r5) goto L31;
        r6 = r6 + 1;     // Catch: Throwable -> L29
        if (TextUtils.equals((String) MethodUtils.invokeMethod(r9, "getCookieName", new Object[]{Integer.valueOf(r6)}), r10) == false) goto L25;
    L34:
        a(r9, r10, r11);
        goto L35
    L9:
        r0 = false;
        goto L10
    }
}
