package ona;

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
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f524401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f524402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Pair<a, Long>> f524403c = null;

    static {
        f524403c = Collections.synchronizedList(new ArrayList());
    }

    public static long b() {
        List<Pair<a, Long>> r100 = f524403c;
        monitor-enter(r100);
        Iterator<T> r101 = r100.iterator();     // Catch: Throwable -> L11
        long r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L8;
        r102 = r102 + (SystemClock.uptimeMillis() - Math.max(f524402b, ((Number) ((Pair) r101.next()).getSecond()).longValue()));     // Catch: Throwable -> L11
        goto L6
    L8:
        long r103 = r102 + f524401a;     // Catch: Throwable -> L11
        f524401a = 0;     // Catch: Throwable -> L11
        f524402b = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        monitor-exit(r100);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "sensorInfo");
        List<Pair<a, Long>> r101 = f524403c;
        Intrinsics.checkNotNull(r101);
        List<Pair<a, Long>> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        r103.add(Integer.valueOf(((a) ((Pair) r104.next()).getFirst()).f524399a));
        goto L4
    L7:
        if (r103.contains(Integer.valueOf(r100.f524399a)) == false) goto L15;
        List<Pair<a, Long>> r105 = f524403c;
        Intrinsics.checkNotNull(r105);
        List<Pair<a, Long>> r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L10:
        if (r108.hasNext() == false) goto L13;
        r107.add(((a) ((Pair) r108.next()).getFirst()).f524400b);
        goto L10
    L13:
        if (r107.contains(r100.f524400b) == false) goto L15;
        return;
    L15:
        f524403c.add(new Pair(r100, Long.valueOf(SystemClock.uptimeMillis())));
        ILogDepend.f384986a.d("PowerMonitor", "SensorMonitor onRegister: listenerHashCode=" + r100.f524399a + ", sensorHashCode=" + r100.f524400b);
    }

    @JvmStatic
    public static final void c(a r110) {
        Intrinsics.checkNotNullParameter(r110, "sensorInfo");
        Object r100 = null;
        if (r110.f524400b != null) goto L25;
        List<Pair<a, Long>> r101 = f524403c;
        Intrinsics.checkNotNull(r101);
        monitor-enter(r101);
        Iterator<T> r102 = r101.iterator();     // Catch: Throwable -> L22
    L8:
        if (r102.hasNext() == false) goto L15;
        Object r103 = r102.next();     // Catch: Throwable -> L22
        if (((a) ((Pair) r103).getFirst()).f524399a != r110.f524399a) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L8;
        r100 = r103;
        goto L15
    L12:
        r104 = false;
    L15:
        Pair r105 = (Pair) r100;     // Catch: Throwable -> L22
        if (r105 != null) goto L19;
        monitor-exit(r101);
        return;
    L19:
        f524401a += SystemClock.uptimeMillis() - Math.max(f524402b, ((Number) r105.getSecond()).longValue());     // Catch: Throwable -> L22
        f524403c.remove(r105);     // Catch: Throwable -> L22
        monitor-exit(r101);
        ILogDepend.f384986a.d("PowerMonitor", "SensorMonitor onUnregister: listenerHashCode=" + r110.f524399a + ", sensorHashCode=null, sensorListenerTime=" + f524401a);
        return;
    L22:
        th = move-exception;
        throw th;
    L25:
        List<Pair<a, Long>> r106 = f524403c;
        Intrinsics.checkNotNull(r106);
        monitor-enter(r106);
        Iterator<T> r107 = r106.iterator();     // Catch: Throwable -> L46
    L29:
        if (r107.hasNext() == false) goto L38;
        Object r108 = r107.next();     // Catch: Throwable -> L46
        Pair r109 = (Pair) r108;     // Catch: Throwable -> L46
        if (((a) r109.getFirst()).f524399a == r110.f524399a) goto L33;
    L35:
        boolean r111 = false;
    L36:
        if (r111 == false) goto L29;
        r100 = r108;
        goto L38
    L33:
        if (Intrinsics.areEqual(((a) r109.getFirst()).f524400b, r110.f524400b) == false) goto L35;
        r111 = true;
    L38:
        Pair r112 = (Pair) r100;     // Catch: Throwable -> L46
        if (r112 != null) goto L42;
        monitor-exit(r106);
        return;
    L42:
        f524401a += SystemClock.uptimeMillis() - Math.max(f524402b, ((Number) r112.getSecond()).longValue());     // Catch: Throwable -> L46
        f524403c.remove(r112);     // Catch: Throwable -> L46
        monitor-exit(r106);
        ILogDepend.f384986a.d("PowerMonitor", "SensorMonitor onUnregister: listenerHashCode=" + r110.f524399a + ", sensorHashCode=" + r110.f524400b + ", sensorListenerTime=" + f524401a);
        return;
    L46:
        th = move-exception;
        throw th;
    }
}
