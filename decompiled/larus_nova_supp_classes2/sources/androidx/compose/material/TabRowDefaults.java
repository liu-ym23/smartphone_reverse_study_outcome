package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\rJ\u0012\u0010\u0011\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u0016\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001a\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001b\u0010\u0018R\u0013\u0010\u001c\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001d\u0010\u0018¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020\tX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020\tX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/TabRowDefaults;", "", "<init>", "()V", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "Indicator", "height", "Indicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material/TabPosition;", "DividerOpacity", "", "DividerThickness", "getDividerThickness-D9Ej5fM", "()F", "F", "IndicatorHeight", "getIndicatorHeight-D9Ej5fM", "ScrollableTabRowPadding", "getScrollableTabRowPadding-D9Ej5fM", "material", "currentTabWidth", "indicatorOffset"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final float DividerOpacity = 0.12f;
    private static final float DividerThickness = 0.0f;
    public static final TabRowDefaults INSTANCE = null;
    private static final float IndicatorHeight = 0.0f;
    private static final float ScrollableTabRowPadding = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material.TabRowDefaults$tabIndicatorOffset$2, reason: invalid class name */
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

        public final Modifier invoke(Modifier r15, Composer r16, int r17) {
            r16.startReplaceGroup(-398757863);
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(-398757863, r17, -1, "androidx.compose.material.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:391)");
        L5:
            State<Dp> r13 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(this.$currentTabPosition.m2199getWidthD9Ej5fM(), AnimationSpecKt.tween$default(androidx.compose.material3.ProgressIndicatorKt.FirstLineTailDelay, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, r16, 0, 12);
            final State<Dp> r1 = AnimateAsStateKt.m238animateDpAsStateAjpBEmI(this.$currentTabPosition.m2197getLeftD9Ej5fM(), AnimationSpecKt.tween$default(androidx.compose.material3.ProgressIndicatorKt.FirstLineTailDelay, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, r16, 0, 12);
            Modifier r2 = SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(r15, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), Alignment.Companion.getBottomStart(), false, 2, null);
            boolean r3 = r16.changed(r1);
            Object r4 = r16.rememberedValue();
            if (r3 == false) goto L8;
        L9:
            r4 = new jc(r1);
            r16.updateRememberedValue(r4);
        L10:
            Modifier r5 = SizeKt.m1019width3ABfNKs(OffsetKt.offset(r2, (Function1) r4), invoke$lambda$0(r13));
            if (ComposerKt.isTraceInProgress() == false) goto L13;
            ComposerKt.traceEventEnd();
        L13:
            r16.endReplaceGroup();
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

    private static final Unit Divider_9IZ8Weo$lambda$0(TabRowDefaults r9, Modifier r10, float r11, long r12, int r14, int r15, Composer r16, int r17) {
        r9.m2200Divider9IZ8Weo(r10, r11, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit Indicator_9IZ8Weo$lambda$1(TabRowDefaults r9, Modifier r10, float r11, long r12, int r14, int r15, Composer r16, int r17) {
        r9.m2201Indicator9IZ8Weo(r10, r11, r12, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(TabRowDefaults r0, Modifier r1, float r2, long r3, int r5, int r6, Composer r7, int r8) {
        return Indicator_9IZ8Weo$lambda$1(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit b(TabRowDefaults r0, Modifier r1, float r2, long r3, int r5, int r6, Composer r7, int r8) {
        return Divider_9IZ8Weo$lambda$0(r0, r1, r2, r3, r5, r6, r7, r8);
    }

    static {
        INSTANCE = new TabRowDefaults();
        DividerThickness = Dp.constructor-impl(1);
        IndicatorHeight = Dp.constructor-impl(2);
        ScrollableTabRowPadding = Dp.constructor-impl(52);
    }

    /* JADX INFO: renamed from: getDividerThickness-D9Ej5fM, reason: not valid java name */
    public final float m2202getDividerThicknessD9Ej5fM() {
        return DividerThickness;
    }

    /* JADX INFO: renamed from: getIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m2203getIndicatorHeightD9Ej5fM() {
        return IndicatorHeight;
    }

    /* JADX INFO: renamed from: getScrollableTabRowPadding-D9Ej5fM, reason: not valid java name */
    public final float m2204getScrollableTabRowPaddingD9Ej5fM() {
        return ScrollableTabRowPadding;
    }

    public final Modifier tabIndicatorOffset(Modifier r3, final TabPosition r4) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r0 = new TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1(r4);
    L7:
        return ComposedModifierKt.composed(r3, r0, new AnonymousClass2(r4));
    L5:
        r0 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    /* JADX INFO: renamed from: Divider-9IZ8Weo, reason: not valid java name */
    public final void m2200Divider9IZ8Weo(Modifier r19, float r20, long r21, Composer r23, final int r24, final int r25) {
        Composer r1 = r23.startRestartGroup(910934799);
        int r2 = r25 & 1;
        if (r2 == 0) goto L6;
        int r4 = r24 | 6;
        Modifier r3 = r19;
    L14:
        if ((r24 & 48) == 0) goto L16;
        float r5 = r20;
    L25:
        if ((r24 & 384) == 0) goto L27;
        long r7 = r21;
    L36:
        if ((r25 & 8) == 0) goto L39;
        r4 = r4 | 3072;
    L46:
        if ((r4 & 1171) == 1170) goto L48;
        boolean r9 = true;
    L50:
        if (r1.shouldExecute(r9, r4 & 1) == false) goto L79;
        r1.startDefaults();
        if ((r24 & 1) != 0) goto L54;
    L63:
        if (r2 == 0) goto L65;
        final Modifier r6 = Modifier.Companion;
    L67:
        if ((r25 & 2) == 0) goto L69;
        final float r8 = DividerThickness;
        r4 = r4 & (-113);
    L71:
        if ((r25 & 4) == 0) goto L73;
        r7 = Color.copy-wmQWz5c$default(((Color) r1.consume(ContentColorKt.getLocalContentColor())).unbox-impl(), 0.12f, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 14, null);
        r4 = r4 & (-897);
    L73:
        long r16 = r7;
        int r10 = r4;
        final long r11 = r16;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventStart(910934799, r10, -1, "androidx.compose.material.TabRowDefaults.Divider (TabRow.kt:355)");
    L76:
        int r13 = ((r10 & 14) | ((r10 >> 3) & 112)) | ((r10 << 3) & 896);
        DividerKt.m2032DivideroMI9zvI(r6, r11, r8, androidx.compose.material3.MenuKt.ClosedAlphaTarget, r1, r13, 8);
        if (ComposerKt.isTraceInProgress() == false) goto L80;
        ComposerKt.traceEventEnd();
    L80:
        ScopeUpdateScope r12 = r1.endRestartGroup();
        if (r12 == null) goto L84;
        r12.updateScope(new ic(this, r6, r8, r11, r24, r25));
        return;
    L84:
        return;
    L69:
        r8 = r5;
        goto L71
    L65:
        r6 = r3;
        goto L67
    L54:
        if (r1.getDefaultsInvalid() == true) goto L63;
        r1.skipToGroupEnd();
        if ((r25 & 2) == 0) goto L60;
        r4 = r4 & (-113);
    L60:
        if ((r25 & 4) == 0) goto L62;
        r4 = r4 & (-897);
    L62:
        r6 = r3;
        r8 = r5;
        goto L73
    L79:
        r1.skipToGroupEnd();
        r6 = r3;
        r8 = r5;
        r11 = r7;
        goto L80
    L48:
        r9 = false;
        goto L50
    L39:
        if ((r24 & 3072) != 0) goto L46;
        if (r1.changed(this) == false) goto L43;
        int r14 = 2048;
    L44:
        r4 = r4 | r14;
        goto L46
    L43:
        r14 = 1024;
        goto L44
    L27:
        if ((r25 & 4) != 0) goto L31;
        r7 = r21;
        if (r1.changed(r7) == false) goto L32;
        int r15 = 256;
    L33:
        r4 = r4 | r15;
    L32:
        r15 = 128;
        goto L33
    L31:
        r7 = r21;
        goto L32
    L16:
        if ((r25 & 2) != 0) goto L20;
        r5 = r20;
        if (r1.changed(r5) == false) goto L21;
        int r17 = 32;
    L22:
        r4 = r4 | r17;
    L21:
        r17 = 16;
        goto L22
    L20:
        r5 = r20;
        goto L21
    L6:
        if ((r24 & 6) != 0) goto L12;
        r3 = r19;
        if (r1.changed(r3) == false) goto L10;
        int r18 = 4;
    L11:
        r4 = r18 | r24;
        goto L14
    L10:
        r18 = 2;
        goto L11
    L12:
        r3 = r19;
        r4 = r24;
        goto L14
    }

    /* JADX INFO: renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    public final void m2201Indicator9IZ8Weo(Modifier r21, float r22, long r23, Composer r25, final int r26, final int r27) {
        Composer r1 = r25.startRestartGroup(1499002201);
        int r2 = r27 & 1;
        if (r2 == 0) goto L6;
        int r4 = r26 | 6;
        Modifier r3 = r21;
    L14:
        if ((r26 & 48) == 0) goto L16;
        float r5 = r22;
    L25:
        if ((r26 & 384) == 0) goto L27;
        long r7 = r23;
    L36:
        if ((r27 & 8) == 0) goto L39;
        r4 = r4 | 3072;
    L47:
        if ((r4 & 1171) == 1170) goto L49;
        boolean r10 = true;
    L51:
        if (r1.shouldExecute(r10, r4 & 1) == false) goto L80;
        r1.startDefaults();
        if ((r26 & 1) != 0) goto L55;
    L64:
        if (r2 == 0) goto L66;
        final Modifier r6 = Modifier.Companion;
    L68:
        if ((r27 & 2) == 0) goto L70;
        final float r8 = IndicatorHeight;
        r4 = r4 & (-113);
    L72:
        if ((r27 & 4) == 0) goto L74;
        r7 = ((Color) r1.consume(ContentColorKt.getLocalContentColor())).unbox-impl();
        r4 = r4 & (-897);
    L74:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L77;
        ComposerKt.traceEventStart(1499002201, r4, -1, "androidx.compose.material.TabRowDefaults.Indicator (TabRow.kt:372)");
    L77:
        BoxKt.Box(BackgroundKt.m342backgroundbw27NRU$default(SizeKt.m1000height3ABfNKs(SizeKt.fillMaxWidth$default(r6, androidx.compose.material3.MenuKt.ClosedAlphaTarget, 1, null), r8), r7, null, 2, null), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L81;
        ComposerKt.traceEventEnd();
    L81:
        final long r9 = r7;
        ScopeUpdateScope r11 = r1.endRestartGroup();
        if (r11 == null) goto L85;
        r11.updateScope(new hc(this, r6, r8, r9, r26, r27));
        return;
    L85:
        return;
    L70:
        r8 = r5;
        goto L72
    L66:
        r6 = r3;
        goto L68
    L55:
        if (r1.getDefaultsInvalid() == true) goto L64;
        r1.skipToGroupEnd();
        if ((r27 & 2) == 0) goto L61;
        r4 = r4 & (-113);
    L61:
        if ((r27 & 4) == 0) goto L63;
        r4 = r4 & (-897);
    L63:
        r6 = r3;
        r8 = r5;
        goto L74
    L80:
        r1.skipToGroupEnd();
        r6 = r3;
        r8 = r5;
        goto L81
    L49:
        r10 = false;
        goto L51
    L39:
        if ((r26 & 3072) != 0) goto L47;
        if (r1.changed(this) == false) goto L43;
        int r12 = 2048;
    L44:
        r4 = r4 | r12;
        goto L47
    L43:
        r12 = 1024;
        goto L44
    L27:
        if ((r27 & 4) != 0) goto L31;
        r7 = r23;
        if (r1.changed(r7) == false) goto L32;
        int r13 = 256;
    L33:
        r4 = r4 | r13;
    L32:
        r13 = 128;
        goto L33
    L31:
        r7 = r23;
        goto L32
    L16:
        if ((r27 & 2) != 0) goto L20;
        r5 = r22;
        if (r1.changed(r5) == false) goto L21;
        int r14 = 32;
    L22:
        r4 = r4 | r14;
    L21:
        r14 = 16;
        goto L22
    L20:
        r5 = r22;
        goto L21
    L6:
        if ((r26 & 6) != 0) goto L12;
        r3 = r21;
        if (r1.changed(r3) == false) goto L10;
        int r15 = 4;
    L11:
        r4 = r15 | r26;
        goto L14
    L10:
        r15 = 2;
        goto L11
    L12:
        r3 = r21;
        r4 = r26;
        goto L14
    }
}
