package com.xiaomi.push;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes41.dex */
class ai implements ah, InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[][] f463117a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile int f225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile long f226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f227a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile a f228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Class f229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Object f230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class f463118b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Method f232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Method f463119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f463120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Method f463121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Method f463122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Method f463123g;

    /* JADX INFO: renamed from: com.xiaomi.push.ai$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ai f463124a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Boolean f233a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f463125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f463126c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f463127d;

        public boolean a() {
            if (TextUtils.isEmpty(this.f234a) == true) goto L5;
        L10:
            this.f233a = Boolean.TRUE;
        L12:
            if (this.f233a == null) goto L14;
            return true;
        L14:
            return false;
        L5:
            if (TextUtils.isEmpty(this.f463125b) == false) goto L10;
            if (TextUtils.isEmpty(this.f463126c) == false) goto L10;
            if (TextUtils.isEmpty(this.f463127d) == true) goto L12;
            goto L10
        }

        private a(ai r100) {
            this.f463124a = r100;
            this.f233a = null;
            this.f234a = null;
            this.f463125b = null;
            this.f463126c = null;
            this.f463127d = null;
        }

        public /* synthetic */ a(ai r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    static {
        f463117a = new String[][]{new String[]{"com.bun.supplier.IIdentifierListener", "com.bun.supplier.IdSupplier"}, new String[]{"com.bun.miitmdid.core.IIdentifierListener", "com.bun.miitmdid.supplier.IdSupplier"}};
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a */
    public boolean mo8805a() {
        a("isSupported");
        if (this.f228a != null) goto L5;
    L7:
        return false;
    L5:
        if (Boolean.TRUE.equals(this.f228a.f233a) == false) goto L7;
        return true;
    }

    @Override // com.xiaomi.push.ah
    /* JADX INFO: renamed from: a */
    public String mo8804a() {
        a("getOAID");
        if (this.f228a != null) goto L6;
        return null;
    L6:
        return this.f228a.f463125b;
    }

    private void a() {
        Object r100 = this.f230a;
        monitor-enter(r100);
        this.f230a.notifyAll();     // Catch: Throwable -> L6 Exception -> L12
    L6:
        th = move-exception;
        throw th;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L6
    }

    public ai(Context r100) {
        this.f229a = null;
        this.f463118b = null;
        this.f231a = null;
        this.f232b = null;
        this.f463119c = null;
        this.f463120d = null;
        this.f463121e = null;
        this.f463122f = null;
        this.f463123g = null;
        this.f230a = new Object();
        this.f225a = 0;
        this.f226a = 0;
        this.f228a = null;
        this.f227a = r100.getApplicationContext();
        a(r100);
        b(r100);
    }

    private void a(String r110) {
        if (this.f228a == null) goto L5;
        return;
    L5:
        long r100 = this.f226a;
        long r101 = SystemClock.elapsedRealtime() - Math.abs(r100);
        int r102 = this.f225a;
        if (r101 <= 3000) goto L22;
        if (r102 >= 3) goto L22;
        Object r103 = this.f230a;
        monitor-enter(r103);
    L18:
        th = move-exception;
        throw th;
    L12:
        if (this.f226a == r100) goto L14;
    L16:
        monitor-exit(r103);     // Catch: Throwable -> L18
        goto L22
    L14:
        if (this.f225a != r102) goto L16;
        b("retry, current count is " + r102);     // Catch: Throwable -> L18
        this.f225a = this.f225a + 1;     // Catch: Throwable -> L18
        b(this.f227a);     // Catch: Throwable -> L18
        long r104 = this.f226a;     // Catch: Throwable -> L18
        r101 = SystemClock.elapsedRealtime() - Math.abs(r104);     // Catch: Throwable -> L18
        r100 = r104;
    L22:
        if (this.f228a == null) goto L24;
        return;
    L24:
        if (r100 >= 0) goto L26;
        return;
    L26:
        if (r101 <= 3000) goto L28;
        return;
    L28:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L49;
        Object r105 = this.f230a;
        monitor-enter(r105);
    L36:
        th = move-exception;
        throw th;
    L32:
        if (this.f228a == null) goto L43;
    L34:
        monitor-exit(r105);     // Catch: Throwable -> L36
        return;
    L43:
        b(r110 + " wait...");     // Catch: Exception -> L40 Throwable -> L36
        this.f230a.wait(3000);     // Catch: Exception -> L40 Throwable -> L36
        goto L34
    }

    private void b(Context r110) {
        long r100 = SystemClock.elapsedRealtime();
        long r101 = -r100;
        Class r102 = this.f463118b;
        if (r102 != null) goto L14;
    L11:
        r100 = r101;
    L12:
        this.f226a = r100;
        return;
    L14:
        ClassLoader r103 = r102.getClassLoader();     // Catch: Throwable -> L9
        if (r103 != null) goto L7;
        r103 = r110.getClassLoader();     // Catch: Throwable -> L9
    L7:
        a(this.f231a, this.f229a.newInstance(), new Object[]{r110, Proxy.newProxyInstance(r103, new Class[]{this.f463118b}, this)});     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        b("call init sdk error:" + th);
        goto L11
    }

    private void a(Context r110) {
        Class<?> r100 = a(r110, "com.bun.miitmdid.core.MdidSdk");
        Class<?> r101 = null;
        Class<?> r102 = null;
        int r103 = 0;
    L3:
        String[][] r104 = f463117a;
        if (r103 >= r104.length) goto L10;
        String[] r105 = r104[r103];
        Class<?> r106 = a(r110, r105[0]);
        Class<?> r107 = a(r110, r105[1]);
        if (r106 == null) goto L9;
        if (r107 == null) goto L9;
        b("found class in index " + r103);
        r102 = r107;
        r101 = r106;
    L9:
        r103 = r103 + 1;
        r102 = r107;
        r101 = r106;
    L10:
        this.f229a = r100;
        this.f231a = a(r100, "InitSdk", new Class[]{Context.class, r101});
        this.f463118b = r101;
        this.f463119c = a(r102, "getOAID", new Class[0]);
        this.f463122f = a(r102, "isSupported", new Class[0]);
        this.f463123g = a(r102, "shutDown", new Class[0]);
    }

    private static void b(String r100) {
        com.xiaomi.channel.commonutils.logger.b.m8718a("mdid:" + r100);
    }

    private static boolean a(Object r100) {
        if ((r100 instanceof Boolean) == false) goto L5;
    L20:
        return true;
    L5:
        if ((r100 instanceof Character) == true) goto L20;
        if ((r100 instanceof Byte) == true) goto L20;
        if ((r100 instanceof Short) == true) goto L20;
        if ((r100 instanceof Integer) == true) goto L20;
        if ((r100 instanceof Long) == true) goto L20;
        if ((r100 instanceof Float) == true) goto L20;
        if ((r100 instanceof Double) == true) goto L20;
        return false;
    }

    private static Class<?> a(Context r100, String r101) {
        return q.a(r100, r101);
    L4:
        return null;
    }

    private static <T> T a(Method r100, Object r101, Object... r102) {
        if (r100 != null) goto L9;
        return null;
    L9:
        T r103 = (T) r100.invoke(r101, r102);
        if (r103 == null) goto L11;
        return r103;
    L11:
        return null;
    L12:
        return null;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object r100, Method r101, Object[] r102) {
        this.f226a = SystemClock.elapsedRealtime();
        AnonymousClass1 r103 = null;
        if (r102 == null) goto L27;
        a r104 = new a(this, r103);
        int r105 = r102.length;
        boolean r106 = false;
        int r107 = 0;
    L5:
        if (r107 >= r105) goto L27;
        Object r108 = r102[r107];
        if (r108 == null) goto L26;
        if (a(r108) == true) goto L26;
        r104.f463125b = (String) a(this.f463119c, r108, new Object[0]);
        r104.f233a = (Boolean) a(this.f463122f, r108, new Object[0]);
        a(this.f463123g, r108, new Object[0]);
        if (r104.a() == false) goto L26;
        StringBuilder r109 = new StringBuilder("has get succ, check duplicate:");
        if (this.f228a == null) goto L16;
        r106 = true;
    L16:
        r109.append(r106);
        b(r109.toString());
        monitor-enter(ai.class);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (this.f228a != null) goto L21;
        this.f228a = r104;     // Catch: Throwable -> L23
    L21:
        monitor-exit(ai.class);     // Catch: Throwable -> L23
    L26:
        r107 = r107 + 1;
    L27:
        a();
        return null;
    }

    private static Method a(Class<?> r100, String r101, Class<?>... r102) {
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getMethod(r101, r102);
    L10:
        return null;
    }
}
