package ia5;

import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<Integer> f488914f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ia5.a f488915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f488916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f488917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f488918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f488919e;

    public static final class a {
    }

    static {
        f488914f = CollectionsKt.listOf(new Integer[]{3, 4});
    }

    public final void a() {
        tt5.a.h("VideoProgressTimerManager", "destroyTimer!!! instance=" + this.f488915a.hashCode() + ", current status = " + this.f488916b + ", size=" + this.f488918d.size());
        this.f488919e = 0;
        this.f488918d.clear();
    }

    public b(ia5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "progressTimerListener");
        this.f488915a = r100;
        this.f488916b = 1;
        this.f488918d = new CompositeDisposable();
    }
}
