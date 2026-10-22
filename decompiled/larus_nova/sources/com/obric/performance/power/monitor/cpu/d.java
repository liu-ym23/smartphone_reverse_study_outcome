package com.obric.performance.power.monitor.cpu;

import android.os.PowerManager;
import android.os.SystemClock;
import com.obric.aiagent.platform.depend.ILogDepend;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f403827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f403828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Pair<Integer, Long>> f403829c = null;

    static {
        f403829c = Collections.synchronizedList(new ArrayList());
    }

    @JvmStatic
    public static final void a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "wakeLockObject");
        int r101 = r100.hashCode();
        if ((r100 instanceof PowerManager.WakeLock) == false) goto L14;
        List<Pair<Integer, Long>> r102 = f403829c;
        Intrinsics.checkNotNull(r102);
        List<Pair<Integer, Long>> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L6:
        if (r105.hasNext() == false) goto L9;
        r104.add(Integer.valueOf(((Number) ((Pair) r105.next()).getFirst()).intValue()));
        goto L6
    L9:
        if (r104.contains(Integer.valueOf(r101)) == true) goto L15;
        f403829c.add(new Pair(Integer.valueOf(r101), Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.f384986a.d("PowerMonitor", "WakeLockMonitor onAcquire: " + r101);
        return;
    L15:
        return;
    }

    @JvmStatic
    public static final void b(Object r110) {
        Intrinsics.checkNotNullParameter(r110, "wakeLockObject");
        int r100 = r110.hashCode();
        if ((r110 instanceof PowerManager.WakeLock) == false) goto L35;
        List<Pair<Integer, Long>> r101 = f403829c;
        Intrinsics.checkNotNull(r101);
        List<Pair<Integer, Long>> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L9;
        r103.add(Integer.valueOf(((Number) ((Pair) r104.next()).getFirst()).intValue()));
        goto L6
    L9:
        if (r103.contains(Integer.valueOf(r100)) == true) goto L12;
        return;
    L12:
        if (((PowerManager.WakeLock) r110).isHeld() == true) goto L44;
        List<Pair<Integer, Long>> r111 = f403829c;
        Intrinsics.checkNotNull(r111);
        monitor-enter(r111);
        Iterator<T> r105 = r111.iterator();     // Catch: Throwable -> L32
    L17:
        if (r105.hasNext() == false) goto L24;
        Object r106 = r105.next();     // Catch: Throwable -> L32
        if (((Number) ((Pair) r106).getFirst()).intValue() != r100) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L17;
    L25:
        Pair r108 = (Pair) r106;     // Catch: Throwable -> L32
        if (r108 != null) goto L29;
        monitor-exit(r111);
        return;
    L29:
        f403827a += SystemClock.uptimeMillis() - Math.max(f403828b, ((Number) r108.getSecond()).longValue());     // Catch: Throwable -> L32
        f403829c.remove(r108);     // Catch: Throwable -> L32
        monitor-exit(r111);
        ILogDepend.f384986a.d("PowerMonitor", "WakeLockMonitor onRelease: " + r100 + ", wakeLockTime: " + f403827a);
        return;
    L21:
        r107 = false;
        goto L22
    L24:
        r106 = null;
    L32:
        th = move-exception;
        throw th;
    L44:
        return;
    }
}
