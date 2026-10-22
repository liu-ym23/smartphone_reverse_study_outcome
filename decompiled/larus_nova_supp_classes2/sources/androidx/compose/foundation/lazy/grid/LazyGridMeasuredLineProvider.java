package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J9\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\u0007H&¢\u0006\u0002\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "", "isVertical", "", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "gridItemsCount", "", "spaceBetweenLines", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "<init>", "(ZLandroidx/compose/foundation/lazy/grid/LazyGridSlots;IILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;)V", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "startSlot", "span", "childConstraints-JhjzzOo$foundation_release", "(II)J", "spanOf", "index", "getAndMeasure", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lineIndex", "keepAround", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "createLine", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "mainAxisSpacing", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Ljava/util/List;I)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class LazyGridMeasuredLineProvider {
    public static final int $stable = 8;
    private final int gridItemsCount;
    private final boolean isVertical;
    private final LazyGridMeasuredItemProvider measuredItemProvider;
    private final LazyGridSlots slots;
    private final int spaceBetweenLines;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public abstract LazyGridMeasuredLine createLine(int r1, LazyGridMeasuredItem[] r2, List<GridItemSpan> r3, int r4);

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.measuredItemProvider.getKeyIndexMap();
    }

    public final LazyGridMeasuredLine getAndMeasure(int r15) {
        LazyGridSpanLayoutProvider.LineConfiguration r0 = this.spanLayoutProvider.getLineConfiguration(r15);
        int r1 = r0.getSpans().size();
        int r2 = 0;
        if (r1 != 0) goto L5;
    L8:
        int r3 = 0;
    L9:
        LazyGridMeasuredItem[] r11 = new LazyGridMeasuredItem[r1];
        int r12 = 0;
    L10:
        if (r2 >= r1) goto L13;
        int r13 = GridItemSpan.m1106getCurrentLineSpanimpl(((GridItemSpan) ListProtector.get(r0.getSpans(), r2)).m1109unboximpl());
        long r6 = m1125childConstraintsJhjzzOo$foundation_release(r12, r13);
        LazyGridMeasuredItem r4 = this.measuredItemProvider.m1124getAndMeasurem8Kt_7k(r0.getFirstItemIndex() + r2, r6, r12, r13, r3);
        r12 = r12 + r13;
        Unit r5 = Unit.INSTANCE;
        r11[r2] = r4;
        r2 = r2 + 1;
        goto L10
    L13:
        return createLine(r15, r11, r0.getSpans(), r3);
    L5:
        if ((r0.getFirstItemIndex() + r1) == this.gridItemsCount) goto L8;
        r3 = this.spaceBetweenLines;
        goto L9
    }

    public final LazyGridMeasuredLine keepAround(int r1) {
        return getAndMeasure(r1);
    }

    public final int spanOf(int r3) {
        LazyGridSpanLayoutProvider r0 = this.spanLayoutProvider;
        return r0.spanOf(r3, r0.getSlotsPerLine());
    }

    /* JADX INFO: renamed from: childConstraints-JhjzzOo$foundation_release, reason: not valid java name */
    public final long m1125childConstraintsJhjzzOo$foundation_release(int r3, int r4) {
        if (r4 != 1) goto L5;
        int r5 = this.slots.getSizes()[r3];
    L6:
        int r6 = RangesKt.coerceAtLeast(r5, 0);
        if (this.isVertical == false) goto L10;
        return Constraints.Companion.fixedWidth-OenEA2s(r6);
    L10:
        return Constraints.Companion.fixedHeight-OenEA2s(r6);
    L5:
        int r7 = (r4 + r3) - 1;
        r5 = (this.slots.getPositions()[r7] + this.slots.getSizes()[r7]) - this.slots.getPositions()[r3];
        goto L6
    }

    public LazyGridMeasuredLineProvider(boolean r1, LazyGridSlots r2, int r3, int r4, LazyGridMeasuredItemProvider r5, LazyGridSpanLayoutProvider r6) {
        this.isVertical = r1;
        this.slots = r2;
        this.gridItemsCount = r3;
        this.spaceBetweenLines = r4;
        this.measuredItemProvider = r5;
        this.spanLayoutProvider = r6;
    }
}
