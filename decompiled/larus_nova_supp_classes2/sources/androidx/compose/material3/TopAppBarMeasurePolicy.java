package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.ListUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\"\u0010#\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010&\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010'\u001a\u00020\tH\u0016J\"\u0010(\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010)\u001a\u00020\t*\u00020$2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020%0\u001d2\u0006\u0010'\u001a\u00020\tH\u0016JK\u0010*\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\tH\u0002¢\u0006\u0004\b2\u00103R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u00020\u000b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u00064"}, d2 = {"Landroidx/compose/material3/TopAppBarMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "scrolledOffset", "Landroidx/compose/material3/internal/FloatProducer;", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "titleBottomPadding", "", "height", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Landroidx/compose/material3/internal/FloatProducer;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;IFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getScrolledOffset", "()Landroidx/compose/material3/internal/FloatProducer;", "getTitleVerticalArrangement", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTitleHorizontalAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "getTitleBottomPadding", "()I", "getHeight-D9Ej5fM", "()F", "F", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "placeTopAppBar", "layoutHeight", "maxLayoutHeight", "navigationIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "titlePlaceable", "actionIconsPlaceable", "titleBaseline", "placeTopAppBar-mpW86Vk", "(Landroidx/compose/ui/layout/MeasureScope;JIILandroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;I)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class TopAppBarMeasurePolicy implements MeasurePolicy {
    private final float height;
    private final FloatProducer scrolledOffset;
    private final int titleBottomPadding;
    private final Alignment.Horizontal titleHorizontalAlignment;
    private final Arrangement.Vertical titleVerticalArrangement;

    public /* synthetic */ TopAppBarMeasurePolicy(FloatProducer r1, Arrangement.Vertical r2, Alignment.Horizontal r3, int r4, float r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit a(Placeable r0, int r1, Placeable r2, Placeable r3, long r4, MeasureScope r6, TopAppBarMeasurePolicy r7, int r8, int r9, Placeable.PlacementScope r10) {
        return placeTopAppBar_mpW86Vk$lambda$8(r0, r1, r2, r3, r4, r6, r7, r8, r9, r10);
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public final float m3592getHeightD9Ej5fM() {
        return this.height;
    }

    public final FloatProducer getScrolledOffset() {
        return this.scrolledOffset;
    }

    public final int getTitleBottomPadding() {
        return this.titleBottomPadding;
    }

    public final Alignment.Horizontal getTitleHorizontalAlignment() {
        return this.titleHorizontalAlignment;
    }

    public final Arrangement.Vertical getTitleVerticalArrangement() {
        return this.titleVerticalArrangement;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r7, List<? extends IntrinsicMeasurable> r8, int r9) {
        int r10 = r7.roundToPx-0680j_4(this.height);
        int r1 = 0;
        if (r8.isEmpty() == false) goto L5;
        Integer r11 = null;
    L13:
        Integer r12 = r11;
        if (r12 == null) goto L17;
        r1 = r12.intValue();
    L17:
        return Math.max(r10, r1);
    L5:
        Integer r0 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r8, 0)).maxIntrinsicHeight(r9));
        int r2 = CollectionsKt.getLastIndex(r8);
        int r3 = 1;
        if (1 > r2) goto L12;
    L7:
        Integer r4 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r8, r3)).maxIntrinsicHeight(r9));
        if (r4.compareTo(r0) <= 0) goto L10;
        r0 = r4;
    L10:
        if (r3 == r2) goto L12;
        r3 = r3 + 1;
    L12:
        r11 = r0;
        goto L13
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope r4, List<? extends IntrinsicMeasurable> r5, int r6) {
        int r7 = r5.size();
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r7) goto L5;
        r1 = r1 + ((IntrinsicMeasurable) ListProtector.get(r5, r0)).maxIntrinsicWidth(r6);
        r0 = r0 + 1;
        goto L3
    L5:
        return r1;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m3593measure3p2s80s(MeasureScope r20, List<? extends Measurable> r21, long r22) {
        List<? extends Measurable> r1 = r21;
        int r2 = r1.size();
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L40;
        Measurable r6 = (Measurable) ListProtector.get(r21, r4);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r6), "navigationIcon") == true) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        Placeable r7 = r6.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r22, 0, 0, 0, 0, 14, null));
        int r3 = r1.size();
        int r5 = 0;
    L8:
        if (r5 >= r3) goto L37;
        Measurable r8 = (Measurable) ListProtector.get(r21, r5);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r8), "actionIcons") == true) goto L11;
        r5 = r5 + 1;
        goto L8
    L11:
        Placeable r9 = r8.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r22, 0, 0, 0, 0, 14, null));
        if (Constraints.getMaxWidth-impl(r22) != Integer.MAX_VALUE) goto L14;
        int r10 = Constraints.getMaxWidth-impl(r22);
    L15:
        int r14 = r10;
        int r11 = r1.size();
        int r12 = 0;
    L16:
        if (r12 >= r11) goto L34;
        Measurable r13 = (Measurable) ListProtector.get(r21, r12);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r13), "title") == true) goto L19;
        r12 = r12 + 1;
        goto L16
    L19:
        Placeable r15 = r13.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r22, 0, r14, 0, 0, 12, null));
        if (r15.get(AlignmentLineKt.getLastBaseline()) == Integer.MIN_VALUE) goto L22;
        int r16 = r15.get(AlignmentLineKt.getLastBaseline());
    L23:
        float r0 = this.scrolledOffset.invoke();
        if (Float.isNaN(r0) == false) goto L26;
        int r17 = 0;
    L27:
        int r18 = Math.max(r20.roundToPx-0680j_4(this.height), r15.getHeight());
        if (Constraints.getMaxHeight-impl(r22) != Integer.MAX_VALUE) goto L30;
        int r19 = r18;
    L32:
        return m3591placeTopAppBarmpW86Vk(r20, r22, r19, r18, r7, r15, r9, r16);
    L30:
        r19 = RangesKt.coerceAtLeast(r17 + r18, 0);
        goto L32
    L26:
        r17 = MathKt.roundToInt(r0);
        goto L27
    L22:
        r16 = 0;
        goto L23
    L34:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L14:
        r10 = RangesKt.coerceAtLeast((Constraints.getMaxWidth-impl(r22) - r7.getWidth()) - r9.getWidth(), 0);
        goto L15
    L37:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L40:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r7, List<? extends IntrinsicMeasurable> r8, int r9) {
        int r10 = r7.roundToPx-0680j_4(this.height);
        int r1 = 0;
        if (r8.isEmpty() == false) goto L5;
        Integer r11 = null;
    L13:
        Integer r12 = r11;
        if (r12 == null) goto L17;
        r1 = r12.intValue();
    L17:
        return Math.max(r10, r1);
    L5:
        Integer r0 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r8, 0)).minIntrinsicHeight(r9));
        int r2 = CollectionsKt.getLastIndex(r8);
        int r3 = 1;
        if (1 > r2) goto L12;
    L7:
        Integer r4 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r8, r3)).minIntrinsicHeight(r9));
        if (r4.compareTo(r0) <= 0) goto L10;
        r0 = r4;
    L10:
        if (r3 == r2) goto L12;
        r3 = r3 + 1;
    L12:
        r11 = r0;
        goto L13
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope r4, List<? extends IntrinsicMeasurable> r5, int r6) {
        int r7 = r5.size();
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r7) goto L5;
        r1 = r1 + ((IntrinsicMeasurable) ListProtector.get(r5, r0)).minIntrinsicWidth(r6);
        r0 = r0 + 1;
        goto L3
    L5:
        return r1;
    }

    private TopAppBarMeasurePolicy(FloatProducer r1, Arrangement.Vertical r2, Alignment.Horizontal r3, int r4, float r5) {
        this.scrolledOffset = r1;
        this.titleVerticalArrangement = r2;
        this.titleHorizontalAlignment = r3;
        this.titleBottomPadding = r4;
        this.height = r5;
    }

    /* JADX INFO: renamed from: placeTopAppBar-mpW86Vk, reason: not valid java name */
    private final MeasureResult m3591placeTopAppBarmpW86Vk(final MeasureScope r17, final long r18, final int r20, final int r21, final Placeable r22, final Placeable r23, final Placeable r24, final int r25) {
        return MeasureScope.-CC.layout$default(r17, Constraints.getMaxWidth-impl(r18), r20, null, new ox(r22, r20, r23, r24, r18, r17, this, r25, r21), 4, null);
    }

    private static final Unit placeTopAppBar_mpW86Vk$lambda$8(Placeable r12, int r13, Placeable r14, Placeable r15, long r16, MeasureScope r18, TopAppBarMeasurePolicy r19, int r20, int r21, Placeable.PlacementScope r22) {
        Placeable.PlacementScope.placeRelative$default(r22, r12, 0, (r13 - r12.getHeight()) / 2, MenuKt.ClosedAlphaTarget, 4, null);
        int r2 = Math.max(r18.roundToPx-0680j_4(AppBarKt.access$getTopAppBarTitleInset$p()), r12.getWidth());
        int r3 = r15.getWidth();
        int r4 = r19.titleHorizontalAlignment.align(r14.getWidth(), Constraints.getMaxWidth-impl(r16), LayoutDirection.Ltr);
        if (r4 >= r2) goto L7;
        int r5 = r2 - r4;
    L5:
        r4 = r4 + r5;
    L9:
        int r7 = r4;
        Arrangement.Vertical r6 = r19.titleVerticalArrangement;
        Arrangement r8 = Arrangement.INSTANCE;
        if (Intrinsics.areEqual(r6, r8.getCenter()) == false) goto L14;
        int r0 = (r13 - r14.getHeight()) / 2;
    L12:
        int r9 = r0;
    L23:
        Placeable.PlacementScope.placeRelative$default(r22, r14, r7, r9, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r22, r15, Constraints.getMaxWidth-impl(r16) - r15.getWidth(), (r13 - r15.getHeight()) / 2, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L14:
        if (Intrinsics.areEqual(r6, r8.getBottom()) == false) goto L22;
        int r1 = r19.titleBottomPadding;
        if (r1 != 0) goto L18;
        r0 = r13 - r14.getHeight();
        goto L12
    L18:
        int r10 = r1 - (r14.getHeight() - r20);
        int r11 = r14.getHeight() + r10;
        if (r11 <= r21) goto L21;
        r10 = r10 - (r11 - r21);
    L21:
        r9 = (r13 - r14.getHeight()) - Math.max(0, r10);
        goto L23
    L22:
        r9 = 0;
        goto L23
    L7:
        if ((r14.getWidth() + r4) <= (Constraints.getMaxWidth-impl(r16) - r3)) goto L9;
        r5 = (Constraints.getMaxWidth-impl(r16) - r3) - (r14.getWidth() + r4);
        goto L5
    }
}
