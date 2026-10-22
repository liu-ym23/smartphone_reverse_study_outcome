package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.tokens.NavigationBarHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.material3.tokens.NavigationBarVerticalItemTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001aT\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0081\u0001\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002\"\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\"\u0016\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+\"\u0016\u0010-\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b.\u0010+\"\u0016\u0010/\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b0\u0010+\"\u0016\u00101\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b2\u0010+\"\u0016\u00103\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b4\u0010+\"\u0016\u00105\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b6\u0010+\"\u0016\u00107\u001a\u00020)X\u0080\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b8\u0010+¨\u00069"}, d2 = {"ShortNavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/material3/ShortNavigationBarArrangement;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ShortNavigationBar-kQ6Tpik", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ShortNavigationBarItem", "selected", "", "onClick", "icon", "label", "enabled", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "colors", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "ShortNavigationBarItem-6ZDA4I0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "LocalShortNavigationBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ShortNavigationBarOverride;", "getLocalShortNavigationBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "calculateCenteredContentHorizontalPadding", "", "itemsCount", "barWidth", "TopIconItemVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTopIconItemVerticalPadding", "()F", "F", "TopIconIndicatorVerticalPadding", "getTopIconIndicatorVerticalPadding", "TopIconIndicatorHorizontalPadding", "getTopIconIndicatorHorizontalPadding", "StartIconIndicatorVerticalPadding", "getStartIconIndicatorVerticalPadding", "TopIconIndicatorToLabelPadding", "getTopIconIndicatorToLabelPadding", "StartIconIndicatorHorizontalPadding", "getStartIconIndicatorHorizontalPadding", "StartIconToLabelPadding", "getStartIconToLabelPadding", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ShortNavigationBarKt {
    private static final ProvidableCompositionLocal<ShortNavigationBarOverride> LocalShortNavigationBarOverride = null;
    private static final float StartIconIndicatorHorizontalPadding = 0.0f;
    private static final float StartIconIndicatorVerticalPadding = 0.0f;
    private static final float StartIconToLabelPadding = 0.0f;
    private static final float TopIconIndicatorHorizontalPadding = 0.0f;
    private static final float TopIconIndicatorToLabelPadding = 0.0f;
    private static final float TopIconIndicatorVerticalPadding = 0.0f;
    private static final float TopIconItemVerticalPadding = 0.0f;

    private static final Unit ShortNavigationBarItem_6ZDA4I0$lambda$3(boolean r13, Function0 r14, Function2 r15, Function2 r16, Modifier r17, boolean r18, int r19, NavigationItemColors r20, MutableInteractionSource r21, int r22, int r23, Composer r24, int r25) {
        m3131ShortNavigationBarItem6ZDA4I0(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit ShortNavigationBar_kQ6Tpik$lambda$1(Modifier r12, long r13, long r15, WindowInsets r17, int r18, Function2 r19, int r20, int r21, Composer r22, int r23) {
        m3130ShortNavigationBarkQ6Tpik(r12, r13, r15, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, long r1, long r3, WindowInsets r5, int r6, Function2 r7, int r8, int r9, Composer r10, int r11) {
        return ShortNavigationBar_kQ6Tpik$lambda$1(r0, r1, r3, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ ShortNavigationBarOverride b() {
        return LocalShortNavigationBarOverride$lambda$4();
    }

    public static /* synthetic */ Unit c(boolean r0, Function0 r1, Function2 r2, Function2 r3, Modifier r4, boolean r5, int r6, NavigationItemColors r7, MutableInteractionSource r8, int r9, int r10, Composer r11, int r12) {
        return ShortNavigationBarItem_6ZDA4I0$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    static {
        LocalShortNavigationBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new lo(), 1, null);
        NavigationBarVerticalItemTokens r0 = NavigationBarVerticalItemTokens.INSTANCE;
        TopIconItemVerticalPadding = r0.getContainerBetweenSpace-D9Ej5fM();
        float r2 = 2;
        TopIconIndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(r0.getActiveIndicatorHeight-D9Ej5fM() - r0.getIconSize-D9Ej5fM()) / r2);
        TopIconIndicatorHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(r0.getActiveIndicatorWidth-D9Ej5fM() - r0.getIconSize-D9Ej5fM()) / r2);
        NavigationBarHorizontalItemTokens r1 = NavigationBarHorizontalItemTokens.INSTANCE;
        StartIconIndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(r1.getActiveIndicatorHeight-D9Ej5fM() - r1.getIconSize-D9Ej5fM()) / r2);
        TopIconIndicatorToLabelPadding = Dp.constructor-impl(4);
        StartIconIndicatorHorizontalPadding = r1.getActiveIndicatorLeadingSpace-D9Ej5fM();
        StartIconToLabelPadding = NavigationBarTokens.INSTANCE.getItemActiveIndicatorIconLabelSpace-D9Ej5fM();
    }

    private static final ShortNavigationBarOverride LocalShortNavigationBarOverride$lambda$4() {
        return DefaultShortNavigationBarOverride.INSTANCE;
    }

    public static final ProvidableCompositionLocal<ShortNavigationBarOverride> getLocalShortNavigationBarOverride() {
        return LocalShortNavigationBarOverride;
    }

    public static final float getStartIconIndicatorHorizontalPadding() {
        return StartIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconIndicatorVerticalPadding() {
        return StartIconIndicatorVerticalPadding;
    }

    public static final float getStartIconToLabelPadding() {
        return StartIconToLabelPadding;
    }

    public static final float getTopIconIndicatorHorizontalPadding() {
        return TopIconIndicatorHorizontalPadding;
    }

    public static final float getTopIconIndicatorToLabelPadding() {
        return TopIconIndicatorToLabelPadding;
    }

    public static final float getTopIconIndicatorVerticalPadding() {
        return TopIconIndicatorVerticalPadding;
    }

    public static final float getTopIconItemVerticalPadding() {
        return TopIconItemVerticalPadding;
    }

    public static final /* synthetic */ int access$calculateCenteredContentHorizontalPadding(int r0, int r1) {
        return calculateCenteredContentHorizontalPadding(r0, r1);
    }

    private static final int calculateCenteredContentHorizontalPadding(int r2, int r3) {
        if (r2 <= 6) goto L7;
        return 0;
    L7:
        return MathKt.roundToInt((((100 - ((r2 + 3) * 10)) / 2.0f) / 100) * r3);
    }

    /* JADX INFO: renamed from: ShortNavigationBar-kQ6Tpik, reason: not valid java name */
    public static final void m3130ShortNavigationBarkQ6Tpik(Modifier r23, long r24, long r26, WindowInsets r28, int r29, final Function2<? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32, final int r33) {
        Composer r1 = r31.startRestartGroup(552087412);
        int r2 = r33 & 1;
        if (r2 == 0) goto L6;
        int r4 = r32 | 6;
        Modifier r3 = r23;
    L14:
        if ((r32 & 48) == 0) goto L16;
        long r5 = r24;
    L25:
        if ((r32 & 384) == 0) goto L27;
        long r7 = r26;
    L36:
        if ((r32 & 3072) == 0) goto L38;
        WindowInsets r10 = r28;
    L47:
        if ((r32 & 24576) == 0) goto L49;
        int r11 = r29;
    L58:
        if ((r33 & 32) == 0) goto L61;
        r4 = r4 | 196608;
    L69:
        if ((74899 & r4) == 74898) goto L71;
        boolean r13 = true;
    L73:
        if (r1.shouldExecute(r13, r4 & 1) == false) goto L113;
        r1.startDefaults();
        if ((r32 & 1) != 0) goto L77;
    L92:
        if (r2 == 0) goto L94;
        Modifier r6 = Modifier.Companion;
    L96:
        if ((r33 & 2) == 0) goto L99;
        r5 = ShortNavigationBarDefaults.INSTANCE.getContainerColor(r1, 6);
        r4 = r4 & (-113);
    L99:
        if ((r33 & 4) == 0) goto L102;
        r7 = ShortNavigationBarDefaults.INSTANCE.getContentColor(r1, 6);
        r4 = r4 & (-897);
    L102:
        if ((r33 & 8) == 0) goto L105;
        r4 = r4 & (-7169);
        r10 = ShortNavigationBarDefaults.INSTANCE.getWindowInsets(r1, 6);
    L105:
        if ((r33 & 16) == 0) goto L107;
        r4 = r4 & (-57345);
        r11 = ShortNavigationBarDefaults.INSTANCE.m3128getArrangementLnnQw40();
    L107:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L110;
        ComposerKt.traceEventStart(552087412, r4, -1, "androidx.compose.material3.ShortNavigationBar (ShortNavigationBar.kt:101)");
    L110:
        ((ShortNavigationBarOverride) r1.consume(LocalShortNavigationBarOverride)).ShortNavigationBar(new ShortNavigationBarOverrideScope(r6, r5, r7, r10, r11, r30, null), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L114;
        ComposerKt.traceEventEnd();
    L114:
        ScopeUpdateScope r14 = r1.endRestartGroup();
        if (r14 == null) goto L118;
        final Modifier r8 = r6;
        final long r9 = r5;
        final long r12 = r7;
        final WindowInsets r15 = r10;
        final int r16 = r11;
        r14.updateScope(new ko(r8, r9, r12, r15, r16, r30, r32, r33));
        return;
    L118:
        return;
    L94:
        r6 = r3;
        goto L96
    L77:
        if (r1.getDefaultsInvalid() == true) goto L92;
        r1.skipToGroupEnd();
        if ((r33 & 2) == 0) goto L83;
        r4 = r4 & (-113);
    L83:
        if ((r33 & 4) == 0) goto L86;
        r4 = r4 & (-897);
    L86:
        if ((r33 & 8) == 0) goto L89;
        r4 = r4 & (-7169);
    L89:
        if ((r33 & 16) == 0) goto L91;
        r4 = r4 & (-57345);
    L91:
        r6 = r3;
        goto L107
    L113:
        r1.skipToGroupEnd();
        r6 = r3;
        goto L114
    L71:
        r13 = false;
        goto L73
    L61:
        if ((r32 & 196608) != 0) goto L69;
        if (r1.changedInstance(r30) == false) goto L65;
        int r17 = 131072;
    L66:
        r4 = r4 | r17;
        goto L69
    L65:
        r17 = 65536;
        goto L66
    L49:
        if ((r33 & 16) != 0) goto L53;
        r11 = r29;
        if (r1.changed(r11) == false) goto L54;
        int r18 = 16384;
    L55:
        r4 = r4 | r18;
    L54:
        r18 = 8192;
        goto L55
    L53:
        r11 = r29;
        goto L54
    L38:
        if ((r33 & 8) != 0) goto L42;
        r10 = r28;
        if (r1.changed(r10) == false) goto L43;
        int r19 = 2048;
    L44:
        r4 = r4 | r19;
    L43:
        r19 = 1024;
        goto L44
    L42:
        r10 = r28;
        goto L43
    L27:
        if ((r33 & 4) != 0) goto L31;
        r7 = r26;
        if (r1.changed(r7) == false) goto L32;
        int r110 = 256;
    L33:
        r4 = r4 | r110;
    L32:
        r110 = 128;
        goto L33
    L31:
        r7 = r26;
        goto L32
    L16:
        if ((r33 & 2) != 0) goto L20;
        r5 = r24;
        if (r1.changed(r5) == false) goto L21;
        int r20 = 32;
    L22:
        r4 = r4 | r20;
    L21:
        r20 = 16;
        goto L22
    L20:
        r5 = r24;
        goto L21
    L6:
        if ((r32 & 6) != 0) goto L12;
        r3 = r23;
        if (r1.changed(r3) == false) goto L10;
        int r21 = 4;
    L11:
        r4 = r21 | r32;
        goto L14
    L10:
        r21 = 2;
        goto L11
    L12:
        r3 = r23;
        r4 = r32;
        goto L14
    }

    /* JADX INFO: renamed from: ShortNavigationBarItem-6ZDA4I0, reason: not valid java name */
    public static final void m3131ShortNavigationBarItem6ZDA4I0(final boolean r32, final Function0<Unit> r33, final Function2<? super Composer, ? super Integer, Unit> r34, final Function2<? super Composer, ? super Integer, Unit> r35, Modifier r36, boolean r37, int r38, NavigationItemColors r39, MutableInteractionSource r40, Composer r41, final int r42, final int r43) {
        Composer r1 = r41.startRestartGroup(-1164996656);
        if ((r43 & 1) == 0) goto L6;
        int r3 = r42 | 6;
    L14:
        if ((r43 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L25:
        if ((r43 & 4) == 0) goto L28;
        r3 = r3 | 384;
    L36:
        if ((r43 & 8) == 0) goto L39;
        r3 = r3 | 3072;
    L46:
        int r7 = r43 & 16;
        if (r7 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        Modifier r8 = r36;
    L57:
        int r9 = r43 & 32;
        if (r9 == 0) goto L61;
        r3 = r3 | 196608;
    L67:
        boolean r12 = r37;
    L68:
        int r13 = r43 & 64;
        if (r13 == 0) goto L72;
        r3 = r3 | 1572864;
    L78:
        int r14 = r38;
    L80:
        if ((12582912 & r42) == 0) goto L82;
        NavigationItemColors r15 = r39;
    L90:
        int r0 = r43 & 256;
        if (r0 == 0) goto L94;
        r3 = r3 | 100663296;
    L101:
        if ((r3 & 38347923) == 38347922) goto L103;
        boolean r2 = true;
    L105:
        if (r1.shouldExecute(r2, r3 & 1) == false) goto L148;
        r1.startDefaults();
        if ((r42 & 1) != 0) goto L109;
    L116:
        if (r7 == 0) goto L118;
        r8 = Modifier.Companion;
    L118:
        if (r9 == 0) goto L120;
        r12 = true;
    L120:
        if (r13 == 0) goto L123;
        r14 = NavigationItemIconPosition.Companion.m2932getTopxw1Ddg();
    L123:
        if ((r43 & 128) == 0) goto L125;
        r3 = r3 & (-29360129);
        r15 = ShortNavigationBarItemDefaults.INSTANCE.colors(r1, 6);
    L125:
        if (r0 != 0) goto L126;
    L114:
        MutableInteractionSource r10 = r40;
    L115:
        int r11 = r3;
        boolean r4 = r12;
        int r5 = r14;
        NavigationItemColors r6 = r15;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L130;
        ComposerKt.traceEventStart(-1164996656, r11, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:219)");
    L130:
        if (r10 != null) goto L135;
        r1.startReplaceGroup(1215858123);
        Object r16 = r1.rememberedValue();
        if (r16 != Composer.Companion.getEmpty()) goto L134;
        r16 = InteractionSourceKt.MutableInteractionSource();
        r1.updateRememberedValue(r16);
    L134:
        r1.endReplaceGroup();
        MutableInteractionSource r28 = (MutableInteractionSource) r16;
    L136:
        boolean r17 = NavigationItemIconPosition.m2927equalsimpl0(r5, NavigationItemIconPosition.Companion.m2932getTopxw1Ddg());
        if (r17 == false) goto L139;
        float r18 = TopIconIndicatorHorizontalPadding;
    L140:
        float r19 = r18;
        if (r17 == false) goto L143;
        float r110 = TopIconIndicatorVerticalPadding;
    L144:
        float r111 = r110;
        NavigationBarTokens r112 = NavigationBarTokens.INSTANCE;
        int r113 = r11 >> 6;
        Modifier r24 = r8;
        NavigationItemKt.m2936NavigationItem8Df7sds(r32, r33, r34, TypographyKt.getValue(r112.getLabelTextFont(), r1, 6), ShapesKt.getValue(r112.getItemActiveIndicatorShape(), r1, 6), NavigationBarVerticalItemTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM(), r19, r111, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, r6, r24, r4, r35, r5, r28, r1, (((r11 & 14) | 906166272) | (r11 & 112)) | (r11 & 896), ((((6 | ((r11 >> 18) & 112)) | (r113 & 896)) | (r113 & 7168)) | ((r11 << 3) & 57344)) | ((r11 >> 3) & 458752));
        if (ComposerKt.isTraceInProgress() == false) goto L147;
        ComposerKt.traceEventEnd();
    L147:
        r12 = r4;
        r15 = r6;
        final MutableInteractionSource r20 = r10;
        final int r21 = r5;
    L149:
        ScopeUpdateScope r114 = r1.endRestartGroup();
        if (r114 == null) goto L153;
        final Modifier r22 = r8;
        final boolean r23 = r12;
        final NavigationItemColors r25 = r15;
        r114.updateScope(new mo(r32, r33, r34, r35, r22, r23, r21, r25, r20, r42, r43));
        return;
    L153:
        return;
    L143:
        r110 = StartIconIndicatorVerticalPadding;
        goto L144
    L139:
        r18 = StartIconIndicatorHorizontalPadding;
        goto L140
    L135:
        r1.startReplaceGroup(1424693900);
        r1.endReplaceGroup();
        r28 = r10;
        goto L136
    L126:
        r10 = null;
        goto L115
    L109:
        if (r1.getDefaultsInvalid() == true) goto L116;
        r1.skipToGroupEnd();
        if ((r43 & 128) == 0) goto L114;
        r3 = r3 & (-29360129);
        goto L114
    L148:
        r1.skipToGroupEnd();
        r20 = r40;
        r21 = r14;
        goto L149
    L103:
        r2 = false;
        goto L105
    L94:
        if ((r42 & 100663296) != 0) goto L101;
        if (r1.changed(r40) == false) goto L98;
        int r115 = 67108864;
    L99:
        r3 = r3 | r115;
        goto L101
    L98:
        r115 = 33554432;
        goto L99
    L82:
        if ((r43 & 128) != 0) goto L86;
        r15 = r39;
        if (r1.changed(r15) == false) goto L87;
        int r116 = 8388608;
    L88:
        r3 = r3 | r116;
    L87:
        r116 = 4194304;
        goto L88
    L86:
        r15 = r39;
        goto L87
    L72:
        if ((1572864 & r42) != 0) goto L78;
        r14 = r38;
        if (r1.changed(r14) == false) goto L76;
        int r117 = 1048576;
    L77:
        r3 = r3 | r117;
        goto L80
    L76:
        r117 = 524288;
        goto L77
    L61:
        if ((196608 & r42) != 0) goto L67;
        r12 = r37;
        if (r1.changed(r12) == false) goto L65;
        int r118 = 131072;
    L66:
        r3 = r3 | r118;
        goto L68
    L65:
        r118 = 65536;
        goto L66
    L50:
        if ((r42 & 24576) != 0) goto L56;
        r8 = r36;
        if (r1.changed(r8) == false) goto L54;
        int r26 = 16384;
    L55:
        r3 = r3 | r26;
        goto L57
    L54:
        r26 = 8192;
        goto L55
    L39:
        if ((r42 & 3072) != 0) goto L46;
        if (r1.changedInstance(r35) == false) goto L43;
        int r27 = 2048;
    L44:
        r3 = r3 | r27;
        goto L46
    L43:
        r27 = 1024;
        goto L44
    L28:
        if ((r42 & 384) != 0) goto L36;
        if (r1.changedInstance(r34) == false) goto L32;
        int r29 = 256;
    L33:
        r3 = r3 | r29;
        goto L36
    L32:
        r29 = 128;
        goto L33
    L17:
        if ((r42 & 48) != 0) goto L25;
        if (r1.changedInstance(r33) == false) goto L21;
        int r30 = 32;
    L22:
        r3 = r3 | r30;
        goto L25
    L21:
        r30 = 16;
        goto L22
    L6:
        if ((r42 & 6) == 0) goto L8;
        r3 = r42;
        goto L14
    L8:
        if (r1.changed(r32) == false) goto L10;
        int r31 = 4;
    L11:
        r3 = r31 | r42;
        goto L14
    L10:
        r31 = 2;
        goto L11
    }
}
