package j69;

import android.os.SystemClock;
import g49.d;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayDeque<Pair<String, Long>> f497536a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReentrantLock f497537b = null;

    static {
        f497536a = new ArrayDeque();
        f497537b = new ReentrantLock();
    }

    public static long a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        ReentrantLock r101 = f497537b;
        r101.lock();
        long r102 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        ArrayDeque<Pair<String, Long>> r103 = f497536a;     // Catch: Throwable -> L18
        ListIterator<Pair<String, Long>> r104 = r103.listIterator(r103.size());     // Catch: Throwable -> L18
    L5:
        if (r104.hasPrevious() == false) goto L10;
        if (Intrinsics.areEqual(r104.previous().getFirst(), r100) == false) goto L5;
        int r105 = r104.nextIndex();     // Catch: Throwable -> L18
    L12:
        if (r105 == (-1)) goto L14;
        long r106 = r102 - f497536a.remove(r105).component2().longValue();     // Catch: Throwable -> L18
        d.d("DoraOTATrackerTimer", "popStage: stage=" + r100 + ", duration=" + r106);     // Catch: Throwable -> L18
    L16:
        r101.unlock();
        return r106;
    L14:
        d.b("DoraOTATrackerTimer", "popStage: stage=" + r100 + ", not found in stack");     // Catch: Throwable -> L18
        r106 = 0;
        goto L16
    L10:
        r105 = -1;
    L18:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        ReentrantLock r101 = f497537b;
        r101.lock();
        long r102 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        f497536a.addLast(TuplesKt.to(r100, Long.valueOf(r102)));     // Catch: Throwable -> L6
        d.d("DoraOTATrackerTimer", "pushStage: stage=" + r100 + ", now=" + r102);     // Catch: Throwable -> L6
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r101.unlock();
        return;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
