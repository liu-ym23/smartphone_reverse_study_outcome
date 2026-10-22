package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.util.ListUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class TabKt$TabBaselineLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    public TabKt$TabBaselineLayout$2$1(Function2<? super Composer, ? super Integer, Unit> r1, Function2<? super Composer, ? super Integer, Unit> r2) {
        this.$text = r1;
        this.$icon = r2;
    }

    public static /* synthetic */ Unit a(Placeable r0, Placeable r1, MeasureScope r2, int r3, int r4, Integer r5, Integer r6, Placeable.PlacementScope r7) {
        return measure_3p2s80s$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7);
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
    public final MeasureResult m2196measure3p2s80s(final MeasureScope r18, List<? extends Measurable> r19, long r20) {
        int r4 = 0;
        Integer r5 = null;
        if (this.$text == null) goto L12;
        int r2 = r19.size();
        int r6 = 0;
    L5:
        if (r6 >= r2) goto L10;
        Measurable r7 = (Measurable) ListProtector.get(r19, r6);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r7), "text") == true) goto L8;
        r6 = r6 + 1;
        goto L5
    L8:
        Measured r8 = r7.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r20, 0, 0, 0, 0, 11, null));
    L14:
        if (this.$icon == null) goto L23;
        int r3 = r19.size();
        int r9 = 0;
    L16:
        if (r9 >= r3) goto L21;
        Measurable r10 = (Measurable) ListProtector.get(r19, r9);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r10), "icon") == true) goto L19;
        r9 = r9 + 1;
        goto L16
    L19:
        Placeable r1 = r10.measure-BRTryo0(r20);
    L24:
        if (r8 == null) goto L26;
        int r11 = r8.getWidth();
    L27:
        if (r1 == null) goto L29;
        r4 = r1.getWidth();
    L29:
        final int r12 = Math.max(r11, r4);
        if (r8 == null) goto L33;
        if (r1 == null) goto L33;
        float r13 = TabKt.access$getLargeTabHeight$p();
    L34:
        final int r14 = r18.roundToPx-0680j_4(r13);
        if (r8 == null) goto L37;
        final Integer r15 = Integer.valueOf(r8.get(AlignmentLineKt.getFirstBaseline()));
    L38:
        if (r8 == null) goto L40;
        r5 = Integer.valueOf(r8.get(AlignmentLineKt.getLastBaseline()));
    L40:
        final Integer r16 = r5;
        final Measured r17 = r8;
        final Placeable r21 = r1;
        return MeasureScope.-CC.layout$default(r18, r12, r14, null, new gc(r17, r21, r18, r12, r14, r15, r16), 4, null);
    L37:
        r15 = null;
    L33:
        r13 = TabKt.access$getSmallTabHeight$p();
        goto L34
    L26:
        r11 = 0;
        goto L27
    L21:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L23:
        r1 = null;
        goto L24
    L10:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L12:
        r8 = null;
        goto L14
    }

    private static final Unit measure_3p2s80s$lambda$4(Placeable r8, Placeable r9, MeasureScope r10, int r11, int r12, Integer r13, Integer r14, Placeable.PlacementScope r15) {
        if (r8 == null) goto L5;
        if (r9 == null) goto L5;
        Intrinsics.checkNotNull(r13);
        int r6 = r13.intValue();
        Intrinsics.checkNotNull(r14);
        TabKt.access$placeTextAndIcon(r15, r10, r8, r9, r11, r12, r6, r14.intValue());
    L10:
        return Unit.INSTANCE;
    L5:
        if (r8 == null) goto L7;
        TabKt.access$placeTextOrIcon(r15, r8, r12);
        goto L10
    L7:
        if (r9 == null) goto L10;
        TabKt.access$placeTextOrIcon(r15, r9, r12);
        goto L10
    }
}
