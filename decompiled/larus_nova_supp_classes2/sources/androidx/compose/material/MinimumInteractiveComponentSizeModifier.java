package androidx.compose.material;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Landroidx/compose/material/MinimumInteractiveComponentSizeModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "size", "Landroidx/compose/ui/unit/DpSize;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getSize-MYxV2XQ", "()J", "J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "equals", "", "other", "", "hashCode", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MinimumInteractiveComponentSizeModifier implements LayoutModifier {
    private final long size;

    public /* synthetic */ MinimumInteractiveComponentSizeModifier(long r1, DefaultConstructorMarker r3) {
        this(r1);
    }

    public static /* synthetic */ Unit a(int r0, Placeable r1, int r2, Placeable.PlacementScope r3) {
        return measure_3p2s80s$lambda$0(r0, r1, r2, r3);
    }

    public final /* synthetic */ boolean all(Function1 r1) {
        return Modifier.Element.-CC.$default$all(this, r1);
    }

    public final /* synthetic */ boolean any(Function1 r1) {
        return Modifier.Element.-CC.$default$any(this, r1);
    }

    public final /* synthetic */ Object foldIn(Object r1, Function2 r2) {
        return Modifier.Element.-CC.$default$foldIn(this, r1, r2);
    }

    public final /* synthetic */ Object foldOut(Object r1, Function2 r2) {
        return Modifier.Element.-CC.$default$foldOut(this, r1, r2);
    }

    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifier.-CC.$default$maxIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifier.-CC.$default$maxIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifier.-CC.$default$minIntrinsicHeight(this, r1, r2, r3);
    }

    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r1, IntrinsicMeasurable r2, int r3) {
        return LayoutModifier.-CC.$default$minIntrinsicWidth(this, r1, r2, r3);
    }

    public final /* synthetic */ Modifier then(Modifier r1) {
        return Modifier.-CC.$default$then(this, r1);
    }

    public int hashCode() {
        return DpSize.hashCode-impl(this.size);
    }

    /* JADX INFO: renamed from: getSize-MYxV2XQ, reason: not valid java name */
    public final long m2092getSizeMYxV2XQ() {
        return this.size;
    }

    private MinimumInteractiveComponentSizeModifier(long r1) {
        this.size = r1;
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof MinimumInteractiveComponentSizeModifier) == false) goto L5;
        MinimumInteractiveComponentSizeModifier r6 = (MinimumInteractiveComponentSizeModifier) r5;
    L6:
        if (r6 != null) goto L10;
        return false;
    L10:
        return DpSize.equals-impl0(this.size, r6.size);
    L5:
        r6 = null;
        goto L6
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m2093measure3p2s80s(MeasureScope r8, Measurable r9, long r10) {
        final Placeable r11 = r9.measure-BRTryo0(r10);
        final int r1 = Math.max(r11.getWidth(), r8.roundToPx-0680j_4(DpSize.getWidth-D9Ej5fM(this.size)));
        final int r2 = Math.max(r11.getHeight(), r8.roundToPx-0680j_4(DpSize.getHeight-D9Ej5fM(this.size)));
        return MeasureScope.-CC.layout$default(r8, r1, r2, null, new c6(r1, r11, r2), 4, null);
    }

    private static final Unit measure_3p2s80s$lambda$0(int r8, Placeable r9, int r10, Placeable.PlacementScope r11) {
        Placeable.PlacementScope.place$default(r11, r9, MathKt.roundToInt((r8 - r9.getWidth()) / 2.0f), MathKt.roundToInt((r10 - r9.getHeight()) / 2.0f), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }
}
