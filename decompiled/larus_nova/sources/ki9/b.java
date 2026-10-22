package ki9;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<String> f503656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f503657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f503658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Integer> f503659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f503660e;

    public b() {
        this.f503659d = CollectionsKt.listOf(0);
    }

    public final void a(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        this.f503659d = r100;
    }
}
