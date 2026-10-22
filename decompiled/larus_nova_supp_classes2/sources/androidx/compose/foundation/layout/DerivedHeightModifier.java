package androidx.compose.foundation.layout;

import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BG\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u0012\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\n¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0016J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\nX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Landroidx/compose/foundation/layout/DerivedHeightModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "heightCalc", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "", "<init>", "(Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "<set-?>", "unconsumedInsets", "getUnconsumedInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "setUnconsumedInsets", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "unconsumedInsets$delegate", "Landroidx/compose/runtime/MutableState;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "equals", "", "other", "", "hashCode", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DerivedHeightModifier extends InspectorValueInfo implements LayoutModifier, ModifierLocalConsumer {
    private final Function2<WindowInsets, Density, Integer> heightCalc;
    private final WindowInsets insets;
    private final MutableState unconsumedInsets$delegate;

    public static /* synthetic */ Unit a(Placeable r0, Placeable.PlacementScope r1) {
        return measure_3p2s80s$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit b(Placeable.PlacementScope r0) {
        return measure_3p2s80s$lambda$0(r0);
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

    private final WindowInsets getUnconsumedInsets() {
        return (WindowInsets) this.unconsumedInsets$delegate.getValue();
    }

    public int hashCode() {
        return (this.insets.hashCode() * 31) + this.heightCalc.hashCode();
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope r0) {
        return Unit.INSTANCE;
    }

    private final void setUnconsumedInsets(WindowInsets r2) {
        this.unconsumedInsets$delegate.setValue(r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DerivedHeightModifier) == true) goto L8;
        return false;
    L8:
        DerivedHeightModifier r6 = (DerivedHeightModifier) r5;
        if (Intrinsics.areEqual(this.insets, r6.insets) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.heightCalc != r6.heightCalc) goto L13;
        return true;
    }

    public void onModifierLocalsUpdated(ModifierLocalReadScope r3) {
        setUnconsumedInsets(WindowInsetsKt.exclude(this.insets, (WindowInsets) r3.getCurrent(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets())));
    }

    private static final Unit measure_3p2s80s$lambda$1(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.placeRelative$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedHeightModifier(WindowInsets r1, Function1<? super InspectorInfo, Unit> r2, Function2<? super WindowInsets, ? super Density, Integer> r3) {
        super(r2);
        this.insets = r1;
        this.heightCalc = r3;
        this.unconsumedInsets$delegate = SnapshotStateKt.mutableStateOf$default(r1, null, 2, null);
    }

    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m854measure3p2s80s(MeasureScope r10, Measurable r11, long r12) {
        int r0 = ((Number) this.heightCalc.invoke(getUnconsumedInsets(), r10)).intValue();
        if (r0 == 0) goto L5;
        final Placeable r13 = r11.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(r12, 0, 0, r0, r0, 3, null));
        return MeasureScope.-CC.layout$default(r10, r13.getWidth(), r0, null, new b0(r13), 4, null);
    L5:
        return MeasureScope.-CC.layout$default(r10, 0, 0, null, new a0(), 4, null);
    }
}
