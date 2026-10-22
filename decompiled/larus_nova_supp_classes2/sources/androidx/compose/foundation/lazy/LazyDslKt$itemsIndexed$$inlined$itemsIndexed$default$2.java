package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
public final class LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2 implements Function1<Integer, Object> {
    final /* synthetic */ Object[] $items;

    public LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(Object[] r1) {
        this.$items = r1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Number) r1).intValue());
    }

    public final Object invoke(int r2) {
        Object r3 = this.$items[r2];
        return null;
    }
}
