package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.compose.material3.MenuKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bc\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0017\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/SideCalculator;", "", "valueOf", "", "insets", "Landroid/graphics/Insets;", "motionOf", "", "x", "y", "showMotion", "hideMotion", "adjustInsets", "oldInsets", "newValue", "consumedOffsets", "Landroidx/compose/ui/geometry/Offset;", "available", "consumedOffsets-MK-Hz9U", "(J)J", "consumedVelocity", "Landroidx/compose/ui/unit/Velocity;", "remaining", "consumedVelocity-QWom1Mo", "(JF)J", "Companion", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
interface SideCalculator {
    public static final Companion Companion = null;

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.SideCalculator$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static float $default$hideMotion(SideCalculator r0, float r1, float r2) {
            return RangesKt.coerceAtMost(r0.motionOf(r1, r2), MenuKt.ClosedAlphaTarget);
        }

        public static float $default$showMotion(SideCalculator r0, float r1, float r2) {
            return RangesKt.coerceAtLeast(r0.motionOf(r1, r2), MenuKt.ClosedAlphaTarget);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0004\r\u0010\u0013\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/layout/SideCalculator$Companion;", "", "<init>", "()V", "chooseCalculator", "Landroidx/compose/foundation/layout/SideCalculator;", "side", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "chooseCalculator-ni1skBw", "(ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/foundation/layout/SideCalculator;", "LeftSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$LeftSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$LeftSideCalculator$1;", "TopSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$TopSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$TopSideCalculator$1;", "RightSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$RightSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$RightSideCalculator$1;", "BottomSideCalculator", "androidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1", "Landroidx/compose/foundation/layout/SideCalculator$Companion$BottomSideCalculator$1;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final SideCalculator$Companion$BottomSideCalculator$1 BottomSideCalculator = null;
        private static final SideCalculator$Companion$LeftSideCalculator$1 LeftSideCalculator = null;
        private static final SideCalculator$Companion$RightSideCalculator$1 RightSideCalculator = null;
        private static final SideCalculator$Companion$TopSideCalculator$1 TopSideCalculator = null;

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.layout.SideCalculator$Companion$LeftSideCalculator$1] */
        /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.foundation.layout.SideCalculator$Companion$TopSideCalculator$1] */
        /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.foundation.layout.SideCalculator$Companion$RightSideCalculator$1] */
        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.compose.foundation.layout.SideCalculator$Companion$BottomSideCalculator$1] */
        static {
            $$INSTANCE = new Companion();
            LeftSideCalculator = new SideCalculator$Companion$LeftSideCalculator$1();
            TopSideCalculator = new SideCalculator$Companion$TopSideCalculator$1();
            RightSideCalculator = new SideCalculator$Companion$RightSideCalculator$1();
            BottomSideCalculator = new SideCalculator$Companion$BottomSideCalculator$1();
        }

        /* JADX INFO: renamed from: chooseCalculator-ni1skBw, reason: not valid java name */
        public final SideCalculator m996chooseCalculatorni1skBw(int r3, LayoutDirection r4) {
            WindowInsetsSides.Companion r0 = WindowInsetsSides.Companion;
            if (WindowInsetsSides.m1057equalsimpl0(r3, r0.m1071getLeftJoeWqyM()) == false) goto L6;
            return LeftSideCalculator;
        L6:
            if (WindowInsetsSides.m1057equalsimpl0(r3, r0.m1074getTopJoeWqyM()) == false) goto L9;
            return TopSideCalculator;
        L9:
            if (WindowInsetsSides.m1057equalsimpl0(r3, r0.m1072getRightJoeWqyM()) == false) goto L12;
            return RightSideCalculator;
        L12:
            if (WindowInsetsSides.m1057equalsimpl0(r3, r0.m1068getBottomJoeWqyM()) == false) goto L15;
            return BottomSideCalculator;
        L15:
            if (WindowInsetsSides.m1057equalsimpl0(r3, r0.m1073getStartJoeWqyM()) == false) goto L21;
            if (r4 != LayoutDirection.Ltr) goto L34;
            return LeftSideCalculator;
        L34:
            return RightSideCalculator;
        L21:
            if (WindowInsetsSides.m1057equalsimpl0(r3, r0.m1069getEndJoeWqyM()) == false) goto L28;
            if (r4 != LayoutDirection.Ltr) goto L26;
            return RightSideCalculator;
        L26:
            return LeftSideCalculator;
        L28:
            throw new IllegalStateException("Only Left, Top, Right, Bottom, Start and End are allowed".toString());
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    Insets adjustInsets(Insets r1, int r2);

    /* JADX INFO: renamed from: consumedOffsets-MK-Hz9U, reason: not valid java name */
    long mo994consumedOffsetsMKHz9U(long r1);

    /* JADX INFO: renamed from: consumedVelocity-QWom1Mo, reason: not valid java name */
    long mo995consumedVelocityQWom1Mo(long r1, float r3);

    float hideMotion(float r1, float r2);

    float motionOf(float r1, float r2);

    float showMotion(float r1, float r2);

    int valueOf(Insets r1);
}
