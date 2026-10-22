package p57;

import android.os.Looper;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f527788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f527789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<g> f527790c;

    public b() {
        this.f527790c = new LinkedList();
    }

    public final boolean a(Thread r100, Throwable r101) throws Throwable {
        List<g> r102 = this.f527790c;     // Catch: Throwable -> L19
        monitor-enter(r102);     // Catch: Throwable -> L19
        Iterator<g> r103 = this.f527790c.iterator();     // Catch: Throwable -> L14
    L6:
        if (r103.hasNext() == false) goto L12;
        if (r103.next().a(r100, r101) == false) goto L6;
        monitor-exit(r102);     // Catch: Throwable -> L14
        return true;
    L12:
        monitor-exit(r102);     // Catch: Throwable -> L14
        return false;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L25:
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r100, Throwable r101) {
        if (r101 != null) goto L5;
    L4:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L60;
    L42:
        Thread.UncaughtExceptionHandler r103 = this.f527789b;     // Catch: Throwable -> L40
        if (r103 == null) goto L79;
        if (r103 == this) goto L80;
        r103.uncaughtException(r100, r101);     // Catch: Throwable -> L40
        return;
    L80:
        return;
    L79:
        return;
    L60:
    L40:
        th = move-exception;
        Thread.UncaughtExceptionHandler r104 = this.f527789b;
        if (r104 == null) goto L81;
        if (r104 == this) goto L82;
        r104.uncaughtException(r100, th);
        return;
    L82:
        return;
    L81:
        return;
    L16:
        if (a(r100, r101) == false) goto L42;
        if (r100 != null) goto L19;
        return;
    L19:
        if (r100.getName().equals(PullConfiguration.PROCESS_NAME_MAIN) == false) goto L75;
    L56:
        Looper.loop();     // Catch: Exception -> L22 Throwable -> L40
    L22:
        e = move-exception;
        Throwable r105 = e;
        int r106 = 0;
    L24:
        if (r105 == null) goto L32;
        if ((r105 instanceof OutOfMemoryError) == true) goto L27;
        if (r106 > 20) goto L32;
        r106 = r106 + 1;     // Catch: Throwable -> L53
        r105 = r105.getCause();     // Catch: Throwable -> L53
    L27:
        boolean r107 = true;
    L33:
        if (r107 == true) goto L36;
        if (a(r100, e) == true) goto L56;
    L36:
        Thread.UncaughtExceptionHandler r108 = this.f527789b;     // Catch: Throwable -> L40
        if (r108 == null) goto L76;
        if (r108 == this) goto L77;
        r108.uncaughtException(r100, e);     // Catch: Throwable -> L40
        return;
    L77:
        return;
    L76:
        return;
    L32:
        r107 = false;
        goto L33
    L75:
        return;
    L5:
        Throwable r109 = r101;
        int r110 = 0;
    L6:
        if (r109 == null) goto L4;
        if ((r109 instanceof OutOfMemoryError) == true) goto L9;
        if (r110 > 20) goto L4;
        r110 = r110 + 1;     // Catch: Throwable -> L52
        r109 = r109.getCause();     // Catch: Throwable -> L52
    L9:
        r102 = true;
        goto L14
    }
}
