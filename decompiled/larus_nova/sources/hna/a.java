package hna;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f486160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f486161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Pair<Integer, Long>> f486162c = null;

    static {
        f486162c = Collections.synchronizedList(new ArrayList());
    }

    public static long a() {
        List<Pair<Integer, Long>> r100 = f486162c;
        monitor-enter(r100);
        Iterator<T> r101 = r100.iterator();     // Catch: Throwable -> L11
        long r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L8;
        r102 = r102 + (SystemClock.uptimeMillis() - Math.max(f486161b, ((Number) ((Pair) r101.next()).getSecond()).longValue()));     // Catch: Throwable -> L11
        goto L6
    L8:
        long r103 = r102 + f486160a;     // Catch: Throwable -> L11
        f486160a = 0;     // Catch: Throwable -> L11
        f486161b = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        monitor-exit(r100);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void b(int r100) {
        List<Pair<Integer, Long>> r101 = f486162c;
        Intrinsics.checkNotNull(r101);
        List<Pair<Integer, Long>> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        r103.add(Integer.valueOf(((Number) ((Pair) r104.next()).getFirst()).intValue()));
        goto L4
    L7:
        if (r103.contains(Integer.valueOf(r100)) == false) goto L9;
        return;
    L9:
        f486162c.add(new Pair(Integer.valueOf(r100), Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.f384986a.d("PowerMonitor", "AudioInMonitor onStart: " + r100);
    }

    @JvmStatic
    public static final void c(int r110) {
        List<Pair<Integer, Long>> r100 = f486162c;
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
        f486160a += SystemClock.uptimeMillis() - Math.max(f486161b, ((Number) r104.getSecond()).longValue());     // Catch: Throwable -> L22
        f486162c.remove(r104);     // Catch: Throwable -> L22
        monitor-exit(r100);
        ILogDepend.f384986a.d("PowerMonitor", "AudioInMonitor onStop: " + r110 + ", audioInStartTime: " + f486160a);
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
}
