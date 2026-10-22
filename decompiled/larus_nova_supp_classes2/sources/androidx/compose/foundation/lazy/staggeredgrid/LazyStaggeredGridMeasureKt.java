package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0002¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0082\b\u001a£\u0001\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102\u001a,\u00103\u001a\u00020\u0015*\u0002042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0001H\u0002\u001aK\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010@\u001aG\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0019*\u0002042\u0006\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00012\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110EH\u0082\b\u001aR\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u00072!\u0010G\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010K\u001a\u00020\u0001H\u0082\b\u001a7\u0010L\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00192\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b\u001a(\u0010O\u001a\u00020\u0011*\u00020P2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b¢\u0006\u0004\bQ\u0010R\u001a\u0014\u0010S\u001a\u00020\u0011*\u0002072\u0006\u0010T\u001a\u00020\u001aH\u0002\u001a\u001b\u0010U\u001a\u00020\u001a*\u0002072\u0006\u0010V\u001a\u00020PH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0016\u0010Y\u001a\u00020\u001a*\u0002072\b\b\u0002\u0010Z\u001a\u00020\u001aH\u0000\u001a2\u0010[\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b¢\u0006\u0002\u0010\\\u001a\f\u0010]\u001a\u00020\u001a*\u000207H\u0002\u001a!\u0010^\u001a\u000207*\u0002072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b\u001a\u001c\u0010_\u001a\u00020\u0011*\u0002042\u0006\u0010`\u001a\u0002072\u0006\u0010a\u001a\u00020\u001aH\u0002\u001a\u001c\u0010b\u001a\u00020\u001a*\u0002042\u0006\u0010c\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"DebugLoggingEnabled", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "debugRender", "", "", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "debugLog", "", "message", "Lkotlin/Function0;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "initialItemIndices", "", "initialItemOffsets", "canRestartMeasure", "calculateVisibleItems", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "position", "Lkotlin/Function2;", "calculateExtraItems", "filter", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "itemIndex", "beforeVisibleBounds", "fastForEach", "reverse", "action", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "offsetBy", "delta", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "indexOfMinValue", "minBound", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMaxValue", "transform", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "Unset", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    public static /* synthetic */ Unit a(LazyStaggeredGridMeasureContext r0, List r1, LazyLayoutMeasureScope r2, Placeable.PlacementScope r3) {
        return measure$lambda$49$lambda$48(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit b(Placeable.PlacementScope r0) {
        return measure$lambda$49$lambda$4(r0);
    }

    public static /* synthetic */ Unit c(List r0, LazyStaggeredGridMeasureContext r1, LazyLayoutMeasureScope r2, Placeable.PlacementScope r3) {
        return measure$lambda$49$lambda$48$lambda$47(r0, r1, r2, r3);
    }

    private static final void debugLog(Function0<String> r0) {
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] r0) {
        return "";
    }

    private static final int indexOfMaxValue(int[] r5) {
        int r0 = r5.length;
        int r1 = -1;
        int r2 = Integer.MIN_VALUE;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        int r4 = r5[r3];
        if (r2 >= r4) goto L7;
        r1 = r3;
        r2 = r4;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return r1;
    }

    private static final CharSequence measure$lambda$49$lambda$34$lambda$33(LazyStaggeredGridMeasuredItem r0) {
        return String.valueOf(r0.getIndex());
    }

    private static final Unit measure$lambda$49$lambda$4(Placeable.PlacementScope r0) {
        return Unit.INSTANCE;
    }

    private static final CharSequence measure$lambda$49$lambda$41$lambda$40(LazyStaggeredGridMeasuredItem r0) {
        return String.valueOf(r0.getIndex());
    }

    /* JADX INFO: renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m1225forEachnIS5qE8(long r4, Function1<? super Integer, Unit> r6) {
        int r1 = (int) (r4 >> 32);
        int r5 = (int) (r4 & 4294967295L);
    L3:
        if (r1 >= r5) goto L5;
        r6.invoke(Integer.valueOf(r1));
        r1 = r1 + 1;
        goto L3
    }

    private static final <T> int indexOfMinBy(T[] r5, Function1<? super T, Integer> r6) {
        int r0 = r5.length;
        int r1 = -1;
        int r2 = Integer.MAX_VALUE;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        int r4 = ((Number) r6.invoke(r5[r3])).intValue();
        if (r2 <= r4) goto L7;
        r1 = r3;
        r2 = r4;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return r1;
    }

    public static final int indexOfMinValue(int[] r8, int r9) {
        int r0 = r8.length;
        int r1 = -1;
        int r2 = Integer.MAX_VALUE;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L12;
        boolean r5 = true;
        int r6 = r9 + 1;
        int r7 = r8[r4];
        if (r6 > r7) goto L8;
        if (r7 >= r2) goto L8;
    L9:
        if (r5 == false) goto L11;
        r1 = r4;
        r2 = r7;
    L11:
        r4 = r4 + 1;
    L8:
        r5 = false;
        goto L9
    L12:
        return r1;
    }

    /* JADX INFO: renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m1226maxInRangejy6DScQ(int[] r4, long r5) {
        int r1 = (int) (r5 >> 32);
        int r6 = (int) (r5 & 4294967295L);
        int r7 = Integer.MIN_VALUE;
    L3:
        if (r1 >= r6) goto L5;
        r7 = Math.max(r7, r4[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r7;
    }

    private static final void offsetBy(int[] r3, int r4) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1] = r3[r1] + r4;
        r1 = r1 + 1;
        goto L3
    }

    private static final int[] transform(int[] r3, Function1<? super Integer, Integer> r4) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1] = ((Number) r4.invoke(Integer.valueOf(r3[r1]))).intValue();
        r1 = r1 + 1;
        goto L3
    L5:
        return r3;
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope r0, Function1<? super LazyLayoutMeasureScope, ? extends T> r1) {
        return (T) r1.invoke(r0);
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext r4, int[] r5, int r6) {
        int r0 = r5.length - 1;
        if (r0 < 0) goto L19;
    L4:
        int r1 = r0 - 1;
    L6:
        if (r5[r0] >= r6) goto L18;
        if (r4.getLaneInfo().assignedToLane(r5[r0], r0) == false) goto L18;
        if (r5[r0] >= 0) goto L13;
    L15:
        if (r1 < 0) goto L24;
        r0 = r1;
        goto L4
    L24:
        return;
    L13:
        if (r4.isFullSpan(r4.getItemProvider(), r5[r0]) == true) goto L15;
        r4.getLaneInfo().setLane(r5[r0], r0);
    L18:
        r5[r0] = findPreviousItemIndex(r4, r5[r0], r0);
        goto L6
    }

    private static final <T> void fastForEach(List<? extends T> r2, boolean r3, Function1<? super T, Unit> r4) {
        if (r3 == false) goto L9;
        int r5 = r2.size() - 1;
        if (r5 < 0) goto L12;
    L5:
        int r0 = r5 - 1;
        r4.invoke(ListProtector.get(r2, r5));
        if (r0 < 0) goto L15;
        r5 = r0;
        goto L5
    L15:
        return;
    L12:
        return;
    L9:
        int r6 = r2.size();
        int r1 = 0;
    L10:
        if (r1 >= r6) goto L16;
        r4.invoke(ListProtector.get(r2, r1));
        r1 = r1 + 1;
        goto L10
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext r0, int r1, int r2) {
        return r0.getLaneInfo().findPreviousItemIndex(r1, r2);
    }

    private static final boolean measure$lambda$49$hasSpaceBeforeFirst(int[] r6, int[] r7, LazyStaggeredGridMeasureContext r8) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        int r3 = r6[r2];
        if (r7[r2] >= Math.max(-r8.getMainAxisSpacing(), 0)) goto L9;
        if (r3 <= 0) goto L9;
        return true;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return false;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext r8, Function1<? super LazyStaggeredGridMeasuredItem, Unit> r9, Function1<? super Integer, Boolean> r10, boolean r11) {
        List<Integer> r0 = r8.getPinnedItems();
        ArrayList r2 = null;
        if (r11 == false) goto L15;
        int r12 = r0.size() - 1;
        if (r12 < 0) goto L24;
    L6:
        int r3 = r12 - 1;
        int r13 = ((Number) ListProtector.get(r0, r12)).intValue();
        if (((Boolean) r10.invoke(Integer.valueOf(r13))).booleanValue() == false) goto L12;
        long r4 = r8.m1222getSpanRangelOCCd4c(r8.getItemProvider(), r13, 0);
        if (r2 != null) goto L11;
        r2 = new ArrayList();
    L11:
        LazyStaggeredGridMeasuredItem r14 = r8.getMeasuredItemProvider().m1230getAndMeasurejy6DScQ(r13, r4);
        r9.invoke(r14);
        r2.add(r14);
    L12:
        if (r3 < 0) goto L24;
        r12 = r3;
    L24:
        if (r2 == null) goto L26;
        return r2;
    L26:
        return CollectionsKt.emptyList();
    L15:
        int r15 = r0.size();
        int r5 = 0;
    L16:
        if (r5 >= r15) goto L24;
        int r6 = ((Number) ListProtector.get(r0, r5)).intValue();
        if (((Boolean) r10.invoke(Integer.valueOf(r6))).booleanValue() == false) goto L23;
        long r7 = r8.m1222getSpanRangelOCCd4c(r8.getItemProvider(), r6, 0);
        if (r2 != null) goto L22;
        r2 = new ArrayList();
    L22:
        LazyStaggeredGridMeasuredItem r16 = r8.getMeasuredItemProvider().m1230getAndMeasurejy6DScQ(r6, r7);
        r9.invoke(r16);
        r2.add(r16);
    L23:
        r5 = r5 + 1;
        goto L16
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = Integer.MIN_VALUE;
    L6:
        return indexOfMinValue(r0, r1);
    }

    private static final Unit measure$lambda$49$lambda$48(final LazyStaggeredGridMeasureContext r1, final List r2, final LazyLayoutMeasureScope r3, Placeable.PlacementScope r4) {
        r4.withMotionFrameOfReferencePlacement(new n(r2, r1, r3));
        ObservableScopeInvalidator.m1184attachToScopeimpl(r1.getState().m1234getPlacementScopeInvalidatorzYiylxw$foundation_release());
        return Unit.INSTANCE;
    }

    private static final Unit measure$lambda$49$lambda$48$lambda$47(List r4, LazyStaggeredGridMeasureContext r5, LazyLayoutMeasureScope r6, Placeable.PlacementScope r7) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        ((LazyStaggeredGridMeasuredItem) ListProtector.get(r4, r1)).place(r7, r5, r6.isLookingAhead());
        r1 = r1 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    private static final boolean measure$lambda$49$misalignedStart(int[] r7, LazyStaggeredGridMeasureContext r8, int[] r9, int r10) {
        int r0 = r7.length;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L14;
        if (findPreviousItemIndex(r8, r7[r2], r2) == (-1)) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L12;
        r2 = r2 + 1;
        goto L4
    L12:
        return true;
    L8:
        if (r9[r2] == r9[r10]) goto L10;
        r3 = true;
        goto L11
    L14:
        int r1 = r7.length;
        int r4 = 0;
    L15:
        if (r4 >= r1) goto L25;
        if (findPreviousItemIndex(r8, r7[r4], r4) != (-1)) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == true) goto L23;
        r4 = r4 + 1;
        goto L15
    L23:
        return true;
    L19:
        if (r9[r4] < r9[r10]) goto L21;
        r5 = true;
        goto L22
    L25:
        int r11 = r8.getLaneInfo().getLane(0);
        if (r11 == 0) goto L36;
        if (r11 != (-1)) goto L29;
        return false;
    L29:
        if (r11 == (-2)) goto L38;
        return true;
    L38:
        return false;
    L36:
        return false;
    }

    public static /* synthetic */ void fastForEach$default(List r0, boolean r1, Function1 r2, int r3, Object r4) {
        int r5 = 0;
        if ((r3 & 1) == 0) goto L5;
        r1 = false;
    L5:
        if (r1 == false) goto L12;
        int r6 = r0.size() - 1;
        if (r6 < 0) goto L15;
    L8:
        int r7 = r6 - 1;
        r2.invoke(ListProtector.get(r0, r6));
        if (r7 < 0) goto L18;
        r6 = r7;
        goto L8
    L18:
        return;
    L15:
        return;
    L12:
        int r8 = r0.size();
    L13:
        if (r5 >= r8) goto L19;
        r2.invoke(ListProtector.get(r0, r5));
        r5 = r5 + 1;
        goto L13
    }

    private static final List<LazyStaggeredGridMeasuredItem> itemsRetainedForLookahead(LazyStaggeredGridMeasureContext r8, int r9, int r10, boolean r11, Function2<? super LazyStaggeredGridMeasuredItem, ? super Integer, Unit> r12) {
        if (r11 == true) goto L5;
        return null;
    L5:
        if (r8.getApproachLayoutInfo() != null) goto L7;
        return null;
    L7:
        if ((!r8.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty()) == false) goto L76;
        List<LazyStaggeredGridItemInfo> r13 = r8.getApproachLayoutInfo().getVisibleItemsInfo();
        int r2 = r13.size() - 1;
    L10:
        if ((-1) >= r2) goto L18;
        if (((LazyStaggeredGridItemInfo) ListProtector.get(r13, r2)).getIndex() <= r9) goto L17;
        if (r2 == 0) goto L16;
        if (((LazyStaggeredGridItemInfo) ListProtector.get(r13, r2 - 1)).getIndex() > r9) goto L17;
    L16:
        LazyStaggeredGridItemInfo r14 = (LazyStaggeredGridItemInfo) ListProtector.get(r13, r2);
    L19:
        LazyStaggeredGridItemInfo r15 = (LazyStaggeredGridItemInfo) CollectionsKt.last(r8.getApproachLayoutInfo().getVisibleItemsInfo());
        if (r14 == null) goto L77;
        int r16 = r14.getIndex();
        int r17 = Math.min(r15.getIndex(), r10 - 1);
        if (r16 > r17) goto L78;
        ArrayList r18 = null;
    L24:
        int r3 = 0;
        if (r18 == null) goto L38;
        int r4 = r18.size();
        int r5 = 0;
    L27:
        if (r5 >= r4) goto L35;
        if (((LazyStaggeredGridMeasuredItem) ListProtector.get(r18, r5)).getIndex() != r16) goto L31;
        boolean r6 = true;
    L32:
        if (r6 == true) goto L33;
        r5 = r5 + 1;
        goto L27
    L33:
        boolean r7 = true;
    L36:
        if (r7 != true) goto L38;
        boolean r19 = true;
    L39:
        if (r19 == true) goto L60;
        if (r18 != null) goto L42;
        r18 = new ArrayList();
    L42:
        List<LazyStaggeredGridItemInfo> r20 = r8.getApproachLayoutInfo().getVisibleItemsInfo();
        int r21 = r20.size();
        int r22 = 0;
    L43:
        if (r22 >= r21) goto L51;
        Object r23 = ListProtector.get(r20, r22);
        if (((LazyStaggeredGridItemInfo) r23).getIndex() != r16) goto L47;
        boolean r24 = true;
    L48:
        if (r24 == true) goto L52;
        r22 = r22 + 1;
    L52:
        LazyStaggeredGridItemInfo r25 = (LazyStaggeredGridItemInfo) r23;
        if (r25 == null) goto L55;
        int r26 = r25.getLane();
    L56:
        LazyStaggeredGridMeasuredItem r27 = r8.getMeasuredItemProvider().m1230getAndMeasurejy6DScQ(r16, r8.m1222getSpanRangelOCCd4c(r8.getItemProvider(), r16, r26));
        r18.add(r27);
        int[] r28 = r8.getResolvedSlots().getPositions();
        if (r28.length <= r26) goto L59;
        r3 = r28[r26];
    L59:
        r12.invoke(r27, Integer.valueOf(r3));
        goto L60
    L55:
        r26 = 0;
        goto L56
    L47:
        r24 = false;
        goto L48
    L51:
        r23 = null;
    L60:
        if (r16 == r17) goto L63;
        r16 = r16 + 1;
        goto L24
    L63:
        return r18;
    L31:
        r6 = false;
        goto L32
    L35:
        r7 = false;
    L38:
        r19 = false;
        goto L39
    L78:
        return null;
    L77:
        return null;
    L17:
        r2 = r2 - 1;
        goto L10
    L18:
        r14 = null;
        goto L19
    L76:
        return null;
    }

    private static final LazyStaggeredGridMeasureResult measure(final LazyStaggeredGridMeasureContext r50, int r51, int[] r52, int[] r53, boolean r54) {
        int r0 = r51;
        LazyLayoutMeasureScope r15 = r50.getMeasureScope();
        int r14 = r50.getItemProvider().getItemCount();
        if (r14 > 0) goto L5;
    L520:
        int r1 = Constraints.getMinWidth-impl(r50.m1219getConstraintsmsEJaDk());
        int r3 = Constraints.getMinHeight-impl(r50.m1219getConstraintsmsEJaDk());
        r50.getState().getItemAnimator$foundation_release().onMeasured(0, r1, r3, new ArrayList(), r50.getMeasuredItemProvider().getKeyIndexMap(), r50.getMeasuredItemProvider(), r50.isVertical(), r15.isLookingAhead(), r50.getLaneCount(), r50.isInLookaheadScope(), 0, 0, r50.getCoroutineScope(), r50.getGraphicsContext());
        if (r15.isLookingAhead() == true) goto L526;
        long r4 = r50.getState().getItemAnimator$foundation_release().m1152getMinSizeToFitDisappearingItemsYbymL2g();
        if (IntSize.equals-impl0(r4, IntSize.Companion.getZero-YbymL2g()) == true) goto L526;
        r1 = ConstraintsKt.constrainWidth-K40F9xA(r50.m1219getConstraintsmsEJaDk(), (int) (r4 >> 32));
        r3 = ConstraintsKt.constrainHeight-K40F9xA(r50.m1219getConstraintsmsEJaDk(), (int) (r4 & 4294967295L));
    L526:
        return new LazyStaggeredGridMeasureResult(r52, r53, MenuKt.ClosedAlphaTarget, MeasureScope.-CC.layout$default(r15, r1, r3, null, new o(), 4, null), MenuKt.ClosedAlphaTarget, false, r50.isVertical(), false, r50.getResolvedSlots(), r50.getItemProvider().getSpanProvider(), r15, r14, CollectionsKt.emptyList(), IntSize.constructor-impl((((long) Constraints.getMinWidth-impl(r50.m1219getConstraintsmsEJaDk())) << 32) | (((long) Constraints.getMinHeight-impl(r50.m1219getConstraintsmsEJaDk())) & 4294967295L)), -r50.getBeforeContentPadding(), r50.getMainAxisAvailableSize() + r50.getAfterContentPadding(), r50.getBeforeContentPadding(), r50.getAfterContentPadding(), r50.getMainAxisSpacing(), r50.getCoroutineScope(), null);
    L5:
        if (r50.getLaneCount() == 0) goto L520;
        int[] r13 = Arrays.copyOf(r52, r52.length);
        int[] r12 = Arrays.copyOf(r53, r53.length);
        ensureIndicesInRange(r50, r13, r14);
        offsetBy(r12, -r0);
        int r5 = r50.getLaneCount();
        ArrayDeque[] r6 = new ArrayDeque[r5];
        int r2 = 0;
    L8:
        if (r2 >= r5) goto L10;
        r6[r2] = new ArrayDeque(16);
        r2 = r2 + 1;
        goto L8
    L10:
        offsetBy(r12, -r50.getBeforeContentPadding());
        boolean r7 = false;
    L12:
        if (measure$lambda$49$hasSpaceBeforeFirst(r13, r12, r50) == false) goto L48;
        int r8 = indexOfMaxValue(r13);
        int r9 = r13[r8];
        int r10 = r12.length;
        int r11 = 0;
    L14:
        if (r11 >= r10) goto L21;
        if (r13[r11] == r13[r8]) goto L20;
        int r16 = r12[r11];
        int r17 = r12[r8];
        if (r16 >= r17) goto L20;
        r12[r11] = r17;
    L20:
        r11 = r11 + 1;
        goto L14
    L21:
        int r18 = findPreviousItemIndex(r50, r9, r8);
        if (r18 < 0) goto L49;
        long r19 = r50.m1222getSpanRangelOCCd4c(r50.getItemProvider(), r18, r8);
        LazyStaggeredGridLaneInfo r20 = r50.getLaneInfo();
        int r110 = (int) (r19 & 4294967295L);
        int[] r55 = r12;
        int r111 = (int) (r19 >> 32);
        int r112 = r110 - r111;
        if (r112 == 1) goto L27;
        boolean r21 = true;
    L28:
        if (r21 == false) goto L30;
        int r22 = -2;
    L31:
        r20.setLane(r18, r22);
        LazyStaggeredGridMeasuredItem r23 = r50.getMeasuredItemProvider().m1230getAndMeasurejy6DScQ(r18, r19);
        int r24 = m1226maxInRangejy6DScQ(r55, r19);
        if (r112 == 1) goto L34;
        boolean r25 = true;
    L35:
        if (r25 == false) goto L37;
        int[] r26 = r50.getLaneInfo().getGaps(r18);
    L38:
        if (r111 >= r110) goto L47;
        r13[r111] = r18;
        if (r26 != null) goto L42;
        int r27 = 0;
    L43:
        int r113 = (r24 + r23.getMainAxisSizeWithSpacings()) + r27;
        r55[r111] = r113;
        if ((r50.getMainAxisAvailableSize() + r113) > 0) goto L46;
        r7 = true;
    L46:
        r111 = r111 + 1;
        goto L38
    L42:
        r27 = r26[r111];
        goto L43
    L47:
        r12 = r9;
        goto L12
    L37:
        r26 = null;
        goto L38
    L34:
        r25 = false;
        goto L35
    L30:
        r22 = r111;
        goto L31
    L27:
        r21 = false;
    L49:
        int r114 = -r50.getBeforeContentPadding();
        int r28 = r12[0];
        if (r28 >= r114) goto L52;
        offsetBy(r12, r114 - r28);
        r0 = r0 - (r114 - r28);
    L52:
        offsetBy(r12, r50.getBeforeContentPadding());
        int r29 = -1;
        if (r8 != (-1)) goto L55;
        r8 = ArraysKt.indexOf(r13, 0);
    L55:
        if (r8 != (-1)) goto L57;
    L67:
        int[] r30 = Arrays.copyOf(r13, r13.length);
        int r31 = r12.length;
        int[] r115 = new int[r31];
        int r32 = 0;
    L68:
        if (r32 >= r31) goto L70;
        r115[r32] = -r12[r32];
        r32 = r32 + 1;
        goto L68
    L70:
        int r33 = r114 + r50.getMainAxisSpacing();
        int r34 = RangesKt.coerceAtLeast(r50.getMainAxisAvailableSize() + r50.getAfterContentPadding(), 0);
        boolean r56 = r7;
        int r116 = indexOfMinValue$default(r30, 0, 1, null);
        int r35 = 0;
        int r36 = -1;
        boolean r210 = r56;
    L71:
        if (r116 == r36) goto L100;
        if (r35 >= r50.getLaneCount()) goto L100;
        int r37 = r30[r116];
        r116 = indexOfMinValue(r30, r37);
        r35 = r35 + 1;
        if (r37 < 0) goto L99;
        int r211 = r0;
        long r38 = r50.m1222getSpanRangelOCCd4c(r50.getItemProvider(), r37, r116);
        LazyStaggeredGridMeasuredItem r117 = r50.getMeasuredItemProvider().m1230getAndMeasurejy6DScQ(r37, r38);
        LazyStaggeredGridLaneInfo r39 = r50.getLaneInfo();
        int[] r212 = r13;
        int r213 = r14;
        int r118 = (int) (r38 & 4294967295L);
        int r214 = r34;
        int r119 = r5;
        int r40 = (int) (r38 >> 32);
        int r41 = r118 - r40;
        if (r41 == 1) goto L79;
        boolean r310 = true;
    L80:
        if (r310 == false) goto L82;
        int r120 = -2;
    L83:
        r39.setLane(r53, r120);
        int r42 = m1226maxInRangejy6DScQ(r115, r38);
        int r43 = r40;
    L84:
        if (r43 >= r118) goto L86;
        r115[r43] = r117.getMainAxisSizeWithSpacings() + r42;
        r30[r43] = r37;
        r6[r43].addLast(r117);
        r43 = r43 + 1;
        goto L84
    L86:
        if (r42 < r33) goto L88;
    L90:
        int r44 = 1;
    L91:
        if (r41 == r44) goto L93;
        boolean r45 = true;
    L94:
        if (r45 == false) goto L96;
        r35 = r50.getLaneCount();
    L97:
        r0 = r211;
        r14 = r213;
        r13 = r212;
        r34 = r214;
        r5 = r119;
        r15 = r15;
        goto L99
    L96:
        r35 = r35;
        goto L97
    L93:
        r45 = false;
        goto L94
    L88:
        if (r115[r40] > r33) goto L90;
        r117.setVisible(false);
        r44 = 1;
        r210 = true;
        goto L91
    L82:
        r120 = r40;
        goto L83
    L79:
        r310 = false;
    L99:
        r36 = -1;
    L100:
        int r215 = r0;
        int r216 = r34;
        int r311 = r5;
        int[] r217 = r13;
        int r218 = r14;
        LazyLayoutMeasureScope r312 = r15;
    L101:
        int r46 = 0;
    L102:
        if (r46 >= r31) goto L112;
        int r47 = r115[r46];
        int r48 = r216;
        if (r47 < r48) goto L108;
        if (r47 <= 0) goto L108;
        boolean r49 = false;
    L109:
        if (r49 == true) goto L110;
        r46 = r46 + 1;
        r216 = r48;
        goto L102
    L110:
        boolean r57 = true;
    L113:
        int r58 = r311;
        if (r57 == true) goto L125;
        int r59 = 0;
    L116:
        if (r59 >= r58) goto L121;
        if (r6[r59].isEmpty() == false) goto L119;
        r59 = r59 + 1;
        goto L116
    L119:
        boolean r60 = false;
    L122:
        if (r60 == true) goto L125;
        int r121 = r218;
        int r61 = 1;
    L127:
        int r62 = 0;
    L128:
        if (r62 >= r58) goto L148;
        ArrayDeque r63 = r6[r62];
    L131:
        if (r63.size() <= r61) goto L143;
        if (((LazyStaggeredGridMeasuredItem) r63.first()).isVisible() == true) goto L143;
        LazyStaggeredGridMeasuredItem r64 = (LazyStaggeredGridMeasuredItem) r63.removeFirst();
        if (r64.getSpan() == r61) goto L137;
        int[] r122 = r50.getLaneInfo().getGaps(r64.getIndex());
    L138:
        int r123 = r12[r62];
        int r65 = r64.getMainAxisSizeWithSpacings();
        if (r122 != null) goto L141;
        int r124 = 0;
    L142:
        r12[r62] = r123 - (r65 + r124);
        r61 = 1;
        goto L131
    L141:
        r124 = r122[r62];
        goto L142
    L137:
        r122 = null;
    L143:
        LazyStaggeredGridMeasuredItem r66 = (LazyStaggeredGridMeasuredItem) r63.firstOrNull();
        if (r66 == null) goto L146;
        int r67 = r66.getIndex();
    L147:
        r217[r62] = r67;
        r62 = r62 + 1;
        r61 = 1;
        goto L128
    L146:
        r67 = -1;
        goto L147
    L148:
        int r68 = r30.length;
        int r69 = 0;
    L149:
        if (r69 >= r68) goto L157;
        if (r30[r69] != (r121 - 1)) goto L153;
        boolean r70 = true;
    L154:
        if (r70 == true) goto L155;
        r69 = r69 + 1;
        goto L149
    L155:
        boolean r71 = true;
    L158:
        if (r71 == false) goto L160;
        offsetBy(r115, -r50.getMainAxisSpacing());
    L160:
        int r72 = 0;
    L161:
        if (r72 >= r31) goto L169;
        if (r115[r72] >= r50.getMainAxisAvailableSize()) goto L165;
        boolean r73 = true;
    L166:
        if (r73 == false) goto L167;
        r72 = r72 + 1;
        goto L161
    L167:
        boolean r74 = false;
    L170:
        if (r74 == false) goto L241;
        int r75 = r50.getMainAxisAvailableSize() - r115[indexOfMaxValue(r115)];
        offsetBy(r12, -r75);
        offsetBy(r115, r75);
        boolean r76 = false;
    L172:
        int r77 = r12.length;
        int r125 = 0;
    L173:
        if (r125 >= r77) goto L181;
        if (r12[r125] >= r50.getBeforeContentPadding()) goto L177;
        boolean r126 = true;
    L178:
        if (r126 == true) goto L179;
        r125 = r125 + 1;
        goto L173
    L179:
        boolean r78 = true;
    L182:
        if (r78 == false) goto L233;
        int r127 = indexOfMinValue$default(r12, 0, 1, null);
        int r79 = indexOfMaxValue(r217);
        if (r127 != r79) goto L186;
    L189:
        int r80 = r217[r127];
        if (r80 != (-1)) goto L192;
        r80 = r121;
    L192:
        int r81 = findPreviousItemIndex(r50, r80, r127);
        if (r81 < 0) goto L194;
        int r128 = r215;
        int[] r129 = r217;
        int r219 = r31;
        long r82 = r50.m1222getSpanRangelOCCd4c(r50.getItemProvider(), r81, r127);
        LazyStaggeredGridLaneInfo r130 = r50.getLaneInfo();
        int r220 = r48;
        int r313 = r58;
        int r83 = (int) (r82 & 4294967295L);
        boolean r510 = r76;
        int r511 = r75;
        int r84 = (int) (r82 >> 32);
        int r85 = r83 - r84;
        if (r85 == 1) goto L211;
        boolean r221 = true;
    L212:
        if (r221 == false) goto L214;
        int r86 = -2;
    L215:
        r130.setLane(r81, r86);
        LazyStaggeredGridMeasuredItem r87 = r50.getMeasuredItemProvider().m1230getAndMeasurejy6DScQ(r81, r82);
        int r88 = m1226maxInRangejy6DScQ(r12, r82);
        if (r85 == 1) goto L218;
        boolean r89 = true;
    L219:
        if (r89 == false) goto L221;
        int[] r90 = r50.getLaneInfo().getGaps(r81);
    L222:
        int r131 = r84;
        boolean r91 = r510;
    L223:
        if (r131 >= r83) goto L232;
        if (r12[r131] == r88) goto L227;
        r91 = true;
    L227:
        r6[r131].addFirst(r87);
        r129[r131] = r81;
        if (r90 != null) goto L230;
        int r92 = 0;
    L231:
        r12[r131] = (r88 + r87.getMainAxisSizeWithSpacings()) + r92;
        r131 = r131 + 1;
        goto L223
    L230:
        r92 = r90[r131];
        goto L231
    L232:
        r76 = r91;
        r215 = r128;
        r217 = r129;
        r31 = r219;
        r48 = r220;
        r58 = r313;
        r75 = r511;
        goto L172
    L221:
        r90 = null;
        goto L222
    L218:
        r89 = false;
        goto L219
    L214:
        r86 = r84;
        goto L215
    L211:
        r221 = false;
        goto L212
    L194:
        int[] r132 = r217;
        if (r76 == false) goto L197;
    L198:
        if (r54 == false) goto L234;
        r50.getLaneInfo().reset();
        int r93 = r132.length;
        int[] r94 = new int[r93];
        int r95 = 0;
    L200:
        if (r95 >= r93) goto L202;
        r94[r95] = -1;
        r95 = r95 + 1;
        goto L200
    L202:
        int r96 = r12.length;
        int[] r97 = new int[r96];
        int r98 = 0;
    L203:
        if (r98 >= r96) goto L206;
        r97[r98] = r12[r127];
        r98 = r98 + 1;
        goto L203
    L206:
        return measure(r50, r215, r94, r97, false);
    L234:
        if (r76 == false) goto L238;
        if (r54 == false) goto L238;
        r50.getLaneInfo().reset();
        return measure(r50, r215, r132, r12, false);
    L238:
        int r99 = r215 + r75;
        int r100 = r12[indexOfMinValue$default(r12, 0, 1, null)];
        if (r100 >= 0) goto L242;
        r99 = r99 + r100;
        offsetBy(r115, r100);
        offsetBy(r12, -r100);
    L242:
        float r101 = r50.getState().scrollToBeConsumed$foundation_release(r312.isLookingAhead());
        if (MathKt.getSign(Math.round(r101)) == MathKt.getSign(r99)) goto L245;
    L247:
        float r133 = r101;
    L248:
        float r102 = r101 - r133;
        if (r312.isLookingAhead() == false) goto L254;
        if (r99 <= r215) goto L254;
        if (r102 > MenuKt.ClosedAlphaTarget) goto L254;
        float r222 = (r99 - r215) + r102;
    L255:
        int[] r134 = Arrays.copyOf(r12, r12.length);
        int r103 = r134.length;
        int r104 = 0;
    L256:
        if (r104 >= r103) goto L258;
        r134[r104] = -r134[r104];
        r104 = r104 + 1;
        goto L256
    L258:
        int r105 = r58;
        if (r50.getBeforeContentPadding() <= r50.getMainAxisSpacing()) goto L275;
        int r106 = 0;
    L261:
        if (r106 >= r105) goto L275;
        ArrayDeque r107 = r6[r106];
        int r108 = r107.size();
        int r109 = 0;
    L263:
        if (r109 >= r108) goto L274;
        LazyStaggeredGridMeasuredItem r223 = (LazyStaggeredGridMeasuredItem) r107.get(r109);
        int[] r135 = r50.getLaneInfo().getGaps(r223.getIndex());
        int r136 = r223.getMainAxisSizeWithSpacings();
        if (r135 != null) goto L267;
        int r137 = 0;
    L268:
        int r138 = r136 + r137;
        if (r109 == CollectionsKt.getLastIndex(r107)) goto L274;
        int r139 = r12[r106];
        if (r139 == 0) goto L274;
        if (r139 < r138) goto L274;
        r12[r106] = r139 - r138;
        r109 = r109 + 1;
        r132[r106] = ((LazyStaggeredGridMeasuredItem) r107.get(r109)).getIndex();
        goto L263
    L267:
        r137 = r135[r106];
    L274:
        r106 = r106 + 1;
    L275:
        int r140 = r50.getBeforeContentPadding() + r50.getAfterContentPadding();
        if (r50.isVertical() == false) goto L278;
        int r141 = Constraints.getMaxWidth-impl(r50.m1219getConstraintsmsEJaDk());
    L279:
        int r142 = r141;
        if (r50.isVertical() == false) goto L282;
        int r143 = ConstraintsKt.constrainHeight-K40F9xA(r50.m1219getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(r115) + r140);
    L283:
        int r144 = r143;
        if (r50.isVertical() == false) goto L286;
        int r145 = r144;
    L287:
        int r146 = (Math.min(r145, r50.getMainAxisAvailableSize()) - r50.getBeforeContentPadding()) + r50.getAfterContentPadding();
        int r147 = r134[0];
        List<Integer> r148 = r50.getPinnedItems();
        int r224 = r148.size() - 1;
        if (r224 < 0) goto L323;
        int r149 = r224;
        ArrayList r225 = null;
    L290:
        int r226 = r149 - 1;
        int r150 = ((Number) ListProtector.get(r148, r149)).intValue();
        List<Integer> r512 = r148;
        int r151 = r50.getLaneInfo().getLane(r150);
        int r513 = r142;
        if (r151 != (-2)) goto L293;
    L301:
        int r152 = 0;
    L302:
        if (r152 >= r105) goto L313;
        LazyStaggeredGridMeasuredItem r153 = (LazyStaggeredGridMeasuredItem) r6[r152].firstOrNull();
        if (r153 == null) goto L306;
        int r154 = r153.getIndex();
    L307:
        if (r154 <= r150) goto L309;
        boolean r155 = true;
    L310:
        if (r155 == false) goto L300;
        r152 = r152 + 1;
    L300:
        boolean r156 = false;
    L314:
        if (r156 == false) goto L320;
        long r157 = r50.m1222getSpanRangelOCCd4c(r50.getItemProvider(), r150, 0);
        if (r225 != null) goto L318;
        r225 = new ArrayList();
    L318:
        ArrayList r158 = r225;
        LazyStaggeredGridMeasuredItem r159 = r50.getMeasuredItemProvider().m1230getAndMeasurejy6DScQ(r150, r157);
        r147 = r147 - r159.getMainAxisSizeWithSpacings();
        r159.position(r147, 0, r146);
        r158.add(r159);
        r225 = r158;
    L320:
        if (r226 < 0) goto L321;
        r148 = r512;
        r142 = r513;
        r149 = r226;
        r115 = r115;
        r12 = r12;
        goto L290
    L321:
        List r160 = r225;
    L324:
        if (r160 != null) goto L326;
        r160 = CollectionsKt.emptyList();
    L326:
        List r161 = r160;
        int r410 = r48;
        List<LazyStaggeredGridMeasuredItem> r162 = calculateVisibleItems(r50, r6, r134, r146, r114, r410);
        int r163 = r134[0];
        LazyStaggeredGridMeasuredItem r164 = (LazyStaggeredGridMeasuredItem) CollectionsKt.lastOrNull(r162);
        if (r164 == null) goto L329;
        int r165 = r164.getIndex();
    L331:
        if (r312.isLookingAhead() == true) goto L333;
    L395:
        int r166 = r513;
        int r514 = r144;
    L396:
        r133 = r133;
        int[] r227 = r132;
        ArrayList r167 = null;
    L397:
        List<Integer> r168 = r50.getPinnedItems();
        int r169 = r168.size();
        int r170 = 0;
        List r228 = null;
    L398:
        if (r170 >= r169) goto L443;
        int r171 = ((Number) ListProtector.get(r168, r170)).intValue();
        if (r171 < r121) goto L403;
        List<Integer> r515 = r168;
    L402:
        boolean r172 = false;
    L436:
        if (r172 == false) goto L442;
        long r173 = r50.m1222getSpanRangelOCCd4c(r50.getItemProvider(), r171, 0);
        if (r228 != null) goto L440;
        r228 = new ArrayList();
    L440:
        List r174 = r228;
        LazyStaggeredGridMeasuredItem r175 = r50.getMeasuredItemProvider().m1230getAndMeasurejy6DScQ(r171, r173);
        r175.position(r163, 0, r146);
        r163 = r163 + r175.getMainAxisSizeWithSpacings();
        r174.add(r175);
        r228 = r174;
    L442:
        r170 = r170 + 1;
        r168 = r515;
        r169 = r169;
        r121 = r121;
        goto L398
    L403:
        if (r167 == null) goto L417;
        int r176 = r167.size();
        int r177 = 0;
    L405:
        if (r177 >= r176) goto L413;
        r515 = r168;
        if (((LazyStaggeredGridMeasuredItem) ListProtector.get(r167, r177)).getIndex() != r171) goto L409;
        boolean r178 = true;
    L410:
        if (r178 == true) goto L411;
        r177 = r177 + 1;
        r168 = r515;
        goto L405
    L411:
        boolean r179 = true;
    L415:
        if (r179 != true) goto L418;
        boolean r180 = true;
    L419:
        if (r180 == true) goto L402;
        int r181 = r50.getLaneInfo().getLane(r171);
        if (r181 == (-2)) goto L427;
        if (r181 == (-1)) goto L427;
        if (r30[r181] >= r171) goto L402;
    L426:
        r172 = true;
    L427:
        int r182 = r30.length;
        int r183 = 0;
    L428:
        if (r183 >= r182) goto L426;
        if (r30[r183] >= r171) goto L432;
        boolean r184 = true;
    L433:
        if (r184 == false) goto L402;
        r183 = r183 + 1;
        goto L428
    L432:
        r184 = false;
    L418:
        r180 = false;
        goto L419
    L409:
        r178 = false;
        goto L410
    L413:
        r515 = r168;
        r179 = false;
        goto L415
    L417:
        r515 = r168;
        goto L418
    L443:
        int r229 = r121;
        if (r228 != null) goto L446;
        r228 = CollectionsKt.emptyList();
    L446:
        final ArrayList r185 = new ArrayList();
        r185.addAll(r161);
        r185.addAll(r162);
        if (r167 == null) goto L449;
        r185.addAll(r167);
    L449:
        r185.addAll(r228);
        float r186 = r133;
        int r314 = r166;
        int r315 = r514;
        r50.getState().getItemAnimator$foundation_release().onMeasured((int) r186, r314, r315, r185, r50.getMeasuredItemProvider().getKeyIndexMap(), r50.getMeasuredItemProvider(), r50.isVertical(), r312.isLookingAhead(), r50.getLaneCount(), r50.isInLookaheadScope(), ArraysKt.minOrThrow(r12), ArraysKt.maxOrThrow(r115) + r140, r50.getCoroutineScope(), r50.getGraphicsContext());
        if (r312.isLookingAhead() == true) goto L465;
        long r187 = r50.getState().getItemAnimator$foundation_release().m1152getMinSizeToFitDisappearingItemsYbymL2g();
        if (IntSize.equals-impl0(r187, IntSize.Companion.getZero-YbymL2g()) == true) goto L465;
        if (r50.isVertical() == false) goto L456;
        int r188 = r514;
    L457:
        r166 = ConstraintsKt.constrainWidth-K40F9xA(r50.m1219getConstraintsmsEJaDk(), Math.max(r166, (int) (r187 >> 32)));
        int r189 = ConstraintsKt.constrainHeight-K40F9xA(r50.m1219getConstraintsmsEJaDk(), Math.max(r514, (int) (r187 & 4294967295L)));
        if (r50.isVertical() == false) goto L460;
        int r190 = r189;
    L461:
        if (r190 == r188) goto L466;
        int r191 = r185.size();
        int r192 = 0;
    L463:
        if (r192 >= r191) goto L466;
        ((LazyStaggeredGridMeasuredItem) ListProtector.get(r185, r192)).updateMainAxisLayoutSize(r190);
        r192 = r192 + 1;
    L466:
        int r193 = r31;
        int r194 = 0;
    L467:
        if (r194 >= r193) goto L475;
        if (r115[r194] <= r50.getMainAxisAvailableSize()) goto L471;
        boolean r195 = true;
    L472:
        if (r195 == true) goto L473;
        r194 = r194 + 1;
        goto L467
    L473:
        boolean r196 = true;
    L476:
        if (r196 == true) goto L490;
        int r197 = r30.length;
        int r198 = 0;
    L478:
        if (r198 >= r197) goto L486;
        if (r30[r198] >= (r229 - 1)) goto L482;
        boolean r199 = true;
    L483:
        if (r199 == false) goto L484;
        r198 = r198 + 1;
        goto L478
    L484:
        boolean r200 = false;
    L487:
        if (r200 == true) goto L490;
        boolean r316 = false;
    L491:
        final LazyLayoutMeasureScope r201 = r312;
        return new LazyStaggeredGridMeasureResult(r227, r12, r186, MeasureScope.-CC.layout$default(r201, r166, r189, null, new p(r50, r185, r201), 4, null), r222, r316, r50.isVertical(), r210, r50.getResolvedSlots(), r50.getItemProvider().getSpanProvider(), r201, r229, r162, IntSize.constructor-impl((((long) r189) & 4294967295L) | (((long) r166) << 32)), r114, r410, r50.getBeforeContentPadding(), r50.getAfterContentPadding(), r50.getMainAxisSpacing(), r50.getCoroutineScope(), null);
    L482:
        r199 = false;
        goto L483
    L486:
        r200 = true;
    L490:
        r316 = true;
        goto L491
    L471:
        r195 = false;
        goto L472
    L475:
        r196 = false;
        goto L476
    L460:
        r190 = r166;
        goto L461
    L456:
        r188 = r166;
    L465:
        r189 = r514;
        goto L466
    L333:
        if (r50.getApproachLayoutInfo() == null) goto L395;
        if ((!r50.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty()) == false) goto L395;
        List<LazyStaggeredGridItemInfo> r202 = r50.getApproachLayoutInfo().getVisibleItemsInfo();
        int r203 = r202.size() - 1;
        r166 = r513;
        r514 = r144;
    L338:
        if ((-1) >= r203) goto L346;
        if (((LazyStaggeredGridItemInfo) ListProtector.get(r202, r203)).getIndex() <= r165) goto L345;
        if (r203 == 0) goto L344;
        if (((LazyStaggeredGridItemInfo) ListProtector.get(r202, r203 - 1)).getIndex() > r165) goto L345;
    L344:
        LazyStaggeredGridItemInfo r204 = (LazyStaggeredGridItemInfo) ListProtector.get(r202, r203);
    L347:
        LazyStaggeredGridItemInfo r205 = (LazyStaggeredGridItemInfo) CollectionsKt.last(r50.getApproachLayoutInfo().getVisibleItemsInfo());
        if (r204 == null) goto L394;
        int r206 = r204.getIndex();
        int r207 = Math.min(r205.getIndex(), r121 - 1);
        if (r206 > r207) goto L394;
        int r208 = r163;
        int r209 = r206;
        r167 = null;
    L352:
        if (r167 == null) goto L366;
        int r230 = r167.size();
        r227 = r132;
        int r1100 = 0;
    L354:
        if (r1100 >= r230) goto L362;
        int r516 = r230;
        if (((LazyStaggeredGridMeasuredItem) ListProtector.get(r167, r1100)).getIndex() != r209) goto L358;
        boolean r231 = true;
    L359:
        if (r231 == true) goto L360;
        r1100 = r1100 + 1;
        r230 = r516;
        goto L354
    L360:
        boolean r232 = true;
    L364:
        if (r232 != true) goto L367;
        boolean r1101 = true;
    L368:
        if (r1101 == true) goto L391;
        if (r167 != null) goto L371;
        r167 = new ArrayList();
    L371:
        List<LazyStaggeredGridItemInfo> r1102 = r50.getApproachLayoutInfo().getVisibleItemsInfo();
        int r233 = r1102.size();
        int r1103 = 0;
    L372:
        if (r1103 >= r233) goto L380;
        Object r234 = ListProtector.get(r1102, r1103);
        int r517 = r233;
        if (((LazyStaggeredGridItemInfo) r234).getIndex() != r209) goto L376;
        boolean r235 = true;
    L377:
        if (r235 == true) goto L381;
        r1103 = r1103 + 1;
        r233 = r517;
    L381:
        LazyStaggeredGridItemInfo r236 = (LazyStaggeredGridItemInfo) r234;
        if (r236 == null) goto L384;
        int r237 = r236.getLane();
    L385:
        LazyStaggeredGridMeasuredItem r1104 = r50.getMeasuredItemProvider().m1230getAndMeasurejy6DScQ(r209, r50.m1222getSpanRangelOCCd4c(r50.getItemProvider(), r209, r237));
        r167.add(r1104);
        int[] r1105 = r50.getResolvedSlots().getPositions();
        if (r1105.length <= r237) goto L388;
        int r238 = r1105[r237];
    L389:
        r1104.position(r208, r238, r146);
        r208 = r208 + r1104.getMainAxisSizeWithSpacings();
        goto L391
    L388:
        r238 = 0;
        goto L389
    L384:
        r237 = 0;
        goto L385
    L376:
        r235 = false;
        goto L377
    L380:
        r234 = null;
    L391:
        if (r209 == r207) goto L393;
        r209 = r209 + 1;
        r514 = r514;
        r133 = r133;
        r132 = r227;
        goto L352
    L393:
        r163 = r208;
    L367:
        r1101 = false;
        goto L368
    L358:
        r231 = false;
        goto L359
    L362:
        r232 = false;
        goto L364
    L366:
        r227 = r132;
    L394:
        r514 = r514;
    L345:
        r203 = r203 - 1;
        goto L338
    L346:
        r204 = null;
        goto L347
    L329:
        r165 = -1;
        goto L331
    L309:
        r155 = false;
        goto L310
    L306:
        r154 = -1;
    L313:
        r156 = true;
        goto L314
    L293:
        if (r151 == (-1)) goto L301;
        LazyStaggeredGridMeasuredItem r239 = (LazyStaggeredGridMeasuredItem) r6[r151].firstOrNull();
        if (r239 == null) goto L297;
        int r240 = r239.getIndex();
    L298:
        if (r240 <= r150) goto L300;
    L297:
        r240 = -1;
        goto L298
    L323:
        r513 = r142;
        r115 = r115;
        r12 = r12;
        r160 = null;
        goto L324
    L286:
        r145 = r142;
        goto L287
    L282:
        r143 = Constraints.getMaxHeight-impl(r50.m1219getConstraintsmsEJaDk());
        goto L283
    L278:
        r141 = ConstraintsKt.constrainWidth-K40F9xA(r50.m1219getConstraintsmsEJaDk(), ArraysKt.maxOrThrow(r115) + r140);
    L254:
        r222 = MenuKt.ClosedAlphaTarget;
        goto L255
    L245:
        if (Math.abs(Math.round(r101)) < Math.abs(r99)) goto L247;
        r133 = r99;
        goto L248
    L197:
        if (measure$lambda$49$misalignedStart(r132, r50, r12, r127) == false) goto L234;
    L186:
        if (r12[r127] != r12[r79]) goto L188;
        r127 = r79;
        goto L189
    L188:
        r76 = true;
        goto L189
    L233:
        r132 = r217;
        goto L234
    L177:
        r126 = false;
        goto L178
    L181:
        r78 = false;
        goto L182
    L241:
        r48 = r48;
        r58 = r58;
        r31 = r31;
        r215 = r215;
        r132 = r217;
        r99 = r215;
        goto L242
    L165:
        r73 = false;
        goto L166
    L169:
        r74 = true;
        goto L170
    L153:
        r70 = false;
        goto L154
    L157:
        r71 = false;
        goto L158
    L121:
        r60 = true;
    L125:
        r61 = 1;
        int r1106 = indexOfMinValue$default(r115, 0, 1, null);
        int r241 = ArraysKt.maxOrThrow(r30) + 1;
        r121 = r218;
        if (r241 >= r121) goto L127;
        int r411 = r48;
        int[] r317 = r115;
        int[] r1107 = r12;
        int r242 = r215;
        LazyLayoutMeasureScope r318 = r312;
        int[] r319 = r217;
        long r243 = r50.m1222getSpanRangelOCCd4c(r50.getItemProvider(), r241, r1106);
        LazyStaggeredGridLaneInfo r1108 = r50.getLaneInfo();
        int r1109 = (int) (r243 & 4294967295L);
        int r1110 = (int) (r243 >> 32);
        int r1111 = r1109 - r1110;
        if (r1111 == 1) goto L496;
        boolean r244 = true;
    L497:
        if (r244 == false) goto L499;
        int r1112 = -2;
    L500:
        r1108.setLane(r241, r1112);
        LazyStaggeredGridMeasuredItem r1113 = r50.getMeasuredItemProvider().m1230getAndMeasurejy6DScQ(r241, r243);
        int r245 = m1226maxInRangejy6DScQ(r317, r243);
        if (r1111 == 1) goto L503;
        boolean r1114 = true;
    L504:
        if (r1114 == false) goto L508;
        int[] r1115 = r50.getLaneInfo().getGaps(r241);
        if (r1115 != null) goto L509;
        r1115 = new int[r50.getLaneCount()];
    L509:
        int r246 = r1110;
    L510:
        if (r246 >= r1109) goto L514;
        if (r1115 == null) goto L513;
        r1115[r246] = r245 - r317[r246];
    L513:
        r30[r246] = r241;
        r317[r246] = r245 + r1113.getMainAxisSizeWithSpacings();
        r6[r246].addLast(r1113);
        r246 = r246 + 1;
        r58 = r58;
        goto L510
    L514:
        r311 = r58;
        r50.getLaneInfo().setGaps(r241, r1115);
        if (r245 >= r33) goto L519;
        if (r317[r1110] > r33) goto L519;
        r1113.setVisible(false);
    L519:
        r215 = r242;
        r115 = r317;
        r12 = r1107;
        r217 = r319;
        r218 = r121;
        r312 = r318;
        r216 = r411;
        goto L101
    L508:
        r1115 = null;
        goto L509
    L503:
        r1114 = false;
        goto L504
    L499:
        r1112 = r1110;
        goto L500
    L496:
        r244 = false;
    L108:
        r49 = true;
        goto L109
    L112:
        r48 = r216;
        r57 = false;
        goto L113
    L57:
        if (measure$lambda$49$misalignedStart(r13, r50, r12, r8) == false) goto L67;
        if (r54 == false) goto L67;
        r50.getLaneInfo().reset();
        int r247 = r13.length;
        int[] r248 = new int[r247];
        int r249 = 0;
    L60:
        if (r249 >= r247) goto L62;
        r248[r249] = r29;
        r249 = r249 + 1;
        r29 = -1;
        goto L60
    L62:
        int r250 = r12.length;
        int[] r251 = new int[r250];
        int r252 = 0;
    L63:
        if (r252 >= r250) goto L66;
        r251[r252] = r12[r8];
        r252 = r252 + 1;
        goto L63
    L66:
        return measure(r50, r0, r248, r251, false);
    L48:
        r8 = -1;
        goto L49
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext r9, ArrayDeque<LazyStaggeredGridMeasuredItem>[] r10, int[] r11, int r12, int r13, int r14) {
        int r0 = r10.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r10[r2].size();
        r2 = r2 + 1;
        goto L3
    L5:
        ArrayList r1 = new ArrayList(r3);
    L6:
        int r4 = r10.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L12;
        boolean r6 = true;
        if ((!r10[r5].isEmpty()) == true) goto L13;
        r5 = r5 + 1;
    L13:
        if (r6 == false) goto L33;
        int r7 = r10.length;
        int r8 = -1;
        int r15 = 0;
        int r16 = Integer.MAX_VALUE;
    L15:
        if (r15 >= r7) goto L23;
        LazyStaggeredGridMeasuredItem r17 = (LazyStaggeredGridMeasuredItem) r10[r15].firstOrNull();
        if (r17 == null) goto L19;
        int r18 = r17.getIndex();
    L20:
        if (r16 <= r18) goto L22;
        r8 = r15;
        r16 = r18;
    L22:
        r15 = r15 + 1;
        goto L15
    L19:
        r18 = Integer.MAX_VALUE;
        goto L20
    L23:
        LazyStaggeredGridMeasuredItem r19 = (LazyStaggeredGridMeasuredItem) r10[r8].removeFirst();
        if (r19.getLane() != r8) goto L6;
        long r20 = SpanRange.m1236constructorimpl(r19.getLane(), r19.getSpan());
        int r21 = m1226maxInRangejy6DScQ(r11, r20);
        int r22 = r9.getResolvedSlots().getPositions()[r8];
        if ((r19.getMainAxisSize() + r21) < r13) goto L30;
        if (r21 > r14) goto L30;
        r19.position(r21, r22, r12);
        r1.add(r19);
    L30:
        int r23 = (int) (r20 >> 32);
        int r24 = (int) (r20 & 4294967295L);
    L31:
        if (r23 >= r24) goto L6;
        r11[r23] = r19.getMainAxisSizeWithSpacings() + r21;
        r23 = r23 + 1;
        goto L31
    L33:
        return r1;
    L12:
        r6 = false;
        goto L13
    }

    /* JADX INFO: renamed from: measureStaggeredGrid-C6celF4, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m1227measureStaggeredGridC6celF4(LazyLayoutMeasureScope r22, LazyStaggeredGridState r23, List<Integer> r24, LazyStaggeredGridItemProvider r25, LazyStaggeredGridSlots r26, long r27, boolean r29, boolean r30, long r31, int r33, int r34, int r35, int r36, CoroutineScope r37, boolean r38, boolean r39, LazyStaggeredGridLayoutInfo r40, GraphicsContext r41) {
        LazyStaggeredGridMeasureContext r1 = new LazyStaggeredGridMeasureContext(r23, r24, r25, r26, r27, r29, r22, r33, r31, r35, r36, r30, r34, r37, r38, r39, r40, r41, null);
        int[] r0 = r23.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(r25, r23.getScrollPosition$foundation_release().getIndices());
        int[] r2 = r23.getScrollPosition$foundation_release().getScrollOffsets();
        if (r0.length == r1.getLaneCount()) goto L18;
        r1.getLaneInfo().reset();
        int r3 = r1.getLaneCount();
        int[] r4 = new int[r3];
        int r7 = 0;
    L6:
        if (r7 >= r3) goto L16;
        if (r7 >= r0.length) goto L12;
        int r8 = r0[r7];
        if (r8 == (-1)) goto L12;
    L15:
        r4[r7] = r8;
        r1.getLaneInfo().setLane(r4[r7], r7);
        r7 = r7 + 1;
    L12:
        if (r7 != 0) goto L14;
        r8 = 0;
        goto L15
    L14:
        r8 = m1226maxInRangejy6DScQ(r4, SpanRange.m1236constructorimpl(0, r7)) + 1;
        goto L15
    L16:
        r0 = r4;
    L18:
        if (r2.length == r1.getLaneCount()) goto L31;
        int r5 = r1.getLaneCount();
        int[] r6 = new int[r5];
        int r9 = 0;
    L21:
        if (r9 >= r5) goto L29;
        if (r9 >= r2.length) goto L25;
        int r10 = r2[r9];
    L28:
        r6[r9] = r10;
        r9 = r9 + 1;
        goto L21
    L25:
        if (r9 != 0) goto L27;
        r10 = 0;
        goto L28
    L27:
        r10 = r6[r9 - 1];
        goto L28
    L29:
        r2 = r6;
    L31:
        return measure(r1, Math.round(r23.scrollToBeConsumed$foundation_release(r39)), r0, r2, true);
    }
}
