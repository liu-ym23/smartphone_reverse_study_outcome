package androidx.compose.material3;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aH\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000e\u001aP\u0010\u000f\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0001¢\u0006\u0002\u0010\u000e\u001a\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0017\"\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u000e\u0010\u0018\u001a\u00020\u0019X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"MaterialTheme", "", "colorScheme", "Landroidx/compose/material3/ColorScheme;", "shapes", "Landroidx/compose/material3/Shapes;", "typography", "Landroidx/compose/material3/Typography;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "motionScheme", "Landroidx/compose/material3/MotionScheme;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/MotionScheme;Landroidx/compose/material3/Shapes;Landroidx/compose/material3/Typography;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "MaterialExpressiveTheme", "LocalUsingExpressiveTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalUsingExpressiveTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "TextSelectionBackgroundOpacity", "", "_localMotionScheme", "get_localMotionScheme$annotations", "()V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MaterialThemeKt {
    private static final ProvidableCompositionLocal<Boolean> LocalUsingExpressiveTheme = null;
    public static final float TextSelectionBackgroundOpacity = 0.4f;
    private static final ProvidableCompositionLocal<MotionScheme> _localMotionScheme = null;

    private static final boolean LocalUsingExpressiveTheme$lambda$3() {
        return false;
    }

    private static final Unit MaterialExpressiveTheme$lambda$2(ColorScheme r9, MotionScheme r10, Shapes r11, Typography r12, Function2 r13, int r14, int r15, Composer r16, int r17) {
        MaterialExpressiveTheme(r9, r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit MaterialTheme$lambda$0(ColorScheme r7, Shapes r8, Typography r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        MaterialTheme(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit MaterialTheme$lambda$1(ColorScheme r9, MotionScheme r10, Shapes r11, Typography r12, Function2 r13, int r14, int r15, Composer r16, int r17) {
        MaterialTheme(r9, r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ MotionScheme a() {
        return _localMotionScheme$lambda$5();
    }

    public static /* synthetic */ Unit b(ColorScheme r0, MotionScheme r1, Shapes r2, Typography r3, Function2 r4, int r5, int r6, Composer r7, int r8) {
        return MaterialTheme$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit c(ColorScheme r0, MotionScheme r1, Shapes r2, Typography r3, Function2 r4, int r5, int r6, Composer r7, int r8) {
        return MaterialExpressiveTheme$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ boolean d() {
        return LocalUsingExpressiveTheme$lambda$3();
    }

    public static /* synthetic */ Unit e(ColorScheme r0, Shapes r1, Typography r2, Function2 r3, int r4, int r5, Composer r6, int r7) {
        return MaterialTheme$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    private static /* synthetic */ void get_localMotionScheme$annotations() {
    }

    static {
        LocalUsingExpressiveTheme = CompositionLocalKt.staticCompositionLocalOf(new pd());
        _localMotionScheme = CompositionLocalKt.staticCompositionLocalOf(new qd());
    }

    private static final MotionScheme _localMotionScheme$lambda$5() {
        return MotionScheme.Companion.standard$material3();
    }

    public static final /* synthetic */ ProvidableCompositionLocal access$get_localMotionScheme$p() {
        return _localMotionScheme;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalUsingExpressiveTheme() {
        return LocalUsingExpressiveTheme;
    }

    public static final TextSelectionColors rememberTextSelectionColors(ColorScheme r11, Composer r12, int r13) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1866455512, r13, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:217)");
    L5:
        long r0 = r11.m2471getPrimary0d7_KjU();
        boolean r14 = r12.changed(r0);
        Object r15 = r12.rememberedValue();
        if (r14 == false) goto L8;
    L9:
        r15 = new TextSelectionColors(r0, Color.copy-wmQWz5c$default(r0, 0.4f, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r12.updateRememberedValue(r15);
    L10:
        TextSelectionColors r16 = (TextSelectionColors) r15;
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r16;
    L8:
        if (r15 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public static final void MaterialTheme(ColorScheme r9, Shapes r10, Typography r11, final Function2<? super Composer, ? super Integer, Unit> r12, Composer r13, final int r14, final int r15) {
        Composer r16 = r13.startRestartGroup(-449719819);
        if ((r14 & 6) == 0) goto L5;
        int r1 = r14;
    L13:
        if ((r14 & 48) != 0) goto L22;
        if ((r15 & 2) == 0) goto L17;
    L19:
        int r2 = 16;
    L20:
        r1 = r1 | r2;
        goto L22
    L17:
        if (r16.changed(r10) == false) goto L19;
        r2 = 32;
    L22:
        if ((r14 & 384) != 0) goto L31;
        if ((r15 & 4) == 0) goto L26;
    L28:
        int r3 = 128;
    L29:
        r1 = r1 | r3;
        goto L31
    L26:
        if (r16.changed(r11) == false) goto L28;
        r3 = 256;
    L31:
        if ((r15 & 8) == 0) goto L34;
        r1 = r1 | 3072;
    L41:
        if ((r1 & 1171) == 1170) goto L43;
        boolean r4 = true;
    L45:
        if (r16.shouldExecute(r4, r1 & 1) == false) goto L76;
        r16.startDefaults();
        if ((r14 & 1) == 0) goto L61;
        if (r16.getDefaultsInvalid() == true) goto L61;
        r16.skipToGroupEnd();
        if ((r15 & 1) == 0) goto L55;
        r1 = r1 & (-15);
    L55:
        if ((r15 & 2) == 0) goto L58;
        r1 = r1 & (-113);
    L58:
        if ((r15 & 4) != 0) goto L69;
    L70:
        r16.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L73;
        ComposerKt.traceEventStart(-449719819, r1, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:59)");
    L73:
        MotionScheme r5 = MaterialTheme.INSTANCE.getMotionScheme(r16, 6);
        int r0 = r1 & 14;
        int r6 = r1 << 3;
        int r7 = ((r0 | (r6 & 896)) | (r6 & 7168)) | (r6 & 57344);
        MaterialTheme(r9, r5, r10, r11, r12, r16, r7, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventEnd();
    L77:
        final ColorScheme r8 = r9;
        final Shapes r17 = r10;
        final Typography r18 = r11;
        ScopeUpdateScope r19 = r16.endRestartGroup();
        if (r19 == null) goto L81;
        r19.updateScope(new rd(r8, r17, r18, r12, r14, r15));
        return;
    L81:
        return;
    L69:
        r1 = r1 & (-897);
    L61:
        if ((r15 & 1) == 0) goto L64;
        r9 = MaterialTheme.INSTANCE.getColorScheme(r16, 6);
        r1 = r1 & (-15);
    L64:
        if ((r15 & 2) == 0) goto L67;
        r10 = MaterialTheme.INSTANCE.getShapes(r16, 6);
        r1 = r1 & (-113);
    L67:
        if ((r15 & 4) == 0) goto L70;
        r11 = MaterialTheme.INSTANCE.getTypography(r16, 6);
        goto L69
    L76:
        r16.skipToGroupEnd();
        goto L77
    L43:
        r4 = false;
        goto L45
    L34:
        if ((r14 & 3072) != 0) goto L41;
        if (r16.changedInstance(r12) == false) goto L38;
        int r20 = 2048;
    L39:
        r1 = r1 | r20;
        goto L41
    L38:
        r20 = 1024;
        goto L39
    L5:
        if ((r15 & 1) == 0) goto L7;
    L9:
        int r21 = 2;
    L10:
        r1 = r21 | r14;
        goto L13
    L7:
        if (r16.changed(r9) == false) goto L9;
        r21 = 4;
        goto L10
    }

    public static final void MaterialExpressiveTheme(ColorScheme r20, MotionScheme r21, Shapes r22, Typography r23, final Function2<? super Composer, ? super Integer, Unit> r24, Composer r25, final int r26, final int r27) {
        Composer r1 = r25.startRestartGroup(1317329884);
        int r2 = r27 & 1;
        if (r2 == 0) goto L6;
        int r4 = r26 | 6;
        ColorScheme r3 = r20;
    L13:
        int r5 = r27 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        MotionScheme r7 = r21;
    L24:
        int r8 = r27 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Shapes r9 = r22;
    L35:
        int r10 = r27 & 8;
        if (r10 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Typography r11 = r23;
    L47:
        if ((r27 & 16) == 0) goto L50;
        r4 = r4 | 24576;
    L57:
        if ((r4 & 9363) == 9362) goto L59;
        boolean r12 = true;
    L61:
        if (r1.shouldExecute(r12, r4 & 1) == true) goto L63;
        r1.skipToGroupEnd();
        final MotionScheme r6 = r7;
        final Typography r13 = r11;
    L99:
        ScopeUpdateScope r14 = r1.endRestartGroup();
        if (r14 == null) goto L103;
        final ColorScheme r15 = r3;
        final Shapes r16 = r9;
        r14.updateScope(new od(r15, r6, r16, r13, r24, r26, r27));
        return;
    L103:
        return;
    L63:
        if (r2 == 0) goto L65;
        r3 = null;
    L65:
        if (r5 == 0) goto L67;
        r6 = null;
    L68:
        if (r8 == 0) goto L70;
        Shapes r17 = null;
    L71:
        if (r10 == 0) goto L73;
        Typography r19 = null;
    L75:
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventStart(1317329884, r4, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:190)");
    L77:
        ProvidableCompositionLocal<Boolean> r0 = LocalUsingExpressiveTheme;
        if (((Boolean) r1.consume(r0)).booleanValue() == false) goto L93;
        r1.startReplaceGroup(1458674654);
        if (r3 != null) goto L82;
        r1.startReplaceGroup(-1061322393);
        ColorScheme r18 = MaterialTheme.INSTANCE.getColorScheme(r1, 6);
        r1.endReplaceGroup();
    L83:
        if (r6 != null) goto L85;
        r1.startReplaceGroup(-1061320152);
        MotionScheme r28 = MaterialTheme.INSTANCE.getMotionScheme(r1, 6);
        r1.endReplaceGroup();
    L86:
        if (r19 != null) goto L88;
        r1.startReplaceGroup(-1061318010);
        Typography r29 = MaterialTheme.INSTANCE.getTypography(r1, 6);
        r1.endReplaceGroup();
        Typography r110 = r29;
    L89:
        if (r17 != null) goto L91;
        r1.startReplaceGroup(-1061316190);
        Shapes r30 = MaterialTheme.INSTANCE.getShapes(r1, 6);
        r1.endReplaceGroup();
        Shapes r31 = r30;
    L92:
        MaterialTheme(r18, r28, r31, r110, r24, r1, r4 & 57344, 0);
        r1.endReplaceGroup();
    L95:
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventEnd();
    L97:
        r9 = r17;
        r13 = r19;
        goto L99
    L91:
        r1.startReplaceGroup(-1061316934);
        r1.endReplaceGroup();
        r31 = r17;
        goto L92
    L88:
        r1.startReplaceGroup(-1061318878);
        r1.endReplaceGroup();
        r110 = r19;
        goto L89
    L85:
        r1.startReplaceGroup(-1061321082);
        r1.endReplaceGroup();
        r28 = r6;
        goto L86
    L82:
        r1.startReplaceGroup(-1061323292);
        r1.endReplaceGroup();
        r18 = r3;
        goto L83
    L93:
        r1.startReplaceGroup(1459011221);
        final ColorScheme r111 = r3;
        final MotionScheme r112 = r6;
        final Shapes r113 = r17;
        final Typography r114 = r19;
        CompositionLocalKt.CompositionLocalProvider(r0.provides(Boolean.TRUE), ComposableLambdaKt.rememberComposableLambda(1535649272, true, new AnonymousClass1(r111, r112, r113, r114, r24), r1, 54), r1, ProvidedValue.$stable | 48);
        r1.endReplaceGroup();
        goto L95
    L73:
        r19 = r11;
        goto L75
    L70:
        r17 = r9;
        goto L71
    L67:
        r6 = r7;
        goto L68
    L59:
        r12 = false;
        goto L61
    L50:
        if ((r26 & 24576) != 0) goto L57;
        if (r1.changedInstance(r24) == false) goto L54;
        int r115 = 16384;
    L55:
        r4 = r4 | r115;
        goto L57
    L54:
        r115 = 8192;
        goto L55
    L39:
        if ((r26 & 3072) != 0) goto L45;
        r11 = r23;
        if (r1.changed(r11) == false) goto L43;
        int r116 = 2048;
    L44:
        r4 = r4 | r116;
        goto L47
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r26 & 384) != 0) goto L34;
        r9 = r22;
        if (r1.changed(r9) == false) goto L32;
        int r117 = 256;
    L33:
        r4 = r4 | r117;
        goto L35
    L32:
        r117 = 128;
        goto L33
    L17:
        if ((r26 & 48) != 0) goto L23;
        r7 = r21;
        if (r1.changed(r7) == false) goto L21;
        int r32 = 32;
    L22:
        r4 = r4 | r32;
        goto L24
    L21:
        r32 = 16;
        goto L22
    L6:
        if ((r26 & 6) != 0) goto L12;
        r3 = r20;
        if (r1.changed(r3) == false) goto L10;
        int r33 = 4;
    L11:
        r4 = r33 | r26;
        goto L13
    L10:
        r33 = 2;
        goto L11
    L12:
        r3 = r20;
        r4 = r26;
        goto L13
    }

    public static final void MaterialTheme(ColorScheme r22, MotionScheme r23, Shapes r24, Typography r25, final Function2<? super Composer, ? super Integer, Unit> r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(904511636);
        if ((r28 & 6) == 0) goto L5;
        ColorScheme r2 = r22;
        int r7 = r28;
    L14:
        if ((r28 & 48) == 0) goto L16;
        MotionScheme r8 = r23;
    L25:
        if ((r28 & 384) == 0) goto L27;
        Shapes r9 = r24;
    L36:
        if ((r28 & 3072) == 0) goto L38;
        final Typography r10 = r25;
    L47:
        if ((r29 & 16) == 0) goto L50;
        r7 = r7 | 24576;
    L57:
        if ((r7 & 9363) == 9362) goto L59;
        boolean r11 = true;
    L61:
        if (r1.shouldExecute(r11, r7 & 1) == false) goto L98;
        r1.startDefaults();
        if ((r28 & 1) == 0) goto L80;
        if (r1.getDefaultsInvalid() == true) goto L80;
        r1.skipToGroupEnd();
        if ((r29 & 1) == 0) goto L71;
        r7 = r7 & (-15);
    L71:
        if ((r29 & 2) == 0) goto L74;
        r7 = r7 & (-113);
    L74:
        if ((r29 & 4) == 0) goto L77;
        r7 = r7 & (-897);
    L77:
        if ((r29 & 8) != 0) goto L91;
    L92:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L95;
        ComposerKt.traceEventStart(904511636, r7, -1, "androidx.compose.material3.MaterialTheme (MaterialTheme.kt:95)");
    L95:
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ColorSchemeKt.getLocalColorScheme().provides(r2), _localMotionScheme.provides(r8), IndicationKt.getLocalIndication().provides(RippleKt.m3031rippleH2RKhps$default(false, MenuKt.ClosedAlphaTarget, 0, 7, null)), ShapesKt.getLocalShapes().provides(r9), TextSelectionColorsKt.getLocalTextSelectionColors().provides(rememberTextSelectionColors(r2, r1, r7 & 14)), TypographyKt.getLocalTypography().provides(r10)}, ComposableLambdaKt.rememberComposableLambda(-1750539308, true, new AnonymousClass2(r10, r26), r1, 54), r1, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventEnd();
    L99:
        final Shapes r3 = r9;
        final Typography r4 = r10;
        ScopeUpdateScope r12 = r1.endRestartGroup();
        if (r12 == null) goto L103;
        final ColorScheme r5 = r2;
        final MotionScheme r6 = r8;
        r12.updateScope(new sd(r5, r6, r3, r4, r26, r28, r29));
        return;
    L103:
        return;
    L91:
        r7 = r7 & (-7169);
    L80:
        if ((r29 & 1) == 0) goto L83;
        r2 = MaterialTheme.INSTANCE.getColorScheme(r1, 6);
        r7 = r7 & (-15);
    L83:
        if ((r29 & 2) == 0) goto L86;
        r8 = MaterialTheme.INSTANCE.getMotionScheme(r1, 6);
        r7 = r7 & (-113);
    L86:
        if ((r29 & 4) == 0) goto L89;
        r9 = MaterialTheme.INSTANCE.getShapes(r1, 6);
        r7 = r7 & (-897);
    L89:
        if ((r29 & 8) == 0) goto L92;
        r10 = MaterialTheme.INSTANCE.getTypography(r1, 6);
        goto L91
    L98:
        r1.skipToGroupEnd();
        goto L99
    L59:
        r11 = false;
        goto L61
    L50:
        if ((r28 & 24576) != 0) goto L57;
        if (r1.changedInstance(r26) == false) goto L54;
        int r13 = 16384;
    L55:
        r7 = r7 | r13;
        goto L57
    L54:
        r13 = 8192;
        goto L55
    L38:
        if ((r29 & 8) != 0) goto L42;
        r10 = r25;
        if (r1.changed(r10) == false) goto L43;
        int r14 = 2048;
    L44:
        r7 = r7 | r14;
    L43:
        r14 = 1024;
        goto L44
    L42:
        r10 = r25;
        goto L43
    L27:
        if ((r29 & 4) != 0) goto L31;
        r9 = r24;
        if (r1.changed(r9) == false) goto L32;
        int r15 = 256;
    L33:
        r7 = r7 | r15;
    L32:
        r15 = 128;
        goto L33
    L31:
        r9 = r24;
        goto L32
    L16:
        if ((r29 & 2) != 0) goto L20;
        r8 = r23;
        if (r1.changed(r8) == false) goto L21;
        int r16 = 32;
    L22:
        r7 = r7 | r16;
    L21:
        r16 = 16;
        goto L22
    L20:
        r8 = r23;
        goto L21
    L5:
        if ((r29 & 1) != 0) goto L9;
        r2 = r22;
        if (r1.changed(r2) == false) goto L10;
        int r17 = 4;
    L11:
        r7 = r17 | r28;
    L10:
        r17 = 2;
        goto L11
    L9:
        r2 = r22;
        goto L10
    }
}
