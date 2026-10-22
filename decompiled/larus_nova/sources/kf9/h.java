package kf9;

import com.ss.kmp.ugc.aweme.concurrent.lock.ReentrantReadWriteLock;
import kotlin.Unit;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f503280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f503281b;

    public final boolean a() {
        ReentrantReadWriteLock.WriteLock r100 = this.f503280a.writeLock();
        r100.lock();
    L10:
        th = move-exception;
        r100.unlock();
        throw th;
    L4:
        if (this.f503281b == true) goto L7;
        boolean r101 = true;
        this.f503281b = true;     // Catch: Throwable -> L10
    L8:
        r100.unlock();
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    public final void b() {
        ReentrantReadWriteLock.WriteLock r100 = this.f503280a.writeLock();
        r100.lock();
        this.f503281b = false;     // Catch: Throwable -> L6
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r100.unlock();
        return;
    L6:
        th = move-exception;
        r100.unlock();
        throw th;
    }

    public h() {
        this.f503280a = new ReentrantReadWriteLock();
        this.f503281b = false;
    }
}
