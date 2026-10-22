package androidx.compose.foundation.lazy.grid;

import androidx.autofill.HintConstants;
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
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¸\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aü\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*23\u0010+\u001a/\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011000 0,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00030,2\b\u00103\u001a\u0004\u0018\u0001042/\u00105\u001a+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080,¢\u0006\u0002\b9\u0012\u0004\u0012\u00020:06H\u0000¢\u0006\u0004\b;\u0010<\u001aA\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130,H\u0082\b\u001aF\u0010?\u001a\b\u0012\u0004\u0012\u00020@0 2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00132\f\u0010B\u001a\b\u0012\u0004\u0012\u00020@0 2\b\u0010C\u001a\u0004\u0018\u00010$H\u0002\u001a\u008c\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001d0E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020@0 2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a+\u0010N\u001a\u000208\"\u0004\b\u0000\u0010O*\b\u0012\u0004\u0012\u0002HO0E2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HO0QH\u0002¢\u0006\u0002\u0010R¨\u0006S"}, d2 = {"measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "slotsPerLine", "pinnedItems", "", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "line", "Lkotlin/Pair;", "lineIndexProvider", "itemIndex", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-t1x4au0", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "calculateExtraItems", "filter", "linesRetainedForLookahead", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lastVisibleItemIndex", "visibleLines", "lastApproachLayoutInfo", "calculateItemsOffsets", "", "lines", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "addAllFromArray", "T", "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridMeasureKt {
    public static /* synthetic */ LazyGridMeasuredItem a(LazyGridMeasuredLineProvider r0, LazyGridMeasuredItemProvider r1, int r2) {
        return measureLazyGrid_t1x4au0$lambda$9(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(MutableState r0, List r1, List r2, boolean r3, Placeable.PlacementScope r4) {
        return measureLazyGrid_t1x4au0$lambda$13(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit c(List r0, List r1, boolean r2, Placeable.PlacementScope r3) {
        return measureLazyGrid_t1x4au0$lambda$13$lambda$12(r0, r1, r2, r3);
    }

    private static final int calculateItemsOffsets$reverseAware(int r0, boolean r1, int r2) {
        if (r1 == true) goto L5;
        return r0;
    L5:
        return (r2 - r0) - 1;
    }

    public static /* synthetic */ Unit d(Placeable.PlacementScope r0) {
        return measureLazyGrid_t1x4au0$lambda$2(r0);
    }

    private static final Unit measureLazyGrid_t1x4au0$lambda$2(Placeable.PlacementScope r0) {
        return Unit.INSTANCE;
    }

    private static final <T> void addAllFromArray(List<T> r3, T[] r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3.add(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }

    private static final LazyGridMeasuredItem measureLazyGrid_t1x4au0$lambda$9(LazyGridMeasuredLineProvider r6, LazyGridMeasuredItemProvider r7, int r8) {
        int r3 = r6.spanOf(r8);
        return r7.mo1095getAndMeasurehBUhpc(r8, 0, r3, r6.m1125childConstraintsJhjzzOo$foundation_release(0, r3));
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> r11, LazyGridMeasuredItemProvider r12, LazyGridMeasuredLineProvider r13, Function1<? super Integer, Boolean> r14) {
        int r0 = r11.size();
        ArrayList r1 = null;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L11;
        int r6 = ((Number) ListProtector.get(r11, r3)).intValue();
        if (((Boolean) r14.invoke(Integer.valueOf(r6))).booleanValue() == false) goto L10;
        int r8 = r13.spanOf(r6);
        LazyGridMeasuredItem r4 = r12.mo1095getAndMeasurehBUhpc(r6, 0, r8, r13.m1125childConstraintsJhjzzOo$foundation_release(0, r8));
        if (r1 != null) goto L9;
        r1 = new ArrayList();
    L9:
        r1.add(r4);
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        if (r1 == null) goto L13;
        return r1;
    L13:
        return CollectionsKt.emptyList();
    }

    private static final Unit measureLazyGrid_t1x4au0$lambda$13$lambda$12(List r4, List r5, boolean r6, Placeable.PlacementScope r7) {
        int r0 = r4.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((LazyGridMeasuredItem) ListProtector.get(r4, r2)).place(r7, r6);
        r2 = r2 + 1;
        goto L3
    L5:
        int r8 = r5.size();
    L6:
        if (r1 >= r8) goto L9;
        ((LazyGridMeasuredItem) ListProtector.get(r5, r1)).place(r7, r6);
        r1 = r1 + 1;
        goto L6
    L9:
        return Unit.INSTANCE;
    }

    private static final Unit measureLazyGrid_t1x4au0$lambda$13(MutableState r1, final List r2, final List r3, final boolean r4, Placeable.PlacementScope r5) {
        r5.withMotionFrameOfReferencePlacement(new t(r2, r3, r4));
        ObservableScopeInvalidator.m1184attachToScopeimpl(r1);
        return Unit.INSTANCE;
    }

    private static final List<LazyGridMeasuredLine> linesRetainedForLookahead(int r7, int r8, LazyGridMeasuredLineProvider r9, boolean r10, List<LazyGridMeasuredLine> r11, LazyGridLayoutInfo r12) {
        ArrayList r0 = null;
        if (r10 == false) goto L51;
        if (r12 == null) goto L51;
        if ((!r12.getVisibleItemsInfo().isEmpty()) == false) goto L51;
        List<LazyGridItemInfo> r13 = r12.getVisibleItemsInfo();
        int r2 = r13.size() - 1;
    L9:
        if ((-1) >= r2) goto L17;
        if (((LazyGridItemInfo) ListProtector.get(r13, r2)).getIndex() <= r7) goto L16;
        if (r2 == 0) goto L15;
        if (((LazyGridItemInfo) ListProtector.get(r13, r2 - 1)).getIndex() > r7) goto L16;
    L15:
        LazyGridItemInfo r14 = (LazyGridItemInfo) ListProtector.get(r13, r2);
    L18:
        LazyGridItemInfo r15 = (LazyGridItemInfo) CollectionsKt.last(r12.getVisibleItemsInfo());
        LazyGridMeasuredLine r16 = (LazyGridMeasuredLine) CollectionsKt.lastOrNull(r11);
        if (r16 == null) goto L21;
        int r17 = r16.getIndex() + 1;
    L22:
        if (r14 == null) goto L51;
        int r18 = r14.getIndex();
        int r19 = Math.min(r15.getIndex(), r8 - 1);
        if (r18 > r19) goto L51;
    L25:
        if (r0 == null) goto L44;
        int r110 = r0.size();
        int r3 = 0;
    L27:
        if (r3 >= r110) goto L41;
        LazyGridMeasuredItem[] r4 = ((LazyGridMeasuredLine) ListProtector.get(r0, r3)).getItems();
        int r5 = r4.length;
        int r6 = 0;
    L29:
        if (r6 >= r5) goto L37;
        if (r4[r6].getIndex() != r18) goto L33;
        boolean r20 = true;
    L34:
        if (r20 == true) goto L35;
        r6 = r6 + 1;
        goto L29
    L35:
        boolean r21 = true;
    L38:
        if (r21 == true) goto L39;
        r3 = r3 + 1;
        goto L27
    L39:
        boolean r111 = true;
    L42:
        if (r111 != true) goto L44;
        boolean r112 = true;
    L45:
        if (r112 == true) goto L49;
        if (r0 != null) goto L48;
        r0 = new ArrayList();
    L48:
        LazyGridMeasuredLine r113 = r9.getAndMeasure(r17);
        r17 = r17 + 1;
        r0.add(r113);
    L49:
        if (r18 == r19) goto L51;
        r18 = r18 + 1;
        goto L25
    L33:
        r20 = false;
        goto L34
    L37:
        r21 = false;
        goto L38
    L41:
        r111 = false;
    L44:
        r112 = false;
        goto L45
    L21:
        r17 = 0;
    L16:
        r2 = r2 - 1;
        goto L9
    L17:
        r14 = null;
    L51:
        if (r0 == null) goto L53;
        return r0;
    L53:
        return CollectionsKt.emptyList();
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> r16, List<LazyGridMeasuredItem> r17, List<LazyGridMeasuredItem> r18, int r19, int r20, int r21, int r22, int r23, boolean r24, Arrangement.Vertical r25, Arrangement.Horizontal r26, boolean r27, Density r28) {
        if (r24 == false) goto L5;
        int r8 = r20;
    L6:
        boolean r9 = true;
        int r10 = 0;
        if (r21 >= Math.min(r8, r22)) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == false) goto L16;
        if (r23 != 0) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == true) goto L16;
        InlineClassHelperKt.throwIllegalStateException("non-zero firstLineScrollOffset");
        goto L16
    L13:
        r11 = false;
    L16:
        List<LazyGridMeasuredLine> r12 = r16;
        int r13 = r12.size();
        int r14 = 0;
        int r15 = 0;
    L17:
        if (r14 >= r13) goto L19;
        r15 = r15 + ((LazyGridMeasuredLine) ListProtector.get(r16, r14)).getItems().length;
        r14 = r14 + 1;
        goto L17
    L19:
        ArrayList r110 = new ArrayList(r15);
        if (r7 == true) goto L22;
        int r5 = r17.size() - 1;
        if (r5 < 0) goto L64;
        int r6 = r23;
    L60:
        int r29 = r5 - 1;
        LazyGridMeasuredItem r30 = (LazyGridMeasuredItem) ListProtector.get(r17, r5);
        r6 = r6 - r30.getMainAxisSizeWithSpacings();
        r30.position(r6, 0, r19, r20);
        r110.add(r30);
        if (r29 < 0) goto L64;
        r5 = r29;
    L64:
        int r1 = r12.size();
        int r31 = r23;
        int r32 = 0;
    L65:
        if (r32 >= r1) goto L67;
        LazyGridMeasuredLine r33 = (LazyGridMeasuredLine) ListProtector.get(r16, r32);
        addAllFromArray(r110, r33.position(r31, r19, r20));
        r31 = r31 + r33.getMainAxisSizeWithSpacings();
        r32 = r32 + 1;
        goto L65
    L67:
        int r0 = r18.size();
        int r2 = 0;
    L68:
        if (r2 >= r0) goto L70;
        LazyGridMeasuredItem r34 = (LazyGridMeasuredItem) ListProtector.get(r18, r2);
        r34.position(r31, 0, r19, r20);
        r110.add(r34);
        r31 = r31 + r34.getMainAxisSizeWithSpacings();
        r2 = r2 + 1;
    L70:
        return r110;
    L22:
        if (r17.isEmpty() == true) goto L24;
    L26:
        r9 = false;
    L27:
        if (r9 == true) goto L29;
        InlineClassHelperKt.throwIllegalArgumentException("no items");
    L29:
        int r3 = r16.size();
        int[] r4 = new int[r3];
    L30:
        if (r10 >= r3) goto L32;
        r4[r10] = ((LazyGridMeasuredLine) ListProtector.get(r16, calculateItemsOffsets$reverseAware(r10, r27, r3))).getMainAxisSize();
        r10 = r10 + 1;
        goto L30
    L32:
        int[] r35 = new int[r3];
        if (r24 == false) goto L39;
        if (r25 == null) goto L36;
        r25.arrange(r28, r8, r4, r35);
    L41:
        IntProgression r36 = ArraysKt.getIndices(r35);
        if (r27 == false) goto L44;
        r36 = RangesKt.reversed(r36);
    L44:
        int r37 = r36.getFirst();
        int r38 = r36.getLast();
        int r39 = r36.getStep();
        if (r39 <= 0) goto L47;
        if (r37 > r38) goto L47;
    L49:
        int r111 = r35[r37];
        LazyGridMeasuredLine r112 = (LazyGridMeasuredLine) ListProtector.get(r16, calculateItemsOffsets$reverseAware(r37, r27, r3));
        if (r27 == false) goto L52;
        r111 = (r8 - r111) - r112.getMainAxisSize();
    L52:
        addAllFromArray(r110, r112.position(r111, r19, r20));
        if (r37 == r38) goto L70;
        r37 = r37 + r39;
    L47:
        if (r39 >= 0) goto L70;
        if (r38 > r37) goto L70;
    L36:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement");
        throw new KotlinNothingValueException();
    L39:
        if (r26 == null) goto L55;
        r26.arrange(r28, r8, r4, LayoutDirection.Ltr, r35);
        goto L41
    L55:
        InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement");
        throw new KotlinNothingValueException();
    L24:
        if (r18.isEmpty() == false) goto L26;
    L9:
        r7 = false;
        goto L10
    L5:
        r8 = r19;
        goto L6
    }

    /* JADX INFO: renamed from: measureLazyGrid-t1x4au0, reason: not valid java name */
    public static final LazyGridMeasureResult m1121measureLazyGridt1x4au0(int r40, final LazyGridMeasuredLineProvider r41, final LazyGridMeasuredItemProvider r42, int r43, int r44, int r45, int r46, int r47, int r48, float r49, long r50, boolean r52, Arrangement.Vertical r53, Arrangement.Horizontal r54, boolean r55, Density r56, LazyLayoutItemAnimator<LazyGridMeasuredItem> r57, int r58, List<Integer> r59, boolean r60, boolean r61, LazyGridLayoutInfo r62, CoroutineScope r63, final MutableState<Unit> r64, GraphicsContext r65, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> r66, Function1<? super Integer, Integer> r67, StickyItemsPlacement r68, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> r69) {
        int r15 = r40;
        List<Integer> r11 = r59;
        if (r44 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
    L8:
        if (r45 < 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
    L14:
        if (r15 > 0) goto L26;
        int r2 = Constraints.getMinWidth-impl(r50);
        int r3 = Constraints.getMinHeight-impl(r50);
        r57.onMeasured(0, r2, r3, new ArrayList(), r42.getKeyIndexMap(), r42, r52, r61, r58, r60, 0, 0, r63, r65);
        if (r61 == true) goto L20;
        long r4 = r57.m1152getMinSizeToFitDisappearingItemsYbymL2g();
        if (IntSize.equals-impl0(r4, IntSize.Companion.getZero-YbymL2g()) == true) goto L20;
        r2 = ConstraintsKt.constrainWidth-K40F9xA(r50, (int) (r4 >> 32));
        r3 = ConstraintsKt.constrainHeight-K40F9xA(r50, (int) (r4 & 4294967295L));
    L20:
        MeasureResult r5 = (MeasureResult) r69.invoke(Integer.valueOf(r2), Integer.valueOf(r3), new u());
        List r13 = CollectionsKt.emptyList();
        int r14 = -r44;
        int r16 = r43 + r45;
        if (r52 == false) goto L23;
        Orientation r6 = Orientation.Vertical;
    L25:
        return new LazyGridMeasureResult(null, 0, false, MenuKt.ClosedAlphaTarget, r5, MenuKt.ClosedAlphaTarget, false, r63, r56, r58, r66, r67, r13, r14, r16, 0, r55, r6, r45, r46);
    L23:
        r6 = Orientation.Horizontal;
        goto L25
    L26:
        int r7 = Math.round(r49);
        int r8 = r48 - r7;
        if (r47 != 0) goto L30;
        if (r8 >= 0) goto L30;
        r7 = r7 + r8;
        r8 = 0;
    L30:
        List r17 = new ArrayDeque();
        int r9 = -r44;
        if (r46 >= 0) goto L33;
        int r10 = r46;
    L34:
        int r12 = r10 + r9;
        int r18 = r8 + r12;
        int r19 = r47;
    L35:
        if (r18 >= 0) goto L38;
        if (r19 <= 0) goto L38;
        r19 = r19 - 1;
        int r110 = r9;
        LazyGridMeasuredLine r20 = r41.getAndMeasure(r19);
        r17.add(0, r20);
        r18 = r18 + r20.getMainAxisSizeWithSpacings();
        r9 = r110;
    L38:
        int r111 = r9;
        if (r18 >= r12) goto L41;
        r7 = r7 - (r12 - r18);
        r18 = r12;
    L41:
        int r112 = r18 - r12;
        int r21 = r43 + r45;
        int r410 = r19;
        int r22 = RangesKt.coerceAtLeast(r21, 0);
        int r113 = -r112;
        int r114 = r410;
        int r23 = 0;
        boolean r115 = false;
    L43:
        if (r23 >= r17.size()) goto L47;
        if (r113 >= r22) goto L45;
        r114 = r114 + 1;
        r113 = r113 + ((LazyGridMeasuredLine) r17.get(r23)).getMainAxisSizeWithSpacings();
        r23 = r23 + 1;
        goto L43
    L45:
        r17.remove(r23);
        Unit r24 = Unit.INSTANCE;
        r115 = true;
        goto L43
    L47:
        int r25 = r112;
        boolean r116 = r115;
        int r26 = r114;
    L48:
        if (r26 >= r15) goto L64;
        if (r113 < r22) goto L53;
        if (r113 <= 0) goto L53;
        if (r17.isEmpty() == false) goto L64;
    L53:
        int r117 = r22;
        LazyGridMeasuredLine r27 = r41.getAndMeasure(r26);
        if (r27.isEmpty() == true) goto L64;
        int r118 = r113 + r27.getMainAxisSizeWithSpacings();
        if (r118 > r12) goto L61;
        int r119 = r12;
        int r120 = r118;
        if (((LazyGridMeasuredItem) ArraysKt.last(r27.getItems())).getIndex() == (r15 - 1)) goto L62;
        int r28 = r26 + 1;
        r25 = r25 - r27.getMainAxisSizeWithSpacings();
        Unit r29 = Unit.INSTANCE;
        r116 = true;
    L63:
        r26 = r26 + 1;
        r410 = r28;
        r22 = r117;
        r113 = r120;
        r12 = r119;
    L62:
        r17.add(r27);
        r28 = r410;
        goto L63
    L61:
        r119 = r12;
        r120 = r118;
    L64:
        if (r113 >= r43) goto L73;
        int r30 = r43 - r113;
        r25 = r25 - r30;
        r113 = r113 + r30;
    L66:
        int r31 = r410;
        if (r25 >= r44) goto L70;
        if (r31 <= 0) goto L70;
        int r32 = r31 - 1;
        LazyGridMeasuredLine r33 = r41.getAndMeasure(r32);
        r410 = r32;
        r17.add(0, r33);
        r25 = r25 + r33.getMainAxisSizeWithSpacings();
    L70:
        int r34 = r30 + r7;
        if (r25 >= 0) goto L74;
        r34 = r34 + r25;
        int r35 = r113 + r25;
        int r121 = 0;
    L76:
        if (MathKt.getSign(Math.round(r49)) == MathKt.getSign(r34)) goto L78;
    L80:
        float r36 = r49;
    L81:
        float r37 = r49 - r36;
        if (r61 == false) goto L87;
        if (r34 <= r7) goto L87;
        if (r37 > MenuKt.ClosedAlphaTarget) goto L87;
        float r38 = (r34 - r7) + r37;
    L88:
        if (r121 < 0) goto L90;
        boolean r39 = true;
    L91:
        if (r39 == true) goto L93;
        InlineClassHelperKt.throwIllegalArgumentException("negative initial offset");
    L93:
        int r51 = -r121;
        LazyGridMeasuredLine r122 = (LazyGridMeasuredLine) r17.first();
        LazyGridMeasuredItem r70 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(r122.getItems());
        if (r70 == null) goto L96;
        int r71 = r70.getIndex();
    L97:
        LazyGridMeasuredLine r72 = (LazyGridMeasuredLine) r17.lastOrNull();
        if (r72 == null) goto L104;
        LazyGridMeasuredItem[] r73 = r72.getItems();
        if (r73 == null) goto L104;
        LazyGridMeasuredItem r74 = (LazyGridMeasuredItem) ArraysKt.lastOrNull(r73);
        if (r74 == null) goto L104;
        int r411 = r74.getIndex();
    L105:
        List<Integer> r123 = r11;
        int r75 = r123.size();
        ArrayList r124 = null;
        List r210 = null;
        int r76 = 0;
    L106:
        if (r76 >= r75) goto L120;
        int r412 = r75;
        int r77 = ((Number) ListProtector.get(r11, r76)).intValue();
        if (r77 < 0) goto L111;
        if (r77 >= r71) goto L111;
        boolean r211 = true;
    L112:
        if (r211 == false) goto L119;
        int r78 = r41.spanOf(r77);
        LazyGridMeasuredItem r79 = r42.mo1095getAndMeasurehBUhpc(r77, 0, r78, r41.m1125childConstraintsJhjzzOo$foundation_release(0, r78));
        if (r210 != null) goto L116;
        List r80 = new ArrayList();
    L117:
        r80.add(r79);
        r210 = r80;
        goto L119
    L116:
        r80 = r210;
    L119:
        r76 = r76 + 1;
        r75 = r412;
        r71 = r71;
        r36 = r36;
    L111:
        r211 = false;
        goto L112
    L120:
        int r212 = r71;
        float r213 = r36;
        if (r210 != null) goto L123;
        r210 = CollectionsKt.emptyList();
    L123:
        int r413 = r121;
        boolean r310 = r116;
        int r125 = r35;
        List<LazyGridMeasuredLine> r81 = linesRetainedForLookahead(r411, r40, r41, r61, r17, r62);
        int r82 = r123.size();
        int r83 = 0;
    L124:
        if (r83 >= r82) goto L161;
        int r84 = ((Number) ListProtector.get(r11, r83)).intValue();
        int r85 = r411;
        if ((r85 + 1) > r84) goto L129;
        if (r84 >= r15) goto L129;
        boolean r86 = true;
    L130:
        if (r86 == false) goto L152;
        if (r61 == false) goto L150;
        int r87 = r81.size();
        int r414 = r82;
        int r88 = 0;
    L133:
        if (r88 >= r87) goto L147;
        int r610 = r87;
        LazyGridMeasuredItem[] r89 = ((LazyGridMeasuredLine) ListProtector.get(r81, r88)).getItems();
        int r126 = r89.length;
        int r127 = 0;
    L135:
        if (r127 >= r126) goto L143;
        LazyGridMeasuredItem[] r128 = r89;
        if (r89[r127].getIndex() != r84) goto L139;
        boolean r90 = true;
    L140:
        if (r90 == true) goto L141;
        r127 = r127 + 1;
        r89 = r128;
        goto L135
    L141:
        boolean r91 = true;
    L144:
        if (r91 == true) goto L145;
        r88 = r88 + 1;
        r87 = r610;
        goto L133
    L145:
        boolean r92 = true;
    L148:
        if (r92 == false) goto L151;
    L153:
        boolean r93 = false;
    L154:
        if (r93 == false) goto L160;
        int r94 = r41.spanOf(r84);
        LazyGridMeasuredItem r95 = r42.mo1095getAndMeasurehBUhpc(r84, 0, r94, r41.m1125childConstraintsJhjzzOo$foundation_release(0, r94));
        if (r124 != null) goto L158;
        r124 = new ArrayList();
    L158:
        ArrayList r96 = r124;
        r96.add(r95);
        r124 = r96;
    L160:
        r83 = r83 + 1;
        r15 = r40;
        r82 = r414;
        r11 = r59;
        r411 = r85;
    L151:
        r93 = true;
        goto L154
    L139:
        r90 = false;
        goto L140
    L143:
        r91 = false;
        goto L144
    L147:
        r92 = false;
        goto L148
    L150:
        r414 = r82;
        goto L151
    L152:
        r414 = r82;
    L129:
        r86 = false;
        goto L130
    L161:
        int r97 = r411;
        if (r124 != null) goto L164;
        List r129 = CollectionsKt.emptyList();
    L165:
        if (r44 > 0) goto L170;
        if (r46 < 0) goto L170;
        int r98 = r413;
    L169:
        LazyGridMeasuredLine r99 = r122;
        if (r52 == false) goto L180;
        int r100 = Constraints.getMaxWidth-impl(r50);
    L181:
        if (r52 == false) goto L183;
        int r130 = ConstraintsKt.constrainHeight-K40F9xA(r50, r125);
    L185:
        if (r81.isEmpty() == false) goto L187;
        List r131 = r17;
    L188:
        final List<LazyGridMeasuredItem> r101 = calculateItemsOffsets(r131, r210, r129, r100, r130, r125, r43, r51, r52, r53, r54, r55, r56);
        r57.onMeasured((int) r213, r100, r130, r101, r42.getKeyIndexMap(), r42, r52, r61, r58, r60, r98, r125, r63, r65);
        if (r61 == true) goto L203;
        long r132 = r57.m1152getMinSizeToFitDisappearingItemsYbymL2g();
        if (IntSize.equals-impl0(r132, IntSize.Companion.getZero-YbymL2g()) == true) goto L203;
        if (r52 == false) goto L194;
        int r102 = r130;
    L195:
        r100 = ConstraintsKt.constrainWidth-K40F9xA(r50, Math.max(r100, (int) (r132 >> 32)));
        r130 = ConstraintsKt.constrainHeight-K40F9xA(r50, Math.max(r130, (int) (r132 & 4294967295L)));
        if (r52 == false) goto L198;
        int r103 = r130;
    L199:
        if (r103 == r102) goto L203;
        int r104 = r101.size();
        int r105 = 0;
    L201:
        if (r105 >= r104) goto L203;
        ((LazyGridMeasuredItem) ListProtector.get(r101, r105)).updateMainAxisLayoutSize(r103);
        r105 = r105 + 1;
        goto L201
    L198:
        r103 = r100;
        goto L199
    L194:
        r102 = r100;
    L203:
        final List r106 = LazyLayoutStickyItemsKt.applyStickyItems(r68, r212, r97, r101, r42.getHeaderIndices(), r44, r45, r100, r130, new v(r41, r42));
        if (r97 != (r40 - 1)) goto L209;
        final boolean r107 = r61;
        if (r125 > r43) goto L210;
        boolean r311 = false;
    L211:
        MeasureResult r108 = (MeasureResult) r69.invoke(Integer.valueOf(r100), Integer.valueOf(r130), new w(r64, r101, r106, r107));
        List r133 = LazyLayoutMeasuredItemKt.updatedVisibleItems(r212, r97, r101, r106);
        if (r52 == false) goto L214;
        Orientation r109 = Orientation.Vertical;
    L216:
        return new LazyGridMeasureResult(r99, r98, r311, r213, r108, r38, r310, r63, r56, r58, r66, r67, r133, r111, r21, r40, r55, r109, r45, r46);
    L214:
        r109 = Orientation.Horizontal;
    L210:
        r311 = true;
        goto L211
    L209:
        r107 = r61;
        goto L210
    L187:
        r131 = CollectionsKt.plus(r17, r81);
        goto L188
    L183:
        r130 = Constraints.getMaxHeight-impl(r50);
        goto L185
    L180:
        r100 = ConstraintsKt.constrainWidth-K40F9xA(r50, r125);
    L170:
        int r134 = r17.size();
        r98 = r413;
        int r135 = 0;
    L171:
        if (r135 >= r134) goto L169;
        int r136 = ((LazyGridMeasuredLine) r17.get(r135)).getMainAxisSizeWithSpacings();
        if (r98 == 0) goto L169;
        if (r136 > r98) goto L169;
        if (r135 == CollectionsKt.getLastIndex(r17)) goto L169;
        r98 = r98 - r136;
        r135 = r135 + 1;
        r122 = (LazyGridMeasuredLine) r17.get(r135);
        goto L171
    L164:
        r129 = r124;
    L104:
        r411 = 0;
        goto L105
    L96:
        r71 = 0;
        goto L97
    L90:
        r39 = false;
    L87:
        r38 = MenuKt.ClosedAlphaTarget;
        goto L88
    L78:
        if (Math.abs(Math.round(r49)) < Math.abs(r34)) goto L80;
        r36 = r34;
    L74:
        int r312 = r113;
        r121 = r25;
        r35 = r312;
        goto L76
    L73:
        r34 = r7;
        goto L74
    L33:
        r10 = 0;
        goto L34
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }
}
