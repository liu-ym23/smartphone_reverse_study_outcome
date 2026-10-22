package jqc;

import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
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

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f500106b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, Integer> f500107a;

    static {
        f500106b = new HashMap();
        AssetManager r100 = (AssetManager) AssetManager.class.newInstance();     // Catch: Exception -> L5
    L7:
        ArrayList r101 = (ArrayList) o.c(r100);
        if (r101.size() <= 0) goto L13;
        Iterator r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L17;
        String r103 = (String) r102.next();
        f500106b.put(r103, 0);
        goto L11
    L17:
        return;
    L13:
        return;
    L5:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "Execute 'AssetManager.class.newInstance()' failed. ", e);
        r100 = null;
        goto L7
    }

    public a() {
        LinkedHashMap<String, Integer> r100 = new LinkedHashMap();
        this.f500107a = r100;
        r100.put(Zeus.getAppApplication().getApplicationInfo().sourceDir, 0);
    }

    public static void a(AssetManager r100, String r110, boolean r111) {
        String r101 = "addAssetPath";
        if (r111 == false) goto L5;
        String r102 = "addAssetPathAsSharedLibrary";
    L6:
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 30) goto L9;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L20;
        if (r111 == true) goto L20;
        if (r110.startsWith("/product/overlay/") == false) goto L20;
        r102 = "addOverlayPath";
    L20:
        Method r105 = MethodUtils.getAccessibleMethod(AssetManager.class, r102, new Class[]{String.class});
        if (r105 != null) goto L24;
        if (r111 == false) goto L24;
        r105 = MethodUtils.getAccessibleMethod(AssetManager.class, "addAssetPath", new Class[]{String.class});
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor AssetManager.addAssetPath() invoke addAssetPathAsSharedLibrary failed. use addAssetPath.");
    L25:
        if (r105 == null) goto L37;
        int r106 = 3;
    L27:
        int r107 = r106 - 1;
        if (r106 < 0) goto L45;
        int r108 = ((Integer) r105.invoke(r100, new Object[]{r110})).intValue();     // Catch: Exception -> L34
        if (r108 == 0) goto L32;
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() success, cookie = " + r108 + ", path = " + r110);     // Catch: Exception -> L34
        return;
    L32:
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed, cookie = " + r108 + " " + r110);     // Catch: Exception -> L34
    L36:
        r106 = r107;
    L34:
        e = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.addAssetPath() failed. asSharedLibrary = " + r111 + ", methodName = " + r101, e);
        goto L36
    L45:
        return;
    L37:
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor reflect AssetManager.addAssetPath() failed. addAssetPathMethod == null. asSharedLibrary = " + r111 + " methodName:" + r101);
        return;
    L24:
        r101 = r102;
        goto L25
    L9:
        if (r103 == 29) goto L11;
    L13:
        r104 = false;
        goto L15
    L11:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L13;
    L5:
        r102 = "addAssetPath";
        goto L6
    }

    public static void b(AssetManager r110, String r111, boolean r112) {
        Throwable th10 = null;
        int r100 = 3;
        int r101 = 3;
    L3:
        int r102 = r101 - 1;
        if (r101 < 0) goto L50;
        monitor-enter(r110);     // Catch: Throwable -> L48
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r103 >= r100) goto L28;
        int r113 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L26
        if (r113 > 23) goto L12;
        boolean r114 = true;
    L13:
        if (r114 == false) goto L16;
        r104 = ((Integer) MethodUtils.invokeMethod(r110, "addAssetPathNative", new Object[]{r111}, new Class[]{String.class})).intValue();     // Catch: Throwable -> L26
    L23:
        if (r104 != 0) goto L28;
        r103 = r103 + 1;     // Catch: Throwable -> L26
        goto L8
    L16:
        if (r113 >= 24) goto L18;
    L20:
        boolean r115 = false;
    L21:
        if (r115 == false) goto L23;
        r104 = ((Integer) MethodUtils.invokeMethod(r110, "addAssetPathNative", new Object[]{r111, Boolean.valueOf(r112)}, new Class[]{String.class, Boolean.TYPE})).intValue();     // Catch: Throwable -> L26
        goto L23
    L18:
        if (r113 > 25) goto L20;
        r115 = true;
        goto L21
    L12:
        r114 = false;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L28:
        if (r104 != 0) goto L32;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor invoke AssetManager.appendAssetPathSafely() failed, cookie = " + r104 + " " + r111);     // Catch: Throwable -> L26
        monitor-exit(r110);     // Catch: Throwable -> L26
        goto L50
    L32:
        Object r105 = FieldUtils.readField(r110, "mStringBlocks");     // Catch: Throwable -> L26
        if (r105 == null) goto L35;
        int r106 = Array.getLength(r105);     // Catch: Throwable -> L26
    L36:
        int r116 = ((Integer) MethodUtils.invokeMethod(r110, "getStringBlockCount", new Object[0])).intValue();     // Catch: Throwable -> L26
        Object r117 = Array.newInstance(r105.getClass().getComponentType(), r116);     // Catch: Throwable -> L26
        int r118 = 0;
    L37:
        if (r118 >= r116) goto L42;
        if (r118 >= r106) goto L40;
        Array.set(r117, r118, Array.get(r105, r118));     // Catch: Throwable -> L26
    L41:
        r118 = r118 + 1;     // Catch: Throwable -> L26
        goto L37
    L40:
        Array.set(r117, r118, MethodUtils.invokeConstructor(r105.getClass().getComponentType(), new Object[]{Long.valueOf(((Long) MethodUtils.invokeMethod(r110, "getNativeStringBlock", new Object[]{Integer.valueOf(r118)}, new Class[]{Integer.TYPE})).longValue()), Boolean.TRUE}, new Class[]{Long.TYPE, Boolean.TYPE}));     // Catch: Throwable -> L26
        goto L41
    L42:
        FieldUtils.writeField(r110, "mStringBlocks", r117);     // Catch: Throwable -> L26
        monitor-exit(r110);     // Catch: Throwable -> L26
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely success, sourceDir = " + r111);     // Catch: Throwable -> L48
        goto L50
    L35:
        r106 = 0;
    L48:
        th10 = th;
        r101 = r102;
        r100 = 3;
    L50:
        if (th10 != null) goto L52;
        return;
    L52:
        if (TextUtils.equals(Build.BRAND.toLowerCase(), SmEditTextLeakOpt.SAMSUNG) == true) goto L54;
        ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = " + r111, th10);
    L54:
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor appendAssetPathSafely failed, sourceDir = " + r111, th10);
    }

    public final void c(AssetManager r100, String r110, boolean r111) {
        if (r110.endsWith(".frro") == false) goto L6;
        ZeusLogger.w(ZeusLogger.TAG_LOAD, "AssetManagerProcessor updateAssetManager skip frro. ".concat(r110));
        return;
    L6:
        boolean r101 = true;
        if (Build.VERSION.SDK_INT > 25) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L34;
        b(r100, r110, r111);
    L29:
        th = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_RESOURCES, "containsPath error. ", th);
    L31:
        r101 = false;
    L32:
        if (r101 == true) goto L35;
        a(r100, r110, r111);
    L35:
        LinkedHashMap<String, Integer> r103 = this.f500107a;
        monitor-enter(r103);
        this.f500107a.put(r110, 0);     // Catch: Throwable -> L40
        monitor-exit(r103);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    L13:
        if (m.a() == false) goto L24;
        Object[] r104 = (Object[]) MethodUtils.invokeMethod(r100, "getApkAssets", new Object[0]);     // Catch: Throwable -> L29
        if (r104 == null) goto L31;
        if (r104.length <= 0) goto L31;
        int r105 = r104.length;     // Catch: Throwable -> L29
        int r106 = 0;
    L19:
        if (r106 >= r105) goto L31;
        if (TextUtils.equals((String) MethodUtils.invokeMethod(r104[r106], "getAssetPath", new Object[0]), r110) == true) goto L32;
        r106 = r106 + 1;     // Catch: Throwable -> L29
        goto L19
    L24:
        int r107 = ((Integer) MethodUtils.invokeMethod(r100, "getStringBlockCount", new Object[0])).intValue();     // Catch: Throwable -> L29
        int r108 = 0;
    L25:
        if (r108 >= r107) goto L31;
        r108 = r108 + 1;     // Catch: Throwable -> L29
        if (TextUtils.equals((String) MethodUtils.invokeMethod(r100, "getCookieName", new Object[]{Integer.valueOf(r108)}), r110) == false) goto L25;
    L34:
        a(r100, r110, r111);
        goto L35
    L9:
        r102 = false;
        goto L10
    }
}
