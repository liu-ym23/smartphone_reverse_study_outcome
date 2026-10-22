package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aj\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00152\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00152\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u001f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0004\b\u001b\u0010 \u001a5\u0010!\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020#H\u0003¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010&\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\nH\u0003¢\u0006\u0004\b(\u0010)\"\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Surface", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "onClick", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surface", "backgroundColor", "", "surface-XO-JAsU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SurfaceKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = null;

    private static final Dp LocalAbsoluteTonalElevation$lambda$3() {
        return Dp.box-impl(Dp.constructor-impl(0));
    }

    public static /* synthetic */ Dp a() {
        return LocalAbsoluteTonalElevation$lambda$3();
    }

    static {
        LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(null, new er(), 1, null);
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }

    /* JADX INFO: renamed from: access$surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    public static final /* synthetic */ long m3218access$surfaceColorAtElevationCLU3JFs(long r0, float r2, Composer r3, int r4) {
        return m3220surfaceColorAtElevationCLU3JFs(r0, r2, r3, r4);
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    private static final long m3220surfaceColorAtElevationCLU3JFs(long r8, float r10, Composer r11, int r12) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2079918090, r12, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:478)");
    L5:
        int r13 = r12 << 3;
        long r9 = ColorSchemeKt.m2494applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme(r11, 6), r8, r10, r11, (r13 & 112) | (r13 & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r9;
    }

    /* JADX INFO: renamed from: access$surface-XO-JAsU, reason: not valid java name */
    public static final /* synthetic */ Modifier m3217access$surfaceXOJAsU(Modifier r0, Shape r1, long r2, BorderStroke r4, float r5) {
        return m3219surfaceXOJAsU(r0, r1, r2, r4, r5);
    }

    /* JADX INFO: renamed from: surface-XO-JAsU, reason: not valid java name */
    private static final Modifier m3219surfaceXOJAsU(Modifier r23, Shape r24, long r25, BorderStroke r27, float r28) {
        if (r28 <= MenuKt.ClosedAlphaTarget) goto L5;
        Modifier r0 = GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r28, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 0, r24, false, null, 0, 0, 0, 124895, null);
    L6:
        Modifier r1 = r23.then(r0);
        if (r27 == null) goto L9;
        Shape r3 = r24;
        Modifier r2 = BorderKt.border(Modifier.Companion, r27, r3);
    L11:
        return ClipKt.clip(BackgroundKt.m341backgroundbw27NRU(r1.then(r2), r25, r3), r3);
    L9:
        r3 = r24;
        r2 = Modifier.Companion;
        goto L11
    L5:
        r0 = Modifier.Companion;
        goto L6
    }

    /* JADX INFO: renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m3213SurfaceT9BRK9s(Modifier r15, Shape r16, long r17, long r19, float r21, float r22, BorderStroke r23, Function2<? super Composer, ? super Integer, Unit> r24, Composer r25, int r26, int r27) {
        if ((r27 & 1) == 0) goto L5;
        Modifier r2 = Modifier.Companion;
    L7:
        if ((r27 & 2) == 0) goto L9;
        Shape r3 = RectangleShapeKt.getRectangleShape();
    L11:
        if ((r27 & 4) == 0) goto L13;
        long r4 = MaterialTheme.INSTANCE.getColorScheme(r25, 6).m2480getSurface0d7_KjU();
    L15:
        if ((r27 & 8) == 0) goto L17;
        long r6 = ColorSchemeKt.m2496contentColorForek8zF_U(r4, r25, (r26 >> 6) & 14);
    L19:
        if ((r27 & 16) == 0) goto L21;
        float r8 = Dp.constructor-impl(0);
    L23:
        if ((r27 & 32) == 0) goto L25;
        float r10 = Dp.constructor-impl(0);
    L27:
        if ((r27 & 64) == 0) goto L29;
        BorderStroke r11 = null;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-1093433818, r26, -1, "androidx.compose.material3.Surface (Surface.kt:104)");
    L33:
        ProvidableCompositionLocal<Dp> r1 = LocalAbsoluteTonalElevation;
        float r9 = Dp.constructor-impl(((Dp) r25.consume(r1)).unbox-impl() + r8);
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r6)), r1.provides(Dp.box-impl(r9))}, ComposableLambdaKt.rememberComposableLambda(421772006, true, new SurfaceKt$Surface$1(r2, r3, r4, r9, r11, r10, r24), r25, 54), r25, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L37;
        ComposerKt.traceEventEnd();
        return;
    L37:
        return;
    L29:
        r11 = r23;
        goto L31
    L25:
        r10 = r22;
        goto L27
    L21:
        r8 = r21;
        goto L23
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    /* JADX INFO: renamed from: Surface-o_FOJdg, reason: not valid java name */
    public static final void m3216Surfaceo_FOJdg(final Function0<Unit> r16, Modifier r17, boolean r18, Shape r19, long r20, long r22, float r24, float r25, BorderStroke r26, MutableInteractionSource r27, final Function2<? super Composer, ? super Integer, Unit> r28, Composer r29, int r30, int r31, int r32) {
        if ((r32 & 2) == 0) goto L5;
        final Modifier r5 = Modifier.Companion;
    L7:
        if ((r32 & 4) == 0) goto L9;
        final boolean r12 = true;
    L11:
        if ((r32 & 8) == 0) goto L13;
        final Shape r6 = RectangleShapeKt.getRectangleShape();
    L15:
        if ((r32 & 16) == 0) goto L17;
        final long r7 = MaterialTheme.INSTANCE.getColorScheme(r29, 6).m2480getSurface0d7_KjU();
    L19:
        if ((r32 & 32) == 0) goto L21;
        long r3 = ColorSchemeKt.m2496contentColorForek8zF_U(r7, r29, (r30 >> 12) & 14);
    L23:
        if ((r32 & 64) == 0) goto L25;
        float r9 = Dp.constructor-impl(0);
    L27:
        if ((r32 & 128) == 0) goto L29;
        final float r14 = Dp.constructor-impl(0);
    L30:
        MutableInteractionSource r13 = null;
        if ((r32 & 256) == 0) goto L33;
        BorderStroke r11 = null;
    L35:
        if ((r32 & 512) != 0) goto L39;
        r13 = r27;
    L39:
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventStart(-1472753265, r30, r31, "androidx.compose.material3.Surface (Surface.kt:207)");
    L41:
        if (r13 != null) goto L46;
        r29.startReplaceGroup(-1701037204);
        Object r1 = r29.rememberedValue();
        if (r1 != Composer.Companion.getEmpty()) goto L45;
        r1 = InteractionSourceKt.MutableInteractionSource();
        r29.updateRememberedValue(r1);
    L45:
        MutableInteractionSource r2 = (MutableInteractionSource) r1;
        r29.endReplaceGroup();
    L47:
        ProvidableCompositionLocal<Dp> r4 = LocalAbsoluteTonalElevation;
        final float r10 = Dp.constructor-impl(((Dp) r29.consume(r4)).unbox-impl() + r9);
        final BorderStroke r15 = r11;
        final MutableInteractionSource r110 = r2;
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r3)), r4.provides(Dp.box-impl(r10))}, ComposableLambdaKt.rememberComposableLambda(849208527, true, new SurfaceKt$Surface$2(r5, r6, r7, r10, r15, r110, r12, r16, r14, r28), r29, 54), r29, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L51;
        ComposerKt.traceEventEnd();
        return;
    L51:
        return;
    L46:
        r29.startReplaceGroup(2023337163);
        r29.endReplaceGroup();
        r2 = r13;
        goto L47
    L33:
        r11 = r26;
        goto L35
    L29:
        r14 = r25;
        goto L30
    L25:
        r9 = r24;
        goto L27
    L21:
        r3 = r22;
        goto L23
    L17:
        r7 = r20;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r12 = r18;
        goto L11
    L5:
        r5 = r17;
        goto L7
    }

    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m3214Surfaced85dljk(final boolean r17, final Function0<Unit> r18, Modifier r19, boolean r20, Shape r21, long r22, long r24, float r26, float r27, BorderStroke r28, MutableInteractionSource r29, final Function2<? super Composer, ? super Integer, Unit> r30, Composer r31, int r32, int r33, int r34) {
        if ((r34 & 4) == 0) goto L5;
        final Modifier r5 = Modifier.Companion;
    L7:
        if ((r34 & 8) == 0) goto L9;
        final boolean r13 = true;
    L11:
        if ((r34 & 16) == 0) goto L13;
        final Shape r6 = RectangleShapeKt.getRectangleShape();
    L15:
        if ((r34 & 32) == 0) goto L17;
        final long r7 = MaterialTheme.INSTANCE.getColorScheme(r31, 6).m2480getSurface0d7_KjU();
    L19:
        if ((r34 & 64) == 0) goto L21;
        long r3 = ColorSchemeKt.m2496contentColorForek8zF_U(r7, r31, (r32 >> 15) & 14);
    L23:
        if ((r34 & 128) == 0) goto L25;
        float r9 = Dp.constructor-impl(0);
    L27:
        if ((r34 & 256) == 0) goto L29;
        float r16 = Dp.constructor-impl(0);
    L30:
        final MutableInteractionSource r12 = null;
        if ((r34 & 512) == 0) goto L33;
        BorderStroke r11 = null;
    L35:
        if ((r34 & 1024) != 0) goto L39;
        r12 = r29;
    L39:
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventStart(1416521139, r32, r33, "androidx.compose.material3.Surface (Surface.kt:313)");
    L41:
        if (r12 != null) goto L46;
        r31.startReplaceGroup(1528143336);
        Object r1 = r31.rememberedValue();
        if (r1 != Composer.Companion.getEmpty()) goto L45;
        r1 = InteractionSourceKt.MutableInteractionSource();
        r31.updateRememberedValue(r1);
    L45:
        r31.endReplaceGroup();
        r12 = (MutableInteractionSource) r1;
    L47:
        ProvidableCompositionLocal<Dp> r2 = LocalAbsoluteTonalElevation;
        final float r10 = Dp.constructor-impl(((Dp) r31.consume(r2)).unbox-impl() + r9);
        final BorderStroke r14 = r11;
        final float r15 = r16;
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r3)), r2.provides(Dp.box-impl(r10))}, ComposableLambdaKt.rememberComposableLambda(1508735219, true, new SurfaceKt$Surface$3(r5, r6, r7, r10, r14, r17, r12, r13, r18, r15, r30), r31, 54), r31, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L51;
        ComposerKt.traceEventEnd();
        return;
    L51:
        return;
    L46:
        r31.startReplaceGroup(-227800369);
        r31.endReplaceGroup();
        goto L47
    L33:
        r11 = r28;
        goto L35
    L29:
        r16 = r27;
        goto L30
    L25:
        r9 = r26;
        goto L27
    L21:
        r3 = r24;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r13 = r20;
        goto L11
    L5:
        r5 = r19;
        goto L7
    }

    /* JADX INFO: renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m3215Surfaced85dljk(final boolean r17, final Function1<? super Boolean, Unit> r18, Modifier r19, boolean r20, Shape r21, long r22, long r24, float r26, float r27, BorderStroke r28, MutableInteractionSource r29, final Function2<? super Composer, ? super Integer, Unit> r30, Composer r31, int r32, int r33, int r34) {
        if ((r34 & 4) == 0) goto L5;
        final Modifier r5 = Modifier.Companion;
    L7:
        if ((r34 & 8) == 0) goto L9;
        final boolean r13 = true;
    L11:
        if ((r34 & 16) == 0) goto L13;
        final Shape r6 = RectangleShapeKt.getRectangleShape();
    L15:
        if ((r34 & 32) == 0) goto L17;
        final long r7 = MaterialTheme.INSTANCE.getColorScheme(r31, 6).m2480getSurface0d7_KjU();
    L19:
        if ((r34 & 64) == 0) goto L21;
        long r3 = ColorSchemeKt.m2496contentColorForek8zF_U(r7, r31, (r32 >> 15) & 14);
    L23:
        if ((r34 & 128) == 0) goto L25;
        float r9 = Dp.constructor-impl(0);
    L27:
        if ((r34 & 256) == 0) goto L29;
        float r16 = Dp.constructor-impl(0);
    L30:
        final MutableInteractionSource r12 = null;
        if ((r34 & 512) == 0) goto L33;
        BorderStroke r11 = null;
    L35:
        if ((r34 & 1024) != 0) goto L39;
        r12 = r29;
    L39:
        if (ComposerKt.isTraceInProgress() == false) goto L41;
        ComposerKt.traceEventStart(-1931279214, r32, r33, "androidx.compose.material3.Surface (Surface.kt:420)");
    L41:
        if (r12 != null) goto L46;
        r31.startReplaceGroup(643421417);
        Object r1 = r31.rememberedValue();
        if (r1 != Composer.Companion.getEmpty()) goto L45;
        r1 = InteractionSourceKt.MutableInteractionSource();
        r31.updateRememberedValue(r1);
    L45:
        r31.endReplaceGroup();
        r12 = (MutableInteractionSource) r1;
    L47:
        ProvidableCompositionLocal<Dp> r2 = LocalAbsoluteTonalElevation;
        final float r10 = Dp.constructor-impl(((Dp) r31.consume(r2)).unbox-impl() + r9);
        final BorderStroke r14 = r11;
        final float r15 = r16;
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r3)), r2.provides(Dp.box-impl(r10))}, ComposableLambdaKt.rememberComposableLambda(-1839065134, true, new SurfaceKt$Surface$4(r5, r6, r7, r10, r14, r17, r12, r13, r18, r15, r30), r31, 54), r31, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L51;
        ComposerKt.traceEventEnd();
        return;
    L51:
        return;
    L46:
        r31.startReplaceGroup(-533434450);
        r31.endReplaceGroup();
        goto L47
    L33:
        r11 = r28;
        goto L35
    L29:
        r16 = r27;
        goto L30
    L25:
        r9 = r26;
        goto L27
    L21:
        r3 = r24;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r13 = r20;
        goto L11
    L5:
        r5 = r19;
        goto L7
    }
}
