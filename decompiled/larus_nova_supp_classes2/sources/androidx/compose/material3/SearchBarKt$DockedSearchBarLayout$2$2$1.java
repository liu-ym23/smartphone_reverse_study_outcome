package androidx.compose.material3;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class SearchBarKt$DockedSearchBarLayout$2$2$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ float $maxHeight;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ SearchBarState $state;

    public SearchBarKt$DockedSearchBarLayout$2$2$1(SearchBarState r1, float r2, float r3) {
        this.$state = r1;
        this.$maxHeight = r2;
        this.$minHeight = r3;
    }

    public static /* synthetic */ Unit a(List r0, List r1, int r2, Placeable.PlacementScope r3) {
        return measure_3p2s80s$lambda$8(r0, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, List r2, int r3) {
        return MultiContentMeasurePolicy.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m3068measure3p2s80s(MeasureScope r23, List<? extends List<? extends Measurable>> r24, long r25) {
        int r3 = 0;
        List r4 = (List) ListProtector.get(r24, 0);
        int r5 = 1;
        List r2 = (List) ListProtector.get(r24, 1);
        int r12 = MathHelpersKt.lerp(SearchBarKt.access$getCollapsedBounds(this.$state).getHeight(), r23.roundToPx-0680j_4(this.$maxHeight), this.$state.getProgress());
        long r6 = ConstraintsKt.constrain-N9IONVI(r25, ConstraintsKt.Constraints$default(0, 0, RangesKt.coerceAtMost(r23.roundToPx-0680j_4(this.$minHeight), r12), r12, 3, null));
        long r8 = Constraints.copy-Zbe2FdA$default(r6, 0, 0, 0, 0, 10, null);
        final ArrayList r10 = new ArrayList(r4.size());
        int r11 = r4.size();
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L6;
        r10.add(((Measurable) ListProtector.get(r4, r13)).measure-BRTryo0(r8));
        r13 = r13 + 1;
        goto L3
    L6:
        if (r10.isEmpty() == false) goto L8;
        Integer r7 = null;
    L16:
        Integer r9 = r7;
        if (r9 == null) goto L19;
        int r14 = r9.intValue();
    L21:
        if (r10.isEmpty() == false) goto L23;
        Integer r15 = null;
    L31:
        Integer r16 = r15;
        if (r16 == null) goto L34;
        int r17 = r16.intValue();
    L35:
        long r18 = ConstraintsKt.offset-NN6Ew-U$default(r8, 0, -r17, 1, null);
        final int r19 = r17;
        long r110 = Constraints.copy-Zbe2FdA$default(r18, 0, r14, 0, 0, 13, null);
        final ArrayList r20 = new ArrayList(r2.size());
        int r111 = r2.size();
        int r112 = 0;
    L36:
        if (r112 >= r111) goto L39;
        r20.add(((Measurable) ListProtector.get(r2, r112)).measure-BRTryo0(r110));
        r112 = r112 + 1;
        goto L36
    L39:
        if (r20.isEmpty() == false) goto L41;
        Integer r21 = null;
    L49:
        Integer r22 = r21;
        if (r22 == null) goto L52;
        int r26 = r22.intValue();
    L53:
        int r113 = r19 + r26;
        if (r20.isEmpty() == false) goto L56;
        Integer r114 = null;
    L64:
        Integer r115 = r114;
        if (r115 == null) goto L68;
        r3 = r115.intValue();
    L68:
        return MeasureScope.-CC.layout$default(r23, ConstraintsKt.constrainWidth-K40F9xA(r6, Math.max(r14, r3)), ConstraintsKt.constrainHeight-K40F9xA(r6, r113), null, new vm(r10, r20, r19), 4, null);
    L56:
        Integer r27 = Integer.valueOf(((Placeable) ListProtector.get(r20, 0)).getWidth());
        int r116 = CollectionsKt.getLastIndex(r20);
        if (1 > r116) goto L63;
    L58:
        Integer r117 = Integer.valueOf(((Placeable) ListProtector.get(r20, r5)).getWidth());
        if (r117.compareTo(r27) <= 0) goto L61;
        r27 = r117;
    L61:
        if (r5 == r116) goto L63;
        r5 = r5 + 1;
    L63:
        r114 = r27;
        goto L64
    L52:
        r26 = 0;
        goto L53
    L41:
        r21 = Integer.valueOf(((Placeable) ListProtector.get(r20, 0)).getHeight());
        int r118 = CollectionsKt.getLastIndex(r20);
        if (1 > r118) goto L49;
        int r119 = 1;
    L44:
        Integer r120 = Integer.valueOf(((Placeable) ListProtector.get(r20, r119)).getHeight());
        if (r120.compareTo(r21) <= 0) goto L47;
        r21 = r120;
    L47:
        if (r119 == r118) goto L49;
        r119 = r119 + 1;
        goto L44
    L34:
        r17 = 0;
        goto L35
    L23:
        r15 = Integer.valueOf(((Placeable) ListProtector.get(r10, 0)).getHeight());
        int r121 = CollectionsKt.getLastIndex(r10);
        if (1 > r121) goto L31;
        int r122 = 1;
    L26:
        Integer r123 = Integer.valueOf(((Placeable) ListProtector.get(r10, r122)).getHeight());
        if (r123.compareTo(r15) <= 0) goto L29;
        r15 = r123;
    L29:
        if (r122 == r121) goto L31;
        r122 = r122 + 1;
        goto L26
    L19:
        r14 = 0;
        goto L21
    L8:
        r7 = Integer.valueOf(((Placeable) ListProtector.get(r10, 0)).getWidth());
        int r124 = CollectionsKt.getLastIndex(r10);
        if (1 > r124) goto L16;
        int r125 = 1;
    L11:
        Integer r126 = Integer.valueOf(((Placeable) ListProtector.get(r10, r125)).getWidth());
        if (r126.compareTo(r7) <= 0) goto L14;
        r7 = r126;
    L14:
        if (r125 == r124) goto L16;
        r125 = r125 + 1;
        goto L11
    }

    private static final Unit measure_3p2s80s$lambda$8(List r11, List r12, int r13, Placeable.PlacementScope r14) {
        int r0 = r11.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        Placeable.PlacementScope.place$default(r14, (Placeable) ListProtector.get(r11, r2), 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r2 = r2 + 1;
        goto L3
    L5:
        int r15 = r12.size();
    L6:
        if (r1 >= r15) goto L9;
        Placeable.PlacementScope.place$default(r14, (Placeable) ListProtector.get(r12, r1), 0, r13, MenuKt.ClosedAlphaTarget, 4, null);
        r1 = r1 + 1;
        goto L6
    L9:
        return Unit.INSTANCE;
    }
}
