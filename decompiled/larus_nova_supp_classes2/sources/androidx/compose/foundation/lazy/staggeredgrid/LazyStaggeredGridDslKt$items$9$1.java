package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class LazyStaggeredGridDslKt$items$9$1 implements Function1<Integer, StaggeredGridItemSpan> {
    final /* synthetic */ T[] $items;
    final /* synthetic */ Function1<T, StaggeredGridItemSpan> $span;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridDslKt$items$9$1(Function1<? super T, StaggeredGridItemSpan> r1, T[] r2) {
        this.$span = r1;
        this.$items = r2;
    }

    public final StaggeredGridItemSpan invoke(int r3) {
        return (StaggeredGridItemSpan) this.$span.invoke(this.$items[r3]);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }
}
