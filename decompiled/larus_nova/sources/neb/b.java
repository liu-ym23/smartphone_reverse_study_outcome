package neb;

import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f518912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReadWriteLock f518913b;

    @Override // neb.a
    public final boolean e1() {
        return false;
    }

    @Inject
    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f518912a = new HashSet();
        new HashSet();
        this.f518913b = new ReentrantReadWriteLock();
    }

    @Override // neb.a
    public final void qe(String r100) {
        Intrinsics.checkNotNullParameter(r100, "feedId");
        Lock r101 = ((ReentrantReadWriteLock) this.f518913b).writeLock();
        r101.lock();
        ((HashSet) this.f518912a).add(r100);     // Catch: Throwable -> L6
        r101.unlock();
        return;
    L6:
        th = move-exception;
        r101.unlock();
        throw th;
    }
}
