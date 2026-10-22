package androidx.compose.foundation.pager;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\b\b\u0003\u0010\u000f\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/pager/PagerDefaults;", "", "<init>", "()V", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "state", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "snapPositionalThreshold", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/pager/PagerSnapDistance;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;FLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "BeyondViewportPageCount", "", "BeyondBoundsPageCount", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PagerDefaults {
    public static final int $stable = 0;
    public static final int BeyondBoundsPageCount = 0;
    public static final int BeyondViewportPageCount = 0;
    public static final PagerDefaults INSTANCE = null;

    static {
        INSTANCE = new PagerDefaults();
    }

    private PagerDefaults() {
    }

    public static /* synthetic */ float a(PagerState r0, LayoutDirection r1, float r2, float r3, float r4, float r5) {
        return flingBehavior$lambda$2$lambda$1(r0, r1, r2, r3, r4, r5);
    }

    public final NestedScrollConnection pageNestedScrollConnection(PagerState r6, Orientation r7, Composer r8, int r9) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(877583120, r9, -1, "androidx.compose.foundation.pager.PagerDefaults.pageNestedScrollConnection (Pager.kt:466)");
    L5:
        boolean r1 = false;
        if (((r9 & 14) ^ 6) <= 4) goto L10;
        if (r8.changed(r6) == false) goto L10;
    L11:
        boolean r0 = true;
    L14:
        if (((r9 & 112) ^ 48) <= 32) goto L18;
        if (r8.changed(r7.ordinal()) == false) goto L18;
    L19:
        r1 = true;
    L20:
        boolean r10 = r0 | r1;
        Object r2 = r8.rememberedValue();
        if (r10 == false) goto L23;
    L24:
        r2 = new DefaultPagerNestedScrollConnection(r6, r7);
        r8.updateRememberedValue(r2);
    L25:
        DefaultPagerNestedScrollConnection r3 = (DefaultPagerNestedScrollConnection) r2;
        if (ComposerKt.isTraceInProgress() == false) goto L28;
        ComposerKt.traceEventEnd();
    L28:
        return r3;
    L23:
        if (r2 != Composer.Companion.getEmpty()) goto L25;
    L18:
        if ((r9 & 48) != 32) goto L20;
    L10:
        if ((r9 & 6) == 4) goto L11;
        r0 = false;
        goto L14
    }

    private static final float flingBehavior$lambda$2$lambda$1(PagerState r0, LayoutDirection r1, float r2, float r3, float r4, float r5) {
        return PagerSnapLayoutInfoProviderKt.calculateFinalSnappingBound(r0, r1, r2, r3, r4, r5);
    }

    public final TargetedFlingBehavior flingBehavior(final PagerState r7, PagerSnapDistance r8, DecayAnimationSpec<Float> r9, AnimationSpec<Float> r10, final float r11, Composer r12, int r13, int r14) {
        boolean r1 = true;
        if ((r14 & 2) == 0) goto L6;
        r8 = PagerSnapDistance.Companion.atMost(1);
    L6:
        if ((r14 & 4) == 0) goto L9;
        r9 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(r12, 0);
    L9:
        if ((r14 & 8) == 0) goto L12;
        r10 = AnimationSpecKt.spring$default(MenuKt.ClosedAlphaTarget, 400.0f, Float.valueOf(VisibilityThresholdsKt.getVisibilityThreshold(IntCompanionObject.INSTANCE)), 1, null);
    L12:
        if ((r14 & 16) == 0) goto L15;
        r11 = 0.5f;
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L18;
        ComposerKt.traceEventStart(1559769181, r13, -1, "androidx.compose.foundation.pager.PagerDefaults.flingBehavior (Pager.kt:417)");
    L18:
        if (MenuKt.ClosedAlphaTarget <= r11) goto L20;
    L22:
        boolean r15 = false;
    L23:
        if (r15 == true) goto L25;
        InlineClassHelperKt.throwIllegalArgumentException("snapPositionalThreshold should be a number between 0 and 1. You've specified " + r11);
    L25:
        Density r16 = (Density) r12.consume(CompositionLocalsKt.getLocalDensity());
        final LayoutDirection r0 = (LayoutDirection) r12.consume(CompositionLocalsKt.getLocalLayoutDirection());
        if (((r13 & 14) ^ 6) <= 4) goto L30;
        if (r12.changed(r7) == false) goto L30;
    L31:
        boolean r3 = true;
    L33:
        boolean r4 = (r3 | r12.changed(r9)) | r12.changed(r10);
        if (((r13 & 112) ^ 48) <= 32) goto L38;
        if (r12.changed(r8) == false) goto L38;
    L41:
        boolean r17 = ((r4 | r1) | r12.changed(r16)) | r12.changed(r0.ordinal());
        Object r18 = r12.rememberedValue();
        if (r17 == false) goto L44;
    L45:
        r18 = SnapFlingBehaviorKt.snapFlingBehavior(PagerSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(r7, r8, new i(r7, r0, r11)), r9, r10);
        r12.updateRememberedValue(r18);
    L46:
        TargetedFlingBehavior r19 = (TargetedFlingBehavior) r18;
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        return r19;
    L44:
        if (r18 != Composer.Companion.getEmpty()) goto L46;
    L38:
        if ((r13 & 48) == 32) goto L41;
        r1 = false;
    L30:
        if ((r13 & 6) == 4) goto L31;
        r3 = false;
        goto L33
    L20:
        if (r11 > 1.0f) goto L22;
        r15 = true;
        goto L23
    }
}
