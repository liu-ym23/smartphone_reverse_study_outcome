package lp7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f510234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f510235b;

    public final List<T> a() {
        ReentrantLock r100 = this.f510235b;
        r100.lock();
        List<T> r101 = CollectionsKt.toList(this.f510234a);     // Catch: Throwable -> L6
        r100.unlock();
        return r101;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public c() {
        this.f510234a = new ArrayList();
        this.f510235b = new ReentrantLock();
    }
}
