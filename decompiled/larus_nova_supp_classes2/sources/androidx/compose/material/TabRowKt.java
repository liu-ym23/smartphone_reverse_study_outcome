package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u000723\b\u0002\u0010\t\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a¦\u0001\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u001923\b\u0002\u0010\t\u001a-\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u00112\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u001c\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d\"\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"TabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material/TabPosition;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "tabPositions", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "divider", "Lkotlin/Function0;", "tabs", "TabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "edgePadding", "Landroidx/compose/ui/unit/Dp;", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowMinimumTabWidth", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = 0.0f;
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = null;

    private static final Unit ScrollableTabRow_sKfQg0A$lambda$1(int r14, Modifier r15, long r16, long r18, float r20, Function3 r21, Function2 r22, Function2 r23, int r24, int r25, Composer r26, int r27) {
        m2205ScrollableTabRowsKfQg0A(r14, r15, r16, r18, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit TabRow_pAZo6Ak$lambda$0(int r13, Modifier r14, long r15, long r17, Function3 r19, Function2 r20, Function2 r21, int r22, int r23, Composer r24, int r25) {
        m2206TabRowpAZo6Ak(r13, r14, r15, r17, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(int r0, Modifier r1, long r2, long r4, float r6, Function3 r7, Function2 r8, Function2 r9, int r10, int r11, Composer r12, int r13) {
        return ScrollableTabRow_sKfQg0A$lambda$1(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit b(int r0, Modifier r1, long r2, long r4, Function3 r6, Function2 r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        return TabRow_pAZo6Ak$lambda$0(r0, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12);
    }

    static {
        ScrollableTabRowMinimumTabWidth = Dp.constructor-impl(90);
        ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(androidx.compose.material3.ProgressIndicatorKt.FirstLineTailDelay, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    }

    public static final /* synthetic */ float access$getScrollableTabRowMinimumTabWidth$p() {
        return ScrollableTabRowMinimumTabWidth;
    }

    public static final /* synthetic */ AnimationSpec access$getScrollableTabRowScrollSpec$p() {
        return ScrollableTabRowScrollSpec;
    }

    /* JADX INFO: renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    public static final void m2206TabRowpAZo6Ak(final int r25, Modifier r26, long r27, long r29, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r31, Function2<? super Composer, ? super Integer, Unit> r32, final Function2<? super Composer, ? super Integer, Unit> r33, Composer r34, final int r35, final int r36) {
        Composer r2 = r34.startRestartGroup(113221600);
        if ((r36 & 1) == 0) goto L6;
        int r3 = r35 | 6;
    L13:
        int r4 = r36 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r35 & 384) != 0) goto L36;
        if ((r36 & 4) != 0) goto L32;
        if (r2.changed(r27) == false) goto L32;
        int r8 = 256;
    L33:
        r3 = r3 | r8;
    L32:
        r8 = 128;
    L36:
        if ((r35 & 3072) != 0) goto L44;
        long r11 = r29;
        if ((r36 & 8) == 0) goto L40;
    L42:
        int r9 = 1024;
    L43:
        r3 = r3 | r9;
    L45:
        int r10 = r36 & 16;
        if (r10 == 0) goto L49;
        r3 = r3 | 24576;
    L55:
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r13 = r31;
    L56:
        int r14 = r36 & 32;
        if (r14 == 0) goto L60;
        r3 = r3 | 196608;
    L66:
        Function2<? super Composer, ? super Integer, Unit> r15 = r32;
    L68:
        if ((r36 & 64) == 0) goto L71;
        r3 = r3 | 1572864;
    L78:
        if ((r3 & 599187) == 599186) goto L80;
        boolean r0 = true;
    L82:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L119;
        r2.startDefaults();
        if ((r35 & 1) != 0) goto L86;
    L95:
        if (r4 == 0) goto L97;
        Modifier r1 = Modifier.Companion;
    L99:
        if ((r36 & 4) == 0) goto L101;
        int r7 = r3 & (-897);
        long r5 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(r2, 6));
    L103:
        if ((r36 & 8) == 0) goto L105;
        r11 = ColorsKt.m2017contentColorForek8zF_U(r5, r2, (r7 >> 6) & 14);
        r7 = r7 & (-7169);
    L105:
        if (r10 == 0) goto L107;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r12 = ComposableLambdaKt.rememberComposableLambda(1896966245, true, new TabRowKt$TabRow$1(r25), r2, 54);
    L108:
        if (r14 == 0) goto L110;
        Function2<? super Composer, ? super Integer, Unit> r16 = ComposableSingletons$TabRowKt.INSTANCE.m2027getLambda$1216856915$material();
    L111:
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r17 = r12;
        long r23 = r11;
        int r18 = r7;
        long r19 = r23;
    L112:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventStart(113221600, r18, -1, "androidx.compose.material.TabRow (TabRow.kt:144)");
    L115:
        Modifier r6 = SelectableGroupKt.selectableGroup(r1);
        Modifier r28 = r1;
        ComposableLambda r20 = ComposableLambdaKt.rememberComposableLambda(-638448612, true, new TabRowKt$TabRow$2(r33, r16, r17), r2, 54);
        int r21 = ((r18 & 896) | 1572864) | (r18 & 7168);
        Function2<? super Composer, ? super Integer, Unit> r22 = r16;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r24 = r17;
        SurfaceKt.m2175SurfaceFjzlyU(r6, null, r5, r19, null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r20, r2, r21, 50);
        if (ComposerKt.isTraceInProgress() == false) goto L118;
        ComposerKt.traceEventEnd();
    L118:
        r15 = r22;
        r13 = r24;
        long r30 = r5;
        Modifier r37 = r28;
    L120:
        ScopeUpdateScope r110 = r2.endRestartGroup();
        if (r110 == null) goto L124;
        final Modifier r38 = r37;
        final long r39 = r30;
        final long r40 = r19;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r41 = r13;
        final Function2<? super Composer, ? super Integer, Unit> r42 = r15;
        r110.updateScope(new lc(r25, r38, r39, r40, r41, r42, r33, r35, r36));
        return;
    L124:
        return;
    L110:
        r16 = r15;
        goto L111
    L107:
        r12 = r13;
        goto L108
    L101:
        r7 = r3;
        r5 = r27;
        goto L103
    L97:
        r1 = r26;
        goto L99
    L86:
        if (r2.getDefaultsInvalid() == true) goto L95;
        r2.skipToGroupEnd();
        if ((r36 & 4) == 0) goto L92;
        r3 = r3 & (-897);
    L92:
        if ((r36 & 8) == 0) goto L94;
        r3 = r3 & (-7169);
    L94:
        r1 = r26;
        r19 = r11;
        r18 = r3;
        r5 = r27;
        Function2<? super Composer, ? super Integer, Unit> r210 = r15;
        r17 = r13;
        r16 = r210;
        goto L112
    L119:
        r2.skipToGroupEnd();
        r37 = r26;
        r30 = r27;
        r19 = r11;
        goto L120
    L80:
        r0 = false;
        goto L82
    L71:
        if ((r35 & 1572864) != 0) goto L78;
        if (r2.changedInstance(r33) == false) goto L75;
        int r111 = 1048576;
    L76:
        r3 = r3 | r111;
        goto L78
    L75:
        r111 = 524288;
        goto L76
    L60:
        if ((196608 & r35) != 0) goto L66;
        r15 = r32;
        if (r2.changedInstance(r15) == false) goto L64;
        int r112 = 131072;
    L65:
        r3 = r3 | r112;
        goto L68
    L64:
        r112 = 65536;
        goto L65
    L49:
        if ((r35 & 24576) != 0) goto L55;
        r13 = r31;
        if (r2.changedInstance(r13) == false) goto L53;
        int r113 = 16384;
    L54:
        r3 = r3 | r113;
        goto L56
    L53:
        r113 = 8192;
        goto L54
    L40:
        if (r2.changed(r11) == false) goto L42;
        r9 = 2048;
        goto L43
    L44:
        r11 = r29;
        goto L45
    L17:
        if ((r35 & 48) != 0) goto L25;
        if (r2.changed(r26) == false) goto L21;
        int r43 = 32;
    L22:
        r3 = r3 | r43;
        goto L25
    L21:
        r43 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r3 = r35;
        goto L13
    L8:
        if (r2.changed(r25) == false) goto L10;
        int r44 = 4;
    L11:
        r3 = r44 | r35;
        goto L13
    L10:
        r44 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    public static final void m2205ScrollableTabRowsKfQg0A(final int r27, Modifier r28, long r29, long r31, float r33, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r34, Function2<? super Composer, ? super Integer, Unit> r35, final Function2<? super Composer, ? super Integer, Unit> r36, Composer r37, final int r38, final int r39) {
        Composer r2 = r37.startRestartGroup(-1291546575);
        if ((r39 & 1) == 0) goto L6;
        int r3 = r38 | 6;
    L13:
        int r4 = r39 & 2;
        if (r4 == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r38 & 384) != 0) goto L36;
        if ((r39 & 4) != 0) goto L32;
        if (r2.changed(r29) == false) goto L32;
        int r8 = 256;
    L33:
        r3 = r3 | r8;
    L32:
        r8 = 128;
    L36:
        if ((r38 & 3072) == 0) goto L38;
        long r9 = r31;
    L46:
        int r10 = r39 & 16;
        if (r10 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        float r13 = r33;
    L57:
        int r14 = r39 & 32;
        if (r14 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r15 = r34;
    L68:
        int r16 = r39 & 64;
        if (r16 == 0) goto L72;
        r3 = r3 | 1572864;
    L79:
        if ((r39 & 128) == 0) goto L82;
        r3 = r3 | 12582912;
    L90:
        if ((r3 & 4793491) == 4793490) goto L92;
        boolean r0 = true;
    L94:
        if (r2.shouldExecute(r0, r3 & 1) == false) goto L134;
        r2.startDefaults();
        if ((r38 & 1) != 0) goto L98;
    L107:
        if (r4 == 0) goto L109;
        Modifier r1 = Modifier.Companion;
    L111:
        if ((r39 & 4) == 0) goto L113;
        int r7 = r3 & (-897);
        long r5 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(r2, 6));
    L115:
        if ((r39 & 8) == 0) goto L117;
        r9 = ColorsKt.m2017contentColorForek8zF_U(r5, r2, (r7 >> 6) & 14);
        r7 = r7 & (-7169);
    L117:
        if (r10 == 0) goto L119;
        float r11 = TabRowDefaults.INSTANCE.m2204getScrollableTabRowPaddingD9Ej5fM();
    L120:
        if (r14 == 0) goto L122;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r17 = ComposableLambdaKt.rememberComposableLambda(-233732148, true, new TabRowKt$ScrollableTabRow$1(r27), r2, 54);
    L123:
        if (r16 == 0) goto L125;
        Function2<? super Composer, ? super Integer, Unit> r25 = ComposableSingletons$TabRowKt.INSTANCE.m2028getLambda$222041980$material();
    L126:
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r26 = r17;
        int r18 = r7;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r12 = r26;
    L127:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L130;
        ComposerKt.traceEventStart(-1291546575, r18, -1, "androidx.compose.material.ScrollableTabRow (TabRow.kt:234)");
    L130:
        ComposableLambda r21 = ComposableLambdaKt.rememberComposableLambda(-1575164555, true, new TabRowKt$ScrollableTabRow$2(r11, r36, r25, r12, r27), r2, 54);
        int r23 = ((((r18 >> 3) & 14) | 1572864) | (r18 & 896)) | (r18 & 7168);
        SurfaceKt.m2175SurfaceFjzlyU(r1, null, r5, r9, null, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r21, r2, r23, 50);
        if (ComposerKt.isTraceInProgress() == false) goto L133;
        ComposerKt.traceEventEnd();
    L133:
        long r6 = r5;
        r15 = r12;
        final float r19 = r11;
        Modifier r20 = r1;
    L135:
        ScopeUpdateScope r110 = r2.endRestartGroup();
        if (r110 == null) goto L139;
        final Modifier r22 = r20;
        final long r24 = r6;
        final long r30 = r9;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> r32 = r15;
        final Function2<? super Composer, ? super Integer, Unit> r40 = r25;
        r110.updateScope(new kc(r27, r22, r24, r30, r19, r32, r40, r36, r38, r39));
        return;
    L139:
        return;
    L125:
        r25 = r35;
        goto L126
    L122:
        r17 = r15;
        goto L123
    L119:
        r11 = r13;
        goto L120
    L113:
        r7 = r3;
        r5 = r29;
        goto L115
    L109:
        r1 = r28;
        goto L111
    L98:
        if (r2.getDefaultsInvalid() == true) goto L107;
        r2.skipToGroupEnd();
        if ((r39 & 4) == 0) goto L104;
        r3 = r3 & (-897);
    L104:
        if ((r39 & 8) == 0) goto L106;
        r3 = r3 & (-7169);
    L106:
        r1 = r28;
        r25 = r35;
        r11 = r13;
        r12 = r15;
        r18 = r3;
        r5 = r29;
        goto L127
    L134:
        r2.skipToGroupEnd();
        r20 = r28;
        r6 = r29;
        r25 = r35;
        r19 = r13;
        goto L135
    L92:
        r0 = false;
        goto L94
    L82:
        if ((r38 & 12582912) != 0) goto L90;
        if (r2.changedInstance(r36) == false) goto L86;
        int r111 = 8388608;
    L87:
        r3 = r3 | r111;
        goto L90
    L86:
        r111 = 4194304;
        goto L87
    L72:
        if ((r38 & 1572864) != 0) goto L79;
        if (r2.changedInstance(r35) == false) goto L76;
        int r112 = 1048576;
    L77:
        r3 = r3 | r112;
        goto L79
    L76:
        r112 = 524288;
        goto L77
    L61:
        if ((196608 & r38) != 0) goto L67;
        r15 = r34;
        if (r2.changedInstance(r15) == false) goto L65;
        int r113 = 131072;
    L66:
        r3 = r3 | r113;
        goto L68
    L65:
        r113 = 65536;
        goto L66
    L50:
        if ((r38 & 24576) != 0) goto L56;
        r13 = r33;
        if (r2.changed(r13) == false) goto L54;
        int r114 = 16384;
    L55:
        r3 = r3 | r114;
        goto L57
    L54:
        r114 = 8192;
        goto L55
    L38:
        if ((r39 & 8) != 0) goto L42;
        r9 = r31;
        if (r2.changed(r9) == false) goto L43;
        int r115 = 2048;
    L44:
        r3 = r3 | r115;
    L43:
        r115 = 1024;
        goto L44
    L42:
        r9 = r31;
        goto L43
    L17:
        if ((r38 & 48) != 0) goto L25;
        if (r2.changed(r28) == false) goto L21;
        int r41 = 32;
    L22:
        r3 = r3 | r41;
        goto L25
    L21:
        r41 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r3 = r38;
        goto L13
    L8:
        if (r2.changed(r27) == false) goto L10;
        int r42 = 4;
    L11:
        r3 = r42 | r38;
        goto L13
    L10:
        r42 = 2;
        goto L11
    }
}
