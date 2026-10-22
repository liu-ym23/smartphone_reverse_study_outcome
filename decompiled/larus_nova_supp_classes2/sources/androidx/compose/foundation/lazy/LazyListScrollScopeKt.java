package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"LazyLayoutScrollScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "scrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyListScrollScopeKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScrollScopeKt$LazyLayoutScrollScope$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0096\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006¨\u0006\u0017"}, d2 = {"androidx/compose/foundation/lazy/LazyListScrollScopeKt$LazyLayoutScrollScope$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollScope;", "Landroidx/compose/foundation/gestures/ScrollScope;", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "lastVisibleItemIndex", "getLastVisibleItemIndex", "itemCount", "getItemCount", "snapToItem", "", "index", "offset", "calculateDistanceTo", "targetIndex", "targetOffset", "scrollBy", "", "pixels", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements LazyLayoutScrollScope, ScrollScope {
        private final /* synthetic */ ScrollScope $$delegate_0;
        final /* synthetic */ LazyListState $state;

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
            LazyListItemInfo r0 = (LazyListItemInfo) CollectionsKt.lastOrNull(this.$state.getLayoutInfo().getVisibleItemsInfo());
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getIndex();
        }

        public AnonymousClass1(ScrollScope r1, LazyListState r2) {
            this.$state = r2;
            this.$$delegate_0 = r1;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
        public int calculateDistanceTo(int r8, int r9) {
            LazyListLayoutInfo r0 = this.$state.getLayoutInfo();
            int r2 = 0;
            if (r0.getVisibleItemsInfo().isEmpty() == false) goto L5;
            return 0;
        L5:
            int r1 = getFirstVisibleItemIndex();
            if (r8 > getLastVisibleItemIndex()) goto L9;
            if (r1 > r8) goto L9;
            boolean r3 = true;
        L10:
            if (r3 == true) goto L12;
            r2 = (LazyListLayoutInfoKt.visibleItemsAverageSize(r0) * (r8 - getFirstVisibleItemIndex())) - getFirstVisibleItemScrollOffset();
        L26:
            return r2 + r9;
        L12:
            List<LazyListItemInfo> r4 = r0.getVisibleItemsInfo();
            int r5 = r4.size();
            int r6 = 0;
        L13:
            if (r6 >= r5) goto L21;
            Object r7 = ListProtector.get(r4, r6);
            if (((LazyListItemInfo) r7).getIndex() != r8) goto L17;
            boolean r10 = true;
        L18:
            if (r10 == true) goto L22;
            r6 = r6 + 1;
        L22:
            LazyListItemInfo r11 = (LazyListItemInfo) r7;
            if (r11 == null) goto L26;
            r2 = r11.getOffset();
            goto L26
        L17:
            r10 = false;
            goto L18
        L21:
            r7 = null;
        L9:
            r3 = false;
            goto L10
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope
        public void snapToItem(int r3, int r4) {
            this.$state.snapToItemIndexInternal$foundation_release(r3, r4, true);
        }
    }

    public static final LazyLayoutScrollScope LazyLayoutScrollScope(LazyListState r1, ScrollScope r2) {
        return new AnonymousClass1(r2, r1);
    }
}
