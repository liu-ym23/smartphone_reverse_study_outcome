package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\"+\u0010\u0004\u001a\u001f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000\"+\u0010\u000b\u001a\u001f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000\"%\u0010\r\u001a\u0019\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000\"%\u0010\u0010\u001a\u0019\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"windowInsetsStartWidth", "Landroidx/compose/ui/Modifier;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "startCalc", "Lkotlin/Function3;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ExtensionFunctionType;", "windowInsetsEndWidth", "endCalc", "windowInsetsTopHeight", "topCalc", "Lkotlin/Function2;", "windowInsetsBottomHeight", "bottomCalc", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsSizeKt {
    private static final Function2<WindowInsets, Density, Integer> bottomCalc = null;
    private static final Function3<WindowInsets, LayoutDirection, Density, Integer> endCalc = null;
    private static final Function3<WindowInsets, LayoutDirection, Density, Integer> startCalc = null;
    private static final Function2<WindowInsets, Density, Integer> topCalc = null;

    public static /* synthetic */ int a(WindowInsets r0, LayoutDirection r1, Density r2) {
        return startCalc$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ int b(WindowInsets r0, LayoutDirection r1, Density r2) {
        return endCalc$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ int c(WindowInsets r0, Density r1) {
        return bottomCalc$lambda$7(r0, r1);
    }

    public static /* synthetic */ int d(WindowInsets r0, Density r1) {
        return topCalc$lambda$5(r0, r1);
    }

    static {
        startCalc = new o2();
        endCalc = new p2();
        topCalc = new q2();
        bottomCalc = new r2();
    }

    private static final int bottomCalc$lambda$7(WindowInsets r0, Density r1) {
        return r0.getBottom(r1);
    }

    private static final int topCalc$lambda$5(WindowInsets r0, Density r1) {
        return r0.getTop(r1);
    }

    public static final Modifier windowInsetsBottomHeight(Modifier r3, final WindowInsets r4) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r1 = new WindowInsetsSizeKt$windowInsetsBottomHeight$$inlined$debugInspectorInfo$1(r4);
    L7:
        return r3.then(new DerivedHeightModifier(r4, r1, bottomCalc));
    L5:
        r1 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier windowInsetsEndWidth(Modifier r3, final WindowInsets r4) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r1 = new WindowInsetsSizeKt$windowInsetsEndWidth$$inlined$debugInspectorInfo$1(r4);
    L7:
        return r3.then(new DerivedWidthModifier(r4, r1, endCalc));
    L5:
        r1 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier windowInsetsStartWidth(Modifier r3, final WindowInsets r4) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r1 = new WindowInsetsSizeKt$windowInsetsStartWidth$$inlined$debugInspectorInfo$1(r4);
    L7:
        return r3.then(new DerivedWidthModifier(r4, r1, startCalc));
    L5:
        r1 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    public static final Modifier windowInsetsTopHeight(Modifier r3, final WindowInsets r4) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r1 = new WindowInsetsSizeKt$windowInsetsTopHeight$$inlined$debugInspectorInfo$1(r4);
    L7:
        return r3.then(new DerivedHeightModifier(r4, r1, topCalc));
    L5:
        r1 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    private static final int endCalc$lambda$3(WindowInsets r1, LayoutDirection r2, Density r3) {
        if (r2 != LayoutDirection.Rtl) goto L6;
        return r1.getLeft(r3, r2);
    L6:
        return r1.getRight(r3, r2);
    }

    private static final int startCalc$lambda$1(WindowInsets r1, LayoutDirection r2, Density r3) {
        if (r2 != LayoutDirection.Ltr) goto L6;
        return r1.getLeft(r3, r2);
    L6:
        return r1.getRight(r3, r2);
    }
}
