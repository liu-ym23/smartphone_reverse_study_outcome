package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutStickyItemsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000e\u001a\u009c\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2/\u0010+\u001a+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-¢\u0006\u0002\b0\u0012\u0004\u0012\u0002010,H\u0000¢\u0006\u0004\b2\u00103\u001a\\\u00104\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b062\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u00107\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\"H\u0002\u001a4\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002\u001a\u008c\u0001\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001b062\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006D"}, d2 = {"measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "beyondBoundsItemCount", "pinnedItems", "", "hasLookaheadOccurred", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-LCrQqZ4", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "createItemsAfterList", "visibleItems", "", "consumedScroll", "lastApproachLayoutInfo", "createItemsBeforeList", "currentFirstItemIndex", "calculateItemsOffsets", "items", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyListMeasureKt {
    public static /* synthetic */ Unit a(Placeable.PlacementScope r0) {
        return measureLazyList_LCrQqZ4$lambda$2(r0);
    }

    public static /* synthetic */ Unit b(List r0, List r1, boolean r2, Placeable.PlacementScope r3) {
        return measureLazyList_LCrQqZ4$lambda$11$lambda$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ LazyListMeasuredItem c(LazyListMeasuredItemProvider r0, int r1) {
        return measureLazyList_LCrQqZ4$lambda$7(r0, r1);
    }

    private static final int calculateItemsOffsets$reverseAware(int r0, boolean r1, int r2) {
        if (r1 == true) goto L5;
        return r0;
    L5:
        return (r2 - r0) - 1;
    }

    public static /* synthetic */ Unit d(MutableState r0, List r1, List r2, boolean r3, Placeable.PlacementScope r4) {
        return measureLazyList_LCrQqZ4$lambda$11(r0, r1, r2, r3, r4);
    }

    private static final Unit measureLazyList_LCrQqZ4$lambda$2(Placeable.PlacementScope r0) {
        return Unit.INSTANCE;
    }

    private static final LazyListMeasuredItem measureLazyList_LCrQqZ4$lambda$7(LazyListMeasuredItemProvider r6, int r7) {
        return LazyListMeasuredItemProvider.m1094getAndMeasure0kLqBqw$default(r6, r7, 0, 2, null);
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int r8, LazyListMeasuredItemProvider r9, int r10, List<Integer> r11) {
        int r12 = Math.max(0, r8 - r10);
        int r13 = r8 - 1;
        ArrayList r0 = null;
        if (r12 > r13) goto L9;
    L4:
        if (r0 != null) goto L6;
        r0 = new ArrayList();
    L6:
        r0.add(LazyListMeasuredItemProvider.m1094getAndMeasure0kLqBqw$default(r9, r13, 0, 2, null));
        if (r13 == r12) goto L9;
        r13 = r13 - 1;
    L9:
        int r14 = r11.size() - 1;
        if (r14 < 0) goto L19;
    L11:
        int r1 = r14 - 1;
        int r3 = ((Number) ListProtector.get(r11, r14)).intValue();
        if (r3 >= r12) goto L16;
        if (r0 != null) goto L15;
        r0 = new ArrayList();
    L15:
        r0.add(LazyListMeasuredItemProvider.m1094getAndMeasure0kLqBqw$default(r9, r3, 0, 2, null));
    L16:
        if (r1 < 0) goto L19;
        r14 = r1;
    L19:
        if (r0 == null) goto L21;
        return r0;
    L21:
        return CollectionsKt.emptyList();
    }

    private static final Unit measureLazyList_LCrQqZ4$lambda$11$lambda$10(List r4, List r5, boolean r6, Placeable.PlacementScope r7) {
        int r0 = r4.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((LazyListMeasuredItem) ListProtector.get(r4, r2)).place(r7, r6);
        r2 = r2 + 1;
        goto L3
    L5:
        int r8 = r5.size();
    L6:
        if (r1 >= r8) goto L9;
        ((LazyListMeasuredItem) ListProtector.get(r5, r1)).place(r7, r6);
        r1 = r1 + 1;
        goto L6
    L9:
        return Unit.INSTANCE;
    }

    private static final Unit measureLazyList_LCrQqZ4$lambda$11(MutableState r1, final List r2, final List r3, final boolean r4, Placeable.PlacementScope r5) {
        r5.withMotionFrameOfReferencePlacement(new o(r2, r3, r4));
        ObservableScopeInvalidator.m1184attachToScopeimpl(r1);
        return Unit.INSTANCE;
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> r21, LazyListMeasuredItemProvider r22, int r23, int r24, List<Integer> r25, float r26, boolean r27, LazyListLayoutInfo r28) {
        int r4 = r23 - 1;
        int r3 = Math.min(((LazyListMeasuredItem) CollectionsKt.last(r21)).getIndex() + r24, r4);
        int r5 = ((LazyListMeasuredItem) CollectionsKt.last(r21)).getIndex() + 1;
        if (r5 > r3) goto L10;
        ArrayList r8 = null;
    L5:
        if (r8 != null) goto L7;
        r8 = new ArrayList();
    L7:
        ArrayList r14 = r8;
        r14.add(LazyListMeasuredItemProvider.m1094getAndMeasure0kLqBqw$default(r22, r5, 0, 2, null));
        if (r5 == r3) goto L11;
        r5 = r5 + 1;
        r8 = r14;
    L11:
        int r6 = 0;
        if (r27 == false) goto L87;
        if (r28 == null) goto L87;
        if ((!r28.getVisibleItemsInfo().isEmpty()) == false) goto L87;
        List<LazyListItemInfo> r9 = r28.getVisibleItemsInfo();
        int r10 = r9.size() - 1;
    L18:
        if ((-1) >= r10) goto L26;
        if (((LazyListItemInfo) ListProtector.get(r9, r10)).getIndex() <= r3) goto L25;
        if (r10 == 0) goto L24;
        if (((LazyListItemInfo) ListProtector.get(r9, r10 - 1)).getIndex() > r3) goto L25;
    L24:
        LazyListItemInfo r11 = (LazyListItemInfo) ListProtector.get(r9, r10);
    L27:
        LazyListItemInfo r12 = (LazyListItemInfo) CollectionsKt.last(r28.getVisibleItemsInfo());
        if (r11 == null) goto L50;
        int r13 = r11.getIndex();
        int r7 = Math.min(r12.getIndex(), r4);
        if (r13 > r7) goto L50;
    L31:
        if (r14 == null) goto L43;
        int r15 = r14.size();
        int r16 = 0;
    L33:
        if (r16 >= r15) goto L41;
        Object r17 = ListProtector.get(r14, r16);
        if (((LazyListMeasuredItem) r17).getIndex() != r13) goto L37;
        boolean r18 = true;
    L38:
        if (r18 == true) goto L42;
        r16 = r16 + 1;
    L42:
        LazyListMeasuredItem r19 = (LazyListMeasuredItem) r17;
    L44:
        if (r19 != null) goto L48;
        if (r14 != null) goto L47;
        r14 = new ArrayList();
    L47:
        r14.add(LazyListMeasuredItemProvider.m1094getAndMeasure0kLqBqw$default(r22, r13, 0, 2, null));
    L48:
        if (r13 == r7) goto L50;
        r13 = r13 + 1;
        goto L31
    L37:
        r18 = false;
        goto L38
    L41:
        r17 = null;
        goto L42
    L43:
        r19 = null;
    L50:
        float r20 = ((r28.getViewportEndOffset() - r12.getOffset()) - r12.getSize()) - r26;
        if (r20 <= MenuKt.ClosedAlphaTarget) goto L87;
        int r29 = r12.getIndex() + 1;
        int r30 = 0;
    L53:
        if (r29 >= r23) goto L87;
        if (r30 >= r20) goto L87;
        if (r29 > r3) goto L68;
        int r110 = r21.size();
        int r111 = 0;
    L58:
        if (r111 >= r110) goto L66;
        Object r112 = ListProtector.get(r21, r111);
        if (((LazyListMeasuredItem) r112).getIndex() != r29) goto L62;
        boolean r113 = true;
    L63:
        if (r113 == true) goto L67;
        r111 = r111 + 1;
    L67:
        LazyListMeasuredItem r114 = (LazyListMeasuredItem) r112;
    L81:
        if (r114 == null) goto L84;
        r29 = r29 + 1;
        int r115 = r114.getMainAxisSizeWithSpacings();
    L83:
        r30 = r30 + r115;
        goto L53
    L84:
        if (r14 != null) goto L86;
        r14 = new ArrayList();
    L86:
        r14.add(LazyListMeasuredItemProvider.m1094getAndMeasure0kLqBqw$default(r22, r29, 0, 2, null));
        r29 = r29 + 1;
        r115 = ((LazyListMeasuredItem) CollectionsKt.last(r14)).getMainAxisSizeWithSpacings();
        goto L83
    L62:
        r113 = false;
        goto L63
    L66:
        r112 = null;
        goto L67
    L68:
        if (r14 == null) goto L80;
        int r116 = r14.size();
        int r117 = 0;
    L70:
        if (r117 >= r116) goto L78;
        Object r118 = ListProtector.get(r14, r117);
        if (((LazyListMeasuredItem) r118).getIndex() != r29) goto L74;
        boolean r119 = true;
    L75:
        if (r119 == true) goto L79;
        r117 = r117 + 1;
    L79:
        r114 = (LazyListMeasuredItem) r118;
        goto L81
    L74:
        r119 = false;
        goto L75
    L78:
        r118 = null;
        goto L79
    L80:
        r114 = null;
    L25:
        r10 = r10 - 1;
        goto L18
    L26:
        r11 = null;
    L87:
        if (r14 != null) goto L89;
    L91:
        int r0 = r25.size();
    L92:
        if (r6 >= r0) goto L99;
        int r31 = ((Number) ListProtector.get(r25, r6)).intValue();
        if (r31 <= r3) goto L98;
        if (r14 != null) goto L97;
        r14 = new ArrayList();
    L97:
        r14.add(LazyListMeasuredItemProvider.m1094getAndMeasure0kLqBqw$default(r22, r31, 0, 2, null));
    L98:
        r6 = r6 + 1;
        goto L92
    L99:
        if (r14 == null) goto L101;
        return r14;
    L101:
        return CollectionsKt.emptyList();
    L89:
        if (((LazyListMeasuredItem) CollectionsKt.last(r14)).getIndex() <= r3) goto L91;
        r3 = ((LazyListMeasuredItem) CollectionsKt.last(r14)).getIndex();
        goto L91
    L10:
        r14 = null;
        goto L11
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> r14, List<LazyListMeasuredItem> r15, List<LazyListMeasuredItem> r16, int r17, int r18, int r19, int r20, int r21, boolean r22, Arrangement.Vertical r23, Arrangement.Horizontal r24, boolean r25, Density r26) {
        if (r22 == false) goto L5;
        int r8 = r18;
    L6:
        boolean r9 = true;
        int r10 = 0;
        if (r19 >= Math.min(r8, r20)) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == false) goto L16;
        if (r21 != 0) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == true) goto L16;
        InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
        goto L16
    L13:
        r11 = false;
    L16:
        ArrayList r12 = new ArrayList((r14.size() + r15.size()) + r16.size());
        if (r7 == true) goto L19;
        int r5 = r15.size();
        int r13 = r21;
        int r6 = 0;
    L56:
        if (r6 >= r5) goto L58;
        LazyListMeasuredItem r27 = (LazyListMeasuredItem) ListProtector.get(r15, r6);
        r13 = r13 - r27.getMainAxisSizeWithSpacings();
        r27.position(r13, r17, r18);
        r12.add(r27);
        r6 = r6 + 1;
        goto L56
    L58:
        int r1 = r14.size();
        int r28 = r21;
        int r29 = 0;
    L59:
        if (r29 >= r1) goto L61;
        LazyListMeasuredItem r30 = (LazyListMeasuredItem) ListProtector.get(r14, r29);
        r30.position(r28, r17, r18);
        r12.add(r30);
        r28 = r28 + r30.getMainAxisSizeWithSpacings();
        r29 = r29 + 1;
        goto L59
    L61:
        int r0 = r16.size();
    L62:
        if (r10 >= r0) goto L64;
        LazyListMeasuredItem r2 = (LazyListMeasuredItem) ListProtector.get(r16, r10);
        r2.position(r28, r17, r18);
        r12.add(r2);
        r28 = r28 + r2.getMainAxisSizeWithSpacings();
        r10 = r10 + 1;
    L64:
        return r12;
    L19:
        if (r15.isEmpty() == true) goto L21;
    L23:
        r9 = false;
    L24:
        if (r9 == true) goto L26;
        InlineClassHelperKt.throwIllegalArgumentException("no extra items");
    L26:
        int r3 = r14.size();
        int[] r4 = new int[r3];
    L27:
        if (r10 >= r3) goto L29;
        r4[r10] = ((LazyListMeasuredItem) ListProtector.get(r14, calculateItemsOffsets$reverseAware(r10, r25, r3))).getSize();
        r10 = r10 + 1;
        goto L27
    L29:
        int[] r31 = new int[r3];
        if (r22 == false) goto L36;
        if (r23 == null) goto L33;
        r23.arrange(r26, r8, r4, r31);
    L38:
        IntProgression r32 = ArraysKt.getIndices(r31);
        if (r25 == false) goto L42;
        r32 = RangesKt.reversed(r32);
    L42:
        int r33 = r32.getFirst();
        int r34 = r32.getLast();
        int r35 = r32.getStep();
        if (r35 <= 0) goto L45;
        if (r33 > r34) goto L45;
    L47:
        int r110 = r31[r33];
        LazyListMeasuredItem r111 = (LazyListMeasuredItem) ListProtector.get(r14, calculateItemsOffsets$reverseAware(r33, r25, r3));
        if (r25 == false) goto L50;
        r110 = (r8 - r110) - r111.getSize();
    L50:
        r111.position(r110, r17, r18);
        r12.add(r111);
        if (r33 == r34) goto L64;
        r33 = r33 + r35;
    L45:
        if (r35 >= 0) goto L64;
        if (r34 > r33) goto L64;
    L33:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
        throw new KotlinNothingValueException();
    L36:
        if (r24 == null) goto L53;
        int r210 = r8;
        r24.arrange(r26, r210, r4, LayoutDirection.Ltr, r31);
        goto L38
    L53:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
        throw new KotlinNothingValueException();
    L21:
        if (r16.isEmpty() == false) goto L23;
    L9:
        r7 = false;
        goto L10
    L5:
        r8 = r17;
        goto L6
    }

    /* JADX INFO: renamed from: measureLazyList-LCrQqZ4, reason: not valid java name */
    public static final LazyListMeasureResult m1088measureLazyListLCrQqZ4(int r37, final LazyListMeasuredItemProvider r38, int r39, int r40, int r41, int r42, int r43, int r44, float r45, long r46, boolean r48, Arrangement.Vertical r49, Arrangement.Horizontal r50, boolean r51, Density r52, LazyLayoutItemAnimator<LazyListMeasuredItem> r53, int r54, List<Integer> r55, boolean r56, boolean r57, LazyListLayoutInfo r58, CoroutineScope r59, final MutableState<Unit> r60, GraphicsContext r61, StickyItemsPlacement r62, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> r63) {
        if (r40 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
    L8:
        if (r41 < 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
    L14:
        if (r37 > 0) goto L26;
        int r15 = Constraints.getMinWidth-impl(r46);
        int r16 = Constraints.getMinHeight-impl(r46);
        r53.onMeasured(0, r15, r16, new ArrayList(), r38.getKeyIndexMap(), r38, r48, r57, 1, r56, 0, 0, r59, r61);
        if (r57 == true) goto L20;
        long r2 = r53.m1152getMinSizeToFitDisappearingItemsYbymL2g();
        if (IntSize.equals-impl0(r2, IntSize.Companion.getZero-YbymL2g()) == true) goto L20;
        r15 = ConstraintsKt.constrainWidth-K40F9xA(r46, (int) (r2 >> 32));
        r16 = ConstraintsKt.constrainHeight-K40F9xA(r46, (int) (r2 & 4294967295L));
    L20:
        MeasureResult r5 = (MeasureResult) r63.invoke(Integer.valueOf(r15), Integer.valueOf(r16), new p());
        List r12 = CollectionsKt.emptyList();
        int r13 = -r40;
        int r14 = r39 + r41;
        if (r48 == false) goto L23;
        Orientation r3 = Orientation.Vertical;
    L25:
        return new LazyListMeasureResult(null, 0, false, MenuKt.ClosedAlphaTarget, r5, MenuKt.ClosedAlphaTarget, false, r59, r52, r38.m1097getChildConstraintsmsEJaDk(), r12, r13, r14, 0, r51, r3, r41, r42, null);
    L23:
        r3 = Orientation.Horizontal;
        goto L25
    L26:
        int r4 = r43;
        if (r4 < r37) goto L29;
        r4 = r37 - 1;
        int r6 = 0;
    L30:
        int r7 = Math.round(r45);
        int r8 = r6 - r7;
        if (r4 != 0) goto L34;
        if (r8 >= 0) goto L34;
        int r9 = r7 + r8;
        r8 = 0;
    L35:
        ArrayDeque r10 = new ArrayDeque();
        int r11 = -r40;
        if (r42 >= 0) goto L38;
        int r17 = r42;
    L39:
        int r18 = r11 + r17;
        int r19 = r8 + r18;
        int r20 = 0;
    L40:
        if (r19 >= 0) goto L43;
        if (r4 <= 0) goto L43;
        int r21 = r4 - 1;
        LazyListMeasuredItem r22 = LazyListMeasuredItemProvider.m1094getAndMeasure0kLqBqw$default(r38, r21, 0, 2, null);
        r10.add(0, r22);
        r20 = Math.max(r20, r22.getCrossAxisSize());
        r19 = r19 + r22.getMainAxisSizeWithSpacings();
        r4 = r21;
        r11 = r11;
        r18 = r18;
    L43:
        int r23 = r19;
        int r24 = r20;
        int r25 = r11;
        int r26 = r18;
        if (r23 >= r26) goto L46;
        r9 = r9 - (r26 - r23);
        int r27 = r26;
    L47:
        int r28 = r27 - r26;
        int r29 = r39 + r41;
        int r30 = RangesKt.coerceAtLeast(r29, 0);
        int r31 = -r28;
        int r47 = r4;
        int r210 = r47;
        int r32 = 0;
        boolean r211 = false;
    L49:
        if (r32 >= r10.size()) goto L53;
        if (r31 >= r30) goto L51;
        r210 = r210 + 1;
        r31 = r31 + ((LazyListMeasuredItem) r10.get(r32)).getMainAxisSizeWithSpacings();
        r32 = r32 + 1;
        goto L49
    L51:
        r10.remove(r32);
        Unit r33 = Unit.INSTANCE;
        r211 = true;
        goto L49
    L53:
        int r34 = r31;
        int r35 = r210;
        int r36 = r47;
        int r212 = r28;
        int r64 = r24;
    L54:
        if (r35 >= r37) goto L67;
        if (r34 < r30) goto L59;
        if (r34 <= 0) goto L59;
        if (r10.isEmpty() == false) goto L67;
    L59:
        int r410 = r35;
        int r213 = r30;
        int r310 = r29;
        int r311 = r64;
        int r411 = r36;
        int r65 = r26;
        LazyListMeasuredItem r66 = LazyListMeasuredItemProvider.m1094getAndMeasure0kLqBqw$default(r38, r410, 0, 2, null);
        r34 = r34 + r66.getMainAxisSizeWithSpacings();
        if (r34 > r65) goto L64;
        int r67 = r410;
        if (r67 == (r37 - 1)) goto L65;
        int r68 = r67 + 1;
        r212 = r212 - r66.getMainAxisSizeWithSpacings();
        Unit r69 = Unit.INSTANCE;
        r64 = r311;
        r211 = true;
    L66:
        r35 = r67 + 1;
        r26 = r65;
        r29 = r310;
        r36 = r68;
        r30 = r213;
    L65:
        int r70 = Math.max(r311, r66.getCrossAxisSize());
        r10.add(r66);
        r64 = r70;
        r68 = r411;
        goto L66
    L64:
        r67 = r410;
    L67:
        int r71 = r35;
        int r312 = r29;
        int r72 = r64;
        int r412 = r36;
        if (r34 >= r39) goto L77;
        int r73 = r39 - r34;
        int r214 = r34 + r73;
        int r74 = r412;
        int r75 = r72;
        int r76 = r212 - r73;
    L70:
        if (r76 >= r40) goto L73;
        if (r74 <= 0) goto L73;
        int r215 = r74 - 1;
        LazyListMeasuredItem r77 = LazyListMeasuredItemProvider.m1094getAndMeasure0kLqBqw$default(r38, r215, 0, 2, null);
        r10.add(0, r77);
        r75 = Math.max(r75, r77.getCrossAxisSize());
        r76 = r76 + r77.getMainAxisSizeWithSpacings();
        r74 = r215;
        r71 = r71;
    L73:
        int r216 = r76;
        int r78 = r75;
        int r313 = r71;
        int r79 = r73 + r9;
        if (r216 >= 0) goto L76;
        int r80 = r74;
        int r81 = r78;
        int r82 = r79 + r216;
        int r83 = r214 + r216;
        int r84 = 0;
    L79:
        if (MathKt.getSign(Math.round(r45)) == MathKt.getSign(r82)) goto L81;
    L83:
        float r85 = r45;
    L84:
        float r86 = r45 - r85;
        float r217 = MenuKt.ClosedAlphaTarget;
        if (r57 == false) goto L90;
        if (r82 <= r9) goto L90;
        if (r86 > MenuKt.ClosedAlphaTarget) goto L90;
        r217 = (r82 - r9) + r86;
    L90:
        if (r84 < 0) goto L92;
        boolean r87 = true;
    L93:
        if (r87 == true) goto L95;
        InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
    L95:
        int r88 = -r84;
        LazyListMeasuredItem r89 = (LazyListMeasuredItem) r10.first();
        if (r40 > 0) goto L100;
        if (r42 < 0) goto L100;
        int r218 = r84;
        int r219 = r81;
        LazyListMeasuredItem r90 = r89;
    L110:
        List<LazyListMeasuredItem> r91 = createItemsBeforeList(r80, r38, r54, r55);
        int r92 = r91.size();
        int r93 = r219;
        int r94 = 0;
    L111:
        if (r94 >= r92) goto L113;
        r93 = Math.max(r93, ((LazyListMeasuredItem) ListProtector.get(r91, r94)).getCrossAxisSize());
        r94 = r94 + 1;
        r92 = r92;
        goto L111
    L113:
        LazyListMeasuredItem r110 = r90;
        float r413 = r85;
        int r414 = r83;
        List<LazyListMeasuredItem> r95 = createItemsAfterList(r10, r38, r37, r54, r55, r85, r57, r58);
        int r96 = r95.size();
        int r97 = 0;
    L114:
        if (r97 >= r96) goto L117;
        r93 = Math.max(r93, ((LazyListMeasuredItem) ListProtector.get(r95, r97)).getCrossAxisSize());
        r97 = r97 + 1;
        goto L114
    L117:
        if (Intrinsics.areEqual(r110, r10.first()) == true) goto L119;
    L123:
        boolean r220 = false;
    L124:
        if (r48 == false) goto L126;
        int r98 = r93;
    L127:
        int r99 = ConstraintsKt.constrainWidth-K40F9xA(r46, r98);
        if (r48 == false) goto L130;
        r93 = r414;
    L130:
        int r100 = ConstraintsKt.constrainHeight-K40F9xA(r46, r93);
        List<LazyListMeasuredItem> r111 = calculateItemsOffsets(r10, r91, r95, r99, r100, r414, r39, r88, r48, r49, r50, r51, r52);
        r53.onMeasured((int) r413, r99, r100, r111, r38.getKeyIndexMap(), r38, r48, r57, 1, r56, r218, r414, r59, r61);
        if (r57 == true) goto L147;
        long r101 = r53.m1152getMinSizeToFitDisappearingItemsYbymL2g();
        if (IntSize.equals-impl0(r101, IntSize.Companion.getZero-YbymL2g()) == true) goto L147;
        if (r48 == false) goto L136;
        int r102 = r100;
    L137:
        int r103 = ConstraintsKt.constrainWidth-K40F9xA(r46, Math.max(r99, (int) (r101 >> 32)));
        int r104 = ConstraintsKt.constrainHeight-K40F9xA(r46, Math.max(r100, (int) (r101 & 4294967295L)));
        if (r48 == false) goto L140;
        int r105 = r104;
    L141:
        final List<LazyListMeasuredItem> r112 = r111;
        if (r105 == r102) goto L146;
        int r106 = r112.size();
        int r107 = 0;
    L144:
        if (r107 >= r106) goto L146;
        ((LazyListMeasuredItem) ListProtector.get(r112, r107)).updateMainAxisLayoutSize(r105);
        r107 = r107 + 1;
    L146:
        int r113 = r103;
        int r114 = r104;
    L148:
        LazyListMeasuredItem r108 = (LazyListMeasuredItem) r10.firstOrNull();
        if (r108 == null) goto L151;
        int r109 = r108.getIndex();
    L152:
        LazyListMeasuredItem r115 = (LazyListMeasuredItem) r10.lastOrNull();
        if (r115 == null) goto L155;
        int r116 = r115.getIndex();
    L156:
        final List r117 = LazyLayoutStickyItemsKt.applyStickyItems(r62, r109, r116, r112, r38.getHeaderIndexes(), r40, r41, r113, r114, new q(r38));
        Integer r118 = null;
        if (r220 == false) goto L161;
        LazyListMeasuredItem r119 = (LazyListMeasuredItem) CollectionsKt.firstOrNull(r112);
        if (r119 == null) goto L164;
        Integer r120 = Integer.valueOf(r119.getIndex());
    L165:
        if (r220 == false) goto L169;
        LazyListMeasuredItem r121 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(r112);
        if (r121 == null) goto L173;
        r118 = Integer.valueOf(r121.getIndex());
    L173:
        if (r313 < r37) goto L178;
        final boolean r122 = r57;
        if (r414 > r39) goto L179;
        boolean r123 = false;
    L180:
        MeasureResult r124 = (MeasureResult) r63.invoke(Integer.valueOf(r113), Integer.valueOf(r114), new r(r60, r112, r117, r122));
        if (r120 == null) goto L183;
        int r125 = r120.intValue();
    L184:
        if (r118 == null) goto L186;
        int r126 = r118.intValue();
    L187:
        List r127 = LazyLayoutMeasuredItemKt.updatedVisibleItems(r125, r126, r112, r117);
        if (r48 == false) goto L190;
        Orientation r128 = Orientation.Vertical;
    L192:
        return new LazyListMeasureResult(r110, r218, r123, r413, r124, r217, r211, r59, r52, r38.m1097getChildConstraintsmsEJaDk(), r127, r25, r312, r37, r51, r128, r41, r42, null);
    L190:
        r128 = Orientation.Horizontal;
        goto L192
    L186:
        r126 = 0;
        goto L187
    L183:
        r125 = 0;
    L179:
        r123 = true;
        goto L180
    L178:
        r122 = r57;
        goto L179
    L169:
        LazyListMeasuredItem r129 = (LazyListMeasuredItem) r10.lastOrNull();
        if (r129 == null) goto L173;
        r118 = Integer.valueOf(r129.getIndex());
    L164:
        r120 = null;
        goto L165
    L161:
        LazyListMeasuredItem r130 = (LazyListMeasuredItem) r10.firstOrNull();
        if (r130 == null) goto L164;
        r120 = Integer.valueOf(r130.getIndex());
        goto L165
    L155:
        r116 = 0;
        goto L156
    L151:
        r109 = 0;
        goto L152
    L140:
        r105 = r103;
        goto L141
    L136:
        r102 = r99;
    L147:
        r112 = r111;
        r114 = r100;
        r113 = r99;
        goto L148
    L126:
        r98 = r414;
        goto L127
    L119:
        if (r91.isEmpty() == false) goto L123;
        if (r95.isEmpty() == false) goto L123;
        r220 = true;
    L100:
        int r131 = r10.size();
        LazyListMeasuredItem r415 = r89;
        int r132 = 0;
    L101:
        if (r132 >= r131) goto L108;
        int r416 = r131;
        int r133 = ((LazyListMeasuredItem) r10.get(r132)).getMainAxisSizeWithSpacings();
        if (r84 == 0) goto L108;
        if (r133 > r84) goto L108;
        r219 = r81;
        if (r132 == CollectionsKt.getLastIndex(r10)) goto L109;
        r84 = r84 - r133;
        r132 = r132 + 1;
        r415 = (LazyListMeasuredItem) r10.get(r132);
        r81 = r219;
        r131 = r416;
    L109:
        r90 = r415;
        r218 = r84;
    L108:
        r219 = r81;
        goto L109
    L92:
        r87 = false;
        goto L93
    L81:
        if (Math.abs(Math.round(r45)) < Math.abs(r82)) goto L83;
        r85 = r82;
        goto L84
    L76:
        r80 = r74;
        r81 = r78;
        r82 = r79;
        r83 = r214;
        r84 = r216;
        goto L79
    L77:
        r313 = r71;
        r80 = r412;
        r83 = r34;
        r81 = r72;
        r82 = r9;
        r84 = r212;
        goto L79
    L46:
        r27 = r23;
        goto L47
    L38:
        r17 = 0;
    L34:
        r9 = r7;
        goto L35
    L29:
        r6 = r44;
        goto L30
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }
}
