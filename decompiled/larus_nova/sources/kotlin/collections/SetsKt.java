package kotlin.collections;

import an4.e;
import com.bytedance.ruler.strategy.provider.StrategyProviderCenter;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"kotlin/collections/SetsKt__SetsJVMKt", "kotlin/collections/SetsKt__SetsKt", "kotlin/collections/SetsKt___SetsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class SetsKt extends SetsKt___SetsKt {
    public static /* bridge */ /* synthetic */ Set a(e r100) {
        return SetsKt__SetsKt.setOfNotNull(r100);
    }

    private SetsKt() {
    }

    public static /* bridge */ /* synthetic */ TreeSet b(Object... r100) {
        return SetsKt__SetsJVMKt.sortedSetOf(StrategyProviderCenter.a.f267718a, r100);
    }
}
