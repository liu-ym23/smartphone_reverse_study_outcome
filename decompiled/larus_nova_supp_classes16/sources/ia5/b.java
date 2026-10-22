package ia5;

import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final List<Integer> f = null;
    public final ia5.a a;
    public int b;
    public boolean c;
    public final CompositeDisposable d;
    public int e;

    public static final class a {
    }

    static {
        f = CollectionsKt.listOf(new Integer[]{3, 4});
    }

    public final void a() {
        tt5.a.h("VideoProgressTimerManager", "destroyTimer!!! instance=" + this.a.hashCode() + ", current status = " + this.b + ", size=" + this.d.size());
        this.e = 0;
        this.d.clear();
    }

    public b(ia5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "progressTimerListener");
        this.a = r2;
        this.b = 1;
        this.d = new CompositeDisposable();
    }
}
