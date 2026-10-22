package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0002J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u0003J\u0016\u0010/\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007J\u0016\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u0002022\u0006\u0010\u000f\u001a\u00020\u0003J\u0018\u00103\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0002R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R+\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R+\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u00064"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "", "initialIndices", "", "initialOffsets", "fillIndices", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "targetIndex", "laneCount", "<init>", "([I[ILkotlin/jvm/functions/Function2;)V", "value", "indices", "getIndices", "()[I", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "scrollOffsets", "getScrollOffsets", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "calculateFirstVisibleIndex", "calculateFirstVisibleScrollOffset", "offsets", "hadFirstNotEmptyLayout", "", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "updateFromMeasureResult", "", "measureResult", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "updateScrollOffset", "requestPositionAndForgetLastKnownKey", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "update", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridScrollPosition {
    public static final int $stable = 8;
    private final Function2<Integer, Integer, int[]> fillIndices;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private int[] indices;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;
    private int[] scrollOffsets;

    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    public final int[] getIndices() {
        return this.indices;
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final int[] getScrollOffsets() {
        return this.scrollOffsets;
    }

    private final int calculateFirstVisibleIndex(int[] r7) {
        int r0 = r7.length;
        int r3 = 0;
        int r4 = Integer.MAX_VALUE;
    L3:
        if (r3 >= r0) goto L10;
        int r5 = r7[r3];
        if (r5 <= 0) goto L6;
        if (r4 <= r5) goto L9;
        r4 = r5;
    L9:
        r3 = r3 + 1;
        goto L3
    L6:
        return 0;
    L10:
        if (r4 != Integer.MAX_VALUE) goto L13;
        return 0;
    L13:
        return r4;
    }

    private final void setIndex(int r2) {
        this.index$delegate.setIntValue(r2);
    }

    private final void setScrollOffset(int r2) {
        this.scrollOffset$delegate.setIntValue(r2);
    }

    public final void updateFromMeasureResult(LazyStaggeredGridMeasureResult r10) {
        int r0 = calculateFirstVisibleIndex(r10.getFirstVisibleItemIndices());
        List<LazyStaggeredGridMeasuredItem> r1 = r10.getVisibleItemsInfo();
        int r2 = r1.size();
        int r4 = 0;
    L3:
        Function1 r6 = null;
        if (r4 >= r2) goto L12;
        Object r7 = ListProtector.get(r1, r4);
        if (((LazyStaggeredGridMeasuredItem) r7).getIndex() != r0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == true) goto L13;
        r4 = r4 + 1;
    L13:
        LazyStaggeredGridMeasuredItem r9 = (LazyStaggeredGridMeasuredItem) r7;
        if (r9 == null) goto L16;
        Object r3 = r9.getKey();
    L17:
        this.lastKnownFirstItemKey = r3;
        this.nearestRangeState.update(r0);
        if (this.hadFirstNotEmptyLayout == false) goto L20;
    L21:
        this.hadFirstNotEmptyLayout = true;
        Snapshot.Companion r5 = Snapshot.Companion;
        Snapshot r11 = r5.getCurrentThreadSnapshot();
        if (r11 == null) goto L24;
        r6 = r11.getReadObserver();
    L24:
        Snapshot r12 = r5.makeCurrentNonObservable(r11);
        update(r10.getFirstVisibleItemIndices(), r10.getFirstVisibleItemScrollOffsets());     // Catch: Throwable -> L28
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r5.restoreNonObservable(r11, r12, r6);
        return;
    L28:
        th = move-exception;
        r5.restoreNonObservable(r11, r12, r6);
        throw th;
    L20:
        if (r10.getTotalItemsCount() > 0) goto L21;
        return;
    L16:
        r3 = null;
        goto L17
    L8:
        r8 = false;
        goto L9
    L12:
        r7 = null;
        goto L13
    }

    public final void updateScrollOffset(int[] r2) {
        this.scrollOffsets = r2;
        setScrollOffset(calculateFirstVisibleScrollOffset(this.indices, r2));
    }

    private final int calculateFirstVisibleScrollOffset(int[] r8, int[] r9) {
        int r0 = calculateFirstVisibleIndex(r8);
        int r1 = r9.length;
        int r4 = 0;
        int r5 = Integer.MAX_VALUE;
    L3:
        if (r4 >= r1) goto L8;
        if (r8[r4] != r0) goto L7;
        r5 = Math.min(r5, r9[r4]);
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        if (r5 != Integer.MAX_VALUE) goto L11;
        return 0;
    L11:
        return r5;
    }

    private final void update(int[] r2, int[] r3) {
        this.indices = r2;
        setIndex(calculateFirstVisibleIndex(r2));
        this.scrollOffsets = r3;
        setScrollOffset(calculateFirstVisibleScrollOffset(r2, r3));
    }

    public final void requestPositionAndForgetLastKnownKey(int r5, int r6) {
        int[] r0 = (int[]) this.fillIndices.invoke(Integer.valueOf(r5), Integer.valueOf(this.indices.length));
        int r1 = r0.length;
        int[] r2 = new int[r1];
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r2[r3] = r6;
        r3 = r3 + 1;
        goto L3
    L5:
        update(r0, r2);
        this.nearestRangeState.update(r5);
        this.lastKnownFirstItemKey = null;
    }

    public final int[] updateScrollPositionIfTheFirstItemWasMoved(LazyLayoutItemProvider r6, int[] r7) {
        Object r0 = this.lastKnownFirstItemKey;
        int r1 = 0;
        Integer r2 = ArraysKt.getOrNull(r7, 0);
        if (r2 == null) goto L5;
        r1 = r2.intValue();
    L5:
        int r8 = LazyLayoutItemProviderKt.findIndexByKey(r6, r0, r1);
        if (ArraysKt.contains(r7, r8) == true) goto L17;
        this.nearestRangeState.update(r8);
        Snapshot.Companion r3 = Snapshot.Companion;
        Snapshot r4 = r3.getCurrentThreadSnapshot();
        if (r4 == null) goto L10;
        Function1 r5 = r4.getReadObserver();
    L11:
        Snapshot r9 = r3.makeCurrentNonObservable(r4);
        r7 = (int[]) this.fillIndices.invoke(Integer.valueOf(r8), Integer.valueOf(r7.length));     // Catch: Throwable -> L14
        r3.restoreNonObservable(r4, r9, r5);
        this.indices = r7;
        setIndex(calculateFirstVisibleIndex(r7));
    L14:
        th = move-exception;
        r3.restoreNonObservable(r4, r9, r5);
        throw th;
    L10:
        r5 = null;
    L17:
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyStaggeredGridScrollPosition(int[] r2, int[] r3, Function2<? super Integer, ? super Integer, int[]> r4) {
        this.fillIndices = r4;
        this.indices = r2;
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(calculateFirstVisibleIndex(r2));
        this.scrollOffsets = r3;
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(calculateFirstVisibleScrollOffset(r2, r3));
        Integer r5 = ArraysKt.minOrNull(r2);
        if (r5 == null) goto L5;
        int r6 = r5.intValue();
    L6:
        this.nearestRangeState = new LazyLayoutNearestRangeState(r6, 90, 200);
        return;
    L5:
        r6 = 0;
        goto L6
    }
}
