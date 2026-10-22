package qi4;

import com.baidu.platform.comapi.map.MapController;
import java.util.Comparator;
import java.util.List;
import ki4.m;
import ki4.r;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class f implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ki4.b> f533146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f533147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f533148c;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((ki4.b) r101).f503614b, ((ki4.b) r100).f503614b);
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((r) r101).getDate()), Long.valueOf(((r) r100).getDate()));
        }
    }

    public f() {
        this.f533146a = CollectionsKt.listOf(new ki4.b());
        this.f533147b = new a();
        this.f533148c = new b();
    }

    @Override // ki4.m, ki4.k
    public final Comparator<ki4.b> getComparator() {
        return this.f533147b;
    }

    @Override // ki4.m
    public Comparator<r> b(ki4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "groupKey");
        return this.f533148c;
    }

    @Override // ki4.k
    public final List<ki4.b> e(r r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return this.f533146a;
    }
}
