package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0003\b\t\nJ\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells;", "", "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "Fixed", "Adaptive", "FixedSize", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface GridCells {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$Adaptive;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "minSize", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "hashCode", "equals", "", "other", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Adaptive implements GridCells {
        public static final int $stable = 0;
        private final float minSize;

        public /* synthetic */ Adaptive(float r1, DefaultConstructorMarker r2) {
            this(r1);
        }

        public int hashCode() {
            return Dp.hashCode-impl(this.minSize);
        }

        private Adaptive(float r3) {
            this.minSize = r3;
            boolean r0 = false;
            if (Dp.compareTo-0680j_4(r3, Dp.constructor-impl(0)) <= 0) goto L5;
            r0 = true;
        L5:
            if (r0 == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("Provided min size should be larger than zero.");
            return;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof Adaptive) == true) goto L5;
        L7:
            return false;
        L5:
            if (Dp.equals-impl0(this.minSize, ((Adaptive) r2).minSize) == false) goto L7;
            return true;
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List<Integer> calculateCrossAxisCellSizes(Density r3, int r4, int r5) {
            return LazyGridDslKt.access$calculateCellsCrossAxisSizeImpl(r4, Math.max((r4 + r5) / (r3.roundToPx-0680j_4(this.minSize) + r5), 1), r5);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$Fixed;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "count", "", "<init>", "(I)V", "calculateCrossAxisCellSizes", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "hashCode", "equals", "", "other", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Fixed implements GridCells {
        public static final int $stable = 0;
        private final int count;

        public int hashCode() {
            return -this.count;
        }

        public Fixed(int r1) {
            this.count = r1;
            if (r1 <= 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == true) goto L9;
            InlineClassHelperKt.throwIllegalArgumentException("Provided count should be larger than zero");
            return;
        L9:
            return;
        L5:
            r2 = false;
            goto L6
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof Fixed) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.count != ((Fixed) r2).count) goto L7;
            return true;
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List<Integer> calculateCrossAxisCellSizes(Density r1, int r2, int r3) {
            return LazyGridDslKt.access$calculateCellsCrossAxisSizeImpl(r2, this.count, r3);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002R\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/lazy/grid/GridCells$FixedSize;", "Landroidx/compose/foundation/lazy/grid/GridCells;", "size", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "calculateCrossAxisCellSizes", "", "", "Landroidx/compose/ui/unit/Density;", "availableSize", "spacing", "hashCode", "equals", "", "other", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class FixedSize implements GridCells {
        public static final int $stable = 0;
        private final float size;

        public /* synthetic */ FixedSize(float r1, DefaultConstructorMarker r2) {
            this(r1);
        }

        public int hashCode() {
            return Dp.hashCode-impl(this.size);
        }

        private FixedSize(float r3) {
            this.size = r3;
            boolean r0 = false;
            if (Dp.compareTo-0680j_4(r3, Dp.constructor-impl(0)) <= 0) goto L5;
            r0 = true;
        L5:
            if (r0 == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("Provided size should be larger than zero.");
            return;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof FixedSize) == true) goto L5;
        L7:
            return false;
        L5:
            if (Dp.equals-impl0(this.size, ((FixedSize) r2).size) == false) goto L7;
            return true;
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List<Integer> calculateCrossAxisCellSizes(Density r3, int r4, int r5) {
            int r6 = r3.roundToPx-0680j_4(this.size);
            int r0 = r6 + r5;
            int r7 = r5 + r4;
            if (r0 >= r7) goto L7;
            int r8 = r7 / r0;
            ArrayList r9 = new ArrayList(r8);
            int r1 = 0;
        L5:
            if (r1 >= r8) goto L10;
            r9.add(Integer.valueOf(r6));
            r1 = r1 + 1;
            goto L5
        L10:
            return r9;
        L7:
            ArrayList r10 = new ArrayList(1);
            r10.add(Integer.valueOf(r4));
            return r10;
        }
    }

    List<Integer> calculateCrossAxisCellSizes(Density r1, int r2, int r3);
}
