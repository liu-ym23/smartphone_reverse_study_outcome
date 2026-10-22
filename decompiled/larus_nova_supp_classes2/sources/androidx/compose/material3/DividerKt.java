package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\t\u001a-\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"HorizontalDivider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "HorizontalDivider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "VerticalDivider", "VerticalDivider-9IZ8Weo", "Divider", "Divider-9IZ8Weo", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DividerKt {
    private static final Unit Divider_9IZ8Weo$lambda$6(Modifier r7, float r8, long r9, int r11, int r12, Composer r13, int r14) {
        m2633Divider9IZ8Weo(r7, r8, r9, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit HorizontalDivider_9IZ8Weo$lambda$2(Modifier r7, float r8, long r9, int r11, int r12, Composer r13, int r14) {
        m2634HorizontalDivider9IZ8Weo(r7, r8, r9, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit VerticalDivider_9IZ8Weo$lambda$5(Modifier r7, float r8, long r9, int r11, int r12, Composer r13, int r14) {
        m2635VerticalDivider9IZ8Weo(r7, r8, r9, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, float r1, long r2, int r4, int r5, Composer r6, int r7) {
        return VerticalDivider_9IZ8Weo$lambda$5(r0, r1, r2, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit b(Modifier r0, float r1, long r2, int r4, int r5, Composer r6, int r7) {
        return HorizontalDivider_9IZ8Weo$lambda$2(r0, r1, r2, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit c(Modifier r0, float r1, long r2, int r4, int r5, Composer r6, int r7) {
        return Divider_9IZ8Weo$lambda$6(r0, r1, r2, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit d(float r0, long r1, DrawScope r3) {
        return HorizontalDivider_9IZ8Weo$lambda$1$lambda$0(r0, r1, r3);
    }

    public static /* synthetic */ Unit e(float r0, long r1, DrawScope r3) {
        return VerticalDivider_9IZ8Weo$lambda$4$lambda$3(r0, r1, r3);
    }

    private static final Unit HorizontalDivider_9IZ8Weo$lambda$1$lambda$0(float r17, long r18, DrawScope r20) {
        float r7 = r20.toPx-0680j_4(r17);
        float r3 = 2;
        float r2 = r20.toPx-0680j_4(r17) / r3;
        long r4 = Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r2)) & 4294967295L));
        float r6 = Float.intBitsToFloat((int) (r20.getSize-NH-jbRc() >> 32));
        float r0 = r20.toPx-0680j_4(r17) / r3;
        DrawScope.-CC.drawLine-NGM6Ib0$default(r20, r18, r4, Offset.constructor-impl((Float.floatToRawIntBits(r6) << 32) | (((long) Float.floatToRawIntBits(r0)) & 4294967295L)), r7, 0, null, MenuKt.ClosedAlphaTarget, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    private static final Unit VerticalDivider_9IZ8Weo$lambda$4$lambda$3(float r17, long r18, DrawScope r20) {
        float r7 = r20.toPx-0680j_4(r17);
        float r3 = 2;
        long r4 = Offset.constructor-impl((Float.floatToRawIntBits(r20.toPx-0680j_4(r17) / r3) << 32) | (((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L));
        float r0 = r20.toPx-0680j_4(r17) / r3;
        float r5 = Float.intBitsToFloat((int) (r20.getSize-NH-jbRc() & 4294967295L));
        DrawScope.-CC.drawLine-NGM6Ib0$default(r20, r18, r4, Offset.constructor-impl((Float.floatToRawIntBits(r0) << 32) | (((long) Float.floatToRawIntBits(r5)) & 4294967295L)), r7, 0, null, MenuKt.ClosedAlphaTarget, null, 0, 496, null);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Renamed to HorizontalDivider", replaceWith = @ReplaceWith(expression = "HorizontalDivider(modifier, thickness, color)", imports = {}))
    /* JADX INFO: renamed from: Divider-9IZ8Weo, reason: not valid java name */
    public static final void m2633Divider9IZ8Weo(Modifier r16, float r17, long r18, Composer r20, final int r21, final int r22) {
        Composer r1 = r20.startRestartGroup(1562471785);
        int r2 = r22 & 1;
        if (r2 == 0) goto L6;
        int r4 = r21 | 6;
        Modifier r3 = r16;
    L13:
        int r6 = r22 & 2;
        if (r6 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        float r7 = r17;
    L25:
        if ((r21 & 384) == 0) goto L27;
        long r8 = r18;
    L36:
        if ((r4 & 147) == 146) goto L38;
        boolean r10 = true;
    L40:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L70;
        r1.startDefaults();
        if ((r21 & 1) != 0) goto L44;
    L51:
        if (r2 == 0) goto L53;
        Modifier r5 = Modifier.Companion;
    L54:
        if (r6 == 0) goto L56;
        float r9 = DividerDefaults.INSTANCE.m2632getThicknessD9Ej5fM();
    L58:
        if ((r22 & 4) != 0) goto L59;
    L50:
        long r14 = r8;
    L60:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L64;
        ComposerKt.traceEventStart(1562471785, r4, -1, "androidx.compose.material3.Divider (Divider.kt:99)");
    L64:
        if (Dp.equals-impl0(r9, Dp.Companion.getHairline-D9Ej5fM()) == false) goto L66;
        r1.startReplaceGroup(-1258250053);
        float r0 = Dp.constructor-impl(1.0f / ((Density) r1.consume(CompositionLocalsKt.getLocalDensity())).getDensity());
        r1.endReplaceGroup();
    L67:
        BoxKt.Box(BackgroundKt.m342backgroundbw27NRU$default(SizeKt.m1000height3ABfNKs(SizeKt.fillMaxWidth$default(r5, MenuKt.ClosedAlphaTarget, 1, null), r0), r14, null, 2, null), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L71;
        ComposerKt.traceEventEnd();
    L71:
        ScopeUpdateScope r11 = r1.endRestartGroup();
        if (r11 == null) goto L75;
        final Modifier r12 = r5;
        final float r13 = r9;
        final long r15 = r14;
        r11.updateScope(new j9(r12, r13, r15, r21, r22));
        return;
    L75:
        return;
    L66:
        r1.startReplaceGroup(-1258183496);
        r1.endReplaceGroup();
        r0 = r9;
        goto L67
    L59:
        r4 = r4 & (-897);
        r14 = DividerDefaults.INSTANCE.getColor(r1, 6);
        goto L60
    L56:
        r9 = r7;
        goto L58
    L53:
        r5 = r3;
        goto L54
    L44:
        if (r1.getDefaultsInvalid() == true) goto L51;
        r1.skipToGroupEnd();
        if ((r22 & 4) == 0) goto L49;
        r4 = r4 & (-897);
    L49:
        r5 = r3;
        r9 = r7;
        goto L50
    L70:
        r1.skipToGroupEnd();
        r5 = r3;
        r9 = r7;
        r14 = r8;
        goto L71
    L38:
        r10 = false;
        goto L40
    L27:
        if ((r22 & 4) != 0) goto L31;
        r8 = r18;
        if (r1.changed(r8) == false) goto L32;
        int r19 = 256;
    L33:
        r4 = r4 | r19;
    L32:
        r19 = 128;
        goto L33
    L31:
        r8 = r18;
        goto L32
    L17:
        if ((r21 & 48) != 0) goto L23;
        r7 = r17;
        if (r1.changed(r7) == false) goto L21;
        int r23 = 32;
    L22:
        r4 = r4 | r23;
        goto L25
    L21:
        r23 = 16;
        goto L22
    L6:
        if ((r21 & 6) != 0) goto L12;
        r3 = r16;
        if (r1.changed(r3) == false) goto L10;
        int r24 = 4;
    L11:
        r4 = r24 | r21;
        goto L13
    L10:
        r24 = 2;
        goto L11
    L12:
        r3 = r16;
        r4 = r21;
        goto L13
    }

    /* JADX INFO: renamed from: HorizontalDivider-9IZ8Weo, reason: not valid java name */
    public static final void m2634HorizontalDivider9IZ8Weo(Modifier r16, float r17, long r18, Composer r20, final int r21, final int r22) {
        Composer r1 = r20.startRestartGroup(75144485);
        int r2 = r22 & 1;
        if (r2 == 0) goto L6;
        int r4 = r21 | 6;
        Modifier r3 = r16;
    L13:
        int r6 = r22 & 2;
        if (r6 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        float r8 = r17;
    L25:
        if ((r21 & 384) != 0) goto L33;
        final long r11 = r18;
        if ((r22 & 4) == 0) goto L29;
    L31:
        int r9 = 128;
    L32:
        r4 = r4 | r9;
    L34:
        boolean r15 = true;
        if ((r4 & 147) == 146) goto L37;
        boolean r10 = true;
    L39:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L81;
        r1.startDefaults();
        if ((r21 & 1) != 0) goto L43;
    L49:
        if (r2 == 0) goto L51;
        Modifier r5 = Modifier.Companion;
    L52:
        if (r6 == 0) goto L54;
        final float r7 = DividerDefaults.INSTANCE.m2632getThicknessD9Ej5fM();
    L56:
        if ((r22 & 4) == 0) goto L58;
        r4 = r4 & (-897);
        r11 = DividerDefaults.INSTANCE.getColor(r1, 6);
    L58:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventStart(75144485, r4, -1, "androidx.compose.material3.HorizontalDivider (Divider.kt:53)");
    L61:
        Modifier r0 = SizeKt.m1000height3ABfNKs(SizeKt.fillMaxWidth$default(r5, MenuKt.ClosedAlphaTarget, 1, null), r7);
        if ((r4 & 112) != 32) goto L64;
        boolean r12 = true;
    L66:
        if (((r4 & 896) ^ 384) <= 256) goto L70;
        if (r1.changed(r11) == false) goto L70;
    L73:
        boolean r13 = r12 | r15;
        Object r14 = r1.rememberedValue();
        if (r13 == false) goto L76;
    L77:
        r14 = new k9(r7, r11);
        r1.updateRememberedValue(r14);
    L78:
        CanvasKt.Canvas(r0, (Function1) r14, r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L82;
        ComposerKt.traceEventEnd();
    L82:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L86;
        final Modifier r23 = r5;
        final float r24 = r7;
        final long r25 = r11;
        r19.updateScope(new l9(r23, r24, r25, r21, r22));
        return;
    L86:
        return;
    L76:
        if (r14 != Composer.Companion.getEmpty()) goto L78;
    L70:
        if ((r4 & 384) == 256) goto L73;
        r15 = false;
        goto L73
    L64:
        r12 = false;
        goto L66
    L54:
        r7 = r8;
        goto L56
    L51:
        r5 = r3;
        goto L52
    L43:
        if (r1.getDefaultsInvalid() == true) goto L49;
        r1.skipToGroupEnd();
        if ((r22 & 4) == 0) goto L48;
        r4 = r4 & (-897);
    L48:
        r5 = r3;
        r7 = r8;
        goto L58
    L81:
        r1.skipToGroupEnd();
        r5 = r3;
        r7 = r8;
        goto L82
    L37:
        r10 = false;
        goto L39
    L29:
        if (r1.changed(r11) == false) goto L31;
        r9 = 256;
        goto L32
    L33:
        r11 = r18;
        goto L34
    L17:
        if ((r21 & 48) != 0) goto L23;
        r8 = r17;
        if (r1.changed(r8) == false) goto L21;
        int r26 = 32;
    L22:
        r4 = r4 | r26;
        goto L25
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r21 & 6) != 0) goto L12;
        r3 = r16;
        if (r1.changed(r3) == false) goto L10;
        int r27 = 4;
    L11:
        r4 = r27 | r21;
        goto L13
    L10:
        r27 = 2;
        goto L11
    L12:
        r3 = r16;
        r4 = r21;
        goto L13
    }

    /* JADX INFO: renamed from: VerticalDivider-9IZ8Weo, reason: not valid java name */
    public static final void m2635VerticalDivider9IZ8Weo(Modifier r16, float r17, long r18, Composer r20, final int r21, final int r22) {
        Composer r1 = r20.startRestartGroup(-1534852205);
        int r2 = r22 & 1;
        if (r2 == 0) goto L6;
        int r4 = r21 | 6;
        Modifier r3 = r16;
    L13:
        int r6 = r22 & 2;
        if (r6 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        float r8 = r17;
    L25:
        if ((r21 & 384) != 0) goto L33;
        final long r11 = r18;
        if ((r22 & 4) == 0) goto L29;
    L31:
        int r9 = 128;
    L32:
        r4 = r4 | r9;
    L34:
        boolean r15 = true;
        if ((r4 & 147) == 146) goto L37;
        boolean r10 = true;
    L39:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L81;
        r1.startDefaults();
        if ((r21 & 1) != 0) goto L43;
    L49:
        if (r2 == 0) goto L51;
        Modifier r5 = Modifier.Companion;
    L52:
        if (r6 == 0) goto L54;
        final float r7 = DividerDefaults.INSTANCE.m2632getThicknessD9Ej5fM();
    L56:
        if ((r22 & 4) == 0) goto L58;
        r4 = r4 & (-897);
        r11 = DividerDefaults.INSTANCE.getColor(r1, 6);
    L58:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventStart(-1534852205, r4, -1, "androidx.compose.material3.VerticalDivider (Divider.kt:81)");
    L61:
        Modifier r0 = SizeKt.m1019width3ABfNKs(SizeKt.fillMaxHeight$default(r5, MenuKt.ClosedAlphaTarget, 1, null), r7);
        if ((r4 & 112) != 32) goto L64;
        boolean r12 = true;
    L66:
        if (((r4 & 896) ^ 384) <= 256) goto L70;
        if (r1.changed(r11) == false) goto L70;
    L73:
        boolean r13 = r12 | r15;
        Object r14 = r1.rememberedValue();
        if (r13 == false) goto L76;
    L77:
        r14 = new h9(r7, r11);
        r1.updateRememberedValue(r14);
    L78:
        CanvasKt.Canvas(r0, (Function1) r14, r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L82;
        ComposerKt.traceEventEnd();
    L82:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L86;
        final Modifier r23 = r5;
        final float r24 = r7;
        final long r25 = r11;
        r19.updateScope(new i9(r23, r24, r25, r21, r22));
        return;
    L86:
        return;
    L76:
        if (r14 != Composer.Companion.getEmpty()) goto L78;
    L70:
        if ((r4 & 384) == 256) goto L73;
        r15 = false;
        goto L73
    L64:
        r12 = false;
        goto L66
    L54:
        r7 = r8;
        goto L56
    L51:
        r5 = r3;
        goto L52
    L43:
        if (r1.getDefaultsInvalid() == true) goto L49;
        r1.skipToGroupEnd();
        if ((r22 & 4) == 0) goto L48;
        r4 = r4 & (-897);
    L48:
        r5 = r3;
        r7 = r8;
        goto L58
    L81:
        r1.skipToGroupEnd();
        r5 = r3;
        r7 = r8;
        goto L82
    L37:
        r10 = false;
        goto L39
    L29:
        if (r1.changed(r11) == false) goto L31;
        r9 = 256;
        goto L32
    L33:
        r11 = r18;
        goto L34
    L17:
        if ((r21 & 48) != 0) goto L23;
        r8 = r17;
        if (r1.changed(r8) == false) goto L21;
        int r26 = 32;
    L22:
        r4 = r4 | r26;
        goto L25
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r21 & 6) != 0) goto L12;
        r3 = r16;
        if (r1.changed(r3) == false) goto L10;
        int r27 = 4;
    L11:
        r4 = r27 | r21;
        goto L13
    L10:
        r27 = 2;
        goto L11
    L12:
        r3 = r16;
        r4 = r21;
        goto L13
    }
}
