package androidx.compose.foundation.text;

import androidx.compose.material3.MenuKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1 implements MeasurePolicy {
    public static final AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1 INSTANCE = null;

    static {
        INSTANCE = new AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1();
    }

    public AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1() {
    }

    public static /* synthetic */ Unit a(List r0, Placeable.PlacementScope r1) {
        return measure_3p2s80s$lambda$2(r0, r1);
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

    private static final Unit measure_3p2s80s$lambda$2(List r10, Placeable.PlacementScope r11) {
        int r0 = r10.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L6;
        Placeable.PlacementScope.placeRelative$default(r11, (Placeable) ListProtector.get(r10, r1), 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        r1 = r1 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public final MeasureResult m1338measure3p2s80s(MeasureScope r11, List<? extends Measurable> r12, long r13) {
        final ArrayList r0 = new ArrayList(r12.size());
        int r1 = r12.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(((Measurable) ListProtector.get(r12, r2)).measure-BRTryo0(r13));
        r2 = r2 + 1;
        goto L3
    L6:
        return MeasureScope.-CC.layout$default(r11, Constraints.getMaxWidth-impl(r13), Constraints.getMaxHeight-impl(r13), null, new g(r0), 4, null);
    }
}
