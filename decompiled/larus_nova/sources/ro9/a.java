package ro9;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<T> f538797a;

    public final synchronized T b() {
        monitor-enter(this);
        T r100 = (T) CollectionsKt.lastOrNull(this.f538797a);
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public a() {
        this.f538797a = new ArrayList();
    }

    public final synchronized void a(T r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);     // Catch: Throwable -> L6
        ((ArrayList) this.f538797a).remove(r100);     // Catch: Throwable -> L6
        ((ArrayList) this.f538797a).add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(T r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);     // Catch: Throwable -> L6
        ((ArrayList) this.f538797a).remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
