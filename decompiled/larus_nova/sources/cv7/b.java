package cv7;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ClassLoader f465498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Thread f465499b;

    public static synchronized ClassLoader a() {
        monitor-enter(b.class);
    L64:
        th = move-exception;
        throw th;
    L5:
        if (f465498a != null) goto L61;
        Thread r100 = f465499b;     // Catch: Throwable -> L64
        ClassLoader r101 = null;
        if (r100 != null) goto L49;
        ThreadGroup r102 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getThreadGroup();     // Catch: Throwable -> L64
        if (r102 != null) goto L12;
        r100 = null;
    L44:
        f465499b = r100;     // Catch: Throwable -> L64
        if (r100 != null) goto L49;
    L57:
        f465498a = r101;     // Catch: Throwable -> L64
        goto L61
    L12:
        monitor-enter(Void.class);     // Catch: Throwable -> L64
        int r103 = r102.activeGroupCount();     // Catch: Throwable -> L37 SecurityException -> L39
        ThreadGroup[] r104 = new ThreadGroup[r103];     // Catch: Throwable -> L37 SecurityException -> L39
        r102.enumerate(r104);     // Catch: Throwable -> L37 SecurityException -> L39
        int r105 = 0;
        int r106 = 0;
    L14:
        if (r106 >= r103) goto L19;
        ThreadGroup r107 = r104[r106];     // Catch: Throwable -> L37 SecurityException -> L39
        if ("dynamiteLoader".equals(r107.getName()) == true) goto L20;
        r106 = r106 + 1;     // Catch: Throwable -> L37 SecurityException -> L39
    L20:
        if (r107 != null) goto L22;
        r107 = new ThreadGroup(r102, "dynamiteLoader");     // Catch: Throwable -> L37 SecurityException -> L39
    L22:
        int r108 = r107.activeCount();     // Catch: Throwable -> L37 SecurityException -> L39
        Thread[] r109 = new Thread[r108];     // Catch: Throwable -> L37 SecurityException -> L39
        r107.enumerate(r109);     // Catch: Throwable -> L37 SecurityException -> L39
    L23:
        if (r105 >= r108) goto L28;
        Thread r110 = r109[r105];     // Catch: Throwable -> L37 SecurityException -> L39
        if ("GmsDynamite".equals(r110.getName()) == true) goto L29;
        r105 = r105 + 1;
    L29:
        if (r110 == null) goto L72;
    L42:
        monitor-exit(Void.class);     // Catch: Throwable -> L37
        r100 = r110;
        goto L44
    L72:
        a r111 = new a(r107);     // Catch: SecurityException -> L35 Throwable -> L37
        r111.setContextClassLoader(null);     // Catch: SecurityException -> L33 Throwable -> L37
        ThreadMethodProxy.start(r111);     // Catch: SecurityException -> L33 Throwable -> L37
        r110 = r111;
    L33:
        SecurityException e100 = e;
        r110 = r111;
    L41:
        e100.getMessage();     // Catch: Throwable -> L37
    L35:
        e = move-exception;
        e100 = e;
        goto L41
    L28:
        r110 = null;
        goto L29
    L19:
        r107 = null;
    L37:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L39:
        e = move-exception;
        e100 = e;
        r110 = null;
    L49:
        monitor-enter(r100);     // Catch: Throwable -> L64
        r101 = f465499b.getContextClassLoader();     // Catch: Throwable -> L52 SecurityException -> L54
    L56:
        monitor-exit(r100);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L54:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L52
    L61:
        ClassLoader r112 = f465498a;     // Catch: Throwable -> L64
        monitor-exit(b.class);
        return r112;
    }
}
