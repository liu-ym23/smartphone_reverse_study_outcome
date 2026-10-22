package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0081\u0001\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00110\u00052\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u00152\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0017\u001a\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003H\u0002\"\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"rememberDismissState", "Landroidx/compose/material/DismissState;", "initialValue", "Landroidx/compose/material/DismissValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DismissState;", "SwipeToDismiss", "", "state", "modifier", "Landroidx/compose/ui/Modifier;", "directions", "", "Landroidx/compose/material/DismissDirection;", "dismissThresholds", "Landroidx/compose/material/ThresholdConfig;", "background", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dismissContent", "(Landroidx/compose/material/DismissState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "getDismissDirection", "from", "to", "DISMISS_THRESHOLD", "Landroidx/compose/ui/unit/Dp;", "F", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SwipeToDismissKt {
    private static final float DISMISS_THRESHOLD = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material.SwipeToDismissKt$SwipeToDismiss$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass2 implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
        final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $background;
        final /* synthetic */ Set<DismissDirection> $directions;
        final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $dismissContent;
        final /* synthetic */ Function1<DismissDirection, ThresholdConfig> $dismissThresholds;
        final /* synthetic */ DismissState $state;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Set<? extends DismissDirection> r1, Function1<? super DismissDirection, ? extends ThresholdConfig> r2, DismissState r3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r4, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r5) {
            this.$directions = r1;
            this.$dismissThresholds = r2;
            this.$state = r3;
            this.$background = r4;
            this.$dismissContent = r5;
        }

        public static /* synthetic */ ThresholdConfig a(Function1 r0, DismissValue r1, DismissValue r2) {
            return invoke$lambda$1$lambda$0(r0, r1, r2);
        }

        public static /* synthetic */ IntOffset b(DismissState r0, Density r1) {
            return invoke$lambda$4$lambda$3$lambda$2(r0, r1);
        }

        private static final IntOffset invoke$lambda$4$lambda$3$lambda$2(DismissState r4, Density r5) {
            return IntOffset.box-impl(IntOffset.constructor-impl((((long) MathKt.roundToInt(((Number) r4.getOffset().getValue()).floatValue())) << 32) | (((long) 0) & 4294967295L)));
        }

        private static final ThresholdConfig invoke$lambda$1$lambda$0(Function1 r0, DismissValue r1, DismissValue r2) {
            DismissDirection r3 = SwipeToDismissKt.access$getDismissDirection(r1, r2);
            Intrinsics.checkNotNull(r3);
            return (ThresholdConfig) r0.invoke(r3);
        }

        public final void invoke(BoxWithConstraintsScope r21, Composer r22, int r23) {
            if ((r23 & 6) == 0) goto L5;
            int r3 = r23;
        L11:
            if ((r3 & 19) == 18) goto L13;
            boolean r4 = true;
        L15:
            if (r22.shouldExecute(r4, r3 & 1) == true) goto L17;
            r22.skipToGroupEnd();
            return;
        L17:
            if (ComposerKt.isTraceInProgress() == false) goto L19;
            ComposerKt.traceEventStart(-1281726977, r3, -1, "androidx.compose.material.SwipeToDismiss.<anonymous> (SwipeToDismiss.kt:167)");
        L19:
            float r2 = Constraints.getMaxWidth-impl(r21.mo838getConstraintsmsEJaDk());
            if (r22.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) goto L22;
            boolean r13 = true;
        L23:
            Float r5 = Float.valueOf(androidx.compose.material3.MenuKt.ClosedAlphaTarget);
            DismissValue r6 = DismissValue.Default;
            Map r10 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r5, r6)});
            Set<DismissDirection> r7 = this.$directions;
            DismissDirection r8 = DismissDirection.StartToEnd;
            if (r7.contains(r8) == false) goto L26;
            Pair r9 = TuplesKt.to(Float.valueOf(r2), DismissValue.DismissedToEnd);
            r10.put(r9.getFirst(), r9.getSecond());
        L26:
            Set<DismissDirection> r11 = this.$directions;
            DismissDirection r12 = DismissDirection.EndToStart;
            if (r11.contains(r12) == false) goto L29;
            Pair r14 = TuplesKt.to(Float.valueOf(-r2), DismissValue.DismissedToStart);
            r10.put(r14.getFirst(), r14.getSecond());
        L29:
            boolean r15 = r22.changed(this.$dismissThresholds);
            final Function1<DismissDirection, ThresholdConfig> r16 = this.$dismissThresholds;
            Object r17 = r22.rememberedValue();
            if (r15 == false) goto L32;
        L33:
            r17 = new db(r16);
            r22.updateRememberedValue(r17);
        L34:
            Function2 r18 = (Function2) r17;
            boolean r19 = this.$directions.contains(r12);
            float r20 = 10.0f;
            if (r19 == false) goto L37;
            float r24 = 10.0f;
        L39:
            if (this.$directions.contains(r8) == true) goto L42;
            r20 = 20.0f;
        L42:
            Modifier r25 = Modifier.Companion;
            Orientation r110 = Orientation.Horizontal;
            if (this.$state.getCurrentValue() != r6) goto L45;
            boolean r111 = true;
        L46:
            Modifier r26 = SwipeableKt.m2185swipeablepPrIpRY$default(r25, this.$state, r10, r110, r111, r13, null, r18, new ResistanceConfig(r2, r24, r20), androidx.compose.material3.MenuKt.ClosedAlphaTarget, 288, null);
            Function3<RowScope, Composer, Integer, Unit> r27 = this.$background;
            final DismissState r28 = this.$state;
            Function3<RowScope, Composer, Integer, Unit> r29 = this.$dismissContent;
            Alignment.Companion r30 = Alignment.Companion;
            MeasurePolicy r31 = BoxKt.maybeCachedBoxMeasurePolicy(r30.getTopStart(), false);
            int r112 = ComposablesKt.getCurrentCompositeKeyHash(r22, 0);
            CompositionLocalMap r113 = r22.getCurrentCompositionLocalMap();
            Modifier r32 = ComposedModifierKt.materializeModifier(r22, r26);
            ComposeUiNode.Companion r114 = ComposeUiNode.Companion;
            Function0 r115 = r114.getConstructor();
            if ((r22.getApplier() instanceof Applier) == true) goto L49;
            ComposablesKt.invalidApplier();
        L49:
            r22.startReusableNode();
            if (r22.getInserting() == false) goto L52;
            r22.createNode(r115);
        L53:
            Composer r116 = Updater.constructor-impl(r22);
            Updater.set-impl(r116, r31, r114.getSetMeasurePolicy());
            Updater.set-impl(r116, r113, r114.getSetResolvedCompositionLocals());
            Function2 r33 = r114.getSetCompositeKeyHash();
            if (r116.getInserting() == false) goto L56;
        L57:
            r116.updateRememberedValue(Integer.valueOf(r112));
            r116.apply(Integer.valueOf(r112), r33);
        L58:
            Updater.set-impl(r116, r32, r114.getSetModifier());
            Modifier r34 = BoxScopeInstance.INSTANCE.matchParentSize(r25);
            Arrangement r35 = Arrangement.INSTANCE;
            MeasurePolicy r117 = RowKt.rowMeasurePolicy(r35.getStart(), r30.getTop(), r22, 0);
            int r118 = ComposablesKt.getCurrentCompositeKeyHash(r22, 0);
            CompositionLocalMap r119 = r22.getCurrentCompositionLocalMap();
            Modifier r36 = ComposedModifierKt.materializeModifier(r22, r34);
            Function0 r120 = r114.getConstructor();
            if ((r22.getApplier() instanceof Applier) == true) goto L61;
            ComposablesKt.invalidApplier();
        L61:
            r22.startReusableNode();
            if (r22.getInserting() == false) goto L64;
            r22.createNode(r120);
        L65:
            Composer r121 = Updater.constructor-impl(r22);
            Updater.set-impl(r121, r117, r114.getSetMeasurePolicy());
            Updater.set-impl(r121, r119, r114.getSetResolvedCompositionLocals());
            Function2 r122 = r114.getSetCompositeKeyHash();
            if (r121.getInserting() == false) goto L68;
        L69:
            r121.updateRememberedValue(Integer.valueOf(r118));
            r121.apply(Integer.valueOf(r118), r122);
        L70:
            Updater.set-impl(r121, r36, r114.getSetModifier());
            RowScopeInstance r37 = RowScopeInstance.INSTANCE;
            r27.invoke(r37, r22, 6);
            r22.endNode();
            boolean r38 = r22.changed(r28);
            Object r123 = r22.rememberedValue();
            if (r38 == false) goto L73;
        L74:
            r123 = new eb(r28);
            r22.updateRememberedValue(r123);
        L75:
            Modifier r39 = OffsetKt.offset(r25, (Function1) r123);
            MeasurePolicy r40 = RowKt.rowMeasurePolicy(r35.getStart(), r30.getTop(), r22, 0);
            int r41 = ComposablesKt.getCurrentCompositeKeyHash(r22, 0);
            CompositionLocalMap r42 = r22.getCurrentCompositionLocalMap();
            Modifier r43 = ComposedModifierKt.materializeModifier(r22, r39);
            Function0 r44 = r114.getConstructor();
            if ((r22.getApplier() instanceof Applier) == true) goto L78;
            ComposablesKt.invalidApplier();
        L78:
            r22.startReusableNode();
            if (r22.getInserting() == false) goto L81;
            r22.createNode(r44);
        L82:
            Composer r45 = Updater.constructor-impl(r22);
            Updater.set-impl(r45, r40, r114.getSetMeasurePolicy());
            Updater.set-impl(r45, r42, r114.getSetResolvedCompositionLocals());
            Function2 r46 = r114.getSetCompositeKeyHash();
            if (r45.getInserting() == false) goto L85;
        L86:
            r45.updateRememberedValue(Integer.valueOf(r41));
            r45.apply(Integer.valueOf(r41), r46);
        L87:
            Updater.set-impl(r45, r43, r114.getSetModifier());
            r29.invoke(r37, r22, 6);
            r22.endNode();
            r22.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L92;
            ComposerKt.traceEventEnd();
            return;
        L92:
            return;
        L85:
            if (Intrinsics.areEqual(r45.rememberedValue(), Integer.valueOf(r41)) == true) goto L87;
        L81:
            r22.useNode();
            goto L82
        L73:
            if (r123 != Composer.Companion.getEmpty()) goto L75;
        L68:
            if (Intrinsics.areEqual(r121.rememberedValue(), Integer.valueOf(r118)) == true) goto L70;
        L64:
            r22.useNode();
            goto L65
        L56:
            if (Intrinsics.areEqual(r116.rememberedValue(), Integer.valueOf(r112)) == true) goto L58;
        L52:
            r22.useNode();
            goto L53
        L45:
            r111 = false;
            goto L46
        L37:
            r24 = 20.0f;
            goto L39
        L32:
            if (r17 != Composer.Companion.getEmpty()) goto L34;
        L22:
            r13 = false;
            goto L23
        L13:
            r4 = false;
            goto L15
        L5:
            if (r22.changed(r21) == false) goto L7;
            int r47 = 4;
        L8:
            r3 = r23 | r47;
            goto L11
        L7:
            r47 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            invoke((BoxWithConstraintsScope) r1, (Composer) r2, ((Number) r3).intValue());
            return Unit.INSTANCE;
        }
    }

    private static final Unit SwipeToDismiss$lambda$6(DismissState r10, Modifier r11, Set r12, Function1 r13, Function3 r14, Function3 r15, int r16, int r17, Composer r18, int r19) {
        SwipeToDismiss(r10, r11, r12, r13, r14, r15, r18, RecomposeScopeImplKt.updateChangedFlags(r16 | 1), r17);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ boolean a(DismissValue r0) {
        return rememberDismissState$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ FixedThreshold b(DismissDirection r0) {
        return SwipeToDismiss$lambda$5$lambda$4(r0);
    }

    public static /* synthetic */ Unit c(DismissState r0, Modifier r1, Set r2, Function1 r3, Function3 r4, Function3 r5, int r6, int r7, Composer r8, int r9) {
        return SwipeToDismiss$lambda$6(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ DismissState d(DismissValue r0, Function1 r1) {
        return rememberDismissState$lambda$3$lambda$2(r0, r1);
    }

    private static final boolean rememberDismissState$lambda$1$lambda$0(DismissValue r0) {
        return true;
    }

    static {
        DISMISS_THRESHOLD = Dp.constructor-impl(56);
    }

    private static final FixedThreshold SwipeToDismiss$lambda$5$lambda$4(DismissDirection r2) {
        return new FixedThreshold(DISMISS_THRESHOLD, null);
    }

    public static final /* synthetic */ DismissDirection access$getDismissDirection(DismissValue r0, DismissValue r1) {
        return getDismissDirection(r0, r1);
    }

    private static final DismissDirection getDismissDirection(DismissValue r3, DismissValue r4) {
        if (r3 == r4) goto L5;
    L7:
        if (r3 == r4) goto L9;
    L11:
        if (r3 == r4) goto L13;
    L15:
        DismissValue r1 = DismissValue.Default;
        if (r3 == r1) goto L18;
    L20:
        if (r3 != r1) goto L25;
        if (r4 != DismissValue.DismissedToStart) goto L25;
        return DismissDirection.EndToStart;
    L25:
        if (r3 != DismissValue.DismissedToEnd) goto L29;
        if (r4 != r1) goto L29;
        return DismissDirection.StartToEnd;
    L29:
        if (r3 != DismissValue.DismissedToStart) goto L38;
        if (r4 == r1) goto L32;
        return null;
    L32:
        return DismissDirection.EndToStart;
    L38:
        return null;
    L18:
        if (r4 != DismissValue.DismissedToEnd) goto L20;
        return DismissDirection.StartToEnd;
    L13:
        if (r3 != DismissValue.DismissedToStart) goto L15;
        return DismissDirection.EndToStart;
    L9:
        if (r3 != DismissValue.DismissedToEnd) goto L11;
        return DismissDirection.StartToEnd;
    L5:
        if (r3 != DismissValue.Default) goto L7;
        return null;
    }

    private static final DismissState rememberDismissState$lambda$3$lambda$2(DismissValue r1, Function1 r2) {
        return new DismissState(r1, r2);
    }

    public static final DismissState rememberDismissState(final DismissValue r6, final Function1<? super DismissValue, Boolean> r7, Composer r8, int r9, int r10) {
        if ((r10 & 1) == 0) goto L6;
        r6 = DismissValue.Default;
    L6:
        if ((r10 & 2) == 0) goto L12;
        Object r11 = r8.rememberedValue();
        if (r11 != Composer.Companion.getEmpty()) goto L10;
        r11 = new bb();
        r8.updateRememberedValue(r11);
    L10:
        r7 = (Function1) r11;
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(-1753522702, r9, -1, "androidx.compose.material.rememberDismissState (SwipeToDismiss.kt:135)");
    L14:
        Object[] r0 = new Object[0];
        Saver<DismissState, DismissValue> r1 = DismissState.Companion.Saver(r7);
        boolean r4 = true;
        if (((r9 & 14) ^ 6) <= 4) goto L19;
        if (r8.changed(r6.ordinal()) == false) goto L19;
    L20:
        boolean r2 = true;
    L23:
        if (((r9 & 112) ^ 48) <= 32) goto L27;
        if (r8.changed(r7) == false) goto L27;
    L30:
        boolean r12 = r2 | r4;
        Object r3 = r8.rememberedValue();
        if (r12 == false) goto L33;
    L34:
        r3 = new cb(r6, r7);
        r8.updateRememberedValue(r3);
    L35:
        DismissState r13 = (DismissState) RememberSaveableKt.rememberSaveable(r0, r1, (Function0) r3, r8, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        return r13;
    L33:
        if (r3 != Composer.Companion.getEmpty()) goto L35;
    L27:
        if ((r9 & 48) == 32) goto L30;
        r4 = false;
    L19:
        if ((r9 & 6) == 4) goto L20;
        r2 = false;
        goto L23
    }

    public static final void SwipeToDismiss(final DismissState r18, Modifier r19, Set<? extends DismissDirection> r20, Function1<? super DismissDirection, ? extends ThresholdConfig> r21, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r22, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r23, Composer r24, final int r25, final int r26) {
        Composer r1 = r24.startRestartGroup(-9746411);
        if ((r26 & 1) == 0) goto L6;
        int r4 = r25 | 6;
    L13:
        int r5 = r26 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L23:
        Modifier r6 = r19;
    L24:
        int r8 = r26 & 4;
        if (r8 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        Set<? extends DismissDirection> r9 = r20;
    L35:
        int r10 = r26 & 8;
        if (r10 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        Function1<? super DismissDirection, ? extends ThresholdConfig> r11 = r21;
    L47:
        if ((r26 & 16) == 0) goto L50;
        r4 = r4 | 24576;
    L57:
        if ((r26 & 32) == 0) goto L60;
        r4 = r4 | 196608;
    L67:
        if ((74899 & r4) == 74898) goto L69;
        boolean r12 = true;
    L71:
        if (r1.shouldExecute(r12, r4 & 1) == false) goto L91;
        if (r5 == 0) goto L74;
        Modifier r7 = Modifier.Companion;
    L75:
        if (r8 == 0) goto L77;
        final Set<? extends DismissDirection> r3 = SetsKt.setOf(new DismissDirection[]{DismissDirection.EndToStart, DismissDirection.StartToEnd});
    L78:
        if (r10 == 0) goto L83;
        Object r13 = r1.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L82;
        r13 = new za();
        r1.updateRememberedValue(r13);
    L82:
        Function1<? super DismissDirection, ? extends ThresholdConfig> r14 = (Function1) r13;
    L85:
        if (ComposerKt.isTraceInProgress() == false) goto L87;
        ComposerKt.traceEventStart(-9746411, r4, -1, "androidx.compose.material.SwipeToDismiss (SwipeToDismiss.kt:166)");
    L87:
        BoxWithConstraintsKt.BoxWithConstraints(r7, null, false, ComposableLambdaKt.rememberComposableLambda(-1281726977, true, new AnonymousClass2(r3, r14, r18, r22, r23), r1, 54), r1, ((r4 >> 3) & 14) | 3072, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L90;
        ComposerKt.traceEventEnd();
    L90:
        final Modifier r2 = r7;
        final Function1<? super DismissDirection, ? extends ThresholdConfig> r15 = r14;
    L92:
        ScopeUpdateScope r16 = r1.endRestartGroup();
        if (r16 == null) goto L96;
        r16.updateScope(new ab(r18, r2, r3, r15, r22, r23, r25, r26));
        return;
    L96:
        return;
    L83:
        r14 = r11;
        goto L85
    L77:
        r3 = r9;
        goto L78
    L74:
        r7 = r6;
        goto L75
    L91:
        r1.skipToGroupEnd();
        r2 = r6;
        r3 = r9;
        r15 = r11;
        goto L92
    L69:
        r12 = false;
        goto L71
    L60:
        if ((r25 & 196608) != 0) goto L67;
        if (r1.changedInstance(r23) == false) goto L64;
        int r17 = 131072;
    L65:
        r4 = r4 | r17;
        goto L67
    L64:
        r17 = 65536;
        goto L65
    L50:
        if ((r25 & 24576) != 0) goto L57;
        if (r1.changedInstance(r22) == false) goto L54;
        int r110 = 16384;
    L55:
        r4 = r4 | r110;
        goto L57
    L54:
        r110 = 8192;
        goto L55
    L39:
        if ((r25 & 3072) != 0) goto L45;
        r11 = r21;
        if (r1.changedInstance(r11) == false) goto L43;
        int r111 = 2048;
    L44:
        r4 = r4 | r111;
        goto L47
    L43:
        r111 = 1024;
        goto L44
    L28:
        if ((r25 & 384) != 0) goto L34;
        r9 = r20;
        if (r1.changedInstance(r9) == false) goto L32;
        int r112 = 256;
    L33:
        r4 = r4 | r112;
        goto L35
    L32:
        r112 = 128;
        goto L33
    L17:
        if ((r25 & 48) != 0) goto L23;
        r6 = r19;
        if (r1.changed(r6) == false) goto L21;
        int r27 = 32;
    L22:
        r4 = r4 | r27;
        goto L24
    L21:
        r27 = 16;
        goto L22
    L6:
        if ((r25 & 6) == 0) goto L8;
        r4 = r25;
        goto L13
    L8:
        if (r1.changed(r18) == false) goto L10;
        int r28 = 4;
    L11:
        r4 = r28 | r25;
        goto L13
    L10:
        r28 = 2;
        goto L11
    }
}
