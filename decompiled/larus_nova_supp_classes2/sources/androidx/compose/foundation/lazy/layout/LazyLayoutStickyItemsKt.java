package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.collection.IntList;
import androidx.compose.ui.unit.IntOffset;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001ax\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\t*\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u000e0\u001bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Debug", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "mainAxisOffset", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "applyStickyItems", "", "T", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "firstVisibleItemIndex", "lastVisibleItemIndex", "positionedItems", "", "stickyItems", "Landroidx/collection/IntList;", "beforeContentPadding", "afterContentPadding", "layoutWidth", "layoutHeight", "getAndMeasure", "Lkotlin/Function1;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutStickyItemsKt {
    private static final boolean Debug = false;

    private static final void debugLog(Function0<String> r0) {
    }

    public static final /* synthetic */ int access$getMainAxisOffset(LazyLayoutMeasuredItem r0) {
        return getMainAxisOffset(r0);
    }

    private static final int getMainAxisOffset(LazyLayoutMeasuredItem r2) {
        long r0 = r2.mo1093getOffsetBjo55l4(0);
        if (r2.isVertical() == false) goto L6;
        return IntOffset.getY-impl(r0);
    L6:
        return IntOffset.getX-impl(r0);
    }

    public static final <T extends LazyLayoutMeasuredItem> List<T> applyStickyItems(StickyItemsPlacement r18, int r19, int r20, List<T> r21, IntList r22, int r23, int r24, int r25, int r26, Function1<? super Integer, ? extends T> r27) {
        if (r18 == null) goto L39;
        if ((!r21.isEmpty()) == false) goto L39;
        if (r22._size == 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L39;
        IntList r2 = r18.getStickingIndices(r19, r20, r22);
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList(r21.size());
        int r3 = r21.size();
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L17;
        Object r5 = ListProtector.get(r21, r4);
        if (r22.contains(((LazyLayoutMeasuredItem) r5).getIndex()) == false) goto L16;
        r14.add(r5);
    L16:
        r4 = r4 + 1;
        goto L12
    L17:
        int[] r15 = r2.content;
        int r8 = r2._size;
        int r7 = 0;
    L18:
        if (r7 >= r8) goto L48;
        int r6 = r15[r7];
        Iterator<T> r0 = r21.iterator();
        int r9 = 0;
    L21:
        if (r0.hasNext() == false) goto L29;
        if (r0.next().getIndex() != r6) goto L25;
        boolean r10 = true;
    L26:
        if (r10 == true) goto L30;
        r9 = r9 + 1;
    L30:
        if (r9 != (-1)) goto L32;
        LazyLayoutMeasuredItem r11 = (LazyLayoutMeasuredItem) r27.invoke(Integer.valueOf(r6));
    L33:
        LazyLayoutMeasuredItem r12 = r11;
        int r16 = r12.getMainAxisSizeWithSpacings();
        if (r9 != (-1)) goto L36;
        int r17 = RtlSpacingHelper.UNDEFINED;
    L37:
        int r28 = r18.calculateStickingItemOffset(r14, r6, r16, r17, r23, r24, r25, r26);
        r12.setNonScrollableItem(true);
        r12.position(r28, 0, r25, r26);
        r13.add(r12);
        r7 = r7 + 1;
        r8 = r8;
        goto L18
    L36:
        r17 = getMainAxisOffset(r12);
        goto L37
    L32:
        r11 = (LazyLayoutMeasuredItem) ListProtector.remove(r21, r9);
        goto L33
    L25:
        r10 = false;
        goto L26
    L29:
        r9 = -1;
        goto L30
    L48:
        return r13;
    L9:
        r1 = false;
    L39:
        return CollectionsKt.emptyList();
    }
}
