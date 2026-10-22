package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a`\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00142\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0092\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00142\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u001a\u0010\u001f\u001a5\u0010 \u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0004\b\"\u0010#\u001a)\u0010$\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\fH\u0003¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"Surface", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "onClick", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SurfaceKt {
    private static final Unit Surface_F_jzlyU$lambda$0(Modifier r13, Shape r14, long r15, long r17, BorderStroke r19, float r20, Function2 r21, int r22, int r23, Composer r24, int r25) {
        m2175SurfaceFjzlyU(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit Surface_LPr_se0$lambda$1(Function0 r16, Modifier r17, boolean r18, Shape r19, long r20, long r22, BorderStroke r24, float r25, MutableInteractionSource r26, Function2 r27, int r28, int r29, Composer r30, int r31) {
        m2176SurfaceLPr_se0(r16, r17, r18, r19, r20, r22, r24, r25, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), r29);
        return Unit.INSTANCE;
    }

    private static final Unit Surface_Ny5ogXk$lambda$2(boolean r17, Function0 r18, Modifier r19, boolean r20, Shape r21, long r22, long r24, BorderStroke r26, float r27, MutableInteractionSource r28, Function2 r29, int r30, int r31, int r32, Composer r33, int r34) {
        m2177SurfaceNy5ogXk(r17, r18, r19, r20, r21, r22, r24, r26, r27, r28, r29, r33, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31), r32);
        return Unit.INSTANCE;
    }

    private static final Unit Surface_Ny5ogXk$lambda$3(boolean r17, Function1 r18, Modifier r19, boolean r20, Shape r21, long r22, long r24, BorderStroke r26, float r27, MutableInteractionSource r28, Function2 r29, int r30, int r31, int r32, Composer r33, int r34) {
        m2178SurfaceNy5ogXk(r17, r18, r19, r20, r21, r22, r24, r26, r27, r28, r29, r33, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31), r32);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function0 r0, Modifier r1, boolean r2, Shape r3, long r4, long r6, BorderStroke r8, float r9, MutableInteractionSource r10, Function2 r11, int r12, int r13, Composer r14, int r15) {
        return Surface_LPr_se0$lambda$1(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit b(Modifier r0, Shape r1, long r2, long r4, BorderStroke r6, float r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        return Surface_F_jzlyU$lambda$0(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit c(boolean r1, Function1 r2, Modifier r3, boolean r4, Shape r5, long r6, long r8, BorderStroke r10, float r11, MutableInteractionSource r12, Function2 r13, int r14, int r15, int r16, Composer r17, int r18) {
        return Surface_Ny5ogXk$lambda$3(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit d(boolean r1, Function0 r2, Modifier r3, boolean r4, Shape r5, long r6, long r8, BorderStroke r10, float r11, MutableInteractionSource r12, Function2 r13, int r14, int r15, int r16, Composer r17, int r18) {
        return Surface_Ny5ogXk$lambda$2(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    /* JADX INFO: renamed from: access$surface-8ww4TTg, reason: not valid java name */
    public static final /* synthetic */ Modifier m2179access$surface8ww4TTg(Modifier r0, Shape r1, long r2, BorderStroke r4, float r5) {
        return m2181surface8ww4TTg(r0, r1, r2, r4, r5);
    }

    /* JADX INFO: renamed from: access$surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    public static final /* synthetic */ long m2180access$surfaceColorAtElevationcq6XJ1M(long r0, ElevationOverlay r2, float r3, Composer r4, int r5) {
        return m2182surfaceColorAtElevationcq6XJ1M(r0, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: surface-8ww4TTg, reason: not valid java name */
    private static final Modifier m2181surface8ww4TTg(Modifier r10, Shape r11, long r12, BorderStroke r14, float r15) {
        Modifier r13 = ShadowKt.shadow-s4CzXII$default(r10, r15, r11, false, 0, 0, 24, null);
        if (r14 == null) goto L5;
        Modifier r16 = BorderKt.border(Modifier.Companion, r14, r11);
    L7:
        return ClipKt.clip(BackgroundKt.m341backgroundbw27NRU(r13.then(r16), r12, r11), r11);
    L5:
        r16 = Modifier.Companion;
        goto L7
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    private static final long m2182surfaceColorAtElevationcq6XJ1M(long r7, ElevationOverlay r9, float r10, Composer r11, int r12) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(1561611256, r12, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:479)");
    L6:
        if (Color.equals-impl0(r7, MaterialTheme.INSTANCE.getColors(r11, 6).m2003getSurface0d7_KjU()) == false) goto L9;
        if (r9 == null) goto L9;
        r11.startReplaceGroup(-1124594614);
        r7 = r9.mo2030apply7g2Lkgo(r7, r10, r11, ((r12 & 14) | ((r12 >> 3) & 112)) | ((r12 << 3) & 896));
        r11.endReplaceGroup();
    L11:
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r7;
    L9:
        r11.startReplaceGroup(-1124526507);
        r11.endReplaceGroup();
        goto L11
    }

    /* JADX INFO: renamed from: Surface-F-jzlyU, reason: not valid java name */
    public static final void m2175SurfaceFjzlyU(Modifier r26, Shape r27, long r28, long r30, BorderStroke r32, float r33, final Function2<? super Composer, ? super Integer, Unit> r34, Composer r35, final int r36, final int r37) {
        Composer r1 = r35.startRestartGroup(174096871);
        int r2 = r37 & 1;
        if (r2 == 0) goto L6;
        int r5 = r36 | 6;
    L13:
        int r6 = r37 & 2;
        if (r6 == 0) goto L17;
        r5 = r5 | 48;
    L23:
        Shape r7 = r27;
    L25:
        if ((r36 & 384) == 0) goto L27;
        long r8 = r28;
    L36:
        if ((r36 & 3072) == 0) goto L38;
        long r11 = r30;
    L46:
        int r13 = r37 & 16;
        if (r13 == 0) goto L50;
        r5 = r5 | 24576;
    L56:
        BorderStroke r14 = r32;
    L57:
        int r15 = r37 & 32;
        if (r15 == 0) goto L61;
        r5 = r5 | 196608;
    L68:
        if ((r37 & 64) == 0) goto L71;
        r5 = r5 | 1572864;
    L78:
        if ((r5 & 599187) == 599186) goto L80;
        boolean r0 = true;
    L82:
        if (r1.shouldExecute(r0, r5 & 1) == false) goto L118;
        r1.startDefaults();
        if ((r36 & 1) != 0) goto L86;
    L96:
        if (r2 == 0) goto L98;
        Modifier r3 = Modifier.Companion;
    L99:
        if (r6 == 0) goto L102;
        r7 = RectangleShapeKt.getRectangleShape();
    L102:
        if ((r37 & 4) == 0) goto L105;
        r5 = r5 & (-897);
        r8 = MaterialTheme.INSTANCE.getColors(r1, 6).m2003getSurface0d7_KjU();
    L105:
        if ((r37 & 8) == 0) goto L107;
        long r4 = ColorsKt.m2017contentColorForek8zF_U(r8, r1, (r5 >> 6) & 14);
        r5 = r5 & (-7169);
        r11 = r4;
    L107:
        if (r13 == 0) goto L109;
        r14 = null;
    L109:
        if (r15 != 0) goto L110;
    L95:
        float r9 = r33;
    L111:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventStart(174096871, r5, -1, "androidx.compose.material.Surface (Surface.kt:101)");
    L114:
        float r22 = Dp.constructor-impl(((Dp) r1.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).unbox-impl() + r9);
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r11)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(r22))}, ComposableLambdaKt.rememberComposableLambda(-2004281689, true, new SurfaceKt$Surface$1(r3, r7, r8, r22, r14, r9, r34), r1, 54), r1, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L117;
        ComposerKt.traceEventEnd();
    L117:
        final long r10 = r8;
        final long r12 = r11;
        final float r16 = r9;
        Modifier r17 = r3;
    L119:
        ScopeUpdateScope r18 = r1.endRestartGroup();
        if (r18 == null) goto L123;
        final Modifier r19 = r17;
        final Shape r20 = r7;
        final BorderStroke r21 = r14;
        r18.updateScope(new xa(r19, r20, r10, r12, r21, r16, r34, r36, r37));
        return;
    L123:
        return;
    L110:
        r9 = Dp.constructor-impl(0);
        goto L111
    L98:
        r3 = r26;
        goto L99
    L86:
        if (r1.getDefaultsInvalid() == true) goto L96;
        r1.skipToGroupEnd();
        if ((r37 & 4) == 0) goto L92;
        r5 = r5 & (-897);
    L92:
        if ((r37 & 8) == 0) goto L94;
        r5 = r5 & (-7169);
    L94:
        r3 = r26;
        goto L95
    L118:
        r1.skipToGroupEnd();
        r17 = r26;
        r10 = r8;
        r12 = r11;
        r16 = r33;
        goto L119
    L80:
        r0 = false;
        goto L82
    L71:
        if ((r36 & 1572864) != 0) goto L78;
        if (r1.changedInstance(r34) == false) goto L75;
        int r110 = 1048576;
    L76:
        r5 = r5 | r110;
        goto L78
    L75:
        r110 = 524288;
        goto L76
    L61:
        if ((r36 & 196608) != 0) goto L68;
        if (r1.changed(r33) == false) goto L65;
        int r111 = 131072;
    L66:
        r5 = r5 | r111;
        goto L68
    L65:
        r111 = 65536;
        goto L66
    L50:
        if ((r36 & 24576) != 0) goto L56;
        r14 = r32;
        if (r1.changed(r14) == false) goto L54;
        int r112 = 16384;
    L55:
        r5 = r5 | r112;
        goto L57
    L54:
        r112 = 8192;
        goto L55
    L38:
        if ((r37 & 8) != 0) goto L42;
        r11 = r30;
        if (r1.changed(r11) == false) goto L43;
        int r113 = 2048;
    L44:
        r5 = r5 | r113;
    L43:
        r113 = 1024;
        goto L44
    L42:
        r11 = r30;
        goto L43
    L27:
        if ((r37 & 4) != 0) goto L31;
        r8 = r28;
        if (r1.changed(r8) == false) goto L32;
        int r114 = 256;
    L33:
        r5 = r5 | r114;
    L32:
        r114 = 128;
        goto L33
    L31:
        r8 = r28;
        goto L32
    L17:
        if ((r36 & 48) != 0) goto L23;
        r7 = r27;
        if (r1.changed(r7) == false) goto L21;
        int r23 = 32;
    L22:
        r5 = r5 | r23;
        goto L25
    L21:
        r23 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r5 = r36;
        goto L13
    L8:
        if (r1.changed(r26) == false) goto L10;
        int r24 = 4;
    L11:
        r5 = r24 | r36;
        goto L13
    L10:
        r24 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Surface-LPr_se0, reason: not valid java name */
    public static final void m2176SurfaceLPr_se0(final Function0<Unit> r30, Modifier r31, boolean r32, Shape r33, long r34, long r36, BorderStroke r38, float r39, MutableInteractionSource r40, final Function2<? super Composer, ? super Integer, Unit> r41, Composer r42, final int r43, final int r44) {
        Composer r1 = r42.startRestartGroup(2141308794);
        if ((r44 & 1) == 0) goto L6;
        int r4 = r43 | 6;
    L13:
        int r5 = r44 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L24:
        int r7 = r44 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        boolean r8 = r32;
    L35:
        int r9 = r44 & 8;
        if (r9 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Shape r10 = r33;
    L47:
        if ((r43 & 24576) == 0) goto L49;
        long r11 = r34;
    L58:
        if ((196608 & r43) == 0) goto L60;
        int r15 = r4;
    L68:
        int r16 = r44 & 64;
        if (r16 == 0) goto L72;
        r15 = r15 | 1572864;
    L78:
        int r0 = r44 & 128;
        if (r0 == 0) goto L82;
        r15 = r15 | 12582912;
    L88:
        int r2 = r44 & 256;
        if (r2 == 0) goto L92;
        r15 = r15 | 100663296;
    L99:
        if ((r44 & 512) == 0) goto L102;
        r15 = r15 | 805306368;
    L110:
        if ((r15 & 306783379) == 306783378) goto L112;
        boolean r3 = true;
    L114:
        if (r1.shouldExecute(r3, r15 & 1) == false) goto L159;
        r1.startDefaults();
        if ((r43 & 1) != 0) goto L118;
    L127:
        if (r5 == 0) goto L129;
        Modifier r6 = Modifier.Companion;
    L130:
        if (r7 == 0) goto L132;
        r8 = true;
    L132:
        if (r9 == 0) goto L134;
        Shape r12 = RectangleShapeKt.getRectangleShape();
    L136:
        if ((r44 & 16) == 0) goto L138;
        long r13 = MaterialTheme.INSTANCE.getColors(r1, 6).m2003getSurface0d7_KjU();
        r15 = r15 & (-57345);
    L140:
        if ((r44 & 32) == 0) goto L142;
        long r14 = ColorsKt.m2017contentColorForek8zF_U(r13, r1, (r15 >> 12) & 14);
        r15 = (-458753) & r15;
    L143:
        if (r16 == 0) goto L145;
        BorderStroke r17 = null;
    L146:
        if (r0 == 0) goto L148;
        float r18 = Dp.constructor-impl(0);
    L149:
        if (r2 == 0) goto L151;
        MutableInteractionSource r19 = null;
    L152:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L155;
        ComposerKt.traceEventStart(2141308794, r15, -1, "androidx.compose.material.Surface (Surface.kt:207)");
    L155:
        final float r20 = Dp.constructor-impl(((Dp) r1.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).unbox-impl() + r18);
        final Modifier r110 = r6;
        final Shape r111 = r12;
        final long r112 = r13;
        final BorderStroke r21 = r17;
        final float r22 = r18;
        final MutableInteractionSource r23 = r19;
        final boolean r24 = r8;
        float r35 = r18;
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r14)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(r20))}, ComposableLambdaKt.rememberComposableLambda(-1766606150, true, new SurfaceKt$Surface$3(r110, r111, r112, r20, r21, r22, r23, r24, r30, r41), r1, 54), r1, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L158;
        ComposerKt.traceEventEnd();
    L158:
        final Shape r25 = r12;
        final long r26 = r13;
        final float r113 = r35;
        final BorderStroke r27 = r17;
        long r28 = r14;
        final MutableInteractionSource r114 = r19;
        final Modifier r29 = r6;
        final boolean r37 = r8;
        final long r45 = r28;
    L160:
        ScopeUpdateScope r115 = r1.endRestartGroup();
        if (r115 == null) goto L164;
        r115.updateScope(new wa(r30, r29, r37, r25, r26, r45, r27, r113, r114, r41, r43, r44));
        return;
    L164:
        return;
    L151:
        r19 = r40;
        goto L152
    L148:
        r18 = r39;
        goto L149
    L145:
        r17 = r38;
        goto L146
    L142:
        r14 = r36;
        goto L143
    L138:
        r13 = r11;
        goto L140
    L134:
        r12 = r10;
        goto L136
    L129:
        r6 = r31;
        goto L130
    L118:
        if (r1.getDefaultsInvalid() == true) goto L127;
        r1.skipToGroupEnd();
        if ((r44 & 16) == 0) goto L124;
        r15 = r15 & (-57345);
    L124:
        if ((r44 & 32) == 0) goto L126;
        r15 = r15 & (-458753);
    L126:
        r6 = r31;
        r17 = r38;
        r18 = r39;
        r19 = r40;
        r12 = r10;
        r13 = r11;
        r14 = r36;
        goto L152
    L159:
        r1.skipToGroupEnd();
        r29 = r31;
        r27 = r38;
        r37 = r8;
        r25 = r10;
        r26 = r11;
        r45 = r36;
        r113 = r39;
        r114 = r40;
        goto L160
    L112:
        r3 = false;
        goto L114
    L102:
        if ((r43 & 805306368) != 0) goto L110;
        if (r1.changedInstance(r41) == false) goto L106;
        int r116 = 536870912;
    L107:
        r15 = r15 | r116;
        goto L110
    L106:
        r116 = 268435456;
        goto L107
    L92:
        if ((r43 & 100663296) != 0) goto L99;
        if (r1.changed(r40) == false) goto L96;
        int r46 = 67108864;
    L97:
        r15 = r15 | r46;
        goto L99
    L96:
        r46 = 33554432;
        goto L97
    L82:
        if ((r43 & 12582912) != 0) goto L88;
        if (r1.changed(r39) == false) goto L86;
        int r117 = 8388608;
    L87:
        r15 = r15 | r117;
        goto L88
    L86:
        r117 = 4194304;
        goto L87
    L72:
        if ((r43 & 1572864) != 0) goto L78;
        if (r1.changed(r38) == false) goto L76;
        int r118 = 1048576;
    L77:
        r15 = r15 | r118;
        goto L78
    L76:
        r118 = 524288;
        goto L77
    L60:
        if ((r44 & 32) != 0) goto L64;
        int r119 = r4;
        if (r1.changed(r36) == false) goto L65;
        int r120 = 131072;
    L66:
        r15 = r119 | r120;
    L65:
        r120 = 65536;
        goto L66
    L64:
        r119 = r4;
        goto L65
    L49:
        if ((r44 & 16) != 0) goto L53;
        r11 = r34;
        if (r1.changed(r11) == false) goto L54;
        int r121 = 16384;
    L55:
        r4 = r4 | r121;
    L54:
        r121 = 8192;
        goto L55
    L53:
        r11 = r34;
        goto L54
    L39:
        if ((r43 & 3072) != 0) goto L45;
        r10 = r33;
        if (r1.changed(r10) == false) goto L43;
        int r122 = 2048;
    L44:
        r4 = r4 | r122;
        goto L47
    L43:
        r122 = 1024;
        goto L44
    L28:
        if ((r43 & 384) != 0) goto L34;
        r8 = r32;
        if (r1.changed(r8) == false) goto L32;
        int r47 = 256;
    L33:
        r4 = r4 | r47;
        goto L35
    L32:
        r47 = 128;
        goto L33
    L17:
        if ((r43 & 48) != 0) goto L24;
        if (r1.changed(r31) == false) goto L21;
        int r48 = 32;
    L22:
        r4 = r4 | r48;
        goto L24
    L21:
        r48 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r4 = r43;
        goto L13
    L8:
        if (r1.changedInstance(r30) == false) goto L10;
        int r49 = 4;
    L11:
        r4 = r49 | r43;
        goto L13
    L10:
        r49 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m2177SurfaceNy5ogXk(final boolean r33, final Function0<Unit> r34, Modifier r35, boolean r36, Shape r37, long r38, long r40, BorderStroke r42, float r43, MutableInteractionSource r44, final Function2<? super Composer, ? super Integer, Unit> r45, Composer r46, final int r47, final int r48, final int r49) {
        Composer r1 = r46.startRestartGroup(-258978402);
        if ((r49 & 1) == 0) goto L6;
        int r5 = r47 | 6;
    L14:
        if ((r49 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r7 = r49 & 4;
        if (r7 == 0) goto L28;
        r5 = r5 | 384;
    L35:
        int r9 = r49 & 8;
        if (r9 == 0) goto L39;
        r5 = r5 | 3072;
    L45:
        boolean r10 = r36;
    L46:
        int r11 = r49 & 16;
        if (r11 == 0) goto L50;
        r5 = r5 | 24576;
    L56:
        Shape r12 = r37;
    L58:
        if ((196608 & r47) != 0) goto L68;
        if ((r49 & 32) == 0) goto L62;
    L64:
        int r16 = 65536;
    L65:
        r5 = r5 | r16;
        goto L68
    L62:
        if (r1.changed(r38) == false) goto L64;
        r16 = 131072;
    L68:
        if ((r47 & 1572864) != 0) goto L77;
        if ((r49 & 64) == 0) goto L72;
    L74:
        int r17 = 524288;
    L75:
        r5 = r5 | r17;
        goto L77
    L72:
        if (r1.changed(r40) == false) goto L74;
        r17 = 1048576;
    L77:
        int r0 = r49 & 128;
        if (r0 == 0) goto L80;
        r5 = r5 | 12582912;
        BorderStroke r14 = r42;
    L87:
        int r13 = r49 & 256;
        if (r13 == 0) goto L91;
        r5 = r5 | 100663296;
    L97:
        int r2 = r49 & 512;
        if (r2 == 0) goto L101;
        r5 = r5 | 805306368;
    L108:
        if ((r49 & 1024) == 0) goto L111;
        int r3 = r48 | 6;
    L119:
        if ((r5 & 306783379) == 306783378) goto L121;
    L124:
        boolean r6 = true;
    L126:
        if (r1.shouldExecute(r6, r5 & 1) == false) goto L172;
        r1.startDefaults();
        if ((r47 & 1) != 0) goto L130;
    L139:
        if (r7 == 0) goto L141;
        Modifier r8 = Modifier.Companion;
    L142:
        if (r9 == 0) goto L144;
        r10 = true;
    L144:
        if (r11 == 0) goto L146;
        Shape r15 = RectangleShapeKt.getRectangleShape();
    L148:
        if ((r49 & 32) == 0) goto L150;
        long r18 = MaterialTheme.INSTANCE.getColors(r1, 6).m2003getSurface0d7_KjU();
        r5 = r5 & (-458753);
    L152:
        if ((r49 & 64) == 0) goto L154;
        long r19 = ColorsKt.m2017contentColorForek8zF_U(r18, r1, (r5 >> 15) & 14);
        r5 = r5 & (-3670017);
    L155:
        MutableInteractionSource r20 = null;
        if (r0 == 0) goto L158;
        r14 = null;
    L158:
        if (r13 == 0) goto L160;
        float r4 = Dp.constructor-impl(0);
    L161:
        if (r2 != 0) goto L164;
        r20 = r44;
    L164:
        int r21 = r5;
        long r22 = r19;
    L165:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L168;
        ComposerKt.traceEventStart(-258978402, r21, r3, "androidx.compose.material.Surface (Surface.kt:317)");
    L168:
        final float r23 = Dp.constructor-impl(((Dp) r1.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).unbox-impl() + r4);
        final Modifier r110 = r8;
        final Shape r111 = r15;
        final long r112 = r18;
        final BorderStroke r24 = r14;
        final float r25 = r4;
        final MutableInteractionSource r26 = r20;
        final boolean r27 = r10;
        float r39 = r4;
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r22)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(r23))}, ComposableLambdaKt.rememberComposableLambda(1830486238, true, new SurfaceKt$Surface$5(r110, r111, r112, r23, r24, r25, r33, r26, r27, r34, r45), r1, 54), r1, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L171;
        ComposerKt.traceEventEnd();
    L171:
        final Modifier r28 = r8;
        long r31 = r18;
        final float r113 = r39;
        final MutableInteractionSource r114 = r20;
        final long r29 = r22;
        final Shape r30 = r15;
        final boolean r32 = r10;
        final long r41 = r31;
        final BorderStroke r115 = r14;
    L173:
        ScopeUpdateScope r116 = r1.endRestartGroup();
        if (r116 == null) goto L177;
        r116.updateScope(new ua(r33, r34, r28, r32, r30, r41, r29, r115, r113, r114, r45, r47, r48, r49));
        return;
    L177:
        return;
    L160:
        r4 = r43;
        goto L161
    L154:
        r19 = r40;
        goto L155
    L150:
        r18 = r38;
        goto L152
    L146:
        r15 = r12;
        goto L148
    L141:
        r8 = r35;
        goto L142
    L130:
        if (r1.getDefaultsInvalid() == true) goto L139;
        r1.skipToGroupEnd();
        if ((r49 & 32) == 0) goto L136;
        r5 = r5 & (-458753);
    L136:
        if ((r49 & 64) == 0) goto L138;
        r5 = r5 & (-3670017);
    L138:
        r8 = r35;
        r4 = r43;
        r20 = r44;
        r21 = r5;
        r15 = r12;
        r18 = r38;
        r22 = r40;
        goto L165
    L172:
        r1.skipToGroupEnd();
        r28 = r35;
        r41 = r38;
        r29 = r40;
        r113 = r43;
        r32 = r10;
        r30 = r12;
        r115 = r14;
        r114 = r44;
        goto L173
    L121:
        if ((r3 & 3) != 2) goto L124;
        r6 = false;
        goto L126
    L111:
        if ((r48 & 6) == 0) goto L113;
        r3 = r48;
        goto L119
    L113:
        if (r1.changedInstance(r45) == false) goto L115;
        int r117 = 4;
    L116:
        r3 = r48 | r117;
        goto L119
    L115:
        r117 = 2;
        goto L116
    L101:
        if ((r47 & 805306368) != 0) goto L108;
        if (r1.changed(r44) == false) goto L105;
        int r50 = 536870912;
    L106:
        r5 = r5 | r50;
        goto L108
    L105:
        r50 = 268435456;
        goto L106
    L91:
        if ((r47 & 100663296) != 0) goto L97;
        if (r1.changed(r43) == false) goto L95;
        int r118 = 67108864;
    L96:
        r5 = r5 | r118;
        goto L97
    L95:
        r118 = 33554432;
        goto L96
    L80:
        r14 = r42;
        if ((r47 & 12582912) != 0) goto L87;
        if (r1.changed(r14) == false) goto L85;
        int r119 = 8388608;
    L86:
        r5 = r5 | r119;
        goto L87
    L85:
        r119 = 4194304;
        goto L86
    L50:
        if ((r47 & 24576) != 0) goto L56;
        r12 = r37;
        if (r1.changed(r12) == false) goto L54;
        int r120 = 16384;
    L55:
        r5 = r5 | r120;
        goto L58
    L54:
        r120 = 8192;
        goto L55
    L39:
        if ((r47 & 3072) != 0) goto L45;
        r10 = r36;
        if (r1.changed(r10) == false) goto L43;
        int r121 = 2048;
    L44:
        r5 = r5 | r121;
        goto L46
    L43:
        r121 = 1024;
        goto L44
    L28:
        if ((r47 & 384) != 0) goto L35;
        if (r1.changed(r35) == false) goto L32;
        int r51 = 256;
    L33:
        r5 = r5 | r51;
        goto L35
    L32:
        r51 = 128;
        goto L33
    L17:
        if ((r47 & 48) != 0) goto L24;
        if (r1.changedInstance(r34) == false) goto L21;
        int r52 = 32;
    L22:
        r5 = r5 | r52;
        goto L24
    L21:
        r52 = 16;
        goto L22
    L6:
        if ((r47 & 6) == 0) goto L8;
        r5 = r47;
        goto L14
    L8:
        if (r1.changed(r33) == false) goto L10;
        int r53 = 4;
    L11:
        r5 = r53 | r47;
        goto L14
    L10:
        r53 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Surface-Ny5ogXk, reason: not valid java name */
    public static final void m2178SurfaceNy5ogXk(final boolean r33, final Function1<? super Boolean, Unit> r34, Modifier r35, boolean r36, Shape r37, long r38, long r40, BorderStroke r42, float r43, MutableInteractionSource r44, final Function2<? super Composer, ? super Integer, Unit> r45, Composer r46, final int r47, final int r48, final int r49) {
        Composer r1 = r46.startRestartGroup(-391302147);
        if ((r49 & 1) == 0) goto L6;
        int r5 = r47 | 6;
    L14:
        if ((r49 & 2) == 0) goto L17;
        r5 = r5 | 48;
    L24:
        int r7 = r49 & 4;
        if (r7 == 0) goto L28;
        r5 = r5 | 384;
    L35:
        int r9 = r49 & 8;
        if (r9 == 0) goto L39;
        r5 = r5 | 3072;
    L45:
        boolean r10 = r36;
    L46:
        int r11 = r49 & 16;
        if (r11 == 0) goto L50;
        r5 = r5 | 24576;
    L56:
        Shape r12 = r37;
    L58:
        if ((196608 & r47) != 0) goto L68;
        if ((r49 & 32) == 0) goto L62;
    L64:
        int r16 = 65536;
    L65:
        r5 = r5 | r16;
        goto L68
    L62:
        if (r1.changed(r38) == false) goto L64;
        r16 = 131072;
    L68:
        if ((r47 & 1572864) != 0) goto L77;
        if ((r49 & 64) == 0) goto L72;
    L74:
        int r17 = 524288;
    L75:
        r5 = r5 | r17;
        goto L77
    L72:
        if (r1.changed(r40) == false) goto L74;
        r17 = 1048576;
    L77:
        int r0 = r49 & 128;
        if (r0 == 0) goto L80;
        r5 = r5 | 12582912;
        BorderStroke r14 = r42;
    L87:
        int r13 = r49 & 256;
        if (r13 == 0) goto L91;
        r5 = r5 | 100663296;
    L97:
        int r2 = r49 & 512;
        if (r2 == 0) goto L101;
        r5 = r5 | 805306368;
    L108:
        if ((r49 & 1024) == 0) goto L111;
        int r3 = r48 | 6;
    L119:
        if ((r5 & 306783379) == 306783378) goto L121;
    L124:
        boolean r6 = true;
    L126:
        if (r1.shouldExecute(r6, r5 & 1) == false) goto L172;
        r1.startDefaults();
        if ((r47 & 1) != 0) goto L130;
    L139:
        if (r7 == 0) goto L141;
        Modifier r8 = Modifier.Companion;
    L142:
        if (r9 == 0) goto L144;
        r10 = true;
    L144:
        if (r11 == 0) goto L146;
        Shape r15 = RectangleShapeKt.getRectangleShape();
    L148:
        if ((r49 & 32) == 0) goto L150;
        long r18 = MaterialTheme.INSTANCE.getColors(r1, 6).m2003getSurface0d7_KjU();
        r5 = r5 & (-458753);
    L152:
        if ((r49 & 64) == 0) goto L154;
        long r19 = ColorsKt.m2017contentColorForek8zF_U(r18, r1, (r5 >> 15) & 14);
        r5 = r5 & (-3670017);
    L155:
        MutableInteractionSource r20 = null;
        if (r0 == 0) goto L158;
        r14 = null;
    L158:
        if (r13 == 0) goto L160;
        float r4 = Dp.constructor-impl(0);
    L161:
        if (r2 != 0) goto L164;
        r20 = r44;
    L164:
        int r21 = r5;
        long r22 = r19;
    L165:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L168;
        ComposerKt.traceEventStart(-391302147, r21, r3, "androidx.compose.material.Surface (Surface.kt:428)");
    L168:
        final float r23 = Dp.constructor-impl(((Dp) r1.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).unbox-impl() + r4);
        final Modifier r110 = r8;
        final Shape r111 = r15;
        final long r112 = r18;
        final BorderStroke r24 = r14;
        final float r25 = r4;
        final MutableInteractionSource r26 = r20;
        final boolean r27 = r10;
        float r39 = r4;
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r22)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.box-impl(r23))}, ComposableLambdaKt.rememberComposableLambda(1698162493, true, new SurfaceKt$Surface$7(r110, r111, r112, r23, r24, r25, r33, r26, r27, r34, r45), r1, 54), r1, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L171;
        ComposerKt.traceEventEnd();
    L171:
        final Modifier r28 = r8;
        long r31 = r18;
        final float r113 = r39;
        final MutableInteractionSource r114 = r20;
        final long r29 = r22;
        final Shape r30 = r15;
        final boolean r32 = r10;
        final long r41 = r31;
        final BorderStroke r115 = r14;
    L173:
        ScopeUpdateScope r116 = r1.endRestartGroup();
        if (r116 == null) goto L177;
        r116.updateScope(new va(r33, r34, r28, r32, r30, r41, r29, r115, r113, r114, r45, r47, r48, r49));
        return;
    L177:
        return;
    L160:
        r4 = r43;
        goto L161
    L154:
        r19 = r40;
        goto L155
    L150:
        r18 = r38;
        goto L152
    L146:
        r15 = r12;
        goto L148
    L141:
        r8 = r35;
        goto L142
    L130:
        if (r1.getDefaultsInvalid() == true) goto L139;
        r1.skipToGroupEnd();
        if ((r49 & 32) == 0) goto L136;
        r5 = r5 & (-458753);
    L136:
        if ((r49 & 64) == 0) goto L138;
        r5 = r5 & (-3670017);
    L138:
        r8 = r35;
        r4 = r43;
        r20 = r44;
        r21 = r5;
        r15 = r12;
        r18 = r38;
        r22 = r40;
        goto L165
    L172:
        r1.skipToGroupEnd();
        r28 = r35;
        r41 = r38;
        r29 = r40;
        r113 = r43;
        r32 = r10;
        r30 = r12;
        r115 = r14;
        r114 = r44;
        goto L173
    L121:
        if ((r3 & 3) != 2) goto L124;
        r6 = false;
        goto L126
    L111:
        if ((r48 & 6) == 0) goto L113;
        r3 = r48;
        goto L119
    L113:
        if (r1.changedInstance(r45) == false) goto L115;
        int r117 = 4;
    L116:
        r3 = r48 | r117;
        goto L119
    L115:
        r117 = 2;
        goto L116
    L101:
        if ((r47 & 805306368) != 0) goto L108;
        if (r1.changed(r44) == false) goto L105;
        int r50 = 536870912;
    L106:
        r5 = r5 | r50;
        goto L108
    L105:
        r50 = 268435456;
        goto L106
    L91:
        if ((r47 & 100663296) != 0) goto L97;
        if (r1.changed(r43) == false) goto L95;
        int r118 = 67108864;
    L96:
        r5 = r5 | r118;
        goto L97
    L95:
        r118 = 33554432;
        goto L96
    L80:
        r14 = r42;
        if ((r47 & 12582912) != 0) goto L87;
        if (r1.changed(r14) == false) goto L85;
        int r119 = 8388608;
    L86:
        r5 = r5 | r119;
        goto L87
    L85:
        r119 = 4194304;
        goto L86
    L50:
        if ((r47 & 24576) != 0) goto L56;
        r12 = r37;
        if (r1.changed(r12) == false) goto L54;
        int r120 = 16384;
    L55:
        r5 = r5 | r120;
        goto L58
    L54:
        r120 = 8192;
        goto L55
    L39:
        if ((r47 & 3072) != 0) goto L45;
        r10 = r36;
        if (r1.changed(r10) == false) goto L43;
        int r121 = 2048;
    L44:
        r5 = r5 | r121;
        goto L46
    L43:
        r121 = 1024;
        goto L44
    L28:
        if ((r47 & 384) != 0) goto L35;
        if (r1.changed(r35) == false) goto L32;
        int r51 = 256;
    L33:
        r5 = r5 | r51;
        goto L35
    L32:
        r51 = 128;
        goto L33
    L17:
        if ((r47 & 48) != 0) goto L24;
        if (r1.changedInstance(r34) == false) goto L21;
        int r52 = 32;
    L22:
        r5 = r5 | r52;
        goto L24
    L21:
        r52 = 16;
        goto L22
    L6:
        if ((r47 & 6) == 0) goto L8;
        r5 = r47;
        goto L14
    L8:
        if (r1.changed(r33) == false) goto L10;
        int r53 = 4;
    L11:
        r5 = r53 | r47;
        goto L14
    L10:
        r53 = 2;
        goto L11
    }
}
