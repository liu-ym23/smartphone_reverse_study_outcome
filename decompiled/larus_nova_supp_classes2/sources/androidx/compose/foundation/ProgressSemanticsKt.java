package androidx.compose.foundation;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007¨\u0006\b"}, d2 = {"progressSemantics", "Landroidx/compose/ui/Modifier;", "value", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProgressSemanticsKt {
    public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
        return progressSemantics$lambda$1(r0);
    }

    public static /* synthetic */ Unit b(float r0, ClosedFloatingPointRange r1, int r2, SemanticsPropertyReceiver r3) {
        return progressSemantics$lambda$0(r0, r1, r2, r3);
    }

    public static final Modifier progressSemantics(Modifier r2) {
        return SemanticsModifierKt.semantics(r2, true, new d1());
    }

    private static final Unit progressSemantics$lambda$1(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setProgressBarRangeInfo(r1, ProgressBarRangeInfo.Companion.getIndeterminate());
        return Unit.INSTANCE;
    }

    public static final Modifier progressSemantics(Modifier r1, final float r2, final ClosedFloatingPointRange<Float> r3, final int r4) {
        return SemanticsModifierKt.semantics(r1, true, new e1(r2, r3, r4));
    }

    private static final Unit progressSemantics$lambda$0(float r1, ClosedFloatingPointRange r2, int r3, SemanticsPropertyReceiver r4) {
        SemanticsPropertiesKt.setProgressBarRangeInfo(r4, new ProgressBarRangeInfo(((Number) RangesKt.coerceIn(Float.valueOf(r1), r2)).floatValue(), r2, r3));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Modifier progressSemantics$default(Modifier r0, float r1, ClosedFloatingPointRange r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = RangesKt.rangeTo(MenuKt.ClosedAlphaTarget, 1.0f);
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = 0;
    L9:
        return progressSemantics(r0, r1, r2, r3);
    }
}
