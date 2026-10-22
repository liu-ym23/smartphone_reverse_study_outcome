package androidx.compose.foundation.lazy.staggeredgrid;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class LazyStaggeredGridDslKt$items$2$1 implements Function1<Integer, Object> {
    final /* synthetic */ List<T> $items;
    final /* synthetic */ Function1<T, Object> $key;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridDslKt$items$2$1(Function1<? super T, ? extends Object> r1, List<? extends T> r2) {
        this.$key = r1;
        this.$items = r2;
    }

    public final Object invoke(int r3) {
        return this.$key.invoke(ListProtector.get(this.$items, r3));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }
}
