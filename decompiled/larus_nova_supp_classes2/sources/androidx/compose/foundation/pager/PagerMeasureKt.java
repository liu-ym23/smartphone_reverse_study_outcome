package androidx.compose.foundation.pager;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0082\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2/\u0010#\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(\u0012\u0004\u0012\u00020)0$2\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001c0+H\u0000¢\u0006\u0004\b-\u0010.\u001aH\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001c2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002000%H\u0002\u001a@\u00104\u001a\b\u0012\u0004\u0012\u0002000\u001c2\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002000%H\u0002\u001aH\u00106\u001a\u0004\u0018\u0001002\u0006\u00107\u001a\u00020\u00042\f\u00108\u001a\b\u0012\u0004\u0012\u0002000\u001c2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a{\u00103\u001a\u000200*\u00020\u00022\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00042\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001c0+H\u0002¢\u0006\u0004\b>\u0010?\u001a\u008c\u0001\u0010@\u001a\b\u0012\u0004\u0012\u0002000A*\u00020\u00022\f\u0010B\u001a\b\u0012\u0004\u0012\u0002000\u001c2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002000\u001c2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002000\u001c2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010J\u001a\u00020K2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002\u001a\u0017\u0010O\u001a\u00020'2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020R0QH\u0082\b\"\u000e\u0010L\u001a\u00020MX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010N\u001a\u00020MX\u0080T¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pageCount", "", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenPages", "currentPage", "currentPageOffset", "constraints", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "reverseLayout", "", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "pageAvailableSize", "beyondViewportPageCount", "pinnedPages", "", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "placeablesCache", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/layout/Placeable;", "measurePager-BiYVr7A", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;Landroidx/collection/MutableIntObjectMap;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "createPagesAfterList", "Landroidx/compose/foundation/pager/MeasuredPage;", "currentLastPage", "pagesCount", "getAndMeasure", "createPagesBeforeList", "currentFirstPage", "calculateNewCurrentPage", "viewportSize", "visiblePagesInfo", "itemSize", "index", "childConstraints", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-G5IdpRk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZILandroidx/collection/MutableIntObjectMap;)Landroidx/compose/foundation/pager/MeasuredPage;", "calculatePagesOffsets", "", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "density", "Landroidx/compose/ui/unit/Density;", "MinPageOffset", "", "MaxPageOffset", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    public static /* synthetic */ Unit a(MutableState r0, List r1, Placeable.PlacementScope r2) {
        return measurePager_BiYVr7A$lambda$20(r0, r1, r2);
    }

    public static /* synthetic */ Unit b(Placeable.PlacementScope r0) {
        return measurePager_BiYVr7A$lambda$3(r0);
    }

    public static /* synthetic */ Unit c(List r0, Placeable.PlacementScope r1) {
        return measurePager_BiYVr7A$lambda$20$lambda$19(r0, r1);
    }

    private static final int calculatePagesOffsets$reverseAware(int r0, boolean r1, int r2) {
        if (r1 == true) goto L5;
        return r0;
    L5:
        return (r2 - r0) - 1;
    }

    public static /* synthetic */ MeasuredPage d(LazyLayoutMeasureScope r0, long r1, PagerLazyLayoutItemProvider r3, long r4, Orientation r6, Alignment.Horizontal r7, Alignment.Vertical r8, boolean r9, int r10, MutableIntObjectMap r11, int r12) {
        return measurePager_BiYVr7A$lambda$12(r0, r1, r3, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    private static final void debugLog(Function0<String> r0) {
    }

    public static /* synthetic */ MeasuredPage e(LazyLayoutMeasureScope r0, long r1, PagerLazyLayoutItemProvider r3, long r4, Orientation r6, Alignment.Horizontal r7, Alignment.Vertical r8, boolean r9, int r10, MutableIntObjectMap r11, int r12) {
        return measurePager_BiYVr7A$lambda$10(r0, r1, r3, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    private static final Unit measurePager_BiYVr7A$lambda$3(Placeable.PlacementScope r0) {
        return Unit.INSTANCE;
    }

    private static final Unit measurePager_BiYVr7A$lambda$20$lambda$19(List r3, Placeable.PlacementScope r4) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        ((MeasuredPage) ListProtector.get(r3, r1)).place(r4);
        r1 = r1 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit measurePager_BiYVr7A$lambda$20(MutableState r1, final List r2, Placeable.PlacementScope r3) {
        r3.withMotionFrameOfReferencePlacement(new y(r2));
        ObservableScopeInvalidator.m1184attachToScopeimpl(r1);
        return Unit.INSTANCE;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int r3, int r4, List<Integer> r5, Function1<? super Integer, MeasuredPage> r6) {
        int r0 = 0;
        int r7 = Math.max(0, r3 - r4);
        int r8 = r3 - 1;
        ArrayList r1 = null;
        if (r7 > r8) goto L9;
    L4:
        if (r1 != null) goto L6;
        r1 = new ArrayList();
    L6:
        r1.add(r6.invoke(Integer.valueOf(r8)));
        if (r8 == r7) goto L9;
        r8 = r8 - 1;
    L9:
        int r9 = r5.size();
    L10:
        if (r0 >= r9) goto L17;
        int r2 = ((Number) ListProtector.get(r5, r0)).intValue();
        if (r2 >= r7) goto L16;
        if (r1 != null) goto L15;
        r1 = new ArrayList();
    L15:
        r1.add(r6.invoke(Integer.valueOf(r2)));
    L16:
        r0 = r0 + 1;
        goto L10
    L17:
        if (r1 == null) goto L19;
        return r1;
    L19:
        return CollectionsKt.emptyList();
    }

    private static final List<MeasuredPage> createPagesAfterList(int r6, int r7, int r8, List<Integer> r9, Function1<? super Integer, MeasuredPage> r10) {
        int r11 = Math.min(r8, (r7 - r6) - 1) + r6;
        int r12 = r6 + 1;
        ArrayList r0 = null;
        if (r12 > r11) goto L9;
    L4:
        if (r0 != null) goto L6;
        r0 = new ArrayList();
    L6:
        r0.add(r10.invoke(Integer.valueOf(r12)));
        if (r12 == r11) goto L9;
        r12 = r12 + 1;
    L9:
        int r13 = r9.size();
        int r3 = 0;
    L10:
        if (r3 >= r13) goto L21;
        int r4 = ((Number) ListProtector.get(r9, r3)).intValue();
        if ((r11 + 1) > r4) goto L15;
        if (r4 >= r7) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == false) goto L20;
        if (r0 != null) goto L19;
        r0 = new ArrayList();
    L19:
        r0.add(r10.invoke(Integer.valueOf(r4)));
    L20:
        r3 = r3 + 1;
    L15:
        r5 = false;
        goto L16
    L21:
        if (r0 == null) goto L23;
        return r0;
    L23:
        return CollectionsKt.emptyList();
    }

    private static final MeasuredPage calculateNewCurrentPage(int r15, List<MeasuredPage> r16, int r17, int r18, int r19, SnapPosition r20, int r21) {
        if (r16.isEmpty() == false) goto L5;
        Object r0 = null;
    L14:
        return (MeasuredPage) r0;
    L5:
        Object r1 = ListProtector.get(r16, 0);
        MeasuredPage r2 = (MeasuredPage) r1;
        float r3 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(r15, r17, r18, r19, r2.getOffset(), r2.getIndex(), r20, r21));
        int r4 = CollectionsKt.getLastIndex(r16);
        int r5 = 1;
        if (1 > r4) goto L12;
    L7:
        Object r6 = ListProtector.get(r16, r5);
        MeasuredPage r7 = (MeasuredPage) r6;
        float r8 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(r15, r17, r18, r19, r7.getOffset(), r7.getIndex(), r20, r21));
        if (Float.compare(r3, r8) >= 0) goto L10;
        r1 = r6;
        r3 = r8;
    L10:
        if (r5 == r4) goto L12;
        r5 = r5 + 1;
    L12:
        r0 = r1;
        goto L14
    }

    private static final MeasuredPage measurePager_BiYVr7A$lambda$10(LazyLayoutMeasureScope r14, long r15, PagerLazyLayoutItemProvider r17, long r18, Orientation r20, Alignment.Horizontal r21, Alignment.Vertical r22, boolean r23, int r24, MutableIntObjectMap r25, int r26) {
        return m1262getAndMeasureG5IdpRk(r14, r26, r15, r17, r18, r20, r21, r22, r14.getLayoutDirection(), r23, r24, r25);
    }

    private static final MeasuredPage measurePager_BiYVr7A$lambda$12(LazyLayoutMeasureScope r14, long r15, PagerLazyLayoutItemProvider r17, long r18, Orientation r20, Alignment.Horizontal r21, Alignment.Vertical r22, boolean r23, int r24, MutableIntObjectMap r25, int r26) {
        return m1262getAndMeasureG5IdpRk(r14, r26, r15, r17, r18, r20, r21, r22, r14.getLayoutDirection(), r23, r24, r25);
    }

    /* JADX INFO: renamed from: getAndMeasure-G5IdpRk, reason: not valid java name */
    private static final MeasuredPage m1262getAndMeasureG5IdpRk(LazyLayoutMeasureScope r14, int r15, long r16, PagerLazyLayoutItemProvider r18, long r19, Orientation r21, Alignment.Horizontal r22, Alignment.Vertical r23, LayoutDirection r24, boolean r25, int r26, MutableIntObjectMap<List<Placeable>> r27) {
        Object r6 = r18.getKey(r15);
        List<Placeable> r0 = r27.get(r15);
        if (r0 == null) goto L5;
        List<Placeable> r3 = r0;
    L10:
        return new MeasuredPage(r15, r26, r3, r19, r6, r21, r22, r23, r24, r25, null);
    L5:
        List<Measurable> r1 = r14.compose(r15);
        int r4 = r1.size();
        ArrayList r5 = new ArrayList(r4);
        int r7 = 0;
    L6:
        if (r7 >= r4) goto L8;
        r5.add(((Measurable) ListProtector.get(r1, r7)).measure-BRTryo0(r16));
        r7 = r7 + 1;
        goto L6
    L8:
        r27.set(r15, r5);
        r3 = r5;
        goto L10
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope r17, List<MeasuredPage> r18, List<MeasuredPage> r19, List<MeasuredPage> r20, int r21, int r22, int r23, int r24, int r25, Orientation r26, boolean r27, Density r28, int r29, int r30) {
        int r5 = r25;
        int r9 = r30 + r29;
        if (r26 != Orientation.Vertical) goto L5;
        int r15 = r22;
    L6:
        boolean r11 = true;
        int r12 = 0;
        if (r23 >= Math.min(r15, r24)) goto L9;
        boolean r10 = true;
    L10:
        if (r10 == false) goto L16;
        if (r5 != 0) goto L13;
        boolean r13 = true;
    L14:
        if (r13 == true) goto L16;
        InlineClassHelperKt.throwIllegalStateException("non-zero pagesScrollOffset=" + r5);
        goto L16
    L13:
        r13 = false;
    L16:
        ArrayList r14 = new ArrayList((r18.size() + r19.size()) + r20.size());
        if (r10 == true) goto L19;
        r14 = r14;
        int r6 = r19.size();
        int r16 = r5;
        int r7 = 0;
    L49:
        if (r7 >= r6) goto L51;
        MeasuredPage r110 = (MeasuredPage) ListProtector.get(r19, r7);
        r16 = r16 - r9;
        r110.position(r16, r21, r22);
        r14.add(r110);
        r7 = r7 + 1;
        goto L49
    L51:
        int r1 = r18.size();
        int r8 = 0;
    L52:
        if (r8 >= r1) goto L54;
        MeasuredPage r31 = (MeasuredPage) ListProtector.get(r18, r8);
        r31.position(r5, r21, r22);
        r14.add(r31);
        r5 = r5 + r9;
        r8 = r8 + 1;
        goto L52
    L54:
        int r0 = r20.size();
    L55:
        if (r12 >= r0) goto L57;
        MeasuredPage r2 = (MeasuredPage) ListProtector.get(r20, r12);
        r2.position(r5, r21, r22);
        r14.add(r2);
        r5 = r5 + r9;
        r12 = r12 + 1;
    L57:
        return r14;
    L19:
        if (r19.isEmpty() == true) goto L21;
    L23:
        r11 = false;
    L24:
        if (r11 == true) goto L26;
        InlineClassHelperKt.throwIllegalArgumentException("No extra pages");
    L26:
        int r3 = r18.size();
        int[] r111 = new int[r3];
    L27:
        if (r12 >= r3) goto L29;
        r111[r12] = r30;
        r12 = r12 + 1;
        goto L27
    L29:
        int[] r4 = new int[r3];
        Arrangement.HorizontalOrVertical r112 = Arrangement.Absolute.INSTANCE.m809spacedBy0680j_4(r17.toDp-u2uoSUM(r29));
        if (r26 != Orientation.Vertical) goto L32;
        r112.arrange(r28, r15, r111, r4);
    L33:
        IntProgression r32 = ArraysKt.getIndices(r4);
        if (r27 == false) goto L37;
        r32 = RangesKt.reversed(r32);
    L37:
        int r33 = r32.getFirst();
        int r113 = r32.getLast();
        int r34 = r32.getStep();
        if (r34 <= 0) goto L40;
        if (r33 > r113) goto L40;
    L42:
        int r114 = r4[r33];
        MeasuredPage r115 = (MeasuredPage) ListProtector.get(r18, calculatePagesOffsets$reverseAware(r33, r27, r3));
        if (r27 == false) goto L45;
        r114 = (r15 - r114) - r115.getSize();
    L45:
        r115.position(r114, r21, r22);
        r14.add(r115);
        if (r33 == r113) goto L57;
        r33 = r33 + r34;
    L40:
        if (r34 >= 0) goto L57;
        if (r113 > r33) goto L57;
    L32:
        r112.arrange(r28, r15, r111, LayoutDirection.Ltr, r4);
        goto L33
    L21:
        if (r20.isEmpty() == false) goto L23;
    L9:
        r10 = false;
        goto L10
    L5:
        r15 = r21;
        goto L6
    }

    /* JADX INFO: renamed from: measurePager-BiYVr7A, reason: not valid java name */
    public static final PagerMeasureResult m1263measurePagerBiYVr7A(final LazyLayoutMeasureScope r33, int r34, final PagerLazyLayoutItemProvider r35, int r36, int r37, int r38, int r39, int r40, int r41, long r42, final Orientation r44, final Alignment.Vertical r45, final Alignment.Horizontal r46, final boolean r47, final long r48, final int r50, int r51, List<Integer> r52, SnapPosition r53, final MutableState<Unit> r54, CoroutineScope r55, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> r56, final MutableIntObjectMap<List<Placeable>> r57) {
        if (r37 < 0) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
    L8:
        if (r38 < 0) goto L10;
        boolean r9 = true;
    L11:
        if (r9 == true) goto L13;
        InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
    L13:
        int r13 = RangesKt.coerceAtLeast(r50 + r39, 0);
        int r12 = RangesKt.coerceAtMost(r51, r34);
        if (r34 <= 0) goto L16;
        int r14 = r12;
        Orientation r10 = Orientation.Vertical;
        if (r44 != r10) goto L20;
        int r17 = Constraints.getMaxWidth-impl(r42);
    L22:
        if (r44 == r10) goto L24;
        int r19 = Constraints.getMaxHeight-impl(r42);
    L25:
        final long r23 = ConstraintsKt.Constraints$default(0, r17, 0, r19, 5, null);
        int r11 = r40;
        int r15 = r41;
    L26:
        if (r11 <= 0) goto L29;
        if (r15 <= 0) goto L29;
        r11 = r11 - 1;
        r15 = r15 - r13;
    L29:
        int r16 = r15 * (-1);
        if (r11 < r34) goto L32;
        r11 = r34 - 1;
        r16 = 0;
    L32:
        ArrayDeque r18 = new ArrayDeque();
        int r110 = -r37;
        if (r39 >= 0) goto L35;
        int r111 = r39;
    L36:
        int r112 = r111 + r110;
        int r20 = r16 + r112;
        int r3 = 0;
    L37:
        if (r20 >= 0) goto L40;
        if (r11 <= 0) goto L40;
        int r25 = r11 - 1;
        ArrayDeque r4 = r18;
        int r2 = r13;
        MeasuredPage r21 = m1262getAndMeasureG5IdpRk(r33, r25, r23, r35, r48, r44, r46, r45, r33.getLayoutDirection(), r47, r50, r57);
        r4.add(0, r21);
        r3 = Math.max(r3, r21.getCrossAxisSize());
        r20 = r20 + r2;
        r112 = r112;
        r13 = r2;
        r18 = r4;
        r11 = r25;
        r110 = r110;
        r14 = r14;
    L40:
        int r0 = r20;
        int r26 = r110;
        int r1 = r112;
        ArrayDeque r5 = r18;
        int r6 = r13;
        int r30 = r14;
        if (r0 >= r1) goto L43;
        int r113 = r1;
    L44:
        int r114 = r113 - r1;
        int r7 = r36 + r38;
        int r115 = RangesKt.coerceAtLeast(r7, 0);
        int r22 = -r114;
        int r116 = r11;
        int r117 = 0;
        boolean r118 = false;
    L46:
        if (r117 >= r5.size()) goto L50;
        if (r22 >= r115) goto L48;
        r116 = r116 + 1;
        r22 = r22 + r6;
        r117 = r117 + 1;
        goto L46
    L48:
        r5.remove(r117);
        Unit r119 = Unit.INSTANCE;
        r118 = true;
        goto L46
    L50:
        int r27 = r11;
        int r28 = r114;
        boolean r29 = r118;
        int r120 = r116;
        int r121 = r22;
    L51:
        if (r120 >= r34) goto L66;
        if (r121 < r115) goto L56;
        if (r121 <= 0) goto L56;
        if (r5.isEmpty() == false) goto L66;
    L56:
        int r43 = r7;
        int r24 = r121;
        int r31 = r120;
        int r32 = r115;
        MeasuredPage r49 = m1262getAndMeasureG5IdpRk(r33, r120, r23, r35, r48, r44, r46, r45, r33.getLayoutDirection(), r47, r50, r57);
        int r58 = r34 - 1;
        if (r31 != r58) goto L59;
        int r122 = r50;
    L60:
        r121 = r122 + r24;
        if (r121 > r1) goto L64;
        if (r31 == r58) goto L64;
        r28 = r28 - r6;
        Unit r59 = Unit.INSTANCE;
        r27 = r31 + 1;
        r29 = true;
    L65:
        r120 = r31 + 1;
        r7 = r43;
        r115 = r32;
    L64:
        r3 = Math.max(r3, r49.getCrossAxisSize());
        r5.add(r49);
        goto L65
    L59:
        r122 = r6;
    L66:
        int r410 = r7;
        int r60 = r121;
        int r61 = r120;
        if (r60 >= r36) goto L77;
        int r62 = r36 - r60;
        int r210 = r28 - r62;
        int r63 = r62 + r60;
        int r64 = r210;
    L70:
        if (r64 >= r37) goto L73;
        if (r27 <= 0) goto L73;
        r27 = r27 - 1;
        MeasuredPage r65 = m1262getAndMeasureG5IdpRk(r33, r27, r23, r35, r48, r44, r46, r45, r33.getLayoutDirection(), r47, r50, r57);
        r5.add(0, r65);
        r3 = Math.max(r3, r65.getCrossAxisSize());
        r64 = r64 + r6;
        r61 = r61;
    L73:
        int r211 = r61;
        if (r64 >= 0) goto L76;
        r60 = r63 + r64;
        int r66 = r27;
        int r123 = 0;
    L78:
        if (r123 < 0) goto L80;
        boolean r67 = true;
    L81:
        if (r67 == true) goto L83;
        InlineClassHelperKt.throwIllegalArgumentException("invalid currentFirstPageScrollOffset");
    L83:
        int r124 = -r123;
        MeasuredPage r68 = (MeasuredPage) r5.first();
        if (r37 > 0) goto L88;
        if (r39 < 0) goto L88;
        int r212 = r123;
        MeasuredPage r125 = r68;
    L96:
        int r411 = r3;
        MeasuredPage r69 = r125;
        List<MeasuredPage> r70 = createPagesBeforeList(r66, r30, r52, new v(r33, r23, r35, r48, r44, r46, r45, r47, r50, r57));
        int r71 = r70.size();
        int r126 = r411;
        int r72 = 0;
    L97:
        if (r72 >= r71) goto L99;
        r126 = Math.max(r126, ((MeasuredPage) ListProtector.get(r70, r72)).getCrossAxisSize());
        r72 = r72 + 1;
        goto L97
    L99:
        int r412 = r60;
        List<MeasuredPage> r73 = createPagesAfterList(((MeasuredPage) r5.last()).getIndex(), r34, r30, r52, new w(r33, r23, r35, r48, r44, r46, r45, r47, r50, r57));
        int r74 = r73.size();
        int r127 = r126;
        int r128 = 0;
    L100:
        if (r128 >= r74) goto L103;
        r127 = Math.max(r127, ((MeasuredPage) ListProtector.get(r73, r128)).getCrossAxisSize());
        r128 = r128 + 1;
        goto L100
    L103:
        if (Intrinsics.areEqual(r69, r5.first()) == true) goto L105;
    L109:
        boolean r75 = false;
    L110:
        Orientation r76 = Orientation.Vertical;
        if (r44 != r76) goto L113;
        int r129 = r127;
    L114:
        int r213 = ConstraintsKt.constrainWidth-K40F9xA(r42, r129);
        if (r44 != r76) goto L117;
        r127 = r412;
    L117:
        int r310 = ConstraintsKt.constrainHeight-K40F9xA(r42, r127);
        final List<MeasuredPage> r77 = calculatePagesOffsets(r33, r5, r70, r73, r213, r310, r412, r36, r124, r44, r47, r33, r39, r50);
        if (r75 == false) goto L120;
        List r78 = r77;
    L133:
        if (r70.isEmpty() == false) goto L136;
        List r79 = CollectionsKt.emptyList();
    L135:
        List r130 = r79;
        if (r73.isEmpty() == false) goto L149;
        List r80 = CollectionsKt.emptyList();
    L148:
        List r131 = r80;
        int r132 = (r36 + r37) + r38;
        int r133 = r211;
        MeasuredPage r134 = calculateNewCurrentPage(r132, r78, r37, r38, r50, r53, r34);
        if (r134 == null) goto L161;
        int r81 = r134.getIndex();
    L162:
        int r82 = r53.position(r132, r50, r37, r38, r81, r34);
        if (r134 == null) goto L165;
        int r83 = r134.getOffset();
    L166:
        if (r32 != 0) goto L168;
        float r214 = MenuKt.ClosedAlphaTarget;
    L169:
        MeasureResult r215 = (MeasureResult) r56.invoke(Integer.valueOf(r213), Integer.valueOf(r310), new x(r54, r77));
        if (r133 < r34) goto L174;
        if (r412 > r36) goto L174;
        boolean r135 = false;
    L176:
        return new PagerMeasureResult(r78, r50, r39, r38, r44, r26, r410, r47, r30, r69, r134, r214, r212, r135, r53, r215, r29, r130, r131, r55);
    L174:
        r135 = true;
        goto L176
    L168:
        r214 = RangesKt.coerceIn((r82 - r83) / r6, -0.5f, 0.5f);
        goto L169
    L165:
        r83 = 0;
        goto L166
    L161:
        r81 = 0;
        goto L162
    L149:
        r80 = new ArrayList(r77.size());
        int r84 = r77.size();
        int r136 = 0;
    L150:
        if (r136 >= r84) goto L148;
        Object r85 = ListProtector.get(r77, r136);
        if (((MeasuredPage) r85).getIndex() <= ((MeasuredPage) r5.last()).getIndex()) goto L154;
        boolean r86 = true;
    L155:
        if (r86 == false) goto L157;
        r80.add(r85);
    L157:
        r136 = r136 + 1;
        goto L150
    L154:
        r86 = false;
        goto L155
    L136:
        r79 = new ArrayList(r77.size());
        int r87 = r77.size();
        int r137 = 0;
    L137:
        if (r137 >= r87) goto L135;
        Object r88 = ListProtector.get(r77, r137);
        if (((MeasuredPage) r88).getIndex() >= ((MeasuredPage) r5.first()).getIndex()) goto L141;
        boolean r138 = true;
    L142:
        if (r138 == false) goto L144;
        r79.add(r88);
    L144:
        r137 = r137 + 1;
        goto L137
    L141:
        r138 = false;
        goto L142
    L120:
        ArrayList r89 = new ArrayList(r77.size());
        int r90 = r77.size();
        int r139 = 0;
    L121:
        if (r139 >= r90) goto L131;
        Object r91 = ListProtector.get(r77, r139);
        MeasuredPage r140 = (MeasuredPage) r91;
        if (r140.getIndex() >= ((MeasuredPage) r5.first()).getIndex()) goto L125;
    L127:
        boolean r141 = false;
    L128:
        if (r141 == false) goto L130;
        r89.add(r91);
    L130:
        r139 = r139 + 1;
        goto L121
    L125:
        if (r140.getIndex() > ((MeasuredPage) r5.last()).getIndex()) goto L127;
        r141 = true;
        goto L128
    L131:
        r78 = r89;
        goto L133
    L113:
        r129 = r412;
        goto L114
    L105:
        if (r70.isEmpty() == false) goto L109;
        if (r73.isEmpty() == false) goto L109;
        r75 = true;
    L88:
        int r92 = r5.size();
        int r142 = r123;
        int r143 = 0;
    L89:
        if (r143 >= r92) goto L95;
        if (r142 == 0) goto L95;
        if (r6 > r142) goto L95;
        if (r143 == CollectionsKt.getLastIndex(r5)) goto L95;
        r142 = r142 - r6;
        r143 = r143 + 1;
        r68 = (MeasuredPage) r5.get(r143);
    L95:
        r125 = r68;
        r212 = r142;
        goto L96
    L80:
        r67 = false;
        goto L81
    L76:
        r123 = r64;
        r60 = r63;
        r66 = r27;
        goto L78
    L77:
        r211 = r61;
        r66 = r27;
        r123 = r28;
        goto L78
    L43:
        r113 = r0;
        goto L44
    L35:
        r111 = 0;
        goto L36
    L24:
        r19 = r50;
        goto L25
    L20:
        r17 = r50;
        goto L22
    L16:
        return new PagerMeasureResult(CollectionsKt.emptyList(), r50, r39, r38, r44, -r37, r36 + r38, false, r12, null, null, MenuKt.ClosedAlphaTarget, 0, false, r53, (MeasureResult) r56.invoke(Integer.valueOf(Constraints.getMinWidth-impl(r42)), Integer.valueOf(Constraints.getMinHeight-impl(r42)), new u()), false, null, null, r55, 393216, null);
    L10:
        r9 = false;
        goto L11
    L5:
        r8 = false;
        goto L6
    }
}
