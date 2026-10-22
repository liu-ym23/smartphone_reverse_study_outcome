package gna;

import android.os.SystemClock;
import com.obric.aiagent.platform.depend.ILogDepend;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f481853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f481854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Pair<Integer, Long>> f481855c = null;

    static {
        f481855c = Collections.synchronizedList(new ArrayList());
    }

    public static long b() {
        List<Pair<Integer, Long>> r100 = f481855c;
        monitor-enter(r100);
        Iterator<T> r101 = r100.iterator();     // Catch: Throwable -> L11
        long r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L8;
        r102 = r102 + (SystemClock.uptimeMillis() - Math.max(f481854b, ((Number) ((Pair) r101.next()).getSecond()).longValue()));     // Catch: Throwable -> L11
        goto L6
    L8:
        long r103 = r102 + f481853a;     // Catch: Throwable -> L11
        f481853a = 0;     // Catch: Throwable -> L11
        f481854b = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        monitor-exit(r100);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void a(int r110) {
        List<Pair<Integer, Long>> r100 = f481855c;
        Intrinsics.checkNotNull(r100);
        monitor-enter(r100);
        Iterator<T> r101 = r100.iterator();     // Catch: Throwable -> L22
    L6:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();     // Catch: Throwable -> L22
        if (((Number) ((Pair) r102).getFirst()).intValue() != r110) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L6;
    L14:
        Pair r104 = (Pair) r102;     // Catch: Throwable -> L22
        if (r104 != null) goto L18;
        monitor-exit(r100);
        return;
    L18:
        f481853a += SystemClock.uptimeMillis() - Math.max(f481854b, ((Number) r104.getSecond()).longValue());     // Catch: Throwable -> L22
        f481855c.remove(r104);     // Catch: Throwable -> L22
        monitor-exit(r100);
        ILogDepend.f384986a.d("PowerMonitor", "AudioMonitor onPauseOrStop: " + r110 + ", audioStartTime: " + f481853a);
        return;
    L10:
        r103 = false;
        goto L11
    L13:
        r102 = null;
    L22:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void c(int r100) {
        List<Pair<Integer, Long>> r101 = f481855c;
        Intrinsics.checkNotNull(r101);
        monitor-enter(r101);
        List<Pair<Integer, Long>> r102 = r101;     // Catch: Throwable -> L26
        boolean r103 = false;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r104 = r102.iterator();     // Catch: Throwable -> L26
    L11:
        if (r104.hasNext() == false) goto L19;
        if (((Number) ((Pair) r104.next()).getFirst()).intValue() != r100) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L11;
        r103 = true;
        goto L19
    L16:
        r105 = false;
    L19:
        if (r103 == false) goto L22;
        monitor-exit(r101);
        return;
    L22:
        f481855c.add(new Pair(Integer.valueOf(r100), Long.valueOf(SystemClock.uptimeMillis())));     // Catch: Throwable -> L26
        monitor-exit(r101);
        ILogDepend.f384986a.d("PowerMonitor", "AudioMonitor onStart: " + r100);
        return;
    L7:
        if (r102.isEmpty() == false) goto L9;
    L26:
        th = move-exception;
        throw th;
    }
}
