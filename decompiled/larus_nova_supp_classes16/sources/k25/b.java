package k25;

import com.bytedance.ee.bear.list.dto.ListDocs;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements k25.a {

    public static final class a {
    }

    static {
    }

    @Inject
    public b() {
    }

    @Override // k25.a
    public final void a(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "tokens");
    }

    @Override // k25.a
    public final void b() {
    }

    @Override // k25.a
    public final void d(List<String> r1) {
    }

    @Override // k25.a
    public final Flowable<ListDocs> m() {
        ListDocs r0 = new ListDocs();
        r0.a = new ArrayList();
        return Flowable.just(r0);
    }

    @Override // k25.a
    public final Flowable<Integer> c(List<String> r1) {
        return Flowable.just(0);
    }
}
