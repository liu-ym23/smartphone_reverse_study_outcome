package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.ui.unit.IntOffset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"LazyLayoutScrollScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "scrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridScrollScopeKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazyGridScrollScopeKt$LazyLayoutScrollScope$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006¨\u0006\u0017"}, d2 = {"androidx/compose/foundation/lazy/grid/LazyGridScrollScopeKt$LazyLayoutScrollScope$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "Landroidx/compose/foundation/gestures/ScrollScope;", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "lastVisibleItemIndex", "getLastVisibleItemIndex", "itemCount", "getItemCount", "snapToItem", "", "index", "offset", "calculateDistanceTo", "targetIndex", "targetOffset", "scrollBy", "", "pixels", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements LazyLayoutScrollScope, ScrollScope {
        private final /* synthetic */ ScrollScope $$delegate_0;
        final /* synthetic */ LazyGridState $state;

        @Override // androidx.compose.foundation.gestures.ScrollScope
        public float scrollBy(float r2) {
            return this.$$delegate_0.scrollBy(r2);
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
        public int getFirstVisibleItemIndex() {
            return this.$state.getFirstVisibleItemIndex();
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
        public int getFirstVisibleItemScrollOffset() {
            return this.$state.getFirstVisibleItemScrollOffset();
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
        public int getItemCount() {
            return this.$state.getLayoutInfo().getTotalItemsCount();
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
        public int getLastVisibleItemIndex() {
            LazyGridItemInfo r0 = (LazyGridItemInfo) CollectionsKt.lastOrNull(this.$state.getLayoutInfo().getVisibleItemsInfo());
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getIndex();
        }

        public AnonymousClass1(ScrollScope r1, LazyGridState r2) {
            this.$state = r2;
            this.$$delegate_0 = r1;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
        public int calculateDistanceTo(int r10, int r11) {
            LazyGridLayoutInfo r0 = this.$state.getLayoutInfo();
            int r2 = 0;
            if (r0.getVisibleItemsInfo().isEmpty() == false) goto L5;
            return 0;
        L5:
            int r1 = getFirstVisibleItemIndex();
            int r4 = 1;
            if (r10 > getLastVisibleItemIndex()) goto L9;
            if (r1 > r10) goto L9;
            boolean r3 = true;
        L10:
            if (r3 == true) goto L18;
            int r5 = this.$state.getSlotsPerLine$foundation_release();
            int r6 = LazyGridLayoutInfoKt.visibleLinesAverageMainAxisSize(r0);
            if (r10 >= getFirstVisibleItemIndex()) goto L14;
            r2 = 1;
        L14:
            int r12 = r10 - getFirstVisibleItemIndex();
            int r7 = r5 - 1;
            if (r2 == 0) goto L17;
            r4 = -1;
        L17:
            r2 = (r6 * ((r12 + (r7 * r4)) / r5)) - getFirstVisibleItemScrollOffset();
        L38:
            return r2 + r11;
        L18:
            List<LazyGridItemInfo> r8 = r0.getVisibleItemsInfo();
            int r9 = r8.size();
            int r13 = 0;
        L19:
            Integer r14 = null;
            if (r13 >= r9) goto L28;
            Object r15 = ListProtector.get(r8, r13);
            if (((LazyGridItemInfo) r15).getIndex() != r10) goto L24;
            boolean r16 = true;
        L25:
            if (r16 == true) goto L29;
            r13 = r13 + 1;
        L29:
            LazyGridItemInfo r17 = (LazyGridItemInfo) r15;
            if (r0.getOrientation() != Orientation.Vertical) goto L33;
            if (r17 == null) goto L35;
            r14 = Integer.valueOf(IntOffset.getY-impl(r17.mo1117getOffsetnOccac()));
        L35:
            if (r14 == null) goto L38;
            r2 = r14.intValue();
            goto L38
        L33:
            if (r17 == null) goto L35;
            r14 = Integer.valueOf(IntOffset.getX-impl(r17.mo1117getOffsetnOccac()));
            goto L35
        L24:
            r16 = false;
            goto L25
        L28:
            r15 = null;
        L9:
            r3 = false;
            goto L10
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
        public void snapToItem(int r3, int r4) {
            this.$state.snapToItemIndexInternal$foundation_release(r3, r4, true);
        }
    }

    public static final LazyLayoutScrollScope LazyLayoutScrollScope(LazyGridState r1, ScrollScope r2) {
        return new AnonymousClass1(r2, r1);
    }
}
