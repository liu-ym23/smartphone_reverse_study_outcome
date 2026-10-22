package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.util.ListUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\"\u0010\u0013\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\"\u0010\u0014\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\"\u0010\u0016\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/ChipLayoutMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicHeight", "minIntrinsicWidth", "height", "maxIntrinsicWidth", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ChipLayoutMeasurePolicy implements MeasurePolicy {
    public ChipLayoutMeasurePolicy() {
    }

    public static /* synthetic */ Unit a(Placeable r0, int r1, int r2, Placeable r3, int r4, Placeable r5, int r6, Placeable.PlacementScope r7) {
        return measure_3p2s80s$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope r6, List<? extends IntrinsicMeasurable> r7, int r8) {
        if (r7.isEmpty() == false) goto L5;
        Integer r9 = null;
    L12:
        Integer r10 = r9;
        if (r10 != null) goto L15;
        return 0;
    L15:
        return r10.intValue();
    L5:
        r9 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, 0)).maxIntrinsicHeight(r8));
        int r1 = CollectionsKt.getLastIndex(r7);
        int r2 = 1;
        if (1 > r1) goto L12;
    L7:
        Integer r3 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, r2)).maxIntrinsicHeight(r8));
        if (r3.compareTo(r9) <= 0) goto L10;
        r9 = r3;
    L10:
        if (r2 == r1) goto L12;
        r2 = r2 + 1;
        goto L7
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
    public MeasureResult m2425measure3p2s80s(MeasureScope r22, List<? extends Measurable> r23, long r24) {
        List<? extends Measurable> r1 = r23;
        int r2 = r1.size();
        int r3 = 0;
        int r4 = 0;
    L3:
        Placeable r5 = null;
        if (r4 >= r2) goto L9;
        Object r6 = ListProtector.get(r23, r4);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r6), "leadingIcon") == true) goto L10;
        r4 = r4 + 1;
    L10:
        Measurable r7 = (Measurable) r6;
        if (r7 == null) goto L13;
        final Placeable r8 = r7.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r24, 0, 0, 0, 0, 10, null));
    L14:
        final int r11 = LayoutUtilKt.getWidthOrZero(r8);
        final int r9 = LayoutUtilKt.getHeightOrZero(r8);
        int r10 = r1.size();
        int r12 = 0;
    L15:
        if (r12 >= r10) goto L20;
        Object r13 = ListProtector.get(r23, r12);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) r13), "trailingIcon") == true) goto L21;
        r12 = r12 + 1;
    L21:
        Measurable r14 = (Measurable) r13;
        if (r14 == null) goto L24;
        r5 = r14.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r24, 0, 0, 0, 0, 10, null));
    L24:
        final Placeable r15 = r5;
        int r16 = LayoutUtilKt.getWidthOrZero(r15);
        final int r17 = LayoutUtilKt.getHeightOrZero(r15);
        int r18 = r1.size();
    L25:
        if (r3 >= r18) goto L31;
        Measurable r19 = (Measurable) ListProtector.get(r23, r3);
        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(r19), "label") == true) goto L28;
        r3 = r3 + 1;
        goto L25
    L28:
        final Placeable r110 = r19.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U$default(r24, -(r11 + r16), 0, 2, null));
        int r111 = (r110.getWidth() + r11) + r16;
        final int r112 = Math.max(r9, Math.max(r110.getHeight(), r17));
        return MeasureScope.-CC.layout$default(r22, r111, r112, null, new y3(r8, r9, r112, r110, r11, r15, r17), 4, null);
    L31:
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    L20:
        r13 = null;
        goto L21
    L13:
        r8 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope r6, List<? extends IntrinsicMeasurable> r7, int r8) {
        if (r7.isEmpty() == false) goto L5;
        Integer r9 = null;
    L12:
        Integer r10 = r9;
        if (r10 != null) goto L15;
        return 0;
    L15:
        return r10.intValue();
    L5:
        r9 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, 0)).minIntrinsicHeight(r8));
        int r1 = CollectionsKt.getLastIndex(r7);
        int r2 = 1;
        if (1 > r1) goto L12;
    L7:
        Integer r3 = Integer.valueOf(((IntrinsicMeasurable) ListProtector.get(r7, r2)).minIntrinsicHeight(r8));
        if (r3.compareTo(r9) <= 0) goto L10;
        r9 = r3;
    L10:
        if (r2 == r1) goto L12;
        r2 = r2 + 1;
        goto L7
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

    private static final Unit measure_3p2s80s$lambda$3(Placeable r15, int r16, int r17, Placeable r18, int r19, Placeable r20, int r21, Placeable.PlacementScope r22) {
        if (r15 == null) goto L5;
        Placeable.PlacementScope.placeRelative$default(r22, r15, 0, Alignment.Companion.getCenterVertically().align(r16, r17), MenuKt.ClosedAlphaTarget, 4, null);
    L5:
        Placeable.PlacementScope.placeRelative$default(r22, r18, r19, 0, MenuKt.ClosedAlphaTarget, 4, null);
        if (r20 == null) goto L9;
        Placeable.PlacementScope.placeRelative$default(r22, r20, r19 + r18.getWidth(), Alignment.Companion.getCenterVertically().align(r21, r17), MenuKt.ClosedAlphaTarget, 4, null);
    L9:
        return Unit.INSTANCE;
    }
}
