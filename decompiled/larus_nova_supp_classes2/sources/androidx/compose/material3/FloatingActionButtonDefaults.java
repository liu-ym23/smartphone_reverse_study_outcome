package androidx.compose.material3;

import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabBaselineTokens;
import androidx.compose.material3.tokens.FabLargeTokens;
import androidx.compose.material3.tokens.FabPrimaryContainerTokens;
import androidx.compose.material3.tokens.FabSmallTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010\u001f\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u0005H\u0007¢\u0006\u0004\b \u0010\u001eJ5\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\t\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonDefaults;", "", "<init>", "()V", "LargeIconSize", "Landroidx/compose/ui/unit/Dp;", "getLargeIconSize-D9Ej5fM", "()F", "F", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "smallShape", "getSmallShape", "largeShape", "getLargeShape", "extendedFabShape", "getExtendedFabShape", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "elevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/FloatingActionButtonElevation;", "loweredElevation", "loweredElevation-xZ9-QkE", "bottomAppBarFabElevation", "bottomAppBarFabElevation-a9UjIt4", "(FFFF)Landroidx/compose/material3/FloatingActionButtonElevation;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FloatingActionButtonDefaults {
    public static final int $stable = 0;
    public static final FloatingActionButtonDefaults INSTANCE = null;
    private static final float LargeIconSize = 0.0f;

    private FloatingActionButtonDefaults() {
    }

    static {
        INSTANCE = new FloatingActionButtonDefaults();
        LargeIconSize = Dp.constructor-impl(36);
    }

    /* JADX INFO: renamed from: getLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2721getLargeIconSizeD9Ej5fM() {
        return LargeIconSize;
    }

    public final long getContainerColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1855656391, r5, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-containerColor> (FloatingActionButton.kt:529)");
    L5:
        long r6 = ColorSchemeKt.getValue(FabPrimaryContainerTokens.INSTANCE.getContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getExtendedFabShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-536021915, r5, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-extendedFabShape> (FloatingActionButton.kt:525)");
    L5:
        Shape r6 = ShapesKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getLargeShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1835912187, r5, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-largeShape> (FloatingActionButton.kt:521)");
    L5:
        Shape r6 = ShapesKt.getValue(FabLargeTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-53247565, r5, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-shape> (FloatingActionButton.kt:513)");
    L5:
        Shape r6 = ShapesKt.getValue(FabBaselineTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getSmallShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(394933381, r5, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-smallShape> (FloatingActionButton.kt:517)");
    L5:
        Shape r6 = ShapesKt.getValue(FabSmallTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    /* JADX INFO: renamed from: bottomAppBarFabElevation-a9UjIt4, reason: not valid java name */
    public final FloatingActionButtonElevation m2719bottomAppBarFabElevationa9UjIt4(float r8, float r9, float r10, float r11) {
        return new FloatingActionButtonElevation(r8, r9, r10, r11, null);
    }

    /* JADX INFO: renamed from: bottomAppBarFabElevation-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ FloatingActionButtonElevation m2718bottomAppBarFabElevationa9UjIt4$default(FloatingActionButtonDefaults r1, float r2, float r3, float r4, float r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = Dp.constructor-impl(0);
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = Dp.constructor-impl(0);
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = Dp.constructor-impl(0);
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = Dp.constructor-impl(0);
    L15:
        return r1.m2719bottomAppBarFabElevationa9UjIt4(r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m2720elevationxZ9QkE(float r4, float r5, float r6, float r7, Composer r8, int r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r4 = FabPrimaryContainerTokens.INSTANCE.getContainerElevation-D9Ej5fM();
    L6:
        if ((r10 & 2) == 0) goto L8;
        r5 = FabPrimaryContainerTokens.INSTANCE.getPressedContainerElevation-D9Ej5fM();
    L8:
        float r11 = r5;
        if ((r10 & 4) == 0) goto L11;
        r6 = FabPrimaryContainerTokens.INSTANCE.getFocusedContainerElevation-D9Ej5fM();
    L11:
        float r0 = r6;
        if ((r10 & 8) == 0) goto L14;
        r7 = FabPrimaryContainerTokens.INSTANCE.getHoveredContainerElevation-D9Ej5fM();
    L14:
        float r12 = r7;
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(-241106249, r9, -1, "androidx.compose.material3.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:549)");
    L17:
        FloatingActionButtonElevation r1 = new FloatingActionButtonElevation(r4, r11, r0, r12, null);
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r1;
    }

    /* JADX INFO: renamed from: loweredElevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m2722loweredElevationxZ9QkE(float r4, float r5, float r6, float r7, Composer r8, int r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r4 = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
    L6:
        if ((r10 & 2) == 0) goto L8;
        r5 = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
    L8:
        float r11 = r5;
        if ((r10 & 4) == 0) goto L11;
        r6 = ElevationTokens.INSTANCE.getLevel1-D9Ej5fM();
    L11:
        float r0 = r6;
        if ((r10 & 8) == 0) goto L14;
        r7 = ElevationTokens.INSTANCE.getLevel2-D9Ej5fM();
    L14:
        float r12 = r7;
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(-285065125, r9, -1, "androidx.compose.material3.FloatingActionButtonDefaults.loweredElevation (FloatingActionButton.kt:573)");
    L17:
        FloatingActionButtonElevation r1 = new FloatingActionButtonElevation(r4, r11, r0, r12, null);
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r1;
    }
}
