package d64;

import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements MemoryTrimmableRegistry {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f467194c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<MemoryTrimmable> f467195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f467196b;

    public c() {
        this.f467195a = new HashSet();
        this.f467196b = new Object();
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public final void registerMemoryTrimmable(MemoryTrimmable r100) {
        if (r100 == null) goto L11;
        Object r101 = this.f467196b;
        monitor-enter(r101);
        ((HashSet) this.f467195a).add(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.common.memory.MemoryTrimmableRegistry
    public final void unregisterMemoryTrimmable(MemoryTrimmable r100) {
        if (r100 == null) goto L11;
        Object r101 = this.f467196b;
        monitor-enter(r101);
        ((HashSet) this.f467195a).remove(r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
