package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.material3.tokens.SecondaryNavigationTabTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\fH\u0007¢\u0006\u0004\b!\u0010\"JA\u0010#\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0004\b'\u0010(J-\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\fH\u0007¢\u0006\u0004\b*\u0010\"J\u0014\u0010+\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010,\u001a\u00020-H\u0007R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0014\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0017\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0019\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000f¨\u0006.²\u0006\n\u0010/\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/TabRowDefaults;", "", "<init>", "()V", "ScrollableTabRowMinTabWidth", "Landroidx/compose/ui/unit/Dp;", "getScrollableTabRowMinTabWidth-D9Ej5fM", "()F", "F", "ScrollableTabRowEdgeStartPadding", "getScrollableTabRowEdgeStartPadding-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "primaryContainerColor", "getPrimaryContainerColor", "secondaryContainerColor", "getSecondaryContainerColor", "contentColor", "getContentColor$annotations", "getContentColor", "primaryContentColor", "getPrimaryContentColor", "secondaryContentColor", "getSecondaryContentColor", "Indicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "height", "color", "Indicator-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "PrimaryIndicator", "width", "shape", "Landroidx/compose/ui/graphics/Shape;", "PrimaryIndicator-10LGxhE", "(Landroidx/compose/ui/Modifier;FFJLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "SecondaryIndicator", "SecondaryIndicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material3/TabPosition;", "material3", "currentTabWidth", "indicatorOffset"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final TabRowDefaults INSTANCE = null;
    private static final float ScrollableTabRowEdgeStartPadding = 0.0f;
    private static final float ScrollableTabRowMinTabWidth = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Function3<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ TabPosition $currentTabPosition;

        public AnonymousClass2(TabPosition r1) {
            this.$currentTabPosition = r1;
        }

        public static /* synthetic */ IntOffset a(State r0, Density r1) {
            return invoke$lambda$3$lambda$2(r0, r1);
        }

        private static final float invoke$lambda$0(State<Dp> r0) {
            return ((Dp) r0.getValue()).unbox-impl();
        }

        private static final float invoke$lambda$1(State<Dp> r0) {
            return ((Dp) r0.getValue()).unbox-impl();
        }

        private static final IntOffset invoke$lambda$3$lambda$2(State r4, Density r5) {
            return IntOffset.box-impl(IntOffset.constructor-impl((((long) r5.roundToPx-0680j_4(invoke$lambda$1(r4))) << 32) | (((long) 0) & 4294967295L)));
        }

        public final Modifier invoke(Modifier r11, Composer r12, int r13) {
            r12.startReplaceGroup(-1541271084);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-1541271084, r13, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:1108)");
        L5:
            float r0 = this.$currentTabPosition.m3255getWidthD9Ej5fM();
            MotionSchemeKeyTokens r7 = MotionSchemeKeyTokens.DefaultSpatial;
            State<Dp> r9 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(r0, MotionSchemeKt.value(r7, r12, 6), null, null, r12, 0, 12);
            final State<Dp> r1 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(this.$currentTabPosition.m3253getLeftD9Ej5fM(), MotionSchemeKt.value(r7, r12, 6), null, null, r12, 0, 12);
            Modifier r2 = SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(r11, MenuKt.ClosedAlphaTarget, 1, null), Alignment.Companion.getBottomStart(), false, 2, null);
            boolean r3 = r12.changed(r1);
            Object r4 = r12.rememberedValue();
            if (r3 == false) goto L8;
        L9:
            r4 = new js(r1);
            r12.updateRememberedValue(r4);
        L10:
            Modifier r5 = SizeKt.m1019width3ABfNKs(OffsetKt.offset(r2, (Function1) r4), invoke$lambda$0(r9));
            if (ComposerKt.isTraceInProgress() == false) goto L13;
            ComposerKt.traceEventEnd();
        L13:
            r12.endReplaceGroup();
            return r5;
        L8:
            if (r4 != Composer.Companion.getEmpty()) goto L10;
            goto L9
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((Modifier) r1, (Composer) r2, ((Number) r3).intValue());
        }
    }

    private TabRowDefaults() {
    }

    private static final Unit Indicator_9IZ8Weo$lambda$0(TabRowDefaults r9, Modifier r10, float r11, long r12, int r14, int r15, Composer r16, int r17) {
        r9.m3256Indicator9IZ8Weo(r10, r11, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit PrimaryIndicator_10LGxhE$lambda$1(TabRowDefaults r11, Modifier r12, float r13, float r14, long r15, Shape r17, int r18, int r19, Composer r20, int r21) {
        r11.m3257PrimaryIndicator10LGxhE(r12, r13, r14, r15, r17, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit SecondaryIndicator_9IZ8Weo$lambda$2(TabRowDefaults r9, Modifier r10, float r11, long r12, int r14, int r15, Composer r16, int r17) {
        r9.m3258SecondaryIndicator9IZ8Weo(r10, r11, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TabRowDefaults r0, Modifier r1, float r2, long r3, int r5, int r6, Composer r7, int r8) {
        return SecondaryIndicator_9IZ8Weo$lambda$2(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit b(TabRowDefaults r0, Modifier r1, float r2, long r3, int r5, int r6, Composer r7, int r8) {
        return Indicator_9IZ8Weo$lambda$0(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit c(TabRowDefaults r0, Modifier r1, float r2, float r3, long r4, Shape r6, int r7, int r8, Composer r9, int r10) {
        return PrimaryIndicator_10LGxhE$lambda$1(r0, r1, r2, r3, r4, r6, r7, r8, r9, r10);
    }

    @Deprecated(message = "Use TabRowDefaults.primaryContainerColor instead", replaceWith = @ReplaceWith(expression = "primaryContainerColor", imports = {}))
    public static /* synthetic */ void getContainerColor$annotations() {
    }

    @Deprecated(message = "Use TabRowDefaults.primaryContentColor instead", replaceWith = @ReplaceWith(expression = "primaryContentColor", imports = {}))
    public static /* synthetic */ void getContentColor$annotations() {
    }

    static {
        INSTANCE = new TabRowDefaults();
        ScrollableTabRowMinTabWidth = Dp.constructor-impl(90);
        ScrollableTabRowEdgeStartPadding = Dp.constructor-impl(52);
    }

    /* JADX INFO: renamed from: getScrollableTabRowEdgeStartPadding-D9Ej5fM, reason: not valid java name */
    public final float m3259getScrollableTabRowEdgeStartPaddingD9Ej5fM() {
        return ScrollableTabRowEdgeStartPadding;
    }

    /* JADX INFO: renamed from: getScrollableTabRowMinTabWidth-D9Ej5fM, reason: not valid java name */
    public final float m3260getScrollableTabRowMinTabWidthD9Ej5fM() {
        return ScrollableTabRowMinTabWidth;
    }

    public final long getContainerColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2026555673, r5, -1, "androidx.compose.material3.TabRowDefaults.<get-containerColor> (TabRow.kt:994)");
    L5:
        long r6 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getContentColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1163072359, r5, -1, "androidx.compose.material3.TabRowDefaults.<get-contentColor> (TabRow.kt:1010)");
    L5:
        long r6 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getPrimaryContainerColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2069154037, r5, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContainerColor> (TabRow.kt:998)");
    L5:
        long r6 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getPrimaryContentColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1410362619, r5, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContentColor> (TabRow.kt:1014)");
    L5:
        long r6 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getSecondaryContainerColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1938007129, r5, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContainerColor> (TabRow.kt:1002)");
    L5:
        long r6 = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getContainerColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final long getSecondaryContentColor(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1166419479, r5, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContentColor> (TabRow.kt:1018)");
    L5:
        long r6 = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Solely for use alongside deprecated TabRowDefaults.Indicator method. For recommended PrimaryIndicator and SecondaryIndicator methods, please use TabIndicatorScope.tabIndicatorOffset method.")
    public final Modifier tabIndicatorOffset(Modifier r3, final TabPosition r4) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1(r4);
    L7:
        return ComposedModifierKt.composed(r3, r0, new AnonymousClass2(r4));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    @Deprecated(message = "Use SecondaryIndicator instead.", replaceWith = @ReplaceWith(expression = "SecondaryIndicator(modifier, height, color)", imports = {}))
    /* JADX INFO: renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    public final void m3256Indicator9IZ8Weo(Modifier r21, float r22, long r23, Composer r25, final int r26, final int r27) {
        Composer r1 = r25.startRestartGroup(1454716052);
        int r2 = r27 & 1;
        if (r2 == 0) goto L6;
        int r4 = r26 | 6;
        Modifier r3 = r21;
    L13:
        int r5 = r27 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        float r7 = r22;
    L25:
        if ((r26 & 384) == 0) goto L27;
        long r8 = r23;
    L36:
        if ((r4 & 147) == 146) goto L38;
        boolean r10 = true;
    L40:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L65;
        r1.startDefaults();
        if ((r26 & 1) != 0) goto L44;
    L50:
        if (r2 == 0) goto L52;
        final Modifier r6 = Modifier.Companion;
    L53:
        if (r5 == 0) goto L55;
        final float r9 = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM();
    L57:
        if ((r27 & 4) == 0) goto L59;
        r4 = r4 & (-897);
        r8 = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(r1, 6), PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor());
    L59:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventStart(1454716052, r4, -1, "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:1038)");
    L62:
        BoxKt.Box(BackgroundKt.m342backgroundbw27NRU$default(SizeKt.m1000height3ABfNKs(SizeKt.fillMaxWidth$default(r6, MenuKt.ClosedAlphaTarget, 1, null), r9), r8, null, 2, null), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventEnd();
    L66:
        final long r11 = r8;
        ScopeUpdateScope r12 = r1.endRestartGroup();
        if (r12 == null) goto L70;
        r12.updateScope(new gs(this, r6, r9, r11, r26, r27));
        return;
    L70:
        return;
    L55:
        r9 = r7;
        goto L57
    L52:
        r6 = r3;
        goto L53
    L44:
        if (r1.getDefaultsInvalid() == true) goto L50;
        r1.skipToGroupEnd();
        if ((r27 & 4) == 0) goto L49;
        r4 = r4 & (-897);
    L49:
        r6 = r3;
        r9 = r7;
        goto L59
    L65:
        r1.skipToGroupEnd();
        r6 = r3;
        r9 = r7;
        goto L66
    L38:
        r10 = false;
        goto L40
    L27:
        if ((r27 & 4) != 0) goto L31;
        r8 = r23;
        if (r1.changed(r8) == false) goto L32;
        int r13 = 256;
    L33:
        r4 = r4 | r13;
    L32:
        r13 = 128;
        goto L33
    L31:
        r8 = r23;
        goto L32
    L17:
        if ((r26 & 48) != 0) goto L23;
        r7 = r22;
        if (r1.changed(r7) == false) goto L21;
        int r14 = 32;
    L22:
        r4 = r4 | r14;
        goto L25
    L21:
        r14 = 16;
        goto L22
    L6:
        if ((r26 & 6) != 0) goto L12;
        r3 = r21;
        if (r1.changed(r3) == false) goto L10;
        int r15 = 4;
    L11:
        r4 = r15 | r26;
        goto L13
    L10:
        r15 = 2;
        goto L11
    L12:
        r3 = r21;
        r4 = r26;
        goto L13
    }

    /* JADX INFO: renamed from: SecondaryIndicator-9IZ8Weo, reason: not valid java name */
    public final void m3258SecondaryIndicator9IZ8Weo(Modifier r21, float r22, long r23, Composer r25, final int r26, final int r27) {
        Composer r1 = r25.startRestartGroup(-1498258020);
        int r2 = r27 & 1;
        if (r2 == 0) goto L6;
        int r4 = r26 | 6;
        Modifier r3 = r21;
    L13:
        int r5 = r27 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        float r7 = r22;
    L25:
        if ((r26 & 384) == 0) goto L27;
        long r8 = r23;
    L36:
        if ((r4 & 147) == 146) goto L38;
        boolean r10 = true;
    L40:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L65;
        r1.startDefaults();
        if ((r26 & 1) != 0) goto L44;
    L50:
        if (r2 == 0) goto L52;
        final Modifier r6 = Modifier.Companion;
    L53:
        if (r5 == 0) goto L55;
        final float r9 = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM();
    L57:
        if ((r27 & 4) == 0) goto L59;
        r4 = r4 & (-897);
        r8 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), r1, 6);
    L59:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventStart(-1498258020, r4, -1, "androidx.compose.material3.TabRowDefaults.SecondaryIndicator (TabRow.kt:1081)");
    L62:
        BoxKt.Box(BackgroundKt.m342backgroundbw27NRU$default(SizeKt.m1000height3ABfNKs(SizeKt.fillMaxWidth$default(r6, MenuKt.ClosedAlphaTarget, 1, null), r9), r8, null, 2, null), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L66;
        ComposerKt.traceEventEnd();
    L66:
        final long r11 = r8;
        ScopeUpdateScope r12 = r1.endRestartGroup();
        if (r12 == null) goto L70;
        r12.updateScope(new is(this, r6, r9, r11, r26, r27));
        return;
    L70:
        return;
    L55:
        r9 = r7;
        goto L57
    L52:
        r6 = r3;
        goto L53
    L44:
        if (r1.getDefaultsInvalid() == true) goto L50;
        r1.skipToGroupEnd();
        if ((r27 & 4) == 0) goto L49;
        r4 = r4 & (-897);
    L49:
        r6 = r3;
        r9 = r7;
        goto L59
    L65:
        r1.skipToGroupEnd();
        r6 = r3;
        r9 = r7;
        goto L66
    L38:
        r10 = false;
        goto L40
    L27:
        if ((r27 & 4) != 0) goto L31;
        r8 = r23;
        if (r1.changed(r8) == false) goto L32;
        int r13 = 256;
    L33:
        r4 = r4 | r13;
    L32:
        r13 = 128;
        goto L33
    L31:
        r8 = r23;
        goto L32
    L17:
        if ((r26 & 48) != 0) goto L23;
        r7 = r22;
        if (r1.changed(r7) == false) goto L21;
        int r14 = 32;
    L22:
        r4 = r4 | r14;
        goto L25
    L21:
        r14 = 16;
        goto L22
    L6:
        if ((r26 & 6) != 0) goto L12;
        r3 = r21;
        if (r1.changed(r3) == false) goto L10;
        int r15 = 4;
    L11:
        r4 = r15 | r26;
        goto L13
    L10:
        r15 = 2;
        goto L11
    L12:
        r3 = r21;
        r4 = r26;
        goto L13
    }

    /* JADX INFO: renamed from: PrimaryIndicator-10LGxhE, reason: not valid java name */
    public final void m3257PrimaryIndicator10LGxhE(Modifier r17, float r18, float r19, long r20, Shape r22, Composer r23, final int r24, final int r25) {
        Composer r1 = r23.startRestartGroup(-1895596205);
        int r2 = r25 & 1;
        if (r2 == 0) goto L6;
        int r4 = r24 | 6;
        Modifier r3 = r17;
    L13:
        int r5 = r25 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        float r6 = r18;
    L24:
        int r7 = r25 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        float r9 = r19;
    L36:
        if ((r24 & 3072) == 0) goto L38;
        long r10 = r20;
    L46:
        int r12 = r25 & 16;
        if (r12 == 0) goto L50;
        r4 = r4 | 24576;
    L56:
        Shape r13 = r22;
    L58:
        if ((r4 & 9363) == 9362) goto L60;
        boolean r14 = true;
    L62:
        if (r1.shouldExecute(r14, r4 & 1) == false) goto L90;
        r1.startDefaults();
        if ((r24 & 1) != 0) goto L66;
    L72:
        if (r2 == 0) goto L74;
        final Modifier r8 = Modifier.Companion;
    L75:
        if (r5 == 0) goto L77;
        r6 = Dp.constructor-impl(24);
    L77:
        if (r7 == 0) goto L80;
        r9 = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorHeight-D9Ej5fM();
    L80:
        if ((r25 & 8) == 0) goto L82;
        r10 = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), r1, 6);
        r4 = r4 & (-7169);
    L82:
        if (r12 == 0) goto L84;
        r13 = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
    L84:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventStart(-1895596205, r4, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1059)");
    L87:
        SpacerKt.Spacer(BackgroundKt.m341backgroundbw27NRU(SizeKt.m1011requiredWidth3ABfNKs(SizeKt.m1003requiredHeight3ABfNKs(r8, r9), r6), r10, r13), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventEnd();
    L91:
        final float r11 = r6;
        final float r15 = r9;
        final long r16 = r10;
        final Shape r21 = r13;
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L95;
        r110.updateScope(new hs(this, r8, r11, r15, r16, r21, r24, r25));
        return;
    L95:
        return;
    L74:
        r8 = r3;
        goto L75
    L66:
        if (r1.getDefaultsInvalid() == true) goto L72;
        r1.skipToGroupEnd();
        if ((r25 & 8) == 0) goto L71;
        r4 = r4 & (-7169);
    L71:
        r8 = r3;
        goto L84
    L90:
        r1.skipToGroupEnd();
        r8 = r3;
        goto L91
    L60:
        r14 = false;
        goto L62
    L50:
        if ((r24 & 24576) != 0) goto L56;
        r13 = r22;
        if (r1.changed(r13) == false) goto L54;
        int r111 = 16384;
    L55:
        r4 = r4 | r111;
        goto L58
    L54:
        r111 = 8192;
        goto L55
    L38:
        if ((r25 & 8) != 0) goto L42;
        r10 = r20;
        if (r1.changed(r10) == false) goto L43;
        int r112 = 2048;
    L44:
        r4 = r4 | r112;
    L43:
        r112 = 1024;
        goto L44
    L42:
        r10 = r20;
        goto L43
    L28:
        if ((r24 & 384) != 0) goto L34;
        r9 = r19;
        if (r1.changed(r9) == false) goto L32;
        int r113 = 256;
    L33:
        r4 = r4 | r113;
        goto L36
    L32:
        r113 = 128;
        goto L33
    L17:
        if ((r24 & 48) != 0) goto L23;
        r6 = r18;
        if (r1.changed(r6) == false) goto L21;
        int r26 = 32;
    L22:
        r4 = r4 | r26;
        goto L24
    L21:
        r26 = 16;
        goto L22
    L6:
        if ((r24 & 6) != 0) goto L12;
        r3 = r17;
        if (r1.changed(r3) == false) goto L10;
        int r27 = 4;
    L11:
        r4 = r27 | r24;
        goto L13
    L10:
        r27 = 2;
        goto L11
    L12:
        r3 = r17;
        r4 = r24;
        goto L13
    }
}
