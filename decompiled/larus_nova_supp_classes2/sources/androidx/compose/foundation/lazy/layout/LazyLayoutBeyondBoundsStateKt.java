package androidx.compose.foundation.lazy.layout;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"calculateLazyLayoutPinnedIndices", "", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutBeyondBoundsStateKt {
    public static final List<Integer> calculateLazyLayoutPinnedIndices(LazyLayoutItemProvider r8, LazyLayoutPinnedItemList r9, LazyLayoutBeyondBoundsInfo r10) {
        if (r10.hasIntervals() == false) goto L5;
    L8:
        ArrayList r0 = new ArrayList();
        if (r10.hasIntervals() == false) goto L11;
        IntRange r1 = new IntRange(r10.getStart(), Math.min(r10.getEnd(), r8.getItemCount() - 1));
    L12:
        int r11 = r9.size();
        int r4 = 0;
    L13:
        if (r4 >= r11) goto L28;
        LazyLayoutPinnedItemList.PinnedItem r5 = (LazyLayoutPinnedItemList.PinnedItem) ListProtector.get(r9, r4);
        int r6 = LazyLayoutItemProviderKt.findIndexByKey(r8, r5.getKey(), r5.getIndex());
        int r7 = r1.getFirst();
        if (r6 > r1.getLast()) goto L18;
        if (r7 > r6) goto L18;
        boolean r12 = true;
    L19:
        if (r12 == true) goto L27;
        if (r6 >= 0) goto L22;
    L24:
        boolean r13 = false;
    L25:
        if (r13 == false) goto L27;
        r0.add(Integer.valueOf(r6));
        goto L27
    L22:
        if (r6 >= r8.getItemCount()) goto L24;
        r13 = true;
    L27:
        r4 = r4 + 1;
    L18:
        r12 = false;
        goto L19
    L28:
        int r14 = r1.getFirst();
        int r15 = r1.getLast();
        if (r14 > r15) goto L33;
    L30:
        r0.add(Integer.valueOf(r14));
        if (r14 == r15) goto L33;
        r14 = r14 + 1;
    L33:
        return r0;
    L11:
        r1 = IntRange.Companion.getEMPTY();
        goto L12
    L5:
        if (r9.isEmpty() == false) goto L8;
        return CollectionsKt.emptyList();
    }
}
