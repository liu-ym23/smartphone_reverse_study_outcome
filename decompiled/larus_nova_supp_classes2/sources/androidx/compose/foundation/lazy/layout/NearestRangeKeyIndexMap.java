package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/lazy/layout/NearestRangeKeyIndexMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "nearestRange", "Lkotlin/ranges/IntRange;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "<init>", "(Lkotlin/ranges/IntRange;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;)V", "map", "Landroidx/collection/ObjectIntMap;", "", "keys", "", "[Ljava/lang/Object;", "keysStartIndex", "", "getIndex", "key", "getKey", "index", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    public static final int $stable = 8;
    private final Object[] keys;
    private final int keysStartIndex;
    private final ObjectIntMap<Object> map;

    public static /* synthetic */ Unit a(int r0, int r1, MutableObjectIntMap r2, NearestRangeKeyIndexMap r3, IntervalList.Interval r4) {
        return lambda$2$lambda$1(r0, r1, r2, r3, r4);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public int getIndex(Object r2) {
        ObjectIntMap<Object> r0 = this.map;
        int r3 = r0.findKeyIndex(r2);
        if (r3 >= 0) goto L7;
        return -1;
    L7:
        return r0.values[r3];
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public Object getKey(int r4) {
        Object[] r0 = this.keys;
        int r5 = r4 - this.keysStartIndex;
        boolean r1 = false;
        if (r5 >= 0) goto L5;
    L7:
        if (r1 == true) goto L11;
        return null;
    L11:
        return r0[r5];
    L5:
        if (r5 >= r0.length) goto L7;
        r1 = true;
        goto L7
    }

    public NearestRangeKeyIndexMap(IntRange r5, LazyLayoutIntervalContent<?> r6) {
        IntervalList<Interval> r7 = r6.getIntervals();
        final int r0 = r5.getFirst();
        if (r0 < 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("negative nearestRange.first");
    L8:
        final int r8 = Math.min(r5.getLast(), r7.getSize() - 1);
        if (r8 >= r0) goto L11;
        this.map = ObjectIntMapKt.emptyObjectIntMap();
        this.keys = new Object[0];
        this.keysStartIndex = 0;
        return;
    L11:
        int r2 = (r8 - r0) + 1;
        this.keys = new Object[r2];
        this.keysStartIndex = r0;
        final MutableObjectIntMap r1 = new MutableObjectIntMap(r2);
        r7.forEach(r0, r8, new k0(r0, r8, r1, this));
        this.map = r1;
        return;
    L5:
        r3 = false;
        goto L6
    }

    private static final Unit lambda$2$lambda$1(int r4, int r5, MutableObjectIntMap r6, NearestRangeKeyIndexMap r7, IntervalList.Interval r8) {
        Function1<Integer, Object> r0 = ((LazyLayoutIntervalContent.Interval) r8.getValue()).getKey();
        int r9 = Math.max(r4, r8.getStartIndex());
        int r10 = Math.min(r5, (r8.getStartIndex() + r8.getSize()) - 1);
        if (r9 > r10) goto L12;
    L4:
        if (r0 == null) goto L7;
        Object r1 = r0.invoke(Integer.valueOf(r9 - r8.getStartIndex()));
        if (r1 == null) goto L7;
    L8:
        r6.set(r1, r9);
        r7.keys[r9 - r7.keysStartIndex] = r1;
        if (r9 == r10) goto L12;
        r9 = r9 + 1;
    L7:
        r1 = Lazy_androidKt.getDefaultLazyLayoutKey(r9);
    L12:
        return Unit.INSTANCE;
    }
}
