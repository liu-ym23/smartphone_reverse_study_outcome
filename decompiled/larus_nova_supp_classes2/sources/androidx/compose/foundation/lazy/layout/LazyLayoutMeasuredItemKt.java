package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.unit.IntOffset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\"\u0018\u0010\t\u001a\u00020\u0005*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"updatedVisibleItems", "", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "firstVisibleIndex", "", "lastVisibleIndex", "positionedItems", "stickingItems", "mainAxisOffset", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "LazyLayoutMeasuredItemIndexComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutMeasuredItemKt {
    private static final Comparator<LazyLayoutMeasuredItem> LazyLayoutMeasuredItemIndexComparator = null;

    public static /* synthetic */ int a(LazyLayoutMeasuredItem r0, LazyLayoutMeasuredItem r1) {
        return LazyLayoutMeasuredItemIndexComparator$lambda$2(r0, r1);
    }

    static {
        LazyLayoutMeasuredItemIndexComparator = new t();
    }

    private static final int getMainAxisOffset(LazyLayoutMeasuredItem r2) {
        long r0 = r2.mo1093getOffsetBjo55l4(0);
        if (r2.isVertical() == false) goto L6;
        return IntOffset.getY-impl(r0);
    L6:
        return IntOffset.getX-impl(r0);
    }

    private static final int LazyLayoutMeasuredItemIndexComparator$lambda$2(LazyLayoutMeasuredItem r0, LazyLayoutMeasuredItem r1) {
        return Intrinsics.compare(r0.getIndex(), r1.getIndex());
    }

    public static final <T extends LazyLayoutMeasuredItem> List<T> updatedVisibleItems(int r5, int r6, List<? extends T> r7, List<? extends T> r8) {
        if (r7.isEmpty() == true) goto L5;
        Stack r9 = (List<T>) CollectionsKt.toMutableList(r8);
        int r0 = r7.size();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L16;
        LazyLayoutMeasuredItem r3 = (LazyLayoutMeasuredItem) ListProtector.get(r7, r2);
        int r4 = r3.getIndex();
        if (r5 > r4) goto L12;
        if (r4 > r6) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == false) goto L15;
        r9.add(r3);
    L15:
        r2 = r2 + 1;
    L12:
        r10 = false;
        goto L13
    L16:
        CollectionsKt.sortWith(r9, LazyLayoutMeasuredItemIndexComparator);
        return r9;
    L5:
        return CollectionsKt.emptyList();
    }
}
