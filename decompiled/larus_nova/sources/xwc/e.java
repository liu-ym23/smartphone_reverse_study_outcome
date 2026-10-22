package xwc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.EventConstant;
import java.io.IOException;
import java.net.URL;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.helpers.NOPLogger;
import org.slf4j.helpers.g;
import org.slf4j.helpers.h;

/* JADX INFO: loaded from: classes42.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f565314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f565315b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final org.slf4j.helpers.d f565316c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f565317d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile ywc.e f565318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f565319f = null;

    static {
        f565315b = new g();
        f565316c = new org.slf4j.helpers.d();
        String r100 = System.getProperty("slf4j.detectLoggerNameMismatch");     // Catch: SecurityException -> L5
    L6:
        if (r100 != null) goto L8;
        boolean r101 = false;
    L9:
        f565317d = r101;
        f565319f = new String[]{EventConstant.Value.AUTH_VERSION_2};
        return;
    L8:
        r101 = r100.equalsIgnoreCase("true");
    L5:
        r100 = null;
        goto L6
    }

    public static List<ywc.e> a() {
        final ClassLoader r100 = e.class.getClassLoader();
        if (System.getSecurityManager() != null) goto L5;
        ServiceLoader r101 = ServiceLoader.load(ywc.e.class, r100);
    L6:
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        r102.add((ywc.e) r103.next());     // Catch: ServiceConfigurationError -> L11
    L11:
        e = move-exception;
        h.a("A SLF4J service provider failed to instantiate:\n" + e.getMessage());
        goto L8
    L13:
        return r102;
    L5:
        r101 = (ServiceLoader) AccessController.doPrivileged(new d(r100));
        goto L6
    }

    public static ywc.e d() {
        if (f565314a == 0) goto L5;
    L14:
        int r100 = f565314a;
        if (r100 == 1) goto L31;
        if (r100 == 2) goto L29;
        if (r100 == 3) goto L27;
        if (r100 != 4) goto L25;
        return f565316c;
    L25:
        throw new IllegalStateException("Unreachable code");
    L27:
        return f565318e;
    L29:
        throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
    L31:
        return f565315b;
    L5:
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f565314a != 0) goto L9;
        f565314a = 1;     // Catch: Throwable -> L11
        e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static final void e() {
        List<ywc.e> r100 = a();     // Catch: Exception -> L41
        h(r100);     // Catch: Exception -> L41
        ArrayList r101 = (ArrayList) r100;     // Catch: Exception -> L41
        int r102 = 0;
        if (r101.isEmpty() == true) goto L13;
        f565318e = (ywc.e) ListProtector.get(r100, 0);     // Catch: Exception -> L41
        f565318e.initialize();     // Catch: Exception -> L41
        f565314a = 3;     // Catch: Exception -> L41
        if (r101.isEmpty() == false) goto L8;
    L26:
        f();     // Catch: Exception -> L41
        if (f565314a != 3) goto L56;
        String r103 = f565318e.c();     // Catch: Throwable -> L38 NoSuchFieldError -> L44
        String[] r104 = f565319f;     // Catch: Throwable -> L38 NoSuchFieldError -> L44
        int r105 = r104.length;     // Catch: Throwable -> L38 NoSuchFieldError -> L44
        boolean r106 = false;
    L30:
        if (r102 >= r105) goto L35;
        if (r103.startsWith(r104[r102]) == false) goto L34;
        r106 = true;
    L34:
        r102 = r102 + 1;     // Catch: Throwable -> L38 NoSuchFieldError -> L44
        goto L30
    L35:
        if (r106 == true) goto L57;
        h.a("The requested version " + r103 + " by your slf4j binding is not compatible with " + Arrays.asList(f565319f).toString());     // Catch: Throwable -> L38 NoSuchFieldError -> L44
        h.a("See https://www.slf4j.org/codes.html#version_mismatch for further details.");     // Catch: Throwable -> L38 NoSuchFieldError -> L44
        goto L59
    L58:
        return;
    L57:
        return;
    L38:
        th = move-exception;
        System.err.println("Unexpected problem occured during version sanity check");
        System.err.println("Reported exception:");
        th.printStackTrace();
        return;
    L59:
        return;
    L56:
        return;
    L8:
        if (r101.size() <= 1) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L26;
        h.a("Actual provider is of type [" + ListProtector.get(r100, 0) + "]");     // Catch: Exception -> L41
        goto L26
    L10:
        r107 = false;
        goto L11
    L13:
        f565314a = 4;     // Catch: Exception -> L41
        h.a("No SLF4J providers were found.");     // Catch: Exception -> L41
        h.a("Defaulting to no-operation (NOP) logger implementation");     // Catch: Exception -> L41
        h.a("See https://www.slf4j.org/codes.html#noProviders for further details.");     // Catch: Exception -> L41
        LinkedHashSet r108 = new LinkedHashSet();     // Catch: Exception -> L41
        ClassLoader r109 = e.class.getClassLoader();     // Catch: IOException -> L23 Exception -> L41
        if (r109 != null) goto L18;
        Enumeration<URL> r110 = ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class");     // Catch: IOException -> L23 Exception -> L41
    L19:
        if (r110.hasMoreElements() == false) goto L25;
        r108.add(r110.nextElement());     // Catch: IOException -> L23 Exception -> L41
    L25:
        g(r108);     // Catch: Exception -> L41
        goto L26
    L18:
        r110 = r109.getResources("org/slf4j/impl/StaticLoggerBinder.class");     // Catch: IOException -> L23 Exception -> L41
    L23:
        e = move-exception;
        System.err.println("Error getting resources from path");     // Catch: Exception -> L41
        System.err.println("Reported exception:");     // Catch: Exception -> L41
        e.printStackTrace();     // Catch: Exception -> L41
    L41:
        e = move-exception;
        f565314a = 2;
        System.err.println("Failed to instantiate SLF4J LoggerFactory");
        System.err.println("Reported exception:");
        e.printStackTrace();
        throw new IllegalStateException("Unexpected initialization failure", e);
    }

    public static void f() {
        g r100 = f565315b;
        monitor-enter(r100);
        r100.f526233a.f526230a = true;     // Catch: Throwable -> L51
        org.slf4j.helpers.f r101 = r100.f526233a;     // Catch: Throwable -> L51
        r101.getClass();     // Catch: Throwable -> L51
        Iterator r102 = new ArrayList(((ConcurrentHashMap) r101.f526231b).values()).iterator();     // Catch: Throwable -> L51
    L6:
        if (r102.hasNext() == false) goto L8;
        org.slf4j.helpers.e r103 = (org.slf4j.helpers.e) r102.next();     // Catch: Throwable -> L51
        r103.f526224b = c(r103.f526223a);     // Catch: Throwable -> L51
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L51
        LinkedBlockingQueue<org.slf4j.event.b> r104 = f565315b.f526233a.f526232c;
        int r105 = r104.size();
        ArrayList r106 = new ArrayList(128);
        int r107 = 0;
    L11:
        if (r104.drainTo(r106, 128) == 0) goto L12;
        Iterator r108 = r106.iterator();
    L16:
        if (r108.hasNext() == false) goto L50;
        org.slf4j.event.b r109 = (org.slf4j.event.b) r108.next();
        if (r109 == null) goto L38;
        org.slf4j.helpers.e r110 = r109.f526218c;
        String r111 = r110.f526223a;
        if (r110.f526224b != null) goto L23;
        boolean r112 = true;
    L24:
        if (r112 == true) goto L49;
        if ((r110.f526224b instanceof NOPLogger) == true) goto L38;
        if (r110.b() == true) goto L31;
        h.a(r111);
        goto L38
    L31:
        if (r110.isEnabledForLevel(r109.f526216a) == false) goto L38;
        if (r110.b() == false) goto L38;
        r110.f526226d.invoke(r110.f526224b, new Object[]{r109});     // Catch: Throwable -> L36
        goto L38
    L49:
        throw new IllegalStateException("Delegate logger cannot be null at this state.");
    L23:
        r112 = false;
    L38:
        int r113 = r107 + 1;
        if (r107 != 0) goto L47;
        if (r109.f526218c.b() == false) goto L44;
        h.a("A number (" + r105 + ") of logging calls during the initialization phase have been intercepted and are");
        h.a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        h.a("See also https://www.slf4j.org/codes.html#replay");
        goto L47
    L44:
        if ((r109.f526218c.f526224b instanceof NOPLogger) == true) goto L47;
        h.a("The following set of substitute loggers may have been accessed");
        h.a("during the initialization phase. Logging calls during this");
        h.a("phase were not honored. However, subsequent logging calls to these");
        h.a("loggers will work as normally expected.");
        h.a("See also https://www.slf4j.org/codes.html#substituteLogger");
    L47:
        r107 = r113;
        goto L16
    L50:
        r106.clear();
        goto L11
    L12:
        org.slf4j.helpers.f r114 = f565315b.f526233a;
        ((ConcurrentHashMap) r114.f526231b).clear();
        r114.f526232c.clear();
        return;
    L51:
        th = move-exception;
        throw th;
    }

    public e() {
    }

    public static c b(Class<?> r100) {
        c r101 = c(r100.getName());
        if (f565317d == false) goto L35;
        h.a r102 = h.f526235a;
        Class<?> r103 = null;
        if (r102 != null) goto L15;
        if (h.f526236b == false) goto L36;
        r102 = null;
        goto L15
    L36:
        r102 = new h.a();     // Catch: SecurityException -> L12
    L13:
        h.f526235a = r102;
        h.f526236b = true;
    L12:
        r102 = null;
    L15:
        if (r102 == null) goto L29;
        Class<?>[] r104 = r102.getClassContext();
        String r105 = h.class.getName();
        int r106 = 0;
    L19:
        if (r106 >= r104.length) goto L25;
        if (r105.equals(r104[r106].getName()) == true) goto L25;
        r106 = r106 + 1;
    L25:
        if (r106 >= r104.length) goto L34;
        int r107 = r106 + 2;
        if (r107 >= r104.length) goto L34;
        r103 = r104[r107];
    L34:
        throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    L29:
        if (r103 == null) goto L35;
        if ((!r103.isAssignableFrom(r100)) == false) goto L35;
        h.a(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[]{r101.getName(), r103.getName()}));
        h.a("See https://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
    L35:
        return r101;
    }

    public static c c(String r100) {
        return d().a().a(r100);
    }

    public static void g(Set<URL> r100) {
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        h.a("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator<URL> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        h.a("Ignoring binding found at [" + r101.next() + "]");
        goto L7
    L9:
        h.a("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void h(List<ywc.e> r100) {
        ArrayList r101 = (ArrayList) r100;
        boolean r102 = true;
        if (r101.size() > 1) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L14;
        h.a("Class path contains multiple SLF4J providers.");
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        h.a("Found provider [" + ((ywc.e) r103.next()) + "]");
        goto L9
    L11:
        h.a("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        return;
    }
}
