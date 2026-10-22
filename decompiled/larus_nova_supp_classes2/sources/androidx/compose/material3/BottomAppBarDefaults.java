package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.material3.tokens.DockedToolbarTokens;
import androidx.compose.material3.tokens.FabSecondaryContainerTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JK\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010,H\u0007¢\u0006\u0002\u0010-R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0007R\u0014\u0010\u0017\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001e¨\u0006."}, d2 = {"Landroidx/compose/material3/BottomAppBarDefaults;", "", "<init>", "()V", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "bottomAppBarFabColor", "getBottomAppBarFabColor", "FlexibleContentPadding", "getFlexibleContentPadding$material3", "FlexibleBottomAppBarHeight", "getFlexibleBottomAppBarHeight-D9Ej5fM$material3", "FlexibleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getFlexibleHorizontalArrangement$material3", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "FlexibleFixedHorizontalArrangement", "getFlexibleFixedHorizontalArrangement$material3", "exitAlwaysScrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "state", "Landroidx/compose/material3/BottomAppBarState;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/BottomAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarScrollBehavior;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomAppBarDefaults {
    public static final int $stable = 0;
    private static final float ContainerElevation = 0.0f;
    private static final PaddingValues ContentPadding = null;
    private static final float FlexibleBottomAppBarHeight = 0.0f;
    private static final PaddingValues FlexibleContentPadding = null;
    private static final Arrangement.Horizontal FlexibleFixedHorizontalArrangement = null;
    private static final Arrangement.Horizontal FlexibleHorizontalArrangement = null;
    public static final BottomAppBarDefaults INSTANCE = null;

    private BottomAppBarDefaults() {
    }

    public static /* synthetic */ boolean a() {
        return exitAlwaysScrollBehavior$lambda$1$lambda$0();
    }

    private static final boolean exitAlwaysScrollBehavior$lambda$1$lambda$0() {
        return true;
    }

    static {
        INSTANCE = new BottomAppBarDefaults();
        ContainerElevation = Dp.constructor-impl(0);
        ContentPadding = PaddingKt.m957PaddingValuesa9UjIt4$default(AppBarKt.access$getBottomAppBarHorizontalPadding$p(), AppBarKt.getBottomAppBarVerticalPadding(), AppBarKt.access$getBottomAppBarHorizontalPadding$p(), MenuKt.ClosedAlphaTarget, 8, null);
        DockedToolbarTokens r0 = DockedToolbarTokens.INSTANCE;
        FlexibleContentPadding = PaddingKt.m957PaddingValuesa9UjIt4$default(r0.getContainerLeadingSpace-D9Ej5fM(), MenuKt.ClosedAlphaTarget, r0.getContainerTrailingSpace-D9Ej5fM(), MenuKt.ClosedAlphaTarget, 10, null);
        FlexibleBottomAppBarHeight = r0.getContainerHeight-D9Ej5fM();
        Arrangement r1 = Arrangement.INSTANCE;
        FlexibleHorizontalArrangement = r1.getSpaceBetween();
        FlexibleFixedHorizontalArrangement = r1.m807spacedByD5KLDUw(r0.getContainerMaxSpacing-D9Ej5fM(), Alignment.Companion.getCenterHorizontally());
    }

    /* JADX INFO: renamed from: getContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m2330getContainerElevationD9Ej5fM() {
        return ContainerElevation;
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    /* JADX INFO: renamed from: getFlexibleBottomAppBarHeight-D9Ej5fM$material3, reason: not valid java name */
    public final float m2331getFlexibleBottomAppBarHeightD9Ej5fM$material3() {
        return FlexibleBottomAppBarHeight;
    }

    public final PaddingValues getFlexibleContentPadding$material3() {
        return FlexibleContentPadding;
    }

    public final Arrangement.Horizontal getFlexibleFixedHorizontalArrangement$material3() {
        return FlexibleFixedHorizontalArrangement;
    }

    public final Arrangement.Horizontal getFlexibleHorizontalArrangement$material3() {
        return FlexibleHorizontalArrangement;
    }

    public final long getBottomAppBarFabColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1464561486, r5, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-bottomAppBarFabColor> (AppBar.kt:2155)");
    L5:
        long r6 = ColorSchemeKt.getValue(FabSecondaryContainerTokens.INSTANCE.getContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getContainerColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-368340078, r5, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-containerColor> (AppBar.kt:2128)");
    L5:
        long r6 = ColorSchemeKt.getValue(BottomAppBarTokens.INSTANCE.getContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final WindowInsets getWindowInsets(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(688896409, r5, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-windowInsets> (AppBar.kt:2147)");
    L5:
        WindowInsets r6 = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, r4, 6);
        WindowInsetsSides.Companion r7 = WindowInsetsSides.Companion;
        WindowInsets r8 = WindowInsetsKt.m1046onlybOOhFvg(r6, WindowInsetsSides.m1060plusgK_yJZ4(r7.m1070getHorizontalJoeWqyM(), r7.m1068getBottomJoeWqyM()));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r8;
    }

    public final BottomAppBarScrollBehavior exitAlwaysScrollBehavior(BottomAppBarState r8, Function0<Boolean> r9, AnimationSpec<Float> r10, DecayAnimationSpec<Float> r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L6;
        r8 = AppBarKt.rememberBottomAppBarState(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r12, 0, 7);
    L6:
        if ((r14 & 2) == 0) goto L12;
        Object r15 = r12.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L10;
        r15 = new o1();
        r12.updateRememberedValue(r15);
    L10:
        r9 = (Function0) r15;
    L12:
        if ((r14 & 4) == 0) goto L14;
        r10 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, r12, 6);
    L14:
        boolean r0 = false;
        if ((r14 & 8) == 0) goto L18;
        r11 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(r12, 0);
    L18:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(457144034, r13, -1, "androidx.compose.material3.BottomAppBarDefaults.exitAlwaysScrollBehavior (AppBar.kt:2208)");
    L21:
        if (((r13 & 14) ^ 6) <= 4) goto L25;
        if (r12.changed(r8) == false) goto L25;
    L26:
        boolean r16 = true;
    L29:
        if (((r13 & 112) ^ 48) <= 32) goto L33;
        if (r12.changed(r9) == false) goto L33;
    L34:
        r0 = true;
    L35:
        boolean r17 = ((r16 | r0) | r12.changed(r10)) | r12.changed(r11);
        Object r18 = r12.rememberedValue();
        if (r17 == false) goto L38;
    L39:
        r18 = new ExitAlwaysScrollBehavior(r8, r10, r11, r9);
        r12.updateRememberedValue(r18);
    L40:
        ExitAlwaysScrollBehavior r19 = (ExitAlwaysScrollBehavior) r18;
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
    L43:
        return r19;
    L38:
        if (r18 != Composer.Companion.getEmpty()) goto L40;
    L33:
        if ((r13 & 48) != 32) goto L35;
    L25:
        if ((r13 & 6) == 4) goto L26;
        r16 = false;
        goto L29
    }
}
