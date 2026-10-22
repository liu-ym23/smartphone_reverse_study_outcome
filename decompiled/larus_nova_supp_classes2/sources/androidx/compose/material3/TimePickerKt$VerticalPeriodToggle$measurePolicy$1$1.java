package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
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
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1 implements MeasurePolicy {
    public static final TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1 INSTANCE = null;

    static {
        INSTANCE = new TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1();
    }

    public TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1() {
    }

    public static /* synthetic */ Unit a(List r0, Placeable r1, Placeable.PlacementScope r2) {
        return measure_3p2s80s$lambda$3(r0, r1, r2);
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

    private static final Unit measure_3p2s80s$lambda$3(List r17, Placeable r18, Placeable.PlacementScope r19) {
        Placeable.PlacementScope.place$default(r19, (Placeable) ListProtector.get(r17, 0), 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.place$default(r19, (Placeable) ListProtector.get(r17, 1), 0, ((Placeable) ListProtector.get(r17, 0)).getHeight(), MenuKt.ClosedAlphaTarget, 4, null);
        Placeable.PlacementScope.place$default(r19, r18, 0, ((Placeable) ListProtector.get(r17, 0)).getHeight() - (r18.getHeight() / 2), MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m3422measure3p2s80s(MeasureScope r20, List<? extends Measurable> r21, long r22) {
        int r1 = r21.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L18;
        Measurable r4 = (Measurable) ListProtector.get(r21, r3);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r4), "Spacer") == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        final Placeable r5 = r4.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r22, 0, 0, 0, r20.roundToPx-0680j_4(TimePickerTokens.INSTANCE.getPeriodSelectorOutlineWidth-D9Ej5fM()), 3, null));
        ArrayList r6 = new ArrayList(r21.size());
        int r7 = r21.size();
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L12;
        Object r9 = ListProtector.get(r21, r8);
        if ((!Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r9), "Spacer")) == false) goto L11;
        r6.add(r9);
    L11:
        r8 = r8 + 1;
        goto L7
    L12:
        final ArrayList r0 = new ArrayList(r6.size());
        int r10 = r6.size();
    L13:
        if (r2 >= r10) goto L16;
        r0.add(((Measurable) ListProtector.get(r6, r2)).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r22, 0, 0, 0, Constraints.getMaxHeight-impl(r22) / 2, 3, null)));
        r2 = r2 + 1;
        goto L13
    L16:
        return MeasureScope.-CC.layout$default(r20, Constraints.getMaxWidth-impl(r22), Constraints.getMaxHeight-impl(r22), null, new mw(r0, r5), 4, null);
    L18:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
