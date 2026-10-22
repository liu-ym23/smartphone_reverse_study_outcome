package ii9;

import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<String> f490008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Float, Unit> f490009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f490010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<Integer> f490011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f490012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f490013f;

    public b() {
        this.f490010c = new float[]{0.0f};
        this.f490011d = CollectionsKt.listOf(0);
    }

    public final void a(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        this.f490011d = r100;
    }
}
