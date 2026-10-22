package k25;

import com.bytedance.ee.bear.list.dto.ListDocs;
import io.reactivex.Flowable;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class j0 implements k25.a {

    public static final class a {
    }

    static {
    }

    @Inject
    public j0() {
    }

    @Override // k25.a
    public final void b() {
        Long r100 = com.bytedance.ee.bear.document.offline.sync.h0.f220589j;
        com.bytedance.ee.bear.document.offline.sync.h0.b.f220605a.a();
    }

    @Override // k25.a
    public final Flowable<ListDocs> m() {
        return ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).m();
    }

    @Override // k25.a
    public final void a(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "tokens");
        ((ze5.a) org.koin.java.a.c(ze5.a.class, null, null, 6)).b(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("OfflineDataManagerDependencyImpl", "clean comment draft by token error!", th, false);
    }

    @Override // k25.a
    public final Flowable<Integer> c(List<String> r100) {
        return ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).c(r100);
    }

    @Override // k25.a
    public final void d(List<String> r100) {
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).d(r100);
    }
}
