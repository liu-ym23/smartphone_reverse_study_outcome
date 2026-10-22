package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.ListUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class BadgeKt$BadgedBox$2$1 implements MeasurePolicy {
    public static final BadgeKt$BadgedBox$2$1 INSTANCE = null;

    static {
        INSTANCE = new BadgeKt$BadgedBox$2$1();
    }

    public BadgeKt$BadgedBox$2$1() {
    }

    public static /* synthetic */ Unit a(Placeable r0, MeasureScope r1, Placeable r2, Placeable.PlacementScope r3) {
        return measure_3p2s80s$lambda$2(r0, r1, r2, r3);
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
    public final MeasureResult m1943measure3p2s80s(final MeasureScope r18, List<? extends Measurable> r19, long r20) {
        List<? extends Measurable> r2 = r19;
        int r3 = r2.size();
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L17;
        Measurable r7 = (Measurable) ListProtector.get(r19, r5);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r7), "badge") == true) goto L7;
        r5 = r5 + 1;
        goto L4
    L7:
        final Placeable r4 = r7.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r20, 0, 0, 0, 0, 11, null));
        int r6 = r2.size();
        int r8 = 0;
    L8:
        if (r8 >= r6) goto L14;
        Measurable r9 = (Measurable) ListProtector.get(r19, r8);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r9), "anchor") == true) goto L11;
        r8 = r8 + 1;
        goto L8
    L11:
        final Placeable r1 = r9.measure-BRTryo0(r20);
        int r10 = r1.get(AlignmentLineKt.getFirstBaseline());
        int r11 = r1.get(AlignmentLineKt.getLastBaseline());
        return r18.layout(r1.getWidth(), r1.getHeight(), MapsKt.mapOf(new Pair[]{TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(r10)), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(r11))}), new k1(r4, r18, r1));
    L14:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L17:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private static final Unit measure_3p2s80s$lambda$2(Placeable r8, MeasureScope r9, Placeable r10, Placeable.PlacementScope r11) {
        if (r8.getWidth() <= (r9.roundToPx-0680j_4(BadgeKt.getBadgeRadius()) * 2)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        float r1 = BadgeKt.getBadgeWithContentHorizontalOffset();
    L9:
        Placeable.PlacementScope.placeRelative$default(r11, r10, 0, 0, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.placeRelative$default(r11, r8, r10.getWidth() + r9.roundToPx-0680j_4(r1), (-r8.getHeight()) / 2, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    L8:
        r1 = BadgeKt.getBadgeHorizontalOffset();
        goto L9
    L5:
        r0 = false;
        goto L6
    }
}
