package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u000f2\b\b\u0002\u0010&\u001a\u00020\u000f2\b\b\u0002\u0010'\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u000bH\u0007¢\u0006\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\u0015\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0017\u001a\u00020\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u001e\u0010\u0011R\u0016\u0010\u001f\u001a\u00020\u000fX\u0080\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b \u0010\u0011¨\u0006+"}, d2 = {"Landroidx/compose/material3/BottomSheetDefaults;", "", "<init>", "()V", "HiddenShape", "Landroidx/compose/ui/graphics/Shape;", "getHiddenShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "ExpandedShape", "getExpandedShape", "ContainerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ScrimColor", "getScrimColor", "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "SheetMaxWidth", "getSheetMaxWidth-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "PositionalThreshold", "getPositionalThreshold-D9Ej5fM$material3", "VelocityThreshold", "getVelocityThreshold-D9Ej5fM$material3", "DragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "width", "height", "shape", "color", "DragHandle-lgZ2HuY", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetDefaults {
    public static final int $stable = 0;
    private static final float Elevation = 0.0f;
    public static final BottomSheetDefaults INSTANCE = null;
    private static final float PositionalThreshold = 0.0f;
    private static final float SheetMaxWidth = 0.0f;
    private static final float SheetPeekHeight = 0.0f;
    private static final float VelocityThreshold = 0.0f;

    private BottomSheetDefaults() {
    }

    private static final Unit DragHandle_lgZ2HuY$lambda$2(BottomSheetDefaults r11, Modifier r12, float r13, float r14, Shape r15, long r16, int r18, int r19, Composer r20, int r21) {
        r11.m2332DragHandlelgZ2HuY(r12, r13, r14, r15, r16, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(String r0, SemanticsPropertyReceiver r1) {
        return DragHandle_lgZ2HuY$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ Unit b(BottomSheetDefaults r0, Modifier r1, float r2, float r3, Shape r4, long r5, int r7, int r8, Composer r9, int r10) {
        return DragHandle_lgZ2HuY$lambda$2(r0, r1, r2, r3, r4, r5, r7, r8, r9, r10);
    }

    static {
        INSTANCE = new BottomSheetDefaults();
        Elevation = SheetBottomTokens.INSTANCE.getDockedModalContainerElevation-D9Ej5fM();
        float r0 = 56;
        SheetPeekHeight = Dp.constructor-impl(r0);
        SheetMaxWidth = Dp.constructor-impl(640);
        PositionalThreshold = Dp.constructor-impl(r0);
        VelocityThreshold = Dp.constructor-impl(125);
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m2333getElevationD9Ej5fM() {
        return Elevation;
    }

    /* JADX INFO: renamed from: getPositionalThreshold-D9Ej5fM$material3, reason: not valid java name */
    public final float m2334getPositionalThresholdD9Ej5fM$material3() {
        return PositionalThreshold;
    }

    /* JADX INFO: renamed from: getSheetMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m2335getSheetMaxWidthD9Ej5fM() {
        return SheetMaxWidth;
    }

    /* JADX INFO: renamed from: getSheetPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m2336getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }

    /* JADX INFO: renamed from: getVelocityThreshold-D9Ej5fM$material3, reason: not valid java name */
    public final float m2337getVelocityThresholdD9Ej5fM$material3() {
        return VelocityThreshold;
    }

    private static final Unit DragHandle_lgZ2HuY$lambda$1$lambda$0(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        return Unit.INSTANCE;
    }

    public final long getContainerColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(433375448, r5, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ContainerColor> (SheetDefaults.kt:383)");
    L5:
        long r6 = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getExpandedShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1683783414, r5, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ExpandedShape> (SheetDefaults.kt:379)");
    L5:
        Shape r6 = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getHiddenShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1971658024, r5, -1, "androidx.compose.material3.BottomSheetDefaults.<get-HiddenShape> (SheetDefaults.kt:375)");
    L5:
        Shape r6 = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedMinimizedContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getScrimColor(Composer r10, int r11) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2040719176, r11, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ScrimColor> (SheetDefaults.kt:390)");
    L5:
        long r12 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), r10, 6), 0.32f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r12;
    }

    public final WindowInsets getWindowInsets(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-511309409, r5, -1, "androidx.compose.material3.BottomSheetDefaults.<get-windowInsets> (SheetDefaults.kt:401)");
    L5:
        WindowInsets r6 = WindowInsets_androidKt.getSafeDrawing(WindowInsets.Companion, r4, 6);
        WindowInsetsSides.Companion r7 = WindowInsetsSides.Companion;
        WindowInsets r8 = WindowInsetsKt.m1046onlybOOhFvg(r6, WindowInsetsSides.m1060plusgK_yJZ4(r7.m1068getBottomJoeWqyM(), r7.m1074getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r8;
    }

    /* JADX INFO: renamed from: DragHandle-lgZ2HuY, reason: not valid java name */
    public final void m2332DragHandlelgZ2HuY(Modifier r25, float r26, float r27, Shape r28, long r29, Composer r31, final int r32, final int r33) {
        Composer r1 = r31.startRestartGroup(-1364277227);
        int r2 = r33 & 1;
        if (r2 == 0) goto L6;
        int r4 = r32 | 6;
        Modifier r3 = r25;
    L13:
        int r5 = r33 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        final float r6 = r26;
    L24:
        int r7 = r33 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        float r9 = r27;
    L36:
        if ((r32 & 3072) == 0) goto L38;
        Shape r10 = r28;
    L47:
        if ((r32 & 24576) == 0) goto L49;
        long r11 = r29;
    L58:
        if ((r4 & 9363) == 9362) goto L60;
        boolean r13 = true;
    L62:
        if (r1.shouldExecute(r13, r4 & 1) == false) goto L101;
        r1.startDefaults();
        if ((r32 & 1) != 0) goto L66;
    L76:
        if (r2 == 0) goto L78;
        final Modifier r8 = Modifier.Companion;
    L79:
        if (r5 == 0) goto L81;
        r6 = SheetBottomTokens.INSTANCE.getDockedDragHandleWidth-D9Ej5fM();
    L81:
        if (r7 == 0) goto L84;
        r9 = SheetBottomTokens.INSTANCE.getDockedDragHandleHeight-D9Ej5fM();
    L84:
        if ((r33 & 8) == 0) goto L87;
        r4 = r4 & (-7169);
        r10 = MaterialTheme.INSTANCE.getShapes(r1, 6).getExtraLarge();
    L87:
        if ((r33 & 16) != 0) goto L88;
    L75:
        int r12 = r4;
        final float r14 = r9;
        Shape r15 = r10;
        long r22 = r11;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L92;
        ComposerKt.traceEventStart(-1364277227, r12, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:415)");
    L92:
        final String r0 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911715), r1, 0);
        Modifier r16 = PaddingKt.m962paddingVpY3zN4$default(r8, MenuKt.ClosedAlphaTarget, SheetDefaultsKt.access$getDragHandleVerticalPadding$p(), 1, null);
        boolean r17 = r1.changed(r0);
        Object r18 = r1.rememberedValue();
        if (r17 == false) goto L95;
    L96:
        r18 = new r1(r0);
        r1.updateRememberedValue(r18);
    L97:
        int r19 = r12 >> 6;
        SurfaceKt.m3213SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(r16, false, (Function1) r18, 1, null), r15, r22, 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, ComposableLambdaKt.rememberComposableLambda(-1039573072, true, new BottomSheetDefaults$DragHandle$2(r6, r14), r1, 54), r1, ((r19 & 112) | 12582912) | (r19 & 896), androidx.compose.material.MenuKt.InTransitionDuration);
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventEnd();
    L100:
        final Shape r20 = r15;
        final float r21 = r14;
        final float r23 = r6;
        final long r24 = r22;
    L102:
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L106;
        r110.updateScope(new s1(this, r8, r23, r21, r20, r24, r32, r33));
        return;
    L106:
        return;
    L95:
        if (r18 != Composer.Companion.getEmpty()) goto L97;
    L88:
        r11 = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), r1, 6);
        r4 = r4 & (-57345);
        goto L75
    L78:
        r8 = r3;
        goto L79
    L66:
        if (r1.getDefaultsInvalid() == true) goto L76;
        r1.skipToGroupEnd();
        if ((r33 & 8) == 0) goto L72;
        r4 = r4 & (-7169);
    L72:
        if ((r33 & 16) == 0) goto L74;
        r4 = r4 & (-57345);
    L74:
        r8 = r3;
        goto L75
    L101:
        r1.skipToGroupEnd();
        r8 = r3;
        r23 = r6;
        r21 = r9;
        r20 = r10;
        r24 = r11;
        goto L102
    L60:
        r13 = false;
        goto L62
    L49:
        if ((r33 & 16) != 0) goto L53;
        r11 = r29;
        if (r1.changed(r11) == false) goto L54;
        int r111 = 16384;
    L55:
        r4 = r4 | r111;
    L54:
        r111 = 8192;
        goto L55
    L53:
        r11 = r29;
        goto L54
    L38:
        if ((r33 & 8) != 0) goto L42;
        r10 = r28;
        if (r1.changed(r10) == false) goto L43;
        int r112 = 2048;
    L44:
        r4 = r4 | r112;
    L43:
        r112 = 1024;
        goto L44
    L42:
        r10 = r28;
        goto L43
    L28:
        if ((r32 & 384) != 0) goto L34;
        r9 = r27;
        if (r1.changed(r9) == false) goto L32;
        int r113 = 256;
    L33:
        r4 = r4 | r113;
        goto L36
    L32:
        r113 = 128;
        goto L33
    L17:
        if ((r32 & 48) != 0) goto L23;
        r6 = r26;
        if (r1.changed(r6) == false) goto L21;
        int r30 = 32;
    L22:
        r4 = r4 | r30;
        goto L24
    L21:
        r30 = 16;
        goto L22
    L6:
        if ((r32 & 6) != 0) goto L12;
        r3 = r25;
        if (r1.changed(r3) == false) goto L10;
        int r34 = 4;
    L11:
        r4 = r34 | r32;
        goto L13
    L10:
        r34 = 2;
        goto L11
    L12:
        r3 = r25;
        r4 = r32;
        goto L13
    }
}
