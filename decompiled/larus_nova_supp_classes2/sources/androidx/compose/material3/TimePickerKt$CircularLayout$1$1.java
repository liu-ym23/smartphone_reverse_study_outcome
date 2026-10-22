package androidx.compose.material3;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TimePickerKt$CircularLayout$1$1 implements MeasurePolicy {
    final /* synthetic */ float $radiusToSizeRatio;

    public TimePickerKt$CircularLayout$1$1(float r1) {
        this.$radiusToSizeRatio = r1;
    }

    public static /* synthetic */ Unit a(Placeable r0, List r1, Placeable r2, long r3, float r5, float r6, Placeable.PlacementScope r7) {
        return measure_3p2s80s$lambda$5(r0, r1, r2, r3, r5, r6, r7);
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
    public final MeasureResult m3418measure3p2s80s(MeasureScope r20, List<? extends Measurable> r21, final long r22) {
        final float r10 = Constraints.getMaxHeight-impl(r22) * this.$radiusToSizeRatio;
        long r3 = Constraints.copy-Zbe2FdA$default(r22, 0, 0, 0, 0, 10, null);
        ArrayList r1 = new ArrayList(r21.size());
        List<? extends Measurable> r5 = r21;
        int r6 = r5.size();
        int r8 = 0;
    L3:
        boolean r9 = true;
        if (r8 >= r6) goto L14;
        Object r11 = ListProtector.get(r21, r8);
        Measurable r12 = (Measurable) r11;
        if (LayoutIdKt.getLayoutId(r12) != LayoutId.Selector) goto L8;
    L10:
        r9 = false;
    L11:
        if (r9 == false) goto L13;
        r1.add(r11);
    L13:
        r8 = r8 + 1;
        goto L3
    L8:
        if (LayoutIdKt.getLayoutId(r12) == LayoutId.InnerCircle) goto L10;
    L14:
        final ArrayList r7 = new ArrayList(r1.size());
        int r13 = r1.size();
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L17;
        r7.add(((Measurable) ListProtector.get(r1, r14)).measure-BRTryo0(r3));
        r14 = r14 + 1;
        goto L15
    L17:
        int r2 = r5.size();
        int r15 = 0;
    L19:
        if (r15 >= r2) goto L27;
        Object r16 = ListProtector.get(r21, r15);
        if (LayoutIdKt.getLayoutId((Measurable) r16) != LayoutId.Selector) goto L23;
        boolean r17 = true;
    L24:
        if (r17 == true) goto L28;
        r15 = r15 + 1;
    L28:
        Measurable r18 = (Measurable) r16;
        int r4 = r5.size();
        int r19 = 0;
    L29:
        if (r19 >= r4) goto L37;
        Object r23 = ListProtector.get(r21, r19);
        if (LayoutIdKt.getLayoutId((Measurable) r23) != LayoutId.InnerCircle) goto L33;
        boolean r110 = true;
    L34:
        if (r110 == true) goto L38;
        r19 = r19 + 1;
    L38:
        Measurable r24 = (Measurable) r23;
        final float r0 = 6.2831855f / r7.size();
        if (r18 == null) goto L41;
        final Placeable r25 = r18.measure-BRTryo0(r3);
    L42:
        if (r24 == null) goto L44;
        final Placeable r26 = r24.measure-BRTryo0(r3);
    L46:
        return MeasureScope.-CC.layout$default(r20, Constraints.getMinWidth-impl(r22), Constraints.getMinHeight-impl(r22), null, new aw(r25, r7, r26, r22, r10, r0), 4, null);
    L44:
        r26 = null;
        goto L46
    L41:
        r25 = null;
        goto L42
    L33:
        r110 = false;
        goto L34
    L37:
        r23 = null;
        goto L38
    L23:
        r17 = false;
        goto L24
    L27:
        r16 = null;
        goto L28
    }

    private static final Unit measure_3p2s80s$lambda$5(Placeable r16, List r17, Placeable r18, long r19, float r21, float r22, Placeable.PlacementScope r23) {
        if (r16 == null) goto L5;
        Placeable.PlacementScope.place$default(r23, r16, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
    L5:
        int r1 = r17.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L8;
        Placeable r5 = (Placeable) ListProtector.get(r17, r2);
        int r3 = (Constraints.getMaxWidth-impl(r19) / 2) - (r5.getWidth() / 2);
        int r4 = (Constraints.getMaxHeight-impl(r19) / 2) - (r5.getHeight() / 2);
        double r6 = r21;
        double r8 = ((double) (r2 * r22)) - 1.5707963267948966d;
        Placeable.PlacementScope.place$default(r23, r5, MathKt.roundToInt((Math.cos(r8) * r6) + ((double) r3)), MathKt.roundToInt((r6 * Math.sin(r8)) + ((double) r4)), MenuKt.ClosedAlphaTarget, 4, null);
        r2 = r2 + 1;
        goto L6
    L8:
        if (r18 == null) goto L11;
        Placeable.PlacementScope.place$default(r23, r18, (Constraints.getMinWidth-impl(r19) - r18.getWidth()) / 2, (Constraints.getMinHeight-impl(r19) - r18.getHeight()) / 2, MenuKt.ClosedAlphaTarget, 4, null);
    L11:
        return Unit.INSTANCE;
    }
}
