package sq3;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends com.bytedance.android.window.shop.repository.tab.entity.f {
    public final List<Integer> j;
    public List<? extends b> k;
    public final int l;

    public e(List<? extends b> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "pendingVoList");
        super(2505);
        this.k = r2;
        this.l = r3;
        this.j = CollectionsKt.mutableListOf(new Integer[]{7, 10, 10, Integer.MAX_VALUE});
    }
}
