package jrc;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.mt.protector.impl.UriProtector;
import ee.android.framework.manis.base.c;
import f06.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f500172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f500173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jrc.a f500174c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f500175a = null;

        static {
            f500175a = new b();
        }
    }

    public b() {
        this.f500172a = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v3 */
    public static Object a(Context r210, Class r211) {
        String r100 = lrc.b.a(r210);
        StringBuilder r101 = new StringBuilder("getService ");
        r101.append(r211.getName());
        r101.append(" in process:");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r100 = PullConfiguration.PROCESS_NAME_MAIN;
    L5:
        r101.append(r100);
        krc.b.c("ManisManager", r101.toString());
        String[] r102 = ee.android.framework.manis.base.b.f472259d;
        ee.android.framework.manis.base.b r103 = ee.android.framework.manis.base.b.a.f472263a;
        r103.getClass();
        String r104 = c.a(r210, r211);
        if (TextUtils.isEmpty(r104) == false) goto L8;
        krc.b.a("ServiceFetcher", "class:" + r211.getName() + " is not register");
        return null;
    L8:
        String r105 = r211.getName();
        Object r106 = r103.f472262c;
        monitor-enter(r106);
        IInterface r107 = (IInterface) ((ConcurrentHashMap) r103.f472260a).get(r105);     // Catch: Throwable -> L105
        monitor-exit(r106);     // Catch: Throwable -> L105
        if (r107 != null) goto L14;
    L18:
        Uri r108 = UriProtector.parse(r104);
        if (a.f500175a.f500174c == null) goto L22;
        krc.b.c("ProviderProcessMatcher", "getTargetProcess serviceClass:".concat(r211.getName()));
    L22:
        long r110 = System.currentTimeMillis();
        ContentResolver r109 = r210.getContentResolver();
        String[] r111 = ee.android.framework.manis.base.b.f472259d;
        f06.c r212 = new f06.c();
        Object[] r112 = {r108, r111, null, null, null};
        f06.b r213 = new f06.b();
        d r113 = r212.b(240004, "android/content/ContentResolver", "query", r109, r112, "android.database.Cursor", r213);
        if (r113.f474982a == false) goto L25;
        r212.a(240004, "android/content/ContentResolver", "query", r109, r112, null, r213, false);
        Cursor r114 = (Cursor) r113.f474983b;
        int r115 = 2;
        int r116 = 0;
    L26:
        krc.b.c("ServiceFetcher", "getContentResolver().query called, uri:" + r108 + ", cost time:" + (System.currentTimeMillis() - r110));
        if (r114 != null) goto L110;
        StringBuilder r117 = new StringBuilder("query ContentProvider: '");
        r117.append(r108);
        r117.append("' failed in process:");
        Map<Integer, String> r118 = ee.android.framework.manis.base.a.f472258a;
        Context r119 = r210.getApplicationContext();
        int r120 = r119.hashCode();
        HashMap r121 = (HashMap) ee.android.framework.manis.base.a.f472258a;
        String r122 = (String) r121.get(Integer.valueOf(r120));
        if (TextUtils.isEmpty(r122) == false) goto L35;
        String r123 = lrc.b.a(r119);
        if (TextUtils.isEmpty(r123) == false) goto L34;
        r123 = "lark_main";
    L34:
        r122 = r123;
        r121.put(Integer.valueOf(r120), r122);
    L35:
        r117.append(r122);
        krc.b.a("ServiceFetcher", r117.toString());
        return null;
    L110:
        System.currentTimeMillis();     // Catch: Throwable -> L41 Exception -> L43
        String[] r124 = lrc.a.f510480b;     // Catch: Throwable -> L41 Exception -> L43
        IBinder r125 = lrc.a.C6731a.a(r114);     // Catch: Throwable -> L41 Exception -> L43
    L113:
        r114.close();     // Catch: Exception -> L39
    L50:
        String r126 = r105.concat("Stub");
        Method r127 = (Method) ((HashMap) r103.f472261b).get(r105);     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        if (r127 != null) goto L54;
        Class r128 = ee.android.framework.manis.base.b.a(r126);     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        Class<?>[] r129 = new Class[r115];     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        r129[r116] = ee.android.framework.manis.base.b.a("android.content.Context");     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        ?? r130 = 1;
        r129[1] = ee.android.framework.manis.base.b.a("android.os.IBinder");     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        Method r131 = r128.getDeclaredMethod("asInterface", r129);     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        ((HashMap) r103.f472261b).put(r105, r131);     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        Method r132 = r131;
    L55:
        r132.setAccessible(r130);     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        Object[] r133 = new Object[r115];     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        r133[r116] = r210;     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        r133[r130] = r125;     // Catch: NoSuchMethodException -> L77 InvocationTargetException -> L79 IllegalAccessException -> L81 ClassNotFoundException -> L83
        Object r134 = null;
        Object r135 = r132.invoke(null, r133);     // Catch: NoSuchMethodException -> L69 InvocationTargetException -> L71 IllegalAccessException -> L73 ClassNotFoundException -> L75
        if (r135 != null) goto L121;
    L93:
        if (r135 != null) goto L119;
        krc.b.a("ServiceFetcher", "fetch service " + r105 + " failed!!!");
        return r134;
    L119:
        r125.linkToDeath(new ee.android.framework.manis.base.b.C5770b(r103, r108, r105, (IInterface) r135), r116);     // Catch: RemoteException -> L97
        return r135;
    L97:
        e = move-exception;
        e.printStackTrace();
        krc.b.b("ServiceFetcher", "fetcherService remoteException e:" + e.toString(), e);
        return r135;
    L121:
        ((ConcurrentHashMap) r103.f472260a).put(r105, (IInterface) r135);     // Catch: NoSuchMethodException -> L61 InvocationTargetException -> L63 IllegalAccessException -> L65 ClassNotFoundException -> L67
    L67:
        e = e;
    L92:
        krc.b.b("ServiceFetcher", "Error: " + r126 + " class is not Found!!!", e);
    L65:
        e = e;
    L90:
        krc.b.b("ServiceFetcher", "Error: asInterface method iIllegalAccessException in class:" + r126, e);
    L61:
        e = e;
    L86:
        krc.b.b("ServiceFetcher", "Error: asInterface method NoSuchMethodException in class:" + r126, e);
    L63:
        e = e;
    L88:
        krc.b.b("ServiceFetcher", "Error: asInterface method InvocationTargetException in class:" + r126, e);
        goto L93
    L75:
        e = e;
    L91:
        r135 = r134;
    L73:
        e = e;
    L89:
        r135 = r134;
    L69:
        e = e;
    L85:
        r135 = r134;
    L71:
        e = e;
    L87:
        r135 = r134;
        goto L88
    L54:
        r130 = 1;
        r132 = r127;
    L83:
        e = e;
        r134 = null;
    L81:
        e = e;
        r134 = null;
    L77:
        e = e;
        r134 = null;
    L79:
        e = e;
        r134 = null;
    L39:
        e = move-exception;
        e.printStackTrace();
    L43:
        e = move-exception;
        krc.b.a("ServiceFetcher", "failed to stripBinder, e:" + e);     // Catch: Throwable -> L41
        r114.close();     // Catch: Exception -> L47
    L49:
        r125 = null;
    L47:
        e = move-exception;
        e.printStackTrace();
    L41:
        th = move-exception;
        r114.close();     // Catch: Exception -> L102
        throw th;
    L102:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L25:
        r115 = 2;
        r114 = r109.query(r108, r111, null, null, null);
        r116 = 0;
        r212.a(240004, "android/content/ContentResolver", "query", r109, r112, r114, r213, true);
        goto L26
    L14:
        if (r107.asBinder().pingBinder() == false) goto L18;
        if (r107.asBinder().isBinderAlive() == false) goto L18;
        return r107;
    L105:
        th = move-exception;
        throw th;
    }
}
