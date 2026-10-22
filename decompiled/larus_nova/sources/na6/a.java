package na6;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f518466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f518467b;

    public final String toString() {
        ReentrantReadWriteLock.ReadLock r100 = this.f518467b.f518471a.readLock();
        r100.lock();
        String r101 = this.f518466a.toString();     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public a(int r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter(r101, "map");
        this.f518466a = r101;
        this.f518467b = new e();
    }
}
