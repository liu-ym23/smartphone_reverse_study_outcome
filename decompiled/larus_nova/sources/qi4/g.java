package qi4;

import java.util.Comparator;
import ki4.r;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g extends f {

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((r) r101).getDuration()), Long.valueOf(((r) r100).getDuration()));
        }
    }

    public g() {
    }

    @Override // qi4.f, ki4.m
    public final Comparator<r> b(ki4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "groupKey");
        return new a();
    }
}
