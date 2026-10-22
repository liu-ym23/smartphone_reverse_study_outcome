package androidx.compose.foundation.lazy;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"visibleItemsAverageSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyListLayoutInfoKt {
    public static final int visibleItemsAverageSize(LazyListLayoutInfo r5) {
        List<LazyListItemInfo> r0 = r5.getVisibleItemsInfo();
        int r1 = r0.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r3 = r3 + ((LazyListItemInfo) ListProtector.get(r0, r2)).getSize();
        r2 = r2 + 1;
        goto L3
    L6:
        return (r3 / r0.size()) + r5.getMainAxisItemSpacing();
    }
}
