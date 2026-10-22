package k25;

import com.bytedance.ee.bear.list.dto.ListDocs;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements k25.a {

    public static final class a {
    }

    static {
    }

    @Inject
    public b() {
    }

    @Override // k25.a
    public final void a(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "tokens");
    }

    @Override // k25.a
    public final void b() {
    }

    @Override // k25.a
    public final void d(List<String> r100) {
    }

    @Override // k25.a
    public final Flowable<ListDocs> m() {
        ListDocs r100 = new ListDocs();
        r100.f227914a = new ArrayList();
        return Flowable.just(r100);
    }

    @Override // k25.a
    public final Flowable<Integer> c(List<String> r100) {
        return Flowable.just(0);
    }
}
