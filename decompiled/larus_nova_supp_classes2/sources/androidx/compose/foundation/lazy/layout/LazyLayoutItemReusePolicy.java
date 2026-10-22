package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableOrderedScatterSet;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.SieveCacheKt;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemReusePolicy;", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "factory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;)V", "countPerType", "Landroidx/collection/MutableObjectIntMap;", "", "getSlotsToRetain", "", "slotIds", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "areCompatible", "", "slotId", "reusableSlotId", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LazyLayoutItemReusePolicy implements SubcomposeSlotReusePolicy {
    private final MutableObjectIntMap<Object> countPerType;
    private final LazyLayoutItemContentFactory factory;

    public LazyLayoutItemReusePolicy(LazyLayoutItemContentFactory r1) {
        this.factory = r1;
        this.countPerType = ObjectIntMapKt.mutableObjectIntMapOf();
    }

    public void getSlotsToRetain(SubcomposeSlotReusePolicy.SlotIdsSet r8) {
        this.countPerType.clear();
        MutableOrderedScatterSet r0 = r8.getSet();
        Object[] r1 = r0.elements;
        long[] r2 = r0.nodes;
        int r3 = r0.tail;
    L4:
        if (r3 == Integer.MAX_VALUE) goto L10;
        int r4 = (int) ((r2[r3] >> 31) & SieveCacheKt.NodeLinkMask);
        Object r5 = r1[r3];
        Object r6 = this.factory.getContentType(r5);
        int r7 = this.countPerType.getOrDefault(r6, 0);
        if (r7 != 7) goto L8;
        r8.remove(r5);
    L9:
        r3 = r4;
        goto L4
    L8:
        this.countPerType.set(r6, r7 + 1);
        goto L9
    }

    public boolean areCompatible(Object r2, Object r3) {
        return Intrinsics.areEqual(this.factory.getContentType(r2), this.factory.getContentType(r3));
    }
}
