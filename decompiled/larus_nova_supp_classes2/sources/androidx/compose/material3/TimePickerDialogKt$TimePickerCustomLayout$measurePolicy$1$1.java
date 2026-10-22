package androidx.compose.material3;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1 implements MeasurePolicy {
    public static final TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1 INSTANCE = null;

    static {
        INSTANCE = new TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1();
    }

    public TimePickerDialogKt$TimePickerCustomLayout$measurePolicy$1$1() {
    }

    public static /* synthetic */ Unit a(boolean r0, int r1, Placeable r2, int r3, Placeable r4, int r5, int r6, int r7, MeasureScope r8, Placeable r9, int r10, int r11, int r12, int r13, Placeable.PlacementScope r14) {
        return measure_3p2s80s$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m3396measure3p2s80s(final MeasureScope r26, List<? extends Measurable> r27, long r28) {
        List<? extends Measurable> r1 = r27;
        int r2 = r1.size();
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L40;
        Measurable r6 = (Measurable) ListProtector.get(r27, r4);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r6), "title") == true) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        int r3 = r1.size();
        int r5 = 0;
    L8:
        if (r5 >= r3) goto L37;
        Measurable r7 = (Measurable) ListProtector.get(r27, r5);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r7), "timePickerContent") == true) goto L11;
        r5 = r5 + 1;
        r26 = r26;
        goto L8
    L11:
        int r8 = r1.size();
        int r9 = 0;
    L12:
        if (r9 >= r8) goto L34;
        Measurable r10 = (Measurable) ListProtector.get(r27, r9);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r10), "actions") == true) goto L15;
        r9 = r9 + 1;
        r26 = r26;
        goto L12
    L15:
        float r0 = 24;
        final int r12 = r26.roundToPx-0680j_4(Dp.constructor-impl(r0));
        final int r11 = r26.roundToPx-0680j_4(Dp.constructor-impl(384));
        final int r13 = r26.roundToPx-0680j_4(Dp.constructor-impl(r0));
        final int r14 = r26.roundToPx-0680j_4(Dp.constructor-impl(16));
        final int r15 = r26.roundToPx-0680j_4(Dp.constructor-impl(4));
        final int r16 = r26.roundToPx-0680j_4(Dp.constructor-impl(8));
        final int r17 = r26.roundToPx-0680j_4(Dp.constructor-impl(r0));
        int r18 = r26.roundToPx-0680j_4(Dp.constructor-impl(r0));
        final Placeable r19 = r7.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r28, 0, 0, 0, 0, 11, null));
        if (r19.getWidth() > r19.getHeight()) goto L18;
    L20:
        final boolean r20 = false;
    L21:
        if (r20 == false) goto L23;
        int r21 = r19.getWidth();
    L24:
        final int r22 = r21 + (r12 * 2);
        final Placeable r23 = r10.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r28, 0, r19.getWidth(), 0, 0, 8, null));
        final Placeable r110 = r6.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r28, 0, r19.getWidth(), 0, 0, 8, null));
        if (r20 == false) goto L30;
        int r24 = (((r19.getHeight() + r23.getHeight()) + r16) + r14) + r15;
        if (Constraints.getHasBoundedHeight-impl(r28) == false) goto L29;
        r24 = Constraints.getMaxHeight-impl(r28);
    L29:
        int r111 = r24;
    L31:
        final int r25 = r111;
        return MeasureScope.-CC.layout$default(r26, r22, r111, null, new nu(r20, r14, r19, r15, r23, r16, r25, r11, r26, r110, r13, r12, r17, r22), 4, null);
    L30:
        r111 = (((r110.getHeight() + r17) + r19.getHeight()) + r23.getHeight()) + r18;
        goto L31
    L23:
        r21 = r19.getWidth();
        goto L24
    L18:
        if (r19.getHeight() < MathKt.truncate(r26.toPx-0680j_4(TimePickerKt.getClockDialMinContainerSize()))) goto L20;
        r20 = true;
        goto L21
    L34:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L37:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L40:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private static final Unit measure_3p2s80s$lambda$3(boolean r16, int r17, Placeable r18, int r19, Placeable r20, int r21, int r22, int r23, MeasureScope r24, Placeable r25, int r26, int r27, int r28, int r29, Placeable.PlacementScope r30) {
        if (r16 == false) goto L9;
        int r1 = r22 - ((((r17 + r18.getHeight()) + r19) + r20.getHeight()) + r21);
        if (r22 < r23) goto L7;
        int r0 = r24.roundToPx-0680j_4(Dp.constructor-impl(16));
    L8:
        Placeable.PlacementScope.place$default(r30, r25, r26, r26, MenuKt.ClosedAlphaTarget, 4, null);
        int r2 = r1 / 2;
        int r9 = r17 + r2;
        Placeable.PlacementScope.place$default(r30, r18, r27, r9, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.place$default(r30, r20, r27, (((r9 + r18.getHeight()) + r19) - r0) + r2, MenuKt.ClosedAlphaTarget, 4, null);
    L11:
        return Unit.INSTANCE;
    L7:
        r0 = 0;
        goto L8
    L9:
        Placeable.PlacementScope.place$default(r30, r25, r26, r28, MenuKt.ClosedAlphaTarget, 4, null);
        int r3 = (r29 - r18.getWidth()) / 2;
        int r4 = r28 + r25.getHeight();
        Placeable.PlacementScope.place$default(r30, r18, r3, r4, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.place$default(r30, r20, (r29 - r20.getWidth()) / 2, r4 + r18.getHeight(), MenuKt.ClosedAlphaTarget, 4, null);
        goto L11
    }
}
